package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservablePublish<T> extends ConnectableObservable<T> implements ObservablePublishClassic<T> {
    public final AtomicReference<PublishObserver<T>> current;
    public final ObservableSource<T> onSubscribe;
    public final ObservableSource<T> source;

    /* loaded from: classes.dex */
    public static final class InnerDisposable<T> extends AtomicReference<Object> implements Disposable {
        public final Observer<? super T> child;

        public InnerDisposable(Observer<? super T> observer) {
            this.child = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Object andSet = getAndSet(this);
            if (andSet != null && andSet != this) {
                ((PublishObserver) andSet).remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == this) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static final class PublishObserver<T> implements Observer<T>, Disposable {
        public static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        public static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        public final AtomicReference<PublishObserver<T>> current;
        public final AtomicReference<Disposable> upstream = new AtomicReference<>();
        public final AtomicReference<InnerDisposable<T>[]> observers = new AtomicReference<>(EMPTY);
        public final AtomicBoolean shouldConnect = new AtomicBoolean();

        public PublishObserver(AtomicReference<PublishObserver<T>> atomicReference) {
            this.current = atomicReference;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            AtomicReference<PublishObserver<T>> atomicReference;
            AtomicReference<InnerDisposable<T>[]> atomicReference2 = this.observers;
            InnerDisposable<T>[] innerDisposableArr = TERMINATED;
            if (atomicReference2.getAndSet(innerDisposableArr) == innerDisposableArr) {
                return;
            }
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
            if (this.observers.get() == TERMINATED) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            AtomicReference<PublishObserver<T>> atomicReference;
            do {
                atomicReference = this.current;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            for (InnerDisposable<T> innerDisposable : this.observers.getAndSet(TERMINATED)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable th) {
            AtomicReference<PublishObserver<T>> atomicReference;
            do {
                atomicReference = this.current;
                if (atomicReference.compareAndSet(this, null)) {
                    break;
                }
            } while (atomicReference.get() == this);
            InnerDisposable<T>[] andSet = this.observers.getAndSet(TERMINATED);
            if (andSet.length != 0) {
                for (InnerDisposable<T> innerDisposable : andSet) {
                    innerDisposable.child.onError(th);
                }
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.observers.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.upstream, disposable);
        }

        public final void remove(InnerDisposable<T> innerDisposable) {
            boolean z;
            InnerDisposable<T>[] innerDisposableArr;
            do {
                AtomicReference<InnerDisposable<T>[]> atomicReference = this.observers;
                InnerDisposable<T>[] innerDisposableArr2 = atomicReference.get();
                int length = innerDisposableArr2.length;
                if (length == 0) {
                    return;
                }
                z = false;
                int r4 = 0;
                while (true) {
                    if (r4 < length) {
                        if (innerDisposableArr2[r4].equals(innerDisposable)) {
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
                    innerDisposableArr = EMPTY;
                } else {
                    InnerDisposable<T>[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr2, 0, innerDisposableArr3, 0, r4);
                    System.arraycopy(innerDisposableArr2, r4 + 1, innerDisposableArr3, r4, (length - r4) - 1);
                    innerDisposableArr = innerDisposableArr3;
                }
                while (true) {
                    if (atomicReference.compareAndSet(innerDisposableArr2, innerDisposableArr)) {
                        z = true;
                        break;
                    } else if (atomicReference.get() != innerDisposableArr2) {
                        break;
                    }
                }
            } while (!z);
        }
    }

    /* loaded from: classes.dex */
    public static final class PublishSource<T> implements ObservableSource<T> {
        public final AtomicReference<PublishObserver<T>> curr;

        public PublishSource(AtomicReference<PublishObserver<T>> atomicReference) {
            this.curr = atomicReference;
        }

        @Override // io.reactivex.ObservableSource
        public final void subscribe(Observer<? super T> observer) {
            boolean z;
            PublishObserver<T> publishObserver;
            boolean z2;
            InnerDisposable<T> innerDisposable = new InnerDisposable<>(observer);
            observer.onSubscribe(innerDisposable);
            while (true) {
                AtomicReference<PublishObserver<T>> atomicReference = this.curr;
                PublishObserver<T> publishObserver2 = atomicReference.get();
                boolean z3 = false;
                if (publishObserver2 != null && !publishObserver2.isDisposed()) {
                    publishObserver = publishObserver2;
                } else {
                    PublishObserver<T> publishObserver3 = new PublishObserver<>(atomicReference);
                    while (true) {
                        if (atomicReference.compareAndSet(publishObserver2, publishObserver3)) {
                            z = true;
                            break;
                        } else if (atomicReference.get() != publishObserver2) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        publishObserver = publishObserver3;
                    } else {
                        continue;
                    }
                }
                while (true) {
                    AtomicReference<InnerDisposable<T>[]> atomicReference2 = publishObserver.observers;
                    InnerDisposable<T>[] innerDisposableArr = atomicReference2.get();
                    if (innerDisposableArr == PublishObserver.TERMINATED) {
                        break;
                    }
                    int length = innerDisposableArr.length;
                    InnerDisposable<T>[] innerDisposableArr2 = new InnerDisposable[length + 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                    innerDisposableArr2[length] = innerDisposable;
                    while (true) {
                        if (atomicReference2.compareAndSet(innerDisposableArr, innerDisposableArr2)) {
                            z2 = true;
                            break;
                        } else if (atomicReference2.get() != innerDisposableArr) {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    break;
                }
            }
            if (!innerDisposable.compareAndSet(null, publishObserver)) {
                publishObserver.remove(innerDisposable);
            }
        }
    }

    public ObservablePublish(PublishSource publishSource, ObservableSource observableSource, AtomicReference atomicReference) {
        this.onSubscribe = publishSource;
        this.source = observableSource;
        this.current = atomicReference;
    }

    @Override // io.reactivex.observables.ConnectableObservable
    public final void connect(Consumer<? super Disposable> consumer) {
        PublishObserver<T> publishObserver;
        boolean z;
        boolean z2;
        while (true) {
            AtomicReference<PublishObserver<T>> atomicReference = this.current;
            publishObserver = atomicReference.get();
            z = false;
            if (publishObserver != null && !publishObserver.isDisposed()) {
                break;
            }
            PublishObserver<T> publishObserver2 = new PublishObserver<>(atomicReference);
            while (true) {
                if (atomicReference.compareAndSet(publishObserver, publishObserver2)) {
                    z2 = true;
                    break;
                } else if (atomicReference.get() != publishObserver) {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                publishObserver = publishObserver2;
                break;
            }
        }
        if (!publishObserver.shouldConnect.get() && publishObserver.shouldConnect.compareAndSet(false, true)) {
            z = true;
        }
        try {
            consumer.accept(publishObserver);
            if (z) {
                this.source.subscribe(publishObserver);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    @Override // io.reactivex.internal.operators.observable.ObservablePublishClassic
    public final ObservableSource<T> publishSource() {
        return this.source;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        this.onSubscribe.subscribe(observer);
    }
}
