package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class GradientStrokeContent extends BaseStrokeContent {
    public final RectF boundsRect;
    public final int cacheSteps;
    public final GradientColorKeyframeAnimation colorAnimation;
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public final PointKeyframeAnimation endPointAnimation;
    public final boolean hidden;
    public final LongSparseArray<LinearGradient> linearGradientCache;
    public final String name;
    public final LongSparseArray<RadialGradient> radialGradientCache;
    public final PointKeyframeAnimation startPointAnimation;
    public final GradientType type;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer, gradientStroke.capType.toPaintCap(), gradientStroke.joinType.toPaintJoin(), gradientStroke.miterLimit, gradientStroke.opacity, gradientStroke.width, gradientStroke.lineDashPattern, gradientStroke.dashOffset);
        this.linearGradientCache = new LongSparseArray<>();
        this.radialGradientCache = new LongSparseArray<>();
        this.boundsRect = new RectF();
        this.name = gradientStroke.name;
        this.type = gradientStroke.gradientType;
        this.hidden = gradientStroke.hidden;
        this.cacheSteps = (int) (lottieDrawable.composition.getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientStroke.gradientColor.createAnimation();
        this.colorAnimation = (GradientColorKeyframeAnimation) createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = gradientStroke.startPoint.createAnimation();
        this.startPointAnimation = (PointKeyframeAnimation) createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientStroke.endPoint.createAnimation();
        this.endPointAnimation = (PointKeyframeAnimation) createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        super.addValueCallback(lottieValueCallback, obj);
        if (obj == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
            BaseLayer baseLayer = this.layer;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.removeAnimation(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(this.colorCallbackAnimation);
        }
    }

    public final int[] applyDynamicColorsIfNeeded(int[] r5) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorCallbackAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.getValue();
            int r3 = 0;
            if (r5.length == numArr.length) {
                while (r3 < r5.length) {
                    r5[r3] = numArr[r3].intValue();
                    r3++;
                }
            } else {
                r5 = new int[numArr.length];
                while (r3 < numArr.length) {
                    r5[r3] = numArr[r3].intValue();
                    r3++;
                }
            }
        }
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void draw(Canvas canvas, Matrix matrix, int r20) {
        Shader shader;
        if (this.hidden) {
            return;
        }
        getBounds(this.boundsRect, matrix, false);
        GradientType gradientType = GradientType.LINEAR;
        GradientType gradientType2 = this.type;
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = this.colorAnimation;
        PointKeyframeAnimation pointKeyframeAnimation = this.endPointAnimation;
        PointKeyframeAnimation pointKeyframeAnimation2 = this.startPointAnimation;
        if (gradientType2 == gradientType) {
            long gradientHash = getGradientHash();
            LongSparseArray<LinearGradient> longSparseArray = this.linearGradientCache;
            shader = (LinearGradient) longSparseArray.get(gradientHash, null);
            if (shader == null) {
                PointF value = pointKeyframeAnimation2.getValue();
                PointF value2 = pointKeyframeAnimation.getValue();
                GradientColor value3 = gradientColorKeyframeAnimation.getValue();
                shader = new LinearGradient(value.x, value.y, value2.x, value2.y, applyDynamicColorsIfNeeded(value3.colors), value3.positions, Shader.TileMode.CLAMP);
                longSparseArray.put(gradientHash, shader);
            }
        } else {
            long gradientHash2 = getGradientHash();
            LongSparseArray<RadialGradient> longSparseArray2 = this.radialGradientCache;
            shader = (RadialGradient) longSparseArray2.get(gradientHash2, null);
            if (shader == null) {
                PointF value4 = pointKeyframeAnimation2.getValue();
                PointF value5 = pointKeyframeAnimation.getValue();
                GradientColor value6 = gradientColorKeyframeAnimation.getValue();
                int[] applyDynamicColorsIfNeeded = applyDynamicColorsIfNeeded(value6.colors);
                float[] fArr = value6.positions;
                shader = new RadialGradient(value4.x, value4.y, (float) Math.hypot(value5.x - r10, value5.y - r11), applyDynamicColorsIfNeeded, fArr, Shader.TileMode.CLAMP);
                longSparseArray2.put(gradientHash2, shader);
            }
        }
        shader.setLocalMatrix(matrix);
        this.paint.setShader(shader);
        super.draw(canvas, matrix, r20);
    }

    public final int getGradientHash() {
        int r0;
        float f = this.startPointAnimation.progress;
        float f2 = this.cacheSteps;
        int round = Math.round(f * f2);
        int round2 = Math.round(this.endPointAnimation.progress * f2);
        int round3 = Math.round(this.colorAnimation.progress * f2);
        if (round != 0) {
            r0 = round * 527;
        } else {
            r0 = 17;
        }
        if (round2 != 0) {
            r0 = r0 * 31 * round2;
        }
        if (round3 != 0) {
            return r0 * 31 * round3;
        }
        return r0;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }
}
