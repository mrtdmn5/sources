package app.cash.sqldelight;

import app.cash.sqldelight.db.SqlCursor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Query.kt */
/* loaded from: classes.dex */
public abstract class Query<RowType> extends ExecutableQuery<RowType> {

    /* compiled from: Query.kt */
    /* loaded from: classes.dex */
    public interface Listener {
        void queryResultsChanged();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Query(Function1<? super SqlCursor, ? extends RowType> mapper) {
        super(mapper);
        Intrinsics.checkNotNullParameter(mapper, "mapper");
    }

    public abstract void addListener(Listener listener);

    public abstract void removeListener(Listener listener);
}
