package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* compiled from: DebugStrings.kt */
/* loaded from: classes4.dex */
public final class DebugStringsKt {
    public static final String getHexAddress(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String toDebugString(Continuation<?> continuation) {
        Object createFailure;
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            createFailure = continuation + '@' + getHexAddress(continuation);
        } catch (Throwable th) {
            createFailure = ResultKt.createFailure(th);
        }
        if (Result.m1661exceptionOrNullimpl(createFailure) != null) {
            createFailure = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) createFailure;
    }
}
