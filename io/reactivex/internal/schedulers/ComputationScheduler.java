package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ComputationScheduler extends Scheduler {
    public static final int MAX_THREADS;
    public static final FixedSchedulerPool NONE;
    public static final PoolWorker SHUTDOWN_WORKER;
    public static final RxThreadFactory THREAD_FACTORY;
    public final AtomicReference<FixedSchedulerPool> pool;

    /* loaded from: classes.dex */
    public static final class FixedSchedulerPool {
        public final int cores;
        public final PoolWorker[] eventLoops;
        public long n;

        public FixedSchedulerPool(int r4, ThreadFactory threadFactory) {
            this.cores = r4;
            this.eventLoops = new PoolWorker[r4];
            for (int r0 = 0; r0 < r4; r0++) {
                this.eventLoops[r0] = new PoolWorker(threadFactory);
            }
        }

        public final PoolWorker getEventLoop() {
            int r0 = this.cores;
            if (r0 == 0) {
                return ComputationScheduler.SHUTDOWN_WORKER;
            }
            long j = this.n;
            this.n = 1 + j;
            return this.eventLoops[(int) (j % r0)];
        }
    }

    /* loaded from: classes.dex */
    public static final class PoolWorker extends NewThreadWorker {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        MAX_THREADS = availableProcessors;
        PoolWorker poolWorker = new PoolWorker(new RxThreadFactory("RxComputationShutdown"));
        SHUTDOWN_WORKER = poolWorker;
        poolWorker.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        THREAD_FACTORY = rxThreadFactory;
        FixedSchedulerPool fixedSchedulerPool = new FixedSchedulerPool(0, rxThreadFactory);
        NONE = fixedSchedulerPool;
        for (PoolWorker poolWorker2 : fixedSchedulerPool.eventLoops) {
            poolWorker2.dispose();
        }
    }

    public ComputationScheduler() {
        int r4;
        boolean z;
        FixedSchedulerPool fixedSchedulerPool = NONE;
        this.pool = new AtomicReference<>(fixedSchedulerPool);
        FixedSchedulerPool fixedSchedulerPool2 = new FixedSchedulerPool(MAX_THREADS, THREAD_FACTORY);
        while (true) {
            AtomicReference<FixedSchedulerPool> atomicReference = this.pool;
            if (atomicReference.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2)) {
                z = true;
                break;
            } else if (atomicReference.get() != fixedSchedulerPool) {
                z = false;
                break;
            }
        }
        if (!z) {
            for (PoolWorker poolWorker : fixedSchedulerPool2.eventLoops) {
                poolWorker.dispose();
            }
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new EventLoopWorker(this.pool.get().getEventLoop());
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        PoolWorker eventLoop = this.pool.get().getEventLoop();
        eventLoop.getClass();
        RxJavaPlugins.onSchedule(runnable);
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        ScheduledExecutorService scheduledExecutorService = eventLoop.executor;
        try {
            if (j <= 0) {
                schedule = scheduledExecutorService.submit(scheduledDirectTask);
            } else {
                schedule = scheduledExecutorService.schedule(scheduledDirectTask, j, timeUnit);
            }
            scheduledDirectTask.setFuture(schedule);
            return scheduledDirectTask;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(ObservableInterval.IntervalObserver intervalObserver, long j, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        PoolWorker eventLoop = this.pool.get().getEventLoop();
        eventLoop.getClass();
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = eventLoop.executor;
            InstantPeriodicTask instantPeriodicTask = new InstantPeriodicTask(intervalObserver, scheduledExecutorService);
            try {
                if (j <= 0) {
                    schedule = scheduledExecutorService.submit(instantPeriodicTask);
                } else {
                    schedule = scheduledExecutorService.schedule(instantPeriodicTask, j, timeUnit);
                }
                instantPeriodicTask.setFirst(schedule);
                return instantPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(intervalObserver);
        try {
            scheduledDirectPeriodicTask.setFuture(eventLoop.executor.scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        FixedSchedulerPool fixedSchedulerPool;
        int r4;
        boolean z;
        do {
            AtomicReference<FixedSchedulerPool> atomicReference = this.pool;
            fixedSchedulerPool = atomicReference.get();
            FixedSchedulerPool fixedSchedulerPool2 = NONE;
            if (fixedSchedulerPool == fixedSchedulerPool2) {
                return;
            }
            while (true) {
                if (atomicReference.compareAndSet(fixedSchedulerPool, fixedSchedulerPool2)) {
                    z = true;
                    break;
                } else if (atomicReference.get() != fixedSchedulerPool) {
                    z = false;
                    break;
                }
            }
        } while (!z);
        for (PoolWorker poolWorker : fixedSchedulerPool.eventLoops) {
            poolWorker.dispose();
        }
    }

    /* loaded from: classes.dex */
    public static final class EventLoopWorker extends Scheduler.Worker {
        public final ListCompositeDisposable both;
        public volatile boolean disposed;
        public final PoolWorker poolWorker;
        public final ListCompositeDisposable serial;
        public final CompositeDisposable timed;

        public EventLoopWorker(PoolWorker poolWorker) {
            this.poolWorker = poolWorker;
            ListCompositeDisposable listCompositeDisposable = new ListCompositeDisposable();
            this.serial = listCompositeDisposable;
            CompositeDisposable compositeDisposable = new CompositeDisposable();
            this.timed = compositeDisposable;
            ListCompositeDisposable listCompositeDisposable2 = new ListCompositeDisposable();
            this.both = listCompositeDisposable2;
            listCompositeDisposable2.add(listCompositeDisposable);
            listCompositeDisposable2.add(compositeDisposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.both.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, 0L, TimeUnit.MILLISECONDS, this.serial);
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            return this.poolWorker.scheduleActual(runnable, j, timeUnit, this.timed);
        }
    }
}
