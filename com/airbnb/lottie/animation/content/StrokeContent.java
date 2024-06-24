package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes.dex */
public final class StrokeContent extends BaseStrokeContent {
    public final ColorKeyframeAnimation colorAnimation;
    public ValueCallbackKeyframeAnimation colorFilterAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final String name;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer, shapeStroke.capType.toPaintCap(), shapeStroke.joinType.toPaintJoin(), shapeStroke.miterLimit, shapeStroke.opacity, shapeStroke.width, shapeStroke.lineDashPattern, shapeStroke.offset);
        this.layer = baseLayer;
        this.name = shapeStroke.name;
        this.hidden = shapeStroke.hidden;
        BaseKeyframeAnimation<Integer, Integer> createAnimation = shapeStroke.color.createAnimation();
        this.colorAnimation = (ColorKeyframeAnimation) createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        super.addValueCallback(lottieValueCallback, obj);
        Integer num = LottieProperty.STROKE_COLOR;
        ColorKeyframeAnimation colorKeyframeAnimation = this.colorAnimation;
        if (obj == num) {
            colorKeyframeAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.COLOR_FILTER) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorFilterAnimation;
            BaseLayer baseLayer = this.layer;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.removeAnimation(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            baseLayer.addAnimation(colorKeyframeAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void draw(Canvas canvas, Matrix matrix, int r6) {
        if (this.hidden) {
            return;
        }
        ColorKeyframeAnimation colorKeyframeAnimation = this.colorAnimation;
        int intValue = colorKeyframeAnimation.getIntValue(colorKeyframeAnimation.getCurrentKeyframe(), colorKeyframeAnimation.getInterpolatedCurrentKeyframeProgress());
        LPaint lPaint = this.paint;
        lPaint.setColor(intValue);
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorFilterAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.getValue());
        }
        super.draw(canvas, matrix, r6);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }
}
