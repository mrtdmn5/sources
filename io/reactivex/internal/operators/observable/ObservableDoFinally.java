package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class ObservableDoFinally<T> extends AbstractObservableWithUpstream<T, T> {
    public final Action onFinally;

    /* loaded from: classes.dex */
    public static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T> {
        public final Observer<? super T> downstream;
        public final Action onFinally;
        public QueueDisposable<T> qd;
        public boolean syncFused;
        public Disposable upstream;

        public DoFinallyObserver(Observer<? super T> observer, Action action) {
            this.downstream = observer;
            this.onFinally = action;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    this.qd = (QueueDisposable) disposable;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            T poll = this.qd.poll();
            if (poll == null && this.syncFused) {
                runFinally();
            }
            return poll;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r4) {
            QueueDisposable<T> queueDisposable = this.qd;
            boolean z = false;
            if (queueDisposable == null || (r4 & 4) != 0) {
                return 0;
            }
            int requestFusion = queueDisposable.requestFusion(r4);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z = true;
                }
                this.syncFused = z;
            }
            return requestFusion;
        }

        public final void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    public ObservableDoFinally(ObservableSource<T> observableSource, Action action) {
        super(observableSource);
        this.onFinally = action;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DoFinallyObserver(observer, this.onFinally));
    }
}
