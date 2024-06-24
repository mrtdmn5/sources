package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public final class PointKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PointF point;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.point = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* bridge */ /* synthetic */ Object getValue(Keyframe keyframe, float f, float f2, float f3) {
        return getValue((Keyframe<PointF>) keyframe, f, f2, f3);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        return getValue((Keyframe<PointF>) keyframe, f, f, f);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final PointF getValue(Keyframe<PointF> keyframe, float f, float f2, float f3) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = keyframe.startValue;
        if (pointF3 != null && (pointF = keyframe.endValue) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback != 0 && (pointF2 = (PointF) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), pointF4, pointF5, f, getLinearCurrentKeyframeProgress(), this.progress)) != null) {
                return pointF2;
            }
            PointF pointF6 = this.point;
            float f4 = pointF4.x;
            float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF5.x, f4, f2, f4);
            float f5 = pointF4.y;
            pointF6.set(m, ((pointF5.y - f5) * f3) + f5);
            return pointF6;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
