package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhe implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzhx zzb;

    public zzhe(zzhx zzhxVar, long j) {
        this.zzb = zzhxVar;
        this.zza = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j = this.zza;
        zzhx zzhxVar = this.zzb;
        zzhxVar.zzL(j, true);
        zzhxVar.zzt.zzt().zzu(new AtomicReference());
    }
}
