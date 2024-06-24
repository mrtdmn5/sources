package com.amazonaws.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public class BinaryUtils {
    private static final int FF_LOCATION = 6;
    private static final int HEX_LENGTH_8 = 8;
    private static final int HEX_PARSE_16 = 16;

    public static byte[] copyAllBytesFrom(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        if (byteBuffer.hasArray()) {
            return Arrays.copyOfRange(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit() + byteBuffer.arrayOffset());
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        asReadOnlyBuffer.rewind();
        byte[] bArr = new byte[asReadOnlyBuffer.remaining()];
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static byte[] fromBase64(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str);
    }

    public static byte[] fromHex(String str) {
        byte[] bArr = new byte[(str.length() + 1) / 2];
        int r1 = 0;
        int r2 = 0;
        while (r1 < str.length()) {
            int r3 = r1 + 2;
            bArr[r2] = (byte) Integer.parseInt(str.substring(r1, r3), 16);
            r1 = r3;
            r2++;
        }
        return bArr;
    }

    public static String toBase64(byte[] bArr) {
        return Base64.encodeAsString(bArr);
    }

    public static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            if (hexString.length() == 1) {
                sb.append("0");
            } else if (hexString.length() == 8) {
                hexString = hexString.substring(6);
            }
            sb.append(hexString);
        }
        return StringUtils.lowerCase(sb.toString());
    }

    public static InputStream toStream(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new ByteArrayInputStream(bArr);
    }
}
