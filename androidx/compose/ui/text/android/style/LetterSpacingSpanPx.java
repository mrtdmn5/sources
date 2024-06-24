package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LetterSpacingSpanPx.kt */
/* loaded from: classes.dex */
public final class LetterSpacingSpanPx extends MetricAffectingSpan {
    public final float letterSpacing;

    public LetterSpacingSpanPx(float f) {
        this.letterSpacing = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        boolean z;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        float textScaleX = textPaint.getTextScaleX() * textPaint.getTextSize();
        if (textScaleX == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            textPaint.setLetterSpacing(this.letterSpacing / textScaleX);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        boolean z;
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        float textScaleX = textPaint.getTextScaleX() * textPaint.getTextSize();
        if (textScaleX == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            textPaint.setLetterSpacing(this.letterSpacing / textScaleX);
        }
    }
}
