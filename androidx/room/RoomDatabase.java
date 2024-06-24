package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.util.Log;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public abstract class RoomDatabase {
    public boolean mAllowMainThreadQueries;

    @Deprecated
    public List<Callback> mCallbacks;

    @Deprecated
    public volatile SupportSQLiteDatabase mDatabase;
    public final InvalidationTracker mInvalidationTracker;
    public SupportSQLiteOpenHelper mOpenHelper;
    public Executor mQueryExecutor;
    public boolean mWriteAheadLoggingEnabled;
    public final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    public final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static class Builder<T extends RoomDatabase> {
        public boolean mAllowDestructiveMigrationOnDowngrade;
        public boolean mAllowMainThreadQueries;
        public ArrayList<Callback> mCallbacks;
        public final Context mContext;
        public SupportSQLiteOpenHelper.Factory mFactory;
        public HashSet mMigrationStartAndEndVersions;
        public final String mName;
        public Executor mQueryExecutor;
        public Executor mTransactionExecutor;
        public final Class<T> mDatabaseClass = WorkDatabase.class;
        public final JournalMode mJournalMode = JournalMode.AUTOMATIC;
        public boolean mRequireMigration = true;
        public final MigrationContainer mMigrationContainer = new MigrationContainer();

        public Builder(Context context, String str) {
            this.mContext = context;
            this.mName = str;
        }

        public final void addMigrations(Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            MigrationContainer migrationContainer = this.mMigrationContainer;
            migrationContainer.getClass();
            for (Migration migration2 : migrationArr) {
                int r4 = migration2.startVersion;
                HashMap<Integer, TreeMap<Integer, Migration>> hashMap = migrationContainer.mMigrations;
                TreeMap<Integer, Migration> treeMap = hashMap.get(Integer.valueOf(r4));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    hashMap.put(Integer.valueOf(r4), treeMap);
                }
                int r42 = migration2.endVersion;
                Migration migration3 = treeMap.get(Integer.valueOf(r42));
                if (migration3 != null) {
                    Log.w("ROOM", "Overriding migration " + migration3 + " with " + migration2);
                }
                treeMap.put(Integer.valueOf(r42), migration2);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        @SuppressLint({"NewApi"})
        public JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* loaded from: classes.dex */
    public static class MigrationContainer {
        public final HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();
    }

    public RoomDatabase() {
        new ConcurrentHashMap();
        this.mInvalidationTracker = createInvalidationTracker();
    }

    public final void assertNotMainThread() {
        boolean z;
        if (this.mAllowMainThreadQueries) {
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
        } else {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public final void assertNotSuspendingTransaction() {
        if (!this.mOpenHelper.getWritableDatabase().inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public final void beginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        writableDatabase.beginTransaction();
    }

    public abstract InvalidationTracker createInvalidationTracker();

    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public final void endTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (!this.mOpenHelper.getWritableDatabase().inTransaction()) {
            InvalidationTracker invalidationTracker = this.mInvalidationTracker;
            if (invalidationTracker.mPendingRefresh.compareAndSet(false, true)) {
                invalidationTracker.mDatabase.mQueryExecutor.execute(invalidationTracker.mRefreshRunnable);
            }
        }
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    @Deprecated
    public final void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public void onOpen(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        }
    }
}
