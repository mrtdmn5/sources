package com.j256.ormlite.db;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType {

    /* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] r0 = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = r0;
            try {
                r0[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public final void appendEscapedEntityName(String str, StringBuilder sb) {
        sb.append('`');
        sb.append(str);
        sb.append('`');
    }

    public final <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) connectionSource).databaseType;
        String extractTableName = DatabaseTableConfig.extractTableName(sqliteAndroidDatabaseType, cls);
        ArrayList arrayList = new ArrayList();
        for (Class<T> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            for (Field field : cls2.getDeclaredFields()) {
                DatabaseFieldConfig fromField = DatabaseFieldConfig.fromField(sqliteAndroidDatabaseType, field);
                if (fromField != null && fromField.persisted) {
                    arrayList.add(fromField);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return new DatabaseTableConfig<>(cls, extractTableName, arrayList);
    }
}
