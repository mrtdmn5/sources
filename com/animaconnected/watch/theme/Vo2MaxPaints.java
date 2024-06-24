package com.animaconnected.watch.theme;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartPaints.kt */
/* loaded from: classes3.dex */
public final class Vo2MaxPaints extends ChartPaints {
    private final Lazy excellent$delegate;
    private final Lazy fair$delegate;
    private final Lazy good$delegate;
    private final Lazy poor$delegate;
    private final Lazy superior$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Vo2MaxPaints(ChartFonts fonts, final ChartColors colors, final Kanvas canvas) {
        super(fonts, colors, canvas);
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.superior$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.Vo2MaxPaints$superior$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getVo2MaxChartSuperior(), true, 0.0f, null, 12, null);
            }
        });
        this.excellent$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.Vo2MaxPaints$excellent$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getVo2MaxChartExcellent(), true, 0.0f, null, 12, null);
            }
        });
        this.good$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.Vo2MaxPaints$good$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getVo2MaxChartGood(), true, 0.0f, null, 12, null);
            }
        });
        this.fair$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.Vo2MaxPaints$fair$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getVo2MaxChartFair(), true, 0.0f, null, 12, null);
            }
        });
        this.poor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.Vo2MaxPaints$poor$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getVo2MaxChartPoor(), true, 0.0f, null, 12, null);
            }
        });
    }

    public final CanvasPaint getExcellent() {
        return (CanvasPaint) this.excellent$delegate.getValue();
    }

    public final CanvasPaint getFair() {
        return (CanvasPaint) this.fair$delegate.getValue();
    }

    public final CanvasPaint getGood() {
        return (CanvasPaint) this.good$delegate.getValue();
    }

    public final CanvasPaint getPoor() {
        return (CanvasPaint) this.poor$delegate.getValue();
    }

    public final CanvasPaint getSuperior() {
        return (CanvasPaint) this.superior$delegate.getValue();
    }
}
