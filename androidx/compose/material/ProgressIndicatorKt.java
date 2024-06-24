package androidx.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: ProgressIndicator.kt */
/* loaded from: classes.dex */
public final class ProgressIndicatorKt {
    public static final CubicBezierEasing CircularEasing;
    public static final float LinearIndicatorHeight = ProgressIndicatorDefaults.StrokeWidth;
    public static final float LinearIndicatorWidth = 240;
    public static final float CircularIndicatorDiameter = 40;

    static {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (!Float.isNaN(0.2f) && !Float.isNaN(0.0f) && !Float.isNaN(0.8f) && !Float.isNaN(1.0f)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (!Float.isNaN(0.4f) && !Float.isNaN(0.0f) && !Float.isNaN(1.0f) && !Float.isNaN(1.0f)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (!Float.isNaN(0.0f) && !Float.isNaN(0.0f) && !Float.isNaN(0.65f) && !Float.isNaN(1.0f)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (Float.isNaN(0.1f) || Float.isNaN(0.0f) || Float.isNaN(0.45f) || Float.isNaN(1.0f)) {
                        z4 = false;
                    }
                    if (z4) {
                        CircularEasing = new CubicBezierEasing(0.4f, 0.2f);
                        return;
                    }
                    throw new IllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: 0.1, 0.0, 0.45, 1.0.".toString());
                }
                throw new IllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: 0.0, 0.0, 0.65, 1.0.".toString());
            }
            throw new IllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: 0.4, 0.0, 1.0, 1.0.".toString());
        }
        throw new IllegalArgumentException("Parameters to CubicBezierEasing cannot be NaN. Actual parameters are: 0.2, 0.0, 0.8, 1.0.".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0068  */
    /* renamed from: CircularProgressIndicator-LxG7B9w, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m195CircularProgressIndicatorLxG7B9w(float r28, int r29, final int r30, final int r31, long r32, long r34, androidx.compose.runtime.Composer r36, androidx.compose.ui.Modifier r37) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m195CircularProgressIndicatorLxG7B9w(float, int, int, int, long, long, androidx.compose.runtime.Composer, androidx.compose.ui.Modifier):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0132 A[LOOP:0: B:50:0x0130->B:51:0x0132, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x005a  */
    /* renamed from: LinearProgressIndicator-_5eSR-E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m196LinearProgressIndicator_5eSRE(final float r22, int r23, final int r24, final int r25, long r26, long r28, androidx.compose.runtime.Composer r30, androidx.compose.ui.Modifier r31) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m196LinearProgressIndicator_5eSRE(float, int, int, int, long, long, androidx.compose.runtime.Composer, androidx.compose.ui.Modifier):void");
    }

    /* renamed from: drawCircularIndicator-42QJj7c, reason: not valid java name */
    public static final void m197drawCircularIndicator42QJj7c(DrawScope drawScope, float f, float f2, long j, Stroke stroke) {
        float f3 = 2;
        float f4 = stroke.width / f3;
        float m276getWidthimpl = Size.m276getWidthimpl(drawScope.mo391getSizeNHjbRc()) - (f3 * f4);
        drawScope.mo357drawArcyD3GUKo(j, f, f2, OffsetKt.Offset(f4, f4), SizeKt.Size(m276getWidthimpl, m276getWidthimpl), 1.0f, stroke, null, 3);
    }

    /* renamed from: drawLinearIndicator-qYKTg0g, reason: not valid java name */
    public static final void m198drawLinearIndicatorqYKTg0g(DrawScope drawScope, float f, long j, float f2, int r25) {
        boolean z;
        float f3;
        float m276getWidthimpl = Size.m276getWidthimpl(drawScope.mo391getSizeNHjbRc());
        float m274getHeightimpl = Size.m274getHeightimpl(drawScope.mo391getSizeNHjbRc());
        float f4 = 2;
        float f5 = m274getHeightimpl / f4;
        boolean z2 = true;
        if (drawScope.getLayoutDirection() == LayoutDirection.Ltr) {
            z = true;
        } else {
            z = false;
        }
        float f6 = 1.0f;
        if (z) {
            f3 = 0.0f;
        } else {
            f3 = 1.0f - f;
        }
        float f7 = f3 * m276getWidthimpl;
        if (z) {
            f6 = f;
        }
        float f8 = f6 * m276getWidthimpl;
        if (r25 != 0) {
            z2 = false;
        }
        if (!z2 && m274getHeightimpl <= m276getWidthimpl) {
            float f9 = f2 / f4;
            ClosedFloatRange closedFloatRange = new ClosedFloatRange(f9, m276getWidthimpl - f9);
            float floatValue = ((Number) RangesKt___RangesKt.coerceIn(Float.valueOf(f7), closedFloatRange)).floatValue();
            float floatValue2 = ((Number) RangesKt___RangesKt.coerceIn(Float.valueOf(f8), closedFloatRange)).floatValue();
            if (Math.abs(f - 0.0f) > 0.0f) {
                DrawScope.m382drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(floatValue, f5), OffsetKt.Offset(floatValue2, f5), f2, r25, 480);
                return;
            }
            return;
        }
        DrawScope.m382drawLineNGM6Ib0$default(drawScope, j, OffsetKt.Offset(f7, f5), OffsetKt.Offset(f8, f5), f2, 0, 496);
    }
}
