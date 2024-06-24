package androidx.compose.ui.geometry;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: Rect.kt */
/* loaded from: classes.dex */
public final class Rect {
    public static final Rect Zero = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
    public final float bottom;
    public final float left;
    public final float right;
    public final float top;

    public Rect(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    /* renamed from: contains-k-4lQ0M, reason: not valid java name */
    public final boolean m268containsk4lQ0M(long j) {
        if (Offset.m259getXimpl(j) >= this.left && Offset.m259getXimpl(j) < this.right && Offset.m260getYimpl(j) >= this.top && Offset.m260getYimpl(j) < this.bottom) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) obj;
        if (Float.compare(this.left, rect.left) == 0 && Float.compare(this.top, rect.top) == 0 && Float.compare(this.right, rect.right) == 0 && Float.compare(this.bottom, rect.bottom) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: getCenter-F1C5BW0, reason: not valid java name */
    public final long m269getCenterF1C5BW0() {
        float f = this.right;
        float f2 = this.left;
        float f3 = ((f - f2) / 2.0f) + f2;
        float f4 = this.bottom;
        float f5 = this.top;
        return OffsetKt.Offset(f3, ((f4 - f5) / 2.0f) + f5);
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.right, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, Float.hashCode(this.left) * 31, 31), 31);
    }

    public final Rect intersect(Rect rect) {
        return new Rect(Math.max(this.left, rect.left), Math.max(this.top, rect.top), Math.min(this.right, rect.right), Math.min(this.bottom, rect.bottom));
    }

    public final String toString() {
        return "Rect.fromLTRB(" + GeometryUtilsKt.toStringAsFixed(this.left) + ", " + GeometryUtilsKt.toStringAsFixed(this.top) + ", " + GeometryUtilsKt.toStringAsFixed(this.right) + ", " + GeometryUtilsKt.toStringAsFixed(this.bottom) + ')';
    }

    public final Rect translate(float f, float f2) {
        return new Rect(this.left + f, this.top + f2, this.right + f, this.bottom + f2);
    }

    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final Rect m270translatek4lQ0M(long j) {
        return new Rect(Offset.m259getXimpl(j) + this.left, Offset.m260getYimpl(j) + this.top, Offset.m259getXimpl(j) + this.right, Offset.m260getYimpl(j) + this.bottom);
    }
}
