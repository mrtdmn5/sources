package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ResettableConnectable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservablePublishAlt<T> extends ConnectableObservable<T> implements ResettableConnectable {
    public final AtomicReference<PublishConnection<T>> current = new AtomicReference<>();
    public final ObservableSource<T> source;

    /* loaded from: classes.dex */
    public static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        public final Observer<? super T> downstream;

        public InnerDisposable(Observer<? super T> observer, PublishConnection<T> publishConnection) {
            this.downstream = observer;
            lazySet(publishConnection);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {
        public static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        public static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        public final AtomicReference<PublishConnection<T>> current;
        public Throwable error;
        public final AtomicBoolean connect = new AtomicBoolean();
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(EMPTY);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            AtomicReference<PublishConnection<T>> atomicReference;
            getAndSet(TERMINATED);
            do {
                atomicReference = this.current;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == TERMINATED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            this.error = th;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public final void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int r3 = 0;
                while (true) {
                    if (r3 < length) {
                        if (innerDisposableArr[r3] == innerDisposable) {
                            break;
                        } else {
                            r3++;
                        }
                    } else {
                        r3 = -1;
                        break;
                    }
                }
                if (r3 < 0) {
                    return;
                }
                innerDisposableArr2 = EMPTY;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, r3);
                    System.arraycopy(innerDisposableArr, r3 + 1, innerDisposableArr2, r3, (length - r3) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublishAlt(ObservableSource<T> observableSource) {
        this.source = observableSource;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public final void connect(Consumer<? super Disposable> consumer) {
        PublishConnection<T> publishConnection;
        boolean z;
        boolean z2;
        while (true) {
            AtomicReference<PublishConnection<T>> atomicReference = this.current;
            publishConnection = atomicReference.get();
            z = false;
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishConnection, publishConnection2)) {
                    z2 = true;
                    break;
                } else if (atomicReference.get() != publishConnection) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                publishConnection = publishConnection2;
                break;
            }
        }
        if (!publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishConnection);
            if (z) {
                this.source.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.disposables.ResettableConnectable
    public final void resetIf(Disposable disposable) {
        AtomicReference<PublishConnection<T>> atomicReference = this.current;
        PublishConnection<T> publishConnection = (PublishConnection) disposable;
        while (!atomicReference.compareAndSet(publishConnection, null) && atomicReference.get() == publishConnection) {
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        PublishConnection<T> publishConnection;
        boolean z;
        boolean z2;
        while (true) {
            AtomicReference<PublishConnection<T>> atomicReference = this.current;
            publishConnection = atomicReference.get();
            z = false;
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishConnection, publishConnection2)) {
                    z2 = true;
                    break;
                } else if (atomicReference.get() != publishConnection) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(observer, publishConnection);
        observer.onSubscribe(innerDisposable);
        while (true) {
            InnerDisposable<T>[] innerDisposableArr = publishConnection.get();
            if (innerDisposableArr == PublishConnection.TERMINATED) {
                break;
            }
            int length = innerDisposableArr.length;
            InnerDisposable[] innerDisposableArr2 = new InnerDisposable[length + 1];
            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
            innerDisposableArr2[length] = innerDisposable;
            if (publishConnection.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                z = true;
                break;
            }
        }
        if (z) {
            if (innerDisposable.isDisposed()) {
                publishConnection.remove(innerDisposable);
            }
        } else {
            Throwable th = publishConnection.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }
}
