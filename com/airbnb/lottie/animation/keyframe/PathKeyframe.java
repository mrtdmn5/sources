package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

/* loaded from: classes.dex */
public final class PathKeyframe extends Keyframe<PointF> {
    public Path path;
    public final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.startValue, keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void createPath() {
        boolean z;
        T t;
        T t2 = this.endValue;
        T t3 = this.startValue;
        if (t2 != 0 && t3 != 0 && ((PointF) t3).equals(((PointF) t2).x, ((PointF) t2).y)) {
            z = true;
        } else {
            z = false;
        }
        if (t3 != 0 && (t = this.endValue) != 0 && !z) {
            PointF pointF = (PointF) t3;
            PointF pointF2 = (PointF) t;
            Keyframe<PointF> keyframe = this.pointKeyFrame;
            PointF pointF3 = keyframe.pathCp1;
            PointF pointF4 = keyframe.pathCp2;
            Utils.AnonymousClass1 anonymousClass1 = Utils.threadLocalPathMeasure;
            Path path = new Path();
            path.moveTo(pointF.x, pointF.y);
            if (pointF3 != null && pointF4 != null && (pointF3.length() != 0.0f || pointF4.length() != 0.0f)) {
                float f = pointF3.x + pointF.x;
                float f2 = pointF.y + pointF3.y;
                float f3 = pointF2.x;
                float f4 = f3 + pointF4.x;
                float f5 = pointF2.y;
                path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
            } else {
                path.lineTo(pointF2.x, pointF2.y);
            }
            this.path = path;
        }
    }
}
