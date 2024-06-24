package com.animaconnected.watch.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
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

/* compiled from: BarChart.kt */
/* loaded from: classes3.dex */
public final class BarChart extends Chart {
    private float actualBarWidth;
    private float barTotalWidth;
    private final Kanvas canvas;
    private final ChartColors colors;
    private float cornerRadius;
    private boolean drawDotForEmptyBar;
    private final ChartFonts fonts;
    private MarkerView markerView;
    private float maxBarWidth;
    private float minSpacingBetweenBars;
    private final ChartPaints paints;

    public BarChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.drawDotForEmptyBar = true;
        this.paints = new ChartPaints(fonts, colors, getCanvas());
        this.markerView = new DetailMarkerView(fonts, colors, getCanvas());
    }

    private final void calculateBarWidth() {
        float usableWidth = getUsableWidth();
        int size = getData().size();
        if (size < 1) {
            size = 1;
        }
        float f = usableWidth / size;
        this.barTotalWidth = f;
        float f2 = this.maxBarWidth;
        float f3 = this.minSpacingBetweenBars;
        if (f > f2 + f3) {
            this.actualBarWidth = f2;
        } else if (f3 >= f) {
            this.actualBarWidth = f * 0.5f;
        } else {
            this.actualBarWidth = f - f3;
        }
    }

    private final void drawBars() {
        CanvasPaint normalFill;
        int touchIndex = getTouchIndex();
        int r3 = 0;
        for (Object obj : getBarData()) {
            int r5 = r3 + 1;
            if (r3 >= 0) {
                BarEntry barEntry = (BarEntry) obj;
                if (touchIndex == r3 && barEntry.isSelected()) {
                    normalFill = this.paints.getHighlightFill();
                } else if (touchIndex == r3) {
                    normalFill = this.paints.getNormalFill();
                } else if (touchIndex > -1 && barEntry.isSelected()) {
                    normalFill = this.paints.getHighlightVariantFill();
                } else if (touchIndex > -1) {
                    normalFill = this.paints.getNormalVariantFill();
                } else if (barEntry.isSelected()) {
                    normalFill = this.paints.getHighlightFill();
                } else {
                    normalFill = this.paints.getNormalFill();
                }
                RectF barRect = getBarRect(r3, barEntry.getValue());
                ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), barRect, this.cornerRadius, false, false, false, false, normalFill, 120, null);
                if (this.drawDotForEmptyBar && barRect.getHeight() < 1.0f) {
                    ChartDrawUtilsKt.drawDotForEmptyBar(this, barRect, normalFill);
                }
                r3 = r5;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    private final void drawXAxis() {
        XAxisProperties.Style style = getX().getStyle();
        if (Intrinsics.areEqual(style, XAxisProperties.Style.Labels.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabels$default(this, getBarData(), this.paints, 0, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.BarChart$drawXAxis$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenterSegment;
                    xPosCenterSegment = BarChart.this.getXPosCenterSegment(r2);
                    return Float.valueOf(xPosCenterSegment);
                }
            }, 4, null);
            return;
        }
        if (Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabelsStartEndSelected(this, getBarData(), this.paints, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.BarChart$drawXAxis$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenterSegment;
                    xPosCenterSegment = BarChart.this.getXPosCenterSegment(r2);
                    return Float.valueOf(xPosCenterSegment);
                }
            });
            return;
        }
        if (style instanceof XAxisProperties.Style.Timeline) {
            ChartDrawXAxisUtilsKt.drawTimeline(this, XAxisUtilsKt.m1535getXPositionCurrentTimeVtjQ1oo$default(0L, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.BarChart$drawXAxis$3
                {
                    super(1);
                }

                public final Float invoke(int r2) {
                    float xPosCenterSegment;
                    xPosCenterSegment = BarChart.this.getXPosCenterSegment(r2);
                    return Float.valueOf(xPosCenterSegment);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }, 1, null), this.paints);
        } else if (style instanceof XAxisProperties.Style.DurationTimeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.BarChart$drawXAxis$4
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Style.DurationTimeline not supported. ";
                }
            }, 7, (Object) null);
        } else if (Intrinsics.areEqual(style, XAxisProperties.Style.NoLabels.INSTANCE)) {
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BarEntry> getBarData() {
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

    private final RectF getBarRect(int r9, int r10) {
        return new RectF(getXPosCenterSegment(r9) - (this.actualBarWidth * 0.5f), ChartUtilsKt.normalizeValueToYPos$default(this, r10, 0, 0, 6, null), (this.actualBarWidth * 0.5f) + getXPosCenterSegment(r9), getUsableHeight());
    }

    private final int getTouchIndex() {
        if (getTouchListener$graphics_release().getTouchPoint$graphics_release() != null) {
            return (int) Math.floor(r0.getX() / this.barTotalWidth);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getXPosCenterSegment(int r3) {
        float f = this.barTotalWidth;
        return (f * 0.5f) + (r3 * f);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getLabel(), getBarData()));
        YAxisProperties.Limits invoke = getY().getCalculateMinMax().invoke(getBarData());
        int component1 = invoke.component1();
        int component2 = invoke.component2();
        YAxisScaleFormatter scaleFormatter = getY().getScaleFormatter();
        scaleFormatter.setMaxTicks(getY().getNbrOfGridLines());
        scaleFormatter.setFormatValue(getY().getConvertValueToLabel());
        scaleFormatter.setLowestValue(component1);
        scaleFormatter.setHighestValue(component2);
        getY().setDataMinValue(getY().getScaleFormatter().getRoundedLowestValue());
        getY().setDataMaxValue(getY().getScaleFormatter().getRoundedHighestValue());
        getY().setDataAverageValue(getY().getCalculateAverageValue().invoke(getBarData()).intValue());
        getY().setMaxLabelWidth(YAxisUtilsKt.yAxisMaxLabelWidth(this, this.paints));
        getY().setMaxLabelHeight(YAxisUtilsKt.yAxisMaxLabelHeight(this, this.paints));
        setUsableWidth(ChartUtilsKt.calculateUsableWidth(this, this.paints));
        calculateBarWidth();
        getX().setCircleHeight(this.actualBarWidth);
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
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
        drawBars();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void drawTouchValue() {
        DetailMarkerView detailMarkerView;
        boolean areEqual;
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release instanceof DetailMarkerView) {
            detailMarkerView = (DetailMarkerView) markerView$graphics_release;
        } else {
            detailMarkerView = null;
        }
        if (detailMarkerView == null) {
            return;
        }
        int touchIndex = getTouchIndex();
        BarEntry barEntry = (BarEntry) CollectionsKt___CollectionsKt.getOrNull(touchIndex, getBarData());
        if (barEntry == null) {
            return;
        }
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(touchIndex);
        RectF barRect = getBarRect(touchIndex, barEntry.getValue());
        float centerX = barRect.getCenterX();
        float top = barRect.getTop();
        String invoke = getY().getConvertValueToLabel().invoke(Integer.valueOf(barEntry.getValue()));
        String markerLabel = barEntry.getMarkerLabel();
        detailMarkerView.setTouchEvent(getTouchListener$graphics_release().getCurrentEvent());
        detailMarkerView.setTouchPosition(getTouchListener$graphics_release().getTouchPoint$graphics_release());
        detailMarkerView.setXPos(centerX);
        detailMarkerView.setYPos(top);
        detailMarkerView.setTitle(invoke);
        detailMarkerView.setSubtitle(markerLabel);
        detailMarkerView.setOuterBounds(getMainDrawingZone());
        detailMarkerView.draw();
        XAxisProperties.Style style = getX().getStyle();
        if (Intrinsics.areEqual(style, XAxisProperties.Style.Labels.INSTANCE)) {
            areEqual = true;
        } else {
            areEqual = Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE);
        }
        if (areEqual) {
            if (barEntry.getValue() == 0) {
                ChartDrawUtilsKt.drawDotForEmptyBar(this, barRect, this.paints.getImportantFill());
            }
        } else if (style instanceof XAxisProperties.Style.Timeline) {
            ChartDrawUtilsKt.drawDotOnTimeLine(this, centerX, this.paints.getImportantFill());
        }
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final ChartColors getColors() {
        return this.colors;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final boolean getDrawDotForEmptyBar() {
        return this.drawDotForEmptyBar;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public MarkerView getMarkerView$graphics_release() {
        return this.markerView;
    }

    public final float getMaxBarWidth() {
        return this.maxBarWidth;
    }

    public final float getMinSpacingBetweenBars() {
        return this.minSpacingBetweenBars;
    }

    public final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    public final void setDrawDotForEmptyBar(boolean z) {
        this.drawDotForEmptyBar = z;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void setMarkerView$graphics_release(MarkerView markerView) {
        this.markerView = markerView;
    }

    public final void setMaxBarWidth(float f) {
        this.maxBarWidth = f;
    }

    public final void setMinSpacingBetweenBars(float f) {
        this.minSpacingBetweenBars = f;
    }

    private static /* synthetic */ void getBarData$annotations() {
    }
}
