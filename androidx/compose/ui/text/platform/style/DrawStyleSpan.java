package androidx.compose.ui.text.platform.style;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawStyleSpan.android.kt */
/* loaded from: classes.dex */
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {
    public final DrawStyle drawStyle;

    public DrawStyleSpan(DrawStyle drawStyle) {
        this.drawStyle = drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        boolean z;
        boolean z2;
        boolean z3;
        Paint.Join join;
        boolean z4;
        boolean z5;
        Paint.Cap cap;
        if (textPaint != null) {
            Fill fill = Fill.INSTANCE;
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, fill)) {
                textPaint.setStyle(Paint.Style.FILL);
                return;
            }
            if (drawStyle instanceof Stroke) {
                textPaint.setStyle(Paint.Style.STROKE);
                textPaint.setStrokeWidth(((Stroke) drawStyle).width);
                textPaint.setStrokeMiter(((Stroke) drawStyle).miter);
                int r0 = ((Stroke) drawStyle).join;
                boolean z6 = true;
                if (r0 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    join = Paint.Join.MITER;
                } else {
                    if (r0 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        join = Paint.Join.ROUND;
                    } else {
                        if (r0 == 2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            join = Paint.Join.BEVEL;
                        } else {
                            join = Paint.Join.MITER;
                        }
                    }
                }
                textPaint.setStrokeJoin(join);
                int r02 = ((Stroke) drawStyle).cap;
                if (r02 == 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    cap = Paint.Cap.BUTT;
                } else {
                    if (r02 == 1) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        cap = Paint.Cap.ROUND;
                    } else {
                        if (r02 != 2) {
                            z6 = false;
                        }
                        if (z6) {
                            cap = Paint.Cap.SQUARE;
                        } else {
                            cap = Paint.Cap.BUTT;
                        }
                    }
                }
                textPaint.setStrokeCap(cap);
                ((Stroke) drawStyle).getClass();
                textPaint.setPathEffect(null);
            }
        }
    }
}
