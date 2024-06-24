package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToObservable;

/* loaded from: classes.dex */
public final class ObservableCountSingle<T> extends Single<Long> implements FuseToObservable<Long> {
    public final ObservableSource<T> source;

    /* loaded from: classes.dex */
    public static final class CountObserver implements Observer<Object>, Disposable {
        public long count;
        public final SingleObserver<? super Long> downstream;
        public Disposable upstream;

        public CountObserver(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onSuccess(Long.valueOf(this.count));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object obj) {
            this.count++;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableCountSingle(ObservableTakeWhile observableTakeWhile) {
        this.source = observableTakeWhile;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<Long> fuseToObservable() {
        return new ObservableCount(this.source);
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        this.source.subscribe(new CountObserver(singleObserver));
    }
}
