package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class SafeLoggingExecutor implements Executor {
    public final Executor delegate;

    /* loaded from: classes3.dex */
    public static class SafeLoggingRunnable implements Runnable {
        public final Runnable delegate;

        public SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.delegate.run();
            } catch (Exception e) {
                Logging.e("Executor", "Background execution failure.", e);
            }
        }
    }

    public SafeLoggingExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.delegate.execute(new SafeLoggingRunnable(runnable));
    }
}
