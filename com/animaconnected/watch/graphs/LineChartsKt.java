package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PascalDisplay;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.workout.WorkoutPeriod;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineCharts.kt */
/* loaded from: classes3.dex */
public final class LineChartsKt {

    /* compiled from: LineCharts.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[ZoomOutLevel.values().length];
            try {
                r0[ZoomOutLevel.HIGH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ZoomOutLevel.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[WorkoutPeriod.values().length];
            try {
                r02[WorkoutPeriod.WEEK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r02[WorkoutPeriod.YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[WorkoutPeriod.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int average(List<? extends ChartEntry> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof PointEntry) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((PointEntry) it.next()).getLineChartValue());
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (obj2 instanceof Known) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(Integer.valueOf(((Known) it2.next()).getValue()));
        }
        boolean z = true;
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

    public static final LineChart createBasicLineChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> pointEntries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(pointEntries, "pointEntries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        lineChart.setData(pointEntries);
        return lineChart;
    }

    public static final LineChart createElevationChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, final String elevationGain, final FitnessProvider.Profile.Measurement measurement, List<PointEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(elevationGain, "elevationGain");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        Intrinsics.checkNotNullParameter(entries, "entries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getX().setStyle(XAxisProperties.Style.NoLabels.INSTANCE);
        lineChart.getY().setNbrOfGridLines(4);
        lineChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        lineChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationChart$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r2) {
                return WorkoutFormatUtilsKt.formatElevationCentimeter(r2, FitnessProvider.Profile.Measurement.this);
            }
        });
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutElevation$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        lineChart.setTitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationChart$1$4
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return StringsExtensionsKt.getAppString(Key.health_workouts_detail_elevation_title);
            }
        });
        lineChart.setSubtitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationChart$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return elevationGain;
            }
        });
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final LineChart createElevationDetailChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries, final FitnessProvider.Profile.Measurement measurement, final String duration) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        Intrinsics.checkNotNullParameter(duration, "duration");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getX().setStyle(new XAxisProperties.Style.DurationTimeline(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationDetailChart$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "00:00";
            }
        }, new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationDetailChart$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return duration;
            }
        }));
        lineChart.getY().setConvertValueToLabel(new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationDetailChart$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r2) {
                return WorkoutFormatUtilsKt.formatElevationCentimeter(r2, FitnessProvider.Profile.Measurement.this);
            }
        });
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationDetailChart$1$4
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                YAxisProperties.Limits zoomOutElevation;
                Intrinsics.checkNotNullParameter(data, "data");
                zoomOutElevation = LineChartsKt.zoomOutElevation(data, ZoomOutLevel.HIGH);
                return zoomOutElevation;
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createElevationDetailChart$1$5
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final LineChart createHeartRateChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries, final int r11) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        final LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getY().setStyle(new YAxisProperties.Style.Highlight(new Function0<Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateChart$1$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(LineChart.this.getY().getDataAverageValue());
            }
        }, true, false, true, true));
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutHeartRate$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateChart$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(r11);
            }
        });
        lineChart.getY().setNbrOfGridLines(4);
        lineChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        lineChart.getX().setStyle(XAxisProperties.Style.NoLabels.INSTANCE);
        lineChart.setTitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateChart$1$4
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return StringsExtensionsKt.getAppString(Key.health_workouts_detail_heart_rate_title);
            }
        });
        lineChart.setSubtitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateChart$1$5
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return LineChart.this.getY().getDataAverageValue() + ' ' + StringsExtensionsKt.getAppString(Key.units_heartrate_bpm);
            }
        });
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        lineChart.setShowSolidLineOnDashedLine(true);
        return lineChart;
    }

    public static final LineChart createHeartRateDetailChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries, final String duration, final int r14) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(duration, "duration");
        final LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getX().setStyle(new XAxisProperties.Style.DurationTimeline(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateDetailChart$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "00:00";
            }
        }, new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateDetailChart$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return duration;
            }
        }));
        lineChart.getY().setStyle(new YAxisProperties.Style.Highlight(new Function0<Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateDetailChart$1$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(LineChart.this.getY().getDataAverageValue());
            }
        }, false, false, true, true, 6, null));
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateDetailChart$1$4
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                YAxisProperties.Limits zoomOutHeartRate;
                Intrinsics.checkNotNullParameter(data, "data");
                zoomOutHeartRate = LineChartsKt.zoomOutHeartRate(data, ZoomOutLevel.HIGH);
                return zoomOutHeartRate;
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateDetailChart$1$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(r14);
            }
        });
        lineChart.getY().setNbrOfGridLines(5);
        lineChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        lineChart.setShowSolidLineOnDashedLine(true);
        return lineChart;
    }

    public static final LineChart createHeartRateTodayChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries) {
        String str;
        String xAxisLabel;
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.getY().setNbrOfGridLines(4);
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        lineChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateTodayChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutHeartRate$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createHeartRateTodayChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        XAxisProperties x = lineChart.getX();
        PointEntry pointEntry = (PointEntry) CollectionsKt___CollectionsKt.firstOrNull((List) entries);
        String str2 = "00:00";
        if (pointEntry == null || (str = pointEntry.getXAxisLabel()) == null) {
            str = "00:00";
        }
        PointEntry pointEntry2 = (PointEntry) CollectionsKt___CollectionsKt.lastOrNull(entries);
        if (pointEntry2 != null && (xAxisLabel = pointEntry2.getXAxisLabel()) != null) {
            str2 = xAxisLabel;
        }
        x.setStyle(new XAxisProperties.Style.Timeline(str, str2));
        lineChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final LineChart createRestingHeartRateChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.setShowEmptyLine(false);
        lineChart.setTitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateChart$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return StringsExtensionsKt.getAppString(Key.health_detail_heart_rate_resting_last_thirty_days);
            }
        });
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutHeartRate$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        lineChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        lineChart.getX().setDrawCircles(true);
        lineChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final LineChart createRestingHeartRateDetailChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.setShowEmptyLine(false);
        lineChart.setTitleText(new Function0<String>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateDetailChart$1$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return StringsExtensionsKt.getAppString(Key.health_detail_heart_rate_resting_last_thirty_days);
            }
        });
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, false));
        lineChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateDetailChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutHeartRate$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateDetailChart$1$3
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        lineChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        lineChart.getX().setDrawCircles(true);
        lineChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final LineChart createRestingHeartRateHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<PointEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        LineChart lineChart = new LineChart(kanvas, colors, fonts);
        lineChart.setShowEmptyLine(false);
        lineChart.getY().setStyle(new YAxisProperties.Style.Normal(true, false));
        lineChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateHistoryChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                Intrinsics.checkNotNullParameter(data, "data");
                return LineChartsKt.zoomOutHeartRate$default(data, null, 1, null);
            }
        });
        lineChart.getY().setCalculateAverageValue(new Function1<List<? extends ChartEntry>, Integer>() { // from class: com.animaconnected.watch.graphs.LineChartsKt$createRestingHeartRateHistoryChart$1$2
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(List<? extends ChartEntry> data) {
                int average;
                Intrinsics.checkNotNullParameter(data, "data");
                average = LineChartsKt.average(data);
                return Integer.valueOf(average);
            }
        });
        lineChart.getX().setStyle(XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        lineChart.getX().setDrawCircles(true);
        lineChart.setData(entries);
        lineChart.setUserInteractionEnabled(true);
        return lineChart;
    }

    public static final void showHeartRateHistory(Chart chart, WorkoutPeriod period) {
        XAxisProperties.Style style;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        XAxisProperties x = chart.getX();
        int r2 = WhenMappings.$EnumSwitchMapping$1[period.ordinal()];
        if (r2 != 1 && r2 != 2) {
            if (r2 == 3) {
                style = XAxisProperties.Style.LabelsStartEndSelected.INSTANCE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            style = XAxisProperties.Style.Labels.INSTANCE;
        }
        x.setStyle(style);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final YAxisProperties.Limits zoomOut(List<PointEntry> entries, int r9, int r10, int r11, int r12, ZoomOutLevel zoomOutLevel) {
        double d;
        double d2;
        double d3;
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(zoomOutLevel, "zoomOutLevel");
        List<PointEntry> list = entries;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((PointEntry) it.next()).getLineChartValue());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof Known) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Integer.valueOf(((Known) it3.next()).getValue()));
        }
        if (arrayList3.isEmpty()) {
            return new YAxisProperties.Limits(r11, r12);
        }
        Object minOrThrow = CollectionsKt___CollectionsKt.minOrThrow(arrayList3);
        Iterator it4 = arrayList3.iterator();
        if (it4.hasNext()) {
            Comparable comparable = (Comparable) it4.next();
            while (it4.hasNext()) {
                Comparable comparable2 = (Comparable) it4.next();
                if (comparable.compareTo(comparable2) < 0) {
                    comparable = comparable2;
                }
            }
            int intValue = ((Number) minOrThrow).intValue();
            int intValue2 = ((Number) comparable).intValue();
            if (intValue == 0 && intValue2 == 0) {
                return new YAxisProperties.Limits(r11, r12);
            }
            int r112 = intValue2 - intValue;
            if (r112 < 1) {
                r112 = 1;
            }
            float f = r112;
            int[] r1 = WhenMappings.$EnumSwitchMapping$0;
            int r2 = r1[zoomOutLevel.ordinal()];
            if (r2 != 1) {
                if (r2 == 2) {
                    d = -1.25d;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                d = -0.75d;
            }
            int r22 = r1[zoomOutLevel.ordinal()];
            if (r22 != 1) {
                if (r22 == 2) {
                    d2 = 51.25d;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                d2 = 100.0d;
            }
            int r13 = r1[zoomOutLevel.ordinal()];
            if (r13 != 1) {
                if (r13 == 2) {
                    d3 = 10.0d;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                d3 = 20.0d;
            }
            double d4 = (d * f) + d2;
            if (d4 >= d3) {
                d3 = d4;
            }
            Integer valueOf = Integer.valueOf((int) (intValue - d3));
            Integer valueOf2 = Integer.valueOf((int) (intValue2 + d3));
            int intValue3 = valueOf.intValue();
            int intValue4 = valueOf2.intValue();
            if (intValue3 >= r10) {
                r10 = intValue3;
            }
            if (intValue4 <= r9) {
                r9 = intValue4;
            }
            return new YAxisProperties.Limits(r10, r9);
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YAxisProperties.Limits zoomOutElevation(List<? extends ChartEntry> list, ZoomOutLevel zoomOutLevel) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof PointEntry) {
                arrayList.add(obj);
            }
        }
        return zoomOut(arrayList, 900000, -900000, 0, 10, zoomOutLevel);
    }

    public static /* synthetic */ YAxisProperties.Limits zoomOutElevation$default(List list, ZoomOutLevel zoomOutLevel, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            zoomOutLevel = ZoomOutLevel.DEFAULT;
        }
        return zoomOutElevation(list, zoomOutLevel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YAxisProperties.Limits zoomOutHeartRate(List<? extends ChartEntry> list, ZoomOutLevel zoomOutLevel) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof PointEntry) {
                arrayList.add(obj);
            }
        }
        return zoomOut(arrayList, PascalDisplay.marginTop, 25, 60, 90, zoomOutLevel);
    }

    public static /* synthetic */ YAxisProperties.Limits zoomOutHeartRate$default(List list, ZoomOutLevel zoomOutLevel, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            zoomOutLevel = ZoomOutLevel.DEFAULT;
        }
        return zoomOutHeartRate(list, zoomOutLevel);
    }
}
