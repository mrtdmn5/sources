package com.amazonaws.util;

/* loaded from: classes.dex */
public enum Base16 {
    ;

    private static final Base16Codec CODEC = new Base16Codec();

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length()];
        return CODEC.decode(bArr, CodecUtils.sanitize(str, bArr));
    }

    public static byte[] encode(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return CODEC.encode(bArr);
        }
        return bArr;
    }

    public static String encodeAsString(byte... bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        return CodecUtils.toStringDirect(CODEC.encode(bArr));
    }

    public static byte[] decode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : CODEC.decode(bArr, bArr.length);
    }
}
