package com.animaconnected.watch.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.CanvasPath;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
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
import com.animaconnected.watch.theme.Vo2MaxPaints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: Vo2MaxHistoryChart.kt */
/* loaded from: classes3.dex */
public final class Vo2MaxHistoryChart extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private float dataDotRadius;
    private final ChartFonts fonts;
    private final float markerPointCircleRadius;
    private MarkerView markerView;
    private final Vo2MaxPaints paints;

    public Vo2MaxHistoryChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.paints = new Vo2MaxPaints(fonts, colors, getCanvas());
        this.markerView = new DetailMarkerView(fonts, colors, getCanvas());
        this.dataDotRadius = 3.0f;
        this.markerPointCircleRadius = 4.0f;
    }

    private final Pair<Integer, PointEntry> closestDataPointWithIndex(float f) {
        boolean z;
        float tickSpace = getX().getTickSpace();
        float floatValue = f - getX().getStartPosition().invoke().floatValue();
        if (floatValue < 0.0f) {
            floatValue = 0.0f;
        }
        int r3 = 0;
        for (Object obj : getPointData()) {
            int r6 = r3 + 1;
            if (r3 >= 0) {
                PointEntry pointEntry = (PointEntry) obj;
                float f2 = r3 * tickSpace;
                float f3 = f2 + tickSpace;
                if (f2 <= floatValue && floatValue <= f3) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return new Pair<>(Integer.valueOf(r3), pointEntry);
                }
                r3 = r6;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void drawColorRectangles(List<Pair<String, IntRange>> list) {
        int r0 = 0;
        for (Object obj : list) {
            int r2 = r0 + 1;
            CanvasPaint canvasPaint = null;
            if (r0 >= 0) {
                IntRange intRange = (IntRange) ((Pair) obj).second;
                RectF rectF = new RectF(getX().getStartPosition().invoke().floatValue(), ChartUtilsKt.normalizeValueToYPos$default(this, intRange.last, 0, 0, 6, null), getUsableWidth(), ChartUtilsKt.normalizeValueToYPos$default(this, intRange.first, 0, 0, 6, null));
                if (r0 != 0) {
                    if (r0 != 1) {
                        if (r0 != 2) {
                            if (r0 != 3) {
                                if (r0 == 4) {
                                    canvasPaint = this.paints.getSuperior();
                                }
                            } else {
                                canvasPaint = this.paints.getExcellent();
                            }
                        } else {
                            canvasPaint = this.paints.getGood();
                        }
                    } else {
                        canvasPaint = this.paints.getFair();
                    }
                } else {
                    canvasPaint = this.paints.getPoor();
                }
                CanvasPaint canvasPaint2 = canvasPaint;
                if (canvasPaint2 != null) {
                    getCanvas().drawRect(rectF.getLeft(), rectF.getTop(), rectF.getRight(), rectF.getBottom(), canvasPaint2);
                }
                r0 = r2;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    private final void drawLineChart() {
        int r1;
        boolean z;
        Known known;
        CanvasPath createPath = getCanvas().createPath();
        List<PointEntry> pointData = getPointData();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(pointData, 10));
        Iterator<T> it = pointData.iterator();
        int r3 = 0;
        while (true) {
            Integer num = null;
            if (it.hasNext()) {
                Object next = it.next();
                int r7 = r3 + 1;
                if (r3 >= 0) {
                    arrayList.add(new Pair(Integer.valueOf(r3), (PointEntry) next));
                    r3 = r7;
                } else {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                    throw null;
                }
            } else {
                Map map = MapsKt__MapsKt.toMap(arrayList);
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    LineChartValue lineChartValue = ((PointEntry) entry.getValue()).getLineChartValue();
                    if (lineChartValue instanceof Known) {
                        known = (Known) lineChartValue;
                    } else {
                        known = null;
                    }
                    linkedHashMap.put(key, known);
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    if (entry2.getValue() != null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                Iterator it2 = linkedHashMap2.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Integer num2 = (Integer) ((Map.Entry) it2.next()).getKey();
                    if (num2 != null) {
                        num = num2;
                        break;
                    }
                }
                if (num != null) {
                    r1 = num.intValue();
                } else {
                    r1 = -1;
                }
                int r15 = r1;
                for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                    int intValue = ((Number) entry3.getKey()).intValue();
                    float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, Math.min(getY().getDataMaxValue(), Math.max(getY().getDataMinValue(), ((Known) entry3.getValue()).getValue())), 0, 0, 6, null);
                    float xPosCenter = getXPosCenter(intValue);
                    if (intValue == r15) {
                        createPath.moveTo(xPosCenter, normalizeValueToYPos$default);
                    } else {
                        PointF currentPoint = createPath.getCurrentPoint();
                        float f = 2;
                        PointF pointF = new PointF((currentPoint.getX() + xPosCenter) / f, currentPoint.getY());
                        PointF pointF2 = new PointF((currentPoint.getX() + xPosCenter) / f, normalizeValueToYPos$default);
                        createPath.cubicTo(pointF.getX(), pointF.getY(), pointF2.getX(), pointF2.getY(), xPosCenter, normalizeValueToYPos$default);
                    }
                    getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default, this.dataDotRadius, this.paints.getHighlightFill());
                }
                getCanvas().drawPath(createPath, this.paints.getHighlightStroke());
                return;
            }
        }
    }

    private final void drawXAxis() {
        XAxisProperties.Style style = getX().getStyle();
        if (Intrinsics.areEqual(style, XAxisProperties.Style.Labels.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabels$default(this, getPointData(), this.paints, 0, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$drawXAxis$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenter;
                    xPosCenter = Vo2MaxHistoryChart.this.getXPosCenter(r2);
                    return Float.valueOf(xPosCenter);
                }
            }, 4, null);
            return;
        }
        if (Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabelsStartEndSelected(this, getPointData(), this.paints, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$drawXAxis$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenter;
                    xPosCenter = Vo2MaxHistoryChart.this.getXPosCenter(r2);
                    return Float.valueOf(xPosCenter);
                }
            });
            return;
        }
        if (style instanceof XAxisProperties.Style.Timeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$drawXAxis$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Style.TodayTimeline not supported.";
                }
            }, 7, (Object) null);
        } else if (style instanceof XAxisProperties.Style.DurationTimeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$drawXAxis$4
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

    private final List<PointEntry> getPointData() {
        List<ChartEntry> data = getData();
        if (!(data instanceof List)) {
            data = null;
        }
        if (data != null) {
            List<ChartEntry> list = data;
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PointEntry pointEntry = (PointEntry) it.next();
                if (!(pointEntry.getLineChartValue() instanceof Known)) {
                    pointEntry = new PointEntry((LineChartValue) None.INSTANCE, pointEntry.getXAxisLabel(), (String) null, false, 12, (DefaultConstructorMarker) null);
                }
                arrayList.add(pointEntry);
            }
            return arrayList;
        }
        return EmptyList.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getXPosCenter(int r3) {
        return getX().getStartPosition().invoke().floatValue() + (getX().getTickSpace() * r3) + (getX().getTickSpace() * 0.5f);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        final YAxisProperties.Style.DualAxes dualAxes;
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getLabel(), getData()));
        getX().setStartPosition(new Function0<Float>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$adaptChartToData$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                float f;
                f = Vo2MaxHistoryChart.this.markerPointCircleRadius;
                return Float.valueOf(f);
            }
        });
        YAxisScaleFormatter scaleFormatter = getY().getScaleFormatter();
        scaleFormatter.setHighestValue(getY().getDataMaxValue());
        scaleFormatter.setLowestValue(getY().getDataMinValue());
        scaleFormatter.setMaxTicks(getY().getNbrOfGridLines());
        scaleFormatter.setFormatValue(getY().getConvertValueToLabel());
        getY().setMaxLabelWidth(YAxisUtilsKt.yAxisMaxLabelWidth(this, this.paints));
        getY().setMaxLabelHeight(YAxisUtilsKt.yAxisMaxLabelHeight(this, this.paints));
        setUsableWidth(ChartUtilsKt.calculateUsableWidth(this, this.paints));
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
        YAxisProperties.Style style = getY().getStyle();
        if (style instanceof YAxisProperties.Style.DualAxes) {
            dualAxes = (YAxisProperties.Style.DualAxes) style;
        } else {
            dualAxes = null;
        }
        if (dualAxes != null) {
            getX().setStartPosition(new Function0<Float>() { // from class: com.animaconnected.watch.graphs.Vo2MaxHistoryChart$adaptChartToData$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    Float valueOf;
                    Vo2MaxPaints vo2MaxPaints;
                    List<Pair<String, IntRange>> entriesLeftAxis = YAxisProperties.Style.DualAxes.this.getEntriesLeftAxis();
                    Vo2MaxHistoryChart vo2MaxHistoryChart = this;
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(entriesLeftAxis, 10));
                    Iterator<T> it = entriesLeftAxis.iterator();
                    while (it.hasNext()) {
                        String str = (String) ((Pair) it.next()).first;
                        vo2MaxPaints = vo2MaxHistoryChart.paints;
                        arrayList.add(Float.valueOf(vo2MaxPaints.getLabel().measureHeight(str)));
                    }
                    Iterator it2 = arrayList.iterator();
                    if (it2.hasNext()) {
                        float floatValue = ((Number) it2.next()).floatValue();
                        while (it2.hasNext()) {
                            floatValue = Math.max(floatValue, ((Number) it2.next()).floatValue());
                        }
                        valueOf = Float.valueOf(floatValue);
                    } else {
                        valueOf = null;
                    }
                    return Float.valueOf((valueOf != null ? valueOf.floatValue() : 0.0f) + this.getY().getLabelMargin());
                }
            });
        }
        XAxisProperties x = getX();
        float usableWidth = getUsableWidth() - getX().getStartPosition().invoke().floatValue();
        int size = getData().size();
        if (size < 1) {
            size = 1;
        }
        x.setTickSpace(usableWidth / size);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        YAxisProperties.Style.DualAxes dualAxes;
        if (getData().isEmpty()) {
            return;
        }
        drawXAxis();
        ChartDrawUtilsKt.drawYAxis(this, this.paints);
        YAxisProperties.Style style = getY().getStyle();
        if (style instanceof YAxisProperties.Style.DualAxes) {
            dualAxes = (YAxisProperties.Style.DualAxes) style;
        } else {
            dualAxes = null;
        }
        if (dualAxes != null) {
            drawColorRectangles(dualAxes.getEntriesLeftAxis());
        }
        drawLineChart();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void drawTouchValue() {
        DetailMarkerView detailMarkerView;
        PointF touchPoint$graphics_release;
        Pair<Integer, PointEntry> closestDataPointWithIndex;
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release instanceof DetailMarkerView) {
            detailMarkerView = (DetailMarkerView) markerView$graphics_release;
        } else {
            detailMarkerView = null;
        }
        if (detailMarkerView == null || (touchPoint$graphics_release = getTouchListener$graphics_release().getTouchPoint$graphics_release()) == null || (closestDataPointWithIndex = closestDataPointWithIndex(touchPoint$graphics_release.getX())) == null) {
            return;
        }
        int intValue = closestDataPointWithIndex.first.intValue();
        PointEntry pointEntry = closestDataPointWithIndex.second;
        if (!(pointEntry.getLineChartValue() instanceof Known)) {
            return;
        }
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(intValue);
        float xPosCenter = getXPosCenter(intValue);
        float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, ((Known) pointEntry.getLineChartValue()).getValue(), 0, 0, 6, null);
        String invoke = getY().getConvertValueToLabel().invoke(Integer.valueOf(((Known) pointEntry.getLineChartValue()).getValue()));
        String markerLabel = pointEntry.getMarkerLabel();
        detailMarkerView.setTouchEvent(getTouchListener$graphics_release().getCurrentEvent());
        detailMarkerView.setTouchPosition(getTouchListener$graphics_release().getTouchPoint$graphics_release());
        detailMarkerView.setXPos(xPosCenter);
        detailMarkerView.setYPos(normalizeValueToYPos$default);
        detailMarkerView.setTitle(invoke);
        detailMarkerView.setSubtitle(markerLabel);
        detailMarkerView.setOuterBounds(getMainDrawingZone());
        detailMarkerView.draw();
        getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default, this.markerPointCircleRadius, this.paints.getImportantFill());
        getCanvas().drawCircle(xPosCenter, normalizeValueToYPos$default, this.markerPointCircleRadius - 1, this.paints.getNormalFill());
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

    private static /* synthetic */ void getPointData$annotations() {
    }
}
