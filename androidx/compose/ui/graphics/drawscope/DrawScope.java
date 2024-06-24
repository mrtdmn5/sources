package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import mu.KMarkerFactory;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DrawScope.kt */
/* loaded from: classes.dex */
public interface DrawScope extends Density {
    /* renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
    static /* synthetic */ void m378drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, DrawStyle drawStyle, int r18) {
        float f2;
        long j3;
        float f3;
        DrawStyle drawStyle2;
        int r0;
        if ((r18 & 2) != 0) {
            f2 = Size.m275getMinDimensionimpl(drawScope.mo391getSizeNHjbRc()) / 2.0f;
        } else {
            f2 = f;
        }
        if ((r18 & 4) != 0) {
            j3 = drawScope.mo390getCenterF1C5BW0();
        } else {
            j3 = j2;
        }
        if ((r18 & 8) != 0) {
            f3 = 1.0f;
        } else {
            f3 = 0.0f;
        }
        float f4 = f3;
        if ((r18 & 16) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        if ((r18 & 64) != 0) {
            r0 = 3;
        } else {
            r0 = 0;
        }
        drawScope.mo358drawCircleVaOC9Bg(j, f2, j3, f4, drawStyle2, null, r0);
    }

    /* renamed from: drawImage-AZ2fEMs$default, reason: not valid java name */
    static void m379drawImageAZ2fEMs$default(DrawScope drawScope, ImageBitmap imageBitmap, long j, long j2, long j3, long j4, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r31, int r32, int r33) {
        long j5;
        long j6;
        long j7;
        long j8;
        float f2;
        DrawStyle drawStyle2;
        ColorFilter colorFilter2;
        int r16;
        int r17;
        if ((r33 & 2) != 0) {
            j5 = IntOffset.Zero;
        } else {
            j5 = j;
        }
        if ((r33 & 4) != 0) {
            j6 = IntSizeKt.IntSize(imageBitmap.getWidth(), imageBitmap.getHeight());
        } else {
            j6 = j2;
        }
        if ((r33 & 8) != 0) {
            j7 = IntOffset.Zero;
        } else {
            j7 = j3;
        }
        if ((r33 & 16) != 0) {
            j8 = j6;
        } else {
            j8 = j4;
        }
        if ((r33 & 32) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((r33 & 64) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        if ((r33 & 128) != 0) {
            colorFilter2 = null;
        } else {
            colorFilter2 = colorFilter;
        }
        if ((r33 & 256) != 0) {
            r16 = 3;
        } else {
            r16 = r31;
        }
        if ((r33 & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
            r17 = 1;
        } else {
            r17 = r32;
        }
        drawScope.mo359drawImageAZ2fEMs(imageBitmap, j5, j6, j7, j8, f2, drawStyle2, colorFilter2, r16, r17);
    }

    /* renamed from: drawLine-1RTmtNc$default, reason: not valid java name */
    static /* synthetic */ void m381drawLine1RTmtNc$default(DrawScope drawScope, Brush brush, long j, long j2, float f, float f2, int r22) {
        float f3;
        float f4;
        int r0;
        if ((r22 & 8) != 0) {
            f3 = 0.0f;
        } else {
            f3 = f;
        }
        if ((r22 & 64) != 0) {
            f4 = 1.0f;
        } else {
            f4 = f2;
        }
        if ((r22 & 256) != 0) {
            r0 = 3;
        } else {
            r0 = 0;
        }
        drawScope.mo361drawLine1RTmtNc(brush, j, j2, f3, 0, null, f4, null, r0);
    }

    /* renamed from: drawLine-NGM6Ib0$default, reason: not valid java name */
    static /* synthetic */ void m382drawLineNGM6Ib0$default(DrawScope drawScope, long j, long j2, long j3, float f, int r24, int r25) {
        float f2;
        int r11;
        int r15;
        float f3 = 0.0f;
        if ((r25 & 8) != 0) {
            f2 = 0.0f;
        } else {
            f2 = f;
        }
        if ((r25 & 16) != 0) {
            r11 = 0;
        } else {
            r11 = r24;
        }
        if ((r25 & 64) != 0) {
            f3 = 1.0f;
        }
        float f4 = f3;
        if ((r25 & 256) != 0) {
            r15 = 3;
        } else {
            r15 = 0;
        }
        drawScope.mo362drawLineNGM6Ib0(j, j2, j3, f2, r11, null, f4, null, r15);
    }

    /* renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
    static /* synthetic */ void m383drawPathGBMwjPU$default(DrawScope drawScope, Path path, Brush brush, float f, Stroke stroke, int r12) {
        int r10;
        if ((r12 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        DrawStyle drawStyle = stroke;
        if ((r12 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((r12 & 32) != 0) {
            r10 = 3;
        } else {
            r10 = 0;
        }
        drawScope.mo363drawPathGBMwjPU(path, brush, f2, drawStyle2, null, r10);
    }

    /* renamed from: drawPath-LG529CI$default, reason: not valid java name */
    static /* synthetic */ void m384drawPathLG529CI$default(DrawScope drawScope, Path path, long j, Stroke stroke, int r14) {
        float f;
        int r13;
        if ((r14 & 4) != 0) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        float f2 = f;
        DrawStyle drawStyle = stroke;
        if ((r14 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((r14 & 32) != 0) {
            r13 = 3;
        } else {
            r13 = 0;
        }
        drawScope.mo364drawPathLG529CI(path, j, f2, drawStyle2, null, r13);
    }

    /* renamed from: drawRect-AsUm42w$default, reason: not valid java name */
    static void m385drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, int r20, int r21) {
        long j3;
        long j4;
        float f2;
        DrawStyle drawStyle2;
        int r11;
        if ((r21 & 2) != 0) {
            j3 = Offset.Zero;
        } else {
            j3 = j;
        }
        if ((r21 & 4) != 0) {
            j4 = m389offsetSizePENXr5M(drawScope.mo391getSizeNHjbRc(), j3);
        } else {
            j4 = j2;
        }
        if ((r21 & 8) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((r21 & 16) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        if ((r21 & 64) != 0) {
            r11 = 3;
        } else {
            r11 = r20;
        }
        drawScope.mo366drawRectAsUm42w(brush, j3, j4, f2, drawStyle2, null, r11);
    }

    /* renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
    static void m386drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, long j3, float f, int r21) {
        long j4;
        long j5;
        float f2;
        Fill fill;
        int r0;
        if ((r21 & 2) != 0) {
            j4 = Offset.Zero;
        } else {
            j4 = j2;
        }
        if ((r21 & 4) != 0) {
            j5 = m389offsetSizePENXr5M(drawScope.mo391getSizeNHjbRc(), j4);
        } else {
            j5 = j3;
        }
        if ((r21 & 8) != 0) {
            f2 = 1.0f;
        } else {
            f2 = f;
        }
        if ((r21 & 16) != 0) {
            fill = Fill.INSTANCE;
        } else {
            fill = null;
        }
        Fill fill2 = fill;
        if ((r21 & 64) != 0) {
            r0 = 3;
        } else {
            r0 = 0;
        }
        drawScope.mo367drawRectnJ9OG0(j, j4, j5, f2, fill2, null, r0);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
    static void m387drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, Stroke stroke, int r24) {
        long j4;
        long j5;
        long j6;
        float f;
        DrawStyle drawStyle;
        int r0;
        if ((r24 & 2) != 0) {
            j4 = Offset.Zero;
        } else {
            j4 = j;
        }
        if ((r24 & 4) != 0) {
            j5 = m389offsetSizePENXr5M(drawScope.mo391getSizeNHjbRc(), j4);
        } else {
            j5 = j2;
        }
        if ((r24 & 8) != 0) {
            j6 = CornerRadius.Zero;
        } else {
            j6 = j3;
        }
        if ((r24 & 16) != 0) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        float f2 = f;
        if ((r24 & 32) != 0) {
            drawStyle = Fill.INSTANCE;
        } else {
            drawStyle = stroke;
        }
        if ((r24 & 128) != 0) {
            r0 = 3;
        } else {
            r0 = 0;
        }
        drawScope.mo368drawRoundRectZuiqVtQ(brush, j4, j5, j6, f2, drawStyle, null, r0);
    }

    /* renamed from: drawRoundRect-u-Aw5IA$default, reason: not valid java name */
    static void m388drawRoundRectuAw5IA$default(DrawScope drawScope, long j, long j2, long j3, long j4, DrawStyle drawStyle, int r26) {
        long j5;
        long j6;
        long j7;
        DrawStyle drawStyle2;
        float f;
        int r0;
        if ((r26 & 2) != 0) {
            j5 = Offset.Zero;
        } else {
            j5 = j2;
        }
        if ((r26 & 4) != 0) {
            j6 = m389offsetSizePENXr5M(drawScope.mo391getSizeNHjbRc(), j5);
        } else {
            j6 = j3;
        }
        if ((r26 & 8) != 0) {
            j7 = CornerRadius.Zero;
        } else {
            j7 = j4;
        }
        if ((r26 & 16) != 0) {
            drawStyle2 = Fill.INSTANCE;
        } else {
            drawStyle2 = drawStyle;
        }
        if ((r26 & 32) != 0) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        float f2 = f;
        if ((r26 & 128) != 0) {
            r0 = 3;
        } else {
            r0 = 0;
        }
        drawScope.mo369drawRoundRectuAw5IA(j, j5, j6, j7, drawStyle2, f2, null, r0);
    }

    /* renamed from: offsetSize-PENXr5M, reason: not valid java name */
    private static long m389offsetSizePENXr5M(long j, long j2) {
        return SizeKt.Size(Size.m276getWidthimpl(j) - Offset.m259getXimpl(j2), Size.m274getHeightimpl(j) - Offset.m260getYimpl(j2));
    }

    /* renamed from: drawArc-yD3GUKo */
    void mo357drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle drawStyle, ColorFilter colorFilter, int r12);

    /* renamed from: drawCircle-VaOC9Bg */
    void mo358drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle drawStyle, ColorFilter colorFilter, int r9);

    /* renamed from: drawImage-AZ2fEMs */
    default void mo359drawImageAZ2fEMs(ImageBitmap image, long j, long j2, long j3, long j4, float f, DrawStyle style, ColorFilter colorFilter, int r30, int r31) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        m379drawImageAZ2fEMs$default(this, image, j, j2, j3, j4, f, style, colorFilter, r30, 0, DfuBaseService.ERROR_REMOTE_TYPE_SECURE);
    }

    /* renamed from: drawImage-gbVJVH8 */
    void mo360drawImagegbVJVH8(ImageBitmap imageBitmap, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r7);

    /* renamed from: drawLine-1RTmtNc */
    void mo361drawLine1RTmtNc(Brush brush, long j, long j2, float f, int r7, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r11);

    /* renamed from: drawLine-NGM6Ib0 */
    void mo362drawLineNGM6Ib0(long j, long j2, long j3, float f, int r8, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r12);

    /* renamed from: drawPath-GBMwjPU */
    void mo363drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r6);

    /* renamed from: drawPath-LG529CI */
    void mo364drawPathLG529CI(Path path, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r7);

    /* renamed from: drawPoints-F8ZwMP8 */
    void mo365drawPointsF8ZwMP8(ArrayList arrayList, long j, float f, int r5, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r9);

    /* renamed from: drawRect-AsUm42w */
    void mo366drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r9);

    /* renamed from: drawRect-n-J9OG0 */
    void mo367drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r10);

    /* renamed from: drawRoundRect-ZuiqVtQ */
    void mo368drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, ColorFilter colorFilter, int r11);

    /* renamed from: drawRoundRect-u-Aw5IA */
    void mo369drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle drawStyle, float f, ColorFilter colorFilter, int r12);

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    default long mo390getCenterF1C5BW0() {
        return SizeKt.m279getCenteruvyYCjk(getDrawContext().mo370getSizeNHjbRc());
    }

    CanvasDrawScope$drawContext$1 getDrawContext();

    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    default long mo391getSizeNHjbRc() {
        return getDrawContext().mo370getSizeNHjbRc();
    }
}
