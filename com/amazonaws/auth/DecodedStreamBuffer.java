package com.amazonaws.auth;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes.dex */
class DecodedStreamBuffer {
    private static final Log log = LogFactory.getLog((Class<?>) DecodedStreamBuffer.class);
    private byte[] bufferArray;
    private boolean bufferSizeOverflow;
    private int byteBuffered;
    private int maxBufferSize;
    private int pos = -1;

    public DecodedStreamBuffer(int r2) {
        this.bufferArray = new byte[r2];
        this.maxBufferSize = r2;
    }

    public void buffer(byte b) {
        this.pos = -1;
        int r0 = this.byteBuffered;
        if (r0 >= this.maxBufferSize) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Buffer size " + this.maxBufferSize + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
            }
            this.bufferSizeOverflow = true;
            return;
        }
        byte[] bArr = this.bufferArray;
        this.byteBuffered = r0 + 1;
        bArr[r0] = b;
    }

    public boolean hasNext() {
        int r0 = this.pos;
        if (r0 != -1 && r0 < this.byteBuffered) {
            return true;
        }
        return false;
    }

    public byte next() {
        byte[] bArr = this.bufferArray;
        int r1 = this.pos;
        this.pos = r1 + 1;
        return bArr[r1];
    }

    public void startReadBuffer() {
        if (!this.bufferSizeOverflow) {
            this.pos = 0;
            return;
        }
        throw new AmazonClientException(ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("The input stream is not repeatable since the buffer size "), this.maxBufferSize, " has been exceeded."));
    }

    public void buffer(byte[] bArr, int r5, int r6) {
        this.pos = -1;
        int r0 = this.byteBuffered;
        if (r0 + r6 > this.maxBufferSize) {
            Log log2 = log;
            if (log2.isDebugEnabled()) {
                log2.debug("Buffer size " + this.maxBufferSize + " has been exceeded and the input stream will not be repeatable. Freeing buffer memory");
            }
            this.bufferSizeOverflow = true;
            return;
        }
        System.arraycopy(bArr, r5, this.bufferArray, r0, r6);
        this.byteBuffered += r6;
    }
}
