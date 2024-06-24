package kotlinx.coroutines.intrinsics;

import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.JobSupportKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* compiled from: Undispatched.kt */
/* loaded from: classes4.dex */
public final class UndispatchedKt {
    public static final Object startUndispatchedOrReturn(ScopeCoroutine scopeCoroutine, ScopeCoroutine scopeCoroutine2, Function2 function2) {
        Object completedExceptionally;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        try {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            completedExceptionally = function2.invoke(scopeCoroutine2, scopeCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally != coroutineSingletons && (makeCompletingOnce$kotlinx_coroutines_core = scopeCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (!(makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                return JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            throw ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
        }
        return coroutineSingletons;
    }
}
