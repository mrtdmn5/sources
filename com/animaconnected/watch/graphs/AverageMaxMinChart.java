package com.animaconnected.watch.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.XAxisProperties;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartDrawXAxisUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.graphs.utils.XAxisUtilsKt;
import com.animaconnected.watch.graphs.utils.YAxisScaleFormatter;
import com.animaconnected.watch.graphs.utils.YAxisUtilsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AverageMaxMinChart.kt */
/* loaded from: classes3.dex */
public final class AverageMaxMinChart extends Chart {
    private final Kanvas canvas;
    private final float circleRadiusAvg;
    private final float circleRadiusMax;
    private final float circleRadiusMin;
    private final ChartColors colors;
    private final ChartFonts fonts;
    private float lineSpacing;
    private MarkerView markerView;
    private final ChartPaints paints;

    public AverageMaxMinChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.circleRadiusMax = 2.0f;
        this.circleRadiusAvg = 4.0f;
        this.circleRadiusMin = 2.0f;
        this.paints = new ChartPaints(fonts, colors, getCanvas());
        this.markerView = new MaxAvgMinMarkerView(fonts, colors, getCanvas());
    }

    private final void drawAvgMaxMinData() {
        boolean z;
        CanvasPaint normalFill;
        int touchIndex = getTouchIndex();
        if (touchIndex > -1) {
            z = true;
        } else {
            z = false;
        }
        int r10 = 0;
        for (Object obj : getAvgMaxMinData()) {
            int r11 = r10 + 1;
            if (r10 >= 0) {
                AvgMaxMinEntry avgMaxMinEntry = (AvgMaxMinEntry) obj;
                if (avgMaxMinEntry.getAvgValue() > 0) {
                    float xPosCenter = getXPosCenter(r10);
                    float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, avgMaxMinEntry.getMinValue(), 0, 0, 6, null);
                    float normalizeValueToYPos$default2 = ChartUtilsKt.normalizeValueToYPos$default(this, avgMaxMinEntry.getAvgValue(), 0, 0, 6, null);
                    float normalizeValueToYPos$default3 = ChartUtilsKt.normalizeValueToYPos$default(this, avgMaxMinEntry.getMaxValue(), 0, 0, 6, null);
                    if (z) {
                        if (r10 == touchIndex && avgMaxMinEntry.isSelected()) {
                            normalFill = this.paints.getHighlightFill();
                        } else if (r10 == touchIndex) {
                            normalFill = this.paints.getNormalFill();
                        } else if (avgMaxMinEntry.isSelected()) {
                            normalFill = this.paints.getHighlightVariantFill();
                        } else {
                            normalFill = this.paints.getNormalVariantFill();
                        }
                    } else if (avgMaxMinEntry.isSelected()) {
                        normalFill = this.paints.getHighlightFill();
                    } else {
                        normalFill = this.paints.getNormalFill();
                    }
                    ChartDrawUtilsKt.drawVerticalDashedLine(getCanvas(), xPosCenter, normalizeValueToYPos$default, normalizeValueToYPos$default3, normalFill, 1.0f, 1.0f);
                    if (r10 == touchIndex) {
                        CanvasPaint importantFill = this.paints.getImportantFill();
                        CanvasPaint canvasPaint = normalFill;
                        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), xPosCenter, normalizeValueToYPos$default, this.circleRadiusMin, canvasPaint, importantFill);
                        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), xPosCenter, normalizeValueToYPos$default2, this.circleRadiusAvg, canvasPaint, importantFill);
                        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), xPosCenter, normalizeValueToYPos$default3, this.circleRadiusMax, canvasPaint, importantFill);
                    } else {
                        getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default, this.circleRadiusMin, normalFill);
                        getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default2, this.circleRadiusAvg, normalFill);
                        getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default3, this.circleRadiusMax, normalFill);
                    }
                }
                r10 = r11;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    private final void drawXAxis() {
        XAxisProperties.Style style = getX().getStyle();
        if (Intrinsics.areEqual(style, XAxisProperties.Style.Labels.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabels(this, getAvgMaxMinData(), this.paints, getTouchIndex(), new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.AverageMaxMinChart$drawXAxis$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenter;
                    xPosCenter = AverageMaxMinChart.this.getXPosCenter(r2);
                    return Float.valueOf(xPosCenter);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabelsStartEndSelected(this, getAvgMaxMinData(), this.paints, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.AverageMaxMinChart$drawXAxis$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenter;
                    xPosCenter = AverageMaxMinChart.this.getXPosCenter(r2);
                    return Float.valueOf(xPosCenter);
                }
            });
            return;
        }
        if (style instanceof XAxisProperties.Style.Timeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.AverageMaxMinChart$drawXAxis$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Style.TodayTimeline not supported.";
                }
            }, 7, (Object) null);
        } else if (style instanceof XAxisProperties.Style.DurationTimeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.AverageMaxMinChart$drawXAxis$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Style.DurationTimeline not supported.";
                }
            }, 7, (Object) null);
        } else if (Intrinsics.areEqual(style, XAxisProperties.Style.NoLabels.INSTANCE)) {
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<AvgMaxMinEntry> getAvgMaxMinData() {
        List data = getData();
        boolean z = data instanceof List;
        List list = data;
        if (!z) {
            list = null;
        }
        if (list == null) {
            return EmptyList.INSTANCE;
        }
        return list;
    }

    private final int getTouchIndex() {
        if (getTouchListener$graphics_release().getTouchPoint$graphics_release() != null) {
            return (int) Math.floor(r0.getX() / getX().getTickSpace());
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getXPosCenter(int r3) {
        return (this.lineSpacing / 2.0f) + (getX().getTickSpace() * r3) + this.circleRadiusAvg;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getLabel(), getData()));
        YAxisProperties.Limits invoke = getY().getCalculateMinMax().invoke(getAvgMaxMinData());
        int component1 = invoke.component1();
        int component2 = invoke.component2();
        YAxisScaleFormatter scaleFormatter = getY().getScaleFormatter();
        scaleFormatter.setMaxTicks(getY().getNbrOfGridLines());
        scaleFormatter.setFormatValue(getY().getConvertValueToLabel());
        scaleFormatter.setLowestValue(component1);
        scaleFormatter.setHighestValue(component2);
        getY().setDataMinValue(getY().getScaleFormatter().getRoundedLowestValue());
        getY().setDataMaxValue(getY().getScaleFormatter().getRoundedHighestValue());
        getY().setDataAverageValue(getY().getCalculateAverageValue().invoke(getAvgMaxMinData()).intValue());
        getY().setMaxLabelWidth(YAxisUtilsKt.yAxisMaxLabelWidth(this, this.paints));
        getY().setMaxLabelHeight(YAxisUtilsKt.yAxisMaxLabelHeight(this, this.paints));
        setUsableWidth(ChartUtilsKt.calculateUsableWidth(this, this.paints));
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
        XAxisProperties x = getX();
        float usableWidth = getUsableWidth();
        int size = getData().size();
        if (size < 1) {
            size = 1;
        }
        x.setTickSpace(usableWidth / size);
        if (getX().getTickSpace() > this.circleRadiusAvg) {
            this.lineSpacing = getX().getTickSpace() - this.circleRadiusAvg;
        }
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        drawXAxis();
        ChartDrawUtilsKt.drawYAxis(this, this.paints);
        if (getShowNoDataText()) {
            ChartDrawUtilsKt.drawNoDataText(this, this.paints.getAverageHeading(), this.paints.getBackground());
        }
        if (getData().isEmpty()) {
            return;
        }
        drawAvgMaxMinData();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void drawTouchValue() {
        MaxAvgMinMarkerView maxAvgMinMarkerView;
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release instanceof MaxAvgMinMarkerView) {
            maxAvgMinMarkerView = (MaxAvgMinMarkerView) markerView$graphics_release;
        } else {
            maxAvgMinMarkerView = null;
        }
        if (maxAvgMinMarkerView == null) {
            return;
        }
        int touchIndex = getTouchIndex();
        AvgMaxMinEntry avgMaxMinEntry = (AvgMaxMinEntry) CollectionsKt___CollectionsKt.getOrNull(touchIndex, getAvgMaxMinData());
        if (avgMaxMinEntry == null || avgMaxMinEntry.getAvgValue() < 1) {
            return;
        }
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(touchIndex);
        float xPosCenter = getXPosCenter(touchIndex);
        float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, avgMaxMinEntry.getAvgValue(), 0, 0, 6, null);
        maxAvgMinMarkerView.setTouchEvent(getTouchListener$graphics_release().getCurrentEvent());
        maxAvgMinMarkerView.setTouchPosition(getTouchListener$graphics_release().getTouchPoint$graphics_release());
        maxAvgMinMarkerView.setXPos(xPosCenter);
        maxAvgMinMarkerView.setYPos(normalizeValueToYPos$default);
        maxAvgMinMarkerView.setCircleRadiusHigh(this.circleRadiusMax);
        maxAvgMinMarkerView.setCircleRadiusAverage(this.circleRadiusAvg);
        maxAvgMinMarkerView.setCircleRadiusLow(this.circleRadiusMin);
        maxAvgMinMarkerView.setEntry(avgMaxMinEntry);
        maxAvgMinMarkerView.setOuterBounds(getMainDrawingZone());
        maxAvgMinMarkerView.draw();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final ChartColors getColors() {
        return this.colors;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public MarkerView getMarkerView$graphics_release() {
        return this.markerView;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void setMarkerView$graphics_release(MarkerView markerView) {
        this.markerView = markerView;
    }

    private static /* synthetic */ void getAvgMaxMinData$annotations() {
    }
}
