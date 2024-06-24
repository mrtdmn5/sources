package androidx.work.impl.utils;

import androidx.work.impl.utils.futures.SettableFuture;
import java.util.List;

/* loaded from: classes.dex */
public abstract class StatusRunnable<T> implements Runnable {
    public final SettableFuture<T> mFuture = new SettableFuture<>();

    @Override // java.lang.Runnable
    public final void run() {
        SettableFuture<T> settableFuture = this.mFuture;
        try {
            settableFuture.set(runInternal$1());
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    public abstract List runInternal$1();
}
