package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class InputSubstream extends SdkFilterInputStream {
    private final boolean closeSourceStream;
    private long currentPosition;
    private long markedPosition;
    private final long requestedLength;
    private final long requestedOffset;

    public InputSubstream(InputStream inputStream, long j, long j2, boolean z) {
        super(inputStream);
        this.markedPosition = 0L;
        this.currentPosition = 0L;
        this.requestedLength = j2;
        this.requestedOffset = j;
        this.closeSourceStream = z;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        long j;
        long j2 = this.currentPosition;
        long j3 = this.requestedOffset;
        if (j2 < j3) {
            j = this.requestedLength;
        } else {
            j = (this.requestedLength + j3) - j2;
        }
        return (int) Math.min(j, super.available());
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closeSourceStream) {
            super.close();
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r3) {
        this.markedPosition = this.currentPosition;
        super.mark(r3);
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        this.currentPosition = this.markedPosition;
        super.reset();
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r8, int r9) throws IOException {
        long j;
        long j2;
        while (true) {
            j = this.currentPosition;
            j2 = this.requestedOffset;
            if (j >= j2) {
                break;
            }
            this.currentPosition += super.skip(j2 - j);
        }
        long j3 = (this.requestedLength + j2) - j;
        if (j3 <= 0) {
            return -1;
        }
        int read = super.read(bArr, r8, (int) Math.min(r9, j3));
        this.currentPosition += read;
        return read;
    }
}
