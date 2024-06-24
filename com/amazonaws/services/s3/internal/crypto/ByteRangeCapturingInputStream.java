package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ByteRangeCapturingInputStream extends SdkFilterInputStream {
    private final byte[] block;
    private int blockPosition;
    private final long endingPosition;
    private int markedBlockPosition;
    private long markedStreamPosition;
    private final long startingPosition;
    private long streamPosition;

    public ByteRangeCapturingInputStream(InputStream inputStream, long j, long j2) {
        super(inputStream);
        this.blockPosition = 0;
        if (j < j2) {
            this.startingPosition = j;
            this.endingPosition = j2;
            this.block = new byte[(int) (j2 - j)];
            return;
        }
        throw new IllegalArgumentException("Invalid byte range specified: the starting position must be less than the ending position");
    }

    public byte[] getBlock() {
        return this.block;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r3) {
        super.mark(r3);
        if (markSupported()) {
            this.markedStreamPosition = this.streamPosition;
            this.markedBlockPosition = this.blockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            return -1;
        }
        long j = this.streamPosition;
        if (j >= this.startingPosition && j <= this.endingPosition) {
            byte[] bArr = this.block;
            int r4 = this.blockPosition;
            this.blockPosition = r4 + 1;
            bArr[r4] = (byte) read;
        }
        this.streamPosition = j + 1;
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        if (markSupported()) {
            this.streamPosition = this.markedStreamPosition;
            this.blockPosition = this.markedBlockPosition;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r14, int r15) throws IOException {
        int read = super.read(bArr, r14, r15);
        if (read == -1) {
            return -1;
        }
        long j = this.streamPosition;
        long j2 = read;
        if (j + j2 >= this.startingPosition && j <= this.endingPosition) {
            for (int r0 = 0; r0 < read; r0++) {
                long j3 = this.streamPosition;
                long j4 = r0;
                if (j3 + j4 >= this.startingPosition && j3 + j4 < this.endingPosition) {
                    byte[] bArr2 = this.block;
                    int r4 = this.blockPosition;
                    this.blockPosition = r4 + 1;
                    bArr2[r4] = bArr[r14 + r0];
                }
            }
        }
        this.streamPosition += j2;
        return read;
    }
}
