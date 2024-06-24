package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzoq implements zzop {
    public static final zzhv zzc;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zzhyVar.zzd(0L, "measurement.id.lifecycle.app_in_background_parameter");
        zzhyVar.zzf("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zzhyVar.zzf("measurement.lifecycle.app_in_background_parameter", false);
        zzhyVar.zzd(0L, "measurement.id.lifecycle.app_backgrounded_tracking");
    }

    @Override // com.google.android.gms.internal.measurement.zzop
    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
