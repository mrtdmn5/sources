package app.cash.sqldelight.driver.android;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class AndroidCursor implements SqlCursor {
    public final Cursor cursor;

    public AndroidCursor(Cursor cursor, Long l) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.cursor = cursor;
        if (Build.VERSION.SDK_INT >= 28 && l != null && (cursor instanceof AbstractWindowedCursor)) {
            Api28Impl.setWindowSize((AbstractWindowedCursor) cursor, l.longValue());
        }
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Boolean getBoolean(int r5) {
        boolean z;
        Cursor cursor = this.cursor;
        if (cursor.isNull(r5)) {
            return null;
        }
        if (cursor.getLong(r5) == 1) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Double getDouble(int r3) {
        Cursor cursor = this.cursor;
        if (cursor.isNull(r3)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(r3));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final Long getLong(int r3) {
        Cursor cursor = this.cursor;
        if (cursor.isNull(r3)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(r3));
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final String getString(int r3) {
        Cursor cursor = this.cursor;
        if (cursor.isNull(r3)) {
            return null;
        }
        return cursor.getString(r3);
    }

    @Override // app.cash.sqldelight.db.SqlCursor
    public final QueryResult.Value next() {
        return new QueryResult.Value(Boolean.valueOf(this.cursor.moveToNext()));
    }
}
