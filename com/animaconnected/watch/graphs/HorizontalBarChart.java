package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalBarChart.kt */
/* loaded from: classes3.dex */
public final class HorizontalBarChart extends Chart {
    private float barHeight;
    private float barSpacing;
    private final Kanvas canvas;
    private final ChartColors colors;
    private String firstTitle;
    private final ChartFonts fonts;
    private final CanvasPaint paintBarSelectedValueLabel;
    private final ChartPaints paints;
    private String secondTitle;
    private boolean showValuesOnBars;
    private float titleMaxHeight;

    public HorizontalBarChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.paintBarSelectedValueLabel = getCanvas().createTextPaint(new Kanvas.TextConfig(fonts.getH5(), Kolors.black, null, false, null, 28, null));
        this.paints = new ChartPaints(fonts, colors, getCanvas());
        this.firstTitle = "";
        this.secondTitle = "";
    }

    private final RectF calculateBarBounds(BarEntry barEntry, int r6) {
        float f = this.barHeight;
        float f2 = (this.barSpacing + f) * r6;
        float f3 = 2;
        float labelMargin = (f / f3) + f2 + this.titleMaxHeight + getY().getLabelMargin();
        float barLeftXPos = getBarLeftXPos();
        float calculateNormalizedWidth = calculateNormalizedWidth(barEntry) + barLeftXPos;
        float f4 = this.barHeight;
        return new RectF(barLeftXPos, labelMargin - (f4 / f3), calculateNormalizedWidth, (f4 / f3) + labelMargin);
    }

    private final float calculateNormalizedWidth(BarEntry barEntry) {
        boolean z;
        Object obj;
        float f;
        float normalizeValueToXPos;
        boolean z2;
        float normalizeValueToXPos2 = ChartUtilsKt.normalizeValueToXPos((Chart) this, getY().getDataMinValue(), 0, getY().getDataMaxValue());
        Iterator<T> it = getBarData().iterator();
        while (true) {
            z = true;
            if (it.hasNext()) {
                obj = it.next();
                if (((BarEntry) obj).getValue() == getY().getDataMinValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        BarEntry barEntry2 = (BarEntry) obj;
        float f2 = 0.0f;
        if (barEntry2 != null) {
            f = (getY().getLabelMargin() * 4.0f) + this.paintBarSelectedValueLabel.measureWidth(barEntry2.getBarValueLabel());
        } else {
            f = 0.0f;
        }
        if (normalizeValueToXPos2 >= f) {
            z = false;
        }
        if (z) {
            normalizeValueToXPos = normalizeValueToXPosRoot(barEntry.getValue(), 0, getY().getDataMaxValue());
        } else {
            normalizeValueToXPos = ChartUtilsKt.normalizeValueToXPos((Chart) this, barEntry.getValue(), 0, getY().getDataMaxValue());
        }
        if (z) {
            normalizeValueToXPos2 = normalizeValueToXPosRoot(getY().getDataMinValue(), 0, getY().getDataMaxValue());
        }
        if (normalizeValueToXPos2 < f) {
            f2 = f - normalizeValueToXPos2;
        }
        float f3 = normalizeValueToXPos + f2;
        float usableWidth = getUsableWidth();
        if (f3 > usableWidth) {
            return usableWidth;
        }
        return f3;
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

    private final float getBarLeftXPos() {
        return getY().getMaxLabelWidth() + getY().getLabelMargin();
    }

    private final float getSecondTitleLeftXPos() {
        return (getY().getLabelMargin() * 2.0f) + getBarLeftXPos();
    }

    private final float normalizeValueToXPosRoot(int r3, int r4, int r5) {
        if (r3 < r4) {
            r3 = r4;
        }
        float sqrt = (float) Math.sqrt(r3);
        float sqrt2 = (float) Math.sqrt(r5);
        float sqrt3 = (float) Math.sqrt(r4);
        float f = sqrt - sqrt3;
        float f2 = sqrt2 - sqrt3;
        if (f2 < 1.0f) {
            f2 = 1.0f;
        }
        return getUsableWidth() * (f / f2);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        float width;
        float height;
        if (getBarData().isEmpty()) {
            return;
        }
        YAxisProperties.Limits invoke = getY().getCalculateMinMax().invoke(getBarData());
        int component1 = invoke.component1();
        int component2 = invoke.component2();
        getY().setDataMinValue(component1);
        getY().setDataMaxValue(component2);
        getY().setDataAverageValue(getY().getCalculateAverageValue().invoke(getBarData()).intValue());
        this.titleMaxHeight = Math.max(this.paints.getLabel().measureHeight(this.firstTitle), this.paints.getLabel().measureHeight(this.secondTitle));
        getY().setMaxLabelHeight(this.paints.getLabel().measureHeight(((BarEntry) CollectionsKt___CollectionsKt.first((List) getBarData())).getXAxisLabel()));
        YAxisProperties y = getY();
        List<BarEntry> barData = getBarData();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(barData, 10));
        Iterator<T> it = barData.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(this.paints.getLabel().measureWidth(((BarEntry) it.next()).getXAxisLabel())));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            float floatValue = ((Number) it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, ((Number) it2.next()).floatValue());
            }
            y.setMaxLabelWidth(Math.max(floatValue, this.paints.getLabel().measureWidth(this.firstTitle)));
            if (getY().getStyle() != null) {
                width = (getWidth() - getY().getMaxLabelWidth()) - (getY().getLabelMargin() * 2);
            } else {
                width = getWidth();
            }
            setUsableWidth(width);
            if (getY().getStyle() != null) {
                height = (getHeight() - this.titleMaxHeight) - getY().getLabelMargin();
            } else {
                height = getHeight();
            }
            setUsableHeight(height);
            return;
        }
        throw new NoSuchElementException();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        CanvasPaint normalFill;
        CanvasPaint important;
        if (getBarData().isEmpty()) {
            return;
        }
        Kanvas.drawText$default(getCanvas(), this.firstTitle, 0.0f, this.titleMaxHeight, 0.0f, null, this.paints.getLabel(), 24, null);
        Kanvas.drawText$default(getCanvas(), this.secondTitle, getSecondTitleLeftXPos(), this.titleMaxHeight, 0.0f, null, this.paints.getLabel(), 24, null);
        int r2 = 0;
        for (Object obj : getBarData()) {
            int r4 = r2 + 1;
            if (r2 >= 0) {
                BarEntry barEntry = (BarEntry) obj;
                RectF calculateBarBounds = calculateBarBounds(barEntry, r2);
                Kanvas canvas = getCanvas();
                if (barEntry.isSelected()) {
                    normalFill = this.paints.getHighlightFill();
                } else {
                    normalFill = this.paints.getNormalFill();
                }
                ChartDrawUtilsKt.drawRoundRectPath$default(canvas, calculateBarBounds, 8.0f, false, false, false, false, normalFill, 120, null);
                if (getY().getStyle() != null) {
                    Kanvas.drawText$default(getCanvas(), barEntry.getXAxisLabel(), (getY().getMaxLabelWidth() * 0.5f) - (this.paints.getLabel().measureWidth(barEntry.getXAxisLabel()) * 0.5f), (getY().getMaxLabelHeight() * 0.5f) + calculateBarBounds.getCenterY(), 0.0f, null, this.paints.getLabel(), 24, null);
                }
                if (this.showValuesOnBars) {
                    float maxLabelHeight = (getY().getMaxLabelHeight() * 0.5f) + calculateBarBounds.getCenterY();
                    Kanvas canvas2 = getCanvas();
                    String barValueLabel = barEntry.getBarValueLabel();
                    float secondTitleLeftXPos = getSecondTitleLeftXPos();
                    if (barEntry.isSelected()) {
                        important = this.paintBarSelectedValueLabel;
                    } else {
                        important = this.paints.getImportant();
                    }
                    Kanvas.drawText$default(canvas2, barValueLabel, secondTitleLeftXPos, maxLabelHeight, 0.0f, null, important, 24, null);
                }
                r2 = r4;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    public final float getBarHeight() {
        return this.barHeight;
    }

    public final float getBarSpacing() {
        return this.barSpacing;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final ChartColors getColors() {
        return this.colors;
    }

    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public final boolean getShowValuesOnBars() {
        return this.showValuesOnBars;
    }

    public final float getTotalHeight() {
        return this.titleMaxHeight + getY().getLabelMargin() + (getData().size() * this.barHeight) + (CollectionsKt__CollectionsKt.getLastIndex(getData()) * this.barSpacing);
    }

    public final void setBarHeight(float f) {
        this.barHeight = f;
    }

    public final void setBarSpacing(float f) {
        this.barSpacing = f;
    }

    public final void setFirstTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstTitle = str;
    }

    public final void setSecondTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondTitle = str;
    }

    public final void setShowValuesOnBars(boolean z) {
        this.showValuesOnBars = z;
    }

    private static /* synthetic */ void getBarData$annotations() {
    }
}
