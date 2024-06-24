package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class PublishSubject<T> extends Subject<T> {
    public Throwable error;
    public final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);
    public static final PublishDisposable[] TERMINATED = new PublishDisposable[0];
    public static final PublishDisposable[] EMPTY = new PublishDisposable[0];

    /* loaded from: classes.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        public final Observer<? super T> downstream;
        public final PublishSubject<T> parent;

        public PublishDisposable(Observer<? super T> observer, PublishSubject<T> publishSubject) {
            this.downstream = observer;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return get();
        }
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
        PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
        PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        PublishDisposable<T>[] andSet = atomicReference.getAndSet(publishDisposableArr2);
        for (PublishDisposable<T> publishDisposable : andSet) {
            if (!publishDisposable.get()) {
                publishDisposable.downstream.onComplete();
            }
        }
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        if (th != null) {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
            PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
            PublishDisposable<T>[] publishDisposableArr2 = TERMINATED;
            if (publishDisposableArr == publishDisposableArr2) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.error = th;
            PublishDisposable<T>[] andSet = atomicReference.getAndSet(publishDisposableArr2);
            for (PublishDisposable<T> publishDisposable : andSet) {
                if (publishDisposable.get()) {
                    RxJavaPlugins.onError(th);
                } else {
                    publishDisposable.downstream.onError(th);
                }
            }
            return;
        }
        throw new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onNext(T t) {
        if (t != null) {
            for (PublishDisposable<T> publishDisposable : this.subscribers.get()) {
                if (!publishDisposable.get()) {
                    publishDisposable.downstream.onNext(t);
                }
            }
            return;
        }
        throw new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    public final void remove(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        boolean z;
        do {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
            PublishDisposable<T>[] publishDisposableArr2 = atomicReference.get();
            if (publishDisposableArr2 != TERMINATED && publishDisposableArr2 != (publishDisposableArr = EMPTY)) {
                int length = publishDisposableArr2.length;
                z = false;
                int r5 = 0;
                while (true) {
                    if (r5 < length) {
                        if (publishDisposableArr2[r5] == publishDisposable) {
                            break;
                        } else {
                            r5++;
                        }
                    } else {
                        r5 = -1;
                        break;
                    }
                }
                if (r5 < 0) {
                    return;
                }
                if (length != 1) {
                    publishDisposableArr = new PublishDisposable[length - 1];
                    System.arraycopy(publishDisposableArr2, 0, publishDisposableArr, 0, r5);
                    System.arraycopy(publishDisposableArr2, r5 + 1, publishDisposableArr, r5, (length - r5) - 1);
                }
                while (true) {
                    if (atomicReference.compareAndSet(publishDisposableArr2, publishDisposableArr)) {
                        z = true;
                        break;
                    } else if (atomicReference.get() != publishDisposableArr2) {
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        boolean z;
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        while (true) {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
            PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
            z = false;
            if (publishDisposableArr == TERMINATED) {
                break;
            }
            int length = publishDisposableArr.length;
            PublishDisposable<T>[] publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
            while (true) {
                if (atomicReference.compareAndSet(publishDisposableArr, publishDisposableArr2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != publishDisposableArr) {
                    break;
                }
            }
            if (z) {
                z = true;
                break;
            }
        }
        if (z) {
            if (publishDisposable.get()) {
                remove(publishDisposable);
            }
        } else {
            Throwable th = this.error;
            if (th != null) {
                observer.onError(th);
            } else {
                observer.onComplete();
            }
        }
    }
}
