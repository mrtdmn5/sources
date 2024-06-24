package app.cash.sqldelight.db;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.Transacter;
import app.cash.sqldelight.db.QueryResult;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SqlDriver.kt */
/* loaded from: classes.dex */
public interface SqlDriver extends Closeable {
    void addListener(String[] strArr, Query.Listener listener);

    Transacter.Transaction currentTransaction();

    QueryResult.Value execute(Integer num, String str, Function1 function1);

    <R> QueryResult<R> executeQuery(Integer num, String str, Function1<? super SqlCursor, ? extends QueryResult<R>> function1, int r4, Function1<? super SqlPreparedStatement, Unit> function12);

    QueryResult.Value newTransaction();

    void notifyListeners(String... strArr);

    void removeListener(String[] strArr, Query.Listener listener);
}
