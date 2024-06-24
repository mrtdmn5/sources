package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public AnimatableFloatValue(ArrayList arrayList) {
        super(arrayList);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<Float, Float> createAnimation() {
        return new FloatKeyframeAnimation(this.keyframes);
    }
}
