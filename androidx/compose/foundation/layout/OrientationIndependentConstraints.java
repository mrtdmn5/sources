package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnImpl.kt */
/* loaded from: classes.dex */
public final class OrientationIndependentConstraints {
    /* renamed from: toBoxConstraints-OenEA2s, reason: not valid java name */
    public static final long m70toBoxConstraintsOenEA2s(long j, LayoutOrientation orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        if (orientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j), Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j));
        }
        return ConstraintsKt.Constraints(Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j), Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j));
    }
}
