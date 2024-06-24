package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.StandEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.XorWowRandom;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: StandMock.kt */
/* loaded from: classes3.dex */
public final class StandMock {
    private final String hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
    private Integer staticStandValue;

    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public final CommonFlow<List<StandEntry>> getData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Integer num = this.staticStandValue;
        if (num != null) {
            return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new StandEntry(this.hdid, timePeriod.getStartTs(), num.intValue(), null))));
        }
        long startTs = timePeriod.getStartTs();
        IntRange intRange = new IntRange(1, new XorWowRandom((int) startTs, (int) (startTs >> 32)).nextInt(1, 12));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        ?? it = intRange.iterator();
        while (it.hasNext) {
            int nextInt = it.nextInt();
            String str = this.hdid;
            long startTs2 = timePeriod.getStartTs();
            int r4 = Duration.$r8$clinit;
            arrayList.add(new StandEntry(str, startTs2 + (Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(1, DurationUnit.HOURS)) * nextInt), nextInt, null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public final CommonFlow<List<StandEntry>> getDataWithResolution(TimePeriod timePeriod, int r13) {
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Integer num = this.staticStandValue;
        if (num != null) {
            return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new StandEntry(this.hdid, timePeriod.getStartTs(), num.intValue(), null))));
        }
        long m1674divUwyO8pc = Duration.m1674divUwyO8pc(r13, timePeriod.getEnd().m1704minus5sfh64U(timePeriod.getStart()));
        IntRange until = RangesKt___RangesKt.until(0, r13);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        ?? it = until.iterator();
        while (it.hasNext) {
            long epochMilliseconds = timePeriod.getStart().m1706plusLRDsOJo(Duration.m1687timesUwyO8pc(it.nextInt(), m1674divUwyO8pc)).toEpochMilliseconds();
            arrayList.add(new StandEntry(this.hdid, epochMilliseconds, new XorWowRandom((int) epochMilliseconds, (int) (epochMilliseconds >> 32)).nextInt(1, 12), null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1525getHdidV9ZILtA() {
        return this.hdid;
    }

    public final Integer getStaticStandValue() {
        return this.staticStandValue;
    }

    public final void setStaticStandValue(Integer num) {
        this.staticStandValue = num;
    }
}
