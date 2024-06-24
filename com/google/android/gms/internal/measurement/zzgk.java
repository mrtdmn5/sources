package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgk extends zzkf implements zzln {
    private static final zzgk zza;
    private int zzd;
    private int zze;
    private zzkl zzf = zzlb.zza;

    static {
        zzgk zzgkVar = new zzgk();
        zza = zzgkVar;
        zzkf.zzbL(zzgk.class, zzgkVar);
    }

    public static zzgj zzd() {
        return (zzgj) zza.zzbx();
    }

    public static /* synthetic */ void zzg(zzgk zzgkVar, int r2) {
        zzgkVar.zzd |= 1;
        zzgkVar.zze = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void zzh(zzgk zzgkVar, List list) {
        zzkl zzklVar = zzgkVar.zzf;
        if (!((zzip) zzklVar).zza) {
            zzgkVar.zzf = zzkf.zzbD(zzklVar);
        }
        zzio.zzbt(list, zzgkVar.zzf);
    }

    public final int zza() {
        return this.zzf.size();
    }

    public final int zzb() {
        return this.zze;
    }

    public final long zzc(int r4) {
        zzlb zzlbVar = (zzlb) this.zzf;
        zzlbVar.zzi(r4);
        return zzlbVar.zzb[r4];
    }

    public final List zzf() {
        return this.zzf;
    }

    public final boolean zzi() {
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
                    return new zzgj(0);
                }
                return new zzgk();
            }
            return new zzlw(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzd", "zze", "zzf"});
        }
        return (byte) 1;
    }
}
