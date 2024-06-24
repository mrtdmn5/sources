package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkDigestInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.Arrays;

/* loaded from: classes.dex */
public class DigestValidationInputStream extends SdkDigestInputStream {
    private boolean digestValidated;
    private byte[] expectedHash;

    public DigestValidationInputStream(InputStream inputStream, MessageDigest messageDigest, byte[] bArr) {
        super(inputStream, messageDigest);
        this.digestValidated = false;
        this.expectedHash = bArr;
    }

    private void validateMD5Digest() {
        if (this.expectedHash != null && !this.digestValidated) {
            this.digestValidated = true;
            if (!Arrays.equals(((DigestInputStream) this).digest.digest(), this.expectedHash)) {
                throw new AmazonClientException("Unable to verify integrity of data download.  Client calculated content hash didn't match hash calculated by Amazon S3.  The data may be corrupt.");
            }
        }
    }

    public byte[] getMD5Checksum() {
        return ((DigestInputStream) this).digest.digest();
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            validateMD5Digest();
        }
        return read;
    }

    @Override // java.security.DigestInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r2, int r3) throws IOException {
        int read = super.read(bArr, r2, r3);
        if (read == -1) {
            validateMD5Digest();
        }
        return read;
    }
}
