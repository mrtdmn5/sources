package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadContextKt {
    public static final Symbol NO_THREAD_ELEMENTS = new Symbol("NO_THREAD_ELEMENTS");
    public static final ThreadContextKt$countAll$1 countAll = ThreadContextKt$countAll$1.INSTANCE;
    public static final ThreadContextKt$findOne$1 findOne = ThreadContextKt$findOne$1.INSTANCE;
    public static final ThreadContextKt$updateState$1 updateState = ThreadContextKt$updateState$1.INSTANCE;

    public static final void restoreThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == NO_THREAD_ELEMENTS) {
            return;
        }
        if (obj instanceof ThreadState) {
            ThreadState threadState = (ThreadState) obj;
            ThreadContextElement<Object>[] threadContextElementArr = threadState.elements;
            int length = threadContextElementArr.length - 1;
            if (length < 0) {
                return;
            }
            while (true) {
                int r1 = length - 1;
                ThreadContextElement<Object> threadContextElement = threadContextElementArr[length];
                Intrinsics.checkNotNull(threadContextElement);
                threadContextElement.restoreThreadContext(threadState.values[length]);
                if (r1 >= 0) {
                    length = r1;
                } else {
                    return;
                }
            }
        } else {
            Object fold = coroutineContext.fold(null, findOne);
            Intrinsics.checkNotNull(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            ((ThreadContextElement) fold).restoreThreadContext(obj);
        }
    }

    public static final Object threadContextElements(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, countAll);
        Intrinsics.checkNotNull(fold);
        return fold;
    }

    public static final Object updateThreadContext(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = threadContextElements(coroutineContext);
        }
        if (obj == 0) {
            return NO_THREAD_ELEMENTS;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(coroutineContext, ((Number) obj).intValue()), updateState);
        }
        return ((ThreadContextElement) obj).updateThreadContext(coroutineContext);
    }
}
