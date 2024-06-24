package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public final class HandlerDispatcherKt {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static volatile Choreographer choreographer;

    static {
        Object createFailure;
        try {
            createFailure = new HandlerContext(asHandler(Looper.getMainLooper()));
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (createFailure instanceof Result.Failure) {
            createFailure = null;
        }
    }

    public static final Handler asHandler(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
