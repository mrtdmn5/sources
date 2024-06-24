package app.cash.sqldelight;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import app.cash.sqldelight.db.SqlDriver;
import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Query.kt */
/* loaded from: classes.dex */
public final class SimpleQuery<RowType> extends Query<RowType> {
    public final SqlDriver driver;
    public final String fileName;
    public final int identifier;
    public final String label;
    public final String query;
    public final String[] queryKeys;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleQuery(int r2, String[] strArr, SqlDriver driver, String str, String str2, String str3, Function1<? super SqlCursor, ? extends RowType> mapper) {
        super(mapper);
        Intrinsics.checkNotNullParameter(driver, "driver");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.identifier = r2;
        this.queryKeys = strArr;
        this.driver = driver;
        this.fileName = str;
        this.label = str2;
        this.query = str3;
    }

    @Override // app.cash.sqldelight.Query
    public final void addListener(Query.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String[] strArr = this.queryKeys;
        this.driver.addListener((String[]) Arrays.copyOf(strArr, strArr.length), listener);
    }

    @Override // app.cash.sqldelight.ExecutableQuery
    public final <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        return this.driver.executeQuery(Integer.valueOf(this.identifier), this.query, mapper, 0, null);
    }

    @Override // app.cash.sqldelight.Query
    public final void removeListener(Query.Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String[] strArr = this.queryKeys;
        this.driver.removeListener((String[]) Arrays.copyOf(strArr, strArr.length), listener);
    }

    public final String toString() {
        return this.fileName + ':' + this.label;
    }
}
