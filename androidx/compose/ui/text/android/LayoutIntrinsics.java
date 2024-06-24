package androidx.compose.ui.text.android;

import android.os.Build;
import android.text.BoringLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutIntrinsics.kt */
/* loaded from: classes.dex */
public final class LayoutIntrinsics {
    public BoringLayout.Metrics _boringMetrics;
    public float _maxIntrinsicWidth;
    public float _minIntrinsicWidth;
    public boolean boringMetricsIsInit;
    public final CharSequence charSequence;
    public final int textDirectionHeuristic;
    public final TextPaint textPaint;

    public LayoutIntrinsics(CharSequence charSequence, AndroidTextPaint textPaint, int r4) {
        Intrinsics.checkNotNullParameter(charSequence, "charSequence");
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        this.charSequence = charSequence;
        this.textPaint = textPaint;
        this.textDirectionHeuristic = r4;
        this._maxIntrinsicWidth = Float.NaN;
        this._minIntrinsicWidth = Float.NaN;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        BoringLayout.Metrics isBoring;
        if (!this.boringMetricsIsInit) {
            TextDirectionHeuristic textDirectionHeuristic = TextLayoutKt.getTextDirectionHeuristic(this.textDirectionHeuristic);
            CharSequence text = this.charSequence;
            Intrinsics.checkNotNullParameter(text, "text");
            TextPaint paint = this.textPaint;
            Intrinsics.checkNotNullParameter(paint, "paint");
            if (Build.VERSION.SDK_INT >= 33) {
                isBoring = BoringLayoutFactory33.isBoring(text, paint, textDirectionHeuristic);
            } else {
                isBoring = BoringLayoutFactoryDefault.isBoring(text, paint, textDirectionHeuristic);
            }
            this._boringMetrics = isBoring;
            this.boringMetricsIsInit = true;
        }
        return this._boringMetrics;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:            if (io.ktor.util.ThrowableKt.hasSpan(r3, androidx.compose.ui.text.android.style.LetterSpacingSpanEm.class) == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:            if (r2 == false) goto L28;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float getMaxIntrinsicWidth() {
        /*
            r7 = this;
            float r0 = r7._maxIntrinsicWidth
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto Lc
            float r0 = r7._maxIntrinsicWidth
            goto L7a
        Lc:
            android.text.BoringLayout$Metrics r0 = r7.getBoringMetrics()
            if (r0 == 0) goto L1a
            int r0 = r0.width
            float r0 = (float) r0
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            goto L1b
        L1a:
            r0 = 0
        L1b:
            r1 = 0
            android.text.TextPaint r2 = r7.textPaint
            java.lang.CharSequence r3 = r7.charSequence
            if (r0 != 0) goto L34
            int r0 = r3.length()
            float r0 = android.text.Layout.getDesiredWidth(r3, r1, r0, r2)
            double r4 = (double) r0
            double r4 = java.lang.Math.ceil(r4)
            float r0 = (float) r4
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L34:
            float r4 = r0.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r6 = 1
            if (r4 != 0) goto L40
            r4 = r6
            goto L41
        L40:
            r4 = r1
        L41:
            if (r4 != 0) goto L67
            boolean r4 = r3 instanceof android.text.Spanned
            if (r4 == 0) goto L59
            android.text.Spanned r3 = (android.text.Spanned) r3
            java.lang.Class<androidx.compose.ui.text.android.style.LetterSpacingSpanPx> r4 = androidx.compose.ui.text.android.style.LetterSpacingSpanPx.class
            boolean r4 = io.ktor.util.ThrowableKt.hasSpan(r3, r4)
            if (r4 != 0) goto L66
            java.lang.Class<androidx.compose.ui.text.android.style.LetterSpacingSpanEm> r4 = androidx.compose.ui.text.android.style.LetterSpacingSpanEm.class
            boolean r3 = io.ktor.util.ThrowableKt.hasSpan(r3, r4)
            if (r3 != 0) goto L66
        L59:
            float r2 = r2.getLetterSpacing()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L63
            r2 = r6
            goto L64
        L63:
            r2 = r1
        L64:
            if (r2 != 0) goto L67
        L66:
            r1 = r6
        L67:
            if (r1 == 0) goto L74
            float r0 = r0.floatValue()
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L74:
            float r0 = r0.floatValue()
            r7._maxIntrinsicWidth = r0
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.LayoutIntrinsics.getMaxIntrinsicWidth():float");
    }
}
