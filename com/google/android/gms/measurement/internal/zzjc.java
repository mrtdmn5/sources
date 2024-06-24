package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzjc implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzac zzc;
    public final /* synthetic */ zzjm zze;

    public zzjc(zzjm zzjmVar, zzq zzqVar, boolean z, zzac zzacVar) {
        this.zze = zzjmVar;
        this.zza = zzqVar;
        this.zzb = z;
        this.zzc = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzac zzacVar;
        zzjm zzjmVar = this.zze;
        zzdx zzdxVar = zzjmVar.zzb;
        if (zzdxVar == null) {
            zzeh zzehVar = zzjmVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        zzq zzqVar = this.zza;
        Preconditions.checkNotNull(zzqVar);
        if (this.zzb) {
            zzacVar = null;
        } else {
            zzacVar = this.zzc;
        }
        zzjmVar.zzD(zzdxVar, zzacVar, zzqVar);
        zzjmVar.zzQ();
    }
}
