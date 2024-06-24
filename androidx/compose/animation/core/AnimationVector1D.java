package androidx.compose.animation.core;

/* compiled from: AnimationVectors.kt */
/* loaded from: classes.dex */
public final class AnimationVector1D extends AnimationVector {
    public final int size = 1;
    public float value;

    public AnimationVector1D(float f) {
        this.value = f;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof AnimationVector1D)) {
            return false;
        }
        if (((AnimationVector1D) obj).value == this.value) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float get$animation_core_release(int r1) {
        if (r1 == 0) {
            return this.value;
        }
        return 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final int getSize$animation_core_release() {
        return this.size;
    }

    public final int hashCode() {
        return Float.hashCode(this.value);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final AnimationVector newVector$animation_core_release() {
        return new AnimationVector1D(0.0f);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void reset$animation_core_release() {
        this.value = 0.0f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void set$animation_core_release(float f, int r2) {
        if (r2 == 0) {
            this.value = f;
        }
    }

    public final String toString() {
        return "AnimationVector1D: value = " + this.value;
    }
}
