package com.animaconnected.watch.fitness;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.EmptyFlow;
import kotlinx.datetime.Instant;

/* compiled from: FitnessProvider.kt */
/* loaded from: classes3.dex */
public interface FitnessProvider {

    /* compiled from: FitnessProvider.kt */
    /* loaded from: classes3.dex */
    public interface Profile {

        /* compiled from: FitnessProvider.kt */
        /* loaded from: classes3.dex */
        public static final class Gender extends Enum<Gender> {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Gender[] $VALUES;
            public static final Companion Companion;
            private final int id;
            public static final Gender Male = new Gender("Male", 0, 1);
            public static final Gender Female = new Gender("Female", 1, 2);
            public static final Gender Other = new Gender("Other", 2, 3);

            /* compiled from: FitnessProvider.kt */
            /* loaded from: classes3.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Gender fromId$watch_release(Integer num) {
                    Object obj;
                    boolean z;
                    Iterator<E> it = Gender.getEntries().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            int id$watch_release = ((Gender) obj).getId$watch_release();
                            if (num != null && id$watch_release == num.intValue()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    return (Gender) obj;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ Gender[] $values() {
                return new Gender[]{Male, Female, Other};
            }

            static {
                Gender[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                Companion = new Companion(null);
            }

            private Gender(String str, int r2, int r3) {
                super(str, r2);
                this.id = r3;
            }

            public static EnumEntries<Gender> getEntries() {
                return $ENTRIES;
            }

            public static Gender valueOf(String str) {
                return (Gender) Enum.valueOf(Gender.class, str);
            }

            public static Gender[] values() {
                return (Gender[]) $VALUES.clone();
            }

            public final int getId$watch_release() {
                return this.id;
            }
        }

        /* compiled from: FitnessProvider.kt */
        /* loaded from: classes3.dex */
        public static final class Measurement extends Enum<Measurement> {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Measurement[] $VALUES;
            public static final Companion Companion;
            private final int id;
            public static final Measurement Metric = new Measurement("Metric", 0, 1);
            public static final Measurement Imperial = new Measurement("Imperial", 1, 2);

            /* compiled from: FitnessProvider.kt */
            /* loaded from: classes3.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Measurement fromId$watch_release(Integer num) {
                    Object obj;
                    boolean z;
                    Iterator<E> it = Measurement.getEntries().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            int id$watch_release = ((Measurement) obj).getId$watch_release();
                            if (num != null && id$watch_release == num.intValue()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    return (Measurement) obj;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ Measurement[] $values() {
                return new Measurement[]{Metric, Imperial};
            }

            static {
                Measurement[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                Companion = new Companion(null);
            }

            private Measurement(String str, int r2, int r3) {
                super(str, r2);
                this.id = r3;
            }

            public static EnumEntries<Measurement> getEntries() {
                return $ENTRIES;
            }

            public static Measurement valueOf(String str) {
                return (Measurement) Enum.valueOf(Measurement.class, str);
            }

            public static Measurement[] values() {
                return (Measurement[]) $VALUES.clone();
            }

            public final int getId$watch_release() {
                return this.id;
            }
        }

        /* compiled from: FitnessProvider.kt */
        /* loaded from: classes3.dex */
        public static final class Temperature extends Enum<Temperature> {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Temperature[] $VALUES;
            public static final Companion Companion;
            private final int id;
            public static final Temperature Celsius = new Temperature("Celsius", 0, 1);
            public static final Temperature Fahrenheit = new Temperature("Fahrenheit", 1, 2);

            /* compiled from: FitnessProvider.kt */
            /* loaded from: classes3.dex */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final Temperature fromId$watch_release(Integer num) {
                    Object obj;
                    boolean z;
                    Iterator<E> it = Temperature.getEntries().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            int id$watch_release = ((Temperature) obj).getId$watch_release();
                            if (num != null && id$watch_release == num.intValue()) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    return (Temperature) obj;
                }

                private Companion() {
                }
            }

            private static final /* synthetic */ Temperature[] $values() {
                return new Temperature[]{Celsius, Fahrenheit};
            }

