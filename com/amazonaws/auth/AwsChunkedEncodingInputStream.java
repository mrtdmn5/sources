package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkInputStream;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class AwsChunkedEncodingInputStream extends SdkInputStream {
    private static final int BIT_MASK = 255;
    private static final String CHUNK_SIGNATURE_HEADER = ";chunk-signature=";
    private static final String CHUNK_STRING_TO_SIGN_PREFIX = "AWS4-HMAC-SHA256-PAYLOAD";
    private static final String CLRF = "\r\n";
    private static final int DEFAULT_BUFFER_SIZE = 262144;
    private static final int DEFAULT_CHUNK_SIZE = 131072;
    protected static final String DEFAULT_ENCODING = "UTF-8";
    private static final int SIGNATURE_LENGTH = 64;
    private final AWS4Signer aws4Signer;
    private ChunkContentIterator currentChunkIterator;
    private final String dateTime;
    private DecodedStreamBuffer decodedStreamBuffer;
    private final String headerSignature;
    private InputStream is;
    private boolean isAtStart;
    private boolean isTerminating;
    private final byte[] kSigning;
    private final String keyPath;
    private final int maxBufferSize;
    private String priorChunkSignature;
    private static final byte[] FINAL_CHUNK = new byte[0];
    private static final Log log = LogFactory.getLog((Class<?>) AwsChunkedEncodingInputStream.class);

    public AwsChunkedEncodingInputStream(InputStream inputStream, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this(inputStream, DEFAULT_BUFFER_SIZE, bArr, str, str2, str3, aWS4Signer);
    }

    private static long calculateSignedChunkLength(long j) {
        return Long.toHexString(j).length() + 17 + 64 + 2 + j + 2;
    }

    public static long calculateStreamContentLength(long j) {
        long j2;
        if (j >= 0) {
            long j3 = j / 131072;
            long j4 = j % 131072;
            long calculateSignedChunkLength = j3 * calculateSignedChunkLength(131072L);
            if (j4 > 0) {
                j2 = calculateSignedChunkLength(j4);
            } else {
                j2 = 0;
            }
            return calculateSignedChunkLength + j2 + calculateSignedChunkLength(0L);
        }
        throw new IllegalArgumentException("Nonnegative content length expected.");
    }

    private byte[] createSignedChunk(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(bArr.length));
        String hex = BinaryUtils.toHex(this.aws4Signer.sign("AWS4-HMAC-SHA256-PAYLOAD\n" + this.dateTime + "\n" + this.keyPath + "\n" + this.priorChunkSignature + "\n" + BinaryUtils.toHex(this.aws4Signer.hash("")) + "\n" + BinaryUtils.toHex(this.aws4Signer.hash(bArr)), this.kSigning, SigningAlgorithm.HmacSHA256));
        this.priorChunkSignature = hex;
        StringBuilder sb2 = new StringBuilder(CHUNK_SIGNATURE_HEADER);
        sb2.append(hex);
        sb.append(sb2.toString());
        sb.append(CLRF);
        try {
            String sb3 = sb.toString();
            Charset charset = StringUtils.UTF8;
            byte[] bytes = sb3.getBytes(charset);
            byte[] bytes2 = CLRF.getBytes(charset);
            byte[] bArr2 = new byte[bytes.length + bArr.length + bytes2.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            System.arraycopy(bytes2, 0, bArr2, bytes.length + bArr.length, bytes2.length);
            return bArr2;
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Unable to sign the chunked data. ")), e);
        }
    }

    private boolean setUpNextChunk() throws IOException {
        byte[] bArr = new byte[DEFAULT_CHUNK_SIZE];
        int r3 = 0;
        while (r3 < DEFAULT_CHUNK_SIZE) {
            DecodedStreamBuffer decodedStreamBuffer = this.decodedStreamBuffer;
            if (decodedStreamBuffer != null && decodedStreamBuffer.hasNext()) {
                bArr[r3] = this.decodedStreamBuffer.next();
                r3++;
            } else {
                int read = this.is.read(bArr, r3, DEFAULT_CHUNK_SIZE - r3);
                if (read == -1) {
                    break;
                }
                DecodedStreamBuffer decodedStreamBuffer2 = this.decodedStreamBuffer;
                if (decodedStreamBuffer2 != null) {
                    decodedStreamBuffer2.buffer(bArr, r3, read);
                }
                r3 += read;
            }
        }
        if (r3 == 0) {
            this.currentChunkIterator = new ChunkContentIterator(createSignedChunk(FINAL_CHUNK));
            return true;
        }
        if (r3 < DEFAULT_CHUNK_SIZE) {
            byte[] bArr2 = new byte[r3];
            System.arraycopy(bArr, 0, bArr2, 0, r3);
            bArr = bArr2;
        }
        this.currentChunkIterator = new ChunkContentIterator(createSignedChunk(bArr));
        return false;
    }

    @Override // com.amazonaws.internal.SdkInputStream
    public InputStream getWrappedInputStream() {
        return this.is;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        abortIfNeeded();
        if (this.isAtStart) {
            if (this.is.markSupported()) {
                Log log2 = log;
                if (log2.isDebugEnabled()) {
                    log2.debug("AwsChunkedEncodingInputStream marked at the start of the stream (will directly mark the wrapped stream since it's mark-supported).");
                }
                this.is.mark(Integer.MAX_VALUE);
            } else {
                Log log3 = log;
                if (log3.isDebugEnabled()) {
                    log3.debug("AwsChunkedEncodingInputStream marked at the start of the stream (initializing the buffer since the wrapped stream is not mark-supported).");
                }
                this.decodedStreamBuffer = new DecodedStreamBuffer(this.maxBufferSize);
            }
        } else {
            throw new UnsupportedOperationException("Chunk-encoded stream only supports mark() at the start of the stream.");
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        if (read == -1) {
            return read;
        }
        Log log2 = log;
        if (log2.isDebugEnabled()) {
            log2.debug("One byte read from the stream.");
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        abortIfNeeded();
        this.currentChunkIterator = null;
        this.priorChunkSignature = this.headerSignature;
        if (this.is.markSupported()) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("AwsChunkedEncodingInputStream reset (will reset the wrapped stream because it is mark-supported).");
            }
            this.is.reset();
        } else {
            Log log3 = log;
            if (log3.isDebugEnabled()) {
                log3.debug("AwsChunkedEncodingInputStream reset (will use the buffer of the decoded stream).");
            }
            DecodedStreamBuffer decodedStreamBuffer = this.decodedStreamBuffer;
            if (decodedStreamBuffer != null) {
                decodedStreamBuffer.startReadBuffer();
            } else {
                throw new IOException("Cannot reset the stream because the mark is not set.");
            }
        }
        this.currentChunkIterator = null;
        this.isAtStart = true;
        this.isTerminating = false;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int read;
        if (j <= 0) {
            return 0L;
        }
        int min = (int) Math.min(262144L, j);
        byte[] bArr = new byte[min];
        long j2 = j;
        while (j2 > 0 && (read = read(bArr, 0, min)) >= 0) {
            j2 -= read;
        }
        return j - j2;
    }

    public AwsChunkedEncodingInputStream(InputStream inputStream, int r4, byte[] bArr, String str, String str2, String str3, AWS4Signer aWS4Signer) {
        this.is = null;
        this.isAtStart = true;
        this.isTerminating = false;
        if (inputStream instanceof AwsChunkedEncodingInputStream) {
            AwsChunkedEncodingInputStream awsChunkedEncodingInputStream = (AwsChunkedEncodingInputStream) inputStream;
            r4 = Math.max(awsChunkedEncodingInputStream.maxBufferSize, r4);
            this.is = awsChunkedEncodingInputStream.is;
            this.decodedStreamBuffer = awsChunkedEncodingInputStream.decodedStreamBuffer;
        } else {
            this.is = inputStream;
            this.decodedStreamBuffer = null;
        }
        if (r4 >= DEFAULT_CHUNK_SIZE) {
            this.maxBufferSize = r4;
            this.kSigning = bArr;
            this.dateTime = str;
            this.keyPath = str2;
            this.headerSignature = str3;
            this.priorChunkSignature = str3;
            this.aws4Signer = aWS4Signer;
            return;
        }
        throw new IllegalArgumentException("Max buffer size should not be less than chunk size");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int r4, int r5) throws IOException {
        abortIfNeeded();
        bArr.getClass();
        if (r4 < 0 || r5 < 0 || r5 > bArr.length - r4) {
            throw new IndexOutOfBoundsException();
        }
        if (r5 == 0) {
            return 0;
        }
        ChunkContentIterator chunkContentIterator = this.currentChunkIterator;
        if (chunkContentIterator == null || !chunkContentIterator.hasNext()) {
            if (this.isTerminating) {
                return -1;
            }
            this.isTerminating = setUpNextChunk();
        }
        int read = this.currentChunkIterator.read(bArr, r4, r5);
        if (read > 0) {
            this.isAtStart = false;
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug(read + " byte read from the stream.");
            }
        }
        return read;
    }
}
