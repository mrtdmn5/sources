package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    public final CoroutineScheduler coroutineScheduler;

    public SchedulerCoroutineDispatcher(long j, String str, int r11, int r12) {
        this.coroutineScheduler = new CoroutineScheduler(j, str, r11, r12);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.parkedWorkersStack$FU;
        this.coroutineScheduler.dispatch(runnable, TasksKt.NonBlockingContext, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.parkedWorkersStack$FU;
        this.coroutineScheduler.dispatch(runnable, TasksKt.NonBlockingContext, true);
    }
}
