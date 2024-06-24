package com.j256.ormlite.stmt.mapped;

import android.database.Cursor;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public class MappedQueryForFieldEq<T, ID> extends BaseMappedQuery<T, ID> {
    public final String label;

    public MappedQueryForFieldEq(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, String str2) {
        super(dao, tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.label = str2;
    }

    public static <T, ID> MappedQueryForFieldEq<T, ID> build(Dao<T, ID> dao, TableInfo<T, ID> tableInfo, FieldType fieldType) throws SQLException {
        if (fieldType == null && (fieldType = tableInfo.idField) == null) {
            throw new SQLException("Cannot query-for-id with " + tableInfo.dataClass + " because it doesn't have an id field");
        }
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) dao.getConnectionSource()).databaseType;
        StringBuilder sb = new StringBuilder(64);
        BaseMappedStatement.appendTableName(sqliteAndroidDatabaseType, sb, "SELECT * FROM ", tableInfo);
        sb.append("WHERE ");
        BaseMappedStatement.appendFieldColumnName(sqliteAndroidDatabaseType, fieldType, sb);
        sb.append("= ?");
        return new MappedQueryForFieldEq<>(dao, tableInfo, sb.toString(), new FieldType[]{fieldType}, tableInfo.fieldTypes, "query-for-id");
    }

    public final Object execute(DatabaseConnection databaseConnection, Object obj) throws SQLException {
        Cursor cursor;
        String str = this.statement;
        Object[] objArr = {this.idField.convertJavaFieldToSqlArgValue(obj)};
        AndroidDatabaseConnection androidDatabaseConnection = (AndroidDatabaseConnection) databaseConnection;
        androidDatabaseConnection.getClass();
        AndroidDatabaseResults androidDatabaseResults = null;
        Object mapRow = null;
        androidDatabaseResults = null;
        try {
            try {
                cursor = androidDatabaseConnection.db.rawQuery(str, AndroidDatabaseConnection.toStrings(objArr));
                try {
                    AndroidDatabaseResults androidDatabaseResults2 = new AndroidDatabaseResults(cursor, true);
                    try {
                        AndroidDatabaseConnection.logger.trace(androidDatabaseConnection, str, "{}: queried for one result: {}");
                        if (cursor.moveToFirst()) {
                            mapRow = mapRow(androidDatabaseResults2);
                            if (cursor.moveToNext()) {
                                mapRow = DatabaseConnection.MORE_THAN_ONE;
                            }
                        }
                        IOUtils.closeQuietly(androidDatabaseResults2);
                        AndroidDatabaseConnection.closeQuietly(cursor);
                        String str2 = this.label;
                        String str3 = this.label;
                        Logger logger = BaseMappedStatement.logger;
                        if (mapRow == null) {
                            logger.debug("{} using '{}' and {} args, got no results", str2, str, 1);
                        } else if (mapRow != DatabaseConnection.MORE_THAN_ONE) {
                            logger.debug("{} using '{}' and {} args, got 1 result", str2, str, 1);
                        } else {
                            String str4 = this.statement;
                            logger.getClass();
                            Level level = Level.ERROR;
                            Object obj2 = Logger.UNKNOWN_ARG;
                            logger.logIfEnabled(level, null, "{} using '{}' and {} args, got >1 results", str2, str4, 1, null);
                            logger.trace(str3, objArr, "{} arguments: {}");
                            throw new SQLException(AbstractResolvableFuture$$ExternalSyntheticOutline0.m(str2, " got more than 1 result: ", str));
                        }
                        logger.trace(str3, objArr, "{} arguments: {}");
                        return mapRow;
                    } catch (android.database.SQLException e) {
                        e = e;
                        throw SupervisorKt.create("queryForOne from database failed: " + str, e);
                    } catch (Throwable th) {
                        th = th;
                        androidDatabaseResults = androidDatabaseResults2;
                        IOUtils.closeQuietly(androidDatabaseResults);
                        AndroidDatabaseConnection.closeQuietly(cursor);
                        throw th;
                    }
                } catch (android.database.SQLException e2) {
                    e = e2;
                }
            } catch (android.database.SQLException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
