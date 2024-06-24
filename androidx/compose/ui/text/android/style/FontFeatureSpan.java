package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFeatureSpan.kt */
/* loaded from: classes.dex */
public final class FontFeatureSpan extends MetricAffectingSpan {
    public final String fontFeatureSettings;

    public FontFeatureSpan(String str) {
        this.fontFeatureSettings = str;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
        textPaint.setFontFeatureSettings(this.fontFeatureSettings);
    }
}
