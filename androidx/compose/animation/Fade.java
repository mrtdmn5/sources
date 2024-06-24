package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterExitTransition.kt */
/* loaded from: classes.dex */
public final class Fade {
    public final float alpha;
    public final FiniteAnimationSpec<Float> animationSpec;

    public Fade(float f, FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.alpha = f;
        this.animationSpec = finiteAnimationSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fade)) {
            return false;
        }
        Fade fade = (Fade) obj;
        if (Float.compare(this.alpha, fade.alpha) == 0 && Intrinsics.areEqual(this.animationSpec, fade.animationSpec)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.animationSpec.hashCode() + (Float.hashCode(this.alpha) * 31);
    }

    public final String toString() {
        return "Fade(alpha=" + this.alpha + ", animationSpec=" + this.animationSpec + ')';
    }
}
