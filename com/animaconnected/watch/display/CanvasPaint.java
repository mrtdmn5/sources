package com.animaconnected.watch.display;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public interface CanvasPaint {
    int getColor();

    boolean getFill();

    Font getFont();

    float getWidth();

    float measureHeight(String str);

    Size measureSize(String str);

    float measureWidth(String str);

    void setColor(int r1);

    void setFill(boolean z);

    void setFont(Font font);

    void setWidth(float f);
}
