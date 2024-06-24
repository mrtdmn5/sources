package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzin implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzq zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzcf zze;
    public final /* synthetic */ zzjm zzf;

    public zzin(zzjm zzjmVar, String str, String str2, zzq zzqVar, boolean z, zzcf zzcfVar) {
        this.zzf = zzjmVar;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzqVar;
        this.zzd = z;
        this.zze = zzcfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        zzq zzqVar = this.zzc;
        String str = this.zza;
        zzcf zzcfVar = this.zze;
        zzjm zzjmVar = this.zzf;
        Bundle bundle2 = new Bundle();
        try {
            try {
                zzdx zzdxVar = zzjmVar.zzb;
                zzfr zzfrVar = zzjmVar.zzt;
                String str2 = this.zzb;
                if (zzdxVar == null) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzc(str, str2, "Failed to get user properties; not connected to service");
                    zzlb zzlbVar = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar);
                    zzlbVar.zzR(zzcfVar, bundle2);
                    return;
                }
                Preconditions.checkNotNull(zzqVar);
                List<zzkw> zzh = zzdxVar.zzh(str, str2, this.zzd, zzqVar);
                bundle = new Bundle();
                if (zzh != null) {
                    for (zzkw zzkwVar : zzh) {
                        String str3 = zzkwVar.zze;
                        String str4 = zzkwVar.zzb;
                        if (str3 != null) {
                            bundle.putString(str4, str3);
                        } else {
                            Long l = zzkwVar.zzd;
                            if (l != null) {
                                bundle.putLong(str4, l.longValue());
                            } else {
                                Double d = zzkwVar.zzg;
                                if (d != null) {
                                    bundle.putDouble(str4, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    zzjmVar.zzQ();
                    zzlb zzlbVar2 = zzfrVar.zzp;
                    zzfr.zzP(zzlbVar2);
                    zzlbVar2.zzR(zzcfVar, bundle);
                } catch (RemoteException e) {
                    e = e;
                    bundle2 = bundle;
                    zzeh zzehVar2 = zzjmVar.zzt.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzc(str, e, "Failed to get user properties; remote exception");
                    zzlb zzlbVar3 = zzjmVar.zzt.zzp;
                    zzfr.zzP(zzlbVar3);
                    zzlbVar3.zzR(zzcfVar, bundle2);
                } catch (Throwable th) {
                    th = th;
                    zzlb zzlbVar4 = zzjmVar.zzt.zzp;
                    zzfr.zzP(zzlbVar4);
                    zzlbVar4.zzR(zzcfVar, bundle);
                    throw th;
                }
            } catch (RemoteException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            bundle = bundle2;
        }
    }
}
