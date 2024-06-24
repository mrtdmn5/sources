package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class ConcurrencyHelpers$Handler28Impl {
    public static Handler createAsync(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}
