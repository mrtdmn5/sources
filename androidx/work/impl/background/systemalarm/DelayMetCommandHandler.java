package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    public static final String TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    public final Context mContext;
    public final SystemAlarmDispatcher mDispatcher;
    public final int mStartId;
    public PowerManager.WakeLock mWakeLock;
    public final WorkConstraintsTracker mWorkConstraintsTracker;
    public final String mWorkSpecId;
    public boolean mHasConstraints = false;
    public int mCurrentState = 0;
    public final Object mLock = new Object();

    public DelayMetCommandHandler(Context context, int startId, String workSpecId, SystemAlarmDispatcher dispatcher) {
        this.mContext = context;
        this.mStartId = startId;
        this.mDispatcher = dispatcher;
        this.mWorkSpecId = workSpecId;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, dispatcher.mTaskExecutor, this);
    }

    public final void cleanUp() {
        synchronized (this.mLock) {
            this.mWorkConstraintsTracker.reset();
            this.mDispatcher.mWorkTimer.stopTimer(this.mWorkSpecId);
            PowerManager.WakeLock wakeLock = this.mWakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().debug(TAG, String.format("Releasing wakelock %s for WorkSpec %s", this.mWakeLock, this.mWorkSpecId), new Throwable[0]);
                this.mWakeLock.release();
            }
        }
    }

    public final void handleProcessWork() {
        Integer valueOf = Integer.valueOf(this.mStartId);
        String str = this.mWorkSpecId;
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, String.format("%s (%s)", str, valueOf));
        String str2 = TAG;
        Logger.get().debug(str2, String.format("Acquiring wakelock %s for WorkSpec %s", this.mWakeLock, str), new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = ((WorkSpecDao_Impl) this.mDispatcher.mWorkManager.mWorkDatabase.workSpecDao()).getWorkSpec(str);
        if (workSpec == null) {
            stopWork();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = hasConstraints;
        if (!hasConstraints) {
            Logger.get().debug(str2, String.format("No constraints for %s", str), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(str));
        } else {
            this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List<String> workSpecIds) {
        if (!workSpecIds.contains(this.mWorkSpecId)) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mCurrentState == 0) {
                this.mCurrentState = 1;
                Logger.get().debug(TAG, String.format("onAllConstraintsMet for %s", this.mWorkSpecId), new Throwable[0]);
                if (this.mDispatcher.mProcessor.startWork(this.mWorkSpecId, null)) {
                    this.mDispatcher.mWorkTimer.startTimer(this.mWorkSpecId, this);
                } else {
                    cleanUp();
                }
            } else {
                Logger.get().debug(TAG, String.format("Already started work for %s", this.mWorkSpecId), new Throwable[0]);
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList workSpecIds) {
        stopWork();
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        Logger.get().debug(TAG, String.format("onExecuted %s, %s", workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
        cleanUp();
        int r4 = this.mStartId;
        SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
        Context context = this.mContext;
        if (needsReschedule) {
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(r4, CommandHandler.createScheduleWorkIntent(context, this.mWorkSpecId), systemAlarmDispatcher));
        }
        if (this.mHasConstraints) {
            Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
            intent.setAction("ACTION_CONSTRAINTS_CHANGED");
            systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(r4, intent, systemAlarmDispatcher));
        }
    }

    @Override // androidx.work.impl.utils.WorkTimer.TimeLimitExceededListener
    public final void onTimeLimitExceeded(String workSpecId) {
        Logger.get().debug(TAG, String.format("Exceeded time limits on execution for %s", workSpecId), new Throwable[0]);
        stopWork();
    }

    public final void stopWork() {
        synchronized (this.mLock) {
            if (this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, String.format("Stopping work for WorkSpec %s", this.mWorkSpecId), new Throwable[0]);
                Context context = this.mContext;
                String str2 = this.mWorkSpecId;
                Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent.setAction("ACTION_STOP_WORK");
                intent.putExtra("KEY_WORKSPEC_ID", str2);
                SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
                systemAlarmDispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(this.mStartId, intent, systemAlarmDispatcher));
                if (this.mDispatcher.mProcessor.isEnqueued(this.mWorkSpecId)) {
                    Logger.get().debug(str, String.format("WorkSpec %s needs to be rescheduled", this.mWorkSpecId), new Throwable[0]);
                    Intent createScheduleWorkIntent = CommandHandler.createScheduleWorkIntent(this.mContext, this.mWorkSpecId);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
                    systemAlarmDispatcher2.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(this.mStartId, createScheduleWorkIntent, systemAlarmDispatcher2));
                } else {
                    Logger.get().debug(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.mWorkSpecId), new Throwable[0]);
                }
            } else {
                Logger.get().debug(TAG, String.format("Already stopped work for %s", this.mWorkSpecId), new Throwable[0]);
            }
        }
    }
}
