package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzld implements zzlk {
    public final zzlk[] zza;

    public zzld(zzlk... zzlkVarArr) {
        this.zza = zzlkVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlj zzb(Class cls) {
        for (int r0 = 0; r0 < 2; r0++) {
            zzlk zzlkVar = this.zza[r0];
            if (zzlkVar.zzc(cls)) {
                return zzlkVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc(Class cls) {
        for (int r1 = 0; r1 < 2; r1++) {
            if (this.zza[r1].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
