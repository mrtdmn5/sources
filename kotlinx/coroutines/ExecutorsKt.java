package kotlinx.coroutines;

import java.util.concurrent.Executor;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public final class ExecutorsKt {
    public static final ExecutorsKt INSTANCE = new ExecutorsKt();

    public static final ExecutorCoroutineDispatcherImpl from(Executor executor) {
        if (executor instanceof DispatcherExecutor) {
        }
        return new ExecutorCoroutineDispatcherImpl(executor);
    }
}
