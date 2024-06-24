package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    /* loaded from: classes.dex */
    public static final class SleepingRunnable implements Runnable {
        public final long execTime;
        public final Runnable run;
        public final TrampolineWorker worker;

        public SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j) {
            this.run = runnable;
            this.worker = trampolineWorker;
            this.execTime = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!this.worker.disposed) {
                TrampolineWorker trampolineWorker = this.worker;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                trampolineWorker.getClass();
                long now = Scheduler.Worker.now(timeUnit);
                long j = this.execTime;
                if (j > now) {
                    try {
                        Thread.sleep(j - now);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.onError(e);
                        return;
                    }
                }
                if (!this.worker.disposed) {
                    this.run.run();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class TimedRunnable implements Comparable<TimedRunnable> {
        public final int count;
        public volatile boolean disposed;
        public final long execTime;
        public final Runnable run;

        public TimedRunnable(Runnable runnable, Long l, int r3) {
            this.run = runnable;
            this.execTime = l.longValue();
            this.count = r3;
        }

        @Override // java.lang.Comparable
        public final int compareTo(TimedRunnable timedRunnable) {
            int r0;
            TimedRunnable timedRunnable2 = timedRunnable;
            long j = timedRunnable2.execTime;
            long j2 = this.execTime;
            int r1 = 1;
            if (j2 < j) {
                r0 = -1;
            } else if (j2 > j) {
                r0 = 1;
            } else {
                r0 = 0;
            }
            if (r0 == 0) {
                int r02 = this.count;
                int r5 = timedRunnable2.count;
                if (r02 < r5) {
                    r1 = -1;
                } else if (r02 <= r5) {
                    r1 = 0;
                }
                return r1;
            }
            return r0;
        }
    }

    /* loaded from: classes.dex */
    public static final class TrampolineWorker extends Scheduler.Worker {
        public volatile boolean disposed;
        public final PriorityBlockingQueue<TimedRunnable> queue = new PriorityBlockingQueue<>();
        public final AtomicInteger wip = new AtomicInteger();
        public final AtomicInteger counter = new AtomicInteger();

        /* loaded from: classes.dex */
        public final class AppendToQueueTask implements Runnable {
            public final TimedRunnable timedRunnable;

            public AppendToQueueTask(TimedRunnable timedRunnable) {
                this.timedRunnable = timedRunnable;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.timedRunnable.disposed = true;
                TrampolineWorker.this.queue.remove(this.timedRunnable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.disposed = true;
        }

        public final Disposable enqueue(Runnable runnable, long j) {
            if (this.disposed) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j), this.counter.incrementAndGet());
            this.queue.add(timedRunnable);
            if (this.wip.getAndIncrement() == 0) {
                int r2 = 1;
                while (!this.disposed) {
                    TimedRunnable poll = this.queue.poll();
                    if (poll == null) {
                        r2 = this.wip.addAndGet(-r2);
                        if (r2 == 0) {
                            return EmptyDisposable.INSTANCE;
                        }
                    } else if (!poll.disposed) {
                        poll.run.run();
                    }
                }
                this.queue.clear();
                return EmptyDisposable.INSTANCE;
            }
            return new RunnableDisposable(new AppendToQueueTask(timedRunnable));
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable) {
            return enqueue(runnable, Scheduler.Worker.now(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            long millis = timeUnit.toMillis(j) + Scheduler.Worker.now(TimeUnit.MILLISECONDS);
            return enqueue(new SleepingRunnable(runnable, this, millis), millis);
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new TrampolineWorker();
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable) {
        RxJavaPlugins.onSchedule(runnable);
        runnable.run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            RxJavaPlugins.onSchedule(runnable);
            runnable.run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.onError(e);
        }
        return EmptyDisposable.INSTANCE;
    }
}
