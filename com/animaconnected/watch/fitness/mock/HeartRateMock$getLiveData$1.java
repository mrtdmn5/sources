package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.workout.HeartrateMetricItem;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: HeartRateMock.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.mock.HeartRateMock$getLiveData$1", f = "HeartRateMock.kt", l = {183, 185, 187}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class HeartRateMock$getLiveData$1 extends SuspendLambda implements Function2<FlowCollector<? super HeartrateMetricItem>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HeartRateMock this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeartRateMock$getLiveData$1(HeartRateMock heartRateMock, Continuation<? super HeartRateMock$getLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = heartRateMock;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HeartRateMock$getLiveData$1 heartRateMock$getLiveData$1 = new HeartRateMock$getLiveData$1(this.this$0, continuation);
        heartRateMock$getLiveData$1.L$0 = obj;
        return heartRateMock$getLiveData$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0081 -> B:12:0x006a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00b5 -> B:12:0x006a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            java.lang.String r2 = "systemUTC().instant()"
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L2c
            if (r1 == r6) goto L24
            if (r1 == r5) goto L1b
            if (r1 != r4) goto L13
            goto L24
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            goto L7b
        L24:
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L69
        L2c:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Object r11 = r10.L$0
            r1 = r11
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            com.animaconnected.watch.workout.HeartrateMetricItem r11 = new com.animaconnected.watch.workout.HeartrateMetricItem
            com.animaconnected.watch.fitness.HeartrateValue r7 = new com.animaconnected.watch.fitness.HeartrateValue
            com.animaconnected.watch.fitness.mock.HeartRateMock r8 = r10.this$0
            kotlin.jvm.functions.Function0 r8 = r8.getNextHeartRateValue()
            java.lang.Object r8 = r8.invoke()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r7.<init>(r8, r3)
            kotlinx.datetime.Instant$Companion r8 = kotlinx.datetime.Instant.Companion
            r8.getClass()
            kotlinx.datetime.Instant r8 = new kotlinx.datetime.Instant
            j$.time.Instant r9 = com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0.m(r2)
            r8.<init>(r9)
            com.animaconnected.watch.workout.HeartrateSource r9 = com.animaconnected.watch.workout.HeartrateSource.LIVE
            r11.<init>(r7, r8, r9)
            r10.L$0 = r1
            r10.label = r6
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L69
            return r0
        L69:
            r11 = r10
        L6a:
            com.animaconnected.watch.fitness.mock.HeartRateMock r6 = r11.this$0
            long r6 = r6.mo1453getLiveHeartRateDelayUwyO8pc()
            r11.L$0 = r1
            r11.label = r5
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.m1695delayVtjQ1oo(r6, r11)
            if (r6 != r0) goto L7b
            return r0
        L7b:
            com.animaconnected.watch.fitness.mock.HeartRateMock r6 = r11.this$0
            boolean r6 = r6.isLiveHeartRateEnabled()
            if (r6 == 0) goto L6a
            com.animaconnected.watch.workout.HeartrateMetricItem r6 = new com.animaconnected.watch.workout.HeartrateMetricItem
            com.animaconnected.watch.fitness.HeartrateValue r7 = new com.animaconnected.watch.fitness.HeartrateValue
            com.animaconnected.watch.fitness.mock.HeartRateMock r8 = r11.this$0
            kotlin.jvm.functions.Function0 r8 = r8.getNextHeartRateValue()
            java.lang.Object r8 = r8.invoke()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r7.<init>(r8, r3)
            kotlinx.datetime.Instant$Companion r8 = kotlinx.datetime.Instant.Companion
            r8.getClass()
            kotlinx.datetime.Instant r8 = new kotlinx.datetime.Instant
            j$.time.Instant r9 = com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0.m(r2)
            r8.<init>(r9)
            com.animaconnected.watch.workout.HeartrateSource r9 = com.animaconnected.watch.workout.HeartrateSource.LIVE
            r6.<init>(r7, r8, r9)
            r11.L$0 = r1
            r11.label = r4
            java.lang.Object r6 = r1.emit(r6, r11)
            if (r6 != r0) goto L6a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.mock.HeartRateMock$getLiveData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super HeartrateMetricItem> flowCollector, Continuation<? super Unit> continuation) {
        return ((HeartRateMock$getLiveData$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
