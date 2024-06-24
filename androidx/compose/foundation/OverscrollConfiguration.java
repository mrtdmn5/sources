package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OverscrollConfiguration.kt */
/* loaded from: classes.dex */
public final class OverscrollConfiguration {
    public final PaddingValues drawPadding;
    public final long glowColor;

    public OverscrollConfiguration(long j, PaddingValues drawPadding) {
        Intrinsics.checkNotNullParameter(drawPadding, "drawPadding");
        this.glowColor = j;
        this.drawPadding = drawPadding;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(OverscrollConfiguration.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) obj;
        if (Color.m317equalsimpl0(this.glowColor, overscrollConfiguration.glowColor) && Intrinsics.areEqual(this.drawPadding, overscrollConfiguration.drawPadding)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r0 = Color.$r8$clinit;
        return this.drawPadding.hashCode() + (Long.hashCode(this.glowColor) * 31);
    }

    public final String toString() {
        return "OverscrollConfiguration(glowColor=" + ((Object) Color.m323toStringimpl(this.glowColor)) + ", drawPadding=" + this.drawPadding + ')';
    }
}
