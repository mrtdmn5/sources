package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    public static final int PURGE_PERIOD_SECONDS;
    public static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    public static final ConcurrentHashMap POOLS = new ConcurrentHashMap();

    /* loaded from: classes.dex */
    public static final class ScheduledTask implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            Iterator it = new ArrayList(SchedulerPoolFactory.POOLS.keySet()).iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) it.next();
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003a A[LOOP:0: B:12:0x003a->B:22:0x0070, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_THREAD = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            io.reactivex.internal.schedulers.SchedulerPoolFactory.POOLS = r0
            java.lang.String r0 = "rx2.purge-enabled"
            r1 = 1
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L18
            goto L20
        L18:
            java.lang.String r2 = "true"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L20
            goto L21
        L20:
            r0 = r1
        L21:
            io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_ENABLED = r0
            java.lang.String r2 = "rx2.purge-period-seconds"
            if (r0 == 0) goto L33
            java.lang.String r0 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L33
            if (r0 != 0) goto L2e
            goto L33
        L2e:
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Throwable -> L33
            goto L34
        L33:
            r0 = r1
        L34:
            io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_PERIOD_SECONDS = r0
            boolean r0 = io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_ENABLED
            if (r0 == 0) goto L74
        L3a:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ScheduledExecutorService> r0 = io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_THREAD
            java.lang.Object r2 = r0.get()
            java.util.concurrent.ScheduledExecutorService r2 = (java.util.concurrent.ScheduledExecutorService) r2
            if (r2 == 0) goto L45
            goto L74
        L45:
            io.reactivex.internal.schedulers.RxThreadFactory r3 = new io.reactivex.internal.schedulers.RxThreadFactory
            java.lang.String r4 = "RxSchedulerPurge"
            r3.<init>(r4)
            java.util.concurrent.ScheduledExecutorService r5 = java.util.concurrent.Executors.newScheduledThreadPool(r1, r3)
        L50:
            boolean r3 = r0.compareAndSet(r2, r5)
            if (r3 == 0) goto L58
            r0 = r1
            goto L5f
        L58:
            java.lang.Object r3 = r0.get()
            if (r3 == r2) goto L50
            r0 = 0
        L5f:
            if (r0 == 0) goto L70
            io.reactivex.internal.schedulers.SchedulerPoolFactory$ScheduledTask r6 = new io.reactivex.internal.schedulers.SchedulerPoolFactory$ScheduledTask
            r6.<init>()
            int r0 = io.reactivex.internal.schedulers.SchedulerPoolFactory.PURGE_PERIOD_SECONDS
            long r9 = (long) r0
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
            r7 = r9
            r5.scheduleAtFixedRate(r6, r7, r9, r11)
            goto L74
        L70:
            r5.shutdownNow()
            goto L3a
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.schedulers.SchedulerPoolFactory.<clinit>():void");
    }
}
