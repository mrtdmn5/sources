package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zznv implements zznu {
    public static final zzhv zzb;
    public static final zzhv zzc;

    static {
        zzhy zzhyVar = new zzhy(zzhq.zza(), true, true);
        zzhyVar.zzf("measurement.collection.event_safelist", true);
        zzb = zzhyVar.zzf("measurement.service.store_null_safelist", true);
        zzc = zzhyVar.zzf("measurement.service.store_safelist", true);
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final boolean zzb() {
        return ((Boolean) zzb.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final boolean zzc() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zznu
    public final void zza() {
    }
}
