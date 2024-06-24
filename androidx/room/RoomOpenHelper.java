package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.WorkDatabase_Impl;

/* loaded from: classes.dex */
public final class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public DatabaseConfiguration mConfiguration;
    public final Delegate mDelegate;

    /* loaded from: classes.dex */
    public static abstract class Delegate {
        public final int version = 12;

        public abstract void createAllTables(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract ValidationResult onValidateSchema(FrameworkSQLiteDatabase frameworkSQLiteDatabase);
    }

    /* loaded from: classes.dex */
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, WorkDatabase_Impl.AnonymousClass1 anonymousClass1) {
        super(anonymousClass1.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = anonymousClass1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[ORIG_RETURN, RETURN] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r5) {
        /*
            r4 = this;
            java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            android.database.Cursor r0 = r5.query(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L61
            r2 = 0
            if (r1 == 0) goto L15
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L61
            if (r1 != 0) goto L15
            r1 = 1
            goto L16
        L15:
            r1 = r2
        L16:
            r0.close()
            androidx.room.RoomOpenHelper$Delegate r0 = r4.mDelegate
            r0.createAllTables(r5)
            if (r1 != 0) goto L3f
            androidx.room.RoomOpenHelper$ValidationResult r1 = r0.onValidateSchema(r5)
            boolean r3 = r1.isValid
            if (r3 == 0) goto L29
            goto L3f
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.expectedFoundMsg
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L3f:
            r4.updateIdentity(r5)
            androidx.work.impl.WorkDatabase_Impl$1 r0 = (androidx.work.impl.WorkDatabase_Impl.AnonymousClass1) r0
            int r5 = androidx.work.impl.WorkDatabase_Impl.$r8$clinit
            androidx.work.impl.WorkDatabase_Impl r5 = androidx.work.impl.WorkDatabase_Impl.this
            java.util.List<androidx.room.RoomDatabase$Callback> r0 = r5.mCallbacks
            if (r0 == 0) goto L60
            int r0 = r0.size()
        L50:
            if (r2 >= r0) goto L60
            java.util.List<androidx.room.RoomDatabase$Callback> r1 = r5.mCallbacks
            java.lang.Object r1 = r1.get(r2)
            androidx.room.RoomDatabase$Callback r1 = (androidx.room.RoomDatabase.Callback) r1
            r1.getClass()
            int r2 = r2 + 1
            goto L50
        L60:
            return
        L61:
            r5 = move-exception
            r0.close()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onCreate(androidx.sqlite.db.framework.FrameworkSQLiteDatabase):void");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void onDowngrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int r2, int r3) {
        onUpgrade(frameworkSQLiteDatabase, r2, r3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0055  */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onOpen(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r7) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onOpen(androidx.sqlite.db.framework.FrameworkSQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0076 A[EDGE_INSN: B:90:0x0076->B:79:0x0076 BREAK  A[LOOP:4: B:58:0x0020->B:80:?], SYNTHETIC] */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onUpgrade(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.onUpgrade(androidx.sqlite.db.framework.FrameworkSQLiteDatabase, int, int):void");
    }

    public final void updateIdentity(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public final void onConfigure(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
    }
}
