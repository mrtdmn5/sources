package com.j256.ormlite.stmt.query;

import com.j256.ormlite.stmt.ArgumentHolder;

/* loaded from: classes3.dex */
public final class OrderBy {
    public final boolean ascending;
    public final String columnName;
    public final String rawSql = null;
    public final ArgumentHolder[] orderByArgs = null;
    public final boolean nullsFirst = false;
    public final boolean nullsLast = false;

    public OrderBy(String str, boolean z) {
        this.columnName = str;
        this.ascending = z;
    }
}
