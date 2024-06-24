package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzit implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzjm zzb;

    public zzit(zzjm zzjmVar, zzq zzqVar) {
        this.zzb = zzjmVar;
        this.zza = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.zza;
        zzjm zzjmVar = this.zzb;
        zzdx zzdxVar = zzjmVar.zzb;
        zzfr zzfrVar = zzjmVar.zzt;
        if (zzdxVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(zzqVar);
            zzdxVar.zzj(zzqVar);
            zzfrVar.zzi().zzm();
            zzjmVar.zzD(zzdxVar, null, zzqVar);
            zzjmVar.zzQ();
        } catch (RemoteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e, "Failed to send app launch to the service");
        }
    }
}
