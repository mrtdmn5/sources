package androidx.sqlite.db;

import androidx.sqlite.db.framework.FrameworkSQLiteProgram;

/* compiled from: SupportSQLiteQuery.kt */
/* loaded from: classes.dex */
public interface SupportSQLiteQuery {
    void bindTo(FrameworkSQLiteProgram frameworkSQLiteProgram);

    String getSql();
}
