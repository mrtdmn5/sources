package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbd implements zzbf {
    public final zzg zza;
    public final String zzb;

    public zzbd(zzg zzgVar, String str) {
        this.zza = zzgVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbf
    public final zzg zza(zzap zzapVar) {
        zzg zza = this.zza.zza();
        String str = this.zzb;
        zza.zze(str, zzapVar);
        zza.zzd.put(str, Boolean.TRUE);
        return zza;
    }
}
