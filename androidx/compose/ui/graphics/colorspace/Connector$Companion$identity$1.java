package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;

/* compiled from: Connector.kt */
/* loaded from: classes.dex */
public final class Connector$Companion$identity$1 extends Connector {
    public Connector$Companion$identity$1(ColorSpace colorSpace) {
        super(colorSpace, colorSpace, 1);
    }

    @Override // androidx.compose.ui.graphics.colorspace.Connector
    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release */
    public final long mo351transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
        return ColorKt.Color(f, f2, f3, f4, this.destination);
    }
}
