package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.FitnessIndexEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: FitnessIndexMock.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexMock {
    private final String hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
    private final boolean hasDataBefore = true;

    public final CommonFlow<List<FitnessIndexEntry>> getData(TimePeriod timePeriod) {
        List listOf;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        TimePeriod.Companion companion = TimePeriod.Companion;
        if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.day$default(companion, null, null, 3, null))) {
            listOf = CollectionsKt__CollectionsKt.listOf(new FitnessIndexEntry(this.hdid, 1L, 52.0f, null));
        } else if (Intrinsics.areEqual(timePeriod, TimePeriod.Companion.month$default(companion, null, null, 3, null))) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            float f = 52.0f;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            float f2 = 50.0f;
            float f3 = 52.0f;
            float f4 = 50.0f;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FitnessIndexEntry[]{new FitnessIndexEntry(this.hdid, 1L, 52.0f, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 2L, 52.0f, null), new FitnessIndexEntry(this.hdid, 3L, f, defaultConstructorMarker2), new FitnessIndexEntry(this.hdid, 4L, 52.0f, null), new FitnessIndexEntry(this.hdid, 5L, f, defaultConstructorMarker2), new FitnessIndexEntry(this.hdid, 6L, 52.0f, null), new FitnessIndexEntry(this.hdid, 7L, f, defaultConstructorMarker2), new FitnessIndexEntry(this.hdid, 8L, 52.0f, null), new FitnessIndexEntry(this.hdid, 9L, 52.0f, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 10L, 51.0f, null), new FitnessIndexEntry(this.hdid, 11L, f2, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 12L, 49.0f, null), new FitnessIndexEntry(this.hdid, 13L, f2, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 14L, 51.0f, null), new FitnessIndexEntry(this.hdid, 15L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 16L, 52.0f, null), new FitnessIndexEntry(this.hdid, 17L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 18L, 52.0f, null), new FitnessIndexEntry(this.hdid, 19L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 20L, 52.0f, null), new FitnessIndexEntry(this.hdid, 21L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 22L, 52.0f, null), new FitnessIndexEntry(this.hdid, 23L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 24L, 52.0f, null), new FitnessIndexEntry(this.hdid, 25L, f3, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 26L, 51.0f, null), new FitnessIndexEntry(this.hdid, 27L, f4, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 28L, 49.0f, null), new FitnessIndexEntry(this.hdid, 29L, f4, defaultConstructorMarker), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, 31L, 52.0f, defaultConstructorMarker)});
        } else {
            long j = 30;
            DefaultConstructorMarker defaultConstructorMarker3 = null;
            long j2 = 30;
            float f5 = 50.0f;
            DefaultConstructorMarker defaultConstructorMarker4 = null;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new FitnessIndexEntry[]{new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, j, 51.0f, defaultConstructorMarker3), new FitnessIndexEntry(this.hdid, j2, f5, defaultConstructorMarker4), new FitnessIndexEntry(this.hdid, j, 49.0f, defaultConstructorMarker3), new FitnessIndexEntry(this.hdid, j2, f5, defaultConstructorMarker4), new FitnessIndexEntry(this.hdid, j, 51.0f, defaultConstructorMarker3), new FitnessIndexEntry(this.hdid, j2, 51.0f, defaultConstructorMarker4), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null), new FitnessIndexEntry(this.hdid, 30L, 51.0f, null)});
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(listOf));
    }

    public final CommonFlow<List<FitnessIndexEntry>> getDataWithResolution(TimePeriod timePeriod, int r18) {
        List list;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long durationMs = timePeriod.getDurationMs() / r18;
        int r6 = 50;
        int r7 = 20;
        if (r18 == 1) {
            list = CollectionsKt__CollectionsKt.listOf(new FitnessIndexEntry(this.hdid, timePeriod.getStartTs(), Random.Default.nextInt(20, 50), null));
        } else {
            IntRange until = RangesKt___RangesKt.until(0, r18);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(new FitnessIndexEntry(this.hdid, timePeriod.getStartTs() + (((IntIterator) it).nextInt() * durationMs), Random.Default.nextInt(r7, r6), null));
                r6 = 50;
                r7 = 20;
            }
            list = arrayList;
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(list));
    }

    public final boolean getHasDataBefore() {
        return this.hasDataBefore;
    }

    /* renamed from: getHdid-V9ZILtA, reason: not valid java name */
    public final String m1519getHdidV9ZILtA() {
        return this.hdid;
    }

    public final CommonFlow<Float> getLatestValue() {
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(Float.valueOf(43.0f)));
    }
}
