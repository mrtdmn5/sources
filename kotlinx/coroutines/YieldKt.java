package kotlinx.coroutines;

import com.google.gson.internal.ObjectConstructor;
import java.util.ArrayList;

/* compiled from: Yield.kt */
/* loaded from: classes4.dex */
public final class YieldKt implements ObjectConstructor {
    public static final float lerp(float f, float f2, float f3) {
        return (f3 * f2) + ((1 - f3) * f);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object yield(kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            kotlin.coroutines.CoroutineContext r0 = r6.getContext()
            kotlinx.coroutines.JobKt.ensureActive(r0)
            kotlin.coroutines.Continuation r6 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r6)
            boolean r1 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            r2 = 0
            if (r1 == 0) goto L13
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            goto L14
        L13:
            r6 = r2
        L14:
            if (r6 != 0) goto L1a
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L86
        L1a:
            kotlinx.coroutines.CoroutineDispatcher r1 = r6.dispatcher
            boolean r3 = r1.isDispatchNeeded(r0)
            r4 = 1
            if (r3 == 0) goto L2d
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r6._state = r2
            r6.resumeMode = r4
            r1.dispatchYield(r0, r6)
            goto L84
        L2d:
            kotlinx.coroutines.YieldContext r3 = new kotlinx.coroutines.YieldContext
            r3.<init>()
            kotlin.coroutines.CoroutineContext r0 = r0.plus(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r6._state = r5
            r6.resumeMode = r4
            r1.dispatchYield(r0, r6)
            boolean r0 = r3.dispatcherWasUnconfined
            if (r0 == 0) goto L84
            kotlinx.coroutines.EventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.getEventLoop$kotlinx_coroutines_core()
            kotlin.collections.ArrayDeque<kotlinx.coroutines.DispatchedTask<?>> r1 = r0.unconfinedQueue
            if (r1 == 0) goto L50
            boolean r1 = r1.isEmpty()
            goto L51
        L50:
            r1 = r4
        L51:
            if (r1 == 0) goto L54
            goto L76
        L54:
            boolean r1 = r0.isUnconfinedLoopActive()
            if (r1 == 0) goto L62
            r6._state = r5
            r6.resumeMode = r4
            r0.dispatchUnconfined(r6)
            goto L77
        L62:
            r0.incrementUseCount(r4)
            r6.run()     // Catch: java.lang.Throwable -> L6f
        L68:
            boolean r1 = r0.processUnconfinedEvent()     // Catch: java.lang.Throwable -> L6f
            if (r1 != 0) goto L68
            goto L73
        L6f:
            r1 = move-exception
            r6.handleFatalException$kotlinx_coroutines_core(r1, r2)     // Catch: java.lang.Throwable -> L7f
        L73:
            r0.decrementUseCount(r4)
        L76:
            r4 = 0
        L77:
            if (r4 == 0) goto L7c
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            goto L86
        L7c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            goto L86
        L7f:
            r6 = move-exception
            r0.decrementUseCount(r4)
            throw r6
        L84:
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
        L86:
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r6 != r0) goto L8b
            return r6
        L8b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.YieldKt.yield(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return new ArrayList();
    }
}
