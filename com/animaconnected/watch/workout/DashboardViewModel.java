package com.animaconnected.watch.workout;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.BasicStorage;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.NumberFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: DashboardViewModel.kt */
/* loaded from: classes3.dex */
public final class DashboardViewModel {
    public static final Companion Companion = new Companion(null);
    public static final String IS_ONBOARDING_KEY = "isOnboarding";
    public static final String ONBOARDING_STORAGE_NAME = "HealthOnboarding";
    private final StateFlow<HealthOnboardingState> currentState;
    private final FitnessProvider fitnessProvider;
    private final FitnessProvider.Profile.Measurement measurement;
    private MutableStateFlow<HealthOnboardingState> state;
    private final BasicStorage storage;

    /* compiled from: DashboardViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DashboardViewModel(FitnessProvider fitnessProvider) {
        HealthOnboardingState healthOnboardingState;
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        this.fitnessProvider = fitnessProvider;
        BasicStorage createStorage = ServiceLocator.INSTANCE.getStorageFactory().createStorage(ONBOARDING_STORAGE_NAME);
        this.storage = createStorage;
        if (Intrinsics.areEqual(createStorage.getBoolean(IS_ONBOARDING_KEY), Boolean.FALSE)) {
            healthOnboardingState = HealthOnboardingState.Inactive;
        } else {
            healthOnboardingState = HealthOnboardingState.DailyGoal;
        }
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(healthOnboardingState);
        this.state = MutableStateFlow;
        this.currentState = MutableStateFlow;
        this.measurement = fitnessProvider.getProfile().getMeasurement();
    }

    public static /* synthetic */ CommonFlow getLatestWorkout$default(DashboardViewModel dashboardViewModel, TimePeriod timePeriod, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            timePeriod = TimePeriod.Companion.relevant();
        }
        return dashboardViewModel.getLatestWorkout(timePeriod);
    }

    public static /* synthetic */ CommonFlow lastSynced$default(DashboardViewModel dashboardViewModel, DateFormatter dateFormatter, DateFormatter dateFormatter2, int r7, Object obj) {
        if ((r7 & 1) != 0) {
            dateFormatter = StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), "EEE " + DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null);
        }
        if ((r7 & 2) != 0) {
            dateFormatter2 = StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null);
        }
        return dashboardViewModel.lastSynced(dateFormatter, dateFormatter2);
    }

    public final StateFlow<HealthOnboardingState> getCurrentState() {
        return this.currentState;
    }

    public final DailyGoalItem getDailyGoalItem() {
        final NumberFormatter createNumberFormatter = ServiceLocator.INSTANCE.getStringsBackend().createNumberFormatter(1, 7, 0, 0);
        FitnessProvider fitnessProvider = this.fitnessProvider;
        TimePeriod.Companion companion = TimePeriod.Companion;
        final CommonFlow<List<StepEntry>> stepsWithResolution = fitnessProvider.getStepsWithResolution(TimePeriod.Companion.day$default(companion, null, null, 3, null), 1);
        CommonFlow asCommonFlow = FlowExtensionsKt.asCommonFlow(new Flow<BarEntry>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ NumberFormatter $formatter$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, NumberFormatter numberFormatter) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$formatter$inlined = numberFormatter;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        r18 = this;
                        r0 = r18
                        r1 = r20
                        boolean r2 = r1 instanceof com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L33
                        if (r4 != r5) goto L2b
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto L98
                    L2b:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L33:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r19
                        java.util.List r4 = (java.util.List) r4
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r6 = r4.iterator()
                        r7 = 0
                        r9 = r7
                    L44:
                        boolean r8 = r6.hasNext()
                        if (r8 == 0) goto L56
                        java.lang.Object r8 = r6.next()
                        com.animaconnected.watch.fitness.StepEntry r8 = (com.animaconnected.watch.fitness.StepEntry) r8
                        int r8 = r8.getSteps()
                        int r9 = r9 + r8
                        goto L44
                    L56:
                        r10 = 0
                        r13 = 0
                        com.animaconnected.watch.strings.Key r6 = com.animaconnected.watch.strings.Key.DailyGoals_GraphOverlay_Steps
                        java.lang.String[] r8 = new java.lang.String[r5]
                        com.animaconnected.watch.device.NumberFormatter r14 = r0.$formatter$inlined
                        java.util.Iterator r4 = r4.iterator()
                        r15 = r7
                    L63:
                        boolean r16 = r4.hasNext()
                        if (r16 == 0) goto L76
                        java.lang.Object r16 = r4.next()
                        com.animaconnected.watch.fitness.StepEntry r16 = (com.animaconnected.watch.fitness.StepEntry) r16
                        int r16 = r16.getSteps()
                        int r15 = r16 + r15
                        goto L63
                    L76:
                        double r11 = (double) r15
                        java.lang.String r4 = r14.format(r11)
                        r8[r7] = r4
                        java.lang.String r14 = com.animaconnected.watch.strings.StringsExtensionsKt.getAppString(r6, r8)
                        r16 = 46
                        r17 = 0
                        com.animaconnected.watch.graphs.BarEntry r4 = new com.animaconnected.watch.graphs.BarEntry
                        r15 = 0
                        r8 = r4
                        r6 = 0
                        r11 = r6
                        r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17)
                        r2.label = r5
                        java.lang.Object r1 = r1.emit(r4, r2)
                        if (r1 != r3) goto L98
                        return r3
                    L98:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BarEntry> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, createNumberFormatter), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        final CommonFlow<List<StandEntry>> standData = this.fitnessProvider.getStandData(TimePeriod.Companion.day$default(companion, null, null, 3, null));
        CommonFlow asCommonFlow2 = FlowExtensionsKt.asCommonFlow(new Flow<BarEntry>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ NumberFormatter $formatter$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$2$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$2$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, NumberFormatter numberFormatter) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$formatter$inlined = numberFormatter;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r20, kotlin.coroutines.Continuation r21) {
                    /*
                        Method dump skipped, instructions count: 245
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BarEntry> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, createNumberFormatter), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        final CommonFlow<List<ExerciseEntry>> exerciseData = this.fitnessProvider.getExerciseData(TimePeriod.Companion.day$default(companion, null, null, 3, null));
        return new DailyGoalItem(asCommonFlow, asCommonFlow2, FlowExtensionsKt.asCommonFlow(new Flow<BarEntry>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ NumberFormatter $formatter$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, NumberFormatter numberFormatter) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$formatter$inlined = numberFormatter;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        r18 = this;
                        r0 = r18
                        r1 = r20
                        boolean r2 = r1 instanceof com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2$1 r2 = (com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2$1 r2 = new com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L33
                        if (r4 != r5) goto L2b
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto L98
                    L2b:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L33:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r19
                        java.util.List r4 = (java.util.List) r4
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r6 = r4.iterator()
                        r7 = 0
                        r9 = r7
                    L44:
                        boolean r8 = r6.hasNext()
                        if (r8 == 0) goto L56
                        java.lang.Object r8 = r6.next()
                        com.animaconnected.watch.fitness.ExerciseEntry r8 = (com.animaconnected.watch.fitness.ExerciseEntry) r8
                        int r8 = r8.getActiveMinutes()
                        int r9 = r9 + r8
                        goto L44
                    L56:
                        r10 = 0
                        r13 = 0
                        com.animaconnected.watch.strings.Key r6 = com.animaconnected.watch.strings.Key.DailyGoals_GraphOverlay_Minutes
                        java.lang.String[] r8 = new java.lang.String[r5]
                        com.animaconnected.watch.device.NumberFormatter r14 = r0.$formatter$inlined
                        java.util.Iterator r4 = r4.iterator()
                        r15 = r7
                    L63:
                        boolean r16 = r4.hasNext()
                        if (r16 == 0) goto L76
                        java.lang.Object r16 = r4.next()
                        com.animaconnected.watch.fitness.ExerciseEntry r16 = (com.animaconnected.watch.fitness.ExerciseEntry) r16
                        int r16 = r16.getActiveMinutes()
                        int r15 = r16 + r15
                        goto L63
                    L76:
                        double r11 = (double) r15
                        java.lang.String r4 = r14.format(r11)
                        r8[r7] = r4
                        java.lang.String r14 = com.animaconnected.watch.strings.StringsExtensionsKt.getAppString(r6, r8)
                        r16 = 46
                        r17 = 0
                        com.animaconnected.watch.graphs.BarEntry r4 = new com.animaconnected.watch.graphs.BarEntry
                        r15 = 0
                        r8 = r4
                        r6 = 0
                        r11 = r6
                        r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17)
                        r2.label = r5
                        java.lang.Object r1 = r1.emit(r4, r2)
                        if (r1 != r3) goto L98
                        return r3
                    L98:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getDailyGoalItem$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BarEntry> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, createNumberFormatter), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }));
    }

    public final CommonFlow<SessionListItem> getLatestWorkout(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final CommonFlow<List<Session>> sessionsOverview = this.fitnessProvider.getSessionsOverview(timePeriod);
        return FlowExtensionsKt.asCommonFlow(new Flow<SessionListItem>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DashboardViewModel this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DashboardViewModel dashboardViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = dashboardViewModel;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                /* JADX WARN: Type inference failed for: r2v12 */
                /* JADX WARN: Type inference failed for: r2v13 */
                /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
                /* JADX WARN: Type inference failed for: r2v6 */
                /* JADX WARN: Type inference failed for: r2v7 */
                /* JADX WARN: Type inference failed for: r2v9 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L30
                        if (r2 != r3) goto L28
                        kotlin.ResultKt.throwOnFailure(r12)
                        goto Ld3
                    L28:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L30:
                        kotlin.ResultKt.throwOnFailure(r12)
                        kotlinx.coroutines.flow.FlowCollector r12 = r10.$this_unsafeFlow
                        java.util.List r11 = (java.util.List) r11
                        boolean r2 = r11.isEmpty()
                        r4 = 0
                        if (r2 == 0) goto L40
                        goto Lca
                    L40:
                        java.lang.Iterable r11 = (java.lang.Iterable) r11
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r2.<init>()
                        java.util.Iterator r11 = r11.iterator()
                    L4b:
                        boolean r5 = r11.hasNext()
                        if (r5 == 0) goto L69
                        java.lang.Object r5 = r11.next()
                        r6 = r5
                        com.animaconnected.watch.fitness.Session r6 = (com.animaconnected.watch.fitness.Session) r6
                        com.animaconnected.watch.fitness.SessionStatus r6 = r6.getStatus()
                        com.animaconnected.watch.fitness.SessionStatus r7 = com.animaconnected.watch.fitness.SessionStatus.Deleted
                        if (r6 == r7) goto L62
                        r6 = r3
                        goto L63
                    L62:
                        r6 = 0
                    L63:
                        if (r6 == 0) goto L4b
                        r2.add(r5)
                        goto L4b
                    L69:
                        java.util.ArrayList r11 = new java.util.ArrayList
                        r5 = 10
                        int r5 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r2, r5)
                        r11.<init>(r5)
                        java.util.Iterator r2 = r2.iterator()
                    L78:
                        boolean r5 = r2.hasNext()
                        if (r5 == 0) goto L94
                        java.lang.Object r5 = r2.next()
                        com.animaconnected.watch.fitness.Session r5 = (com.animaconnected.watch.fitness.Session) r5
                        com.animaconnected.watch.workout.SessionListItem$Companion r6 = com.animaconnected.watch.workout.SessionListItem.Companion
                        com.animaconnected.watch.workout.DashboardViewModel r7 = r10.this$0
                        com.animaconnected.watch.fitness.FitnessProvider$Profile$Measurement r7 = com.animaconnected.watch.workout.DashboardViewModel.access$getMeasurement$p(r7)
                        com.animaconnected.watch.workout.SessionListItem r5 = r6.fromSession(r5, r7)
                        r11.add(r5)
                        goto L78
                    L94:
                        java.util.Iterator r11 = r11.iterator()
                        boolean r2 = r11.hasNext()
                        if (r2 != 0) goto L9f
                        goto Lca
                    L9f:
                        java.lang.Object r2 = r11.next()
                        boolean r4 = r11.hasNext()
                        if (r4 != 0) goto Lab
                    La9:
                        r4 = r2
                        goto Lca
                    Lab:
                        r4 = r2
                        com.animaconnected.watch.workout.SessionListItem r4 = (com.animaconnected.watch.workout.SessionListItem) r4
                        long r4 = r4.getTimestamp()
                    Lb2:
                        java.lang.Object r6 = r11.next()
                        r7 = r6
                        com.animaconnected.watch.workout.SessionListItem r7 = (com.animaconnected.watch.workout.SessionListItem) r7
                        long r7 = r7.getTimestamp()
                        int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                        if (r9 >= 0) goto Lc3
                        r2 = r6
                        r4 = r7
                    Lc3:
                        boolean r6 = r11.hasNext()
                        if (r6 != 0) goto Lb2
                        goto La9
                    Lca:
                        r0.label = r3
                        java.lang.Object r11 = r12.emit(r4, r0)
                        if (r11 != r1) goto Ld3
                        return r1
                    Ld3:
                        kotlin.Unit r11 = kotlin.Unit.INSTANCE
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getLatestWorkout$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SessionListItem> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final List<MetricListItem<?>> getMetrics() {
        TimePeriod day$default = TimePeriod.Companion.day$default(TimePeriod.Companion, null, null, 3, null);
        final CommonFlow<List<StepEntry>> stepsWithResolution = this.fitnessProvider.getStepsWithResolution(day$default, 1);
        CommonFlow asCommonFlow = FlowExtensionsKt.asCommonFlow(new Flow<String>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L5c
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
                        java.lang.String r6 = java.lang.String.valueOf(r2)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L5c
                        return r1
                    L5c:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        final CommonFlow<List<WatchFitnessProvider.CalorieEntry>> caloriesWithResolution = this.fitnessProvider.getCaloriesWithResolution(day$default, 1);
        CommonFlow asCommonFlow2 = FlowExtensionsKt.asCommonFlow(new Flow<String>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2$1, reason: invalid class name */
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L5c
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
                        java.lang.String r6 = java.lang.String.valueOf(r2)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L5c
                        return r1
                    L5c:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        final CommonFlow<Float> fitnessIndexLatest = this.fitnessProvider.getFitnessIndexLatest();
        CommonFlow asCommonFlow3 = FlowExtensionsKt.asCommonFlow(new Flow<String>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L53
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.lang.Float r5 = (java.lang.Float) r5
                        if (r5 == 0) goto L48
                        float r5 = r5.floatValue()
                        int r5 = (int) r5
                        java.lang.Integer r2 = new java.lang.Integer
                        r2.<init>(r5)
                        java.lang.String r5 = r2.toString()
                        if (r5 != 0) goto L4a
                    L48:
                        java.lang.String r5 = "-"
                    L4a:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L53
                        return r1
                    L53:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        FitnessProvider fitnessProvider = this.fitnessProvider;
        final CommonFlow<SleepSession> lastNightSleepData = fitnessProvider.getLastNightSleepData(fitnessProvider.getProfile().getBedtime());
        return CollectionsKt__CollectionsKt.listOf((Object[]) new MetricListItem[]{new StringMetricListItem(WorkoutMetricType.Steps, asCommonFlow, null, 4, null), new HeartrateMetricListItem(WorkoutMetricType.HeartRate, FlowExtensionsKt.asCommonFlow(this.fitnessProvider.getHeartrateLiveData()), null, 4, null), new StringMetricListItem(WorkoutMetricType.Calories, asCommonFlow2, null, 4, null), new StringMetricListItem(WorkoutMetricType.VO2Max, asCommonFlow3, null, 4, null), new StringMetricListItem(WorkoutMetricType.Sleep, FlowExtensionsKt.asCommonFlow(new Flow<String>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L56
                    L27:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        com.animaconnected.watch.fitness.sleep.SleepSession r7 = (com.animaconnected.watch.fitness.sleep.SleepSession) r7
                        com.animaconnected.watch.fitness.sleep.SleepSessionState r2 = r7.getState()
                        com.animaconnected.watch.fitness.sleep.SleepSessionState r4 = com.animaconnected.watch.fitness.sleep.SleepSessionState.Invalid
                        if (r2 != r4) goto L41
                        java.lang.String r7 = "-"
                        goto L4d
                    L41:
                        long r4 = com.animaconnected.watch.fitness.sleep.SleepSessionKt.totalSleepAmount(r7)
                        long r4 = kotlin.time.Duration.m1677getInWholeMillisecondsimpl(r4)
                        java.lang.String r7 = com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt.formatDurationHourMinutes(r4)
                    L4d:
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L56
                        return r1
                    L56:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$getMetrics$$inlined$map$4.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }), null, 4, null)});
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getWorkoutDetailed(long r5, kotlin.coroutines.Continuation<? super com.animaconnected.watch.workout.SessionListItem> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.watch.workout.DashboardViewModel$getWorkoutDetailed$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.watch.workout.DashboardViewModel$getWorkoutDetailed$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$getWorkoutDetailed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.workout.DashboardViewModel$getWorkoutDetailed$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$getWorkoutDetailed$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.watch.workout.DashboardViewModel r5 = (com.animaconnected.watch.workout.DashboardViewModel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L44
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.fitness.FitnessProvider r7 = r4.fitnessProvider
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.getSessionsDetailed(r5, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            com.animaconnected.watch.fitness.Session r7 = (com.animaconnected.watch.fitness.Session) r7
            if (r7 != 0) goto L4a
            r5 = 0
            return r5
        L4a:
            com.animaconnected.watch.workout.SessionListItem$Companion r6 = com.animaconnected.watch.workout.SessionListItem.Companion
            com.animaconnected.watch.fitness.FitnessProvider$Profile$Measurement r5 = r5.measurement
            com.animaconnected.watch.workout.SessionListItem r5 = r6.fromSession(r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel.getWorkoutDetailed(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CommonFlow<String> lastSynced(final DateFormatter dateFormatter, final DateFormatter timeFormatter) {
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(timeFormatter, "timeFormatter");
        final CommonFlow<Long> lastSynced = this.fitnessProvider.getLastSynced();
        return FlowExtensionsKt.asCommonFlow(new Flow<String>() { // from class: com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ DateFormatter $dateFormatter$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DateFormatter $timeFormatter$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2", f = "DashboardViewModel.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DateFormatter dateFormatter, DateFormatter dateFormatter2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$dateFormatter$inlined = dateFormatter;
                    this.$timeFormatter$inlined = dateFormatter2;
                }

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
                        boolean r0 = r9 instanceof com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L6c
                    L27:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        java.lang.Long r8 = (java.lang.Long) r8
                        if (r8 == 0) goto L62
                        r8.longValue()
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        r2.<init>()
                        com.animaconnected.watch.strings.Key r4 = com.animaconnected.watch.strings.Key.last_synced
                        java.lang.String r4 = com.animaconnected.watch.strings.StringsExtensionsKt.getAppString(r4)
                        r2.append(r4)
                        r4 = 32
                        r2.append(r4)
                        long r4 = r8.longValue()
                        com.animaconnected.watch.device.DateFormatter r8 = r7.$dateFormatter$inlined
                        com.animaconnected.watch.device.DateFormatter r6 = r7.$timeFormatter$inlined
                        java.lang.String r8 = com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt.toReadablePast(r4, r8, r6)
                        r2.append(r8)
                        java.lang.String r8 = r2.toString()
                        goto L63
                    L62:
                        r8 = 0
                    L63:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto L6c
                        return r1
                    L6c:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.workout.DashboardViewModel$lastSynced$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, dateFormatter, timeFormatter), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void onboardingDailyGoalDone() {
        MutableStateFlow<HealthOnboardingState> mutableStateFlow = this.state;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), HealthOnboardingState.Workout));
    }

    public final void onboardingDone() {
        MutableStateFlow<HealthOnboardingState> mutableStateFlow = this.state;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), HealthOnboardingState.Inactive));
    }

    public final void onboardingLetsGoDone() {
        this.storage.put(IS_ONBOARDING_KEY, false);
        MutableStateFlow<HealthOnboardingState> mutableStateFlow = this.state;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), HealthOnboardingState.InteractionComplete));
    }

    public final void onboardingMetricDone() {
        MutableStateFlow<HealthOnboardingState> mutableStateFlow = this.state;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), HealthOnboardingState.LetsGo));
    }

    public final void onboardingWorkoutDone() {
        MutableStateFlow<HealthOnboardingState> mutableStateFlow = this.state;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), HealthOnboardingState.Metric));
    }
}
