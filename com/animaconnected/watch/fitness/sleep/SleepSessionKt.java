package com.animaconnected.watch.fitness.sleep;

import com.animaconnected.watch.fitness.SleepEntry;
import com.animaconnected.watch.workout.SleepType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: SleepSession.kt */
/* loaded from: classes3.dex */
public final class SleepSessionKt {
    private static final long awakeTimeToEnd;
    private static final long maxSleepAmount;
    private static final long minAwake;
    private static final long minSleepAmount;
    private static final long suspiciousSleepLength;

    static {
        int r0 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.HOURS;
        minSleepAmount = DurationKt.toDuration(3, durationUnit);
        maxSleepAmount = DurationKt.toDuration(14, durationUnit);
        suspiciousSleepLength = DurationKt.toDuration(3, durationUnit);
        DurationUnit durationUnit2 = DurationUnit.MINUTES;
        awakeTimeToEnd = DurationKt.toDuration(30, durationUnit2);
        minAwake = DurationKt.toDuration(15, durationUnit2);
    }

    private static final SleepSession addAwakeStates(SleepSession sleepSession) {
        String mo1121getHistoryDeviceIdV9ZILtA = ((SleepEntry) CollectionsKt___CollectionsKt.first((List) sleepSession.getEntries())).mo1121getHistoryDeviceIdV9ZILtA();
        long timestamp = ((SleepEntry) CollectionsKt___CollectionsKt.first((List) sleepSession.getEntries())).getTimestamp();
        long j = minAwake;
        long m1677getInWholeMillisecondsimpl = timestamp - Duration.m1677getInWholeMillisecondsimpl(j);
        SleepType sleepType = SleepType.AWAKE;
        SleepEntry sleepEntry = new SleepEntry(mo1121getHistoryDeviceIdV9ZILtA, m1677getInWholeMillisecondsimpl, sleepType, null);
        SleepEntry sleepEntry2 = new SleepEntry(((SleepEntry) CollectionsKt___CollectionsKt.first((List) sleepSession.getEntries())).mo1121getHistoryDeviceIdV9ZILtA(), ((SleepEntry) CollectionsKt___CollectionsKt.last(sleepSession.getEntries())).getTimestamp(), sleepType, null);
        SleepEntry sleepEntry3 = new SleepEntry(((SleepEntry) CollectionsKt___CollectionsKt.first((List) sleepSession.getEntries())).mo1121getHistoryDeviceIdV9ZILtA(), Duration.m1677getInWholeMillisecondsimpl(j) + ((SleepEntry) CollectionsKt___CollectionsKt.last(sleepSession.getEntries())).getTimestamp(), sleepType, null);
        return new SleepSession(sleepSession.getSleepTimePeriod(), CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus(CollectionsKt___CollectionsKt.plus((Iterable) CollectionsKt___CollectionsKt.dropLast(sleepSession.getEntries()), (Collection) CollectionsKt__CollectionsKt.listOf(sleepEntry)), sleepEntry2), sleepEntry3), sleepSession.getState());
    }

    public static final long awakeAmount(SleepSession sleepSession) {
        Intrinsics.checkNotNullParameter(sleepSession, "<this>");
        return getTotalFor(sleepSession, SleepType.AWAKE);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final com.animaconnected.watch.fitness.sleep.SleepSession calculateSleepSession(com.animaconnected.watch.fitness.sleep.SleepTimePeriod r15, java.util.List<com.animaconnected.watch.fitness.SleepEntry> r16) {
        /*
            Method dump skipped, instructions count: 666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.fitness.sleep.SleepSessionKt.calculateSleepSession(com.animaconnected.watch.fitness.sleep.SleepTimePeriod, java.util.List):com.animaconnected.watch.fitness.sleep.SleepSession");
    }

    public static final long deepSleepAmount(SleepSession sleepSession) {
        Intrinsics.checkNotNullParameter(sleepSession, "<this>");
        return getTotalFor(sleepSession, SleepType.DEEP);
    }

    /* renamed from: filterSleepStates-HG0u8IE */
    private static final SleepSession m1533filterSleepStatesHG0u8IE(SleepSession sleepSession, final long j) {
        if (sleepSession.getEntries().size() < 2) {
            return sleepSession;
        }
        final ArrayList arrayList = new ArrayList();
        CollectionsKt___CollectionsKt.windowed$default(sleepSession.getEntries(), 2, 1, new Function1<List<? extends SleepEntry>, Unit>() { // from class: com.animaconnected.watch.fitness.sleep.SleepSessionKt$filterSleepStates$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SleepEntry> list) {
                invoke2((List<SleepEntry>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SleepEntry> list) {
                Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                SleepEntry sleepEntry = list.get(0);
                boolean z = list.get(1).getTimestamp() - sleepEntry.getTimestamp() > Duration.m1677getInWholeMillisecondsimpl(j);
                SleepEntry sleepEntry2 = (SleepEntry) CollectionsKt___CollectionsKt.lastOrNull(arrayList);
                boolean z2 = (sleepEntry2 != null ? sleepEntry2.getState() : null) != sleepEntry.getState() || arrayList.isEmpty();
                boolean z3 = sleepEntry.getState() == SleepType.AWAKE;
                if ((z || z3) && z2) {
                    arrayList.add(sleepEntry);
                }
            }
        }, 4);
        arrayList.add(CollectionsKt___CollectionsKt.last(sleepSession.getEntries()));
        return new SleepSession(sleepSession.getSleepTimePeriod(), arrayList, sleepSession.getState());
    }

    public static final long getMaxSleepAmount() {
        return maxSleepAmount;
    }

    public static final long getMinSleepAmount() {
        return minSleepAmount;
    }

    private static final long getTotalFor(SleepSession sleepSession, SleepType... sleepTypeArr) {
        if (sleepSession.getState() != SleepSessionState.Invalid) {
            return getTotalFor(sleepSession.getEntries(), (SleepType[]) Arrays.copyOf(sleepTypeArr, sleepTypeArr.length));
        }
        int r2 = Duration.$r8$clinit;
        return 0L;
    }

    public static final long lightSleepAmount(SleepSession sleepSession) {
        Intrinsics.checkNotNullParameter(sleepSession, "<this>");
        return getTotalFor(sleepSession, SleepType.LIGHT);
    }

    private static final List<SleepEntry> subList(List<SleepEntry> list, SleepEntry sleepEntry, SleepEntry sleepEntry2) {
        int r4;
        boolean z;
        boolean z2;
        Iterator<SleepEntry> it = list.iterator();
        int r2 = 0;
        while (true) {
            r4 = -1;
            if (it.hasNext()) {
                if (it.next().getTimestamp() >= sleepEntry.getTimestamp()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
                r2++;
            } else {
                r2 = -1;
                break;
            }
        }
        ListIterator<SleepEntry> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            if (listIterator.previous().getTimestamp() <= sleepEntry2.getTimestamp()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                r4 = listIterator.nextIndex();
                break;
            }
        }
        IntRange intRange = new IntRange(r2, r4);
        if (intRange.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        return CollectionsKt___CollectionsKt.toList(list.subList(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1));
    }

    private static final <T> long sumOf(Iterable<? extends T> iterable, Function1<? super T, Duration> function1) {
        int r0 = Duration.$r8$clinit;
        Iterator<? extends T> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = Duration.m1686plusLRDsOJo(j, function1.invoke(it.next()).rawValue);
        }
        return j;
    }

    public static final SleepSession toSleepSession(SleepTimePeriod sleepTimePeriod, List<SleepEntry> entries) {
        Intrinsics.checkNotNullParameter(sleepTimePeriod, "<this>");
        Intrinsics.checkNotNullParameter(entries, "entries");
        SleepSession calculateSleepSession = calculateSleepSession(sleepTimePeriod, entries);
        if (calculateSleepSession.getState() != SleepSessionState.Invalid) {
            int r3 = Duration.$r8$clinit;
            return addAwakeStates(m1533filterSleepStatesHG0u8IE(calculateSleepSession, DurationKt.toDuration(5, DurationUnit.MINUTES)));
        }
        return calculateSleepSession;
    }

    public static final long totalSleepAmount(SleepSession sleepSession) {
        Intrinsics.checkNotNullParameter(sleepSession, "<this>");
        return getTotalFor(sleepSession, SleepType.LIGHT, SleepType.DEEP);
    }

    private static final long getTotalFor(List<SleepEntry> list, final SleepType... sleepTypeArr) {
        int r0 = Duration.$r8$clinit;
        Iterator it = CollectionsKt___CollectionsKt.windowed$default(list, 2, 1, new Function1<List<? extends SleepEntry>, Long>() { // from class: com.animaconnected.watch.fitness.sleep.SleepSessionKt$getTotalFor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Long invoke2(List<SleepEntry> list2) {
                Intrinsics.checkNotNullParameter(list2, "<name for destructuring parameter 0>");
                SleepEntry sleepEntry = list2.get(0);
                return Long.valueOf(ArraysKt___ArraysKt.contains(sleepTypeArr, sleepEntry.getState()) ? list2.get(1).getTimestamp() - sleepEntry.getTimestamp() : 0L);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Long invoke(List<? extends SleepEntry> list2) {
                return invoke2((List<SleepEntry>) list2);
            }
        }, 4).iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((Number) it.next()).longValue();
        }
        return DurationKt.toDuration(j, DurationUnit.MILLISECONDS);
    }
}
