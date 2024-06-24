package androidx.compose.foundation.shape;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CornerSize.kt */
/* loaded from: classes.dex */
public final class CornerSizeKt$ZeroCornerSize$1 implements CornerSize {
    @Override // androidx.compose.foundation.shape.CornerSize
    /* renamed from: toPx-TmRCtEA */
    public final float mo111toPxTmRCtEA(long j, Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return 0.0f;
    }

    public final String toString() {
        return "ZeroCornerSize";
    }
}
