package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.Timestamp;

/* loaded from: classes3.dex */
public final class TimeStampType extends DateType {
    public static final TimeStampType singleTon = new TimeStampType();

    public TimeStampType() {
        super(SqlType.DATE, new Class[]{Timestamp.class});
    }

    @Override // com.j256.ormlite.field.types.BaseDateType, com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        if (field.getType() == Timestamp.class) {
            return true;
        }
        return false;
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

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public final Object javaToSqlArg(FieldType fieldType, Object obj) {
        return obj;
    }

    @Override // com.j256.ormlite.field.types.DateType, com.j256.ormlite.field.BaseFieldConverter
    public final Object sqlArgToJava(FieldType fieldType, Object obj, int r3) {
        return obj;
    }
}
