package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class SimpleComparison extends BaseComparison {
    public final String operation;

    public SimpleComparison(String str, FieldType fieldType, Object obj, String str2) throws SQLException {
        super(str, fieldType, obj, true);
        this.operation = str2;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public final void appendOperation(StringBuilder sb) {
        sb.append(this.operation);
        sb.append(' ');
    }
}
