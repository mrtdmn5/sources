package com.j256.ormlite.stmt.query;

/* loaded from: classes3.dex */
public final class ColumnNameOrRawSql {
    public final String columnName = null;
    public final String rawSql;

    public ColumnNameOrRawSql(String str) {
        this.rawSql = str;
    }

    public final String toString() {
        String str = this.rawSql;
        if (str == null) {
            return this.columnName;
        }
        return str;
    }
}
