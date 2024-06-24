package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineHeightStyleSpan.kt */
/* loaded from: classes.dex */
public final class LineHeightStyleSpan implements android.text.style.LineHeightSpan {
    public final int endIndex;
    public int firstAscentDiff;
    public int lastDescentDiff;
    public final float lineHeight;
    public final float topRatio;
    public final boolean trimFirstLineTop;
    public final boolean trimLastLineBottom;
    public final int startIndex = 0;
    public int firstAscent = Integer.MIN_VALUE;
    public int ascent = Integer.MIN_VALUE;
    public int descent = Integer.MIN_VALUE;
    public int lastDescent = Integer.MIN_VALUE;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:            if (r2 != false) goto L14;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LineHeightStyleSpan(float r1, int r2, boolean r3, boolean r4, float r5) {
        /*
            r0 = this;
            r0.<init>()
            r0.lineHeight = r1
            r1 = 0
            r0.startIndex = r1
            r0.endIndex = r2
            r0.trimFirstLineTop = r3
            r0.trimLastLineBottom = r4
            r0.topRatio = r5
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r0.firstAscent = r2
            r0.ascent = r2
            r0.descent = r2
            r0.lastDescent = r2
            r2 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            r3 = 1
            if (r2 > 0) goto L28
            r2 = 1065353216(0x3f800000, float:1.0)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 > 0) goto L28
            r2 = r3
            goto L29
        L28:
            r2 = r1
        L29:
            if (r2 != 0) goto L36
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 != 0) goto L33
            r2 = r3
            goto L34
        L33:
            r2 = r1
        L34:
            if (r2 == 0) goto L37
        L36:
            r1 = r3
        L37:
            if (r1 == 0) goto L3a
            return
        L3a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "topRatio should be in [0..1] range or -1"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.style.LineHeightStyleSpan.<init>(float, int, boolean, boolean, float):void");
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence text, int r7, int r8, int r9, int r10, Paint.FontMetricsInt fontMetricsInt) {
        boolean z;
        boolean z2;
        int r6;
        int r62;
        double ceil;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (fontMetricsInt.descent - fontMetricsInt.ascent <= 0) {
            return;
        }
        boolean z3 = true;
        if (r7 == this.startIndex) {
            z = true;
        } else {
            z = false;
        }
        if (r8 == this.endIndex) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z4 = this.trimLastLineBottom;
        boolean z5 = this.trimFirstLineTop;
        if (z && z2 && z5 && z4) {
            return;
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            int ceil2 = (int) Math.ceil(this.lineHeight);
            int r1 = ceil2 - (fontMetricsInt.descent - fontMetricsInt.ascent);
            float f = this.topRatio;
            if (f != -1.0f) {
                z3 = false;
            }
            if (z3) {
                f = Math.abs(fontMetricsInt.ascent) / (fontMetricsInt.descent - fontMetricsInt.ascent);
            }
            if (r1 <= 0) {
                ceil = Math.ceil(r1 * f);
            } else {
                ceil = Math.ceil((1.0f - f) * r1);
            }
            int r102 = fontMetricsInt.descent;
            int r92 = ((int) ceil) + r102;
            this.descent = r92;
            int r12 = r92 - ceil2;
            this.ascent = r12;
            if (z5) {
                r12 = fontMetricsInt.ascent;
            }
            this.firstAscent = r12;
            if (z4) {
                r92 = r102;
            }
            this.lastDescent = r92;
            this.firstAscentDiff = fontMetricsInt.ascent - r12;
            this.lastDescentDiff = r92 - r102;
        }
        if (z) {
            r6 = this.firstAscent;
        } else {
            r6 = this.ascent;
        }
        fontMetricsInt.ascent = r6;
        if (z2) {
            r62 = this.lastDescent;
        } else {
            r62 = this.descent;
        }
        fontMetricsInt.descent = r62;
    }
}
