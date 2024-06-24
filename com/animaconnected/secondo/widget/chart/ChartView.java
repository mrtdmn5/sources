package com.animaconnected.secondo.widget.chart;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.display.DpUtilsKt;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.TouchListener;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartView.kt */
/* loaded from: classes3.dex */
public final class ChartView extends View {
    public static final int $stable = 8;
    private Chart chart;
    private AndroidKanvas kanvas;
    private Vibrator vibrator;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ChartView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Chart getChart() {
        return this.chart;
    }

    public final AndroidKanvas getKanvas() {
        return this.kanvas;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.kanvas.setNativeCanvas(canvas);
        Chart chart = this.chart;
        if (chart != null) {
            chart.draw();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Chart chart = this.chart;
        if (chart != null) {
            chart.setChartSize(DpUtilsKt.toDp(getHeight()), DpUtilsKt.toDp(getWidth()));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z;
        TouchListener.Event chartTouchEvent;
        Intrinsics.checkNotNullParameter(event, "event");
        Chart chart = this.chart;
        if (chart != null) {
            z = chart.getDisableVerticalScroll();
        } else {
            z = false;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
        Chart chart2 = this.chart;
        if (chart2 != null) {
            chartTouchEvent = ChartViewKt.toChartTouchEvent(event);
            return chart2.onTouch(chartTouchEvent);
        }
        return false;
    }

    public final void setChart(Chart chart) {
        this.chart = chart;
        if (chart != null) {
            chart.setOnDataUpdated(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartView$chart$1
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
                    final ChartView chartView = ChartView.this;
                    Function0 function0 = (Function0) new WeakReference(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartView$chart$1.1
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
                            ChartView.this.invalidate();
                        }
                    }).get();
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
        if (chart != null) {
            chart.setOnTouchDataSelected(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartView$chart$2
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
                    final ChartView chartView = ChartView.this;
                    Function0 function0 = (Function0) new WeakReference(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartView$chart$2.1
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
                            Vibrator vibrator;
                            vibrator = ChartView.this.vibrator;
                            ChartViewKt.playHapticFeedBack(vibrator);
                        }
                    }).get();
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
        }
        invalidate();
    }

    public final void setKanvas(AndroidKanvas androidKanvas) {
        Intrinsics.checkNotNullParameter(androidKanvas, "<set-?>");
        this.kanvas = androidKanvas;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public ChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChartView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChartView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        Vibrator vibrator;
        Intrinsics.checkNotNullParameter(context, "context");
        this.kanvas = new AndroidKanvas(context);
        vibrator = ChartViewKt.getVibrator(context);
        this.vibrator = vibrator;
    }
}
