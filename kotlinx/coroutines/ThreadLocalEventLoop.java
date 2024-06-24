package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes4.dex */
public final class ThreadLocalEventLoop {
    public static final ThreadLocal<EventLoop> ref = new ThreadLocal<>();

    public static EventLoop getEventLoop$kotlinx_coroutines_core() {
        ThreadLocal<EventLoop> threadLocal = ref;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop == null) {
            BlockingEventLoop blockingEventLoop = new BlockingEventLoop(Thread.currentThread());
            threadLocal.set(blockingEventLoop);
            return blockingEventLoop;
        }
        return eventLoop;
    }
}
