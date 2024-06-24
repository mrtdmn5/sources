package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Timeout.kt */
/* loaded from: classes4.dex */
public final class TimeoutKt {
    public static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        Object completedExceptionally;
        Object makeCompletingOnce$kotlinx_coroutines_core;
        timeoutCoroutine.invokeOnCompletion(new DisposeOnCompletion(DelayKt.getDelay(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.context)));
        boolean z = false;
        try {
            TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, function2);
            completedExceptionally = function2.invoke(timeoutCoroutine, timeoutCoroutine);
        } catch (Throwable th) {
            completedExceptionally = new CompletedExceptionally(th, false);
        }
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (completedExceptionally != coroutineSingletons && (makeCompletingOnce$kotlinx_coroutines_core = timeoutCoroutine.makeCompletingOnce$kotlinx_coroutines_core(completedExceptionally)) != JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (makeCompletingOnce$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                Throwable th2 = ((CompletedExceptionally) makeCompletingOnce$kotlinx_coroutines_core).cause;
                if (!(th2 instanceof TimeoutCancellationException) || ((TimeoutCancellationException) th2).coroutine != timeoutCoroutine) {
                    z = true;
                }
                if (!z) {
                    if (completedExceptionally instanceof CompletedExceptionally) {
                        throw ((CompletedExceptionally) completedExceptionally).cause;
                    }
                } else {
                    throw th2;
                }
            } else {
                completedExceptionally = JobSupportKt.unboxState(makeCompletingOnce$kotlinx_coroutines_core);
            }
            return completedExceptionally;
        }
        return coroutineSingletons;
    }

    public static final <T> Object withTimeout(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j > 0) {
            Object obj = setupTimeout(new TimeoutCoroutine(j, continuation), function2);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            return obj;
        }
        throw new TimeoutCancellationException("Timed out immediately", null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.TimeoutCoroutine, T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object withTimeoutOrNull(long r7, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            kotlin.jvm.internal.Ref$ObjectRef r7 = r0.L$1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L2a
            goto L57
        L2a:
            r8 = move-exception
            goto L5b
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L3e
            return r3
        L3e:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.L$0 = r9     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            r0.L$1 = r10     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            r0.label = r4     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            r10.element = r2     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            java.lang.Object r10 = setupTimeout(r2, r9)     // Catch: kotlinx.coroutines.TimeoutCancellationException -> L58
            if (r10 != r1) goto L57
            return r1
        L57:
            return r10
        L58:
            r7 = move-exception
            r8 = r7
            r7 = r10
        L5b:
            kotlinx.coroutines.Job r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L62
            return r3
        L62:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
