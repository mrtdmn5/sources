package io.reactivex.internal.operators.single;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleDelayWithObservable<T, U> extends Single<T> {
    public final ObservableSource<U> other;
    public final SingleSource<T> source;

    /* loaded from: classes.dex */
    public static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        public boolean done;
        public final SingleObserver<? super T> downstream;
        public final SingleSource<T> source;

        public OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.downstream = singleObserver;
            this.source = singleSource;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.source.subscribe(new ResumeSingleObserver(this.downstream, this));
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            get().dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.set(this, disposable)) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public SingleDelayWithObservable(SingleSource singleSource, Observable observable) {
        this.source = singleSource;
        this.other = observable;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.other.subscribe(new OtherSubscriber(singleObserver, this.source));
    }
}
