package com.j256.ormlite.field;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.types.VoidType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.misc.JavaxPersistenceImpl;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class DatabaseFieldConfig {
    public static final DataType DEFAULT_DATA_TYPE = DataType.UNKNOWN;
    public static final JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    public boolean allowGeneratedIdInsert;
    public String columnDefinition;
    public String columnName;
    public DataPersister dataPersister;
    public String defaultValue;
    public String fieldName;
    public boolean foreign;
    public boolean foreignAutoCreate;
    public boolean foreignAutoRefresh;
    public boolean foreignCollection;
    public boolean foreignCollectionEager;
    public String foreignCollectionForeignFieldName;
    public String foreignCollectionOrderColumnName;
    public String foreignColumnName;
    public String format;
    public String fullColumnDefinition;
    public boolean generatedId;
    public String generatedIdSequence;
    public boolean id;
    public boolean index;
    public String indexName;
    public boolean javaxEntity;
    public boolean readOnly;
    public boolean throwIfNull;
    public boolean unique;
    public boolean uniqueCombo;
    public boolean uniqueIndex;
    public String uniqueIndexName;
    public Enum<?> unknownEnumValue;
    public boolean useGetSet;
    public boolean version;
    public int width;
    public DataType dataType = DEFAULT_DATA_TYPE;
    public boolean canBeNull = true;
    public boolean persisted = true;
    public int maxForeignAutoRefreshLevel = -1;
    public Class<? extends DataPersister> persisterClass = VoidType.class;
    public int foreignCollectionMaxEagerLevel = 1;
    public boolean foreignCollectionOrderAscending = true;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) JavaxPersistenceImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public static Method findGetMethod(Field field, SqliteAndroidDatabaseType sqliteAndroidDatabaseType, boolean z) throws IllegalArgumentException {
        Method findMethodFromNames = findMethodFromNames(field, true, z, methodFromField(field, "get", sqliteAndroidDatabaseType, true), methodFromField(field, "get", sqliteAndroidDatabaseType, false), methodFromField(field, "is", sqliteAndroidDatabaseType, true), methodFromField(field, "is", sqliteAndroidDatabaseType, false));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != field.getType()) {
            if (!z) {
                return null;
            }
            throw new IllegalArgumentException("Return type of get method " + findMethodFromNames.getName() + " does not return " + field.getType());
        }
        return findMethodFromNames;
    }

    public static Method findMethodFromNames(Field field, boolean z, boolean z2, String... strArr) {
        String str;
        NoSuchMethodException noSuchMethodException = null;
        for (String str2 : strArr) {
            try {
                if (z) {
                    return field.getDeclaringClass().getMethod(str2, new Class[0]);
                }
                return field.getDeclaringClass().getMethod(str2, field.getType());
            } catch (NoSuchMethodException e) {
                if (noSuchMethodException == null) {
                    noSuchMethodException = e;
                }
            }
        }
        if (!z2) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Could not find appropriate ");
        if (z) {
            str = "get";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(" method for ");
        sb.append(field);
        throw new IllegalArgumentException(sb.toString(), noSuchMethodException);
    }

    public static Method findSetMethod(Field field, SqliteAndroidDatabaseType sqliteAndroidDatabaseType, boolean z) throws IllegalArgumentException {
        Method findMethodFromNames = findMethodFromNames(field, false, z, methodFromField(field, "set", sqliteAndroidDatabaseType, true), methodFromField(field, "set", sqliteAndroidDatabaseType, false));
        if (findMethodFromNames == null) {
            return null;
        }
        if (findMethodFromNames.getReturnType() != Void.TYPE) {
            if (!z) {
                return null;
            }
            throw new IllegalArgumentException("Return type of set method " + findMethodFromNames.getName() + " returns " + findMethodFromNames.getReturnType() + " instead of void");
        }
        return findMethodFromNames;
    }

    public static DatabaseFieldConfig fromField(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, Field field) throws SQLException {
        DatabaseField databaseField = (DatabaseField) field.getAnnotation(DatabaseField.class);
        Enum<?> r1 = null;
        if (databaseField != null) {
            if (!databaseField.persisted()) {
                return null;
            }
            DatabaseFieldConfig databaseFieldConfig = new DatabaseFieldConfig();
            databaseFieldConfig.fieldName = field.getName();
            sqliteAndroidDatabaseType.getClass();
            databaseFieldConfig.columnName = valueIfNotBlank(databaseField.columnName());
            databaseFieldConfig.dataType = databaseField.dataType();
            String defaultValue = databaseField.defaultValue();
            if (!defaultValue.equals("__ormlite__ no default value string was specified")) {
                databaseFieldConfig.defaultValue = defaultValue;
            }
            databaseFieldConfig.width = databaseField.width();
            databaseFieldConfig.canBeNull = databaseField.canBeNull();
            databaseFieldConfig.id = databaseField.id();
            databaseFieldConfig.generatedId = databaseField.generatedId();
            databaseFieldConfig.generatedIdSequence = valueIfNotBlank(databaseField.generatedIdSequence());
            databaseFieldConfig.foreign = databaseField.foreign();
            databaseFieldConfig.useGetSet = databaseField.useGetSet();
            String unknownEnumName = databaseField.unknownEnumName();
            if (unknownEnumName != null && unknownEnumName.length() != 0) {
                for (Enum<?> r5 : (Enum[]) field.getType().getEnumConstants()) {
                    if (r5.name().equals(unknownEnumName)) {
                        r1 = r5;
                    }
                }
                throw new IllegalArgumentException("Unknwown enum unknown name " + unknownEnumName + " for field " + field);
            }
            databaseFieldConfig.unknownEnumValue = r1;
            databaseFieldConfig.throwIfNull = databaseField.throwIfNull();
            databaseFieldConfig.format = valueIfNotBlank(databaseField.format());
            databaseFieldConfig.unique = databaseField.unique();
            databaseFieldConfig.uniqueCombo = databaseField.uniqueCombo();
            databaseFieldConfig.index = databaseField.index();
            databaseFieldConfig.indexName = valueIfNotBlank(databaseField.indexName());
            databaseFieldConfig.uniqueIndex = databaseField.uniqueIndex();
            databaseFieldConfig.uniqueIndexName = valueIfNotBlank(databaseField.uniqueIndexName());
            boolean foreignAutoRefresh = databaseField.foreignAutoRefresh();
            databaseFieldConfig.foreignAutoRefresh = foreignAutoRefresh;
            if (!foreignAutoRefresh && databaseField.maxForeignAutoRefreshLevel() == 2) {
                databaseFieldConfig.maxForeignAutoRefreshLevel = -1;
            } else {
                databaseFieldConfig.maxForeignAutoRefreshLevel = databaseField.maxForeignAutoRefreshLevel();
            }
            databaseFieldConfig.persisterClass = databaseField.persisterClass();
            databaseFieldConfig.allowGeneratedIdInsert = databaseField.allowGeneratedIdInsert();
            databaseFieldConfig.columnDefinition = valueIfNotBlank(databaseField.columnDefinition());
            databaseFieldConfig.foreignAutoCreate = databaseField.foreignAutoCreate();
            databaseFieldConfig.version = databaseField.version();
            databaseFieldConfig.foreignColumnName = valueIfNotBlank(databaseField.foreignColumnName());
            databaseFieldConfig.readOnly = databaseField.readOnly();
            databaseFieldConfig.fullColumnDefinition = valueIfNotBlank(databaseField.fullColumnDefinition());
            return databaseFieldConfig;
        }
        ForeignCollectionField foreignCollectionField = (ForeignCollectionField) field.getAnnotation(ForeignCollectionField.class);
        if (foreignCollectionField != null) {
            DatabaseFieldConfig databaseFieldConfig2 = new DatabaseFieldConfig();
            databaseFieldConfig2.fieldName = field.getName();
            if (foreignCollectionField.columnName().length() > 0) {
                databaseFieldConfig2.columnName = foreignCollectionField.columnName();
            }
            databaseFieldConfig2.foreignCollection = true;
            databaseFieldConfig2.foreignCollectionEager = foreignCollectionField.eager();
            databaseFieldConfig2.foreignCollectionMaxEagerLevel = foreignCollectionField.maxEagerLevel();
            databaseFieldConfig2.foreignCollectionOrderColumnName = valueIfNotBlank(foreignCollectionField.orderColumnName());
            databaseFieldConfig2.foreignCollectionOrderAscending = foreignCollectionField.orderAscending();
            foreignCollectionField.columnName();
            databaseFieldConfig2.foreignCollectionForeignFieldName = valueIfNotBlank(foreignCollectionField.foreignFieldName());
            return databaseFieldConfig2;
        }
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2 = javaxPersistenceConfigurer;
        if (javaxPersistenceConfigurer2 == null) {
            return null;
        }
        return javaxPersistenceConfigurer2.createFieldConfig(sqliteAndroidDatabaseType, field);
    }

    public static String methodFromField(Field field, String str, SqliteAndroidDatabaseType sqliteAndroidDatabaseType, boolean z) {
        String upperCase;
        String name = field.getName();
        String substring = name.substring(0, 1);
        sqliteAndroidDatabaseType.getClass();
        if (z) {
            upperCase = substring.toUpperCase(Locale.ENGLISH);
        } else {
            upperCase = substring.toUpperCase();
        }
        StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, upperCase);
        m.append((CharSequence) name, 1, name.length());
        return m.toString();
    }

    public static String valueIfNotBlank(String str) {
        if (str != null && str.length() != 0) {
            return str;
        }
        return null;
    }

    public final String findIndexName(String str) {
        if (this.columnName == null) {
            return ComponentActivity$2$$ExternalSyntheticOutline0.m(PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, "_"), this.fieldName, "_idx");
        }
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, "_"), this.columnName, "_idx");
    }

    public final DataPersister getDataPersister() {
        DataPersister dataPersister = this.dataPersister;
        if (dataPersister == null) {
            return this.dataType.getDataPersister();
        }
        return dataPersister;
    }

    public final void setCanBeNull(boolean z) {
        this.canBeNull = z;
    }

    public final void setColumnDefinition(String str) {
        this.columnDefinition = str;
    }

    public final void setColumnName(String str) {
        this.columnName = str;
    }

    public final void setDataPersister(DataPersister dataPersister) {
        this.dataPersister = dataPersister;
    }

    public final void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public final void setFieldName(String str) {
        this.fieldName = str;
    }

    public final void setForeign() {
        this.foreign = true;
    }

    public final void setForeignCollection() {
        this.foreignCollection = true;
    }

    public final void setForeignCollectionEager() {
        this.foreignCollectionEager = true;
    }

    public final void setForeignCollectionForeignFieldName(String str) {
        this.foreignCollectionForeignFieldName = str;
    }

    public final void setGeneratedId() {
        this.generatedId = true;
    }

    public final void setId() {
        this.id = true;
    }

    public final void setJavaxEntity() {
        this.javaxEntity = true;
    }

    public final void setUnique(boolean z) {
        this.unique = z;
    }

    public final void setUseGetSet(boolean z) {
        this.useGetSet = z;
    }

    public final void setVersion() {
        this.version = true;
    }

    public final void setWidth(int r1) {
        this.width = r1;
    }
}
