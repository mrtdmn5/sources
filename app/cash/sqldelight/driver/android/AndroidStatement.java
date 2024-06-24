package app.cash.sqldelight.driver.android;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlPreparedStatement;
import kotlin.jvm.functions.Function1;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public interface AndroidStatement extends SqlPreparedStatement {
    void close();

    long execute();

    <R> R executeQuery(Function1<? super SqlCursor, ? extends QueryResult<R>> function1);
}
