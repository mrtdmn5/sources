package com.animaconnected.watch.fitness.mock;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.Elevation;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.Interval;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.watch.fitness.Session;
import com.animaconnected.watch.fitness.SessionStatus;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import com.animaconnected.watch.workout.SessionListItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: SessionMock.kt */
/* loaded from: classes3.dex */
public final class SessionMock implements FakeSessionGenerator {
    private final String hdid;
    private final HeartRateMock heartRateMock;
    private FitnessProvider.Profile.Measurement measurement;
    private int nbrOfDefaultSessions;
    private final Interval sessionIntervalDefault;
    private List<IntervalType> sessionIntervals;
    private final MutableStateFlow<List<Session>> sessionsFlow;
    private final Instant yesterday;

    /* compiled from: SessionMock.kt */
    /* loaded from: classes3.dex */
    public static final class IntervalType {
        private final Interval interval;
        private final SessionType type;

        public IntervalType(Interval interval, SessionType type) {
            Intrinsics.checkNotNullParameter(interval, "interval");
            Intrinsics.checkNotNullParameter(type, "type");
            this.interval = interval;
            this.type = type;
        }

        public static /* synthetic */ IntervalType copy$default(IntervalType intervalType, Interval interval, SessionType sessionType, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                interval = intervalType.interval;
            }
            if ((r3 & 2) != 0) {
                sessionType = intervalType.type;
            }
            return intervalType.copy(interval, sessionType);
        }

        public final Interval component1() {
            return this.interval;
        }

        public final SessionType component2() {
            return this.type;
        }

