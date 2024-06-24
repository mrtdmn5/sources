package com.airbnb.lottie.model.content;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes.dex */
public final class ShapeTrimPath implements ContentModel {
    public final AnimatableFloatValue end;
    public final boolean hidden;
    public final AnimatableFloatValue offset;
    public final AnimatableFloatValue start;
    public final Type type;

    /* loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int r2) {
            if (r2 != 1) {
                if (r2 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unknown trim path type ", r2));
            }
            return SIMULTANEOUSLY;
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.type = type;
        this.start = animatableFloatValue;
        this.end = animatableFloatValue2;
        this.offset = animatableFloatValue3;
        this.hidden = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.start + ", end: " + this.end + ", offset: " + this.offset + "}";
    }
}
