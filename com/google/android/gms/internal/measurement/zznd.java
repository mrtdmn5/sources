package com.google.android.gms.internal.measurement;

import com.animaconnected.dfu.dfu.utils.DfuConstants;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zznd {
    public static final zznb zza;

    static {
        if (zzmy.zzh && zzmy.zzg) {
            int r0 = zziq.$r8$clinit;
        }
        zza = new zznb();
    }

    public static /* bridge */ /* synthetic */ int zza(byte[] bArr, int r7, int r8) {
        byte b = bArr[r7 - 1];
        int r82 = r8 - r7;
        if (r82 != 0) {
            if (r82 != 1) {
                if (r82 == 2) {
                    byte b2 = bArr[r7];
                    byte b3 = bArr[r7 + 1];
                    if (b <= -12 && b2 <= -65 && b3 <= -65) {
                        return ((b2 << 8) ^ b) ^ (b3 << DfuConstants.OpResponse);
                    }
                } else {
                    throw new AssertionError();
                }
            } else {
                byte b4 = bArr[r7];
                if (b <= -12 && b4 <= -65) {
                    return b ^ (b4 << 8);
                }
            }
        } else if (b <= -12) {
            return b;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00fb, code lost:            return r9 + r0;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzb(java.lang.CharSequence r7, byte[] r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zznd.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    public static int zzc(CharSequence charSequence) {
        int length = charSequence.length();
        int r1 = 0;
        int r2 = 0;
        while (r2 < length && charSequence.charAt(r2) < 128) {
            r2++;
        }
        int r3 = length;
        while (true) {
            if (r2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(r2);
            if (charAt < 2048) {
                r3 += (127 - charAt) >>> 31;
                r2++;
            } else {
                int length2 = charSequence.length();
                while (r2 < length2) {
                    char charAt2 = charSequence.charAt(r2);
                    if (charAt2 < 2048) {
                        r1 += (127 - charAt2) >>> 31;
                    } else {
                        r1 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, r2) >= 65536) {
                                r2++;
                            } else {
                                throw new zznc(r2, length2);
                            }
                        }
                    }
                    r2++;
                }
                r3 += r1;
            }
        }
        if (r3 >= length) {
            return r3;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (r3 + 4294967296L));
    }

    public static boolean zzf(byte[] bArr, int r2, int r3) {
        zza.getClass();
        return zzna.zzb(bArr, r2, r3);
    }
}
