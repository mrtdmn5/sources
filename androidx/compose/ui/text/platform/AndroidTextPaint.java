package androidx.compose.ui.text.platform;

import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextPaint.android.kt */
/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {
    public final AndroidPaint composePaint;
    public DrawStyle drawStyle;
    public Shadow shadow;
    public TextDecoration textDecoration;

    public AndroidTextPaint(float f) {
        super(1);
        ((TextPaint) this).density = f;
        this.composePaint = new AndroidPaint(this);
        this.textDecoration = TextDecoration.None;
        this.shadow = Shadow.None;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:            r9.mo310applyToPq9zytI(r12, r10, r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:            return;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:            r12 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r12, 0.0f, 1.0f);     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:            if (r1 != false) goto L42;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:            if (r0 == false) goto L35;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:            if (java.lang.Float.isNaN(r12) == false) goto L45;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:            r12 = r3.getAlpha();     */
    /* renamed from: setBrush-12SF9DM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m547setBrush12SF9DM(androidx.compose.ui.graphics.Brush r9, long r10, float r12) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.graphics.SolidColor
            r1 = 1
            r2 = 0
            androidx.compose.ui.graphics.AndroidPaint r3 = r8.composePaint
            if (r0 == 0) goto L18
            r0 = r9
            androidx.compose.ui.graphics.SolidColor r0 = (androidx.compose.ui.graphics.SolidColor) r0
            long r4 = r0.value
            long r6 = androidx.compose.ui.graphics.Color.Unspecified
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L15
            r0 = r1
            goto L16
        L15:
            r0 = r2
        L16:
            if (r0 != 0) goto L26
        L18:
            boolean r0 = r9 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L3c
            long r4 = androidx.compose.ui.geometry.Size.Unspecified
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L23
            goto L24
        L23:
            r1 = r2
        L24:
            if (r1 == 0) goto L3c
        L26:
            boolean r0 = java.lang.Float.isNaN(r12)
            if (r0 == 0) goto L31
            float r12 = r3.getAlpha()
            goto L38
        L31:
            r0 = 0
            r1 = 1065353216(0x3f800000, float:1.0)
            float r12 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r12, r0, r1)
        L38:
            r9.mo310applyToPq9zytI(r12, r10, r3)
            goto L42
        L3c:
            if (r9 != 0) goto L42
            r9 = 0
            r3.setShader(r9)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.m547setBrush12SF9DM(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void setDrawStyle(DrawStyle drawStyle) {
        if (drawStyle != null && !Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            this.drawStyle = drawStyle;
            boolean areEqual = Intrinsics.areEqual(drawStyle, Fill.INSTANCE);
            AndroidPaint androidPaint = this.composePaint;
            if (areEqual) {
                androidPaint.m302setStylek9PVt8s(0);
                return;
            }
            if (drawStyle instanceof Stroke) {
                androidPaint.m302setStylek9PVt8s(1);
                Stroke stroke = (Stroke) drawStyle;
                androidPaint.setStrokeWidth(stroke.width);
                androidPaint.setStrokeMiterLimit(stroke.miter);
                androidPaint.m301setStrokeJoinWw9F2mQ(stroke.join);
                androidPaint.m300setStrokeCapBeK7IIE(stroke.cap);
                stroke.getClass();
                androidPaint.setPathEffect(null);
            }
        }
    }

    public final void setShadow(Shadow shadow) {
        boolean z;
        if (shadow != null && !Intrinsics.areEqual(this.shadow, shadow)) {
            this.shadow = shadow;
            if (Intrinsics.areEqual(shadow, Shadow.None)) {
                clearShadowLayer();
                return;
            }
            Shadow shadow2 = this.shadow;
            float f = shadow2.blurRadius;
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                f = Float.MIN_VALUE;
            }
            setShadowLayer(f, Offset.m259getXimpl(shadow2.offset), Offset.m260getYimpl(this.shadow.offset), ColorKt.m327toArgb8_81llA(this.shadow.color));
        }
    }

    public final void setTextDecoration(TextDecoration textDecoration) {
        if (textDecoration != null && !Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            this.textDecoration = textDecoration;
            setUnderlineText(textDecoration.contains(TextDecoration.Underline));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.LineThrough));
        }
    }
}
