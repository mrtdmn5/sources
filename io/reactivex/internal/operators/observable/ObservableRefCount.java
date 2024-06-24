package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableRefCount<T> extends Observable<T> {
    public RefConnection connection;
    public final int n;
    public final ConnectableObservable<T> source;

    /* loaded from: classes.dex */
    public static final class RefConnection extends AtomicReference<Disposable> implements Runnable, Consumer<Disposable> {
        public boolean connected;
        public boolean disconnectedEarly;
        public final ObservableRefCount<?> parent;
        public long subscriberCount;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Disposable disposable) throws Exception {
            Disposable disposable2 = disposable;
            DisposableHelper.replace(this, disposable2);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((ResettableConnectable) this.parent.source).resetIf(disposable2);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.parent.timeout(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class RefCountObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        public final RefConnection connection;
        public final Observer<? super T> downstream;
        public final ObservableRefCount<T> parent;
        public Disposable upstream;

        public RefCountObserver(Observer<? super T> observer, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = observer;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                ObservableRefCount<T> observableRefCount = this.parent;
                RefConnection refConnection = this.connection;
                synchronized (observableRefCount) {
                    RefConnection refConnection2 = observableRefCount.connection;
                    if (refConnection2 != null && refConnection2 == refConnection) {
                        long j = refConnection.subscriberCount - 1;
                        refConnection.subscriberCount = j;
                        if (j == 0 && refConnection.connected) {
                            observableRefCount.timeout(refConnection);
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                this.parent.terminated(this.connection);
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.source = connectableObservable;
        this.n = 1;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.connection;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.connection = refConnection;
            }
            long j = refConnection.subscriberCount;
            int r3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            if (!refConnection.connected && j2 == this.n) {
                z = true;
                refConnection.connected = true;
            } else {
                z = false;
            }
        }
        this.source.subscribe(new RefCountObserver(observer, this, refConnection));
        if (z) {
            this.source.connect(refConnection);
        }
    }

    public final void terminated(RefConnection refConnection) {
        synchronized (this) {
            if (this.source instanceof ObservablePublishClassic) {
                RefConnection refConnection2 = this.connection;
                if (refConnection2 != null && refConnection2 == refConnection) {
                    this.connection = null;
                    refConnection.getClass();
                }
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0) {
                    ConnectableObservable<T> connectableObservable = this.source;
                    if (connectableObservable instanceof Disposable) {
                        ((Disposable) connectableObservable).dispose();
                    } else if (connectableObservable instanceof ResettableConnectable) {
                        ((ResettableConnectable) connectableObservable).resetIf(refConnection.get());
                    }
                }
            } else {
                RefConnection refConnection3 = this.connection;
                if (refConnection3 != null && refConnection3 == refConnection) {
                    refConnection.getClass();
                    long j2 = refConnection.subscriberCount - 1;
                    refConnection.subscriberCount = j2;
                    if (j2 == 0) {
                        this.connection = null;
                        ConnectableObservable<T> connectableObservable2 = this.source;
                        if (connectableObservable2 instanceof Disposable) {
                            ((Disposable) connectableObservable2).dispose();
                        } else if (connectableObservable2 instanceof ResettableConnectable) {
                            ((ResettableConnectable) connectableObservable2).resetIf(refConnection.get());
                        }
                    }
                }
            }
        }
    }

    public final void timeout(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.connection) {
                this.connection = null;
                Disposable disposable = refConnection.get();
                DisposableHelper.dispose(refConnection);
                ConnectableObservable<T> connectableObservable = this.source;
                if (connectableObservable instanceof Disposable) {
                    ((Disposable) connectableObservable).dispose();
                } else if (connectableObservable instanceof ResettableConnectable) {
                    if (disposable == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((ResettableConnectable) connectableObservable).resetIf(disposable);
                    }
                }
            }
        }
    }
}
