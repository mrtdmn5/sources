package com.animaconnected.watch.provider.demo;

import app.cash.sqldelight.TransactionWithoutReturn;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.ExerciseEntry;
import com.animaconnected.watch.fitness.FitnessConfig;
import com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt;
import com.animaconnected.watch.fitness.FitnessIndexEntry;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.FitnessQueries;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.InternalFitnessProvider;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.PowerEntry;
import com.animaconnected.watch.fitness.RestingHeartrateEntry;
import com.animaconnected.watch.fitness.SessionEntry;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import com.animaconnected.watch.provider.demo.DemoMode;
import com.animaconnected.watch.storage.WatchDb;
import com.animaconnected.watch.workout.DashboardViewModel;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.ReadonlySharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.datetime.Instant;

/* compiled from: DemoModeProvider.kt */
/* loaded from: classes3.dex */
public final class DemoModeProvider {
    public static final Companion Companion = new Companion(null);
    private static final String tag = "DemoModeProvider";
    private final MutableStateFlow<DemoMode> _demoMode;
    private final Analytics analytics;
    private final SharedFlow<DemoMode> demoMode;
    private final FitnessProvider fitnessProvider;
    private final long historyDuration;
    private final long hourOfDayToReset;
    private final CommonFlow<Boolean> isEnabledFlow;
    private Instant lastInteraction;
    private final Channel<Unit> notifyRequest;
    private final long requiredTimeSinceInteraction;
    private boolean resetAllRequested;
    private final long resetRecentInterval;
    private boolean resetRecentRequested;
    private RunState runState;
    private final Mutex runStateMutex;
    private final DemoModeStorage storage;
    private final WatchDb watchDb;
    private final WatchManager watchManager;

    /* compiled from: DemoModeProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final InternalFitnessProvider internal(FitnessProvider fitnessProvider) {
            Intrinsics.checkNotNull(fitnessProvider, "null cannot be cast to non-null type com.animaconnected.watch.fitness.InternalFitnessProvider");
            return (InternalFitnessProvider) fitnessProvider;
        }

        private Companion() {
        }
    }

    /* compiled from: DemoModeProvider.kt */
    /* loaded from: classes3.dex */
    public static final class RunState extends Enum<RunState> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RunState[] $VALUES;
        public static final RunState NotRunning = new RunState("NotRunning", 0);
        public static final RunState Running = new RunState("Running", 1);
        public static final RunState Exiting = new RunState("Exiting", 2);

        private static final /* synthetic */ RunState[] $values() {
            return new RunState[]{NotRunning, Running, Exiting};
        }

