package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameworkSQLiteOpenHelper.kt */
/* loaded from: classes.dex */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public final boolean allowDataLossOnRecovery;
    public final SupportSQLiteOpenHelper.Callback callback;
    public final Context context;
    public final SynchronizedLazyImpl lazyDelegate;
    public final String name;
    public final boolean useNoBackupDirectory;
    public boolean writeAheadLoggingEnabled;

    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    /* loaded from: classes.dex */
    public static final class DBRefHolder {
        public FrameworkSQLiteDatabase db = null;
    }

    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    /* loaded from: classes.dex */
    public static final class OpenHelper extends SQLiteOpenHelper {
        public static final /* synthetic */ int $r8$clinit = 0;
        public final boolean allowDataLossOnRecovery;
        public final SupportSQLiteOpenHelper.Callback callback;
        public final Context context;
        public final DBRefHolder dbRef;
        public final ProcessLock lock;
        public boolean migrated;
        public boolean opened;

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        /* loaded from: classes.dex */
        public static final class CallbackException extends RuntimeException {
            public final CallbackName callbackName;
            public final Throwable cause;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable th) {
                super(th);
                Intrinsics.checkNotNullParameter(callbackName, "callbackName");
                this.callbackName = callbackName;
                this.cause = th;
            }

            @Override // java.lang.Throwable
            public final Throwable getCause() {
                return this.cause;
            }
        }

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        /* loaded from: classes.dex */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
            public static FrameworkSQLiteDatabase getWrappedDb(DBRefHolder refHolder, SQLiteDatabase sqLiteDatabase) {
                Intrinsics.checkNotNullParameter(refHolder, "refHolder");
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = refHolder.db;
                if (frameworkSQLiteDatabase == null || !Intrinsics.areEqual(frameworkSQLiteDatabase.delegate, sqLiteDatabase)) {
                    FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = new FrameworkSQLiteDatabase(sqLiteDatabase);
                    refHolder.db = frameworkSQLiteDatabase2;
                    return frameworkSQLiteDatabase2;
                }
                return frameworkSQLiteDatabase;
            }
        }

        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] r0 = new int[CallbackName.values().length];
                try {
                    r0[CallbackName.ON_CONFIGURE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[CallbackName.ON_CREATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[CallbackName.ON_UPGRADE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[CallbackName.ON_DOWNGRADE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    r0[CallbackName.ON_OPEN.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = r0;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final DBRefHolder dBRefHolder, final SupportSQLiteOpenHelper.Callback callback, boolean z) {
            super(context, str, null, callback.version, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase dbObj) {
                    SupportSQLiteOpenHelper.Callback callback2 = SupportSQLiteOpenHelper.Callback.this;
                    Intrinsics.checkNotNullParameter(callback2, "$callback");
                    FrameworkSQLiteOpenHelper.DBRefHolder dbRef = dBRefHolder;
                    Intrinsics.checkNotNullParameter(dbRef, "$dbRef");
                    int r1 = FrameworkSQLiteOpenHelper.OpenHelper.$r8$clinit;
                    Intrinsics.checkNotNullExpressionValue(dbObj, "dbObj");
                    FrameworkSQLiteDatabase wrappedDb = FrameworkSQLiteOpenHelper.OpenHelper.Companion.getWrappedDb(dbRef, dbObj);
                    Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + wrappedDb + ".path");
                    boolean isOpen = wrappedDb.isOpen();
                    SQLiteDatabase sQLiteDatabase = wrappedDb.delegate;
                    if (!isOpen) {
                        String path = sQLiteDatabase.getPath();
                        if (path != null) {
                            SupportSQLiteOpenHelper.Callback.deleteDatabaseFile(path);
                            return;
                        }
                        return;
                    }
                    List<Pair<String, String>> list = null;
                    try {
                        try {
                            list = wrappedDb.getAttachedDbs();
                        } catch (SQLiteException unused) {
                        }
                        try {
                            wrappedDb.close();
                        } catch (IOException unused2) {
                        }
                    } finally {
                        if (list != null) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                Object obj = ((Pair) it.next()).second;
                                Intrinsics.checkNotNullExpressionValue(obj, "p.second");
                                SupportSQLiteOpenHelper.Callback.deleteDatabaseFile((String) obj);
                            }
                        } else {
                            String path2 = sQLiteDatabase.getPath();
                            if (path2 != null) {
                                SupportSQLiteOpenHelper.Callback.deleteDatabaseFile(path2);
                            }
                        }
                    }
                }
            });
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.context = context;
            this.dbRef = dBRefHolder;
            this.callback = callback;
            this.allowDataLossOnRecovery = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            this.lock = new ProcessLock(str, context.getCacheDir());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public final void close() {
            ProcessLock processLock = this.lock;
            try {
                processLock.lock(processLock.processLock);
                super.close();
                this.dbRef.db = null;
                this.opened = false;
            } finally {
                processLock.unlock();
            }
        }

        public final SupportSQLiteDatabase getSupportDatabase() {
            boolean z;
            ProcessLock processLock = this.lock;
            try {
                if (!this.opened && getDatabaseName() != null) {
                    z = true;
                } else {
                    z = false;
                }
                processLock.lock(z);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase();
                if (this.migrated) {
                    close();
                    return getSupportDatabase();
                }
                return getWrappedDb(innerGetDatabase);
            } finally {
                processLock.unlock();
            }
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sqLiteDatabase);
        }

        public final SQLiteDatabase getWritableOrReadableDatabase() {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
            return writableDatabase;
        }

        public final SQLiteDatabase innerGetDatabase() {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z = this.opened;
            Context context = this.context;
            if (databaseName != null && !z && (parentFile = context.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return getWritableOrReadableDatabase();
            } catch (Throwable unused) {
                super.close();
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return getWritableOrReadableDatabase();
                } catch (Throwable th) {
                    super.close();
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = th;
                        int r3 = WhenMappings.$EnumSwitchMapping$0[callbackException.callbackName.ordinal()];
                        Throwable th2 = callbackException.cause;
                        if (r3 != 1 && r3 != 2 && r3 != 3 && r3 != 4) {
                            if (!(th2 instanceof SQLiteException)) {
                                throw th2;
                            }
                        } else {
                            throw th2;
                        }
                    } else if (th instanceof SQLiteException) {
                        if (databaseName == null || !this.allowDataLossOnRecovery) {
                            throw th;
                        }
                    } else {
                        throw th;
                    }
                    context.deleteDatabase(databaseName);
                    try {
                        return getWritableOrReadableDatabase();
                    } catch (CallbackException e) {
                        throw e.cause;
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onConfigure(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            boolean z = this.migrated;
            SupportSQLiteOpenHelper.Callback callback = this.callback;
            if (!z && callback.version != db.getVersion()) {
                db.setMaxSqlCacheSize(1);
            }
            try {
                callback.onConfigure(getWrappedDb(db));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase db, int r3, int r4) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(db), r3, r4);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onOpen(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(db));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase sqLiteDatabase, int r3, int r4) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sqLiteDatabase), r3, r4);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.name = str;
        this.callback = callback;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
        this.lazyDelegate = LazyKt__LazyJVMKt.lazy(new Function0<OpenHelper>() { // from class: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$lazyDelegate$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
                FrameworkSQLiteOpenHelper.OpenHelper openHelper;
                FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper = FrameworkSQLiteOpenHelper.this;
                if (frameworkSQLiteOpenHelper.name != null && frameworkSQLiteOpenHelper.useNoBackupDirectory) {
                    Context context2 = frameworkSQLiteOpenHelper.context;
                    Intrinsics.checkNotNullParameter(context2, "context");
                    File noBackupFilesDir = context2.getNoBackupFilesDir();
                    Intrinsics.checkNotNullExpressionValue(noBackupFilesDir, "context.noBackupFilesDir");
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.context, new File(noBackupFilesDir, frameworkSQLiteOpenHelper.name).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder(), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
                } else {
                    openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(frameworkSQLiteOpenHelper.context, frameworkSQLiteOpenHelper.name, new FrameworkSQLiteOpenHelper.DBRefHolder(), frameworkSQLiteOpenHelper.callback, frameworkSQLiteOpenHelper.allowDataLossOnRecovery);
                }
                openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.writeAheadLoggingEnabled);
                return openHelper;
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SynchronizedLazyImpl synchronizedLazyImpl = this.lazyDelegate;
        if (synchronizedLazyImpl.isInitialized()) {
            ((OpenHelper) synchronizedLazyImpl.getValue()).close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        return this.name;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        return ((OpenHelper) this.lazyDelegate.getValue()).getSupportDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        SynchronizedLazyImpl synchronizedLazyImpl = this.lazyDelegate;
        if (synchronizedLazyImpl.isInitialized()) {
            OpenHelper sQLiteOpenHelper = (OpenHelper) synchronizedLazyImpl.getValue();
            Intrinsics.checkNotNullParameter(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z);
        }
        this.writeAheadLoggingEnabled = z;
    }
}
