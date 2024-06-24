package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: StepsViewModel.kt */
/* loaded from: classes3.dex */
public final class StepsViewModel extends ChartViewModel {
    private final FitnessProvider fitnessProvider;

    public StepsViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAvgStepsPerMonth(com.animaconnected.watch.fitness.TimePeriod r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.CommonFlow<java.util.List<com.animaconnected.watch.fitness.StepEntry>>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.workout.StepsViewModel$getAvgStepsPerMonth$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.workout.StepsViewModel$getAvgStepsPerMonth$1 r0 = (com.animaconnected.watch.workout.StepsViewModel$getAvgStepsPerMonth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.StepsViewModel$getAvgStepsPerMonth$1 r0 = new com.animaconnected.watch.workout.StepsViewModel$getAvgStepsPerMonth$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r9 = r0.L$0
            com.animaconnected.watch.fitness.TimePeriod r9 = (com.animaconnected.watch.fitness.TimePeriod) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L5b
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            java.lang.Object r9 = r0.L$0
            com.animaconnected.watch.fitness.TimePeriod r9 = (com.animaconnected.watch.fitness.TimePeriod) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L4e
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.animaconnected.watch.fitness.FitnessProvider r10 = r8.fitnessProvider
            r0.L$0 = r9
            r0.label = r4
            java.lang.Object r10 = r10.getAvgStepsPerMonth(r9, r0)
            if (r10 != r1) goto L4e
            return r1
        L4e:
            kotlinx.coroutines.flow.Flow r10 = (kotlinx.coroutines.flow.Flow) r10
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r10, r0)
            if (r10 != r1) goto L5b
            return r1
        L5b:
            java.util.List r10 = (java.util.List) r10
            r0 = r10
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L6b
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L69
            goto L6b
        L69:
            r0 = 0
            goto L6c
        L6b:
            r0 = r4
        L6c:
            if (r0 == 0) goto La6
            r10 = 0
            java.util.List r9 = com.animaconnected.watch.fitness.TimePeriodKt.monthIntervals$default(r9, r10, r4, r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r9, r0)
            r10.<init>(r0)
            java.util.Iterator r9 = r9.iterator()
        L84:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto La6
            java.lang.Object r0 = r9.next()
            com.animaconnected.watch.fitness.TimePeriod r0 = (com.animaconnected.watch.fitness.TimePeriod) r0
            com.animaconnected.watch.fitness.StepEntry r7 = new com.animaconnected.watch.fitness.StepEntry
            com.animaconnected.watch.model.HistoryDeviceId$Companion r1 = com.animaconnected.watch.model.HistoryDeviceId.Companion
            java.lang.String r2 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r1)
            long r3 = r0.getStartTs()
            r5 = 0
            r6 = 0
            r1 = r7
            r1.<init>(r2, r3, r5, r6)
            r10.add(r7)
            goto L84
        La6:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2 r9 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2
            r9.<init>(r10)
            com.animaconnected.watch.CommonFlow r9 = com.animaconnected.watch.FlowExtensionsKt.asCommonFlow(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.StepsViewModel.getAvgStepsPerMonth(com.animaconnected.watch.fitness.TimePeriod, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object observeStepsData(final com.animaconnected.watch.fitness.TimePeriod r5, final com.animaconnected.watch.fitness.TimePeriod r6, final com.animaconnected.watch.fitness.EntriesAmount r7, final com.animaconnected.watch.device.DateFormatter r8, final kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String> r9, kotlin.coroutines.Continuation<? super com.animaconnected.watch.CommonFlow<com.animaconnected.watch.graphs.ChartData<com.animaconnected.watch.graphs.BarEntry>>> r10) {
        /*
            r4 = this;
            boolean r0 = r10 instanceof com.animaconnected.watch.workout.StepsViewModel$observeStepsData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$1 r0 = (com.animaconnected.watch.workout.StepsViewModel$observeStepsData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$1 r0 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$1
            r0.<init>(r4, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r5 = r0.L$4
            r9 = r5
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            java.lang.Object r5 = r0.L$3
            r8 = r5
            com.animaconnected.watch.device.DateFormatter r8 = (com.animaconnected.watch.device.DateFormatter) r8
            java.lang.Object r5 = r0.L$2
            r6 = r5
            com.animaconnected.watch.fitness.TimePeriod r6 = (com.animaconnected.watch.fitness.TimePeriod) r6
            java.lang.Object r5 = r0.L$1
            com.animaconnected.watch.fitness.TimePeriod r5 = (com.animaconnected.watch.fitness.TimePeriod) r5
            java.lang.Object r7 = r0.L$0
            com.animaconnected.watch.workout.StepsViewModel r7 = (com.animaconnected.watch.workout.StepsViewModel) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L67
        L3e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L46:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r7 instanceof com.animaconnected.watch.fitness.Months
            if (r10 == 0) goto L6a
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$1 r7 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$1
            r10 = 0
            r7.<init>(r4, r10)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r8
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r10 = com.animaconnected.watch.workout.utils.VmChartUtilsKt.monthsFlowSuspend(r5, r7, r0)
            if (r10 != r1) goto L66
            return r1
        L66:
            r7 = r4
        L67:
            kotlinx.coroutines.flow.Flow r10 = (kotlinx.coroutines.flow.Flow) r10
            goto L87
        L6a:
            boolean r10 = r7 instanceof com.animaconnected.watch.fitness.Days
            if (r10 == 0) goto L79
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$2 r7 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$2
            r7.<init>()
            kotlinx.coroutines.flow.Flow r10 = com.animaconnected.watch.workout.utils.VmChartUtilsKt.daysFlow(r5, r7)
        L77:
            r7 = r4
            goto L87
        L79:
            boolean r10 = r7 instanceof com.animaconnected.watch.fitness.EqualIntervals
            if (r10 == 0) goto L9a
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$3 r10 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$flow$3
            r10.<init>()
            kotlinx.coroutines.flow.Flow r10 = com.animaconnected.watch.workout.utils.VmChartUtilsKt.equalsFlow(r5, r10)
            goto L77
        L87:
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$2 r0 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$2
            r0.<init>()
            kotlinx.coroutines.flow.Flow r6 = com.animaconnected.watch.workout.utils.VmChartUtilsKt.unwrap(r10, r0)
            com.animaconnected.watch.workout.StepsViewModel$observeStepsData$$inlined$map$1 r8 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsData$$inlined$map$1
            r8.<init>()
            com.animaconnected.watch.CommonFlow r5 = com.animaconnected.watch.FlowExtensionsKt.asCommonFlow(r8)
            return r5
        L9a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.StepsViewModel.observeStepsData(com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.fitness.EntriesAmount, com.animaconnected.watch.device.DateFormatter, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object observeStepsLastWeek(Continuation<? super CommonFlow<ChartData<BarEntry>>> continuation) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeStepsData(TimePeriod.Companion.lastWeek$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), markerLastWeekFormatter(), continuation);
    }

    public final Object observeStepsToday(Continuation<? super CommonFlow<ChartData<BarEntry>>> continuation) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeStepsData(TimePeriod.Companion.day$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), new EqualIntervals(48), StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null), markerTodayFormatter(), continuation);
    }

    public final CommonFlow<Integer> observeStepsTodaySummary() {
        final CommonFlow<List<StepEntry>> stepsWithResolution = this.fitnessProvider.getStepsWithResolution(TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null), 1);
        return FlowExtensionsKt.asCommonFlow(new Flow<Integer>() { // from class: com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2", f = "StepsViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L5d
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        java.lang.Iterable r6 = (java.lang.Iterable) r6
                        java.util.Iterator r6 = r6.iterator()
                        r2 = 0
                    L3d:
                        boolean r4 = r6.hasNext()
                        if (r4 == 0) goto L4f
                        java.lang.Object r4 = r6.next()
                        com.animaconnected.watch.fitness.StepEntry r4 = (com.animaconnected.watch.fitness.StepEntry) r4
                        int r4 = r4.getSteps()
                        int r2 = r2 + r4
                        goto L3d
                    L4f:
                        java.lang.Integer r6 = new java.lang.Integer
                        r6.<init>(r2)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L5d
                        return r1
                    L5d:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.StepsViewModel$observeStepsTodaySummary$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Integer> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }
}
