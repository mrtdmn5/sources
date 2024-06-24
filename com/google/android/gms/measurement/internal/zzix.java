package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzix implements Runnable {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzcf zzc;
    public final /* synthetic */ zzjm zzd;

    public zzix(zzjm zzjmVar, zzaw zzawVar, String str, zzcf zzcfVar) {
        this.zzd = zzjmVar;
        this.zza = zzawVar;
        this.zzb = str;
        this.zzc = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlb zzlbVar;
        zzcf zzcfVar = this.zzc;
        zzjm zzjmVar = this.zzd;
        byte[] bArr = null;
        try {
            try {
                zzdx zzdxVar = zzjmVar.zzb;
                zzfr zzfrVar = zzjmVar.zzt;
                if (zzdxVar == null) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zza("Discarding data. Failed to send event to service to bundle");
                } else {
                    bArr = zzdxVar.zzu(this.zza, this.zzb);
                    zzjmVar.zzQ();
                }
                zzlbVar = zzfrVar.zzp;
            } catch (RemoteException e) {
                zzeh zzehVar2 = zzjmVar.zzt.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Failed to send event to the service to bundle");
                zzlbVar = zzjmVar.zzt.zzp;
            }
            zzfr.zzP(zzlbVar);
            zzlbVar.zzS(zzcfVar, bArr);
        } catch (Throwable th) {
            zzlb zzlbVar2 = zzjmVar.zzt.zzp;
            zzfr.zzP(zzlbVar2);
            zzlbVar2.zzS(zzcfVar, null);
            throw th;
        }
    }
}
