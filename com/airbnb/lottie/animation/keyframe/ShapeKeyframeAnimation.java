package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.animation.content.ShapeModifierContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ShapeKeyframeAnimation extends BaseKeyframeAnimation<ShapeData, Path> {
    public List<ShapeModifierContent> shapeModifiers;
    public final Path tempPath;
    public final ShapeData tempShapeData;

    public ShapeKeyframeAnimation(List<Keyframe<ShapeData>> list) {
        super(list);
        this.tempShapeData = new ShapeData();
        this.tempPath = new Path();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Path getValue(Keyframe<ShapeData> keyframe, float f) {
        boolean z;
        ShapeData shapeData = keyframe.startValue;
        ShapeData shapeData2 = keyframe.endValue;
        ShapeData shapeData3 = this.tempShapeData;
        if (shapeData3.initialPoint == null) {
            shapeData3.initialPoint = new PointF();
        }
        int r4 = 0;
        if (!shapeData.closed && !shapeData2.closed) {
            z = false;
        } else {
            z = true;
        }
        shapeData3.closed = z;
        ArrayList arrayList = shapeData.curves;
        int size = arrayList.size();
        int size2 = shapeData2.curves.size();
        ArrayList arrayList2 = shapeData2.curves;
        if (size != size2) {
            Logger.warning("Curves must have the same number of control points. Shape 1: " + arrayList.size() + "\tShape 2: " + arrayList2.size());
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        ArrayList arrayList3 = shapeData3.curves;
        if (arrayList3.size() < min) {
            for (int size3 = arrayList3.size(); size3 < min; size3++) {
                arrayList3.add(new CubicCurveData());
            }
        } else if (arrayList3.size() > min) {
            for (int size4 = arrayList3.size() - 1; size4 >= min; size4--) {
                arrayList3.remove(arrayList3.size() - 1);
            }
        }
        PointF pointF = shapeData.initialPoint;
        PointF pointF2 = shapeData2.initialPoint;
        float f2 = pointF.x;
        float f3 = pointF2.x;
        PointF pointF3 = MiscUtils.pathFromDataCurrentPoint;
        float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f3, f2, f, f2);
        float f4 = pointF.y;
        shapeData3.setInitialPoint(m, ((pointF2.y - f4) * f) + f4);
        for (int size5 = arrayList3.size() - 1; size5 >= 0; size5--) {
            CubicCurveData cubicCurveData = (CubicCurveData) arrayList.get(size5);
            CubicCurveData cubicCurveData2 = (CubicCurveData) arrayList2.get(size5);
            PointF pointF4 = cubicCurveData.controlPoint1;
            PointF pointF5 = cubicCurveData2.controlPoint1;
            CubicCurveData cubicCurveData3 = (CubicCurveData) arrayList3.get(size5);
            float f5 = pointF4.x;
            float m2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF5.x, f5, f, f5);
            float f6 = pointF4.y;
            cubicCurveData3.controlPoint1.set(m2, DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF5.y, f6, f, f6));
            CubicCurveData cubicCurveData4 = (CubicCurveData) arrayList3.get(size5);
            PointF pointF6 = cubicCurveData.controlPoint2;
            float f7 = pointF6.x;
            PointF pointF7 = cubicCurveData2.controlPoint2;
            float m3 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF7.x, f7, f, f7);
            float f8 = pointF6.y;
            cubicCurveData4.controlPoint2.set(m3, DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF7.y, f8, f, f8));
            CubicCurveData cubicCurveData5 = (CubicCurveData) arrayList3.get(size5);
            PointF pointF8 = cubicCurveData.vertex;
            float f9 = pointF8.x;
            PointF pointF9 = cubicCurveData2.vertex;
            float m4 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF9.x, f9, f, f9);
            float f10 = pointF8.y;
            cubicCurveData5.vertex.set(m4, DrawerArrowDrawable$$ExternalSyntheticOutline0.m(pointF9.y, f10, f, f10));
        }
        List<ShapeModifierContent> list = this.shapeModifiers;
        if (list != null) {
            for (int size6 = list.size() - 1; size6 >= 0; size6--) {
                shapeData3 = this.shapeModifiers.get(size6).modifyShape(shapeData3);
            }
        }
        Path path = this.tempPath;
        path.reset();
        PointF pointF10 = shapeData3.initialPoint;
        path.moveTo(pointF10.x, pointF10.y);
        PointF pointF11 = MiscUtils.pathFromDataCurrentPoint;
        pointF11.set(pointF10.x, pointF10.y);
        while (true) {
            ArrayList arrayList4 = shapeData3.curves;
            if (r4 >= arrayList4.size()) {
                break;
            }
            CubicCurveData cubicCurveData6 = (CubicCurveData) arrayList4.get(r4);
            PointF pointF12 = cubicCurveData6.controlPoint1;
            boolean equals = pointF12.equals(pointF11);
            PointF pointF13 = cubicCurveData6.controlPoint2;
            PointF pointF14 = cubicCurveData6.vertex;
            if (equals && pointF13.equals(pointF14)) {
                path.lineTo(pointF14.x, pointF14.y);
            } else {
                path.cubicTo(pointF12.x, pointF12.y, pointF13.x, pointF13.y, pointF14.x, pointF14.y);
            }
            pointF11.set(pointF14.x, pointF14.y);
            r4++;
        }
        if (shapeData3.closed) {
            path.close();
        }
        return path;
    }
}
