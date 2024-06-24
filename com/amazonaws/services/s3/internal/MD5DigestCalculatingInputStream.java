package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class MD5DigestCalculatingInputStream extends SdkFilterInputStream {
    private MessageDigest digest;
    private MessageDigest digestLastMarked;

    public MD5DigestCalculatingInputStream(InputStream inputStream) {
        super(inputStream);
        this.digest = newMD5();
    }

    private MessageDigest cloneFrom(MessageDigest messageDigest) {
        try {
            return (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    private MessageDigest newMD5() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("unexpected", e);
        }
    }

    public byte[] getMd5Digest() {
        return this.digest.digest();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        if (markSupported()) {
            super.mark(r2);
            this.digestLastMarked = cloneFrom(this.digest);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.digest.update((byte) read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        MessageDigest cloneFrom;
        if (markSupported()) {
            super.reset();
            MessageDigest messageDigest = this.digestLastMarked;
            if (messageDigest == null) {
                cloneFrom = newMD5();
            } else {
                cloneFrom = cloneFrom(messageDigest);
            }
            this.digest = cloneFrom;
            return;
        }
        throw new IOException("mark/reset not supported");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r3, int r4) throws IOException {
        int read = super.read(bArr, r3, r4);
        if (read != -1) {
            this.digest.update(bArr, r3, read);
        }
        return read;
    }
}
