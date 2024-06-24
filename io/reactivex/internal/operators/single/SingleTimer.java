package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class SingleTimer extends Single<Long> {
    public final long delay = 5;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class TimerDisposable extends AtomicReference<Disposable> implements Disposable, Runnable {
        public final SingleObserver<? super Long> downstream;

        public TimerDisposable(SingleObserver<? super Long> singleObserver) {
            this.downstream = singleObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.downstream.onSuccess(0L);
        }
    }

    public SingleTimer(TimeUnit timeUnit, Scheduler scheduler) {
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Single
    public final void subscribeActual(SingleObserver<? super Long> singleObserver) {
        TimerDisposable timerDisposable = new TimerDisposable(singleObserver);
        singleObserver.onSubscribe(timerDisposable);
        DisposableHelper.replace(timerDisposable, this.scheduler.scheduleDirect(timerDisposable, this.delay, this.unit));
    }
}
