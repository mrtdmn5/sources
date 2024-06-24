package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import com.animaconnected.watch.device.Command;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ForceStopRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    public static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    public final Context mContext;
    public int mRetryCount = 0;
    public final WorkManagerImpl mWorkManager;

    /* loaded from: classes.dex */
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        public static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                if (((Logger.LogcatLogger) Logger.get()).mLoggingLevel <= 2) {
                    Log.v(TAG, "Rescheduling alarm that keeps track of force-stops.");
                }
                ForceStopRunnable.setAlarm(context);
            }
        }
    }

    public ForceStopRunnable(Context context, WorkManagerImpl workManager) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManager;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void setAlarm(Context context) {
        int r1;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Command.ALARM);
        if (BuildCompat.isAtLeastS()) {
            r1 = 167772160;
        } else {
            r1 = 134217728;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, r1);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, broadcast);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void forceStopRunnable() {
        /*
            Method dump skipped, instructions count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.ForceStopRunnable.forceStopRunnable():void");
    }

    public final boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.mConfiguration;
        configuration.getClass();
        boolean isEmpty = TextUtils.isEmpty(null);
        String str = TAG;
        if (isEmpty) {
            Logger.get().debug(str, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean isDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, configuration);
        Logger.get().debug(str, String.format("Is default app process = %s", Boolean.valueOf(isDefaultProcess)), new Throwable[0]);
        return isDefaultProcess;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = TAG;
        WorkManagerImpl workManagerImpl = this.mWorkManager;
        try {
            if (!multiProcessChecks()) {
                return;
            }
            while (true) {
                WorkDatabasePathHelper.migrateDatabase(this.mContext);
                Logger.get().debug(str, "Performing cleanup operations.", new Throwable[0]);
                try {
                    forceStopRunnable();
                    return;
                } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e) {
                    int r3 = this.mRetryCount + 1;
                    this.mRetryCount = r3;
                    if (r3 < 3) {
                        Logger.get().debug(str, String.format("Retrying after %s", Long.valueOf(r3 * 300)), e);
                        try {
                            Thread.sleep(this.mRetryCount * 300);
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        Logger.get().error(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);
                        workManagerImpl.mConfiguration.getClass();
                        throw illegalStateException;
                    }
                }
            }
        } finally {
            workManagerImpl.onForceStopRunnableCompleted();
        }
    }
}
