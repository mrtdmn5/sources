package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzna {
    public static boolean zzb(byte[] bArr, int r7, int r8) {
        int r72;
        while (r7 < r8 && bArr[r7] >= 0) {
            r7++;
        }
        if (r7 < r8) {
            while (r7 < r8) {
                int r1 = r7 + 1;
                r72 = bArr[r7];
                if (r72 < 0) {
                    if (r72 < -32) {
                        if (r1 < r8) {
                            if (r72 >= -62) {
                                r7 = r1 + 1;
                                if (bArr[r1] > -65) {
                                }
                            }
                            r72 = -1;
                            break;
                        }
                        break;
                    }
                    if (r72 < -16) {
                        if (r1 >= r8 - 1) {
                            r72 = zznd.zza(bArr, r1, r8);
                            break;
                        }
                        int r4 = r1 + 1;
                        byte b = bArr[r1];
                        if (b <= -65 && ((r72 != -32 || b >= -96) && (r72 != -19 || b < -96))) {
                            r7 = r4 + 1;
                            if (bArr[r4] > -65) {
                            }
                        }
                        r72 = -1;
                        break;
                    }
                    if (r1 >= r8 - 2) {
                        r72 = zznd.zza(bArr, r1, r8);
                        break;
                    }
                    int r2 = r1 + 1;
                    byte b2 = bArr[r1];
                    if (b2 <= -65) {
                        if ((((b2 + 112) + (r72 << 28)) >> 30) == 0) {
                            int r73 = r2 + 1;
                            if (bArr[r2] <= -65) {
                                r1 = r73 + 1;
                                if (bArr[r73] > -65) {
                                }
                            }
                        }
                    }
                    r72 = -1;
                    break;
                }
                r7 = r1;
            }
        }
        r72 = 0;
        if (r72 != 0) {
            return false;
        }
        return true;
    }
}
