package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzon implements zzom {
    public static final zzhv zzc;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zzhyVar.zzf("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzhyVar.zzf("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zzhyVar.zzf("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzhyVar.zzd(0L, "measurement.id.sdk.collection.last_deep_link_referrer2");
    }

    @Override // com.google.android.gms.internal.measurement.zzom
    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
