package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadState {
    public final CoroutineContext context;
    public final ThreadContextElement<Object>[] elements;
    public int i;
    public final Object[] values;

    public ThreadState(CoroutineContext coroutineContext, int r2) {
        this.context = coroutineContext;
        this.values = new Object[r2];
        this.elements = new ThreadContextElement[r2];
    }
}
