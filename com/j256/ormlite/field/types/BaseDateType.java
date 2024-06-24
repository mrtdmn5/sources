package com.j256.ormlite.field.types;

import java.lang.reflect.Field;
import java.util.Date;

/* loaded from: classes3.dex */
public abstract class BaseDateType extends BaseDataType {
    public static final DateStringFormatConfig DEFAULT_DATE_FORMAT_CONFIG = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");
    public static final DateStringFormatConfig NO_MILLIS_DATE_FORMAT_CONFIG = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss");

    public DateStringFormatConfig getDefaultDateFormatConfig() {
        return DEFAULT_DATE_FORMAT_CONFIG;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        if (field.getType() == Date.class) {
            return true;
        }
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForVersion() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (obj == null) {
            return new Date(currentTimeMillis);
        }
        if (currentTimeMillis == ((Date) obj).getTime()) {
            return new Date(currentTimeMillis + 1);
        }
        return new Date(currentTimeMillis);
    }
}
