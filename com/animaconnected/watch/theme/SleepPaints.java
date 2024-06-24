package com.animaconnected.watch.theme;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.image.GraphicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartPaints.kt */
/* loaded from: classes3.dex */
public final class SleepPaints extends ChartPaints {
    private final Kanvas canvas;
    private final CanvasPaint deepInteractionOtherDay;
    private final CanvasPaint deepInteractionToday;
    private final CanvasPaint deepOtherDay;
    private final CanvasPaint deepToday;
    private final CanvasPaint lightInteractionOtherDay;
    private final CanvasPaint lightInteractionToday;
    private final CanvasPaint lightOtherDay;
    private final CanvasPaint lightToday;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepPaints(ChartFonts fonts, ChartColors colors, Kanvas canvas) {
        super(fonts, colors, canvas);
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.canvas = canvas;
        this.lightToday = createPaint$default(this, colors.getSleepChartLight(), 0, 2, null);
        this.lightInteractionToday = createPaint(colors.getSleepChartLight(), 10);
        this.lightOtherDay = createPaint$default(this, colors.getNormal(), 0, 2, null);
        this.lightInteractionOtherDay = createPaint(colors.getNormal(), 10);
        this.deepToday = createPaint$default(this, colors.getSleepChartDeep(), 0, 2, null);
        this.deepInteractionToday = createPaint(colors.getSleepChartDeep(), 10);
        this.deepOtherDay = createPaint(colors.getNormal(), 15);
        this.deepInteractionOtherDay = createPaint(colors.getNormal(), 20);
    }

    private final CanvasPaint createPaint(int r8, int r9) {
        Kanvas kanvas = this.canvas;
        if (r9 > 0) {
            r8 = GraphicsKt.darkenColorByPercentage(r8, r9);
        }
        return Kanvas.createColorPaint$default(kanvas, r8, true, 0.0f, null, 12, null);
    }

    public static /* synthetic */ CanvasPaint createPaint$default(SleepPaints sleepPaints, int r1, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        return sleepPaints.createPaint(r1, r2);
    }

    public final CanvasPaint getDeepInteractionOtherDay() {
        return this.deepInteractionOtherDay;
    }

    public final CanvasPaint getDeepInteractionToday() {
        return this.deepInteractionToday;
    }

    public final CanvasPaint getDeepOtherDay() {
        return this.deepOtherDay;
    }

    public final CanvasPaint getDeepToday() {
        return this.deepToday;
    }

    public final CanvasPaint getLightInteractionOtherDay() {
        return this.lightInteractionOtherDay;
    }

    public final CanvasPaint getLightInteractionToday() {
        return this.lightInteractionToday;
    }

    public final CanvasPaint getLightOtherDay() {
        return this.lightOtherDay;
    }

    public final CanvasPaint getLightToday() {
        return this.lightToday;
    }
}
