package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.Vo2MaxPaints;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: FitnessIndexChart.kt */
/* loaded from: classes3.dex */
public final class FitnessIndexChart extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private final float currentBarVerticalMargin;
    private final float currentValueBarWidth;
    private final List<IntRange> distributionRanges;
    private final ChartFonts fonts;
    private final Vo2MaxPaints paints;
    private final List<CanvasPaint> rectPaints;
    private final float spaceBetweenRectangles;

    public FitnessIndexChart(Kanvas canvas, ChartColors colors, ChartFonts fonts, List<IntRange> distributionRanges) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(distributionRanges, "distributionRanges");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.distributionRanges = distributionRanges;
        Vo2MaxPaints vo2MaxPaints = new Vo2MaxPaints(fonts, colors, getCanvas());
        this.paints = vo2MaxPaints;
        this.rectPaints = CollectionsKt__CollectionsKt.listOf((Object[]) new CanvasPaint[]{vo2MaxPaints.getPoor(), vo2MaxPaints.getFair(), vo2MaxPaints.getGood(), vo2MaxPaints.getExcellent(), vo2MaxPaints.getSuperior()});
        this.spaceBetweenRectangles = 1.0f;
        this.currentValueBarWidth = 4.0f;
        this.currentBarVerticalMargin = 4.0f;
    }

    private final void drawCurrentValueBar(float f) {
        Pair<Float, Float> leftRightBound = ChartUtilsKt.getLeftRightBound(f, this.currentValueBarWidth, getUsableWidth(), 0.0f);
        ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), new RectF(leftRightBound.first.floatValue(), this.currentBarVerticalMargin, leftRightBound.second.floatValue(), getUsableHeight() - this.currentBarVerticalMargin), 2.0f, false, false, false, false, this.paints.getHighlightFill(), 120, null);
    }

    private final void drawFitnessIndexChart() {
        float f;
        float coerceIn;
        int r0 = ((IntRange) CollectionsKt___CollectionsKt.last(this.distributionRanges)).last;
        int r1 = ((IntRange) CollectionsKt___CollectionsKt.first((List) this.distributionRanges)).first;
        Iterator<T> it = this.distributionRanges.iterator();
        int r3 = 0;
        while (true) {
            Object obj = null;
            float f2 = 0.0f;
            if (it.hasNext()) {
                Object next = it.next();
                int r7 = r3 + 1;
                if (r3 >= 0) {
                    IntRange intRange = (IntRange) next;
                    float normalizeValueToXPos = ChartUtilsKt.normalizeValueToXPos((Chart) this, intRange.first, r1, r0);
                    float normalizeValueToXPos2 = ChartUtilsKt.normalizeValueToXPos((Chart) this, intRange.last, r1, r0);
                    if (r3 != 0) {
                        f2 = this.spaceBetweenRectangles;
                    }
                    getCanvas().drawRect(normalizeValueToXPos + f2, 0.0f, normalizeValueToXPos2, getUsableHeight(), this.rectPaints.get(r3));
                    r3 = r7;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            } else {
                BarEntry dataItem = getDataItem();
                if (dataItem != null) {
                    int value = dataItem.getValue();
                    Iterator<T> it2 = this.distributionRanges.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        Object next2 = it2.next();
                        if (((IntRange) next2).contains(value)) {
                            obj = next2;
                            break;
                        }
                    }
                    IntRange intRange2 = (IntRange) obj;
                    if (intRange2 == null) {
                        coerceIn = ChartUtilsKt.normalizeValueToXPos((Chart) this, RangesKt___RangesKt.coerceIn(value, getY().getDataMinValue(), getY().getDataMaxValue()), getY().getDataMinValue(), getY().getDataMaxValue());
                    } else {
                        float normalizeValueToXPos3 = ChartUtilsKt.normalizeValueToXPos((Chart) this, intRange2.first, r1, r0);
                        float normalizeValueToXPos4 = ChartUtilsKt.normalizeValueToXPos((Chart) this, intRange2.last, r1, r0);
                        if (Intrinsics.areEqual(intRange2, CollectionsKt___CollectionsKt.first((List) this.distributionRanges))) {
                            f = 0.0f;
                        } else {
                            f = this.spaceBetweenRectangles;
                        }
                        coerceIn = normalizeValueToXPos3 + ((int) ((normalizeValueToXPos4 - normalizeValueToXPos3) * RangesKt___RangesKt.coerceIn(value / (r7 + r3), 0.0f, 1.0f))) + f;
                    }
                    drawCurrentValueBar(coerceIn);
                    return;
                }
                return;
            }
        }
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
        getY().setDataMinValue(((IntRange) CollectionsKt___CollectionsKt.first((List) this.distributionRanges)).first);
        getY().setDataMaxValue(((IntRange) CollectionsKt___CollectionsKt.last(this.distributionRanges)).last);
        setUsableWidth(getWidth() - ((this.distributionRanges.size() - 1) * this.spaceBetweenRectangles));
        setUsableHeight(getHeight());
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        if (this.distributionRanges.isEmpty()) {
            return;
        }
        drawFitnessIndexChart();
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
}
