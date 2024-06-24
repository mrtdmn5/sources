package com.animaconnected.watch.display;

import android.graphics.Paint;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWatchPaint.kt */
/* loaded from: classes3.dex */
public final class AndroidWatchPaint implements CanvasPaint {
    private Font font;
    private final Paint paint;

    public AndroidWatchPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        this.paint = paint;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public int getColor() {
        return this.paint.getColor();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public boolean getFill() {
        if (this.paint.getStyle() != Paint.Style.FILL && this.paint.getStyle() != Paint.Style.FILL_AND_STROKE) {
            return false;
        }
        return true;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public Font getFont() {
        return this.font;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float getWidth() {
        return this.paint.getStrokeWidth();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureHeight(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        return (float) Math.ceil((fontMetrics.bottom - fontMetrics.top) + fontMetrics.leading);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public Size measureSize(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Size(measureWidth(text), measureHeight(text));
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureWidth(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.paint.getTextWidths(text, new float[text.length()]);
        return ((float) Math.ceil(ArraysKt___ArraysKt.sum(r0))) + 5.0f;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setColor(int r2) {
        this.paint.setColor(r2);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFill(boolean z) {
        Paint.Style style;
        Paint paint = this.paint;
        if (z) {
            style = Paint.Style.FILL;
        } else {
            style = Paint.Style.STROKE;
        }
        paint.setStyle(style);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFont(Font font) {
        this.font = font;
        if (font == null) {
            return;
        }
        this.paint.setTextSize(font.getSize());
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setWidth(float f) {
        this.paint.setStrokeWidth(f);
    }
}
