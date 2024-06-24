package io.reactivex.internal.observers;

import io.reactivex.Observer;

/* loaded from: classes.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    public final Observer<? super T> downstream;
    public T value;

    public DeferredScalarDisposable(Observer<? super T> observer) {
        this.downstream = observer;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int r0 = get();
        if ((r0 & 54) != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream;
        if (r0 == 8) {
            this.value = t;
            lazySet(16);
            observer.onNext(null);
        } else {
            lazySet(2);
            observer.onNext(t);
        }
        if (get() != 4) {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(4);
        this.value = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == 4) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        if (get() != 16) {
            return true;
        }
        return false;
    }

    public void onSuccess(T t) {
        complete(t);
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int requestFusion(int r2) {
        if ((r2 & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }
}
