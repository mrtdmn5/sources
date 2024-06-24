package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class UnicastSubject<T> extends Subject<T> {
    public final boolean delayError;
    public volatile boolean disposed;
    public volatile boolean done;
    public final AtomicReference<Observer<? super T>> downstream;
    public boolean enableOperatorFusion;
    public Throwable error;
    public final AtomicReference<Runnable> onTerminate;
    public final AtomicBoolean once;
    public final SpscLinkedArrayQueue<T> queue;
    public final UnicastQueueDisposable wip;

    /* loaded from: classes.dex */
    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        public UnicastQueueDisposable() {
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final void clear() {
            UnicastSubject.this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!UnicastSubject.this.disposed) {
                UnicastSubject.this.disposed = true;
                UnicastSubject.this.doTerminate();
                UnicastSubject.this.downstream.lazySet(null);
                if (UnicastSubject.this.wip.getAndIncrement() == 0) {
                    UnicastSubject.this.downstream.lazySet(null);
                    UnicastSubject unicastSubject = UnicastSubject.this;
                    if (!unicastSubject.enableOperatorFusion) {
                        unicastSubject.queue.clear();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return UnicastSubject.this.disposed;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final boolean isEmpty() {
            return UnicastSubject.this.queue.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public final T poll() throws Exception {
            return UnicastSubject.this.queue.poll();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public final int requestFusion(int r3) {
            if ((r3 & 2) != 0) {
                UnicastSubject.this.enableOperatorFusion = true;
                return 2;
            }
            return 0;
        }
    }

    public UnicastSubject(int r3, Runnable runnable) {
        ObjectHelper.verifyPositive(r3, "capacityHint");
        this.queue = new SpscLinkedArrayQueue<>(r3);
        if (runnable != null) {
            this.onTerminate = new AtomicReference<>(runnable);
            this.delayError = true;
            this.downstream = new AtomicReference<>();
            this.once = new AtomicBoolean();
            this.wip = new UnicastQueueDisposable();
            return;
        }
        throw new NullPointerException("onTerminate");
    }

    public final void doTerminate() {
        boolean z;
        AtomicReference<Runnable> atomicReference = this.onTerminate;
        Runnable runnable = atomicReference.get();
        if (runnable == null) {
            return;
        }
        while (true) {
            if (atomicReference.compareAndSet(runnable, null)) {
                z = true;
                break;
            } else if (atomicReference.get() != runnable) {
                z = false;
                break;
            }
        }
        if (z) {
            runnable.run();
        }
    }

    public final void drain() {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        Observer<? super T> observer = this.downstream.get();
        int r2 = 1;
        while (observer == null) {
            r2 = this.wip.addAndGet(-r2);
            if (r2 == 0) {
                return;
            } else {
                observer = this.downstream.get();
            }
        }
        if (this.enableOperatorFusion) {
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            boolean z4 = !this.delayError;
            int r6 = 1;
            while (!this.disposed) {
                boolean z5 = this.done;
                if (z4 && z5) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.lazySet(null);
                        spscLinkedArrayQueue.clear();
                        observer.onError(th);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        return;
                    }
                }
                observer.onNext(null);
                if (z5) {
                    this.downstream.lazySet(null);
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        observer.onError(th2);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
                r6 = this.wip.addAndGet(-r6);
                if (r6 == 0) {
                    return;
                }
            }
            this.downstream.lazySet(null);
            return;
        }
        SpscLinkedArrayQueue<T> spscLinkedArrayQueue2 = this.queue;
        boolean z6 = !this.delayError;
        boolean z7 = true;
        int r7 = 1;
        while (!this.disposed) {
            boolean z8 = this.done;
            T poll = this.queue.poll();
            if (poll == null) {
                z = true;
            } else {
                z = false;
            }
            if (z8) {
                if (z6 && z7) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        this.downstream.lazySet(null);
                        spscLinkedArrayQueue2.clear();
                        observer.onError(th3);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        z7 = false;
                    } else {
                        return;
                    }
                }
                if (z) {
                    this.downstream.lazySet(null);
                    Throwable th4 = this.error;
                    if (th4 != null) {
                        observer.onError(th4);
                        return;
                    } else {
                        observer.onComplete();
                        return;
                    }
                }
            }
            if (z) {
                r7 = this.wip.addAndGet(-r7);
                if (r7 == 0) {
                    return;
                }
            } else {
                observer.onNext(poll);
            }
        }
        this.downstream.lazySet(null);
        spscLinkedArrayQueue2.clear();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (!this.done && !this.disposed) {
            this.done = true;
            doTerminate();
            drain();
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (th != null) {
            if (!this.done && !this.disposed) {
                this.error = th;
                this.done = true;
                doTerminate();
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
            return;
        }
        throw new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (t != null) {
            if (!this.done && !this.disposed) {
                this.queue.offer(t);
                drain();
                return;
            }
            return;
        }
        throw new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.done || this.disposed) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        if (!this.once.get() && this.once.compareAndSet(false, true)) {
            observer.onSubscribe(this.wip);
            this.downstream.lazySet(observer);
            if (this.disposed) {
                this.downstream.lazySet(null);
                return;
            } else {
                drain();
                return;
            }
        }
        EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), observer);
    }
}
