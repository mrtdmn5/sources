package com.animaconnected.secondo.provider.notification.configuration.item;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.animaconnected.secondo.provider.configuration.database.ConfigurationItem;
import com.animaconnected.secondo.provider.configuration.database.DbOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/* loaded from: classes3.dex */
class NotificationItemDbOpenHelper extends DbOpenHelper {
    private static final int DATABASE_VERSION = 6;
    private static final String TAG = "com.animaconnected.secondo.provider.notification.configuration.item.NotificationItemDbOpenHelper";

    public NotificationItemDbOpenHelper(Context context, String str) {
        super(context, str, 6);
    }

    @Override // com.animaconnected.secondo.provider.configuration.database.DbOpenHelper, com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            Log.d(TAG, "Creating database");
            TableUtils.createTable(connectionSource, ConfigurationItem.class);
            Dao<ConfigurationItem, Integer> dao = getDao();
            dao.create(new ConfigurationItem(1, 0, null, -1, -1));
            dao.create(new ConfigurationItem(0, 1, null, -1, -1));
            dao.create(new ConfigurationItem(9, 1, null, -1, -1));
            dao.create(new ConfigurationItem(3, 1, null, -1, -1));
            dao.create(new ConfigurationItem(5, 1, null, -1, -1));
            dao.create(new ConfigurationItem(6, 1, null, -1, -1));
            dao.create(new ConfigurationItem(7, 1, null, -1, -1));
            dao.create(new ConfigurationItem(10, 1, null, -1, -1));
            dao.create(new ConfigurationItem(8, 2, null, -1, -1));
            dao.create(new ConfigurationItem(11, 1, null, -1, -1));
            dao.create(new ConfigurationItem(12, 1, null, -1, -1));
        } catch (SQLException e) {
            Log.e(TAG, "Error creating database", e);
            throw new RuntimeException(e);
        }
    }

    @Override // com.animaconnected.secondo.provider.configuration.database.DbOpenHelper, com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int r9, int r10) {
        try {
            if (r10 == 2) {
                getDao().create(new ConfigurationItem(8, 2, null, -1, -1));
            } else if (r10 == 3) {
                getDao().create(new ConfigurationItem(9, 1, null, -1, -1));
            } else if (r10 == 4) {
                getDao().create(new ConfigurationItem(10, 1, null, -1, -1));
            } else if (r10 == 5) {
                getDao().create(new ConfigurationItem(11, 1, null, -1, -1));
            } else if (r10 == 6) {
                getDao().create(new ConfigurationItem(12, 1, null, -1, -1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
