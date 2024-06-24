package com.google.android.gms.measurement.internal;

import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzfl implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ zzfo zza;
    public final String zzb;

    public zzfl(zzfo zzfoVar, String str) {
        this.zza = zzfoVar;
        this.zzb = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        zzeh zzehVar = this.zza.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(th, this.zzb);
    }
}
