package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;

/* loaded from: classes.dex */
public final class SingleDoOnError<T> extends Single<T> {
    public final Consumer<? super Throwable> onError;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public final class DoOnError implements SingleObserver<T> {
        public final SingleObserver<? super T> downstream;

        public DoOnError(SingleObserver<? super T> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            try {
                SingleDoOnError.this.onError.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    public SingleDoOnError(SingleDoOnSuccess singleDoOnSuccess, Functions.ActionConsumer actionConsumer) {
        this.source = singleDoOnSuccess;
        this.onError = actionConsumer;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.source.subscribe(new DoOnError(singleObserver));
    }
}
