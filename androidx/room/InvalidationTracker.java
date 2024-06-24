package androidx.room;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public volatile SupportSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    public final ObservedTableTracker mObservedTableTracker;
    public final String[] mTableNames;
    public final Map<String, Set<String>> mViewTables;
    public final AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    public volatile boolean mInitialized = false;

    @SuppressLint({"RestrictedApi"})
    public final SafeIterableMap<Observer, ObserverWrapper> mObserverMap = new SafeIterableMap<>();
    public final AnonymousClass1 mRefreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker.1
        public final HashSet checkUpdatedTable() {
            HashSet hashSet = new HashSet();
            Cursor query = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
            }
            return hashSet;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00a7 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void run() {
            /*
                r5 = this;
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r0 = r0.mDatabase
                java.util.concurrent.locks.ReentrantReadWriteLock r0 = r0.mCloseLock
                java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r0.readLock()
                r1 = 1
                r2 = 0
                r3 = 0
                r0.lock()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                boolean r4 = r4.ensureInitialization()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                if (r4 != 0) goto L1c
                r0.unlock()
                return
            L1c:
                androidx.room.InvalidationTracker r4 = androidx.room.InvalidationTracker.this     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.mPendingRefresh     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                boolean r1 = r4.compareAndSet(r1, r2)     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                if (r1 != 0) goto L2a
                r0.unlock()
                return
            L2a:
                androidx.room.InvalidationTracker r1 = androidx.room.InvalidationTracker.this     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.room.RoomDatabase r1 = r1.mDatabase     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r1.mOpenHelper     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.sqlite.db.SupportSQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                boolean r1 = r1.inTransaction()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                if (r1 == 0) goto L3e
                r0.unlock()
                return
            L3e:
                androidx.room.InvalidationTracker r1 = androidx.room.InvalidationTracker.this     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.room.RoomDatabase r1 = r1.mDatabase     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                boolean r2 = r1.mWriteAheadLoggingEnabled     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                if (r2 == 0) goto L63
                androidx.sqlite.db.SupportSQLiteOpenHelper r1 = r1.mOpenHelper     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                androidx.sqlite.db.SupportSQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                r1.beginTransaction()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                java.util.HashSet r3 = r5.checkUpdatedTable()     // Catch: java.lang.Throwable -> L5e
                r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L5e
                r1.endTransaction()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                goto L71
            L5a:
                r1 = move-exception
                goto L6a
            L5c:
                r1 = move-exception
                goto L6a
            L5e:
                r2 = move-exception
                r1.endTransaction()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                throw r2     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
            L63:
                java.util.HashSet r3 = r5.checkUpdatedTable()     // Catch: android.database.sqlite.SQLiteException -> L5a java.lang.IllegalStateException -> L5c java.lang.Throwable -> L68
                goto L71
            L68:
                r1 = move-exception
                goto La8
            L6a:
                java.lang.String r2 = "ROOM"
                java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                android.util.Log.e(r2, r4, r1)     // Catch: java.lang.Throwable -> L68
            L71:
                r0.unlock()
                if (r3 == 0) goto La7
                boolean r0 = r3.isEmpty()
                if (r0 != 0) goto La7
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r0 = r0.mObserverMap
                monitor-enter(r0)
                androidx.room.InvalidationTracker r1 = androidx.room.InvalidationTracker.this     // Catch: java.lang.Throwable -> La4
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$ObserverWrapper> r1 = r1.mObserverMap     // Catch: java.lang.Throwable -> La4
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> La4
                androidx.arch.core.internal.SafeIterableMap$ListIterator r1 = (androidx.arch.core.internal.SafeIterableMap.ListIterator) r1     // Catch: java.lang.Throwable -> La4
                boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> La4
                if (r2 != 0) goto L93
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La4
                goto La7
            L93:
                java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> La4
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> La4
                java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> La4
                androidx.room.InvalidationTracker$ObserverWrapper r1 = (androidx.room.InvalidationTracker.ObserverWrapper) r1     // Catch: java.lang.Throwable -> La4
                r1.getClass()     // Catch: java.lang.Throwable -> La4
                r1 = 0
                throw r1     // Catch: java.lang.Throwable -> La4
            La4:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La4
                throw r1
            La7:
                return
            La8:
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.AnonymousClass1.run():void");
        }
    };
    public final HashMap<String, Integer> mTableIdLookup = new HashMap<>();

    /* loaded from: classes.dex */
    public static class ObservedTableTracker {
        public boolean mNeedsSync;
        public boolean mPendingSync;
        public final long[] mTableObservers;
        public final int[] mTriggerStateChanges;
        public final boolean[] mTriggerStates;

        public ObservedTableTracker(int r5) {
            long[] jArr = new long[r5];
            this.mTableObservers = jArr;
            boolean[] zArr = new boolean[r5];
            this.mTriggerStates = zArr;
            this.mTriggerStateChanges = new int[r5];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public final int[] getTablesToSync() {
            boolean z;
            synchronized (this) {
                if (this.mNeedsSync && !this.mPendingSync) {
                    int length = this.mTableObservers.length;
                    int r2 = 0;
                    while (true) {
                        int r3 = 1;
                        if (r2 < length) {
                            if (this.mTableObservers[r2] > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            boolean[] zArr = this.mTriggerStates;
                            if (z != zArr[r2]) {
                                int[] r6 = this.mTriggerStateChanges;
                                if (!z) {
                                    r3 = 2;
                                }
                                r6[r2] = r3;
                            } else {
                                this.mTriggerStateChanges[r2] = 0;
                            }
                            zArr[r2] = z;
                            r2++;
                        } else {
                            this.mPendingSync = true;
                            this.mNeedsSync = false;
                            return this.mTriggerStateChanges;
                        }
                    }
                }
                return null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Observer {
        public abstract void onInvalidated(Set<String> set);
    }

    /* loaded from: classes.dex */
    public static class ObserverWrapper {
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.room.InvalidationTracker$1] */
    public InvalidationTracker(RoomDatabase roomDatabase, HashMap hashMap, HashMap hashMap2, String... strArr) {
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        this.mViewTables = hashMap2;
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int r1 = 0; r1 < length; r1++) {
            String str = strArr[r1];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(r1));
            String str2 = (String) hashMap.get(strArr[r1]);
            if (str2 != null) {
                this.mTableNames[r1] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[r1] = lowerCase;
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str3 = (String) entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = str3.toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap3 = this.mTableIdLookup;
                hashMap3.put(lowerCase3, hashMap3.get(lowerCase2));
            }
        }
    }

    public final boolean ensureInitialization() {
        boolean z;
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase.mDatabase;
        if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.mOpenHelper.getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int r10) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + r10 + ", 0)");
        String str = this.mTableNames[r10];
        StringBuilder sb = new StringBuilder();
        String[] strArr = TRIGGERS;
        for (int r4 = 0; r4 < 3; r4++) {
            String str2 = strArr[r4];
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(r10);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.execSQL(sb.toString());
        }
    }

    public final void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        while (true) {
            try {
                ReentrantReadWriteLock.ReadLock readLock = this.mDatabase.mCloseLock.readLock();
                readLock.lock();
                try {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    int length = tablesToSync.length;
                    supportSQLiteDatabase.beginTransaction();
                    for (int r4 = 0; r4 < length; r4++) {
                        try {
                            int r5 = tablesToSync[r4];
                            if (r5 != 1) {
                                if (r5 == 2) {
                                    String str = this.mTableNames[r4];
                                    StringBuilder sb = new StringBuilder();
                                    String[] strArr = TRIGGERS;
                                    for (int r8 = 0; r8 < 3; r8++) {
                                        String str2 = strArr[r8];
                                        sb.setLength(0);
                                        sb.append("DROP TRIGGER IF EXISTS ");
                                        sb.append("`");
                                        sb.append("room_table_modification_trigger_");
                                        sb.append(str);
                                        sb.append("_");
                                        sb.append(str2);
                                        sb.append("`");
                                        supportSQLiteDatabase.execSQL(sb.toString());
                                    }
                                }
                            } else {
                                startTrackingTable(supportSQLiteDatabase, r4);
                            }
                        } catch (Throwable th) {
                            supportSQLiteDatabase.endTransaction();
                            throw th;
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    ObservedTableTracker observedTableTracker = this.mObservedTableTracker;
                    synchronized (observedTableTracker) {
                        observedTableTracker.mPendingSync = false;
                    }
                } finally {
                    readLock.unlock();
                }
            } catch (SQLiteException | IllegalStateException e) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                return;
            }
        }
    }
}
