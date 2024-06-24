package com.animaconnected.watch.display.view;

import com.animaconnected.watch.image.Kolor;

/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public class Rectangle extends Container {
    private Kolor color;
    private boolean fill;
    private int thickness;

    public Rectangle(int r7, int r8, int r9, int r10) {
        super(r7, r8, r9, r10, null);
        this.fill = true;
        this.thickness = 1;
    }

    /* renamed from: getColor-XHNnPzI, reason: not valid java name */
    public final Kolor m1113getColorXHNnPzI() {
        return this.color;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final int getThickness() {
        return this.thickness;
    }

    /* renamed from: setColor-1L9c4HM, reason: not valid java name */
    public final void m1114setColor1L9c4HM(Kolor kolor) {
        this.color = kolor;
    }

    public final void setFill(boolean z) {
        this.fill = z;
    }

    public final void setThickness(int r1) {
        this.thickness = r1;
    }
}
