package androidx.work.impl.background.greedy;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.DefaultRunnableScheduler;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.ProcessUtils;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GreedyScheduler implements Scheduler, WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("GreedyScheduler");
    public final Context mContext;
    public final DelayedWorkTracker mDelayedWorkTracker;
    public Boolean mInDefaultProcess;
    public boolean mRegisteredExecutionListener;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashSet mConstrainedWorkSpecs = new HashSet();
    public final Object mLock = new Object();

    public GreedyScheduler(Context context, Configuration configuration, WorkManagerTaskExecutor taskExecutor, WorkManagerImpl workManagerImpl) {
        this.mContext = context;
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
        this.mDelayedWorkTracker = new DelayedWorkTracker(this, configuration.mRunnableScheduler);
    }

    @Override // androidx.work.impl.Scheduler
    public final void cancel(String workSpecId) {
        Runnable runnable;
        Boolean bool = this.mInDefaultProcess;
        WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
        if (bool == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, workManagerImpl.mConfiguration));
        }
        boolean booleanValue = this.mInDefaultProcess.booleanValue();
        String str = TAG;
        if (!booleanValue) {
            Logger.get().info(str, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            workManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        Logger.get().debug(str, String.format("Cancelling work ID %s", workSpecId), new Throwable[0]);
        DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
        if (delayedWorkTracker != null && (runnable = (Runnable) delayedWorkTracker.mRunnables.remove(workSpecId)) != null) {
            delayedWorkTracker.mRunnableScheduler.mHandler.removeCallbacks(runnable);
        }
        workManagerImpl.stopWork(workSpecId);
    }

    @Override // androidx.work.impl.Scheduler
    public final boolean hasLimitedSchedulingSlots() {
        return false;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List<String> workSpecIds) {
        Iterator it = ((ArrayList) workSpecIds).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Logger.get().debug(TAG, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.startWork(str, null);
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList workSpecIds) {
        Iterator it = workSpecIds.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Logger.get().debug(TAG, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.mWorkManagerImpl.stopWork(str);
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        synchronized (this.mLock) {
            Iterator it = this.mConstrainedWorkSpecs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WorkSpec workSpec = (WorkSpec) it.next();
                if (workSpec.id.equals(workSpecId)) {
                    Logger.get().debug(TAG, String.format("Stopping tracking for %s", workSpecId), new Throwable[0]);
                    this.mConstrainedWorkSpecs.remove(workSpec);
                    this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
                    break;
                }
            }
        }
    }

    @Override // androidx.work.impl.Scheduler
    public final void schedule(WorkSpec... workSpecs) {
        boolean z;
        if (this.mInDefaultProcess == null) {
            this.mInDefaultProcess = Boolean.valueOf(ProcessUtils.isDefaultProcess(this.mContext, this.mWorkManagerImpl.mConfiguration));
        }
        if (!this.mInDefaultProcess.booleanValue()) {
            Logger.get().info(TAG, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        if (!this.mRegisteredExecutionListener) {
            this.mWorkManagerImpl.mProcessor.addExecutionListener(this);
            this.mRegisteredExecutionListener = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (final WorkSpec workSpec : workSpecs) {
            long calculateNextRunTime = workSpec.calculateNextRunTime();
            long currentTimeMillis = System.currentTimeMillis();
            if (workSpec.state == WorkInfo.State.ENQUEUED) {
                if (currentTimeMillis < calculateNextRunTime) {
                    final DelayedWorkTracker delayedWorkTracker = this.mDelayedWorkTracker;
                    if (delayedWorkTracker != null) {
                        HashMap hashMap = delayedWorkTracker.mRunnables;
                        Runnable runnable = (Runnable) hashMap.remove(workSpec.id);
                        DefaultRunnableScheduler defaultRunnableScheduler = delayedWorkTracker.mRunnableScheduler;
                        if (runnable != null) {
                            defaultRunnableScheduler.mHandler.removeCallbacks(runnable);
                        }
                        Runnable runnable2 = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Logger logger = Logger.get();
                                String str = DelayedWorkTracker.TAG;
                                WorkSpec workSpec2 = workSpec;
                                logger.debug(str, String.format("Scheduling work %s", workSpec2.id), new Throwable[0]);
                                DelayedWorkTracker.this.mGreedyScheduler.schedule(workSpec2);
                            }
                        };
                        hashMap.put(workSpec.id, runnable2);
                        defaultRunnableScheduler.mHandler.postDelayed(runnable2, workSpec.calculateNextRunTime() - System.currentTimeMillis());
                    }
                } else if (workSpec.hasConstraints()) {
                    Constraints constraints = workSpec.constraints;
                    if (constraints.mRequiresDeviceIdle) {
                        Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires device idle.", workSpec), new Throwable[0]);
                    } else {
                        if (constraints.mContentUriTriggers.mTriggers.size() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            Logger.get().debug(TAG, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", workSpec), new Throwable[0]);
                        } else {
                            hashSet.add(workSpec);
                            hashSet2.add(workSpec.id);
                        }
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Starting work for %s", workSpec.id), new Throwable[0]);
                    this.mWorkManagerImpl.startWork(workSpec.id, null);
                }
            }
        }
        synchronized (this.mLock) {
            if (!hashSet.isEmpty()) {
                Logger.get().debug(TAG, String.format("Starting tracking for [%s]", TextUtils.join(",", hashSet2)), new Throwable[0]);
                this.mConstrainedWorkSpecs.addAll(hashSet);
                this.mWorkConstraintsTracker.replace(this.mConstrainedWorkSpecs);
            }
        }
    }
}
