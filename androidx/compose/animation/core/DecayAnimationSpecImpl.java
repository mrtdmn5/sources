package androidx.compose.animation.core;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DecayAnimationSpec.kt */
/* loaded from: classes.dex */
public final class DecayAnimationSpecImpl<T> implements DecayAnimationSpec<T> {
    public final FloatDecayAnimationSpec floatDecaySpec;

    public DecayAnimationSpecImpl(SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec) {
        this.floatDecaySpec = splineBasedFloatDecayAnimationSpec;
    }

    @Override // androidx.compose.animation.core.DecayAnimationSpec
    public final VectorizedFloatDecaySpec vectorize(TwoWayConverter typeConverter) {
        Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
        return new VectorizedFloatDecaySpec(this.floatDecaySpec);
    }
}
