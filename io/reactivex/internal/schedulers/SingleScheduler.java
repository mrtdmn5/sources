package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleScheduler extends Scheduler {
    public static final ScheduledExecutorService SHUTDOWN;
    public static final RxThreadFactory SINGLE_THREAD_FACTORY;
    public final AtomicReference<ScheduledExecutorService> executor;

    /* loaded from: classes.dex */
    public static final class ScheduledWorker extends Scheduler.Worker {
        public volatile boolean disposed;
        public final ScheduledExecutorService executor;
        public final CompositeDisposable tasks = new CompositeDisposable();

        public ScheduledWorker(ScheduledExecutorService scheduledExecutorService) {
            this.executor = scheduledExecutorService;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            Future<?> schedule;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            RxJavaPlugins.onSchedule(runnable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(runnable, this.tasks);
            this.tasks.add(scheduledRunnable);
            try {
                if (j <= 0) {
                    schedule = this.executor.submit((Callable) scheduledRunnable);
                } else {
                    schedule = this.executor.schedule((Callable) scheduledRunnable, j, timeUnit);
                }
                scheduledRunnable.setFuture(schedule);
                return scheduledRunnable;
            } catch (RejectedExecutionException e) {
                dispose();
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        SHUTDOWN = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        SINGLE_THREAD_FACTORY = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public SingleScheduler() {
        this(SINGLE_THREAD_FACTORY);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ScheduledWorker(this.executor.get());
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        RxJavaPlugins.onSchedule(runnable);
        ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
        AtomicReference<ScheduledExecutorService> atomicReference = this.executor;
        try {
            if (j <= 0) {
                schedule = atomicReference.get().submit(scheduledDirectTask);
            } else {
                schedule = atomicReference.get().schedule(scheduledDirectTask, j, timeUnit);
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
        AtomicReference<ScheduledExecutorService> atomicReference = this.executor;
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = atomicReference.get();
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
            scheduledDirectPeriodicTask.setFuture(atomicReference.get().scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
            return scheduledDirectPeriodicTask;
        } catch (RejectedExecutionException e2) {
            RxJavaPlugins.onError(e2);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        ScheduledExecutorService andSet;
        AtomicReference<ScheduledExecutorService> atomicReference = this.executor;
        ScheduledExecutorService scheduledExecutorService = atomicReference.get();
        ScheduledExecutorService scheduledExecutorService2 = SHUTDOWN;
        if (scheduledExecutorService != scheduledExecutorService2 && (andSet = atomicReference.getAndSet(scheduledExecutorService2)) != scheduledExecutorService2) {
            andSet.shutdownNow();
        }
    }

    public SingleScheduler(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.executor = atomicReference;
        boolean z = SchedulerPoolFactory.PURGE_ENABLED;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (SchedulerPoolFactory.PURGE_ENABLED && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            SchedulerPoolFactory.POOLS.put((ScheduledThreadPoolExecutor) newScheduledThreadPool, newScheduledThreadPool);
        }
        atomicReference.lazySet(newScheduledThreadPool);
    }
}
