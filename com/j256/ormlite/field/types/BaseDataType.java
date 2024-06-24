package com.j256.ormlite.field.types;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public abstract class BaseDataType extends BaseFieldConverter implements DataPersister {
    public static final Class<?>[] NO_CLASSES = new Class[0];
    public final Class<?>[] classes;
    public final SqlType sqlType;

    public BaseDataType(SqlType sqlType, Class<?>[] clsArr) {
        this.sqlType = sqlType;
        this.classes = clsArr;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object convertIdNumber(Number number) {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object generateId() {
        throw new IllegalStateException("Should not have tried to generate this type");
    }

    @Override // com.j256.ormlite.field.DataPersister
    public String[] getAssociatedClassNames() {
        return null;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public final Class<?>[] getAssociatedClasses() {
        return this.classes;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public int getDefaultWidth() {
        return 0;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return null;
        }
        return clsArr[0];
    }

    @Override // com.j256.ormlite.field.FieldConverter
    public final SqlType getSqlType() {
        return this.sqlType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return !(this instanceof BigDecimalNumericType);
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return this instanceof ByteArrayType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return !(this instanceof SerializableType);
    }

    @Override // com.j256.ormlite.field.DataPersister
    public final boolean isEscapedDefaultValue() {
        return isEscapedValue();
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isEscapedValue() {
        return !(this instanceof BigDecimalNumericType);
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return this instanceof ByteType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isSelfGeneratedId() {
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        Class<?>[] clsArr = this.classes;
        if (clsArr.length == 0) {
            return true;
        }
        for (Class<?> cls : clsArr) {
            if (cls.isAssignableFrom(field.getType())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidForVersion() {
        return this instanceof BigIntegerType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public boolean isValidGeneratedType() {
        return this instanceof BigIntegerType;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public Object moveToNextValue(Object obj) throws SQLException {
        return null;
    }

    public BaseDataType(SqlType sqlType) {
        this.sqlType = sqlType;
        this.classes = NO_CLASSES;
    }

    @Override // com.j256.ormlite.field.DataPersister
    public final void getSqlOtherType() {
    }
}
