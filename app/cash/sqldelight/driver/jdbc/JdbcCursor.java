package app.cash.sqldelight.driver.jdbc;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.sql.ResultSet;
import kotlin.jvm.functions.Function1;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public final class JdbcCursor implements SqlCursor {
    public final ResultSet resultSet;

    public JdbcCursor(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public final <T> T getAtIndex(int r1, Function1<? super Integer, ? extends T> function1) {
        T invoke = function1.invoke(Integer.valueOf(r1 + 1));
        if (this.resultSet.wasNull()) {
            return null;
        }
        return invoke;
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Boolean getBoolean(int r3) {
        return (Boolean) getAtIndex(r3, new JdbcCursor$getBoolean$1(this.resultSet));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Double getDouble(int r3) {
        return (Double) getAtIndex(r3, new JdbcCursor$getDouble$1(this.resultSet));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Long getLong(int r3) {
        return (Long) getAtIndex(r3, new JdbcCursor$getLong$1(this.resultSet));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final String getString(int r2) {
        return this.resultSet.getString(r2 + 1);
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final QueryResult.Value next() {
        return new QueryResult.Value(Boolean.valueOf(this.resultSet.next()));
    }
}
