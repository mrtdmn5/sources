package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfb extends zzkf implements zzln {
    private static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzkm zzf = zzlv.zza;
    private boolean zzg;

    static {
        zzfb zzfbVar = new zzfb();
        zza = zzfbVar;
        zzkf.zzbL(zzfb.class, zzfbVar);
    }

    public final String zzb() {
        return this.zze;
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
                    return new zzfa();
                }
                return new zzfb();
            }
            return new zzlw(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        }
        return (byte) 1;
    }
}
