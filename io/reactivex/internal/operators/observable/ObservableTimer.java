package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class ObservableTimer extends Observable<Long> {
    public final long delay;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: classes.dex */
    public static final class TimerObserver extends AtomicReference<Disposable> implements Disposable, Runnable {
        public final Observer<? super Long> downstream;

        public TimerObserver(Observer<? super Long> observer) {
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
            if (!isDisposed()) {
                Observer<? super Long> observer = this.downstream;
                observer.onNext(0L);
                lazySet(EmptyDisposable.INSTANCE);
                observer.onComplete();
            }
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.delay = j;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> observer) {
        TimerObserver timerObserver = new TimerObserver(observer);
        observer.onSubscribe(timerObserver);
        DisposableHelper.trySet(timerObserver, this.scheduler.scheduleDirect(timerObserver, this.delay, this.unit));
    }
}
