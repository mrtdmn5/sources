package com.animaconnected.secondo.widget.chart;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.MotionEvent;
import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import com.animaconnected.watch.display.AndroidKanvas;
import com.animaconnected.watch.display.DpUtilsKt;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.display.PointF;
import com.animaconnected.watch.graphs.Chart;
import com.animaconnected.watch.graphs.ChartEntry;
import com.animaconnected.watch.graphs.TouchListener;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartView.kt */
/* loaded from: classes3.dex */
public final class ChartViewKt {
    public static final void ChartView(final Chart chart, final List<? extends ChartEntry> data, Modifier modifier, Composer composer, final int r11, final int r12) {
        Intrinsics.checkNotNullParameter(chart, "chart");
        Intrinsics.checkNotNullParameter(data, "data");
        ComposerImpl startRestartGroup = composer.startRestartGroup(501755038);
        if ((r12 & 4) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        final Modifier modifier2 = modifier;
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        startRestartGroup.startReplaceableGroup(-1773721057);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = getVibrator(context);
            startRestartGroup.updateValue(nextSlot);
        }
        final Vibrator vibrator = (Vibrator) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1773720987);
        if (m == composer$Companion$Empty$1) {
            m = new RequestDisallowInterceptTouchEvent();
            startRestartGroup.updateValue(m);
        }
        final RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = (RequestDisallowInterceptTouchEvent) m;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -1773720912);
        if (m2 == composer$Companion$Empty$1) {
            m2 = Platform.mutableStateOf$default(0L);
            startRestartGroup.updateValue(m2);
        }
        final MutableState mutableState = (MutableState) m2;
        startRestartGroup.end(false);
        EffectsKt.DisposableEffect(Unit.INSTANCE, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                Chart chart2 = Chart.this;
                final MutableState<Long> mutableState2 = mutableState;
                chart2.setOnDataUpdated(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ChartViewKt.ChartView$lambda$4(mutableState2, System.currentTimeMillis());
                    }
                });
                Chart chart3 = Chart.this;
                final Vibrator vibrator2 = vibrator;
                chart3.setOnTouchDataSelected(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        ChartViewKt.playHapticFeedBack(vibrator2);
                    }
                });
                final Chart chart4 = Chart.this;
                return new DisposableEffectResult() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        Chart.this.setOnTouchDataSelected(new Function0<Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$1$3$1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        });
                    }
                };
            }
        }, startRestartGroup);
        EffectsKt.LaunchedEffect(data, new ChartViewKt$ChartView$2(chart, data, null), startRestartGroup);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier2, new Function1<LayoutCoordinates, Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                invoke2(layoutCoordinates);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LayoutCoordinates position) {
                Intrinsics.checkNotNullParameter(position, "position");
                long mo423getSizeYbymL2g = position.mo423getSizeYbymL2g();
                Chart.this.setChartSize(DpUtilsKt.toDp(IntSize.m593getHeightimpl(mo423getSizeYbymL2g)), DpUtilsKt.toDp((int) (mo423getSizeYbymL2g >> 32)));
            }
        });
        final Function1<MotionEvent, Boolean> function1 = new Function1<MotionEvent, Boolean>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MotionEvent motionEvent) {
                TouchListener.Event chartTouchEvent;
                Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2 = RequestDisallowInterceptTouchEvent.this;
                boolean disableVerticalScroll = chart.getDisableVerticalScroll();
                PointerInteropFilter pointerInteropFilter = requestDisallowInterceptTouchEvent2.pointerInteropFilter;
                if (pointerInteropFilter != null) {
                    pointerInteropFilter.disallowIntercept = disableVerticalScroll;
                }
                Chart chart2 = chart;
                chartTouchEvent = ChartViewKt.toChartTouchEvent(motionEvent);
                return Boolean.valueOf(chart2.onTouch(chartTouchEvent));
            }
        };
        Intrinsics.checkNotNullParameter(onGloballyPositioned, "<this>");
        CanvasKt.Canvas(ComposedModifierKt.composed(onGloballyPositioned, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier3, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier3, "$this$composed", composer3, 374375707);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                composer3.startReplaceableGroup(-492369756);
                Object rememberedValue = composer3.rememberedValue();
                if (rememberedValue == Composer.Companion.Empty) {
                    rememberedValue = new PointerInteropFilter();
                    composer3.updateRememberedValue(rememberedValue);
                }
                composer3.endReplaceableGroup();
                PointerInteropFilter pointerInteropFilter = (PointerInteropFilter) rememberedValue;
                pointerInteropFilter.getClass();
                Function1<MotionEvent, Boolean> function12 = function1;
                Intrinsics.checkNotNullParameter(function12, "<set-?>");
                pointerInteropFilter.onTouchEvent = function12;
                RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2 = pointerInteropFilter.requestDisallowInterceptTouchEvent;
                if (requestDisallowInterceptTouchEvent2 != null) {
                    requestDisallowInterceptTouchEvent2.pointerInteropFilter = null;
                }
                RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent3 = requestDisallowInterceptTouchEvent;
                pointerInteropFilter.requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent3;
                if (requestDisallowInterceptTouchEvent3 != null) {
                    requestDisallowInterceptTouchEvent3.pointerInteropFilter = pointerInteropFilter;
                }
                composer3.endReplaceableGroup();
                return pointerInteropFilter;
            }
        }), new Function1<DrawScope, Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope Canvas) {
                long ChartView$lambda$3;
                Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                ChartView$lambda$3 = ChartViewKt.ChartView$lambda$3(mutableState);
                if (ChartView$lambda$3 > 0) {
                    Kanvas canvas = Chart.this.getCanvas();
                    AndroidKanvas androidKanvas = canvas instanceof AndroidKanvas ? (AndroidKanvas) canvas : null;
                    if (androidKanvas != null) {
                        Canvas canvas2 = Canvas.getDrawContext().getCanvas();
                        android.graphics.Canvas canvas3 = AndroidCanvas_androidKt.EmptyCanvas;
                        Intrinsics.checkNotNullParameter(canvas2, "<this>");
                        androidKanvas.setNativeCanvas(((AndroidCanvas) canvas2).internalCanvas);
                    }
                    Chart.this.draw();
                }
            }
        }, startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.widget.chart.ChartViewKt$ChartView$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    ChartViewKt.ChartView(Chart.this, data, modifier2, composer2, Strings.updateChangedFlags(r11 | 1), r12);
                }
            };
        }
    }

    public static final long ChartView$lambda$3(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    public static final void ChartView$lambda$4(MutableState<Long> mutableState, long j) {
        mutableState.setValue(Long.valueOf(j));
    }

    public static final Vibrator getVibrator(Context context) {
        Vibrator defaultVibrator;
        if (Build.VERSION.SDK_INT >= 31) {
            Object systemService = context.getSystemService("vibrator_manager");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.VibratorManager");
            defaultVibrator = ChartViewKt$$ExternalSyntheticApiModelOutline3.m(systemService).getDefaultVibrator();
            Intrinsics.checkNotNull(defaultVibrator);
            return defaultVibrator;
        }
        Object systemService2 = context.getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.Vibrator");
        return (Vibrator) systemService2;
    }

    public static final void playHapticFeedBack(Vibrator vibrator) {
        boolean hasAmplitudeControl;
        VibrationEffect createOneShot;
        if (!vibrator.hasVibrator()) {
            return;
        }
        vibrator.cancel();
        if (Build.VERSION.SDK_INT >= 26) {
            hasAmplitudeControl = vibrator.hasAmplitudeControl();
            if (hasAmplitudeControl) {
                createOneShot = VibrationEffect.createOneShot(1L, -1);
                vibrator.vibrate(createOneShot);
                return;
            } else {
                vibrator.vibrate(1L);
                return;
            }
        }
        vibrator.vibrate(1L);
    }

    public static final TouchListener.Event toChartTouchEvent(MotionEvent motionEvent) {
        PointF pointF = new PointF(DpUtilsKt.toDp(motionEvent.getX()), DpUtilsKt.toDp(motionEvent.getY()));
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return new TouchListener.Event.Idle(null, 1, null);
                }
                return new TouchListener.Event.Changed(pointF);
            }
            return new TouchListener.Event.End(pointF);
        }
        return new TouchListener.Event.Begin(pointF);
    }
}
