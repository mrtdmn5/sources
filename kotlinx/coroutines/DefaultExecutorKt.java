package kotlinx.coroutines;

import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt__SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: DefaultExecutor.kt */
/* loaded from: classes4.dex */
public final class DefaultExecutorKt {
    public static final Delay DefaultDelay;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String str;
        boolean z;
        Delay delay;
        int r1 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        try {
            str = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            z = Boolean.parseBoolean(str);
        } else {
            z = false;
        }
        if (!z) {
            delay = DefaultExecutor.INSTANCE;
        } else {
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.dispatcher;
            if (!(mainCoroutineDispatcher.getImmediate() instanceof MissingMainCoroutineDispatcher) && (mainCoroutineDispatcher instanceof Delay)) {
                delay = (Delay) mainCoroutineDispatcher;
            } else {
                delay = DefaultExecutor.INSTANCE;
            }
        }
        DefaultDelay = delay;
    }
}
