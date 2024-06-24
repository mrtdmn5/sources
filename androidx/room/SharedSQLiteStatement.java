package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    public final RoomDatabase mDatabase;
    public final AtomicBoolean mLock = new AtomicBoolean(false);
    public volatile SupportSQLiteStatement mStmt;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        this.mDatabase = roomDatabase;
    }

    public final SupportSQLiteStatement acquire() {
        this.mDatabase.assertNotMainThread();
        if (this.mLock.compareAndSet(false, true)) {
            if (this.mStmt == null) {
                String createQuery = createQuery();
                RoomDatabase roomDatabase = this.mDatabase;
                roomDatabase.assertNotMainThread();
                roomDatabase.assertNotSuspendingTransaction();
                this.mStmt = roomDatabase.mOpenHelper.getWritableDatabase().compileStatement(createQuery);
            }
            return this.mStmt;
        }
        String createQuery2 = createQuery();
        RoomDatabase roomDatabase2 = this.mDatabase;
        roomDatabase2.assertNotMainThread();
        roomDatabase2.assertNotSuspendingTransaction();
        return roomDatabase2.mOpenHelper.getWritableDatabase().compileStatement(createQuery2);
    }

    public abstract String createQuery();

    public final void release(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
