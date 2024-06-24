package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzoh implements zzog {
    public static final zzhv zza;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), false, true);
        zza = zzhyVar.zzf("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzhyVar.zzf("measurement.client.sessions.check_on_startup", true);
        zzhyVar.zzf("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzog
    public final void zza() {
    }
}
