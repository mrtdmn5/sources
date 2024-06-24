package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import java.sql.SQLException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public interface Clause {
    void appendSql(DatabaseType databaseType, String str, StringBuilder sb, ArrayList arrayList) throws SQLException;
}
