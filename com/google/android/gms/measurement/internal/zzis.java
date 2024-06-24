package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzis implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzcf zzb;
    public final /* synthetic */ zzjm zzc;

    public zzis(zzjm zzjmVar, zzq zzqVar, zzcf zzcfVar) {
        this.zzc = zzjmVar;
        this.zza = zzqVar;
        this.zzb = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlb zzlbVar;
        zzq zzqVar = this.zza;
        zzcf zzcfVar = this.zzb;
        zzjm zzjmVar = this.zzc;
        String str = null;
        try {
            try {
                zzew zzewVar = zzjmVar.zzt.zzl;
                zzfr.zzP(zzewVar);
                boolean zzi = zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE);
                zzfr zzfrVar = zzjmVar.zzt;
                if (!zzi) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzi.zza("Analytics storage consent denied; will not get app instance id");
                    zzhx zzhxVar = zzfrVar.zzt;
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzg.set(null);
                    zzew zzewVar2 = zzfrVar.zzl;
                    zzfr.zzP(zzewVar2);
                    zzewVar2.zze.zzb(null);
                } else {
                    zzdx zzdxVar = zzjmVar.zzb;
                    if (zzdxVar == null) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zza("Failed to get app instance id");
                    } else {
                        Preconditions.checkNotNull(zzqVar);
                        str = zzdxVar.zzd(zzqVar);
                        if (str != null) {
                            zzhx zzhxVar2 = zzfrVar.zzt;
                            zzfr.zzQ(zzhxVar2);
                            zzhxVar2.zzg.set(str);
                            zzew zzewVar3 = zzfrVar.zzl;
                            zzfr.zzP(zzewVar3);
                            zzewVar3.zze.zzb(str);
                        }
                        zzjmVar.zzQ();
                    }
                }
                zzlbVar = zzfrVar.zzp;
            } catch (RemoteException e) {
                zzeh zzehVar3 = zzjmVar.zzt.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzd.zzb(e, "Failed to get app instance id");
                zzlbVar = zzjmVar.zzt.zzp;
            }
            zzfr.zzP(zzlbVar);
            zzlbVar.zzV(str, zzcfVar);
        } catch (Throwable th) {
            zzlb zzlbVar2 = zzjmVar.zzt.zzp;
            zzfr.zzP(zzlbVar2);
            zzlbVar2.zzV(null, zzcfVar);
            throw th;
        }
    }
}
