package com.animaconnected.watch.fitness;

import com.animaconnected.watch.CommonFlow;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1;

/* compiled from: FitnessProvider.kt */
/* loaded from: classes3.dex */
public final class FitnessProviderKt {
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object getStepsToday(com.animaconnected.watch.fitness.FitnessProvider r5, kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof com.animaconnected.watch.fitness.FitnessProviderKt$getStepsToday$1
            if (r0 == 0) goto L13
            r0 = r6
            com.animaconnected.watch.fitness.FitnessProviderKt$getStepsToday$1 r0 = (com.animaconnected.watch.fitness.FitnessProviderKt$getStepsToday$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.FitnessProviderKt$getStepsToday$1 r0 = new com.animaconnected.watch.fitness.FitnessProviderKt$getStepsToday$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r6)
            com.animaconnected.watch.fitness.TimePeriod$Companion r6 = com.animaconnected.watch.fitness.TimePeriod.Companion
            r2 = 3
            r4 = 0
            com.animaconnected.watch.fitness.TimePeriod r6 = com.animaconnected.watch.fitness.TimePeriod.Companion.day$default(r6, r4, r4, r2, r4)
            com.animaconnected.watch.CommonFlow r5 = r5.getStepsWithResolution(r6, r3)
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L58
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r6)
            com.animaconnected.watch.fitness.StepEntry r5 = (com.animaconnected.watch.fitness.StepEntry) r5
            if (r5 == 0) goto L58
            int r5 = r5.getSteps()
            goto L59
        L58:
            r5 = 0
        L59:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.FitnessProviderKt.getStepsToday(com.animaconnected.watch.fitness.FitnessProvider, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object suspendUntilDone(CommonFlow<SyncResult> commonFlow, Continuation<? super Unit> continuation) {
        Object collect = new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(new FitnessProviderKt$suspendUntilDone$2(null), commonFlow).collect(new FlowCollector() { // from class: com.animaconnected.watch.fitness.FitnessProviderKt$suspendUntilDone$3
            public final Object emit(SyncResult syncResult, Continuation<? super Unit> continuation2) {
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((SyncResult) obj, (Continuation<? super Unit>) continuation2);
            }
        }, continuation);
        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
