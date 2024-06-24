package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContextElement.kt */
/* loaded from: classes4.dex */
public interface ThreadContextElement<S> extends CoroutineContext.Element {
    void restoreThreadContext(Object obj);

    S updateThreadContext(CoroutineContext coroutineContext);
}
