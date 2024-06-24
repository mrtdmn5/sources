package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class LengthCountingOutputStream extends OutputStream {
    public long length = 0;

    @Override // java.io.OutputStream
    public final void write(int r5) {
        this.length++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        this.length += bArr.length;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int r4, int r5) {
        int r42;
        if (r4 >= 0 && r4 <= bArr.length && r5 >= 0 && (r42 = r4 + r5) <= bArr.length && r42 >= 0) {
            this.length += r5;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
