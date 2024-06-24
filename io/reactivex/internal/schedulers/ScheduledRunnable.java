package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    public final Runnable actual;
    public static final Object PARENT_DISPOSED = new Object();
    public static final Object SYNC_DISPOSED = new Object();
    public static final Object ASYNC_DISPOSED = new Object();
    public static final Object DONE = new Object();

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        boolean z;
        while (true) {
            Object obj6 = get(1);
            obj = DONE;
            if (obj6 == obj || obj6 == (obj4 = SYNC_DISPOSED) || obj6 == (obj5 = ASYNC_DISPOSED)) {
                break;
            }
            if (get(2) != Thread.currentThread()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 != null) {
                    ((Future) obj6).cancel(z);
                }
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = PARENT_DISPOSED) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((DisposableContainer) obj2).delete(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Object obj = get(0);
        if (obj != PARENT_DISPOSED && obj != DONE) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean compareAndSet;
        Object obj2;
        Object obj3;
        Object obj4 = ASYNC_DISPOSED;
        Object obj5 = SYNC_DISPOSED;
        Object obj6 = PARENT_DISPOSED;
        Object obj7 = DONE;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
                lazySet(2, null);
                obj2 = get(0);
                if (obj2 != obj6) {
                    ((DisposableContainer) obj2).delete(this);
                }
                do {
                    obj3 = get(1);
                    if (obj3 != obj5) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj3, obj7));
            } catch (Throwable th) {
                do {
                    if (obj == obj5 || obj == obj4) {
                        break;
                    }
                } while (!compareAndSet);
            }
        }
        lazySet(2, null);
        obj2 = get(0);
        if (obj2 != obj6 && compareAndSet(0, obj2, obj7) && obj2 != null) {
            ((DisposableContainer) obj2).delete(this);
        }
        do {
            obj3 = get(1);
            if (obj3 != obj5 || obj3 == obj4) {
                return;
            }
        } while (!compareAndSet(1, obj3, obj7));
    }

    public final void setFuture(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == DONE) {
                return;
            }
            if (obj == SYNC_DISPOSED) {
                future.cancel(false);
                return;
            } else if (obj == ASYNC_DISPOSED) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }
}
