package com.animaconnected.watch.workout.utils;

import com.animaconnected.watch.fitness.HeartrateEntry;
import com.animaconnected.watch.fitness.PowerEntry;
import com.animaconnected.watch.fitness.PowerState;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.graphs.Known;
import com.animaconnected.watch.graphs.LineChartValue;
import com.animaconnected.watch.graphs.None;
import com.animaconnected.watch.graphs.Unknown;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;

/* compiled from: HeartrateCompressor.kt */
/* loaded from: classes3.dex */
public final class HeartrateCompressorKt {
    /* renamed from: compressForTodayGraph-J7AnP2E, reason: not valid java name */
    public static final CompressResult m1572compressForTodayGraphJ7AnP2E(List<HeartrateEntry> heartrateData, List<PowerEntry> powerData, TimePeriod timePeriod, long j, long j2) {
        int r12;
        LineChartValue lineChartValue;
        LineChartValue lineChartValue2;
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(heartrateData, "heartrateData");
        Intrinsics.checkNotNullParameter(powerData, "powerData");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        long m1505getDurationUwyO8pc = timePeriod.m1505getDurationUwyO8pc();
        int r4 = Duration.$r8$clinit;
        if (!Duration.m1675equalsimpl0(m1505getDurationUwyO8pc, 0L) && !Duration.m1675equalsimpl0(j, 0L) && !heartrateData.isEmpty()) {
            int roundToInt = MathKt__MathJVMKt.roundToInt(Duration.m1673divLRDsOJo(j2, j));
            int m1677getInWholeMillisecondsimpl = (int) (((float) Duration.m1677getInWholeMillisecondsimpl(timePeriod.m1505getDurationUwyO8pc())) / ((float) Duration.m1677getInWholeMillisecondsimpl(j)));
            long m1677getInWholeMillisecondsimpl2 = Duration.m1677getInWholeMillisecondsimpl(j);
            List<HeartrateEntry> list = heartrateData;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                int confidence = ((HeartrateEntry) obj).getConfidence();
                if (confidence >= 0 && confidence < 101) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj2 : arrayList) {
                Integer valueOf = Integer.valueOf((int) (((float) (((HeartrateEntry) obj2).getTimestamp() - timePeriod.getStartTs())) / ((float) m1677getInWholeMillisecondsimpl2)));
                Object obj3 = linkedHashMap.get(valueOf);
                if (obj3 == null) {
                    obj3 = new ArrayList();
                    linkedHashMap.put(valueOf, obj3);
                }
                ((List) obj3).add(obj2);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                r12 = 10;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(((HeartrateEntry) it2.next()).getHeartrate()));
                }
                linkedHashMap2.put(key, Integer.valueOf((int) CollectionsKt___CollectionsKt.averageOfInt(arrayList2)));
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj4 : list) {
                int confidence2 = ((HeartrateEntry) obj4).getConfidence();
                if (140 <= confidence2 && confidence2 < 201) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList3.add(obj4);
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Object obj5 : arrayList3) {
                Integer valueOf2 = Integer.valueOf((int) (((float) (((HeartrateEntry) obj5).getTimestamp() - timePeriod.getStartTs())) / ((float) m1677getInWholeMillisecondsimpl2)));
                Object obj6 = linkedHashMap3.get(valueOf2);
                if (obj6 == null) {
                    obj6 = new ArrayList();
                    linkedHashMap3.put(valueOf2, obj6);
                }
                ((List) obj6).add(obj5);
            }
            LinkedHashMap linkedHashMap4 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap3.size()));
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                Object key2 = entry2.getKey();
                Iterable iterable2 = (Iterable) entry2.getValue();
                ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(iterable2, r12));
                Iterator it3 = iterable2.iterator();
                while (it3.hasNext()) {
                    arrayList4.add(Integer.valueOf(((HeartrateEntry) it3.next()).getHeartrate()));
                }
                linkedHashMap4.put(key2, Integer.valueOf((int) CollectionsKt___CollectionsKt.averageOfInt(arrayList4)));
                r12 = 10;
            }
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Object obj7 : powerData) {
                Integer valueOf3 = Integer.valueOf((int) (((float) (((PowerEntry) obj7).getTimestamp() - timePeriod.getStartTs())) / ((float) m1677getInWholeMillisecondsimpl2)));
                Object obj8 = linkedHashMap5.get(valueOf3);
                if (obj8 == null) {
                    obj8 = new ArrayList();
                    linkedHashMap5.put(valueOf3, obj8);
                }
                ((List) obj8).add(obj7);
            }
            LinkedHashMap linkedHashMap6 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap5.size()));
            for (Map.Entry entry3 : linkedHashMap5.entrySet()) {
                Object key3 = entry3.getKey();
                if (((PowerEntry) CollectionsKt___CollectionsKt.last((List) entry3.getValue())).getState() == PowerState.Normal) {
                    z = true;
                } else {
                    z = false;
                }
                linkedHashMap6.put(key3, Boolean.valueOf(z));
            }
            IntRange intRange = new IntRange(0, m1677getInWholeMillisecondsimpl);
            ArrayList arrayList5 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it4 = intRange.iterator();
            int r122 = 0;
            boolean z4 = true;
            while (it4.hasNext()) {
                int nextInt = ((IntIterator) it4).nextInt();
                Integer num = (Integer) linkedHashMap2.get(Integer.valueOf(nextInt));
                Integer num2 = (Integer) linkedHashMap4.get(Integer.valueOf(nextInt));
                Boolean bool = (Boolean) linkedHashMap6.get(Integer.valueOf(nextInt));
                if (bool != null) {
                    z4 = bool.booleanValue();
                }
                if (num != null) {
                    lineChartValue2 = new Known(num.intValue(), false);
                } else if (num2 != null) {
                    lineChartValue2 = new Known(num2.intValue(), true);
                } else {
                    r122++;
                    if (r122 < roundToInt && z4) {
                        lineChartValue2 = Unknown.INSTANCE;
                    } else {
                        lineChartValue2 = None.INSTANCE;
                    }
                    arrayList5.add(new DataPoint((nextInt * m1677getInWholeMillisecondsimpl2) + timePeriod.getStartTs(), lineChartValue2));
                    roundToInt = roundToInt;
                }
                r122 = 0;
                arrayList5.add(new DataPoint((nextInt * m1677getInWholeMillisecondsimpl2) + timePeriod.getStartTs(), lineChartValue2));
                roundToInt = roundToInt;
            }
            Collection values = linkedHashMap2.values();
            int sumOfInt = CollectionsKt___CollectionsKt.sumOfInt(values);
            if ((!values.isEmpty()) && sumOfInt > 0) {
                lineChartValue = new Known(sumOfInt / values.size(), false, 2, (DefaultConstructorMarker) null);
            } else {
                lineChartValue = None.INSTANCE;
            }
            ArrayList arrayList6 = new ArrayList();
            Iterator<T> it5 = list.iterator();
            while (it5.hasNext()) {
                Integer heartrateLow = ((HeartrateEntry) it5.next()).getHeartrateLow();
                if (heartrateLow != null) {
                    arrayList6.add(heartrateLow);
                }
            }
            Integer num3 = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) arrayList6);
            if (num3 == null) {
                num3 = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) values);
            }
            ArrayList arrayList7 = new ArrayList();
            Iterator<T> it6 = list.iterator();
            while (it6.hasNext()) {
                Integer heartrateHigh = ((HeartrateEntry) it6.next()).getHeartrateHigh();
                if (heartrateHigh != null) {
                    arrayList7.add(heartrateHigh);
                }
            }
            Integer num4 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList7);
            if (num4 == null) {
                num4 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) values);
            }
            return new CompressResult(num3, lineChartValue, num4, arrayList5);
        }
        return emptyCompressResult();
    }

    public static final CompressResult compressForWorkoutGraph(List<HeartrateEntry> list, TimePeriod timePeriod, int r15) {
        LineChartValue lineChartValue;
        LineChartValue lineChartValue2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(timePeriod, "timePeriod");
        if (r15 != 0 && !list.isEmpty()) {
            if (list.size() <= r15) {
                List<HeartrateEntry> list2 = list;
                Iterator<T> it = list2.iterator();
                if (it.hasNext()) {
                    Integer valueOf = Integer.valueOf(((HeartrateEntry) it.next()).getHeartrate());
                    while (it.hasNext()) {
                        Integer valueOf2 = Integer.valueOf(((HeartrateEntry) it.next()).getHeartrate());
                        if (valueOf.compareTo(valueOf2) > 0) {
                            valueOf = valueOf2;
                        }
                    }
                    Integer num = valueOf;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(Integer.valueOf(((HeartrateEntry) it2.next()).getHeartrate()));
                    }
                    Known known = new Known((int) CollectionsKt___CollectionsKt.averageOfInt(arrayList), false, 2, (DefaultConstructorMarker) null);
                    Iterator<T> it3 = list2.iterator();
                    if (it3.hasNext()) {
                        Integer valueOf3 = Integer.valueOf(((HeartrateEntry) it3.next()).getHeartrate());
                        while (it3.hasNext()) {
                            Integer valueOf4 = Integer.valueOf(((HeartrateEntry) it3.next()).getHeartrate());
                            if (valueOf3.compareTo(valueOf4) < 0) {
                                valueOf3 = valueOf4;
                            }
                        }
                        Integer num2 = valueOf3;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
                        for (HeartrateEntry heartrateEntry : list2) {
                            arrayList2.add(new DataPoint(heartrateEntry.getTimestamp(), new Known(heartrateEntry.getHeartrate(), false, 2, (DefaultConstructorMarker) null)));
                        }
                        return new CompressResult(num, known, num2, arrayList2);
                    }
                    throw new NoSuchElementException();
                }
                throw new NoSuchElementException();
            }
            long durationMs = timePeriod.getDurationMs() / r15;
            List<HeartrateEntry> list3 = list;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list3) {
                Integer valueOf5 = Integer.valueOf((int) (((float) (((HeartrateEntry) obj).getTimestamp() - timePeriod.getStartTs())) / ((float) durationMs)));
                Object obj2 = linkedHashMap.get(valueOf5);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(valueOf5, obj2);
                }
                ((List) obj2).add(obj);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(linkedHashMap.size()));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                Object key = entry.getKey();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(iterable, 10));
                Iterator it4 = iterable.iterator();
                while (it4.hasNext()) {
                    arrayList3.add(Integer.valueOf(((HeartrateEntry) it4.next()).getHeartrate()));
                }
                linkedHashMap2.put(key, Integer.valueOf((int) CollectionsKt___CollectionsKt.averageOfInt(arrayList3)));
            }
            IntRange intRange = new IntRange(0, r15);
            ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
            Iterator<Integer> it5 = intRange.iterator();
            while (it5.hasNext()) {
                int nextInt = ((IntIterator) it5).nextInt();
                long startTs = (nextInt * durationMs) + timePeriod.getStartTs();
                Integer num3 = (Integer) linkedHashMap2.get(Integer.valueOf(nextInt));
                if (num3 != null) {
                    lineChartValue2 = new Known(num3.intValue(), false, 2, (DefaultConstructorMarker) null);
                } else {
                    lineChartValue2 = Unknown.INSTANCE;
                }
                arrayList4.add(new DataPoint(startTs, lineChartValue2));
            }
            Collection values = linkedHashMap2.values();
            int sumOfInt = CollectionsKt___CollectionsKt.sumOfInt(values);
            if ((!values.isEmpty()) && sumOfInt > 0) {
                lineChartValue = new Known(sumOfInt / values.size(), false, 2, (DefaultConstructorMarker) null);
            } else {
                lineChartValue = None.INSTANCE;
            }
            ArrayList arrayList5 = new ArrayList();
            Iterator<T> it6 = list3.iterator();
            while (it6.hasNext()) {
                Integer heartrateLow = ((HeartrateEntry) it6.next()).getHeartrateLow();
                if (heartrateLow != null) {
                    arrayList5.add(heartrateLow);
                }
            }
            Integer num4 = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) arrayList5);
            if (num4 == null) {
                num4 = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) values);
            }
            ArrayList arrayList6 = new ArrayList();
            Iterator<T> it7 = list3.iterator();
            while (it7.hasNext()) {
                Integer heartrateHigh = ((HeartrateEntry) it7.next()).getHeartrateHigh();
                if (heartrateHigh != null) {
                    arrayList6.add(heartrateHigh);
                }
            }
            Integer num5 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList6);
            if (num5 == null) {
                num5 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) values);
            }
            return new CompressResult(num4, lineChartValue, num5, arrayList4);
        }
        return emptyCompressResult();
    }

    private static final CompressResult emptyCompressResult() {
        return new CompressResult(null, None.INSTANCE, null, EmptyList.INSTANCE);
    }

    public static final List<DataPoint> trim(List<DataPoint> list) {
        int r0;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<DataPoint> it = list.iterator();
        int r1 = 0;
        while (true) {
            if (it.hasNext()) {
                if (it.next().getAvgValue() instanceof Known) {
                    break;
                }
                r1++;
            } else {
                r1 = -1;
                break;
            }
        }
        ListIterator<DataPoint> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (listIterator.previous().getAvgValue() instanceof Known) {
                    r0 = listIterator.nextIndex();
                    break;
                }
            } else {
                r0 = -1;
                break;
            }
        }
        if (r1 != -1 && r0 != -1) {
            return list.subList(r1, r0 + 1);
        }
        return EmptyList.INSTANCE;
    }
}
