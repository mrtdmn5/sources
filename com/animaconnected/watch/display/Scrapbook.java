package com.animaconnected.watch.display;

import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.display.Kanvas;
import com.animaconnected.watch.image.Kolors;
import com.animaconnected.watch.image.Mitmap;
import com.animaconnected.watch.theme.ChartFonts;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scrapbook.kt */
/* loaded from: classes3.dex */
public final class Scrapbook {
    private final CanvasPaint black;
    private final CanvasPaint blueFill;
    private final Kanvas canvas;
    private final ChartFonts fonts;
    private int height;
    private Mitmap mitmap;
    private final CanvasPaint textPaintBlack;
    private final CanvasPaint textPaintBlue;
    private int width;

    public Scrapbook(Kanvas canvas, ChartFonts fonts) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(fonts, "fonts");
        this.canvas = canvas;
        this.fonts = fonts;
        this.black = Kanvas.createColorPaint$default(canvas, Kolors.black, false, 0.0f, null, 14, null);
        this.blueFill = Kanvas.createColorPaint$default(canvas, Kolors.blue, true, 0.0f, null, 12, null);
        this.textPaintBlack = canvas.createTextPaint(new Kanvas.TextConfig(fonts.getH1(), 0, null, false, null, 30, null));
        this.textPaintBlue = canvas.createTextPaint(new Kanvas.TextConfig(fonts.getH1(), Kolors.blue, null, false, null, 28, null));
    }

    public final void drawStuff() {
        int r1 = this.width;
        float f = r1 * 0.1f;
        float f2 = r1 * 0.9f;
        Kanvas kanvas = this.canvas;
        try {
            kanvas.drawLine(f, 50.0f, f2, 50.0f, this.black);
            kanvas.drawRect(f, 100.0f, f2, 120.0f, this.blueFill);
            kanvas.drawRect(f, 170.0f, f2, 190.0f, this.black);
            kanvas.drawCircle(20 + f, 240.0f, 20.0f, this.blueFill);
            Kanvas.drawText$default(kanvas, "Text", f, 300.0f, 0.0f, null, this.textPaintBlack, 24, null);
            CanvasPath createPath = kanvas.createPath();
            float f3 = 8;
            float f4 = (f2 - f) / f3;
            createPath.moveTo(f, 400.0f);
            createPath.quadTo(f + f4, 300.0f, (2 * f4) + f, 400.0f);
            createPath.quadTo((3 * f4) + f, 500.0f, (4 * f4) + f, 400.0f);
            createPath.quadTo((5 * f4) + f, 300.0f, (6 * f4) + f, 400.0f);
            createPath.quadTo((7 * f4) + f, 500.0f, (f4 * f3) + f, 400.0f);
            createPath.close();
            kanvas.drawPath(createPath, this.blueFill);
            Mitmap mitmap = this.mitmap;
            if (mitmap != null) {
                Kanvas.drawImage$default(kanvas, f, 500.0f, f2, 32.0f, mitmap, null, 32, null);
            }
            Kanvas.drawText$default(kanvas, "Rotate -90", f + this.textPaintBlue.measureHeight("Rotate -90"), this.textPaintBlue.measureWidth("Rotate -90") + 550.0f, -90.0f, null, this.textPaintBlue, 16, null);
        } catch (Exception e) {
            LogKt.warn$default((Object) kanvas, (String) null, (Throwable) e, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.display.Scrapbook$drawStuff$1$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Exception";
                }
            }, 5, (Object) null);
        }
    }

    public final Kanvas getCanvas() {
        return this.canvas;
    }

    public final ChartFonts getFonts() {
        return this.fonts;
    }

    public final Mitmap getMitmap() {
        return this.mitmap;
    }

    public final void setMitmap(Mitmap mitmap) {
        this.mitmap = mitmap;
    }

    public final void setSize(int r1, int r2) {
        this.width = r1;
        this.height = r2;
    }
}
