package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class AbstractDirectTask extends AtomicReference<Future<?>> implements Disposable {
    public static final FutureTask<Void> DISPOSED;
    public static final FutureTask<Void> FINISHED;
    public final Runnable runnable;
    public Thread runner;

    static {
        Functions.EmptyRunnable emptyRunnable = Functions.EMPTY_RUNNABLE;
        FINISHED = new FutureTask<>(emptyRunnable, null);
        DISPOSED = new FutureTask<>(emptyRunnable, null);
    }

    public AbstractDirectTask(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        FutureTask<Void> futureTask;
        boolean z;
        Future<?> future = get();
        if (future != FINISHED && future != (futureTask = DISPOSED) && compareAndSet(future, futureTask) && future != null) {
            if (this.runner != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            future.cancel(z);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Future<?> future = get();
        if (future != FINISHED && future != DISPOSED) {
            return false;
        }
        return true;
    }

    public final void setFuture(Future<?> future) {
        Future<?> future2;
        boolean z;
        do {
            future2 = get();
            if (future2 != FINISHED) {
                if (future2 == DISPOSED) {
                    if (this.runner != Thread.currentThread()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    future.cancel(z);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(future2, future));
    }
}
