package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzz implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ Callable zzb;

    public zzz(zzw zzwVar, Callable callable) {
        this.zza = zzwVar;
        this.zzb = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar = this.zza;
        try {
            zzwVar.zzb(this.zzb.call());
        } catch (Exception e) {
            zzwVar.zza(e);
        } catch (Throwable th) {
            zzwVar.zza(new RuntimeException(th));
        }
    }
}
