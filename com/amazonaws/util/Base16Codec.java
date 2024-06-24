package com.amazonaws.util;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
class Base16Codec implements Codec {
    private static final int BITS_4 = 4;
    private static final int MASK_4BITS = 15;
    private static final int OFFSET_OF_A = 55;
    private static final int OFFSET_OF_a = 87;
    private static final int OFFSET_VALUE = 10;
    private final byte[] alpahbets = CodecUtils.toBytesDirect("0123456789ABCDEF");

    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[103];
            for (int r1 = 0; r1 <= 102; r1++) {
                if (r1 >= 48 && r1 <= 57) {
                    bArr[r1] = (byte) (r1 - 48);
                } else if (r1 >= 65 && r1 <= 70) {
                    bArr[r1] = (byte) (r1 - 55);
                } else if (r1 >= 97 && r1 <= 102) {
                    bArr[r1] = (byte) (r1 - 87);
                } else {
                    bArr[r1] = -1;
                }
            }
            return bArr;
        }
    }

    @Override // com.amazonaws.util.Codec
    public byte[] decode(byte[] bArr, int r7) {
        if (r7 % 2 == 0) {
            int r72 = r7 / 2;
            byte[] bArr2 = new byte[r72];
            int r1 = 0;
            int r2 = 0;
            while (r1 < r72) {
                int r3 = r2 + 1;
                bArr2[r1] = (byte) ((pos(bArr[r2]) << 4) | pos(bArr[r3]));
                r1++;
                r2 = r3 + 1;
            }
            return bArr2;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Input is expected to be encoded in multiple of 2 bytes but found: ", r7));
    }

    @Override // com.amazonaws.util.Codec
    public byte[] encode(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int r2 = 0;
        for (byte b : bArr) {
            int r3 = r2 + 1;
            byte[] bArr3 = this.alpahbets;
            bArr2[r2] = bArr3[(b >>> 4) & 15];
            r2 = r3 + 1;
            bArr2[r3] = bArr3[b & 15];
        }
        return bArr2;
    }

    public int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 16 character: '" + ((char) b) + "'");
    }
}
