package kotlinx.coroutines.internal;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    public final Throwable cause = null;
    public final String errorHint;

    public MissingMainCoroutineDispatcher(String str) {
        this.errorHint = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        missing();
        throw null;
    }

    @Override // kotlinx.coroutines.Delay
    public final DisposableHandle invokeOnTimeout(long j, Runnable runnable, CoroutineContext coroutineContext) {
        missing();
        throw null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        missing();
        throw null;
    }

    public final void missing() {
        String str;
        Throwable th = this.cause;
        if (th != null) {
            String str2 = this.errorHint;
            if (str2 == null || (str = ". ".concat(str2)) == null) {
                str = "";
            }
            throw new IllegalStateException("Module with the Main dispatcher had failed to initialize".concat(str), th);
        }
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @Override // kotlinx.coroutines.Delay
    public final void scheduleResumeAfterDelay(long j, CancellableContinuationImpl cancellableContinuationImpl) {
        missing();
        throw null;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dispatchers.Main[missing");
        Throwable th = this.cause;
        if (th != null) {
            str = ", cause=" + th;
        } else {
            str = "";
        }
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, str, ']');
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public final MainCoroutineDispatcher getImmediate() {
        return this;
    }
}
