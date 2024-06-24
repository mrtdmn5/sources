package com.amazonaws.util;

/* loaded from: classes.dex */
public enum CodecUtils {
    ;

    public static int sanitize(String str, byte[] bArr) {
        int length = bArr.length;
        char[] charArray = str.toCharArray();
        int r3 = 0;
        for (int r2 = 0; r2 < length; r2++) {
            char c = charArray[r2];
            if (c != '\r' && c != '\n' && c != ' ') {
                if (c <= 127) {
                    bArr[r3] = (byte) c;
                    r3++;
                } else {
                    throw new IllegalArgumentException("Invalid character found at position " + r2 + " for " + str);
                }
            }
        }
        return r3;
    }

    public static void sanityCheckLastPos(int r0, int r1) {
        if ((r0 & r1) == 0) {
        } else {
            throw new IllegalArgumentException("Invalid last non-pad character detected");
        }
    }

    public static byte[] toBytesDirect(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int r3 = 0; r3 < length; r3++) {
            char c = charArray[r3];
            if (c <= 127) {
                bArr[r3] = (byte) c;
            } else {
                throw new IllegalArgumentException("Invalid character found at position " + r3 + " for " + str);
            }
        }
        return bArr;
    }

    public static String toStringDirect(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int r2 = 0;
        int r3 = 0;
        while (r2 < length) {
            cArr[r3] = (char) bArr[r2];
            r2++;
            r3++;
        }
        return new String(cArr);
    }
}
