package io.reactivex;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.schedulers.NewThreadWorker;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class Scheduler {
    public static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* loaded from: classes3.dex */
    public static final class DisposeTask implements Disposable, Runnable {
        public final Runnable decoratedRun;
        public Thread runner;
        public final Worker w;

        public DisposeTask(Runnable runnable, Worker worker) {
            this.decoratedRun = runnable;
            this.w = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.runner == Thread.currentThread()) {
                Worker worker = this.w;
                if (worker instanceof NewThreadWorker) {
                    NewThreadWorker newThreadWorker = (NewThreadWorker) worker;
                    if (!newThreadWorker.disposed) {
                        newThreadWorker.disposed = true;
                        newThreadWorker.executor.shutdown();
                        return;
                    }
                    return;
                }
            }
            this.w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.w.isDisposed();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.runner = Thread.currentThread();
            try {
                this.decoratedRun.run();
            } finally {
                dispose();
                this.runner = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class PeriodicDirectTask implements Disposable, Runnable {
        public volatile boolean disposed;
        public final Runnable run;
        public final Worker worker;

        public PeriodicDirectTask(ObservableInterval.IntervalObserver intervalObserver, Worker worker) {
            this.run = intervalObserver;
            this.worker = worker;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.disposed = true;
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.disposed) {
                try {
                    this.run.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.worker.dispose();
                    throw ExceptionHelper.wrapOrThrow(th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Worker implements Disposable {

        /* loaded from: classes3.dex */
        public final class PeriodicTask implements Runnable {
            public long count;
            public final Runnable decoratedRun;
            public long lastNowNanoseconds;
            public final long periodInNanoseconds;
            public final SequentialDisposable sd;
            public long startInNanoseconds;

            public PeriodicTask(long j, Runnable runnable, long j2, SequentialDisposable sequentialDisposable, long j3) {
                this.decoratedRun = runnable;
                this.sd = sequentialDisposable;
                this.periodInNanoseconds = j3;
                this.lastNowNanoseconds = j2;
                this.startInNanoseconds = j;
            }

            @Override // java.lang.Runnable
            public final void run() {
                long j;
                this.decoratedRun.run();
                SequentialDisposable sequentialDisposable = this.sd;
                if (!sequentialDisposable.isDisposed()) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    Worker worker = Worker.this;
                    worker.getClass();
                    long now = Worker.now(timeUnit);
                    long j2 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                    long j3 = now + j2;
                    long j4 = this.lastNowNanoseconds;
                    long j5 = this.periodInNanoseconds;
                    if (j3 >= j4 && now < j4 + j5 + j2) {
                        long j6 = this.startInNanoseconds;
                        long j7 = this.count + 1;
                        this.count = j7;
                        j = (j7 * j5) + j6;
                    } else {
                        j = now + j5;
                        long j8 = this.count + 1;
                        this.count = j8;
                        this.startInNanoseconds = j - (j5 * j8);
                    }
                    this.lastNowNanoseconds = now;
                    DisposableHelper.replace(sequentialDisposable, worker.schedule(this, j - now, timeUnit));
                }
            }
        }

        public static long now(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable schedule(Runnable runnable) {
            return schedule(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit);

        public final Disposable schedulePeriodically(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            long nanos = timeUnit.toNanos(j2);
            long now = now(TimeUnit.NANOSECONDS);
            Disposable schedule = schedule(new PeriodicTask(timeUnit.toNanos(j) + now, runnable, now, sequentialDisposable2, nanos), j, timeUnit);
            if (schedule == EmptyDisposable.INSTANCE) {
                return schedule;
            }
            DisposableHelper.replace(sequentialDisposable, schedule);
            return sequentialDisposable2;
        }
    }

    public abstract Worker createWorker();

    public Disposable scheduleDirect(Runnable runnable) {
        return scheduleDirect(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public Disposable schedulePeriodicallyDirect(ObservableInterval.IntervalObserver intervalObserver, long j, long j2, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        PeriodicDirectTask periodicDirectTask = new PeriodicDirectTask(intervalObserver, createWorker);
        Disposable schedulePeriodically = createWorker.schedulePeriodically(periodicDirectTask, j, j2, timeUnit);
        if (schedulePeriodically == EmptyDisposable.INSTANCE) {
            return schedulePeriodically;
        }
        return periodicDirectTask;
    }

    public Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        Worker createWorker = createWorker();
        RxJavaPlugins.onSchedule(runnable);
        DisposeTask disposeTask = new DisposeTask(runnable, createWorker);
        createWorker.schedule(disposeTask, j, timeUnit);
        return disposeTask;
    }

    public void shutdown() {
    }
}
