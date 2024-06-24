package io.reactivex.internal.schedulers;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public final boolean nonBlocking;
    public final String prefix;
    public final int priority;

    /* loaded from: classes.dex */
    public static final class RxCustomThread extends Thread {
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.prefix + '-' + incrementAndGet();
        if (this.nonBlocking) {
            thread = new RxCustomThread(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.priority);
        thread.setDaemon(true);
        return thread;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("RxThreadFactory["), this.prefix, "]");
    }

    public RxThreadFactory(String str, int r2, boolean z) {
        this.prefix = str;
        this.priority = r2;
        this.nonBlocking = z;
    }
}
