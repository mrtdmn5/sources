package com.google.crypto.tink.subtle;

import com.amazonaws.services.s3.internal.Constants;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class Base64 {
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);

    /* loaded from: classes3.dex */
    public static abstract class Coder {
    }

    /* loaded from: classes3.dex */
    public static class Decoder extends Coder {
        public static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    }

    /* loaded from: classes3.dex */
    public static class Encoder extends Coder {
        public static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00df, code lost:            if (r7 == 1) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00e1, code lost:            if (r7 == 2) goto L57;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00e3, code lost:            if (r7 == 3) goto L56;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00e5, code lost:            if (r7 == 4) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00e8, code lost:            r15 = r9 + 1;        r3[r9] = (byte) (r8 >> 10);        r9 = r15 + 1;        r3[r15] = (byte) (r8 >> 2);     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00f7, code lost:            r3[r9] = (byte) (r8 >> 4);        r9 = r9 + 1;     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decode(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.Base64.decode(java.lang.String):byte[]");
    }

    public static byte[] encode(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = Encoder.ENCODE;
        int r2 = (length / 3) * 4;
        if (length % 3 > 0) {
            r2 += 4;
        }
        byte[] bArr3 = new byte[r2];
        int r3 = 0;
        int r0 = length + 0;
        int r5 = 0;
        int r6 = -1;
        while (true) {
            int r7 = r3 + 3;
            if (r7 > r0) {
                break;
            }
            int r32 = (bArr[r3 + 2] & 255) | ((bArr[r3] & 255) << 16) | ((bArr[r3 + 1] & 255) << 8);
            bArr3[r5] = bArr2[(r32 >> 18) & 63];
            bArr3[r5 + 1] = bArr2[(r32 >> 12) & 63];
            bArr3[r5 + 2] = bArr2[(r32 >> 6) & 63];
            bArr3[r5 + 3] = bArr2[r32 & 63];
            r5 += 4;
            r6--;
            if (r6 == 0) {
                bArr3[r5] = 10;
                r6 = 19;
                r5++;
            }
            r3 = r7;
        }
        int r4 = r3 + 0;
        if (r4 == r0 - 1) {
            int r11 = (bArr[r3] & 255) << 4;
            int r02 = r5 + 1;
            bArr3[r5] = bArr2[(r11 >> 6) & 63];
            int r33 = r02 + 1;
            bArr3[r02] = bArr2[r11 & 63];
            bArr3[r33] = 61;
            bArr3[r33 + 1] = 61;
        } else if (r4 == r0 - 2) {
            int r112 = ((bArr[r3 + 1] & 255) << 2) | ((bArr[r3] & 255) << 10);
            int r03 = r5 + 1;
            bArr3[r5] = bArr2[(r112 >> 12) & 63];
            int r34 = r03 + 1;
            bArr3[r03] = bArr2[(r112 >> 6) & 63];
            bArr3[r34] = bArr2[r112 & 63];
            bArr3[r34 + 1] = 61;
        }
        return bArr3;
    }
}
