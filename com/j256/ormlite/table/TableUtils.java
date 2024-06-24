package com.j256.ormlite.table;

import com.j256.ormlite.android.AndroidCompiledStatement;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.android.AndroidDatabaseResults;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.BaseDatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class TableUtils {
    public static final Logger logger = LoggerFactory.getLogger(TableUtils.class);

    public static void addCreateIndexStatements(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, TableInfo tableInfo, ArrayList arrayList, boolean z) {
        String str;
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.fieldTypes) {
            if (z) {
                DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
                if (databaseFieldConfig.uniqueIndex && databaseFieldConfig.uniqueIndexName == null) {
                    databaseFieldConfig.uniqueIndexName = databaseFieldConfig.findIndexName(fieldType.tableName);
                }
                str = databaseFieldConfig.uniqueIndexName;
            } else {
                DatabaseFieldConfig databaseFieldConfig2 = fieldType.fieldConfig;
                if (databaseFieldConfig2.index && databaseFieldConfig2.indexName == null) {
                    databaseFieldConfig2.indexName = databaseFieldConfig2.findIndexName(fieldType.tableName);
                }
                str = databaseFieldConfig2.indexName;
            }
            if (str != null) {
                List list = (List) hashMap.get(str);
                if (list == null) {
                    list = new ArrayList();
                    hashMap.put(str, list);
                }
                list.add(fieldType.columnName);
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = tableInfo.tableName;
            Object key = entry.getKey();
            Logger logger2 = logger;
            logger2.getClass();
            logger2.logIfEnabled(Level.INFO, null, "creating index '{}' for table '{}", key, str2, Logger.UNKNOWN_ARG, null);
            sb.append("CREATE ");
            if (z) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            sqliteAndroidDatabaseType.appendEscapedEntityName((String) entry.getKey(), sb);
            sb.append(" ON ");
            sqliteAndroidDatabaseType.appendEscapedEntityName(str2, sb);
            sb.append(" ( ");
            boolean z2 = true;
            for (String str3 : (List) entry.getValue()) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                sqliteAndroidDatabaseType.appendEscapedEntityName(str3, sb);
            }
            sb.append(" )");
            arrayList.add(sb.toString());
            sb.setLength(0);
        }
    }

    public static void createTable(ConnectionSource connectionSource, Class cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        ConnectionSource connectionSource2 = createDao.getConnectionSource();
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) connectionSource2).databaseType;
        if (createDao instanceof BaseDaoImpl) {
            doCreateTable(connectionSource2, ((BaseDaoImpl) createDao).tableInfo);
        } else {
            doCreateTable(connectionSource2, new TableInfo(sqliteAndroidDatabaseType, createDao.getDataClass()));
        }
    }

    public static int doCreateTable(ConnectionSource connectionSource, TableInfo tableInfo) throws SQLException {
        int r16;
        AndroidConnectionSource androidConnectionSource;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        boolean z2;
        AndroidConnectionSource androidConnectionSource2 = (AndroidConnectionSource) connectionSource;
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = androidConnectionSource2.databaseType;
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        StringBuilder sb = new StringBuilder(256);
        String str = tableInfo.tableName;
        Logger logger2 = logger;
        logger2.getClass();
        Level level = Level.INFO;
        Object obj = Logger.UNKNOWN_ARG;
        logger2.logIfEnabled(level, null, "creating table '{}'", str, obj, obj, null);
        sb.append("CREATE TABLE ");
        String str2 = tableInfo.schemaName;
        if (str2 != null && str2.length() > 0) {
            sqliteAndroidDatabaseType.appendEscapedEntityName(str2, sb);
            sb.append('.');
        }
        sqliteAndroidDatabaseType.appendEscapedEntityName(tableInfo.tableName, sb);
        sb.append(" (");
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        FieldType[] fieldTypeArr = tableInfo.fieldTypes;
        int length = fieldTypeArr.length;
        int r13 = 0;
        boolean z3 = true;
        while (r13 < length) {
            FieldType fieldType = fieldTypeArr[r13];
            if (fieldType.fieldConfig.foreignCollection) {
                androidConnectionSource = androidConnectionSource2;
                arrayList = arrayList4;
                arrayList2 = arrayList5;
                arrayList3 = arrayList8;
                r16 = length;
            } else {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
                String str3 = databaseFieldConfig.fullColumnDefinition;
                if (str3 == null) {
                    str3 = databaseFieldConfig.columnDefinition;
                }
                r16 = length;
                String str4 = fieldType.columnName;
                if (str3 == null) {
                    sqliteAndroidDatabaseType.appendEscapedEntityName(str4, sb);
                    sb.append(' ');
                    DataPersister dataPersister = fieldType.dataPersister;
                    z = z3;
                    if (databaseFieldConfig.width == 0) {
                        dataPersister.getDefaultWidth();
                    }
                    int r14 = BaseDatabaseType.AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()];
                    arrayList2 = arrayList5;
                    androidConnectionSource = androidConnectionSource2;
                    arrayList3 = arrayList8;
                    arrayList = arrayList4;
                    boolean z4 = fieldType.isGeneratedId;
                    switch (r14) {
                        case 1:
                            sb.append("VARCHAR");
                            break;
                        case 2:
                            sb.append("TEXT");
                            break;
                        case 3:
                            sb.append("SMALLINT");
                            break;
                        case 4:
                            sb.append("VARCHAR");
                            break;
                        case 5:
                            sb.append("CHAR");
                            break;
                        case 6:
                            sb.append("TINYINT");
                            break;
                        case 7:
                            sb.append("BLOB");
                            break;
                        case 8:
                            sb.append("SMALLINT");
                            break;
                        case 9:
                            sb.append("INTEGER");
                            break;
                        case 10:
                            if (fieldType.fieldConverter.getSqlType() == SqlType.LONG && z4) {
                                sb.append("INTEGER");
                                break;
                            } else {
                                sb.append("BIGINT");
                                break;
                            }
                        case 11:
                            sb.append("FLOAT");
                            break;
                        case 12:
                            sb.append("DOUBLE PRECISION");
                            break;
                        case 13:
                            sb.append("BLOB");
                            break;
                        case 14:
                            sb.append("NUMERIC");
                            break;
                        case 15:
                            throw new UnsupportedOperationException("UUID is not supported by this database type");
                        case 16:
                            dataPersister.getSqlOtherType();
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown SQL-type " + dataPersister.getSqlType());
                    }
                    sb.append(' ');
                    if (fieldType.generatedIdSequence != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2 && !fieldType.dataPersister.isSelfGeneratedId()) {
                        throw new SQLException("GeneratedIdSequence is not supported by database Android SQLite for field " + fieldType);
                    }
                    if (z4 && !fieldType.dataPersister.isSelfGeneratedId()) {
                        if (fieldType.fieldConverter.getSqlType() != SqlType.INTEGER && fieldType.fieldConverter.getSqlType() != SqlType.LONG) {
                            throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
                        }
                        sb.append("PRIMARY KEY AUTOINCREMENT ");
                    }
                    if (!z4) {
                        Object obj2 = fieldType.defaultValue;
                        if (obj2 != null) {
                            sb.append("DEFAULT ");
                            if (fieldType.dataPersister.isEscapedDefaultValue()) {
                                String obj3 = obj2.toString();
                                sb.append('\'');
                                sb.append(obj3);
                                sb.append('\'');
                            } else {
                                sb.append(obj2);
                            }
                            sb.append(' ');
                        }
                        if (!databaseFieldConfig.canBeNull) {
                            sb.append("NOT NULL ");
                        }
                        if (databaseFieldConfig.unique) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" UNIQUE (");
                            sqliteAndroidDatabaseType.appendEscapedEntityName(str4, sb2);
                            sb2.append(')');
                            arrayList6.add(sb2.toString());
                        }
                    }
                } else {
                    androidConnectionSource = androidConnectionSource2;
                    arrayList = arrayList4;
                    arrayList2 = arrayList5;
                    arrayList3 = arrayList8;
                    z = z3;
                    sqliteAndroidDatabaseType.appendEscapedEntityName(str4, sb);
                    sb.append(' ');
                    sb.append(str3);
                    sb.append(' ');
                }
                z3 = z;
            }
            r13++;
            length = r16;
            arrayList5 = arrayList2;
            androidConnectionSource2 = androidConnectionSource;
            arrayList8 = arrayList3;
            arrayList4 = arrayList;
        }
        AndroidConnectionSource androidConnectionSource3 = androidConnectionSource2;
        ArrayList arrayList9 = arrayList4;
        ArrayList arrayList10 = arrayList5;
        ArrayList arrayList11 = arrayList8;
        StringBuilder sb3 = null;
        StringBuilder sb4 = null;
        for (FieldType fieldType2 : fieldTypeArr) {
            if ((!fieldType2.isGeneratedId || fieldType2.dataPersister.isSelfGeneratedId()) && fieldType2.isId) {
                if (sb4 == null) {
                    sb4 = new StringBuilder(48);
                    sb4.append("PRIMARY KEY (");
                } else {
                    sb4.append(',');
                }
                sqliteAndroidDatabaseType.appendEscapedEntityName(fieldType2.columnName, sb4);
            }
        }
        if (sb4 != null) {
            sb4.append(") ");
            arrayList6.add(sb4.toString());
        }
        for (FieldType fieldType3 : fieldTypeArr) {
            if (fieldType3.fieldConfig.uniqueCombo) {
                if (sb3 == null) {
                    sb3 = new StringBuilder(48);
                    sb3.append("UNIQUE (");
                } else {
                    sb3.append(',');
                }
                sqliteAndroidDatabaseType.appendEscapedEntityName(fieldType3.columnName, sb3);
            }
        }
        if (sb3 != null) {
            sb3.append(") ");
            arrayList6.add(sb3.toString());
        }
        Iterator it = arrayList6.iterator();
        while (it.hasNext()) {
            String str5 = (String) it.next();
            sb.append(", ");
            sb.append(str5);
        }
        sb.append(") ");
        arrayList9.addAll(arrayList7);
        arrayList9.add(sb.toString());
        arrayList9.addAll(arrayList11);
        addCreateIndexStatements(sqliteAndroidDatabaseType, tableInfo, arrayList9, false);
        addCreateIndexStatements(sqliteAndroidDatabaseType, tableInfo, arrayList9, true);
        DatabaseConnection readWriteConnection = androidConnectionSource3.getReadWriteConnection();
        sqliteAndroidDatabaseType.getClass();
        return doCreateTestQueries(readWriteConnection, arrayList10) + doStatements(readWriteConnection, "create", arrayList9, false);
    }

    public static int doCreateTestQueries(DatabaseConnection databaseConnection, ArrayList arrayList) throws SQLException {
        AndroidCompiledStatement androidCompiledStatement;
        Iterator it = arrayList.iterator();
        int r2 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            AndroidCompiledStatement androidCompiledStatement2 = null;
            try {
                try {
                    androidCompiledStatement = ((AndroidDatabaseConnection) databaseConnection).compileStatement(str, StatementBuilder.StatementType.SELECT, false);
                    try {
                        AndroidDatabaseResults runQuery = androidCompiledStatement.runQuery();
                        int r6 = 0;
                        for (boolean moveToFirst = runQuery.cursor.moveToFirst(); moveToFirst; moveToFirst = runQuery.cursor.moveToNext()) {
                            r6++;
                        }
                        Logger logger2 = logger;
                        Integer valueOf = Integer.valueOf(r6);
                        logger2.getClass();
                        logger2.logIfEnabled(Level.INFO, null, "executing create table after-query got {} results: {}", valueOf, str, Logger.UNKNOWN_ARG, null);
                        IOUtils.closeThrowSqlException(androidCompiledStatement, "compiled statement");
                        r2++;
                    } catch (SQLException e) {
                        e = e;
                        androidCompiledStatement2 = androidCompiledStatement;
                        throw SupervisorKt.create("executing create table after-query failed: " + str, e);
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeThrowSqlException(androidCompiledStatement, "compiled statement");
                        throw th;
                    }
                } catch (SQLException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
                androidCompiledStatement = androidCompiledStatement2;
            }
        }
        return r2;
    }

    public static int doDropTable(SqliteAndroidDatabaseType sqliteAndroidDatabaseType, ConnectionSource connectionSource, TableInfo tableInfo) throws SQLException {
        Logger logger2;
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.fieldTypes) {
            DatabaseFieldConfig databaseFieldConfig = fieldType.fieldConfig;
            if (databaseFieldConfig.index && databaseFieldConfig.indexName == null) {
                databaseFieldConfig.indexName = databaseFieldConfig.findIndexName(fieldType.tableName);
            }
            String str = databaseFieldConfig.indexName;
            if (str != null) {
                hashSet.add(str);
            }
            DatabaseFieldConfig databaseFieldConfig2 = fieldType.fieldConfig;
            if (databaseFieldConfig2.uniqueIndex && databaseFieldConfig2.uniqueIndexName == null) {
                databaseFieldConfig2.uniqueIndexName = databaseFieldConfig2.findIndexName(fieldType.tableName);
            }
            String str2 = databaseFieldConfig2.uniqueIndexName;
            if (str2 != null) {
                hashSet.add(str2);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        Iterator it = hashSet.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            logger2 = logger;
            if (!hasNext) {
                break;
            }
            String str3 = (String) it.next();
            String str4 = tableInfo.tableName;
            logger2.getClass();
            logger2.logIfEnabled(Level.INFO, null, "dropping index '{}' for table '{}", str3, str4, Logger.UNKNOWN_ARG, null);
            sb.append("DROP INDEX ");
            sqliteAndroidDatabaseType.appendEscapedEntityName(str3, sb);
            arrayList.add(sb.toString());
            sb.setLength(0);
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (FieldType fieldType2 : tableInfo.fieldTypes) {
            sqliteAndroidDatabaseType.getClass();
        }
        StringBuilder sb2 = new StringBuilder(64);
        String str5 = tableInfo.tableName;
        logger2.getClass();
        Level level = Level.INFO;
        Object obj = Logger.UNKNOWN_ARG;
        logger2.logIfEnabled(level, null, "dropping table '{}'", str5, obj, obj, null);
        sb2.append("DROP TABLE ");
        String str6 = tableInfo.schemaName;
        if (str6 != null && str6.length() > 0) {
            sqliteAndroidDatabaseType.appendEscapedEntityName(str6, sb2);
            sb2.append('.');
        }
        sqliteAndroidDatabaseType.appendEscapedEntityName(str5, sb2);
        sb2.append(' ');
        arrayList.addAll(arrayList2);
        arrayList.add(sb2.toString());
        arrayList.addAll(arrayList3);
        DatabaseConnection readWriteConnection = ((AndroidConnectionSource) connectionSource).getReadWriteConnection();
        sqliteAndroidDatabaseType.getClass();
        return doStatements(readWriteConnection, "drop", arrayList, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0061 A[LOOP:0: B:2:0x000a->B:13:0x0061, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x009b, blocks: (B:8:0x0022, B:10:0x0026, B:22:0x004a, B:24:0x0085, B:25:0x009a), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int doStatements(com.j256.ormlite.support.DatabaseConnection r17, java.lang.String r18, java.util.ArrayList r19, boolean r20) throws java.sql.SQLException {
        /*
            com.j256.ormlite.logger.Logger r9 = com.j256.ormlite.table.TableUtils.logger
            java.lang.String r10 = "compiled statement"
            java.util.Iterator r11 = r19.iterator()
            r12 = 0
            r13 = r12
        La:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto La1
            java.lang.Object r0 = r11.next()
            r14 = r0
            java.lang.String r14 = (java.lang.String) r14
            r1 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r0 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch: java.lang.Throwable -> L41 java.sql.SQLException -> L43
            r2 = r17
            com.j256.ormlite.android.AndroidDatabaseConnection r2 = (com.j256.ormlite.android.AndroidDatabaseConnection) r2     // Catch: java.lang.Throwable -> L41 java.sql.SQLException -> L43
            com.j256.ormlite.android.AndroidCompiledStatement r15 = r2.compileStatement(r14, r0, r12)     // Catch: java.lang.Throwable -> L41 java.sql.SQLException -> L43
            int r16 = r15.runExecute()     // Catch: java.sql.SQLException -> L3e java.lang.Throwable -> L9b
            java.lang.String r4 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)     // Catch: java.sql.SQLException -> L3b java.lang.Throwable -> L9b
            r9.getClass()     // Catch: java.sql.SQLException -> L3b java.lang.Throwable -> L9b
            com.j256.ormlite.logger.Level r2 = com.j256.ormlite.logger.Level.INFO     // Catch: java.sql.SQLException -> L3b java.lang.Throwable -> L9b
            r3 = 0
            r8 = 0
            r1 = r9
            r5 = r18
            r7 = r14
            r1.logIfEnabled(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.sql.SQLException -> L3b java.lang.Throwable -> L9b
            goto L5a
        L3b:
            r0 = move-exception
            r6 = r0
            goto L48
        L3e:
            r0 = move-exception
            r1 = r15
            goto L44
        L41:
            r0 = move-exception
            goto L9d
        L43:
            r0 = move-exception
        L44:
            r6 = r0
            r15 = r1
            r16 = r12
        L48:
            if (r20 == 0) goto L85
            java.lang.String r4 = "ignoring {} error '{}' for statement: {}"
            r9.getClass()     // Catch: java.lang.Throwable -> L9b
            com.j256.ormlite.logger.Level r2 = com.j256.ormlite.logger.Level.INFO     // Catch: java.lang.Throwable -> L9b
            r3 = 0
            r8 = 0
            r1 = r9
            r5 = r18
            r7 = r14
            r1.logIfEnabled(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L9b
        L5a:
            r0 = r16
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r15, r10)
            if (r0 < 0) goto L64
            int r13 = r13 + 1
            goto La
        L64:
            java.sql.SQLException r1 = new java.sql.SQLException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "SQL statement "
            r2.<init>(r3)
            r2.append(r14)
            java.lang.String r3 = " updated "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " rows, we were expecting >= 0"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L85:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r0.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r1 = "SQL statement failed: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L9b
            r0.append(r14)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L9b
            java.sql.SQLException r0 = kotlinx.coroutines.SupervisorKt.create(r0, r6)     // Catch: java.lang.Throwable -> L9b
            throw r0     // Catch: java.lang.Throwable -> L9b
        L9b:
            r0 = move-exception
            r1 = r15
        L9d:
            com.j256.ormlite.misc.IOUtils.closeThrowSqlException(r1, r10)
            throw r0
        La1:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.ArrayList, boolean):int");
    }

    public static void dropTable(ConnectionSource connectionSource, Class cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        ConnectionSource connectionSource2 = createDao.getConnectionSource();
        Class dataClass = createDao.getDataClass();
        SqliteAndroidDatabaseType sqliteAndroidDatabaseType = ((AndroidConnectionSource) connectionSource2).databaseType;
        if (createDao instanceof BaseDaoImpl) {
            doDropTable(sqliteAndroidDatabaseType, connectionSource2, ((BaseDaoImpl) createDao).tableInfo);
        } else {
            doDropTable(sqliteAndroidDatabaseType, connectionSource2, new TableInfo(sqliteAndroidDatabaseType, dataClass));
        }
    }
}
