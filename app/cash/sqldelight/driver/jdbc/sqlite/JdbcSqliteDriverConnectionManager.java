package app.cash.sqldelight.driver.jdbc.sqlite;

import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcSqliteDriver.kt */
/* loaded from: classes.dex */
public abstract class JdbcSqliteDriverConnectionManager implements ConnectionManager {
    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void endTransaction(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "<this>");
        PreparedStatement prepareStatement = connection.prepareStatement("END TRANSACTION");
        try {
            prepareStatement.execute();
            AutoCloseableKt.closeFinally(prepareStatement, null);
        } finally {
        }
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void rollbackTransaction(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "<this>");
        PreparedStatement prepareStatement = connection.prepareStatement("ROLLBACK TRANSACTION");
        try {
            prepareStatement.execute();
            AutoCloseableKt.closeFinally(prepareStatement, null);
        } finally {
        }
    }
}
