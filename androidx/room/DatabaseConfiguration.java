package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final String name;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    public DatabaseConfiguration(Context context, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer, ArrayList arrayList, boolean z, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z2, boolean z3) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = arrayList;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
    }

    public final boolean isMigrationRequired(int r3, int r4) {
        boolean z;
        if (r3 > r4) {
            z = true;
        } else {
            z = false;
        }
        if ((!z || !this.allowDestructiveMigrationOnDowngrade) && this.requireMigration) {
            return true;
        }
        return false;
    }
}
