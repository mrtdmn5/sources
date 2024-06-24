package androidx.compose.material.ripple;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleAnimation.kt */
/* loaded from: classes.dex */
public final class RippleAnimationKt {
    public static final float BoundedRippleExtraRadius = 10;

    /* renamed from: getRippleEndRadius-cSwnlzA, reason: not valid java name */
    public static final float m221getRippleEndRadiuscSwnlzA(Density getRippleEndRadius, boolean z, long j) {
        Intrinsics.checkNotNullParameter(getRippleEndRadius, "$this$getRippleEndRadius");
        float m258getDistanceimpl = Offset.m258getDistanceimpl(OffsetKt.Offset(Size.m276getWidthimpl(j), Size.m274getHeightimpl(j))) / 2.0f;
        if (z) {
            return m258getDistanceimpl + getRippleEndRadius.mo49toPx0680j_4(BoundedRippleExtraRadius);
        }
        return m258getDistanceimpl;
    }
}
