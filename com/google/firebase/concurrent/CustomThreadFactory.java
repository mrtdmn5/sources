package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class CustomThreadFactory implements ThreadFactory {
    public static final ThreadFactory DEFAULT = Executors.defaultThreadFactory();
    public final String namePrefix;
    public final StrictMode.ThreadPolicy policy;
    public final int priority;
    public final AtomicLong threadCount = new AtomicLong();

    public CustomThreadFactory(String str, int r3, StrictMode.ThreadPolicy threadPolicy) {
        this.namePrefix = str;
        this.priority = r3;
        this.policy = threadPolicy;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(final Runnable runnable) {
        Thread newThread = DEFAULT.newThread(new Runnable() { // from class: com.google.firebase.concurrent.CustomThreadFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CustomThreadFactory customThreadFactory = CustomThreadFactory.this;
                Process.setThreadPriority(customThreadFactory.priority);
                StrictMode.ThreadPolicy threadPolicy = customThreadFactory.policy;
                if (threadPolicy != null) {
                    StrictMode.setThreadPolicy(threadPolicy);
                }
                runnable.run();
            }
        });
        newThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.namePrefix, Long.valueOf(this.threadCount.getAndIncrement())));
        return newThread;
    }
}
