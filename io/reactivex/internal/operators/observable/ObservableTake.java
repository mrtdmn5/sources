package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class ObservableTake<T> extends AbstractObservableWithUpstream<T, T> {
    public final long limit;

    /* loaded from: classes.dex */
    public static final class TakeObserver<T> implements Observer<T>, Disposable {
        public boolean done;
        public final Observer<? super T> downstream;
        public long remaining;
        public Disposable upstream;

        public TakeObserver(Observer<? super T> observer, long j) {
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
            if (!this.done) {
                this.done = true;
                this.upstream.dispose();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            boolean z;
            if (!this.done) {
                long j = this.remaining;
                long j2 = j - 1;
                this.remaining = j2;
                if (j > 0) {
                    if (j2 == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.downstream.onNext(t);
                    if (z) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                long j = this.remaining;
                Observer<? super T> observer = this.downstream;
                if (j == 0) {
                    this.done = true;
                    disposable.dispose();
                    EmptyDisposable.complete(observer);
                    return;
                }
                observer.onSubscribe(this);
            }
        }
    }

    public ObservableTake(ObservableSource observableSource) {
        super(observableSource);
        this.limit = 1L;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeObserver(observer, this.limit));
    }
}
