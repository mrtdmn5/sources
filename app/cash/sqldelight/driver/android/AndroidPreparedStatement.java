package app.cash.sqldelight.driver.android;

import androidx.sqlite.db.SupportSQLiteStatement;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class AndroidPreparedStatement implements AndroidStatement {
    public final SupportSQLiteStatement statement;

    public AndroidPreparedStatement(SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        this.statement = statement;
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindBoolean(int r4, Boolean bool) {
        long j;
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        if (bool == null) {
            supportSQLiteStatement.bindNull(r4 + 1);
            return;
        }
        int r42 = r4 + 1;
        if (bool.booleanValue()) {
            j = 1;
        } else {
            j = 0;
        }
        supportSQLiteStatement.bindLong(r42, j);
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindDouble(int r4, Double d) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        int r42 = r4 + 1;
        if (d == null) {
            supportSQLiteStatement.bindNull(r42);
        } else {
            supportSQLiteStatement.bindDouble(r42, d.doubleValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindLong(int r4, Long l) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        int r42 = r4 + 1;
        if (l == null) {
            supportSQLiteStatement.bindNull(r42);
        } else {
            supportSQLiteStatement.bindLong(r42, l.longValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindString(int r2, String str) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        int r22 = r2 + 1;
        if (str == null) {
            supportSQLiteStatement.bindNull(r22);
        } else {
            supportSQLiteStatement.bindString(r22, str);
        }
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final void close() {
        this.statement.close();
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final long execute() {
        return this.statement.executeUpdateDelete();
    }

    @Override // app.cash.sqldelight.driver.android.AndroidStatement
    public final <R> R executeQuery(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        throw new UnsupportedOperationException();
    }
}
