package androidx.compose.foundation.shape;

import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RoundedCornerShape.kt */
/* loaded from: classes.dex */
public final class RoundedCornerShape extends CornerBasedShape {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerShape(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart) {
        super(topStart, topEnd, bottomEnd, bottomStart);
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    public final RoundedCornerShape copy(CornerSize topStart, CornerSize topEnd, CornerSize bottomEnd, CornerSize bottomStart) {
        Intrinsics.checkNotNullParameter(topStart, "topStart");
        Intrinsics.checkNotNullParameter(topEnd, "topEnd");
        Intrinsics.checkNotNullParameter(bottomEnd, "bottomEnd");
        Intrinsics.checkNotNullParameter(bottomStart, "bottomStart");
        return new RoundedCornerShape(topStart, topEnd, bottomEnd, bottomStart);
    }

    @Override // androidx.compose.foundation.shape.CornerBasedShape
    /* renamed from: createOutline-LjSzlW0 */
    public final Outline mo110createOutlineLjSzlW0(long j, float f, float f2, float f3, float f4, LayoutDirection layoutDirection) {
        boolean z;
        float f5;
        float f6;
        float f7;
        float f8;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (f + f2 + f3 + f4 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new Outline.Rectangle(RectKt.m271Recttz77jQw(Offset.Zero, j));
        }
        Rect m271Recttz77jQw = RectKt.m271Recttz77jQw(Offset.Zero, j);
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        if (layoutDirection == layoutDirection2) {
            f5 = f;
        } else {
            f5 = f2;
        }
        long CornerRadius = CornerRadiusKt.CornerRadius(f5, f5);
        if (layoutDirection == layoutDirection2) {
            f6 = f2;
        } else {
            f6 = f;
        }
        long CornerRadius2 = CornerRadiusKt.CornerRadius(f6, f6);
        if (layoutDirection == layoutDirection2) {
            f7 = f3;
        } else {
            f7 = f4;
        }
        long CornerRadius3 = CornerRadiusKt.CornerRadius(f7, f7);
        if (layoutDirection == layoutDirection2) {
            f8 = f4;
        } else {
            f8 = f3;
        }
        return new Outline.Rounded(new RoundRect(m271Recttz77jQw.left, m271Recttz77jQw.top, m271Recttz77jQw.right, m271Recttz77jQw.bottom, CornerRadius, CornerRadius2, CornerRadius3, CornerRadiusKt.CornerRadius(f8, f8)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundedCornerShape)) {
            return false;
        }
        RoundedCornerShape roundedCornerShape = (RoundedCornerShape) obj;
        if (!Intrinsics.areEqual(this.topStart, roundedCornerShape.topStart)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.topEnd, roundedCornerShape.topEnd)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.bottomEnd, roundedCornerShape.bottomEnd)) {
            return false;
        }
        if (Intrinsics.areEqual(this.bottomStart, roundedCornerShape.bottomStart)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.bottomStart.hashCode() + ((this.bottomEnd.hashCode() + ((this.topEnd.hashCode() + (this.topStart.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "RoundedCornerShape(topStart = " + this.topStart + ", topEnd = " + this.topEnd + ", bottomEnd = " + this.bottomEnd + ", bottomStart = " + this.bottomStart + ')';
    }
}
