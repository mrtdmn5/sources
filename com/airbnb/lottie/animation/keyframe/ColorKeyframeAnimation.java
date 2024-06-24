package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public final int getIntValue(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            Integer num2 = keyframe.startValue;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), num2, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), this.progress)) != null) {
                return num.intValue();
            }
            return GammaEvaluator.evaluate(num2.intValue(), MiscUtils.clamp(f, 0.0f, 1.0f), keyframe.endValue.intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        return Integer.valueOf(getIntValue(keyframe, f));
    }
}
