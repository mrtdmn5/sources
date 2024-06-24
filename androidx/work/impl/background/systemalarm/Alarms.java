package androidx.work.impl.background.systemalarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.work.Logger;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.utils.IdGenerator;
import com.animaconnected.watch.device.Command;

/* loaded from: classes.dex */
public final class Alarms {
    public static final String TAG = Logger.tagWithPrefix("Alarms");

    public static void cancelExactAlarm(int context, Context workSpecId, String alarmId) {
        AlarmManager alarmManager = (AlarmManager) workSpecId.getSystemService(Command.ALARM);
        PendingIntent service = PendingIntent.getService(workSpecId, context, CommandHandler.createDelayMetIntent(workSpecId, alarmId), 603979776);
        if (service != null && alarmManager != null) {
            Logger.get().debug(TAG, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", alarmId, Integer.valueOf(context)), new Throwable[0]);
            alarmManager.cancel(service);
        }
    }

    public static void setAlarm(Context context, WorkManagerImpl workManager, String workSpecId, long triggerAtMillis) {
        int r5;
        int r6;
        WorkDatabase workDatabase = workManager.mWorkDatabase;
        SystemIdInfoDao_Impl systemIdInfoDao_Impl = (SystemIdInfoDao_Impl) workDatabase.systemIdInfoDao();
        SystemIdInfo systemIdInfo = systemIdInfoDao_Impl.getSystemIdInfo(workSpecId);
        if (systemIdInfo != null) {
            cancelExactAlarm(systemIdInfo.systemId, context, workSpecId);
            int r12 = systemIdInfo.systemId;
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Command.ALARM);
            PendingIntent service = PendingIntent.getService(context, r12, CommandHandler.createDelayMetIntent(context, workSpecId), 201326592);
            if (alarmManager != null) {
                alarmManager.setExact(0, triggerAtMillis, service);
                return;
            }
            return;
        }
        synchronized (IdGenerator.class) {
            workDatabase.beginTransaction();
            try {
                Long longValue = ((PreferenceDao_Impl) workDatabase.preferenceDao()).getLongValue("next_alarm_manager_id");
                if (longValue != null) {
                    r5 = longValue.intValue();
                } else {
                    r5 = 0;
                }
                if (r5 == Integer.MAX_VALUE) {
                    r6 = 0;
                } else {
                    r6 = r5 + 1;
                }
                ((PreferenceDao_Impl) workDatabase.preferenceDao()).insertPreference(new Preference("next_alarm_manager_id", r6));
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
        SystemIdInfo systemIdInfo2 = new SystemIdInfo(workSpecId, r5);
        RoomDatabase roomDatabase = systemIdInfoDao_Impl.__db;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            systemIdInfoDao_Impl.__insertionAdapterOfSystemIdInfo.insert(systemIdInfo2);
            roomDatabase.setTransactionSuccessful();
            roomDatabase.endTransaction();
            AlarmManager alarmManager2 = (AlarmManager) context.getSystemService(Command.ALARM);
            PendingIntent service2 = PendingIntent.getService(context, r5, CommandHandler.createDelayMetIntent(context, workSpecId), 201326592);
            if (alarmManager2 != null) {
                alarmManager2.setExact(0, triggerAtMillis, service2);
            }
        } catch (Throwable th) {
            roomDatabase.endTransaction();
            throw th;
        }
    }
}
