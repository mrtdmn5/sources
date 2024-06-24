package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.graphs.utils.DrawBarOptions;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalProgressBar.kt */
/* loaded from: classes3.dex */
public final class HorizontalProgressBar extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private final ChartFonts fonts;
    private int goalValue;
    private Mitmap ninePatchBackground;
    private final DrawBarOptions options;
    private final ChartPaints paints;
    private int progressPercentage;
    private boolean toggleToShowGoalText;

    public HorizontalProgressBar(Kanvas canvas, ChartColors colors, ChartFonts fonts, DrawBarOptions options) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(options, "options");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.options = options;
        this.paints = new ChartPaints(fonts, colors, getCanvas());
    }

    private final void drawProgressBar() {
        boolean z;
        int r7;
        if (getDataItem() != null) {
            BarEntry dataItem = getDataItem();
            int r2 = 0;
            if (dataItem != null && dataItem.getValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                Kanvas canvas = getCanvas();
                RectF bounds = getBounds(this.options.getMargin());
                CanvasPaint highlightFill = this.paints.getHighlightFill();
                DrawBarOptions drawBarOptions = this.options;
                BarEntry dataItem2 = getDataItem();
                if (dataItem2 != null) {
                    r7 = dataItem2.getValue();
                } else {
                    r7 = 0;
                }
                if (r7 < this.goalValue) {
                    r2 = this.options.getFrontTiltDegrees();
                }
                ChartDrawUtilsKt.drawBarExt(canvas, bounds, highlightFill, DrawBarOptions.copy$default(drawBarOptions, 0, r2, null, null, null, null, 0.0f, 0.0f, 0.0f, 508, null));
            }
        }
    }

    private final RectF getBounds(float f) {
        float usableWidth = getUsableWidth() * (this.progressPercentage / 100.0f);
        if (this.progressPercentage <= 0) {
            usableWidth = 0.0f;
        }
        RectF rectF = new RectF(0.0f, 0.0f, usableWidth, getHeight());
        rectF.inset(f, f);
        return rectF;
    }

    private final BarEntry getDataItem() {
        Object firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) getData());
        if (firstOrNull instanceof BarEntry) {
            return (BarEntry) firstOrNull;
        }
        return null;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        BarEntry dataItem = getDataItem();
        if (dataItem != null) {
            this.progressPercentage = ChartUtilsKt.calculatePercentage(dataItem.getValue(), this.goalValue);
        }
        setUsableWidth(getWidth());
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        if (getDataItem() == null) {
            return;
        }
        ChartDrawUtilsKt.drawBarBackground(this, 0.0f, 0.0f, getUsableWidth(), getHeight(), this.ninePatchBackground);
        drawProgressBar();
        if (this.toggleToShowGoalText) {
            drawToggledGoalText();
        }
    }

    public final void drawToggledGoalText() {
        String str;
        BarEntry dataItem = getDataItem();
        if (dataItem == null || (str = dataItem.getMarkerLabel()) == null) {
            str = "";
        }
        String str2 = str;
        float f = 2;
        float height = getHeight() / f;
        Kanvas.drawText$default(getCanvas(), str2, (height - (this.paints.getSubtitle().measureHeight(str2) / f)) * f, (this.paints.getSubtitle().measureHeight(str2) / f) + height, 0.0f, null, getCanvas().createTextPaint(new Kanvas.TextConfig(this.fonts.getH3(), this.colors.getImportantText(), null, false, new Kanvas.Shadow(1.0f, 1.0f, 1.0f, Kolors.blackSub), 12, null)), 24, null);
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

    public final int getGoalValue() {
        return this.goalValue;
    }

    public final Mitmap getNinePatchBackground() {
        return this.ninePatchBackground;
    }

    public final boolean getToggleToShowGoalText() {
        return this.toggleToShowGoalText;
    }

    public final void setGoalValue(int r1) {
        this.goalValue = r1;
    }

    public final void setNinePatchBackground(Mitmap mitmap) {
        this.ninePatchBackground = mitmap;
    }

    public final void setToggleToShowGoalText(boolean z) {
        this.toggleToShowGoalText = z;
    }
}
