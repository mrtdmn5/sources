package androidx.compose.material;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: Swipeable.kt */
/* loaded from: classes.dex */
public final class ResistanceConfig {
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResistanceConfig)) {
            return false;
        }
        ResistanceConfig resistanceConfig = (ResistanceConfig) obj;
        resistanceConfig.getClass();
        if (0.0f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        resistanceConfig.getClass();
        if (0.0f == 0.0f) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        resistanceConfig.getClass();
        if (0.0f == 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(0.0f) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(0.0f, Float.hashCode(0.0f) * 31, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ResistanceConfig(basis=");
        sb.append(0.0f);
        sb.append(", factorAtMin=");
        sb.append(0.0f);
        sb.append(", factorAtMax=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, 0.0f, ')');
    }
}
