package io.reactivex.internal.operators.observable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.FuseToObservable;

/* loaded from: classes.dex */
public final class ObservableIgnoreElementsCompletable<T> extends Completable implements FuseToObservable<T> {
    public final ObservableSource<T> source;

    public ObservableIgnoreElementsCompletable(Observable observable) {
        this.source = observable;
    }

    @Override // io.reactivex.internal.fuseable.FuseToObservable
    public final Observable<T> fuseToObservable() {
        return new ObservableIgnoreElements(this.source);
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe(new IgnoreObservable(completableObserver));
    }

    /* loaded from: classes.dex */
    public static final class IgnoreObservable<T> implements Observer<T>, Disposable {
        public final CompletableObserver downstream;
        public Disposable upstream;

        public IgnoreObservable(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
        }
    }
}
