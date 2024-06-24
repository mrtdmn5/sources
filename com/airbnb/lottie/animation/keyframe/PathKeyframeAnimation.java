package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes.dex */
public final class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    public final PathMeasure pathMeasure;
    public PathKeyframe pathMeasureKeyframe;
    public final PointF point;
    public final float[] pos;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.point = new PointF();
        this.pos = new float[2];
        this.pathMeasure = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.path;
        if (path == null) {
            return (PointF) keyframe.startValue;
        }
        LottieValueCallback<A> lottieValueCallback = this.valueCallback;
        if (lottieValueCallback == 0 || (pointF = (PointF) lottieValueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), (PointF) pathKeyframe.startValue, (PointF) pathKeyframe.endValue, getLinearCurrentKeyframeProgress(), f, this.progress)) == null) {
            PathKeyframe pathKeyframe2 = this.pathMeasureKeyframe;
            PathMeasure pathMeasure = this.pathMeasure;
            if (pathKeyframe2 != pathKeyframe) {
                pathMeasure.setPath(path, false);
                this.pathMeasureKeyframe = pathKeyframe;
            }
            float length = pathMeasure.getLength() * f;
            float[] fArr = this.pos;
            pathMeasure.getPosTan(length, fArr, null);
            PointF pointF2 = this.point;
            pointF2.set(fArr[0], fArr[1]);
            return pointF2;
        }
        return pointF;
    }
}
