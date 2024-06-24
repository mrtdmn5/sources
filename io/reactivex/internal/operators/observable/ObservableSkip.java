package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {
    public final long n;

    /* loaded from: classes.dex */
    public static final class SkipObserver<T> implements Observer<T>, Disposable {
        public final Observer<? super T> downstream;
        public long remaining;
        public Disposable upstream;

        public SkipObserver(Observer<? super T> observer, long j) {
            this.downstream = observer;
            this.remaining = j;
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
        public final void onNext(T t) {
            long j = this.remaining;
            if (j != 0) {
                this.remaining = j - 1;
            } else {
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(Observable observable) {
        super(observable);
        this.n = 1L;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.n));
    }
}
