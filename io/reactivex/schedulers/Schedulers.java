package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;
import io.reactivex.internal.schedulers.IoScheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class Schedulers {
    public static final TrampolineScheduler TRAMPOLINE;
    public static final Scheduler SINGLE = RxJavaPlugins.callRequireNonNull(new SingleTask());
    public static final Scheduler COMPUTATION = RxJavaPlugins.callRequireNonNull(new ComputationTask());

    /* loaded from: classes.dex */
    public static final class ComputationHolder {
        public static final ComputationScheduler DEFAULT = new ComputationScheduler();
    }

    /* loaded from: classes.dex */
    public static final class ComputationTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public final Scheduler call() throws Exception {
            return ComputationHolder.DEFAULT;
        }
    }

    /* loaded from: classes.dex */
    public static final class IOTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public final Scheduler call() throws Exception {
            return IoHolder.DEFAULT;
        }
    }

    /* loaded from: classes.dex */
    public static final class IoHolder {
        public static final IoScheduler DEFAULT = new IoScheduler();
    }

    /* loaded from: classes.dex */
    public static final class NewThreadHolder {
        public static final NewThreadScheduler DEFAULT = new NewThreadScheduler();
    }

    /* loaded from: classes.dex */
    public static final class NewThreadTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public final Scheduler call() throws Exception {
            return NewThreadHolder.DEFAULT;
        }
    }

    /* loaded from: classes.dex */
    public static final class SingleHolder {
        public static final SingleScheduler DEFAULT = new SingleScheduler();
    }

    /* loaded from: classes.dex */
    public static final class SingleTask implements Callable<Scheduler> {
        @Override // java.util.concurrent.Callable
        public final Scheduler call() throws Exception {
            return SingleHolder.DEFAULT;
        }
    }

    static {
        RxJavaPlugins.callRequireNonNull(new IOTask());
        TRAMPOLINE = TrampolineScheduler.INSTANCE;
        RxJavaPlugins.callRequireNonNull(new NewThreadTask());
    }
}
