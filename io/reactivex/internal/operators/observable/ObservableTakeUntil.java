package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.MagicApiIntrinsics;

/* loaded from: classes.dex */
public final class ObservableTakeUntil<T, U> extends AbstractObservableWithUpstream<T, T> {
    public final ObservableSource<? extends U> other;

    /* loaded from: classes.dex */
    public static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        public final Observer<? super T> downstream;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        public final AtomicThrowable error = new AtomicThrowable();

        /* loaded from: classes.dex */
        public final class OtherObserver extends AtomicReference<Disposable> implements Observer<U> {
            public OtherObserver() {
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.upstream);
                MagicApiIntrinsics.onComplete(takeUntilMainObserver.downstream, takeUntilMainObserver, takeUntilMainObserver.error);
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.upstream);
                MagicApiIntrinsics.onError(takeUntilMainObserver.downstream, th, takeUntilMainObserver, takeUntilMainObserver.error);
            }

            @Override // io.reactivex.Observer
            public final void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver takeUntilMainObserver = TakeUntilMainObserver.this;
                DisposableHelper.dispose(takeUntilMainObserver.upstream);
                MagicApiIntrinsics.onComplete(takeUntilMainObserver.downstream, takeUntilMainObserver, takeUntilMainObserver.error);
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        public TakeUntilMainObserver(Observer<? super T> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            MagicApiIntrinsics.onComplete(this.downstream, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            MagicApiIntrinsics.onError(this.downstream, th, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            MagicApiIntrinsics.onNext(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }
    }

    public ObservableTakeUntil(ObservableSource observableSource, Observable observable) {
        super(observableSource);
        this.other = observable;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(observer);
        observer.onSubscribe(takeUntilMainObserver);
        this.other.subscribe(takeUntilMainObserver.otherObserver);
        this.source.subscribe(takeUntilMainObserver);
    }
}
