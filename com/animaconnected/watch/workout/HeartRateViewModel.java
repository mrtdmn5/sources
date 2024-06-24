package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HeartrateSummary;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.RestingHeartrateEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.AvgMaxMinEntry;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.None;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.workout.utils.VmChartUtilsKt;
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
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;

/* compiled from: HeartRateViewModel.kt */
/* loaded from: classes3.dex */
public final class HeartRateViewModel extends ChartViewModel {
    private final FitnessProvider fitnessProvider;

    public HeartRateViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
    }

    public final CommonFlow<ChartData<AvgMaxMinEntry>> observeHeartRateData(final TimePeriod timePeriod, final TimePeriod selectedTimePeriod, final EntriesAmount nbrOfEntries, final DateFormatter dateFormatter, final Function1<? super Long, String> markerLabelFormatter) {
        Flow equalsFlow;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        Intrinsics.checkNotNullParameter(nbrOfEntries, "nbrOfEntries");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(markerLabelFormatter, "markerLabelFormatter");
        if (nbrOfEntries instanceof Months) {
            equalsFlow = VmChartUtilsKt.monthsFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends HeartrateSummary>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$flow$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<HeartrateSummary>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getHeartRateDataWithResolution(period, 1);
                }
            });
        } else if (nbrOfEntries instanceof Days) {
            equalsFlow = VmChartUtilsKt.daysFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends HeartrateSummary>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$flow$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<HeartrateSummary>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getHeartRateDataWithResolution(period, 1);
                }
            });
        } else if (nbrOfEntries instanceof EqualIntervals) {
            equalsFlow = VmChartUtilsKt.equalsFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends HeartrateSummary>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$flow$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<HeartrateSummary>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getHeartRateDataWithResolution(period, ((EqualIntervals) nbrOfEntries).getAmountOfEntries());
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final Flow unwrap = VmChartUtilsKt.unwrap(equalsFlow, new Function1<HeartrateSummary, AvgMaxMinEntry>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AvgMaxMinEntry invoke(HeartrateSummary heartRateSummary) {
                Intrinsics.checkNotNullParameter(heartRateSummary, "heartRateSummary");
                return new AvgMaxMinEntry(heartRateSummary.getAvg(), heartRateSummary.getMax(), heartRateSummary.getMin(), DateFormatter.format$default(DateFormatter.this, heartRateSummary.getTimestamp(), null, false, 6, null), markerLabelFormatter.invoke(Long.valueOf(heartRateSummary.getTimestamp())), VmChartUtilsKt.isSelected(heartRateSummary.getTimestamp(), selectedTimePeriod));
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<ChartData<? extends AvgMaxMinEntry>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ HeartRateViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2", f = "HeartRateViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, HeartRateViewModel heartRateViewModel, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = heartRateViewModel;
                    this.$timePeriod$inlined = timePeriod;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L79
                    L27:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r10)
                        kotlinx.coroutines.flow.FlowCollector r10 = r8.$this_unsafeFlow
                        java.util.List r9 = (java.util.List) r9
                        com.animaconnected.watch.workout.HeartRateViewModel r2 = r8.this$0
                        com.animaconnected.watch.fitness.FitnessProvider r2 = com.animaconnected.watch.workout.HeartRateViewModel.access$getFitnessProvider$p(r2)
                        com.animaconnected.watch.fitness.TimePeriod r4 = r8.$timePeriod$inlined
                        kotlinx.datetime.Instant r4 = r4.getStart()
                        boolean r2 = r2.hasHeartRateDataBefore(r4)
                        r4 = r9
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r4 = r4.iterator()
                    L4d:
                        boolean r5 = r4.hasNext()
                        r6 = 0
                        if (r5 == 0) goto L67
                        java.lang.Object r5 = r4.next()
                        r7 = r5
                        com.animaconnected.watch.graphs.AvgMaxMinEntry r7 = (com.animaconnected.watch.graphs.AvgMaxMinEntry) r7
                        int r7 = r7.getAvgValue()
                        if (r7 <= 0) goto L63
                        r7 = r3
                        goto L64
                    L63:
                        r7 = r6
                    L64:
                        if (r7 == 0) goto L4d
                        goto L68
                    L67:
                        r5 = 0
                    L68:
                        if (r5 != 0) goto L6b
                        r6 = r3
                    L6b:
                        com.animaconnected.watch.graphs.ChartData r4 = new com.animaconnected.watch.graphs.ChartData
                        r4.<init>(r9, r2, r6)
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r4, r0)
                        if (r9 != r1) goto L79
                        return r1
                    L79:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.HeartRateViewModel$observeHeartRateData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ChartData<? extends AvgMaxMinEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, timePeriod), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final CommonFlow<ChartData<PointEntry>> observeLastMonthRestingHeartRateData() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeRestingHeartRateData(TimePeriod.Companion.lastMonth$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.shortMonthAndDateFormat, false, 2, null), markerHistoryFormatter(HistoryPeriodTab.Month));
    }

    public final CommonFlow<ChartData<AvgMaxMinEntry>> observeLastWeekHeartRateData() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        return observeHeartRateData(TimePeriod.Companion.lastWeek$default(companion, null, null, 3, null), TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, StringsBackend.createDateFormatter$default(getStringsBackend$watch_release(), DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null), markerLastWeekFormatter());
    }

    public final CommonFlow<HeartrateMetricItem> observeLiveHeartRateData() {
        return FlowExtensionsKt.asCommonFlow(this.fitnessProvider.getHeartrateLiveData());
    }

    public final CommonFlow<ChartData<PointEntry>> observeRestingHeartRateData(final TimePeriod timePeriod, final TimePeriod selectedTimePeriod, final EntriesAmount nbrOfEntries, final DateFormatter dateFormatter, final Function1<? super Long, String> markerLabelFormatter) {
        Flow equalsFlow;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        Intrinsics.checkNotNullParameter(nbrOfEntries, "nbrOfEntries");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(markerLabelFormatter, "markerLabelFormatter");
        if (nbrOfEntries instanceof Months) {
            equalsFlow = VmChartUtilsKt.monthsFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends RestingHeartrateEntry>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$flow$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<RestingHeartrateEntry>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getRestingHeartRateDataWithResolution(period, 1);
                }
            });
        } else if (nbrOfEntries instanceof Days) {
            equalsFlow = VmChartUtilsKt.daysFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends RestingHeartrateEntry>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$flow$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<RestingHeartrateEntry>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getRestingHeartRateDataWithResolution(period, 1);
                }
            });
        } else if (nbrOfEntries instanceof EqualIntervals) {
            equalsFlow = VmChartUtilsKt.equalsFlow(timePeriod, new Function1<TimePeriod, CommonFlow<List<? extends RestingHeartrateEntry>>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$flow$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CommonFlow<List<RestingHeartrateEntry>> invoke(TimePeriod period) {
                    FitnessProvider fitnessProvider;
                    Intrinsics.checkNotNullParameter(period, "period");
                    fitnessProvider = HeartRateViewModel.this.fitnessProvider;
                    return fitnessProvider.getRestingHeartRateDataWithResolution(period, ((EqualIntervals) nbrOfEntries).getAmountOfEntries());
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final Flow unwrap = VmChartUtilsKt.unwrap(equalsFlow, new Function1<RestingHeartrateEntry, PointEntry>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PointEntry invoke(RestingHeartrateEntry restingHeartRateEntry) {
                Intrinsics.checkNotNullParameter(restingHeartRateEntry, "restingHeartRateEntry");
                Integer valueOf = restingHeartRateEntry.getRestingHeartrate() > 0 ? Integer.valueOf(restingHeartRateEntry.getRestingHeartrate()) : null;
                return new PointEntry(valueOf != null ? new Known(valueOf.intValue(), false, 2, (DefaultConstructorMarker) null) : None.INSTANCE, DateFormatter.format$default(DateFormatter.this, restingHeartRateEntry.getTimestamp(), null, false, 6, null), markerLabelFormatter.invoke(Long.valueOf(restingHeartRateEntry.getTimestamp())), VmChartUtilsKt.isSelected(restingHeartRateEntry.getTimestamp(), selectedTimePeriod));
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<ChartData<? extends PointEntry>>() { // from class: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ HeartRateViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2", f = "HeartRateViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, HeartRateViewModel heartRateViewModel, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = heartRateViewModel;
                    this.$timePeriod$inlined = timePeriod;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L80
                    L27:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        java.util.List r7 = (java.util.List) r7
                        com.animaconnected.watch.workout.HeartRateViewModel r2 = r6.this$0
                        com.animaconnected.watch.fitness.FitnessProvider r2 = com.animaconnected.watch.workout.HeartRateViewModel.access$getFitnessProvider$p(r2)
                        com.animaconnected.watch.fitness.TimePeriod r4 = r6.$timePeriod$inlined
                        kotlinx.datetime.Instant r4 = r4.getStart()
                        boolean r2 = r2.hasRestingHeartRateDataBefore(r4)
                        r4 = r7
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        boolean r5 = r4 instanceof java.util.Collection
                        if (r5 == 0) goto L58
                        r5 = r4
                        java.util.Collection r5 = (java.util.Collection) r5
                        boolean r5 = r5.isEmpty()
                        if (r5 == 0) goto L58
                    L56:
                        r4 = r3
                        goto L72
                    L58:
                        java.util.Iterator r4 = r4.iterator()
                    L5c:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L56
                        java.lang.Object r5 = r4.next()
                        com.animaconnected.watch.graphs.PointEntry r5 = (com.animaconnected.watch.graphs.PointEntry) r5
                        com.animaconnected.watch.graphs.LineChartValue r5 = r5.getLineChartValue()
                        boolean r5 = r5 instanceof com.animaconnected.watch.graphs.Known
                        r5 = r5 ^ r3
                        if (r5 != 0) goto L5c
                        r4 = 0
                    L72:
                        com.animaconnected.watch.graphs.ChartData r5 = new com.animaconnected.watch.graphs.ChartData
                        r5.<init>(r7, r2, r4)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r5, r0)
                        if (r7 != r1) goto L80
                        return r1
                    L80:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.HeartRateViewModel$observeRestingHeartRateData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ChartData<? extends PointEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, timePeriod), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final CommonFlow<HeartRateSummary> observeTodayHeartRateData() {
        TimePeriod day$default = TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null);
        return FlowExtensionsKt.asCommonFlow(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(this.fitnessProvider.getHeartrateDataForCurrentDevice(day$default), this.fitnessProvider.getPowerDataForCurrentDevice(day$default), new HeartRateViewModel$observeTodayHeartRateData$1(day$default, this, null)));
    }
}
