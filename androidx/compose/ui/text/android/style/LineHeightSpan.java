package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LineHeightSpan.kt */
/* loaded from: classes.dex */
public final class LineHeightSpan implements android.text.style.LineHeightSpan {
    public final float lineHeight;

    public LineHeightSpan(float f) {
        this.lineHeight = f;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence text, int r4, int r5, int r6, int r7, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fontMetricsInt, "fontMetricsInt");
        if (fontMetricsInt.descent - fontMetricsInt.ascent <= 0) {
            return;
        }
        int ceil = (int) Math.ceil(fontMetricsInt.descent * ((r4 * 1.0f) / r3));
        fontMetricsInt.descent = ceil;
        fontMetricsInt.ascent = ceil - ((int) Math.ceil(this.lineHeight));
    }
}
