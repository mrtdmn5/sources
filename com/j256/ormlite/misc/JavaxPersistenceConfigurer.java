package com.j256.ormlite.misc;

import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public interface JavaxPersistenceConfigurer {
    DatabaseFieldConfig createFieldConfig(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, Field field) throws SQLException;

    String getEntityName(Class<?> cls);
}
