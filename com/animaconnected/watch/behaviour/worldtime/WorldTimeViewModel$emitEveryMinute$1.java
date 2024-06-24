package com.animaconnected.watch.behaviour.worldtime;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: WorldTimeViewModel.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$emitEveryMinute$1", f = "WorldTimeViewModel.kt", l = {118, 120}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WorldTimeViewModel$emitEveryMinute$1<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, T, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public WorldTimeViewModel$emitEveryMinute$1(Continuation<? super WorldTimeViewModel$emitEveryMinute$1> continuation) {
        super(3, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return invoke((FlowCollector<? super FlowCollector<? super T>>) obj, (FlowCollector<? super T>) obj2, continuation);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x006a -> B:7:0x0034). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L29
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r7.L$1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L33
        L16:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1e:
            java.lang.Object r1 = r7.L$1
            java.lang.Object r4 = r7.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L41
        L29:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r4 = r8
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            java.lang.Object r1 = r7.L$1
        L33:
            r8 = r7
        L34:
            r8.L$0 = r4
            r8.L$1 = r1
            r8.label = r3
            java.lang.Object r5 = r4.emit(r1, r8)
            if (r5 != r0) goto L41
            return r0
        L41:
            int r5 = kotlin.time.Duration.$r8$clinit
            kotlinx.datetime.Instant r5 = com.animaconnected.info.DateTimeUtilsKt.now()
            kotlinx.datetime.TimeZone$Companion r6 = kotlinx.datetime.TimeZone.Companion
            r6.getClass()
            kotlinx.datetime.FixedOffsetTimeZone r6 = kotlinx.datetime.TimeZone.UTC
            kotlinx.datetime.LocalDateTime r5 = kotlinx.datetime.TimeZoneKt.toLocalDateTime(r5, r6)
            j$.time.LocalDateTime r5 = r5.value
            int r5 = r5.getSecond()
            int r5 = 60 - r5
            kotlin.time.DurationUnit r6 = kotlin.time.DurationUnit.SECONDS
            long r5 = kotlin.time.DurationKt.toDuration(r5, r6)
            r8.L$0 = r4
            r8.L$1 = r1
            r8.label = r2
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.m1695delayVtjQ1oo(r5, r8)
            if (r5 != r0) goto L34
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel$emitEveryMinute$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(FlowCollector<? super T> flowCollector, T t, Continuation<? super Unit> continuation) {
        WorldTimeViewModel$emitEveryMinute$1 worldTimeViewModel$emitEveryMinute$1 = new WorldTimeViewModel$emitEveryMinute$1(continuation);
        worldTimeViewModel$emitEveryMinute$1.L$0 = flowCollector;
        worldTimeViewModel$emitEveryMinute$1.L$1 = t;
        return worldTimeViewModel$emitEveryMinute$1.invokeSuspend(Unit.INSTANCE);
    }
}
