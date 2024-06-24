package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

/* loaded from: classes.dex */
public final class TransformKeyframeAnimation {
    public BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    public BaseKeyframeAnimation<?, Float> endOpacity;
    public final Matrix matrix = new Matrix();
    public BaseKeyframeAnimation<Integer, Integer> opacity;
    public BaseKeyframeAnimation<?, PointF> position;
    public BaseKeyframeAnimation<Float, Float> rotation;
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    public FloatKeyframeAnimation skew;
    public FloatKeyframeAnimation skewAngle;
    public final Matrix skewMatrix1;
    public final Matrix skewMatrix2;
    public final Matrix skewMatrix3;
    public final float[] skewValues;
    public BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        AnimatablePathValue animatablePathValue = animatableTransform.anchorPoint;
        if (animatablePathValue == null) {
            createAnimation = null;
        } else {
            createAnimation = animatablePathValue.createAnimation();
        }
        this.anchorPoint = createAnimation;
        AnimatableValue<PointF, PointF> animatableValue = animatableTransform.position;
        if (animatableValue == null) {
            createAnimation2 = null;
        } else {
            createAnimation2 = animatableValue.createAnimation();
        }
        this.position = createAnimation2;
        AnimatableScaleValue animatableScaleValue = animatableTransform.scale;
        if (animatableScaleValue == null) {
            createAnimation3 = null;
        } else {
            createAnimation3 = animatableScaleValue.createAnimation();
        }
        this.scale = createAnimation3;
        AnimatableFloatValue animatableFloatValue = animatableTransform.rotation;
        if (animatableFloatValue == null) {
            createAnimation4 = null;
        } else {
            createAnimation4 = animatableFloatValue.createAnimation();
        }
        this.rotation = createAnimation4;
        AnimatableFloatValue animatableFloatValue2 = animatableTransform.skew;
        if (animatableFloatValue2 == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableFloatValue2.createAnimation();
        }
        this.skew = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        AnimatableFloatValue animatableFloatValue3 = animatableTransform.skewAngle;
        if (animatableFloatValue3 == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableFloatValue3.createAnimation();
        }
        this.skewAngle = floatKeyframeAnimation2;
        AnimatableIntegerValue animatableIntegerValue = animatableTransform.opacity;
        if (animatableIntegerValue != null) {
            this.opacity = animatableIntegerValue.createAnimation();
        }
        AnimatableFloatValue animatableFloatValue4 = animatableTransform.startOpacity;
        if (animatableFloatValue4 != null) {
            this.startOpacity = animatableFloatValue4.createAnimation();
        } else {
            this.startOpacity = null;
        }
        AnimatableFloatValue animatableFloatValue5 = animatableTransform.endOpacity;
        if (animatableFloatValue5 != null) {
            this.endOpacity = animatableFloatValue5.createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    public final void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.skew);
        baseLayer.addAnimation(this.skewAngle);
    }

    public final void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public final boolean applyValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        if (obj == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.anchorPoint;
            if (baseKeyframeAnimation == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.position;
            if (baseKeyframeAnimation2 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_POSITION_X) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.position;
            if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3;
                LottieValueCallback<Float> lottieValueCallback2 = splitDimensionPathKeyframeAnimation.xValueCallback;
                splitDimensionPathKeyframeAnimation.xValueCallback = lottieValueCallback;
                return true;
            }
        }
        if (obj == LottieProperty.TRANSFORM_POSITION_Y) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
            if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                SplitDimensionPathKeyframeAnimation splitDimensionPathKeyframeAnimation2 = (SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4;
                LottieValueCallback<Float> lottieValueCallback3 = splitDimensionPathKeyframeAnimation2.yValueCallback;
                splitDimensionPathKeyframeAnimation2.yValueCallback = lottieValueCallback;
                return true;
            }
        }
        if (obj == LottieProperty.TRANSFORM_SCALE) {
            BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.scale;
            if (baseKeyframeAnimation5 == null) {
                this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                return true;
            }
            baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_ROTATION) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.rotation;
            if (baseKeyframeAnimation6 == null) {
                this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                return true;
            }
            baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_OPACITY) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
            if (baseKeyframeAnimation7 == null) {
                this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                return true;
            }
            baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_START_OPACITY) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.startOpacity;
            if (baseKeyframeAnimation8 == null) {
                this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_END_OPACITY) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.endOpacity;
            if (baseKeyframeAnimation9 == null) {
                this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                return true;
            }
            baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_SKEW) {
            if (this.skew == null) {
                this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.skew.setValueCallback(lottieValueCallback);
            return true;
        }
        if (obj == LottieProperty.TRANSFORM_SKEW_ANGLE) {
            if (this.skewAngle == null) {
                this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
            }
            this.skewAngle.setValueCallback(lottieValueCallback);
            return true;
        }
        return false;
    }

    public final Matrix getMatrix() {
        float cos;
        float sin;
        float[] fArr;
        float floatValue;
        PointF value;
        Matrix matrix = this.matrix;
        matrix.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        if (baseKeyframeAnimation != null && (value = baseKeyframeAnimation.getValue()) != null) {
            float f = value.x;
            if (f != 0.0f || value.y != 0.0f) {
                matrix.preTranslate(f, value.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.rotation;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                floatValue = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                floatValue = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (floatValue != 0.0f) {
                matrix.preRotate(floatValue);
            }
        }
        if (this.skew != null) {
            if (this.skewAngle == null) {
                cos = 0.0f;
            } else {
                cos = (float) Math.cos(Math.toRadians((-r5.getFloatValue()) + 90.0f));
            }
            if (this.skewAngle == null) {
                sin = 1.0f;
            } else {
                sin = (float) Math.sin(Math.toRadians((-r7.getFloatValue()) + 90.0f));
            }
            float tan = (float) Math.tan(Math.toRadians(r2.getFloatValue()));
            int r8 = 0;
            while (true) {
                fArr = this.skewValues;
                if (r8 >= 9) {
                    break;
                }
                fArr[r8] = 0.0f;
                r8++;
            }
            fArr[0] = cos;
            fArr[1] = sin;
            float f2 = -sin;
            fArr[3] = f2;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            Matrix matrix2 = this.skewMatrix1;
            matrix2.setValues(fArr);
            for (int r82 = 0; r82 < 9; r82++) {
                fArr[r82] = 0.0f;
            }
            fArr[0] = 1.0f;
            fArr[3] = tan;
            fArr[4] = 1.0f;
            fArr[8] = 1.0f;
            Matrix matrix3 = this.skewMatrix2;
            matrix3.setValues(fArr);
            for (int r83 = 0; r83 < 9; r83++) {
                fArr[r83] = 0.0f;
            }
            fArr[0] = cos;
            fArr[1] = f2;
            fArr[3] = sin;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            Matrix matrix4 = this.skewMatrix3;
            matrix4.setValues(fArr);
            matrix3.preConcat(matrix2);
            matrix4.preConcat(matrix3);
            matrix.preConcat(matrix4);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.scale;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY value2 = baseKeyframeAnimation3.getValue();
            float f3 = value2.scaleX;
            if (f3 != 1.0f || value2.scaleY != 1.0f) {
                matrix.preScale(f3, value2.scaleY);
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            PointF value3 = baseKeyframeAnimation4.getValue();
            float f4 = value3.x;
            if (f4 != 0.0f || value3.y != 0.0f) {
                matrix.preTranslate(-f4, -value3.y);
            }
        }
        return matrix;
    }

    public final Matrix getMatrixForRepeater(float f) {
        PointF value;
        ScaleXY value2;
        float f2;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        PointF pointF = null;
        if (baseKeyframeAnimation == null) {
            value = null;
        } else {
            value = baseKeyframeAnimation.getValue();
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.scale;
        if (baseKeyframeAnimation2 == null) {
            value2 = null;
        } else {
            value2 = baseKeyframeAnimation2.getValue();
        }
        Matrix matrix = this.matrix;
        matrix.reset();
        if (value != null) {
            matrix.preTranslate(value.x * f, value.y * f);
        }
        if (value2 != null) {
            double d = f;
            matrix.preScale((float) Math.pow(value2.scaleX, d), (float) Math.pow(value2.scaleY, d));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.rotation;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            if (baseKeyframeAnimation4 != null) {
                pointF = baseKeyframeAnimation4.getValue();
            }
            float f3 = floatValue * f;
            float f4 = 0.0f;
            if (pointF == null) {
                f2 = 0.0f;
            } else {
                f2 = pointF.x;
            }
            if (pointF != null) {
                f4 = pointF.y;
            }
            matrix.preRotate(f3, f2, f4);
        }
        return matrix;
    }
}
