package com.amazonaws.util;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class Base64Codec implements Codec {
    private static final int BITS_3 = 3;
    private static final int BITS_4 = 4;
    private static final int BITS_6 = 6;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private static final int OFFSET_0_VALUE = 52;
    private static final int OFFSET_OF_0 = -4;
    private static final int OFFSET_OF_PLUS = -19;
    private static final int OFFSET_OF_SLASH = -16;
    private static final int OFFSET_OF_a = 71;
    private static final int OFFSET_PLUS_VALUE = 62;
    private static final int OFFSET_SLASH_VALUE = 63;
    private static final int OFFSET_a_VALUE = 26;
    private static final byte PAD = 61;
    private final byte[] alpahbets;

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
                } else if (r1 >= 48 && r1 <= 57) {
                    bArr[r1] = (byte) (r1 + 4);
                } else if (r1 == 43) {
                    bArr[r1] = (byte) (r1 + 19);
                } else if (r1 == 47) {
                    bArr[r1] = (byte) (r1 + 16);
                } else if (r1 >= 97 && r1 <= 122) {
                    bArr[r1] = (byte) (r1 - 71);
                } else {
                    bArr[r1] = -1;
                }
            }
            return bArr;
        }
    }

    public Base64Codec() {
        this.alpahbets = CodecUtils.toBytesDirect("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    }

    @Override // com.amazonaws.util.Codec
    public byte[] decode(byte[] bArr, int r9) {
        int r3;
        if (r9 % 4 == 0) {
            int r0 = r9 - 1;
            int r2 = 0;
            while (true) {
                r3 = 2;
                if (r2 >= 2 || r0 <= -1 || bArr[r0] != 61) {
                    break;
                }
                r0--;
                r2++;
            }
            if (r2 != 0) {
                if (r2 != 1) {
                    if (r2 == 2) {
                        r3 = 1;
                    } else {
                        throw new Error("Impossible");
                    }
                }
            } else {
                r3 = 3;
            }
            int r92 = ((r9 / 4) * 3) - (3 - r3);
            byte[] bArr2 = new byte[r92];
            int r4 = 0;
            int r5 = 0;
            while (r5 < r92 - (r3 % 3)) {
                decode4bytes(bArr, r4, bArr2, r5);
                r4 += 4;
                r5 += 3;
            }
            if (r3 < 3) {
                decode1to3bytes(r3, bArr, r4, bArr2, r5);
            }
            return bArr2;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Input is expected to be encoded in multiple of 4 bytes but found: ", r9));
    }

    public void decode1to3bytes(int r8, byte[] bArr, int r10, byte[] bArr2, int r12) {
        int r0 = r12 + 1;
        int r1 = r10 + 1;
        int pos = pos(bArr[r10]) << 2;
        int r3 = r1 + 1;
        int pos2 = pos(bArr[r1]);
        bArr2[r12] = (byte) (pos | ((pos2 >>> 4) & 3));
        if (r8 == 1) {
            CodecUtils.sanityCheckLastPos(pos2, 15);
            return;
        }
        int r122 = r0 + 1;
        int r4 = r3 + 1;
        int pos3 = pos(bArr[r3]);
        bArr2[r0] = (byte) ((15 & (pos3 >>> 2)) | ((pos2 & 15) << 4));
        if (r8 == 2) {
            CodecUtils.sanityCheckLastPos(pos3, 3);
        } else {
            bArr2[r122] = (byte) (((pos3 & 3) << 6) | pos(bArr[r4]));
        }
    }

    public void decode4bytes(byte[] bArr, int r6, byte[] bArr2, int r8) {
        int r0 = r8 + 1;
        int r1 = r6 + 1;
        int pos = pos(bArr[r6]) << 2;
        int r2 = r1 + 1;
        int pos2 = pos(bArr[r1]);
        bArr2[r8] = (byte) (pos | ((pos2 >>> 4) & 3));
        int r82 = (pos2 & 15) << 4;
        int r12 = r2 + 1;
        int pos3 = pos(bArr[r2]);
        bArr2[r0] = (byte) (r82 | ((pos3 >>> 2) & 15));
        bArr2[r0 + 1] = (byte) (pos(bArr[r12]) | ((pos3 & 3) << 6));
    }

    @Override // com.amazonaws.util.Codec
    public byte[] encode(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int r2 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int r1 = 0;
            while (r2 < bArr.length) {
                encode3bytes(bArr, r2, bArr2, r1);
                r2 += 3;
                r1 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int r4 = 0;
        while (r2 < bArr.length - length2) {
            encode3bytes(bArr, r2, bArr3, r4);
            r2 += 3;
            r4 += 4;
        }
        if (length2 != 1) {
            if (length2 == 2) {
                encode2bytes(bArr, r2, bArr3, r4);
            }
        } else {
            encode1byte(bArr, r2, bArr3, r4);
        }
        return bArr3;
    }

    public void encode1byte(byte[] bArr, int r4, byte[] bArr2, int r6) {
        int r0 = r6 + 1;
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[r4];
        bArr2[r6] = bArr3[(b >>> 2) & 63];
        int r42 = r0 + 1;
        bArr2[r0] = bArr3[(b & 3) << 4];
        bArr2[r42] = PAD;
        bArr2[r42 + 1] = PAD;
    }

    public void encode2bytes(byte[] bArr, int r6, byte[] bArr2, int r8) {
        int r0 = r8 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r6 + 1;
        byte b = bArr[r6];
        bArr2[r8] = bArr3[(b >>> 2) & 63];
        int r82 = r0 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[r82] = bArr3[(b2 & 15) << 2];
        bArr2[r82 + 1] = PAD;
    }

    public void encode3bytes(byte[] bArr, int r7, byte[] bArr2, int r9) {
        int r0 = r9 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r7 + 1;
        byte b = bArr[r7];
        bArr2[r9] = bArr3[(b >>> 2) & 63];
        int r92 = r0 + 1;
        int r3 = r2 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        byte b3 = bArr[r3];
        bArr2[r92] = bArr3[((b2 & 15) << 2) | ((b3 >>> 6) & 3)];
        bArr2[r92 + 1] = bArr3[b3 & 63];
    }

    public int pos(byte b) {
        byte b2 = LazyHolder.DECODED[b];
        if (b2 > -1) {
            return b2;
        }
        throw new IllegalArgumentException("Invalid base 64 character: '" + ((char) b) + "'");
    }

    public Base64Codec(byte[] bArr) {
        this.alpahbets = bArr;
    }
}
