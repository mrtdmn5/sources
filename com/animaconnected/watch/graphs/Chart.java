package com.animaconnected.watch.graphs;

import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.RectF;
import com.animaconnected.watch.graphs.TouchListener;
import com.animaconnected.watch.graphs.utils.ChartUtilsKt;
import com.animaconnected.watch.theme.ChartPaints;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Chart.kt */
/* loaded from: classes3.dex */
public abstract class Chart {
    private float height;
    private boolean isUserInteractionEnabled;
    private MarkerView markerView;
    private boolean showNoDataText;
    private float subtitleTextHeight;
    private float titleTextHeight;
    private float usableHeight;
    private float usableWidth;
    private float width;
    private Function0<Unit> markerAppeared = new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$markerAppeared$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };
    private XAxisProperties x = new XAxisProperties(null, 0, 0.0f, null, 0.0f, false, false, 0.0f, 255, null);
    private YAxisProperties y = new YAxisProperties(null, 0.0f, 0, 0.0f, 0, null, null, null, null, null, 0, 0, 0, 0, null, 32767, null);
    private Function0<Unit> onTouchDataSelected = new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$onTouchDataSelected$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };
    private final TouchListener touchListener = new TouchListener(new Function0<RectF>() { // from class: com.animaconnected.watch.graphs.Chart$touchListener$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RectF invoke() {
            return Chart.this.getMainDrawingZone();
        }
    }, new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$touchListener$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Chart.this.getOnDataUpdated().invoke();
        }
    }, new Function0<Boolean>() { // from class: com.animaconnected.watch.graphs.Chart$touchListener$3
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(Chart.this.getShowNoDataText());
        }
    }, new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$touchListener$4
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Chart.this.getOnTouchDataSelected().invoke();
        }
    }, new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$touchListener$5
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Chart.this.getMarkerAppeared().invoke();
        }
    });
    private List<? extends ChartEntry> data = EmptyList.INSTANCE;
    private String noDataText = "";
    private Function0<Unit> onDataUpdated = new Function0<Unit>() { // from class: com.animaconnected.watch.graphs.Chart$onDataUpdated$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    };
    private Function0<String> titleText = new Function0<String>() { // from class: com.animaconnected.watch.graphs.Chart$titleText$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "";
        }
    };
    private Function0<String> subtitleText = new Function0<String>() { // from class: com.animaconnected.watch.graphs.Chart$subtitleText$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "";
        }
    };

    private final RectF getTopDrawingZone() {
        return new RectF(0.0f, 0.0f, this.width, this.titleTextHeight + 8.0f + this.subtitleTextHeight);
    }

    public abstract void adaptChartToData();

    public abstract void doDraw();

    public final void draw() {
        boolean resetMarker$graphics_release = this.touchListener.resetMarker$graphics_release(getMarkerView$graphics_release());
        doDraw();
        if (!resetMarker$graphics_release) {
            drawTouchValue();
        }
    }

    public final void drawTitleSection(ChartPaints paints) {
        Intrinsics.checkNotNullParameter(paints, "paints");
        RectF topDrawingZone = getTopDrawingZone();
        Kanvas.drawText$default(getCanvas(), this.titleText.invoke(), topDrawingZone.getLeft(), this.titleTextHeight, 0.0f, null, paints.getTitle(), 24, null);
        Kanvas.drawText$default(getCanvas(), this.subtitleText.invoke(), topDrawingZone.getLeft(), topDrawingZone.getBottom(), 0.0f, null, paints.getSubtitle(), 24, null);
    }

    public abstract Kanvas getCanvas();

    public final List<ChartEntry> getData() {
        return this.data;
    }

    public final boolean getDisableVerticalScroll() {
        if (this.touchListener.getXDistance$graphics_release() > this.touchListener.getYDistance$graphics_release()) {
            return true;
        }
        return false;
    }

    public final float getHeight() {
        return this.height;
    }

    public final RectF getMainDrawingZone() {
        return new RectF(this.x.getStartPosition().invoke().floatValue(), this.y.getMaxLabelHeight() + getTopDrawingZone().getHeight(), this.usableWidth, ChartUtilsKt.calculateUsableHeight(this));
    }

    public Function0<Unit> getMarkerAppeared() {
        return this.markerAppeared;
    }

    public MarkerView getMarkerView$graphics_release() {
        return this.markerView;
    }

    public final String getNoDataText() {
        return this.noDataText;
    }

    public final Function0<Unit> getOnDataUpdated() {
        return this.onDataUpdated;
    }

    public final Function0<Unit> getOnTouchDataSelected() {
        return this.onTouchDataSelected;
    }

    public final boolean getShowNoDataText() {
        return this.showNoDataText;
    }

    public final Function0<String> getSubtitleText() {
        return this.subtitleText;
    }

    public final float getSubtitleTextHeight() {
        return this.subtitleTextHeight;
    }

    public final Function0<String> getTitleText() {
        return this.titleText;
    }

    public final float getTitleTextHeight() {
        return this.titleTextHeight;
    }

    public final TouchListener getTouchListener$graphics_release() {
        return this.touchListener;
    }

    public final float getUsableHeight() {
        return this.usableHeight;
    }

    public final float getUsableWidth() {
        return this.usableWidth;
    }

    public final float getWidth() {
        return this.width;
    }

    public final XAxisProperties getX() {
        return this.x;
    }

    public final YAxisProperties getY() {
        return this.y;
    }

    public final void hideMarker() {
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release != null) {
            TouchListener.hideMarker$graphics_release$default(this.touchListener, markerView$graphics_release, false, 2, null);
        }
    }

    public final void hideMarkerNextRedraw() {
        MarkerView markerView$graphics_release = getMarkerView$graphics_release();
        if (markerView$graphics_release != null) {
            this.touchListener.hideMarker$graphics_release(markerView$graphics_release, false);
        }
    }

    public final boolean isUserInteractionEnabled() {
        return this.isUserInteractionEnabled;
    }

    public final boolean onTouch(TouchListener.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isUserInteractionEnabled) {
            return this.touchListener.onTouch$graphics_release(event);
        }
        return false;
    }

    public final void setChartSize(float f, float f2) {
        this.height = f;
        this.width = f2;
        adaptChartToData();
        this.onDataUpdated.invoke();
    }

    public final void setData(List<? extends ChartEntry> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.data = value;
        adaptChartToData();
        this.onDataUpdated.invoke();
    }

    public void setMarkerAppeared(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.markerAppeared = function0;
    }

    public void setMarkerView$graphics_release(MarkerView markerView) {
        this.markerView = markerView;
    }

    public final void setNoDataText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noDataText = str;
    }

    public final void setOnDataUpdated(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onDataUpdated = function0;
    }

    public final void setOnTouchDataSelected(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.onTouchDataSelected = function0;
    }

    public final void setShowNoDataText(boolean z) {
        this.showNoDataText = z;
    }

    public final void setSubtitleText(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.subtitleText = function0;
    }

    public final void setSubtitleTextHeight(float f) {
        this.subtitleTextHeight = f;
    }

    public final void setTitleText(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.titleText = function0;
    }

    public final void setTitleTextHeight(float f) {
        this.titleTextHeight = f;
    }

    public final void setUsableHeight(float f) {
        this.usableHeight = f;
    }

    public final void setUsableWidth(float f) {
        this.usableWidth = f;
    }

    public final void setUserInteractionEnabled(boolean z) {
        this.isUserInteractionEnabled = z;
    }

    public final void setX(XAxisProperties xAxisProperties) {
        Intrinsics.checkNotNullParameter(xAxisProperties, "<set-?>");
        this.x = xAxisProperties;
    }

    public final void setY(YAxisProperties yAxisProperties) {
        Intrinsics.checkNotNullParameter(yAxisProperties, "<set-?>");
        this.y = yAxisProperties;
    }

    public void drawTouchValue() {
    }
}
