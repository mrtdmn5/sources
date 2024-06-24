package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhm implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhx zzb;

    public zzhm(zzhx zzhxVar, AtomicReference atomicReference) {
        this.zzb = zzhxVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        synchronized (this.zza) {
            try {
                AtomicReference atomicReference = this.zza;
                zzfr zzfrVar = this.zzb.zzt;
                zzag zzagVar = zzfrVar.zzk;
                String zzl = zzfrVar.zzh().zzl();
                zzdt zzdtVar = zzdu.zzK;
                if (zzl == null) {
                    zzagVar.getClass();
                    str = (String) zzdtVar.zza(null);
                } else {
                    str = (String) zzdtVar.zza(zzagVar.zzb.zza(zzl, zzdtVar.zzb));
                }
                atomicReference.set(str);
                this.zza.notify();
            } catch (Throwable th) {
                this.zza.notify();
                throw th;
            }
        }
    }
}
