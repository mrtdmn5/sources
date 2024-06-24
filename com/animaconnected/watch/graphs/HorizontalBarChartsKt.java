package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalBarCharts.kt */
/* loaded from: classes3.dex */
public final class HorizontalBarChartsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final YAxisProperties.Limits calculateMinMaxValue(List<BarEntry> list) {
        Integer valueOf;
        int r1;
        List<BarEntry> list2 = list;
        Iterator<T> it = list2.iterator();
        Integer num = null;
        if (!it.hasNext()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((BarEntry) it.next()).getValue());
            while (it.hasNext()) {
                Integer valueOf2 = Integer.valueOf(((BarEntry) it.next()).getValue());
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
        }
        Integer num2 = valueOf;
        int r0 = 0;
        if (num2 != null) {
            r1 = num2.intValue();
        } else {
            r1 = 0;
        }
        Iterator<T> it2 = list2.iterator();
        if (it2.hasNext()) {
            num = Integer.valueOf(((BarEntry) it2.next()).getValue());
            while (it2.hasNext()) {
                Integer valueOf3 = Integer.valueOf(((BarEntry) it2.next()).getValue());
                if (num.compareTo(valueOf3) < 0) {
                    num = valueOf3;
                }
            }
        }
        Integer num3 = num;
        if (num3 != null) {
            r0 = num3.intValue();
        }
        return new YAxisProperties.Limits(r1, r0);
    }

    public static final HorizontalBarChart createSplitsChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, List<BarEntry> entries, String titleUnitText, String titleSpeedText) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(titleUnitText, "titleUnitText");
        Intrinsics.checkNotNullParameter(titleSpeedText, "titleSpeedText");
        HorizontalBarChart horizontalBarChart = new HorizontalBarChart(kanvas, colors, fonts);
        horizontalBarChart.getY().setStyle(new YAxisProperties.Style.Normal(true, true));
        horizontalBarChart.getY().setCalculateMinMax(new Function1<List<? extends ChartEntry>, YAxisProperties.Limits>() { // from class: com.animaconnected.watch.graphs.HorizontalBarChartsKt$createSplitsChart$1$1
            @Override // kotlin.jvm.functions.Function1
            public final YAxisProperties.Limits invoke(List<? extends ChartEntry> data) {
                YAxisProperties.Limits calculateMinMaxValue;
                Intrinsics.checkNotNullParameter(data, "data");
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (obj instanceof BarEntry) {
                        arrayList.add(obj);
                    }
                }
                calculateMinMaxValue = HorizontalBarChartsKt.calculateMinMaxValue(arrayList);
                return calculateMinMaxValue;
            }
        });
        horizontalBarChart.setShowValuesOnBars(true);
        horizontalBarChart.setBarHeight(30.0f);
        horizontalBarChart.setBarSpacing(8.0f);
        horizontalBarChart.setFirstTitle(titleUnitText);
        horizontalBarChart.setSecondTitle(titleSpeedText);
        horizontalBarChart.setData(entries);
        return horizontalBarChart;
    }
}
