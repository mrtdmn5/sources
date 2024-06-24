package com.animaconnected.dfu.fota.utils;

/* loaded from: classes.dex */
public class FotaUtilities {
    public static byte[] addtoArray(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }
}
