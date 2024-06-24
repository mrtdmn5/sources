package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public final float getFloatValue(Keyframe<Float> keyframe, float f) {
        Float f2;
        if (keyframe.startValue != null && keyframe.endValue != null) {
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            Float f3 = keyframe.startValue;
            if (lottieValueCallback != 0 && (f2 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), f3, keyframe.endValue, f, getLinearCurrentKeyframeProgress(), this.progress)) != null) {
                return f2.floatValue();
            }
            if (keyframe.startValueFloat == -3987645.8f) {
                keyframe.startValueFloat = f3.floatValue();
            }
            float f4 = keyframe.startValueFloat;
            if (keyframe.endValueFloat == -3987645.8f) {
                keyframe.endValueFloat = keyframe.endValue.floatValue();
            }
            float f5 = keyframe.endValueFloat;
            PointF pointF = MiscUtils.pathFromDataCurrentPoint;
            return DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f5, f4, f, f4);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        return Float.valueOf(getFloatValue(keyframe, f));
    }

    public final float getFloatValue() {
        return getFloatValue(getCurrentKeyframe(), getInterpolatedCurrentKeyframeProgress());
    }
}
