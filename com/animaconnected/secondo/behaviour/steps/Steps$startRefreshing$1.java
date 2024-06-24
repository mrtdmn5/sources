package com.animaconnected.secondo.behaviour.steps;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Steps.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.steps.Steps$startRefreshing$1", f = "Steps.kt", l = {67, 68}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Steps$startRefreshing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Steps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Steps$startRefreshing$1(Steps steps, Continuation<? super Steps$startRefreshing$1> continuation) {
        super(2, continuation);
        this.this$0 = steps;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Steps$startRefreshing$1 steps$startRefreshing$1 = new Steps$startRefreshing$1(this.this$0, continuation);
        steps$startRefreshing$1.L$0 = obj;
        return steps$startRefreshing$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0054 -> B:7:0x002f). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r1
            goto L2e
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r1
            r1 = r6
            goto L42
        L27:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
        L2e:
            r1 = r6
        L2f:
            boolean r4 = kotlinx.coroutines.CoroutineScopeKt.isActive(r7)
            if (r4 == 0) goto L57
            r1.L$0 = r7
            r1.label = r3
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r1)
            if (r4 != r0) goto L42
            return r0
        L42:
            com.animaconnected.secondo.behaviour.steps.Steps r4 = r1.this$0
            com.animaconnected.watch.fitness.FitnessProvider r4 = com.animaconnected.secondo.behaviour.steps.Steps.access$getFitnessProvider$p(r4)
            com.animaconnected.watch.CommonFlow r4 = r4.syncFitness()
            r1.L$0 = r7
            r1.label = r2
            java.lang.Object r4 = com.animaconnected.watch.fitness.FitnessProviderKt.suspendUntilDone(r4, r1)
            if (r4 != r0) goto L2f
            return r0
        L57:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.steps.Steps$startRefreshing$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Steps$startRefreshing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
