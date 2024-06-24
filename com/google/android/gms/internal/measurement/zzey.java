package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzey extends zzkf implements zzln {
    private static final zzey zza;
    private int zzd;
    private int zze;
    private boolean zzg;
    private String zzf = "";
    private zzkm zzh = zzlv.zza;

    static {
        zzey zzeyVar = new zzey();
        zza = zzeyVar;
        zzkf.zzbL(zzey.class, zzeyVar);
    }

    public static zzey zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzh.size();
    }

    public final String zzd() {
        return this.zzf;
    }

    public final zzkm zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        if ((this.zzd & 4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzh() {
        if ((this.zzd & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzi() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    public final int zzj() {
        int zza2 = zzex.zza(this.zze);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r7) {
        int r72 = r7 - 1;
        if (r72 != 0) {
            if (r72 != 2) {
                if (r72 != 3) {
                    if (r72 != 4) {
                        if (r72 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzeu();
                }
                return new zzey();
            }
            return new zzlw(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzd", "zze", zzew.zza, "zzf", "zzg", "zzh"});
        }
        return (byte) 1;
    }
}
