package com.j256.ormlite.stmt;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class SelectArg implements ArgumentHolder {
    public String columnName = null;
    public FieldType fieldType = null;
    public boolean hasBeenSet = false;
    public Object value = null;

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final FieldType getFieldType() {
        return this.fieldType;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final Object getSqlArgValue() {
        if (this.hasBeenSet) {
            Object obj = this.value;
            if (obj == null) {
                return null;
            }
            FieldType fieldType = this.fieldType;
            if (fieldType != null) {
                if (fieldType.fieldConfig.foreign && fieldType.field.getType() == obj.getClass()) {
                    return this.fieldType.foreignRefField.extractJavaFieldValue(obj);
                }
                return this.fieldType.convertJavaFieldToSqlArgValue(obj);
            }
            return obj;
        }
        throw new SQLException("Column value has not been set for " + this.columnName);
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final /* bridge */ /* synthetic */ SqlType getSqlType() {
        return null;
    }

    @Override // com.j256.ormlite.stmt.ArgumentHolder
    public final void setMetaInfo(FieldType fieldType, String str) {
        String str2 = this.columnName;
        if (str2 == null || str2.equals(str)) {
            this.columnName = str;
            FieldType fieldType2 = this.fieldType;
            if (fieldType2 == null || fieldType2 == fieldType) {
                this.fieldType = fieldType;
                return;
            }
            throw new IllegalArgumentException("FieldType name cannot be set twice from " + this.fieldType + " to " + fieldType + ".  Using a SelectArg twice in query with different columns?");
        }
        throw new IllegalArgumentException("Column name cannot be set twice from " + this.columnName + " to " + str + ".  Using a SelectArg twice in query with different columns?");
    }

    /* renamed from: toString$com$j256$ormlite$stmt$BaseArgumentHolder, reason: merged with bridge method [inline-methods] */
    public final String toString() {
        if (!this.hasBeenSet) {
            return "[unset]";
        }
        try {
            Object sqlArgValue = getSqlArgValue();
            if (sqlArgValue == null) {
                return "[null]";
            }
            return sqlArgValue.toString();
        } catch (SQLException e) {
            return "[could not get value: " + e + "]";
        }
    }
}
