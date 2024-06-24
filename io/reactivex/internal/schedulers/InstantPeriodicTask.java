package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class InstantPeriodicTask implements Callable<Void>, Disposable {
    public static final FutureTask<Void> CANCELLED = new FutureTask<>(Functions.EMPTY_RUNNABLE, null);
    public final ExecutorService executor;
    public final AtomicReference<Future<?>> first = new AtomicReference<>();
    public final AtomicReference<Future<?>> rest = new AtomicReference<>();
    public Thread runner;
    public final Runnable task;

    public InstantPeriodicTask(ObservableInterval.IntervalObserver intervalObserver, ScheduledExecutorService scheduledExecutorService) {
        this.task = intervalObserver;
        this.executor = scheduledExecutorService;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.task.run();
            Future<?> submit = this.executor.submit(this);
            while (true) {
                AtomicReference<Future<?>> atomicReference = this.rest;
                Future<?> future = atomicReference.get();
                boolean z = false;
                if (future == CANCELLED) {
                    if (this.runner != Thread.currentThread()) {
                        z = true;
                    }
                    submit.cancel(z);
                }
                while (true) {
                    if (atomicReference.compareAndSet(future, submit)) {
                        z = true;
                        break;
                    }
                    if (atomicReference.get() != future) {
                        break;
                    }
                }
                if (z) {
                    break;
                }
            }
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            RxJavaPlugins.onError(th);
        }
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        boolean z;
        AtomicReference<Future<?>> atomicReference = this.first;
        FutureTask<Void> futureTask = CANCELLED;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        boolean z2 = true;
        if (andSet != null && andSet != futureTask) {
            if (this.runner != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            andSet.cancel(z);
        }
        Future<?> andSet2 = this.rest.getAndSet(futureTask);
        if (andSet2 != null && andSet2 != futureTask) {
            if (this.runner == Thread.currentThread()) {
                z2 = false;
            }
            andSet2.cancel(z2);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.first.get() == CANCELLED) {
            return true;
        }
        return false;
    }

    public final void setFirst(Future<?> future) {
        boolean z;
        do {
            AtomicReference<Future<?>> atomicReference = this.first;
            Future<?> future2 = atomicReference.get();
            z = false;
            if (future2 == CANCELLED) {
                if (this.runner != Thread.currentThread()) {
                    z = true;
                }
                future.cancel(z);
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(future2, future)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != future2) {
                    break;
                }
            }
        } while (!z);
    }
}
