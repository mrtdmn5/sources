package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes.dex */
public final class SingleMap<T, R> extends Single<R> {
    public final Function<? super T, ? extends R> mapper;
    public final SingleSource<? extends T> source;

    /* loaded from: classes.dex */
    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        public final Function<? super T, ? extends R> mapper;
        public final SingleObserver<? super R> t;

        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.t = singleObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.t.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.t.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                R apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper function returned a null value.");
                this.t.onSuccess(apply);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                onError(th);
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new MapSingleObserver(singleObserver, this.mapper));
    }
}
