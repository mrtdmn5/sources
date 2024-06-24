package com.animaconnected.watch.fitness;

import app.cash.sqldelight.coroutines.FlowQuery;
import app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$getAvgStepsPerMonth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonFlow<List<? extends StepEntry>>>, Object> {
    final /* synthetic */ TimePeriod $timePeriod;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$getAvgStepsPerMonth$2(WatchFitnessProvider watchFitnessProvider, TimePeriod timePeriod, Continuation<? super WatchFitnessProvider$getAvgStepsPerMonth$2> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$timePeriod = timePeriod;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$getAvgStepsPerMonth$2(this.this$0, this.$timePeriod, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super CommonFlow<List<? extends StepEntry>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super CommonFlow<List<StepEntry>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.this$0.getDb().getAvgStepsPerMonth(this.$timePeriod.getStartTs(), this.$timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
            return FlowExtensionsKt.asCommonFlow(new Flow<List<? extends StepEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r13, kotlin.coroutines.Continuation r14) {
                        /*
                            r12 = this;
                            boolean r0 = r14 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r14
                            com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r14)
                        L18:
                            java.lang.Object r14 = r0.result
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.throwOnFailure(r14)
                            goto L7f
                        L27:
                            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                            r13.<init>(r14)
                            throw r13
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r14)
                            kotlinx.coroutines.flow.FlowCollector r14 = r12.$this_unsafeFlow
                            java.util.List r13 = (java.util.List) r13
                            java.lang.Iterable r13 = (java.lang.Iterable) r13
                            java.util.ArrayList r2 = new java.util.ArrayList
                            r4 = 10
                            int r4 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r13, r4)
                            r2.<init>(r4)
                            java.util.Iterator r13 = r13.iterator()
                        L47:
                            boolean r4 = r13.hasNext()
                            if (r4 == 0) goto L76
                            java.lang.Object r4 = r13.next()
                            com.animaconnected.watch.fitness.GetAvgStepsPerMonth r4 = (com.animaconnected.watch.fitness.GetAvgStepsPerMonth) r4
                            com.animaconnected.watch.fitness.StepEntry r11 = new com.animaconnected.watch.fitness.StepEntry
                            com.animaconnected.watch.model.HistoryDeviceId$Companion r5 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                            java.lang.String r6 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r5)
                            long r7 = r4.getTimestamp()
                            java.lang.Double r4 = r4.getAvg_steps()
                            if (r4 == 0) goto L6b
                            double r4 = r4.doubleValue()
                            int r4 = (int) r4
                            goto L6c
                        L6b:
                            r4 = 0
                        L6c:
                            r9 = r4
                            r10 = 0
                            r5 = r11
                            r5.<init>(r6, r7, r9, r10)
                            r2.add(r11)
                            goto L47
                        L76:
                            r0.label = r3
                            java.lang.Object r13 = r14.emit(r2, r0)
                            if (r13 != r1) goto L7f
                            return r1
                        L7f:
                            kotlin.Unit r13 = kotlin.Unit.INSTANCE
                            return r13
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgStepsPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends StepEntry>> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                    if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super CommonFlow<List<StepEntry>>> continuation) {
        return ((WatchFitnessProvider$getAvgStepsPerMonth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
