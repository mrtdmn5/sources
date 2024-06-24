package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Executors.kt */
/* loaded from: classes4.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {
    static {
        CoroutineDispatcher.Key baseKey = CoroutineDispatcher.Key;
        Intrinsics.checkNotNullParameter(baseKey, "baseKey");
        ExecutorCoroutineDispatcher$Key$1 safeCast = new Function1<CoroutineContext.Element, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher$Key$1
            @Override // kotlin.jvm.functions.Function1
            public final ExecutorCoroutineDispatcher invoke(CoroutineContext.Element element) {
                CoroutineContext.Element element2 = element;
                if (element2 instanceof ExecutorCoroutineDispatcher) {
                    return (ExecutorCoroutineDispatcher) element2;
                }
                return null;
            }
        };
        Intrinsics.checkNotNullParameter(safeCast, "safeCast");
    }
}
