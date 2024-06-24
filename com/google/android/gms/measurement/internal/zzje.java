package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzje implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzq zzc;
    public final /* synthetic */ zzcf zzd;
    public final /* synthetic */ zzjm zze;

    public zzje(zzjm zzjmVar, String str, String str2, zzq zzqVar, zzcf zzcfVar) {
        this.zze = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlb zzlbVar;
        zzq zzqVar = this.zzc;
        String str = this.zzb;
        String str2 = this.zza;
        zzcf zzcfVar = this.zzd;
        zzjm zzjmVar = this.zze;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zzdx zzdxVar = zzjmVar.zzb;
                zzfr zzfrVar = zzjmVar.zzt;
                if (zzdxVar == null) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzc(str2, str, "Failed to get conditional properties; not connected to service");
                } else {
                    Preconditions.checkNotNull(zzqVar);
                    arrayList = zzlb.zzH(zzdxVar.zzf(str2, str, zzqVar));
                    zzjmVar.zzQ();
                }
                zzlbVar = zzfrVar.zzp;
            } catch (RemoteException e) {
                zzeh zzehVar2 = zzjmVar.zzt.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzd("Failed to get conditional properties; remote exception", str2, str, e);
                zzlbVar = zzjmVar.zzt.zzp;
            }
            zzfr.zzP(zzlbVar);
            zzlbVar.zzQ(zzcfVar, arrayList);
        } catch (Throwable th) {
            zzlb zzlbVar2 = zzjmVar.zzt.zzp;
            zzfr.zzP(zzlbVar2);
            zzlbVar2.zzQ(zzcfVar, arrayList);
            throw th;
        }
    }
}
