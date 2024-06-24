package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzpf implements zzpe {
    public static final zzhv zza;
    public static final zzhv zzb;
    public static final zzhv zzc;
    public static final zzhv zzd;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), true, true);
        zza = zzhyVar.zzf("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zzhyVar.zzf("measurement.session_stitching_token_enabled", false);
        zzc = zzhyVar.zzf("measurement.collection.enable_session_stitching_token.service", false);
        zzd = zzhyVar.zzf("measurement.collection.enable_session_stitching_token.service_new", true);
        zzhyVar.zzd(0L, "measurement.id.collection.enable_session_stitching_token.client.dev");
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzc() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zzd() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final boolean zze() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzpe
    public final void zza() {
    }
}
