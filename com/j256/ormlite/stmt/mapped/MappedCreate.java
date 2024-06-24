package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final String dataClassName;
    public final int versionFieldTypeIndex;

    /* loaded from: classes3.dex */
    public static class KeyHolder {
        public Number key;

        public final void addKey(Long l) throws SQLException {
            if (this.key == null) {
                this.key = l;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", trying now to set to " + l);
        }
    }

    public MappedCreate(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int r6) {
        super(dao, tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.dataClass.getSimpleName();
        this.versionFieldTypeIndex = r6;
    }

    public static boolean isFieldCreatable(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, FieldType fieldType) {
        DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
        if (databaseFieldConfig.foreignCollection || databaseFieldConfig.readOnly) {
            return false;
        }
        sqliteAndroidDatabaseType.getClass();
        if (fieldType.isGeneratedId && !fieldType.dataPersister.isSelfGeneratedId() && !fieldType.fieldConfig.allowGeneratedIdInsert) {
            return false;
        }
        return true;
    }
}
