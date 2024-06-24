package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkewXSpan.kt */
/* loaded from: classes.dex */
public final class SkewXSpan extends MetricAffectingSpan {
    public final float skewX;

    public SkewXSpan(float f) {
        this.skewX = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setTextSkewX(textPaint.getTextSkewX() + this.skewX);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setTextSkewX(textPaint.getTextSkewX() + this.skewX);
    }
}
