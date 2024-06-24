package com.animaconnected.watch.graphs.utils;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ChartDrawXAxisUtils.kt */
/* loaded from: classes3.dex */
public final class ChartDrawXAxisUtilsKt {
    public static final void drawDurationTimeline(Chart chart, CanvasPaint paintLabel, CanvasPaint paintCircle) {
        XAxisProperties.Style.DurationTimeline durationTimeline;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paintLabel, "paintLabel");
        Intrinsics.checkNotNullParameter(paintCircle, "paintCircle");
        XAxisProperties.Style style = chart.getX().getStyle();
        if (style instanceof XAxisProperties.Style.DurationTimeline) {
            durationTimeline = (XAxisProperties.Style.DurationTimeline) style;
        } else {
            durationTimeline = null;
        }
        if (durationTimeline == null) {
            return;
        }
        float max = Math.max(chart.getX().getStartPosition().invoke().floatValue(), getCircleRadius(chart.getX()));
        float usableWidth = (chart.getUsableWidth() - paintLabel.measureWidth(durationTimeline.getEndTimeLabel().invoke())) - max;
        float usableHeight = chart.getUsableHeight() + chart.getX().getLabelMargin();
        float labelHeight = chart.getX().getLabelHeight() + usableHeight + chart.getX().getLabelMargin();
        chart.getCanvas().drawLine(max, usableHeight, chart.getUsableWidth() - max, usableHeight, paintLabel);
        chart.getCanvas().drawCircle(max, usableHeight, getCircleRadius(chart.getX()), paintCircle);
        chart.getCanvas().drawCircle(chart.getUsableWidth() - max, usableHeight, getCircleRadius(chart.getX()), paintCircle);
        Kanvas.drawText$default(chart.getCanvas(), durationTimeline.getStartTimeLabel().invoke(), max, labelHeight, 0.0f, null, paintLabel, 24, null);
        Kanvas.drawText$default(chart.getCanvas(), durationTimeline.getEndTimeLabel().invoke(), usableWidth, labelHeight, 0.0f, null, paintLabel, 24, null);
    }

    public static final void drawTimeline(Chart chart, float f, ChartPaints paints) {
        XAxisProperties.Style.Timeline timeline;
        float f2;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        XAxisProperties.Style style = chart.getX().getStyle();
        if (style instanceof XAxisProperties.Style.Timeline) {
            timeline = (XAxisProperties.Style.Timeline) style;
        } else {
            timeline = null;
        }
        if (timeline == null) {
            return;
        }
        float measureWidth = paints.getLabel().measureWidth(timeline.getCurrentTimeLabel());
        float measureWidth2 = paints.getLabel().measureWidth(timeline.getStartTimeLabel());
        float floatValue = chart.getX().getStartPosition().invoke().floatValue();
        float usableWidth = chart.getUsableWidth();
        chart.getCanvas().drawLine(floatValue, getYPosCircle(chart), usableWidth, getYPosCircle(chart), paints.getGridLine());
        float adjustPositionOfText = XAxisUtilsKt.adjustPositionOfText(f, measureWidth, 0.0f, usableWidth);
        if (adjustPositionOfText > measureWidth2 + 4) {
            f2 = usableWidth;
            Kanvas.drawText$default(chart.getCanvas(), timeline.getStartTimeLabel(), floatValue, getYPosText(chart), 0.0f, null, paints.getLabel(), 24, null);
        } else {
            f2 = usableWidth;
        }
        chart.getCanvas().drawCircle(getCircleRadius(chart.getX()) + floatValue, getYPosCircle(chart), getCircleRadius(chart.getX()), paints.getNormalFill());
        chart.getCanvas().drawCircle(f2, getYPosCircle(chart), getCircleRadius(chart.getX()), paints.getNormalFill());
        chart.getCanvas().drawCircle(f, getYPosCircle(chart), getCircleRadius(chart.getX()), paints.getHighlightFill());
        Kanvas.drawText$default(chart.getCanvas(), timeline.getCurrentTimeLabel(), adjustPositionOfText, getYPosText(chart), 0.0f, null, paints.getLabel(), 24, null);
    }

    public static final void drawXAxisLabels(Chart chart, List<? extends ChartEntry> data, ChartPaints paints, int r22, Function1<? super Integer, Float> xPosCenter) {
        CanvasPaint label;
        CanvasPaint normalFill;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(xPosCenter, "xPosCenter");
        int r3 = 0;
        for (Object obj : data) {
            int r7 = r3 + 1;
            if (r3 >= 0) {
                ChartEntry chartEntry = (ChartEntry) obj;
                if (r3 == r22) {
                    label = paints.getImportant();
                } else if (r22 > -1) {
                    label = paints.getLabel();
                } else if (chartEntry.isSelected()) {
                    label = paints.getImportant();
                } else {
                    label = paints.getLabel();
                }
                Kanvas.drawText$default(chart.getCanvas(), chartEntry.getXAxisLabel(), xPosCenter.invoke(Integer.valueOf(r3)).floatValue() - (label.measureWidth(chartEntry.getXAxisLabel()) * 0.5f), getYPosText(chart), 0.0f, null, label, 24, null);
                if (chart.getX().getDrawCircles()) {
                    if (r3 == r22 && chartEntry.isSelected()) {
                        normalFill = paints.getHighlightFill();
                    } else if (r3 == r22) {
                        normalFill = paints.getImportantFill();
                    } else if (r22 > -1 && chartEntry.isSelected()) {
                        normalFill = paints.getHighlightVariantFill();
                    } else if (r22 > -1) {
                        normalFill = paints.getNormalVariantFill();
                    } else if (chartEntry.isSelected()) {
                        normalFill = paints.getHighlightFill();
                    } else {
                        normalFill = paints.getNormalFill();
                    }
                    chart.getCanvas().drawCircle(xPosCenter.invoke(Integer.valueOf(r3)).floatValue(), getYPosCircle(chart), getCircleRadius(chart.getX()), normalFill);
                }
                r3 = r7;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    public static /* synthetic */ void drawXAxisLabels$default(Chart chart, List list, ChartPaints chartPaints, int r3, Function1 function1, int r5, Object obj) {
        if ((r5 & 4) != 0) {
            r3 = -1;
        }
        drawXAxisLabels(chart, list, chartPaints, r3, function1);
    }

    public static final void drawXAxisLabelsStartEndSelected(Chart chart, List<? extends ChartEntry> data, ChartPaints paints, Function1<? super Integer, Float> xPosCenter) {
        boolean z;
        CanvasPaint label;
        float floatValue;
        float floatValue2;
        float circleRadius;
        CanvasPaint normalFill;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(xPosCenter, "xPosCenter");
        int r5 = -1;
        int r7 = 0;
        for (Object obj : data) {
            int r9 = r7 + 1;
            if (r7 >= 0) {
                ChartEntry chartEntry = (ChartEntry) obj;
                boolean z2 = true;
                if (r7 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (r7 != CollectionsKt__CollectionsKt.getLastIndex(data)) {
                    z2 = false;
                }
                if (chartEntry.isSelected()) {
                    r5 = r7;
                }
                if (!z2 || r5 != data.size() - 2) {
                    if (z || z2 || chartEntry.isSelected()) {
                        if (chartEntry.isSelected()) {
                            label = paints.getImportant();
                        } else {
                            label = paints.getLabel();
                        }
                        float measureWidth = label.measureWidth(chartEntry.getXAxisLabel());
                        if (chart.getX().getCenterTextLabels()) {
                            floatValue2 = xPosCenter.invoke(Integer.valueOf(r7)).floatValue();
                            circleRadius = 0.5f * measureWidth;
                        } else if (z) {
                            floatValue2 = xPosCenter.invoke(Integer.valueOf(r7)).floatValue();
                            circleRadius = getCircleRadius(chart.getX());
                        } else {
                            floatValue = (xPosCenter.invoke(Integer.valueOf(r7)).floatValue() - measureWidth) + getCircleRadius(chart.getX());
                            Kanvas.drawText$default(chart.getCanvas(), chartEntry.getXAxisLabel(), ((Number) RangesKt___RangesKt.coerceIn(Float.valueOf(floatValue), new ClosedFloatRange(0.0f, chart.getUsableWidth() - measureWidth))).floatValue(), getYPosText(chart), 0.0f, null, label, 24, null);
                        }
                        floatValue = floatValue2 - circleRadius;
                        Kanvas.drawText$default(chart.getCanvas(), chartEntry.getXAxisLabel(), ((Number) RangesKt___RangesKt.coerceIn(Float.valueOf(floatValue), new ClosedFloatRange(0.0f, chart.getUsableWidth() - measureWidth))).floatValue(), getYPosText(chart), 0.0f, null, label, 24, null);
                    }
                    if (chart.getX().getDrawCircles()) {
                        Kanvas canvas = chart.getCanvas();
                        float floatValue3 = xPosCenter.invoke(Integer.valueOf(r7)).floatValue();
                        float yPosCircle = getYPosCircle(chart);
                        float circleRadius2 = getCircleRadius(chart.getX());
                        if (chartEntry.isSelected()) {
                            normalFill = paints.getHighlightFill();
                        } else {
                            normalFill = paints.getNormalFill();
                        }
                        canvas.drawCircle(floatValue3, yPosCircle, circleRadius2, normalFill);
                    }
                }
                r7 = r9;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    public static final float getCircleRadius(XAxisProperties xAxisProperties) {
        Intrinsics.checkNotNullParameter(xAxisProperties, "<this>");
        return xAxisProperties.getCircleHeight() / 2.0f;
    }

    public static final float getYPosCircle(Chart chart) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        return chart.getUsableHeight() + chart.getX().getLabelMargin();
    }

    private static final float getYPosText(Chart chart) {
        float yPosCircle;
        float labelHeight;
        float labelHeight2 = chart.getX().getLabelHeight() + chart.getUsableHeight() + chart.getX().getLabelMargin();
        if (!(chart.getX().getStyle() instanceof XAxisProperties.Style.DurationTimeline) && !(chart.getX().getStyle() instanceof XAxisProperties.Style.Timeline)) {
            if (chart.getX().getDrawCircles()) {
                yPosCircle = getYPosCircle(chart) + chart.getX().getLabelMargin();
                labelHeight = chart.getX().getLabelHeight();
            } else {
                return labelHeight2;
            }
        } else {
            yPosCircle = getYPosCircle(chart) + chart.getX().getLabelMargin();
            labelHeight = chart.getX().getLabelHeight();
        }
        return labelHeight + yPosCircle;
    }
}
