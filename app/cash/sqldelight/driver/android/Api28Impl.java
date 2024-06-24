package app.cash.sqldelight.driver.android;

import android.database.AbstractWindowedCursor;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class Api28Impl {
    public static final void setWindowSize(AbstractWindowedCursor abstractWindowedCursor, long j) {
        Intrinsics.checkNotNullParameter(abstractWindowedCursor, "<this>");
        abstractWindowedCursor.setWindow(Api28Impl$$ExternalSyntheticApiModelOutline0.m(j));
    }
}
