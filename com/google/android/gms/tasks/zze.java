package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zze implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzf zzb;

    public zze(zzf zzfVar, Task task) {
        this.zzb = zzfVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzf zzfVar = this.zzb;
        try {
            Task task = (Task) zzfVar.zzb.then(this.zza);
            if (task == null) {
                zzfVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            zzt zztVar = TaskExecutors.zza;
            task.addOnSuccessListener(zztVar, zzfVar);
            task.addOnFailureListener(zztVar, zzfVar);
            task.addOnCanceledListener(zztVar, zzfVar);
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzfVar.zzc.zza((Exception) e.getCause());
            } else {
                zzfVar.zzc.zza(e);
            }
        } catch (Exception e2) {
            zzfVar.zzc.zza(e2);
        }
    }
}
