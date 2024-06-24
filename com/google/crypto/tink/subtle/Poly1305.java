package com.google.crypto.tink.subtle;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class Poly1305 {
    public static byte[] computeMac(final byte[] key, byte[] data) {
        if (key.length == 32) {
            byte b = 0;
            long load32 = (load32(0, key) >> 0) & 67108863 & 67108863;
            long load322 = (load32(3, key) >> 2) & 67108863 & 67108611;
            long load323 = (load32(6, key) >> 4) & 67108863 & 67092735;
            long load324 = (load32(9, key) >> 6) & 67108863 & 66076671;
            long load325 = (load32(12, key) >> 8) & 67108863 & 1048575;
            long j = load322 * 5;
            long j2 = load323 * 5;
            long j3 = load324 * 5;
            long j4 = load325 * 5;
            int r3 = 17;
            byte[] bArr = new byte[17];
            long j5 = 0;
            int r12 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            while (r12 < data.length) {
                int min = Math.min(16, data.length - r12);
                System.arraycopy(data, r12, bArr, b, min);
                bArr[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr, min + 1, r3, b);
                }
                long load326 = j9 + ((load32(b, bArr) >> b) & 67108863);
                long load327 = j5 + ((load32(3, bArr) >> 2) & 67108863);
                long load328 = j6 + ((load32(6, bArr) >> 4) & 67108863);
                long load329 = j7 + ((load32(9, bArr) >> 6) & 67108863);
                long load3210 = j8 + (((load32(12, bArr) >> 8) & 67108863) | (bArr[16] << 24));
                long j10 = (load3210 * j) + (load329 * j2) + (load328 * j3) + (load327 * j4) + (load326 * load32);
                long j11 = (load3210 * j2) + (load329 * j3) + (load328 * j4) + (load327 * load32) + (load326 * load322);
                long j12 = (load3210 * j3) + (load329 * j4) + (load328 * load32) + (load327 * load322) + (load326 * load323);
                long j13 = (load3210 * j4) + (load329 * load32) + (load328 * load322) + (load327 * load323) + (load326 * load324);
                long j14 = load329 * load322;
                long j15 = load3210 * load32;
                long j16 = j11 + (j10 >> 26);
                long j17 = j12 + (j16 >> 26);
                long j18 = j13 + (j17 >> 26);
                long j19 = j15 + j14 + (load328 * load323) + (load327 * load324) + (load326 * load325) + (j18 >> 26);
                long j20 = j19 >> 26;
                j8 = j19 & 67108863;
                long j21 = (j20 * 5) + (j10 & 67108863);
                r12 += 16;
                j6 = j17 & 67108863;
                j7 = j18 & 67108863;
                j9 = j21 & 67108863;
                j5 = (j16 & 67108863) + (j21 >> 26);
                b = 0;
                r3 = 17;
            }
            long j22 = j6 + (j5 >> 26);
            long j23 = j22 & 67108863;
            long j24 = j7 + (j22 >> 26);
            long j25 = j24 & 67108863;
            long j26 = j8 + (j24 >> 26);
            long j27 = j26 & 67108863;
            long j28 = ((j26 >> 26) * 5) + j9;
            long j29 = j28 >> 26;
            long j30 = j28 & 67108863;
            long j31 = (j5 & 67108863) + j29;
            long j32 = j30 + 5;
            long j33 = j32 & 67108863;
            long j34 = j31 + (j32 >> 26);
            long j35 = j23 + (j34 >> 26);
            long j36 = j25 + (j35 >> 26);
            long j37 = (j27 + (j36 >> 26)) - 67108864;
            long j38 = j37 >> 63;
            long j39 = ~j38;
            long j40 = (j31 & j38) | (j34 & 67108863 & j39);
            long j41 = (j23 & j38) | (j35 & 67108863 & j39);
            long j42 = (j36 & 67108863 & j39) | (j25 & j38);
            long j43 = ((j30 & j38) | (j33 & j39) | (j40 << 26)) & 4294967295L;
            long j44 = ((j40 >> 6) | (j41 << 20)) & 4294967295L;
            long j45 = ((j41 >> 12) | (j42 << 14)) & 4294967295L;
            long j46 = ((j42 >> 18) | (((j37 & j39) | (j27 & j38)) << 8)) & 4294967295L;
            long load3211 = load32(16, key) + j43;
            long j47 = load3211 & 4294967295L;
            long load3212 = load32(20, key) + j44 + (load3211 >> 32);
            long load3213 = load32(24, key) + j45 + (load3212 >> 32);
            long load3214 = (load32(28, key) + j46 + (load3213 >> 32)) & 4294967295L;
            byte[] bArr2 = new byte[16];
            toByteArray(j47, 0, bArr2);
            toByteArray(load3212 & 4294967295L, 4, bArr2);
            toByteArray(load3213 & 4294967295L, 8, bArr2);
            toByteArray(load3214, 12, bArr2);
            return bArr2;
        }
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    public static long load32(int in, byte[] idx) {
        return (((idx[in + 3] & 255) << 24) | (idx[in] & 255) | ((idx[in + 1] & 255) << 8) | ((idx[in + 2] & 255) << 16)) & 4294967295L;
    }

    public static void toByteArray(long output, int num, byte[] idx) {
        int r0 = 0;
        while (r0 < 4) {
            idx[num + r0] = (byte) (255 & output);
            r0++;
            output >>= 8;
        }
    }
}
