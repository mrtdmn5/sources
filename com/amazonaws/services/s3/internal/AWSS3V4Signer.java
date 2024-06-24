package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AwsChunkedEncodingInputStream;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.BinaryUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class AWSS3V4Signer extends AWS4Signer {
    private static final String CONTENT_SHA_256 = "STREAMING-AWS4-HMAC-SHA256-PAYLOAD";
    private static final int DEFAULT_BYTE_LENGTH = 4096;

    public AWSS3V4Signer() {
        super(false);
    }

    public static long getContentLength(Request<?> request) throws IOException {
        InputStream content = request.getContent();
        if (content.markSupported()) {
            byte[] bArr = new byte[4096];
            content.mark(-1);
            long j = 0;
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    j += read;
                } else {
                    content.reset();
                    return j;
                }
            }
        } else {
            throw new AmazonClientException("Failed to get content length");
        }
    }

    private static boolean useChunkEncoding(Request<?> request) {
        if (!(request.getOriginalRequest() instanceof PutObjectRequest) && !(request.getOriginalRequest() instanceof UploadPartRequest)) {
            return false;
        }
        return true;
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public String calculateContentHash(Request<?> request) {
        long contentLength;
        request.addHeader("x-amz-content-sha256", "required");
        if (useChunkEncoding(request)) {
            String str = request.getHeaders().get("Content-Length");
            if (str != null) {
                contentLength = Long.parseLong(str);
            } else {
                try {
                    contentLength = getContentLength(request);
                } catch (IOException e) {
                    throw new AmazonClientException("Cannot get the content-lenght of the request content.", e);
                }
            }
            request.addHeader("x-amz-decoded-content-length", Long.toString(contentLength));
            request.addHeader("Content-Length", Long.toString(AwsChunkedEncodingInputStream.calculateStreamContentLength(contentLength)));
            return CONTENT_SHA_256;
        }
        return super.calculateContentHash(request);
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public String calculateContentHashPresign(Request<?> request) {
        return "UNSIGNED-PAYLOAD";
    }

    @Override // com.amazonaws.auth.AWS4Signer
    public void processRequestPayload(Request<?> request, AWS4Signer.HeaderSigningResult headerSigningResult) {
        if (useChunkEncoding(request)) {
            request.setContent(new AwsChunkedEncodingInputStream(request.getContent(), headerSigningResult.getKSigning(), headerSigningResult.getDateTime(), headerSigningResult.getScope(), BinaryUtils.toHex(headerSigningResult.getSignature()), this));
        }
    }
}
