package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class AbstractRepeatableCipherInputStream<T> extends SdkFilterInputStream {
    private final T cipherFactory;
    private boolean hasBeenAccessed;
    private final InputStream unencryptedDataStream;

    public AbstractRepeatableCipherInputStream(InputStream inputStream, FilterInputStream filterInputStream, T t) {
        super(filterInputStream);
        this.unencryptedDataStream = inputStream;
        this.cipherFactory = t;
    }

    public abstract FilterInputStream createCipherInputStream(InputStream inputStream, T t);

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int r2) {
        abortIfNeeded();
        if (!this.hasBeenAccessed) {
            this.unencryptedDataStream.mark(r2);
            return;
        }
        throw new UnsupportedOperationException("Marking is only supported before your first call to read or skip.");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        abortIfNeeded();
        return this.unencryptedDataStream.markSupported();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        this.hasBeenAccessed = true;
        return super.read();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        abortIfNeeded();
        this.unencryptedDataStream.reset();
        ((FilterInputStream) this).in = createCipherInputStream(this.unencryptedDataStream, this.cipherFactory);
        this.hasBeenAccessed = false;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        this.hasBeenAccessed = true;
        return super.skip(j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r3, int r4) throws IOException {
        this.hasBeenAccessed = true;
        return super.read(bArr, r3, r4);
    }
}
