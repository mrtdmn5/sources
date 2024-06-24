package com.google.gson.internal.sql;

import com.google.gson.internal.sql.SqlDateTypeAdapter;
import com.google.gson.internal.sql.SqlTimeTypeAdapter;
import com.google.gson.internal.sql.SqlTimestampTypeAdapter;

/* loaded from: classes3.dex */
public final class SqlTypesSupport {
    public static final SqlDateTypeAdapter.AnonymousClass1 DATE_FACTORY;
    public static final boolean SUPPORTS_SQL_TYPES;
    public static final SqlTimestampTypeAdapter.AnonymousClass1 TIMESTAMP_FACTORY;
    public static final SqlTimeTypeAdapter.AnonymousClass1 TIME_FACTORY;

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        SUPPORTS_SQL_TYPES = z;
        if (z) {
            DATE_FACTORY = SqlDateTypeAdapter.FACTORY;
            TIME_FACTORY = SqlTimeTypeAdapter.FACTORY;
            TIMESTAMP_FACTORY = SqlTimestampTypeAdapter.FACTORY;
        } else {
            DATE_FACTORY = null;
            TIME_FACTORY = null;
            TIMESTAMP_FACTORY = null;
        }
    }
}
