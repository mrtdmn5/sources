package app.cash.sqldelight.driver.jdbc;

import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import app.cash.sqldelight.db.SqlPreparedStatement;
import app.cash.sqldelight.driver.jdbc.ConnectionManager;
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JdbcDriver.kt */
/* loaded from: classes.dex */
public abstract class JdbcDriver implements SqlDriver, ConnectionManager {
    public JdbcDriver() {
        new ThreadLocal();
    }

    public final Pair<Connection, Function0<Unit>> connectionAndClose() {
        ConnectionManager.Transaction transaction = getTransaction();
        if (transaction != null) {
            return new Pair<>(transaction.connection, new Function0<Unit>() { // from class: app.cash.sqldelight.driver.jdbc.JdbcDriver$connectionAndClose$1
                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
        final Connection connection = ((JdbcSqliteDriver) this).getConnection();
        return new Pair<>(connection, new Function0<Unit>() { // from class: app.cash.sqldelight.driver.jdbc.JdbcDriver$connectionAndClose$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ((JdbcSqliteDriver) JdbcDriver.this).closeConnection(connection);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final Transacter.Transaction currentTransaction() {
        return getTransaction();
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult.Value execute(Integer num, String sql, Function1 function1) {
        long updateCount;
        Intrinsics.checkNotNullParameter(sql, "sql");
        Pair<Connection, Function0<Unit>> connectionAndClose = connectionAndClose();
        Connection connection = connectionAndClose.first;
        Function0<Unit> function0 = connectionAndClose.second;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            try {
                Intrinsics.checkNotNull(prepareStatement);
                JdbcPreparedStatement jdbcPreparedStatement = new JdbcPreparedStatement(prepareStatement);
                if (function1 != null) {
                    function1.invoke(jdbcPreparedStatement);
                }
                if (prepareStatement.execute()) {
                    updateCount = 0;
                } else {
                    updateCount = prepareStatement.getUpdateCount();
                }
                Long valueOf = Long.valueOf(updateCount);
                AutoCloseableKt.closeFinally(prepareStatement, null);
                return new QueryResult.Value(valueOf);
            } finally {
            }
        } finally {
            function0.invoke();
        }
    }

    @Override // app.cash.sqldelight.db.SqlDriver
    public final <R> QueryResult<R> executeQuery(Integer num, String sql, Function1<? super SqlCursor, ? extends QueryResult<R>> mapper, int r5, Function1<? super SqlPreparedStatement, Unit> function1) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Pair<Connection, Function0<Unit>> connectionAndClose = connectionAndClose();
        Connection connection = connectionAndClose.first;
        Function0<Unit> function0 = connectionAndClose.second;
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            Intrinsics.checkNotNullExpressionValue(prepareStatement, "prepareStatement(...)");
            JdbcPreparedStatement jdbcPreparedStatement = new JdbcPreparedStatement(prepareStatement);
            if (function1 != null) {
                function1.invoke(jdbcPreparedStatement);
            }
            return (QueryResult) jdbcPreparedStatement.executeQuery(mapper);
        } finally {
            function0.invoke();
        }
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public abstract ConnectionManager.Transaction getTransaction();

    @Override // app.cash.sqldelight.db.SqlDriver
    public final QueryResult.Value newTransaction() {
        Connection connection;
        ConnectionManager.Transaction transaction = getTransaction();
        if (transaction == null || (connection = transaction.connection) == null) {
            connection = ((JdbcSqliteDriver) this).getConnection();
        }
        ConnectionManager.Transaction transaction2 = new ConnectionManager.Transaction(transaction, this, connection);
        setTransaction(transaction2);
        if (transaction == null) {
            ((JdbcSqliteDriver) this).$$delegate_0.getClass();
            PreparedStatement prepareStatement = connection.prepareStatement("BEGIN TRANSACTION");
            try {
                prepareStatement.execute();
                AutoCloseableKt.closeFinally(prepareStatement, null);
            } finally {
            }
        }
        return new QueryResult.Value(transaction2);
    }

    @Override // app.cash.sqldelight.driver.jdbc.ConnectionManager
    public abstract void setTransaction(ConnectionManager.Transaction transaction);
}
