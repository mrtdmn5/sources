package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.ActivityEntry;
import com.animaconnected.watch.fitness.StepEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: StepsMock.kt */
/* loaded from: classes3.dex */
public final class StepsMock {
    private Integer staticStepsValue;
    private final String hdid = HistoryDeviceIdUtilsKt.mock(HistoryDeviceId.Companion);
    private final boolean hasDataBefore = true;

    public final CommonFlow<List<ActivityEntry>> getData(TimePeriod timePeriod) {
        boolean z;
        boolean z2;
        int r1;
        Number valueOf;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long startTs = timePeriod.getStartTs();
        long endTs = timePeriod.getEndTs();
        int r6 = 1;
        int inDays$default = TimePeriodKt.inDays$default(timePeriod, null, 1, null);
        if (inDays$default == 1) {
            r6 = 48;
        } else if (inDays$default == 7) {
            r6 = 7;
        } else {
            long j = inDays$default;
            if (27 <= j && j < 32) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                r6 = 31;
            } else {
                if (360 <= j && j < 371) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    r6 = 12;
                }
            }
        }
        long j2 = (endTs - startTs) / r6;
        if (r6 == 48) {
            r1 = 250;
        } else {
            r1 = 3000;
        }
        IntRange until = RangesKt___RangesKt.until(0, r6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            long startTs2 = (nextInt * j2) + timePeriod.getStartTs();
            if (nextInt % 6 == 0) {
                valueOf = Double.valueOf(r1 * 0.7d);
            } else if (nextInt % 4 == 0) {
                valueOf = Double.valueOf(r1 * 0.2d);
            } else if (nextInt % 3 == 0) {
                valueOf = Double.valueOf(r1 * 0.4d);
            } else if (nextInt % 2 == 0) {
                valueOf = Double.valueOf(r1 * 0.9d);
            } else {
                valueOf = Integer.valueOf(r1 * 0);
            }
            arrayList.add(new ActivityEntry(this.hdid, startTs2, 0, Integer.valueOf(valueOf.intValue()), 0, 0, 0, Float.valueOf(0.0f), 0, 375, null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final CommonFlow<List<StepEntry>> getDataWithResolution(TimePeriod timePeriod, int r15) {
        int r2;
        Number valueOf;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        Integer num = this.staticStepsValue;
        if (num != null) {
            return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(CollectionsKt__CollectionsKt.listOf(new StepEntry(this.hdid, timePeriod.getStartTs(), num.intValue(), null))));
        }
        long durationMs = timePeriod.getDurationMs() / r15;
        int inDays$default = TimePeriodKt.inDays$default(timePeriod, null, 1, null);
        if (r15 != 1) {
            if (r15 != 7) {
                if (r15 != 48) {
                    r2 = 6800;
                } else {
                    r2 = 250;
                }
            } else {
                r2 = 7500;
            }
        } else if (inDays$default > 1) {
            r2 = 220000;
        } else {
            r2 = 11857;
        }
        IntRange until = RangesKt___RangesKt.until(0, r15);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (nextInt % 6 == 0) {
                valueOf = Double.valueOf(r2 * 0.7d);
            } else if (nextInt % 4 == 0) {
                valueOf = Double.valueOf(r2 * 0.2d);
            } else if (nextInt % 3 == 0) {
                valueOf = Double.valueOf(r2 * 0.4d);
            } else if (nextInt % 2 == 0) {
                valueOf = Double.valueOf(r2 * 0.9d);
            } else {
                valueOf = Integer.valueOf(r2 * 0);
            }
            arrayList.add(new StepEntry(this.hdid, timePeriod.getStartTs() + (nextInt * durationMs), valueOf.intValue(), null));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final boolean getHasDataBefore() {
        return this.hasDataBefore;
    }

    public final Integer getStaticStepsValue() {
        return this.staticStepsValue;
    }

    public final void setStaticStepsValue(Integer num) {
        this.staticStepsValue = num;
    }
}
