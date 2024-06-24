package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
public final class PercentCornerSize implements CornerSize {
    public final float percent;

    public PercentCornerSize(float f) {
        this.percent = f;
        if (f >= 0.0f && f <= 100.0f) {
        } else {
            throw new IllegalArgumentException("The percent should be in the range of [0, 100]");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof PercentCornerSize) && Float.compare(this.percent, ((PercentCornerSize) obj).percent) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.percent);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public final float mo111toPxTmRCtEA(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return (this.percent / 100.0f) * Size.m275getMinDimensionimpl(j);
    }

    public final String toString() {
        return "CornerSize(size = " + this.percent + "%)";
    }
}
