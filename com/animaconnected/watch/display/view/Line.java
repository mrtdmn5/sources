package com.animaconnected.watch.display.view;

import com.animaconnected.watch.image.Kolor;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Line extends Element {
    private int color;
    private int height;
    private int thickness;
    private int width;
    private final int x2;
    private final int y2;

    public Line(int r8, int r9, int r10, int r11) {
        super(r8, r9, 0, 0, 12, null);
        this.x2 = r10;
        this.y2 = r11;
        this.thickness = 1;
        this.color = Kolor.m1537constructorimpl(-1);
        this.height = Math.abs((r11 == Integer.MIN_VALUE ? 0 : r11) - (r9 == Integer.MIN_VALUE ? 0 : r9));
        this.width = Math.abs((r10 == Integer.MIN_VALUE ? 0 : r10) - (r8 == Integer.MIN_VALUE ? 0 : r8));
    }

    /* renamed from: getColor-IpmnaRI, reason: not valid java name */
    public final int m1111getColorIpmnaRI() {
        return this.color;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getHeight() {
        return this.height;
    }

    public final int getThickness() {
        return this.thickness;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public int getWidth() {
        return this.width;
    }

    public final int getX2() {
        return this.x2;
    }

    public final int getY2() {
        return this.y2;
    }

    /* renamed from: setColor-ukcjflE, reason: not valid java name */
    public final void m1112setColorukcjflE(int r1) {
        this.color = r1;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setHeight(int r1) {
        this.height = r1;
    }

    public final void setThickness(int r1) {
        this.thickness = r1;
    }

    @Override // com.animaconnected.watch.display.view.Element
    public void setWidth(int r1) {
        this.width = r1;
    }
}
