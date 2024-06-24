package com.google.android.gms.internal.measurement;

import com.animaconnected.secondo.R;
import java.io.IOException;
import kotlinx.serialization.json.JvmStreamsKt;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzis {
    public static int zza(byte[] bArr, int r3, zzir zzirVar) throws zzkp {
        int zzj = zzj(bArr, r3, zzirVar);
        int r0 = zzirVar.zza;
        if (r0 >= 0) {
            if (r0 <= bArr.length - zzj) {
                if (r0 == 0) {
                    zzirVar.zzc = zzje.zzb;
                    return zzj;
                }
                zzirVar.zzc = zzje.zzl(bArr, zzj, r0);
                return zzj + r0;
            }
            throw zzkp.zzf();
        }
        throw zzkp.zzd();
    }

    public static int zzb(int r2, byte[] bArr) {
        return ((bArr[r2 + 3] & 255) << 24) | (bArr[r2] & 255) | ((bArr[r2 + 1] & 255) << 8) | ((bArr[r2 + 2] & 255) << 16);
    }

    public static int zzc(zzlx zzlxVar, byte[] bArr, int r10, int r11, int r12, zzir zzirVar) throws IOException {
        zzkf zze = zzlxVar.zze();
        int zzn = zzn(zze, zzlxVar, bArr, r10, r11, r12, zzirVar);
        zzlxVar.zzf(zze);
        zzirVar.zzc = zze;
        return zzn;
    }

    public static int zze(zzlx zzlxVar, int r8, byte[] bArr, int r10, int r11, zzkm zzkmVar, zzir zzirVar) throws IOException {
        zzkf zze = zzlxVar.zze();
        int zzo = zzo(zze, zzlxVar, bArr, r10, r11, zzirVar);
        zzlxVar.zzf(zze);
        zzirVar.zzc = zze;
        zzkmVar.add(zze);
        while (zzo < r11) {
            int zzj = zzj(bArr, zzo, zzirVar);
            if (r8 != zzirVar.zza) {
                break;
            }
            zzkf zze2 = zzlxVar.zze();
            int zzo2 = zzo(zze2, zzlxVar, bArr, zzj, r11, zzirVar);
            zzlxVar.zzf(zze2);
            zzirVar.zzc = zze2;
            zzkmVar.add(zze2);
            zzo = zzo2;
        }
        return zzo;
    }

    public static int zzf(byte[] bArr, int r3, zzkm zzkmVar, zzir zzirVar) throws IOException {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int zzj = zzj(bArr, r3, zzirVar);
        int r0 = zzirVar.zza + zzj;
        while (zzj < r0) {
            zzj = zzj(bArr, zzj, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        if (zzj == r0) {
            return zzj;
        }
        throw zzkp.zzf();
    }

    public static int zzg(byte[] bArr, int r4, zzir zzirVar) throws zzkp {
        int zzj = zzj(bArr, r4, zzirVar);
        int r0 = zzirVar.zza;
        if (r0 >= 0) {
            if (r0 == 0) {
                zzirVar.zzc = "";
                return zzj;
            }
            zzirVar.zzc = new String(bArr, zzj, r0, zzkn.zzb);
            return zzj + r0;
        }
        throw zzkp.zzd();
    }

    public static int zzh(byte[] bArr, int r12, zzir zzirVar) throws zzkp {
        boolean z;
        boolean z2;
        boolean z3;
        int zzj = zzj(bArr, r12, zzirVar);
        int r0 = zzirVar.zza;
        if (r0 >= 0) {
            if (r0 == 0) {
                zzirVar.zzc = "";
                return zzj;
            }
            zznb zznbVar = zznd.zza;
            int length = bArr.length;
            if ((zzj | r0 | ((length - zzj) - r0)) >= 0) {
                int r1 = zzj + r0;
                char[] cArr = new char[r0];
                int r3 = 0;
                while (zzj < r1) {
                    byte b = bArr[zzj];
                    if (b >= 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        break;
                    }
                    zzj++;
                    cArr[r3] = (char) b;
                    r3++;
                }
                while (zzj < r1) {
                    int r5 = zzj + 1;
                    byte b2 = bArr[zzj];
                    if (b2 >= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        int r6 = r3 + 1;
                        cArr[r3] = (char) b2;
                        zzj = r5;
                        while (true) {
                            r3 = r6;
                            if (zzj >= r1) {
                                break;
                            }
                            byte b3 = bArr[zzj];
                            if (b3 >= 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                break;
                            }
                            zzj++;
                            r6 = r3 + 1;
                            cArr[r3] = (char) b3;
                        }
                    } else if (b2 < -32) {
                        if (r5 < r1) {
                            int r62 = r5 + 1;
                            int r7 = r3 + 1;
                            byte b4 = bArr[r5];
                            if (b2 >= -62 && !JvmStreamsKt.zze(b4)) {
                                cArr[r3] = (char) (((b2 & 31) << 6) | (b4 & 63));
                                zzj = r62;
                                r3 = r7;
                            } else {
                                throw zzkp.zzc();
                            }
                        } else {
                            throw zzkp.zzc();
                        }
                    } else {
                        if (b2 < -16) {
                            if (r5 < r1 - 1) {
                                int r72 = r5 + 1;
                                int r8 = r72 + 1;
                                int r9 = r3 + 1;
                                byte b5 = bArr[r5];
                                byte b6 = bArr[r72];
                                if (!JvmStreamsKt.zze(b5)) {
                                    if (b2 == -32) {
                                        if (b5 >= -96) {
                                            b2 = -32;
                                        }
                                    }
                                    if (b2 == -19) {
                                        if (b5 < -96) {
                                            b2 = -19;
                                        }
                                    }
                                    if (!JvmStreamsKt.zze(b6)) {
                                        cArr[r3] = (char) (((b2 & 15) << 12) | ((b5 & 63) << 6) | (b6 & 63));
                                        zzj = r8;
                                        r3 = r9;
                                    }
                                }
                                throw zzkp.zzc();
                            }
                            throw zzkp.zzc();
                        }
                        if (r5 < r1 - 2) {
                            int r63 = r5 + 1;
                            int r73 = r63 + 1;
                            int r82 = r73 + 1;
                            byte b7 = bArr[r5];
                            byte b8 = bArr[r63];
                            byte b9 = bArr[r73];
                            if (!JvmStreamsKt.zze(b7)) {
                                if ((((b7 + 112) + (b2 << 28)) >> 30) == 0 && !JvmStreamsKt.zze(b8) && !JvmStreamsKt.zze(b9)) {
                                    int r122 = ((b2 & 7) << 18) | ((b7 & 63) << 12) | ((b8 & 63) << 6) | (b9 & 63);
                                    cArr[r3] = (char) ((r122 >>> 10) + 55232);
                                    cArr[r3 + 1] = (char) ((r122 & 1023) + 56320);
                                    r3 += 2;
                                    zzj = r82;
                                }
                            }
                            throw zzkp.zzc();
                        }
                        throw zzkp.zzc();
                    }
                }
                zzirVar.zzc = new String(cArr, 0, r3);
                return r1;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzj), Integer.valueOf(r0)));
        }
        throw zzkp.zzd();
    }

    public static int zzi(int r9, byte[] bArr, int r11, int r12, zzmp zzmpVar, zzir zzirVar) throws zzkp {
        if ((r9 >>> 3) != 0) {
            int r0 = r9 & 7;
            if (r0 != 0) {
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 != 3) {
                            if (r0 == 5) {
                                zzmpVar.zzj(r9, Integer.valueOf(zzb(r11, bArr)));
                                return r11 + 4;
                            }
                            throw new zzkp("Protocol message contained an invalid tag (zero).");
                        }
                        int r02 = (r9 & (-8)) | 4;
                        zzmp zzf = zzmp.zzf();
                        int r1 = 0;
                        while (true) {
                            if (r11 >= r12) {
                                break;
                            }
                            int zzj = zzj(bArr, r11, zzirVar);
                            int r112 = zzirVar.zza;
                            if (r112 == r02) {
                                r1 = r112;
                                r11 = zzj;
                                break;
                            }
                            r1 = r112;
                            r11 = zzi(r112, bArr, zzj, r12, zzf, zzirVar);
                        }
                        if (r11 <= r12 && r1 == r02) {
                            zzmpVar.zzj(r9, zzf);
                            return r11;
                        }
                        throw zzkp.zze();
                    }
                    int zzj2 = zzj(bArr, r11, zzirVar);
                    int r122 = zzirVar.zza;
                    if (r122 >= 0) {
                        if (r122 <= bArr.length - zzj2) {
                            if (r122 == 0) {
                                zzmpVar.zzj(r9, zzje.zzb);
                            } else {
                                zzmpVar.zzj(r9, zzje.zzl(bArr, zzj2, r122));
                            }
                            return zzj2 + r122;
                        }
                        throw zzkp.zzf();
                    }
                    throw zzkp.zzd();
                }
                zzmpVar.zzj(r9, Long.valueOf(zzp(r11, bArr)));
                return r11 + 8;
            }
            int zzm = zzm(bArr, r11, zzirVar);
            zzmpVar.zzj(r9, Long.valueOf(zzirVar.zzb));
            return zzm;
        }
        throw new zzkp("Protocol message contained an invalid tag (zero).");
    }

    public static int zzj(byte[] bArr, int r2, zzir zzirVar) {
        int r0 = r2 + 1;
        byte b = bArr[r2];
        if (b >= 0) {
            zzirVar.zza = b;
            return r0;
        }
        return zzk(b, bArr, r0, zzirVar);
    }

    public static int zzk(int r1, byte[] bArr, int r3, zzir zzirVar) {
        int r12 = r1 & R.styleable.AppTheme_statusTextH5;
        int r0 = r3 + 1;
        byte b = bArr[r3];
        if (b >= 0) {
            zzirVar.zza = r12 | (b << 7);
            return r0;
        }
        int r13 = r12 | ((b & Byte.MAX_VALUE) << 7);
        int r32 = r0 + 1;
        byte b2 = bArr[r0];
        if (b2 >= 0) {
            zzirVar.zza = r13 | (b2 << 14);
            return r32;
        }
        int r14 = r13 | ((b2 & Byte.MAX_VALUE) << 14);
        int r02 = r32 + 1;
        byte b3 = bArr[r32];
        if (b3 >= 0) {
            zzirVar.zza = r14 | (b3 << 21);
            return r02;
        }
        int r15 = r14 | ((b3 & Byte.MAX_VALUE) << 21);
        int r33 = r02 + 1;
        byte b4 = bArr[r02];
        if (b4 >= 0) {
            zzirVar.zza = r15 | (b4 << 28);
            return r33;
        }
        int r16 = r15 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int r03 = r33 + 1;
            if (bArr[r33] < 0) {
                r33 = r03;
            } else {
                zzirVar.zza = r16;
                return r03;
            }
        }
    }

    public static int zzl(int r2, byte[] bArr, int r4, int r5, zzkm zzkmVar, zzir zzirVar) {
        zzkg zzkgVar = (zzkg) zzkmVar;
        int zzj = zzj(bArr, r4, zzirVar);
        zzkgVar.zzh(zzirVar.zza);
        while (zzj < r5) {
            int zzj2 = zzj(bArr, zzj, zzirVar);
            if (r2 != zzirVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzirVar);
            zzkgVar.zzh(zzirVar.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int r10, zzir zzirVar) {
        int r0 = r10 + 1;
        long j = bArr[r10];
        if (j >= 0) {
            zzirVar.zzb = j;
            return r0;
        }
        int r102 = r0 + 1;
        byte b = bArr[r0];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int r3 = 7;
        while (b < 0) {
            int r02 = r102 + 1;
            r3 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << r3;
            b = bArr[r102];
            r102 = r02;
        }
        zzirVar.zzb = j2;
        return r102;
    }

    public static int zzn(Object obj, zzlx zzlxVar, byte[] bArr, int r10, int r11, int r12, zzir zzirVar) throws IOException {
        int zzc = ((zzlp) zzlxVar).zzc(obj, bArr, r10, r11, r12, zzirVar);
        zzirVar.zzc = obj;
        return zzc;
    }

    public static int zzo(Object obj, zzlx zzlxVar, byte[] bArr, int r9, int r10, zzir zzirVar) throws IOException {
        int r0 = r9 + 1;
        int r92 = bArr[r9];
        if (r92 < 0) {
            r0 = zzk(r92, bArr, r0, zzirVar);
            r92 = zzirVar.zza;
        }
        int r3 = r0;
        if (r92 >= 0 && r92 <= r10 - r3) {
            int r93 = r92 + r3;
            zzlxVar.zzh(obj, bArr, r3, r93, zzirVar);
            zzirVar.zzc = obj;
            return r93;
        }
        throw zzkp.zzf();
    }

    public static long zzp(int r7, byte[] bArr) {
        return ((bArr[r7 + 7] & 255) << 56) | (bArr[r7] & 255) | ((bArr[r7 + 1] & 255) << 8) | ((bArr[r7 + 2] & 255) << 16) | ((bArr[r7 + 3] & 255) << 24) | ((bArr[r7 + 4] & 255) << 32) | ((bArr[r7 + 5] & 255) << 40) | ((bArr[r7 + 6] & 255) << 48);
    }
}
