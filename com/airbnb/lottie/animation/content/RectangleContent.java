package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {
    public final FloatKeyframeAnimation cornerRadiusAnimation;
    public final boolean hidden;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final BaseKeyframeAnimation<?, PointF> sizeAnimation;
    public final Path path = new Path();
    public final RectF rect = new RectF();
    public final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    public BaseKeyframeAnimation<Float, Float> roundedCornersAnimation = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.name = rectangleShape.name;
        this.hidden = rectangleShape.hidden;
        this.lottieDrawable = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> createAnimation = rectangleShape.position.createAnimation();
        this.positionAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = rectangleShape.size.createAnimation();
        this.sizeAnimation = createAnimation2;
        BaseKeyframeAnimation<?, ?> createAnimation3 = rectangleShape.cornerRadius.createAnimation();
        this.cornerRadiusAnimation = (FloatKeyframeAnimation) createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        if (obj == LottieProperty.RECTANGLE_SIZE) {
            this.sizeAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.CORNER_RADIUS) {
            this.cornerRadiusAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
        float floatValue;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation;
        boolean z = this.isPathValid;
        Path path = this.path;
        if (z) {
            return path;
        }
        path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return path;
        }
        PointF value = this.sizeAnimation.getValue();
        float f = value.x / 2.0f;
        float f2 = value.y / 2.0f;
        FloatKeyframeAnimation floatKeyframeAnimation = this.cornerRadiusAnimation;
        if (floatKeyframeAnimation == null) {
            floatValue = 0.0f;
        } else {
            floatValue = floatKeyframeAnimation.getFloatValue();
        }
        if (floatValue == 0.0f && (baseKeyframeAnimation = this.roundedCornersAnimation) != null) {
            floatValue = Math.min(baseKeyframeAnimation.getValue().floatValue(), Math.min(f, f2));
        }
        float min = Math.min(f, f2);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF value2 = this.positionAnimation.getValue();
        path.moveTo(value2.x + f, (value2.y - f2) + floatValue);
        path.lineTo(value2.x + f, (value2.y + f2) - floatValue);
        RectF rectF = this.rect;
        if (floatValue > 0.0f) {
            float f3 = value2.x + f;
            float f4 = floatValue * 2.0f;
            float f5 = value2.y + f2;
            rectF.set(f3 - f4, f5 - f4, f3, f5);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        }
        path.lineTo((value2.x - f) + floatValue, value2.y + f2);
        if (floatValue > 0.0f) {
            float f6 = value2.x - f;
            float f7 = value2.y + f2;
            float f8 = floatValue * 2.0f;
            rectF.set(f6, f7 - f8, f8 + f6, f7);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(value2.x - f, (value2.y - f2) + floatValue);
        if (floatValue > 0.0f) {
            float f9 = value2.x - f;
            float f10 = value2.y - f2;
            float f11 = floatValue * 2.0f;
            rectF.set(f9, f10, f9 + f11, f11 + f10);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((value2.x + f) - floatValue, value2.y - f2);
        if (floatValue > 0.0f) {
            float f12 = value2.x + f;
            float f13 = floatValue * 2.0f;
            float f14 = value2.y - f2;
            rectF.set(f12 - f13, f14, f12, f13 + f14);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.trimPaths.apply(path);
        this.isPathValid = true;
        return path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void resolveKeyPath(KeyPath keyPath, int r2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, r2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
        int r6 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (r6 < arrayList.size()) {
                Content content = (Content) arrayList.get(r6);
                if (content instanceof TrimPathContent) {
                    TrimPathContent trimPathContent = (TrimPathContent) content;
                    if (trimPathContent.type == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                        this.trimPaths.contents.add(trimPathContent);
                        trimPathContent.addListener(this);
                        r6++;
                    }
                }
                if (content instanceof RoundedCornersContent) {
                    this.roundedCornersAnimation = ((RoundedCornersContent) content).roundedCorners;
                }
                r6++;
            } else {
                return;
            }
        }
    }
}
