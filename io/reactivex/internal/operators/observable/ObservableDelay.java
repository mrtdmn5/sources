package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    public final long delay;
    public final boolean delayError;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class DelayObserver<T> implements Observer<T>, Disposable {
        public final long delay;
        public final boolean delayError;
        public final Observer<? super T> downstream;
        public final TimeUnit unit;
        public Disposable upstream;
        public final Scheduler.Worker w;

        /* loaded from: classes.dex */
        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                DelayObserver delayObserver = DelayObserver.this;
                try {
                    delayObserver.downstream.onComplete();
                } finally {
                    delayObserver.w.dispose();
                }
            }
        }

        /* loaded from: classes.dex */
        public final class OnError implements Runnable {
            public final Throwable throwable;

            public OnError(Throwable th) {
                this.throwable = th;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DelayObserver delayObserver = DelayObserver.this;
                try {
                    delayObserver.downstream.onError(this.throwable);
                } finally {
                    delayObserver.w.dispose();
                }
            }
        }

        /* loaded from: classes.dex */
        public final class OnNext implements Runnable {
            public final T t;

            public OnNext(T t) {
                this.t = t;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DelayObserver.this.downstream.onNext(this.t);
            }
        }

        public DelayObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.downstream = observer;
            this.delay = j;
            this.unit = timeUnit;
            this.w = worker;
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            long j;
            OnError onError = new OnError(th);
            if (this.delayError) {
                j = this.delay;
            } else {
                j = 0;
            }
            this.w.schedule(onError, j, this.unit);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.w.schedule(new OnNext(t), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = false;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        Observer<? super T> serializedObserver;
        if (this.delayError) {
            serializedObserver = observer;
        } else {
            serializedObserver = new SerializedObserver(observer);
        }
        this.source.subscribe(new DelayObserver(serializedObserver, this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
