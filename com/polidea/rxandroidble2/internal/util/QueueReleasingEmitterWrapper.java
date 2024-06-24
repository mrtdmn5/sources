package com.polidea.rxandroidble2.internal.util;

import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import io.reactivex.ObservableEmitter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableCreate;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class QueueReleasingEmitterWrapper<T> implements Observer<T>, Cancellable {
    public final ObservableEmitter<T> emitter;
    public final AtomicBoolean isEmitterCanceled = new AtomicBoolean(false);
    public final QueueSemaphore queueReleaseInterface;

    public QueueReleasingEmitterWrapper(ObservableCreate.CreateEmitter createEmitter, QueueSemaphore queueSemaphore) {
        this.emitter = createEmitter;
        this.queueReleaseInterface = queueSemaphore;
        DisposableHelper.set(createEmitter, new CancellableDisposable(this));
    }

    @Override // io.reactivex.functions.Cancellable
    public final synchronized void cancel() {
        this.isEmitterCanceled.set(true);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        this.queueReleaseInterface.release();
        ((ObservableCreate.CreateEmitter) this.emitter).onComplete();
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        this.queueReleaseInterface.release();
        ((ObservableCreate.CreateEmitter) this.emitter).tryOnError(th);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        ((ObservableCreate.CreateEmitter) this.emitter).onNext(t);
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
    }
}
