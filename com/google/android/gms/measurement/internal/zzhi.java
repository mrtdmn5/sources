package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhi implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhx zzb;

    public zzhi(zzhx zzhxVar, AtomicReference atomicReference) {
        this.zzb = zzhxVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                AtomicReference atomicReference = this.zza;
                zzfr zzfrVar = this.zzb.zzt;
                atomicReference.set(Boolean.valueOf(zzfrVar.zzk.zzs(zzfrVar.zzh().zzl(), zzdu.zzJ)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