        public final IntervalType copy(Interval interval, SessionType type) {
            Intrinsics.checkNotNullParameter(interval, "interval");
            Intrinsics.checkNotNullParameter(type, "type");
            return new IntervalType(interval, type);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IntervalType)) {
                return false;
            }
            IntervalType intervalType = (IntervalType) obj;
            if (Intrinsics.areEqual(this.interval, intervalType.interval) && this.type == intervalType.type) {
                return true;
            }
            return false;
        }

        public final Interval getInterval() {
            return this.interval;
        }

        public final SessionType getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode() + (this.interval.hashCode() * 31);
        }

        public String toString() {
            return "IntervalType(interval=" + this.interval + ", type=" + this.type + ')';
        }
    }

    /* compiled from: SessionMock.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public SessionMock(int r5, HeartRateMock heartRateMock) {
        Intrinsics.checkNotNullParameter(heartRateMock, "heartRateMock");
        this.nbrOfDefaultSessions = r5;
        this.heartRateMock = heartRateMock;
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        int r6 = Duration.$r8$clinit;
        Instant m1705minusLRDsOJo = instant.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        this.yesterday = m1705minusLRDsOJo;
        this.sessionIntervals = getDefaultIntervals();
        this.measurement = FitnessProvider.Profile.Measurement.Metric;
        this.sessionIntervalDefault = new Interval(m1705minusLRDsOJo.toEpochMilliseconds(), SessionMock$$ExternalSyntheticOutline0.m(9, DurationUnit.SECONDS, m1705minusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(47, DurationUnit.MINUTES))));
        this.hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
        this.sessionsFlow = StateFlowKt.MutableStateFlow(generateSessionsFromIntervals());
    }

    private final Session bike(Interval interval) {
        return createSession$default(this, SessionType.Bike, interval, 10000.0d, 0, 600, 0, 0, null, null, locationEntries(), null, 1512, null);
    }

    private final Session createSession(SessionType sessionType, Interval interval, double d, int r36, int r37, int r38, int r39, List<HeartrateEntry> list, List<ActivityEntry> list2, List<LocationEntry> list3, List<Elevation> list4) {
        return new Session(this.hdid, interval.getStartTimestamp(), sessionType, true, interval.getStartTimestamp(), interval.getEndTimestamp(), interval.getEndTimestamp() - interval.getStartTimestamp(), interval.getEndTimestamp() - interval.getStartTimestamp(), d, r36, r37, r38, r39, null, list, list2, list3, list4, CollectionsKt__CollectionsKt.listOf(new Interval(interval.getStartTimestamp(), interval.getEndTimestamp())), SessionStatus.Valid, null);
    }

    public static /* synthetic */ Session createSession$default(SessionMock sessionMock, SessionType sessionType, Interval interval, double d, int r17, int r18, int r19, int r20, List list, List list2, List list3, List list4, int r25, Object obj) {
        Interval interval2;
        double d2;
        int r4;
        int r6;
        int r7;
        List list5;
        List list6;
        List list7;
        if ((r25 & 2) != 0) {
            interval2 = new Interval(0L, 0L);
        } else {
            interval2 = interval;
        }
        if ((r25 & 4) != 0) {
            d2 = 0.0d;
        } else {
            d2 = d;
        }
        int r5 = 0;
        if ((r25 & 8) != 0) {
            r4 = 0;
        } else {
            r4 = r17;
        }
        if ((r25 & 16) != 0) {
            r6 = 0;
        } else {
            r6 = r18;
        }
        if ((r25 & 32) != 0) {
            r7 = 0;
        } else {
            r7 = r19;
        }
        if ((r25 & 64) == 0) {
            r5 = r20;
        }
        int r8 = r25 & 128;
        List list8 = EmptyList.INSTANCE;
        if (r8 != 0) {
            list5 = list8;
        } else {
            list5 = list;
        }
        if ((r25 & 256) != 0) {
            list6 = list8;
        } else {
            list6 = list2;
        }
        if ((r25 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            list7 = list8;
        } else {
            list7 = list3;
        }
        if ((r25 & 1024) == 0) {
            list8 = list4;
        }
        return sessionMock.createSession(sessionType, interval2, d2, r4, r6, r7, r5, list5, list6, list7, list8);
    }

    private final List<Session> generateSessionsFromIntervals() {
        Session running;
        List<IntervalType> list = this.sessionIntervals;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        for (IntervalType intervalType : list) {
            int r3 = WhenMappings.$EnumSwitchMapping$0[intervalType.getType().ordinal()];
            if (r3 != 1) {
                if (r3 != 2) {
                    if (r3 != 3) {
                        if (r3 == 4) {
                            running = other(intervalType.getInterval());
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        running = bike(intervalType.getInterval());
                    }
                } else {
                    running = walking(intervalType.getInterval());
                }
            } else {
                running = running(intervalType.getInterval());
            }
            arrayList.add(running);
        }
        return arrayList;
    }

    private final List<IntervalType> getDefaultIntervals() {
        ListBuilder listBuilder = new ListBuilder();
        int r1 = this.nbrOfDefaultSessions;
        for (int r2 = 0; r2 < r1; r2++) {
            Instant instant = this.yesterday;
            int r4 = Duration.$r8$clinit;
            Instant m1706plusLRDsOJo = instant.m1706plusLRDsOJo(DurationKt.toDuration(r2 * 31, DurationUnit.DAYS));
            listBuilder.add(new IntervalType(new Interval(m1706plusLRDsOJo.toEpochMilliseconds(), m1706plusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(Random.Default.nextInt(50) + 44, DurationUnit.MINUTES)).toEpochMilliseconds()), SessionType.Companion.fromId(Integer.valueOf(r2 % SessionType.getEntries().size()))));
        }
        return CollectionsKt__CollectionsKt.build(listBuilder);
    }

    private final Session other(Interval interval) {
        return createSession$default(this, SessionType.Other, interval, 0.0d, 0, 330, 0, 0, null, null, CollectionsKt__CollectionsKt.listOf(LocationMock.INSTANCE.getMalmo()), null, 1516, null);
    }

    private final Session running(Interval interval) {
        SessionType sessionType = SessionType.Running;
        HeartRateMock heartRateMock = this.heartRateMock;
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        int r3 = Duration.$r8$clinit;
        return createSession$default(this, sessionType, interval, 7130.0d, 4410, 400, 0, 22, heartRateMock.m1520generateHeartRateDataSxA4cEA(startOfDay$default, 20, DurationKt.toDuration(5, DurationUnit.MINUTES)), null, locationEntries(), null, 1312, null);
    }

    private final Session walking(Interval interval) {
        SessionType sessionType = SessionType.Walking;
        HeartRateMock heartRateMock = this.heartRateMock;
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        int r3 = Duration.$r8$clinit;
        return createSession$default(this, sessionType, interval, 16300.0d, 4410, 330, 0, 22, heartRateMock.m1520generateHeartRateDataSxA4cEA(startOfDay$default, 20, DurationKt.toDuration(5, DurationUnit.MINUTES)), null, locationEntries(), null, 1312, null);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session bikeSession() {
        return bike(this.sessionIntervalDefault);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public FitnessProvider.Profile.Measurement getMeasurement() {
        return this.measurement;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public SessionListItem healthOnboardingSessions() {
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        int r2 = Duration.$r8$clinit;
        Instant m1705minusLRDsOJo = instant.m1705minusLRDsOJo(DurationKt.toDuration(23, DurationUnit.MINUTES));
        Instant.Companion.getClass();
        return SessionListItem.Companion.fromSession(running(new Interval(m1705minusLRDsOJo.toEpochMilliseconds(), new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")).toEpochMilliseconds())), getMeasurement());
    }

    public final List<LocationEntry> locationEntries() {
        return LocationMock.INSTANCE.getRunningRoute();
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session otherSession() {
        return other(this.sessionIntervalDefault);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session runningSession() {
        return running(this.sessionIntervalDefault);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public CommonFlow<List<Session>> sessions() {
        return FlowExtensionsKt.asCommonFlow(this.sessionsFlow);
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public void setMeasurement(FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "<set-?>");
        this.measurement = measurement;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public void setSessionIntervals(List<IntervalType> intervals) {
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.sessionIntervals = intervals;
        MutableStateFlow<List<Session>> mutableStateFlow = this.sessionsFlow;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), generateSessionsFromIntervals()));
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeSessionGenerator
    public Session walkingSession() {
        return walking(this.sessionIntervalDefault);
    }
}
