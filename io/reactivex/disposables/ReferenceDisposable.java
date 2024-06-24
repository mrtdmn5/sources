package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    public ReferenceDisposable(T t) {
        super(t);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            onDisposed(andSet);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    public abstract void onDisposed(T t);
}
