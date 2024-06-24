package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class BlockingFirstObserver<T> extends CountDownLatch implements Observer<Object>, Disposable {
    public volatile boolean cancelled;
    public Throwable error;
    public Disposable upstream;
    public Object value;

    public BlockingFirstObserver() {
        super(1);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.cancelled = true;
        Disposable disposable = this.upstream;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.cancelled;
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (this.value == null) {
            this.error = th;
        }
        countDown();
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (this.value == null) {
            this.value = t;
            this.upstream.dispose();
            countDown();
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }
}
