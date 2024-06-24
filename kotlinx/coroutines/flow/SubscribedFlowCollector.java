package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Share.kt */
/* loaded from: classes4.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.flow.internal.SafeCollector, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit onSubscription(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = (kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 r0 = new kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L42
            if (r1 == r2) goto L34
            r0 = 2
            if (r1 != r0) goto L2c
            kotlin.ResultKt.throwOnFailure(r5)
        L29:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            kotlinx.coroutines.flow.internal.SafeCollector r1 = r0.L$1
            kotlinx.coroutines.flow.SubscribedFlowCollector r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L56
            r1.releaseIntercepted()
            r0.getClass()
            goto L29
        L42:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.flow.internal.SafeCollector r1 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r5 = r0.getContext()
            r3 = 0
            r1.<init>(r3, r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L56
            r0.L$1 = r1     // Catch: java.lang.Throwable -> L56
            r0.label = r2     // Catch: java.lang.Throwable -> L56
            throw r3     // Catch: java.lang.Throwable -> L56
        L56:
            r5 = move-exception
            r1.releaseIntercepted()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SubscribedFlowCollector.onSubscription(kotlin.coroutines.Continuation):kotlin.Unit");
    }
}
