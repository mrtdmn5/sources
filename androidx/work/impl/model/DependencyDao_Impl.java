package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class DependencyDao_Impl implements DependencyDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfDependency;

    /* renamed from: androidx.work.impl.model.DependencyDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<Dependency> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, Dependency value) {
            Dependency dependency = value;
            String str = dependency.workSpecId;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            String str2 = dependency.prerequisiteId;
            if (str2 == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, str2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }
    }

    public DependencyDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDependency = new AnonymousClass1(__db);
    }

    public final ArrayList getDependentWorkIds(final String id) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (id == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, id);
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

    public final boolean hasCompletedAllPrerequisites(final String id) {
        boolean z = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (id == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, id);
        }
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        boolean z2 = false;
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            if (query.moveToFirst()) {
                if (query.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
