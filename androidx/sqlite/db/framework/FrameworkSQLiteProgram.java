package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FrameworkSQLiteProgram.kt */
/* loaded from: classes.dex */
public class FrameworkSQLiteProgram implements SupportSQLiteProgram {
    public final SQLiteProgram delegate;

    public FrameworkSQLiteProgram(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindBlob(int r2, byte[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.bindBlob(r2, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindDouble(int r2, double d) {
        this.delegate.bindDouble(r2, d);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindLong(int r2, long j) {
        this.delegate.bindLong(r2, j);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindNull(int r2) {
        this.delegate.bindNull(r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public final void bindString(int r2, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.delegate.bindString(r2, value);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.delegate.close();
    }
}
