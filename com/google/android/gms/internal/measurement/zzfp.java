package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfp extends zzkf implements zzln {
    private static final zzfp zza;
    private int zzd;
    private int zze;
    private zzgi zzf;
    private zzgi zzg;
    private boolean zzh;

    static {
        zzfp zzfpVar = new zzfp();
        zza = zzfpVar;
        zzkf.zzbL(zzfp.class, zzfpVar);
    }

    public static zzfo zzb$1() {
        return (zzfo) zza.zzbx();
    }

    public static /* synthetic */ void zzf(zzfp zzfpVar, int r2) {
        zzfpVar.zzd |= 1;
        zzfpVar.zze = r2;
    }

    public static /* synthetic */ void zzg(zzfp zzfpVar, zzgi zzgiVar) {
        zzfpVar.zzf = zzgiVar;
        zzfpVar.zzd |= 2;
    }

    public static /* synthetic */ void zzh(zzfp zzfpVar, zzgi zzgiVar) {
        zzfpVar.zzg = zzgiVar;
        zzfpVar.zzd |= 4;
    }

    public static /* synthetic */ void zzi(zzfp zzfpVar, boolean z) {
        zzfpVar.zzd |= 8;
        zzfpVar.zzh = z;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzgi zzd() {
        zzgi zzgiVar = this.zzf;
        if (zzgiVar == null) {
            return zzgi.zzh();
        }
        return zzgiVar;
    }

    public final zzgi zze() {
        zzgi zzgiVar = this.zzg;
        if (zzgiVar == null) {
            return zzgi.zzh();
        }
        return zzgiVar;
    }

    public final boolean zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r5) {
        int r52 = r5 - 1;
        if (r52 != 0) {
            if (r52 != 2) {
                if (r52 != 3) {
                    if (r52 != 4) {
                        if (r52 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzfo(0);
                }
                return new zzfp();
            }
            return new zzlw(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }

    public final boolean zzm() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzn() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }
}
