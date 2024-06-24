package com.animaconnected.secondo.notification.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "notification.db";
    private static final int DATABASE_VERSION = 4;
    private Dao<Contact, String> mContactDao;
    private Dao<ImportantApp, String> mImpAppDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
        this.mContactDao = null;
        this.mImpAppDao = null;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        this.mContactDao = null;
        this.mImpAppDao = null;
        super.close();
    }

    public Dao<Contact, String> getContactDao() throws SQLException {
        if (this.mContactDao == null) {
            this.mContactDao = getDao(Contact.class);
        }
        return this.mContactDao;
    }

    public Dao<ImportantApp, String> getImpAppDao() throws SQLException {
        if (this.mImpAppDao == null) {
            this.mImpAppDao = getDao(ImportantApp.class);
        }
        return this.mImpAppDao;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Contact.class);
            TableUtils.createTable(connectionSource, ImportantApp.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int r4, int r5) {
        try {
            if (r5 == 4) {
                TableUtils.dropTable(connectionSource, ImportantApp.class);
                TableUtils.createTable(connectionSource, ImportantApp.class);
            } else {
                TableUtils.dropTable(connectionSource, Contact.class);
                TableUtils.dropTable(connectionSource, ImportantApp.class);
                onCreate(sQLiteDatabase, connectionSource);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
