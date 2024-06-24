package com.amazonaws.services.s3.internal.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes.dex */
public final class RenewableCipherLiteInputStream extends CipherLiteInputStream {
    private boolean hasBeenAccessed;

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite) {
        super(inputStream, cipherLite);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        abortIfNeeded();
        if (!this.hasBeenAccessed) {
            ((FilterInputStream) this).in.mark(r2);
            return;
        }
        throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        this.hasBeenAccessed = true;
        return super.read();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        abortIfNeeded();
        ((FilterInputStream) this).in.reset();
        renewCipherLite();
        resetInternal();
        this.hasBeenAccessed = false;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        this.hasBeenAccessed = true;
        return super.skip(j);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int r3) {
        super(inputStream, cipherLite, r3);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream, CipherLite cipherLite, int r3, boolean z, boolean z2) {
        super(inputStream, cipherLite, r3, z, z2);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr);
    }

    public RenewableCipherLiteInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLiteInputStream, com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r3, int r4) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr, r3, r4);
    }
}
