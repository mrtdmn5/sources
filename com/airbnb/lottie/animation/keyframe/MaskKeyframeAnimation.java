package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MaskKeyframeAnimation {
    public final ArrayList maskAnimations;
    public final List<Mask> masks;
    public final ArrayList opacityAnimations;

    public MaskKeyframeAnimation(List<Mask> list) {
        this.masks = list;
        this.maskAnimations = new ArrayList(list.size());
        this.opacityAnimations = new ArrayList(list.size());
        for (int r0 = 0; r0 < list.size(); r0++) {
            this.maskAnimations.add(new ShapeKeyframeAnimation(list.get(r0).maskPath.keyframes));
            this.opacityAnimations.add(list.get(r0).opacity.createAnimation());
        }
    }
}
