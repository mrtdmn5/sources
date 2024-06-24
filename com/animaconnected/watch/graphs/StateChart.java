package com.animaconnected.watch.graphs;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
import com.animaconnected.watch.graphs.StateChart;
import com.animaconnected.watch.graphs.utils.ChartDrawUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartDrawXAxisUtilsKt;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.graphs.utils.XAxisUtilsKt;
import com.animaconnected.watch.theme.ChartColors;
import com.animaconnected.watch.theme.ChartFonts;
import com.animaconnected.watch.theme.SleepPaints;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: StateChart.kt */
/* loaded from: classes3.dex */
public final class StateChart extends Chart {
    private final Kanvas canvas;
    private final ChartColors colors;
    private List<DataHorizontalLine> dataHorizontalLines;
    private final ChartFonts fonts;
    private final float markerPointCircleRadius;
    private MarkerView markerView;
    private final CanvasPaint paintAwakeSleep;
    private final CanvasPaint paintDeepSleep;
    private final CanvasPaint paintLightSleep;
    private final float paintThickness;
    private final SleepPaints paints;

    /* compiled from: StateChart.kt */
    /* loaded from: classes3.dex */
    public static final class DataHorizontalLine {
        private final StateEntry endEntry;
        private final float endX;
        private final StateEntry startEntry;
        private final float startX;
        private final float yPos;

        public DataHorizontalLine(float f, float f2, float f3, StateEntry startEntry, StateEntry endEntry) {
            Intrinsics.checkNotNullParameter(startEntry, "startEntry");
            Intrinsics.checkNotNullParameter(endEntry, "endEntry");
            this.startX = f;
            this.endX = f2;
            this.yPos = f3;
            this.startEntry = startEntry;
            this.endEntry = endEntry;
        }

        public static /* synthetic */ DataHorizontalLine copy$default(DataHorizontalLine dataHorizontalLine, float f, float f2, float f3, StateEntry stateEntry, StateEntry stateEntry2, int r9, Object obj) {
            if ((r9 & 1) != 0) {
                f = dataHorizontalLine.startX;
            }
            if ((r9 & 2) != 0) {
                f2 = dataHorizontalLine.endX;
            }
            float f4 = f2;
            if ((r9 & 4) != 0) {
                f3 = dataHorizontalLine.yPos;
            }
            float f5 = f3;
            if ((r9 & 8) != 0) {
                stateEntry = dataHorizontalLine.startEntry;
            }
            StateEntry stateEntry3 = stateEntry;
            if ((r9 & 16) != 0) {
                stateEntry2 = dataHorizontalLine.endEntry;
            }
            return dataHorizontalLine.copy(f, f4, f5, stateEntry3, stateEntry2);
        }

        public final float component1() {
            return this.startX;
        }

        public final float component2() {
            return this.endX;
        }

        public final float component3() {
            return this.yPos;
        }

        public final StateEntry component4() {
            return this.startEntry;
        }

        public final StateEntry component5() {
            return this.endEntry;
        }

