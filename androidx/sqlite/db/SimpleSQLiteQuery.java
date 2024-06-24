package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleSQLiteQuery.kt */
/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public final String query;

    public SimpleSQLiteQuery(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.query = query;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final String getSql() {
        return this.query;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public final void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram) {
    }
}
