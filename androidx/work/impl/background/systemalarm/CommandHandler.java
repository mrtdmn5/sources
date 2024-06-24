package androidx.work.impl.background.systemalarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class CommandHandler implements ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("CommandHandler");
    public final Context mContext;
    public final HashMap mPendingDelayMet = new HashMap();
    public final Object mLock = new Object();

    public CommandHandler(Context context) {
        this.mContext = context;
    }

    public static Intent createDelayMetIntent(Context context, String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public static Intent createScheduleWorkIntent(Context context, String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        synchronized (this.mLock) {
            ExecutionListener executionListener = (ExecutionListener) this.mPendingDelayMet.remove(workSpecId);
            if (executionListener != null) {
                executionListener.onExecuted(workSpecId, needsReschedule);
            }
        }
    }

    public final void onHandleIntent(int intent, Intent startId, SystemAlarmDispatcher dispatcher) {
        boolean z;
        boolean z2;
        String action = startId.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            Logger.get().debug(TAG, String.format("Handling constraints changed %s", startId), new Throwable[0]);
            ConstraintsCommandHandler constraintsCommandHandler = new ConstraintsCommandHandler(this.mContext, intent, dispatcher);
            ArrayList scheduledWork = ((WorkSpecDao_Impl) dispatcher.mWorkManager.mWorkDatabase.workSpecDao()).getScheduledWork();
            String str = ConstraintProxy.TAG;
            Iterator it = scheduledWork.iterator();
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            while (it.hasNext()) {
                Constraints constraints = ((WorkSpec) it.next()).constraints;
                z3 |= constraints.mRequiresBatteryNotLow;
                z4 |= constraints.mRequiresCharging;
                z5 |= constraints.mRequiresStorageNotLow;
                if (constraints.mRequiredNetworkType != NetworkType.NOT_REQUIRED) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z6 |= z2;
                if (z3 && z4 && z5 && z6) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.TAG;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = constraintsCommandHandler.mContext;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z4).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z5).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z6);
            context.sendBroadcast(intent2);
            WorkConstraintsTracker workConstraintsTracker = constraintsCommandHandler.mWorkConstraintsTracker;
            workConstraintsTracker.replace(scheduledWork);
            ArrayList arrayList = new ArrayList(scheduledWork.size());
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = scheduledWork.iterator();
            while (it2.hasNext()) {
                WorkSpec workSpec = (WorkSpec) it2.next();
                String str3 = workSpec.id;
                if (currentTimeMillis >= workSpec.calculateNextRunTime() && (!workSpec.hasConstraints() || workConstraintsTracker.areAllConstraintsMet(str3))) {
                    arrayList.add(workSpec);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String str4 = ((WorkSpec) it3.next()).id;
                Intent createDelayMetIntent = createDelayMetIntent(context, str4);
                Logger.get().debug(ConstraintsCommandHandler.TAG, String.format("Creating a delay_met command for workSpec with id (%s)", str4), new Throwable[0]);
                dispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(constraintsCommandHandler.mStartId, createDelayMetIntent, dispatcher));
            }
            workConstraintsTracker.reset();
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", startId, Integer.valueOf(intent)), new Throwable[0]);
            dispatcher.mWorkManager.rescheduleEligibleWork();
            return;
        }
        Bundle extras = startId.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras != null && !extras.isEmpty() && extras.get(strArr[0]) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            String string = startId.getExtras().getString("KEY_WORKSPEC_ID");
            String str5 = TAG;
            Logger.get().debug(str5, String.format("Handling schedule work for %s", string), new Throwable[0]);
            WorkDatabase workDatabase = dispatcher.mWorkManager.mWorkDatabase;
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(string);
                if (workSpec2 == null) {
                    Logger.get().warning(str5, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                } else if (workSpec2.state.isFinished()) {
                    Logger.get().warning(str5, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                } else {
                    long calculateNextRunTime = workSpec2.calculateNextRunTime();
                    boolean hasConstraints = workSpec2.hasConstraints();
                    Context context2 = this.mContext;
                    WorkManagerImpl workManagerImpl = dispatcher.mWorkManager;
                    if (!hasConstraints) {
                        Logger.get().debug(str5, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(calculateNextRunTime)), new Throwable[0]);
                        Alarms.setAlarm(context2, workManagerImpl, string, calculateNextRunTime);
                    } else {
                        Logger.get().debug(str5, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(calculateNextRunTime)), new Throwable[0]);
                        Alarms.setAlarm(context2, workManagerImpl, string, calculateNextRunTime);
                        Intent intent3 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                        intent3.setAction("ACTION_CONSTRAINTS_CHANGED");
                        dispatcher.postOnMainThread(new SystemAlarmDispatcher.AddRunnable(intent, intent3, dispatcher));
                    }
                    workDatabase.setTransactionSuccessful();
                }
                return;
            } finally {
                workDatabase.endTransaction();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            Bundle extras2 = startId.getExtras();
            synchronized (this.mLock) {
                String string2 = extras2.getString("KEY_WORKSPEC_ID");
                Logger logger = Logger.get();
                String str6 = TAG;
                logger.debug(str6, String.format("Handing delay met for %s", string2), new Throwable[0]);
                if (!this.mPendingDelayMet.containsKey(string2)) {
                    DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, intent, string2, dispatcher);
                    this.mPendingDelayMet.put(string2, delayMetCommandHandler);
                    delayMetCommandHandler.handleProcessWork();
                } else {
                    Logger.get().debug(str6, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string2), new Throwable[0]);
                }
            }
            return;
        }
        if ("ACTION_STOP_WORK".equals(action)) {
            String string3 = startId.getExtras().getString("KEY_WORKSPEC_ID");
            Logger.get().debug(TAG, String.format("Handing stopWork work for %s", string3), new Throwable[0]);
            dispatcher.mWorkManager.stopWork(string3);
            String str7 = Alarms.TAG;
            SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) dispatcher.mWorkManager.mWorkDatabase.systemIdInfoDao();
            SystemIdInfo systemIdInfo = systemIdInfoDao_Impl.getSystemIdInfo(string3);
            if (systemIdInfo != null) {
                Alarms.cancelExactAlarm(systemIdInfo.systemId, this.mContext, string3);
                Logger.get().debug(Alarms.TAG, String.format("Removing SystemIdInfo for workSpecId (%s)", string3), new Throwable[0]);
                systemIdInfoDao_Impl.removeSystemIdInfo(string3);
            }
            dispatcher.onExecuted(string3, false);
            return;
        }
        if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            Bundle extras3 = startId.getExtras();
            String string4 = extras3.getString("KEY_WORKSPEC_ID");
            boolean z7 = extras3.getBoolean("KEY_NEEDS_RESCHEDULE");
            Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", startId, Integer.valueOf(intent)), new Throwable[0]);
            onExecuted(string4, z7);
            return;
        }
        Logger.get().warning(TAG, String.format("Ignoring intent %s", startId), new Throwable[0]);
    }
}
