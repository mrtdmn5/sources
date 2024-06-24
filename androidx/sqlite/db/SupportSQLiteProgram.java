package androidx.sqlite.db;

import java.io.Closeable;

/* compiled from: SupportSQLiteProgram.kt */
/* loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int r1, byte[] bArr);

    void bindDouble(int r1, double d);

    void bindLong(int r1, long j);

    void bindNull(int r1);

    void bindString(int r1, String str);
}
