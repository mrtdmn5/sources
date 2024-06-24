package androidx.compose.foundation.layout;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes.dex */
public final class PaddingValuesImpl implements PaddingValues {
    public final float bottom;
    public final float end;
    public final float start;
    public final float top;

    public PaddingValuesImpl(float f, float f2, float f3, float f4) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateBottomPadding-D9Ej5fM */
    public final float mo76calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateLeftPadding-u2uoSUM */
    public final float mo77calculateLeftPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.start;
        }
        return this.end;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateRightPadding-u2uoSUM */
    public final float mo78calculateRightPaddingu2uoSUM(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.end;
        }
        return this.start;
    }

    @Override // androidx.compose.foundation.layout.PaddingValues
    /* renamed from: calculateTopPadding-D9Ej5fM */
    public final float mo79calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        if (!Dp.m579equalsimpl0(this.start, paddingValuesImpl.start) || !Dp.m579equalsimpl0(this.top, paddingValuesImpl.top) || !Dp.m579equalsimpl0(this.end, paddingValuesImpl.end) || !Dp.m579equalsimpl0(this.bottom, paddingValuesImpl.bottom)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.end, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, Float.hashCode(this.start) * 31, 31), 31);
    }

    public final String toString() {
        return "PaddingValues(start=" + ((Object) Dp.m580toStringimpl(this.start)) + ", top=" + ((Object) Dp.m580toStringimpl(this.top)) + ", end=" + ((Object) Dp.m580toStringimpl(this.end)) + ", bottom=" + ((Object) Dp.m580toStringimpl(this.bottom)) + ')';
    }
}
