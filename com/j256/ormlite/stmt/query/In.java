package com.j256.ormlite.stmt.query;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import java.sql.SQLException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class In extends BaseComparison {
    public final boolean in;
    public final Iterable<?> objects;

    public In(String str, FieldType fieldType, ArrayList arrayList) throws SQLException {
        super(str, fieldType, null, true);
        this.objects = arrayList;
        this.in = true;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public final void appendOperation(StringBuilder sb) {
        if (this.in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public final void appendValue(DatabaseType databaseType, StringBuilder sb, ArrayList arrayList) throws SQLException {
        sb.append('(');
        boolean z = true;
        for (Object obj : this.objects) {
            if (obj != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                appendArgOrValue(databaseType, this.fieldType, sb, arrayList, obj);
                int length = sb.length();
                if (length > 0) {
                    int r2 = length - 1;
                    if (sb.charAt(r2) == ' ') {
                        sb.setLength(r2);
                    }
                }
            } else {
                throw new IllegalArgumentException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("one of the IN values for '"), this.columnName, "' is null"));
            }
        }
        sb.append(") ");
    }
}
