package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.MarkerViewPaints;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerView.kt */
/* loaded from: classes3.dex */
public final class MaxAvgMinMarkerView extends MarkerView {
    private RectF avgRect;
    private final CanvasPaint background;
    private final Kanvas canvas;
    private float circleRadiusAverage;
    private float circleRadiusHigh;
    private float circleRadiusLow;
    private AvgMaxMinEntry entry;
    private RectF highRect;
    private RectF lowRect;
    private final int margin;
    private final CanvasPaint markerPaint;
    private final MarkerViewPaints paints;
    private final CanvasPaint valuePaint;

    public MaxAvgMinMarkerView(ChartFonts fonts, ChartColors colors, Kanvas canvas) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.canvas = canvas;
        MarkerViewPaints markerViewPaints = new MarkerViewPaints(fonts, colors, getCanvas());
        this.paints = markerViewPaints;
        this.valuePaint = markerViewPaints.getMarkerTitle();
        this.markerPaint = markerViewPaints.getMarkerSubtitle();
        this.background = markerViewPaints.getMarkerBackground();
        this.entry = new AvgMaxMinEntry(0, 0, 0, "", (String) null, false, 48, (DefaultConstructorMarker) null);
        RectF.Companion companion = RectF.Companion;
        this.highRect = companion.getZero();
        this.avgRect = companion.getZero();
        this.lowRect = companion.getZero();
        this.margin = 8;
    }

    private final void drawVerticalLine(float f) {
        CanvasPaint normalFill;
        if (this.entry.isSelected()) {
            normalFill = this.paints.getHighlightFill();
        } else {
            normalFill = this.paints.getNormalFill();
        }
        CanvasPaint canvasPaint = normalFill;
        ChartDrawUtilsKt.drawVerticalDashedLine(getCanvas(), f, this.lowRect.getCenterY(), this.highRect.getCenterY(), canvasPaint, 1.0f, 1.0f);
        CanvasPaint canvasPaint2 = normalFill;
        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), f, this.highRect.getCenterY(), this.circleRadiusHigh, canvasPaint, canvasPaint2);
        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), f, this.avgRect.getCenterY(), this.circleRadiusAverage, canvasPaint, canvasPaint2);
        ChartDrawUtilsKt.drawCircleWithBorder(getCanvas(), f, this.lowRect.getCenterY(), this.circleRadiusLow, canvasPaint, canvasPaint2);
    }

    private final String getAvgText() {
        return String.valueOf(this.entry.getAvgValue());
    }

    private final String getHighText() {
        return String.valueOf(this.entry.getMaxValue());
    }

    private final String getLowText() {
        return String.valueOf(this.entry.getMinValue());
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public void draw() {
        float contentPadding;
        float f;
        float measureWidth = this.markerPaint.measureWidth(this.entry.getMarkerLabel());
        float measureHeight = this.markerPaint.measureHeight(this.entry.getMarkerLabel());
        float measureWidth2 = this.valuePaint.measureWidth(getHighText());
        float measureWidth3 = this.valuePaint.measureWidth(getAvgText());
        float measureWidth4 = this.valuePaint.measureWidth(getLowText());
        float measureHeight2 = this.valuePaint.measureHeight(getHighText());
        float measureHeight3 = this.valuePaint.measureHeight(getAvgText());
        float measureHeight4 = this.valuePaint.measureHeight(getLowText());
        float f2 = 2;
        float max = Math.max(measureWidth2, Math.max(measureWidth3, measureWidth4)) + (this.circleRadiusAverage * f2) + this.margin;
        float max2 = Math.max(max, measureWidth);
        int r12 = this.margin;
        MarkerViewKt.configureBounds(this, (getContentPadding() * f2) + max2, (getContentPadding() * f2) + r12 + measureHeight2 + measureHeight3 + r12 + measureHeight4 + r12 + measureHeight);
        ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), getBounds(), getBackgroundRadius(), false, false, false, false, getBackground(), 120, null);
        if (measureWidth > max) {
            f = getBounds().getCenterX() - (max / f2);
            contentPadding = getContentPadding() / f2;
        } else {
            contentPadding = getContentPadding() + getBounds().getLeft();
            f = this.circleRadiusAverage;
        }
        float f3 = contentPadding + f;
        float f4 = this.circleRadiusAverage + f3 + this.margin;
        RectF copy = this.highRect.copy(f4, getContentPadding() + getBounds().getTop(), measureWidth2, getContentPadding() + getBounds().getTop() + measureHeight2);
        this.highRect = copy;
        RectF copy2 = this.avgRect.copy(f4, copy.getBottom() + this.margin, measureWidth3, this.highRect.getBottom() + this.margin + measureHeight3);
        this.avgRect = copy2;
        this.lowRect = this.lowRect.copy(f4, copy2.getBottom() + this.margin, measureWidth4, this.avgRect.getBottom() + this.margin + measureHeight4);
        Kanvas.drawText$default(getCanvas(), getHighText(), this.highRect.getLeft(), this.highRect.getBottom(), 0.0f, null, this.valuePaint, 24, null);
        Kanvas.drawText$default(getCanvas(), getAvgText(), this.avgRect.getLeft(), this.avgRect.getBottom(), 0.0f, null, this.valuePaint, 24, null);
        Kanvas.drawText$default(getCanvas(), getLowText(), this.lowRect.getLeft(), this.lowRect.getBottom(), 0.0f, null, this.valuePaint, 24, null);
        drawVerticalLine(f3);
        Kanvas.drawText$default(getCanvas(), this.entry.getMarkerLabel(), getBounds().getCenterX() - (measureWidth / f2), getBounds().getBottom() - getContentPadding(), 0.0f, null, this.markerPaint, 24, null);
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public CanvasPaint getBackground() {
        return this.background;
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final float getCircleRadiusAverage() {
        return this.circleRadiusAverage;
    }

    public final float getCircleRadiusHigh() {
        return this.circleRadiusHigh;
    }

    public final float getCircleRadiusLow() {
        return this.circleRadiusLow;
    }

    public final AvgMaxMinEntry getEntry() {
        return this.entry;
    }

    public final void setCircleRadiusAverage(float f) {
        this.circleRadiusAverage = f;
    }

    public final void setCircleRadiusHigh(float f) {
        this.circleRadiusHigh = f;
    }

    public final void setCircleRadiusLow(float f) {
        this.circleRadiusLow = f;
    }

    public final void setEntry(AvgMaxMinEntry avgMaxMinEntry) {
        Intrinsics.checkNotNullParameter(avgMaxMinEntry, "<set-?>");
        this.entry = avgMaxMinEntry;
    }
}
