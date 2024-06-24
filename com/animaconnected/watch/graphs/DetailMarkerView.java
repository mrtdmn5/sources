package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.MarkerViewPaints;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkerView.kt */
/* loaded from: classes3.dex */
public final class DetailMarkerView extends MarkerView {
    private final CanvasPaint background;
    private final Kanvas canvas;
    private final MarkerViewPaints paints;
    private String subtitle;
    private final CanvasPaint subtitlePaint;
    private String title;
    private final CanvasPaint titlePaint;
    private final int verticalMarginBetweenText;

    public DetailMarkerView(ChartFonts fonts, ChartColors colors, Kanvas canvas) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.canvas = canvas;
        this.title = "";
        this.subtitle = "";
        MarkerViewPaints markerViewPaints = new MarkerViewPaints(fonts, colors, getCanvas());
        this.paints = markerViewPaints;
        this.titlePaint = markerViewPaints.getMarkerTitle();
        this.subtitlePaint = markerViewPaints.getMarkerSubtitle();
        this.background = markerViewPaints.getMarkerBackground();
        this.verticalMarginBetweenText = 6;
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public void draw() {
        boolean z;
        float measureWidth = this.titlePaint.measureWidth(this.title);
        float measureHeight = this.titlePaint.measureHeight(this.title);
        float measureWidth2 = this.subtitlePaint.measureWidth(this.subtitle);
        float measureHeight2 = this.subtitlePaint.measureHeight(this.subtitle);
        float max = Math.max(measureWidth, measureWidth2);
        boolean z2 = true;
        if (this.title.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (this.subtitle.length() != 0) {
                z2 = false;
            }
            if (z2) {
                measureHeight2 = measureHeight;
            } else {
                measureHeight2 += this.verticalMarginBetweenText + measureHeight;
            }
        }
        float f = 2;
        MarkerViewKt.configureBounds(this, (getContentPadding() * f) + max, (getContentPadding() * f) + measureHeight2);
        ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), getBounds(), getBackgroundRadius(), false, false, false, false, getBackground(), 120, null);
        Kanvas.drawText$default(getCanvas(), this.title, getBounds().getCenterX() - (measureWidth / f), getContentPadding() + getBounds().getTop() + measureHeight, 0.0f, null, this.titlePaint, 24, null);
        Kanvas.drawText$default(getCanvas(), this.subtitle, getBounds().getCenterX() - (measureWidth2 / f), getBounds().getBottom() - getContentPadding(), 0.0f, null, this.subtitlePaint, 24, null);
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public CanvasPaint getBackground() {
        return this.background;
    }

    @Override // com.animaconnected.watch.graphs.MarkerView
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setSubtitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
