package androidx.compose.ui.geometry;

import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;

/* compiled from: RoundRect.kt */
/* loaded from: classes.dex */
public final class RoundRect {
    public final float bottom;
    public final long bottomLeftCornerRadius;
    public final long bottomRightCornerRadius;
    public final float left;
    public final float right;
    public final float top;
    public final long topLeftCornerRadius;
    public final long topRightCornerRadius;

    static {
        int r4 = CornerRadius.$r8$clinit;
        RoundRectKt.m272RoundRectgG7oq9Y(0.0f, 0.0f, 0.0f, 0.0f, CornerRadius.Zero);
    }

    public RoundRect(float f, float f2, float f3, float f4, long j, long j2, long j3, long j4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
        this.topLeftCornerRadius = j;
        this.topRightCornerRadius = j2;
        this.bottomRightCornerRadius = j3;
        this.bottomLeftCornerRadius = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoundRect)) {
            return false;
        }
        RoundRect roundRect = (RoundRect) obj;
        if (Float.compare(this.left, roundRect.left) == 0 && Float.compare(this.top, roundRect.top) == 0 && Float.compare(this.right, roundRect.right) == 0 && Float.compare(this.bottom, roundRect.bottom) == 0 && CornerRadius.m252equalsimpl0(this.topLeftCornerRadius, roundRect.topLeftCornerRadius) && CornerRadius.m252equalsimpl0(this.topRightCornerRadius, roundRect.topRightCornerRadius) && CornerRadius.m252equalsimpl0(this.bottomRightCornerRadius, roundRect.bottomRightCornerRadius) && CornerRadius.m252equalsimpl0(this.bottomLeftCornerRadius, roundRect.bottomLeftCornerRadius)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.bottom, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.right, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, Float.hashCode(this.left) * 31, 31), 31), 31);
        int r1 = CornerRadius.$r8$clinit;
        return Long.hashCode(this.bottomLeftCornerRadius) + Scale$$ExternalSyntheticOutline0.m(this.bottomRightCornerRadius, Scale$$ExternalSyntheticOutline0.m(this.topRightCornerRadius, Scale$$ExternalSyntheticOutline0.m(this.topLeftCornerRadius, m, 31), 31), 31);
    }

    public final String toString() {
        boolean z;
        String str = GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom);
        long j = this.topLeftCornerRadius;
        long j2 = this.topRightCornerRadius;
        boolean m252equalsimpl0 = CornerRadius.m252equalsimpl0(j, j2);
        long j3 = this.bottomRightCornerRadius;
        long j4 = this.bottomLeftCornerRadius;
        if (m252equalsimpl0 && CornerRadius.m252equalsimpl0(j2, j3) && CornerRadius.m252equalsimpl0(j3, j4)) {
            if (CornerRadius.m253getXimpl(j) == CornerRadius.m254getYimpl(j)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("RoundRect(rect=", str, ", radius=");
                m.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m253getXimpl(j)));
                m.append(')');
                return m.toString();
            }
            StringBuilder m2 = ActivityResultRegistry$$ExternalSyntheticOutline0.m("RoundRect(rect=", str, ", x=");
            m2.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m253getXimpl(j)));
            m2.append(", y=");
            m2.append(GeometryUtilsKt.toStringAsFixed(CornerRadius.m254getYimpl(j)));
            m2.append(')');
            return m2.toString();
        }
        StringBuilder m3 = ActivityResultRegistry$$ExternalSyntheticOutline0.m("RoundRect(rect=", str, ", topLeft=");
        m3.append((Object) CornerRadius.m255toStringimpl(j));
        m3.append(", topRight=");
        m3.append((Object) CornerRadius.m255toStringimpl(j2));
        m3.append(", bottomRight=");
        m3.append((Object) CornerRadius.m255toStringimpl(j3));
        m3.append(", bottomLeft=");
        m3.append((Object) CornerRadius.m255toStringimpl(j4));
        m3.append(')');
        return m3.toString();
    }
}
