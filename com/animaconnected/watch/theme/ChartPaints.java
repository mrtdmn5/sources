package com.animaconnected.watch.theme;

import com.animaconnected.watch.display.CanvasPaint;
import com.animaconnected.watch.display.Kanvas;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartPaints.kt */
/* loaded from: classes3.dex */
public class ChartPaints {
    private final Lazy averageHeading$delegate;
    private final Lazy averageValue$delegate;
    private final Lazy background$delegate;
    private final Lazy gridLine$delegate;
    private final Lazy highlightFill$delegate;
    private final Lazy highlightStroke$delegate;
    private final Lazy highlightVariantFill$delegate;
    private final Lazy important$delegate;
    private final Lazy importantFill$delegate;
    private final Lazy label$delegate;
    private final Lazy line$delegate;
    private final Lazy lineDashed$delegate;
    private final Lazy lineDashedHighlight$delegate;
    private final Lazy lineDot$delegate;
    private final Lazy normalFill$delegate;
    private final Lazy normalVariantFill$delegate;
    private final Lazy subtitle$delegate;
    private final Lazy title$delegate;

    public ChartPaints(final ChartFonts fonts, final ChartColors colors, final Kanvas canvas) {
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.label$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$label$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH5(), colors.getLabels(), null, false, null, 28, null));
            }
        });
        this.important$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$important$2
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
        this.averageHeading$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$averageHeading$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getCaption(), colors.getImportantText(), null, false, null, 28, null));
            }
        });
        this.averageValue$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$averageValue$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH1(), colors.getImportantText(), null, false, null, 28, null));
            }
        });
        this.subtitle$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$subtitle$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH3(), colors.getImportantText(), null, false, null, 28, null));
            }
        });
        this.title$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$title$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.this.createTextPaint(new Kanvas.TextConfig(fonts.getH4(), colors.getLabels(), null, false, null, 28, null));
            }
        });
        this.background$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$background$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getBackground(), true, 0.0f, null, 12, null);
            }
        });
        this.highlightFill$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$highlightFill$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getHighlight(), true, 0.0f, null, 12, null);
            }
        });
        this.highlightVariantFill$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$highlightVariantFill$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getHighlightVariant(), true, 0.0f, null, 12, null);
            }
        });
        this.normalFill$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$normalFill$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getNormal(), true, 0.0f, null, 12, null);
            }
        });
        this.normalVariantFill$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$normalVariantFill$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getNormalVariant(), true, 0.0f, null, 12, null);
            }
        });
        this.importantFill$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$importantFill$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getImportantText(), true, 0.0f, null, 12, null);
            }
        });
        this.line$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$line$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getLabels(), false, 2.0f, null, 10, null);
            }
        });
        this.lineDot$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$lineDot$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getLabels(), true, 0.0f, null, 12, null);
            }
        });
        this.highlightStroke$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$highlightStroke$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getHighlight(), false, 2.0f, null, 10, null);
            }
        });
        this.lineDashed$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$lineDashed$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getLabels(), false, 2.0f, new Kanvas.DashedLine(1.5f, 1.5f), 2, null);
            }
        });
        this.lineDashedHighlight$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$lineDashedHighlight$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getHighlight(), false, 2.0f, new Kanvas.DashedLine(1.5f, 1.5f), 2, null);
            }
        });
        this.gridLine$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CanvasPaint>() { // from class: com.animaconnected.watch.theme.ChartPaints$gridLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CanvasPaint invoke() {
                return Kanvas.createColorPaint$default(Kanvas.this, colors.getGridLines(), false, 0.0f, null, 14, null);
            }
        });
    }

    public final CanvasPaint getAverageHeading() {
        return (CanvasPaint) this.averageHeading$delegate.getValue();
    }

    public final CanvasPaint getAverageValue() {
        return (CanvasPaint) this.averageValue$delegate.getValue();
    }

    public final CanvasPaint getBackground() {
        return (CanvasPaint) this.background$delegate.getValue();
    }

    public final CanvasPaint getGridLine() {
        return (CanvasPaint) this.gridLine$delegate.getValue();
    }

    public final CanvasPaint getHighlightFill() {
        return (CanvasPaint) this.highlightFill$delegate.getValue();
    }

    public final CanvasPaint getHighlightStroke() {
        return (CanvasPaint) this.highlightStroke$delegate.getValue();
    }

    public final CanvasPaint getHighlightVariantFill() {
        return (CanvasPaint) this.highlightVariantFill$delegate.getValue();
    }

    public final CanvasPaint getImportant() {
        return (CanvasPaint) this.important$delegate.getValue();
    }

    public final CanvasPaint getImportantFill() {
        return (CanvasPaint) this.importantFill$delegate.getValue();
    }

    public final CanvasPaint getLabel() {
        return (CanvasPaint) this.label$delegate.getValue();
    }

    public final CanvasPaint getLine() {
        return (CanvasPaint) this.line$delegate.getValue();
    }

    public final CanvasPaint getLineDashed() {
        return (CanvasPaint) this.lineDashed$delegate.getValue();
    }

    public final CanvasPaint getLineDashedHighlight() {
        return (CanvasPaint) this.lineDashedHighlight$delegate.getValue();
    }

    public final CanvasPaint getLineDot() {
        return (CanvasPaint) this.lineDot$delegate.getValue();
    }

    public final CanvasPaint getNormalFill() {
        return (CanvasPaint) this.normalFill$delegate.getValue();
    }

    public final CanvasPaint getNormalVariantFill() {
        return (CanvasPaint) this.normalVariantFill$delegate.getValue();
    }

    public final CanvasPaint getSubtitle() {
        return (CanvasPaint) this.subtitle$delegate.getValue();
    }

    public final CanvasPaint getTitle() {
        return (CanvasPaint) this.title$delegate.getValue();
    }
}
