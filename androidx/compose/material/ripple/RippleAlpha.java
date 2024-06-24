package androidx.compose.material.ripple;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: RippleTheme.kt */
/* loaded from: classes.dex */
public final class RippleAlpha {
    public final float draggedAlpha;
    public final float focusedAlpha;
    public final float hoveredAlpha;
    public final float pressedAlpha;

    public RippleAlpha(float f, float f2, float f3, float f4) {
        this.draggedAlpha = f;
        this.focusedAlpha = f2;
        this.hoveredAlpha = f3;
        this.pressedAlpha = f4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RippleAlpha)) {
            return false;
        }
        RippleAlpha rippleAlpha = (RippleAlpha) obj;
        if (this.draggedAlpha == rippleAlpha.draggedAlpha) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.focusedAlpha == rippleAlpha.focusedAlpha) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.hoveredAlpha == rippleAlpha.hoveredAlpha) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        if (this.pressedAlpha == rippleAlpha.pressedAlpha) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.pressedAlpha) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.hoveredAlpha, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.focusedAlpha, Float.hashCode(this.draggedAlpha) * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RippleAlpha(draggedAlpha=");
        sb.append(this.draggedAlpha);
        sb.append(", focusedAlpha=");
        sb.append(this.focusedAlpha);
        sb.append(", hoveredAlpha=");
        sb.append(this.hoveredAlpha);
        sb.append(", pressedAlpha=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.pressedAlpha, ')');
    }
}
