package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes4.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.invokeOnTimeout(j, runnable, coroutineContext);
    }
}
