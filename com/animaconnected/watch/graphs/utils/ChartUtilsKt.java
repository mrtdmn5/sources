package com.animaconnected.watch.graphs.utils;

import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.theme.ChartPaints;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: ChartUtils.kt */
/* loaded from: classes3.dex */
public final class ChartUtilsKt {
    public static final int calculatePercentage(int r1, int r2) {
        float f = r1;
        if (r2 < 1) {
            r2 = 1;
        }
        return MathKt__MathJVMKt.roundToInt(Math.min(f / r2, 1.0f) * 100);
    }

    public static final float calculateUsableHeight(Chart chart) {
        float height;
        float circleHeight;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        if (Intrinsics.areEqual(chart.getX().getStyle(), XAxisProperties.Style.NoLabels.INSTANCE)) {
            height = chart.getHeight();
            circleHeight = chart.getY().getMaxLabelHeight();
        } else if (!chart.getX().getDrawCircles() && (chart.getX().getStyle() instanceof XAxisProperties.Style.Labels)) {
            height = chart.getHeight() - chart.getX().getLabelHeight();
            circleHeight = chart.getX().getLabelMargin() * 2;
        } else {
            height = (chart.getHeight() - chart.getX().getLabelHeight()) - (chart.getX().getLabelMargin() * 2);
            circleHeight = chart.getX().getCircleHeight();
        }
        return height - circleHeight;
    }

    public static final float calculateUsableWidth(Chart chart, ChartPaints paints) {
        boolean z;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        YAxisProperties.Style style = chart.getY().getStyle();
        boolean z2 = true;
        if (style instanceof YAxisProperties.Style.Average) {
            if (chart.getY().getDataAverageValue() < 1) {
                return chart.getWidth();
            }
            return (chart.getWidth() - Math.max(paints.getAverageHeading().measureWidth(((YAxisProperties.Style.Average) style).getDescriptionText()), paints.getAverageValue().measureWidth(chart.getY().getConvertValueToLabel().invoke(Integer.valueOf(chart.getY().getDataAverageValue()))))) + 3;
        }
        if (style instanceof YAxisProperties.Style.Highlight) {
            z = true;
        } else {
            z = style instanceof YAxisProperties.Style.Normal;
        }
        if (!z) {
            z2 = style instanceof YAxisProperties.Style.DualAxes;
        }
        if (z2) {
            return ((chart.getWidth() - chart.getY().getMaxLabelWidth()) - chart.getY().getLabelMargin()) - chart.getX().getStartPosition().invoke().floatValue();
        }
        if (style == null) {
            return chart.getWidth();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Pair<Float, Float> getLeftRightBound(float f, float f2, float f3, float f4) {
        float f5;
        if (f < f2) {
            f5 = f2 + f4;
        } else if (f > f3 - f2) {
            float f6 = f3 - f4;
            f4 = f6 - f2;
            f5 = f6;
        } else {
            float f7 = f2 / 2;
            f4 = f - f7;
            f5 = f7 + f;
        }
        return new Pair<>(Float.valueOf(f4), Float.valueOf(f5));
    }

    public static final float normalizeValueToXPos(Chart chart, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        if (r2 < r3) {
            r2 = r3;
        }
        float f = r2 - r3;
        int r42 = r4 - r3;
        if (r42 < 1) {
            r42 = 1;
        }
        return chart.getUsableWidth() * (f / r42);
    }

    public static final float normalizeValueToYPos(Chart chart, int r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        float f = r2 - r3;
        int r42 = r4 - r3;
        if (r42 < 1) {
            r42 = 1;
        }
        return (chart.getMainDrawingZone().getHeight() - (chart.getMainDrawingZone().getHeight() * (f / r42))) + chart.getMainDrawingZone().getTop();
    }

    public static /* synthetic */ float normalizeValueToYPos$default(Chart chart, int r1, int r2, int r3, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            r2 = chart.getY().getDataMinValue();
        }
        if ((r4 & 4) != 0) {
            r3 = chart.getY().getDataMaxValue();
        }
        return normalizeValueToYPos(chart, r1, r2, r3);
    }

    public static final float normalizeValueToXPos(Chart chart, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        if (j < j2) {
            j = j2;
        }
        float f = (float) (j - j2);
        long j4 = j3 - j2;
        if (j4 < 1) {
            j4 = 1;
        }
        return chart.getUsableWidth() * (f / ((float) j4));
    }
}
