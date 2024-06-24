package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;

    /* loaded from: classes.dex */
    public static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        public final int bufferSize;
        public volatile boolean done;
        public final long index;
        public final SwitchMapObserver<T, R> parent;
        public volatile SimpleQueue<R> queue;

        public SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j, int r4) {
            this.parent = switchMapObserver;
            this.index = j;
            this.bufferSize = r4;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            SwitchMapObserver<T, R> switchMapObserver = this.parent;
            switchMapObserver.getClass();
            if (this.index == switchMapObserver.unique && switchMapObserver.errors.addThrowable(th)) {
                if (!switchMapObserver.delayErrors) {
                    switchMapObserver.upstream.dispose();
                    switchMapObserver.done = true;
                }
                this.done = true;
                switchMapObserver.drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.drain();
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int requestFusion = queueDisposable.requestFusion(7);
                    if (requestFusion == 1) {
                        this.queue = queueDisposable;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = queueDisposable;
                        return;
                    }
                }
                this.queue = new SpscLinkedArrayQueue(this.bufferSize);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        public static final SwitchMapInnerObserver<Object, Object> CANCELLED;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Observer<? super R> downstream;
        public final Function<? super T, ? extends ObservableSource<? extends R>> mapper;
        public volatile long unique;
        public Disposable upstream;
        public final AtomicReference<SwitchMapInnerObserver<T, R>> active = new AtomicReference<>();
        public final AtomicThrowable errors = new AtomicThrowable();

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>(null, -1L, 1);
            CANCELLED = switchMapInnerObserver;
            DisposableHelper.dispose(switchMapInnerObserver);
        }

        public SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int r4, boolean z) {
            this.downstream = observer;
            this.mapper = function;
            this.bufferSize = r4;
            this.delayErrors = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                disposeInner();
            }
        }

        public final void disposeInner() {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.active;
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver2 = (SwitchMapInnerObserver) atomicReference.get();
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver3 = CANCELLED;
            if (switchMapInnerObserver2 != switchMapInnerObserver3 && (switchMapInnerObserver = (SwitchMapInnerObserver) atomicReference.getAndSet(switchMapInnerObserver3)) != switchMapInnerObserver3 && switchMapInnerObserver != null) {
                DisposableHelper.dispose(switchMapInnerObserver);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:80:0x0114 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x000f A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void drain() {
            /*
                Method dump skipped, instructions count: 284
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.drain():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (!this.done && this.errors.addThrowable(th)) {
                if (!this.delayErrors) {
                    disposeInner();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            boolean z;
            long j = this.unique + 1;
            this.unique = j;
            SwitchMapInnerObserver<T, R> switchMapInnerObserver = this.active.get();
            if (switchMapInnerObserver != null) {
                DisposableHelper.dispose(switchMapInnerObserver);
            }
            try {
                ObservableSource<? extends R> apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The ObservableSource returned is null");
                ObservableSource<? extends R> observableSource = apply;
                SwitchMapInnerObserver<T, R> switchMapInnerObserver2 = new SwitchMapInnerObserver<>(this, j, this.bufferSize);
                do {
                    SwitchMapInnerObserver<T, R> switchMapInnerObserver3 = this.active.get();
                    if (switchMapInnerObserver3 != CANCELLED) {
                        AtomicReference<SwitchMapInnerObserver<T, R>> atomicReference = this.active;
                        while (true) {
                            if (atomicReference.compareAndSet(switchMapInnerObserver3, switchMapInnerObserver2)) {
                                z = true;
                                break;
                            } else if (atomicReference.get() != switchMapInnerObserver3) {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!z);
                observableSource.subscribe(switchMapInnerObserver2);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSwitchMap(Observable observable, Function function, int r3) {
        super(observable);
        this.mapper = function;
        this.bufferSize = r3;
        this.delayErrors = false;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        ObservableSource<T> observableSource = this.source;
        Function<? super T, ? extends ObservableSource<? extends R>> function = this.mapper;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(observableSource, observer, function)) {
            return;
        }
        observableSource.subscribe(new SwitchMapObserver(observer, function, this.bufferSize, this.delayErrors));
    }
}
