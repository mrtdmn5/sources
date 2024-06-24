package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfWorkSpec;
    public final AnonymousClass2 __preparedStmtOfDelete;
    public final AnonymousClass5 __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final AnonymousClass7 __preparedStmtOfMarkWorkSpecScheduled;
    public final AnonymousClass8 __preparedStmtOfResetScheduledState;
    public final AnonymousClass6 __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final AnonymousClass3 __preparedStmtOfSetOutput;
    public final AnonymousClass4 __preparedStmtOfSetPeriodStartTime;

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<WorkSpec> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x01dc  */
        /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Throwable] */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Throwable] */
        @Override // androidx.room.EntityInsertionAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void bind(androidx.sqlite.db.SupportSQLiteStatement r19, androidx.work.impl.model.WorkSpec r20) {
            /*
                Method dump skipped, instructions count: 536
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass1.bind(androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object):void");
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$4, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass4 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$5, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass5 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$7, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass7 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$8, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass8 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public WorkSpecDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkSpec = new AnonymousClass1(__db);
        this.__preparedStmtOfDelete = new AnonymousClass2(__db);
        this.__preparedStmtOfSetOutput = new AnonymousClass3(__db);
        this.__preparedStmtOfSetPeriodStartTime = new AnonymousClass4(__db);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new AnonymousClass5(__db);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new AnonymousClass6(__db);
        this.__preparedStmtOfMarkWorkSpecScheduled = new AnonymousClass7(__db);
        this.__preparedStmtOfResetScheduledState = new AnonymousClass8(__db);
        new AtomicBoolean(false);
    }

    public final void __fetchRelationshipWorkProgressAsandroidxWorkData(final ArrayMap<String, ArrayList<Data>> _map) {
        ArrayList<Data> orDefault;
        MapCollections.KeySet keySet = (MapCollections.KeySet) _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.mSize > 999) {
            ArrayMap<String, ArrayList<Data>> arrayMap = new ArrayMap<>(999);
            int r1 = _map.mSize;
            int r4 = 0;
            int r5 = 0;
            while (r4 < r1) {
                arrayMap.put(_map.keyAt(r4), _map.valueAt(r4));
                r4++;
                r5++;
                if (r5 == 999) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
                    arrayMap = new ArrayMap<>(999);
                    r5 = 0;
                }
            }
            if (r5 > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
                return;
            }
            return;
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(size, m);
        m.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(size + 0, m.toString());
        Iterator it = keySet.iterator();
        int r2 = 1;
        while (true) {
            MapCollections.ArrayIterator arrayIterator = (MapCollections.ArrayIterator) it;
            if (!arrayIterator.hasNext()) {
                break;
            }
            String str = (String) arrayIterator.next();
            if (str == null) {
                acquire.bindNull(r2);
            } else {
                acquire.bindString(r2, str);
            }
            r2++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                if (!query.isNull(columnIndex) && (orDefault = _map.getOrDefault(query.getString(columnIndex), null)) != null) {
                    orDefault.add(Data.fromByteArray(query.getBlob(0)));
                }
            }
        } finally {
            query.close();
        }
    }

    public final void __fetchRelationshipWorkTagAsjavaLangString(final ArrayMap<String, ArrayList<String>> _map) {
        ArrayList<String> orDefault;
        MapCollections.KeySet keySet = (MapCollections.KeySet) _map.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        if (_map.mSize > 999) {
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>(999);
            int r1 = _map.mSize;
            int r4 = 0;
            int r5 = 0;
            while (r4 < r1) {
                arrayMap.put(_map.keyAt(r4), _map.valueAt(r4));
                r4++;
                r5++;
                if (r5 == 999) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    arrayMap = new ArrayMap<>(999);
                    r5 = 0;
                }
            }
            if (r5 > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                return;
            }
            return;
        }
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size = keySet.size();
        StringUtil.appendPlaceholders(size, m);
        m.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(size + 0, m.toString());
        Iterator it = keySet.iterator();
        int r2 = 1;
        while (true) {
            MapCollections.ArrayIterator arrayIterator = (MapCollections.ArrayIterator) it;
            if (!arrayIterator.hasNext()) {
                break;
            }
            String str = (String) arrayIterator.next();
            if (str == null) {
                acquire.bindNull(r2);
            } else {
                acquire.bindString(r2, str);
            }
            r2++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                if (!query.isNull(columnIndex) && (orDefault = _map.getOrDefault(query.getString(columnIndex), null)) != null) {
                    orDefault.add(query.getString(0));
                }
            }
        } finally {
            query.close();
        }
    }

    public final void delete(final String id) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfDelete;
        SupportSQLiteStatement acquire = anonymousClass2.acquire();
        if (id == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, id);
        }
        roomDatabase.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            anonymousClass2.release(acquire);
        }
    }

    public final ArrayList getAllEligibleWorkSpecsForScheduling() {
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?");
        acquire.bindLong(1, 200);
        RoomDatabase roomDatabase = this.__db;
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
            int r28 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow9);
                int r29 = columnIndexOrThrow9;
                String string2 = query.getString(columnIndexOrThrow11);
                int r30 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int r32 = columnIndexOrThrow;
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
                int r0 = columnIndexOrThrow2;
                int r31 = columnIndexOrThrow3;
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                int r3 = r28;
                workSpec.output = Data.fromByteArray(query.getBlob(r3));
                int r13 = columnIndexOrThrow12;
                int r7 = columnIndexOrThrow15;
                workSpec.initialDelay = query.getLong(r7);
                r28 = r3;
                int r1 = columnIndexOrThrow13;
                int r02 = columnIndexOrThrow16;
                workSpec.intervalDuration = query.getLong(r02);
                columnIndexOrThrow16 = r02;
                int r33 = columnIndexOrThrow17;
                workSpec.flexDuration = query.getLong(r33);
                int r03 = columnIndexOrThrow18;
                workSpec.runAttemptCount = query.getInt(r03);
                int r12 = columnIndexOrThrow19;
                columnIndexOrThrow18 = r03;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(r12));
                columnIndexOrThrow17 = r33;
                int r04 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = query.getLong(r04);
                columnIndexOrThrow20 = r04;
                int r34 = columnIndexOrThrow21;
                workSpec.periodStartTime = query.getLong(r34);
                columnIndexOrThrow21 = r34;
                int r05 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = query.getLong(r05);
                columnIndexOrThrow22 = r05;
                int r35 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = query.getLong(r35);
                int r06 = columnIndexOrThrow24;
                if (query.getInt(r06) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                int r14 = columnIndexOrThrow25;
                columnIndexOrThrow24 = r06;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(r14));
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow25 = r14;
                columnIndexOrThrow23 = r35;
                columnIndexOrThrow12 = r13;
                columnIndexOrThrow2 = r0;
                columnIndexOrThrow9 = r29;
                columnIndexOrThrow11 = r30;
                columnIndexOrThrow = r32;
                columnIndexOrThrow15 = r7;
                columnIndexOrThrow3 = r31;
                columnIndexOrThrow19 = r12;
                columnIndexOrThrow13 = r1;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public final ArrayList getEligibleWorkForScheduling(final int schedulerLimit) {
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))");
        acquire.bindLong(1, schedulerLimit);
        RoomDatabase roomDatabase = this.__db;
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
            int r28 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow9);
                int r29 = columnIndexOrThrow9;
                String string2 = query.getString(columnIndexOrThrow11);
                int r30 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int r32 = columnIndexOrThrow;
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
                int r0 = columnIndexOrThrow2;
                int r31 = columnIndexOrThrow3;
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                int r3 = r28;
                workSpec.output = Data.fromByteArray(query.getBlob(r3));
                int r13 = columnIndexOrThrow12;
                int r7 = columnIndexOrThrow15;
                workSpec.initialDelay = query.getLong(r7);
                r28 = r3;
                int r1 = columnIndexOrThrow13;
                int r02 = columnIndexOrThrow16;
                workSpec.intervalDuration = query.getLong(r02);
                columnIndexOrThrow16 = r02;
                int r33 = columnIndexOrThrow17;
                workSpec.flexDuration = query.getLong(r33);
                int r03 = columnIndexOrThrow18;
                workSpec.runAttemptCount = query.getInt(r03);
                int r12 = columnIndexOrThrow19;
                columnIndexOrThrow18 = r03;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(r12));
                columnIndexOrThrow17 = r33;
                int r04 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = query.getLong(r04);
                columnIndexOrThrow20 = r04;
                int r34 = columnIndexOrThrow21;
                workSpec.periodStartTime = query.getLong(r34);
                columnIndexOrThrow21 = r34;
                int r05 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = query.getLong(r05);
                columnIndexOrThrow22 = r05;
                int r35 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = query.getLong(r35);
                int r06 = columnIndexOrThrow24;
                if (query.getInt(r06) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                int r14 = columnIndexOrThrow25;
                columnIndexOrThrow24 = r06;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(r14));
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow25 = r14;
                columnIndexOrThrow23 = r35;
                columnIndexOrThrow12 = r13;
                columnIndexOrThrow2 = r0;
                columnIndexOrThrow9 = r29;
                columnIndexOrThrow11 = r30;
                columnIndexOrThrow = r32;
                columnIndexOrThrow15 = r7;
                columnIndexOrThrow3 = r31;
                columnIndexOrThrow19 = r12;
                columnIndexOrThrow13 = r1;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public final ArrayList getRunningWork() {
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1");
        RoomDatabase roomDatabase = this.__db;
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
            int r28 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow9);
                int r29 = columnIndexOrThrow9;
                String string2 = query.getString(columnIndexOrThrow11);
                int r30 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int r32 = columnIndexOrThrow;
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
                int r0 = columnIndexOrThrow2;
                int r33 = columnIndexOrThrow3;
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                int r3 = r28;
                workSpec.output = Data.fromByteArray(query.getBlob(r3));
                int r12 = columnIndexOrThrow13;
                int r6 = columnIndexOrThrow15;
                workSpec.initialDelay = query.getLong(r6);
                int r1 = columnIndexOrThrow4;
                int r02 = columnIndexOrThrow16;
                workSpec.intervalDuration = query.getLong(r02);
                int r62 = columnIndexOrThrow17;
                workSpec.flexDuration = query.getLong(r62);
                int r03 = columnIndexOrThrow18;
                workSpec.runAttemptCount = query.getInt(r03);
                int r13 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(r13));
                int r04 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = query.getLong(r04);
                int r63 = columnIndexOrThrow21;
                workSpec.periodStartTime = query.getLong(r63);
                int r05 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = query.getLong(r05);
                int r64 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = query.getLong(r64);
                int r06 = columnIndexOrThrow24;
                if (query.getInt(r06) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                int r14 = columnIndexOrThrow25;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(r14));
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                r28 = r3;
                columnIndexOrThrow2 = r0;
                columnIndexOrThrow15 = r6;
                columnIndexOrThrow16 = r02;
                columnIndexOrThrow20 = r04;
                columnIndexOrThrow21 = r63;
                columnIndexOrThrow24 = r06;
                columnIndexOrThrow11 = r30;
                columnIndexOrThrow = r32;
                columnIndexOrThrow25 = r14;
                columnIndexOrThrow23 = r64;
                columnIndexOrThrow13 = r12;
                columnIndexOrThrow9 = r29;
                columnIndexOrThrow3 = r33;
                columnIndexOrThrow22 = r05;
                columnIndexOrThrow4 = r1;
                columnIndexOrThrow17 = r62;
                columnIndexOrThrow18 = r03;
                columnIndexOrThrow19 = r13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public final ArrayList getScheduledWork() {
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(0, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1");
        RoomDatabase roomDatabase = this.__db;
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
            int r28 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                String string = query.getString(columnIndexOrThrow9);
                int r29 = columnIndexOrThrow9;
                String string2 = query.getString(columnIndexOrThrow11);
                int r30 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int r32 = columnIndexOrThrow;
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
                int r0 = columnIndexOrThrow2;
                int r33 = columnIndexOrThrow3;
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                int r3 = r28;
                workSpec.output = Data.fromByteArray(query.getBlob(r3));
                int r12 = columnIndexOrThrow13;
                int r6 = columnIndexOrThrow15;
                workSpec.initialDelay = query.getLong(r6);
                int r1 = columnIndexOrThrow4;
                int r02 = columnIndexOrThrow16;
                workSpec.intervalDuration = query.getLong(r02);
                int r62 = columnIndexOrThrow17;
                workSpec.flexDuration = query.getLong(r62);
                int r03 = columnIndexOrThrow18;
                workSpec.runAttemptCount = query.getInt(r03);
                int r13 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(r13));
                int r04 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = query.getLong(r04);
                int r63 = columnIndexOrThrow21;
                workSpec.periodStartTime = query.getLong(r63);
                int r05 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = query.getLong(r05);
                int r64 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = query.getLong(r64);
                int r06 = columnIndexOrThrow24;
                if (query.getInt(r06) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                int r14 = columnIndexOrThrow25;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(r14));
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                r28 = r3;
                columnIndexOrThrow2 = r0;
                columnIndexOrThrow15 = r6;
                columnIndexOrThrow16 = r02;
                columnIndexOrThrow20 = r04;
                columnIndexOrThrow21 = r63;
                columnIndexOrThrow24 = r06;
                columnIndexOrThrow11 = r30;
                columnIndexOrThrow = r32;
                columnIndexOrThrow25 = r14;
                columnIndexOrThrow23 = r64;
                columnIndexOrThrow13 = r12;
                columnIndexOrThrow9 = r29;
                columnIndexOrThrow3 = r33;
                columnIndexOrThrow22 = r05;
                columnIndexOrThrow4 = r1;
                columnIndexOrThrow17 = r62;
                columnIndexOrThrow18 = r03;
                columnIndexOrThrow19 = r13;
            }
            query.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public final WorkInfo.State getState(final String id) {
        WorkInfo.State state;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT state FROM workspec WHERE id=?");
        if (id == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, id);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            if (query.moveToFirst()) {
                state = WorkTypeConverters.intToState(query.getInt(0));
            } else {
                state = null;
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final ArrayList getUnfinishedWorkWithName(final String name) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (name == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, name);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final ArrayList getUnfinishedWorkWithTag(final String tag) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)");
        if (tag == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, tag);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final WorkSpec getWorkSpec(final String id) {
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
        WorkSpec workSpec;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?");
        if (id == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, id);
        }
        RoomDatabase roomDatabase = this.__db;
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
            if (query.moveToFirst()) {
                String string = query.getString(columnIndexOrThrow9);
                String string2 = query.getString(columnIndexOrThrow11);
                Constraints constraints = new Constraints();
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
                constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                constraints.mContentUriTriggers = WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                if (query.getInt(columnIndexOrThrow24) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                workSpec.expedited = z5;
                workSpec.outOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(query.getInt(columnIndexOrThrow25));
                workSpec.constraints = constraints;
            } else {
                workSpec = null;
            }
            query.close();
            roomSQLiteQuery.release();
            return workSpec;
        } catch (Throwable th2) {
            th = th2;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public final ArrayList getWorkSpecIdAndStatesForName(final String name) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
        if (name == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, name);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, ConfigurationItem.COLUMN_NAME_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = query.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final int markWorkSpecScheduled(final long id, final String startTime) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        AnonymousClass7 anonymousClass7 = this.__preparedStmtOfMarkWorkSpecScheduled;
        SupportSQLiteStatement acquire = anonymousClass7.acquire();
        acquire.bindLong(1, id);
        if (startTime == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, startTime);
        }
        roomDatabase.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
            anonymousClass7.release(acquire);
        }
    }

    public final void setOutput(final String id, final Data output) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        AnonymousClass3 anonymousClass3 = this.__preparedStmtOfSetOutput;
        SupportSQLiteStatement acquire = anonymousClass3.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(output);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (id == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, id);
        }
        roomDatabase.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            anonymousClass3.release(acquire);
        }
    }

    public final void setPeriodStartTime(final long id, final String periodStartTime) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        AnonymousClass4 anonymousClass4 = this.__preparedStmtOfSetPeriodStartTime;
        SupportSQLiteStatement acquire = anonymousClass4.acquire();
        acquire.bindLong(1, id);
        if (periodStartTime == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, periodStartTime);
        }
        roomDatabase.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
            anonymousClass4.release(acquire);
        }
    }

    public final int setState(final WorkInfo.State state, final String... ids) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=? WHERE id IN (");
        StringUtil.appendPlaceholders(ids.length, sb);
        sb.append(")");
        String sb2 = sb.toString();
        roomDatabase.assertNotMainThread();
        roomDatabase.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement compileStatement = roomDatabase.mOpenHelper.getWritableDatabase().compileStatement(sb2);
        compileStatement.bindLong(1, WorkTypeConverters.stateToInt(state));
        int r2 = 2;
        for (String str : ids) {
            if (str == null) {
                compileStatement.bindNull(r2);
            } else {
                compileStatement.bindString(r2, str);
            }
            r2++;
        }
        roomDatabase.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            roomDatabase.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
