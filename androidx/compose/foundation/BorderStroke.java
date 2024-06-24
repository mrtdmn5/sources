package androidx.compose.foundation;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BorderStroke.kt */
/* loaded from: classes.dex */
public final class BorderStroke {
    public final Brush brush;
    public final float width;

    public BorderStroke(float f, SolidColor solidColor) {
        this.width = f;
        this.brush = solidColor;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BorderStroke)) {
            return false;
        }
        BorderStroke borderStroke = (BorderStroke) obj;
        if (Dp.m579equalsimpl0(this.width, borderStroke.width) && Intrinsics.areEqual(this.brush, borderStroke.brush)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.brush.hashCode() + (Float.hashCode(this.width) * 31);
    }

    public final String toString() {
        return "BorderStroke(width=" + ((Object) Dp.m580toStringimpl(this.width)) + ", brush=" + this.brush + ')';
    }
}
