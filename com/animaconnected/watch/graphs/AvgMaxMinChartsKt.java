package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvgMaxMinCharts.kt */
/* loaded from: classes3.dex */
public final class AvgMaxMinChartsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final YAxisProperties.Limits calculateMinMaxValue(List<AvgMaxMinEntry> list, int r5, int r6) {
        Integer num;
        int r0;
        boolean z;
        if (list.isEmpty()) {
            return new YAxisProperties.Limits(r5, r6);
        }
        List<AvgMaxMinEntry> list2 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (((AvgMaxMinEntry) obj).getMinValue() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            num = null;
        } else {
            Integer valueOf = Integer.valueOf(((AvgMaxMinEntry) it.next()).getMinValue());
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((AvgMaxMinEntry) it.next()).getMinValue());
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            num = valueOf;
        }
        Integer num2 = num;
        if (num2 != null) {
            r0 = num2.intValue();
        } else {
            r0 = r5;
        }
        Iterator<T> it2 = list2.iterator();
        if (it2.hasNext()) {
            int maxValue = ((AvgMaxMinEntry) it2.next()).getMaxValue();
            while (it2.hasNext()) {
                int maxValue2 = ((AvgMaxMinEntry) it2.next()).getMaxValue();
                if (maxValue < maxValue2) {
                    maxValue = maxValue2;
                }
            }
            return new YAxisProperties.Limits(Math.min(r0, r5), Math.max(maxValue, r6));
        }
        throw new NoSuchElementException();
    }

    public static final AverageMaxMinChart createHeartRateHistoryChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<AvgMaxMinEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        AverageMaxMinChart averageMaxMinChart = new AverageMaxMinChart(kanvas, colors, fonts);
        averageMaxMinChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        averageMaxMinChart.getY().setNbrOfGridLines(10);
        averageMaxMinChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.AvgMaxMinChartsKt$createHeartRateHistoryChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                YAxisProperties.Limits calculateMinMaxValue;
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof AvgMaxMinEntry) {
                        arrayList.add(obj);
                    }
                }
                calculateMinMaxValue = AvgMaxMinChartsKt.calculateMinMaxValue(arrayList, 0, 200);
                return calculateMinMaxValue;
            }
        });
        averageMaxMinChart.getY().setLabelMargin(16);
        averageMaxMinChart.getX().setDrawCircles(true);
        averageMaxMinChart.getX().setLabelMargin(16);
        averageMaxMinChart.setUserInteractionEnabled(true);
        averageMaxMinChart.setData(entries);
        return averageMaxMinChart;
    }

    public static final AverageMaxMinChart createHeartRateLastSevenDaysChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<AvgMaxMinEntry> entries) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        AverageMaxMinChart averageMaxMinChart = new AverageMaxMinChart(kanvas, colors, fonts);
        averageMaxMinChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        averageMaxMinChart.getY().setLineToLabelRatio(YAxisProperties.LineToLabelRatio.One);
        averageMaxMinChart.getY().setNbrOfGridLines(4);
        averageMaxMinChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.AvgMaxMinChartsKt$createHeartRateLastSevenDaysChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                YAxisProperties.Limits calculateMinMaxValue;
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof AvgMaxMinEntry) {
                        arrayList.add(obj);
                    }
                }
                calculateMinMaxValue = AvgMaxMinChartsKt.calculateMinMaxValue(arrayList, 60, 90);
                return calculateMinMaxValue;
            }
        });
        averageMaxMinChart.getY().setLabelMargin(16);
        averageMaxMinChart.getX().setLabelMargin(16);
        averageMaxMinChart.setNoDataText(StringsExtensionsKt.getAppString(Key.general_no_data_available));
        averageMaxMinChart.setUserInteractionEnabled(true);
        averageMaxMinChart.setData(entries);
        return averageMaxMinChart;
    }
}
