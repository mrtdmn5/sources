package io.reactivex.internal.operators.observable;

import android.Manifest;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final int bufferSize;
    public final ErrorMode delayErrors;
    public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;

    /* loaded from: classes.dex */
    public static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public final DelayErrorInnerObserver<R> observer;
        public SimpleQueue<T> queue;
        public int sourceMode;
        public final boolean tillTheEnd;
        public Disposable upstream;

        /* loaded from: classes.dex */
        public static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            public final Observer<? super R> downstream;
            public final ConcatMapDelayErrorObserver<?, R> parent;

            public DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.downstream = observer;
                this.parent = concatMapDelayErrorObserver;
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                concatMapDelayErrorObserver.active = false;
                concatMapDelayErrorObserver.drain();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.parent;
                if (concatMapDelayErrorObserver.error.addThrowable(th)) {
                    if (!concatMapDelayErrorObserver.tillTheEnd) {
                        concatMapDelayErrorObserver.upstream.dispose();
                    }
                    concatMapDelayErrorObserver.active = false;
                    concatMapDelayErrorObserver.drain();
                    return;
                }
                RxJavaPlugins.onError(th);
            }

            @Override // io.reactivex.Observer
            public final void onNext(R r) {
                this.downstream.onNext(r);
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int r3, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.bufferSize = r3;
            this.tillTheEnd = z;
            this.observer = new DelayErrorInnerObserver<>(observer, this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            DelayErrorInnerObserver<R> delayErrorInnerObserver = this.observer;
            delayErrorInnerObserver.getClass();
            DisposableHelper.dispose(delayErrorInnerObserver);
        }

        public final void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super R> observer = this.downstream;
            SimpleQueue<T> simpleQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        simpleQueue.clear();
                        return;
                    }
                    if (!this.tillTheEnd && atomicThrowable.get() != null) {
                        simpleQueue.clear();
                        this.cancelled = true;
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    try {
                        T poll = simpleQueue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            this.cancelled = true;
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                observer.onError(terminate);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                        if (!z) {
                            try {
                                ObservableSource<? extends R> apply = this.mapper.apply(poll);
                                ObjectHelper.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource<? extends R> observableSource = apply;
                                if (observableSource instanceof Callable) {
                                    try {
                                        Manifest manifest = (Object) ((Callable) observableSource).call();
                                        if (manifest != null && !this.cancelled) {
                                            observer.onNext(manifest);
                                        }
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        atomicThrowable.addThrowable(th);
                                    }
                                } else {
                                    this.active = true;
                                    observableSource.subscribe(this.observer);
                                }
                            } catch (Throwable th2) {
                                Exceptions.throwIfFatal(th2);
                                this.cancelled = true;
                                this.upstream.dispose();
                                simpleQueue.clear();
                                atomicThrowable.addThrowable(th2);
                                observer.onError(atomicThrowable.terminate());
                                return;
                            }
                        }
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        this.cancelled = true;
                        this.upstream.dispose();
                        atomicThrowable.addThrowable(th3);
                        observer.onError(atomicThrowable.terminate());
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.error.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        public volatile boolean active;
        public final int bufferSize;
        public volatile boolean disposed;
        public volatile boolean done;
        public final Observer<? super U> downstream;
        public int fusionMode;
        public final InnerObserver<U> inner;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        public SimpleQueue<T> queue;
        public Disposable upstream;

        /* loaded from: classes.dex */
        public static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            public final Observer<? super U> downstream;
            public final SourceObserver<?, ?> parent;

            public InnerObserver(SerializedObserver serializedObserver, SourceObserver sourceObserver) {
                this.downstream = serializedObserver;
                this.parent = sourceObserver;
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                SourceObserver<?, ?> sourceObserver = this.parent;
                sourceObserver.active = false;
                sourceObserver.drain();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            @Override // io.reactivex.Observer
            public final void onNext(U u) {
                this.downstream.onNext(u);
            }

            @Override // io.reactivex.Observer
            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }
        }

        public SourceObserver(SerializedObserver serializedObserver, Function function, int r3) {
            this.downstream = serializedObserver;
            this.mapper = function;
            this.bufferSize = r3;
            this.inner = new InnerObserver<>(serializedObserver, this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.disposed = true;
            InnerObserver<U> innerObserver = this.inner;
            innerObserver.getClass();
            DisposableHelper.dispose(innerObserver);
            this.upstream.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public final void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            while (!this.disposed) {
                if (!this.active) {
                    boolean z2 = this.done;
                    try {
                        T poll = this.queue.poll();
                        if (poll == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z2 && z) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            return;
                        }
                        if (!z) {
                            try {
                                ObservableSource<? extends U> apply = this.mapper.apply(poll);
                                ObjectHelper.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource<? extends U> observableSource = apply;
                                this.active = true;
                                observableSource.subscribe(this.inner);
                            } catch (Throwable th) {
                                Exceptions.throwIfFatal(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.fusionMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = queueDisposable;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableConcatMap(Observable observable, int r3, ErrorMode errorMode) {
        super(observable);
        Functions.Identity identity = Functions.IDENTITY;
        this.mapper = identity;
        this.delayErrors = errorMode;
        this.bufferSize = Math.max(8, r3);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        boolean z;
        ObservableSource<T> observableSource = this.source;
        Function<? super T, ? extends ObservableSource<? extends U>> function = this.mapper;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(observableSource, observer, function)) {
            return;
        }
        ErrorMode errorMode = ErrorMode.IMMEDIATE;
        int r3 = this.bufferSize;
        ErrorMode errorMode2 = this.delayErrors;
        if (errorMode2 == errorMode) {
            observableSource.subscribe(new SourceObserver(new SerializedObserver(observer), function, r3));
            return;
        }
        if (errorMode2 == ErrorMode.END) {
            z = true;
        } else {
            z = false;
        }
        observableSource.subscribe(new ConcatMapDelayErrorObserver(observer, function, r3, z));
    }
}
