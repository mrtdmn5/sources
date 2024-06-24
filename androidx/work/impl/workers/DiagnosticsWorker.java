package androidx.work.impl.workers;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.model.WorkTypeConverters;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {
    public static final String TAG = Logger.tagWithPrefix("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
    }

    public static String workSpecRows(WorkNameDao workNameDao, WorkTagDao workTagDao, SystemIdInfoDao systemIdInfoDao, ArrayList workSpecs) {
        Integer num;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", "Job Id"));
        Iterator it = workSpecs.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            SystemIdInfo systemIdInfo = ((SystemIdInfoDao_Impl) systemIdInfoDao).getSystemIdInfo(workSpec.id);
            if (systemIdInfo != null) {
                num = Integer.valueOf(systemIdInfo.systemId);
            } else {
                num = null;
            }
            Integer num2 = num;
            String str = workSpec.id;
            WorkNameDao_Impl workNameDao_Impl = (WorkNameDao_Impl) workNameDao;
            workNameDao_Impl.getClass();
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT name FROM workname WHERE work_spec_id=?");
            if (str == null) {
                acquire.bindNull(1);
            } else {
                acquire.bindString(1, str);
            }
            RoomDatabase roomDatabase = workNameDao_Impl.__db;
            roomDatabase.assertNotSuspendingTransaction();
            Cursor query = DBUtil.query(roomDatabase, acquire, false);
            try {
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
                query.close();
                acquire.release();
                ArrayList tagsForWorkSpecId = ((WorkTagDao_Impl) workTagDao).getTagsForWorkSpecId(workSpec.id);
                sb.append(String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.id, workSpec.workerClassName, num2, workSpec.state.name(), TextUtils.join(",", arrayList), TextUtils.join(",", tagsForWorkSpecId)));
            } catch (Throwable th) {
                query.close();
                acquire.release();
                throw th;
            }
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result.Success doWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        SystemIdInfoDao systemIdInfoDao;
        WorkNameDao workNameDao;
        WorkTagDao workTagDao;
        int r5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        WorkDatabase workDatabase = WorkManagerImpl.getInstance(getApplicationContext()).mWorkDatabase;
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkNameDao workNameDao2 = workDatabase.workNameDao();
        WorkTagDao workTagDao2 = workDatabase.workTagDao();
        SystemIdInfoDao systemIdInfoDao2 = workDatabase.systemIdInfoDao();
        long currentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workSpecDao;
        workSpecDao_Impl.getClass();
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC");
        acquire.bindLong(1, currentTimeMillis);
        RoomDatabase roomDatabase = workSpecDao_Impl.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, ConfigurationItem.COLUMN_NAME_ID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = acquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
            int r32 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow9);
                int r33 = columnIndexOrThrow9;
                String string2 = query.getString(columnIndexOrThrow11);
                int r34 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int r36 = columnIndexOrThrow;
                constraints.mRequiredNetworkType = WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow));
                if (query.getInt(columnIndexOrThrow2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                constraints.mRequiresCharging = z;
                if (query.getInt(columnIndexOrThrow3) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                constraints.mRequiresDeviceIdle = z2;
                if (query.getInt(columnIndexOrThrow4) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                constraints.mRequiresBatteryNotLow = z3;
                if (query.getInt(columnIndexOrThrow5) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                constraints.mRequiresStorageNotLow = z4;
                int r35 = columnIndexOrThrow2;
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                int r1 = r32;
                workSpec.output = Data.fromByteArray(query.getBlob(r1));
                r32 = r1;
                int r9 = columnIndexOrThrow12;
                int r6 = columnIndexOrThrow15;
                workSpec.initialDelay = query.getLong(r6);
                int r21 = columnIndexOrThrow13;
                int r12 = columnIndexOrThrow16;
                workSpec.intervalDuration = query.getLong(r12);
                int r3 = columnIndexOrThrow10;
                int r2 = columnIndexOrThrow17;
                workSpec.flexDuration = query.getLong(r2);
                int r52 = columnIndexOrThrow18;
                workSpec.runAttemptCount = query.getInt(r52);
                int r62 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(r62));
                columnIndexOrThrow17 = r2;
                int r13 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = query.getLong(r13);
                int r22 = columnIndexOrThrow21;
                workSpec.periodStartTime = query.getLong(r22);
                columnIndexOrThrow21 = r22;
                int r53 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = query.getLong(r53);
                int r14 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = query.getLong(r14);
                int r23 = columnIndexOrThrow24;
                if (query.getInt(r23) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                int r37 = columnIndexOrThrow25;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(r37));
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow25 = r37;
                columnIndexOrThrow13 = r21;
                columnIndexOrThrow15 = r6;
                columnIndexOrThrow16 = r12;
                columnIndexOrThrow18 = r52;
                columnIndexOrThrow23 = r14;
                columnIndexOrThrow11 = r34;
                columnIndexOrThrow = r36;
                columnIndexOrThrow24 = r23;
                columnIndexOrThrow22 = r53;
                columnIndexOrThrow12 = r9;
                columnIndexOrThrow10 = r3;
                columnIndexOrThrow19 = r62;
                columnIndexOrThrow2 = r35;
                columnIndexOrThrow20 = r13;
                columnIndexOrThrow9 = r33;
            }
            query.close();
            roomSQLiteQuery.release();
            ArrayList runningWork = workSpecDao_Impl.getRunningWork();
            ArrayList allEligibleWorkSpecsForScheduling = workSpecDao_Impl.getAllEligibleWorkSpecsForScheduling();
            boolean isEmpty = arrayList.isEmpty();
            String str = TAG;
            if (!isEmpty) {
                r5 = 0;
                Logger.get().info(str, "Recently completed work:\n\n", new Throwable[0]);
                systemIdInfoDao = systemIdInfoDao2;
                workNameDao = workNameDao2;
                workTagDao = workTagDao2;
                Logger.get().info(str, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, arrayList), new Throwable[0]);
            } else {
                systemIdInfoDao = systemIdInfoDao2;
                workNameDao = workNameDao2;
                workTagDao = workTagDao2;
                r5 = 0;
            }
            if (!runningWork.isEmpty()) {
                Logger.get().info(str, "Running work:\n\n", new Throwable[r5]);
                Logger.get().info(str, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, runningWork), new Throwable[r5]);
            }
            if (!allEligibleWorkSpecsForScheduling.isEmpty()) {
                Logger.get().info(str, "Enqueued work:\n\n", new Throwable[r5]);
                Logger.get().info(str, workSpecRows(workNameDao, workTagDao, systemIdInfoDao, allEligibleWorkSpecsForScheduling), new Throwable[r5]);
            }
            return new ListenableWorker.Result.Success();
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }
}
