package kotlinx.coroutines;

import kotlinx.coroutines.EventLoopImplBase;

/* compiled from: EventLoop.kt */
/* loaded from: classes4.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    public abstract Thread getThread();

    public void reschedule(long j, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(j, delayedTask);
    }
}
