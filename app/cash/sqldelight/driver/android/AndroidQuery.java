package app.cash.sqldelight.driver.android;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class AndroidQuery implements SupportSQLiteQuery, AndroidStatement {
    public final ArrayList binds;
    public final SupportSQLiteDatabase database;
    public final String sql;
    public final Long windowSizeBytes;

    public AndroidQuery(String sql, SupportSQLiteDatabase database, int r4, Long l) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(database, "database");
        this.sql = sql;
        this.database = database;
        this.windowSizeBytes = l;
        ArrayList arrayList = new ArrayList(r4);
        for (int r3 = 0; r3 < r4; r3++) {
            arrayList.add(null);
        }
        this.binds = arrayList;
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindBoolean(final int r3, final Boolean bool) {
        this.binds.set(r3, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindBoolean$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                long j;
                SupportSQLiteProgram it = supportSQLiteProgram;
                Intrinsics.checkNotNullParameter(it, "it");
                int r0 = r3;
                Boolean bool2 = bool;
                if (bool2 == null) {
                    it.bindNull(r0 + 1);
                } else {
                    int r02 = r0 + 1;
                    if (bool2.booleanValue()) {
                        j = 1;
                    } else {
                        j = 0;
                    }
                    it.bindLong(r02, j);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindDouble(final int r3, final Double d) {
        this.binds.set(r3, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindDouble$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                SupportSQLiteProgram it = supportSQLiteProgram;
                Intrinsics.checkNotNullParameter(it, "it");
                int r0 = r3 + 1;
                Double d2 = d;
                if (d2 == null) {
                    it.bindNull(r0);
                } else {
                    it.bindDouble(r0, d2.doubleValue());
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindLong(final int r3, final Long l) {
        this.binds.set(r3, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindLong$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                SupportSQLiteProgram it = supportSQLiteProgram;
                Intrinsics.checkNotNullParameter(it, "it");
                int r0 = r3 + 1;
                Long l2 = l;
                if (l2 == null) {
                    it.bindNull(r0);
                } else {
                    it.bindLong(r0, l2.longValue());
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindString(final int r3, final String str) {
        this.binds.set(r3, new Function1<SupportSQLiteProgram, Unit>() { // from class: app.cash.sqldelight.driver.android.AndroidQuery$bindString$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                SupportSQLiteProgram it = supportSQLiteProgram;
                Intrinsics.checkNotNullParameter(it, "it");
                int r0 = r3 + 1;
                String str2 = str;
                if (str2 == null) {
                    it.bindNull(r0);
                } else {
                    it.bindString(r0, str2);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram) {
        Iterator it = this.binds.iterator();
        while (it.hasNext()) {
            Function1 function1 = (Function1) it.next();
            Intrinsics.checkNotNull(function1);
            function1.invoke(frameworkSQLiteProgram);
        }
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final long execute() {
        throw new UnsupportedOperationException();
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final <R> R executeQuery(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Cursor query = this.database.query(this);
        try {
            R value = mapper.invoke(new AndroidCursor(query, this.windowSizeBytes)).getValue();
            CloseableKt.closeFinally(query, null);
            return value;
        } finally {
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        return this.sql;
    }

    public final String toString() {
        return this.sql;
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final void close() {
    }
}
