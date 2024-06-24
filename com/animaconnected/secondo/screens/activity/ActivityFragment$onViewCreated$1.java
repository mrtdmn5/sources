package com.animaconnected.secondo.screens.activity;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ActivityFragment.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.activity.ActivityFragment$onViewCreated$1", f = "ActivityFragment.kt", l = {73, 75, 76}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ActivityFragment$onViewCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ActivityFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityFragment$onViewCreated$1(ActivityFragment activityFragment, Continuation<? super ActivityFragment$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = activityFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityFragment$onViewCreated$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0065 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0063 -> B:12:0x003a). Please report as a decompilation issue!!! */
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
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L21
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            goto L1d
        L10:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L18:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            goto L51
        L1d:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L39
        L21:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchProvider r7 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.fitness.FitnessProvider r7 = r7.fitness()
            com.animaconnected.watch.CommonFlow r7 = r7.syncFitness()
            r6.label = r4
            java.lang.Object r7 = com.animaconnected.watch.fitness.FitnessProviderKt.suspendUntilDone(r7, r6)
            if (r7 != r0) goto L39
            return r0
        L39:
            r7 = r6
        L3a:
            com.animaconnected.secondo.screens.activity.ActivityFragment r1 = r7.this$0
            androidx.lifecycle.LifecycleCoroutineScopeImpl r1 = com.google.common.collect.Hashing.getLifecycleScope(r1)
            boolean r1 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
            if (r1 == 0) goto L66
            r7.label = r3
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r1 != r0) goto L51
            return r0
        L51:
            com.animaconnected.watch.WatchProvider r1 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.fitness.FitnessProvider r1 = r1.fitness()
            com.animaconnected.watch.CommonFlow r1 = r1.syncFitness()
            r7.label = r2
            java.lang.Object r1 = com.animaconnected.watch.fitness.FitnessProviderKt.suspendUntilDone(r1, r7)
            if (r1 != r0) goto L3a
            return r0
        L66:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.activity.ActivityFragment$onViewCreated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityFragment$onViewCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
