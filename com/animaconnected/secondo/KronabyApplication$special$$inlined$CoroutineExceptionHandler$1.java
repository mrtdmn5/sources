package com.animaconnected.secondo;

import com.animaconnected.logger.LogKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes.dex */
public final class KronabyApplication$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public KronabyApplication$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key) {
        super(key);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(final CoroutineContext coroutineContext, Throwable th) {
        LogKt.err((Object) KronabyApplication.Companion, "KronabyApplication", th, true, new Function0<String>() { // from class: com.animaconnected.secondo.KronabyApplication$Companion$exceptionHandler$1$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Unhandled exception from context " + CoroutineContext.this;
            }
        });
        throw th;
    }
}
