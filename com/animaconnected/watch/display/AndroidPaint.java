package com.animaconnected.watch.display;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidKanvas.kt */
/* loaded from: classes3.dex */
public final class AndroidPaint implements CanvasPaint {
    private Font font;
    private Paint paint;

    public AndroidPaint(Paint paint) {
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

    public final Paint getPaint() {
        return this.paint;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float getWidth() {
        return this.paint.getStrokeWidth();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureHeight(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return measureSize(text).getHeight();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public Size measureSize(String text) {
        boolean z;
        float ceil;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ceil = 0.0f;
        } else {
            this.paint.getTextWidths(text, new float[text.length()]);
            ceil = (float) Math.ceil(ArraysKt___ArraysKt.sum(r0));
        }
        this.paint.getTextBounds(text, 0, text.length(), new Rect());
        return new Size(DpUtilsKt.toDp(ceil), DpUtilsKt.toDp(r2.height()));
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureWidth(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return measureSize(text).getWidth();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setColor(int r2) {
        this.paint.setColor(r2);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFill(boolean z) {
        if (z) {
            this.paint.setStyle(Paint.Style.FILL);
        } else {
            this.paint.setStyle(Paint.Style.STROKE);
        }
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFont(Font font) {
        this.font = font;
        if (font == null) {
            return;
        }
        this.paint.setTextSize(font.getSize());
        this.paint.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, 0));
    }

    public final void setPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paint = paint;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setWidth(float f) {
        this.paint.setStrokeWidth(f);
    }
}
