package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.stmt.mapped.MappedCreate;
import com.j256.ormlite.support.DatabaseConnection;
import java.io.IOException;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class AndroidDatabaseConnection implements DatabaseConnection {
    public static final Logger logger = LoggerFactory.getLogger(AndroidDatabaseConnection.class);
    public final boolean cancelQueriesEnabled;
    public final SQLiteDatabase db;

    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] r0 = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = r0;
            try {
                r0[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.db = sQLiteDatabase;
        this.cancelQueriesEnabled = z;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.TRUE);
    }

    public static void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        for (int r0 = 0; r0 < objArr.length; r0++) {
            Object obj = objArr[r0];
            if (obj == null) {
                sQLiteStatement.bindNull(r0 + 1);
            } else {
                SqlType sqlType = fieldTypeArr[r0].fieldConverter.getSqlType();
                switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(r0 + 1, obj.toString());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(r0 + 1, ((Number) obj).longValue());
                        break;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(r0 + 1, ((Number) obj).doubleValue());
                        break;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(r0 + 1, (byte[]) obj);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
        }
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            cursor.close();
        }
    }

    public static String[] toStrings(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int r2 = 0; r2 < objArr.length; r2++) {
            Object obj = objArr[r2];
            if (obj == null) {
                strArr[r2] = null;
            } else {
                strArr[r2] = obj.toString();
            }
        }
        return strArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        SQLiteDatabase sQLiteDatabase = this.db;
        try {
            sQLiteDatabase.close();
            logger.trace(this, sQLiteDatabase, "{}: db {} closed");
        } catch (android.database.SQLException e) {
            throw new IOException("problems closing the database connection", e);
        }
    }

    public final AndroidCompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, boolean z) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType, this.cancelQueriesEnabled, z);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    public final void insert(String str, Object[] objArr, FieldType[] fieldTypeArr, MappedCreate.KeyHolder keyHolder) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.db.compileStatement(str);
                bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                long executeInsert = sQLiteStatement.executeInsert();
                if (keyHolder != null) {
                    keyHolder.addKey(Long.valueOf(executeInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", this, 1, str);
                closeQuietly(sQLiteStatement);
            } catch (android.database.SQLException e) {
                throw SupervisorKt.create("inserting to database failed: " + str, e);
            }
        } catch (Throwable th) {
            closeQuietly(sQLiteStatement);
            throw th;
        }
    }

    public final String toString() {
        return "AndroidDatabaseConnection@" + Integer.toHexString(hashCode());
    }

    public final int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws SQLException {
        SQLiteStatement sQLiteStatement;
        int r6;
        SQLiteDatabase sQLiteDatabase = this.db;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                sQLiteStatement = sQLiteDatabase.compileStatement(str);
                try {
                    bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                    sQLiteStatement.execute();
                    closeQuietly(sQLiteStatement);
                    try {
                        sQLiteStatement2 = sQLiteDatabase.compileStatement("SELECT CHANGES()");
                        r6 = (int) sQLiteStatement2.simpleQueryForLong();
                        closeQuietly(sQLiteStatement2);
                    } catch (android.database.SQLException unused) {
                        closeQuietly(sQLiteStatement2);
                        r6 = 1;
                    } catch (Throwable th) {
                        closeQuietly(sQLiteStatement2);
                        throw th;
                    }
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(r6), str);
                    return r6;
                } catch (android.database.SQLException e) {
                    e = e;
                    sQLiteStatement2 = sQLiteStatement;
                    throw SupervisorKt.create("updating database failed: " + str, e);
                } catch (Throwable th2) {
                    th = th2;
                    closeQuietly(sQLiteStatement);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                sQLiteStatement = sQLiteStatement2;
            }
        } catch (android.database.SQLException e2) {
            e = e2;
        }
    }

    public static void closeQuietly(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement != null) {
            sQLiteStatement.close();
        }
    }
}
