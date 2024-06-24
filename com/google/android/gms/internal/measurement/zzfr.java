package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfr extends zzkf implements zzln {
    private static final zzfr zza;
    private int zzd;
    private int zze;
    private long zzf;

    static {
        zzfr zzfrVar = new zzfr();
        zza = zzfrVar;
        zzkf.zzbL(zzfr.class, zzfrVar);
    }

    public static zzfq zzc() {
        return (zzfq) zza.zzbx();
    }

    public static /* synthetic */ void zze(zzfr zzfrVar, int r2) {
        zzfrVar.zzd |= 1;
        zzfrVar.zze = r2;
    }

    public static /* synthetic */ void zzf(zzfr zzfrVar, long j) {
        zzfrVar.zzd |= 2;
        zzfrVar.zzf = j;
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzg() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r4) {
        int r42 = r4 - 1;
        if (r42 != 0) {
            if (r42 != 2) {
                if (r42 != 3) {
                    if (r42 != 4) {
                        if (r42 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzfq(0);
                }
                return new zzfr();
            }
            return new zzlw(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
