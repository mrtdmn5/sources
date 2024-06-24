package androidx.room.migration;

import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* loaded from: classes.dex */
public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int r1, int r2) {
        this.startVersion = r1;
        this.endVersion = r2;
    }

    public abstract void migrate(FrameworkSQLiteDatabase frameworkSQLiteDatabase);
}
