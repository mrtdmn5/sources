package com.j256.ormlite.field;

import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface DataPersister extends FieldConverter {
    Object convertIdNumber(Number number);

    Object generateId();

    String[] getAssociatedClassNames();

    Class<?>[] getAssociatedClasses();

    int getDefaultWidth();

    Class<?> getPrimaryClass();

    void getSqlOtherType();

    boolean isAppropriateId();

    boolean isArgumentHolderRequired();

    boolean isComparable();

    boolean isEscapedDefaultValue();

    boolean isEscapedValue();

    boolean isPrimitive();

    boolean isSelfGeneratedId();

    boolean isValidForField(Field field);

    boolean isValidForVersion();

    boolean isValidGeneratedType();

    Object moveToNextValue(Object obj) throws SQLException;
}
