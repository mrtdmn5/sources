package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class NewThreadScheduler extends Scheduler {
    public static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())), false);
    public final ThreadFactory threadFactory = THREAD_FACTORY;

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
