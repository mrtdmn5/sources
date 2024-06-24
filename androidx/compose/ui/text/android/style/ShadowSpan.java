package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShadowSpan.kt */
/* loaded from: classes.dex */
public final class ShadowSpan extends CharacterStyle {
    public final int color;
    public final float offsetX;
    public final float offsetY;
    public final float radius;

    public ShadowSpan(float f, float f2, float f3, int r4) {
        this.color = r4;
        this.offsetX = f;
        this.offsetY = f2;
        this.radius = f3;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint tp) {
        Intrinsics.checkNotNullParameter(tp, "tp");
        tp.setShadowLayer(this.radius, this.offsetX, this.offsetY, this.color);
    }
}
