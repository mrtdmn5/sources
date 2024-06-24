package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.workout.utils.VmChartUtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: CaloriesViewModel.kt */
/* loaded from: classes3.dex */
public final class CaloriesViewModel extends ChartViewModel {
    private final FitnessProvider fitnessProvider;

    public CaloriesViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAvgCaloriesPerMonth(final com.animaconnected.watch.fitness.TimePeriod r11, com.animaconnected.watch.device.DateFormatter r12, com.animaconnected.watch.fitness.TimePeriod r13, kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String> r14, kotlin.coroutines.Continuation<? super com.animaconnected.watch.CommonFlow<com.animaconnected.watch.graphs.ChartData<com.animaconnected.watch.graphs.BarEntry>>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$1
            if (r0 == 0) goto L13
            r0 = r15
            com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$1 r0 = (com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$1 r0 = new com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$1
            r0.<init>(r10, r15)
        L18:
            java.lang.Object r15 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r11 = r0.L$1
            com.animaconnected.watch.fitness.TimePeriod r11 = (com.animaconnected.watch.fitness.TimePeriod) r11
            java.lang.Object r12 = r0.L$0
            com.animaconnected.watch.workout.CaloriesViewModel r12 = (com.animaconnected.watch.workout.CaloriesViewModel) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L53
        L2f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L37:
            kotlin.ResultKt.throwOnFailure(r15)
            com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$2 r15 = new com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$2
            r9 = 0
            r4 = r15
            r5 = r10
            r6 = r12
            r7 = r14
            r8 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r15 = com.animaconnected.watch.workout.utils.VmChartUtilsKt.monthsFlowSuspend(r11, r15, r0)
            if (r15 != r1) goto L52
            return r1
        L52:
            r12 = r10
        L53:
            kotlinx.coroutines.flow.Flow r15 = (kotlinx.coroutines.flow.Flow) r15
            com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$$inlined$map$1 r13 = new com.animaconnected.watch.workout.CaloriesViewModel$getAvgCaloriesPerMonth$$inlined$map$1
            r13.<init>()
            com.animaconnected.watch.CommonFlow r11 = com.animaconnected.watch.FlowExtensionsKt.asCommonFlow(r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.CaloriesViewModel.getAvgCaloriesPerMonth(com.animaconnected.watch.fitness.TimePeriod, com.animaconnected.watch.device.DateFormatter, com.animaconnected.watch.fitness.TimePeriod, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final CommonFlow<ChartData<BarEntry>> observeCaloriesDays(final TimePeriod timePeriod, final DateFormatter dateFormatter, final Function1<? super Long, String> function1, final TimePeriod timePeriod2) {
        final Flow unwrap = VmChartUtilsKt.unwrap(VmChartUtilsKt.daysFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends WatchFitnessProvider.CalorieEntry>>>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CommonFlow<List<WatchFitnessProvider.CalorieEntry>> invoke(TimePeriod period) {
                FitnessProvider fitnessProvider;
                Intrinsics.checkNotNullParameter(period, "period");
                fitnessProvider = CaloriesViewModel.this.fitnessProvider;
                return fitnessProvider.getCaloriesWithResolution(period, 1);
            }
        }), new Function1<WatchFitnessProvider.CalorieEntry, BarEntry>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BarEntry invoke(WatchFitnessProvider.CalorieEntry entry) {
                BarEntry barEntry;
                Intrinsics.checkNotNullParameter(entry, "entry");
                barEntry = CaloriesViewModel.this.toBarEntry(entry, dateFormatter, function1, timePeriod2);
                return barEntry;
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<ChartData<? extends BarEntry>>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ CaloriesViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2", f = "CaloriesViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, CaloriesViewModel caloriesViewModel, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = caloriesViewModel;
                    this.$timePeriod$inlined = timePeriod;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L47
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        com.animaconnected.watch.workout.CaloriesViewModel r2 = r5.this$0
                        com.animaconnected.watch.fitness.TimePeriod r4 = r5.$timePeriod$inlined
                        com.animaconnected.watch.graphs.ChartData r6 = com.animaconnected.watch.workout.CaloriesViewModel.access$toChartData(r2, r6, r4)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesDays$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ChartData<? extends BarEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, timePeriod), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    private final CommonFlow<ChartData<BarEntry>> observeCaloriesEqualIntervals(final TimePeriod timePeriod, final DateFormatter dateFormatter, final Function1<? super Long, String> function1, final TimePeriod timePeriod2, EqualIntervals equalIntervals) {
        final Flow unwrap = VmChartUtilsKt.unwrap(this.fitnessProvider.getCaloriesWithResolution(timePeriod, equalIntervals.getAmountOfEntries()), new Function1<WatchFitnessProvider.CalorieEntry, BarEntry>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BarEntry invoke(WatchFitnessProvider.CalorieEntry calorieEntry) {
                BarEntry barEntry;
                Intrinsics.checkNotNullParameter(calorieEntry, "calorieEntry");
                barEntry = CaloriesViewModel.this.toBarEntry(calorieEntry, dateFormatter, function1, timePeriod2);
                return barEntry;
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<ChartData<? extends BarEntry>>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ CaloriesViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2", f = "CaloriesViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, CaloriesViewModel caloriesViewModel, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = caloriesViewModel;
                    this.$timePeriod$inlined = timePeriod;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L47
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.util.List r6 = (java.util.List) r6
                        com.animaconnected.watch.workout.CaloriesViewModel r2 = r5.this$0
                        com.animaconnected.watch.fitness.TimePeriod r4 = r5.$timePeriod$inlined
                        com.animaconnected.watch.graphs.ChartData r6 = com.animaconnected.watch.workout.CaloriesViewModel.access$toChartData(r2, r6, r4)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesEqualIntervals$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ChartData<? extends BarEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, timePeriod), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BarEntry toBarEntry(WatchFitnessProvider.CalorieEntry calorieEntry, DateFormatter dateFormatter, Function1<? super Long, String> function1, TimePeriod timePeriod) {
        return new BarEntry(calorieEntry.getCalories(), DateFormatter.format$default(dateFormatter, calorieEntry.getTimePeriod().getStartTs(), null, false, 6, null), 0L, (String) null, function1.invoke(Long.valueOf(calorieEntry.getTimePeriod().getStartTs())), VmChartUtilsKt.isSelected(calorieEntry.getTimePeriod().getStartTs(), timePeriod), 12, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChartData<BarEntry> toChartData(List<BarEntry> list, TimePeriod timePeriod) {
        boolean z;
        Object obj;
        boolean z2;
        boolean hasCaloriesDataBefore = this.fitnessProvider.hasCaloriesDataBefore(timePeriod.getStart());
        Iterator<T> it = list.iterator();
        while (true) {
            z = true;
            if (it.hasNext()) {
                obj = it.next();
                if (((BarEntry) obj).getValue() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            z = false;
        }
        return new ChartData<>(list, hasCaloriesDataBefore, z);
    }

    public final Object observeCalories(TimePeriod timePeriod, TimePeriod timePeriod2, EntriesAmount entriesAmount, DateFormatter dateFormatter, Function1<? super Long, String> function1, Continuation<? super CommonFlow<ChartData<BarEntry>>> continuation) {
        if (entriesAmount instanceof Months) {
            return getAvgCaloriesPerMonth(timePeriod, dateFormatter, timePeriod2, function1, continuation);
        }
        if (entriesAmount instanceof Days) {
            return observeCaloriesDays(timePeriod, dateFormatter, function1, timePeriod2);
        }
        if (entriesAmount instanceof EqualIntervals) {
            return observeCaloriesEqualIntervals(timePeriod, dateFormatter, function1, timePeriod2, (EqualIntervals) entriesAmount);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object observeCaloriesLastWeek(Continuation<? super CommonFlow<ChartData<BarEntry>>> continuation) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeCalories(TimePeriod.Companion.lastWeek$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), markerLastWeekFormatter(), continuation);
    }

    public final Object observeCaloriesToday(Continuation<? super CommonFlow<ChartData<BarEntry>>> continuation) {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeCalories(TimePeriod.Companion.day$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), new EqualIntervals(48), StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null), markerTodayFormatter(), continuation);
    }

    public final CommonFlow<Integer> observeCaloriesTodaySummary() {
        final CommonFlow<List<WatchFitnessProvider.CalorieEntry>> caloriesWithResolution = this.fitnessProvider.getCaloriesWithResolution(TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null), 1);
        return FlowExtensionsKt.asCommonFlow(new Flow<Integer>() { // from class: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2", f = "CaloriesViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1$2$1
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
                        com.animaconnected.watch.fitness.WatchFitnessProvider$CalorieEntry r4 = (com.animaconnected.watch.fitness.WatchFitnessProvider.CalorieEntry) r4
                        int r4 = r4.getCalories()
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
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.CaloriesViewModel$observeCaloriesTodaySummary$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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
