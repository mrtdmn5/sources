package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;

/* loaded from: classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfWorkProgress;
    public final AnonymousClass2 __preparedStmtOfDelete;
    public final AnonymousClass3 __preparedStmtOfDeleteAll;

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<WorkProgress> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, WorkProgress value) {
            WorkProgress workProgress = value;
            String str = workProgress.mWorkSpecId;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            byte[] byteArrayInternal = Data.toByteArrayInternal(workProgress.mProgress);
            if (byteArrayInternal == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindBlob(2, byteArrayInternal);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkProgressDao_Impl$3, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM WorkProgress";
        }
    }

    public WorkProgressDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkProgress = new AnonymousClass1(__db);
        this.__preparedStmtOfDelete = new AnonymousClass2(__db);
        this.__preparedStmtOfDeleteAll = new AnonymousClass3(__db);
    }
}
