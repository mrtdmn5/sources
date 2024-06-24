package io.ktor.util;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes3.dex */
public final class CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    public CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1() {
        super(CoroutineExceptionHandler.Key.$$INSTANCE);
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public final void handleException(CoroutineContext coroutineContext, Throwable th) {
    }
}
