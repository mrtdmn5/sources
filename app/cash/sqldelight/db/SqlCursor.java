package app.cash.sqldelight.db;

import app.cash.sqldelight.db.QueryResult;

/* compiled from: SqlCursor.kt */
/* loaded from: classes.dex */
public interface SqlCursor {
    Boolean getBoolean(int r1);

    Double getDouble(int r1);

    Long getLong(int r1);

    String getString(int r1);

    QueryResult.Value next();
}
