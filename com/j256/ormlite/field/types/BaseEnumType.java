package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public abstract class BaseEnumType extends BaseDataType {
    public static Enum<?> enumVal(FieldType fieldType, Object obj, Enum<?> r3, Enum<?> r4) throws SQLException {
        if (r3 != null) {
            return r3;
        }
        if (r4 != null) {
            return r4;
        }
        throw new SQLException("Cannot get enum value of '" + obj + "' for field " + fieldType);
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public final boolean isValidForField(Field field) {
        return field.getType().isEnum();
    }
}
