package com.animaconnected.secondo.provider.configuration.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class DbOpenHelper extends OrmLiteSqliteOpenHelper {
    private Dao<ConfigurationItem, Integer> mConfigurationItem;

    public DbOpenHelper(Context context, String str, int r4) {
        super(context, str, null, r4);
        this.mConfigurationItem = null;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper, android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.mConfigurationItem = null;
    }

    public Dao<ConfigurationItem, Integer> getDao() throws SQLException {
        if (this.mConfigurationItem == null) {
            this.mConfigurationItem = getDao(ConfigurationItem.class);
        }
        return this.mConfigurationItem;
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.i(DbOpenHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, ConfigurationItem.class);
        } catch (SQLException e) {
            Log.e(DbOpenHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int r3, int r4) {
    }
}
