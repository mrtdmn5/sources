package com.animaconnected.watch.fitness.mock;

import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.FlowExtensionsKt;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.fitness.WatchFitnessProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2;

/* compiled from: CaloriesMock.kt */
/* loaded from: classes3.dex */
public final class CaloriesMock {
    private final boolean hasCaloriesDataBefore = true;

    public final CommonFlow<List<WatchFitnessProvider.CalorieEntry>> getCaloriesWithResolution(TimePeriod timePeriod, int r14) {
        int r2;
        Number valueOf;
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long durationMs = timePeriod.getDurationMs() / r14;
        int inDays$default = TimePeriodKt.inDays$default(timePeriod, null, 1, null);
        if (r14 != 1) {
            if (r14 != 7) {
                if (r14 != 48) {
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
            r2 = 3286;
        }
        IntRange until = RangesKt___RangesKt.until(0, r14);
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
            long startTs = (nextInt * durationMs) + timePeriod.getStartTs();
            arrayList.add(new WatchFitnessProvider.CalorieEntry(new TimePeriod(startTs, startTs + durationMs), valueOf.intValue()));
        }
        return FlowExtensionsKt.asCommonFlow(new FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$2(arrayList));
    }

    public final boolean getHasCaloriesDataBefore() {
        return this.hasCaloriesDataBefore;
    }
}
