package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    public final PointF point;
    public final PointF pointWithCallbackValues;
    public final BaseKeyframeAnimation<Float, Float> xAnimation;
    public LottieValueCallback<Float> xValueCallback;
    public final BaseKeyframeAnimation<Float, Float> yAnimation;
    public LottieValueCallback<Float> yValueCallback;

    public SplitDimensionPathKeyframeAnimation(FloatKeyframeAnimation floatKeyframeAnimation, FloatKeyframeAnimation floatKeyframeAnimation2) {
        super(Collections.emptyList());
        this.point = new PointF();
        this.pointWithCallbackValues = new PointF();
        this.xAnimation = floatKeyframeAnimation;
        this.yAnimation = floatKeyframeAnimation2;
        setProgress(this.progress);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* bridge */ /* synthetic */ PointF getValue(Keyframe<PointF> keyframe, float f) {
        return getValue(f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void setProgress(float f) {
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.xAnimation;
        baseKeyframeAnimation.setProgress(f);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.yAnimation;
        baseKeyframeAnimation2.setProgress(f);
        this.point.set(baseKeyframeAnimation.getValue().floatValue(), baseKeyframeAnimation2.getValue().floatValue());
        int r3 = 0;
        while (true) {
            ArrayList arrayList = this.listeners;
            if (r3 < arrayList.size()) {
                ((BaseKeyframeAnimation.AnimationListener) arrayList.get(r3)).onValueChanged();
                r3++;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final PointF getValue() {
        return getValue(0.0f);
    }

    public final PointF getValue(float f) {
        Float f2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        Keyframe<Float> currentKeyframe;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2;
        Keyframe<Float> currentKeyframe2;
        Float f3 = null;
        if (this.xValueCallback == null || (currentKeyframe2 = (baseKeyframeAnimation2 = this.xAnimation).getCurrentKeyframe()) == null) {
            f2 = null;
        } else {
            float interpolatedCurrentKeyframeProgress = baseKeyframeAnimation2.getInterpolatedCurrentKeyframeProgress();
            Float f4 = currentKeyframe2.endFrame;
            LottieValueCallback<Float> lottieValueCallback = this.xValueCallback;
            float f5 = currentKeyframe2.startFrame;
            f2 = lottieValueCallback.getValueInternal(f5, f4 == null ? f5 : f4.floatValue(), currentKeyframe2.startValue, currentKeyframe2.endValue, f, f, interpolatedCurrentKeyframeProgress);
        }
        if (this.yValueCallback != null && (currentKeyframe = (baseKeyframeAnimation = this.yAnimation).getCurrentKeyframe()) != null) {
            float interpolatedCurrentKeyframeProgress2 = baseKeyframeAnimation.getInterpolatedCurrentKeyframeProgress();
            Float f6 = currentKeyframe.endFrame;
            LottieValueCallback<Float> lottieValueCallback2 = this.yValueCallback;
            float f7 = currentKeyframe.startFrame;
            f3 = lottieValueCallback2.getValueInternal(f7, f6 == null ? f7 : f6.floatValue(), currentKeyframe.startValue, currentKeyframe.endValue, f, f, interpolatedCurrentKeyframeProgress2);
        }
        PointF pointF = this.point;
        PointF pointF2 = this.pointWithCallbackValues;
        if (f2 == null) {
            pointF2.set(pointF.x, 0.0f);
        } else {
            pointF2.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            pointF2.set(pointF2.x, pointF.y);
        } else {
            pointF2.set(pointF2.x, f3.floatValue());
        }
        return pointF2;
    }
}
