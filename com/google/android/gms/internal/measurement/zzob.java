package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzob implements zzoa {
    public static final zzhv zzb;
    public static final zzhv zzc;
    public static final zzhv zzd;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zzhyVar.zzf("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        zzb = zzhyVar.zzf("measurement.audience.refresh_event_count_filters_timestamp", false);
        zzc = zzhyVar.zzf("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        zzd = zzhyVar.zzf("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final boolean zzd() {
        return ((Boolean) zzd.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzoa
    public final void zza() {
    }
}
