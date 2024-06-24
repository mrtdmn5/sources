package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableInterval extends Observable<Long> {
    public final long initialDelay;
    public final long period;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class IntervalObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public long count;
        public final Observer<? super Long> downstream;

        public IntervalObserver(Observer<? super Long> observer) {
            this.downstream = observer;
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            if (get() == DisposableHelper.DISPOSED) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (get() != DisposableHelper.DISPOSED) {
                long j = this.count;
                this.count = 1 + j;
                this.downstream.onNext(Long.valueOf(j));
            }
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = j;
        this.period = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        IntervalObserver intervalObserver = new IntervalObserver(observer);
        observer.onSubscribe(intervalObserver);
        Scheduler scheduler = this.scheduler;
        if (scheduler instanceof TrampolineScheduler) {
            Scheduler.Worker createWorker = scheduler.createWorker();
            DisposableHelper.setOnce(intervalObserver, createWorker);
            createWorker.schedulePeriodically(intervalObserver, this.initialDelay, this.period, this.unit);
            return;
        }
        DisposableHelper.setOnce(intervalObserver, scheduler.schedulePeriodicallyDirect(intervalObserver, this.initialDelay, this.period, this.unit));
    }
}
