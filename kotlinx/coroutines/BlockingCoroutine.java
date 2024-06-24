package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Builders.kt */
/* loaded from: classes4.dex */
public final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    public final Thread blockedThread;
    public final EventLoop eventLoop;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void afterCompletion(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.blockedThread;
        if (!Intrinsics.areEqual(currentThread, thread)) {
            LockSupport.unpark(thread);
        }
    }
}
