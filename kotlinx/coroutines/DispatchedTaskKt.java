package kotlinx.coroutines;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedTask.kt */
/* loaded from: classes4.dex */
public final class DispatchedTaskKt {
    public static final <T> void resume(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object successfulResult$kotlinx_coroutines_core;
        UndispatchedCoroutine<?> undispatchedCoroutine;
        boolean clearThreadContext;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            successfulResult$kotlinx_coroutines_core = ResultKt.createFailure(exceptionalResult$kotlinx_coroutines_core);
        } else {
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        if (z) {
            Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.continuation;
            CoroutineContext context = continuation2.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            if (updateThreadContext != ThreadContextKt.NO_THREAD_ELEMENTS) {
                undispatchedCoroutine = CoroutineContextKt.updateUndispatchedCompletion(continuation2, context, updateThreadContext);
            } else {
                undispatchedCoroutine = null;
            }
            try {
                dispatchedContinuation.continuation.resumeWith(successfulResult$kotlinx_coroutines_core);
                Unit unit = Unit.INSTANCE;
                if (undispatchedCoroutine != null) {
                    if (!clearThreadContext) {
                        return;
                    }
                }
                return;
            } finally {
                if (undispatchedCoroutine == null || undispatchedCoroutine.clearThreadContext()) {
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
            }
        }
        continuation.resumeWith(successfulResult$kotlinx_coroutines_core);
    }
}
