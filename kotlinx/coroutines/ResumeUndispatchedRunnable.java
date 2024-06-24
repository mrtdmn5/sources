package kotlinx.coroutines;

import kotlin.Unit;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public final class ResumeUndispatchedRunnable implements Runnable {
    public final CancellableContinuation<Unit> continuation;
    public final CoroutineDispatcher dispatcher;

    public ResumeUndispatchedRunnable(CoroutineDispatcher coroutineDispatcher, CancellableContinuationImpl cancellableContinuationImpl) {
        this.dispatcher = coroutineDispatcher;
        this.continuation = cancellableContinuationImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.continuation.resumeUndispatched(this.dispatcher, Unit.INSTANCE);
    }
}
