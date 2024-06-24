package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzo implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzp zzb;

    public zzo(zzp zzpVar, Task task) {
        this.zzb = zzpVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzp zzpVar = this.zzb;
        try {
            Task then = zzpVar.zzb.then(this.zza.getResult());
            if (then == null) {
                zzpVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzt zztVar = TaskExecutors.zza;
            then.addOnSuccessListener(zztVar, zzpVar);
            then.addOnFailureListener(zztVar, zzpVar);
            then.addOnCanceledListener(zztVar, zzpVar);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzpVar.onFailure((Exception) e.getCause());
            } else {
                zzpVar.onFailure(e);
            }
        } catch (CancellationException unused) {
            zzpVar.onCanceled();
        } catch (Exception e2) {
            zzpVar.onFailure(e2);
        }
    }
}
