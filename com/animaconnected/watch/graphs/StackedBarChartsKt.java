package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.fitness.sleep.SleepSessionKt;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.graphs.utils.YAxisScaleFormatter;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: StackedBarCharts.kt */
/* loaded from: classes3.dex */
public final class StackedBarChartsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int averageValue(List<? extends ChartEntry> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof StackedBarEntry) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StackedBarEntry) it.next()).getData());
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (true) {
            int r2 = 0;
            if (!it2.hasNext()) {
                break;
            }
            Iterator it3 = ((List) it2.next()).iterator();
            while (it3.hasNext()) {
                r2 += ((BarEntry) it3.next()).getValue();
            }
            arrayList3.add(Integer.valueOf(r2));
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it4 = arrayList3.iterator();
        while (true) {
            z = true;
            if (!it4.hasNext()) {
                break;
            }
            Object next = it4.next();
            int intValue = ((Number) next).intValue();
            long minSleepAmount = SleepSessionKt.getMinSleepAmount();
            long maxSleepAmount = SleepSessionKt.getMaxSleepAmount();
            int r9 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(Duration.m1676getInWholeHoursimpl(DurationKt.toDuration(intValue, DurationUnit.SECONDS)), DurationUnit.HOURS);
            if (new Duration(duration).compareTo(new Duration(minSleepAmount)) < 0 || new Duration(duration).compareTo(new Duration(maxSleepAmount)) > 0) {
                z = false;
            }
            if (z) {
                arrayList4.add(next);
            }
        }
        if (arrayList4.size() <= 1) {
            z = false;
        }
        if (!z) {
            arrayList4 = null;
        }
        if (arrayList4 == null) {
            return 0;
        }
        return (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList4);
    }

    private static final YAxisProperties.Limits calculateMinMaxValue(List<StackedBarEntry> list, int r6) {
        if (list.isEmpty()) {
            return new YAxisProperties.Limits(0, r6);
        }
        List<StackedBarEntry> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((StackedBarEntry) it.next()).getData());
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            Iterator it3 = ((List) it2.next()).iterator();
            int r2 = 0;
            while (it3.hasNext()) {
                r2 += ((BarEntry) it3.next()).getValue();
            }
            while (it2.hasNext()) {
                Iterator it4 = ((List) it2.next()).iterator();
                int r3 = 0;
                while (it4.hasNext()) {
                    r3 += ((BarEntry) it4.next()).getValue();
                }
                if (r2 < r3) {
                    r2 = r3;
                }
            }
            return new YAxisProperties.Limits(0, Math.max(r2, r6));
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ YAxisProperties.Limits calculateMinMaxValue$default(List list, int r1, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            r1 = 0;
        }
        return calculateMinMaxValue(list, r1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<IntRange> calculateProvidedRangesForSleepHistory(List<StackedBarEntry> list, int r7) {
        Integer num;
        int r6;
        List<StackedBarEntry> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((StackedBarEntry) it.next()).getData());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            num = null;
        } else {
            Iterator it3 = ((List) it2.next()).iterator();
            int r3 = 0;
            while (it3.hasNext()) {
                r3 += ((BarEntry) it3.next()).getValue();
            }
            Integer valueOf = Integer.valueOf(r3);
            while (it2.hasNext()) {
                Iterator it4 = ((List) it2.next()).iterator();
                int r4 = 0;
                while (it4.hasNext()) {
                    r4 += ((BarEntry) it4.next()).getValue();
                }
                Integer valueOf2 = Integer.valueOf(r4);
                if (valueOf.compareTo(valueOf2) < 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num2 != null) {
            r6 = num2.intValue();
        } else {
            r6 = 0;
        }
        int r0 = Duration.$r8$clinit;
        int min = Math.min(Math.max((int) Duration.m1676getInWholeHoursimpl(DurationKt.toDuration(r6, DurationUnit.SECONDS)), r7), (int) Duration.m1676getInWholeHoursimpl(SleepSessionKt.getMaxSleepAmount()));
        int m1679getInWholeSecondsimpl = (int) Duration.m1679getInWholeSecondsimpl(DurationKt.toDuration(1, DurationUnit.HOURS));
        IntRange intRange = new IntRange(0, min);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it5 = intRange.iterator();
        while (it5.hasNext()) {
            int nextInt = ((IntIterator) it5).nextInt() * m1679getInWholeSecondsimpl;
            arrayList2.add(new IntRange(nextInt, nextInt + m1679getInWholeSecondsimpl));
        }
        return arrayList2;
    }

    public static /* synthetic */ List calculateProvidedRangesForSleepHistory$default(List list, int r1, int r2, Object obj) {
        if ((r2 & 2) != 0) {
            r1 = 0;
        }
        return calculateProvidedRangesForSleepHistory(list, r1);
    }

    public static final StackedBarChart createSleepHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        StackedBarChart stackedBarChart = new StackedBarChart(kanvas, colors, fonts);
        stackedBarChart.getY().setStyle(new YAxisProperties.Style.Normal(false, false));
        stackedBarChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        stackedBarChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepHistoryChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r3) {
                int r0 = Duration.$r8$clinit;
                return WorkoutFormatUtilsKt.m1579formatToWholeHoursLRDsOJo(DurationKt.toDuration(r3, DurationUnit.SECONDS));
            }
        });
        stackedBarChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepHistoryChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> list) {
                int averageValue;
                Intrinsics.checkNotNullParameter(list, "list");
                averageValue = StackedBarChartsKt.averageValue(list);
                return Integer.valueOf(averageValue);
            }
        });
        stackedBarChart.getY().getScaleFormatter().setScaleType(YAxisScaleFormatter.ScaleType.CUSTOM_RANGES);
        stackedBarChart.getY().setCalculateProvidedRanges(new Function1<List<? extends ChartEntry>, List<? extends IntRange>>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepHistoryChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final List<IntRange> invoke(List<? extends ChartEntry> data) {
                List<IntRange> calculateProvidedRangesForSleepHistory;
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof StackedBarEntry) {
                        arrayList.add(obj);
                    }
                }
                int r4 = Duration.$r8$clinit;
                calculateProvidedRangesForSleepHistory = StackedBarChartsKt.calculateProvidedRangesForSleepHistory(arrayList, (int) Duration.m1676getInWholeHoursimpl(DurationKt.toDuration(8, DurationUnit.HOURS)));
                return calculateProvidedRangesForSleepHistory;
            }
        });
        stackedBarChart.setConvertValueToMarkerTitle(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepHistoryChart$1$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r3) {
                int r0 = Duration.$r8$clinit;
                return WorkoutFormatUtilsKt.formatDurationHourMinutes(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(r3, DurationUnit.SECONDS)));
            }
        });
        stackedBarChart.setUserInteractionEnabled(true);
        return stackedBarChart;
    }

    public static final StackedBarChart createSleepLastSevenDaysChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<StackedBarEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        final StackedBarChart stackedBarChart = new StackedBarChart(kanvas, colors, fonts);
        stackedBarChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        stackedBarChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepLastSevenDaysChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> list) {
                int averageValue;
                Intrinsics.checkNotNullParameter(list, "list");
                averageValue = StackedBarChartsKt.averageValue(list);
                return Integer.valueOf(averageValue);
            }
        });
        stackedBarChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepLastSevenDaysChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof StackedBarEntry) {
                        arrayList.add(obj);
                    }
                }
                return StackedBarChartsKt.calculateMinMaxValue$default(arrayList, 0, 2, null);
            }
        });
        stackedBarChart.getY().setStyle(new YAxisProperties.Style.Average(StringsExtensionsKt.getAppString(Key.general_average), false, false, 6, null));
        stackedBarChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepLastSevenDaysChart$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r3) {
                int r32 = Duration.$r8$clinit;
                return WorkoutFormatUtilsKt.formatDurationHourMinutes(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(StackedBarChart.this.getY().getDataAverageValue(), DurationUnit.SECONDS)));
            }
        });
        stackedBarChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        stackedBarChart.setCornerRadius(8.0f);
        stackedBarChart.setMaxBarWidth(24.0f);
        stackedBarChart.setMinSpacingBetweenBars(10.0f);
        stackedBarChart.setData(entries);
        stackedBarChart.setConvertValueToMarkerTitle(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.StackedBarChartsKt$createSleepLastSevenDaysChart$1$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r3) {
                int r0 = Duration.$r8$clinit;
                return WorkoutFormatUtilsKt.formatDurationHourMinutes(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(r3, DurationUnit.SECONDS)));
            }
        });
        stackedBarChart.setUserInteractionEnabled(true);
        return stackedBarChart;
    }

    public static final void showSleepPeriodMonth(StackedBarChart stackedBarChart) {
        Intrinsics.checkNotNullParameter(stackedBarChart, "<this>");
        stackedBarChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        stackedBarChart.setCornerRadius(4.0f);
        stackedBarChart.setMaxBarWidth(4.0f);
        stackedBarChart.setMinSpacingBetweenBars(6.0f);
    }

    public static final void showSleepPeriodWeek(StackedBarChart stackedBarChart) {
        Intrinsics.checkNotNullParameter(stackedBarChart, "<this>");
        stackedBarChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        stackedBarChart.setCornerRadius(8.0f);
        stackedBarChart.setMaxBarWidth(30.0f);
        stackedBarChart.setMinSpacingBetweenBars(18.0f);
    }

    public static final void showSleepPeriodYear(StackedBarChart stackedBarChart) {
        Intrinsics.checkNotNullParameter(stackedBarChart, "<this>");
        stackedBarChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        stackedBarChart.setCornerRadius(8.0f);
        stackedBarChart.setMaxBarWidth(24.0f);
        stackedBarChart.setMinSpacingBetweenBars(12.0f);
    }
}
