package com.animaconnected.watch.fitness;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.fitness.mock.CaloriesMock;
import com.animaconnected.watch.fitness.mock.ElevationMock;
import com.animaconnected.watch.fitness.mock.ExerciseMock;
import com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator;
import com.animaconnected.watch.fitness.mock.FakeSessionGenerator;
import com.animaconnected.watch.fitness.mock.FitnessIndexMock;
import com.animaconnected.watch.fitness.mock.HeartRateMock;
import com.animaconnected.watch.fitness.mock.LocationMock;
import com.animaconnected.watch.fitness.mock.ProfileMock;
import com.animaconnected.watch.fitness.mock.SessionMock;
import com.animaconnected.watch.fitness.mock.SleepMock;
import com.animaconnected.watch.fitness.mock.StandMock;
import com.animaconnected.watch.fitness.mock.StepsMock;
import com.animaconnected.watch.fitness.session.SessionDataListener;
import com.animaconnected.watch.fitness.session.SessionProviderImpl;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import com.animaconnected.watch.utils.WatchLibResult;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import com.animaconnected.watch.workout.SessionListItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.EmptyFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;
import kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.datetime.Instant;

/* compiled from: MockFitnessProvider.kt */
/* loaded from: classes3.dex */
public final class MockFitnessProvider implements FitnessProvider, FakeSessionGenerator, FakeHeartRateGenerator {
    private final Lazy caloriesMock$delegate;
    private final Lazy elevationMock$delegate;
    private final Lazy exerciseMock$delegate;
    private final Lazy fitnessIndexMock$delegate;
    private final String hdid;
    private final HeartRateMock heartRateMock;
    private final ProfileMock profile;
    private final SessionMock sessionMock;
    private final FitnessProvider.SessionProvider sessionProvider;
    private final Lazy sleepMock$delegate;
    private final Lazy standMock$delegate;
    private final Lazy stepsMock$delegate;

    public MockFitnessProvider() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final CaloriesMock getCaloriesMock() {
        return (CaloriesMock) this.caloriesMock$delegate.getValue();
    }

    private final ExerciseMock getExerciseMock() {
        return (ExerciseMock) this.exerciseMock$delegate.getValue();
    }

    private final FitnessIndexMock getFitnessIndexMock() {
        return (FitnessIndexMock) this.fitnessIndexMock$delegate.getValue();
    }

