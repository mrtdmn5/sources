package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final class WorkNameDao_Impl implements WorkNameDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfWorkName;

    /* renamed from: androidx.work.impl.model.WorkNameDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<WorkName> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, WorkName value) {
            WorkName workName = value;
            String str = workName.name;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            String str2 = workName.workSpecId;
            if (str2 == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindString(2, str2);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }
    }

    public WorkNameDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkName = new AnonymousClass1(__db);
    }
}
