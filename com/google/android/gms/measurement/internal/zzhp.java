package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhp implements Runnable {
    public final /* synthetic */ AtomicReference zza;
    public final /* synthetic */ zzhx zzb;

    public zzhp(zzhx zzhxVar, AtomicReference atomicReference) {
        this.zzb = zzhxVar;
        this.zza = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zza) {
            try {
                AtomicReference atomicReference = this.zza;
                zzfr zzfrVar = this.zzb.zzt;
                atomicReference.set(Double.valueOf(zzfrVar.zzk.zza(zzfrVar.zzh().zzl(), zzdu.zzN)));
            } finally {
                this.zza.notify();
            }
        }
    }
}
