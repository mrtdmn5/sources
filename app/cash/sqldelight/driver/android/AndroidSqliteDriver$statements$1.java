package app.cash.sqldelight.driver.android;

import android.util.LruCache;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidSqliteDriver.kt */
/* loaded from: classes.dex */
public final class AndroidSqliteDriver$statements$1 extends LruCache<Integer, AndroidStatement> {
    @Override // android.util.LruCache
    public final void entryRemoved(boolean z, Integer num, AndroidStatement androidStatement, AndroidStatement androidStatement2) {
        num.intValue();
        AndroidStatement oldValue = androidStatement;
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        if (z) {
            oldValue.close();
        }
    }
}
