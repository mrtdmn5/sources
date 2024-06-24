package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.text.android.TextLayoutKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndentationFixSpan.kt */
/* loaded from: classes.dex */
public final class IndentationFixSpan implements LeadingMarginSpan {
    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int r3, int r4, int r5, int r6, int r7, CharSequence charSequence, int r9, int r10, boolean z, Layout layout) {
        if (layout != null && paint != null) {
            int lineForOffset = layout.getLineForOffset(r9);
            boolean z2 = true;
            if (lineForOffset == layout.getLineCount() - 1 && TextLayoutKt.isLineEllipsized(layout, lineForOffset)) {
                float ellipsizedRightPadding = IndentationFixSpanKt.getEllipsizedRightPadding(layout, lineForOffset, paint) + IndentationFixSpanKt.getEllipsizedLeftPadding(layout, lineForOffset, paint);
                if (ellipsizedRightPadding != 0.0f) {
                    z2 = false;
                }
                if (!z2) {
                    Intrinsics.checkNotNull(canvas);
                    canvas.translate(ellipsizedRightPadding, 0.0f);
                }
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z) {
        return 0;
    }
}
