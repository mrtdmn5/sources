package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadContextKt$updateState$1 extends Lambda implements Function2<ThreadState, CoroutineContext.Element, ThreadState> {
    public static final ThreadContextKt$updateState$1 INSTANCE = new ThreadContextKt$updateState$1();

    public ThreadContextKt$updateState$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ThreadState invoke(ThreadState threadState, CoroutineContext.Element element) {
        ThreadState threadState2 = threadState;
        CoroutineContext.Element element2 = element;
        if (element2 instanceof ThreadContextElement) {
            ThreadContextElement<Object> threadContextElement = (ThreadContextElement) element2;
            Object updateThreadContext = threadContextElement.updateThreadContext(threadState2.context);
            int r1 = threadState2.i;
            threadState2.values[r1] = updateThreadContext;
            threadState2.i = r1 + 1;
            threadState2.elements[r1] = threadContextElement;
        }
        return threadState2;
    }
}
