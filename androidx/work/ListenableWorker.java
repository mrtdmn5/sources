package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import androidx.room.RoomDatabase;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ListenableWorker {
    private Context mAppContext;
    private boolean mRunInForeground;
    private volatile boolean mStopped;
    private boolean mUsed;
    private WorkerParameters mWorkerParams;

    /* loaded from: classes.dex */
    public static abstract class Result {

        /* loaded from: classes.dex */
        public static final class Failure extends Result {
            public final Data mOutputData = Data.EMPTY;

            public final boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o != null && Failure.class == o.getClass()) {
                    return this.mOutputData.equals(((Failure) o).mOutputData);
                }
                return false;
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() + 846803280;
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.mOutputData + '}';
            }
        }

        /* loaded from: classes.dex */
        public static final class Retry extends Result {
            public final boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o != null && Retry.class == o.getClass()) {
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return "Retry";
            }
        }

        /* loaded from: classes.dex */
        public static final class Success extends Result {
            public final Data mOutputData;

            public Success() {
                this(Data.EMPTY);
            }

            public final boolean equals(Object o) {
                if (this == o) {
                    return true;
                }
                if (o != null && Success.class == o.getClass()) {
                    return this.mOutputData.equals(((Success) o).mOutputData);
                }
                return false;
            }

            public final int hashCode() {
                return this.mOutputData.hashCode() - 1876823561;
            }

            public final String toString() {
                return "Success {mOutputData=" + this.mOutputData + '}';
            }

            public Success(Data outputData) {
                this.mOutputData = outputData;
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context appContext, WorkerParameters workerParams) {
        if (appContext != null) {
            if (workerParams != null) {
                this.mAppContext = appContext;
                this.mWorkerParams = workerParams;
                return;
            }
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        throw new IllegalArgumentException("Application Context is null");
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.mBackgroundExecutor;
    }

    public ListenableFuture<ForegroundInfo> getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.setException(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    public final UUID getId() {
        return this.mWorkerParams.mId;
    }

    public final Data getInputData() {
        return this.mWorkerParams.mInputData;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.mRuntimeExtras.network;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.mRunAttemptCount;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.mTags;
    }

    public TaskExecutor getTaskExecutor() {
        return this.mWorkerParams.mWorkTaskExecutor;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.mRuntimeExtras.triggeredContentAuthorities;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.mRuntimeExtras.triggeredContentUris;
    }

    public WorkerFactory getWorkerFactory() {
        return this.mWorkerParams.mWorkerFactory;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public final ListenableFuture<Void> setForegroundAsync(ForegroundInfo foregroundInfo) {
        this.mRunInForeground = true;
        ForegroundUpdater foregroundUpdater = this.mWorkerParams.mForegroundUpdater;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        WorkForegroundUpdater workForegroundUpdater = (WorkForegroundUpdater) foregroundUpdater;
        workForegroundUpdater.getClass();
        SettableFuture settableFuture = new SettableFuture();
        ((WorkManagerTaskExecutor) workForegroundUpdater.mTaskExecutor).executeOnBackgroundThread(new WorkForegroundUpdater.AnonymousClass1(settableFuture, id, foregroundInfo, applicationContext));
        return settableFuture;
    }

    public ListenableFuture<Void> setProgressAsync(final Data data) {
        ProgressUpdater progressUpdater = this.mWorkerParams.mProgressUpdater;
        getApplicationContext();
        final UUID id = getId();
        final WorkProgressUpdater workProgressUpdater = (WorkProgressUpdater) progressUpdater;
        workProgressUpdater.getClass();
        final SettableFuture settableFuture = new SettableFuture();
        ((WorkManagerTaskExecutor) workProgressUpdater.mTaskExecutor).executeOnBackgroundThread(new Runnable() { // from class: androidx.work.impl.utils.WorkProgressUpdater.1
            @Override // java.lang.Runnable
            public final void run() {
                WorkSpec workSpec;
                SettableFuture settableFuture2 = settableFuture;
                UUID r1 = id;
                String str = r1.toString();
                Logger logger = Logger.get();
                String str2 = WorkProgressUpdater.TAG;
                Data data2 = data;
                logger.debug(str2, String.format("Updating progress for %s (%s)", r1, data2), new Throwable[0]);
                WorkProgressUpdater workProgressUpdater2 = WorkProgressUpdater.this;
                WorkDatabase workDatabase = workProgressUpdater2.mWorkDatabase;
                WorkDatabase workDatabase2 = workProgressUpdater2.mWorkDatabase;
                workDatabase.beginTransaction();
                try {
                    workSpec = ((WorkSpecDao_Impl) workDatabase2.workSpecDao()).getWorkSpec(str);
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                if (workSpec != null) {
                    if (workSpec.state == WorkInfo.State.RUNNING) {
                        WorkProgress workProgress = new WorkProgress(str, data2);
                        WorkProgressDao_Impl workProgressDao_Impl = (WorkProgressDao_Impl) workDatabase2.workProgressDao();
                        RoomDatabase roomDatabase = workProgressDao_Impl.__db;
                        roomDatabase.assertNotSuspendingTransaction();
                        roomDatabase.beginTransaction();
                        try {
                            workProgressDao_Impl.__insertionAdapterOfWorkProgress.insert(workProgress);
                            roomDatabase.setTransactionSuccessful();
                            roomDatabase.endTransaction();
                        } catch (Throwable th) {
                            roomDatabase.endTransaction();
                            throw th;
                        }
                    } else {
                        Logger.get().warning(str2, String.format("Ignoring setProgressAsync(...). WorkSpec (%s) is not in a RUNNING state.", str), new Throwable[0]);
                    }
                    settableFuture2.set(null);
                    workDatabase2.setTransactionSuccessful();
                    return;
                }
                throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
            }
        });
        return settableFuture;
    }

    public void setRunInForeground(boolean runInForeground) {
        this.mRunInForeground = runInForeground;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract ListenableFuture<Result> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }

    public void onStopped() {
    }
}
