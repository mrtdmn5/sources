package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableFlatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    public final int bufferSize;
    public final boolean delayErrors;
    public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
    public final int maxConcurrency;

    /* loaded from: classes.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<Disposable> implements Observer<U> {
        public volatile boolean done;
        public int fusionMode;
        public final long id;
        public final MergeObserver<T, U> parent;
        public volatile SimpleQueue<U> queue;

        public InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.id = j;
            this.parent = mergeObserver;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.parent.errors.addThrowable(th)) {
                MergeObserver<T, U> mergeObserver = this.parent;
                if (!mergeObserver.delayErrors) {
                    mergeObserver.disposeAll();
                }
                this.done = true;
                this.parent.drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(U u) {
            if (this.fusionMode == 0) {
                MergeObserver<T, U> mergeObserver = this.parent;
                if (mergeObserver.get() == 0 && mergeObserver.compareAndSet(0, 1)) {
                    mergeObserver.downstream.onNext(u);
                    if (mergeObserver.decrementAndGet() == 0) {
                        return;
                    }
                } else {
                    SimpleQueue simpleQueue = this.queue;
                    if (simpleQueue == null) {
                        simpleQueue = new SpscLinkedArrayQueue(mergeObserver.bufferSize);
                        this.queue = simpleQueue;
                    }
                    simpleQueue.offer(u);
                    if (mergeObserver.getAndIncrement() != 0) {
                        return;
                    }
                }
                mergeObserver.drainLoop();
                return;
            }
            this.parent.drain();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable) && (disposable instanceof QueueDisposable)) {
                QueueDisposable queueDisposable = (QueueDisposable) disposable;
                int requestFusion = queueDisposable.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                    this.done = true;
                    this.parent.drain();
                    return;
                }
                if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = queueDisposable;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class MergeObserver<T, U> extends AtomicInteger implements Disposable, Observer<T> {
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final Observer<? super U> downstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final Function<? super T, ? extends ObservableSource<? extends U>> mapper;
        public final int maxConcurrency;
        public final AtomicReference<InnerObserver<?, ?>[]> observers;
        public volatile SimplePlainQueue<U> queue;
        public final ArrayDeque sources;
        public long uniqueId;
        public Disposable upstream;
        public int wip;
        public static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        public static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        public MergeObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, boolean z, int r5, int r6) {
            this.downstream = observer;
            this.mapper = function;
            this.delayErrors = z;
            this.maxConcurrency = r5;
            this.bufferSize = r6;
            if (r5 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(r5);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        public final boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (!this.delayErrors && th != null) {
                disposeAll();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                return true;
            }
            return false;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Throwable terminate;
            if (!this.cancelled) {
                this.cancelled = true;
                if (disposeAll() && (terminate = this.errors.terminate()) != null && terminate != ExceptionHelper.TERMINATED) {
                    RxJavaPlugins.onError(terminate);
                }
            }
        }

        public final boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.upstream.dispose();
            AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.observers;
            InnerObserver<?, ?>[] innerObserverArr = atomicReference.get();
            InnerObserver<?, ?>[] innerObserverArr2 = CANCELLED;
            if (innerObserverArr == innerObserverArr2 || (andSet = atomicReference.getAndSet(innerObserverArr2)) == innerObserverArr2) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.getClass();
                DisposableHelper.dispose(innerObserver);
            }
            return true;
        }

        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:131:0x0004, code lost:            continue;     */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:            if (r11 != null) goto L110;     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:            r11 = r10.done;        r12 = r10.queue;     */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00d7, code lost:            if (r11 == false) goto L83;     */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00d9, code lost:            if (r12 == null) goto L79;     */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00df, code lost:            if (r12.isEmpty() == false) goto L83;     */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00e1, code lost:            removeInner(r10);     */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00e8, code lost:            if (checkTerminate() == false) goto L82;     */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00eb, code lost:            r4 = r4 + 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ea, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00ed, code lost:            r7 = r7 + 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:            if (r7 != r6) goto L133;     */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00f1, code lost:            r7 = 0;     */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00f2, code lost:            r3 = r3 + 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a5, code lost:            r12 = r11.poll();     */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00a9, code lost:            if (r12 != null) goto L64;     */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:            r0.onNext(r12);     */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00b3, code lost:            if (checkTerminate() == false) goto L135;     */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00b5, code lost:            return;     */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00b6, code lost:            r11 = move-exception;     */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00b7, code lost:            io.reactivex.exceptions.Exceptions.throwIfFatal(r11);        io.reactivex.internal.disposables.DisposableHelper.dispose(r10);        r13.errors.addThrowable(r11);     */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x00c6, code lost:            if (checkTerminate() != false) goto L119;     */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x00c9, code lost:            removeInner(r10);        r4 = r4 + 1;        r7 = r7 + 1;     */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00d0, code lost:            if (r7 != r6) goto L132;     */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x00c8, code lost:            return;     */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void drainLoop() {
            /*
                Method dump skipped, instructions count: 299
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.drainLoop():void");
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.cancelled;
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
            } else if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                ObservableSource<? extends U> apply = this.mapper.apply(t);
                ObjectHelper.requireNonNull(apply, "The mapper returned a null ObservableSource");
                ObservableSource<? extends U> observableSource = apply;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int r0 = this.wip;
                        if (r0 == this.maxConcurrency) {
                            this.sources.offer(observableSource);
                            return;
                        }
                        this.wip = r0 + 1;
                    }
                }
                subscribeInner(observableSource);
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

        /* JADX WARN: Multi-variable type inference failed */
        public final void removeInner(InnerObserver<T, U> innerObserver) {
            boolean z;
            InnerObserver<?, ?>[] innerObserverArr;
            do {
                AtomicReference<InnerObserver<?, ?>[]> atomicReference = this.observers;
                InnerObserver<?, ?>[] innerObserverArr2 = atomicReference.get();
                int length = innerObserverArr2.length;
                if (length == 0) {
                    return;
                }
                z = false;
                int r4 = 0;
                while (true) {
                    if (r4 < length) {
                        if (innerObserverArr2[r4] == innerObserver) {
                            break;
                        } else {
                            r4++;
                        }
                    } else {
                        r4 = -1;
                        break;
                    }
                }
                if (r4 < 0) {
                    return;
                }
                if (length == 1) {
                    innerObserverArr = EMPTY;
                } else {
                    InnerObserver<?, ?>[] innerObserverArr3 = new InnerObserver[length - 1];
                    System.arraycopy(innerObserverArr2, 0, innerObserverArr3, 0, r4);
                    System.arraycopy(innerObserverArr2, r4 + 1, innerObserverArr3, r4, (length - r4) - 1);
                    innerObserverArr = innerObserverArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerObserverArr2, innerObserverArr)) {
                        z = true;
                        break;
                    } else if (atomicReference.get() != innerObserverArr2) {
                        break;
                    }
                }
            } while (!z);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:            if (decrementAndGet() == 0) goto L31;     */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v8, types: [io.reactivex.internal.fuseable.SimpleQueue] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void subscribeInner(io.reactivex.ObservableSource<? extends U> r8) {
            /*
                r7 = this;
            L0:
                boolean r0 = r8 instanceof java.util.concurrent.Callable
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L8f
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                r0 = 2147483647(0x7fffffff, float:NaN)
                java.lang.Object r8 = r8.call()     // Catch: java.lang.Throwable -> L60
                if (r8 != 0) goto L12
                goto L6c
            L12:
                int r3 = r7.get()
                if (r3 != 0) goto L2a
                boolean r3 = r7.compareAndSet(r2, r1)
                if (r3 == 0) goto L2a
                io.reactivex.Observer<? super U> r3 = r7.downstream
                r3.onNext(r8)
                int r8 = r7.decrementAndGet()
                if (r8 != 0) goto L5c
                goto L6c
            L2a:
                io.reactivex.internal.fuseable.SimplePlainQueue<U> r3 = r7.queue
                if (r3 != 0) goto L43
                int r3 = r7.maxConcurrency
                if (r3 != r0) goto L3a
                io.reactivex.internal.queue.SpscLinkedArrayQueue r3 = new io.reactivex.internal.queue.SpscLinkedArrayQueue
                int r4 = r7.bufferSize
                r3.<init>(r4)
                goto L41
            L3a:
                io.reactivex.internal.queue.SpscArrayQueue r3 = new io.reactivex.internal.queue.SpscArrayQueue
                int r4 = r7.maxConcurrency
                r3.<init>(r4)
            L41:
                r7.queue = r3
            L43:
                boolean r8 = r3.offer(r8)
                if (r8 != 0) goto L54
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r3 = "Scalar queue full?!"
                r8.<init>(r3)
                r7.onError(r8)
                goto L6c
            L54:
                int r8 = r7.getAndIncrement()
                if (r8 == 0) goto L5c
                r8 = r2
                goto L6d
            L5c:
                r7.drainLoop()
                goto L6c
            L60:
                r8 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r8)
                io.reactivex.internal.util.AtomicThrowable r3 = r7.errors
                r3.addThrowable(r8)
                r7.drain()
            L6c:
                r8 = r1
            L6d:
                if (r8 == 0) goto Lcc
                int r8 = r7.maxConcurrency
                if (r8 == r0) goto Lcc
                monitor-enter(r7)
                java.util.ArrayDeque r8 = r7.sources     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r8 = r8.poll()     // Catch: java.lang.Throwable -> L8c
                io.reactivex.ObservableSource r8 = (io.reactivex.ObservableSource) r8     // Catch: java.lang.Throwable -> L8c
                if (r8 != 0) goto L84
                int r0 = r7.wip     // Catch: java.lang.Throwable -> L8c
                int r0 = r0 - r1
                r7.wip = r0     // Catch: java.lang.Throwable -> L8c
                goto L85
            L84:
                r1 = r2
            L85:
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L8c
                if (r1 == 0) goto L0
                r7.drain()
                goto Lcc
            L8c:
                r8 = move-exception
                monitor-exit(r7)     // Catch: java.lang.Throwable -> L8c
                throw r8
            L8f:
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver r0 = new io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver
                long r3 = r7.uniqueId
                r5 = 1
                long r5 = r5 + r3
                r7.uniqueId = r5
                r0.<init>(r7, r3)
            L9b:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver<?, ?>[]> r3 = r7.observers
                java.lang.Object r4 = r3.get()
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r4 = (io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[]) r4
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver<?, ?>[] r5 = io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.CANCELLED
                if (r4 != r5) goto Lac
                io.reactivex.internal.disposables.DisposableHelper.dispose(r0)
                r1 = r2
                goto Lc7
            Lac:
                int r5 = r4.length
                int r6 = r5 + 1
                io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver[] r6 = new io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver[r6]
                java.lang.System.arraycopy(r4, r2, r6, r2, r5)
                r6[r5] = r0
            Lb6:
                boolean r5 = r3.compareAndSet(r4, r6)
                if (r5 == 0) goto Lbe
                r3 = r1
                goto Lc5
            Lbe:
                java.lang.Object r5 = r3.get()
                if (r5 == r4) goto Lb6
                r3 = r2
            Lc5:
                if (r3 == 0) goto L9b
            Lc7:
                if (r1 == 0) goto Lcc
                r8.subscribe(r0)
            Lcc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMap.MergeObserver.subscribeInner(io.reactivex.ObservableSource):void");
        }
    }

    public ObservableFlatMap(ObservableSource observableSource, Function function, int r3, int r4) {
        super(observableSource);
        this.mapper = function;
        this.delayErrors = false;
        this.maxConcurrency = r3;
        this.bufferSize = r4;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> observer) {
        Function<? super T, ? extends ObservableSource<? extends U>> function = this.mapper;
        ObservableSource<T> observableSource = this.source;
        if (ObservableScalarXMap.tryScalarXMapSubscribe(observableSource, observer, function)) {
            return;
        }
        observableSource.subscribe(new MergeObserver(observer, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
    }
}
