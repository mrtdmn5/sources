package com.animaconnected.watch.fitness.mock;

import com.animaconnected.secondo.R;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.HeartrateSummary;
import com.animaconnected.watch.fitness.RestingHeartrateEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.LineChartValue;
import com.animaconnected.watch.graphs.PointEntry;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import com.animaconnected.watch.workout.HeartrateMetricItem;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.datetime.Instant;

/* compiled from: HeartRateMock.kt */
/* loaded from: classes3.dex */
public final class HeartRateMock implements FakeHeartRateGenerator {
    private final boolean hasDataBefore;
    private final String hdid;
    private boolean isLiveHeartRateEnabled;
    private long liveHeartRateDelay;
    private final Random random = new XorWowRandom(42, 0);
    private Function0<Integer> nextHeartRateValue = new Function0<Integer>() { // from class: com.animaconnected.watch.fitness.mock.HeartRateMock$nextHeartRateValue$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Random random;
            random = HeartRateMock.this.random;
            return Integer.valueOf(random.nextInt(R.styleable.AppTheme_statusTopStripeSetup) + 70);
        }
    };
    private Function0<Integer> nextRestingHeartRateValue = new Function0<Integer>() { // from class: com.animaconnected.watch.fitness.mock.HeartRateMock$nextRestingHeartRateValue$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Random random;
            random = HeartRateMock.this.random;
            return Integer.valueOf(random.nextInt(10) + 64);
        }
    };

    public HeartRateMock() {
        int r0 = Duration.$r8$clinit;
        this.liveHeartRateDelay = DurationKt.toDuration(2, DurationUnit.SECONDS);
        this.hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
        this.hasDataBefore = true;
    }

    /* renamed from: generateHeartRateData-SxA4cEA, reason: not valid java name */
    public final List<HeartrateEntry> m1520generateHeartRateDataSxA4cEA(Instant instant, int r19, long j) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        IntRange until = RangesKt___RangesKt.until(0, r19);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(new HeartrateEntry(this.hdid, instant.m1706plusLRDsOJo(Duration.m1687timesUwyO8pc(((IntIterator) it).nextInt(), j)).toEpochMilliseconds(), getNextHeartRateValue().invoke().intValue(), 0, (Integer) null, (Integer) null, 48, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    /* renamed from: generateHeartRatePoints-HG0u8IE, reason: not valid java name */
    public final List<PointEntry> m1521generateHeartRatePointsHG0u8IE(int r11, long j) {
        IntRange until = RangesKt___RangesKt.until(0, r11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new PointEntry((LineChartValue) new Known(getNextHeartRateValue().invoke().intValue(), false, 2, (DefaultConstructorMarker) null), String.valueOf(nextInt), WorkoutFormatUtilsKt.m1574formatElapsedTimeLRDsOJo(DurationKt.toDuration(Duration.m1677getInWholeMillisecondsimpl(j) * nextInt, DurationUnit.MILLISECONDS)), false, 8, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    /* renamed from: generateRestingHeartRateData-SxA4cEA, reason: not valid java name */
    public final List<RestingHeartrateEntry> m1522generateRestingHeartRateDataSxA4cEA(Instant instant, int r11, long j) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        IntRange until = RangesKt___RangesKt.until(0, r11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(new RestingHeartrateEntry(this.hdid, instant.m1706plusLRDsOJo(Duration.m1687timesUwyO8pc(((IntIterator) it).nextInt(), j)).toEpochMilliseconds(), getNextRestingHeartRateValue().invoke().intValue(), null));
        }
        return arrayList;
    }

    /* renamed from: generateRestingHeartRatePoints-SxA4cEA, reason: not valid java name */
    public final List<PointEntry> m1523generateRestingHeartRatePointsSxA4cEA(Instant instant, int r24, long j) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        IntRange until = RangesKt___RangesKt.until(0, r24);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            String format$default = DateFormatter.format$default(DateTimeFormattersKt.getShortMonthAndDateFormatter(ServiceLocator.INSTANCE.getStringsBackend()), instant.m1706plusLRDsOJo(Duration.m1687timesUwyO8pc(((IntIterator) it).nextInt(), j)).toEpochMilliseconds(), null, false, 6, null);
            arrayList.add(new PointEntry((LineChartValue) new Known(getNextRestingHeartRateValue().invoke().intValue(), false, 2, (DefaultConstructorMarker) null), format$default, format$default, false, 8, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    public final List<HeartrateEntry> getDailyHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List dayIntervals$default = TimePeriodKt.dayIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
        Iterator it = dayIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(new HeartrateEntry(this.hdid, ((TimePeriod) it.next()).getStartTs(), getNextHeartRateValue().invoke().intValue(), 0, (Integer) null, (Integer) null, 48, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    public final List<RestingHeartrateEntry> getDailyRestingHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List dayIntervals$default = TimePeriodKt.dayIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
        Iterator it = dayIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(new RestingHeartrateEntry(this.hdid, ((TimePeriod) it.next()).getStartTs(), getNextRestingHeartRateValue().invoke().intValue(), null));
        }
        return arrayList;
    }

    public final boolean getHasDataBefore() {
        return this.hasDataBefore;
    }

    public final CommonFlow<List<HeartrateSummary>> getHeartRateDataWithResolution(TimePeriod timePeriod, int r11) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long durationMs = timePeriod.getDurationMs() / r11;
        Instant start = timePeriod.getStart();
        int r2 = Duration.$r8$clinit;
        List<HeartrateEntry> m1520generateHeartRateDataSxA4cEA = m1520generateHeartRateDataSxA4cEA(start, r11, DurationKt.toDuration(durationMs, DurationUnit.MILLISECONDS));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(m1520generateHeartRateDataSxA4cEA, 10));
        for (HeartrateEntry heartrateEntry : m1520generateHeartRateDataSxA4cEA) {
            arrayList.add(new HeartrateSummary(heartrateEntry.getTimestamp(), heartrateEntry.getHeartrate() + 40, heartrateEntry.getHeartrate() - 30, heartrateEntry.getHeartrate(), true));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final CommonFlow<HeartrateMetricItem> getLiveData() {
        return FlowExtensionsKt.asCommonFlow(new SafeFlow(new HeartRateMock$getLiveData$1(this, null)));
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    /* renamed from: getLiveHeartRateDelay-UwyO8pc */
    public long mo1453getLiveHeartRateDelayUwyO8pc() {
        return this.liveHeartRateDelay;
    }

    public final List<HeartrateEntry> getMonthlyHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List monthIntervals$default = TimePeriodKt.monthIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthIntervals$default, 10));
        Iterator it = monthIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(new HeartrateEntry(this.hdid, ((TimePeriod) it.next()).getStartTs(), getNextHeartRateValue().invoke().intValue(), 0, (Integer) null, (Integer) null, 48, (DefaultConstructorMarker) null));
        }
        return arrayList;
    }

    public final List<RestingHeartrateEntry> getMonthlyRestingHeartRateData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        List monthIntervals$default = TimePeriodKt.monthIntervals$default(timePeriod, null, 1, null);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthIntervals$default, 10));
        Iterator it = monthIntervals$default.iterator();
        while (it.hasNext()) {
            arrayList.add(new RestingHeartrateEntry(this.hdid, ((TimePeriod) it.next()).getStartTs(), getNextRestingHeartRateValue().invoke().intValue(), null));
        }
        return arrayList;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public Function0<Integer> getNextHeartRateValue() {
        return this.nextHeartRateValue;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public Function0<Integer> getNextRestingHeartRateValue() {
        return this.nextRestingHeartRateValue;
    }

    public final CommonFlow<List<RestingHeartrateEntry>> getRestingHeartRateDataWithResolution(TimePeriod timePeriod, int r10) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long durationMs = timePeriod.getDurationMs() / r10;
        Instant start = timePeriod.getStart();
        int r2 = Duration.$r8$clinit;
        List<RestingHeartrateEntry> m1522generateRestingHeartRateDataSxA4cEA = m1522generateRestingHeartRateDataSxA4cEA(start, r10, DurationKt.toDuration(durationMs, DurationUnit.MILLISECONDS));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(m1522generateRestingHeartRateDataSxA4cEA, 10));
        Iterator<T> it = m1522generateRestingHeartRateDataSxA4cEA.iterator();
        while (it.hasNext()) {
            arrayList.add(new RestingHeartrateEntry(this.hdid, ((RestingHeartrateEntry) it.next()).getTimestamp(), getNextRestingHeartRateValue().invoke().intValue(), null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public boolean isLiveHeartRateEnabled() {
        return this.isLiveHeartRateEnabled;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    /* renamed from: setLiveHeartRateDelay-LRDsOJo */
    public void mo1454setLiveHeartRateDelayLRDsOJo(long j) {
        this.liveHeartRateDelay = j;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setLiveHeartRateEnabled(boolean z) {
        this.isLiveHeartRateEnabled = z;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setNextHeartRateValue(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.nextHeartRateValue = function0;
    }

    @Override // com.animaconnected.watch.fitness.mock.FakeHeartRateGenerator
    public void setNextRestingHeartRateValue(Function0<Integer> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.nextRestingHeartRateValue = function0;
    }
}
