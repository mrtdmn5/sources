package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    public final SingleObserver<? super T> downstream;
    public final AtomicReference<Disposable> parent;

    public ResumeSingleObserver(SingleObserver singleObserver, AtomicReference atomicReference) {
        this.parent = atomicReference;
        this.downstream = singleObserver;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.downstream.onError(th);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
        DisposableHelper.replace(this.parent, disposable);
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.downstream.onSuccess(t);
    }
}
