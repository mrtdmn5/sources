package com.animaconnected.watch.graphs;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.secondo.R;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.device.StringsBackendKt;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BarCharts.kt */
/* loaded from: classes3.dex */
public final class BarChartsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int averageValue(List<? extends ChartEntry> list) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof BarEntry) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(((BarEntry) it.next()).getValue()));
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        while (true) {
            boolean z2 = false;
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Number) next).intValue() > 0) {
                z2 = true;
            }
            if (z2) {
                arrayList3.add(next);
            }
        }
        if (arrayList3.size() <= 1) {
            z = false;
        }
        if (!z) {
            arrayList3 = null;
        }
        if (arrayList3 == null) {
            return 0;
        }
        return (int) CollectionsKt___CollectionsKt.averageOfInt(arrayList3);
    }

    private static final YAxisProperties.Limits calculateMinMaxValue(List<BarEntry> list, int r4, int r5) {
        if (list.isEmpty()) {
            return new YAxisProperties.Limits(r4, r5);
        }
        List<BarEntry> list2 = list;
        Iterator<T> it = list2.iterator();
        if (it.hasNext()) {
            int value = ((BarEntry) it.next()).getValue();
            while (it.hasNext()) {
                int value2 = ((BarEntry) it.next()).getValue();
                if (value > value2) {
                    value = value2;
                }
            }
            Iterator<T> it2 = list2.iterator();
            if (it2.hasNext()) {
                int value3 = ((BarEntry) it2.next()).getValue();
                while (it2.hasNext()) {
                    int value4 = ((BarEntry) it2.next()).getValue();
                    if (value3 < value4) {
                        value3 = value4;
                    }
                }
                return new YAxisProperties.Limits(Math.min(value, r4), Math.max(value3, r5));
            }
            throw new NoSuchElementException();
        }
        throw new NoSuchElementException();
    }

    public static /* synthetic */ YAxisProperties.Limits calculateMinMaxValue$default(List list, int r2, int r3, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            r2 = 0;
        }
        if ((r4 & 4) != 0) {
            r3 = 0;
        }
        return calculateMinMaxValue(list, r2, r3);
    }

    public static final BarChart createCaloriesHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getY().setNbrOfGridLines(10);
        barChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesHistoryChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return WorkoutFormatUtilsKt.formatToKilo(r1);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesHistoryChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, 2000, 2, null);
            }
        });
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesHistoryChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.getY().setStyle(new YAxisProperties.Style.Normal(false, false));
        barChart.setMinSpacingBetweenBars(18.0f);
        barChart.setCornerRadius(8.0f);
        barChart.setData(entries);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    public static final BarChart createCaloriesLastSevenDaysChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesLastSevenDaysChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesLastSevenDaysChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, 0, 6, null);
            }
        });
        barChart.getY().setStyle(new YAxisProperties.Style.Average(StringsExtensionsKt.getAppString(Key.general_average), false, false, 6, null));
        barChart.setCornerRadius(8.0f);
        barChart.setMaxBarWidth(30.0f);
        barChart.setMinSpacingBetweenBars(10.0f);
        barChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        barChart.setData(entries);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    public static final BarChart createCaloriesTodayChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getX().setStyle(getTimeline(StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null)));
        barChart.getY().setNbrOfGridLines(4);
        barChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesTodayChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.getY().setStyle(new YAxisProperties.Style.Normal(true, false));
        barChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesTodayChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return WorkoutFormatUtilsKt.formatToKilo(r1);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createCaloriesTodayChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 2, null);
            }
        });
        barChart.setCornerRadius(4.0f);
        barChart.setDrawDotForEmptyBar(false);
        barChart.setMaxBarWidth(4.0f);
        barChart.setMinSpacingBetweenBars(2.0f);
        barChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        barChart.setData(entries);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    public static final BarChart createStepsHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries, final int r13) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getY().setNbrOfGridLines(10);
        barChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsHistoryChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return WorkoutFormatUtilsKt.formatToKilo(r1);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsHistoryChart$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, r13, 2, null);
            }
        });
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsHistoryChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.getY().setStyle(new YAxisProperties.Style.Highlight(new Function0<Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsHistoryChart$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(r13);
            }
        }, false, false, false, false, 6, null));
        barChart.setCornerRadius(8.0f);
        barChart.setData(entries);
        barChart.setMinSpacingBetweenBars(18.0f);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    public static final BarChart createStepsLastSevenDaysChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries, final int r11) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsLastSevenDaysChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsLastSevenDaysChart$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, r11, 2, null);
            }
        });
        barChart.getY().setStyle(new YAxisProperties.Style.Average(StringsExtensionsKt.getAppString(Key.general_average), false, false, 6, null));
        barChart.setMaxBarWidth(30.0f);
        barChart.setMinSpacingBetweenBars(10.0f);
        barChart.setCornerRadius(8.0f);
        barChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        barChart.setData(entries);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    public static final BarChart createStepsTodayChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        BarChart barChart = new BarChart(kanvas, colors, fonts);
        barChart.getX().setStyle(getTimeline(StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null)));
        barChart.getY().setStyle(new YAxisProperties.Style.Normal(true, false));
        barChart.getY().setNbrOfGridLines(3);
        barChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        barChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsTodayChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return WorkoutFormatUtilsKt.formatToKilo(r1);
            }
        });
        barChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsTodayChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                return BarChartsKt.calculateMinMaxValue$default(arrayList, 0, 500, 2, null);
            }
        });
        barChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.BarChartsKt$createStepsTodayChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int averageValue;
                Intrinsics.checkNotNullParameter(data, "data");
                averageValue = BarChartsKt.averageValue(data);
                return Integer.valueOf(averageValue);
            }
        });
        barChart.setCornerRadius(4.0f);
        barChart.setDrawDotForEmptyBar(false);
        barChart.setMaxBarWidth(4.0f);
        barChart.setMinSpacingBetweenBars(2.0f);
        barChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        barChart.setData(entries);
        barChart.setUserInteractionEnabled(true);
        return barChart;
    }

    private static final XAxisProperties.Style.Timeline getTimeline(DateFormatter dateFormatter) {
        return new XAxisProperties.Style.Timeline(StringsBackendKt.format$default(dateFormatter, DateTimeUtilsKt.atStartOfDay$default(DateTimeUtilsKt.getLocalDateTime$default(null, null, 3, null), null, 1, null), null, false, 6, null), StringsBackendKt.format$default(dateFormatter, DateTimeUtilsKt.now(), null, false, 6, null));
    }

    public static final void showCaloriesPeriodMonth(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        barChart.setMaxBarWidth(4.0f);
        barChart.setMinSpacingBetweenBars(6.0f);
        barChart.setCornerRadius(4.0f);
    }

    public static final void showCaloriesPeriodWeek(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        barChart.setMaxBarWidth(30.0f);
        barChart.setMinSpacingBetweenBars(18.0f);
        barChart.setCornerRadius(8.0f);
    }

    public static final void showCaloriesPeriodYear(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        barChart.setMaxBarWidth(24.0f);
        barChart.setMinSpacingBetweenBars(12.0f);
        barChart.setCornerRadius(8.0f);
    }

    public static final void showStepsPeriodMonth(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        barChart.setMaxBarWidth(4.0f);
        barChart.setMinSpacingBetweenBars(6.0f);
        barChart.setCornerRadius(4.0f);
    }

    public static final void showStepsPeriodWeek(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        barChart.setMaxBarWidth(30.0f);
        barChart.setMinSpacingBetweenBars(18.0f);
        barChart.setCornerRadius(8.0f);
    }

    public static final void showStepsPeriodYear(BarChart barChart) {
        Intrinsics.checkNotNullParameter(barChart, "<this>");
        barChart.getX().setStyle(XAxisProperties.Style.Labels.INSTANCE);
        barChart.setMaxBarWidth(24.0f);
        barChart.setMinSpacingBetweenBars(12.0f);
        barChart.setCornerRadius(8.0f);
    }
}
