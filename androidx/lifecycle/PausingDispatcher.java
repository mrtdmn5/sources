package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcher extends CoroutineDispatcher {
    public final DispatchQueue dispatchQueue = new DispatchQueue();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext context, final Runnable block) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        final DispatchQueue dispatchQueue = this.dispatchQueue;
        dispatchQueue.getClass();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        MainCoroutineDispatcher immediate = MainDispatcherLoader.dispatcher.getImmediate();
        if (!immediate.isDispatchNeeded(context)) {
            if (!dispatchQueue.finished && dispatchQueue.paused) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                if (dispatchQueue.queue.offer(block)) {
                    dispatchQueue.drainQueue();
                    return;
                }
                throw new IllegalStateException("cannot enqueue any more runnables".toString());
            }
        }
        immediate.dispatch(context, new Runnable() { // from class: androidx.lifecycle.DispatchQueue$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DispatchQueue this$0 = DispatchQueue.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Runnable runnable = block;
                Intrinsics.checkNotNullParameter(runnable, "$runnable");
                if (this$0.queue.offer(runnable)) {
                    this$0.drainQueue();
                    return;
                }
                throw new IllegalStateException("cannot enqueue any more runnables".toString());
            }
        });
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext context) {
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        if (MainDispatcherLoader.dispatcher.getImmediate().isDispatchNeeded(context)) {
            return true;
        }
        DispatchQueue dispatchQueue = this.dispatchQueue;
        if (!dispatchQueue.finished && dispatchQueue.paused) {
            z = false;
        } else {
            z = true;
        }
        return !z;
    }
}
