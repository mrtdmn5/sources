package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class TextKeyframeAnimation extends KeyframeAnimation<DocumentData> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        T t;
        float floatValue;
        DocumentData documentData;
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        T t2 = keyframe.startValue;
        if (lottieValueCallback != 0) {
            float f2 = keyframe.startFrame;
            Float f3 = keyframe.endFrame;
            if (f3 == null) {
                floatValue = Float.MAX_VALUE;
            } else {
                floatValue = f3.floatValue();
            }
            DocumentData documentData2 = (DocumentData) t2;
            T t3 = keyframe.endValue;
            if (t3 == 0) {
                documentData = documentData2;
            } else {
                documentData = (DocumentData) t3;
            }
            return (DocumentData) lottieValueCallback.getValueInternal(f2, floatValue, documentData2, documentData, f, getInterpolatedCurrentKeyframeProgress(), this.progress);
        }
        if (f == 1.0f && (t = keyframe.endValue) != 0) {
            return (DocumentData) t;
        }
        return (DocumentData) t2;
    }
}
