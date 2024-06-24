package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes3.dex */
public final class AndroidConnectionSource extends BaseConnectionSource {
    public static final Logger logger = LoggerFactory.getLogger(AndroidConnectionSource.class);
    public AndroidDatabaseConnection connection = null;
    public final SqliteAndroidDatabaseType databaseType = new SqliteAndroidDatabaseType();
    public final SQLiteOpenHelper helper;

    public AndroidConnectionSource(SQLiteOpenHelper sQLiteOpenHelper) {
        this.helper = sQLiteOpenHelper;
    }

    public final void clearSpecialConnection(DatabaseConnection databaseConnection) {
        ThreadLocal<BaseConnectionSource.NestedConnection> threadLocal = this.specialConnection;
        BaseConnectionSource.NestedConnection nestedConnection = threadLocal.get();
        Logger logger2 = logger;
        if (nestedConnection == null) {
            logger2.getClass();
            Level level = Level.ERROR;
            Object obj = Logger.UNKNOWN_ARG;
            logger2.logIfEnabled(level, null, "no connection has been saved when clear() called", obj, obj, obj, null);
            return;
        }
        DatabaseConnection databaseConnection2 = nestedConnection.connection;
        if (databaseConnection2 == databaseConnection) {
            int r11 = nestedConnection.nestedC - 1;
            nestedConnection.nestedC = r11;
            if (r11 == 0) {
                threadLocal.set(null);
                return;
            }
            return;
        }
        logger2.getClass();
        logger2.logIfEnabled(Level.ERROR, null, "connection saved {} is not the one being cleared {}", databaseConnection2, databaseConnection, Logger.UNKNOWN_ARG, null);
    }

    public final DatabaseConnection getReadWriteConnection() throws SQLException {
        DatabaseConnection databaseConnection;
        BaseConnectionSource.NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            databaseConnection = null;
        } else {
            databaseConnection = nestedConnection.connection;
        }
        if (databaseConnection != null) {
            return databaseConnection;
        }
        AndroidDatabaseConnection androidDatabaseConnection = this.connection;
        Logger logger2 = logger;
        SQLiteOpenHelper sQLiteOpenHelper = this.helper;
        if (androidDatabaseConnection == null) {
            try {
                SQLiteDatabase writableDatabase = sQLiteOpenHelper.getWritableDatabase();
                AndroidDatabaseConnection androidDatabaseConnection2 = new AndroidDatabaseConnection(writableDatabase, false);
                this.connection = androidDatabaseConnection2;
                logger2.trace("created connection {} for db {}, helper {}", androidDatabaseConnection2, writableDatabase, sQLiteOpenHelper);
            } catch (android.database.SQLException e) {
                throw SupervisorKt.create("Getting a writable database from helper " + sQLiteOpenHelper + " failed", e);
            }
        } else {
            logger2.trace("{}: returning read-write connection {}, helper {}", this, androidDatabaseConnection, sQLiteOpenHelper);
        }
        return this.connection;
    }

    public final boolean saveSpecialConnection(AndroidDatabaseConnection androidDatabaseConnection) throws SQLException {
        ThreadLocal<BaseConnectionSource.NestedConnection> threadLocal = this.specialConnection;
        BaseConnectionSource.NestedConnection nestedConnection = threadLocal.get();
        if (nestedConnection == null) {
            threadLocal.set(new BaseConnectionSource.NestedConnection(androidDatabaseConnection));
            return true;
        }
        DatabaseConnection databaseConnection = nestedConnection.connection;
        if (databaseConnection == androidDatabaseConnection) {
            nestedConnection.nestedC++;
            return false;
        }
        throw new SQLException("trying to save connection " + androidDatabaseConnection + " but already have saved connection " + databaseConnection);
    }

    public final String toString() {
        return "AndroidConnectionSource@" + Integer.toHexString(hashCode());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
