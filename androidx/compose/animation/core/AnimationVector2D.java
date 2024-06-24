package androidx.compose.animation.core;

/* compiled from: AnimationVectors.kt */
/* loaded from: classes.dex */
public final class AnimationVector2D extends AnimationVector {
    public final int size = 2;
    public float v1;
    public float v2;

    public AnimationVector2D(float f, float f2) {
        this.v1 = f;
        this.v2 = f2;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof AnimationVector2D)) {
            return false;
        }
        AnimationVector2D animationVector2D = (AnimationVector2D) obj;
        if (animationVector2D.v1 == this.v1) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (animationVector2D.v2 == this.v2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core_release(int r2) {
        if (r2 != 0) {
            if (r2 != 1) {
                return 0.0f;
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
        return Float.hashCode(this.v2) + (Float.hashCode(this.v1) * 31);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core_release() {
        return new AnimationVector2D(0.0f, 0.0f);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core_release() {
        this.v1 = 0.0f;
        this.v2 = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core_release(float f, int r3) {
        if (r3 != 0) {
            if (r3 == 1) {
                this.v2 = f;
                return;
            }
            return;
        }
        this.v1 = f;
    }

    public final String toString() {
        return "AnimationVector2D: v1 = " + this.v1 + ", v2 = " + this.v2;
    }
}
