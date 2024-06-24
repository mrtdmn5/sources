package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzky extends zzla {
    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zza(long j, Object obj) {
        ((zzkm) zzmy.zzf(j, obj)).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzla
    public final void zzb(long j, Object obj, Object obj2) {
        zzkm zzkmVar = (zzkm) zzmy.zzf(j, obj);
        zzkm zzkmVar2 = (zzkm) zzmy.zzf(j, obj2);
        int size = zzkmVar.size();
        int size2 = zzkmVar2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkmVar.zzc()) {
                zzkmVar = zzkmVar.zzd(size2 + size);
            }
            zzkmVar.addAll(zzkmVar2);
        }
        if (size > 0) {
            zzkmVar2 = zzkmVar;
        }
        zzmy.zzs(j, obj, zzkmVar2);
    }
}
