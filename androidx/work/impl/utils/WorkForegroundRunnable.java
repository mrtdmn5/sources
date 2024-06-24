package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.os.BuildCompat;
import androidx.work.ForegroundInfo;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkForegroundRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("WorkForegroundRunnable");
    public final Context mContext;
    public final ForegroundUpdater mForegroundUpdater;
    public final SettableFuture<Void> mFuture = new SettableFuture<>();
    public final TaskExecutor mTaskExecutor;
    public final WorkSpec mWorkSpec;
    public final ListenableWorker mWorker;

    @SuppressLint({"LambdaLast"})
    public WorkForegroundRunnable(Context context, WorkSpec workSpec, ListenableWorker worker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor) {
        this.mContext = context;
        this.mWorkSpec = workSpec;
        this.mWorker = worker;
        this.mForegroundUpdater = foregroundUpdater;
        this.mTaskExecutor = taskExecutor;
    }

    @Override // java.lang.Runnable
    @SuppressLint({"UnsafeExperimentalUsageError"})
    public final void run() {
        if (this.mWorkSpec.expedited && !BuildCompat.isAtLeastS()) {
            final SettableFuture settableFuture = new SettableFuture();
            WorkManagerTaskExecutor workManagerTaskExecutor = (WorkManagerTaskExecutor) this.mTaskExecutor;
            workManagerTaskExecutor.mMainThreadExecutor.execute(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.1
                @Override // java.lang.Runnable
                public final void run() {
                    settableFuture.setFuture(WorkForegroundRunnable.this.mWorker.getForegroundInfoAsync());
                }
            });
            settableFuture.addListener(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundRunnable.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public final void run() {
                    WorkForegroundRunnable workForegroundRunnable = WorkForegroundRunnable.this;
                    try {
                        ForegroundInfo foregroundInfo = (ForegroundInfo) settableFuture.get();
                        if (foregroundInfo != null) {
                            Logger logger = Logger.get();
                            String str = WorkForegroundRunnable.TAG;
                            Object[] objArr = new Object[1];
                            WorkSpec workSpec = workForegroundRunnable.mWorkSpec;
                            ListenableWorker listenableWorker = workForegroundRunnable.mWorker;
                            objArr[0] = workSpec.workerClassName;
                            logger.debug(str, String.format("Updating notification for %s", objArr), new Throwable[0]);
                            listenableWorker.setRunInForeground(true);
                            SettableFuture<Void> settableFuture2 = workForegroundRunnable.mFuture;
                            ForegroundUpdater foregroundUpdater = workForegroundRunnable.mForegroundUpdater;
                            Context context = workForegroundRunnable.mContext;
                            UUID id = listenableWorker.getId();
                            WorkForegroundUpdater workForegroundUpdater = (WorkForegroundUpdater) foregroundUpdater;
                            workForegroundUpdater.getClass();
                            SettableFuture settableFuture3 = new SettableFuture();
                            ((WorkManagerTaskExecutor) workForegroundUpdater.mTaskExecutor).executeOnBackgroundThread(new WorkForegroundUpdater.AnonymousClass1(settableFuture3, id, foregroundInfo, context));
                            settableFuture2.setFuture(settableFuture3);
                            return;
                        }
                        throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", workForegroundRunnable.mWorkSpec.workerClassName));
                    } catch (Throwable th) {
                        workForegroundRunnable.mFuture.setException(th);
                    }
                }
            }, workManagerTaskExecutor.mMainThreadExecutor);
            return;
        }
        this.mFuture.set(null);
    }
}
