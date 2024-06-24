package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzaf<T> implements OnSuccessListener, OnFailureListener, OnCanceledListener {
    public final Object zza = new Object();
    public final int zzb;
    public final zzw zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public Exception zzg;
    public boolean zzh;

    public zzaf(int r2, zzw zzwVar) {
        this.zzb = r2;
        this.zzc = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.zza) {
            this.zzf++;
            this.zzh = true;
            zza();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.zza) {
            this.zze++;
            this.zzg = exc;
            zza();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t) {
        synchronized (this.zza) {
            this.zzd++;
            zza();
        }
    }

    public final void zza() {
        int r0 = this.zzd + this.zze + this.zzf;
        int r1 = this.zzb;
        if (r0 == r1) {
            Exception exc = this.zzg;
            zzw zzwVar = this.zzc;
            if (exc != null) {
                zzwVar.zza(new ExecutionException(this.zze + " out of " + r1 + " underlying tasks failed", this.zzg));
                return;
            }
            if (this.zzh) {
                zzwVar.zzc();
            } else {
                zzwVar.zzb(null);
            }
        }
    }
}
