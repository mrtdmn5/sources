package androidx.compose.ui.layout;

import androidx.compose.ui.unit.Constraints;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layout.kt */
/* loaded from: classes.dex */
public final class DefaultIntrinsicMeasurable implements Measurable {
    public final IntrinsicMeasurable measurable;
    public final IntrinsicMinMax minMax;
    public final IntrinsicWidthHeight widthHeight;

    public DefaultIntrinsicMeasurable(IntrinsicMeasurable measurable, IntrinsicMinMax minMax, IntrinsicWidthHeight widthHeight) {
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        this.measurable = measurable;
        this.minMax = minMax;
        this.widthHeight = widthHeight;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final Object getParentData() {
        return this.measurable.getParentData();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicHeight(int r2) {
        return this.measurable.maxIntrinsicHeight(r2);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicWidth(int r2) {
        return this.measurable.maxIntrinsicWidth(r2);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0, reason: not valid java name */
    public final Placeable mo421measureBRTryo0(long j) {
        int minIntrinsicHeight;
        int minIntrinsicWidth;
        IntrinsicWidthHeight intrinsicWidthHeight = this.widthHeight;
        IntrinsicWidthHeight intrinsicWidthHeight2 = IntrinsicWidthHeight.Width;
        IntrinsicMinMax intrinsicMinMax = this.minMax;
        IntrinsicMeasurable intrinsicMeasurable = this.measurable;
        if (intrinsicWidthHeight == intrinsicWidthHeight2) {
            if (intrinsicMinMax == IntrinsicMinMax.Max) {
                minIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m564getMaxHeightimpl(j));
            } else {
                minIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m564getMaxHeightimpl(j));
            }
            return new FixedSizeIntrinsicsPlaceable(minIntrinsicWidth, Constraints.m564getMaxHeightimpl(j));
        }
        if (intrinsicMinMax == IntrinsicMinMax.Max) {
            minIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m565getMaxWidthimpl(j));
        } else {
            minIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m565getMaxWidthimpl(j));
        }
        return new FixedSizeIntrinsicsPlaceable(Constraints.m565getMaxWidthimpl(j), minIntrinsicHeight);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicHeight(int r2) {
        return this.measurable.minIntrinsicHeight(r2);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicWidth(int r2) {
        return this.measurable.minIntrinsicWidth(r2);
    }
}
