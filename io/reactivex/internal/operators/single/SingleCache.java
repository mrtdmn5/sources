package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    public static final CacheDisposable[] EMPTY = new CacheDisposable[0];
    public static final CacheDisposable[] TERMINATED = new CacheDisposable[0];
    public Throwable error;
    public final SingleSource<? extends T> source;
    public T value;
    public final AtomicInteger wip = new AtomicInteger();
    public final AtomicReference<CacheDisposable<T>[]> observers = new AtomicReference<>(EMPTY);

    /* loaded from: classes.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        public final SingleObserver<? super T> downstream;
        public final SingleCache<T> parent;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            this.downstream = singleObserver;
            this.parent = singleCache;
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

    public SingleCache(SingleDoOnError singleDoOnError) {
        this.source = singleDoOnError;
    }

    @Override // io.reactivex.SingleObserver
    public final void onError(Throwable th) {
        this.error = th;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.get()) {
                cacheDisposable.downstream.onError(th);
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onSuccess(T t) {
        this.value = t;
        for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
            if (!cacheDisposable.get()) {
                cacheDisposable.downstream.onSuccess(t);
            }
        }
    }

    public final void remove(CacheDisposable<T> cacheDisposable) {
        boolean z;
        CacheDisposable<T>[] cacheDisposableArr;
        do {
            AtomicReference<CacheDisposable<T>[]> atomicReference = this.observers;
            CacheDisposable<T>[] cacheDisposableArr2 = atomicReference.get();
            int length = cacheDisposableArr2.length;
            if (length == 0) {
                return;
            }
            z = false;
            int r4 = 0;
            while (true) {
                if (r4 < length) {
                    if (cacheDisposableArr2[r4] == cacheDisposable) {
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
                cacheDisposableArr = EMPTY;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr2, 0, cacheDisposableArr3, 0, r4);
                System.arraycopy(cacheDisposableArr2, r4 + 1, cacheDisposableArr3, r4, (length - r4) - 1);
                cacheDisposableArr = cacheDisposableArr3;
            }
            while (true) {
                if (atomicReference.compareAndSet(cacheDisposableArr2, cacheDisposableArr)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != cacheDisposableArr2) {
                    break;
                }
            }
        } while (!z);
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super T> singleObserver) {
        boolean z;
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(singleObserver, this);
        singleObserver.onSubscribe(cacheDisposable);
        while (true) {
            AtomicReference<CacheDisposable<T>[]> atomicReference = this.observers;
            CacheDisposable<T>[] cacheDisposableArr = atomicReference.get();
            z = false;
            if (cacheDisposableArr == TERMINATED) {
                break;
            }
            int length = cacheDisposableArr.length;
            CacheDisposable<T>[] cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
            while (true) {
                if (atomicReference.compareAndSet(cacheDisposableArr, cacheDisposableArr2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != cacheDisposableArr) {
                    break;
                }
            }
            if (z) {
                z = true;
                break;
            }
        }
        if (z) {
            if (cacheDisposable.get()) {
                remove(cacheDisposable);
            }
            if (this.wip.getAndIncrement() == 0) {
                this.source.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            singleObserver.onError(th);
        } else {
            singleObserver.onSuccess(this.value);
        }
    }

    @Override // io.reactivex.SingleObserver
    public final void onSubscribe(Disposable disposable) {
    }
}
