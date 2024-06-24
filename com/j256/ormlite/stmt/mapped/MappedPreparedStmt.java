package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedStmt;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public final class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedQuery<T>, PreparedStmt {
    public final ArgumentHolder[] argHolders;
    public final boolean cacheStore;
    public final Long limit;
    public final StatementBuilder.StatementType type;

    public MappedPreparedStmt(Dao dao, TableInfo tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, StatementBuilder.StatementType statementType, boolean z) {
        super(dao, tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = null;
        this.type = statementType;
        this.cacheStore = z;
    }

    public final AndroidCompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException {
        Object[] objArr;
        SqlType sqlType;
        StatementBuilder.StatementType statementType2 = this.type;
        if (statementType2 == statementType) {
            boolean z = this.cacheStore;
            String str = this.statement;
            AndroidCompiledStatement compileStatement = ((AndroidDatabaseConnection) databaseConnection).compileStatement(str, statementType, z);
            Logger logger = BaseMappedStatement.logger;
            try {
                Long l = this.limit;
                if (l != null) {
                    int intValue = l.intValue();
                    if (compileStatement.cursor == null) {
                        compileStatement.max = Integer.valueOf(intValue);
                    } else {
                        throw new SQLException("Query already run. Cannot add argument values.");
                    }
                }
                boolean isLevelEnabled = logger.backend.isLevelEnabled(Level.TRACE);
                ArgumentHolder[] argumentHolderArr = this.argHolders;
                if (isLevelEnabled && argumentHolderArr.length > 0) {
                    objArr = new Object[argumentHolderArr.length];
                } else {
                    objArr = null;
                }
                for (int r3 = 0; r3 < argumentHolderArr.length; r3++) {
                    Object sqlArgValue = argumentHolderArr[r3].getSqlArgValue();
                    FieldType fieldType = this.argFieldTypes[r3];
                    if (fieldType == null) {
                        sqlType = argumentHolderArr[r3].getSqlType();
                    } else {
                        sqlType = fieldType.fieldConverter.getSqlType();
                    }
                    compileStatement.setObject(r3, sqlArgValue, sqlType);
                    if (objArr != null) {
                        objArr[r3] = sqlArgValue;
                    }
                }
                logger.debug(str, Integer.valueOf(argumentHolderArr.length), "prepared statement '{}' with {} args");
                if (objArr != null) {
                    logger.trace(objArr, "prepared statement arguments: {}");
                }
                return compileStatement;
            } catch (Throwable th) {
                IOUtils.closeThrowSqlException(compileStatement, "statement");
                throw th;
            }
        }
        throw new SQLException("Could not compile this " + statementType2 + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
    }
}
