package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzi implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzj zzb;

    public zzi(zzj zzjVar, Task task) {
        this.zzb = zzjVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zzb) {
            OnCompleteListener onCompleteListener = this.zzb.zzc;
            if (onCompleteListener != null) {
                onCompleteListener.onComplete(this.zza);
            }
        }
    }
}
