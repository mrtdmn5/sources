package androidx.compose.ui.text.style;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public final class BrushStyle implements TextForegroundStyle {
    public final float alpha;
    public final ShaderBrush value;

    public BrushStyle(ShaderBrush value, float f) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.alpha = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrushStyle)) {
            return false;
        }
        BrushStyle brushStyle = (BrushStyle) obj;
        if (Intrinsics.areEqual(this.value, brushStyle.value) && Float.compare(this.alpha, brushStyle.alpha) == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final Brush getBrush() {
        return this.value;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long mo553getColor0d7_KjU() {
        int r0 = Color.$r8$clinit;
        return Color.Unspecified;
    }

    public final int hashCode() {
        return Float.hashCode(this.alpha) + (this.value.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BrushStyle(value=");
        sb.append(this.value);
        sb.append(", alpha=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.alpha, ')');
    }
}
