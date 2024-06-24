package io.reactivex.disposables;

/* loaded from: classes3.dex */
public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    @Override // io.reactivex.disposables.ReferenceDisposable
    public final void onDisposed(Runnable runnable) {
        runnable.run();
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }
}
