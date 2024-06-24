package com.google.crypto.tink.subtle;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes3.dex */
public final class Bytes {
    public static byte[] concat(byte[]... chunks) throws GeneralSecurityException {
        int r3 = 0;
        for (byte[] bArr : chunks) {
            if (r3 <= Integer.MAX_VALUE - bArr.length) {
                r3 += bArr.length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr2 = new byte[r3];
        int r4 = 0;
        for (byte[] bArr3 : chunks) {
            System.arraycopy(bArr3, 0, bArr2, r4, bArr3.length);
            r4 += bArr3.length;
        }
        return bArr2;
    }

    public static final boolean equal(final byte[] x, final byte[] y) {
        if (x == null || y == null || x.length != y.length) {
            return false;
        }
        int r2 = 0;
        for (int r1 = 0; r1 < x.length; r1++) {
            r2 |= x[r1] ^ y[r1];
        }
        if (r2 != 0) {
            return false;
        }
        return true;
    }

    public static final byte[] xor(final int x, byte[] offsetX, final int y, byte[] offsetY, int len) {
        if (len >= 0 && offsetX.length - len >= x && offsetY.length - len >= y) {
            byte[] bArr = new byte[len];
            for (int r1 = 0; r1 < len; r1++) {
                bArr[r1] = (byte) (offsetX[r1 + x] ^ offsetY[r1 + y]);
            }
            return bArr;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static final void xor(ByteBuffer output, ByteBuffer x, ByteBuffer y, int len) {
        if (len < 0 || x.remaining() < len || y.remaining() < len || output.remaining() < len) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int r0 = 0; r0 < len; r0++) {
            output.put((byte) (x.get() ^ y.get()));
        }
    }

    public static final byte[] xor(final byte[] x, final byte[] y) {
        if (x.length == y.length) {
            return xor(0, x, 0, y, x.length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }
}
