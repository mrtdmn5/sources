package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    public static final String TAG = Logger.tagWithPrefix("ConstraintTrkngWrkr");
    public volatile boolean mAreConstraintsUnmet;
    public ListenableWorker mDelegate;
    public final SettableFuture<ListenableWorker.Result> mFuture;
    public final Object mLock;
    public final WorkerParameters mWorkerParameters;

    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        this.mWorkerParameters = workerParams;
        this.mLock = new Object();
        this.mAreConstraintsUnmet = false;
        this.mFuture = new SettableFuture<>();
    }

    @Override // androidx.work.ListenableWorker
    public final TaskExecutor getTaskExecutor() {
        return WorkManagerImpl.getInstance(getApplicationContext()).mWorkTaskExecutor;
    }

    @Override // androidx.work.ListenableWorker
    public final boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null && listenableWorker.isRunInForeground()) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList workSpecIds) {
        Logger.get().debug(TAG, String.format("Constraints changed for %s", workSpecIds), new Throwable[0]);
        synchronized (this.mLock) {
            this.mAreConstraintsUnmet = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.mDelegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.mDelegate.stop();
        }
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.1
            @Override // java.lang.Runnable
            public final void run() {
                String str;
                final ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
                Object obj = constraintTrackingWorker.getInputData().mValues.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    Logger.get().error(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                    return;
                }
                ListenableWorker createWorkerWithDefaultFallback = constraintTrackingWorker.getWorkerFactory().createWorkerWithDefaultFallback(constraintTrackingWorker.getApplicationContext(), str, constraintTrackingWorker.mWorkerParameters);
                constraintTrackingWorker.mDelegate = createWorkerWithDefaultFallback;
                if (createWorkerWithDefaultFallback == null) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, "No worker to delegate to.", new Throwable[0]);
                    constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                    return;
                }
                WorkSpec workSpec = ((WorkSpecDao_Impl) WorkManagerImpl.getInstance(constraintTrackingWorker.getApplicationContext()).mWorkDatabase.workSpecDao()).getWorkSpec(constraintTrackingWorker.getId().toString());
                if (workSpec == null) {
                    constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                    return;
                }
                WorkConstraintsTracker workConstraintsTracker = new WorkConstraintsTracker(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                workConstraintsTracker.replace(Collections.singletonList(workSpec));
                if (workConstraintsTracker.areAllConstraintsMet(constraintTrackingWorker.getId().toString())) {
                    Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                    try {
                        final ListenableFuture<ListenableWorker.Result> startWork = constraintTrackingWorker.mDelegate.startWork();
                        startWork.addListener(new Runnable() { // from class: androidx.work.impl.workers.ConstraintTrackingWorker.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                synchronized (ConstraintTrackingWorker.this.mLock) {
                                    if (ConstraintTrackingWorker.this.mAreConstraintsUnmet) {
                                        ConstraintTrackingWorker constraintTrackingWorker2 = ConstraintTrackingWorker.this;
                                        constraintTrackingWorker2.getClass();
                                        constraintTrackingWorker2.mFuture.set(new ListenableWorker.Result.Retry());
                                    } else {
                                        ConstraintTrackingWorker.this.mFuture.setFuture(startWork);
                                    }
                                }
                            }
                        }, constraintTrackingWorker.getBackgroundExecutor());
                        return;
                    } catch (Throwable th) {
                        Logger logger = Logger.get();
                        String str2 = ConstraintTrackingWorker.TAG;
                        logger.debug(str2, String.format("Delegated worker %s threw exception in startWork.", str), th);
                        synchronized (constraintTrackingWorker.mLock) {
                            if (constraintTrackingWorker.mAreConstraintsUnmet) {
                                Logger.get().debug(str2, "Constraints were unmet, Retrying.", new Throwable[0]);
                                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Retry());
                            } else {
                                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Failure());
                            }
                            return;
                        }
                    }
                }
                Logger.get().debug(ConstraintTrackingWorker.TAG, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
                constraintTrackingWorker.mFuture.set(new ListenableWorker.Result.Retry());
            }
        });
        return this.mFuture;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List<String> workSpecIds) {
    }
}
