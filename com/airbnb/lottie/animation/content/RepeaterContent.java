package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes.dex */
public final class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public ContentGroup contentGroup;
    public final FloatKeyframeAnimation copies;
    public final boolean hidden;
    public final BaseLayer layer;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final FloatKeyframeAnimation offset;
    public final TransformKeyframeAnimation transform;
    public final Matrix matrix = new Matrix();
    public final Path path = new Path();

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.lottieDrawable = lottieDrawable;
        this.layer = baseLayer;
        this.name = repeater.name;
        this.hidden = repeater.hidden;
        BaseKeyframeAnimation<Float, Float> createAnimation = repeater.copies.createAnimation();
        this.copies = (FloatKeyframeAnimation) createAnimation;
        baseLayer.addAnimation(createAnimation);
        createAnimation.addUpdateListener(this);
        BaseKeyframeAnimation<Float, Float> createAnimation2 = repeater.offset.createAnimation();
        this.offset = (FloatKeyframeAnimation) createAnimation2;
        baseLayer.addAnimation(createAnimation2);
        createAnimation2.addUpdateListener(this);
        AnimatableTransform animatableTransform = repeater.transform;
        animatableTransform.getClass();
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.transform = transformKeyframeAnimation;
        transformKeyframeAnimation.addAnimationsToLayer(baseLayer);
        transformKeyframeAnimation.addListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void absorbContent(ListIterator<Content> listIterator) {
        if (this.contentGroup != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.contentGroup = new ContentGroup(this.lottieDrawable, this.layer, "Repeater", this.hidden, arrayList, null);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        if (this.transform.applyValueCallback(lottieValueCallback, obj)) {
            return;
        }
        if (obj == LottieProperty.REPEATER_COPIES) {
            this.copies.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.REPEATER_OFFSET) {
            this.offset.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void draw(Canvas canvas, Matrix matrix, int r13) {
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        TransformKeyframeAnimation transformKeyframeAnimation = this.transform;
        float floatValue3 = transformKeyframeAnimation.startOpacity.getValue().floatValue() / 100.0f;
        float floatValue4 = transformKeyframeAnimation.endOpacity.getValue().floatValue() / 100.0f;
        int r4 = (int) floatValue;
        while (true) {
            r4--;
            if (r4 >= 0) {
                Matrix matrix2 = this.matrix;
                matrix2.set(matrix);
                float f = r4;
                matrix2.preConcat(transformKeyframeAnimation.getMatrixForRepeater(f + floatValue2));
                PointF pointF = MiscUtils.pathFromDataCurrentPoint;
                this.contentGroup.draw(canvas, matrix2, (int) ((((floatValue4 - floatValue3) * (f / floatValue)) + floatValue3) * r13));
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void getBounds(RectF rectF, Matrix matrix, boolean z) {
        this.contentGroup.getBounds(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
        Path path = this.contentGroup.getPath();
        Path path2 = this.path;
        path2.reset();
        float floatValue = this.copies.getValue().floatValue();
        float floatValue2 = this.offset.getValue().floatValue();
        int r2 = (int) floatValue;
        while (true) {
            r2--;
            if (r2 >= 0) {
                Matrix matrix = this.matrix;
                matrix.set(this.transform.getMatrixForRepeater(r2 + floatValue2));
                path2.addPath(path, matrix);
            } else {
                return path2;
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
        this.contentGroup.setContents(list, list2);
    }
}
