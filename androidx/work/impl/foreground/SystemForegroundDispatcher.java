package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    public static final String TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    public Callback mCallback;
    public final WorkConstraintsTracker mConstraintsTracker;
    public String mCurrentForegroundWorkSpecId;
    public final LinkedHashMap mForegroundInfoById;
    public final Object mLock = new Object();
    public final TaskExecutor mTaskExecutor;
    public final HashSet mTrackedWorkSpecs;
    public final WorkManagerImpl mWorkManagerImpl;
    public final HashMap mWorkSpecById;

    /* loaded from: classes.dex */
    public interface Callback {
    }

    public SystemForegroundDispatcher(Context context) {
        WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
        this.mWorkManagerImpl = workManagerImpl;
        TaskExecutor taskExecutor = workManagerImpl.mWorkTaskExecutor;
        this.mTaskExecutor = taskExecutor;
        this.mCurrentForegroundWorkSpecId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTracker(context, taskExecutor, this);
        workManagerImpl.mProcessor.addExecutionListener(this);
    }

    public static Intent createNotifyIntent(Context context, String workSpecId, ForegroundInfo info) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_NOTIFY");
        intent.putExtra("KEY_NOTIFICATION_ID", info.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", info.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", info.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public static Intent createStartForegroundIntent(Context context, String workSpecId, ForegroundInfo info) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction("ACTION_START_FOREGROUND");
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        intent.putExtra("KEY_NOTIFICATION_ID", info.mNotificationId);
        intent.putExtra("KEY_FOREGROUND_SERVICE_TYPE", info.mForegroundServiceType);
        intent.putExtra("KEY_NOTIFICATION", info.mNotification);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public final void handleNotify(Intent intent) {
        int r1 = 0;
        final int intExtra = intent.getIntExtra("KEY_NOTIFICATION_ID", 0);
        int intExtra2 = intent.getIntExtra("KEY_FOREGROUND_SERVICE_TYPE", 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        final Notification notification = (Notification) intent.getParcelableExtra("KEY_NOTIFICATION");
        Logger.get().debug(TAG, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification != null && this.mCallback != null) {
            ForegroundInfo foregroundInfo = new ForegroundInfo(intExtra, intExtra2, notification);
            LinkedHashMap linkedHashMap = this.mForegroundInfoById;
            linkedHashMap.put(stringExtra, foregroundInfo);
            if (TextUtils.isEmpty(this.mCurrentForegroundWorkSpecId)) {
                this.mCurrentForegroundWorkSpecId = stringExtra;
                SystemForegroundService systemForegroundService = (SystemForegroundService) this.mCallback;
                systemForegroundService.mHandler.post(new SystemForegroundService.AnonymousClass1(intExtra, notification, intExtra2));
                return;
            }
            final SystemForegroundService systemForegroundService2 = (SystemForegroundService) this.mCallback;
            systemForegroundService2.mHandler.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.2
                @Override // java.lang.Runnable
                public final void run() {
                    SystemForegroundService.this.mNotificationManager.notify(intExtra, notification);
                }
            });
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    r1 |= ((ForegroundInfo) ((Map.Entry) it.next()).getValue()).mForegroundServiceType;
                }
                ForegroundInfo foregroundInfo2 = (ForegroundInfo) linkedHashMap.get(this.mCurrentForegroundWorkSpecId);
                if (foregroundInfo2 != null) {
                    SystemForegroundService systemForegroundService3 = (SystemForegroundService) this.mCallback;
                    systemForegroundService3.mHandler.post(new SystemForegroundService.AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, r1));
                }
            }
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsNotMet(ArrayList workSpecIds) {
        if (!workSpecIds.isEmpty()) {
            Iterator it = workSpecIds.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Logger.get().debug(TAG, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
                WorkManagerImpl workManagerImpl = this.mWorkManagerImpl;
                ((WorkManagerTaskExecutor) workManagerImpl.mWorkTaskExecutor).executeOnBackgroundThread(new StopWorkRunnable(workManagerImpl, str, true));
            }
        }
    }

    @Override // androidx.work.impl.ExecutionListener
    public final void onExecuted(String workSpecId, boolean needsReschedule) {
        boolean z;
        Map.Entry entry;
        synchronized (this.mLock) {
            try {
                WorkSpec workSpec = (WorkSpec) this.mWorkSpecById.remove(workSpecId);
                if (workSpec != null) {
                    z = this.mTrackedWorkSpecs.remove(workSpec);
                } else {
                    z = false;
                }
                if (z) {
                    this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ForegroundInfo foregroundInfo = (ForegroundInfo) this.mForegroundInfoById.remove(workSpecId);
        if (workSpecId.equals(this.mCurrentForegroundWorkSpecId) && this.mForegroundInfoById.size() > 0) {
            Iterator it = this.mForegroundInfoById.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                } else {
                    next = it.next();
                }
            }
            this.mCurrentForegroundWorkSpecId = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo2 = (ForegroundInfo) entry.getValue();
                Callback callback = this.mCallback;
                SystemForegroundService systemForegroundService = (SystemForegroundService) callback;
                systemForegroundService.mHandler.post(new SystemForegroundService.AnonymousClass1(foregroundInfo2.mNotificationId, foregroundInfo2.mNotification, foregroundInfo2.mForegroundServiceType));
                Callback callback2 = this.mCallback;
                final int r0 = foregroundInfo2.mNotificationId;
                final SystemForegroundService systemForegroundService2 = (SystemForegroundService) callback2;
                systemForegroundService2.mHandler.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        SystemForegroundService.this.mNotificationManager.cancel(r0);
                    }
                });
            }
        }
        Callback callback3 = this.mCallback;
        if (foregroundInfo != null && callback3 != null) {
            Logger.get().debug(TAG, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(foregroundInfo.mNotificationId), workSpecId, Integer.valueOf(foregroundInfo.mForegroundServiceType)), new Throwable[0]);
            final int r9 = foregroundInfo.mNotificationId;
            final SystemForegroundService systemForegroundService3 = (SystemForegroundService) callback3;
            systemForegroundService3.mHandler.post(new Runnable() { // from class: androidx.work.impl.foreground.SystemForegroundService.3
                @Override // java.lang.Runnable
                public final void run() {
                    SystemForegroundService.this.mNotificationManager.cancel(r9);
                }
            });
        }
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public final void onAllConstraintsMet(List<String> workSpecIds) {
    }
}
