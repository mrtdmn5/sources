package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class RoundedCornersContent implements ShapeModifierContent, BaseKeyframeAnimation.AnimationListener {
    public final LottieDrawable lottieDrawable;
    public final BaseKeyframeAnimation<Float, Float> roundedCorners;
    public ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RoundedCorners roundedCorners) {
        this.lottieDrawable = lottieDrawable;
        roundedCorners.getClass();
        BaseKeyframeAnimation<Float, Float> createAnimation = roundedCorners.cornerRadius.createAnimation();
        this.roundedCorners = createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
    }

    public static int floorMod(int r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0 && r3 * r0 != r2) {
            r0--;
        }
        return r2 - (r0 * r3);
    }

    @Override // com.airbnb.lottie.animation.content.ShapeModifierContent
    public final ShapeData modifyShape(ShapeData shapeData) {
        PointF pointF;
        PointF pointF2;
        boolean z;
        ArrayList arrayList;
        float f;
        int r0;
        PointF pointF3;
        PointF pointF4;
        boolean z2;
        ShapeData shapeData2 = shapeData;
        ArrayList arrayList2 = shapeData2.curves;
        if (arrayList2.size() <= 2) {
            return shapeData2;
        }
        float floatValue = this.roundedCorners.getValue().floatValue();
        if (floatValue == 0.0f) {
            return shapeData2;
        }
        ArrayList arrayList3 = shapeData2.curves;
        boolean z3 = shapeData2.closed;
        int size = arrayList3.size() - 1;
        int r9 = 0;
        int r10 = 0;
        while (size >= 0) {
            CubicCurveData cubicCurveData = (CubicCurveData) arrayList3.get(size);
            int r12 = size - 1;
            CubicCurveData cubicCurveData2 = (CubicCurveData) arrayList3.get(floorMod(r12, arrayList3.size()));
            if (size == 0 && !z3) {
                pointF3 = shapeData2.initialPoint;
            } else {
                pointF3 = cubicCurveData2.vertex;
            }
            if (size == 0 && !z3) {
                pointF4 = pointF3;
            } else {
                pointF4 = cubicCurveData2.controlPoint2;
            }
            PointF pointF5 = cubicCurveData.controlPoint1;
            if (!shapeData2.closed && size == 0 && size == arrayList3.size() - 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (pointF4.equals(pointF3) && pointF5.equals(pointF3) && !z2) {
                r10 += 2;
            } else {
                r10++;
            }
            size = r12;
        }
        ShapeData shapeData3 = this.shapeData;
        if (shapeData3 == null || shapeData3.curves.size() != r10) {
            ArrayList arrayList4 = new ArrayList(r10);
            for (int r7 = 0; r7 < r10; r7++) {
                arrayList4.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList4);
        }
        ShapeData shapeData4 = this.shapeData;
        shapeData4.closed = z3;
        PointF pointF6 = shapeData2.initialPoint;
        shapeData4.setInitialPoint(pointF6.x, pointF6.y);
        ArrayList arrayList5 = shapeData4.curves;
        boolean z4 = shapeData2.closed;
        int r72 = 0;
        while (r9 < arrayList2.size()) {
            CubicCurveData cubicCurveData3 = (CubicCurveData) arrayList2.get(r9);
            CubicCurveData cubicCurveData4 = (CubicCurveData) arrayList2.get(floorMod(r9 - 1, arrayList2.size()));
            CubicCurveData cubicCurveData5 = (CubicCurveData) arrayList2.get(floorMod(r9 - 2, arrayList2.size()));
            if (r9 == 0 && !z4) {
                pointF = shapeData2.initialPoint;
            } else {
                pointF = cubicCurveData4.vertex;
            }
            if (r9 == 0 && !z4) {
                pointF2 = pointF;
            } else {
                pointF2 = cubicCurveData4.controlPoint2;
            }
            PointF pointF7 = cubicCurveData3.controlPoint1;
            PointF pointF8 = cubicCurveData5.vertex;
            if (!shapeData2.closed && r9 == 0 && r9 == arrayList2.size() - 1) {
                z = true;
            } else {
                z = false;
            }
            boolean equals = pointF2.equals(pointF);
            PointF pointF9 = cubicCurveData3.vertex;
            if (equals && pointF7.equals(pointF) && !z) {
                float f2 = pointF.x;
                float f3 = f2 - pointF8.x;
                float f4 = pointF.y;
                float f5 = f4 - pointF8.y;
                float f6 = pointF9.x - f2;
                float f7 = pointF9.y - f4;
                arrayList = arrayList2;
                float hypot = (float) Math.hypot(f3, f5);
                double d = f6;
                r0 = r9;
                float hypot2 = (float) Math.hypot(d, f7);
                float min = Math.min(floatValue / hypot, 0.5f);
                float min2 = Math.min(floatValue / hypot2, 0.5f);
                float f8 = pointF.x;
                float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF8.x, f8, min, f8);
                float f9 = pointF.y;
                float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF8.y, f9, min, f9);
                float m3 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF9.x, f8, min2, f8);
                float m4 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF9.y, f9, min2, f9);
                float f10 = m - ((m - f8) * 0.5519f);
                float f11 = m2 - ((m2 - f9) * 0.5519f);
                float f12 = m3 - ((m3 - f8) * 0.5519f);
                float f13 = m4 - ((m4 - f9) * 0.5519f);
                CubicCurveData cubicCurveData6 = (CubicCurveData) arrayList5.get(floorMod(r72 - 1, arrayList5.size()));
                CubicCurveData cubicCurveData7 = (CubicCurveData) arrayList5.get(r72);
                f = floatValue;
                cubicCurveData6.controlPoint2.set(m, m2);
                cubicCurveData6.vertex.set(m, m2);
                if (r0 == 0) {
                    shapeData4.setInitialPoint(m, m2);
                }
                cubicCurveData7.controlPoint1.set(f10, f11);
                r72++;
                CubicCurveData cubicCurveData8 = (CubicCurveData) arrayList5.get(r72);
                cubicCurveData7.controlPoint2.set(f12, f13);
                cubicCurveData7.vertex.set(m3, m4);
                cubicCurveData8.controlPoint1.set(m3, m4);
            } else {
                arrayList = arrayList2;
                f = floatValue;
                r0 = r9;
                CubicCurveData cubicCurveData9 = (CubicCurveData) arrayList5.get(floorMod(r72 - 1, arrayList5.size()));
                CubicCurveData cubicCurveData10 = (CubicCurveData) arrayList5.get(r72);
                PointF pointF10 = cubicCurveData4.vertex;
                cubicCurveData9.controlPoint2.set(pointF10.x, pointF10.y);
                PointF pointF11 = cubicCurveData4.vertex;
                cubicCurveData9.vertex.set(pointF11.x, pointF11.y);
                cubicCurveData10.controlPoint1.set(pointF9.x, pointF9.y);
            }
            r72++;
            r9 = r0 + 1;
            shapeData2 = shapeData;
            arrayList2 = arrayList;
            floatValue = f;
        }
        return shapeData4;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
    }
}
