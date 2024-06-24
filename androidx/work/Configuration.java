package androidx.work;

import androidx.work.InputMergerFactory;
import androidx.work.WorkerFactory;
import androidx.work.impl.DefaultRunnableScheduler;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class Configuration {
    public final InputMergerFactory.AnonymousClass1 mInputMergerFactory;
    public final int mLoggingLevel;
    public final int mMaxJobSchedulerId;
    public final int mMaxSchedulerLimit;
    public final DefaultRunnableScheduler mRunnableScheduler;
    public final WorkerFactory.AnonymousClass1 mWorkerFactory;
    public final ExecutorService mExecutor = createDefaultExecutor(false);
    public final ExecutorService mTaskExecutor = createDefaultExecutor(true);

    /* loaded from: classes.dex */
    public static final class Builder {
    }

    /* loaded from: classes.dex */
    public interface Provider {
        Configuration getWorkManagerConfiguration();
    }

    public Configuration(Builder builder) {
        String str = WorkerFactory.TAG;
        this.mWorkerFactory = new WorkerFactory.AnonymousClass1();
        this.mInputMergerFactory = new InputMergerFactory.AnonymousClass1();
        this.mRunnableScheduler = new DefaultRunnableScheduler();
        this.mLoggingLevel = 4;
        this.mMaxJobSchedulerId = Integer.MAX_VALUE;
        this.mMaxSchedulerLimit = 20;
    }

    public static ExecutorService createDefaultExecutor(final boolean isTaskExecutor) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.Configuration.1
            public final AtomicInteger mThreadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                String str;
                if (isTaskExecutor) {
                    str = "WM.task-";
                } else {
                    str = "androidx.work-";
                }
                StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
                m.append(this.mThreadCount.incrementAndGet());
                return new Thread(runnable, m.toString());
            }
        });
    }
}
