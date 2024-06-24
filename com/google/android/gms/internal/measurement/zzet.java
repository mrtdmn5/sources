package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzet extends zzkf implements zzln {
    private static final zzet zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzem zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzet zzetVar = new zzet();
        zza = zzetVar;
        zzkf.zzbL(zzet.class, zzetVar);
    }

    public static zzes zzc() {
        return (zzes) zza.zzbx();
    }

    public static /* synthetic */ void zzf(zzet zzetVar, String str) {
        zzetVar.zzd |= 2;
        zzetVar.zzf = str;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzem zzb() {
        zzem zzemVar = this.zzg;
        if (zzemVar == null) {
            return zzem.zzb();
        }
        return zzemVar;
    }

    public final String zze() {
        return this.zzf;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzk() {
        if ((this.zzd & 32) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r8) {
        int r82 = r8 - 1;
        if (r82 != 0) {
            if (r82 != 2) {
                if (r82 != 3) {
                    if (r82 != 4) {
                        if (r82 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzes(0);
                }
                return new zzet();
            }
            return new zzlw(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        return (byte) 1;
    }
}
