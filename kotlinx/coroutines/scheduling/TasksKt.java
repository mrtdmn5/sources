package kotlinx.coroutines.scheduling;

import androidx.core.content.res.CamUtils;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;

/* compiled from: Tasks.kt */
/* loaded from: classes4.dex */
public final class TasksKt {
    public static final TaskContextImpl BlockingContext;
    public static final int CORE_POOL_SIZE;
    public static final String DEFAULT_SCHEDULER_NAME;
    public static final long IDLE_WORKER_KEEP_ALIVE_NS;
    public static final int MAX_POOL_SIZE;
    public static final TaskContextImpl NonBlockingContext;
    public static final long WORK_STEALING_TIME_RESOLUTION_NS;
    public static final NanoTimeSource schedulerTimeSource;

    static {
        String str;
        int r1 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        DEFAULT_SCHEDULER_NAME = str;
        WORK_STEALING_TIME_RESOLUTION_NS = CamUtils.systemProp("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 1L, Long.MAX_VALUE);
        int r0 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        if (r0 < 2) {
            r0 = 2;
        }
        CORE_POOL_SIZE = CamUtils.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", r0, 1, 0, 8);
        MAX_POOL_SIZE = CamUtils.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(CamUtils.systemProp("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 1L, Long.MAX_VALUE));
        schedulerTimeSource = NanoTimeSource.INSTANCE;
        NonBlockingContext = new TaskContextImpl(0);
        BlockingContext = new TaskContextImpl(1);
    }
}
