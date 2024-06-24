package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzio implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzkw zzc;
    public final /* synthetic */ zzjm zzd;

    public zzio(zzjm zzjmVar, zzq zzqVar, boolean z, zzkw zzkwVar) {
        this.zzd = zzjmVar;
        this.zza = zzqVar;
        this.zzb = z;
        this.zzc = zzkwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzkw zzkwVar;
        zzjm zzjmVar = this.zzd;
        zzdx zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzeh zzehVar = zzjmVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Failed to set user property");
            return;
        }
        zzq zzqVar = this.zza;
        Preconditions.checkNotNull(zzqVar);
        if (this.zzb) {
            zzkwVar = null;
        } else {
            zzkwVar = this.zzc;
        }
        zzjmVar.zzD(zzdxVar, zzkwVar, zzqVar);
        zzjmVar.zzQ();
    }
}
