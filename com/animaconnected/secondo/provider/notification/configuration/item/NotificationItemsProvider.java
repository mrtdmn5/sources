package com.animaconnected.secondo.provider.notification.configuration.item;

import android.content.Context;
import android.util.Log;
import com.animaconnected.secondo.provider.configuration.database.DatabaseHelper;
import java.sql.SQLException;

/* loaded from: classes3.dex */
public class NotificationItemsProvider {
    private static final String TAG = "NotificationItemsProvider";
    private static NotificationItemsProvider sInstance;
    private DatabaseHelper mDatabaseHelper;

    private NotificationItemsProvider(Context context) {
        try {
            this.mDatabaseHelper = new DatabaseHelper(new NotificationItemDbOpenHelper(context.getApplicationContext(), "notificationItems.db").getDao());
        } catch (SQLException e) {
            Log.e(TAG, "Couldn't open database", e);
        }
    }

    public static NotificationItemsProvider getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new NotificationItemsProvider(context);
        }
        return sInstance;
    }

    public DatabaseHelper getDatabaseHelper() {
        return this.mDatabaseHelper;
    }
}
