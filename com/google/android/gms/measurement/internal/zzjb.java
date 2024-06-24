package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjb implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzaw zzc;
    public final /* synthetic */ zzjm zze;

    public zzjb(zzjm zzjmVar, zzq zzqVar, boolean z, zzaw zzawVar) {
        this.zze = zzjmVar;
        this.zza = zzqVar;
        this.zzb = z;
        this.zzc = zzawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaw zzawVar;
        zzjm zzjmVar = this.zze;
        zzdx zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzeh zzehVar = zzjmVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Failed to send event to service");
            return;
        }
        zzq zzqVar = this.zza;
        Preconditions.checkNotNull(zzqVar);
        if (this.zzb) {
            zzawVar = null;
        } else {
            zzawVar = this.zzc;
        }
        zzjmVar.zzD(zzdxVar, zzawVar, zzqVar);
        zzjmVar.zzQ();
    }
}
