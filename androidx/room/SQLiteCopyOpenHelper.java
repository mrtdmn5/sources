package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper {
    public DatabaseConfiguration mDatabaseConfiguration;
    public boolean mVerified;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        throw null;
    }

    public final void copyDatabaseFile(File file) throws IOException {
        throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final String getDatabaseName() {
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final synchronized SupportSQLiteDatabase getWritableDatabase() {
        if (!this.mVerified) {
            verifyDatabaseFile();
            this.mVerified = true;
        }
        throw null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z) {
        throw null;
    }

    public final void verifyDatabaseFile() {
        getDatabaseName();
        throw null;
    }
}
