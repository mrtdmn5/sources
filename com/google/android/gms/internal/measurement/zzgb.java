package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgb extends zzkf implements zzln {
    private static final zzgb zza;
    private zzkm zzd = zzlv.zza;

    static {
        zzgb zzgbVar = new zzgb();
        zza = zzgbVar;
        zzkf.zzbL(zzgb.class, zzgbVar);
    }

    public static zzga zza() {
        return (zzga) zza.zzbx();
    }

    public static /* synthetic */ void zze(zzgb zzgbVar, zzgd zzgdVar) {
        zzkm zzkmVar = zzgbVar.zzd;
        if (!zzkmVar.zzc()) {
            zzgbVar.zzd = zzkf.zzbF(zzkmVar);
        }
        zzgbVar.zzd.add(zzgdVar);
    }

    public final zzgd zzc() {
        return (zzgd) this.zzd.get(0);
    }

    public final zzkm zzd() {
        return this.zzd;
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
                    return new zzga(0);
                }
                return new zzgb();
            }
            return new zzlw(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgd.class});
        }
        return (byte) 1;
    }
}
