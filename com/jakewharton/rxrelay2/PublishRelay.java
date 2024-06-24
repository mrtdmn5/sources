package com.jakewharton.rxrelay2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class PublishRelay<T> extends Relay<T> {
    public static final PublishDisposable[] EMPTY = new PublishDisposable[0];
    public final AtomicReference<PublishDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);

    /* loaded from: classes3.dex */
    public static final class PublishDisposable<T> extends AtomicBoolean implements Disposable {
        public final Observer<? super T> downstream;
        public final PublishRelay<T> parent;

        public PublishDisposable(Observer<? super T> observer, PublishRelay<T> publishRelay) {
            this.downstream = observer;
            this.parent = publishRelay;
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

    @Override // io.reactivex.functions.Consumer
    public final void accept(T t) {
        if (t != null) {
            for (PublishDisposable<T> publishDisposable : this.subscribers.get()) {
                if (!publishDisposable.get()) {
                    publishDisposable.downstream.onNext(t);
                }
            }
            return;
        }
        throw new NullPointerException("value == null");
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public final boolean hasObservers() {
        if (this.subscribers.get().length != 0) {
            return true;
        }
        return false;
    }

    public final void remove(PublishDisposable<T> publishDisposable) {
        boolean z;
        do {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
            PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
            PublishDisposable<T>[] publishDisposableArr2 = EMPTY;
            if (publishDisposableArr == publishDisposableArr2) {
                return;
            }
            int length = publishDisposableArr.length;
            z = false;
            int r5 = 0;
            while (true) {
                if (r5 < length) {
                    if (publishDisposableArr[r5] == publishDisposable) {
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
                publishDisposableArr2 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, r5);
                System.arraycopy(publishDisposableArr, r5 + 1, publishDisposableArr2, r5, (length - r5) - 1);
            }
            while (true) {
                if (atomicReference.compareAndSet(publishDisposableArr, publishDisposableArr2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != publishDisposableArr) {
                    break;
                }
            }
        } while (!z);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> observer) {
        boolean z;
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(observer, this);
        observer.onSubscribe(publishDisposable);
        do {
            AtomicReference<PublishDisposable<T>[]> atomicReference = this.subscribers;
            PublishDisposable<T>[] publishDisposableArr = atomicReference.get();
            int length = publishDisposableArr.length;
            PublishDisposable<T>[] publishDisposableArr2 = new PublishDisposable[length + 1];
            z = false;
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
        } while (!z);
        if (publishDisposable.get()) {
            remove(publishDisposable);
        }
    }
}
