package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.core.os.HandlerCompat;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidUiDispatcher.android.kt */
/* loaded from: classes.dex */
public final class AndroidUiDispatcher$Companion$currentThread$1 extends ThreadLocal<CoroutineContext> {
    @Override // java.lang.ThreadLocal
    public final CoroutineContext initialValue() {
        Choreographer choreographer = Choreographer.getInstance();
        Intrinsics.checkNotNullExpressionValue(choreographer, "getInstance()");
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            Handler createAsync = HandlerCompat.createAsync(myLooper);
            Intrinsics.checkNotNullExpressionValue(createAsync, "createAsync(\n           …d\")\n                    )");
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, createAsync);
            return androidUiDispatcher.plus(androidUiDispatcher.frameClock);
        }
        throw new IllegalStateException("no Looper on this thread".toString());
    }
}
