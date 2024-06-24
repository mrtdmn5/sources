package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* loaded from: classes.dex */
public final class ObservableCount<T> extends AbstractObservableWithUpstream<T, Long> {

    /* loaded from: classes.dex */
    public static final class CountObserver implements Observer<Object>, Disposable {
        public long count;
        public final Observer<? super Long> downstream;
        public Disposable upstream;

        public CountObserver(Observer<? super Long> observer) {
            this.downstream = observer;
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
            Long valueOf = Long.valueOf(this.count);
            Observer<? super Long> observer = this.downstream;
            observer.onNext(valueOf);
            observer.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
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

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        this.source.subscribe(new CountObserver(observer));
    }
}
