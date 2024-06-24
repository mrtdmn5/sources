package androidx.arch.core.executor;

import androidx.work.WorkContinuation;

/* loaded from: classes.dex */
public final class ArchTaskExecutor extends WorkContinuation {
    public static final ArchTaskExecutor$$ExternalSyntheticLambda0 sIOThreadExecutor = new ArchTaskExecutor$$ExternalSyntheticLambda0();
    public static volatile ArchTaskExecutor sInstance;
    public final DefaultTaskExecutor mDelegate = new DefaultTaskExecutor();

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            if (sInstance == null) {
                sInstance = new ArchTaskExecutor();
            }
        }
        return sInstance;
    }

    public final void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    public final boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    public final void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }
}
