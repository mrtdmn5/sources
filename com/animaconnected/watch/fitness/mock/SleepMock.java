package com.animaconnected.watch.fitness.mock;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.sleep.SleepSession;
import com.animaconnected.watch.fitness.sleep.SleepSessionKt;
import com.animaconnected.watch.fitness.sleep.SleepSessionState;
import com.animaconnected.watch.fitness.sleep.SleepTimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import com.animaconnected.watch.workout.SleepType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;
import kotlinx.datetime.Instant;

/* compiled from: SleepMock.kt */
/* loaded from: classes3.dex */
public final class SleepMock {
    private final boolean hasDataBefore = true;
    private final String hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);

    public final CommonFlow<List<SleepEntry>> getData() {
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(EmptyList.INSTANCE));
    }

    public final boolean getHasDataBefore() {
        return this.hasDataBefore;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1524getHdidV9ZILtA() {
        return this.hdid;
    }

    public final CommonFlow<List<SleepHistoryEntry>> getHistoryData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long startTs = timePeriod.getStartTs();
        long endTs = (timePeriod.getEndTs() - timePeriod.getStartTs()) / 5;
        IntRange until = RangesKt___RangesKt.until(0, 5);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            long nextInt = (((IntIterator) it).nextInt() * endTs) + startTs;
            arrayList.add(new SleepHistoryEntry(this.hdid, nextInt, nextInt + endTs, 10800000L, 14400000L, null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final CommonFlow<SleepSession> getLastNightData(Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(bedtime, "bedtime");
        Instant startOfDay$default = DateTimeUtilsKt.getStartOfDay$default(null, null, 3, null);
        int r2 = Duration.$r8$clinit;
        Instant m1705minusLRDsOJo = startOfDay$default.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.DAYS));
        int hour = bedtime.getHour();
        DurationUnit durationUnit = DurationUnit.HOURS;
        Instant m1706plusLRDsOJo = m1705minusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(hour, durationUnit));
        int minute = bedtime.getMinute();
        DurationUnit durationUnit2 = DurationUnit.MINUTES;
        Instant m1706plusLRDsOJo2 = m1706plusLRDsOJo.m1706plusLRDsOJo(DurationKt.toDuration(minute, durationUnit2));
        SleepTimePeriod fromInstant$default = SleepTimePeriod.Companion.fromInstant$default(SleepTimePeriod.Companion, m1706plusLRDsOJo2, bedtime, null, 4, null);
        if (fromInstant$default == null) {
            fromInstant$default = new SleepTimePeriod(bedtime, m1706plusLRDsOJo2, m1706plusLRDsOJo2.m1706plusLRDsOJo(SleepSessionKt.getMaxSleepAmount()));
        }
        String str = this.hdid;
        long epochMilliseconds = m1706plusLRDsOJo2.toEpochMilliseconds();
        SleepType sleepType = SleepType.AWAKE;
        SleepEntry sleepEntry = new SleepEntry(str, epochMilliseconds, sleepType, null);
        String str2 = this.hdid;
        long m = SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2);
        SleepType sleepType2 = SleepType.DEEP;
        SleepEntry sleepEntry2 = new SleepEntry(str2, m, sleepType2, null);
        String str3 = this.hdid;
        long m2 = SessionMock$$ExternalSyntheticOutline0.m(1, durationUnit, m1706plusLRDsOJo2);
        SleepType sleepType3 = SleepType.LIGHT;
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(new SleepSession(fromInstant$default, CollectionsKt__CollectionsKt.listOf((Object[]) new SleepEntry[]{sleepEntry, sleepEntry2, new SleepEntry(str3, m2, sleepType3, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(2, durationUnit, m1706plusLRDsOJo2), sleepType2, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(3, durationUnit, m1706plusLRDsOJo2), sleepType, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(3, durationUnit))), sleepType2, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(4, durationUnit, m1706plusLRDsOJo2), sleepType3, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(5, durationUnit, m1706plusLRDsOJo2), sleepType2, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(7, durationUnit))), sleepType, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(8, durationUnit))), sleepType3, null), new SleepEntry(this.hdid, SessionMock$$ExternalSyntheticOutline0.m(30, durationUnit2, m1706plusLRDsOJo2.m1706plusLRDsOJo(DurationKt.toDuration(9, durationUnit))), sleepType, null)}), SleepSessionState.Completed)));
    }
}
