package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* loaded from: classes.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {
    public final Consumer<? super T> onSuccess;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public final class DoOnSuccess implements SingleObserver<T> {
        public final SingleObserver<? super T> downstream;

        public DoOnSuccess(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            SingleObserver<? super T> singleObserver = this.downstream;
            try {
                SingleDoOnSuccess.this.onSuccess.accept(t);
                singleObserver.onSuccess(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                singleObserver.onError(th);
            }
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.source = singleSource;
        this.onSuccess = consumer;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnSuccess(singleObserver));
    }
}
