package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class SetValue extends BaseComparison {
    public static final NullArgHolder nullValue = new NullArgHolder();

    public SetValue(String str, FieldType fieldType, Integer num) throws SQLException {
        super(str, fieldType, num == null ? nullValue : num, false);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public final void appendOperation(StringBuilder sb) {
        sb.append("= ");
    }
}
