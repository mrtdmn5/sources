package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzok implements zzoj {
    public static final zzhv zzc;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), true, true);
        zzhyVar.zzf("measurement.client.global_params", true);
        zzhyVar.zzf("measurement.service.global_params_in_payload", true);
        zzc = zzhyVar.zzf("measurement.service.clear_global_params_on_uninstall", true);
        zzhyVar.zzf("measurement.service.global_params", true);
        zzhyVar.zzd(0L, "measurement.id.service.global_params");
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final boolean zzb() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoj
    public final void zza() {
    }
}