        public final DataHorizontalLine copy(float f, float f2, float f3, StateEntry startEntry, StateEntry endEntry) {
            Intrinsics.checkNotNullParameter(startEntry, "startEntry");
            Intrinsics.checkNotNullParameter(endEntry, "endEntry");
            return new DataHorizontalLine(f, f2, f3, startEntry, endEntry);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DataHorizontalLine)) {
                return false;
            }
            DataHorizontalLine dataHorizontalLine = (DataHorizontalLine) obj;
            if (Float.compare(this.startX, dataHorizontalLine.startX) == 0 && Float.compare(this.endX, dataHorizontalLine.endX) == 0 && Float.compare(this.yPos, dataHorizontalLine.yPos) == 0 && Intrinsics.areEqual(this.startEntry, dataHorizontalLine.startEntry) && Intrinsics.areEqual(this.endEntry, dataHorizontalLine.endEntry)) {
                return true;
            }
            return false;
        }

        public final float getCenterX() {
            float f = this.startX;
            return ((this.endX - f) / 2.0f) + f;
        }

        public final StateEntry getEndEntry() {
            return this.endEntry;
        }

        public final float getEndX() {
            return this.endX;
        }

        public final StateEntry getStartEntry() {
            return this.startEntry;
        }

        public final float getStartX() {
            return this.startX;
        }

        public final float getYPos() {
            return this.yPos;
        }

        public int hashCode() {
            return this.endEntry.hashCode() + ((this.startEntry.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.yPos, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.endX, Float.hashCode(this.startX) * 31, 31), 31)) * 31);
        }

        public String toString() {
            return "DataHorizontalLine(startX=" + this.startX + ", endX=" + this.endX + ", yPos=" + this.yPos + ", startEntry=" + this.startEntry + ", endEntry=" + this.endEntry + ')';
        }
    }

    /* compiled from: StateChart.kt */
    /* loaded from: classes3.dex */
    public static final class VerticalLine {
        private final CanvasPaint paint;
        private final float startY;
        private final float stopY;

        public VerticalLine(float f, float f2, CanvasPaint paint) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            this.startY = f;
            this.stopY = f2;
            this.paint = paint;
        }

        public static /* synthetic */ VerticalLine copy$default(VerticalLine verticalLine, float f, float f2, CanvasPaint canvasPaint, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                f = verticalLine.startY;
            }
            if ((r4 & 2) != 0) {
                f2 = verticalLine.stopY;
            }
            if ((r4 & 4) != 0) {
                canvasPaint = verticalLine.paint;
            }
            return verticalLine.copy(f, f2, canvasPaint);
        }

        public final float component1() {
            return this.startY;
        }

        public final float component2() {
            return this.stopY;
        }

        public final CanvasPaint component3() {
            return this.paint;
        }

        public final VerticalLine copy(float f, float f2, CanvasPaint paint) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            return new VerticalLine(f, f2, paint);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerticalLine)) {
                return false;
            }
            VerticalLine verticalLine = (VerticalLine) obj;
            if (Float.compare(this.startY, verticalLine.startY) == 0 && Float.compare(this.stopY, verticalLine.stopY) == 0 && Intrinsics.areEqual(this.paint, verticalLine.paint)) {
                return true;
            }
            return false;
        }

        public final CanvasPaint getPaint() {
            return this.paint;
        }

        public final float getStartY() {
            return this.startY;
        }

        public final float getStopY() {
            return this.stopY;
        }

        public int hashCode() {
            return this.paint.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.stopY, Float.hashCode(this.startY) * 31, 31);
        }

        public String toString() {
            return "VerticalLine(startY=" + this.startY + ", stopY=" + this.stopY + ", paint=" + this.paint + ')';
        }
    }

    public StateChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.paintThickness = 2.0f;
        this.paintAwakeSleep = Kanvas.createColorPaint$default(getCanvas(), colors.getSleepChartAwake(), false, 2.0f, null, 10, null);
        this.paintLightSleep = Kanvas.createColorPaint$default(getCanvas(), colors.getSleepChartLight(), false, 2.0f, null, 10, null);
        this.paintDeepSleep = Kanvas.createColorPaint$default(getCanvas(), colors.getSleepChartDeep(), false, 2.0f, null, 10, null);
        this.markerPointCircleRadius = 4.0f;
        this.markerView = new DetailMarkerView(fonts, colors, getCanvas());
        this.paints = new SleepPaints(fonts, colors, getCanvas());
        this.dataHorizontalLines = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Pair<Integer, DataHorizontalLine> closestDataHorizontalLineWithIndex(float f) {
        int r2;
        DataHorizontalLine dataHorizontalLine;
        boolean z;
        Iterator it = CollectionsKt___CollectionsKt.withIndex(this.dataHorizontalLines).iterator();
        do {
            IndexingIterator indexingIterator = (IndexingIterator) it;
            if (indexingIterator.hasNext()) {
                IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                r2 = indexedValue.index;
                dataHorizontalLine = (DataHorizontalLine) indexedValue.value;
                float startX = dataHorizontalLine.getStartX();
                if (f <= dataHorizontalLine.getEndX() && startX <= f) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                return null;
            }
        } while (!z);
        return new Pair<>(Integer.valueOf(r2), dataHorizontalLine);
    }

    private final void drawStateChart() {
        if (getStateEntries().size() <= 3) {
            return;
        }
        final long timestamp = ((StateEntry) CollectionsKt___CollectionsKt.first((List) getStateEntries())).getTimestamp();
        final long timestamp2 = ((StateEntry) CollectionsKt___CollectionsKt.last(getStateEntries())).getTimestamp();
        this.dataHorizontalLines.clear();
        CollectionsKt___CollectionsKt.windowed$default(getStateEntries(), 2, 0, new Function1<List<? extends StateEntry>, Unit>() { // from class: com.animaconnected.watch.graphs.StateChart$drawStateChart$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends StateEntry> list) {
                invoke2((List<StateEntry>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<StateEntry> list) {
                List<StateChart.VerticalLine> verticalLines;
                float f;
                CanvasPaint paintForState;
                List list2;
                Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                StateEntry stateEntry = list.get(0);
                StateEntry stateEntry2 = list.get(1);
                PointF pointF = new PointF(ChartUtilsKt.normalizeValueToXPos(StateChart.this, stateEntry.getTimestamp(), timestamp, timestamp2), ChartUtilsKt.normalizeValueToYPos$default(StateChart.this, stateEntry.getState(), 0, 0, 6, null));
                PointF pointF2 = new PointF(ChartUtilsKt.normalizeValueToXPos(StateChart.this, stateEntry2.getTimestamp(), timestamp, timestamp2), ChartUtilsKt.normalizeValueToYPos$default(StateChart.this, stateEntry.getState(), 0, 0, 6, null));
                if (!(pointF2.getX() - pointF.getX() == 0.0f)) {
                    f = StateChart.this.paintThickness;
                    Kanvas canvas = StateChart.this.getCanvas();
                    float f2 = (int) (f / 2);
                    float x = pointF.getX() - f2;
                    float y = pointF.getY();
                    float x2 = pointF2.getX() + f2;
                    float y2 = pointF.getY();
                    paintForState = StateChart.this.getPaintForState(stateEntry.getState());
                    canvas.drawLine(x, y, x2, y2, paintForState);
                    list2 = StateChart.this.dataHorizontalLines;
                    list2.add(new StateChart.DataHorizontalLine(pointF.getX(), pointF2.getX(), pointF.getY(), stateEntry, stateEntry2));
                }
                verticalLines = StateChart.this.getVerticalLines(stateEntry.getState(), stateEntry2.getState());
                StateChart stateChart = StateChart.this;
                for (StateChart.VerticalLine verticalLine : verticalLines) {
                    stateChart.getCanvas().drawLine(pointF2.getX(), verticalLine.getStartY(), pointF2.getX(), verticalLine.getStopY(), verticalLine.getPaint());
                }
            }
        }, 6);
    }

    private final void drawYAxis() {
        List<StateEntry> stateEntries = getStateEntries();
        HashSet hashSet = new HashSet();
        ArrayList<StateEntry> arrayList = new ArrayList();
        for (Object obj : stateEntries) {
            if (hashSet.add(((StateEntry) obj).getYAxisLabel())) {
                arrayList.add(obj);
            }
        }
        for (StateEntry stateEntry : arrayList) {
            float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(this, stateEntry.getState(), 0, 0, 6, null);
            Kanvas.drawText$default(getCanvas(), stateEntry.getYAxisLabel(), getUsableWidth() + getY().getLabelMargin(), normalizeValueToYPos$default, 0.0f, null, this.paints.getLabel(), 24, null);
            ChartDrawUtilsKt.drawHorizontalDashedLine(this, normalizeValueToYPos$default, getUsableWidth(), this.paints.getGridLine(), 4.0f, 4.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CanvasPaint getPaintForState(final int r9) {
        if (r9 != 1) {
            if (r9 != 2) {
                if (r9 != 3) {
                    LogKt.warn$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.StateChart$getPaintForState$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return ConstraintWidget$$ExternalSyntheticOutline0.m(new StringBuilder("State "), r9, " is not supported, only state 1-3 is supported.");
                        }
                    }, 7, (Object) null);
                    return this.paintDeepSleep;
                }
                return this.paintAwakeSleep;
            }
            return this.paintLightSleep;
        }
        return this.paintDeepSleep;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<StateEntry> getStateEntries() {
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
    public final List<VerticalLine> getVerticalLines(int r5, int r6) {
        IntProgression upTo;
        if (r5 != r6 && r5 >= 0 && r6 >= 0) {
            final ArrayList arrayList = new ArrayList();
            if (r5 > r6) {
                upTo = new IntProgression(r5, r6, -1);
            } else {
                upTo = upTo(r5, r6);
            }
            CollectionsKt___CollectionsKt.windowed$default(upTo, 2, 0, new Function1<List<? extends Integer>, Boolean>() { // from class: com.animaconnected.watch.graphs.StateChart$getVerticalLines$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Boolean invoke2(List<Integer> list) {
                    CanvasPaint paintForState;
                    CanvasPaint paintForState2;
                    Intrinsics.checkNotNullParameter(list, "<name for destructuring parameter 0>");
                    int intValue = list.get(0).intValue();
                    int intValue2 = list.get(1).intValue();
                    float normalizeValueToYPos$default = ChartUtilsKt.normalizeValueToYPos$default(StateChart.this, intValue, 0, 0, 6, null);
                    float normalizeValueToYPos$default2 = (ChartUtilsKt.normalizeValueToYPos$default(StateChart.this, intValue2, 0, 0, 6, null) - normalizeValueToYPos$default) / 2;
                    float coerceIn = RangesKt___RangesKt.coerceIn(normalizeValueToYPos$default + normalizeValueToYPos$default2, StateChart.this.getMainDrawingZone().getTop(), StateChart.this.getMainDrawingZone().getBottom());
                    float coerceIn2 = RangesKt___RangesKt.coerceIn(normalizeValueToYPos$default2 + coerceIn, StateChart.this.getMainDrawingZone().getTop(), StateChart.this.getMainDrawingZone().getBottom());
                    List<StateChart.VerticalLine> list2 = arrayList;
                    paintForState = StateChart.this.getPaintForState(intValue);
                    list2.add(new StateChart.VerticalLine(normalizeValueToYPos$default, coerceIn, paintForState));
                    List<StateChart.VerticalLine> list3 = arrayList;
                    paintForState2 = StateChart.this.getPaintForState(intValue2);
                    return Boolean.valueOf(list3.add(new StateChart.VerticalLine(coerceIn, coerceIn2, paintForState2)));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Boolean invoke(List<? extends Integer> list) {
                    return invoke2((List<Integer>) list);
                }
            }, 6);
            return arrayList;
        }
        return EmptyList.INSTANCE;
    }

    private final IntProgression upTo(int r3, int r4) {
        return new IntProgression(r3, r4, 1);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        Float valueOf;
        float f;
        Float valueOf2;
        Integer valueOf3;
        int r2;
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getLabel(), getData()));
        YAxisProperties y = getY();
        Iterator<T> it = getStateEntries().iterator();
        Integer num = null;
        if (!it.hasNext()) {
            valueOf = null;
        } else {
            float measureWidth = this.paints.getLabel().measureWidth(((StateEntry) it.next()).getYAxisLabel());
            while (it.hasNext()) {
                measureWidth = Math.max(measureWidth, this.paints.getLabel().measureWidth(((StateEntry) it.next()).getYAxisLabel()));
            }
            valueOf = Float.valueOf(measureWidth);
        }
        float f2 = 0.0f;
        if (valueOf != null) {
            f = valueOf.floatValue();
        } else {
            f = 0.0f;
        }
        y.setMaxLabelWidth(f);
        YAxisProperties y2 = getY();
        Iterator<T> it2 = getStateEntries().iterator();
        if (!it2.hasNext()) {
            valueOf2 = null;
        } else {
            float measureHeight = this.paints.getLabel().measureHeight(((StateEntry) it2.next()).getYAxisLabel());
            while (it2.hasNext()) {
                measureHeight = Math.max(measureHeight, this.paints.getLabel().measureHeight(((StateEntry) it2.next()).getYAxisLabel()));
            }
            valueOf2 = Float.valueOf(measureHeight);
        }
        if (valueOf2 != null) {
            f2 = valueOf2.floatValue();
        }
        y2.setMaxLabelHeight(f2);
        YAxisProperties y3 = getY();
        Iterator<T> it3 = getStateEntries().iterator();
        if (!it3.hasNext()) {
            valueOf3 = null;
        } else {
            valueOf3 = Integer.valueOf(((StateEntry) it3.next()).getState());
            while (it3.hasNext()) {
                Integer valueOf4 = Integer.valueOf(((StateEntry) it3.next()).getState());
                if (valueOf3.compareTo(valueOf4) < 0) {
                    valueOf3 = valueOf4;
                }
            }
        }
        Integer num2 = valueOf3;
        int r1 = 0;
        if (num2 != null) {
            r2 = num2.intValue();
        } else {
            r2 = 0;
        }
        y3.setDataMaxValue(r2);
        YAxisProperties y4 = getY();
        Iterator<T> it4 = getStateEntries().iterator();
        if (it4.hasNext()) {
            num = Integer.valueOf(((StateEntry) it4.next()).getState());
            while (it4.hasNext()) {
                Integer valueOf5 = Integer.valueOf(((StateEntry) it4.next()).getState());
                if (num.compareTo(valueOf5) > 0) {
                    num = valueOf5;
                }
            }
        }
        Integer num3 = num;
        if (num3 != null) {
            r1 = num3.intValue();
        }
        y4.setDataMinValue(r1);
        setUsableWidth((getWidth() - getY().getMaxLabelWidth()) - getY().getLabelMargin());
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        drawYAxis();
        ChartDrawXAxisUtilsKt.drawDurationTimeline(this, this.paints.getLabel(), this.paints.getNormalFill());
        if (getShowNoDataText()) {
            ChartDrawUtilsKt.drawNoDataText(this, this.paints.getAverageHeading(), this.paints.getBackground());
        }
        if (getData().isEmpty()) {
            return;
        }
        drawStateChart();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void drawTouchValue() {
        DetailMarkerView detailMarkerView;
        PointF touchPoint$graphics_release;
        Pair<Integer, DataHorizontalLine> closestDataHorizontalLineWithIndex;
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release instanceof DetailMarkerView) {
            detailMarkerView = (DetailMarkerView) markerView$graphics_release;
        } else {
            detailMarkerView = null;
        }
        if (detailMarkerView == null || (touchPoint$graphics_release = getTouchListener$graphics_release().getTouchPoint$graphics_release()) == null || (closestDataHorizontalLineWithIndex = closestDataHorizontalLineWithIndex(touchPoint$graphics_release.getX())) == null) {
            return;
        }
        int intValue = closestDataHorizontalLineWithIndex.first.intValue();
        DataHorizontalLine dataHorizontalLine = closestDataHorizontalLineWithIndex.second;
        float centerX = dataHorizontalLine.getCenterX();
        float yPos = dataHorizontalLine.getYPos();
        String yAxisLabel = dataHorizontalLine.getStartEntry().getYAxisLabel();
        String str = dataHorizontalLine.getStartEntry().getMarkerLabel() + " - " + dataHorizontalLine.getEndEntry().getMarkerLabel();
        detailMarkerView.setXPos(centerX);
        detailMarkerView.setYPos(yPos);
        detailMarkerView.setTitle(yAxisLabel);
        detailMarkerView.setSubtitle(str);
        detailMarkerView.setOuterBounds(getMainDrawingZone());
        detailMarkerView.draw();
        getCanvas().drawCircle(centerX, yPos, this.markerPointCircleRadius, this.paints.getImportantFill());
        getCanvas().drawCircle(centerX, yPos, this.markerPointCircleRadius - 1, this.paints.getNormalFill());
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(intValue);
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

    private static /* synthetic */ void getStateEntries$annotations() {
    }
}
