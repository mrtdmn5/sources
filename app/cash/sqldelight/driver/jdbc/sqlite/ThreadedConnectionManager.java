package app.cash.sqldelight.driver.jdbc.sqlite;

import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcSqliteDriver.kt */
/* loaded from: classes.dex */
public final class ThreadedConnectionManager extends JdbcSqliteDriverConnectionManager {
    public final Properties properties;
    public final String url = "jdbc:sqlite:";
    public final ThreadLocal<ConnectionManager.Transaction> transactions = new ThreadLocal<>();
    public final ThreadLocal<Connection> connections = new ThreadLocal<>();

    public ThreadedConnectionManager(Properties properties) {
        this.properties = properties;
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void closeConnection(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        ThreadLocal<Connection> threadLocal = this.connections;
        if (Intrinsics.areEqual(threadLocal.get(), connection)) {
            if (getTransaction() == null) {
                connection.close();
                threadLocal.remove();
                return;
            }
            return;
        }
        throw new IllegalStateException("Connections must be closed on the thread that opened them".toString());
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final Connection getConnection() {
        ThreadLocal<Connection> threadLocal = this.connections;
        Connection connection = threadLocal.get();
        if (connection == null) {
            connection = DriverManager.getConnection(this.url, this.properties);
            Intrinsics.checkNotNullExpressionValue(connection, "getConnection(...)");
            threadLocal.set(connection);
        }
        return connection;
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final ConnectionManager.Transaction getTransaction() {
        return this.transactions.get();
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public final void setTransaction(ConnectionManager.Transaction transaction) {
        this.transactions.set(transaction);
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager, java.lang.AutoCloseable
    public final void close() {
    }
}
