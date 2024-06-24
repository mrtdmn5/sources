package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.EqualIntervals;
import com.animaconnected.watch.fitness.FitnessIndexEntry;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.graphs.ChartData;
import com.animaconnected.watch.graphs.PointEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

/* compiled from: FitnessIndexViewModel.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexViewModel extends ChartViewModel {
    private final FitnessProvider fitnessProvider;
    private FitnessProvider.Profile profile;

    public FitnessIndexViewModel(FitnessProvider fitnessProvider) {
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        this.profile = fitnessProvider.getProfile();
    }

    private final Iterable<CommonFlow<List<FitnessIndexEntry>>> dayIterable(TimePeriod timePeriod) {
        List dayIntervals$default = TimePeriodKt.dayIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
        Iterator it = dayIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(this.fitnessProvider.getFitnessIndexDataWithResolution((TimePeriod) it.next(), 1));
        }
        return arrayList;
    }

    private final Iterable<CommonFlow<List<FitnessIndexEntry>>> equalIterable(TimePeriod timePeriod, EqualIntervals equalIntervals) {
        return CollectionsKt__CollectionsKt.listOf(this.fitnessProvider.getFitnessIndexDataWithResolution(timePeriod, equalIntervals.getAmountOfEntries()));
    }

    private final Iterable<CommonFlow<List<FitnessIndexEntry>>> monthIterable(TimePeriod timePeriod) {
        List monthlyPeriods$default = TimePeriodKt.monthlyPeriods$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthlyPeriods$default, 10));
        Iterator it = monthlyPeriods$default.iterator();
        while (it.hasNext()) {
            arrayList.add(this.fitnessProvider.getFitnessIndexDataWithResolution((TimePeriod) it.next(), 1));
        }
        return arrayList;
    }

    public final FitnessProvider.Profile getProfile() {
        return this.profile;
    }

    public final CommonFlow<ChartData<PointEntry>> observeFitnessIndexData(final TimePeriod timePeriod, final TimePeriod selectedTimePeriod, EntriesAmount nbrOfEntries, final DateFormatter xAxisLabelFormatter, final Function1<? super Long, String> markerLabelFormatter) {
        final Flow<List<? extends FitnessIndexEntry>[]> flow;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(selectedTimePeriod, "selectedTimePeriod");
        Intrinsics.checkNotNullParameter(nbrOfEntries, "nbrOfEntries");
        Intrinsics.checkNotNullParameter(xAxisLabelFormatter, "xAxisLabelFormatter");
        Intrinsics.checkNotNullParameter(markerLabelFormatter, "markerLabelFormatter");
        if (nbrOfEntries instanceof Months) {
            final Flow[] flowArr = (Flow[]) CollectionsKt___CollectionsKt.toList(monthIterable(timePeriod)).toArray(new Flow[0]);
            flow = new Flow<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$1

                /* compiled from: Zip.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$1$3", f = "FitnessIndexViewModel.kt", l = {292}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$1$3, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends FitnessIndexEntry>[]>, List<? extends FitnessIndexEntry>[], Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    int label;

                    public AnonymousClass3(Continuation continuation) {
                        super(3, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            FlowCollector flowCollector = (FlowCollector) this.L$0;
                            List[] listArr = (List[]) ((Object[]) this.L$1);
                            this.label = 1;
                            if (flowCollector.emit(listArr, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, List<? extends FitnessIndexEntry>[] listArr, Continuation<? super Unit> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                        anonymousClass3.L$0 = flowCollector;
                        anonymousClass3.L$1 = listArr;
                        return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, Continuation continuation) {
                    final Flow[] flowArr2 = flowArr;
                    Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends FitnessIndexEntry>[] invoke() {
                            return new List[flowArr2.length];
                        }
                    }, new AnonymousClass3(null), flowCollector, flowArr2);
                    if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return combineInternal;
                    }
                    return Unit.INSTANCE;
                }
            };
        } else if (nbrOfEntries instanceof Days) {
            final Flow[] flowArr2 = (Flow[]) CollectionsKt___CollectionsKt.toList(dayIterable(timePeriod)).toArray(new Flow[0]);
            flow = new Flow<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$2

                /* compiled from: Zip.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$2$3", f = "FitnessIndexViewModel.kt", l = {292}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$2$3, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends FitnessIndexEntry>[]>, List<? extends FitnessIndexEntry>[], Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    int label;

                    public AnonymousClass3(Continuation continuation) {
                        super(3, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            FlowCollector flowCollector = (FlowCollector) this.L$0;
                            List[] listArr = (List[]) ((Object[]) this.L$1);
                            this.label = 1;
                            if (flowCollector.emit(listArr, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, List<? extends FitnessIndexEntry>[] listArr, Continuation<? super Unit> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                        anonymousClass3.L$0 = flowCollector;
                        anonymousClass3.L$1 = listArr;
                        return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, Continuation continuation) {
                    final Flow[] flowArr3 = flowArr2;
                    Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends FitnessIndexEntry>[] invoke() {
                            return new List[flowArr3.length];
                        }
                    }, new AnonymousClass3(null), flowCollector, flowArr3);
                    if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return combineInternal;
                    }
                    return Unit.INSTANCE;
                }
            };
        } else if (nbrOfEntries instanceof EqualIntervals) {
            final Flow[] flowArr3 = (Flow[]) CollectionsKt___CollectionsKt.toList(equalIterable(timePeriod, (EqualIntervals) nbrOfEntries)).toArray(new Flow[0]);
            flow = new Flow<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$3

                /* compiled from: Zip.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$3$3", f = "FitnessIndexViewModel.kt", l = {292}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$3$3, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends FitnessIndexEntry>[]>, List<? extends FitnessIndexEntry>[], Continuation<? super Unit>, Object> {
                    private /* synthetic */ Object L$0;
                    /* synthetic */ Object L$1;
                    int label;

                    public AnonymousClass3(Continuation continuation) {
                        super(3, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            FlowCollector flowCollector = (FlowCollector) this.L$0;
                            List[] listArr = (List[]) ((Object[]) this.L$1);
                            this.label = 1;
                            if (flowCollector.emit(listArr, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, List<? extends FitnessIndexEntry>[] listArr, Continuation<? super Unit> continuation) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                        anonymousClass3.L$0 = flowCollector;
                        anonymousClass3.L$1 = listArr;
                        return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super List<? extends FitnessIndexEntry>[]> flowCollector, Continuation continuation) {
                    final Flow[] flowArr4 = flowArr3;
                    Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends FitnessIndexEntry>[]>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$combine$3.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final List<? extends FitnessIndexEntry>[] invoke() {
                            return new List[flowArr4.length];
                        }
                    }, new AnonymousClass3(null), flowCollector, flowArr4);
                    if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                        return combineInternal;
                    }
                    return Unit.INSTANCE;
                }
            };
        } else {
            throw new NoWhenBranchMatchedException();
        }
        final Flow<List<? extends PointEntry>> flow2 = new Flow<List<? extends PointEntry>>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Function1 $markerLabelFormatter$inlined;
                final /* synthetic */ TimePeriod $selectedTimePeriod$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DateFormatter $xAxisLabelFormatter$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$1$2", f = "FitnessIndexViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DateFormatter dateFormatter, Function1 function1, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$xAxisLabelFormatter$inlined = dateFormatter;
                    this.$markerLabelFormatter$inlined = function1;
                    this.$selectedTimePeriod$inlined = timePeriod;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00c6  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        Method dump skipped, instructions count: 221
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends PointEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, xAxisLabelFormatter, markerLabelFormatter, selectedTimePeriod), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        };
        return FlowExtensionsKt.asCommonFlow(new Flow<ChartData<? extends PointEntry>>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ FitnessIndexViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2", f = "FitnessIndexViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, FitnessIndexViewModel fitnessIndexViewModel, TimePeriod timePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = fitnessIndexViewModel;
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
                        boolean r0 = r8 instanceof com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2$1 r0 = (com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2$1 r0 = new com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2$2$1
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
                        com.animaconnected.watch.workout.FitnessIndexViewModel r2 = r6.this$0
                        com.animaconnected.watch.fitness.FitnessProvider r2 = com.animaconnected.watch.workout.FitnessIndexViewModel.access$getFitnessProvider$p(r2)
                        com.animaconnected.watch.fitness.TimePeriod r4 = r6.$timePeriod$inlined
                        kotlinx.datetime.Instant r4 = r4.getStart()
                        boolean r2 = r2.hasFitnessIndexDataBefore(r4)
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
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.FitnessIndexViewModel$observeFitnessIndexData$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
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

    public final CommonFlow<FitnessIndexData> observeLatestFitnessIndex() {
        final CommonFlow<Float> fitnessIndexLatest = this.fitnessProvider.getFitnessIndexLatest();
        return FlowExtensionsKt.asCommonFlow(new Flow<FitnessIndexData>() { // from class: com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ FitnessIndexViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2", f = "FitnessIndexViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, FitnessIndexViewModel fitnessIndexViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = fitnessIndexViewModel;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L54
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        java.lang.Float r6 = (java.lang.Float) r6
                        if (r6 == 0) goto L4a
                        com.animaconnected.watch.workout.FitnessIndexData$Companion r2 = com.animaconnected.watch.workout.FitnessIndexData.Companion
                        float r6 = r6.floatValue()
                        int r6 = (int) r6
                        com.animaconnected.watch.workout.FitnessIndexViewModel r4 = r5.this$0
                        com.animaconnected.watch.fitness.FitnessProvider$Profile r4 = r4.getProfile()
                        com.animaconnected.watch.workout.FitnessIndexData r6 = r2.fromValue(r6, r4)
                        goto L4b
                    L4a:
                        r6 = 0
                    L4b:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L54
                        return r1
                    L54:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.FitnessIndexViewModel$observeLatestFitnessIndex$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super FitnessIndexData> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }
}
