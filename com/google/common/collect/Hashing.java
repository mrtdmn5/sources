package com.google.common.collect;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1;
import androidx.lifecycle.LifecycleOwner;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;

/* loaded from: classes3.dex */
public final class Hashing {
    public static final void access$log(Logger logger, Task task, TaskQueue taskQueue, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(taskQueue.name);
        sb.append(' ');
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(task.name);
        logger.fine(sb.toString());
    }

    public static final String formatDuration(long j) {
        String str;
        if (j <= -999500000) {
            str = ((j - 500000000) / 1000000000) + " s ";
        } else if (j <= -999500) {
            str = ((j - 500000) / 1000000) + " ms";
        } else if (j <= 0) {
            str = ((j - 500) / 1000) + " µs";
        } else if (j < 999500) {
            str = ((j + 500) / 1000) + " µs";
        } else if (j < 999500000) {
            str = ((j + 500000) / 1000000) + " ms";
        } else {
            str = ((j + 500000000) / 1000000000) + " s ";
        }
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public static final LifecycleCoroutineScopeImpl getLifecycleScope(LifecycleOwner lifecycleOwner) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        boolean z;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullParameter(lifecycle, "<this>");
        while (true) {
            AtomicReference<Object> atomicReference = lifecycle.internalScopeRef;
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) atomicReference.get();
            if (lifecycleCoroutineScopeImpl != null) {
                break;
            }
            SupervisorJobImpl SupervisorJob$default = SupervisorKt.SupervisorJob$default();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(lifecycle, SupervisorJob$default.plus(MainDispatcherLoader.dispatcher.getImmediate()));
            while (true) {
                if (atomicReference.compareAndSet(null, lifecycleCoroutineScopeImpl)) {
                    z = true;
                    break;
                }
                if (atomicReference.get() != null) {
                    z = false;
                    break;
                }
            }
            if (z) {
                DefaultScheduler defaultScheduler2 = Dispatchers.Default;
                BuildersKt.launch$default(lifecycleCoroutineScopeImpl, MainDispatcherLoader.dispatcher.getImmediate(), null, new LifecycleCoroutineScopeImpl$register$1(lifecycleCoroutineScopeImpl, null), 2);
                break;
            }
        }
        return lifecycleCoroutineScopeImpl;
    }

    public static int smear(int r4) {
        return (int) (Integer.rotateLeft((int) (r4 * (-862048943)), 15) * 461845907);
    }
}