            static {
                Temperature[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                Companion = new Companion(null);
            }

            private Temperature(String str, int r2, int r3) {
                super(str, r2);
                this.id = r3;
            }

            public static EnumEntries<Temperature> getEntries() {
                return $ENTRIES;
            }

            public static Temperature valueOf(String str) {
                return (Temperature) Enum.valueOf(Temperature.class, str);
            }

            public static Temperature[] values() {
                return (Temperature[]) $VALUES.clone();
            }

            public final int getId$watch_release() {
                return this.id;
            }
        }

        Object clearPersonalData(Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object fetchAndUpdateConfig(Continuation<? super WatchLibResult<FitnessConfig, WatchLibException>> continuation);

        Bedtime getBedtime();

        Long getDateOfBirth();

        Gender getGender();

        Integer getHeight();

        FitnessConfig getLocalFitnessConfig();

        Measurement getMeasurement();

        Temperature getTemperatureUnit();

        Integer getWeight();

        Object saveAndSyncConfig(FitnessConfig fitnessConfig, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setBedtime(Bedtime bedtime, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setDateOfBirth(Long l, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setGender(Gender gender, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setHeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setMeasurement(Measurement measurement, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setTemperatureUnit(Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setUnits(Measurement measurement, Temperature temperature, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);

        Object setWeight(Integer num, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation);
    }

    /* compiled from: FitnessProvider.kt */
    /* loaded from: classes3.dex */
    public interface SessionProvider {
        CurrentSessionData getCurrentSessionData();

        CommonFlow<CurrentSessionData> getCurrentSessionDataFlow();

        boolean getEnableSpeedCalibration();

        boolean isSessionOngoing();

        void setEnableSpeedCalibration(boolean z);
    }

    static /* synthetic */ Object clearLocalFitnessData$suspendImpl(FitnessProvider fitnessProvider, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object clearLocalProfileData$suspendImpl(FitnessProvider fitnessProvider, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object debugProcessSessions$suspendImpl(FitnessProvider fitnessProvider, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object deleteFitnessData$suspendImpl(FitnessProvider fitnessProvider, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object forceSyncFitnessDataToCloud$suspendImpl(FitnessProvider fitnessProvider, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object setGoal$default(FitnessProvider fitnessProvider, Integer num, Integer num2, Integer num3, Continuation continuation, int r6, Object obj) {
        if (obj == null) {
            if ((r6 & 1) != 0) {
                num = null;
            }
            if ((r6 & 2) != 0) {
                num2 = null;
            }
            if ((r6 & 4) != 0) {
                num3 = null;
            }
            return fitnessProvider.setGoal(num, num2, num3, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setGoal");
    }

    default Object clearLocalFitnessData(Continuation<? super Unit> continuation) {
        return clearLocalFitnessData$suspendImpl(this, continuation);
    }

    default Object clearLocalProfileData(Continuation<? super Unit> continuation) {
        return clearLocalProfileData$suspendImpl(this, continuation);
    }

    default String debugExportToJson(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return "Not implemented";
    }

    default CommonFlow<CurrentSessionData> debugFitnessDataFlow() {
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    default void debugImportFromJson(String string) throws Exception {
        Intrinsics.checkNotNullParameter(string, "string");
    }

    default Object debugProcessSessions(Continuation<? super Unit> continuation) {
        return debugProcessSessions$suspendImpl(this, continuation);
    }

    default CommonFlow<List<WatchFitnessProvider.DebugSleepSession>> debugSleepSession() {
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    default Object deleteFitnessData(Continuation<? super Unit> continuation) {
        return deleteFitnessData$suspendImpl(this, continuation);
    }

    Object deleteSession(Session session, Continuation<? super WatchLibResult<Unit, ? extends Exception>> continuation);

    default Object forceSyncFitnessDataToCloud(Continuation<? super Unit> continuation) {
        return forceSyncFitnessDataToCloud$suspendImpl(this, continuation);
    }

    Object getAvgCaloriesPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<WatchFitnessProvider.CalorieEntry>> continuation);

    Object getAvgStepsPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<List<StepEntry>>> continuation);

    int getBMRDuring(TimePeriod timePeriod);

    List<WatchFitnessProvider.CalorieEntry> getCaloriesBMRHistorySince(Instant instant);

    CommonFlow<List<WatchFitnessProvider.CalorieEntry>> getCaloriesWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<List<Entry>> getData(TimePeriod timePeriod);

    CommonFlow<List<ExerciseEntry>> getExerciseData(TimePeriod timePeriod);

    CommonFlow<List<ExerciseEntry>> getExerciseWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<List<FitnessIndexEntry>> getFitnessIndexDataWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<Float> getFitnessIndexLatest();

    CommonFlow<HealthGoals> getGoal(long j);

    HealthGoals getGoalOnce(long j);

    CommonFlow<List<HeartrateSummary>> getHeartRateDataWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<HeartrateEntry> getHeartRateHistorySince(Instant instant);

    CommonFlow<List<HeartrateEntry>> getHeartrateData(TimePeriod timePeriod);

    CommonFlow<List<HeartrateEntry>> getHeartrateDataForCurrentDevice(TimePeriod timePeriod);

    CommonFlow<HeartrateMetricItem> getHeartrateLiveData();

    CommonFlow<SleepSession> getLastNightSleepData(Bedtime bedtime);

    CommonFlow<Long> getLastSynced();

    CommonFlow<HeartrateEntry> getLatestHeartrateDataForCurrentDevice();

    CommonFlow<List<LocationEntry>> getLocationData(TimePeriod timePeriod);

    Object getLocationForSession(long j, Continuation<? super List<LocationEntry>> continuation);

    CommonFlow<List<PowerEntry>> getPowerDataForCurrentDevice(TimePeriod timePeriod);

    Profile getProfile();

    CommonFlow<List<FitnessIndexEntry>> getRawFitnessIndexData(TimePeriod timePeriod);

    CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateData(TimePeriod timePeriod);

    CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateDataWithResolution(TimePeriod timePeriod, int r2);

    SessionProvider getSessionProvider();

    CommonFlow<List<SessionEntry>> getSessionsData(TimePeriod timePeriod);

    Object getSessionsDetailed(long j, Continuation<? super Session> continuation);

    CommonFlow<Session> getSessionsDetailedSince(Instant instant);

    CommonFlow<List<Session>> getSessionsOverview(TimePeriod timePeriod);

    CommonFlow<Session> getSessionsOverviewsSince(Instant instant);

    CommonFlow<List<SleepEntry>> getSleepData(TimePeriod timePeriod);

    CommonFlow<List<SleepHistoryEntry>> getSleepHistoryData(TimePeriod timePeriod, Bedtime bedtime);

    SleepHistoryEntry getSleepHistoryLatestEntry();

    CommonFlow<SleepSession> getSleepSessionsSince(Instant instant);

    CommonFlow<List<SpeedCalibrationEntry>> getSpeedCalibrationData(TimePeriod timePeriod);

    CommonFlow<List<StandEntry>> getStandData(TimePeriod timePeriod);

    CommonFlow<List<StandEntry>> getStandWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<List<ActivityEntry>> getStepsData(TimePeriod timePeriod);

    List<ActivityEntry> getStepsDataAsList(TimePeriod timePeriod);

    CommonFlow<List<StepEntry>> getStepsWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<List<StressEntry>> getStressData(TimePeriod timePeriod);

    CommonFlow<List<StressEntry>> getStressDataWithResolution(TimePeriod timePeriod, int r2);

    CommonFlow<List<WristEntry>> getWristData(TimePeriod timePeriod);

    CommonFlow<List<WristEntry>> getWristDataForCurrentDevice(TimePeriod timePeriod);

    boolean hasCaloriesDataBefore(Instant instant);

    boolean hasFitnessIndexDataBefore(Instant instant);

    boolean hasHeartRateDataBefore(Instant instant);

    boolean hasRestingHeartRateDataBefore(Instant instant);

    Object hasSessions(Continuation<? super Boolean> continuation);

    boolean hasSleepHistoryBefore(Instant instant);

    boolean hasStepsDataBefore(Instant instant);

    Object hasValidSessions(Continuation<? super Boolean> continuation);

    default void registerSessionListener(SessionListener sessionListener) {
        Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
    }

    Object setGoal(Integer num, Integer num2, Integer num3, Continuation<? super Unit> continuation);

    CommonFlow<SyncResult> syncFitness();

    default void unregisterSessionListener(SessionListener sessionListener) {
        Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
    }

    default void debugClearAndProcessRestingHeartRate() {
    }

    default void debugClearAndProcessSleepHistory() {
    }

    default void debugClearCloudTimestamps() {
    }

    default void debugClearProcessed() {
    }

    default void debugClearRaw() {
    }
}
