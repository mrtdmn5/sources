package androidx.compose.ui.graphics.colorspace;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;

/* compiled from: WhitePoint.kt */
/* loaded from: classes.dex */
public final class WhitePoint {
    public final float x;
    public final float y;

    public WhitePoint(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitePoint)) {
            return false;
        }
        WhitePoint whitePoint = (WhitePoint) obj;
        if (Float.compare(this.x, whitePoint.x) == 0 && Float.compare(this.y, whitePoint.y) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("WhitePoint(x=");
        sb.append(this.x);
        sb.append(", y=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y, ')');
    }

    public final float[] toXyz$ui_graphics_release() {
        float f = this.x;
        float f2 = this.y;
        return new float[]{f / f2, 1.0f, ((1.0f - f) - f2) / f2};
    }
}
