package com.animaconnected.watch.fitness;

import app.cash.sqldelight.Query;
import com.animaconnected.watch.fitness.sleep.SleepTimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.workout.SleepType;
import com.animaconnected.watch.workout.utils.BMRUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessDatabaseExtensions.kt */
/* loaded from: classes3.dex */
public final class FitnessDatabaseExtensionsKt {
    private static final Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, SessionEntry> dbSessionDataToEntryMapper = new Function6<HistoryDeviceId, Long, Integer, Integer, Boolean, Long, SessionEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbSessionDataToEntryMapper$1
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ SessionEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Boolean bool, Long l2) {
            return m1243invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2, bool, l2.longValue());
        }

        /* renamed from: invoke-FGKXf14, reason: not valid java name */
        public final SessionEntry m1243invokeFGKXf14(String historyDeviceId, long j, int r15, Integer num, Boolean bool, long j2) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new SessionEntry(historyDeviceId, j, SessionEvent.Companion.fromId(r15), SessionType.Companion.fromId(num), bool, j2, null);
        }
    };
    private static final Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, LocationEntry> dbLocationToEntryMapper = new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, LocationEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbLocationToEntryMapper$1
        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ LocationEntry invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
            return m1242invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
        }

        /* renamed from: invoke-EBUUAns, reason: not valid java name */
        public final LocationEntry m1242invokeEBUUAns(String historyDeviceId, long j, double d, double d2, float f, double d3, boolean z) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new LocationEntry(historyDeviceId, j, d, d2, f, d3, z, (DefaultConstructorMarker) null);
        }
    };
    private static final Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, ActivityEntry> dbActivityToEntryMapper = new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, ActivityEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbActivityToEntryMapper$1
        @Override // kotlin.jvm.functions.Function10
        public /* bridge */ /* synthetic */ ActivityEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
            return m1239invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
        }

        /* renamed from: invoke-hSv7xU0, reason: not valid java name */
        public final ActivityEntry m1239invokehSv7xU0(String historyDeviceId, long j, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new ActivityEntry(historyDeviceId, j, num, num2, num3, num4, num5, f, num6, num7, null);
        }
    };
    private static final Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, HeartrateEntry> dbHeartrateToEntryMapper = new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, HeartrateEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbHeartrateToEntryMapper$1
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ HeartrateEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
            return m1241invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
        }

        /* renamed from: invoke-FGKXf14, reason: not valid java name */
        public final HeartrateEntry m1241invokeFGKXf14(String historyDeviceId, long j, int r14, int r15, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new HeartrateEntry(historyDeviceId, j, r14, r15, num, num2, null);
        }
    };
    private static final Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, HeartrateEntry> dbHeartRateHistoryToEntryMapper = new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, HeartrateEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbHeartRateHistoryToEntryMapper$1
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ HeartrateEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
            return m1240invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
        }

        /* renamed from: invoke-FGKXf14, reason: not valid java name */
        public final HeartrateEntry m1240invokeFGKXf14(String historyDeviceId, long j, int r14, int r15, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new HeartrateEntry(historyDeviceId, j, r14, r15, num, num2, null);
        }
    };
    private static final Function3<HistoryDeviceId, Long, Integer, SleepEntry> dbSleepToEntryMapper = new Function3<HistoryDeviceId, Long, Integer, SleepEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbSleepToEntryMapper$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ SleepEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
            return m1245invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
        }

        /* renamed from: invoke-OZHprlw, reason: not valid java name */
        public final SleepEntry m1245invokeOZHprlw(String historyDeviceId, long j, int r11) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            SleepType parse = SleepType.Companion.parse(r11);
            Intrinsics.checkNotNull(parse);
            return new SleepEntry(historyDeviceId, j, parse, null);
        }
    };
    private static final Function5<HistoryDeviceId, Long, Long, Long, Long, SleepHistoryEntry> dbSleepHistoryToEntryMapper = new Function5<HistoryDeviceId, Long, Long, Long, Long, SleepHistoryEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$dbSleepHistoryToEntryMapper$1
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ SleepHistoryEntry invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3, Long l4) {
            return m1244invoke_w5UW7A(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue(), l4.longValue());
        }

        /* renamed from: invoke-_w5UW7A, reason: not valid java name */
        public final SleepHistoryEntry m1244invoke_w5UW7A(String historyDeviceId, long j, long j2, long j3, long j4) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            return new SleepHistoryEntry(historyDeviceId, j, j2, j3, j4, null);
        }
    };

    public static final Query<ActivityEntry> getActivityDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getActivityDataEntries(fitnessQueries, timePeriod.getStartTs(), timePeriod.getEndTs());
    }

    /* renamed from: getActivityDataEntriesForWorkout-OP-DSpw, reason: not valid java name */
    public static final Query<ActivityEntry> m1224getActivityDataEntriesForWorkoutOPDSpw(FitnessQueries getActivityDataEntriesForWorkout, long j, long j2, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getActivityDataEntriesForWorkout, "$this$getActivityDataEntriesForWorkout");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getActivityDataEntriesForWorkout.m1292getActivityDataByIdentifierForWorkoutW5HvN8Q(j, j2, historyDeviceId, dbActivityToEntryMapper);
    }

    /* renamed from: getCurrentSessionDataEntries-VAJrmyI, reason: not valid java name */
    public static final Query<SessionEntry> m1225getCurrentSessionDataEntriesVAJrmyI(FitnessQueries getCurrentSessionDataEntries, long j, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getCurrentSessionDataEntries, "$this$getCurrentSessionDataEntries");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getCurrentSessionDataEntries.m1295getCurrentSessionData2OocG74(j, historyDeviceId, dbSessionDataToEntryMapper);
    }

    public static final Query<DebugEntry> getDebugDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getDebugData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function4<HistoryDeviceId, Long, Integer, Integer, DebugEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getDebugDataEntries$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ DebugEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2) {
                return m1246invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final DebugEntry m1246invoke4i7cvns(String identifier, long j, int r12, int r13) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new DebugEntry(identifier, j, r12, r13, null);
            }
        });
    }

    /* renamed from: getDetailedLocationsForSession-OP-DSpw, reason: not valid java name */
    public static final List<LocationEntry> m1226getDetailedLocationsForSessionOPDSpw(FitnessQueries getDetailedLocationsForSession, long j, long j2, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getDetailedLocationsForSession, "$this$getDetailedLocationsForSession");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return LocationUtilsKt.filterRouteOrSingleLocation(getDetailedLocationsForSession.m1317getLocationsDataForSessionW5HvN8Q(j, j2, historyDeviceId, new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, LocationEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getDetailedLocationsForSession$1
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ LocationEntry invoke(HistoryDeviceId historyDeviceId2, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1247invokeEBUUAns(historyDeviceId2.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final LocationEntry m1247invokeEBUUAns(String identity, long j3, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(identity, "identity");
                return new LocationEntry(identity, j3, d, d2, f, d3, false, 64, (DefaultConstructorMarker) null);
            }
        }).executeAsList());
    }

    public static final Query<DiagnosticsEntry> getDiagnosticsDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getDiagnosticsData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function4<HistoryDeviceId, Long, String, Integer, DiagnosticsEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getDiagnosticsDataEntries$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ DiagnosticsEntry invoke(HistoryDeviceId historyDeviceId, Long l, String str, Integer num) {
                return m1248invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), str, num.intValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final DiagnosticsEntry m1248invoke4i7cvns(String identifier, long j, String key, int r13) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                Intrinsics.checkNotNullParameter(key, "key");
                return new DiagnosticsEntry(identifier, j, key, r13, null);
            }
        });
    }

    public static final Query<ExerciseEntry> getExerciseDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getExerciseData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Integer, ExerciseEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getExerciseDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ ExerciseEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1249invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final ExerciseEntry m1249invokeOZHprlw(String identifier, long j, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new ExerciseEntry(identifier, j, r11, null);
            }
        });
    }

    public static final Query<HealthGoals> getGoals(FitnessQueries fitnessQueries, long j) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getGoalForTimestamp(j, new Function5<Long, HistoryDeviceId, Integer, Integer, Integer, HealthGoals>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getGoals$1
            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ HealthGoals invoke(Long l, HistoryDeviceId historyDeviceId, Integer num, Integer num2, Integer num3) {
                return m1250invokeAjOicPU(l.longValue(), historyDeviceId.m1562unboximpl(), num.intValue(), num2.intValue(), num3.intValue());
            }

            /* renamed from: invoke-AjOicPU, reason: not valid java name */
            public final HealthGoals m1250invokeAjOicPU(long j2, String str, int r4, int r5, int r6) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                return new HealthGoals(r4, r5, r6);
            }
        });
    }

    public static final Query<HeartrateEntry> getHeartRateHistoryEntriesSince(FitnessQueries fitnessQueries, long j) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getHeartRateHistorySince(j, dbHeartRateHistoryToEntryMapper);
    }

    public static final Query<HeartrateEntry> getHeartrateDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getHeartrateData(timePeriod.getStartTs(), timePeriod.getEndTs(), dbHeartrateToEntryMapper);
    }

    /* renamed from: getHeartrateDataEntries-VAJrmyI, reason: not valid java name */
    public static final Query<HeartrateEntry> m1227getHeartrateDataEntriesVAJrmyI(FitnessQueries getHeartrateDataEntries, TimePeriod timePeriod, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getHeartrateDataEntries, "$this$getHeartrateDataEntries");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getHeartrateDataEntries.m1300getHeartrateDataByIdentifierW5HvN8Q(timePeriod.getStartTs(), timePeriod.getEndTs(), historyDeviceId, dbHeartrateToEntryMapper);
    }

    /* renamed from: getHeartrateDataEntriesForWorkout-OP-DSpw, reason: not valid java name */
    public static final Query<HeartrateEntry> m1228getHeartrateDataEntriesForWorkoutOPDSpw(FitnessQueries getHeartrateDataEntriesForWorkout, long j, long j2, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getHeartrateDataEntriesForWorkout, "$this$getHeartrateDataEntriesForWorkout");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getHeartrateDataEntriesForWorkout.m1302getHeartrateDataByIdentifierForWorkoutW5HvN8Q(j, j2, historyDeviceId, dbHeartrateToEntryMapper);
    }

    /* renamed from: getLastLocationDataByIdentifierEntry-W5HvN8Q, reason: not valid java name */
    public static final Query<LocationEntry> m1229getLastLocationDataByIdentifierEntryW5HvN8Q(FitnessQueries getLastLocationDataByIdentifierEntry, long j, String historyDeviceId, int r12) {
        Intrinsics.checkNotNullParameter(getLastLocationDataByIdentifierEntry, "$this$getLastLocationDataByIdentifierEntry");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getLastLocationDataByIdentifierEntry.m1308getLastLocationDataByIdentifierkRTOawE(j, historyDeviceId, r12, dbLocationToEntryMapper);
    }

    /* renamed from: getLastRawLocationDataByIdentifierEntry-W5HvN8Q, reason: not valid java name */
    public static final Query<LocationEntry> m1230getLastRawLocationDataByIdentifierEntryW5HvN8Q(FitnessQueries getLastRawLocationDataByIdentifierEntry, long j, String historyDeviceId, int r12) {
        Intrinsics.checkNotNullParameter(getLastRawLocationDataByIdentifierEntry, "$this$getLastRawLocationDataByIdentifierEntry");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getLastRawLocationDataByIdentifierEntry.m1310getLastRawLocationDataByIdentifierkRTOawE(j, historyDeviceId, r12, dbLocationToEntryMapper);
    }

    /* renamed from: getLatestHeartrateDataEntry-nDauRJo, reason: not valid java name */
    public static final Query<HeartrateEntry> m1231getLatestHeartrateDataEntrynDauRJo(FitnessQueries getLatestHeartrateDataEntry, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getLatestHeartrateDataEntry, "$this$getLatestHeartrateDataEntry");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getLatestHeartrateDataEntry.m1312getLatestHeartrateDataByIdentifiercu7zPM(historyDeviceId, dbHeartrateToEntryMapper);
    }

    public static final Query<LocationEntry> getLocationDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getLocationData(timePeriod.getStartTs(), timePeriod.getEndTs(), dbLocationToEntryMapper);
    }

    /* renamed from: getLocationDataEntries-OP-DSpw, reason: not valid java name */
    public static final Query<LocationEntry> m1232getLocationDataEntriesOPDSpw(FitnessQueries getLocationDataEntries, long j, long j2, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getLocationDataEntries, "$this$getLocationDataEntries");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getLocationDataEntries.m1315getLocationDataByIdentifierW5HvN8Q(j, j2, historyDeviceId, dbLocationToEntryMapper);
    }

    /* renamed from: getPendingStravaSessions-nDauRJo, reason: not valid java name */
    public static final List<Session> m1233getPendingStravaSessionsnDauRJo(FitnessQueries getPendingStravaSessions, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getPendingStravaSessions, "$this$getPendingStravaSessions");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        List<GetSessionsWithPendingUpload> executeAsList = getPendingStravaSessions.m1324getSessionsWithPendingUploadY1s2hH8(historyDeviceId).executeAsList();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(executeAsList, 10));
        for (GetSessionsWithPendingUpload getSessionsWithPendingUpload : executeAsList) {
            List<RowType> executeAsList2 = getPendingStravaSessions.m1304getHeartrateDataForSessionW5HvN8Q(getSessionsWithPendingUpload.getStart_timestamp(), getSessionsWithPendingUpload.getEnd_timestamp(), getSessionsWithPendingUpload.m1441getHdidV9ZILtA(), dbHeartRateHistoryToEntryMapper).executeAsList();
            List<LocationEntry> m1226getDetailedLocationsForSessionOPDSpw = m1226getDetailedLocationsForSessionOPDSpw(getPendingStravaSessions, getSessionsWithPendingUpload.getStart_timestamp(), getSessionsWithPendingUpload.getEnd_timestamp(), getSessionsWithPendingUpload.m1441getHdidV9ZILtA());
            String m1441getHdidV9ZILtA = getSessionsWithPendingUpload.m1441getHdidV9ZILtA();
            long session_id = getSessionsWithPendingUpload.getSession_id();
            SessionType fromId = SessionType.Companion.fromId(Integer.valueOf(getSessionsWithPendingUpload.getType()));
            boolean gps = getSessionsWithPendingUpload.getGps();
            long start_timestamp = getSessionsWithPendingUpload.getStart_timestamp();
            long end_timestamp = getSessionsWithPendingUpload.getEnd_timestamp();
            long total_time_ms = getSessionsWithPendingUpload.getTotal_time_ms();
            long active_time_ms = getSessionsWithPendingUpload.getActive_time_ms();
            double total_distance_meter = getSessionsWithPendingUpload.getTotal_distance_meter();
            int steps = getSessionsWithPendingUpload.getSteps();
            int calories = getSessionsWithPendingUpload.getCalories();
            int elevationGain = getSessionsWithPendingUpload.getElevationGain();
            Float fitness_index = getSessionsWithPendingUpload.getFitness_index();
            EmptyList emptyList = EmptyList.INSTANCE;
            arrayList.add(new Session(m1441getHdidV9ZILtA, session_id, fromId, gps, start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, 0, elevationGain, fitness_index, executeAsList2, emptyList, m1226getDetailedLocationsForSessionOPDSpw, emptyList, emptyList, SessionStatus.Companion.fromId(getSessionsWithPendingUpload.getStatus()), null));
        }
        return arrayList;
    }

    public static final Query<PowerEntry> getPowerDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getPowerData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Integer, PowerEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getPowerDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ PowerEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1251invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final PowerEntry m1251invokeOZHprlw(String identifier, long j, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new PowerEntry(identifier, j, PowerState.Companion.fromId(r11), null);
            }
        });
    }

    /* renamed from: getPowerDataEntries-VAJrmyI, reason: not valid java name */
    public static final Query<PowerEntry> m1234getPowerDataEntriesVAJrmyI(FitnessQueries getPowerDataEntries, TimePeriod timePeriod, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getPowerDataEntries, "$this$getPowerDataEntries");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getPowerDataEntries.m1319getPowerDataByIdentifierW5HvN8Q(timePeriod.getStartTs(), timePeriod.getEndTs(), historyDeviceId, new Function3<HistoryDeviceId, Long, Integer, PowerEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getPowerDataEntries$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ PowerEntry invoke(HistoryDeviceId historyDeviceId2, Long l, Integer num) {
                return m1252invokeOZHprlw(historyDeviceId2.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final PowerEntry m1252invokeOZHprlw(String historyDeviceId2, long j, int r11) {
                Intrinsics.checkNotNullParameter(historyDeviceId2, "historyDeviceId");
                return new PowerEntry(historyDeviceId2, j, PowerState.Companion.fromId(r11), null);
            }
        });
    }

    public static final Query<FitnessConfig> getProfile(FitnessQueries fitnessQueries, long j) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getProfileForTimestamp(j, new Function9<Long, Integer, Integer, Long, Integer, Integer, Integer, Integer, Integer, FitnessConfig>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getProfile$1
            @Override // kotlin.jvm.functions.Function9
            public /* bridge */ /* synthetic */ FitnessConfig invoke(Long l, Integer num, Integer num2, Long l2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return invoke(l.longValue(), num, num2, l2, num3, num4, num5, num6, num7);
            }

            public final FitnessConfig invoke(long j2, Integer num, Integer num2, Long l, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7) {
                return new FitnessConfig(Long.valueOf(j2), num, num2, l, num3, num4, num5, (num6 == null || num7 == null) ? null : new Bedtime(num6.intValue(), num7.intValue()));
            }
        });
    }

    public static final Query<FitnessIndexEntry> getRawFitnessIndexDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getRawFitnessIndexData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Float, FitnessIndexEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getRawFitnessIndexDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ FitnessIndexEntry invoke(HistoryDeviceId historyDeviceId, Long l, Float f) {
                return m1253invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), f.floatValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final FitnessIndexEntry m1253invokeOZHprlw(String identifier, long j, float f) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new FitnessIndexEntry(identifier, j, f, null);
            }
        });
    }

    public static final Query<LocationEntry> getRawLocationDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getRawLocationData(timePeriod.getStartTs(), timePeriod.getEndTs(), dbLocationToEntryMapper);
    }

    /* renamed from: getRawLocationDataEntries-OP-DSpw, reason: not valid java name */
    public static final Query<LocationEntry> m1235getRawLocationDataEntriesOPDSpw(FitnessQueries getRawLocationDataEntries, long j, long j2, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getRawLocationDataEntries, "$this$getRawLocationDataEntries");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getRawLocationDataEntries.m1323getRawLocationDataByIdentifierW5HvN8Q(j, j2, historyDeviceId, dbLocationToEntryMapper);
    }

    public static final Query<RestingHeartrateEntry> getRestingHeartrateDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getRestingHeartrateData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Integer, RestingHeartrateEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getRestingHeartrateDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ RestingHeartrateEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1254invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final RestingHeartrateEntry m1254invokeOZHprlw(String identity, long j, int r11) {
                Intrinsics.checkNotNullParameter(identity, "identity");
                return new RestingHeartrateEntry(identity, j, r11, null);
            }
        });
    }

    public static final Query<SessionEntry> getSessionDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getSessionData(timePeriod.getStartTs(), timePeriod.getEndTs(), dbSessionDataToEntryMapper);
    }

    public static final Session getSessionDetailed(FitnessQueries fitnessQueries, long j) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        DBSession executeAsOneOrNull = fitnessQueries.getSession(j).executeAsOneOrNull();
        if (executeAsOneOrNull == null) {
            return null;
        }
        List<RowType> executeAsList = fitnessQueries.m1304getHeartrateDataForSessionW5HvN8Q(executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp(), executeAsOneOrNull.m1182getHdidV9ZILtA(), new Function6<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, HeartrateEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSessionDetailed$hr$1
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ HeartrateEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4) {
                return m1257invokeFGKXf14(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), num2.intValue(), num3, num4);
            }

            /* renamed from: invoke-FGKXf14, reason: not valid java name */
            public final HeartrateEntry m1257invokeFGKXf14(String identity, long j2, int r14, int r15, Integer num, Integer num2) {
                Intrinsics.checkNotNullParameter(identity, "identity");
                return new HeartrateEntry(identity, j2, r14, r15, num, num2, null);
            }
        }).executeAsList();
        List<LocationEntry> filterRouteOrSingleLocation = LocationUtilsKt.filterRouteOrSingleLocation(fitnessQueries.m1317getLocationsDataForSessionW5HvN8Q(executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp(), executeAsOneOrNull.m1182getHdidV9ZILtA(), new Function7<HistoryDeviceId, Long, Double, Double, Float, Double, Boolean, LocationEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSessionDetailed$loc$1
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ LocationEntry invoke(HistoryDeviceId historyDeviceId, Long l, Double d, Double d2, Float f, Double d3, Boolean bool) {
                return m1259invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), d.doubleValue(), d2.doubleValue(), f.floatValue(), d3.doubleValue(), bool.booleanValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final LocationEntry m1259invokeEBUUAns(String identity, long j2, double d, double d2, float f, double d3, boolean z) {
                Intrinsics.checkNotNullParameter(identity, "identity");
                return new LocationEntry(identity, j2, d, d2, f, d3, false, 64, (DefaultConstructorMarker) null);
            }
        }).executeAsList());
        List<RowType> executeAsList2 = fitnessQueries.getElevationForSession(j, new Function7<HistoryDeviceId, Long, Integer, Double, Double, Double, Double, Elevation>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSessionDetailed$elevations$1
            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ Elevation invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Double d, Double d2, Double d3, Double d4) {
                return m1256invokeEBUUAns(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue(), d.doubleValue(), d2.doubleValue(), d3.doubleValue(), d4.doubleValue());
            }

            /* renamed from: invoke-EBUUAns, reason: not valid java name */
            public final Elevation m1256invokeEBUUAns(String str, long j2, int r14, double d, double d2, double d3, double d4) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                return new Elevation(d, d2, d3, d4);
            }
        }).executeAsList();
        List<RowType> executeAsList3 = fitnessQueries.getIntervalsForSession(j, new Function4<HistoryDeviceId, Long, Long, Long, Interval>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSessionDetailed$intervals$1
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Interval invoke(HistoryDeviceId historyDeviceId, Long l, Long l2, Long l3) {
                return m1258invoke4i7cvns(historyDeviceId.m1562unboximpl(), l.longValue(), l2.longValue(), l3.longValue());
            }

            /* renamed from: invoke-4i7cvns, reason: not valid java name */
            public final Interval m1258invoke4i7cvns(String str, long j2, long j3, long j4) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                return new Interval(j3, j4);
            }
        }).executeAsList();
        return new Session(executeAsOneOrNull.m1182getHdidV9ZILtA(), executeAsOneOrNull.getSession_id(), SessionType.Companion.fromId(Integer.valueOf(executeAsOneOrNull.getType())), executeAsOneOrNull.getGps(), executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp(), executeAsOneOrNull.getTotal_time_ms(), executeAsOneOrNull.getActive_time_ms(), executeAsOneOrNull.getTotal_distance_meter(), executeAsOneOrNull.getSteps(), executeAsOneOrNull.getCalories(), BMRUtilsKt.calculateBMR(fitnessQueries, new TimePeriod(executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp())), executeAsOneOrNull.getElevationGain(), executeAsOneOrNull.getFitness_index(), executeAsList, fitnessQueries.m1294getActivityDataForSessionW5HvN8Q(executeAsOneOrNull.getStart_timestamp(), executeAsOneOrNull.getEnd_timestamp(), executeAsOneOrNull.m1182getHdidV9ZILtA(), new Function10<HistoryDeviceId, Long, Integer, Integer, Integer, Integer, Integer, Float, Integer, Integer, ActivityEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSessionDetailed$activityEntries$1
            @Override // kotlin.jvm.functions.Function10
            public /* bridge */ /* synthetic */ ActivityEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                return m1255invokehSv7xU0(historyDeviceId.m1562unboximpl(), l.longValue(), num, num2, num3, num4, num5, f, num6, num7);
            }

            /* renamed from: invoke-hSv7xU0, reason: not valid java name */
            public final ActivityEntry m1255invokehSv7xU0(String historyDeviceId, long j2, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Float f, Integer num6, Integer num7) {
                Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
                return new ActivityEntry(historyDeviceId, j2, num, num2, num3, num4, num5, f, num6, num7, null);
            }
        }).executeAsList(), filterRouteOrSingleLocation, executeAsList2, executeAsList3, SessionStatus.Companion.fromId(executeAsOneOrNull.getStatus()), null);
    }

    public static final Query<SleepEntry> getSleepDataEntries(FitnessQueries fitnessQueries, SleepTimePeriod sleepTimePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "sleepTimePeriod");
        return getSleepDataEntries(fitnessQueries, sleepTimePeriod.getStart().toEpochMilliseconds(), sleepTimePeriod.getEnd().toEpochMilliseconds());
    }

    /* renamed from: getSleepDataEntries-VAJrmyI, reason: not valid java name */
    public static final Query<SleepEntry> m1236getSleepDataEntriesVAJrmyI(FitnessQueries getSleepDataEntries, SleepTimePeriod sleepTimePeriod, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getSleepDataEntries, "$this$getSleepDataEntries");
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "sleepTimePeriod");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getSleepDataEntries.m1327getSleepDataByIdentifierW5HvN8Q(sleepTimePeriod.getStart().toEpochMilliseconds(), sleepTimePeriod.getEnd().toEpochMilliseconds(), historyDeviceId, dbSleepToEntryMapper);
    }

    public static final Query<SleepHistoryEntry> getSleepHistoryDataEndInclusiveEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getSleepHistoryDataEndInclusive(timePeriod.getStartTs(), timePeriod.getEndTs(), dbSleepHistoryToEntryMapper);
    }

    public static final Query<SleepHistoryEntry> getSleepHistoryDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getSleepHistoryData(timePeriod.getStartTs(), timePeriod.getEndTs(), dbSleepHistoryToEntryMapper);
    }

    public static final Query<SleepHistoryEntry> getSleepHistoryEntrySince(FitnessQueries fitnessQueries, long j) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getSleepHistorySince(j, dbSleepHistoryToEntryMapper);
    }

    public static final Query<SleepHistoryEntry> getSleepHistoryLatestEntry(FitnessQueries fitnessQueries) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getSleepHistoryDataLatest(dbSleepHistoryToEntryMapper);
    }

    public static final Query<SpeedCalibrationEntry> getSpeedCalibrationEntry(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getSpeedCalibrationData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Integer, SpeedCalibrationEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getSpeedCalibrationEntry$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ SpeedCalibrationEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1260invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final SpeedCalibrationEntry m1260invokeOZHprlw(String identifier, long j, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new SpeedCalibrationEntry(identifier, j, r11, null);
            }
        });
    }

    public static final Query<StandEntry> getStandDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStandDataEntries(fitnessQueries, timePeriod.getStartTs(), timePeriod.getEndTs());
    }

    public static final Query<StressEntry> getStressDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getStressDataEntries(fitnessQueries, timePeriod.getStartTs(), timePeriod.getEndTs());
    }

    public static final Query<WristEntry> getWristDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return fitnessQueries.getWristData(timePeriod.getStartTs(), timePeriod.getEndTs(), new Function3<HistoryDeviceId, Long, Integer, WristEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getWristDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ WristEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1263invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final WristEntry m1263invokeOZHprlw(String identifier, long j, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new WristEntry(identifier, j, WristState.Companion.fromId(r11), null);
            }
        });
    }

    /* renamed from: getWristDataEntries-VAJrmyI, reason: not valid java name */
    public static final Query<WristEntry> m1237getWristDataEntriesVAJrmyI(FitnessQueries getWristDataEntries, TimePeriod timePeriod, String historyDeviceId) {
        Intrinsics.checkNotNullParameter(getWristDataEntries, "$this$getWristDataEntries");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        return getWristDataEntries.m1332getWristDataForIdentifierW5HvN8Q(timePeriod.getStartTs(), timePeriod.getEndTs(), historyDeviceId, new Function3<HistoryDeviceId, Long, Integer, WristEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getWristDataEntries$2
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ WristEntry invoke(HistoryDeviceId historyDeviceId2, Long l, Integer num) {
                return m1264invokeOZHprlw(historyDeviceId2.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final WristEntry m1264invokeOZHprlw(String identifier, long j, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new WristEntry(identifier, j, WristState.Companion.fromId(r11), null);
            }
        });
    }

    public static final void insertActivityDataEntry(FitnessQueries fitnessQueries, ActivityEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1333insertActivityDatahSv7xU0(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getActivityClass(), e.getWalkSteps(), e.getRunSteps(), e.getOtherSteps(), e.getRhythmicStepsCadence(), e.getSpeed(), e.getDistance(), e.getCalories());
    }

    public static final void insertDebugDataEntry(FitnessQueries fitnessQueries, DebugEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1334insertDebugData4i7cvns(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getType(), e.getValue());
    }

    public static final void insertDiagnosticsDataEntry(FitnessQueries fitnessQueries, DiagnosticsEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1336insertDiagnosticsData4i7cvns(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getKey(), e.getValue());
    }

    public static final void insertExerciseDataEntry(FitnessQueries fitnessQueries, ExerciseEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1338insertExerciseDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getActiveMinutes());
    }

    /* renamed from: insertGoal-kRTOawE, reason: not valid java name */
    public static final void m1238insertGoalkRTOawE(FitnessQueries insertGoal, String historyDeviceId, long j, HealthGoals goals) {
        Intrinsics.checkNotNullParameter(insertGoal, "$this$insertGoal");
        Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
        Intrinsics.checkNotNullParameter(goals, "goals");
        insertGoal.m1339insertGoalAjOicPU(Long.valueOf(j), historyDeviceId, goals.getSteps(), goals.getStand(), goals.getExercise());
    }

    public static final void insertHeartrateDataEntry(FitnessQueries fitnessQueries, HeartrateEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1340insertHeartrateDataFGKXf14(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getHeartrate(), e.getConfidence(), e.getHeartrateLow(), e.getHeartrateHigh());
    }

    public static final void insertLocationDataEntry(FitnessQueries fitnessQueries, LocationEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1342insertLocationDataEBUUAns(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getLong(), e.getLat(), e.getAccuracy(), e.getAltitude(), true);
    }

    public static final void insertPowerDataEntry(FitnessQueries fitnessQueries, PowerEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1343insertPowerDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getState().getId());
    }

    public static final void insertProfile(FitnessQueries fitnessQueries, FitnessConfig config) {
        Integer num;
        Integer num2;
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Long timestamp = config.getTimestamp();
        Integer height = config.getHeight();
        Integer weight = config.getWeight();
        Long dateOfBirthTs = config.getDateOfBirthTs();
        Integer gender = config.getGender();
        Integer measurement = config.getMeasurement();
        Integer temperature = config.getTemperature();
        Bedtime bedtime = config.getBedtime();
        if (bedtime != null) {
            num = Integer.valueOf(bedtime.getHour());
        } else {
            num = null;
        }
        Bedtime bedtime2 = config.getBedtime();
        if (bedtime2 != null) {
            num2 = Integer.valueOf(bedtime2.getMinute());
        } else {
            num2 = null;
        }
        fitnessQueries.insertProfile(timestamp, height, weight, dateOfBirthTs, gender, measurement, temperature, num, num2);
    }

    public static final void insertRawFitnessIndexDataEntry(FitnessQueries fitnessQueries, FitnessIndexEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1345insertRawFitnessIndexDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getValue());
    }

    public static final void insertRestingHeartrateDataEntry(FitnessQueries fitnessQueries, RestingHeartrateEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1346insertRestingHeartrateDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getRestingHeartrate());
    }

    public static final void insertSession(FitnessQueries fitnessQueries, Session session) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(session, "session");
        fitnessQueries.m1347insertSessionus9H8TY(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs(), session.getEndTs(), session.getTotalTimeMs(), session.getActiveTimeMs(), session.getTotalDistanceMeter(), session.getSteps(), session.getCalories(), session.getElevationGain(), session.getType().getId(), session.getGps(), session.getSessionId(), session.getFitnessIndex(), session.getStatus().getId());
    }

    public static final void insertSessionDataEntry(FitnessQueries fitnessQueries, SessionEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1348insertSessionDataFGKXf14(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getEvent().getId(), Integer.valueOf(e.getType().getId()), e.getGps(), e.getSessionId());
    }

    public static final void insertSleepDataEntry(FitnessQueries fitnessQueries, SleepEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1349insertSleepDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getState().getValue());
    }

    public static final void insertSleepHistoryDataEntry(FitnessQueries fitnessQueries, SleepHistoryEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1350insertSleepHistoryData_w5UW7A(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getEnd(), e.getLightSleepMs(), e.getDeepSleepMs());
    }

    public static final void insertSpeedCalibrationEntry(FitnessQueries fitnessQueries, SpeedCalibrationEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1351insertSpeedCalibrationDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getCoefficient());
    }

    public static final void insertStandDataEntry(FitnessQueries fitnessQueries, StandEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1352insertStandDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getSuccessfulStands());
    }

    public static final void insertStressDataEntry(FitnessQueries fitnessQueries, StressEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1354insertStressDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getStress());
    }

    public static final void insertWristDataEntry(FitnessQueries fitnessQueries, WristEntry e) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(e, "e");
        fitnessQueries.m1355insertWristDataOZHprlw(e.mo1121getHistoryDeviceIdV9ZILtA(), e.getTimestamp(), e.getState().getId());
    }

    public static final Query<ActivityEntry> getActivityDataEntries(FitnessQueries fitnessQueries, long j, long j2) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getActivityData(j, j2, dbActivityToEntryMapper);
    }

    public static final Query<SleepEntry> getSleepDataEntries(FitnessQueries fitnessQueries, TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return getSleepDataEntries(fitnessQueries, timePeriod.getStartTs(), timePeriod.getEndTs());
    }

    public static final Query<StandEntry> getStandDataEntries(FitnessQueries fitnessQueries, long j, long j2) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getStandData(j, j2, new Function3<HistoryDeviceId, Long, Integer, StandEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getStandDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ StandEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1261invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final StandEntry m1261invokeOZHprlw(String identifier, long j3, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new StandEntry(identifier, j3, r11, null);
            }
        });
    }

    public static final Query<StressEntry> getStressDataEntries(FitnessQueries fitnessQueries, long j, long j2) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getStressData(j, j2, new Function3<HistoryDeviceId, Long, Integer, StressEntry>() { // from class: com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt$getStressDataEntries$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ StressEntry invoke(HistoryDeviceId historyDeviceId, Long l, Integer num) {
                return m1262invokeOZHprlw(historyDeviceId.m1562unboximpl(), l.longValue(), num.intValue());
            }

            /* renamed from: invoke-OZHprlw, reason: not valid java name */
            public final StressEntry m1262invokeOZHprlw(String identifier, long j3, int r11) {
                Intrinsics.checkNotNullParameter(identifier, "identifier");
                return new StressEntry(identifier, j3, r11, null);
            }
        });
    }

    public static final Query<SleepEntry> getSleepDataEntries(FitnessQueries fitnessQueries, long j, long j2) {
        Intrinsics.checkNotNullParameter(fitnessQueries, "<this>");
        return fitnessQueries.getSleepData(j, j2, dbSleepToEntryMapper);
    }
}
