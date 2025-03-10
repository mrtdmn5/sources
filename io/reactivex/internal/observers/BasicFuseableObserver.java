package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public abstract class BasicFuseableObserver<T, R> implements Observer<T>, QueueDisposable<R> {
    public boolean done;
    public final Observer<? super R> downstream;
    public QueueDisposable<T> qd;
    public int sourceMode;
    public Disposable upstream;

    public BasicFuseableObserver(Observer<? super R> observer) {
        this.downstream = observer;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        this.qd.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return this.qd.isEmpty();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.done) {
            RxJavaPlugins.onError(th);
        } else {
            this.done = true;
            this.downstream.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            if (disposable instanceof QueueDisposable) {
                this.qd = (QueueDisposable) disposable;
            }
            this.downstream.onSubscribe(this);
        }
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r1) {
        return transitiveBoundaryFusion(r1);
    }

    public final int transitiveBoundaryFusion(int r3) {
        QueueDisposable<T> queueDisposable = this.qd;
        if (queueDisposable != null && (r3 & 4) == 0) {
            int requestFusion = queueDisposable.requestFusion(r3);
            if (requestFusion != 0) {
                this.sourceMode = requestFusion;
            }
            return requestFusion;
        }
        return 0;
    }
}
