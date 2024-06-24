package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentedProgressBarCharts.kt */
/* loaded from: classes3.dex */
public final class SegmentedProgressBarChartsKt {
    public static final HorizontalProgressBar createHorizontalProgressBarChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, BarChartSize barChartSize, int r5, boolean z, boolean z2, Mitmap mitmap) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(barChartSize, "barChartSize");
        HorizontalProgressBar horizontalProgressBar = new HorizontalProgressBar(kanvas, colors, fonts, barChartSize.getOptions());
        horizontalProgressBar.setGoalValue(r5);
        horizontalProgressBar.setNinePatchBackground(mitmap);
        horizontalProgressBar.setToggleToShowGoalText(z2);
        horizontalProgressBar.setUserInteractionEnabled(z);
        return horizontalProgressBar;
    }

    public static /* synthetic */ HorizontalProgressBar createHorizontalProgressBarChart$default(Kanvas kanvas, ChartColors chartColors, ChartFonts chartFonts, BarChartSize barChartSize, int r13, boolean z, boolean z2, Mitmap mitmap, int r17, Object obj) {
        Mitmap mitmap2;
        if ((r17 & 128) != 0) {
            mitmap2 = null;
        } else {
            mitmap2 = mitmap;
        }
        return createHorizontalProgressBarChart(kanvas, chartColors, chartFonts, barChartSize, r13, z, z2, mitmap2);
    }

    public static final SegmentedProgressBar createSegmentedProgressBarChart(Kanvas kanvas, ChartColors colors, ChartFonts fonts, BarChartSize barChartSize, int r5, boolean z, boolean z2, Mitmap mitmap, boolean z3) {
        Intrinsics.checkNotNullParameter(kanvas, "kanvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(barChartSize, "barChartSize");
        SegmentedProgressBar segmentedProgressBar = new SegmentedProgressBar(kanvas, colors, fonts, barChartSize.getOptions());
        segmentedProgressBar.setGoalValue(r5);
        segmentedProgressBar.setNinePatchBackground(mitmap);
        segmentedProgressBar.setNegativeSpacing(z3);
        segmentedProgressBar.setToggleToShowGoalText(z2);
        segmentedProgressBar.setUserInteractionEnabled(z);
        return segmentedProgressBar;
    }

    public static /* synthetic */ SegmentedProgressBar createSegmentedProgressBarChart$default(Kanvas kanvas, ChartColors chartColors, ChartFonts chartFonts, BarChartSize barChartSize, int r15, boolean z, boolean z2, Mitmap mitmap, boolean z3, int r20, Object obj) {
        Mitmap mitmap2;
        boolean z4;
        if ((r20 & 128) != 0) {
            mitmap2 = null;
        } else {
            mitmap2 = mitmap;
        }
        if ((r20 & 256) != 0) {
            z4 = false;
        } else {
            z4 = z3;
        }
        return createSegmentedProgressBarChart(kanvas, chartColors, chartFonts, barChartSize, r15, z, z2, mitmap2, z4);
    }
}
