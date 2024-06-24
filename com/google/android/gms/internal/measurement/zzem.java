package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzem extends zzkf implements zzln {
    private static final zzem zza;
    private int zzd;
    private zzey zze;
    private zzer zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzem zzemVar = new zzem();
        zza = zzemVar;
        zzkf.zzbL(zzem.class, zzemVar);
    }

    public static zzem zzb() {
        return zza;
    }

    public static /* synthetic */ void zzf(zzem zzemVar, String str) {
        zzemVar.zzd |= 8;
        zzemVar.zzh = str;
    }

    public final zzer zzc() {
        zzer zzerVar = this.zzf;
        if (zzerVar == null) {
            return zzer.zzb();
        }
        return zzerVar;
    }

    public final zzey zzd() {
        zzey zzeyVar = this.zze;
        if (zzeyVar == null) {
            return zzey.zzc();
        }
        return zzeyVar;
    }

    public final String zze() {
        return this.zzh;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final boolean zzh() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzj() {
        if ((this.zzd & 8) != 0) {
            return true;
        }
        return false;
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
                    return new zzel(0);
                }
                return new zzem();
            }
            return new zzlw(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
