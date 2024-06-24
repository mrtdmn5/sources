package com.animaconnected.secondo.behaviour.temperature;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: TemperatureWorkManager.kt */
/* loaded from: classes3.dex */
public final class TemperatureWorkManager$getSuspending$2$1 implements Runnable {
    final /* synthetic */ CancellableContinuation<R> $cancellableContinuation;
    final /* synthetic */ ListenableFuture<R> $this_getSuspending;

    /* JADX WARN: Multi-variable type inference failed */
    public TemperatureWorkManager$getSuspending$2$1(CancellableContinuation<? super R> cancellableContinuation, ListenableFuture<R> listenableFuture) {
        this.$cancellableContinuation = cancellableContinuation;
        this.$this_getSuspending = listenableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.$cancellableContinuation.resumeWith(this.$this_getSuspending.get());
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                cause = th;
            }
            if (th instanceof CancellationException) {
                this.$cancellableContinuation.cancel(cause);
            } else {
                this.$cancellableContinuation.resumeWith(ResultKt.createFailure(cause));
            }
        }
    }
}
