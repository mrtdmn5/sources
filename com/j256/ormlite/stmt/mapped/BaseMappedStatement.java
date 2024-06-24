package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public abstract class BaseMappedStatement<T, ID> {
    public static final Logger logger = LoggerFactory.getLogger(BaseMappedStatement.class);
    public final FieldType[] argFieldTypes;
    public final ConnectionSource connectionSource;
    public final Dao<T, ID> dao;
    public final FieldType idField;
    public final String statement;
    public final TableInfo<T, ID> tableInfo;

    public BaseMappedStatement(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr) {
        this.dao = dao;
        this.connectionSource = dao.getConnectionSource();
        this.tableInfo = tableInfo;
        Class<T> cls = tableInfo.dataClass;
        this.idField = tableInfo.idField;
        this.statement = str;
        this.argFieldTypes = fieldTypeArr;
    }

    public static void appendFieldColumnName(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, FieldType fieldType, StringBuilder sb) {
        sqliteAndroidDatabaseType.appendEscapedEntityName(fieldType.columnName, sb);
        sb.append(' ');
    }

    public static void appendTableName(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, StringBuilder sb, String str, TableInfo tableInfo) {
        sb.append(str);
        String str2 = tableInfo.schemaName;
        if (str2 != null && str2.length() > 0) {
            sqliteAndroidDatabaseType.appendEscapedEntityName(tableInfo.schemaName, sb);
            sb.append('.');
        }
        sqliteAndroidDatabaseType.appendEscapedEntityName(tableInfo.tableName, sb);
        sb.append(' ');
    }

    public final Object[] getFieldObjects(Object obj) throws SQLException {
        FieldType[] fieldTypeArr = this.argFieldTypes;
        Object[] objArr = new Object[fieldTypeArr.length];
        for (int r2 = 0; r2 < fieldTypeArr.length; r2++) {
            FieldType fieldType = fieldTypeArr[r2];
            if (fieldType.fieldConfig.allowGeneratedIdInsert) {
                Object extractJavaFieldValue = fieldType.extractJavaFieldValue(obj);
                if (fieldType.isFieldValueDefault(extractJavaFieldValue)) {
                    extractJavaFieldValue = null;
                }
                objArr[r2] = extractJavaFieldValue;
            } else {
                objArr[r2] = fieldType.convertJavaFieldToSqlArgValue(fieldType.extractJavaFieldValue(obj));
            }
            if (objArr[r2] == null) {
                objArr[r2] = fieldType.defaultValue;
            }
        }
        return objArr;
    }

    public final String toString() {
        return this.statement;
    }
}
