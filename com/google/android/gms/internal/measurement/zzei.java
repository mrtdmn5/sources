package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzei extends zzkf implements zzln {
    private static final zzei zza;
    private int zzd;
    private int zze;
    private zzkm zzf;
    private zzkm zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        zzei zzeiVar = new zzei();
        zza = zzeiVar;
        zzkf.zzbL(zzei.class, zzeiVar);
    }

    public zzei() {
        zzlv zzlvVar = zzlv.zza;
        this.zzf = zzlvVar;
        this.zzg = zzlvVar;
    }

    public static /* synthetic */ void zzi(zzei zzeiVar, int r3, zzet zzetVar) {
        zzkm zzkmVar = zzeiVar.zzf;
        if (!zzkmVar.zzc()) {
            zzeiVar.zzf = zzkf.zzbF(zzkmVar);
        }
        zzeiVar.zzf.set(r3, zzetVar);
    }

    public static /* synthetic */ void zzj(zzei zzeiVar, int r3, zzek zzekVar) {
        zzkm zzkmVar = zzeiVar.zzg;
        if (!zzkmVar.zzc()) {
            zzeiVar.zzg = zzkf.zzbF(zzkmVar);
        }
        zzeiVar.zzg.set(r3, zzekVar);
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzg.size();
    }

    public final int zzc() {
        return this.zzf.size();
    }

    public final zzek zze(int r2) {
        return (zzek) this.zzg.get(r2);
    }

    public final zzet zzf(int r2) {
        return (zzet) this.zzf.get(r2);
    }

    public final List zzg() {
        return this.zzg;
    }

    public final zzkm zzh() {
        return this.zzf;
    }

    public final boolean zzk() {
        if ((this.zzd & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkf
    public final Object zzl(int r9) {
        int r92 = r9 - 1;
        if (r92 != 0) {
            if (r92 != 2) {
                if (r92 != 3) {
                    if (r92 != 4) {
                        if (r92 != 5) {
                            return null;
                        }
                        return zza;
                    }
                    return new zzeh(0);
                }
                return new zzei();
            }
            return new zzlw(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzf", zzet.class, "zzg", zzek.class, "zzh", "zzi"});
        }
        return (byte) 1;
    }
}
