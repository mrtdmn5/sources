package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zziu implements Runnable {
    public final /* synthetic */ zzie zza;
    public final /* synthetic */ zzjm zzb;

    public zziu(zzjm zzjmVar, zzie zzieVar) {
        this.zzb = zzjmVar;
        this.zza = zzieVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjm zzjmVar = this.zzb;
        zzdx zzdxVar = zzjmVar.zzb;
        zzfr zzfrVar = zzjmVar.zzt;
        if (zzdxVar == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to send current screen to service");
            return;
        }
        try {
            zzie zzieVar = this.zza;
            if (zzieVar == null) {
                zzdxVar.zzq(0L, null, null, zzfrVar.zze.getPackageName());
            } else {
                zzdxVar.zzq(zzieVar.zzc, zzieVar.zza, zzieVar.zzb, zzfrVar.zze.getPackageName());
            }
            zzjmVar.zzQ();
        } catch (RemoteException e) {
            zzeh zzehVar2 = zzjmVar.zzt.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e, "Failed to send current screen to the service");
        }
    }
}
