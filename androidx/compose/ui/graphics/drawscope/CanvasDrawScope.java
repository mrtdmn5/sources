package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mu.KMarkerFactory;

/* compiled from: CanvasDrawScope.kt */
/* loaded from: classes.dex */
public final class CanvasDrawScope implements DrawScope {
    public AndroidPaint fillPaint;
    public AndroidPaint strokePaint;
    public final DrawParams drawParams = new DrawParams();
    public final CanvasDrawScope$drawContext$1 drawContext = new CanvasDrawScope$drawContext$1(this);

    /* compiled from: CanvasDrawScope.kt */
    /* loaded from: classes.dex */
    public static final class DrawParams {
        public Canvas canvas;
        public Density density;
        public LayoutDirection layoutDirection;
        public long size;

        public DrawParams() {
            DensityImpl densityImpl = CanvasDrawScopeKt.DefaultDensity;
            LayoutDirection layoutDirection = LayoutDirection.Ltr;
            EmptyCanvas emptyCanvas = new EmptyCanvas();
            long j = Size.Zero;
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            this.density = densityImpl;
            this.layoutDirection = layoutDirection;
            this.canvas = emptyCanvas;
            this.size = j;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            if (Intrinsics.areEqual(this.density, drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual(this.canvas, drawParams.canvas) && Size.m273equalsimpl0(this.size, drawParams.size)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = (this.canvas.hashCode() + ((this.layoutDirection.hashCode() + (this.density.hashCode() * 31)) * 31)) * 31;
            long j = this.size;
            int r3 = Size.$r8$clinit;
            return Long.hashCode(j) + hashCode;
        }

        public final String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + ((Object) Size.m278toStringimpl(this.size)) + ')';
        }
    }

