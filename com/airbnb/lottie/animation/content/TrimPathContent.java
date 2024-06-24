package com.airbnb.lottie.animation.content;

import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TrimPathContent implements Content, BaseKeyframeAnimation.AnimationListener {
    public final FloatKeyframeAnimation endAnimation;
    public final boolean hidden;
    public final ArrayList listeners = new ArrayList();
    public final FloatKeyframeAnimation offsetAnimation;
    public final FloatKeyframeAnimation startAnimation;
    public final ShapeTrimPath.Type type;

    public TrimPathContent(BaseLayer baseLayer, ShapeTrimPath shapeTrimPath) {
        shapeTrimPath.getClass();
        this.hidden = shapeTrimPath.hidden;
        this.type = shapeTrimPath.type;
        BaseKeyframeAnimation<Float, Float> createAnimation = shapeTrimPath.start.createAnimation();
        this.startAnimation = (FloatKeyframeAnimation) createAnimation;
        BaseKeyframeAnimation<Float, Float> createAnimation2 = shapeTrimPath.end.createAnimation();
        this.endAnimation = (FloatKeyframeAnimation) createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = shapeTrimPath.offset.createAnimation();
        this.offsetAnimation = (FloatKeyframeAnimation) createAnimation3;
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
    }

    public final void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        this.listeners.add(animationListener);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void onValueChanged() {
        int r0 = 0;
        while (true) {
            ArrayList arrayList = this.listeners;
            if (r0 < arrayList.size()) {
                ((BaseKeyframeAnimation.AnimationListener) arrayList.get(r0)).onValueChanged();
                r0++;
            } else {
                return;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void setContents(List<Content> list, List<Content> list2) {
    }
}
