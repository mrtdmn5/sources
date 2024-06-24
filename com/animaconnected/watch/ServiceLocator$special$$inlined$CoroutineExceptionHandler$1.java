package com.animaconnected.watch;

import com.animaconnected.logger.LogKt;
import kotlin.ExceptionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public final class ServiceLocator$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public ServiceLocator$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key) {
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(final CoroutineContext coroutineContext, final Throwable th) {
        LogKt.err((Object) ServiceLocator.INSTANCE, "WatchlibMainScope", th, true, new Function0<String>() { // from class: com.animaconnected.watch.ServiceLocator$exceptionHandler$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unhandled exception from context " + CoroutineContext.this + ".Exception: " + th.getMessage() + " Stack trace: " + ExceptionsKt.stackTraceToString(th);
            }
        });
    }
}
