package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgp extends zzkf implements zzln {
    private static final zzgp zza;
    private zzkm zzd = zzlv.zza;

    static {
        zzgp zzgpVar = new zzgp();
        zza = zzgpVar;
        zzkf.zzbL(zzgp.class, zzgpVar);
    }

    public static zzgp zzc() {
        return zza;
    }

    public final int zza() {
        return this.zzd.size();
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
                    return new zzgo();
                }
                return new zzgp();
            }
            return new zzlw(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzgr.class});
        }
        return (byte) 1;
    }
}
