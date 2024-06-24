package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgy extends zzkf implements zzln {
    private static final zzgy zza;
    private int zzd;
    private int zze;
    private zzkm zzf = zzlv.zza;
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzgy zzgyVar = new zzgy();
        zza = zzgyVar;
        zzkf.zzbL(zzgy.class, zzgyVar);
    }

    public final double zza() {
        return this.zzj;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final String zzd() {
        return this.zzh;
    }

    public final zzkm zze() {
        return this.zzf;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if ((this.zzd & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final int zzj() {
        int r2;
        int r0 = this.zze;
        if (r0 != 0) {
            r2 = 2;
            if (r0 != 1) {
                if (r0 != 2) {
                    r2 = 4;
                    if (r0 != 3) {
                        if (r0 != 4) {
                            r2 = 0;
                        } else {
                            r2 = 5;
                        }
                    }
                } else {
                    r2 = 3;
                }
            }
        } else {
            r2 = 1;
        }
        if (r2 == 0) {
            return 1;
        }
        return r2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r10) {
        int r102 = r10 - 1;
        if (r102 != 0) {
            if (r102 != 2) {
                if (r102 != 3) {
                    if (r102 != 4) {
                        if (r102 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzgu();
                }
                return new zzgy();
            }
            return new zzlw(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzd", "zze", zzgw.zza, "zzf", zzgy.class, "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
