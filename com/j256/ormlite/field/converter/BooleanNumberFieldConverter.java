package com.j256.ormlite.field.converter;

import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class BooleanNumberFieldConverter extends BaseFieldConverter {
    @Override // com.j256.ormlite.field.FieldConverter
    public final SqlType getSqlType() {
        return SqlType.BYTE;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object parseDefaultString(FieldType fieldType, String str) {
        return Byte.valueOf(Boolean.parseBoolean(str) ? (byte) 1 : (byte) 0);
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final Object resultToSqlArg(AndroidDatabaseResults androidDatabaseResults, int r2) throws SQLException {
        return Byte.valueOf((byte) androidDatabaseResults.cursor.getShort(r2));
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
        if (((Byte) obj).byteValue() == 1) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
