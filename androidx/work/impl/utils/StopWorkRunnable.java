package androidx.work.impl.utils;

import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;

/* loaded from: classes.dex */
public final class StopWorkRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("StopWorkRunnable");
    public final boolean mStopInForeground;
    public final WorkManagerImpl mWorkManagerImpl;
    public final String mWorkSpecId;

    public StopWorkRunnable(WorkManagerImpl workManagerImpl, String workSpecId, boolean stopInForeground) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = workSpecId;
        this.mStopInForeground = stopInForeground;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean containsKey;
        boolean stopWork;
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        Processor processor = workManagerImpl.mProcessor;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            String str = this.mWorkSpecId;
            synchronized (processor.mLock) {
                containsKey = processor.mForegroundWorkMap.containsKey(str);
            }
            if (this.mStopInForeground) {
                stopWork = this.mWorkManagerImpl.mProcessor.stopForegroundWork(this.mWorkSpecId);
            } else {
                if (!containsKey) {
                    WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
                    if (workSpecDao_Impl.getState(this.mWorkSpecId) == WorkInfo.State.RUNNING) {
                        workSpecDao_Impl.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                    }
                }
                stopWork = this.mWorkManagerImpl.mProcessor.stopWork(this.mWorkSpecId);
            }
            Logger.get().debug(TAG, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.mWorkSpecId, Boolean.valueOf(stopWork)), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
