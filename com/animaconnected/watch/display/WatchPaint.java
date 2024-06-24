package com.animaconnected.watch.display;

import com.animaconnected.watch.image.Kolor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchKanvas.kt */
/* loaded from: classes3.dex */
public final class WatchPaint implements CanvasPaint {
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_FONT_SIZE = 22;
    private int color;
    private boolean fill;
    private Font font;
    private float width;

    /* compiled from: WatchKanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ WatchPaint(int r1, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, z);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public int getColor() {
        return this.color;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public boolean getFill() {
        return this.fill;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public Font getFont() {
        return this.font;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float getWidth() {
        return this.width;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureHeight(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return measureSize(text).getHeight();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public Size measureSize(String text) {
        int r1;
        Intrinsics.checkNotNullParameter(text, "text");
        float length = text.length();
        Font font = getFont();
        int r2 = 22;
        if (font != null) {
            r1 = font.getSize();
        } else {
            r1 = 22;
        }
        float f = length * r1;
        Font font2 = getFont();
        if (font2 != null) {
            r2 = font2.getSize();
        }
        return new Size(f, r2);
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public float measureWidth(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return measureSize(text).getWidth();
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setColor(int r1) {
        this.color = r1;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFill(boolean z) {
        this.fill = z;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setFont(Font font) {
        this.font = font;
    }

    @Override // com.animaconnected.watch.display.CanvasPaint
    public void setWidth(float f) {
        this.width = f;
    }

    private WatchPaint(int r1, boolean z) {
        this.fill = z;
        this.color = r1;
        this.width = 1.0f;
    }

    public /* synthetic */ WatchPaint(int r1, boolean z, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? Kolor.m1537constructorimpl(-1) : r1, (r3 & 2) != 0 ? false : z, null);
    }
}
