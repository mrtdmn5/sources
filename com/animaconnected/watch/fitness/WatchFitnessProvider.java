package com.animaconnected.watch.fitness;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.vector.VectorGroup$$ExternalSyntheticOutline0;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.TransactionWithoutReturn;
import app.cash.sqldelight.coroutines.FlowQuery;
import app.cash.sqldelight.coroutines.FlowQuery$mapToList$$inlined$map$1;
import app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrNull$$inlined$map$1;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.DispatchersKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.account.fitness.FitnessCloudProvider;
import com.animaconnected.watch.device.AccountBackend;
import com.animaconnected.watch.display.AppId;
import com.animaconnected.watch.display.WatchApp;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.InternalFitnessProvider;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import com.animaconnected.watch.fitness.session.SessionDataListener;
import com.animaconnected.watch.fitness.session.SessionProviderImpl;
import com.animaconnected.watch.fitness.sleep.SleepHistoryProcessor;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.fitness.sleep.SleepSessionKt;
import com.animaconnected.watch.fitness.sleep.SleepSessionState;
import com.animaconnected.watch.fitness.sleep.SleepTimePeriod;
import com.animaconnected.watch.fitness.sleep.SleepTimePeriodKt;
import com.animaconnected.watch.fitness.sync.FitnessSyncWatch;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import com.animaconnected.watch.utils.MathUtilsKt;
import com.animaconnected.watch.utils.WatchLibException;
import com.animaconnected.watch.utils.WatchLibResult;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import com.animaconnected.watch.workout.HeartrateSource;
import com.animaconnected.watch.workout.utils.BMRUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.EmptyFlow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__MergeKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.coroutines.flow.internal.ChannelLimitedFlowMerge;
import kotlinx.coroutines.flow.internal.CombineKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantKt;
import kotlinx.datetime.TimeZone;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: WatchFitnessProvider.kt */
/* loaded from: classes3.dex */
public final class WatchFitnessProvider implements FitnessProvider, InternalFitnessProvider {
    private final AccountBackend accountBackend;
    private final FitnessQueries db;
    private final String elevationApiKey;
    private final FitnessCloudProvider fitnessCloudProvider;
    private Job heartrateLiveJob;
    private final CommonFlow<HeartrateMetricItem> heartrateLiveSharedStateFlow;
    private final MutableStateFlow<HeartrateMetricItem> heartrateLiveStateFlow;
    private final MutableStateFlow<Long> lastSyncedStateFlow;
    private Set<SessionListener> listener;
    private final LocationProvider locationProvider;
    private final String locationResultTag;
    private final FitnessProvider.Profile profile;
    private final CoroutineScope scope;
    private final FitnessProvider.SessionProvider sessionProvider;
    private final SessionProviderImpl sessionProviderImpl;
    private final StepFetcher stepsFetcher;
    private final String tag;
    private final String tagPreProcessing;
    private Watch watch;
    private Job watchStateJob;
    private Job workoutLocationJob;

    /* compiled from: WatchFitnessProvider.kt */
    /* loaded from: classes3.dex */
    public static final class CalorieEntry {
        private final int calories;
        private TimePeriod timePeriod;

        public CalorieEntry(TimePeriod timePeriod, int r3) {
            Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
            this.timePeriod = timePeriod;
            this.calories = r3;
        }

        public static /* synthetic */ CalorieEntry copy$default(CalorieEntry calorieEntry, TimePeriod timePeriod, int r2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                timePeriod = calorieEntry.timePeriod;
            }
            if ((r3 & 2) != 0) {
                r2 = calorieEntry.calories;
            }
            return calorieEntry.copy(timePeriod, r2);
        }

        public final TimePeriod component1() {
            return this.timePeriod;
        }

        public final int component2() {
            return this.calories;
        }

