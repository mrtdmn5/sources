package com.animaconnected.watch.fitness;

import app.cash.sqldelight.coroutines.FlowQuery;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
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
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: WatchFitnessProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2", f = "WatchFitnessProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchFitnessProvider$getAvgCaloriesPerMonth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CommonFlow<WatchFitnessProvider.CalorieEntry>>, Object> {
    final /* synthetic */ TimePeriod $monthPeriod;
    int label;
    final /* synthetic */ WatchFitnessProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFitnessProvider$getAvgCaloriesPerMonth$2(WatchFitnessProvider watchFitnessProvider, TimePeriod timePeriod, Continuation<? super WatchFitnessProvider$getAvgCaloriesPerMonth$2> continuation) {
        super(2, continuation);
        this.this$0 = watchFitnessProvider;
        this.$monthPeriod = timePeriod;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchFitnessProvider$getAvgCaloriesPerMonth$2(this.this$0, this.$monthPeriod, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final SafeFlow flow = FlowQuery.toFlow(this.this$0.getDb().getSumCaloriesIntervaled(this.$monthPeriod.getStartTs(), this.$monthPeriod.getDurationMs(), this.$monthPeriod.getEndTs()));
            final TimePeriod timePeriod = this.$monthPeriod;
            final WatchFitnessProvider watchFitnessProvider = this.this$0;
            return FlowExtensionsKt.asCommonFlow(new Flow<WatchFitnessProvider.CalorieEntry>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1

                /* compiled from: Emitters.kt */
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ TimePeriod $monthPeriod$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;
                    final /* synthetic */ WatchFitnessProvider this$0;

                    /* compiled from: Emitters.kt */
                    @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
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

                    public AnonymousClass2(FlowCollector flowCollector, TimePeriod timePeriod, WatchFitnessProvider watchFitnessProvider) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$monthPeriod$inlined = timePeriod;
                        this.this$0 = watchFitnessProvider;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                        /*
                            r7 = this;
                            boolean r0 = r9 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                            if (r0 == 0) goto L13
                            r0 = r9
                            com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                            int r1 = r0.label
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.label = r1
                            goto L18
                        L13:
                            com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1$2$1
                            r0.<init>(r9)
                        L18:
                            java.lang.Object r9 = r0.result
                            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r2 = r0.label
                            r3 = 1
                            if (r2 == 0) goto L2f
                            if (r2 != r3) goto L27
                            kotlin.ResultKt.throwOnFailure(r9)
                            goto L8b
                        L27:
                            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                            r8.<init>(r9)
                            throw r8
                        L2f:
                            kotlin.ResultKt.throwOnFailure(r9)
                            kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                            app.cash.sqldelight.Query r8 = (app.cash.sqldelight.Query) r8
                            java.lang.Object r8 = r8.executeAsOneOrNull()
                            com.animaconnected.watch.fitness.GetSumCaloriesIntervaled r8 = (com.animaconnected.watch.fitness.GetSumCaloriesIntervaled) r8
                            r2 = 0
                            if (r8 == 0) goto L82
                            java.lang.Double r8 = r8.getCalories()
                            if (r8 == 0) goto L82
                            double r4 = r8.doubleValue()
                            int r8 = (int) r4
                            com.animaconnected.watch.fitness.TimePeriod r4 = r7.$monthPeriod$inlined
                            com.animaconnected.watch.fitness.WatchFitnessProvider r5 = r7.this$0
                            com.animaconnected.watch.fitness.TimePeriod r5 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$caloriesTimeSpan(r5)
                            com.animaconnected.watch.fitness.TimePeriod r4 = com.animaconnected.watch.fitness.TimePeriodKt.coerceInOrNull(r4, r5)
                            if (r4 != 0) goto L60
                            com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry
                            com.animaconnected.watch.fitness.TimePeriod r4 = r7.$monthPeriod$inlined
                            r2.<init>(r4, r8)
                            goto L82
                        L60:
                            com.animaconnected.watch.fitness.WatchFitnessProvider r5 = r7.this$0
                            com.animaconnected.watch.fitness.FitnessQueries r5 = r5.getDb()
                            int r5 = com.animaconnected.watch.workout.utils.BMRUtilsKt.calculateBMR(r5, r4)
                            int r4 = com.animaconnected.watch.fitness.TimePeriodKt.inDays$default(r4, r2, r3, r2)
                            int r4 = r4 + r3
                            com.animaconnected.watch.fitness.TimePeriod r6 = r7.$monthPeriod$inlined
                            int r2 = com.animaconnected.watch.fitness.TimePeriodKt.inDays$default(r6, r2, r3, r2)
                            if (r4 <= r2) goto L78
                            r4 = r2
                        L78:
                            int r5 = r5 / r4
                            int r8 = r8 / r4
                            int r8 = r8 + r5
                            com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry
                            com.animaconnected.watch.fitness.TimePeriod r4 = r7.$monthPeriod$inlined
                            r2.<init>(r4, r8)
                        L82:
                            r0.label = r3
                            java.lang.Object r8 = r9.emit(r2, r0)
                            if (r8 != r1) goto L8b
                            return r1
                        L8b:
                            kotlin.Unit r8 = kotlin.Unit.INSTANCE
                            return r8
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getAvgCaloriesPerMonth$2$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super WatchFitnessProvider.CalorieEntry> flowCollector, Continuation continuation) {
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, timePeriod, watchFitnessProvider), continuation);
                    if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CommonFlow<WatchFitnessProvider.CalorieEntry>> continuation) {
        return ((WatchFitnessProvider$getAvgCaloriesPerMonth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
