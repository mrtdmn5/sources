package androidx.sqlite.db;

import android.database.Cursor;
import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.io.Closeable;

/* compiled from: SupportSQLiteDatabase.kt */
/* loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    FrameworkSQLiteStatement compileStatement(String str);

    void endTransaction();

    void execSQL(String str) throws SQLException;

    boolean inTransaction();

    boolean isOpen();

    Cursor query(SupportSQLiteQuery supportSQLiteQuery);

    void setTransactionSuccessful();
}
