package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleFlatMap<T, R> extends Single<R> {
    public final Function<? super T, ? extends SingleSource<? extends R>> mapper;
    public final SingleSource<? extends T> source;

    /* loaded from: classes.dex */
    public static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        public final SingleObserver<? super R> downstream;
        public final Function<? super T, ? extends SingleSource<? extends R>> mapper;

        /* loaded from: classes.dex */
        public static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
            public final SingleObserver<? super R> downstream;
            public final AtomicReference<Disposable> parent;

            public FlatMapSingleObserver(SingleObserver singleObserver, AtomicReference atomicReference) {
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
            public final void onSuccess(R r) {
                this.downstream.onSuccess(r);
            }
        }

        public SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.downstream = singleObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            SingleObserver<? super R> singleObserver = this.downstream;
            try {
                SingleSource<? extends R> apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The single returned by the mapper is null");
                SingleSource<? extends R> singleSource = apply;
                if (!isDisposed()) {
                    singleSource.subscribe(new FlatMapSingleObserver(singleObserver, this));
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                singleObserver.onError(th);
            }
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.mapper = function;
        this.source = singleSource;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.source.subscribe(new SingleFlatMapCallback(singleObserver, this.mapper));
    }
}