    /* renamed from: configurePaint-2qPWKa0$default, reason: not valid java name */
    public static Paint m352configurePaint2qPWKa0$default(CanvasDrawScope canvasDrawScope, long j, DrawStyle drawStyle, float f, ColorFilter colorFilter, int r8) {
        boolean z;
        Paint selectPaint = canvasDrawScope.selectPaint(drawStyle);
        long m355modulate5vOe2sY = m355modulate5vOe2sY(f, j);
        AndroidPaint androidPaint = (AndroidPaint) selectPaint;
        if (!Color.m317equalsimpl0(androidPaint.mo293getColor0d7_KjU(), m355modulate5vOe2sY)) {
            androidPaint.mo298setColor8_81llA(m355modulate5vOe2sY);
        }
        if (androidPaint.internalShader != null) {
            androidPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaint.internalColorFilter, colorFilter)) {
            androidPaint.setColorFilter(colorFilter);
        }
        boolean z2 = false;
        if (androidPaint._blendMode == r8) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            androidPaint.mo297setBlendModes9anfk8(r8);
        }
        if (androidPaint.mo294getFilterQualityfv9h1I() == 1) {
            z2 = true;
        }
        if (!z2) {
            androidPaint.mo299setFilterQualityvDHp3xo(1);
        }
        return selectPaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI$default, reason: not valid java name */
    public static Paint m354configureStrokePaintQ_0CZUI$default(CanvasDrawScope canvasDrawScope, long j, float f, int r6, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r10) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Paint obtainStrokePaint = canvasDrawScope.obtainStrokePaint();
        long m355modulate5vOe2sY = m355modulate5vOe2sY(f2, j);
        AndroidPaint androidPaint = (AndroidPaint) obtainStrokePaint;
        if (!Color.m317equalsimpl0(androidPaint.mo293getColor0d7_KjU(), m355modulate5vOe2sY)) {
            androidPaint.mo298setColor8_81llA(m355modulate5vOe2sY);
        }
        if (androidPaint.internalShader != null) {
            androidPaint.setShader(null);
        }
        if (!Intrinsics.areEqual(androidPaint.internalColorFilter, colorFilter)) {
            androidPaint.setColorFilter(colorFilter);
        }
        boolean z6 = false;
        if (androidPaint._blendMode == r10) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            androidPaint.mo297setBlendModes9anfk8(r10);
        }
        if (androidPaint.getStrokeWidth() == f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            androidPaint.setStrokeWidth(f);
        }
        if (androidPaint.getStrokeMiterLimit() == 4.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            androidPaint.setStrokeMiterLimit(4.0f);
        }
        if (androidPaint.m295getStrokeCapKaPHkGw() == r6) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            androidPaint.m300setStrokeCapBeK7IIE(r6);
        }
        if (androidPaint.m296getStrokeJoinLxFBmk8() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            androidPaint.m301setStrokeJoinWw9F2mQ(0);
        }
        androidPaint.getClass();
        if (!Intrinsics.areEqual((Object) null, kMarkerFactory)) {
            androidPaint.setPathEffect(kMarkerFactory);
        }
        if (androidPaint.mo294getFilterQualityfv9h1I() == 1) {
            z6 = true;
        }
        if (!z6) {
            androidPaint.mo299setFilterQualityvDHp3xo(1);
        }
        return obtainStrokePaint;
    }

    /* renamed from: modulate-5vOe2sY, reason: not valid java name */
    public static long m355modulate5vOe2sY(float f, long j) {
        boolean z;
        long Color;
        if (f == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Color = ColorKt.Color(Color.m322getRedimpl(j), Color.m321getGreenimpl(j), Color.m319getBlueimpl(j), Color.m318getAlphaimpl(j) * f, Color.m320getColorSpaceimpl(j));
            return Color;
        }
        return j;
    }

    /* renamed from: configurePaint-swdJneE, reason: not valid java name */
    public final Paint m356configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f, ColorFilter colorFilter, int r9, int r10) {
        boolean z;
        boolean z2;
        Paint selectPaint = selectPaint(drawStyle);
        boolean z3 = true;
        if (brush != null) {
            brush.mo310applyToPq9zytI(f, mo391getSizeNHjbRc(), selectPaint);
        } else {
            if (selectPaint.getAlpha() == f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                selectPaint.setAlpha(f);
            }
        }
        if (!Intrinsics.areEqual(selectPaint.getColorFilter(), colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (selectPaint.mo292getBlendMode0nO6VwU() == r9) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            selectPaint.mo297setBlendModes9anfk8(r9);
        }
        if (selectPaint.mo294getFilterQualityfv9h1I() != r10) {
            z3 = false;
        }
        if (!z3) {
            selectPaint.mo299setFilterQualityvDHp3xo(r10);
        }
        return selectPaint;
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawArc-yD3GUKo, reason: not valid java name */
    public final void mo357drawArcyD3GUKo(long j, float f, float f2, long j2, long j3, float f3, DrawStyle style, ColorFilter colorFilter, int r25) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawArc(Offset.m259getXimpl(j2), Offset.m260getYimpl(j2), Size.m276getWidthimpl(j3) + Offset.m259getXimpl(j2), Size.m274getHeightimpl(j3) + Offset.m260getYimpl(j2), f, f2, m352configurePaint2qPWKa0$default(this, j, style, f3, colorFilter, r25));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawCircle-VaOC9Bg, reason: not valid java name */
    public final void mo358drawCircleVaOC9Bg(long j, float f, long j2, float f2, DrawStyle style, ColorFilter colorFilter, int r18) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.mo285drawCircle9KIMszo(f, j2, m352configurePaint2qPWKa0$default(this, j, style, f2, colorFilter, r18));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-AZ2fEMs, reason: not valid java name */
    public final void mo359drawImageAZ2fEMs(ImageBitmap image, long j, long j2, long j3, long j4, float f, DrawStyle style, ColorFilter colorFilter, int r25, int r26) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.mo287drawImageRectHPBpro0(image, j, j2, j3, j4, m356configurePaintswdJneE(null, style, f, colorFilter, r25, r26));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawImage-gbVJVH8, reason: not valid java name */
    public final void mo360drawImagegbVJVH8(ImageBitmap image, long j, float f, DrawStyle style, ColorFilter colorFilter, int r14) {
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.mo286drawImaged4ec7I(image, j, m356configurePaintswdJneE(null, style, f, colorFilter, r14, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-1RTmtNc, reason: not valid java name */
    public final void mo361drawLine1RTmtNc(Brush brush, long j, long j2, float f, int r11, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r15) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(brush, "brush");
        Canvas canvas = this.drawParams.canvas;
        Paint obtainStrokePaint = obtainStrokePaint();
        brush.mo310applyToPq9zytI(f2, mo391getSizeNHjbRc(), obtainStrokePaint);
        AndroidPaint androidPaint = (AndroidPaint) obtainStrokePaint;
        if (!Intrinsics.areEqual(androidPaint.internalColorFilter, colorFilter)) {
            androidPaint.setColorFilter(colorFilter);
        }
        boolean z6 = false;
        if (androidPaint._blendMode == r15) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            androidPaint.mo297setBlendModes9anfk8(r15);
        }
        if (androidPaint.getStrokeWidth() == f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            androidPaint.setStrokeWidth(f);
        }
        if (androidPaint.getStrokeMiterLimit() == 4.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            androidPaint.setStrokeMiterLimit(4.0f);
        }
        if (androidPaint.m295getStrokeCapKaPHkGw() == r11) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            androidPaint.m300setStrokeCapBeK7IIE(r11);
        }
        if (androidPaint.m296getStrokeJoinLxFBmk8() == 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            androidPaint.m301setStrokeJoinWw9F2mQ(0);
        }
        androidPaint.getClass();
        if (!Intrinsics.areEqual((Object) null, kMarkerFactory)) {
            androidPaint.setPathEffect(kMarkerFactory);
        }
        if (androidPaint.mo294getFilterQualityfv9h1I() == 1) {
            z6 = true;
        }
        if (!z6) {
            androidPaint.mo299setFilterQualityvDHp3xo(1);
        }
        canvas.mo288drawLineWko1d7g(j, j2, obtainStrokePaint);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawLine-NGM6Ib0, reason: not valid java name */
    public final void mo362drawLineNGM6Ib0(long j, long j2, long j3, float f, int r19, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r23) {
        this.drawParams.canvas.mo288drawLineWko1d7g(j2, j3, m354configureStrokePaintQ_0CZUI$default(this, j, f, r19, kMarkerFactory, f2, colorFilter, r23));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-GBMwjPU, reason: not valid java name */
    public final void mo363drawPathGBMwjPU(Path path, Brush brush, float f, DrawStyle style, ColorFilter colorFilter, int r13) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawPath(path, m356configurePaintswdJneE(brush, style, f, colorFilter, r13, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPath-LG529CI, reason: not valid java name */
    public final void mo364drawPathLG529CI(Path path, long j, float f, DrawStyle style, ColorFilter colorFilter, int r15) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawPath(path, m352configurePaint2qPWKa0$default(this, j, style, f, colorFilter, r15));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawPoints-F8ZwMP8, reason: not valid java name */
    public final void mo365drawPointsF8ZwMP8(ArrayList arrayList, long j, float f, int r16, KMarkerFactory kMarkerFactory, float f2, ColorFilter colorFilter, int r20) {
        this.drawParams.canvas.mo289drawPointsO7TthRY(m354configureStrokePaintQ_0CZUI$default(this, j, f, r16, kMarkerFactory, f2, colorFilter, r20), arrayList);
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-AsUm42w, reason: not valid java name */
    public final void mo366drawRectAsUm42w(Brush brush, long j, long j2, float f, DrawStyle style, ColorFilter colorFilter, int r21) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawRect(Offset.m259getXimpl(j), Offset.m260getYimpl(j), Size.m276getWidthimpl(j2) + Offset.m259getXimpl(j), Size.m274getHeightimpl(j2) + Offset.m260getYimpl(j), m356configurePaintswdJneE(brush, style, f, colorFilter, r21, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRect-n-J9OG0, reason: not valid java name */
    public final void mo367drawRectnJ9OG0(long j, long j2, long j3, float f, DrawStyle style, ColorFilter colorFilter, int r23) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawRect(Offset.m259getXimpl(j2), Offset.m260getYimpl(j2), Size.m276getWidthimpl(j3) + Offset.m259getXimpl(j2), Size.m274getHeightimpl(j3) + Offset.m260getYimpl(j2), m352configurePaint2qPWKa0$default(this, j, style, f, colorFilter, r23));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-ZuiqVtQ, reason: not valid java name */
    public final void mo368drawRoundRectZuiqVtQ(Brush brush, long j, long j2, long j3, float f, DrawStyle style, ColorFilter colorFilter, int r21) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawRoundRect(Offset.m259getXimpl(j), Offset.m260getYimpl(j), Offset.m259getXimpl(j) + Size.m276getWidthimpl(j2), Offset.m260getYimpl(j) + Size.m274getHeightimpl(j2), CornerRadius.m253getXimpl(j3), CornerRadius.m254getYimpl(j3), m356configurePaintswdJneE(brush, style, f, colorFilter, r21, 1));
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    /* renamed from: drawRoundRect-u-Aw5IA, reason: not valid java name */
    public final void mo369drawRoundRectuAw5IA(long j, long j2, long j3, long j4, DrawStyle style, float f, ColorFilter colorFilter, int r27) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.drawParams.canvas.drawRoundRect(Offset.m259getXimpl(j2), Offset.m260getYimpl(j2), Size.m276getWidthimpl(j3) + Offset.m259getXimpl(j2), Size.m274getHeightimpl(j3) + Offset.m260getYimpl(j2), CornerRadius.m253getXimpl(j4), CornerRadius.m254getYimpl(j4), m352configurePaint2qPWKa0$default(this, j, style, f, colorFilter, r27));
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.drawParams.density.getDensity();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final CanvasDrawScope$drawContext$1 getDrawContext() {
        return this.drawContext;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.drawParams.density.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.drawscope.DrawScope
    public final LayoutDirection getLayoutDirection() {
        return this.drawParams.layoutDirection;
    }

    public final Paint obtainStrokePaint() {
        AndroidPaint androidPaint = this.strokePaint;
        if (androidPaint == null) {
            AndroidPaint Paint = AndroidPaint_androidKt.Paint();
            Paint.m302setStylek9PVt8s(1);
            this.strokePaint = Paint;
            return Paint;
        }
        return androidPaint;
    }

    public final Paint selectPaint(DrawStyle drawStyle) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
            AndroidPaint androidPaint = this.fillPaint;
            if (androidPaint == null) {
                AndroidPaint Paint = AndroidPaint_androidKt.Paint();
                Paint.m302setStylek9PVt8s(0);
                this.fillPaint = Paint;
                return Paint;
            }
            return androidPaint;
        }
        if (drawStyle instanceof Stroke) {
            Paint obtainStrokePaint = obtainStrokePaint();
            AndroidPaint androidPaint2 = (AndroidPaint) obtainStrokePaint;
            float strokeWidth = androidPaint2.getStrokeWidth();
            Stroke stroke = (Stroke) drawStyle;
            float f = stroke.width;
            if (strokeWidth == f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                androidPaint2.setStrokeWidth(f);
            }
            int m295getStrokeCapKaPHkGw = androidPaint2.m295getStrokeCapKaPHkGw();
            int r4 = stroke.cap;
            if (m295getStrokeCapKaPHkGw == r4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                androidPaint2.m300setStrokeCapBeK7IIE(r4);
            }
            float strokeMiterLimit = androidPaint2.getStrokeMiterLimit();
            float f2 = stroke.miter;
            if (strokeMiterLimit == f2) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                androidPaint2.setStrokeMiterLimit(f2);
            }
            int m296getStrokeJoinLxFBmk8 = androidPaint2.m296getStrokeJoinLxFBmk8();
            int r42 = stroke.join;
            if (m296getStrokeJoinLxFBmk8 == r42) {
                z4 = true;
            }
            if (!z4) {
                androidPaint2.m301setStrokeJoinWw9F2mQ(r42);
            }
            androidPaint2.getClass();
            stroke.getClass();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                androidPaint2.setPathEffect(null);
            }
            return obtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }
}
