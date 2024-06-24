package com.google.crypto.tink.subtle;

/* loaded from: classes3.dex */
public final class Hex {
    public static byte[] decode(String hex) {
        if (hex.length() % 2 == 0) {
            int length = hex.length() / 2;
            byte[] bArr = new byte[length];
            for (int r2 = 0; r2 < length; r2++) {
                int r3 = r2 * 2;
                int digit = Character.digit(hex.charAt(r3), 16);
                int digit2 = Character.digit(hex.charAt(r3 + 1), 16);
                if (digit != -1 && digit2 != -1) {
                    bArr[r2] = (byte) ((digit * 16) + digit2);
                } else {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    public static String encode(final byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            int r3 = b & 255;
            sb.append("0123456789abcdef".charAt(r3 / 16));
            sb.append("0123456789abcdef".charAt(r3 % 16));
        }
        return sb.toString();
    }
}
