package com.airbnb.lottie.model.content;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public final class ShapePath implements ContentModel {
    public final boolean hidden;
    public final int index;
    public final String name;
    public final AnimatableShapeValue shapePath;

    public ShapePath(String str, int r2, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.name = str;
        this.index = r2;
        this.shapePath = animatableShapeValue;
        this.hidden = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShapePath{name=");
        sb.append(this.name);
        sb.append(", index=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.index, '}');
    }
}
