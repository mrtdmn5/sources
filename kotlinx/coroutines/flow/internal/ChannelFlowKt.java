package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: ChannelFlow.kt */
/* loaded from: classes4.dex */
public final class ChannelFlowKt {
    public static final <T, V> Object withContextUndispatched(CoroutineContext coroutineContext, V v, Object obj, Function2<? super V, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> frame) {
        Object updateThreadContext = ThreadContextKt.updateThreadContext(coroutineContext, obj);
        try {
            StackFrameContinuation stackFrameContinuation = new StackFrameContinuation(frame, coroutineContext);
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            Object invoke = function2.invoke(v, stackFrameContinuation);
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            if (invoke == CoroutineSingletons.COROUTINE_SUSPENDED) {
                Intrinsics.checkNotNullParameter(frame, "frame");
            }
            return invoke;
        } catch (Throwable th) {
            ThreadContextKt.restoreThreadContext(coroutineContext, updateThreadContext);
            throw th;
        }
    }
}
