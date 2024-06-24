package com.j256.ormlite.table;

import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.JavaxPersistenceConfigurer;
import com.j256.ormlite.misc.JavaxPersistenceImpl;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class DatabaseTableConfig<T> {
    public static final JavaxPersistenceConfigurer javaxPersistenceConfigurer;
    public Class<T> dataClass;
    public List<DatabaseFieldConfig> fieldConfigs;
    public FieldType[] fieldTypes;
    public String schemaName;
    public String tableName;

    static {
        try {
            Class.forName("javax.persistence.Entity");
            javaxPersistenceConfigurer = (JavaxPersistenceConfigurer) JavaxPersistenceImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            javaxPersistenceConfigurer = null;
        }
    }

    public DatabaseTableConfig() {
    }

    public static FieldType[] extractFieldTypes(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, Class cls, String str) throws SQLException {
        FieldType fieldType;
        ArrayList arrayList = new ArrayList();
        for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                ThreadLocal<FieldType.LevelCounters> threadLocal = FieldType.threadLevelCounters;
                DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(sqliteAndroidDatabaseType, field);
                if (fromField == null) {
                    fieldType = null;
                } else {
                    fieldType = new FieldType(sqliteAndroidDatabaseType, str, field, fromField, cls);
                }
                if (fieldType != null) {
                    arrayList.add(fieldType);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return (FieldType[]) arrayList.toArray(new FieldType[arrayList.size()]);
        }
        throw new IllegalArgumentException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("No fields have a DatabaseField annotation in ", cls));
    }

    public static String extractTableName(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, Class cls) {
        String str;
        JavaxPersistenceConfigurer javaxPersistenceConfigurer2;
        DatabaseTable databaseTable = (DatabaseTable) cls.getAnnotation(DatabaseTable.class);
        if (databaseTable != null && databaseTable.tableName() != null && databaseTable.tableName().length() > 0) {
            str = databaseTable.tableName();
        } else {
            str = null;
        }
        if (str == null && (javaxPersistenceConfigurer2 = javaxPersistenceConfigurer) != null) {
            str = javaxPersistenceConfigurer2.getEntityName(cls);
        }
        if (str == null) {
            if (sqliteAndroidDatabaseType == null) {
                return cls.getSimpleName().toLowerCase(Locale.ENGLISH);
            }
            return cls.getSimpleName().toLowerCase(Locale.ENGLISH);
        }
        return str;
    }

    public DatabaseTableConfig(Class cls, String str, ArrayList arrayList) {
        this.dataClass = cls;
        this.schemaName = null;
        this.tableName = str;
        this.fieldConfigs = arrayList;
    }

    public DatabaseTableConfig(Class cls, String str, String str2, FieldType[] fieldTypeArr) {
        this.dataClass = cls;
        this.schemaName = str;
        this.tableName = str2;
        this.fieldTypes = fieldTypeArr;
    }
}
