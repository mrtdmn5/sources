package androidx.compose.ui.text.android.style;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaceholderSpan.kt */
/* loaded from: classes.dex */
public final class PlaceholderSpan extends ReplacementSpan {
    public Paint.FontMetricsInt fontMetrics;
    public int heightPx;
    public boolean isLaidOut;
    public int widthPx;

    public PlaceholderSpan() {
        throw null;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int r3, int r4, float f, int r6, int r7, int r8, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
    }

    public final Paint.FontMetricsInt getFontMetrics() {
        Paint.FontMetricsInt fontMetricsInt = this.fontMetrics;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        throw null;
    }

    public final int getHeightPx() {
        if (this.isLaidOut) {
            return this.heightPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }

    @Override // android.text.style.ReplacementSpan
    @SuppressLint({"DocumentExceptions"})
    public final int getSize(Paint paint, CharSequence charSequence, int r3, int r4, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        boolean z = true;
        this.isLaidOut = true;
        paint.getTextSize();
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        Intrinsics.checkNotNullExpressionValue(fontMetricsInt2, "paint.fontMetricsInt");
        this.fontMetrics = fontMetricsInt2;
        if (getFontMetrics().descent <= getFontMetrics().ascent) {
            z = false;
        }
        if (z) {
            this.widthPx = (int) Math.ceil(0.0f);
            this.heightPx = (int) Math.ceil(0.0f);
            if (fontMetricsInt != null) {
                fontMetricsInt.ascent = getFontMetrics().ascent;
                fontMetricsInt.descent = getFontMetrics().descent;
                fontMetricsInt.leading = getFontMetrics().leading;
                if (fontMetricsInt.ascent > (-getHeightPx())) {
                    fontMetricsInt.ascent = -getHeightPx();
                }
                fontMetricsInt.top = Math.min(getFontMetrics().top, fontMetricsInt.ascent);
                fontMetricsInt.bottom = Math.max(getFontMetrics().bottom, fontMetricsInt.descent);
            }
            return getWidthPx();
        }
        throw new IllegalArgumentException("Invalid fontMetrics: line height can not be negative.".toString());
    }

    public final int getWidthPx() {
        if (this.isLaidOut) {
            return this.widthPx;
        }
        throw new IllegalStateException("PlaceholderSpan is not laid out yet.".toString());
    }
}
