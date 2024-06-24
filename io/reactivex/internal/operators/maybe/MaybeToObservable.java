package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class MaybeToObservable<T> extends Observable<T> {
    public final MaybeSource<T> source;

    /* loaded from: classes.dex */
    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        public Disposable upstream;

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.MaybeObserver
        public final void onComplete() {
            if ((get() & 54) == 0) {
                lazySet(2);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onError(Throwable th) {
            if ((get() & 54) != 0) {
                RxJavaPlugins.onError(th);
            } else {
                lazySet(2);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public MaybeToObservable(Maybe maybe) {
        this.source = maybe;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new MaybeToObservableObserver(observer));
    }
}
