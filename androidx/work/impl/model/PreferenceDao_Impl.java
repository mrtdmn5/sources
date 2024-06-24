package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    public final RoomDatabase __db;
    public final AnonymousClass1 __insertionAdapterOfPreference;

    /* renamed from: androidx.work.impl.model.PreferenceDao_Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends EntityInsertionAdapter<Preference> {
        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement stmt, Preference value) {
            Preference preference = value;
            String str = preference.mKey;
            if (str == null) {
                stmt.bindNull(1);
            } else {
                stmt.bindString(1, str);
            }
            Long l = preference.mValue;
            if (l == null) {
                stmt.bindNull(2);
            } else {
                stmt.bindLong(2, l.longValue());
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }
    }

    public PreferenceDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPreference = new AnonymousClass1(__db);
    }

    public final Long getLongValue(final String key) {
        Long l;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(1, "SELECT long_value FROM Preference where `key`=?");
        acquire.bindString(1, key);
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(roomDatabase, acquire, false);
        try {
            if (query.moveToFirst() && !query.isNull(0)) {
                l = Long.valueOf(query.getLong(0));
                return l;
            }
            l = null;
            return l;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public final void insertPreference(final Preference preference) {
        RoomDatabase roomDatabase = this.__db;
        roomDatabase.assertNotSuspendingTransaction();
        roomDatabase.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert(preference);
            roomDatabase.setTransactionSuccessful();
        } finally {
            roomDatabase.endTransaction();
        }
    }
}
