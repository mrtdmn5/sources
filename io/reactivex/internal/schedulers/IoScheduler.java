package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class IoScheduler extends Scheduler {
    public static final RxThreadFactory EVICTOR_THREAD_FACTORY;
    public static final CachedWorkerPool NONE;
    public static final ThreadWorker SHUTDOWN_THREAD_WORKER;
    public static final RxThreadFactory WORKER_THREAD_FACTORY;
    public final AtomicReference<CachedWorkerPool> pool;
    public static final TimeUnit KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    public static final long KEEP_ALIVE_TIME = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* loaded from: classes.dex */
    public static final class CachedWorkerPool implements Runnable {
        public final CompositeDisposable allWorkers;
        public final ScheduledExecutorService evictorService;
        public final ScheduledFuture evictorTask;
        public final ConcurrentLinkedQueue<ThreadWorker> expiringWorkerQueue;
        public final long keepAliveTime;
        public final ThreadFactory threadFactory;

        public CachedWorkerPool(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            long j2;
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            long j3 = j2;
            this.keepAliveTime = j3;
            this.expiringWorkerQueue = new ConcurrentLinkedQueue<>();
            this.allWorkers = new CompositeDisposable();
            this.threadFactory = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, IoScheduler.EVICTOR_THREAD_FACTORY);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.evictorService = scheduledExecutorService;
            this.evictorTask = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ConcurrentLinkedQueue<ThreadWorker> concurrentLinkedQueue = this.expiringWorkerQueue;
            if (!concurrentLinkedQueue.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<ThreadWorker> it = concurrentLinkedQueue.iterator();
                while (it.hasNext()) {
                    ThreadWorker next = it.next();
                    if (next.expirationTime <= nanoTime) {
                        if (concurrentLinkedQueue.remove(next)) {
                            this.allWorkers.remove(next);
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public final void shutdown() {
            this.allWorkers.dispose();
            ScheduledFuture scheduledFuture = this.evictorTask;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.evictorService;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class EventLoopWorker extends Scheduler.Worker {
        public final CachedWorkerPool pool;
        public final ThreadWorker threadWorker;
        public final AtomicBoolean once = new AtomicBoolean();
        public final CompositeDisposable tasks = new CompositeDisposable();

        public EventLoopWorker(CachedWorkerPool cachedWorkerPool) {
            ThreadWorker threadWorker;
            ThreadWorker threadWorker2;
            this.pool = cachedWorkerPool;
            if (cachedWorkerPool.allWorkers.disposed) {
                threadWorker2 = IoScheduler.SHUTDOWN_THREAD_WORKER;
                this.threadWorker = threadWorker2;
            }
            while (true) {
                if (!cachedWorkerPool.expiringWorkerQueue.isEmpty()) {
                    threadWorker = cachedWorkerPool.expiringWorkerQueue.poll();
                    if (threadWorker != null) {
                        break;
                    }
                } else {
                    threadWorker = new ThreadWorker(cachedWorkerPool.threadFactory);
                    cachedWorkerPool.allWorkers.add(threadWorker);
                    break;
                }
            }
            threadWorker2 = threadWorker;
            this.threadWorker = threadWorker2;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.once.compareAndSet(false, true)) {
                this.tasks.dispose();
                CachedWorkerPool cachedWorkerPool = this.pool;
                cachedWorkerPool.getClass();
                long nanoTime = System.nanoTime() + cachedWorkerPool.keepAliveTime;
                ThreadWorker threadWorker = this.threadWorker;
                threadWorker.expirationTime = nanoTime;
                cachedWorkerPool.expiringWorkerQueue.offer(threadWorker);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.once.get();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.tasks.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.threadWorker.scheduleActual(runnable, j, timeUnit, this.tasks);
        }
    }

    /* loaded from: classes.dex */
    public static final class ThreadWorker extends NewThreadWorker {
        public long expirationTime;

        public ThreadWorker(ThreadFactory threadFactory) {
            super(threadFactory);
            this.expirationTime = 0L;
        }
    }

    static {
        ThreadWorker threadWorker = new ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        SHUTDOWN_THREAD_WORKER = threadWorker;
        threadWorker.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max, false);
        WORKER_THREAD_FACTORY = rxThreadFactory;
        EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor", max, false);
        CachedWorkerPool cachedWorkerPool = new CachedWorkerPool(0L, null, rxThreadFactory);
        NONE = cachedWorkerPool;
        cachedWorkerPool.shutdown();
    }

    public IoScheduler() {
        boolean z;
        CachedWorkerPool cachedWorkerPool = NONE;
        this.pool = new AtomicReference<>(cachedWorkerPool);
        CachedWorkerPool cachedWorkerPool2 = new CachedWorkerPool(KEEP_ALIVE_TIME, KEEP_ALIVE_UNIT, WORKER_THREAD_FACTORY);
        while (true) {
            AtomicReference<CachedWorkerPool> atomicReference = this.pool;
            if (atomicReference.compareAndSet(cachedWorkerPool, cachedWorkerPool2)) {
                z = true;
                break;
            } else if (atomicReference.get() != cachedWorkerPool) {
                z = false;
                break;
            }
        }
        if (!z) {
            cachedWorkerPool2.shutdown();
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get());
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        CachedWorkerPool cachedWorkerPool;
        boolean z;
        do {
            AtomicReference<CachedWorkerPool> atomicReference = this.pool;
            cachedWorkerPool = atomicReference.get();
            CachedWorkerPool cachedWorkerPool2 = NONE;
            if (cachedWorkerPool == cachedWorkerPool2) {
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(cachedWorkerPool, cachedWorkerPool2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != cachedWorkerPool) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        cachedWorkerPool.shutdown();
    }
}
