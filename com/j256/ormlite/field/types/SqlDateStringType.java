package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class SqlDateStringType extends DateStringType {
    public static final SqlDateStringType singleTon = new SqlDateStringType();

    public SqlDateStringType() {
        super(SqlType.STRING);
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        if (field.getType() == Date.class) {
            return true;
        }
        return false;
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return super.javaToSqlArg(fieldType, new java.util.Date(((Date) obj).getTime()));
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
        return new Date(((java.util.Date) super.sqlArgToJava(fieldType, obj, r5)).getTime());
    }
}
