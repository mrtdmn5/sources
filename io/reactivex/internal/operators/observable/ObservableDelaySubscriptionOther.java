package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class ObservableDelaySubscriptionOther<T, U> extends Observable<T> {
    public final ObservableSource<? extends T> main;
    public final ObservableSource<U> other;

    /* loaded from: classes.dex */
    public final class DelayObserver implements Observer<U> {
        public final Observer<? super T> child;
        public boolean done;
        public final SequentialDisposable serial;

        /* loaded from: classes.dex */
        public final class OnComplete implements Observer<T> {
            public OnComplete() {
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                DelayObserver.this.child.onComplete();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                DelayObserver.this.child.onError(th);
            }

            @Override // io.reactivex.Observer
            public final void onNext(T t) {
                DelayObserver.this.child.onNext(t);
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                SequentialDisposable sequentialDisposable = DelayObserver.this.serial;
                sequentialDisposable.getClass();
                DisposableHelper.set(sequentialDisposable, disposable);
            }
        }

        public DelayObserver(SequentialDisposable sequentialDisposable, Observer<? super T> observer) {
            this.serial = sequentialDisposable;
            this.child = observer;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            ObservableDelaySubscriptionOther.this.main.subscribe(new OnComplete());
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.child.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            SequentialDisposable sequentialDisposable = this.serial;
            sequentialDisposable.getClass();
            DisposableHelper.set(sequentialDisposable, disposable);
        }
    }

    public ObservableDelaySubscriptionOther(Observable observable, Observable observable2) {
        this.main = observable;
        this.other = observable2;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        this.other.subscribe(new DelayObserver(sequentialDisposable, observer));
    }
}
