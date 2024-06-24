package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* loaded from: classes.dex */
public final class ComplexColorCompat {
    public int mColor;
    public final Shader mShader;

    public ComplexColorCompat(Shader shader, ColorStateList colorStateList, int r3) {
        this.mShader = shader;
        this.mColor = r3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0183, code lost:            if (r8.size() <= 0) goto L55;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0185, code lost:            r0 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops(r8, r15);     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x018c, code lost:            if (r0 == null) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x018f, code lost:            if (r19 == false) goto L60;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0191, code lost:            r0 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops(r5, r10, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0197, code lost:            r0 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops(r5, r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x019d, code lost:            if (r11 == 1) goto L73;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a0, code lost:            if (r11 == 2) goto L72;     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a2, code lost:            r4 = r0.mColors;        r0 = r0.mOffsets;     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01a8, code lost:            if (r7 == 1) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01aa, code lost:            if (r7 == 2) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01ac, code lost:            r1 = android.graphics.Shader.TileMode.CLAMP;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b4, code lost:            r3 = new android.graphics.LinearGradient(r12, r26, r25, r15, r4, r0, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0208, code lost:            return new androidx.core.content.res.ComplexColorCompat(r3, null, 0);     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01af, code lost:            r1 = android.graphics.Shader.TileMode.MIRROR;     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01b2, code lost:            r1 = android.graphics.Shader.TileMode.REPEAT;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01c5, code lost:            r3 = new android.graphics.SweepGradient(r7, r9, r0.mColors, r0.mOffsets);     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01da, code lost:            if (r8 <= 0.0f) goto L85;     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01dc, code lost:            r1 = r0.mColors;        r0 = r0.mOffsets;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01e3, code lost:            if (r7 == 1) goto L81;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01e6, code lost:            if (r7 == 2) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e8, code lost:            r5 = android.graphics.Shader.TileMode.CLAMP;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01f0, code lost:            r3 = new android.graphics.RadialGradient(r7, r9, r8, r1, r0, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01eb, code lost:            r5 = android.graphics.Shader.TileMode.MIRROR;     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ee, code lost:            r5 = android.graphics.Shader.TileMode.REPEAT;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0210, code lost:            throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x018b, code lost:            r0 = null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.core.content.res.ComplexColorCompat createFromXml(android.content.res.Resources r29, int r30, android.content.res.Resources.Theme r31) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            Method dump skipped, instructions count: 567
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ComplexColorCompat.createFromXml(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.res.ComplexColorCompat");
    }
}
