package com.j256.ormlite.android;

import android.database.Cursor;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import java.io.Closeable;
import java.sql.SQLException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class AndroidDatabaseResults implements Closeable {
    public static final SqliteAndroidDatabaseType databaseType = new SqliteAndroidDatabaseType();
    public final HashMap columnNameMap;
    public final String[] columnNames;
    public final Cursor cursor;

    public AndroidDatabaseResults(Cursor cursor, boolean z) {
        this.cursor = cursor;
        String[] columnNames = cursor.getColumnNames();
        this.columnNames = columnNames;
        if (columnNames.length >= 8) {
            this.columnNameMap = new HashMap();
            int r3 = 0;
            while (true) {
                String[] strArr = this.columnNames;
                if (r3 < strArr.length) {
                    this.columnNameMap.put(strArr[r3], Integer.valueOf(r3));
                    r3++;
                } else {
                    return;
                }
            }
        } else {
            this.columnNameMap = null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.cursor.close();
    }

    public final char getChar(int r5) throws SQLException {
        String string = this.cursor.getString(r5);
        if (string == null || string.length() == 0) {
            return (char) 0;
        }
        if (string.length() == 1) {
            return string.charAt(0);
        }
        throw new SQLException(SubMenuBuilder$$ExternalSyntheticOutline0.m("More than 1 character stored in database column: ", r5));
    }

    public final String getString(int r2) {
        return this.cursor.getString(r2);
    }

    public final int lookupColumn(String str) {
        HashMap hashMap = this.columnNameMap;
        if (hashMap == null) {
            int r0 = 0;
            while (true) {
                String[] strArr = this.columnNames;
                if (r0 >= strArr.length) {
                    return -1;
                }
                if (strArr[r0].equals(str)) {
                    return r0;
                }
                r0++;
            }
        } else {
            Integer num = (Integer) hashMap.get(str);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
    }

    public final String toString() {
        return "AndroidDatabaseResults@" + Integer.toHexString(hashCode());
    }
}
