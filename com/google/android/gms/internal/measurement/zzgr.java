package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgr extends zzkf implements zzln {
    private static final zzgr zza;
    private int zzd;
    private String zze = "";
    private zzkm zzf = zzlv.zza;

    static {
        zzgr zzgrVar = new zzgr();
        zza = zzgrVar;
        zzkf.zzbL(zzgr.class, zzgrVar);
    }

    public final String zzb() {
        return this.zze;
    }

    public final zzkm zzc() {
        return this.zzf;
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
                    return new zzgq();
                }
                return new zzgr();
            }
            return new zzlw(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zzd", "zze", "zzf", zzgy.class});
        }
        return (byte) 1;
    }
}
