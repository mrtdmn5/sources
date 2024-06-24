package com.j256.ormlite.stmt;

import android.database.Cursor;
import com.animaconnected.secondo.notification.model.Contact;
import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.BaseMappedStatement;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.stmt.mapped.MappedDelete;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import com.j256.ormlite.stmt.mapped.MappedQueryForFieldEq;
import com.j256.ormlite.stmt.mapped.MappedRefresh;
import com.j256.ormlite.stmt.mapped.MappedUpdate;
import com.j256.ormlite.stmt.query.ColumnNameOrRawSql;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class StatementExecutor<T, ID> implements GenericRowMapper<String[]> {
    public static final Logger logger = LoggerFactory.getLogger(StatementExecutor.class);
    public final Dao<T, ID> dao;
    public final DatabaseType databaseType;
    public String ifExistsQuery;
    public final AnonymousClass1 localIsInBatchMode = new AnonymousClass1();
    public MappedDelete<T, ID> mappedDelete;
    public MappedCreate<T, ID> mappedInsert;
    public MappedQueryForFieldEq<T, ID> mappedQueryForId;
    public MappedRefresh<T, ID> mappedRefresh;
    public MappedUpdate<T, ID> mappedUpdate;
    public MappedPreparedStmt preparedQueryForAll;
    public final TableInfo<T, ID> tableInfo;

    /* renamed from: com.j256.ormlite.stmt.StatementExecutor$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends ThreadLocal<Boolean> {
        @Override // java.lang.ThreadLocal
        public final Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public StatementExecutor(DatabaseType databaseType, TableInfo<T, ID> tableInfo, Dao<T, ID> dao) {
        this.databaseType = databaseType;
        this.tableInfo = tableInfo;
        this.dao = dao;
    }

    public final SelectIterator buildIterator(BaseDaoImpl baseDaoImpl, ConnectionSource connectionSource, PreparedStmt preparedStmt) throws SQLException {
        TableInfo<T, ID> tableInfo = this.tableInfo;
        String str = tableInfo.tableName;
        DatabaseConnection readWriteConnection = ((AndroidConnectionSource) connectionSource).getReadWriteConnection();
        AndroidCompiledStatement androidCompiledStatement = null;
        try {
            MappedPreparedStmt mappedPreparedStmt = (MappedPreparedStmt) preparedStmt;
            androidCompiledStatement = mappedPreparedStmt.compile(readWriteConnection, StatementBuilder.StatementType.SELECT);
            return new SelectIterator(tableInfo.dataClass, baseDaoImpl, mappedPreparedStmt, connectionSource, readWriteConnection, androidCompiledStatement);
        } catch (Throwable th) {
            IOUtils.closeThrowSqlException(androidCompiledStatement, "compiled statement");
            throw th;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:1|(8:3|(3:5|(1:13)(4:7|(1:9)|10|11)|12)|14|15|(1:17)(7:25|(4:28|(3:(1:31)(1:35)|32|33)(1:36)|34|26)|37|38|(3:40|(3:(1:43)(1:47)|44|45)(1:48)|46)|49|50)|18|(1:22)(1:24)|23)|51|(8:(4:53|(1:147)(1:57)|58|(4:63|(1:65)(1:146)|(1:67)|(18:70|71|72|(3:74|(3:76|(2:83|(2:85|86)(1:87))(2:78|79)|80)|88)|89|90|(1:144)(3:94|(1:96)(1:143)|97)|98|99|100|101|102|103|(1:105)|(1:107)|(2:109|(2:111|(2:113|(2:115|(1:117))(2:118|119))(2:121|122))(2:123|124))|125|(1:131)(2:129|130)))(1:(1:62)))|102|103|(0)|(0)|(0)|125|(2:127|131)(1:132))|148|71|72|(0)|89|90|(1:92)|144|98|99|100|101|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0231, code lost:            r0 = e;     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0189 A[Catch: SQLException -> 0x021b, TryCatch #0 {SQLException -> 0x021b, blocks: (B:103:0x017f, B:105:0x0189, B:107:0x018e, B:109:0x0196, B:111:0x019a, B:113:0x01a4, B:115:0x01ae, B:117:0x01be, B:118:0x01d7, B:119:0x01f4, B:121:0x01f5, B:122:0x01fc, B:123:0x01fd, B:124:0x0204), top: B:102:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x018e A[Catch: SQLException -> 0x021b, TryCatch #0 {SQLException -> 0x021b, blocks: (B:103:0x017f, B:105:0x0189, B:107:0x018e, B:109:0x0196, B:111:0x019a, B:113:0x01a4, B:115:0x01ae, B:117:0x01be, B:118:0x01d7, B:119:0x01f4, B:121:0x01f5, B:122:0x01fc, B:123:0x01fd, B:124:0x0204), top: B:102:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0196 A[Catch: SQLException -> 0x021b, TryCatch #0 {SQLException -> 0x021b, blocks: (B:103:0x017f, B:105:0x0189, B:107:0x018e, B:109:0x0196, B:111:0x019a, B:113:0x01a4, B:115:0x01ae, B:117:0x01be, B:118:0x01d7, B:119:0x01f4, B:121:0x01f5, B:122:0x01fc, B:123:0x01fd, B:124:0x0204), top: B:102:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011b A[Catch: SQLException -> 0x0231, TryCatch #2 {SQLException -> 0x0231, blocks: (B:72:0x0117, B:74:0x011b, B:76:0x0121, B:80:0x0145, B:81:0x012c, B:83:0x0132, B:85:0x0140, B:89:0x014b, B:92:0x0155, B:94:0x0159, B:97:0x0166, B:100:0x0176, B:139:0x0220, B:141:0x022d, B:142:0x0230, B:143:0x0161, B:99:0x016f), top: B:71:0x0117, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void create(com.j256.ormlite.support.DatabaseConnection r21, java.lang.Object r22) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.create(com.j256.ormlite.support.DatabaseConnection, java.lang.Object):void");
    }

    public final int delete(DatabaseConnection databaseConnection, Object obj) throws SQLException {
        MappedDelete<T, ID> mappedDelete = this.mappedDelete;
        Dao<T, ID> dao = this.dao;
        if (mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(dao, this.tableInfo);
        }
        MappedDelete<T, ID> mappedDelete2 = this.mappedDelete;
        String str = mappedDelete2.statement;
        try {
            Object[] fieldObjects = mappedDelete2.getFieldObjects(obj);
            int update = ((AndroidDatabaseConnection) databaseConnection).update(str, fieldObjects, mappedDelete2.argFieldTypes, "deleted");
            Logger logger2 = BaseMappedStatement.logger;
            logger2.debug("delete data with statement '{}' and {} args, changed {} rows", str, Integer.valueOf(fieldObjects.length), Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                logger2.trace(fieldObjects, "delete arguments: {}");
            }
            if (dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                dao.notifyChanges();
            }
            return update;
        } catch (SQLException e) {
            throw SupervisorKt.create("Unable to run delete stmt on object " + obj + ": " + str, e);
        }
    }

    public final int deleteById(DatabaseConnection databaseConnection, Object obj) throws SQLException {
        MappedDelete<T, ID> mappedDelete = this.mappedDelete;
        Dao<T, ID> dao = this.dao;
        if (mappedDelete == null) {
            this.mappedDelete = MappedDelete.build(dao, this.tableInfo);
        }
        MappedDelete<T, ID> mappedDelete2 = this.mappedDelete;
        String str = mappedDelete2.statement;
        try {
            Object[] objArr = {mappedDelete2.idField.convertJavaFieldToSqlArgValue(obj)};
            int update = ((AndroidDatabaseConnection) databaseConnection).update(str, objArr, mappedDelete2.argFieldTypes, "deleted");
            Logger logger2 = BaseMappedStatement.logger;
            logger2.debug("delete data with statement '{}' and {} args, changed {} rows", str, 1, Integer.valueOf(update));
            logger2.trace(objArr, "delete arguments: {}");
            if (dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                dao.notifyChanges();
            }
            return update;
        } catch (SQLException e) {
            throw SupervisorKt.create("Unable to run deleteById stmt on id " + obj + ": " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.j256.ormlite.android.AndroidDatabaseResults, java.io.Closeable] */
    public final boolean ifExists(DatabaseConnection databaseConnection, ID r14) throws SQLException {
        Cursor cursor;
        Cursor cursor2;
        long j;
        String str = this.ifExistsQuery;
        TableInfo<T, ID> tableInfo = this.tableInfo;
        if (str == null) {
            QueryBuilder queryBuilder = new QueryBuilder(this.databaseType, tableInfo, this.dao);
            ColumnNameOrRawSql columnNameOrRawSql = new ColumnNameOrRawSql(new String[]{"COUNT(*)"}[0]);
            if (queryBuilder.selectList == null) {
                queryBuilder.selectList = new ArrayList();
            }
            queryBuilder.selectList.add(columnNameOrRawSql);
            queryBuilder.where().eq(new SelectArg(), tableInfo.idField.columnName);
            this.ifExistsQuery = queryBuilder.buildStatementString(new ArrayList());
        }
        Object convertJavaFieldToSqlArgValue = tableInfo.idField.convertJavaFieldToSqlArgValue(r14);
        String str2 = this.ifExistsQuery;
        Object[] objArr = {convertJavaFieldToSqlArgValue};
        AndroidDatabaseConnection androidDatabaseConnection = (AndroidDatabaseConnection) databaseConnection;
        androidDatabaseConnection.getClass();
        Cursor cursor3 = null;
        try {
            cursor2 = androidDatabaseConnection.db.rawQuery(str2, AndroidDatabaseConnection.toStrings(objArr));
            try {
                try {
                    ?? androidDatabaseResults = new AndroidDatabaseResults(cursor2, false);
                    try {
                        if (cursor2.moveToFirst()) {
                            j = cursor2.getLong(0);
                        } else {
                            j = 0;
                        }
                        AndroidDatabaseConnection.logger.trace("{}: query for long raw query returned {}: {}", androidDatabaseConnection, Long.valueOf(j), str2);
                        AndroidDatabaseConnection.closeQuietly(cursor2);
                        IOUtils.closeQuietly(androidDatabaseResults);
                        logger.debug(this.ifExistsQuery, Long.valueOf(j), "query of '{}' returned {}");
                        if (j == 0) {
                            return false;
                        }
                        return true;
                    } catch (android.database.SQLException e) {
                        e = e;
                        cursor3 = androidDatabaseResults;
                        throw SupervisorKt.create("queryForLong from database failed: " + str2, e);
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = androidDatabaseResults;
                        Cursor cursor4 = cursor3;
                        cursor3 = cursor2;
                        cursor = cursor4;
                        AndroidDatabaseConnection.closeQuietly(cursor3);
                        IOUtils.closeQuietly(cursor);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (android.database.SQLException e2) {
                e = e2;
            }
        } catch (android.database.SQLException e3) {
            e = e3;
            cursor2 = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            AndroidDatabaseConnection.closeQuietly(cursor3);
            IOUtils.closeQuietly(cursor);
            throw th;
        }
    }

    @Override // com.j256.ormlite.stmt.GenericRowMapper
    public final Object mapRow(AndroidDatabaseResults androidDatabaseResults) throws SQLException {
        int columnCount = androidDatabaseResults.cursor.getColumnCount();
        String[] strArr = new String[columnCount];
        for (int r2 = 0; r2 < columnCount; r2++) {
            strArr[r2] = androidDatabaseResults.getString(r2);
        }
        return strArr;
    }

    public final ArrayList query(ConnectionSource connectionSource, PreparedStmt preparedStmt) throws SQLException {
        int length;
        SelectIterator buildIterator = buildIterator(null, connectionSource, preparedStmt);
        try {
            ArrayList arrayList = new ArrayList();
            while (buildIterator.hasNextThrow()) {
                arrayList.add(buildIterator.nextThrow());
            }
            Logger logger2 = logger;
            ArgumentHolder[] argumentHolderArr = ((MappedPreparedStmt) preparedStmt).argHolders;
            if (argumentHolderArr == null) {
                length = 0;
            } else {
                length = argumentHolderArr.length;
            }
            logger2.debug("query of '{}' with {} args returned {} results", preparedStmt, Integer.valueOf(length), Integer.valueOf(arrayList.size()));
            return arrayList;
        } finally {
            IOUtils.closeThrowSqlException(buildIterator, "iterator");
        }
    }

    public final int refresh(DatabaseConnection databaseConnection, Contact contact) throws SQLException {
        if (this.mappedRefresh == null) {
            int r0 = MappedRefresh.$r8$clinit;
            TableInfo<T, ID> tableInfo = this.tableInfo;
            FieldType fieldType = tableInfo.idField;
            if (fieldType != null) {
                Dao<T, ID> dao = this.dao;
                SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) dao.getConnectionSource()).databaseType;
                StringBuilder sb = new StringBuilder(64);
                BaseMappedStatement.appendTableName(sqliteAndroidDatabaseType, sb, "SELECT * FROM ", tableInfo);
                sb.append("WHERE ");
                BaseMappedStatement.appendFieldColumnName(sqliteAndroidDatabaseType, fieldType, sb);
                sb.append("= ?");
                this.mappedRefresh = new MappedRefresh<>(dao, tableInfo, sb.toString(), new FieldType[]{tableInfo.idField}, tableInfo.fieldTypes);
            } else {
                throw new SQLException("Cannot refresh " + tableInfo.dataClass + " because it doesn't have an id field");
            }
        }
        MappedRefresh<T, ID> mappedRefresh = this.mappedRefresh;
        FieldType fieldType2 = mappedRefresh.idField;
        Object execute = mappedRefresh.execute(databaseConnection, fieldType2.extractJavaFieldValue(contact));
        if (execute == null) {
            return 0;
        }
        for (FieldType fieldType3 : mappedRefresh.resultsFieldTypes) {
            if (fieldType3 != fieldType2) {
                fieldType3.assignField(mappedRefresh.connectionSource, contact, fieldType3.extractJavaFieldValue(execute), false);
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int update(com.j256.ormlite.support.DatabaseConnection r19, java.lang.Object r20) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.StatementExecutor.update(com.j256.ormlite.support.DatabaseConnection, java.lang.Object):int");
    }

    public final int delete(DatabaseConnection databaseConnection, MappedPreparedStmt mappedPreparedStmt) throws SQLException {
        AndroidCompiledStatement compile = mappedPreparedStmt.compile(databaseConnection, StatementBuilder.StatementType.DELETE);
        try {
            int runUpdate = compile.runUpdate();
            Dao<T, ID> dao = this.dao;
            if (dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }

    public final int update(DatabaseConnection databaseConnection, MappedPreparedStmt mappedPreparedStmt) throws SQLException {
        AndroidCompiledStatement compile = mappedPreparedStmt.compile(databaseConnection, StatementBuilder.StatementType.UPDATE);
        try {
            int runUpdate = compile.runUpdate();
            Dao<T, ID> dao = this.dao;
            if (dao != null && !this.localIsInBatchMode.get().booleanValue()) {
                dao.notifyChanges();
            }
            return runUpdate;
        } finally {
            IOUtils.closeThrowSqlException(compile, "compiled statement");
        }
    }
}
