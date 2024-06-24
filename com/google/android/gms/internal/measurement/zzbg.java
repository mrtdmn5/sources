package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzbg implements zzbf {
    public final zzg zza;
    public final String zzb;

    public zzbg(zzg zzgVar, String str) {
        this.zza = zzgVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzbf
    public final zzg zza(zzap zzapVar) {
        String str = this.zzb;
        zzg zzgVar = this.zza;
        zzgVar.zze(str, zzapVar);
        return zzgVar;
    }
}
