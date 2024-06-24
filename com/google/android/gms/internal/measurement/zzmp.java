package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzmp {
    public static final zzmp zza = new zzmp(0, new int[0], new Object[0], false);
    public int zzb;
    public int[] zzc;
    public Object[] zzd;
    public int zze;
    public boolean zzf;

    public zzmp(int r2, int[] r3, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = r2;
        this.zzc = r3;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzmp zzf() {
        return new zzmp(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzmp)) {
            return false;
        }
        zzmp zzmpVar = (zzmp) obj;
        int r2 = this.zzb;
        if (r2 == zzmpVar.zzb) {
            int[] r3 = this.zzc;
            int[] r4 = zzmpVar.zzc;
            int r5 = 0;
            while (true) {
                if (r5 < r2) {
                    if (r3[r5] != r4[r5]) {
                        break;
                    }
                    r5++;
                } else {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzmpVar.zzd;
                    int r32 = this.zzb;
                    for (int r42 = 0; r42 < r32; r42++) {
                        if (objArr[r42].equals(objArr2[r42])) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int r0 = this.zzb;
        int r1 = (r0 + 527) * 31;
        int[] r2 = this.zzc;
        int r3 = 17;
        int r6 = 17;
        for (int r5 = 0; r5 < r0; r5++) {
            r6 = (r6 * 31) + r2[r5];
        }
        int r12 = (r1 + r6) * 31;
        Object[] objArr = this.zzd;
        int r22 = this.zzb;
        for (int r4 = 0; r4 < r22; r4++) {
            r3 = (r3 * 31) + objArr[r4].hashCode();
        }
        return r12 + r3;
    }

    public final int zza() {
        int zzA;
        int zzB;
        int zzA2;
        int r0 = this.zze;
        if (r0 == -1) {
            int r1 = 0;
            for (int r02 = 0; r02 < this.zzb; r02++) {
                int r2 = this.zzc[r02];
                int r3 = r2 >>> 3;
                int r22 = r2 & 7;
                if (r22 != 0) {
                    if (r22 != 1) {
                        if (r22 != 2) {
                            if (r22 != 3) {
                                if (r22 == 5) {
                                    ((Integer) this.zzd[r02]).intValue();
                                    zzA2 = zzjm.zzA(r3 << 3) + 4;
                                } else {
                                    int r12 = zzkp.$r8$clinit;
                                    throw new IllegalStateException(new zzko());
                                }
                            } else {
                                int zzz = zzjm.zzz(r3);
                                zzA = zzz + zzz;
                                zzB = ((zzmp) this.zzd[r02]).zza();
                            }
                        } else {
                            zzje zzjeVar = (zzje) this.zzd[r02];
                            int zzA3 = zzjm.zzA(r3 << 3);
                            int zzd = zzjeVar.zzd();
                            r1 = zzjm.zzA(zzd) + zzd + zzA3 + r1;
                        }
                    } else {
                        ((Long) this.zzd[r02]).longValue();
                        zzA2 = zzjm.zzA(r3 << 3) + 8;
                    }
                    r1 = zzA2 + r1;
                } else {
                    long longValue = ((Long) this.zzd[r02]).longValue();
                    zzA = zzjm.zzA(r3 << 3);
                    zzB = zzjm.zzB(longValue);
                }
                r1 = zzB + zzA + r1;
            }
            this.zze = r1;
            return r1;
        }
        return r0;
    }

    public final void zzj(int r3, Object obj) {
        if (this.zzf) {
            zzl(this.zzb + 1);
            int[] r0 = this.zzc;
            int r1 = this.zzb;
            r0[r1] = r3;
            this.zzd[r1] = obj;
            this.zzb = r1 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzk(zzjn zzjnVar) throws IOException {
        if (this.zzb != 0) {
            for (int r0 = 0; r0 < this.zzb; r0++) {
                int r1 = this.zzc[r0];
                Object obj = this.zzd[r0];
                int r3 = r1 >>> 3;
                int r12 = r1 & 7;
                if (r12 != 0) {
                    if (r12 != 1) {
                        if (r12 != 2) {
                            if (r12 != 3) {
                                if (r12 == 5) {
                                    zzjnVar.zzk(r3, ((Integer) obj).intValue());
                                } else {
                                    int r02 = zzkp.$r8$clinit;
                                    throw new RuntimeException(new zzko());
                                }
                            } else {
                                zzjnVar.zza.zzo(r3, 3);
                                ((zzmp) obj).zzk(zzjnVar);
                                zzjnVar.zza.zzo(r3, 4);
                            }
                        } else {
                            zzjnVar.zzd(r3, (zzje) obj);
                        }
                    } else {
                        zzjnVar.zzm(r3, ((Long) obj).longValue());
                    }
                } else {
                    zzjnVar.zzt(r3, ((Long) obj).longValue());
                }
            }
        }
    }

    public final void zzl(int r4) {
        int[] r0 = this.zzc;
        if (r4 > r0.length) {
            int r1 = this.zzb;
            int r2 = (r1 / 2) + r1;
            if (r2 >= r4) {
                r4 = r2;
            }
            if (r4 < 8) {
                r4 = 8;
            }
            this.zzc = Arrays.copyOf(r0, r4);
            this.zzd = Arrays.copyOf(this.zzd, r4);
        }
    }

    public zzmp() {
        this(0, new int[8], new Object[8], true);
    }
}
