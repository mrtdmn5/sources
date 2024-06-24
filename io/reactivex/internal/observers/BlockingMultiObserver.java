package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    public volatile boolean cancelled;
    public Throwable error;
    public Disposable upstream;
    public T value;

    public BlockingMultiObserver() {
        super(1);
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.error = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        this.upstream = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.value = t;
        countDown();
    }
}
