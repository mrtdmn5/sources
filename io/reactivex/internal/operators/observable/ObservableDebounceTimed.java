package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    public final Scheduler scheduler;
    public final long timeout;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Runnable, Disposable {
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final DebounceTimedObserver<T> parent;
        public final T value;

        public DebounceEmitter(T t, long j, DebounceTimedObserver<T> debounceTimedObserver) {
            this.value = t;
            this.idx = j;
            this.parent = debounceTimedObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.once.compareAndSet(false, true)) {
                DebounceTimedObserver<T> debounceTimedObserver = this.parent;
                long j = this.idx;
                T t = this.value;
                if (j == debounceTimedObserver.index) {
                    debounceTimedObserver.downstream.onNext(t);
                    DisposableHelper.dispose(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        public boolean done;
        public final Observer<? super T> downstream;
        public volatile long index;
        public final long timeout;
        public DebounceEmitter timer;
        public final TimeUnit unit;
        public Disposable upstream;
        public final Scheduler.Worker worker;

        public DebounceTimedObserver(SerializedObserver serializedObserver, long j, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.downstream = serializedObserver;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            DebounceEmitter debounceEmitter = this.timer;
            if (debounceEmitter != null) {
                DisposableHelper.dispose(debounceEmitter);
            }
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            DebounceEmitter debounceEmitter = this.timer;
            if (debounceEmitter != null) {
                DisposableHelper.dispose(debounceEmitter);
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            long j = this.index + 1;
            this.index = j;
            DebounceEmitter debounceEmitter = this.timer;
            if (debounceEmitter != null) {
                DisposableHelper.dispose(debounceEmitter);
            }
            DebounceEmitter debounceEmitter2 = new DebounceEmitter(t, j, this);
            this.timer = debounceEmitter2;
            DisposableHelper.replace(debounceEmitter2, this.worker.schedule(debounceEmitter2, this.timeout, this.unit));
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(ObservableSource observableSource, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.timeout = 10L;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.timeout, this.unit, this.scheduler.createWorker()));
    }
}
