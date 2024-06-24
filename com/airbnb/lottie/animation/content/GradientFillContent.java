package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public BaseKeyframeAnimation<Float, Float> blurAnimation;
    public float blurMaskFilterRadius;
    public final RectF boundsRect;
    public final int cacheSteps;
    public final GradientColorKeyframeAnimation colorAnimation;
    public ValueCallbackKeyframeAnimation colorCallbackAnimation;
    public ValueCallbackKeyframeAnimation colorFilterAnimation;
    public final DropShadowKeyframeAnimation dropShadowAnimation;
    public final PointKeyframeAnimation endPointAnimation;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final IntegerKeyframeAnimation opacityAnimation;
    public final LPaint paint;
    public final Path path;
    public final ArrayList paths;
    public final PointKeyframeAnimation startPointAnimation;
    public final GradientType type;
    public final LongSparseArray<LinearGradient> linearGradientCache = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> radialGradientCache = new LongSparseArray<>();

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientFill gradientFill) {
        Path path = new Path();
        this.path = path;
        this.paint = new LPaint(1);
        this.boundsRect = new RectF();
        this.paths = new ArrayList();
        this.blurMaskFilterRadius = 0.0f;
        this.layer = baseLayer;
        this.name = gradientFill.name;
        this.hidden = gradientFill.hidden;
        this.lottieDrawable = lottieDrawable;
        this.type = gradientFill.gradientType;
        path.setFillType(gradientFill.fillType);
        this.cacheSteps = (int) (lottieDrawable.composition.getDuration() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> createAnimation = gradientFill.gradientColor.createAnimation();
        this.colorAnimation = (GradientColorKeyframeAnimation) createAnimation;
        createAnimation.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation);
        BaseKeyframeAnimation<Integer, Integer> createAnimation2 = gradientFill.opacity.createAnimation();
        this.opacityAnimation = (IntegerKeyframeAnimation) createAnimation2;
        createAnimation2.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation2);
        BaseKeyframeAnimation<PointF, PointF> createAnimation3 = gradientFill.startPoint.createAnimation();
        this.startPointAnimation = (PointKeyframeAnimation) createAnimation3;
        createAnimation3.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation3);
        BaseKeyframeAnimation<PointF, PointF> createAnimation4 = gradientFill.endPoint.createAnimation();
        this.endPointAnimation = (PointKeyframeAnimation) createAnimation4;
        createAnimation4.addUpdateListener(this);
        baseLayer.addAnimation(createAnimation4);
        if (baseLayer.getBlurEffect() != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation5 = baseLayer.getBlurEffect().blurriness.createAnimation();
            this.blurAnimation = createAnimation5;
            createAnimation5.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
        }
        if (baseLayer.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.getDropShadowEffect());
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        if (obj == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        ColorFilter colorFilter = LottieProperty.COLOR_FILTER;
        BaseLayer baseLayer = this.layer;
        if (obj == colorFilter) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorFilterAnimation;
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
            baseLayer.addAnimation(this.colorFilterAnimation);
            return;
        }
        if (obj == LottieProperty.GRADIENT_COLOR) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = this.colorCallbackAnimation;
            if (valueCallbackKeyframeAnimation3 != null) {
                baseLayer.removeAnimation(valueCallbackKeyframeAnimation3);
            }
            if (lottieValueCallback == null) {
                this.colorCallbackAnimation = null;
                return;
            }
            this.linearGradientCache.clear();
            this.radialGradientCache.clear();
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation4 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.colorCallbackAnimation = valueCallbackKeyframeAnimation4;
            valueCallbackKeyframeAnimation4.addUpdateListener(this);
            baseLayer.addAnimation(this.colorCallbackAnimation);
            return;
        }
        if (obj == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.blurAnimation;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation5 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.blurAnimation = valueCallbackKeyframeAnimation5;
            valueCallbackKeyframeAnimation5.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
            return;
        }
        Integer num = LottieProperty.DROP_SHADOW_COLOR;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (obj == num && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.color.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.DROP_SHADOW_OPACITY && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.setOpacityCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.DROP_SHADOW_DIRECTION && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.direction.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.DROP_SHADOW_DISTANCE && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.distance.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.DROP_SHADOW_RADIUS && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.radius.setValueCallback(lottieValueCallback);
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
    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void draw(Canvas canvas, Matrix matrix, int r24) {
        Shader shader;
        if (this.hidden) {
            return;
        }
        Path path = this.path;
        path.reset();
        int r4 = 0;
        while (true) {
            ArrayList arrayList = this.paths;
            if (r4 >= arrayList.size()) {
                break;
            }
            path.addPath(((PathContent) arrayList.get(r4)).getPath(), matrix);
            r4++;
        }
        path.computeBounds(this.boundsRect, false);
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
                float f = value4.x;
                float f2 = value4.y;
                float hypot = (float) Math.hypot(value5.x - f, value5.y - f2);
                if (hypot <= 0.0f) {
                    hypot = 0.001f;
                }
                shader = new RadialGradient(f, f2, hypot, applyDynamicColorsIfNeeded, fArr, Shader.TileMode.CLAMP);
                longSparseArray2.put(gradientHash2, shader);
            }
        }
        shader.setLocalMatrix(matrix);
        LPaint lPaint = this.paint;
        lPaint.setShader(shader);
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.colorFilterAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.getValue());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.blurAnimation;
        if (baseKeyframeAnimation != null) {
            float floatValue = baseKeyframeAnimation.getValue().floatValue();
            if (floatValue == 0.0f) {
                lPaint.setMaskFilter(null);
            } else if (floatValue != this.blurMaskFilterRadius) {
                lPaint.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.blurMaskFilterRadius = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.applyTo(lPaint);
        }
        PointF pointF = MiscUtils.pathFromDataCurrentPoint;
        lPaint.setAlpha(Math.max(0, Math.min(255, (int) ((((r24 / 255.0f) * this.opacityAnimation.getValue().intValue()) / 100.0f) * 255.0f))));
        canvas.drawPath(path, lPaint);
        L.endSection();
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.path;
        path.reset();
        int r1 = 0;
        while (true) {
            ArrayList arrayList = this.paths;
            if (r1 < arrayList.size()) {
                path.addPath(((PathContent) arrayList.get(r1)).getPath(), matrix);
                r1++;
            } else {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            }
        }
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

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void resolveKeyPath(KeyPath keyPath, int r2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, r2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
        for (int r3 = 0; r3 < list2.size(); r3++) {
            Content content = list2.get(r3);
            if (content instanceof PathContent) {
                this.paths.add((PathContent) content);
            }
        }
    }
}
