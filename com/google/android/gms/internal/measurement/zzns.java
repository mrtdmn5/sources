package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzns implements zznr {
    public static final zzhu zzd;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zzhyVar.zzf("measurement.client.consent_state_v1", true);
        zzhyVar.zzf("measurement.client.3p_consent_state_v1", true);
        zzhyVar.zzf("measurement.service.consent_state_v1_W36", true);
        zzd = zzhyVar.zzd(203600L, "measurement.service.storage_consent_support_version");
    }

    @Override // com.google.android.gms.internal.measurement.zznr
    public final long zza() {
        return ((Long) zzd.zzb()).longValue();
    }
}
