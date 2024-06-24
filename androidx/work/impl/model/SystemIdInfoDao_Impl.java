package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfSystemIdInfo;
    public final AnonymousClass2 __preparedStmtOfRemoveSystemIdInfo;

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<SystemIdInfo> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, SystemIdInfo value) {
            String str = value.workSpecId;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            stmt.bindLong(2, r4.systemId);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }
    }

    /* renamed from: androidx.work.impl.model.SystemIdInfoDao_Impl$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public SystemIdInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSystemIdInfo = new AnonymousClass1(__db);
        this.__preparedStmtOfRemoveSystemIdInfo = new AnonymousClass2(__db);
    }

    public final SystemIdInfo getSystemIdInfo(final String workSpecId) {
        SystemIdInfo systemIdInfo;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?");
        if (workSpecId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, workSpecId);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "work_spec_id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "system_id");
            if (query.moveToFirst()) {
                systemIdInfo = new SystemIdInfo(query.getString(columnIndexOrThrow), query.getInt(columnIndexOrThrow2));
            } else {
                systemIdInfo = null;
            }
            return systemIdInfo;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final void removeSystemIdInfo(final String workSpecId) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        AnonymousClass2 anonymousClass2 = this.__preparedStmtOfRemoveSystemIdInfo;
        SupportSQLiteStatement acquire = anonymousClass2.acquire();
        if (workSpecId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, workSpecId);
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
}
