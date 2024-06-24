package app.cash.sqldelight;

import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Query.kt */
/* loaded from: classes.dex */
public abstract class ExecutableQuery<RowType> {
    private final Function1<SqlCursor, RowType> mapper;

    /* JADX WARN: Multi-variable type inference failed */
    public ExecutableQuery(Function1<? super SqlCursor, ? extends RowType> mapper) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.mapper = mapper;
    }

    public abstract <R> QueryResult<R> execute(Function1<? super SqlCursor, ? extends QueryResult<R>> function1);

    public final List<RowType> executeAsList() {
        return (List) execute(new Function1<SqlCursor, QueryResult<List<RowType>>>(this) { // from class: app.cash.sqldelight.ExecutableQuery$executeAsList$1
            public final /* synthetic */ ExecutableQuery<RowType> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(SqlCursor sqlCursor) {
                SqlCursor cursor = sqlCursor;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                ArrayList arrayList = new ArrayList();
                while (((Boolean) cursor.next().value).booleanValue()) {
                    arrayList.add(this.this$0.getMapper().invoke(cursor));
                }
                return new QueryResult.Value(arrayList);
            }
        }).getValue();
    }

    public final RowType executeAsOne() {
        RowType executeAsOneOrNull = executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            return executeAsOneOrNull;
        }
        throw new NullPointerException("ResultSet returned null for " + this);
    }

    public final RowType executeAsOneOrNull() {
        return (RowType) execute(new Function1<SqlCursor, QueryResult<RowType>>(this) { // from class: app.cash.sqldelight.ExecutableQuery$executeAsOneOrNull$1
            public final /* synthetic */ ExecutableQuery<RowType> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(SqlCursor sqlCursor) {
                SqlCursor cursor = sqlCursor;
                Intrinsics.checkNotNullParameter(cursor, "cursor");
                if (!((Boolean) cursor.next().value).booleanValue()) {
                    return new QueryResult.Value(null);
                }
                ExecutableQuery<RowType> executableQuery = this.this$0;
                RowType invoke = executableQuery.getMapper().invoke(cursor);
                if (!((Boolean) cursor.next().value).booleanValue()) {
                    return new QueryResult.Value(invoke);
                }
                throw new IllegalStateException(("ResultSet returned more than 1 row for " + executableQuery).toString());
            }
        }).getValue();
    }

    public final Function1<SqlCursor, RowType> getMapper() {
        return this.mapper;
    }
}
