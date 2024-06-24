package com.amazonaws.services.s3.internal.crypto;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

@Deprecated
/* loaded from: classes.dex */
public class CipherLiteInputStream extends SdkFilterInputStream {
    private static final int BYTE_MASK = 255;
    private static final int DEFAULT_IN_BUFFER_SIZE = 512;
    private static final int MAX_RETRY = 1000;
    private final byte[] bufin;
    private byte[] bufout;
    private CipherLite cipherLite;
    private int currPos;
    private boolean eof;
    private final boolean lastMultiPart;
    private int maxPos;
    private final boolean multipart;

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite) {
        this(inputStream, cipherLite, 512, false, false);
    }

    private int nextChunk() throws IOException {
        abortIfNeeded();
        if (this.eof) {
            return -1;
        }
        this.bufout = null;
        int read = ((FilterInputStream) this).in.read(this.bufin);
        int r2 = 0;
        if (read == -1) {
            this.eof = true;
            if (!this.multipart || this.lastMultiPart) {
                try {
                    byte[] doFinal = this.cipherLite.doFinal();
                    this.bufout = doFinal;
                    if (doFinal == null) {
                        return -1;
                    }
                    this.currPos = 0;
                    int length = doFinal.length;
                    this.maxPos = length;
                    return length;
                } catch (BadPaddingException e) {
                    if (S3CryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
                        throw new SecurityException(e);
                    }
                } catch (IllegalBlockSizeException unused) {
                }
            }
            return -1;
        }
        byte[] update = this.cipherLite.update(this.bufin, 0, read);
        this.bufout = update;
        this.currPos = 0;
        if (update != null) {
            r2 = update.length;
        }
        this.maxPos = r2;
        return r2;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() {
        abortIfNeeded();
        return this.maxPos - this.currPos;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterInputStream) this).in.close();
        if (!this.multipart && !S3CryptoScheme.isAesGcm(this.cipherLite.getCipherAlgorithm())) {
            try {
                this.cipherLite.doFinal();
            } catch (BadPaddingException | IllegalBlockSizeException unused) {
            }
        }
        this.currPos = 0;
        this.maxPos = 0;
        abortIfNeeded();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        abortIfNeeded();
        ((FilterInputStream) this).in.mark(r2);
        this.cipherLite.mark();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        if (((FilterInputStream) this).in.markSupported() && this.cipherLite.markSupported()) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.currPos >= this.maxPos) {
            if (this.eof) {
                return -1;
            }
            int r0 = 0;
            while (r0 <= MAX_RETRY) {
                int nextChunk = nextChunk();
                r0++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        byte[] bArr = this.bufout;
        int r1 = this.currPos;
        this.currPos = r1 + 1;
        return bArr[r1] & 255;
    }

    public void renewCipherLite() {
        this.cipherLite = this.cipherLite.recreate();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        abortIfNeeded();
        ((FilterInputStream) this).in.reset();
        this.cipherLite.reset();
        resetInternal();
    }

    public final void resetInternal() {
        if (markSupported()) {
            this.currPos = 0;
            this.maxPos = 0;
            this.eof = false;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        abortIfNeeded();
        int r0 = this.maxPos;
        int r1 = this.currPos;
        long j2 = r0 - r1;
        if (j > j2) {
            j = j2;
        }
        if (j < 0) {
            return 0L;
        }
        this.currPos = (int) (r1 + j);
        return j;
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int r9) {
        this(inputStream, cipherLite, r9, false, false);
    }

    public CipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int r3, boolean z, boolean z2) {
        super(inputStream);
        this.eof = false;
        this.currPos = 0;
        this.maxPos = 0;
        if (z2 && !z) {
            throw new IllegalArgumentException("lastMultiPart can only be true if multipart is true");
        }
        this.multipart = z;
        this.lastMultiPart = z2;
        this.cipherLite = cipherLite;
        if (r3 > 0 && r3 % 512 == 0) {
            this.bufin = new byte[r3];
            return;
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("buffsize (", r3, ") must be a positive multiple of 512"));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r6, int r7) throws IOException {
        if (this.currPos >= this.maxPos) {
            if (this.eof) {
                return -1;
            }
            int r0 = 0;
            while (r0 <= MAX_RETRY) {
                int nextChunk = nextChunk();
                r0++;
                if (nextChunk != 0) {
                    if (nextChunk == -1) {
                        return -1;
                    }
                }
            }
            throw new IOException("exceeded maximum number of attempts to read next chunk of data");
        }
        if (r7 <= 0) {
            return 0;
        }
        int r02 = this.maxPos;
        int r1 = this.currPos;
        int r03 = r02 - r1;
        if (r7 >= r03) {
            r7 = r03;
        }
        System.arraycopy(this.bufout, r1, bArr, r6, r7);
        this.currPos += r7;
        return r7;
    }

    public CipherLiteInputStream(InputStream inputStream) {
        this(inputStream, CipherLite.NULL, 512, false, false);
    }
}
