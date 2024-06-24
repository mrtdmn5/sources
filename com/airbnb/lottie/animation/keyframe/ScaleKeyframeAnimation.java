package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes.dex */
public final class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {
    public final ScaleXY scaleXY;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.scaleXY = new ScaleXY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        T t;
        ScaleXY scaleXY;
        T t2 = keyframe.startValue;
        if (t2 != 0 && (t = keyframe.endValue) != 0) {
            ScaleXY scaleXY2 = (ScaleXY) t2;
            ScaleXY scaleXY3 = (ScaleXY) t;
            LottieValueCallback<A> lottieValueCallback = this.valueCallback;
            if (lottieValueCallback == 0 || (scaleXY = (ScaleXY) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), scaleXY2, scaleXY3, f, getLinearCurrentKeyframeProgress(), this.progress)) == null) {
                float f2 = scaleXY2.scaleX;
                float f3 = scaleXY3.scaleX;
                PointF pointF = MiscUtils.pathFromDataCurrentPoint;
                float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
                float f4 = scaleXY2.scaleY;
                float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(scaleXY3.scaleY, f4, f, f4);
                ScaleXY scaleXY4 = this.scaleXY;
                scaleXY4.scaleX = m;
                scaleXY4.scaleY = m2;
                return scaleXY4;
            }
            return scaleXY;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
