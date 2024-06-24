package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Delay.kt */
/* loaded from: classes4.dex */
public interface Delay {

    /* compiled from: Delay.kt */
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
            return DefaultExecutorKt.DefaultDelay.invokeOnTimeout(j, runnable, coroutineContext);
        }
    }

    DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext);

    void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl);
}
