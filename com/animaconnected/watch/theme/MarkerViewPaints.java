package com.animaconnected.watch.theme;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartPaints.kt */
/* loaded from: classes3.dex */
public final class MarkerViewPaints extends ChartPaints {
    private final Lazy markerBackground$delegate;
    private final Lazy markerSubtitle$delegate;
    private final Lazy markerTitle$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkerViewPaints(final ChartFonts fonts, final ChartColors colors, final Kanvas canvas) {
        super(fonts, colors, canvas);
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.markerTitle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.MarkerViewPaints$markerTitle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH4(), colors.getImportantText(), null, false, null, 28, null));
            }
        });
        this.markerSubtitle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.MarkerViewPaints$markerSubtitle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH5(), colors.getImportantText(), null, false, null, 28, null));
            }
        });
        this.markerBackground$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.MarkerViewPaints$markerBackground$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getMarkerViewBackground(), true, 0.0f, null, 12, null);
            }
        });
    }

    public final CanvasPaint getMarkerBackground() {
        return (CanvasPaint) this.markerBackground$delegate.getValue();
    }

    public final CanvasPaint getMarkerSubtitle() {
        return (CanvasPaint) this.markerSubtitle$delegate.getValue();
    }

    public final CanvasPaint getMarkerTitle() {
        return (CanvasPaint) this.markerTitle$delegate.getValue();
    }
}
