package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzir implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzjm zzc;

    public zzir(zzjm zzjmVar, AtomicReference atomicReference, zzq zzqVar) {
        this.zzc = zzjmVar;
        this.zza = atomicReference;
        this.zzb = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zzew zzewVar;
        synchronized (this.zza) {
            try {
                try {
                    zzewVar = this.zzc.zzt.zzl;
                    zzfr.zzP(zzewVar);
                } catch (RemoteException e) {
                    zzeh zzehVar = this.zzc.zzt.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzb(e, "Failed to get app instance id");
                    atomicReference = this.zza;
                }
                if (!zzewVar.zzc().zzi(zzah.ANALYTICS_STORAGE)) {
                    zzeh zzehVar2 = this.zzc.zzt.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzi.zza("Analytics storage consent denied; will not get app instance id");
                    zzhx zzhxVar = this.zzc.zzt.zzt;
                    zzfr.zzQ(zzhxVar);
                    zzhxVar.zzg.set(null);
                    zzew zzewVar2 = this.zzc.zzt.zzl;
                    zzfr.zzP(zzewVar2);
                    zzewVar2.zze.zzb(null);
                    this.zza.set(null);
                    return;
                }
                zzjm zzjmVar = this.zzc;
                zzdx zzdxVar = zzjmVar.zzb;
                if (zzdxVar == null) {
                    zzeh zzehVar3 = zzjmVar.zzt.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Failed to get app instance id");
                    return;
                }
                Preconditions.checkNotNull(this.zzb);
                this.zza.set(zzdxVar.zzd(this.zzb));
                String str = (String) this.zza.get();
                if (str != null) {
                    zzhx zzhxVar2 = this.zzc.zzt.zzt;
                    zzfr.zzQ(zzhxVar2);
                    zzhxVar2.zzg.set(str);
                    zzew zzewVar3 = this.zzc.zzt.zzl;
                    zzfr.zzP(zzewVar3);
                    zzewVar3.zze.zzb(str);
                }
                this.zzc.zzQ();
                atomicReference = this.zza;
                atomicReference.notify();
            } finally {
                this.zza.notify();
            }
        }
    }
}
