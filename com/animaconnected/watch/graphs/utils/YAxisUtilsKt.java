package com.animaconnected.watch.graphs.utils;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.YAxisProperties;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: YAxisUtils.kt */
/* loaded from: classes3.dex */
public final class YAxisUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void drawLabel(Chart chart, String str, float f, CanvasPaint canvasPaint, int r17) {
        boolean z;
        if (r17 == 0 && !getDrawLabelBottom(chart)) {
            return;
        }
        if (chart.getY().getLineToLabelRatio() == YAxisProperties.LineToLabelRatio.One) {
            Kanvas.drawText$default(chart.getCanvas(), str, getXPosYaxisLabel(chart), f, 0.0f, null, canvasPaint, 24, null);
            return;
        }
        int r0 = r17 % 2;
        boolean z2 = true;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (r0 == 0) {
            z2 = false;
        }
        if (!getDrawLabelBottom(chart)) {
            z = z2;
        }
        if (z) {
            Kanvas.drawText$default(chart.getCanvas(), str, getXPosYaxisLabel(chart), f, 0.0f, null, canvasPaint, 24, null);
        }
    }

    public static final void drawYAxisAverageLineLabel(Chart chart, ChartPaints paints, String descriptionText) {
        boolean z;
        float labelMargin;
        float f;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(descriptionText, "descriptionText");
        boolean z2 = true;
        if (chart.getY().getDataAverageValue() < 1) {
            return;
        }
        float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(chart, chart.getY().getDataAverageValue(), 0, 0, 6, null);
        String invoke = chart.getY().getConvertValueToLabel().invoke(Integer.valueOf(chart.getY().getDataAverageValue()));
        float measureWidth = paints.getAverageValue().measureWidth(invoke);
        float measureHeight = paints.getAverageValue().measureHeight(invoke);
        float width = chart.getWidth() - measureWidth;
        if (descriptionText.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            labelMargin = normalizeValueToYPos$default - chart.getX().getLabelMargin();
        } else {
            labelMargin = measureHeight + normalizeValueToYPos$default + chart.getX().getLabelMargin();
        }
        if (labelMargin > chart.getHeight()) {
            f = labelMargin - chart.getHeight();
        } else {
            f = 0.0f;
        }
        chart.getCanvas().drawLine(0.0f, normalizeValueToYPos$default, chart.getWidth(), normalizeValueToYPos$default, paints.getGridLine());
        Kanvas.drawText$default(chart.getCanvas(), invoke, width, labelMargin - f, 0.0f, null, paints.getAverageValue(), 24, null);
        if (descriptionText.length() <= 0) {
            z2 = false;
        }
        if (z2) {
            Kanvas.drawText$default(chart.getCanvas(), descriptionText, chart.getWidth() - paints.getAverageHeading().measureWidth(descriptionText), normalizeValueToYPos$default - paints.getAverageHeading().measureHeight(descriptionText), 0.0f, null, paints.getAverageHeading(), 24, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void drawYAxisDual(Chart chart, ChartPaints paints, List<Pair<String, IntRange>> values) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        Intrinsics.checkNotNullParameter(values, "values");
        drawYAxisNormal(chart, paints, chart.getX().getStartPosition().invoke().floatValue());
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.first;
            IntRange intRange = (IntRange) pair.second;
            float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(chart, (intRange.last + intRange.first) / 2, 0, 0, 6, null);
            float measureHeight = paints.getLabel().measureHeight(str);
            Kanvas canvas = chart.getCanvas();
            float f = measureHeight / 2.0f;
            Kanvas.Anchor.Position position = Kanvas.Anchor.Position.MID;
            canvas.drawText(str, f, normalizeValueToYPos$default, -90.0f, new Kanvas.Anchor(position, position), paints.getLabel());
        }
    }

    public static final void drawYAxisHighlight(final Chart chart, final ChartPaints paints, int r21) {
        YAxisProperties.Style.Highlight highlight;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        YAxisProperties.Style style = chart.getY().getStyle();
        if (style instanceof YAxisProperties.Style.Highlight) {
            highlight = (YAxisProperties.Style.Highlight) style;
        } else {
            highlight = null;
        }
        YAxisProperties.Style.Highlight highlight2 = highlight;
        String invoke = chart.getY().getConvertValueToLabel().invoke(Integer.valueOf(r21));
        float measureHeight = paints.getImportant().measureHeight(invoke);
        final float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(chart, r21, 0, 0, 6, null);
        float f = (measureHeight / 2) + normalizeValueToYPos$default;
        if (highlight2 != null) {
            z = highlight2.getDashedLine();
        } else {
            z = false;
        }
        boolean z3 = z;
        if (highlight2 != null) {
            z2 = highlight2.getShowValue();
        } else {
            z2 = true;
        }
        final boolean z4 = z2;
        final FloatRange yBounds = yBounds(invoke, paints.getImportant(), normalizeValueToYPos$default);
        onEachEntry(chart, paints.getLabel(), new Function5<String, Integer, Float, Float, FloatRange, Unit>() { // from class: com.animaconnected.watch.graphs.utils.YAxisUtilsKt$drawYAxisHighlight$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, Float f2, Float f3, FloatRange floatRange) {
                invoke(str, num.intValue(), f2.floatValue(), f3.floatValue(), floatRange);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:            if ((r2 == r10) == false) goto L10;     */
            /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(java.lang.String r8, int r9, float r10, float r11, com.animaconnected.watch.graphs.utils.FloatRange r12) {
                /*
                    r7 = this;
                    java.lang.String r0 = "label"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "yBounds"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                    com.animaconnected.watch.graphs.Chart r0 = com.animaconnected.watch.graphs.Chart.this
                    boolean r0 = com.animaconnected.watch.graphs.utils.YAxisUtilsKt.access$getDrawZeroLine(r0)
                    if (r0 != 0) goto L1f
                    if (r9 <= 0) goto L37
                    float r0 = r2
                    int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
                    if (r0 != 0) goto L1c
                    r0 = 1
                    goto L1d
                L1c:
                    r0 = 0
                L1d:
                    if (r0 != 0) goto L37
                L1f:
                    com.animaconnected.watch.graphs.Chart r0 = com.animaconnected.watch.graphs.Chart.this
                    com.animaconnected.watch.display.Kanvas r1 = r0.getCanvas()
                    r2 = 0
                    com.animaconnected.watch.graphs.Chart r0 = com.animaconnected.watch.graphs.Chart.this
                    float r4 = r0.getUsableWidth()
                    com.animaconnected.watch.theme.ChartPaints r0 = r3
                    com.animaconnected.watch.display.CanvasPaint r6 = r0.getGridLine()
                    r3 = r10
                    r5 = r10
                    r1.drawLine(r2, r3, r4, r5, r6)
                L37:
                    boolean r10 = r4
                    if (r10 == 0) goto L43
                    com.animaconnected.watch.graphs.utils.FloatRange r10 = r5
                    boolean r10 = com.animaconnected.watch.graphs.utils.YAxisUtilsKt.access$isTouching(r12, r10)
                    if (r10 != 0) goto L4e
                L43:
                    com.animaconnected.watch.graphs.Chart r10 = com.animaconnected.watch.graphs.Chart.this
                    com.animaconnected.watch.theme.ChartPaints r12 = r3
                    com.animaconnected.watch.display.CanvasPaint r12 = r12.getLabel()
                    com.animaconnected.watch.graphs.utils.YAxisUtilsKt.access$drawLabel(r10, r8, r11, r12, r9)
                L4e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.utils.YAxisUtilsKt$drawYAxisHighlight$1.invoke(java.lang.String, int, float, float, com.animaconnected.watch.graphs.utils.FloatRange):void");
            }
        });
        if (z3) {
            ChartDrawUtilsKt.drawHorizontalDashedLine$default(chart, normalizeValueToYPos$default, chart.getUsableWidth(), paints.getImportant(), 0.0f, 0.0f, 24, null);
        } else {
            chart.getCanvas().drawLine(0.0f, normalizeValueToYPos$default, chart.getUsableWidth(), normalizeValueToYPos$default, paints.getImportant());
        }
        if (z4) {
            Kanvas.drawText$default(chart.getCanvas(), invoke, getXPosYaxisLabel(chart), f, 0.0f, null, paints.getImportant(), 24, null);
        }
    }

    public static final void drawYAxisNormal(final Chart chart, final ChartPaints paints, final float f) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        onEachEntry(chart, paints.getLabel(), new Function5<String, Integer, Float, Float, FloatRange, Unit>() { // from class: com.animaconnected.watch.graphs.utils.YAxisUtilsKt$drawYAxisNormal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, Float f2, Float f3, FloatRange floatRange) {
                invoke(str, num.intValue(), f2.floatValue(), f3.floatValue(), floatRange);
                return Unit.INSTANCE;
            }

            public final void invoke(String label, int r8, float f2, float f3, FloatRange floatRange) {
                boolean drawZeroLine;
                Intrinsics.checkNotNullParameter(label, "label");
                Intrinsics.checkNotNullParameter(floatRange, "<anonymous parameter 4>");
                drawZeroLine = YAxisUtilsKt.getDrawZeroLine(Chart.this);
                if (drawZeroLine || r8 > 0) {
                    Chart.this.getCanvas().drawLine(f, f2, Chart.this.getUsableWidth(), f2, paints.getGridLine());
                }
                YAxisUtilsKt.drawLabel(Chart.this, label, f3, paints.getLabel(), r8);
            }
        });
    }

    public static /* synthetic */ void drawYAxisNormal$default(Chart chart, ChartPaints chartPaints, float f, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            f = 0.0f;
        }
        drawYAxisNormal(chart, chartPaints, f);
    }

    private static final boolean getDrawLabelBottom(Chart chart) {
        YAxisProperties.Style style = chart.getY().getStyle();
        if (style != null) {
            return style.getDrawLabelBottom();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getDrawZeroLine(Chart chart) {
        YAxisProperties.Style style = chart.getY().getStyle();
        if (style != null) {
            return style.getDrawZeroLine();
        }
        return true;
    }

    private static final float getXPosYaxisLabel(Chart chart) {
        return chart.getUsableWidth() + chart.getX().getLabelMargin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTouching(FloatRange floatRange, FloatRange floatRange2) {
        float abs = Math.abs(floatRange.getStart().floatValue() - floatRange.getEndInclusive().floatValue());
        float abs2 = Math.abs(floatRange2.getEndInclusive().floatValue() - floatRange2.getStart().floatValue());
        if (floatRange.getStart().floatValue() + abs >= floatRange2.getStart().floatValue() && floatRange.getStart().floatValue() <= floatRange2.getStart().floatValue() + abs2) {
            return true;
        }
        return false;
    }

    private static final float maxLabelHeightValues(Chart chart, CanvasPaint canvasPaint) {
        Float valueOf;
        List<YAxisEntry> entries = chart.getY().getScaleFormatter().getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(canvasPaint.measureHeight(((YAxisEntry) it.next()).getLabel())));
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            valueOf = null;
        } else {
            float floatValue = ((Number) it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, ((Number) it2.next()).floatValue());
            }
            valueOf = Float.valueOf(floatValue);
        }
        if (valueOf != null) {
            return valueOf.floatValue();
        }
        return 0.0f;
    }

    private static final float maxLabelWidthValues(Chart chart, CanvasPaint canvasPaint) {
        Float valueOf;
        List<YAxisEntry> entries = chart.getY().getScaleFormatter().getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entries, 10));
        Iterator<T> it = entries.iterator();
        while (it.hasNext()) {
            arrayList.add(Float.valueOf(canvasPaint.measureWidth(((YAxisEntry) it.next()).getLabel())));
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            valueOf = null;
        } else {
            float floatValue = ((Number) it2.next()).floatValue();
            while (it2.hasNext()) {
                floatValue = Math.max(floatValue, ((Number) it2.next()).floatValue());
            }
            valueOf = Float.valueOf(floatValue);
        }
        if (valueOf != null) {
            return valueOf.floatValue();
        }
        return 0.0f;
    }

    private static final void onEachEntry(Chart chart, CanvasPaint canvasPaint, Function5<? super String, ? super Integer, ? super Float, ? super Float, ? super FloatRange, Unit> function5) {
        List<YAxisEntry> entries = chart.getY().getScaleFormatter().getEntries();
        if (entries.size() < 2) {
            return;
        }
        int r1 = 0;
        for (Object obj : entries) {
            int r3 = r1 + 1;
            if (r1 >= 0) {
                YAxisEntry yAxisEntry = (YAxisEntry) obj;
                String label = yAxisEntry.getLabel();
                float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(chart, yAxisEntry.getValue(), 0, 0, 6, null);
                FloatRange yBounds = yBounds(label, canvasPaint, normalizeValueToYPos$default);
                function5.invoke(label, Integer.valueOf(r1), Float.valueOf(normalizeValueToYPos$default), yBounds.getEndInclusive(), yBounds);
                r1 = r3;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    public static final float yAxisMaxLabelHeight(Chart chart, ChartPaints paints) {
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        YAxisProperties.Style style = chart.getY().getStyle();
        boolean z = true;
        if (style instanceof YAxisProperties.Style.Average) {
            YAxisProperties.Style.Average average = (YAxisProperties.Style.Average) style;
            if (average.getDescriptionText().length() != 0) {
                z = false;
            }
            if (z) {
                return paints.getAverageValue().measureHeight(chart.getY().getConvertValueToLabel().invoke(Integer.valueOf(chart.getY().getDataAverageValue())));
            }
            return paints.getAverageHeading().measureHeight(average.getDescriptionText());
        }
        if (style instanceof YAxisProperties.Style.Highlight) {
            return Math.max(paints.getImportant().measureHeight(chart.getY().getConvertValueToLabel().invoke(((YAxisProperties.Style.Highlight) style).getValue().invoke())), maxLabelHeightValues(chart, paints.getLabel()));
        }
        if (!(style instanceof YAxisProperties.Style.Normal)) {
            z = style instanceof YAxisProperties.Style.DualAxes;
        }
        if (z) {
            return maxLabelHeightValues(chart, paints.getLabel());
        }
        if (style == null) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final float yAxisMaxLabelWidth(Chart chart, ChartPaints paints) {
        boolean z;
        Intrinsics.checkNotNullParameter(chart, "<this>");
        Intrinsics.checkNotNullParameter(paints, "paints");
        YAxisProperties.Style style = chart.getY().getStyle();
        if (style instanceof YAxisProperties.Style.Average) {
            return Math.max(paints.getAverageValue().measureWidth(chart.getY().getConvertValueToLabel().invoke(Integer.valueOf(chart.getY().getDataAverageValue()))), paints.getAverageHeading().measureWidth(((YAxisProperties.Style.Average) style).getDescriptionText()));
        }
        if (style instanceof YAxisProperties.Style.Highlight) {
            return Math.max(paints.getImportant().measureWidth(chart.getY().getConvertValueToLabel().invoke(((YAxisProperties.Style.Highlight) style).getValue().invoke())), maxLabelWidthValues(chart, paints.getLabel()));
        }
        if (style instanceof YAxisProperties.Style.Normal) {
            z = true;
        } else {
            z = style instanceof YAxisProperties.Style.DualAxes;
        }
        if (z) {
            return maxLabelWidthValues(chart, paints.getLabel());
        }
        if (style == null) {
            return 0.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final FloatRange yBounds(String str, CanvasPaint canvasPaint, float f) {
        float measureHeight = canvasPaint.measureHeight(str);
        double d = 0.5f * measureHeight;
        return new FloatRange((f - ((float) Math.ceil(d))) - measureHeight, f + ((float) Math.ceil(d)));
    }
}
