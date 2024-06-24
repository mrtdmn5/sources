package app.cash.sqldelight.driver.jdbc;

import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlPreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public final class JdbcPreparedStatement implements SqlPreparedStatement {
    public final PreparedStatement preparedStatement;

    public JdbcPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindBoolean(int r2, Boolean bool) {
        PreparedStatement preparedStatement = this.preparedStatement;
        if (bool == null) {
            preparedStatement.setNull(r2 + 1, 16);
        } else {
            preparedStatement.setBoolean(r2 + 1, bool.booleanValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindDouble(int r4, Double d) {
        PreparedStatement preparedStatement = this.preparedStatement;
        if (d == null) {
            preparedStatement.setNull(r4 + 1, 8);
        } else {
            preparedStatement.setDouble(r4 + 1, d.doubleValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindLong(int r4, Long l) {
        PreparedStatement preparedStatement = this.preparedStatement;
        if (l == null) {
            preparedStatement.setNull(r4 + 1, -5);
        } else {
            preparedStatement.setLong(r4 + 1, l.longValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlPreparedStatement
    public final void bindString(int r2, String str) {
        PreparedStatement preparedStatement = this.preparedStatement;
        if (str == null) {
            preparedStatement.setNull(r2 + 1, 12);
        } else {
            preparedStatement.setString(r2 + 1, str);
        }
    }

    public final <R> R executeQuery(Function1<? super SqlCursor, ? extends R> mapper) {
        PreparedStatement preparedStatement = this.preparedStatement;
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        try {
            ResultSet executeQuery = preparedStatement.executeQuery();
            try {
                Intrinsics.checkNotNull(executeQuery);
                R invoke = mapper.invoke(new JdbcCursor(executeQuery));
                AutoCloseableKt.closeFinally(executeQuery, null);
                return invoke;
            } finally {
            }
        } finally {
            preparedStatement.close();
        }
    }
}
