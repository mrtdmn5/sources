package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.j256.ormlite.android.compat.ApiCompatibilityUtils;
import com.j256.ormlite.android.compat.JellyBeanApiCompatibility;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class AndroidCompiledStatement implements CompiledStatement {
    public ArrayList args;
    public final boolean cacheStore;
    public final boolean cancelQueriesEnabled;
    public JellyBeanApiCompatibility.JellyBeanCancellationHook cancellationHook;
    public Cursor cursor;
    public final SQLiteDatabase db;
    public Integer max;
    public final String sql;
    public final StatementBuilder.StatementType type;
    public static final Logger logger = LoggerFactory.getLogger(AndroidCompiledStatement.class);
    public static final String[] NO_STRING_ARGS = new String[0];
    public static final JellyBeanApiCompatibility apiCompatibility = ApiCompatibilityUtils.compatibility;

    /* renamed from: com.j256.ormlite.android.AndroidCompiledStatement$1 */
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
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 13;
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

    public AndroidCompiledStatement(String str, SQLiteDatabase sQLiteDatabase, StatementBuilder.StatementType statementType, boolean z, boolean z2) {
        this.sql = str;
        this.db = sQLiteDatabase;
        this.type = statementType;
        this.cancelQueriesEnabled = z;
        this.cacheStore = z2;
    }

    public static int execSql(SQLiteDatabase sQLiteDatabase, String str, String str2, Object[] objArr) throws SQLException {
        int r2;
        try {
            sQLiteDatabase.execSQL(str2, objArr);
            SQLiteStatement sQLiteStatement = null;
            try {
                sQLiteStatement = sQLiteDatabase.compileStatement("SELECT CHANGES()");
                r2 = (int) sQLiteStatement.simpleQueryForLong();
                sQLiteStatement.close();
            } catch (android.database.SQLException unused) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                r2 = 1;
            } catch (Throwable th) {
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                throw th;
            }
            logger.trace("executing statement {} changed {} rows: {}", str, Integer.valueOf(r2), str2);
            return r2;
        } catch (android.database.SQLException e) {
            throw SupervisorKt.create("Problems executing " + str + " Android statement: " + str2, e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        Cursor cursor = this.cursor;
        if (cursor != null && !cursor.isClosed()) {
            try {
                this.cursor.close();
            } catch (android.database.SQLException e) {
                throw new IOException("Problems closing Android cursor", e);
            }
        }
        this.cancellationHook = null;
    }

    public final int runExecute() throws SQLException {
        Object[] array;
        StatementBuilder.StatementType statementType = this.type;
        if (statementType.isOkForExecute()) {
            ArrayList arrayList = this.args;
            if (arrayList == null) {
                array = NO_STRING_ARGS;
            } else {
                array = arrayList.toArray(new Object[arrayList.size()]);
            }
            return execSql(this.db, "runExecute", this.sql, array);
        }
        throw new IllegalArgumentException("Cannot call execute on a " + statementType + " statement");
    }

    public final AndroidDatabaseResults runQuery() throws SQLException {
        String[] strArr;
        Cursor rawQuery;
        StatementBuilder.StatementType statementType = this.type;
        if (statementType.isOkForQuery()) {
            if (this.cursor == null) {
                String str = null;
                try {
                    Integer num = this.max;
                    String str2 = this.sql;
                    if (num == null) {
                        str = str2;
                    } else {
                        str = str2 + " LIMIT " + this.max;
                    }
                    boolean z = this.cancelQueriesEnabled;
                    JellyBeanApiCompatibility jellyBeanApiCompatibility = apiCompatibility;
                    if (z) {
                        jellyBeanApiCompatibility.getClass();
                        this.cancellationHook = new JellyBeanApiCompatibility.JellyBeanCancellationHook();
                    }
                    SQLiteDatabase sQLiteDatabase = this.db;
                    ArrayList arrayList = this.args;
                    if (arrayList == null) {
                        strArr = NO_STRING_ARGS;
                    } else {
                        strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    }
                    JellyBeanApiCompatibility.JellyBeanCancellationHook jellyBeanCancellationHook = this.cancellationHook;
                    jellyBeanApiCompatibility.getClass();
                    if (jellyBeanCancellationHook == null) {
                        rawQuery = sQLiteDatabase.rawQuery(str, strArr);
                    } else {
                        rawQuery = sQLiteDatabase.rawQuery(str, strArr, jellyBeanCancellationHook.cancellationSignal);
                    }
                    this.cursor = rawQuery;
                    rawQuery.moveToFirst();
                    logger.trace(this, str, "{}: started rawQuery cursor for: {}");
                } catch (android.database.SQLException e) {
                    throw SupervisorKt.create("Problems executing Android query: " + str, e);
                }
            }
            return new AndroidDatabaseResults(this.cursor, this.cacheStore);
        }
        throw new IllegalArgumentException("Cannot call query on a " + statementType + " statement");
    }

    public final int runUpdate() throws SQLException {
        Object[] array;
        StatementBuilder.StatementType statementType = this.type;
        if (statementType.isOkForUpdate()) {
            Integer num = this.max;
            String str = this.sql;
            if (num != null) {
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, " ");
                m.append(this.max);
                str = m.toString();
            }
            ArrayList arrayList = this.args;
            if (arrayList == null) {
                array = NO_STRING_ARGS;
            } else {
                array = arrayList.toArray(new Object[arrayList.size()]);
            }
            return execSql(this.db, "runUpdate", str, array);
        }
        throw new IllegalArgumentException("Cannot call update on a " + statementType + " statement");
    }

    public final void setObject(int r3, Object obj, SqlType sqlType) throws SQLException {
        if (this.cursor == null) {
            if (this.args == null) {
                this.args = new ArrayList();
            }
            if (obj == null) {
                this.args.add(r3, null);
                return;
            }
            switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    this.args.add(r3, obj.toString());
                    return;
                case 12:
                case 13:
                    this.args.add(r3, obj);
                    return;
                case 14:
                case 15:
                    throw new SQLException("Invalid Android type: " + sqlType);
                default:
                    throw new SQLException("Unknown sql argument type: " + sqlType);
            }
        }
        throw new SQLException("Query already run. Cannot add argument values.");
    }

    public final String toString() {
        return this.sql;
    }
}
