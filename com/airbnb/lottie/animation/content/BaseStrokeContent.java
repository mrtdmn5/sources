package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {
    public BaseKeyframeAnimation<Float, Float> blurAnimation;
    public float blurMaskFilterRadius;
    public ValueCallbackKeyframeAnimation colorFilterAnimation;
    public final ArrayList dashPatternAnimations;
    public final FloatKeyframeAnimation dashPatternOffsetAnimation;
    public final float[] dashPatternValues;
    public final DropShadowKeyframeAnimation dropShadowAnimation;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final IntegerKeyframeAnimation opacityAnimation;
    public final LPaint paint;
    public final FloatKeyframeAnimation widthAnimation;
    public final PathMeasure pm = new PathMeasure();
    public final Path path = new Path();
    public final Path trimPathPath = new Path();
    public final RectF rect = new RectF();
    public final ArrayList pathGroups = new ArrayList();

    /* loaded from: classes.dex */
    public static final class PathGroup {
        public final ArrayList paths = new ArrayList();
        public final TrimPathContent trimPath;

        public PathGroup(TrimPathContent trimPathContent) {
            this.trimPath = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.paint = lPaint;
        this.blurMaskFilterRadius = 0.0f;
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f);
        this.opacityAnimation = (IntegerKeyframeAnimation) animatableIntegerValue.createAnimation();
        this.widthAnimation = (FloatKeyframeAnimation) animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = (FloatKeyframeAnimation) animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int r5 = 0; r5 < list.size(); r5++) {
            this.dashPatternAnimations.add(list.get(r5).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int r52 = 0; r52 < this.dashPatternAnimations.size(); r52++) {
            baseLayer.addAnimation((BaseKeyframeAnimation) this.dashPatternAnimations.get(r52));
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (floatKeyframeAnimation != null) {
            baseLayer.addAnimation(floatKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int r3 = 0; r3 < list.size(); r3++) {
            ((BaseKeyframeAnimation) this.dashPatternAnimations.get(r3)).addUpdateListener(this);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(this);
        }
        if (baseLayer.getBlurEffect() != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = baseLayer.getBlurEffect().blurriness.createAnimation();
            this.blurAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
        }
        if (baseLayer.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.getDropShadowEffect());
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        if (obj == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
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
        if (obj == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.blurAnimation;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setValueCallback(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.blurAnimation = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.addUpdateListener(this);
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

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public void draw(Canvas canvas, Matrix matrix, int r22) {
        boolean z;
        float[] fArr;
        float floatValue;
        boolean z2;
        float f;
        float f2;
        float f3;
        BlurMaskFilter blurMaskFilter;
        BaseStrokeContent baseStrokeContent = this;
        float[] fArr2 = Utils.threadLocalPoints.get();
        boolean z3 = false;
        fArr2[0] = 0.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 37394.73f;
        fArr2[3] = 39575.234f;
        matrix.mapPoints(fArr2);
        if (fArr2[0] != fArr2[2] && fArr2[1] != fArr2[3]) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            L.endSection();
            return;
        }
        IntegerKeyframeAnimation integerKeyframeAnimation = baseStrokeContent.opacityAnimation;
        float intValue = (r22 / 255.0f) * integerKeyframeAnimation.getIntValue(integerKeyframeAnimation.getCurrentKeyframe(), integerKeyframeAnimation.getInterpolatedCurrentKeyframeProgress());
        float f4 = 100.0f;
        PointF pointF = MiscUtils.pathFromDataCurrentPoint;
        int max = Math.max(0, Math.min(255, (int) ((intValue / 100.0f) * 255.0f)));
        LPaint lPaint = baseStrokeContent.paint;
        lPaint.setAlpha(max);
        lPaint.setStrokeWidth(Utils.getScale(matrix) * baseStrokeContent.widthAnimation.getFloatValue());
        if (lPaint.getStrokeWidth() <= 0.0f) {
            L.endSection();
            return;
        }
        ArrayList arrayList = baseStrokeContent.dashPatternAnimations;
        if (arrayList.isEmpty()) {
            L.endSection();
        } else {
            float scale = Utils.getScale(matrix);
            int r11 = 0;
            while (true) {
                int size = arrayList.size();
                fArr = baseStrokeContent.dashPatternValues;
                if (r11 >= size) {
                    break;
                }
                float floatValue2 = ((Float) ((BaseKeyframeAnimation) arrayList.get(r11)).getValue()).floatValue();
                fArr[r11] = floatValue2;
                if (r11 % 2 == 0) {
                    if (floatValue2 < 1.0f) {
                        fArr[r11] = 1.0f;
                    }
                } else if (floatValue2 < 0.1f) {
                    fArr[r11] = 0.1f;
                }
                fArr[r11] = fArr[r11] * scale;
                r11++;
            }
            FloatKeyframeAnimation floatKeyframeAnimation = baseStrokeContent.dashPatternOffsetAnimation;
            if (floatKeyframeAnimation == null) {
                floatValue = 0.0f;
            } else {
                floatValue = floatKeyframeAnimation.getValue().floatValue() * scale;
            }
            lPaint.setPathEffect(new DashPathEffect(fArr, floatValue));
            L.endSection();
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = baseStrokeContent.colorFilterAnimation;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.getValue());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = baseStrokeContent.blurAnimation;
        if (baseKeyframeAnimation != null) {
            float floatValue3 = baseKeyframeAnimation.getValue().floatValue();
            if (floatValue3 == 0.0f) {
                lPaint.setMaskFilter(null);
            } else if (floatValue3 != baseStrokeContent.blurMaskFilterRadius) {
                BaseLayer baseLayer = baseStrokeContent.layer;
                if (baseLayer.blurMaskFilterRadius == floatValue3) {
                    blurMaskFilter = baseLayer.blurMaskFilter;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(floatValue3 / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    baseLayer.blurMaskFilter = blurMaskFilter2;
                    baseLayer.blurMaskFilterRadius = floatValue3;
                    blurMaskFilter = blurMaskFilter2;
                }
                lPaint.setMaskFilter(blurMaskFilter);
            }
            baseStrokeContent.blurMaskFilterRadius = floatValue3;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = baseStrokeContent.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.applyTo(lPaint);
        }
        int r3 = 0;
        while (true) {
            ArrayList arrayList2 = baseStrokeContent.pathGroups;
            if (r3 < arrayList2.size()) {
                PathGroup pathGroup = (PathGroup) arrayList2.get(r3);
                TrimPathContent trimPathContent = pathGroup.trimPath;
                Path path = baseStrokeContent.path;
                ArrayList arrayList3 = pathGroup.paths;
                if (trimPathContent != null) {
                    path.reset();
                    int size2 = arrayList3.size();
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        } else {
                            path.addPath(((PathContent) arrayList3.get(size2)).getPath(), matrix);
                        }
                    }
                    TrimPathContent trimPathContent2 = pathGroup.trimPath;
                    float floatValue4 = trimPathContent2.startAnimation.getValue().floatValue() / f4;
                    float floatValue5 = trimPathContent2.endAnimation.getValue().floatValue() / f4;
                    float floatValue6 = trimPathContent2.offsetAnimation.getValue().floatValue() / 360.0f;
                    if (floatValue4 < 0.01f && floatValue5 > 0.99f) {
                        canvas.drawPath(path, lPaint);
                        L.endSection();
                    } else {
                        PathMeasure pathMeasure = baseStrokeContent.pm;
                        pathMeasure.setPath(path, z3);
                        float length = pathMeasure.getLength();
                        while (pathMeasure.nextContour()) {
                            length = pathMeasure.getLength() + length;
                        }
                        float f5 = floatValue6 * length;
                        float f6 = (floatValue4 * length) + f5;
                        float min = Math.min((floatValue5 * length) + f5, (f6 + length) - 1.0f);
                        int size3 = arrayList3.size() - 1;
                        float f7 = 0.0f;
                        while (size3 >= 0) {
                            Path path2 = baseStrokeContent.trimPathPath;
                            path2.set(((PathContent) arrayList3.get(size3)).getPath());
                            path2.transform(matrix);
                            pathMeasure.setPath(path2, z3);
                            float length2 = pathMeasure.getLength();
                            if (min > length) {
                                float f8 = min - length;
                                if (f8 < f7 + length2 && f7 < f8) {
                                    if (f6 > length) {
                                        f3 = (f6 - length) / length2;
                                    } else {
                                        f3 = 0.0f;
                                    }
                                    Utils.applyTrimPathIfNeeded(path2, f3, Math.min(f8 / length2, 1.0f), 0.0f);
                                    canvas.drawPath(path2, lPaint);
                                    f7 += length2;
                                    size3--;
                                    baseStrokeContent = this;
                                    z3 = false;
                                }
                            }
                            float f9 = f7 + length2;
                            if (f9 >= f6 && f7 <= min) {
                                if (f9 <= min && f6 < f7) {
                                    canvas.drawPath(path2, lPaint);
                                } else {
                                    if (f6 < f7) {
                                        f = 0.0f;
                                    } else {
                                        f = (f6 - f7) / length2;
                                    }
                                    if (min > f9) {
                                        f2 = 1.0f;
                                    } else {
                                        f2 = (min - f7) / length2;
                                    }
                                    Utils.applyTrimPathIfNeeded(path2, f, f2, 0.0f);
                                    canvas.drawPath(path2, lPaint);
                                }
                            }
                            f7 += length2;
                            size3--;
                            baseStrokeContent = this;
                            z3 = false;
                        }
                        L.endSection();
                    }
                    z2 = true;
                } else {
                    path.reset();
                    z2 = true;
                    for (int size4 = arrayList3.size() - 1; size4 >= 0; size4--) {
                        path.addPath(((PathContent) arrayList3.get(size4)).getPath(), matrix);
                    }
                    L.endSection();
                    canvas.drawPath(path, lPaint);
                    L.endSection();
                }
                r3++;
                baseStrokeContent = this;
                z3 = false;
                f4 = 100.0f;
            } else {
                L.endSection();
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.path;
        path.reset();
        int r1 = 0;
        while (true) {
            ArrayList arrayList = this.pathGroups;
            if (r1 < arrayList.size()) {
                PathGroup pathGroup = (PathGroup) arrayList.get(r1);
                for (int r3 = 0; r3 < pathGroup.paths.size(); r3++) {
                    path.addPath(((PathContent) pathGroup.paths.get(r3)).getPath(), matrix);
                }
                r1++;
            } else {
                RectF rectF2 = this.rect;
                path.computeBounds(rectF2, false);
                float floatValue = this.widthAnimation.getFloatValue() / 2.0f;
                rectF2.set(rectF2.left - floatValue, rectF2.top - floatValue, rectF2.right + floatValue, rectF2.bottom + floatValue);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                L.endSection();
                return;
            }
        }
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
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) list;
        PathGroup pathGroup = null;
        TrimPathContent trimPathContent = null;
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            Content content = (Content) arrayList2.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.type == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.addListener(this);
        }
        int size2 = list2.size();
        while (true) {
            size2--;
            arrayList = this.pathGroups;
            if (size2 < 0) {
                break;
            }
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.type == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        arrayList.add(pathGroup);
                    }
                    PathGroup pathGroup2 = new PathGroup(trimPathContent3);
                    trimPathContent3.addListener(this);
                    pathGroup = pathGroup2;
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            arrayList.add(pathGroup);
        }
    }
}
