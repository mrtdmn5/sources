package app.cash.sqldelight.driver.android;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.AfterVersion;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import app.cash.sqldelight.db.SqlSchema;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class AndroidSqliteDriver implements SqlDriver {
    public final SynchronizedLazyImpl database$delegate;
    public final LinkedHashMap<String, Set<Query.Listener>> listeners;
    public final SupportSQLiteOpenHelper openHelper;
    public final AndroidSqliteDriver$statements$1 statements;
    public final ThreadLocal<Transacter.Transaction> transactions;
    public final Long windowSizeBytes;

    /* compiled from: AndroidSqliteDriver.kt */
    /* loaded from: classes.dex */
    public static class Callback extends SupportSQLiteOpenHelper.Callback {
        public final AfterVersion[] callbacks;
        public final SqlSchema<QueryResult.Value<Unit>> schema;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Callback(SqlSchema<QueryResult.Value<Unit>> schema, AfterVersion... afterVersionArr) {
            super((int) schema.getVersion());
            Intrinsics.checkNotNullParameter(schema, "schema");
            if (schema.getVersion() <= 2147483647L) {
                this.schema = schema;
                this.callbacks = afterVersionArr;
            } else {
                throw new IllegalStateException(("Schema version is larger than Int.MAX_VALUE: " + schema.getVersion() + '.').toString());
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public final void onCreate(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.schema.create(new AndroidSqliteDriver(frameworkSQLiteDatabase));
        }

        @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
        public final void onUpgrade(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int r9, int r10) {
            AfterVersion[] afterVersionArr = this.callbacks;
            this.schema.migrate(new AndroidSqliteDriver(frameworkSQLiteDatabase), r9, r10, (AfterVersion[]) Arrays.copyOf(afterVersionArr, afterVersionArr.length));
        }
    }

    /* compiled from: AndroidSqliteDriver.kt */
    /* loaded from: classes.dex */
    public final class Transaction extends Transacter.Transaction {
        public final Transacter.Transaction enclosingTransaction;

        public Transaction(Transacter.Transaction transaction) {
            this.enclosingTransaction = transaction;
        }

        @Override // app.cash.sqldelight.Transacter.Transaction
        public final QueryResult.Value endTransaction(boolean z) {
            Transacter.Transaction transaction = this.enclosingTransaction;
            AndroidSqliteDriver androidSqliteDriver = AndroidSqliteDriver.this;
            if (transaction == null) {
                if (z) {
                    androidSqliteDriver.getDatabase().setTransactionSuccessful();
                    androidSqliteDriver.getDatabase().endTransaction();
                } else {
                    androidSqliteDriver.getDatabase().endTransaction();
                }
            }
            androidSqliteDriver.transactions.set(transaction);
            QueryResult.Companion.getClass();
            return new QueryResult.Value(QueryResult.Companion.Unit);
        }

        @Override // app.cash.sqldelight.Transacter.Transaction
        public final Transacter.Transaction getEnclosingTransaction() {
            return this.enclosingTransaction;
        }
    }

    public AndroidSqliteDriver(SupportSQLiteOpenHelper supportSQLiteOpenHelper, final SupportSQLiteDatabase supportSQLiteDatabase, int r4, Long l) {
        this.openHelper = supportSQLiteOpenHelper;
        this.windowSizeBytes = l;
        if ((supportSQLiteOpenHelper != null) ^ (supportSQLiteDatabase != null)) {
            this.transactions = new ThreadLocal<>();
            this.database$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SupportSQLiteDatabase>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$database$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final SupportSQLiteDatabase invoke() {
                    SupportSQLiteDatabase writableDatabase;
                    SupportSQLiteOpenHelper supportSQLiteOpenHelper2 = AndroidSqliteDriver.this.openHelper;
                    if (supportSQLiteOpenHelper2 == null || (writableDatabase = supportSQLiteOpenHelper2.getWritableDatabase()) == null) {
                        SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                        Intrinsics.checkNotNull(supportSQLiteDatabase2);
                        return supportSQLiteDatabase2;
                    }
                    return writableDatabase;
                }
            });
            this.statements = new AndroidSqliteDriver$statements$1(r4);
            this.listeners = new LinkedHashMap<>();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void addListener(String[] queryKeys, Query.Listener listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                LinkedHashMap<String, Set<Query.Listener>> linkedHashMap = this.listeners;
                Set<Query.Listener> set = linkedHashMap.get(str);
                if (set == null) {
                    set = new LinkedHashSet<>();
                    linkedHashMap.put(str, set);
                }
                set.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Unit unit;
        this.statements.evictAll();
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.openHelper;
        if (supportSQLiteOpenHelper != null) {
            supportSQLiteOpenHelper.close();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getDatabase().close();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final Transacter.Transaction currentTransaction() {
        return this.transactions.get();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult.Value execute(Integer num, final String sql, Function1 function1) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        return new QueryResult.Value(m614executezeHU3Mk(num, new Function0<AndroidStatement>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$execute$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AndroidStatement invoke() {
                return new AndroidPreparedStatement(AndroidSqliteDriver.this.getDatabase().compileStatement(sql));
            }
        }, function1, new Function1<AndroidStatement, Long>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$execute$2
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(AndroidStatement androidStatement) {
                AndroidStatement execute = androidStatement;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                return Long.valueOf(execute.execute());
            }
        }));
    }

    /* renamed from: execute-zeHU3Mk, reason: not valid java name */
    public final <T> Object m614executezeHU3Mk(Integer num, Function0<? extends AndroidStatement> function0, Function1<? super SqlPreparedStatement, Unit> function1, Function1<? super AndroidStatement, ? extends T> function12) {
        AndroidStatement androidStatement;
        AndroidSqliteDriver$statements$1 androidSqliteDriver$statements$1 = this.statements;
        if (num != null) {
            androidStatement = androidSqliteDriver$statements$1.remove(num);
        } else {
            androidStatement = null;
        }
        if (androidStatement == null) {
            androidStatement = function0.invoke();
        }
        if (function1 != null) {
            try {
                function1.invoke(androidStatement);
            } catch (Throwable th) {
                if (num != null) {
                    AndroidStatement put = androidSqliteDriver$statements$1.put(num, androidStatement);
                    if (put != null) {
                        put.close();
                    }
                } else {
                    androidStatement.close();
                }
                throw th;
            }
        }
        T invoke = function12.invoke(androidStatement);
        if (num != null) {
            AndroidStatement put2 = androidSqliteDriver$statements$1.put(num, androidStatement);
            if (put2 != null) {
                put2.close();
            }
        } else {
            androidStatement.close();
        }
        return invoke;
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult executeQuery(Integer num, final String sql, final Function1 mapper, final int r5, Function1 function1) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return new QueryResult.Value(m614executezeHU3Mk(num, new Function0<AndroidStatement>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$executeQuery$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AndroidStatement invoke() {
                AndroidSqliteDriver androidSqliteDriver = this;
                return new AndroidQuery(sql, androidSqliteDriver.getDatabase(), r5, androidSqliteDriver.windowSizeBytes);
            }
        }, function1, new Function1<AndroidStatement, Object>() { // from class: app.cash.sqldelight.driver.android.AndroidSqliteDriver$executeQuery$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(AndroidStatement androidStatement) {
                AndroidStatement execute = androidStatement;
                Intrinsics.checkNotNullParameter(execute, "$this$execute");
                return execute.executeQuery(mapper);
            }
        }));
    }

    public final SupportSQLiteDatabase getDatabase() {
        return (SupportSQLiteDatabase) this.database$delegate.getValue();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult.Value newTransaction() {
        ThreadLocal<Transacter.Transaction> threadLocal = this.transactions;
        Transacter.Transaction transaction = threadLocal.get();
        Transaction transaction2 = new Transaction(transaction);
        threadLocal.set(transaction2);
        if (transaction == null) {
            getDatabase().beginTransactionNonExclusive();
        }
        return new QueryResult.Value(transaction2);
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void notifyListeners(String... queryKeys) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                Set<Query.Listener> set = this.listeners.get(str);
                if (set != null) {
                    linkedHashSet.addAll(set);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((Query.Listener) it.next()).queryResultsChanged();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final void removeListener(String[] queryKeys, Query.Listener listener) {
        Intrinsics.checkNotNullParameter(queryKeys, "queryKeys");
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listeners) {
            for (String str : queryKeys) {
                Set<Query.Listener> set = this.listeners.get(str);
                if (set != null) {
                    set.remove(listener);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public /* synthetic */ AndroidSqliteDriver(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        this(null, frameworkSQLiteDatabase, 1, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidSqliteDriver(app.cash.sqldelight.db.SqlSchema r7, android.content.Context r8, java.lang.String r9) {
        /*
            r6 = this;
            app.cash.sqldelight.driver.android.AndroidSqliteDriver$Callback r3 = new app.cash.sqldelight.driver.android.AndroidSqliteDriver$Callback
            r0 = 0
            app.cash.sqldelight.db.AfterVersion[] r0 = new app.cash.sqldelight.db.AfterVersion[r0]
            r3.<init>(r7, r0)
            r4 = 0
            java.lang.String r0 = "schema"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r7 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            r5 = 0
            androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper r7 = new androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r8 = 0
            r9 = 20
            r6.<init>(r7, r8, r9, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.driver.android.AndroidSqliteDriver.<init>(app.cash.sqldelight.db.SqlSchema, android.content.Context, java.lang.String):void");
    }
}
