package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zziv implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ zzjm zzc;

    public zziv(zzjm zzjmVar, zzq zzqVar, Bundle bundle) {
        this.zzc = zzjmVar;
        this.zza = zzqVar;
        this.zzb = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzq zzqVar = this.zza;
        zzjm zzjmVar = this.zzc;
        zzdx zzdxVar = zzjmVar.zzb;
        zzfr zzfrVar = zzjmVar.zzt;
        if (zzdxVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(zzqVar);
            zzdxVar.zzr(this.zzb, zzqVar);
        } catch (RemoteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e, "Failed to send default event parameters to service");
        }
    }
}
