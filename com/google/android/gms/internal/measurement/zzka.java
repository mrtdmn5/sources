package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzka implements zzlk {
    public static final zzka zza = new zzka();

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlj zzb(Class cls) {
        if (zzkf.class.isAssignableFrom(cls)) {
            try {
                return (zzlj) zzkf.zzbz(cls.asSubclass(zzkf.class)).zzl(3);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc(Class cls) {
        return zzkf.class.isAssignableFrom(cls);
    }
}