        public final CalorieEntry copy(TimePeriod timePeriod, int r3) {
            Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
            return new CalorieEntry(timePeriod, r3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalorieEntry)) {
                return false;
            }
            CalorieEntry calorieEntry = (CalorieEntry) obj;
            if (Intrinsics.areEqual(this.timePeriod, calorieEntry.timePeriod) && this.calories == calorieEntry.calories) {
                return true;
            }
            return false;
        }

        public final int getCalories() {
            return this.calories;
        }

        public final TimePeriod getTimePeriod() {
            return this.timePeriod;
        }

        public int hashCode() {
            return Integer.hashCode(this.calories) + (this.timePeriod.hashCode() * 31);
        }

        public final void setTimePeriod(TimePeriod timePeriod) {
            Intrinsics.checkNotNullParameter(timePeriod, "<set-?>");
            this.timePeriod = timePeriod;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("CalorieEntry(timePeriod=");
            sb.append(this.timePeriod);
            sb.append(", calories=");
            return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.calories, ')');
        }
    }

    /* compiled from: WatchFitnessProvider.kt */
    /* loaded from: classes3.dex */
    public static final class DebugSleepSession {
        private final String historyDeviceId;
        private final SleepHistoryEntry historyEntry;
        private final List<SleepEntry> rawData;
        private final SleepSession session;

        public /* synthetic */ DebugSleepSession(String str, SleepSession sleepSession, List list, SleepHistoryEntry sleepHistoryEntry, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, sleepSession, list, sleepHistoryEntry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-4i7cvns$default */
        public static /* synthetic */ DebugSleepSession m1510copy4i7cvns$default(DebugSleepSession debugSleepSession, String str, SleepSession sleepSession, List list, SleepHistoryEntry sleepHistoryEntry, int r5, Object obj) {
            if ((r5 & 1) != 0) {
                str = debugSleepSession.historyDeviceId;
            }
            if ((r5 & 2) != 0) {
                sleepSession = debugSleepSession.session;
            }
            if ((r5 & 4) != 0) {
                list = debugSleepSession.rawData;
            }
            if ((r5 & 8) != 0) {
                sleepHistoryEntry = debugSleepSession.historyEntry;
            }
            return debugSleepSession.m1512copy4i7cvns(str, sleepSession, list, sleepHistoryEntry);
        }

        /* renamed from: component1-V9ZILtA */
        public final String m1511component1V9ZILtA() {
            return this.historyDeviceId;
        }

        public final SleepSession component2() {
            return this.session;
        }

        public final List<SleepEntry> component3() {
            return this.rawData;
        }

        public final SleepHistoryEntry component4() {
            return this.historyEntry;
        }

        /* renamed from: copy-4i7cvns */
        public final DebugSleepSession m1512copy4i7cvns(String historyDeviceId, SleepSession session, List<SleepEntry> rawData, SleepHistoryEntry sleepHistoryEntry) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            return new DebugSleepSession(historyDeviceId, session, rawData, sleepHistoryEntry, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DebugSleepSession)) {
                return false;
            }
            DebugSleepSession debugSleepSession = (DebugSleepSession) obj;
            if (HistoryDeviceId.m1559equalsimpl0(this.historyDeviceId, debugSleepSession.historyDeviceId) && Intrinsics.areEqual(this.session, debugSleepSession.session) && Intrinsics.areEqual(this.rawData, debugSleepSession.rawData) && Intrinsics.areEqual(this.historyEntry, debugSleepSession.historyEntry)) {
                return true;
            }
            return false;
        }

        /* renamed from: getHistoryDeviceId-V9ZILtA */
        public final String m1513getHistoryDeviceIdV9ZILtA() {
            return this.historyDeviceId;
        }

        public final SleepHistoryEntry getHistoryEntry() {
            return this.historyEntry;
        }

        public final List<SleepEntry> getRawData() {
            return this.rawData;
        }

        public final SleepSession getSession() {
            return this.session;
        }

        public int hashCode() {
            int hashCode;
            int m = VectorGroup$$ExternalSyntheticOutline0.m(this.rawData, (this.session.hashCode() + (HistoryDeviceId.m1560hashCodeimpl(this.historyDeviceId) * 31)) * 31, 31);
            SleepHistoryEntry sleepHistoryEntry = this.historyEntry;
            if (sleepHistoryEntry == null) {
                hashCode = 0;
            } else {
                hashCode = sleepHistoryEntry.hashCode();
            }
            return m + hashCode;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DebugSleepSession(historyDeviceId=");
            ActivityEntry$$ExternalSyntheticOutline0.m(this.historyDeviceId, sb, ", session=");
            sb.append(this.session);
            sb.append(", rawData=");
            sb.append(this.rawData);
            sb.append(", historyEntry=");
            sb.append(this.historyEntry);
            sb.append(')');
            return sb.toString();
        }

        private DebugSleepSession(String historyDeviceId, SleepSession session, List<SleepEntry> rawData, SleepHistoryEntry sleepHistoryEntry) {
            Intrinsics.checkNotNullParameter(historyDeviceId, "historyDeviceId");
            Intrinsics.checkNotNullParameter(session, "session");
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            this.historyDeviceId = historyDeviceId;
            this.session = session;
            this.rawData = rawData;
            this.historyEntry = sleepHistoryEntry;
        }
    }

    public WatchFitnessProvider(CoroutineScope scope, LocationProvider locationProvider, AccountBackend accountBackend, FitnessQueries db, String elevationApiKey, FitnessCloudProvider fitnessCloudProvider, FitnessProvider.Profile profile) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(locationProvider, "locationProvider");
        Intrinsics.checkNotNullParameter(accountBackend, "accountBackend");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(elevationApiKey, "elevationApiKey");
        Intrinsics.checkNotNullParameter(fitnessCloudProvider, "fitnessCloudProvider");
        Intrinsics.checkNotNullParameter(profile, "profile");
        this.scope = scope;
        this.locationProvider = locationProvider;
        this.accountBackend = accountBackend;
        this.db = db;
        this.elevationApiKey = elevationApiKey;
        this.fitnessCloudProvider = fitnessCloudProvider;
        this.profile = profile;
        this.listener = new HashSet();
        this.stepsFetcher = new StepFetcher(db);
        this.tagPreProcessing = "pre-process";
        this.tag = "WatchFitnessProvider";
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.heartrateLiveStateFlow = MutableStateFlow;
        this.heartrateLiveSharedStateFlow = FlowExtensionsKt.asCommonFlow(FlowKt.shareIn(new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(MutableStateFlow, new WatchFitnessProvider$heartrateLiveSharedStateFlow$1(this, null)), scope, SharingStarted.Companion.WhileSubscribed$default(), 1));
        this.lastSyncedStateFlow = StateFlowKt.MutableStateFlow(null);
        SessionProviderImpl sessionProviderImpl = new SessionProviderImpl(new SessionDataListener() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1
            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void feedToWatch(GpsQuality gpsQuality, Distance distance, Float f) {
                Intrinsics.checkNotNullParameter(gpsQuality, "gpsQuality");
                Intrinsics.checkNotNullParameter(distance, "distance");
                BuildersKt.launch$default(WatchFitnessProvider.this.getScope(), null, null, new WatchFitnessProvider$sessionProviderImpl$1$feedToWatch$1(WatchFitnessProvider.this, gpsQuality, distance, f, null), 3);
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void sessionEnded() {
                LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Workout session ended, process data.";
                    }
                }, 7, (Object) null);
                BuildersKt.launch$default(WatchFitnessProvider.this.getScope(), null, null, new WatchFitnessProvider$sessionProviderImpl$1$sessionEnded$2(WatchFitnessProvider.this, null), 3);
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void startSpeedCalibration() {
                BuildersKt.launch$default(WatchFitnessProvider.this.getScope(), null, null, new WatchFitnessProvider$sessionProviderImpl$1$startSpeedCalibration$1(WatchFitnessProvider.this, null), 3);
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void stopSpeedCalibration(long j, long j2) {
                BuildersKt.launch$default(WatchFitnessProvider.this.getScope(), null, null, new WatchFitnessProvider$sessionProviderImpl$1$stopSpeedCalibration$1(WatchFitnessProvider.this, j, j2, null), 3);
            }

            @Override // com.animaconnected.watch.fitness.session.SessionDataListener
            public void useConnectedGpsRequested(boolean z) {
                Watch watch;
                DisplayWatch displayWatch;
                boolean z2;
                watch = WatchFitnessProvider.this.watch;
                Object obj = null;
                if (watch instanceof DisplayWatch) {
                    displayWatch = (DisplayWatch) watch;
                } else {
                    displayWatch = null;
                }
                if (displayWatch == null) {
                    return;
                }
                Iterator<T> it = displayWatch.getApps$watch_release().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((WatchApp) next).getId() == AppId.Workout) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        obj = next;
                        break;
                    }
                }
                WatchApp watchApp = (WatchApp) obj;
                if (watchApp == null) {
                    return;
                }
                if (z) {
                    watchApp.getCheckPermissions().invoke();
                }
                WatchFitnessProvider.this.updateLocationData(z);
            }
        });
        this.sessionProviderImpl = sessionProviderImpl;
        this.sessionProvider = sessionProviderImpl;
        this.locationResultTag = "handleLocationResult";
    }

    public final TimePeriod caloriesTimeSpan() {
        Long l;
        Long executeAsOneOrNull = this.db.getFirstTimestampCalories().executeAsOneOrNull();
        DBActivityData executeAsOneOrNull2 = this.db.getLastActivityData().executeAsOneOrNull();
        if (executeAsOneOrNull2 != null) {
            l = Long.valueOf(executeAsOneOrNull2.getTimestamp());
        } else {
            l = null;
        }
        if (executeAsOneOrNull == null || l == null) {
            return null;
        }
        return new TimePeriod(executeAsOneOrNull.longValue(), l.longValue());
    }

    private final void clearProcessedBefore(long j) {
        this.db.deleteProcessedDataBefore(j);
    }

    public static /* synthetic */ void clearProcessedBefore$default(WatchFitnessProvider watchFitnessProvider, long j, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        watchFitnessProvider.clearProcessedBefore(j);
    }

    private final void clearRawBefore(long j) {
        this.db.deleteRawDataBefore(j);
    }

    public static /* synthetic */ void clearRawBefore$default(WatchFitnessProvider watchFitnessProvider, long j, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        watchFitnessProvider.clearRawBefore(j);
    }

    /* JADX WARN: Type inference failed for: r12v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    private final <T> List<T> createEmptyPaddedList(int r12, TimePeriod timePeriod, Function2<? super Long, ? super Long, ? extends T> function2) {
        int r3;
        long durationMs = timePeriod.getDurationMs();
        if (r12 < 1) {
            r3 = 1;
        } else {
            r3 = r12;
        }
        long j = durationMs / r3;
        IntRange until = RangesKt___RangesKt.until(0, r12);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        ?? it = until.iterator();
        while (it.hasNext) {
            long nextInt = (it.nextInt() * j) + timePeriod.getStartTs();
            int r6 = Duration.$r8$clinit;
            arrayList.add(function2.invoke(Long.valueOf(nextInt), Long.valueOf((nextInt + j) - Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.SECONDS)))));
        }
        return CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }

    private final CommonFlow<List<DebugEntry>> getDebugData(TimePeriod timePeriod) {
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getDebugDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    private final CommonFlow<List<DiagnosticsEntry>> getDiagnosticData(TimePeriod timePeriod) {
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getDiagnosticsDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    private final CommonFlow<List<PowerEntry>> getPowerData(TimePeriod timePeriod) {
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getPowerDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    private final CommonFlow<List<SleepHistoryEntry>> getSleepHistoryDataEntries(TimePeriod timePeriod) {
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getSleepHistoryDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x015d A[LOOP:0: B:17:0x0157->B:19:0x015d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01da A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object handleLocationResult(com.animaconnected.watch.location.LocationResult r28, kotlin.coroutines.Continuation<? super kotlin.Unit> r29) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.handleLocationResult(com.animaconnected.watch.location.LocationResult, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final InternalFitnessProvider.InternalSessionProvider internal(FitnessProvider.SessionProvider sessionProvider) {
        Intrinsics.checkNotNull(sessionProvider, "null cannot be cast to non-null type com.animaconnected.watch.fitness.InternalFitnessProvider.InternalSessionProvider");
        return (InternalFitnessProvider.InternalSessionProvider) sessionProvider;
    }

    public final void processFitnessIndex() {
        Object obj = (Long) this.db.getLastSessionFitnessIndexTimestamp().executeAsOneOrNull();
        Object valueOf = Float.valueOf(0.0f);
        if (obj == null) {
            obj = valueOf;
        }
        Object obj2 = (Long) this.db.getLastSessionTimestamp().executeAsOneOrNull();
        if (obj2 != null) {
            valueOf = obj2;
        }
        if (Intrinsics.areEqual(obj, valueOf)) {
            return;
        }
        final List<GetMissingProcessedFitnessIndexes> executeAsList = this.db.getMissingProcessedFitnessIndexes().executeAsList();
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$processFitnessIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return executeAsList.size() + " fitness indexes to process";
            }
        }, 7, (Object) null);
        for (final GetMissingProcessedFitnessIndexes getMissingProcessedFitnessIndexes : executeAsList) {
            final List<Float> executeAsList2 = this.db.getRelevantSessionFitnessIndexData(getMissingProcessedFitnessIndexes.getStart_timestamp()).executeAsList();
            if (executeAsList2.size() != 5) {
                this.db.m1344insertProcessedFitnessIndexDataOZHprlw(getMissingProcessedFitnessIndexes.m1432getHdidV9ZILtA(), getMissingProcessedFitnessIndexes.getStart_timestamp(), null);
                LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$processFitnessIndex$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Not enough data (" + executeAsList2.size() + ") to calculate fitness index for " + getMissingProcessedFitnessIndexes.getStart_timestamp();
                    }
                }, 7, (Object) null);
            } else {
                final Float weightedAverage = MathUtilsKt.weightedAverage(executeAsList2, 0.3f, 0.25f, 0.25f, 0.1f, 0.1f);
                LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$processFitnessIndex$2$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Adding fitness index: " + weightedAverage + " for " + getMissingProcessedFitnessIndexes.getStart_timestamp();
                    }
                }, 7, (Object) null);
                this.db.m1344insertProcessedFitnessIndexDataOZHprlw(getMissingProcessedFitnessIndexes.m1432getHdidV9ZILtA(), getMissingProcessedFitnessIndexes.getStart_timestamp(), weightedAverage);
            }
        }
    }

    public final void processRestingHeartrateHistoryData() {
        Watch watch = this.watch;
        if (watch != null) {
            RestingHeartRateProcessor.INSTANCE.m1459processcu7zPM(watch.m1046getHistoryDeviceIdV9ZILtA(), this.db);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x06d3, code lost:            if (r0.onCompletedPreProcess(r10, r7, r2) != r5) goto L260;     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x06d5, code lost:            return r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x06d6, code lost:            r0 = r9;        r9 = r15;        r15 = r7;        r7 = r3;        r3 = r5;        r5 = r16;        r59 = r10;        r10 = r1;        r1 = r6;        r6 = r14;        r14 = r59;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x04e9  */
    /* JADX WARN: Type inference failed for: r15v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v55, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r3v61, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v43, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r9v41, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0169 -> B:35:0x01ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x06d6 -> B:14:0x06e4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object processSessionsFromDB(kotlin.coroutines.Continuation<? super kotlin.Unit> r62) {
        /*
            Method dump skipped, instructions count: 1933
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.processSessionsFromDB(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void processSleepHistoryData() {
        SleepHistoryProcessor.INSTANCE.process(this, this.db);
    }

    public final Session toSession(DBSession dBSession, FitnessQueries fitnessQueries) {
        String m1182getHdidV9ZILtA = dBSession.m1182getHdidV9ZILtA();
        long session_id = dBSession.getSession_id();
        SessionType fromId = SessionType.Companion.fromId(Integer.valueOf(dBSession.getType()));
        boolean gps = dBSession.getGps();
        long start_timestamp = dBSession.getStart_timestamp();
        long end_timestamp = dBSession.getEnd_timestamp();
        long total_time_ms = dBSession.getTotal_time_ms();
        long active_time_ms = dBSession.getActive_time_ms();
        double total_distance_meter = dBSession.getTotal_distance_meter();
        int steps = dBSession.getSteps();
        int calories = dBSession.getCalories();
        int elevationGain = dBSession.getElevationGain();
        int calculateBMR = BMRUtilsKt.calculateBMR(fitnessQueries, new TimePeriod(dBSession.getStart_timestamp(), dBSession.getEnd_timestamp()));
        Float fitness_index = dBSession.getFitness_index();
        EmptyList emptyList = EmptyList.INSTANCE;
        return new Session(m1182getHdidV9ZILtA, session_id, fromId, gps, start_timestamp, end_timestamp, total_time_ms, active_time_ms, total_distance_meter, steps, calories, calculateBMR, elevationGain, fitness_index, emptyList, emptyList, emptyList, emptyList, emptyList, SessionStatus.Companion.fromId(dBSession.getStatus()), null);
    }

    public final List<Session> toSessions(List<DBSession> list) {
        List<DBSession> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSession((DBSession) it.next(), this.db));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:            if (r1.isActive() == true) goto L29;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateLocationData(boolean r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L2d
            kotlinx.coroutines.Job r1 = r10.workoutLocationJob
            if (r1 == 0) goto Lf
            boolean r1 = r1.isActive()
            r2 = 1
            if (r1 != r2) goto Lf
            goto L10
        Lf:
            r2 = 0
        L10:
            if (r2 != 0) goto L42
            java.lang.String r4 = "Start location updates for session"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 14
            r9 = 0
            r3 = r10
            com.animaconnected.logger.LogKt.verbose$default(r3, r4, r5, r6, r7, r8, r9)
            kotlinx.coroutines.CoroutineScope r1 = r10.scope
            com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$updateLocationData$1
            r2.<init>(r10, r11, r0)
            r11 = 3
            kotlinx.coroutines.StandaloneCoroutine r11 = kotlinx.coroutines.BuildersKt.launch$default(r1, r0, r0, r2, r11)
            r10.workoutLocationJob = r11
            goto L42
        L2d:
            java.lang.String r2 = "Stop location updates for session"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 14
            r7 = 0
            r1 = r10
            com.animaconnected.logger.LogKt.verbose$default(r1, r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.Job r11 = r10.workoutLocationJob
            if (r11 == 0) goto L40
            r11.cancel(r0)
        L40:
            r10.workoutLocationJob = r0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.updateLocationData(boolean):void");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object clearLocalFitnessData(Continuation<? super Unit> continuation) {
        FitnessConfig executeAsOneOrNull = FitnessDatabaseExtensionsKt.getProfile(this.db, DateTimeUtilsKt.currentTimeMillis()).executeAsOneOrNull();
        long lastSynced = this.fitnessCloudProvider.getLastSynced();
        clearRawBefore(lastSynced);
        clearProcessedBefore(lastSynced);
        this.db.clearProfile();
        if (executeAsOneOrNull != null) {
            FitnessDatabaseExtensionsKt.insertProfile(this.db, executeAsOneOrNull);
        }
        this.fitnessCloudProvider.clearLocalTimestamps();
        Watch watch = this.watch;
        if (!(watch instanceof DisplayWatch)) {
            return Unit.INSTANCE;
        }
        DisplayWatch displayWatch = (DisplayWatch) watch;
        displayWatch.getStorage$watch_release().put(FitnessSyncWatch.clearDailyFitnessDataKey, true);
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$clearLocalFitnessData$3
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Clear fitness on next writeDailyFitnessData";
            }
        }, 6, (Object) null);
        FitnessSyncWatch fitnessSync$watch_release = displayWatch.getFitnessSync$watch_release();
        if (fitnessSync$watch_release != null) {
            Object writeDailyFitnessData = fitnessSync$watch_release.writeDailyFitnessData(displayWatch.getStorage$watch_release(), continuation);
            if (writeDailyFitnessData == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return writeDailyFitnessData;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object clearLocalProfileData(Continuation<? super Unit> continuation) {
        this.db.clearProfile();
        return Unit.INSTANCE;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugClearAndProcessRestingHeartRate() {
        this.db.clearRestingHeartrateData();
        processRestingHeartrateHistoryData();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugClearAndProcessSleepHistory() {
        this.db.clearSleepHistoryData();
        processSleepHistoryData();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugClearCloudTimestamps() {
        this.fitnessCloudProvider.clearLocalTimestamps();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugClearProcessed() {
        clearProcessedBefore$default(this, 0L, 1, null);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugClearRaw() {
        clearRawBefore$default(this, 0L, 1, null);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public String debugExportToJson(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FitnessDatabaseParser.INSTANCE.exportToJson(this.db, timePeriod);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<CurrentSessionData> debugFitnessDataFlow() {
        return getSessionProvider().getCurrentSessionDataFlow();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void debugImportFromJson(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        FitnessDatabaseParser.INSTANCE.importFromJson(this.db, string);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object debugProcessSessions(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$debugProcessSessions$1
            if (r0 == 0) goto L13
            r0 = r5
            com.animaconnected.watch.fitness.WatchFitnessProvider$debugProcessSessions$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$debugProcessSessions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.WatchFitnessProvider$debugProcessSessions$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$debugProcessSessions$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.processSessionsFromDB(r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            r0 = r4
        L42:
            r0.processFitnessIndex()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.debugProcessSessions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<DebugSleepSession>> debugSleepSession() {
        final CommonFlow<List<SleepEntry>> sleepData = getSleepData(TimePeriod.Companion.none());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<? extends DebugSleepSession>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$debugSleepSession$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$debugSleepSession$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$debugSleepSession$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$debugSleepSession$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = watchFitnessProvider;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r24, kotlin.coroutines.Continuation r25) {
                    /*
                        Method dump skipped, instructions count: 489
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$debugSleepSession$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends WatchFitnessProvider.DebugSleepSession>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deleteFitnessData(kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L67
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L36:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4f
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.watch.device.AccountBackend r8 = r7.accountBackend
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.token(r0)
            if (r8 != r1) goto L4e
            return r1
        L4e:
            r2 = r7
        L4f:
            com.animaconnected.watch.utils.WatchLibResult r8 = (com.animaconnected.watch.utils.WatchLibResult) r8
            java.lang.Object r8 = r8.getOrNull()
            java.lang.String r8 = (java.lang.String) r8
            if (r8 == 0) goto L6a
            com.animaconnected.watch.account.fitness.FitnessCloudProvider r4 = r2.fitnessCloudProvider
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r4.deleteData(r8, r0)
            if (r8 != r1) goto L66
            return r1
        L66:
            r0 = r2
        L67:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L6c
        L6a:
            r8 = 0
            r0 = r2
        L6c:
            if (r8 != 0) goto L79
            java.lang.String r1 = r0.tag
            r2 = 0
            r3 = 0
            com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3 r4 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3
                static {
                    /*
                        com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3) com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Failed to delete data, null token"
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteFitnessData$3.invoke():java.lang.Object");
                }
            }
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.debug$default(r0, r1, r2, r3, r4, r5, r6)
        L79:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.deleteFitnessData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object deleteSession(final Session session, Continuation<? super WatchLibResult<Unit, WatchLibException>> continuation) {
        try {
            this.db.transaction(false, new Function1<TransactionWithoutReturn, Unit>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteSession$2
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
                    Session m1466copyiXt3iNo;
                    Intrinsics.checkNotNullParameter(transaction, "$this$transaction");
                    FitnessQueries db = WatchFitnessProvider.this.getDb();
                    m1466copyiXt3iNo = r3.m1466copyiXt3iNo((r44 & 1) != 0 ? r3.historyDeviceId : null, (r44 & 2) != 0 ? r3.sessionId : 0L, (r44 & 4) != 0 ? r3.type : null, (r44 & 8) != 0 ? r3.gps : false, (r44 & 16) != 0 ? r3.startTs : 0L, (r44 & 32) != 0 ? r3.endTs : 0L, (r44 & 64) != 0 ? r3.totalTimeMs : 0L, (r44 & 128) != 0 ? r3.activeTimeMs : 0L, (r44 & 256) != 0 ? r3.totalDistanceMeter : 0.0d, (r44 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0 ? r3.steps : 0, (r44 & 1024) != 0 ? r3.calories : 0, (r44 & 2048) != 0 ? r3.bmr : 0, (r44 & 4096) != 0 ? r3.elevationGain : 0, (r44 & DfuBaseService.ERROR_REMOTE_MASK) != 0 ? r3.fitnessIndex : null, (r44 & DfuBaseService.ERROR_CONNECTION_MASK) != 0 ? r3.heartrateEntries : null, (r44 & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0 ? r3.activityEntries : null, (r44 & 65536) != 0 ? r3.locationEntries : null, (r44 & 131072) != 0 ? r3.elevation : null, (r44 & 262144) != 0 ? r3.intervals : null, (r44 & 524288) != 0 ? session.status : SessionStatus.Deleted);
                    FitnessDatabaseExtensionsKt.insertSession(db, m1466copyiXt3iNo);
                    WatchFitnessProvider.this.getDb().m1335insertDeletedSessioncu7zPM(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs());
                    WatchFitnessProvider.this.getDb().m1290deleteStravaPendingUploadcu7zPM(session.m1467getHistoryDeviceIdV9ZILtA(), session.getStartTs());
                    final Session session2 = session;
                    LogKt.debug$default((Object) transaction, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteSession$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "Flagged session as deleted (watchId=" + ((Object) HistoryDeviceId.m1561toStringimpl(Session.this.m1467getHistoryDeviceIdV9ZILtA())) + ", startTs=" + Session.this.getStartTs() + ", endTs=" + Session.this.getEndTs() + ", sessionId=" + Session.this.getSessionId() + ')';
                        }
                    }, 7, (Object) null);
                }
            });
            return new WatchLibResult.Success(Unit.INSTANCE);
        } catch (Exception e) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$deleteSession$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Failed to delete session: "));
                }
            }, 7, (Object) null);
            return new WatchLibResult.Failure(WatchLibException.Companion.getDefaultErrorException(e.getMessage()));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(4:12|13|14|15)(2:18|19))(6:20|21|(1:23)(1:31)|(3:26|(2:28|(1:30))|13)|14|15))(1:32))(2:41|(1:43)(1:44))|33|(2:35|36)(2:37|(1:39)(6:40|21|(0)(0)|(3:26|(0)|13)|14|15))))|46|6|7|(0)(0)|33|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[Catch: Exception -> 0x00a8, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a8, blocks: (B:12:0x0029, B:26:0x0093, B:28:0x0099), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object forceSyncFitnessDataToCloud(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$forceSyncFitnessDataToCloud$1
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.watch.fitness.WatchFitnessProvider$forceSyncFitnessDataToCloud$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$forceSyncFitnessDataToCloud$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.WatchFitnessProvider$forceSyncFitnessDataToCloud$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$forceSyncFitnessDataToCloud$1
            r0.<init>(r13, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.lang.Exception -> La8
            goto La8
        L2e:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L36:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L7e
        L3e:
            java.lang.Object r2 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r6 = r2
            goto L58
        L47:
            kotlin.ResultKt.throwOnFailure(r14)
            com.animaconnected.watch.device.AccountBackend r14 = r13.accountBackend
            r0.L$0 = r13
            r0.label = r5
            java.lang.Object r14 = r14.token(r0)
            if (r14 != r1) goto L57
            return r1
        L57:
            r6 = r13
        L58:
            com.animaconnected.watch.utils.WatchLibResult r14 = (com.animaconnected.watch.utils.WatchLibResult) r14
            java.lang.Object r14 = r14.getOrNull()
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L70
            java.lang.String r7 = "Failed to force sync, null token"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 14
            r12 = 0
            com.animaconnected.logger.LogKt.debug$default(r6, r7, r8, r9, r10, r11, r12)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L70:
            com.animaconnected.watch.account.fitness.FitnessCloudProvider r2 = r6.fitnessCloudProvider
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r14 = r2.sync(r14, r5, r0)
            if (r14 != r1) goto L7d
            return r1
        L7d:
            r2 = r6
        L7e:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            com.animaconnected.watch.Watch r2 = r2.watch
            boolean r4 = r2 instanceof com.animaconnected.watch.DisplayWatch
            r5 = 0
            if (r4 == 0) goto L8e
            com.animaconnected.watch.DisplayWatch r2 = (com.animaconnected.watch.DisplayWatch) r2
            goto L8f
        L8e:
            r2 = r5
        L8f:
            if (r14 == 0) goto La8
            if (r2 == 0) goto La8
            com.animaconnected.watch.fitness.sync.FitnessSyncWatch r14 = r2.getFitnessSync$watch_release()     // Catch: java.lang.Exception -> La8
            if (r14 == 0) goto La8
            com.animaconnected.watch.device.BasicStorage r2 = r2.getStorage$watch_release()     // Catch: java.lang.Exception -> La8
            r0.L$0 = r5     // Catch: java.lang.Exception -> La8
            r0.label = r3     // Catch: java.lang.Exception -> La8
            java.lang.Object r14 = r14.writeDailyFitnessData(r2, r0)     // Catch: java.lang.Exception -> La8
            if (r14 != r1) goto La8
            return r1
        La8:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.forceSyncFitnessDataToCloud(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getAvgCaloriesPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<CalorieEntry>> continuation) {
        return BuildersKt.withContext(Dispatchers.Default, new WatchFitnessProvider$getAvgCaloriesPerMonth$2(this, timePeriod, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getAvgStepsPerMonth(TimePeriod timePeriod, Continuation<? super CommonFlow<List<StepEntry>>> continuation) {
        return BuildersKt.withContext(Dispatchers.Default, new WatchFitnessProvider$getAvgStepsPerMonth$2(this, timePeriod, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public int getBMRDuring(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return BMRUtilsKt.calculateBMR(this.db, timePeriod);
    }

    /* JADX WARN: Type inference failed for: r10v8, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public List<CalorieEntry> getCaloriesBMRHistorySince(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        Instant.Companion.getClass();
        Instant instant2 = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        if (instant2.compareTo(instant) < 0) {
            return EmptyList.INSTANCE;
        }
        TimeZone.Companion.getClass();
        int daysUntil = InstantKt.daysUntil(instant, instant2, TimeZone.Companion.currentSystemDefault());
        if (daysUntil > 0) {
            TimePeriod timePeriod = new TimePeriod(DateTimeUtilsKt.getStartOfDay$default(instant, null, 2, null), instant2);
            int r10 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(1, DurationUnit.DAYS);
            IntRange until = RangesKt___RangesKt.until(0, daysUntil + 1);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
            ?? it = until.iterator();
            while (it.hasNext) {
                Instant m1706plusLRDsOJo = timePeriod.getStart().m1706plusLRDsOJo(Duration.m1687timesUwyO8pc(it.nextInt(), duration));
                TimePeriod timePeriod2 = new TimePeriod(m1706plusLRDsOJo, SleepTimePeriodKt.min(m1706plusLRDsOJo.m1706plusLRDsOJo(duration), instant2));
                arrayList.add(new CalorieEntry(timePeriod2, BMRUtilsKt.calculateBMR(this.db, timePeriod2)));
            }
            return arrayList;
        }
        TimePeriod timePeriod3 = new TimePeriod(instant, instant2);
        return CollectionsKt__CollectionsKt.listOf(new CalorieEntry(timePeriod3, BMRUtilsKt.calculateBMR(this.db, timePeriod3)));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<CalorieEntry>> getCaloriesWithResolution(final TimePeriod timePeriod, final int r13) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final long durationMs = timePeriod.getDurationMs() / r13;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getSumCaloriesIntervaled(timePeriod.getStartTs(), durationMs, timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<CalorieEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getCaloriesWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getCaloriesWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getCaloriesWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getCaloriesWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                    this.this$0 = watchFitnessProvider;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r19, kotlin.coroutines.Continuation r20) {
                    /*
                        Method dump skipped, instructions count: 262
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getCaloriesWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<WatchFitnessProvider.CalorieEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r13, timePeriod, durationMs, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<Entry>> getData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final Flow[] flowArr = {getStepsData(timePeriod), getHeartrateData(timePeriod), getSessionsData(timePeriod), getLocationData(timePeriod), getSleepData(timePeriod), getSleepHistoryDataEntries(timePeriod), getStandData(timePeriod), getExerciseData(timePeriod), getStressData(timePeriod), getWristData(timePeriod), getSpeedCalibrationData(timePeriod), getRawFitnessIndexData(timePeriod), getDebugData(timePeriod), getDiagnosticData(timePeriod), getPowerData(timePeriod), getRestingHeartRateData(timePeriod)};
        return FlowExtensionsKt.asCommonFlow(new Flow<List<? extends Entry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getData$$inlined$combine$1

            /* compiled from: Zip.kt */
            @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getData$$inlined$combine$1$3", f = "WatchFitnessProvider.kt", l = {238}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getData$$inlined$combine$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends Entry>>, List<? extends Entry>[], Continuation<? super Unit>, Object> {
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
                        ArrayList flatten = CollectionsKt__IteratorsJVMKt.flatten(ArraysKt___ArraysKt.toList((List[]) ((Object[]) this.L$1)));
                        this.label = 1;
                        if (flowCollector.emit(flatten, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(FlowCollector<? super List<? extends Entry>> flowCollector, List<? extends Entry>[] listArr, Continuation<? super Unit> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
                    anonymousClass3.L$0 = flowCollector;
                    anonymousClass3.L$1 = listArr;
                    return anonymousClass3.invokeSuspend(Unit.INSTANCE);
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends Entry>> flowCollector, Continuation continuation) {
                final Flow[] flowArr2 = flowArr;
                Object combineInternal = CombineKt.combineInternal(continuation, new Function0<List<? extends Entry>[]>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getData$$inlined$combine$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final List<? extends Entry>[] invoke() {
                        return new List[flowArr2.length];
                    }
                }, new AnonymousClass3(null), flowCollector, flowArr2);
                if (combineInternal == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return combineInternal;
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final FitnessQueries getDb() {
        return this.db;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ExerciseEntry>> getExerciseData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getExerciseDataEntries(this.db, TimePeriodKt.shiftForPostCalculatedData(timePeriod))), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ExerciseEntry>> getExerciseWithResolution(final TimePeriod timePeriod, final int r14) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        TimePeriod shiftForPostCalculatedData = TimePeriodKt.shiftForPostCalculatedData(timePeriod);
        long durationMs = shiftForPostCalculatedData.getDurationMs();
        int r3 = 1;
        if (r14 >= 1) {
            r3 = r14;
        }
        final long j = durationMs / r3;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getTotalExerciseIntervaled(shiftForPostCalculatedData.getStartTs(), j, shiftForPostCalculatedData.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<ExerciseEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r17, kotlin.coroutines.Continuation r18) {
                    /*
                        r16 = this;
                        r0 = r16
                        r1 = r18
                        boolean r2 = r1 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L34
                        if (r4 != r5) goto L2c
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Lc5
                    L2c:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L34:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r17
                        java.util.List r4 = (java.util.List) r4
                        int r6 = r0.$amountOfEntries$inlined
                        r7 = 0
                        kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt___RangesKt.until(r7, r6)
                        java.util.ArrayList r8 = new java.util.ArrayList
                        r9 = 10
                        int r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r9)
                        r8.<init>(r9)
                        kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
                    L53:
                        boolean r9 = r6.hasNext
                        if (r9 == 0) goto L7f
                        int r9 = r6.nextInt()
                        com.animaconnected.watch.fitness.ExerciseEntry r15 = new com.animaconnected.watch.fitness.ExerciseEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r10 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r11 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r10)
                        com.animaconnected.watch.fitness.TimePeriod r10 = r0.$timePeriod$inlined
                        long r12 = r10.getStartTs()
                        long r9 = (long) r9
                        r17 = r6
                        long r5 = r0.$interval$inlined
                        long r9 = r9 * r5
                        long r12 = r12 + r9
                        r14 = 0
                        r5 = 0
                        r10 = r15
                        r6 = r15
                        r15 = r5
                        r10.<init>(r11, r12, r14, r15)
                        r8.add(r6)
                        r6 = r17
                        r5 = 1
                        goto L53
                    L7f:
                        java.util.ArrayList r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r8)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r4 = r4.iterator()
                    L89:
                        boolean r6 = r4.hasNext()
                        if (r6 == 0) goto Lbb
                        java.lang.Object r6 = r4.next()
                        com.animaconnected.watch.fitness.GetTotalExerciseIntervaled r6 = (com.animaconnected.watch.fitness.GetTotalExerciseIntervaled) r6
                        long r8 = r6.getInterval_index()
                        int r8 = (int) r8
                        java.lang.Integer r6 = r6.getTotal_active_minutes()
                        if (r6 == 0) goto La6
                        int r6 = r6.intValue()
                        r13 = r6
                        goto La7
                    La6:
                        r13 = r7
                    La7:
                        java.lang.Object r6 = r5.get(r8)
                        r9 = r6
                        com.animaconnected.watch.fitness.ExerciseEntry r9 = (com.animaconnected.watch.fitness.ExerciseEntry) r9
                        r10 = 0
                        r11 = 0
                        r14 = 3
                        r15 = 0
                        com.animaconnected.watch.fitness.ExerciseEntry r6 = com.animaconnected.watch.fitness.ExerciseEntry.m1219copyOZHprlw$default(r9, r10, r11, r13, r14, r15)
                        r5.set(r8, r6)
                        goto L89
                    Lbb:
                        r6 = 1
                        r2.label = r6
                        java.lang.Object r1 = r1.emit(r5, r2)
                        if (r1 != r3) goto Lc5
                        return r3
                    Lc5:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getExerciseWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<ExerciseEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r14, timePeriod, j), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<FitnessIndexEntry>> getFitnessIndexDataWithResolution(final TimePeriod timePeriod, final int r13) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final long durationMs = timePeriod.getDurationMs() / r13;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getProcessedFitnessIndexIntervaled(timePeriod.getStartTs(), durationMs, timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<FitnessIndexEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                /* JADX WARN: Type inference failed for: r18v1, types: [java.util.ArrayList] */
                /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
                /* JADX WARN: Type inference failed for: r6v3, types: [java.util.ArrayList] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r18, kotlin.coroutines.Continuation r19) {
                    /*
                        r17 = this;
                        r0 = r17
                        r1 = r19
                        boolean r2 = r1 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L34
                        if (r4 != r5) goto L2c
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Ld1
                    L2c:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L34:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r18
                        java.util.List r4 = (java.util.List) r4
                        r6 = 0
                        int r7 = r0.$amountOfEntries$inlined
                        kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt___RangesKt.until(r6, r7)
                        java.util.ArrayList r7 = new java.util.ArrayList
                        r8 = 10
                        int r8 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r8)
                        r7.<init>(r8)
                        kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
                    L53:
                        boolean r8 = r6.hasNext
                        if (r8 == 0) goto L78
                        int r8 = r6.nextInt()
                        com.animaconnected.watch.fitness.FitnessIndexEntry r15 = new com.animaconnected.watch.fitness.FitnessIndexEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r9 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r10 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r9)
                        com.animaconnected.watch.fitness.TimePeriod r9 = r0.$timePeriod$inlined
                        long r11 = r9.getStartTs()
                        long r8 = (long) r8
                        long r13 = r0.$interval$inlined
                        long r8 = r8 * r13
                        long r11 = r11 + r8
                        r13 = 0
                        r14 = 0
                        r9 = r15
                        r9.<init>(r10, r11, r13, r14)
                        r7.add(r15)
                        goto L53
                    L78:
                        java.util.ArrayList r6 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r7)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r4 = r4.iterator()
                    L82:
                        boolean r7 = r4.hasNext()
                        if (r7 == 0) goto Lc3
                        java.lang.Object r7 = r4.next()
                        com.animaconnected.watch.fitness.GetProcessedFitnessIndexIntervaled r7 = (com.animaconnected.watch.fitness.GetProcessedFitnessIndexIntervaled) r7
                        long r8 = r7.getInterval_index()
                        int r8 = (int) r8
                        java.lang.Double r7 = r7.getAvg_fitness_index()
                        if (r7 == 0) goto L9f
                        double r9 = r7.doubleValue()
                        float r7 = (float) r9
                        goto La0
                    L9f:
                        r7 = 0
                    La0:
                        r13 = r7
                        com.animaconnected.watch.fitness.FitnessIndexEntry r7 = new com.animaconnected.watch.fitness.FitnessIndexEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r9 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r10 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r9)
                        com.animaconnected.watch.fitness.TimePeriod r9 = r0.$timePeriod$inlined
                        long r11 = r9.getStartTs()
                        long r14 = (long) r8
                        r18 = r6
                        long r5 = r0.$interval$inlined
                        long r14 = r14 * r5
                        long r11 = r11 + r14
                        r14 = 0
                        r9 = r7
                        r9.<init>(r10, r11, r13, r14)
                        r5 = r18
                        r5.set(r8, r7)
                        r6 = r5
                        r5 = 1
                        goto L82
                    Lc3:
                        r16 = r6
                        r6 = r5
                        r5 = r16
                        r2.label = r6
                        java.lang.Object r1 = r1.emit(r5, r2)
                        if (r1 != r3) goto Ld1
                        return r3
                    Ld1:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexDataWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<FitnessIndexEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r13, timePeriod, durationMs), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Float> getFitnessIndexLatest() {
        SafeFlow flow = FlowQuery.toFlow(this.db.getLastProcessedFitnessIndex());
        CoroutineDispatcher context = DispatchersKt.ioDispatcher();
        Intrinsics.checkNotNullParameter(context, "context");
        final FlowQuery$mapToOneOrNull$$inlined$map$1 flowQuery$mapToOneOrNull$$inlined$map$1 = new FlowQuery$mapToOneOrNull$$inlined$map$1(flow, context);
        return FlowExtensionsKt.asCommonFlow(new Flow<Float>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        com.animaconnected.watch.fitness.DBFitnessIndexProcessed r5 = (com.animaconnected.watch.fitness.DBFitnessIndexProcessed) r5
                        if (r5 == 0) goto L3d
                        java.lang.Float r5 = r5.getProcessed_fitness_index()
                        goto L3e
                    L3d:
                        r5 = 0
                    L3e:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getFitnessIndexLatest$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Float> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HealthGoals> getGoal(long j) {
        final SafeFlow flow = FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getGoals(this.db, j));
        final HealthGoals defaultValue = FitnessDataKt.m1223default(HealthGoals.Companion);
        final CoroutineDispatcher context = DispatchersKt.ioDispatcher();
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(context, "context");
        return FlowExtensionsKt.asCommonFlow(new Flow<Object>() { // from class: app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                public final /* synthetic */ CoroutineContext $context$inlined;
                public final /* synthetic */ Object $defaultValue$inlined;
                public final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2", f = "FlowExtensions.kt", l = {224, 223}, m = "emit")
                /* renamed from: app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public FlowCollector L$0;
                    public int label;
                    public /* synthetic */ Object result;

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

                public AnonymousClass2(FlowCollector flowCollector, CoroutineContext coroutineContext, Object obj) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$context$inlined = coroutineContext;
                    this.$defaultValue$inlined = obj;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r8
                        app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2$1 r0 = (app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2$1 r0 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L18:
                        java.lang.Object r8 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 0
                        r4 = 2
                        r5 = 1
                        if (r2 == 0) goto L39
                        if (r2 == r5) goto L33
                        if (r2 != r4) goto L2b
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L5f
                    L2b:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L33:
                        kotlinx.coroutines.flow.FlowCollector r7 = r0.L$0
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L54
                    L39:
                        kotlin.ResultKt.throwOnFailure(r8)
                        app.cash.sqldelight.Query r7 = (app.cash.sqldelight.Query) r7
                        app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$1$1 r8 = new app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$1$1
                        java.lang.Object r2 = r6.$defaultValue$inlined
                        r8.<init>(r7, r2, r3)
                        kotlinx.coroutines.flow.FlowCollector r7 = r6.$this_unsafeFlow
                        r0.L$0 = r7
                        r0.label = r5
                        kotlin.coroutines.CoroutineContext r2 = r6.$context$inlined
                        java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r2, r8, r0)
                        if (r8 != r1) goto L54
                        return r1
                    L54:
                        r0.L$0 = r3
                        r0.label = r4
                        java.lang.Object r7 = r7.emit(r8, r0)
                        if (r7 != r1) goto L5f
                        return r1
                    L5f:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object collect = flow.collect(new AnonymousClass2(flowCollector, context, defaultValue), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public HealthGoals getGoalOnce(long j) {
        HealthGoals executeAsOneOrNull = FitnessDatabaseExtensionsKt.getGoals(this.db, j).executeAsOneOrNull();
        if (executeAsOneOrNull == null) {
            return FitnessDataKt.m1223default(HealthGoals.Companion);
        }
        return executeAsOneOrNull;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateSummary>> getHeartRateDataWithResolution(final TimePeriod timePeriod, final int r13) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final long durationMs = timePeriod.getDurationMs() / r13;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getHeartrateIntervaled(timePeriod.getStartTs(), durationMs, timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<HeartrateSummary>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateDataWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateDataWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateDataWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateDataWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                /* JADX WARN: Type inference failed for: r6v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r18, kotlin.coroutines.Continuation r19) {
                    /*
                        Method dump skipped, instructions count: 230
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateDataWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<HeartrateSummary>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r13, timePeriod, durationMs), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateEntry> getHeartRateHistorySince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        return FlowExtensionsKt.asCommonFlow(FlowExtensionsKt.dynamicQueryAsFlow(timestamp.toEpochMilliseconds(), new Function1<Long, Query<? extends HeartrateEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateHistorySince$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Query<? extends HeartrateEntry> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Query<HeartrateEntry> invoke(long j) {
                return FitnessDatabaseExtensionsKt.getHeartRateHistoryEntriesSince(WatchFitnessProvider.this.getDb(), j);
            }
        }, new Function1<HeartrateEntry, Long>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartRateHistorySince$2
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(HeartrateEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(it.getTimestamp());
            }
        }));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateEntry>> getHeartrateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getHeartrateDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<HeartrateEntry>> getHeartrateDataForCurrentDevice(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Watch watch = this.watch;
        if (watch != null) {
            return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.m1227getHeartrateDataEntriesVAJrmyI(this.db, timePeriod, watch.m1046getHistoryDeviceIdV9ZILtA())), DispatchersKt.ioDispatcher()));
        }
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1] */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateMetricItem> getHeartrateLiveData() {
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 = new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new WatchFitnessProvider$getHeartrateLiveData$liveFlow$1(this, null), this.heartrateLiveSharedStateFlow);
        final CommonFlow<HeartrateEntry> latestHeartrateDataForCurrentDevice = getLatestHeartrateDataForCurrentDevice();
        Flow[] flowArr = {new Flow<HeartrateMetricItem>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L64
                    L27:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r10)
                        kotlinx.coroutines.flow.FlowCollector r10 = r8.$this_unsafeFlow
                        com.animaconnected.watch.fitness.HeartrateEntry r9 = (com.animaconnected.watch.fitness.HeartrateEntry) r9
                        if (r9 == 0) goto L5a
                        com.animaconnected.watch.workout.HeartrateMetricItem r2 = new com.animaconnected.watch.workout.HeartrateMetricItem
                        com.animaconnected.watch.fitness.HeartrateValue r4 = new com.animaconnected.watch.fitness.HeartrateValue
                        int r5 = r9.getHeartrate()
                        int r6 = r9.getConfidence()
                        r4.<init>(r5, r6)
                        kotlinx.datetime.Instant$Companion r5 = kotlinx.datetime.Instant.Companion
                        long r6 = r9.getTimestamp()
                        r5.getClass()
                        kotlinx.datetime.Instant r9 = kotlinx.datetime.Instant.Companion.fromEpochMilliseconds(r6)
                        com.animaconnected.watch.workout.HeartrateSource r5 = com.animaconnected.watch.workout.HeartrateSource.HISTORY
                        r2.<init>(r4, r9, r5)
                        goto L5b
                    L5a:
                        r2 = 0
                    L5b:
                        r0.label = r3
                        java.lang.Object r9 = r10.emit(r2, r0)
                        if (r9 != r1) goto L64
                        return r1
                    L64:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getHeartrateLiveData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super HeartrateMetricItem> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, flowKt__EmittersKt$onStart$$inlined$unsafeFlow$1};
        int r1 = FlowKt__MergeKt.DEFAULT_CONCURRENCY;
        final ChannelLimitedFlowMerge channelLimitedFlowMerge = new ChannelLimitedFlowMerge(new ArraysKt___ArraysKt$asIterable$$inlined$Iterable$1(flowArr), EmptyCoroutineContext.INSTANCE, -2, BufferOverflow.SUSPEND);
        final FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 flowKt__TransformKt$runningFold$$inlined$unsafeFlow$1 = new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(new WatchFitnessProvider$getHeartrateLiveData$1(null), new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                public final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public int label;
                    public /* synthetic */ Object result;

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
                public final java.lang.Object emit(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L3f
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        if (r5 == 0) goto L3f
                        r0.label = r3
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L3f
                        return r1
                    L3f:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            /* compiled from: Emitters.kt */
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
            /* loaded from: classes4.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                public final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223}, m = "emit")
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    public int label;
                    public /* synthetic */ Object result;

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

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T t, Continuation<? super Unit> continuation) {
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                        	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:70)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                        	at java.base/java.util.ArrayList.forEach(Unknown Source)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                        */
                    /*
                        this = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L3f
                    L27:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r6)
                        if (r5 == 0) goto L3f
                        r0.label = r3
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L3f
                        return r1
                    L3f:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SleepSession> getLastNightSleepData(Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        final SleepTimePeriod fromInstant$default = SleepTimePeriod.Companion.fromInstant$default(SleepTimePeriod.Companion, DateTimeUtilsKt.now(), bedtime, null, 4, null);
        if (fromInstant$default == null) {
            return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
        }
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getSleepDataEntries(this.db, fromInstant$default)), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<SleepSession>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ SleepTimePeriod $sleepTimePeriod$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, SleepTimePeriod sleepTimePeriod) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$sleepTimePeriod$inlined = sleepTimePeriod;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0030  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L30
                        if (r2 != r3) goto L28
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto Lb4
                    L28:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L30:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        java.util.List r8 = (java.util.List) r8
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                        r2.<init>()
                        java.util.Iterator r8 = r8.iterator()
                    L42:
                        boolean r4 = r8.hasNext()
                        if (r4 == 0) goto L6b
                        java.lang.Object r4 = r8.next()
                        r5 = r4
                        com.animaconnected.watch.fitness.SleepEntry r5 = (com.animaconnected.watch.fitness.SleepEntry) r5
                        java.lang.String r5 = r5.mo1121getHistoryDeviceIdV9ZILtA()
                        com.animaconnected.watch.model.HistoryDeviceId r5 = com.animaconnected.watch.model.HistoryDeviceId.m1556boximpl(r5)
                        java.lang.Object r6 = r2.get(r5)
                        if (r6 != 0) goto L65
                        java.util.ArrayList r6 = new java.util.ArrayList
                        r6.<init>()
                        r2.put(r5, r6)
                    L65:
                        java.util.List r6 = (java.util.List) r6
                        r6.add(r4)
                        goto L42
                    L6b:
                        java.util.ArrayList r8 = new java.util.ArrayList
                        int r4 = r2.size()
                        r8.<init>(r4)
                        java.util.Set r2 = r2.entrySet()
                        java.util.Iterator r2 = r2.iterator()
                    L7c:
                        boolean r4 = r2.hasNext()
                        if (r4 == 0) goto L98
                        java.lang.Object r4 = r2.next()
                        java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                        com.animaconnected.watch.fitness.sleep.SleepTimePeriod r5 = r7.$sleepTimePeriod$inlined
                        java.lang.Object r4 = r4.getValue()
                        java.util.List r4 = (java.util.List) r4
                        com.animaconnected.watch.fitness.sleep.SleepSession r4 = com.animaconnected.watch.fitness.sleep.SleepSessionKt.toSleepSession(r5, r4)
                        r8.add(r4)
                        goto L7c
                    L98:
                        java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.firstOrNull(r8)
                        com.animaconnected.watch.fitness.sleep.SleepSession r8 = (com.animaconnected.watch.fitness.sleep.SleepSession) r8
                        if (r8 != 0) goto Lab
                        com.animaconnected.watch.fitness.sleep.SleepSession r8 = new com.animaconnected.watch.fitness.sleep.SleepSession
                        com.animaconnected.watch.fitness.sleep.SleepTimePeriod r2 = r7.$sleepTimePeriod$inlined
                        kotlin.collections.EmptyList r4 = kotlin.collections.EmptyList.INSTANCE
                        com.animaconnected.watch.fitness.sleep.SleepSessionState r5 = com.animaconnected.watch.fitness.sleep.SleepSessionState.Invalid
                        r8.<init>(r2, r4, r5)
                    Lab:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r8, r0)
                        if (r8 != r1) goto Lb4
                        return r1
                    Lb4:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getLastNightSleepData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SleepSession> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, fromInstant$default), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Long> getLastSynced() {
        return FlowExtensionsKt.asCommonFlow(this.lastSyncedStateFlow);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<HeartrateEntry> getLatestHeartrateDataForCurrentDevice() {
        Watch watch = this.watch;
        if (watch != null) {
            SafeFlow flow = FlowQuery.toFlow(FitnessDatabaseExtensionsKt.m1231getLatestHeartrateDataEntrynDauRJo(this.db, watch.m1046getHistoryDeviceIdV9ZILtA()));
            CoroutineDispatcher context = DispatchersKt.ioDispatcher();
            Intrinsics.checkNotNullParameter(context, "context");
            return FlowExtensionsKt.asCommonFlow(new FlowQuery$mapToOneOrNull$$inlined$map$1(flow, context));
        }
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<LocationEntry>> getLocationData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getRawLocationDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getLocationForSession(long j, Continuation<? super List<LocationEntry>> continuation) {
        return BuildersKt.withContext(Dispatchers.Default, new WatchFitnessProvider$getLocationForSession$2(this, j, null), continuation);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<PowerEntry>> getPowerDataForCurrentDevice(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Watch watch = this.watch;
        if (watch != null) {
            return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.m1234getPowerDataEntriesVAJrmyI(this.db, timePeriod, watch.m1046getHistoryDeviceIdV9ZILtA())), DispatchersKt.ioDispatcher()));
        }
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public FitnessProvider.Profile getProfile() {
        return this.profile;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<FitnessIndexEntry>> getRawFitnessIndexData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getRawFitnessIndexDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getRestingHeartrateDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateDataWithResolution(TimePeriod timePeriod, int r14) {
        int r10;
        boolean z;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List<GetRestingHeartrateIntervaled> executeAsList = this.db.getRestingHeartrateIntervaled(timePeriod.getStartTs(), timePeriod.getDurationMs() / r14, timePeriod.getEndTs()).executeAsList();
        List createEmptyPaddedList = createEmptyPaddedList(r14, timePeriod, new Function2<Long, Long, RestingHeartrateEntry>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getRestingHeartRateDataWithResolution$restingHeartRateEntries$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ RestingHeartrateEntry invoke(Long l, Long l2) {
                return invoke(l.longValue(), l2.longValue());
            }

            public final RestingHeartrateEntry invoke(long j, long j2) {
                return new RestingHeartrateEntry(HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion), j, -1, null);
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(createEmptyPaddedList, 10));
        int r2 = 0;
        for (Object obj : createEmptyPaddedList) {
            int r4 = r2 + 1;
            Object obj2 = null;
            if (r2 >= 0) {
                RestingHeartrateEntry restingHeartrateEntry = (RestingHeartrateEntry) obj;
                Iterator<T> it = executeAsList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((int) ((GetRestingHeartrateIntervaled) next).getInterval_index()) == r2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        obj2 = next;
                        break;
                    }
                }
                GetRestingHeartrateIntervaled getRestingHeartrateIntervaled = (GetRestingHeartrateIntervaled) obj2;
                if (getRestingHeartrateIntervaled != null) {
                    String none = HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion);
                    long timestamp = restingHeartrateEntry.getTimestamp();
                    Double avgRestingHeartRateValue = getRestingHeartrateIntervaled.getAvgRestingHeartRateValue();
                    if (avgRestingHeartRateValue != null) {
                        r10 = (int) avgRestingHeartRateValue.doubleValue();
                    } else {
                        r10 = 0;
                    }
                    restingHeartrateEntry = new RestingHeartrateEntry(none, timestamp, r10, null);
                }
                arrayList.add(restingHeartrateEntry);
                r2 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public FitnessProvider.SessionProvider getSessionProvider() {
        return this.sessionProvider;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SessionEntry>> getSessionsData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getSessionDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object getSessionsDetailed(long j, Continuation<? super Session> continuation) {
        return FitnessDatabaseExtensionsKt.getSessionDetailed(this.db, j);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Session> getSessionsDetailedSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        final Flow dynamicQueryAsFlow = FlowExtensionsKt.dynamicQueryAsFlow(timestamp.toEpochMilliseconds(), new Function1<Long, Query<? extends DBSession>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Query<? extends DBSession> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Query<DBSession> invoke(long j) {
                return WatchFitnessProvider.this.getDb().getSessionsSince(j);
            }
        }, new Function1<DBSession, Long>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$2
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(DBSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(it.getStart_timestamp());
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<Session>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2", f = "WatchFitnessProvider.kt", l = {224, 225}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = watchFitnessProvider;
                }

                /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r9, kotlin.coroutines.Continuation r10) {
                    /*
                        r8 = this;
                        boolean r0 = r10 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r10
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1$2$1
                        r0.<init>(r10)
                    L18:
                        java.lang.Object r10 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3a
                        if (r2 == r4) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L63
                    L2a:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r10)
                        throw r9
                    L32:
                        java.lang.Object r9 = r0.L$0
                        kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
                        kotlin.ResultKt.throwOnFailure(r10)
                        goto L55
                    L3a:
                        kotlin.ResultKt.throwOnFailure(r10)
                        kotlinx.coroutines.flow.FlowCollector r10 = r8.$this_unsafeFlow
                        com.animaconnected.watch.fitness.DBSession r9 = (com.animaconnected.watch.fitness.DBSession) r9
                        com.animaconnected.watch.fitness.WatchFitnessProvider r2 = r8.this$0
                        long r5 = r9.getStart_timestamp()
                        r0.L$0 = r10
                        r0.label = r4
                        java.lang.Object r9 = r2.getSessionsDetailed(r5, r0)
                        if (r9 != r1) goto L52
                        return r1
                    L52:
                        r7 = r10
                        r10 = r9
                        r9 = r7
                    L55:
                        if (r10 == 0) goto L63
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r9 = r9.emit(r10, r0)
                        if (r9 != r1) goto L63
                        return r1
                    L63:
                        kotlin.Unit r9 = kotlin.Unit.INSTANCE
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsDetailedSince$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Session> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<Session>> getSessionsOverview(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getSessions(timePeriod.getStartTs(), timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(FlowKt.flowOn(new Flow<List<? extends Session>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = watchFitnessProvider;
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
                        boolean r0 = r6 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1$2$1
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
                        java.util.List r5 = (java.util.List) r5
                        com.animaconnected.watch.fitness.WatchFitnessProvider r2 = r4.this$0
                        java.util.List r5 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$toSessions(r2, r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverview$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends Session>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<Session> getSessionsOverviewsSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        final Flow dynamicQueryAsFlow = FlowExtensionsKt.dynamicQueryAsFlow(timestamp.toEpochMilliseconds(), new Function1<Long, Query<? extends DBSession>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Query<? extends DBSession> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Query<DBSession> invoke(long j) {
                return WatchFitnessProvider.this.getDb().getSessionsSince(j);
            }
        }, new Function1<DBSession, Long>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$2
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(DBSession it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(it.getStart_timestamp());
            }
        });
        return FlowExtensionsKt.asCommonFlow(FlowKt.flowOn(new Flow<Session>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = watchFitnessProvider;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L49
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        com.animaconnected.watch.fitness.DBSession r6 = (com.animaconnected.watch.fitness.DBSession) r6
                        com.animaconnected.watch.fitness.WatchFitnessProvider r2 = r5.this$0
                        com.animaconnected.watch.fitness.FitnessQueries r4 = r2.getDb()
                        com.animaconnected.watch.fitness.Session r6 = com.animaconnected.watch.fitness.WatchFitnessProvider.access$toSession(r2, r6, r4)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getSessionsOverviewsSince$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Session> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SleepEntry>> getSleepData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getSleepDataEntries(this.db, timePeriod.getStartTs(), timePeriod.getEndTs())), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SleepHistoryEntry>> getSleepHistoryData(TimePeriod timePeriod, Bedtime bedtime) {
        long j;
        Object obj;
        String none;
        boolean z;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        List<SleepHistoryEntry> executeAsList = FitnessDatabaseExtensionsKt.getSleepHistoryDataEntries(this.db, timePeriod).executeAsList();
        if (timePeriod.contains(DateTimeUtilsKt.now())) {
            SleepTimePeriod fromInstant$default = SleepTimePeriod.Companion.fromInstant$default(SleepTimePeriod.Companion, DateTimeUtilsKt.now(), bedtime, null, 4, null);
            if (fromInstant$default == null) {
                return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(executeAsList));
            }
            SleepHistoryEntry sleepHistoryEntry = (SleepHistoryEntry) CollectionsKt___CollectionsKt.lastOrNull(executeAsList);
            if (sleepHistoryEntry != null) {
                j = sleepHistoryEntry.getEnd();
            } else {
                j = 0;
            }
            if (j > fromInstant$default.getStart().toEpochMilliseconds()) {
                return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(executeAsList));
            }
            List<SleepEntry> sleepDataEntries = SleepTimePeriodKt.sleepDataEntries(fromInstant$default, this.db);
            if (!sleepDataEntries.isEmpty()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : sleepDataEntries) {
                    HistoryDeviceId m1556boximpl = HistoryDeviceId.m1556boximpl(((SleepEntry) obj2).mo1121getHistoryDeviceIdV9ZILtA());
                    Object obj3 = linkedHashMap.get(m1556boximpl);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(m1556boximpl, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                ArrayList arrayList = new ArrayList(linkedHashMap.size());
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    arrayList.add(SleepSessionKt.toSleepSession(fromInstant$default, sleepDataEntries));
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (((SleepSession) obj).getState() != SleepSessionState.Invalid) {
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
                SleepSession sleepSession = (SleepSession) obj;
                if (sleepSession != null) {
                    SleepEntry sleepEntry = (SleepEntry) CollectionsKt___CollectionsKt.firstOrNull((List) sleepSession.getEntries());
                    if (sleepEntry != null) {
                        none = sleepEntry.mo1121getHistoryDeviceIdV9ZILtA();
                    } else {
                        none = HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion);
                    }
                    return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt___CollectionsKt.plus((Iterable) executeAsList, (Collection) CollectionsKt__CollectionsKt.listOf(new SleepHistoryEntry(none, sleepSession.getSleepTimePeriod().getStart().toEpochMilliseconds(), sleepSession.getSleepTimePeriod().getEnd().toEpochMilliseconds(), Duration.m1677getInWholeMillisecondsimpl(SleepSessionKt.lightSleepAmount(sleepSession)), Duration.m1677getInWholeMillisecondsimpl(SleepSessionKt.deepSleepAmount(sleepSession)), null)))));
                }
            }
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(executeAsList));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public SleepHistoryEntry getSleepHistoryLatestEntry() {
        return FitnessDatabaseExtensionsKt.getSleepHistoryLatestEntry(this.db).executeAsOneOrNull();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SleepSession> getSleepSessionsSince(Instant timestamp) {
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        final Flow dynamicQueryAsFlow = FlowExtensionsKt.dynamicQueryAsFlow(timestamp.toEpochMilliseconds(), new Function1<Long, Query<? extends SleepHistoryEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Query<? extends SleepHistoryEntry> invoke(Long l) {
                return invoke(l.longValue());
            }

            public final Query<SleepHistoryEntry> invoke(long j) {
                return FitnessDatabaseExtensionsKt.getSleepHistoryEntrySince(WatchFitnessProvider.this.getDb(), j);
            }
        }, new Function1<SleepHistoryEntry, Long>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$2
            @Override // kotlin.jvm.functions.Function1
            public final Long invoke(SleepHistoryEntry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(it.getEnd());
            }
        });
        return FlowExtensionsKt.asCommonFlow(new Flow<SleepSession>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ WatchFitnessProvider this$0;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = watchFitnessProvider;
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
                        boolean r0 = r7 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L2f
                        if (r2 != r3) goto L27
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L5b
                    L27:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L2f:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$this_unsafeFlow
                        com.animaconnected.watch.fitness.SleepHistoryEntry r6 = (com.animaconnected.watch.fitness.SleepHistoryEntry) r6
                        com.animaconnected.watch.fitness.sleep.SleepTimePeriod$Companion r2 = com.animaconnected.watch.fitness.sleep.SleepTimePeriod.Companion
                        com.animaconnected.watch.fitness.sleep.SleepTimePeriod r2 = r2.fromSleepHistoryEntry(r6)
                        com.animaconnected.watch.fitness.WatchFitnessProvider r4 = r5.this$0
                        com.animaconnected.watch.fitness.FitnessQueries r4 = r4.getDb()
                        java.lang.String r6 = r6.mo1121getHistoryDeviceIdV9ZILtA()
                        app.cash.sqldelight.Query r6 = com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt.m1236getSleepDataEntriesVAJrmyI(r4, r2, r6)
                        java.util.List r6 = r6.executeAsList()
                        com.animaconnected.watch.fitness.sleep.SleepSession r6 = com.animaconnected.watch.fitness.sleep.SleepSessionKt.toSleepSession(r2, r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L5b
                        return r1
                    L5b:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getSleepSessionsSince$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super SleepSession> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<SpeedCalibrationEntry>> getSpeedCalibrationData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getSpeedCalibrationEntry(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StandEntry>> getStandData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getStandDataEntries(this.db, TimePeriodKt.shiftForPostCalculatedData(timePeriod))), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StandEntry>> getStandWithResolution(final TimePeriod timePeriod, final int r14) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        TimePeriod shiftForPostCalculatedData = TimePeriodKt.shiftForPostCalculatedData(timePeriod);
        long durationMs = shiftForPostCalculatedData.getDurationMs();
        int r3 = 1;
        if (r14 >= 1) {
            r3 = r14;
        }
        final long j = durationMs / r3;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getTotalStandsIntervaled(shiftForPostCalculatedData.getStartTs(), j, shiftForPostCalculatedData.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<StandEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r17, kotlin.coroutines.Continuation r18) {
                    /*
                        r16 = this;
                        r0 = r16
                        r1 = r18
                        boolean r2 = r1 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L34
                        if (r4 != r5) goto L2c
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Lc5
                    L2c:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L34:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r17
                        java.util.List r4 = (java.util.List) r4
                        int r6 = r0.$amountOfEntries$inlined
                        r7 = 0
                        kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt___RangesKt.until(r7, r6)
                        java.util.ArrayList r8 = new java.util.ArrayList
                        r9 = 10
                        int r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r9)
                        r8.<init>(r9)
                        kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
                    L53:
                        boolean r9 = r6.hasNext
                        if (r9 == 0) goto L7f
                        int r9 = r6.nextInt()
                        com.animaconnected.watch.fitness.StandEntry r15 = new com.animaconnected.watch.fitness.StandEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r10 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r11 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r10)
                        com.animaconnected.watch.fitness.TimePeriod r10 = r0.$timePeriod$inlined
                        long r12 = r10.getStartTs()
                        long r9 = (long) r9
                        r17 = r6
                        long r5 = r0.$interval$inlined
                        long r9 = r9 * r5
                        long r12 = r12 + r9
                        r14 = 0
                        r5 = 0
                        r10 = r15
                        r6 = r15
                        r15 = r5
                        r10.<init>(r11, r12, r14, r15)
                        r8.add(r6)
                        r6 = r17
                        r5 = 1
                        goto L53
                    L7f:
                        java.util.ArrayList r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r8)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r4 = r4.iterator()
                    L89:
                        boolean r6 = r4.hasNext()
                        if (r6 == 0) goto Lbb
                        java.lang.Object r6 = r4.next()
                        com.animaconnected.watch.fitness.GetTotalStandsIntervaled r6 = (com.animaconnected.watch.fitness.GetTotalStandsIntervaled) r6
                        long r8 = r6.getInterval_index()
                        int r8 = (int) r8
                        java.lang.Integer r6 = r6.getTotal_stands()
                        if (r6 == 0) goto La6
                        int r6 = r6.intValue()
                        r13 = r6
                        goto La7
                    La6:
                        r13 = r7
                    La7:
                        java.lang.Object r6 = r5.get(r8)
                        r9 = r6
                        com.animaconnected.watch.fitness.StandEntry r9 = (com.animaconnected.watch.fitness.StandEntry) r9
                        r10 = 0
                        r11 = 0
                        r14 = 3
                        r15 = 0
                        com.animaconnected.watch.fitness.StandEntry r6 = com.animaconnected.watch.fitness.StandEntry.m1489copyOZHprlw$default(r9, r10, r11, r13, r14, r15)
                        r5.set(r8, r6)
                        goto L89
                    Lbb:
                        r6 = 1
                        r2.label = r6
                        java.lang.Object r1 = r1.emit(r5, r2)
                        if (r1 != r3) goto Lc5
                        return r3
                    Lc5:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getStandWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<StandEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r14, timePeriod, j), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<ActivityEntry>> getStepsData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getActivityDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public List<ActivityEntry> getStepsDataAsList(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FitnessDatabaseExtensionsKt.getActivityDataEntries(this.db, timePeriod).executeAsList();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StepEntry>> getStepsWithResolution(TimePeriod timePeriod, final int r16) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final TimePeriod shiftForPostCalculatedData = TimePeriodKt.shiftForPostCalculatedData(timePeriod);
        long durationMs = timePeriod.getDurationMs();
        int r2 = 1;
        if (r16 >= 1) {
            r2 = r16;
        }
        final long j = durationMs / r2;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getSumStepsIntervaled(shiftForPostCalculatedData.getStartTs(), j, shiftForPostCalculatedData.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<StepEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ TimePeriod $shiftedTimePeriod$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$shiftedTimePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
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
                        boolean r2 = r1 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L34
                        if (r4 != r5) goto L2c
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Lcd
                    L2c:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L34:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r19
                        java.util.List r4 = (java.util.List) r4
                        r6 = 0
                        int r7 = r0.$amountOfEntries$inlined
                        kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt___RangesKt.until(r6, r7)
                        java.util.ArrayList r7 = new java.util.ArrayList
                        r8 = 10
                        int r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r8)
                        r7.<init>(r9)
                        kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
                    L53:
                        boolean r9 = r6.hasNext
                        if (r9 == 0) goto L7f
                        int r9 = r6.nextInt()
                        com.animaconnected.watch.fitness.StepEntry r15 = new com.animaconnected.watch.fitness.StepEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r10 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r11 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r10)
                        com.animaconnected.watch.fitness.TimePeriod r10 = r0.$shiftedTimePeriod$inlined
                        long r12 = r10.getStartTs()
                        long r9 = (long) r9
                        r19 = r6
                        long r5 = r0.$interval$inlined
                        long r9 = r9 * r5
                        long r12 = r12 + r9
                        r14 = 0
                        r5 = 0
                        r10 = r15
                        r6 = r15
                        r15 = r5
                        r10.<init>(r11, r12, r14, r15)
                        r7.add(r6)
                        r6 = r19
                        r5 = 1
                        goto L53
                    L7f:
                        java.util.ArrayList r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r7)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.ArrayList r6 = new java.util.ArrayList
                        int r7 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r4, r8)
                        r6.<init>(r7)
                        java.util.Iterator r4 = r4.iterator()
                    L92:
                        boolean r7 = r4.hasNext()
                        if (r7 == 0) goto Lc3
                        java.lang.Object r7 = r4.next()
                        com.animaconnected.watch.fitness.GetSumStepsIntervaled r7 = (com.animaconnected.watch.fitness.GetSumStepsIntervaled) r7
                        long r8 = r7.getInterval_index()
                        int r8 = (int) r8
                        double r9 = r7.getSteps()
                        int r15 = (int) r9
                        java.lang.Object r7 = r5.get(r8)
                        r11 = r7
                        com.animaconnected.watch.fitness.StepEntry r11 = (com.animaconnected.watch.fitness.StepEntry) r11
                        r12 = 0
                        r13 = 0
                        r16 = 3
                        r17 = 0
                        com.animaconnected.watch.fitness.StepEntry r7 = com.animaconnected.watch.fitness.StepEntry.m1493copyOZHprlw$default(r11, r12, r13, r15, r16, r17)
                        r5.set(r8, r7)
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        r6.add(r7)
                        goto L92
                    Lc3:
                        r7 = 1
                        r2.label = r7
                        java.lang.Object r1 = r1.emit(r5, r2)
                        if (r1 != r3) goto Lcd
                        return r3
                    Lcd:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getStepsWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<StepEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r16, shiftForPostCalculatedData, j), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StressEntry>> getStressData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getStressDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<StressEntry>> getStressDataWithResolution(final TimePeriod timePeriod, final int r13) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        final long durationMs = timePeriod.getDurationMs() / r13;
        final FlowQuery$mapToList$$inlined$map$1 mapToList = FlowQuery.mapToList(FlowQuery.toFlow(this.db.getStressIntervaled(timePeriod.getStartTs(), durationMs, timePeriod.getEndTs())), DispatchersKt.ioDispatcher());
        return FlowExtensionsKt.asCommonFlow(new Flow<List<StressEntry>>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1

            /* compiled from: Emitters.kt */
            /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ int $amountOfEntries$inlined;
                final /* synthetic */ long $interval$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ TimePeriod $timePeriod$inlined;

                /* compiled from: Emitters.kt */
                @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {223}, m = "emit")
                /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, int r2, TimePeriod timePeriod, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$amountOfEntries$inlined = r2;
                    this.$timePeriod$inlined = timePeriod;
                    this.$interval$inlined = j;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r17, kotlin.coroutines.Continuation r18) {
                    /*
                        r16 = this;
                        r0 = r16
                        r1 = r18
                        boolean r2 = r1 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r2 == 0) goto L17
                        r2 = r1
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2$1 r2 = (com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                        int r3 = r2.label
                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                        r5 = r3 & r4
                        if (r5 == 0) goto L17
                        int r3 = r3 - r4
                        r2.label = r3
                        goto L1c
                    L17:
                        com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2$1 r2 = new com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1$2$1
                        r2.<init>(r1)
                    L1c:
                        java.lang.Object r1 = r2.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                        int r4 = r2.label
                        r5 = 1
                        if (r4 == 0) goto L34
                        if (r4 != r5) goto L2c
                        kotlin.ResultKt.throwOnFailure(r1)
                        goto Lc6
                    L2c:
                        java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                        java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                        r1.<init>(r2)
                        throw r1
                    L34:
                        kotlin.ResultKt.throwOnFailure(r1)
                        kotlinx.coroutines.flow.FlowCollector r1 = r0.$this_unsafeFlow
                        r4 = r17
                        java.util.List r4 = (java.util.List) r4
                        int r6 = r0.$amountOfEntries$inlined
                        r7 = 0
                        kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt___RangesKt.until(r7, r6)
                        java.util.ArrayList r8 = new java.util.ArrayList
                        r9 = 10
                        int r9 = kotlin.collections.CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(r6, r9)
                        r8.<init>(r9)
                        kotlin.ranges.IntProgressionIterator r6 = r6.iterator()
                    L53:
                        boolean r9 = r6.hasNext
                        if (r9 == 0) goto L7f
                        int r9 = r6.nextInt()
                        com.animaconnected.watch.fitness.StressEntry r15 = new com.animaconnected.watch.fitness.StressEntry
                        com.animaconnected.watch.model.HistoryDeviceId$Companion r10 = com.animaconnected.watch.model.HistoryDeviceId.Companion
                        java.lang.String r11 = com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt.none(r10)
                        com.animaconnected.watch.fitness.TimePeriod r10 = r0.$timePeriod$inlined
                        long r12 = r10.getStartTs()
                        long r9 = (long) r9
                        r17 = r6
                        long r5 = r0.$interval$inlined
                        long r9 = r9 * r5
                        long r12 = r12 + r9
                        r14 = 0
                        r5 = 0
                        r10 = r15
                        r6 = r15
                        r15 = r5
                        r10.<init>(r11, r12, r14, r15)
                        r8.add(r6)
                        r6 = r17
                        r5 = 1
                        goto L53
                    L7f:
                        java.util.ArrayList r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r8)
                        java.lang.Iterable r4 = (java.lang.Iterable) r4
                        java.util.Iterator r4 = r4.iterator()
                    L89:
                        boolean r6 = r4.hasNext()
                        if (r6 == 0) goto Lbc
                        java.lang.Object r6 = r4.next()
                        com.animaconnected.watch.fitness.GetStressIntervaled r6 = (com.animaconnected.watch.fitness.GetStressIntervaled) r6
                        long r8 = r6.getInterval_index()
                        int r8 = (int) r8
                        java.lang.Double r6 = r6.getAvg_stress()
                        if (r6 == 0) goto La7
                        double r9 = r6.doubleValue()
                        int r6 = (int) r9
                        r13 = r6
                        goto La8
                    La7:
                        r13 = r7
                    La8:
                        java.lang.Object r6 = r5.get(r8)
                        r9 = r6
                        com.animaconnected.watch.fitness.StressEntry r9 = (com.animaconnected.watch.fitness.StressEntry) r9
                        r10 = 0
                        r11 = 0
                        r14 = 3
                        r15 = 0
                        com.animaconnected.watch.fitness.StressEntry r6 = com.animaconnected.watch.fitness.StressEntry.m1501copyOZHprlw$default(r9, r10, r11, r13, r14, r15)
                        r5.set(r8, r6)
                        goto L89
                    Lbc:
                        r6 = 1
                        r2.label = r6
                        java.lang.Object r1 = r1.emit(r5, r2)
                        if (r1 != r3) goto Lc6
                        return r3
                    Lc6:
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$getStressDataWithResolution$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<StressEntry>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, r13, timePeriod, durationMs), continuation);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<WristEntry>> getWristData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.getWristDataEntries(this.db, timePeriod)), DispatchersKt.ioDispatcher()));
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<List<WristEntry>> getWristDataForCurrentDevice(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Watch watch = this.watch;
        if (watch != null) {
            return FlowExtensionsKt.asCommonFlow(FlowQuery.mapToList(FlowQuery.toFlow(FitnessDatabaseExtensionsKt.m1237getWristDataEntriesVAJrmyI(this.db, timePeriod, watch.m1046getHistoryDeviceIdV9ZILtA())), DispatchersKt.ioDispatcher()));
        }
        return FlowExtensionsKt.asCommonFlow(EmptyFlow.INSTANCE);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasCaloriesDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.db.hasCaloriesEntriesBefore(instant.toEpochMilliseconds()).executeAsOne().booleanValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasFitnessIndexDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.db.hasProcessedFitnessIndexBefore(instant.toEpochMilliseconds()).executeAsOne().booleanValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasHeartRateDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.db.hasHeartrateEntriesBefore(instant.toEpochMilliseconds()).executeAsOne().booleanValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasRestingHeartRateDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.db.hasRestingHeartrateEntriesBefore(instant.toEpochMilliseconds()).executeAsOne().booleanValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object hasSessions(Continuation<? super Boolean> continuation) {
        boolean z;
        Boolean executeAsOneOrNull = this.db.hasSessions().executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            z = executeAsOneOrNull.booleanValue();
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasSleepHistoryBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return this.db.hasSleepHistoryBefore(instant.toEpochMilliseconds()).executeAsOne().booleanValue();
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public boolean hasStepsDataBefore(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        HasStepEntriesBefore executeAsOne = this.db.hasStepEntriesBefore(instant.toEpochMilliseconds()).executeAsOne();
        if (!executeAsOne.getRun() && !executeAsOne.getWalk()) {
            return false;
        }
        return true;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public Object hasValidSessions(Continuation<? super Boolean> continuation) {
        boolean z;
        Boolean executeAsOneOrNull = this.db.hasValidSessions().executeAsOneOrNull();
        if (executeAsOneOrNull != null) {
            z = executeAsOneOrNull.booleanValue();
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider
    public void onHybridSteps(int r9, int r10) {
        FitnessSyncWatch fitnessSync$watch_release;
        Watch watch = this.watch;
        if (watch != null && (fitnessSync$watch_release = watch.getFitnessSync$watch_release()) != null) {
            BuildersKt.launch$default(this.scope, null, null, new WatchFitnessProvider$onHybridSteps$1(this, fitnessSync$watch_release, r9, r10, null), 3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object processSessions(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$1
            if (r0 == 0) goto L13
            r0 = r12
            com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L2b
            goto L71
        L2b:
            r12 = move-exception
            goto L5d
        L2d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L35:
            kotlin.ResultKt.throwOnFailure(r12)
            com.animaconnected.watch.fitness.FitnessProvider$SessionProvider r12 = r11.getSessionProvider()
            boolean r12 = r12.isSessionOngoing()
            if (r12 == 0) goto L50
            r5 = 0
            r6 = 0
            r7 = 0
            com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2 r8 = new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2
                static {
                    /*
                        com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2) com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2.<init>():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public final java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = "Workout ongoing, don't process sessions now."
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2.invoke():java.lang.String");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ java.lang.String invoke() {
                    /*
                        r1 = this;
                        java.lang.String r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$processSessions$2.invoke():java.lang.Object");
                }
            }
            r9 = 7
            r10 = 0
            r4 = r11
            com.animaconnected.logger.LogKt.verbose$default(r4, r5, r6, r7, r8, r9, r10)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L50:
            r0.L$0 = r11     // Catch: java.lang.Exception -> L5b
            r0.label = r3     // Catch: java.lang.Exception -> L5b
            java.lang.Object r12 = r11.processSessionsFromDB(r0)     // Catch: java.lang.Exception -> L5b
            if (r12 != r1) goto L71
            return r1
        L5b:
            r12 = move-exception
            r0 = r11
        L5d:
            r3 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to process sessions: "
            r12.<init>(r1)
            java.lang.String r1 = com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0.m(r3, r12)
            r2 = 0
            r4 = 0
            r5 = 10
            r6 = 0
            com.animaconnected.logger.LogKt.err$default(r0, r1, r2, r3, r4, r5, r6)
        L71:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.processSessions(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void registerSessionListener(SessionListener sessionListener) {
        Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
        this.listener.add(sessionListener);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(2:3|(16:5|6|(1:(1:9)(2:35|36))(2:37|(1:39)(1:40))|10|(1:12)|13|(1:15)(1:34)|(1:17)(1:33)|(1:19)(1:32)|20|(1:22)|23|24|(1:26)|28|29))|41|6|(0)(0)|10|(0)|13|(0)(0)|(0)(0)|(0)(0)|20|(0)|23|24|(0)|28|29) */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:            com.animaconnected.logger.LogKt.warn$default((java.lang.Object) r0, "WatchFitnessProvider", (java.lang.Throwable) null, false, (kotlin.jvm.functions.Function0) new kotlin.jvm.functions.Function0<java.lang.String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3            static {                /*                    com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3                    r0.<init>()                                        // error: 0x0005: SPUT (r0 I:com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3) com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.INSTANCE com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3                    return                *\/                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.<clinit>():void");            }                {                /*                    r1 = this;                    r0 = 0                    r1.<init>(r0)                    return                *\/                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.<init>():void");            }                @Override // kotlin.jvm.functions.Function0            public final java.lang.String invoke() {                /*                    r1 = this;                    java.lang.String r0 = "Goal changed. Sync failed"                    return r0                *\/                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.invoke():java.lang.String");            }                @Override // kotlin.jvm.functions.Function0            public /* bridge *\/ /* synthetic *\/ java.lang.String invoke() {                /*                    r1 = this;                    java.lang.String r0 = r1.invoke()                    return r0                *\/                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.invoke():java.lang.Object");            }        }, 6, (java.lang.Object) null);     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3 A[Catch: Exception -> 0x00a7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a7, blocks: (B:24:0x009f, B:26:0x00a3), top: B:23:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.animaconnected.watch.fitness.FitnessProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setGoal(java.lang.Integer r8, java.lang.Integer r9, java.lang.Integer r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$1
            if (r0 == 0) goto L13
            r0 = r11
            com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$1 r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$1 r0 = new com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r8 = r0.L$3
            r10 = r8
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r8 = r0.L$2
            r9 = r8
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r8 = r0.L$1
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.Object r0 = r0.L$0
            com.animaconnected.watch.fitness.WatchFitnessProvider r0 = (com.animaconnected.watch.fitness.WatchFitnessProvider) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5e
        L39:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L41:
            kotlin.ResultKt.throwOnFailure(r11)
            long r4 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            com.animaconnected.watch.CommonFlow r11 = r7.getGoal(r4)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r11, r0)
            if (r11 != r1) goto L5d
            return r1
        L5d:
            r0 = r7
        L5e:
            com.animaconnected.watch.fitness.HealthGoals r11 = (com.animaconnected.watch.fitness.HealthGoals) r11
            if (r11 != 0) goto L68
            com.animaconnected.watch.fitness.HealthGoals$Companion r11 = com.animaconnected.watch.fitness.HealthGoals.Companion
            com.animaconnected.watch.fitness.HealthGoals r11 = com.animaconnected.watch.fitness.FitnessDataKt.m1223default(r11)
        L68:
            com.animaconnected.watch.fitness.HealthGoals r1 = new com.animaconnected.watch.fitness.HealthGoals
            if (r8 == 0) goto L71
            int r8 = r8.intValue()
            goto L75
        L71:
            int r8 = r11.getSteps()
        L75:
            if (r9 == 0) goto L7c
            int r9 = r9.intValue()
            goto L80
        L7c:
            int r9 = r11.getStand()
        L80:
            if (r10 == 0) goto L87
            int r10 = r10.intValue()
            goto L8b
        L87:
            int r10 = r11.getExercise()
        L8b:
            r1.<init>(r8, r9, r10)
            com.animaconnected.watch.Watch r8 = r0.watch
            if (r8 == 0) goto L9f
            java.lang.String r8 = r8.m1046getHistoryDeviceIdV9ZILtA()
            com.animaconnected.watch.fitness.FitnessQueries r9 = r0.db
            long r10 = com.animaconnected.info.DateTimeUtilsKt.currentTimeMillis()
            com.animaconnected.watch.fitness.FitnessDatabaseExtensionsKt.m1238insertGoalkRTOawE(r9, r8, r10, r1)
        L9f:
            com.animaconnected.watch.Watch r8 = r0.watch     // Catch: java.lang.Exception -> La7
            if (r8 == 0) goto Lb2
            r8.reSync$watch_release()     // Catch: java.lang.Exception -> La7
            goto Lb2
        La7:
            java.lang.String r1 = "WatchFitnessProvider"
            r2 = 0
            r3 = 0
            com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3 r4 = com.animaconnected.watch.fitness.WatchFitnessProvider$setGoal$3.INSTANCE
            r5 = 6
            r6 = 0
            com.animaconnected.logger.LogKt.warn$default(r0, r1, r2, r3, r4, r5, r6)
        Lb2:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider.setGoal(java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider
    public void setWatch(final Watch watch) {
        Intrinsics.checkNotNullParameter(watch, "watch");
        internal(getSessionProvider()).clear();
        this.watch = watch;
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Setting watch to: " + Watch.this.getIdentifier();
            }
        }, 6, (Object) null);
        Job job = this.watchStateJob;
        if (job != null) {
            job.cancel(null);
        }
        this.watchStateJob = BuildersKt.launch$default(this.scope, null, null, new WatchFitnessProvider$setWatch$2(watch, this, null), 3);
        if (watch.getState().getValue() != Watch.WatchState.Ready) {
            final Long executeAsOneOrNull = this.db.m1313getLatestTimestampY1s2hH8(watch.m1046getHistoryDeviceIdV9ZILtA()).executeAsOneOrNull();
            LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$setWatch$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "setWatch: lastSyncedStateFlow=" + executeAsOneOrNull + " since state was not ready (state: " + watch.getState().getValue() + ')';
                }
            }, 6, (Object) null);
            this.lastSyncedStateFlow.setValue(executeAsOneOrNull);
        }
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public CommonFlow<SyncResult> syncFitness() {
        FitnessSyncWatch fitnessSync$watch_release;
        CommonFlow<SyncResult> asCommonFlow = FlowExtensionsKt.asCommonFlow(new SafeFlow(new WatchFitnessProvider$syncFitness$doneSync$1(null)));
        Watch watch = this.watch;
        if (watch != null && (fitnessSync$watch_release = watch.getFitnessSync$watch_release()) != null) {
            Watch watch2 = this.watch;
            if (watch2 instanceof DisplayWatch) {
                Intrinsics.checkNotNull(watch2, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
                final DisplayWatch displayWatch = (DisplayWatch) watch2;
                final Flow<SyncResult> readFitnessData = fitnessSync$watch_release.readFitnessData(displayWatch);
                return FlowExtensionsKt.asCommonFlow(new Flow<SyncResult>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$$inlined$map$1

                    /* compiled from: Emitters.kt */
                    /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$$inlined$map$1$2, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ DisplayWatch $displayWatch$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;
                        final /* synthetic */ WatchFitnessProvider this$0;

                        /* compiled from: Emitters.kt */
                        @DebugMetadata(c = "com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$$inlined$map$1$2", f = "WatchFitnessProvider.kt", l = {228, 229, 232, 223}, m = "emit")
                        /* renamed from: com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$$inlined$map$1$2$1, reason: invalid class name */
                        /* loaded from: classes3.dex */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            Object L$1;
                            Object L$2;
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

                        public AnonymousClass2(FlowCollector flowCollector, WatchFitnessProvider watchFitnessProvider, DisplayWatch displayWatch) {
                            this.$this_unsafeFlow = flowCollector;
                            this.this$0 = watchFitnessProvider;
                            this.$displayWatch$inlined = displayWatch;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:21:0x010b  */
                        /* JADX WARN: Removed duplicated region for block: B:25:0x012d A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
                        /* JADX WARN: Removed duplicated region for block: B:36:0x0101 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
                        /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
                        /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
                        /* JADX WARN: Removed duplicated region for block: B:46:0x0073  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object emit(java.lang.Object r24, kotlin.coroutines.Continuation r25) {
                            /*
                                Method dump skipped, instructions count: 305
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super SyncResult> flowCollector, Continuation continuation) {
                        Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this, displayWatch), continuation);
                        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return collect;
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$syncFitness$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Syncing Steps for hybrid watches";
                }
            }, 7, (Object) null);
            return FlowExtensionsKt.asCommonFlow(new SafeFlow(new WatchFitnessProvider$syncFitness$3(this, fitnessSync$watch_release, null)));
        }
        return asCommonFlow;
    }

    @Override // com.animaconnected.watch.fitness.FitnessProvider
    public void unregisterSessionListener(SessionListener sessionListener) {
        Intrinsics.checkNotNullParameter(sessionListener, "sessionListener");
        this.listener.remove(sessionListener);
    }

    @Override // com.animaconnected.watch.fitness.InternalFitnessProvider
    public void updateHeartrateLiveData(HeartrateValue heartrateValue) {
        Intrinsics.checkNotNullParameter(heartrateValue, "heartrateValue");
        LogKt.debug$default((Object) this, this.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.fitness.WatchFitnessProvider$updateHeartrateLiveData$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "New live data arrived";
            }
        }, 6, (Object) null);
        MutableStateFlow<HeartrateMetricItem> mutableStateFlow = this.heartrateLiveStateFlow;
        Instant.Companion.getClass();
        mutableStateFlow.setValue(new HeartrateMetricItem(heartrateValue, new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")), HeartrateSource.LIVE));
    }
}
