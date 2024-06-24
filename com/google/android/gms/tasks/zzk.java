package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzk implements Runnable {
    public final /* synthetic */ Task zza;
    public final /* synthetic */ zzl zzb;

    public zzk(zzl zzlVar, Task task) {
        this.zzb = zzlVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zzb) {
            OnFailureListener onFailureListener = this.zzb.zzc;
            if (onFailureListener != null) {
                Exception exception = this.zza.getException();
                Preconditions.checkNotNull(exception);
                onFailureListener.onFailure(exception);
            }
        }
    }
}
