package com.google.firebase.crashlytics.internal.common;

import android.util.Log;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class ExecutorUtils {
    public static ExecutorService buildSingleThreadExecutorService(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1L);
        final ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.1.1
                    @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
                    public final void onRun() {
                        runnable.run();
                    }
                });
                newThread.setName(str + atomicLong.getAndIncrement());
                return newThread;
            }
        }, new ThreadPoolExecutor.DiscardPolicy()));
        final TimeUnit timeUnit = TimeUnit.SECONDS;
        Runtime.getRuntime().addShutdownHook(new Thread(new BackgroundPriorityRunnable() { // from class: com.google.firebase.crashlytics.internal.common.ExecutorUtils.2
            public final /* synthetic */ long val$terminationTimeout = 2;

            @Override // com.google.firebase.crashlytics.internal.common.BackgroundPriorityRunnable
            public final void onRun() {
                boolean z;
                boolean z2;
                String str2 = str;
                ExecutorService executorService = unconfigurableExecutorService;
                boolean z3 = false;
                try {
                    String str3 = "Executing shutdown hook for " + str2;
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        Log.d("FirebaseCrashlytics", str3, null);
                    }
                    executorService.shutdown();
                    if (!executorService.awaitTermination(this.val$terminationTimeout, timeUnit)) {
                        String str4 = str2 + " did not shut down in the allocated time. Requesting immediate shutdown.";
                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            Log.d("FirebaseCrashlytics", str4, null);
                        }
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    String format = String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", str2);
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        z3 = true;
                    }
                    if (z3) {
                        Log.d("FirebaseCrashlytics", format, null);
                    }
                    executorService.shutdownNow();
                }
            }
        }, "Crashlytics Shutdown Hook for ".concat(str)));
        return unconfigurableExecutorService;
    }
}
