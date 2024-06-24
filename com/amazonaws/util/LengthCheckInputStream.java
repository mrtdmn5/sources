package com.amazonaws.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class LengthCheckInputStream extends SdkFilterInputStream {
    public static final boolean EXCLUDE_SKIPPED_BYTES = false;
    public static final boolean INCLUDE_SKIPPED_BYTES = true;
    private long dataLength;
    private final long expectedLength;
    private final boolean includeSkipped;
    private long marked;

    public LengthCheckInputStream(InputStream inputStream, long j, boolean z) {
        super(inputStream);
        if (j >= 0) {
            this.expectedLength = j;
            this.includeSkipped = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void checkLength(boolean z) {
        if (z) {
            if (this.dataLength != this.expectedLength) {
                throw new AmazonClientException("Data read (" + this.dataLength + ") has a different length than the expected (" + this.expectedLength + ")");
            }
            return;
        }
        if (this.dataLength <= this.expectedLength) {
            return;
        }
        throw new AmazonClientException("More data read (" + this.dataLength + ") than expected (" + this.expectedLength + ")");
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void mark(int r3) {
        super.mark(r3);
        this.marked = this.dataLength;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = super.read();
        if (read >= 0) {
            this.dataLength++;
        }
        checkLength(read == -1);
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        if (super.markSupported()) {
            this.dataLength = this.marked;
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(j);
        if (this.includeSkipped && skip > 0) {
            this.dataLength += skip;
            checkLength(false);
        }
        return skip;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int r4, int r5) throws IOException {
        int read = super.read(bArr, r4, r5);
        this.dataLength += read >= 0 ? read : 0L;
        checkLength(read == -1);
        return read;
    }
}
