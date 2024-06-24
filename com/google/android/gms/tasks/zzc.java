package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzc implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzd zzb;

    public zzc(zzd zzdVar, Task task) {
        this.zzb = zzdVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Task task = this.zza;
        boolean isCanceled = task.isCanceled();
        zzd zzdVar = this.zzb;
        if (isCanceled) {
            zzdVar.zzc.zzc();
            return;
        }
        try {
            zzdVar.zzc.zzb(zzdVar.zzb.then(task));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                zzdVar.zzc.zza((Exception) e.getCause());
            } else {
                zzdVar.zzc.zza(e);
            }
        } catch (Exception e2) {
            zzdVar.zzc.zza(e2);
        }
    }
}
