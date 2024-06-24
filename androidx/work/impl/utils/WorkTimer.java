package androidx.work.impl.utils;

import androidx.work.Logger;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class WorkTimer {
    public static final String TAG = Logger.tagWithPrefix("WorkTimer");
    public final ScheduledExecutorService mExecutorService;
    public final HashMap mListeners;
    public final Object mLock;
    public final HashMap mTimerMap;

    /* loaded from: classes.dex */
    public interface TimeLimitExceededListener {
        void onTimeLimitExceeded(String workSpecId);
    }

    /* loaded from: classes.dex */
    public static class WorkTimerRunnable implements Runnable {
        public final String mWorkSpecId;
        public final WorkTimer mWorkTimer;

        public WorkTimerRunnable(WorkTimer workTimer, String workSpecId) {
            this.mWorkTimer = workTimer;
            this.mWorkSpecId = workSpecId;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this.mWorkTimer.mLock) {
                if (((WorkTimerRunnable) this.mWorkTimer.mTimerMap.remove(this.mWorkSpecId)) != null) {
                    TimeLimitExceededListener timeLimitExceededListener = (TimeLimitExceededListener) this.mWorkTimer.mListeners.remove(this.mWorkSpecId);
                    if (timeLimitExceededListener != null) {
                        timeLimitExceededListener.onTimeLimitExceeded(this.mWorkSpecId);
                    }
                } else {
                    Logger.get().debug("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.mWorkSpecId), new Throwable[0]);
                }
            }
        }
    }

    public WorkTimer() {
        ThreadFactory threadFactory = new ThreadFactory() { // from class: androidx.work.impl.utils.WorkTimer.1
            public int mThreadsCreated = 0;

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable r) {
                Thread newThread = Executors.defaultThreadFactory().newThread(r);
                newThread.setName("WorkManager-WorkTimer-thread-" + this.mThreadsCreated);
                this.mThreadsCreated = this.mThreadsCreated + 1;
                return newThread;
            }
        };
        this.mTimerMap = new HashMap();
        this.mListeners = new HashMap();
        this.mLock = new Object();
        this.mExecutorService = Executors.newSingleThreadScheduledExecutor(threadFactory);
    }

    public final void startTimer(String str, TimeLimitExceededListener timeLimitExceededListener) {
        synchronized (this.mLock) {
            Logger.get().debug(TAG, String.format("Starting timer for %s", str), new Throwable[0]);
            stopTimer(str);
            WorkTimerRunnable workTimerRunnable = new WorkTimerRunnable(this, str);
            this.mTimerMap.put(str, workTimerRunnable);
            this.mListeners.put(str, timeLimitExceededListener);
            this.mExecutorService.schedule(workTimerRunnable, 600000L, TimeUnit.MILLISECONDS);
        }
    }

    public final void stopTimer(final String workSpecId) {
        synchronized (this.mLock) {
            if (((WorkTimerRunnable) this.mTimerMap.remove(workSpecId)) != null) {
                Logger.get().debug(TAG, String.format("Stopping timer for %s", workSpecId), new Throwable[0]);
                this.mListeners.remove(workSpecId);
            }
        }
    }
}
