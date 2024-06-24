package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

/* loaded from: classes.dex */
public final class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    public final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        GradientColor gradientColor = list.get(0).startValue;
        int length = gradientColor != null ? gradientColor.colors.length : 0;
        this.gradientColor = new GradientColor(new float[length], new int[length]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object getValue(Keyframe keyframe, float f) {
        GradientColor gradientColor = (GradientColor) keyframe.startValue;
        GradientColor gradientColor2 = (GradientColor) keyframe.endValue;
        GradientColor gradientColor3 = this.gradientColor;
        gradientColor3.getClass();
        int[] r2 = gradientColor.colors;
        int length = r2.length;
        int[] r4 = gradientColor2.colors;
        if (length == r4.length) {
            for (int r3 = 0; r3 < r2.length; r3++) {
                float f2 = gradientColor.positions[r3];
                float f3 = gradientColor2.positions[r3];
                PointF pointF = MiscUtils.pathFromDataCurrentPoint;
                gradientColor3.positions[r3] = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
                gradientColor3.colors[r3] = GammaEvaluator.evaluate(r2[r3], f, r4[r3]);
            }
            return gradientColor3;
        }
        StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
        sb.append(r2.length);
        sb.append(" vs ");
        throw new IllegalArgumentException(ConstraintWidget$$ExternalSyntheticOutline0.m(sb, r4.length, ")"));
    }
}
