package androidx.compose.material;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.YieldKt;

/* compiled from: Swipeable.kt */
/* loaded from: classes.dex */
public final class FractionalThreshold implements ThresholdConfig {
    public final float fraction = 0.5f;

    @Override // androidx.compose.material.ThresholdConfig
    public final float computeThreshold(Density density, float f, float f2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return YieldKt.lerp(f, f2, this.fraction);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FractionalThreshold) && Float.compare(this.fraction, ((FractionalThreshold) obj).fraction) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.fraction);
    }

    public final String toString() {
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("FractionalThreshold(fraction="), this.fraction, ')');
    }
}
