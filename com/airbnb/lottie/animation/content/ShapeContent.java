package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ShapeKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ShapeContent implements PathContent, BaseKeyframeAnimation.AnimationListener {
    public final boolean hidden;
    public boolean isPathValid;
    public final LottieDrawable lottieDrawable;
    public final ShapeKeyframeAnimation shapeAnimation;
    public final Path path = new Path();
    public final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    public ShapeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapePath shapePath) {
        shapePath.getClass();
        this.hidden = shapePath.hidden;
        this.lottieDrawable = lottieDrawable;
        ShapeKeyframeAnimation shapeKeyframeAnimation = new ShapeKeyframeAnimation(shapePath.shapePath.keyframes);
        this.shapeAnimation = shapeKeyframeAnimation;
        baseLayer.addAnimation(shapeKeyframeAnimation);
        shapeKeyframeAnimation.addUpdateListener(this);
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
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
        Path value = this.shapeAnimation.getValue();
        if (value == null) {
            return path;
        }
        path.set(value);
        path.setFillType(Path.FillType.EVEN_ODD);
        this.trimPaths.apply(path);
        this.isPathValid = true;
        return path;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
        ArrayList arrayList = null;
        int r0 = 0;
        while (true) {
            ArrayList arrayList2 = (ArrayList) list;
            if (r0 < arrayList2.size()) {
                Content content = (Content) arrayList2.get(r0);
                if (content instanceof TrimPathContent) {
                    TrimPathContent trimPathContent = (TrimPathContent) content;
                    if (trimPathContent.type == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                        this.trimPaths.contents.add(trimPathContent);
                        trimPathContent.addListener(this);
                        r0++;
                    }
                }
                if (content instanceof ShapeModifierContent) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((ShapeModifierContent) content);
                }
                r0++;
            } else {
                this.shapeAnimation.shapeModifiers = arrayList;
                return;
            }
        }
    }
}
