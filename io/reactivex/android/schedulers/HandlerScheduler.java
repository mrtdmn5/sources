package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class HandlerScheduler extends Scheduler {
    public final boolean async = false;
    public final Handler handler;

    /* loaded from: classes3.dex */
    public static final class HandlerWorker extends Scheduler.Worker {
        public final boolean async;
        public volatile boolean disposed;
        public final Handler handler;

        public HandlerWorker(Handler handler, boolean z) {
            this.handler = handler;
            this.async = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.Scheduler.Worker
        @SuppressLint({"NewApi"})
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.disposed) {
                        return EmptyDisposable.INSTANCE;
                    }
                    Handler handler = this.handler;
                    ScheduledRunnable scheduledRunnable = new ScheduledRunnable(handler, runnable);
                    Message obtain = Message.obtain(handler, scheduledRunnable);
                    obtain.obj = this;
                    if (this.async) {
                        obtain.setAsynchronous(true);
                    }
                    this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                    if (this.disposed) {
                        this.handler.removeCallbacks(scheduledRunnable);
                        return EmptyDisposable.INSTANCE;
                    }
                    return scheduledRunnable;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }
    }

    /* loaded from: classes3.dex */
    public static final class ScheduledRunnable implements Runnable, Disposable {
        public final Runnable delegate;
        public volatile boolean disposed;
        public final Handler handler;

        public ScheduledRunnable(Handler handler, Runnable runnable) {
            this.handler = handler;
            this.delegate = runnable;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.disposed;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    public HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    @Override // io.reactivex.Scheduler
    @SuppressLint({"NewApi"})
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                Handler handler = this.handler;
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(handler, runnable);
                Message obtain = Message.obtain(handler, scheduledRunnable);
                if (this.async) {
                    obtain.setAsynchronous(true);
                }
                handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                return scheduledRunnable;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }
}
