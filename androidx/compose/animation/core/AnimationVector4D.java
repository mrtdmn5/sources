package androidx.compose.animation.core;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: AnimationVectors.kt */
/* loaded from: classes.dex */
public final class AnimationVector4D extends AnimationVector {
    public final int size = 4;
    public float v1;
    public float v2;
    public float v3;
    public float v4;

    public AnimationVector4D(float f, float f2, float f3, float f4) {
        this.v1 = f;
        this.v2 = f2;
        this.v3 = f3;
        this.v4 = f4;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (!(obj instanceof AnimationVector4D)) {
            return false;
        }
        AnimationVector4D animationVector4D = (AnimationVector4D) obj;
        if (animationVector4D.v1 == this.v1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (animationVector4D.v2 == this.v2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (animationVector4D.v3 == this.v3) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        if (animationVector4D.v4 == this.v4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core_release(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                if (r2 != 2) {
                    if (r2 != 3) {
                        return 0.0f;
                    }
                    return this.v4;
                }
                return this.v3;
            }
            return this.v2;
        }
        return this.v1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final int getSize$animation_core_release() {
        return this.size;
    }

    public final int hashCode() {
        return Float.hashCode(this.v4) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.v3, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.v2, Float.hashCode(this.v1) * 31, 31), 31);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core_release() {
        return new AnimationVector4D(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core_release() {
        this.v1 = 0.0f;
        this.v2 = 0.0f;
        this.v3 = 0.0f;
        this.v4 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core_release(float f, int r3) {
        if (r3 != 0) {
            if (r3 != 1) {
                if (r3 != 2) {
                    if (r3 == 3) {
                        this.v4 = f;
                        return;
                    }
                    return;
                }
                this.v3 = f;
                return;
            }
            this.v2 = f;
            return;
        }
        this.v1 = f;
    }

    public final String toString() {
        return "AnimationVector4D: v1 = " + this.v1 + ", v2 = " + this.v2 + ", v3 = " + this.v3 + ", v4 = " + this.v4;
    }
}
