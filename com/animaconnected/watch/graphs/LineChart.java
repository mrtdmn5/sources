package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.CanvasPath;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexedValue;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: LineChart.kt */
/* loaded from: classes3.dex */
public final class LineChart extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private Mode dataSetMode;
    private final ChartFonts fonts;
    private boolean highlightLastItem;
    private float highlightedCircleRadius;
    private float lineDotRadius;
    private final float markerPointCircleRadius;
    private MarkerView markerView;
    private final ChartPaints paints;
    private boolean showEmptyLine;
    private boolean showSolidLineOnDashedLine;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: LineChart.kt */
    /* loaded from: classes3.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode Cubic = new Mode("Cubic", 0);
        public static final Mode Line = new Mode("Line", 1);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{Cubic, Line};
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Mode(String str, int r2) {
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* compiled from: LineChart.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Mode.values().length];
            try {
                r0[Mode.Cubic.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Mode.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public LineChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.showEmptyLine = true;
        this.highlightedCircleRadius = 4.0f;
        this.lineDotRadius = 1.0f;
        this.markerPointCircleRadius = 4.0f;
        this.dataSetMode = Mode.Cubic;
        this.paints = new ChartPaints(fonts, colors, getCanvas());
        this.markerView = new DetailMarkerView(fonts, colors, getCanvas());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cubicTo(CanvasPath canvasPath, float f, float f2, float f3, float f4) {
        float f5 = (f + f3) / 2;
        PointF pointF = new PointF(f5, f2);
        PointF pointF2 = new PointF(f5, f4);
        canvasPath.cubicTo(pointF.getX(), pointF.getY(), pointF2.getX(), pointF2.getY(), f3, f4);
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Object, com.animaconnected.watch.display.CanvasPath] */
    private final void drawCubicLines() {
        CanvasPaint highlightStroke;
        CanvasPaint highlightFill;
        CanvasPaint lineDashedHighlight;
        CanvasPaint canvasPaint;
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (this.highlightLastItem) {
            highlightStroke = this.paints.getLine();
        } else {
            highlightStroke = this.paints.getHighlightStroke();
        }
        CanvasPaint canvasPaint2 = highlightStroke;
        if (this.highlightLastItem) {
            highlightFill = this.paints.getLineDot();
        } else {
            highlightFill = this.paints.getHighlightFill();
        }
        final CanvasPaint canvasPaint3 = highlightFill;
        if (this.highlightLastItem) {
            lineDashedHighlight = this.paints.getLineDashed();
        } else {
            lineDashedHighlight = this.paints.getLineDashedHighlight();
        }
        if (this.showSolidLineOnDashedLine) {
            canvasPaint = canvasPaint2;
        } else {
            canvasPaint = lineDashedHighlight;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? createPath = getCanvas().createPath();
        arrayList.add(createPath);
        ref$ObjectRef.element = createPath;
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final CanvasPaint canvasPaint4 = canvasPaint;
        forEachWithPrevAndNext(getPointData(), new Function3<IndexedValue<? extends PointEntry>, IndexedValue<? extends PointEntry>, IndexedValue<? extends PointEntry>, Object>() { // from class: com.animaconnected.watch.graphs.LineChart$drawCubicLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(IndexedValue<? extends PointEntry> indexedValue, IndexedValue<? extends PointEntry> indexedValue2, IndexedValue<? extends PointEntry> indexedValue3) {
                return invoke2((IndexedValue<PointEntry>) indexedValue, (IndexedValue<PointEntry>) indexedValue2, (IndexedValue<PointEntry>) indexedValue3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r11v4, types: [T, com.animaconnected.watch.display.CanvasPath] */
            /* JADX WARN: Type inference failed for: r3v4, types: [T, com.animaconnected.watch.display.CanvasPath] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(IndexedValue<PointEntry> indexedValue, IndexedValue<PointEntry> currentEntry, IndexedValue<PointEntry> indexedValue2) {
                float x;
                float y;
                float x2;
                float y2;
                float x3;
                float y3;
                float x4;
                float y4;
                float x5;
                float y5;
                float f;
                PointEntry pointEntry;
                PointEntry pointEntry2;
                PointEntry pointEntry3;
                Intrinsics.checkNotNullParameter(currentEntry, "currentEntry");
                LineChartValue lineChartValue = null;
                LineChartValue lineChartValue2 = (indexedValue == null || (pointEntry3 = indexedValue.value) == null) ? null : pointEntry3.getLineChartValue();
                LineChartValue lineChartValue3 = ((PointEntry) currentEntry.value).getLineChartValue();
                LineChartValue lineChartValue4 = (indexedValue2 == null || (pointEntry2 = indexedValue2.value) == null) ? null : pointEntry2.getLineChartValue();
                boolean z = lineChartValue3 instanceof Known;
                if (z) {
                    ref$ObjectRef2.element = currentEntry;
                } else if (lineChartValue3 instanceof None) {
                    ref$ObjectRef2.element = null;
                }
                IndexedValue<PointEntry> indexedValue3 = ref$ObjectRef2.element;
                if (indexedValue3 != null && (pointEntry = indexedValue3.value) != null) {
                    lineChartValue = pointEntry.getLineChartValue();
                }
                boolean z2 = lineChartValue2 instanceof Known;
                int r11 = currentEntry.index;
                if (!z2 && z && !(lineChartValue4 instanceof Known)) {
                    Kanvas canvas = this.getCanvas();
                    x5 = this.getX(r11);
                    y5 = this.getY(((Known) lineChartValue3).getValue());
                    f = this.lineDotRadius;
                    canvas.drawCircle(x5, y5, f, canvasPaint3);
                    return Unit.INSTANCE;
                }
                if ((lineChartValue instanceof Known) && (lineChartValue3 instanceof Unknown) && (lineChartValue4 instanceof Known) && this.getShowEmptyLine()) {
                    x3 = this.getX(indexedValue3.index);
                    Float valueOf = Float.valueOf(x3);
                    y3 = this.getY(((Known) lineChartValue).getValue());
                    Float valueOf2 = Float.valueOf(y3);
                    float floatValue = valueOf.floatValue();
                    float floatValue2 = valueOf2.floatValue();
                    x4 = this.getX(indexedValue2.index);
                    Float valueOf3 = Float.valueOf(x4);
                    y4 = this.getY(((Known) lineChartValue4).getValue());
                    Float valueOf4 = Float.valueOf(y4);
                    float floatValue3 = valueOf3.floatValue();
                    float floatValue4 = valueOf4.floatValue();
                    CanvasPath createPath2 = this.getCanvas().createPath();
                    LineChart lineChart = this;
                    CanvasPaint canvasPaint5 = canvasPaint4;
                    createPath2.moveTo(floatValue, floatValue2);
                    lineChart.cubicTo(createPath2, floatValue, floatValue2, floatValue3, floatValue4);
                    lineChart.getCanvas().drawPath(createPath2, canvasPaint5);
                    return createPath2;
                }
                if (!z || !(lineChartValue4 instanceof Known)) {
                    if (z2 && !z) {
                        ref$ObjectRef.element = this.getCanvas().createPath();
                        arrayList.add(ref$ObjectRef.element);
                        ref$BooleanRef.element = false;
                    }
                    return Unit.INSTANCE;
                }
                Known known = (Known) lineChartValue3;
                boolean dashedLine = known.getDashedLine();
                if (ref$BooleanRef.element != dashedLine) {
                    ref$ObjectRef.element = this.getCanvas().createPath();
                    if (dashedLine) {
                        arrayList2.add(ref$ObjectRef.element);
                    } else {
                        arrayList.add(ref$ObjectRef.element);
                    }
                    ref$BooleanRef.element = dashedLine;
                }
                x = this.getX(r11);
                Float valueOf5 = Float.valueOf(x);
                y = this.getY(known.getValue());
                Float valueOf6 = Float.valueOf(y);
                float floatValue5 = valueOf5.floatValue();
                float floatValue6 = valueOf6.floatValue();
                x2 = this.getX(indexedValue2.index);
                Float valueOf7 = Float.valueOf(x2);
                y2 = this.getY(((Known) lineChartValue4).getValue());
                Float valueOf8 = Float.valueOf(y2);
                float floatValue7 = valueOf7.floatValue();
                float floatValue8 = valueOf8.floatValue();
                ref$ObjectRef.element.moveTo(floatValue5, floatValue6);
                this.cubicTo(ref$ObjectRef.element, floatValue5, floatValue6, floatValue7, floatValue8);
                return Unit.INSTANCE;
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            getCanvas().drawPath((CanvasPath) it.next(), canvasPaint2);
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            getCanvas().drawPath((CanvasPath) it2.next(), canvasPaint);
        }
        if (this.highlightLastItem) {
            highlightLastItem(arrayList);
        }
    }

    private final void drawLines() {
        forEachWithPrevAndNext(getPointData(), new Function3<IndexedValue<? extends PointEntry>, IndexedValue<? extends PointEntry>, IndexedValue<? extends PointEntry>, Unit>() { // from class: com.animaconnected.watch.graphs.LineChart$drawLines$1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(IndexedValue<? extends PointEntry> indexedValue, IndexedValue<? extends PointEntry> indexedValue2, IndexedValue<? extends PointEntry> indexedValue3) {
                invoke2((IndexedValue<PointEntry>) indexedValue, (IndexedValue<PointEntry>) indexedValue2, (IndexedValue<PointEntry>) indexedValue3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IndexedValue<PointEntry> indexedValue, IndexedValue<PointEntry> currentEntry, IndexedValue<PointEntry> indexedValue2) {
                float x;
                float y;
                float x2;
                float y2;
                ChartPaints chartPaints;
                float x3;
                float y3;
                float f;
                ChartPaints chartPaints2;
                PointEntry pointEntry;
                PointEntry pointEntry2;
                Intrinsics.checkNotNullParameter(currentEntry, "currentEntry");
                LineChartValue lineChartValue = null;
                LineChartValue lineChartValue2 = (indexedValue == null || (pointEntry2 = indexedValue.value) == null) ? null : pointEntry2.getLineChartValue();
                LineChartValue lineChartValue3 = currentEntry.value.getLineChartValue();
                if (indexedValue2 != null && (pointEntry = indexedValue2.value) != null) {
                    lineChartValue = pointEntry.getLineChartValue();
                }
                boolean z = lineChartValue2 instanceof Known;
                int r10 = currentEntry.index;
                if (!z && (lineChartValue3 instanceof Known) && !(lineChartValue instanceof Known)) {
                    Kanvas canvas = LineChart.this.getCanvas();
                    x3 = LineChart.this.getX(r10);
                    y3 = LineChart.this.getY(((Known) lineChartValue3).getValue());
                    f = LineChart.this.lineDotRadius;
                    chartPaints2 = LineChart.this.paints;
                    canvas.drawCircle(x3, y3, f, chartPaints2.getHighlightFill());
                    return;
                }
                if ((lineChartValue3 instanceof Known) && (lineChartValue instanceof Known)) {
                    Kanvas canvas2 = LineChart.this.getCanvas();
                    x = LineChart.this.getX(r10);
                    y = LineChart.this.getY(((Known) lineChartValue3).getValue());
                    x2 = LineChart.this.getX(indexedValue2.index);
                    y2 = LineChart.this.getY(((Known) lineChartValue).getValue());
                    chartPaints = LineChart.this.paints;
                    canvas2.drawLine(x, y, x2, y2, chartPaints.getHighlightStroke());
                }
            }
        });
    }

    private final void drawXAxis() {
        XAxisProperties.Style style = getX().getStyle();
        if (style instanceof XAxisProperties.Style.Timeline) {
            ChartDrawXAxisUtilsKt.drawTimeline(this, getUsableWidth(), this.paints);
            return;
        }
        if (style instanceof XAxisProperties.Style.DurationTimeline) {
            ChartDrawXAxisUtilsKt.drawDurationTimeline(this, this.paints.getLabel(), this.paints.getNormalFill());
            return;
        }
        if (style instanceof XAxisProperties.Style.Labels) {
            ChartDrawXAxisUtilsKt.drawXAxisLabels$default(this, getData(), this.paints, 0, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.LineChart$drawXAxis$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float x;
                    x = LineChart.this.getX(r2);
                    return Float.valueOf(x);
                }
            }, 4, null);
        } else if (style instanceof XAxisProperties.Style.LabelsStartEndSelected) {
            ChartDrawXAxisUtilsKt.drawXAxisLabelsStartEndSelected(this, getData(), this.paints, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.LineChart$drawXAxis$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float x;
                    x = LineChart.this.getX(r2);
                    return Float.valueOf(x);
                }
            });
        } else if (Intrinsics.areEqual(style, XAxisProperties.Style.NoLabels.INSTANCE)) {
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final <T, R> void forEachWithPrevAndNext(List<? extends T> list, Function3<? super IndexedValue<? extends T>, ? super IndexedValue<? extends T>, ? super IndexedValue<? extends T>, ? extends R> function3) {
        IndexedValue indexedValue;
        int r1 = 0;
        for (T t : list) {
            int r3 = r1 + 1;
            IndexedValue indexedValue2 = null;
            if (r1 >= 0) {
                int r5 = r1 - 1;
                Object orNull = CollectionsKt___CollectionsKt.getOrNull(r5, list);
                if (orNull != null) {
                    indexedValue = new IndexedValue(r5, orNull);
                } else {
                    indexedValue = null;
                }
                IndexedValue indexedValue3 = new IndexedValue(r1, t);
                Object orNull2 = CollectionsKt___CollectionsKt.getOrNull(r3, list);
                if (orNull2 != null) {
                    indexedValue2 = new IndexedValue(r3, orNull2);
                }
                function3.invoke(indexedValue, indexedValue3, indexedValue2);
                r1 = r3;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<PointEntry> getPointData() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final float getX(int r3) {
        return ChartDrawXAxisUtilsKt.getCircleRadius(getX()) + (getX().getTickSpace() * r3) + getX().getStartPosition().invoke().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getY(int r7) {
        return ChartUtilsKt.normalizeValueToYPos$default(this, r7, 0, 0, 6, null);
    }

    private final void highlightLastItem(List<? extends CanvasPath> list) {
        CanvasPath canvasPath;
        PointF currentPoint;
        ListIterator<? extends CanvasPath> listIterator = list.listIterator(list.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                canvasPath = listIterator.previous();
                if (!Intrinsics.areEqual(canvasPath.getCurrentPoint(), PointF.Companion.getZero())) {
                    break;
                }
            } else {
                canvasPath = null;
                break;
            }
        }
        CanvasPath canvasPath2 = canvasPath;
        if (canvasPath2 != null && (currentPoint = canvasPath2.getCurrentPoint()) != null) {
            getCanvas().drawCircle(currentPoint.getX(), currentPoint.getY(), this.highlightedCircleRadius, this.paints.getHighlightFill());
        }
    }

    private final void updateTimeLine() {
        String str;
        String xAxisLabel;
        if (getX().getStyle() instanceof XAxisProperties.Style.Timeline) {
            XAxisProperties x = getX();
            ChartEntry chartEntry = (ChartEntry) CollectionsKt___CollectionsKt.firstOrNull((List) getData());
            String str2 = "00:00";
            if (chartEntry == null || (str = chartEntry.getXAxisLabel()) == null) {
                str = "00:00";
            }
            ChartEntry chartEntry2 = (ChartEntry) CollectionsKt___CollectionsKt.lastOrNull(getData());
            if (chartEntry2 != null && (xAxisLabel = chartEntry2.getXAxisLabel()) != null) {
                str2 = xAxisLabel;
            }
            x.setStyle(new XAxisProperties.Style.Timeline(str, str2));
        }
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        int r1;
        boolean z;
        Known known;
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getImportant(), getPointData()));
        YAxisProperties.Limits invoke = getY().getCalculateMinMax().invoke(getPointData());
        int component1 = invoke.component1();
        int component2 = invoke.component2();
        YAxisScaleFormatter scaleFormatter = getY().getScaleFormatter();
        scaleFormatter.setMaxTicks(getY().getNbrOfGridLines());
        scaleFormatter.setFormatValue(getY().getConvertValueToLabel());
        scaleFormatter.setLowestValue(component1);
        scaleFormatter.setHighestValue(component2);
        scaleFormatter.setScaleType(YAxisScaleFormatter.ScaleType.AUTO);
        getY().setDataMaxValue(getY().getScaleFormatter().getRoundedHighestValue());
        getY().setDataMinValue(getY().getScaleFormatter().getRoundedLowestValue());
        getY().setDataAverageValue(getY().getCalculateAverageValue().invoke(getPointData()).intValue());
        YAxisProperties y = getY();
        List reversed = CollectionsKt___CollectionsKt.reversed(getPointData());
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(reversed, 10));
        Iterator it = reversed.iterator();
        while (it.hasNext()) {
            LineChartValue lineChartValue = ((PointEntry) it.next()).getLineChartValue();
            if (lineChartValue instanceof Known) {
                known = (Known) lineChartValue;
            } else {
                known = null;
            }
            arrayList.add(known);
        }
        Known known2 = (Known) CollectionsKt___CollectionsKt.firstOrNull((List) arrayList);
        if (known2 != null) {
            r1 = known2.getValue();
        } else {
            r1 = -1;
        }
        y.setDataLatestValue(r1);
        getY().setMaxLabelWidth(YAxisUtilsKt.yAxisMaxLabelWidth(this, this.paints));
        getY().setMaxLabelHeight(YAxisUtilsKt.yAxisMaxLabelHeight(this, this.paints));
        getX().setStartPosition(new Function0<Float>() { // from class: com.animaconnected.watch.graphs.LineChart$adaptChartToData$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float f;
                f = LineChart.this.markerPointCircleRadius;
                return Float.valueOf(f);
            }
        });
        setUsableWidth(ChartUtilsKt.calculateUsableWidth(this, this.paints));
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
        boolean z2 = false;
        int r2 = 1;
        if (getTitleText().invoke().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            setTitleTextHeight(this.paints.getTitle().measureHeight(getTitleText().invoke()));
        }
        if (getSubtitleText().invoke().length() > 0) {
            z2 = true;
        }
        if (z2) {
            setSubtitleTextHeight(this.paints.getSubtitle().measureHeight(getSubtitleText().invoke()));
        }
        XAxisProperties x = getX();
        float usableWidth = (getUsableWidth() - getX().getStartPosition().invoke().floatValue()) - ChartDrawXAxisUtilsKt.getCircleRadius(getX());
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(getData());
        if (lastIndex >= 1) {
            r2 = lastIndex;
        }
        x.setTickSpace(usableWidth / r2);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        boolean z;
        updateTimeLine();
        drawXAxis();
        ChartDrawUtilsKt.drawYAxis(this, this.paints);
        if (getShowNoDataText()) {
            ChartDrawUtilsKt.drawNoDataText(this, this.paints.getAverageHeading(), this.paints.getBackground());
        }
        if (getData().isEmpty()) {
            return;
        }
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.dataSetMode.ordinal()];
        boolean z2 = true;
        if (r0 != 1) {
            if (r0 == 2) {
                drawLines();
            }
        } else {
            drawCubicLines();
        }
        if (getTitleText().invoke().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (getSubtitleText().invoke().length() <= 0) {
                z2 = false;
            }
            if (!z2) {
                return;
            }
        }
        drawTitleSection(this.paints);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void drawTouchValue() {
        DetailMarkerView detailMarkerView;
        PointF touchPoint$graphics_release;
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release instanceof DetailMarkerView) {
            detailMarkerView = (DetailMarkerView) markerView$graphics_release;
        } else {
            detailMarkerView = null;
        }
        if (detailMarkerView == null || (touchPoint$graphics_release = getTouchListener$graphics_release().getTouchPoint$graphics_release()) == null) {
            return;
        }
        int floor = (int) Math.floor(touchPoint$graphics_release.getX() / getX().getTickSpace());
        PointEntry pointEntry = (PointEntry) CollectionsKt___CollectionsKt.getOrNull(floor, getPointData());
        if (pointEntry == null || !(pointEntry.getLineChartValue() instanceof Known)) {
            return;
        }
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(floor);
        float x = getX(floor);
        float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, ((Known) pointEntry.getLineChartValue()).getValue(), 0, 0, 6, null);
        String invoke = getY().getConvertValueToLabel().invoke(Integer.valueOf(((Known) pointEntry.getLineChartValue()).getValue()));
        String markerLabel = pointEntry.getMarkerLabel();
        detailMarkerView.setTouchEvent(getTouchListener$graphics_release().getCurrentEvent());
        detailMarkerView.setTouchPosition(getTouchListener$graphics_release().getTouchPoint$graphics_release());
        detailMarkerView.setXPos(x);
        detailMarkerView.setYPos(normalizeValueToYPos$default);
        detailMarkerView.setTitle(invoke);
        detailMarkerView.setSubtitle(markerLabel);
        detailMarkerView.setOuterBounds(getMainDrawingZone());
        detailMarkerView.draw();
        getCanvas().drawCircle(x, normalizeValueToYPos$default, this.markerPointCircleRadius, this.paints.getImportantFill());
        getCanvas().drawCircle(x, normalizeValueToYPos$default, this.markerPointCircleRadius - 1, this.paints.getNormalFill());
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

    public final boolean getHighlightLastItem() {
        return this.highlightLastItem;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public MarkerView getMarkerView$graphics_release() {
        return this.markerView;
    }

    public final boolean getShowEmptyLine() {
        return this.showEmptyLine;
    }

    public final boolean getShowSolidLineOnDashedLine() {
        return this.showSolidLineOnDashedLine;
    }

    public final void setHighlightLastItem(boolean z) {
        this.highlightLastItem = z;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void setMarkerView$graphics_release(MarkerView markerView) {
        this.markerView = markerView;
    }

    public final void setShowEmptyLine(boolean z) {
        this.showEmptyLine = z;
    }

    public final void setShowSolidLineOnDashedLine(boolean z) {
        this.showSolidLineOnDashedLine = z;
    }

    private static /* synthetic */ void getPointData$annotations() {
    }
}
