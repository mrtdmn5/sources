package com.amazonaws.util;

/* loaded from: classes.dex */
class Base32Codec extends AbstractBase32Codec {
    private static final int OFFSET = 26;
    private static final int OFFSET_OF_2 = 24;

    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final byte[] DECODED = decodeTable();

        private LazyHolder() {
        }

        private static byte[] decodeTable() {
            byte[] bArr = new byte[123];
            for (int r1 = 0; r1 <= 122; r1++) {
                if (r1 >= 65 && r1 <= 90) {
                    bArr[r1] = (byte) (r1 - 65);
                } else if (r1 >= 50 && r1 <= 55) {
                    bArr[r1] = (byte) (r1 - 24);
                } else if (r1 >= 97 && r1 <= 122) {
                    bArr[r1] = (byte) (r1 - 97);
                } else {
                    bArr[r1] = -1;
                }
            }
            return bArr;
        }
    }

    public Base32Codec() {
        super(alphabets());
    }

    private static byte[] alphabets() {
        return CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
    }

    @Override // com.amazonaws.util.AbstractBase32Codec
    public int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 32 character: '" + ((char) b) + "'");
    }
}
