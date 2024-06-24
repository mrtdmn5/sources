package com.animaconnected.watch.graphs;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.CanvasPaint;
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
import com.animaconnected.watch.theme.SleepPaints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: StackedBarChart.kt */
/* loaded from: classes3.dex */
public final class StackedBarChart extends Chart {
    private float actualBarWidth;
    private float barTotalWidth;
    private final Kanvas canvas;
    private final ChartColors colors;
    private Function1<? super Integer, String> convertValueToMarkerTitle;
    private float cornerRadius;
    private final ChartFonts fonts;
    private MarkerView markerView;
    private float maxBarWidth;
    private float minSpacingBetweenBars;
    private final SleepPaints paints;

    /* compiled from: StackedBarChart.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[YAxisScaleFormatter.ScaleType.values().length];
            try {
                r0[YAxisScaleFormatter.ScaleType.CUSTOM_RANGES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[YAxisScaleFormatter.ScaleType.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public StackedBarChart(Kanvas canvas, ChartColors colors, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.colors = colors;
        this.fonts = fonts;
        this.paints = new SleepPaints(fonts, colors, getCanvas());
        this.markerView = new DetailMarkerView(fonts, colors, getCanvas());
        this.convertValueToMarkerTitle = new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.StackedBarChart$convertValueToMarkerTitle$1
            public final String invoke(int r1) {
                return "";
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }
        };
    }

    private final void calculateBarWidth() {
        float usableWidth = getUsableWidth();
        int size = getData().size();
        if (size < 1) {
            size = 1;
        }
        float f = usableWidth / size;
        this.barTotalWidth = f;
        float f2 = this.maxBarWidth;
        float f3 = this.minSpacingBetweenBars;
        if (f > f2 + f3) {
            this.actualBarWidth = f2;
        } else if (f3 >= f) {
            this.actualBarWidth = f * 0.5f;
        } else {
            this.actualBarWidth = f - f3;
        }
    }

    private final void drawStackedBarChart() {
        float f;
        int r3;
        CanvasPaint deepOtherDay;
        boolean z;
        CanvasPaint lightOtherDay;
        CanvasPaint normalFill;
        int touchIndex = getTouchIndex();
        int r4 = 0;
        for (Object obj : getStackedBarData()) {
            int r6 = r4 + 1;
            if (r4 >= 0) {
                StackedBarEntry stackedBarEntry = (StackedBarEntry) obj;
                Iterator<T> it = stackedBarEntry.getData().iterator();
                int r9 = 0;
                while (it.hasNext()) {
                    r9 += ((BarEntry) it.next()).getValue();
                }
                RectF backgroundRect = getBackgroundRect(r4, r9);
                boolean isSelected = stackedBarEntry.isSelected();
                float f2 = r9;
                if (f2 < 1.0f) {
                    SleepPaints sleepPaints = this.paints;
                    if (isSelected) {
                        normalFill = sleepPaints.getHighlightFill();
                    } else {
                        normalFill = sleepPaints.getNormalFill();
                    }
                    ChartDrawUtilsKt.drawDotForEmptyBar(this, backgroundRect, normalFill);
                } else {
                    List<BarEntry> data = stackedBarEntry.getData();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(data, 10));
                    Iterator<T> it2 = data.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(Float.valueOf(((BarEntry) it2.next()).getValue() / f2));
                    }
                    float f3 = 0.0f;
                    int r15 = 0;
                    for (Object obj2 : arrayList) {
                        int r21 = r15 + 1;
                        if (r15 >= 0) {
                            float floatValue = ((Number) obj2).floatValue();
                            if (r15 == 0) {
                                if (touchIndex == r4 && isSelected) {
                                    lightOtherDay = this.paints.getLightToday();
                                } else if (touchIndex == r4) {
                                    lightOtherDay = this.paints.getLightOtherDay();
                                } else if (touchIndex > -1 && isSelected) {
                                    lightOtherDay = this.paints.getLightInteractionToday();
                                } else if (touchIndex > -1) {
                                    lightOtherDay = this.paints.getLightInteractionOtherDay();
                                } else if (isSelected) {
                                    lightOtherDay = this.paints.getLightToday();
                                } else {
                                    lightOtherDay = this.paints.getLightOtherDay();
                                }
                                f = floatValue;
                                r3 = r15;
                                ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), backgroundRect, this.cornerRadius, false, false, false, false, lightOtherDay, 120, null);
                            } else {
                                f = floatValue;
                                r3 = r15;
                            }
                            if (r3 == 1) {
                                RectF foregroundRect = getForegroundRect(backgroundRect, f3, f);
                                if (touchIndex == r4 && isSelected) {
                                    deepOtherDay = this.paints.getDeepToday();
                                } else if (touchIndex == r4) {
                                    deepOtherDay = this.paints.getDeepOtherDay();
                                } else if (touchIndex > -1 && isSelected) {
                                    deepOtherDay = this.paints.getDeepInteractionToday();
                                } else if (touchIndex > -1) {
                                    deepOtherDay = this.paints.getDeepInteractionOtherDay();
                                } else if (isSelected) {
                                    deepOtherDay = this.paints.getDeepToday();
                                } else {
                                    deepOtherDay = this.paints.getDeepOtherDay();
                                }
                                CanvasPaint canvasPaint = deepOtherDay;
                                if (foregroundRect.getTop() <= backgroundRect.getTop() - this.cornerRadius) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                ChartDrawUtilsKt.drawRoundRectPath$default(getCanvas(), foregroundRect, this.cornerRadius, z, z, false, false, canvasPaint, 96, null);
                            }
                            f3 += f;
                            r15 = r21;
                        } else {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                            throw null;
                        }
                    }
                }
                r4 = r6;
            } else {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
                throw null;
            }
        }
    }

    private final void drawXAxis() {
        XAxisProperties.Style style = getX().getStyle();
        if (Intrinsics.areEqual(style, XAxisProperties.Style.Labels.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabels$default(this, getStackedBarData(), this.paints, 0, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.StackedBarChart$drawXAxis$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenterSegment;
                    xPosCenterSegment = StackedBarChart.this.getXPosCenterSegment(r2);
                    return Float.valueOf(xPosCenterSegment);
                }
            }, 4, null);
            return;
        }
        if (Intrinsics.areEqual(style, XAxisProperties.Style.LabelsStartEndSelected.INSTANCE)) {
            ChartDrawXAxisUtilsKt.drawXAxisLabelsStartEndSelected(this, getStackedBarData(), this.paints, new Function1<Integer, Float>() { // from class: com.animaconnected.watch.graphs.StackedBarChart$drawXAxis$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Float invoke(int r2) {
                    float xPosCenterSegment;
                    xPosCenterSegment = StackedBarChart.this.getXPosCenterSegment(r2);
                    return Float.valueOf(xPosCenterSegment);
                }
            });
            return;
        }
        if (style instanceof XAxisProperties.Style.Timeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.StackedBarChart$drawXAxis$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Style.TodayTimeline not supported.";
                }
            }, 7, (Object) null);
        } else if (style instanceof XAxisProperties.Style.DurationTimeline) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.graphs.StackedBarChart$drawXAxis$4
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

    private final RectF getBackgroundRect(int r9, int r10) {
        return new RectF(getXPosCenterSegment(r9) - (this.actualBarWidth * 0.5f), ChartUtilsKt.normalizeValueToYPos$default(this, r10, 0, 0, 6, null), (this.actualBarWidth * 0.5f) + getXPosCenterSegment(r9), getUsableHeight());
    }

    private final RectF getForegroundRect(RectF rectF, float f, float f2) {
        float left = rectF.getLeft();
        float right = rectF.getRight();
        float height = (rectF.getHeight() * f) + rectF.getTop();
        return new RectF(left, height, right, (rectF.getHeight() * f2) + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<StackedBarEntry> getStackedBarData() {
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

    private final int getTouchIndex() {
        if (getTouchListener$graphics_release().getTouchPoint$graphics_release() != null) {
            return (int) Math.floor(r0.getX() / getX().getTickSpace());
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getXPosCenterSegment(int r3) {
        float f = this.barTotalWidth;
        return (f * 0.5f) + (r3 * f);
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void adaptChartToData() {
        int r2;
        float usableWidth;
        getX().setLabelHeight(XAxisUtilsKt.measureXAxisLabelHeight(this, this.paints.getLabel(), getData()));
        YAxisScaleFormatter scaleFormatter = getY().getScaleFormatter();
        scaleFormatter.setFormatValue(getY().getConvertValueToLabel());
        scaleFormatter.setMaxTicks(getY().getNbrOfGridLines());
        int r1 = WhenMappings.$EnumSwitchMapping$0[scaleFormatter.getScaleType().ordinal()];
        if (r1 != 1) {
            if (r1 == 2) {
                YAxisProperties.Limits invoke = getY().getCalculateMinMax().invoke(getStackedBarData());
                int component1 = invoke.component1();
                int component2 = invoke.component2();
                scaleFormatter.setLowestValue(component1);
                scaleFormatter.setHighestValue(component2);
            }
        } else {
            List<IntRange> invoke2 = getY().getCalculateProvidedRanges().invoke(getStackedBarData());
            scaleFormatter.setCustomRanges(invoke2);
            IntRange intRange = (IntRange) CollectionsKt___CollectionsKt.firstOrNull((List) invoke2);
            int r3 = 0;
            if (intRange != null) {
                r2 = intRange.first;
            } else {
                r2 = 0;
            }
            scaleFormatter.setLowestValue(r2);
            IntRange intRange2 = (IntRange) CollectionsKt___CollectionsKt.lastOrNull(invoke2);
            if (intRange2 != null) {
                r3 = intRange2.last;
            }
            scaleFormatter.setHighestValue(r3);
        }
        getY().setDataMinValue(getY().getScaleFormatter().getRoundedLowestValue());
        getY().setDataMaxValue(getY().getScaleFormatter().getRoundedHighestValue());
        getY().setDataAverageValue(getY().getCalculateAverageValue().invoke(getStackedBarData()).intValue());
        getY().setMaxLabelWidth(YAxisUtilsKt.yAxisMaxLabelWidth(this, this.paints));
        getY().setMaxLabelHeight(YAxisUtilsKt.yAxisMaxLabelHeight(this, this.paints));
        setUsableWidth(ChartUtilsKt.calculateUsableWidth(this, this.paints));
        setUsableHeight(ChartUtilsKt.calculateUsableHeight(this));
        XAxisProperties x = getX();
        if (getData().isEmpty()) {
            usableWidth = 0.0f;
        } else {
            usableWidth = getUsableWidth() / getData().size();
        }
        x.setTickSpace(usableWidth);
        calculateBarWidth();
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void doDraw() {
        drawXAxis();
        ChartDrawUtilsKt.drawYAxis(this, this.paints);
        if (getShowNoDataText()) {
            ChartDrawUtilsKt.drawNoDataText(this, this.paints.getAverageHeading(), this.paints.getBackground());
        }
        if (getData().isEmpty()) {
            return;
        }
        drawStackedBarChart();
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
        int floor = (int) Math.floor(touchPoint$graphics_release.getX() / this.barTotalWidth);
        StackedBarEntry stackedBarEntry = (StackedBarEntry) CollectionsKt___CollectionsKt.getOrNull(floor, getStackedBarData());
        if (stackedBarEntry == null) {
            return;
        }
        Iterator<T> it = stackedBarEntry.getData().iterator();
        int r4 = 0;
        while (it.hasNext()) {
            r4 += ((BarEntry) it.next()).getValue();
        }
        getTouchListener$graphics_release().onTouchSelectedData$graphics_release(floor);
        RectF backgroundRect = getBackgroundRect(floor, r4);
        float centerX = backgroundRect.getCenterX();
        float top = backgroundRect.getTop();
        String invoke = this.convertValueToMarkerTitle.invoke(Integer.valueOf(r4));
        String markerLabel = stackedBarEntry.getMarkerLabel();
        detailMarkerView.setTouchEvent(getTouchListener$graphics_release().getCurrentEvent());
        detailMarkerView.setTouchPosition(getTouchListener$graphics_release().getTouchPoint$graphics_release());
        detailMarkerView.setXPos(centerX);
        detailMarkerView.setYPos(top);
        detailMarkerView.setPadding(0.0f);
        detailMarkerView.setTitle(invoke);
        detailMarkerView.setSubtitle(markerLabel);
        detailMarkerView.setOuterBounds(getMainDrawingZone());
        detailMarkerView.draw();
        if (r4 == 0) {
            ChartDrawUtilsKt.drawDotForEmptyBar(this, backgroundRect, this.paints.getImportantFill());
        }
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public Kanvas getCanvas() {
        return this.canvas;
    }

    public final ChartColors getColors() {
        return this.colors;
    }

    public final Function1<Integer, String> getConvertValueToMarkerTitle() {
        return this.convertValueToMarkerTitle;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public MarkerView getMarkerView$graphics_release() {
        return this.markerView;
    }

    public final float getMaxBarWidth() {
        return this.maxBarWidth;
    }

    public final float getMinSpacingBetweenBars() {
        return this.minSpacingBetweenBars;
    }

    public final void setConvertValueToMarkerTitle(Function1<? super Integer, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.convertValueToMarkerTitle = function1;
    }

    public final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    @Override // com.animaconnected.watch.graphs.Chart
    public void setMarkerView$graphics_release(MarkerView markerView) {
        this.markerView = markerView;
    }

    public final void setMaxBarWidth(float f) {
        this.maxBarWidth = f;
    }

    public final void setMinSpacingBetweenBars(float f) {
        this.minSpacingBetweenBars = f;
    }

    private static /* synthetic */ void getStackedBarData$annotations() {
    }
}