        static {
            RunState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private RunState(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<RunState> getEntries() {
            return $ENTRIES;
        }

        public static RunState valueOf(String str) {
            return (RunState) Enum.valueOf(RunState.class, str);
        }

        public static RunState[] values() {
            return (RunState[]) $VALUES.clone();
        }
    }

    /* compiled from: DemoModeProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[WatchDemoMode.values().length];
            try {
                r0[WatchDemoMode.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public DemoModeProvider(WatchManager watchManager, FitnessProvider fitnessProvider, WatchDb watchDb) {
        int r0;
        Object disabled;
        Intrinsics.checkNotNullParameter(watchManager, "watchManager");
        Intrinsics.checkNotNullParameter(fitnessProvider, "fitnessProvider");
        Intrinsics.checkNotNullParameter(watchDb, "watchDb");
        this.watchManager = watchManager;
        this.fitnessProvider = fitnessProvider;
        this.watchDb = watchDb;
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        DemoModeStorage demoModeStorage = new DemoModeStorage(serviceLocator.getStorageFactory());
        this.storage = demoModeStorage;
        WatchDemoMode watchDemoMode = demoModeStorage.getWatchDemoMode();
        if (watchDemoMode == null) {
            r0 = -1;
        } else {
            r0 = WhenMappings.$EnumSwitchMapping$0[watchDemoMode.ordinal()];
        }
        if (r0 != -1) {
            if (r0 != 1) {
                disabled = new DemoMode.Enabled.Idle(watchDemoMode);
            } else {
                disabled = new DemoMode.Disabled(false);
            }
        } else {
            disabled = new DemoMode.Disabled(true);
        }
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(disabled);
        this._demoMode = MutableStateFlow;
        this.analytics = serviceLocator.getAnalytics();
        final ReadonlySharedFlow asSharedFlow = FlowKt.asSharedFlow(MutableStateFlow);
        this.demoMode = asSharedFlow;
        this.isEnabledFlow = FlowExtensionsKt.asCommonFlow(FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2", f = "DemoModeProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L45
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.animaconnected.watch.provider.demo.DemoMode r5 = (com.animaconnected.watch.provider.demo.DemoMode) r5
                        boolean r5 = r5 instanceof com.animaconnected.watch.provider.demo.DemoMode.Enabled
                        java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }));
        this.runState = RunState.NotRunning;
        this.runStateMutex = new MutexImpl(false);
        Instant.Companion.getClass();
        this.lastInteraction = Instant.DISTANT_PAST;
        this.notifyRequest = ChannelKt.Channel$default(-1, null, 6);
        int r4 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.MINUTES;
        this.resetRecentInterval = DurationKt.toDuration(30, durationUnit);
        this.hourOfDayToReset = DurationKt.toDuration(3, DurationUnit.HOURS);
        this.historyDuration = DurationKt.toDuration(200, DurationUnit.DAYS);
        this.requiredTimeSinceInteraction = DurationKt.toDuration(5, durationUnit);
    }

    public final Object clearWatchDailyFitnessData(Watch watch, Continuation<? super Unit> continuation) {
        watch.getStorage$watch_release().put(FitnessSyncWatch.clearDailyFitnessDataKey, true);
        FitnessSyncWatch fitnessSync$watch_release = watch.getFitnessSync$watch_release();
        if (fitnessSync$watch_release != null) {
            Object writeDailyFitnessData = fitnessSync$watch_release.writeDailyFitnessData(watch.getStorage$watch_release(), continuation);
            if (writeDailyFitnessData == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeDailyFitnessData;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void deleteAllFitnessData(FitnessQueries fitnessQueries) {
        Instant.Companion companion = Instant.Companion;
        companion.getClass();
        Instant instant = Instant.DISTANT_FUTURE;
        fitnessQueries.deleteRawDataBefore(instant.toEpochMilliseconds());
        companion.getClass();
        fitnessQueries.deleteProcessedDataBefore(instant.toEpochMilliseconds());
    }

    public final void deleteAllFitnessDataAfter(FitnessQueries fitnessQueries, Instant instant) {
        fitnessQueries.deleteRawDataAfter(instant.toEpochMilliseconds());
        fitnessQueries.deleteProcessedDataAfter(instant.toEpochMilliseconds());
    }

    public final void generateAndInsertDemoData(FitnessQueries fitnessQueries, TimePeriod timePeriod, boolean z) {
        String m1046getHistoryDeviceIdV9ZILtA = this.watchManager.getCurrentWatch().m1046getHistoryDeviceIdV9ZILtA();
        DemoDataGenerator demoDataGenerator = new DemoDataGenerator(m1046getHistoryDeviceIdV9ZILtA, timePeriod, z, null);
        if (z) {
            HealthGoals healthGoals = demoDataGenerator.getHealthGoals();
            fitnessQueries.m1339insertGoalAjOicPU(Long.valueOf(timePeriod.getStartTs()), m1046getHistoryDeviceIdV9ZILtA, healthGoals.getSteps(), healthGoals.getStand(), healthGoals.getExercise());
        }
        insertSeq(fitnessQueries, demoDataGenerator.generate());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:            if (r0 == null) goto L15;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlinx.datetime.Instant getNextFullReset() {
        /*
            r4 = this;
            com.animaconnected.watch.provider.demo.DemoModeStorage r0 = r4.storage
            kotlinx.datetime.Instant r0 = r0.getLastResetFull()
            if (r0 == 0) goto L24
            int r1 = kotlin.time.Duration.$r8$clinit
            r1 = 24
            kotlin.time.DurationUnit r2 = kotlin.time.DurationUnit.HOURS
            long r1 = kotlin.time.DurationKt.toDuration(r1, r2)
            kotlinx.datetime.Instant r0 = r0.m1706plusLRDsOJo(r1)
            r1 = 2
            r2 = 0
            kotlinx.datetime.Instant r0 = com.animaconnected.info.DateTimeUtilsKt.getStartOfDay$default(r0, r2, r1, r2)
            long r1 = r4.hourOfDayToReset
            kotlinx.datetime.Instant r0 = r0.m1706plusLRDsOJo(r1)
            if (r0 != 0) goto L2b
        L24:
            kotlinx.datetime.Instant$Companion r0 = kotlinx.datetime.Instant.Companion
            r0.getClass()
            kotlinx.datetime.Instant r0 = kotlinx.datetime.Instant.DISTANT_PAST
        L2b:
            kotlinx.datetime.Instant r1 = r4.lastInteraction
            long r2 = r4.requiredTimeSinceInteraction
            kotlinx.datetime.Instant r1 = r1.m1706plusLRDsOJo(r2)
            kotlinx.datetime.Instant r0 = com.animaconnected.info.DateTimeUtilsKt.max(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider.getNextFullReset():kotlinx.datetime.Instant");
    }

    public final Instant getNextRecentReset() {
        Instant instant;
        Instant lastResetRecent = this.storage.getLastResetRecent();
        if (lastResetRecent == null || (instant = lastResetRecent.m1706plusLRDsOJo(this.resetRecentInterval)) == null) {
            Instant.Companion.getClass();
            instant = Instant.DISTANT_PAST;
        }
        return DateTimeUtilsKt.max(instant, this.lastInteraction.m1706plusLRDsOJo(this.requiredTimeSinceInteraction));
    }

    public final Instant getNextReset() {
        return DateTimeUtilsKt.min(getNextFullReset(), getNextRecentReset());
    }

    private final void insertSeq(FitnessQueries fitnessQueries, Sequence<? extends Object> sequence) {
        for (Object obj : sequence) {
            if (obj instanceof FitnessConfig) {
                FitnessDatabaseExtensionsKt.insertProfile(fitnessQueries, (FitnessConfig) obj);
            } else if (obj instanceof ActivityEntry) {
                FitnessDatabaseExtensionsKt.insertActivityDataEntry(fitnessQueries, (ActivityEntry) obj);
            } else if (obj instanceof ExerciseEntry) {
                FitnessDatabaseExtensionsKt.insertExerciseDataEntry(fitnessQueries, (ExerciseEntry) obj);
            } else if (obj instanceof FitnessIndexEntry) {
                FitnessDatabaseExtensionsKt.insertRawFitnessIndexDataEntry(fitnessQueries, (FitnessIndexEntry) obj);
            } else if (obj instanceof HeartrateEntry) {
                FitnessDatabaseExtensionsKt.insertHeartrateDataEntry(fitnessQueries, (HeartrateEntry) obj);
            } else if (obj instanceof RestingHeartrateEntry) {
                FitnessDatabaseExtensionsKt.insertRestingHeartrateDataEntry(fitnessQueries, (RestingHeartrateEntry) obj);
            } else if (obj instanceof PowerEntry) {
                FitnessDatabaseExtensionsKt.insertPowerDataEntry(fitnessQueries, (PowerEntry) obj);
            } else if (obj instanceof LocationEntry) {
                FitnessDatabaseExtensionsKt.insertLocationDataEntry(fitnessQueries, (LocationEntry) obj);
            } else if (obj instanceof SessionEntry) {
                FitnessDatabaseExtensionsKt.insertSessionDataEntry(fitnessQueries, (SessionEntry) obj);
            } else if (obj instanceof StandEntry) {
                FitnessDatabaseExtensionsKt.insertStandDataEntry(fitnessQueries, (StandEntry) obj);
            } else if (obj instanceof SleepEntry) {
                FitnessDatabaseExtensionsKt.insertSleepDataEntry(fitnessQueries, (SleepEntry) obj);
            } else if (obj instanceof SleepHistoryEntry) {
                FitnessDatabaseExtensionsKt.insertSleepHistoryDataEntry(fitnessQueries, (SleepHistoryEntry) obj);
            } else {
                throw new RuntimeException("Unhandled entry: " + obj);
            }
        }
    }

    private final boolean isEnabled(WatchDemoMode watchDemoMode) {
        if (watchDemoMode != null && watchDemoMode != WatchDemoMode.None) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(2:3|(14:5|6|7|(1:(1:(1:(5:12|13|14|15|16)(2:19|20))(9:21|22|23|24|25|(1:27)|14|15|16))(1:29))(2:34|(1:36)(1:37))|30|31|(1:33)|23|24|25|(0)|14|15|16))|41|6|7|(0)(0)|30|31|(0)|23|24|25|(0)|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d0, code lost:            com.animaconnected.logger.LogKt.debug$default(r1, com.animaconnected.watch.provider.demo.DemoModeProvider.tag, (java.lang.Throwable) null, false, (kotlin.jvm.functions.Function0) com.animaconnected.watch.provider.demo.DemoModeProvider$processAndSync$6.INSTANCE, 6, (java.lang.Object) null);     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:            com.animaconnected.logger.LogKt.debug$default(r1, com.animaconnected.watch.provider.demo.DemoModeProvider.tag, (java.lang.Throwable) null, false, (kotlin.jvm.functions.Function0) com.animaconnected.watch.provider.demo.DemoModeProvider$processAndSync$4.INSTANCE, 6, (java.lang.Object) null);     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.animaconnected.watch.provider.demo.DemoModeProvider, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processAndSync(kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.demo.DemoModeProvider.processAndSync(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void resetBeforeToday() {
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$resetBeforeToday$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Reset before today";
            }
        }, 6, (Object) null);
        Instant now = DateTimeUtilsKt.now();
        final TimePeriod timePeriod = new TimePeriod(now.m1705minusLRDsOJo(this.historyDuration), DateTimeUtilsKt.getStartOfDay$default(now, null, 2, null));
        this.watchDb.getDb().transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$resetBeforeToday$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                WatchDb watchDb;
                WatchDb watchDb2;
                WatchDb watchDb3;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                watchDb = DemoModeProvider.this.watchDb;
                watchDb.getDb().getFitnessQueries().clearProfile();
                DemoModeProvider demoModeProvider = DemoModeProvider.this;
                watchDb2 = demoModeProvider.watchDb;
                demoModeProvider.deleteAllFitnessData(watchDb2.getDb().getFitnessQueries());
                DemoModeProvider demoModeProvider2 = DemoModeProvider.this;
                watchDb3 = demoModeProvider2.watchDb;
                demoModeProvider2.generateAndInsertDemoData(watchDb3.getDb().getFitnessQueries(), timePeriod, true);
            }
        });
        this.storage.setLastResetFull(timePeriod.getEnd());
    }

    public final void resetToday() {
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$resetToday$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Reset today";
            }
        }, 6, (Object) null);
        Instant now = DateTimeUtilsKt.now();
        final TimePeriod timePeriod = new TimePeriod(DateTimeUtilsKt.getStartOfDay$default(now, null, 2, null), now);
        this.watchDb.getDb().transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.provider.demo.DemoModeProvider$resetToday$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TransactionWithoutReturn transactionWithoutReturn) {
                invoke2(transactionWithoutReturn);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TransactionWithoutReturn transaction) {
                WatchDb watchDb;
                WatchDb watchDb2;
                Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                DemoModeProvider demoModeProvider = DemoModeProvider.this;
                watchDb = demoModeProvider.watchDb;
                demoModeProvider.deleteAllFitnessDataAfter(watchDb.getDb().getFitnessQueries(), timePeriod.getStart());
                DemoModeProvider demoModeProvider2 = DemoModeProvider.this;
                watchDb2 = demoModeProvider2.watchDb;
                demoModeProvider2.generateAndInsertDemoData(watchDb2.getDb().getFitnessQueries(), timePeriod, false);
            }
        });
        this.storage.setLastResetRecent(timePeriod.getEnd());
    }

    public final void setAppModeUserProperty(Analytics analytics, boolean z) {
        String str;
        if (z) {
            str = "demo_retail";
        } else {
            str = null;
        }
        analytics.setAppMode(str);
    }

    public final void setHealthOnboardingDone() {
        ServiceLocator.INSTANCE.getStorageFactory().createStorage(DashboardViewModel.ONBOARDING_STORAGE_NAME).put(DashboardViewModel.IS_ONBOARDING_KEY, false);
    }

    private final Job startJob() {
        return BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.ioDispatcher(), null, new DemoModeProvider$startJob$1(this, null), 2);
    }

    private final Job stopJob() {
        return BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.ioDispatcher(), null, new DemoModeProvider$stopJob$1(this, null), 2);
    }

    public final DemoMode getCurrentDemoMode() {
        return this._demoMode.getValue();
    }

    public final SharedFlow<DemoMode> getDemoMode() {
        return this.demoMode;
    }

    public final boolean isCurrentlyEnabled() {
        return getCurrentDemoMode() instanceof DemoMode.Enabled;
    }

    public final CommonFlow<Boolean> isEnabledFlow() {
        return this.isEnabledFlow;
    }

    public final Job resetRecent() {
        return BuildersKt.launch$default(ServiceLocator.INSTANCE.getScope(), DispatchersKt.ioDispatcher(), null, new DemoModeProvider$resetRecent$1(this, null), 2);
    }

    public final void setIsEnabled(boolean z) {
        if (z) {
            startJob();
        } else {
            stopJob();
        }
    }

    public final void startJobIfEnabled$watch_release() {
        boolean isEnabled = isEnabled(this.storage.getWatchDemoMode());
        setAppModeUserProperty(this.analytics, isEnabled);
        if (isEnabled) {
            startJob();
        }
    }

    public final void updateAppInteractionTime() {
        this.lastInteraction = DateTimeUtilsKt.now();
    }
}
