package androidx.compose.ui.text.android;

import android.graphics.Rect;
import android.os.Build;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PaintExtensions.kt */
/* loaded from: classes.dex */
public final class PaintExtensionsKt {
    public static final Rect getCharSequenceBounds(TextPaint textPaint, CharSequence charSequence, int r18, int r19) {
        boolean z;
        int r2 = r18;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.nextSpanTransition(r2 - 1, r19, MetricAffectingSpan.class) != r19) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (r2 < r19) {
                    int nextSpanTransition = spanned.nextSpanTransition(r2, r19, MetricAffectingSpan.class);
                    MetricAffectingSpan[] spans = (MetricAffectingSpan[]) spanned.getSpans(r2, nextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    Intrinsics.checkNotNullExpressionValue(spans, "spans");
                    for (MetricAffectingSpan metricAffectingSpan : spans) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        Paint29.getTextBounds(textPaint2, charSequence, r2, nextSpanTransition, rect2);
                    } else {
                        textPaint2.getTextBounds(charSequence.toString(), r2, nextSpanTransition, rect2);
                    }
                    rect.right = rect2.width() + rect.right;
                    rect.top = Math.min(rect.top, rect2.top);
                    rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    r2 = nextSpanTransition;
                }
                return rect;
            }
        }
        Rect rect3 = new Rect();
        if (Build.VERSION.SDK_INT >= 29) {
            Paint29.getTextBounds(textPaint, charSequence, r2, r19, rect3);
        } else {
            textPaint.getTextBounds(charSequence.toString(), r2, r19, rect3);
        }
        return rect3;
    }
}
