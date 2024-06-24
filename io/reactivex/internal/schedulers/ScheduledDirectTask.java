package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: classes.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    @Override // java.util.concurrent.Callable
    public final Void call() throws Exception {
        FutureTask<Void> futureTask = AbstractDirectTask.FINISHED;
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.runner = null;
        }
    }
}
