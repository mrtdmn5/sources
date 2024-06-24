package io.reactivex.internal.schedulers;

import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes.dex */
public final class ScheduledDirectPeriodicTask extends AbstractDirectTask implements Runnable {
    public ScheduledDirectPeriodicTask(ObservableInterval.IntervalObserver intervalObserver) {
        super(intervalObserver);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        } catch (Throwable th) {
            this.runner = null;
            lazySet(AbstractDirectTask.FINISHED);
            RxJavaPlugins.onError(th);
        }
    }
}
