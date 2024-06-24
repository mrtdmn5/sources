package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class WorkTagDao_Impl implements WorkTagDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfWorkTag;

    /* renamed from: androidx.work.impl.model.WorkTagDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<WorkTag> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, WorkTag value) {
            WorkTag workTag = value;
            String str = workTag.tag;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            String str2 = workTag.workSpecId;
            if (str2 == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, str2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public WorkTagDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkTag = new AnonymousClass1(__db);
    }

    public final ArrayList getTagsForWorkSpecId(final String id) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
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
}
