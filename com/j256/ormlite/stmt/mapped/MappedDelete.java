package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class MappedDelete<T, ID> extends BaseMappedStatement<T, ID> {
    public static <T, ID> MappedDelete<T, ID> build(Dao<T, ID> dao, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType fieldType = tableInfo.idField;
        if (fieldType != null) {
            StringBuilder sb = new StringBuilder(64);
            SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) dao.getConnectionSource()).databaseType;
            BaseMappedStatement.appendTableName(sqliteAndroidDatabaseType, sb, "DELETE FROM ", tableInfo);
            sb.append("WHERE ");
            BaseMappedStatement.appendFieldColumnName(sqliteAndroidDatabaseType, fieldType, sb);
            sb.append("= ?");
            return new MappedDelete<>(dao, tableInfo, sb.toString(), new FieldType[]{fieldType});
        }
        throw new SQLException("Cannot delete from " + tableInfo.dataClass + " because it doesn't have an id field");
    }
}
