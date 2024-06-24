package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractObservableWithUpstream<T, Observable<T>> {
    public final int capacityHint;
    public final ObservableSource<B> other;

    /* loaded from: classes.dex */
    public static final class WindowBoundaryInnerObserver<T, B> extends DisposableObserver<B> {
        public boolean done;
        public final WindowBoundaryMainObserver<T, B> parent;

        public WindowBoundaryInnerObserver(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.parent = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.parent;
            DisposableHelper.dispose(windowBoundaryMainObserver.upstream);
            windowBoundaryMainObserver.done = true;
            windowBoundaryMainObserver.drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.parent;
            DisposableHelper.dispose(windowBoundaryMainObserver.upstream);
            if (windowBoundaryMainObserver.errors.addThrowable(th)) {
                windowBoundaryMainObserver.done = true;
                windowBoundaryMainObserver.drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(B b) {
            if (this.done) {
                return;
            }
            Object obj = WindowBoundaryMainObserver.NEXT_WINDOW;
            WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver = this.parent;
            windowBoundaryMainObserver.queue.offer(obj);
            windowBoundaryMainObserver.drain();
        }
    }

    /* loaded from: classes.dex */
    public static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        public static final Object NEXT_WINDOW = new Object();
        public final int capacityHint;
        public volatile boolean done;
        public final Observer<? super Observable<T>> downstream;
        public UnicastSubject<T> window;
        public final WindowBoundaryInnerObserver<T, B> boundaryObserver = new WindowBoundaryInnerObserver<>(this);
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final AtomicInteger windows = new AtomicInteger(1);
        public final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicBoolean stopWindows = new AtomicBoolean();

        public WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, int r2) {
            this.downstream = observer;
            this.capacityHint = r2;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void drain() {
            boolean z;
            if (getAndIncrement() != 0) {
                return;
            }
            Observer<? super Observable<T>> observer = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int r4 = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z2 = this.done;
                if (z2 && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable terminate = atomicThrowable.terminate();
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate);
                    }
                    observer.onError(terminate);
                    return;
                }
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    Throwable terminate2 = atomicThrowable.terminate();
                    if (terminate2 == null) {
                        if (unicastSubject != 0) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        observer.onComplete();
                        return;
                    }
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onError(terminate2);
                    }
                    observer.onError(terminate2);
                    return;
                }
                if (z) {
                    r4 = addAndGet(-r4);
                    if (r4 == 0) {
                        return;
                    }
                } else if (poll != NEXT_WINDOW) {
                    unicastSubject.onNext(poll);
                } else {
                    if (unicastSubject != 0) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> unicastSubject2 = new UnicastSubject<>(this.capacityHint, this);
                        this.window = unicastSubject2;
                        this.windows.getAndIncrement();
                        observer.onNext(unicastSubject2);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.boundaryObserver.dispose();
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this.upstream, disposable)) {
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    public ObservableWindowBoundary(ObservableSource observableSource, Observable observable, int r3) {
        super(observableSource);
        this.other = observable;
        this.capacityHint = r3;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(observer, this.capacityHint);
        observer.onSubscribe(windowBoundaryMainObserver);
        this.other.subscribe(windowBoundaryMainObserver.boundaryObserver);
        this.source.subscribe(windowBoundaryMainObserver);
    }
}
