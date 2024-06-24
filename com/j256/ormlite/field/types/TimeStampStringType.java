package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: classes3.dex */
public final class TimeStampStringType extends DateStringType {
    public static final TimeStampStringType singleTon = new TimeStampStringType();

    public TimeStampStringType() {
        super(SqlType.STRING);
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        if (field.getType() == Timestamp.class) {
            return true;
        }
        return false;
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return super.javaToSqlArg(fieldType, new Date(((Timestamp) obj).getTime()));
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Timestamp(currentTimeMillis);
        }
        if (currentTimeMillis == ((Timestamp) obj).getTime()) {
            return new Timestamp(currentTimeMillis + 1);
        }
        return new Timestamp(currentTimeMillis);
    }

    @Override // com.j256.ormlite.field.types.DateStringType, com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r5) throws SQLException {
        return new Timestamp(((Date) super.sqlArgToJava(fieldType, obj, r5)).getTime());
    }
}
