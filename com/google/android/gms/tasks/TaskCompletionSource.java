package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class TaskCompletionSource<TResult> {
    public final zzw zza = new zzw();

    public final void setException(Exception exc) {
        this.zza.zza(exc);
    }

    public final void setResult(TResult tresult) {
        this.zza.zzb(tresult);
    }

    public final boolean trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        if (exc != null) {
            synchronized (zzwVar.zza) {
                if (zzwVar.zzc) {
                    return false;
                }
                zzwVar.zzc = true;
                zzwVar.zzf = exc;
                zzwVar.zzb.zzb(zzwVar);
                return true;
            }
        }
        throw new NullPointerException("Exception must not be null");
    }

    public final void trySetResult(Object obj) {
        zzw zzwVar = this.zza;
        synchronized (zzwVar.zza) {
            if (!zzwVar.zzc) {
                zzwVar.zzc = true;
                zzwVar.zze = obj;
                zzwVar.zzb.zzb(zzwVar);
            }
        }
    }
}
