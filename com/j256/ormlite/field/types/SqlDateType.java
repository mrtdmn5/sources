package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: classes3.dex */
public final class SqlDateType extends DateType {
    public static final SqlDateType singleTon = new SqlDateType();
    public static final DateStringFormatConfig sqlDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd");

    public SqlDateType() {
        super(SqlType.DATE, new Class[]{Date.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDateType
    public final DateStringFormatConfig getDefaultDateFormatConfig() {
        return sqlDateFormatConfig;
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        if (field.getType() == Date.class) {
            return true;
        }
        return false;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Timestamp(((Date) obj).getTime());
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
        return new Date(((Timestamp) obj).getTime());
    }
}
