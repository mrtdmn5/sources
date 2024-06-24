package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;

/* loaded from: classes.dex */
public final class AnimatableIntegerValue extends BaseAnimatableValue<Integer, Integer> {
    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<Integer, Integer> createAnimation() {
        return new IntegerKeyframeAnimation(this.keyframes);
    }
}
