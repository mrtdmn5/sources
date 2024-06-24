package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzoz implements zzoy {
    public static final zzhv zzb;
    public static final zzhv zze;
    public static final zzhv zzj;
    public static final zzhv zzk;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), true, true);
        zzhyVar.zzf("measurement.redaction.app_instance_id", true);
        zzb = zzhyVar.zzf("measurement.redaction.client_ephemeral_aiid_generation", true);
        zzhyVar.zzf("measurement.redaction.config_redacted_fields", true);
        zzhyVar.zzf("measurement.redaction.device_info", true);
        zze = zzhyVar.zzf("measurement.redaction.e_tag", true);
        zzhyVar.zzf("measurement.redaction.enhanced_uid", true);
        zzhyVar.zzf("measurement.redaction.populate_ephemeral_app_instance_id", true);
        zzhyVar.zzf("measurement.redaction.google_signals", true);
        zzhyVar.zzf("measurement.redaction.no_aiid_in_config_request", true);
        zzj = zzhyVar.zzf("measurement.redaction.retain_major_os_version", true);
        zzk = zzhyVar.zzf("measurement.redaction.scion_payload_generator", true);
        zzhyVar.zzf("measurement.redaction.upload_redacted_fields", true);
        zzhyVar.zzf("measurement.redaction.upload_subdomain_override", true);
        zzhyVar.zzf("measurement.redaction.user_id", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zzc() {
        return ((Boolean) zze.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zzd() {
        return ((Boolean) zzj.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final boolean zze() {
        return ((Boolean) zzk.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoy
    public final void zza() {
    }
}
