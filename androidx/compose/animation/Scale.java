package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.TransformOrigin;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class Scale {
    public final FiniteAnimationSpec<Float> animationSpec;
    public final float scale;
    public final long transformOrigin;

    public Scale() {
        throw null;
    }

    public Scale(float f, long j, FiniteAnimationSpec finiteAnimationSpec) {
        this.scale = f;
        this.transformOrigin = j;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scale)) {
            return false;
        }
        Scale scale = (Scale) obj;
        if (Float.compare(this.scale, scale.scale) != 0) {
            return false;
        }
        int r1 = TransformOrigin.$r8$clinit;
        if (this.transformOrigin == scale.transformOrigin) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(this.animationSpec, scale.animationSpec)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Float.hashCode(this.scale) * 31;
        int r1 = TransformOrigin.$r8$clinit;
        return this.animationSpec.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.transformOrigin, hashCode, 31);
    }

    public final String toString() {
        return "Scale(scale=" + this.scale + ", transformOrigin=" + ((Object) TransformOrigin.m346toStringimpl(this.transformOrigin)) + ", animationSpec=" + this.animationSpec + ')';
    }
}
