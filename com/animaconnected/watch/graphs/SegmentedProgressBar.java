package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.DrawBarOptions;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SegmentedProgressBar.kt */
/* loaded from: classes3.dex */
public final class SegmentedProgressBar extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private final ChartFonts fonts;
    private int goalValue;
    private boolean isNegativeSpacing;
    private Mitmap ninePatchBackground;
    private final DrawBarOptions options;
    private final ChartPaints paints;
    private float segmentWidth;
    private boolean toggleToShowGoalText;

    public SegmentedProgressBar(Kanvas canvas, ChartColors colors, ChartFonts fonts, DrawBarOptions options) {
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

    private final void drawSegmentedBars() {
        int r1;
        BarEntry dataItem = getDataItem();
        if (dataItem != null) {
            r1 = Math.min(dataItem.getValue(), this.goalValue);
        } else {
            r1 = 0;
        }
        for (int r2 = 0; r2 < r1; r2++) {
            RectF bounds = getBounds(r2, this.options.getMargin(), this.options.getSegmentSpace());
            if (r2 == 0) {
                ChartDrawUtilsKt.drawBarExt(getCanvas(), bounds, this.paints.getHighlightFill(), DrawBarOptions.copy$default(this.options, 0, 0, null, null, null, null, 0.0f, 0.0f, 0.0f, 510, null));
            } else if (r2 == this.goalValue - 1) {
                ChartDrawUtilsKt.drawBarExt(getCanvas(), bounds, this.paints.getHighlightFill(), DrawBarOptions.copy$default(this.options, 0, 0, null, null, null, null, 0.0f, 0.0f, 0.0f, 509, null));
            } else {
                ChartDrawUtilsKt.drawBarExt(getCanvas(), bounds, this.paints.getHighlightFill(), this.options);
            }
        }
    }

    private final RectF getBounds(int r4, float f, float f2) {
        float f3;
        float f4 = r4;
        float f5 = this.segmentWidth;
        float f6 = f4 * f5;
        if (r4 == 0) {
            f2 = f;
        }
        float f7 = f6 + f2;
        float f8 = (f4 * f5) + f5;
        if (r4 == this.goalValue - 1) {
            f3 = -f;
        } else {
            f3 = 0.0f;
        }
        RectF rectF = new RectF(f7, 0.0f, f8 + f3, getHeight());
        rectF.inset(0.0f, f);
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
        setUsableWidth(getWidth());
        setUsableHeight(getHeight());
        this.segmentWidth = getUsableWidth() / this.goalValue;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        if (getDataItem() == null) {
            return;
        }
        ChartDrawUtilsKt.drawBarBackground(this, 0.0f, 0.0f, getUsableWidth(), getHeight(), this.ninePatchBackground);
        drawSegmentedBars();
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

    public final DrawBarOptions getOptions() {
        return this.options;
    }

    public final boolean getToggleToShowGoalText() {
        return this.toggleToShowGoalText;
    }

    public final boolean isNegativeSpacing() {
        return this.isNegativeSpacing;
    }

    public final void setGoalValue(int r2) {
        this.goalValue = Math.max(r2, 1);
    }

    public final void setNegativeSpacing(boolean z) {
        this.isNegativeSpacing = z;
    }

    public final void setNinePatchBackground(Mitmap mitmap) {
        this.ninePatchBackground = mitmap;
    }

    public final void setToggleToShowGoalText(boolean z) {
        this.toggleToShowGoalText = z;
    }
}
