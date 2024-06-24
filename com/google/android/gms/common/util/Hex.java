package com.google.android.gms.common.util;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Hex {
    public static final char[] zza = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final char[] zzb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String bytesToStringUppercase(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (int r2 = 0; r2 < length; r2++) {
            char[] cArr = zza;
            sb.append(cArr[(bArr[r2] & 240) >>> 4]);
            sb.append(cArr[bArr[r2] & 15]);
        }
        return sb.toString();
    }
}
