package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes3.dex */
public final class zzw<TResult> extends Task<TResult> {
    public final Object zza = new Object();
    public final zzr zzb = new zzr();
    public boolean zzc;
    public volatile boolean zzd;
    public Object zze;
    public Exception zzf;

    @Override // com.google.android.gms.tasks.Task
    public final void addOnCanceledListener(OnCanceledListener onCanceledListener) {
        addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> addOnCompleteListener(OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(TaskExecutors.MAIN_THREAD, onCompleteListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnFailureListener(OnFailureListener onFailureListener) {
        addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnSuccessListener(OnSuccessListener onSuccessListener) {
        addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final void continueWith(Continuation continuation) {
        continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzf(executor, continuation, zzwVar));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            Preconditions.checkState("Task is not yet complete", this.zzc);
            if (!this.zzd) {
                Exception exc = this.zzf;
                if (exc == null) {
                    tresult = (TResult) this.zze;
                } else {
                    throw new RuntimeExecutionException(exc);
                }
            } else {
                throw new CancellationException("Task is already canceled.");
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Object getResult$1() throws Throwable {
        Object obj;
        synchronized (this.zza) {
            Preconditions.checkState("Task is not yet complete", this.zzc);
            if (!this.zzd) {
                if (!IOException.class.isInstance(this.zzf)) {
                    Exception exc = this.zzf;
                    if (exc == null) {
                        obj = this.zze;
                    } else {
                        throw new RuntimeExecutionException(exc);
                    }
                } else {
                    throw ((Throwable) IOException.class.cast(this.zzf));
                }
            } else {
                throw new CancellationException("Task is already canceled.");
            }
        }
        return obj;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isCanceled() {
        return this.zzd;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzc && !this.zzd && this.zzf == null) {
                z = true;
            }
        }
        return z;
    }

    public final zzw onSuccessTask(SuccessContinuation successContinuation) {
        zzu zzuVar = TaskExecutors.MAIN_THREAD;
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzp(zzuVar, successContinuation, zzwVar));
        zzi();
        return zzwVar;
    }

    public final void zza(Exception exc) {
        if (exc != null) {
            synchronized (this.zza) {
                zzh();
                this.zzc = true;
                this.zzf = exc;
            }
            this.zzb.zzb(this);
            return;
        }
        throw new NullPointerException("Exception must not be null");
    }

    public final void zzb(Object obj) {
        synchronized (this.zza) {
            zzh();
            this.zzc = true;
            this.zze = obj;
        }
        this.zzb.zzb(this);
    }

    public final void zzc() {
        synchronized (this.zza) {
            if (this.zzc) {
                return;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zzb(this);
        }
    }

    public final void zzh() {
        String str;
        if (this.zzc) {
            int r0 = DuplicateTaskCompletionException.$r8$clinit;
            if (isComplete()) {
                Exception exception = getException();
                if (exception == null) {
                    if (!isSuccessful()) {
                        if (this.zzd) {
                            str = "cancellation";
                        } else {
                            str = "unknown issue";
                        }
                    } else {
                        str = "result ".concat(String.valueOf(getResult()));
                    }
                } else {
                    str = "failure";
                }
                throw new DuplicateTaskCompletionException("Complete with: ".concat(str), exception);
            }
            throw new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
    }

    public final void zzi() {
        synchronized (this.zza) {
            if (!this.zzc) {
                return;
            }
            this.zzb.zzb(this);
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final void addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        this.zzb.zza(new zzh(executor, onCanceledListener));
        zzi();
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        this.zzb.zza(new zzl(executor, onFailureListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final zzw addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener) {
        this.zzb.zza(new zzn(executor, onSuccessListener));
        zzi();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzd(executor, continuation, zzwVar));
        zzi();
        return zzwVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final void addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener) {
        this.zzb.zza(new zzj(executor, onCompleteListener));
        zzi();
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzw zzwVar = new zzw();
        this.zzb.zza(new zzp(executor, successContinuation, zzwVar));
        zzi();
        return zzwVar;
    }
}
