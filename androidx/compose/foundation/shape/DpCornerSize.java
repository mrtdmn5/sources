package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
public final class DpCornerSize implements CornerSize {
    public final float size;

    public DpCornerSize(float f) {
        this.size = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof DpCornerSize) && Dp.m579equalsimpl0(this.size, ((DpCornerSize) obj).size)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public final float mo111toPxTmRCtEA(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return density.mo49toPx0680j_4(this.size);
    }

    public final String toString() {
        return "CornerSize(size = " + this.size + ".dp)";
    }
}
