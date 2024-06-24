package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* compiled from: CoroutineScope.kt */
/* loaded from: classes4.dex */
public final class CoroutineScopeKt {
    public static final ContextScope CoroutineScope(CoroutineContext coroutineContext) {
        if (coroutineContext.get(Job.Key.$$INSTANCE) == null) {
            coroutineContext = coroutineContext.plus(JobKt.Job$default());
        }
        return new ContextScope(coroutineContext);
    }

    public static final void cancel(CoroutineScope coroutineScope, CancellationException cancellationException) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        int r1 = Job.$r8$clinit;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            job.cancel(cancellationException);
        } else {
            throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
        }
    }

    public static final <R> Object coroutineScope(Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        ScopeCoroutine scopeCoroutine = new ScopeCoroutine(continuation, continuation.getContext());
        Object startUndispatchedOrReturn = UndispatchedKt.startUndispatchedOrReturn(scopeCoroutine, scopeCoroutine, function2);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return startUndispatchedOrReturn;
    }

    public static final boolean isActive(CoroutineScope coroutineScope) {
        CoroutineContext coroutineContext = coroutineScope.getCoroutineContext();
        int r0 = Job.$r8$clinit;
        Job job = (Job) coroutineContext.get(Job.Key.$$INSTANCE);
        if (job != null) {
            return job.isActive();
        }
        return true;
    }
}
