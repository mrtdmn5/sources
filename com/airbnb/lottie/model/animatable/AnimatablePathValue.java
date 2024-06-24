package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PathKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AnimatablePathValue implements AnimatableValue<PointF, PointF> {
    public final List<Keyframe<PointF>> keyframes;

    public AnimatablePathValue(ArrayList arrayList) {
        this.keyframes = arrayList;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation<PointF, PointF> createAnimation() {
        List<Keyframe<PointF>> list = this.keyframes;
        if (list.get(0).isStatic()) {
            return new PointKeyframeAnimation(list);
        }
        return new PathKeyframeAnimation(list);
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final List<Keyframe<PointF>> getKeyframes() {
        return this.keyframes;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final boolean isStatic() {
        List<Keyframe<PointF>> list = this.keyframes;
        if (list.size() != 1 || !list.get(0).isStatic()) {
            return false;
        }
        return true;
    }
}
