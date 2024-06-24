package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;

/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public final class ColorStyle implements TextForegroundStyle {
    public final long value;

    public ColorStyle(long j) {
        boolean z;
        this.value = j;
        if (j != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ColorStyle) && Color.m317equalsimpl0(this.value, ((ColorStyle) obj).value)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final float getAlpha() {
        return Color.m318getAlphaimpl(this.value);
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    public final Brush getBrush() {
        return null;
    }

    @Override // androidx.compose.ui.text.style.TextForegroundStyle
    /* renamed from: getColor-0d7_KjU */
    public final long mo553getColor0d7_KjU() {
        return this.value;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return Long.hashCode(this.value);
    }

    public final String toString() {
        return "ColorStyle(value=" + ((Object) Color.m323toStringimpl(this.value)) + ')';
    }
}
