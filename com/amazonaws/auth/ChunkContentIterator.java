package com.amazonaws.auth;

/* loaded from: classes.dex */
class ChunkContentIterator {
    private int pos;
    private final byte[] signedChunk;

    public ChunkContentIterator(byte[] bArr) {
        this.signedChunk = bArr;
    }

    public boolean hasNext() {
        if (this.pos < this.signedChunk.length) {
            return true;
        }
        return false;
    }

    public int read(byte[] bArr, int r4, int r5) {
        if (r5 == 0) {
            return 0;
        }
        if (!hasNext()) {
            return -1;
        }
        int min = Math.min(this.signedChunk.length - this.pos, r5);
        System.arraycopy(this.signedChunk, this.pos, bArr, r4, min);
        this.pos += min;
        return min;
    }
}
