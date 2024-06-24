package com.amazonaws.util;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
abstract class AbstractBase32Codec implements Codec {
    private static final int BITS_3 = 3;
    private static final int BITS_4 = 4;
    private static final int BITS_5 = 5;
    private static final int BIT_MULTIPLIER = 8;
    private static final int MASK_2BITS = 3;
    private static final int MASK_3BITS = 7;
    private static final int MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private static final byte PAD = 61;
    private final byte[] alpahbets;

    public AbstractBase32Codec(byte[] bArr) {
        this.alpahbets = bArr;
    }

    private final void decode1to4bytes(int r10, byte[] bArr, int r12, byte[] bArr2, int r14) {
        int r0 = r14 + 1;
        int r1 = r12 + 1;
        int pos = pos(bArr[r12]) << 3;
        int r3 = r1 + 1;
        int pos2 = pos(bArr[r1]);
        bArr2[r14] = (byte) (pos | ((pos2 >>> 2) & 7));
        if (r10 == 1) {
            CodecUtils.sanityCheckLastPos(pos2, 3);
            return;
        }
        int r142 = r0 + 1;
        int r4 = r3 + 1;
        int pos3 = ((pos2 & 3) << 6) | (pos(bArr[r3]) << 1);
        int r32 = r4 + 1;
        int pos4 = pos(bArr[r4]);
        bArr2[r0] = (byte) (pos3 | ((pos4 >>> 4) & 1));
        if (r10 == 2) {
            CodecUtils.sanityCheckLastPos(pos4, 15);
            return;
        }
        int r6 = r142 + 1;
        int r7 = r32 + 1;
        int pos5 = pos(bArr[r32]);
        bArr2[r142] = (byte) ((15 & (pos5 >>> 1)) | ((pos4 & 15) << 4));
        if (r10 == 3) {
            CodecUtils.sanityCheckLastPos(pos5, 1);
            return;
        }
        int pos6 = ((pos5 & 1) << 7) | (pos(bArr[r7]) << 2);
        int pos7 = pos(bArr[r7 + 1]);
        bArr2[r6] = (byte) (pos6 | ((pos7 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(pos7, 7);
    }

    private final void decode5bytes(byte[] bArr, int r6, byte[] bArr2, int r8) {
        int r0 = r8 + 1;
        int r1 = r6 + 1;
        int pos = pos(bArr[r6]) << 3;
        int r2 = r1 + 1;
        int pos2 = pos(bArr[r1]);
        bArr2[r8] = (byte) (pos | ((pos2 >>> 2) & 7));
        int r62 = r0 + 1;
        int r82 = (pos2 & 3) << 6;
        int r12 = r2 + 1;
        int pos3 = r82 | (pos(bArr[r2]) << 1);
        int r22 = r12 + 1;
        int pos4 = pos(bArr[r12]);
        bArr2[r0] = (byte) (pos3 | ((pos4 >>> 4) & 1));
        int r83 = r62 + 1;
        int r02 = (pos4 & 15) << 4;
        int r13 = r22 + 1;
        int pos5 = pos(bArr[r22]);
        bArr2[r62] = (byte) (r02 | ((pos5 >>> 1) & 15));
        int r03 = (pos5 & 1) << 7;
        int r23 = r13 + 1;
        int pos6 = r03 | (pos(bArr[r13]) << 2);
        int r14 = r23 + 1;
        int pos7 = pos(bArr[r23]);
        bArr2[r83] = (byte) (pos6 | ((pos7 >>> 3) & 3));
        bArr2[r83 + 1] = (byte) (pos(bArr[r14]) | ((pos7 & 7) << 5));
    }

    private final void encode1byte(byte[] bArr, int r4, byte[] bArr2, int r6) {
        int r0 = r6 + 1;
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[r4];
        bArr2[r6] = bArr3[(b >>> 3) & 31];
        int r42 = r0 + 1;
        bArr2[r0] = bArr3[(b & 7) << 2];
        int r3 = 0;
        while (r3 < 6) {
            bArr2[r42] = PAD;
            r3++;
            r42++;
        }
    }

    private final void encode2bytes(byte[] bArr, int r6, byte[] bArr2, int r8) {
        int r0 = r8 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r6 + 1;
        byte b = bArr[r6];
        bArr2[r8] = bArr3[(b >>> 3) & 31];
        int r82 = r0 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int r62 = r82 + 1;
        bArr2[r82] = bArr3[(b2 >>> 1) & 31];
        int r83 = r62 + 1;
        bArr2[r62] = bArr3[(b2 & 1) << 4];
        int r5 = 0;
        while (r5 < 4) {
            bArr2[r83] = PAD;
            r5++;
            r83++;
        }
    }

    private final void encode3bytes(byte[] bArr, int r8, byte[] bArr2, int r10) {
        int r0 = r10 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r8 + 1;
        byte b = bArr[r8];
        bArr2[r10] = bArr3[(b >>> 3) & 31];
        int r102 = r0 + 1;
        int r3 = r2 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int r82 = r102 + 1;
        bArr2[r102] = bArr3[(b2 >>> 1) & 31];
        int r103 = r82 + 1;
        byte b3 = bArr[r3];
        bArr2[r82] = bArr3[((b2 & 1) << 4) | ((b3 >>> 4) & 15)];
        int r83 = r103 + 1;
        bArr2[r103] = bArr3[(b3 & 15) << 1];
        int r7 = 0;
        while (r7 < 3) {
            bArr2[r83] = PAD;
            r7++;
            r83++;
        }
    }

    private final void encode4bytes(byte[] bArr, int r7, byte[] bArr2, int r9) {
        int r0 = r9 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r7 + 1;
        byte b = bArr[r7];
        bArr2[r9] = bArr3[(b >>> 3) & 31];
        int r92 = r0 + 1;
        int r3 = r2 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int r72 = r92 + 1;
        bArr2[r92] = bArr3[(b2 >>> 1) & 31];
        int r93 = r72 + 1;
        int r02 = (b2 & 1) << 4;
        int r22 = r3 + 1;
        byte b3 = bArr[r3];
        bArr2[r72] = bArr3[r02 | ((b3 >>> 4) & 15)];
        int r73 = r93 + 1;
        byte b4 = bArr[r22];
        bArr2[r93] = bArr3[((b3 & 15) << 1) | ((b4 >>> 7) & 1)];
        int r94 = r73 + 1;
        bArr2[r73] = bArr3[(b4 >>> 2) & 31];
        bArr2[r94] = bArr3[(b4 & 3) << 3];
        bArr2[r94 + 1] = PAD;
    }

    private final void encode5bytes(byte[] bArr, int r7, byte[] bArr2, int r9) {
        int r0 = r9 + 1;
        byte[] bArr3 = this.alpahbets;
        int r2 = r7 + 1;
        byte b = bArr[r7];
        bArr2[r9] = bArr3[(b >>> 3) & 31];
        int r92 = r0 + 1;
        int r3 = r2 + 1;
        byte b2 = bArr[r2];
        bArr2[r0] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int r72 = r92 + 1;
        bArr2[r92] = bArr3[(b2 >>> 1) & 31];
        int r93 = r72 + 1;
        int r02 = (b2 & 1) << 4;
        int r22 = r3 + 1;
        byte b3 = bArr[r3];
        bArr2[r72] = bArr3[r02 | ((b3 >>> 4) & 15)];
        int r73 = r93 + 1;
        int r03 = (b3 & 15) << 1;
        int r32 = r22 + 1;
        byte b4 = bArr[r22];
        bArr2[r93] = bArr3[r03 | ((b4 >>> 7) & 1)];
        int r94 = r73 + 1;
        bArr2[r73] = bArr3[(b4 >>> 2) & 31];
        byte b5 = bArr[r32];
        bArr2[r94] = bArr3[((b4 & 3) << 3) | ((b5 >>> 5) & 7)];
        bArr2[r94 + 1] = bArr3[b5 & 31];
    }

    @Override // com.amazonaws.util.Codec
    public final byte[] decode(byte[] bArr, int r13) {
        int r6;
        if (r13 % 8 == 0) {
            int r0 = r13 - 1;
            int r2 = 0;
            while (r2 < 6 && r0 > -1 && bArr[r0] == 61) {
                r0--;
                r2++;
            }
            if (r2 != 0) {
                int r4 = 4;
                if (r2 != 1) {
                    r6 = 3;
                    if (r2 != 3) {
                        if (r2 != 4) {
                            if (r2 == 6) {
                                r6 = 1;
                            } else {
                                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Invalid number of paddings ", r2));
                            }
                        } else {
                            r4 = 2;
                        }
                    }
                }
                r6 = r4;
            } else {
                r6 = 5;
            }
            int r132 = ((r13 / 8) * 5) - (5 - r6);
            byte[] bArr2 = new byte[r132];
            int r8 = 0;
            int r10 = 0;
            while (r10 < r132 - (r6 % 5)) {
                decode5bytes(bArr, r8, bArr2, r10);
                r8 += 8;
                r10 += 5;
            }
            if (r6 < 5) {
                decode1to4bytes(r6, bArr, r8, bArr2, r10);
            }
            return bArr2;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Input is expected to be encoded in multiple of 8 bytes but found: ", r13));
    }

    @Override // com.amazonaws.util.Codec
    public final byte[] encode(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int r2 = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 8];
            int r1 = 0;
            while (r2 < bArr.length) {
                encode5bytes(bArr, r2, bArr2, r1);
                r2 += 5;
                r1 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 8];
        int r4 = 0;
        while (r2 < bArr.length - length2) {
            encode5bytes(bArr, r2, bArr3, r4);
            r2 += 5;
            r4 += 8;
        }
        if (length2 != 1) {
            if (length2 != 2) {
                if (length2 != 3) {
                    if (length2 == 4) {
                        encode4bytes(bArr, r2, bArr3, r4);
                    }
                } else {
                    encode3bytes(bArr, r2, bArr3, r4);
                }
            } else {
                encode2bytes(bArr, r2, bArr3, r4);
            }
        } else {
            encode1byte(bArr, r2, bArr3, r4);
        }
        return bArr3;
    }

    public abstract int pos(byte b);
}
