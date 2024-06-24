package kotlinx.coroutines.scheduling;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: Dispatcher.kt */
/* loaded from: classes4.dex */
public final class UnlimitedIoScheduler extends CoroutineDispatcher {
    public static final UnlimitedIoScheduler INSTANCE = new UnlimitedIoScheduler();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler defaultScheduler = DefaultScheduler.INSTANCE;
        defaultScheduler.coroutineScheduler.dispatch(runnable, TasksKt.BlockingContext, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        DefaultScheduler defaultScheduler = DefaultScheduler.INSTANCE;
        defaultScheduler.coroutineScheduler.dispatch(runnable, TasksKt.BlockingContext, true);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final CoroutineDispatcher limitedParallelism(int r2) {
        LimitedDispatcherKt.checkParallelism(r2);
        if (r2 >= TasksKt.MAX_POOL_SIZE) {
            return this;
        }
        return super.limitedParallelism(r2);
    }
}
