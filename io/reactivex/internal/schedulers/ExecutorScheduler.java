package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ExecutorScheduler extends Scheduler {
    public static final Scheduler HELPER = Schedulers.SINGLE;
    public final Executor executor;
    public final boolean interruptibleWorker = false;

    /* loaded from: classes.dex */
    public final class DelayedDispose implements Runnable {
        public final DelayedRunnable dr;

        public DelayedDispose(DelayedRunnable delayedRunnable) {
            this.dr = delayedRunnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DelayedRunnable delayedRunnable = this.dr;
            SequentialDisposable sequentialDisposable = delayedRunnable.direct;
            Disposable scheduleDirect = ExecutorScheduler.this.scheduleDirect(delayedRunnable);
            sequentialDisposable.getClass();
            DisposableHelper.replace(sequentialDisposable, scheduleDirect);
        }
    }

    /* loaded from: classes.dex */
    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable {
        public final SequentialDisposable direct;
        public final SequentialDisposable timed;

        public DelayedRunnable(Runnable runnable) {
            super(runnable);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (getAndSet(null) != null) {
                SequentialDisposable sequentialDisposable = this.timed;
                sequentialDisposable.getClass();
                DisposableHelper.dispose(sequentialDisposable);
                SequentialDisposable sequentialDisposable2 = this.direct;
                sequentialDisposable2.getClass();
                DisposableHelper.dispose(sequentialDisposable2);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SequentialDisposable sequentialDisposable = this.direct;
            SequentialDisposable sequentialDisposable2 = this.timed;
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                    sequentialDisposable2.lazySet(disposableHelper);
                    sequentialDisposable.lazySet(disposableHelper);
                } catch (Throwable th) {
                    lazySet(null);
                    sequentialDisposable2.lazySet(DisposableHelper.DISPOSED);
                    sequentialDisposable.lazySet(DisposableHelper.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public ExecutorScheduler(ExecutorService executorService) {
        this.executor = executorService;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.executor, this.interruptibleWorker);
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable) {
        Executor executor = this.executor;
        RxJavaPlugins.onSchedule(runnable);
        try {
            if (executor instanceof ExecutorService) {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
                scheduledDirectTask.setFuture(((ExecutorService) executor).submit(scheduledDirectTask));
                return scheduledDirectTask;
            }
            if (this.interruptibleWorker) {
                ExecutorWorker.InterruptibleRunnable interruptibleRunnable = new ExecutorWorker.InterruptibleRunnable(runnable, null);
                executor.execute(interruptibleRunnable);
                return interruptibleRunnable;
            }
            ExecutorWorker.BooleanRunnable booleanRunnable = new ExecutorWorker.BooleanRunnable(runnable);
            executor.execute(booleanRunnable);
            return booleanRunnable;
        } catch (RejectedExecutionException e) {
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(ObservableInterval.IntervalObserver intervalObserver, long j, long j2, TimeUnit timeUnit) {
        Executor executor = this.executor;
        if (executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectPeriodicTask scheduledDirectPeriodicTask = new ScheduledDirectPeriodicTask(intervalObserver);
                scheduledDirectPeriodicTask.setFuture(((ScheduledExecutorService) executor).scheduleAtFixedRate(scheduledDirectPeriodicTask, j, j2, timeUnit));
                return scheduledDirectPeriodicTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        return super.schedulePeriodicallyDirect(intervalObserver, j, j2, timeUnit);
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        RxJavaPlugins.onSchedule(runnable);
        Executor executor = this.executor;
        if (executor instanceof ScheduledExecutorService) {
            try {
                ScheduledDirectTask scheduledDirectTask = new ScheduledDirectTask(runnable);
                scheduledDirectTask.setFuture(((ScheduledExecutorService) executor).schedule(scheduledDirectTask, j, timeUnit));
                return scheduledDirectTask;
            } catch (RejectedExecutionException e) {
                RxJavaPlugins.onError(e);
                return EmptyDisposable.INSTANCE;
            }
        }
        DelayedRunnable delayedRunnable = new DelayedRunnable(runnable);
        Disposable scheduleDirect = HELPER.scheduleDirect(new DelayedDispose(delayedRunnable), j, timeUnit);
        SequentialDisposable sequentialDisposable = delayedRunnable.timed;
        sequentialDisposable.getClass();
        DisposableHelper.replace(sequentialDisposable, scheduleDirect);
        return delayedRunnable;
    }

    /* loaded from: classes.dex */
    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {
        public volatile boolean disposed;
        public final Executor executor;
        public final boolean interruptibleWorker;
        public final AtomicInteger wip = new AtomicInteger();
        public final CompositeDisposable tasks = new CompositeDisposable();
        public final MpscLinkedQueue<Runnable> queue = new MpscLinkedQueue<>();

        /* loaded from: classes.dex */
        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            public final Runnable actual;

            public BooleanRunnable(Runnable runnable) {
                this.actual = runnable;
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                lazySet(true);
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                return get();
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (get()) {
                    return;
                }
                try {
                    this.actual.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        /* loaded from: classes.dex */
        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            public final Runnable run;
            public final DisposableContainer tasks;
            public volatile Thread thread;

            public InterruptibleRunnable(Runnable runnable, CompositeDisposable compositeDisposable) {
                this.run = runnable;
                this.tasks = compositeDisposable;
            }

            @Override // io.reactivex.disposables.Disposable
            public final void dispose() {
                while (true) {
                    int r0 = get();
                    if (r0 < 2) {
                        if (r0 == 0) {
                            if (compareAndSet(0, 4)) {
                                DisposableContainer disposableContainer = this.tasks;
                                if (disposableContainer != null) {
                                    disposableContainer.delete(this);
                                    return;
                                }
                                return;
                            }
                        } else if (compareAndSet(1, 3)) {
                            Thread thread = this.thread;
                            if (thread != null) {
                                thread.interrupt();
                                this.thread = null;
                            }
                            set(4);
                            DisposableContainer disposableContainer2 = this.tasks;
                            if (disposableContainer2 != null) {
                                disposableContainer2.delete(this);
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // io.reactivex.disposables.Disposable
            public final boolean isDisposed() {
                if (get() >= 2) {
                    return true;
                }
                return false;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                DisposableContainer disposableContainer = this.tasks;
                                if (disposableContainer != null) {
                                    disposableContainer.delete(this);
                                    return;
                                }
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                            return;
                        } catch (Throwable th) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                DisposableContainer disposableContainer2 = this.tasks;
                                if (disposableContainer2 != null) {
                                    disposableContainer2.delete(this);
                                }
                            }
                            throw th;
                        }
                    }
                    this.thread = null;
                }
            }
        }

        /* loaded from: classes.dex */
        public final class SequentialDispose implements Runnable {
            public final Runnable decoratedRun;
            public final SequentialDisposable mar;

            public SequentialDispose(SequentialDisposable sequentialDisposable, Runnable runnable) {
                this.mar = sequentialDisposable;
                this.decoratedRun = runnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Disposable schedule = ExecutorWorker.this.schedule(this.decoratedRun);
                SequentialDisposable sequentialDisposable = this.mar;
                sequentialDisposable.getClass();
                DisposableHelper.replace(sequentialDisposable, schedule);
            }
        }

        public ExecutorWorker(Executor executor, boolean z) {
            this.executor = executor;
            this.interruptibleWorker = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.tasks.dispose();
                if (this.wip.getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MpscLinkedQueue<Runnable> mpscLinkedQueue = this.queue;
            int r1 = 1;
            while (!this.disposed) {
                do {
                    Runnable poll = mpscLinkedQueue.poll();
                    if (poll == null) {
                        if (this.disposed) {
                            mpscLinkedQueue.clear();
                            return;
                        } else {
                            r1 = this.wip.addAndGet(-r1);
                            if (r1 == 0) {
                                return;
                            }
                        }
                    } else {
                        poll.run();
                    }
                } while (!this.disposed);
                mpscLinkedQueue.clear();
                return;
            }
            mpscLinkedQueue.clear();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            Disposable booleanRunnable;
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            RxJavaPlugins.onSchedule(runnable);
            if (this.interruptibleWorker) {
                booleanRunnable = new InterruptibleRunnable(runnable, this.tasks);
                this.tasks.add(booleanRunnable);
            } else {
                booleanRunnable = new BooleanRunnable(runnable);
            }
            this.queue.offer(booleanRunnable);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    this.queue.clear();
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            }
            return booleanRunnable;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return schedule(runnable);
            }
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            RxJavaPlugins.onSchedule(runnable);
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(new SequentialDispose(sequentialDisposable2, runnable), this.tasks);
            this.tasks.add(scheduledRunnable);
            Executor executor = this.executor;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    scheduledRunnable.setFuture(((ScheduledExecutorService) executor).schedule((Callable) scheduledRunnable, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.disposed = true;
                    RxJavaPlugins.onError(e);
                    return EmptyDisposable.INSTANCE;
                }
            } else {
                scheduledRunnable.setFuture(new DisposeOnCancel(ExecutorScheduler.HELPER.scheduleDirect(scheduledRunnable, j, timeUnit)));
            }
            DisposableHelper.replace(sequentialDisposable, scheduledRunnable);
            return sequentialDisposable2;
        }
    }
}
