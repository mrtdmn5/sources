package com.animaconnected.watch.workout;

import com.animaconnected.watch.fitness.EntriesAmount;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.SleepHistoryEntry;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.model.HistoryDeviceId;
import com.animaconnected.watch.utils.HistoryDeviceIdUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SleepViewModel.kt */
/* loaded from: classes3.dex */
public final class SleepViewModelKt {
    public static final SleepHistoryEntry average(List<SleepHistoryEntry> list, TimePeriod timePeriod) {
        boolean z;
        String mo1121getHistoryDeviceIdV9ZILtA = ((SleepHistoryEntry) CollectionsKt___CollectionsKt.first((List) list)).mo1121getHistoryDeviceIdV9ZILtA();
        long startTs = timePeriod.getStartTs();
        long endTs = timePeriod.getEndTs();
        List<SleepHistoryEntry> list2 = list;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list2.iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SleepHistoryEntry) next).getLightSleepMs() <= 0) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((SleepHistoryEntry) it2.next()).getLightSleepMs()));
        }
        long averageOfLong = (long) CollectionsKt___CollectionsKt.averageOfLong(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list2) {
            if (((SleepHistoryEntry) obj).getDeepSleepMs() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(Long.valueOf(((SleepHistoryEntry) it3.next()).getDeepSleepMs()));
        }
        return new SleepHistoryEntry(mo1121getHistoryDeviceIdV9ZILtA, startTs, endTs, averageOfLong, (long) CollectionsKt___CollectionsKt.averageOfLong(arrayList4), null);
    }

    public static final List<SleepHistoryEntry> createDummyList(TimePeriod timePeriod, EntriesAmount entriesAmount) {
        ArrayList arrayList;
        SleepViewModelKt$createDummyList$dummyEntry$1 sleepViewModelKt$createDummyList$dummyEntry$1 = new Function1<TimePeriod, SleepHistoryEntry>() { // from class: com.animaconnected.watch.workout.SleepViewModelKt$createDummyList$dummyEntry$1
            @Override // kotlin.jvm.functions.Function1
            public final SleepHistoryEntry invoke(TimePeriod timePeriod2) {
                Intrinsics.checkNotNullParameter(timePeriod2, "timePeriod");
                return new SleepHistoryEntry(HistoryDeviceIdUtilsKt.none(HistoryDeviceId.Companion), timePeriod2.getStartTs(), timePeriod2.getEndTs(), 0L, 0L, null);
            }
        };
        if (Intrinsics.areEqual(entriesAmount, Months.INSTANCE)) {
            List monthIntervals$default = TimePeriodKt.monthIntervals$default(timePeriod, null, 1, null);
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(monthIntervals$default, 10));
            Iterator it = monthIntervals$default.iterator();
            while (it.hasNext()) {
                arrayList.add(sleepViewModelKt$createDummyList$dummyEntry$1.invoke((SleepViewModelKt$createDummyList$dummyEntry$1) TimePeriodKt.excludeEnd((TimePeriod) it.next())));
            }
        } else {
            List dayIntervals$default = TimePeriodKt.dayIntervals$default(timePeriod, null, 1, null);
            arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(dayIntervals$default, 10));
            Iterator it2 = dayIntervals$default.iterator();
            while (it2.hasNext()) {
                arrayList.add(sleepViewModelKt$createDummyList$dummyEntry$1.invoke((SleepViewModelKt$createDummyList$dummyEntry$1) TimePeriodKt.excludeEnd((TimePeriod) it2.next())));
            }
        }
        return arrayList;
    }

    public static final SleepHistoryEntry sum(List<SleepHistoryEntry> list) {
        String mo1121getHistoryDeviceIdV9ZILtA = ((SleepHistoryEntry) CollectionsKt___CollectionsKt.first((List) list)).mo1121getHistoryDeviceIdV9ZILtA();
        long timestamp = ((SleepHistoryEntry) CollectionsKt___CollectionsKt.first((List) list)).getTimestamp();
        long end = ((SleepHistoryEntry) CollectionsKt___CollectionsKt.last(list)).getEnd();
        List<SleepHistoryEntry> list2 = list;
        Iterator<T> it = list2.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((SleepHistoryEntry) it.next()).getLightSleepMs();
        }
        Iterator<T> it2 = list2.iterator();
        long j2 = 0;
        while (it2.hasNext()) {
            j2 += ((SleepHistoryEntry) it2.next()).getDeepSleepMs();
        }
        return new SleepHistoryEntry(mo1121getHistoryDeviceIdV9ZILtA, timestamp, end, j, j2, null);
    }
}
