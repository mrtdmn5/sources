package app.cash.sqldelight.driver.jdbc;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import java.sql.Connection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public interface ConnectionManager {

    /* compiled from: JdbcDriver.kt */
    /* loaded from: classes.dex */
    public static final class Transaction extends Transacter.Transaction {
        public final Connection connection;
        public final ConnectionManager connectionManager;
        public final Transaction enclosingTransaction;

        public Transaction(Transaction transaction, ConnectionManager connectionManager, Connection connection) {
            Intrinsics.checkNotNullParameter(connectionManager, "connectionManager");
            Intrinsics.checkNotNullParameter(connection, "connection");
            this.enclosingTransaction = transaction;
            this.connectionManager = connectionManager;
            this.connection = connection;
        }

        @Override // app.cash.sqldelight.Transacter.Transaction
        public final QueryResult.Value endTransaction(boolean z) {
            Transaction transaction = this.enclosingTransaction;
            ConnectionManager connectionManager = this.connectionManager;
            if (transaction == null) {
                Connection connection = this.connection;
                if (z) {
                    connectionManager.endTransaction(connection);
                } else {
                    connectionManager.rollbackTransaction(connection);
                }
            }
            connectionManager.setTransaction(transaction);
            QueryResult.Companion.getClass();
            return new QueryResult.Value(QueryResult.Companion.Unit);
        }

        @Override // app.cash.sqldelight.Transacter.Transaction
        public final Transacter.Transaction getEnclosingTransaction() {
            return this.enclosingTransaction;
        }
    }

    void close();

    void closeConnection(Connection connection);

    void endTransaction(Connection connection);

    Connection getConnection();

    Transaction getTransaction();

    void rollbackTransaction(Connection connection);

    void setTransaction(Transaction transaction);
}
