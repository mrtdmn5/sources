package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public final int getIntValue(Keyframe<Integer> keyframe, float f) {
        Integer num;
        Integer num2 = keyframe.startValue;
        if (num2 != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), num2, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), this.progress)) != null) {
                return num.intValue();
            }
            if (keyframe.startValueInt == 784923401) {
                keyframe.startValueInt = num2.intValue();
            }
            int r0 = keyframe.startValueInt;
            if (keyframe.endValueInt == 784923401) {
                keyframe.endValueInt = keyframe.endValue.intValue();
            }
            int r11 = keyframe.endValueInt;
            PointF pointF = MiscUtils.pathFromDataCurrentPoint;
            return (int) ((f * (r11 - r0)) + r0);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        return Integer.valueOf(getIntValue(keyframe, f));
    }
}
