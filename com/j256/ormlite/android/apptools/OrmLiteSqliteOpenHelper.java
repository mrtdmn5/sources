package com.j256.ormlite.android.apptools;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.lifecycle.SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.AndroidDatabaseConnection;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.logger.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.DatabaseTableConfigLoader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public abstract class OrmLiteSqliteOpenHelper extends SQLiteOpenHelper {
    protected static Logger logger = LoggerFactory.getLogger(OrmLiteSqliteOpenHelper.class);
    protected boolean cancelQueriesEnabled;
    protected AndroidConnectionSource connectionSource;
    private volatile boolean isOpen;

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int r4) {
        super(context, str, cursorFactory, r4);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        logger.trace(this, this.connectionSource, "{}: constructed connectionSource {}");
    }

    private static InputStream openFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Could not open config file " + file, e);
        }
    }

    private static InputStream openFileId(Context context, int r2) {
        InputStream openRawResource = context.getResources().openRawResource(r2);
        if (openRawResource != null) {
            return openRawResource;
        }
        throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Could not find object config file with id ", r2));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.connectionSource.getClass();
        this.isOpen = false;
    }

    public ConnectionSource getConnectionSource() {
        if (!this.isOpen) {
            Logger logger2 = logger;
            IllegalStateException illegalStateException = new IllegalStateException();
            logger2.getClass();
            Level level = Level.WARNING;
            Object obj = Logger.UNKNOWN_ARG;
            logger2.logIfEnabled(level, illegalStateException, "Getting connectionSource was called after closed", obj, obj, obj, null);
        }
        return this.connectionSource;
    }

    public <D extends Dao<T, ?>, T> D getDao(Class<T> cls) throws SQLException {
        return (D) DaoManager.createDao(getConnectionSource(), cls);
    }

    public <D extends RuntimeExceptionDao<T, ?>, T> D getRuntimeExceptionDao(Class<T> cls) {
        try {
            return (D) new RuntimeExceptionDao(getDao(cls));
        } catch (SQLException e) {
            throw new RuntimeException(SavedStateViewModelFactoryKt$$ExternalSyntheticOutline0.m("Could not create RuntimeExcepitionDao for class ", cls), e);
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        boolean z;
        DatabaseConnection databaseConnection;
        BaseConnectionSource baseConnectionSource = (BaseConnectionSource) getConnectionSource();
        BaseConnectionSource.NestedConnection nestedConnection = baseConnectionSource.specialConnection.get();
        DatabaseConnection databaseConnection2 = nestedConnection == null ? null : nestedConnection.connection;
        if (databaseConnection2 == null) {
            AndroidDatabaseConnection androidDatabaseConnection = new AndroidDatabaseConnection(sQLiteDatabase, this.cancelQueriesEnabled);
            try {
                ((AndroidConnectionSource) baseConnectionSource).saveSpecialConnection(androidDatabaseConnection);
                z = true;
                databaseConnection = androidDatabaseConnection;
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
            databaseConnection = databaseConnection2;
        }
        try {
            onCreate(sQLiteDatabase, baseConnectionSource);
        } finally {
            if (z) {
                ((AndroidConnectionSource) baseConnectionSource).clearSpecialConnection(databaseConnection);
            }
        }
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource);

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int r5, int r6) {
        boolean z;
        DatabaseConnection databaseConnection;
        BaseConnectionSource baseConnectionSource = (BaseConnectionSource) getConnectionSource();
        BaseConnectionSource.NestedConnection nestedConnection = baseConnectionSource.specialConnection.get();
        DatabaseConnection databaseConnection2 = nestedConnection == null ? null : nestedConnection.connection;
        if (databaseConnection2 == null) {
            AndroidDatabaseConnection androidDatabaseConnection = new AndroidDatabaseConnection(sQLiteDatabase, this.cancelQueriesEnabled);
            try {
                ((AndroidConnectionSource) baseConnectionSource).saveSpecialConnection(androidDatabaseConnection);
                z = true;
                databaseConnection = androidDatabaseConnection;
            } catch (SQLException e) {
                throw new IllegalStateException("Could not save special connection", e);
            }
        } else {
            z = false;
            databaseConnection = databaseConnection2;
        }
        try {
            onUpgrade(sQLiteDatabase, baseConnectionSource, r5, r6);
        } finally {
            if (z) {
                ((AndroidConnectionSource) baseConnectionSource).clearSpecialConnection(databaseConnection);
            }
        }
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int r3, int r4);

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int r4, DatabaseErrorHandler databaseErrorHandler) {
        super(context, str, cursorFactory, r4, databaseErrorHandler);
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        logger.trace(this, this.connectionSource, "{}: constructed connectionSource {}");
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int r10, int r11) {
        this(context, str, cursorFactory, r10, openFileId(context, r11));
    }

    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int r10, File file) {
        this(context, str, cursorFactory, r10, openFile(file));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.Closeable, java.io.BufferedReader] */
    public OrmLiteSqliteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int r4, InputStream inputStream) {
        super(context, str, cursorFactory, r4);
        Throwable th;
        ?? r2;
        SQLException e;
        this.connectionSource = new AndroidConnectionSource(this);
        this.isOpen = true;
        if (inputStream == null) {
            return;
        }
        InputStream inputStream2 = null;
        try {
            try {
                r2 = new BufferedReader(new InputStreamReader(inputStream), 4096);
                try {
                    DaoManager.addCachedDatabaseConfigs(DatabaseTableConfigLoader.loadDatabaseConfigFromReader(r2));
                    IOUtils.closeQuietly(r2);
                } catch (SQLException e2) {
                    e = e2;
                    inputStream = null;
                    inputStream2 = r2;
                    throw new IllegalStateException("Could not load object config file", e);
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(r2);
                    IOUtils.closeQuietly(inputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                r2 = inputStream2;
                inputStream2 = inputStream;
            }
        } catch (SQLException e3) {
            e = e3;
        }
    }
}
