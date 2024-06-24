package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzgt extends zzkf implements zzln {
    private static final zzgt zza;
    private int zzd;
    private zzkm zze = zzlv.zza;
    private zzgp zzf;

    static {
        zzgt zzgtVar = new zzgt();
        zza = zzgtVar;
        zzkf.zzbL(zzgt.class, zzgtVar);
    }

    public final zzgp zza() {
        zzgp zzgpVar = this.zzf;
        if (zzgpVar == null) {
            return zzgp.zzc();
        }
        return zzgpVar;
    }

    public final zzkm zzc() {
        return this.zze;
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
                    return new zzgs();
                }
                return new zzgt();
            }
            return new zzlw(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzgy.class, "zzf"});
        }
        return (byte) 1;
    }
}