    private final List<Split> getListOfSplitEntries() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new Split[]{new Split(1L, 1000.0d), new Split(2L, 2000.0d), new Split(3L, 3000.0d), new Split(4L, 4000.0d), new Split(5L, 5000.0d)});
    }

    private final SleepMock getSleepMock() {
        return (SleepMock) this.sleepMock$delegate.getValue();
    }

    private final StandMock getStandMock() {
        return (StandMock) this.standMock$delegate.getValue();
    }

    private final StepsMock getStepsMock() {
        return (StepsMock) this.stepsMock$delegate.getValue();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session bikeSession() {
        return this.sessionMock.bikeSession();
    }

    public final List<Split> calculateSplits() {
        return getListOfSplitEntries();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object deleteSession(Session session, Continuation<? super WatchLibResult<Unit, ? extends Exception>> continuation) {
        return new WatchLibResult.Success(Unit.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getAvgCaloriesPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<WatchFitnessProvider.CalorieEntry>> continuation) {
        final CommonFlow<List<WatchFitnessProvider.CalorieEntry>> caloriesWithResolution = getCaloriesMock().getCaloriesWithResolution(timePeriod, 1);
        return FlowExtensionsKt.asCommonFlow(new Flow<WatchFitnessProvider.CalorieEntry>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2", f = "MockFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2$1, reason: invalid class name */
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

                /* JADX WARN: Multi-variable type inference failed */
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L43
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L43
                        return r1
                    L43:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.MockFitnessProvider$getAvgCaloriesPerMonth$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super WatchFitnessProvider.CalorieEntry> flowCollector, Continuation continuation2) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation2);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getAvgStepsPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<List<StepEntry>>> continuation) {
        return getStepsMock().getDataWithResolution(timePeriod, 1);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public int getBMRDuring(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return 0;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public List<WatchFitnessProvider.CalorieEntry> getCaloriesBMRHistorySince(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<WatchFitnessProvider.CalorieEntry>> getCaloriesWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getCaloriesMock().getCaloriesWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<Entry>> getData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(getStepsData(timePeriod), getHeartrateData(timePeriod), new MockFitnessProvider$getData$1(null)), getSessionsData(timePeriod), new MockFitnessProvider$getData$2(null)), getLocationData(timePeriod), new MockFitnessProvider$getData$3(null)));
    }

    public final ElevationMock getElevationMock() {
        return (ElevationMock) this.elevationMock$delegate.getValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ExerciseEntry>> getExerciseData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getExerciseMock().getData(timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ExerciseEntry>> getExerciseWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getExerciseMock().getDataWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<FitnessIndexEntry>> getFitnessIndexDataWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getFitnessIndexMock().getDataWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Float> getFitnessIndexLatest() {
        return getFitnessIndexMock().getLatestValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HealthGoals> getGoal(long j) {
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(new HealthGoals(1000, 8, 120)));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public HealthGoals getGoalOnce(long j) {
        return new HealthGoals(1000, 8, 120);
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1452getHdidV9ZILtA() {
        return this.hdid;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateSummary>> getHeartRateDataWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return this.heartRateMock.getHeartRateDataWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateEntry> getHeartRateHistorySince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    public final HeartRateMock getHeartRateMock() {
        return this.heartRateMock;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateEntry>> getHeartrateData(TimePeriod timePeriod) {
        List<HeartrateEntry> dailyHeartRateData;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        TimePeriod.Companion companion = TimePeriod.Companion;
        if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.day$default(companion, timePeriod.getStart(), null, 2, null))) {
            HeartRateMock heartRateMock = this.heartRateMock;
            Instant start = timePeriod.getStart();
            int r1 = Duration.$r8$clinit;
            dailyHeartRateData = heartRateMock.m1520generateHeartRateDataSxA4cEA(start, 230, DurationKt.toDuration(5, DurationUnit.MINUTES));
        } else if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.week$default(companion, timePeriod.getStart(), null, 2, null))) {
            dailyHeartRateData = this.heartRateMock.getDailyHeartRateData(timePeriod);
        } else if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.month$default(companion, timePeriod.getStart(), null, 2, null))) {
            dailyHeartRateData = this.heartRateMock.getDailyHeartRateData(timePeriod);
        } else if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.year$default(companion, timePeriod.getStart(), null, 2, null))) {
            dailyHeartRateData = this.heartRateMock.getMonthlyHeartRateData(timePeriod);
        } else {
            dailyHeartRateData = this.heartRateMock.getDailyHeartRateData(timePeriod);
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(dailyHeartRateData));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateEntry>> getHeartrateDataForCurrentDevice(TimePeriod timePeriod) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        Pair pair;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        int r0 = Duration.$r8$clinit;
        long duration = DurationKt.toDuration(2, DurationUnit.MINUTES);
        Instant start = timePeriod.getStart();
        ArrayList arrayList = new ArrayList();
        do {
            double m1673divLRDsOJo = Duration.m1673divLRDsOJo(start.m1704minus5sfh64U(timePeriod.getStart()), timePeriod.m1505getDurationUwyO8pc());
            if (0.0d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.1d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), 100);
            } else {
                if (0.1d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.3d) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), Integer.valueOf(R.styleable.AppTheme_subComplicationDropZoneNotSelected));
                } else {
                    if (0.3d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.4d) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), 100);
                    } else {
                        if (0.4d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.45d) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            pair = new Pair(null, 100);
                        } else {
                            if (0.45d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.55d) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            if (z5) {
                                pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), 100);
                            } else {
                                if (0.55d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.6d) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    pair = new Pair(null, 100);
                                } else {
                                    if (0.6d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.7d) {
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z7) {
                                        pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), 100);
                                    } else {
                                        if (0.7d <= m1673divLRDsOJo && m1673divLRDsOJo <= 0.8d) {
                                            z8 = true;
                                        } else {
                                            z8 = false;
                                        }
                                        if (z8) {
                                            pair = new Pair(null, 100);
                                        } else {
                                            if (0.8d <= m1673divLRDsOJo && m1673divLRDsOJo <= 1.0d) {
                                                z9 = true;
                                            } else {
                                                z9 = false;
                                            }
                                            if (z9) {
                                                pair = new Pair(Integer.valueOf((int) ((Math.sin(m1673divLRDsOJo * 40) * 20) + 70)), 100);
                                            } else {
                                                pair = new Pair(0, 100);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Integer num = (Integer) pair.first;
            int intValue = ((Number) pair.second).intValue();
            if (num != null) {
                arrayList.add(new HeartrateEntry(this.hdid, start.toEpochMilliseconds(), num.intValue(), intValue, (Integer) null, (Integer) null, 48, (DefaultConstructorMarker) null));
            }
            start = start.m1706plusLRDsOJo(duration);
        } while (start.compareTo(timePeriod.getEnd()) <= 0);
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt___CollectionsKt.toList(arrayList)));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateMetricItem> getHeartrateLiveData() {
        return this.heartRateMock.getLiveData();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SleepSession> getLastNightSleepData(Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        return getSleepMock().getLastNightData(bedtime);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Long> getLastSynced() {
        return FlowExtensionsKt.asCommonFlow(new SafeFlow(new MockFitnessProvider$getLastSynced$1(null)));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateEntry> getLatestHeartrateDataForCurrentDevice() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    /* renamed from: getLiveHeartRateDelay-UwyO8pc, reason: not valid java name */
    public long mo1453getLiveHeartRateDelayUwyO8pc() {
        return this.heartRateMock.mo1453getLiveHeartRateDelayUwyO8pc();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<LocationEntry>> getLocationData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(this.sessionMock.locationEntries()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getLocationForSession(long j, Continuation<? super List<LocationEntry>> continuation) {
        return LocationMock.INSTANCE.getRunningRoute();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public FitnessProvider.Profile.Measurement getMeasurement() {
        return this.sessionMock.getMeasurement();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public Function0<Integer> getNextHeartRateValue() {
        return this.heartRateMock.getNextHeartRateValue();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public Function0<Integer> getNextRestingHeartRateValue() {
        return this.heartRateMock.getNextRestingHeartRateValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<PowerEntry>> getPowerDataForCurrentDevice(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(EmptyList.INSTANCE));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<FitnessIndexEntry>> getRawFitnessIndexData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getFitnessIndexMock().getData(timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(this.heartRateMock.getDailyRestingHeartRateData(timePeriod)));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateDataWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return this.heartRateMock.getRestingHeartRateDataWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public FitnessProvider.SessionProvider getSessionProvider() {
        return this.sessionProvider;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SessionEntry>> getSessionsData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(EmptyList.INSTANCE));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getSessionsDetailed(long j, Continuation<? super Session> continuation) {
        return walkingSession();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Session> getSessionsDetailedSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<Session>> getSessionsOverview(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return sessions();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Session> getSessionsOverviewsSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SleepEntry>> getSleepData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getSleepMock().getData();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SleepHistoryEntry>> getSleepHistoryData(TimePeriod timePeriod, Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        return getSleepMock().getHistoryData(timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public SleepHistoryEntry getSleepHistoryLatestEntry() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SleepSession> getSleepSessionsSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SpeedCalibrationEntry>> getSpeedCalibrationData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StandEntry>> getStandData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStandMock().getData(timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StandEntry>> getStandWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStandMock().getDataWithResolution(timePeriod, r3);
    }

    public final Integer getStaticExerciseValue() {
        return getExerciseMock().getStaticExerciseValue();
    }

    public final Integer getStaticStandValue() {
        return getStandMock().getStaticStandValue();
    }

    public final Integer getStaticStepsValue() {
        return getStepsMock().getStaticStepsValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ActivityEntry>> getStepsData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStepsMock().getData(timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public List<ActivityEntry> getStepsDataAsList(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return EmptyList.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StepEntry>> getStepsWithResolution(TimePeriod timePeriod, int r3) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStepsMock().getDataWithResolution(timePeriod, r3);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StressEntry>> getStressData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(EmptyList.INSTANCE));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StressEntry>> getStressDataWithResolution(TimePeriod timePeriod, int r2) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(EmptyList.INSTANCE));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<WristEntry>> getWristData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new WristEntry(this.hdid, timePeriod.getStartTs(), WristState.WornIBI, null))));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<WristEntry>> getWristDataForCurrentDevice(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new WristEntry(this.hdid, timePeriod.getStartTs() + 2000, WristState.WornIBI, null))));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasCaloriesDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return getCaloriesMock().getHasCaloriesDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasFitnessIndexDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return getFitnessIndexMock().getHasDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasHeartRateDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.heartRateMock.getHasDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasRestingHeartRateDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.heartRateMock.getHasDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object hasSessions(Continuation<? super Boolean> continuation) {
        return Boolean.FALSE;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasSleepHistoryBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return getSleepMock().getHasDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasStepsDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return getStepsMock().getHasDataBefore();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object hasValidSessions(Continuation<? super Boolean> continuation) {
        return Boolean.FALSE;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public SessionListItem healthOnboardingSessions() {
        return this.sessionMock.healthOnboardingSessions();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public boolean isLiveHeartRateEnabled() {
        return this.heartRateMock.isLiveHeartRateEnabled();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session otherSession() {
        return this.sessionMock.otherSession();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session runningSession() {
        return this.sessionMock.runningSession();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public CommonFlow<List<Session>> sessions() {
        return this.sessionMock.sessions();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object setGoal(Integer num, Integer num2, Integer num3, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    /* renamed from: setLiveHeartRateDelay-LRDsOJo, reason: not valid java name */
    public void mo1454setLiveHeartRateDelayLRDsOJo(long j) {
        this.heartRateMock.mo1454setLiveHeartRateDelayLRDsOJo(j);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setLiveHeartRateEnabled(boolean z) {
        this.heartRateMock.setLiveHeartRateEnabled(z);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public void setMeasurement(FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "<set-?>");
        this.sessionMock.setMeasurement(measurement);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setNextHeartRateValue(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.heartRateMock.setNextHeartRateValue(function0);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setNextRestingHeartRateValue(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.heartRateMock.setNextRestingHeartRateValue(function0);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public void setSessionIntervals(List<SessionMock.IntervalType> intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.sessionMock.setSessionIntervals(intervals);
    }

    public final void setStaticExerciseValue(Integer num) {
        getExerciseMock().setStaticExerciseValue(num);
    }

    public final void setStaticStandValue(Integer num) {
        getStandMock().setStaticStandValue(num);
    }

    public final void setStaticStepsValue(Integer num) {
        getStepsMock().setStaticStepsValue(num);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SyncResult> syncFitness() {
        return FlowExtensionsKt.asCommonFlow(new SafeFlow(new MockFitnessProvider$syncFitness$1(null)));
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session walkingSession() {
        return this.sessionMock.walkingSession();
    }

    public MockFitnessProvider(HeartRateMock heartRateMock, SessionMock sessionMock) {
        Intrinsics.checkNotNullParameter(heartRateMock, "heartRateMock");
        Intrinsics.checkNotNullParameter(sessionMock, "sessionMock");
        this.heartRateMock = heartRateMock;
        this.sessionMock = sessionMock;
        this.hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
        this.elevationMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ElevationMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$elevationMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ElevationMock invoke() {
                return new ElevationMock();
            }
        });
        this.stepsMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StepsMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$stepsMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StepsMock invoke() {
                return new StepsMock();
            }
        });
        this.caloriesMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CaloriesMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$caloriesMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CaloriesMock invoke() {
                return new CaloriesMock();
            }
        });
        this.fitnessIndexMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<FitnessIndexMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$fitnessIndexMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FitnessIndexMock invoke() {
                return new FitnessIndexMock();
            }
        });
        this.sleepMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SleepMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$sleepMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SleepMock invoke() {
                return new SleepMock();
            }
        });
        this.standMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<StandMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$standMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final StandMock invoke() {
                return new StandMock();
            }
        });
        this.exerciseMock$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ExerciseMock>() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$exerciseMock$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExerciseMock invoke() {
                return new ExerciseMock();
            }
        });
        this.profile = new ProfileMock();
        this.sessionProvider = new SessionProviderImpl(new SessionDataListener() { // from class: com.animaconnected.watch.fitness.MockFitnessProvider$sessionProvider$1
            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void feedToWatch(GpsQuality gpsQuality, Distance distance, Float f) {
                Intrinsics.checkNotNullParameter(gpsQuality, "gpsQuality");
                Intrinsics.checkNotNullParameter(distance, "distance");
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void sessionEnded() {
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void startSpeedCalibration() {
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void useConnectedGpsRequested(boolean z) {
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void stopSpeedCalibration(long j, long j2) {
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public ProfileMock getProfile() {
        return this.profile;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ MockFitnessProvider(com.animaconnected.watch.fitness.mock.HeartRateMock r1, com.animaconnected.watch.fitness.mock.SessionMock r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L9
            com.animaconnected.watch.fitness.mock.HeartRateMock r1 = new com.animaconnected.watch.fitness.mock.HeartRateMock
            r1.<init>()
        L9:
            r3 = r3 & 2
            if (r3 == 0) goto L13
            com.animaconnected.watch.fitness.mock.SessionMock r2 = new com.animaconnected.watch.fitness.mock.SessionMock
            r3 = 5
            r2.<init>(r3, r1)
        L13:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.MockFitnessProvider.<init>(com.animaconnected.watch.fitness.mock.HeartRateMock, com.animaconnected.watch.fitness.mock.SessionMock, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
