package app.cash.sqldelight.driver.jdbc.sqlite;

import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcSqliteDriver.kt */
/* loaded from: classes.dex */
public final class StaticConnectionManager extends JdbcSqliteDriverConnectionManager {
    public final Connection connection;
    public ConnectionManager.Transaction transaction;

    public StaticConnectionManager(Properties properties) {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:", properties);
        Intrinsics.checkNotNullExpressionValue(connection, "getConnection(...)");
        this.connection = connection;
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager, java.lang.AutoCloseable
    public final void close() {
        this.connection.close();
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void closeConnection(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final Connection getConnection() {
        return this.connection;
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final ConnectionManager.Transaction getTransaction() {
        return this.transaction;
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void setTransaction(ConnectionManager.Transaction transaction) {
        this.transaction = transaction;
    }
}
