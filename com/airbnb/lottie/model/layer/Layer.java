package com.airbnb.lottie.model.layer;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.BlurEffect;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.Keyframe;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Layer {
    public final BlurEffect blurEffect;
    public final LottieComposition composition;
    public final DropShadowEffect dropShadowEffect;
    public final boolean hidden;
    public final List<Keyframe<Float>> inOutKeyframes;
    public final long layerId;
    public final String layerName;
    public final LayerType layerType;
    public final List<Mask> masks;
    public final MatteType matteType;
    public final long parentId;
    public final int preCompHeight;
    public final int preCompWidth;
    public final String refId;
    public final List<ContentModel> shapes;
    public final int solidColor;
    public final int solidHeight;
    public final int solidWidth;
    public final float startFrame;
    public final AnimatableTextFrame text;
    public final AnimatableTextProperties textProperties;
    public final AnimatableFloatValue timeRemapping;
    public final float timeStretch;
    public final AnimatableTransform transform;

    /* loaded from: classes.dex */
    public enum LayerType {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: classes.dex */
    public enum MatteType {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public Layer(List<ContentModel> list, LottieComposition lottieComposition, String str, long j, LayerType layerType, long j2, String str2, List<Mask> list2, AnimatableTransform animatableTransform, int r15, int r16, int r17, float f, float f2, int r20, int r21, AnimatableTextFrame animatableTextFrame, AnimatableTextProperties animatableTextProperties, List<Keyframe<Float>> list3, MatteType matteType, AnimatableFloatValue animatableFloatValue, boolean z, BlurEffect blurEffect, DropShadowEffect dropShadowEffect) {
        this.shapes = list;
        this.composition = lottieComposition;
        this.layerName = str;
        this.layerId = j;
        this.layerType = layerType;
        this.parentId = j2;
        this.refId = str2;
        this.masks = list2;
        this.transform = animatableTransform;
        this.solidWidth = r15;
        this.solidHeight = r16;
        this.solidColor = r17;
        this.timeStretch = f;
        this.startFrame = f2;
        this.preCompWidth = r20;
        this.preCompHeight = r21;
        this.text = animatableTextFrame;
        this.textProperties = animatableTextProperties;
        this.inOutKeyframes = list3;
        this.matteType = matteType;
        this.timeRemapping = animatableFloatValue;
        this.hidden = z;
        this.blurEffect = blurEffect;
        this.dropShadowEffect = dropShadowEffect;
    }

    public final String toString(String str) {
        int r3;
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        m.append(this.layerName);
        m.append("\n");
        LottieComposition lottieComposition = this.composition;
        Layer layer = (Layer) lottieComposition.layerMap.get(this.parentId, null);
        if (layer != null) {
            m.append("\t\tParents: ");
            m.append(layer.layerName);
            for (Layer layer2 = (Layer) lottieComposition.layerMap.get(layer.parentId, null); layer2 != null; layer2 = (Layer) lottieComposition.layerMap.get(layer2.parentId, null)) {
                m.append("->");
                m.append(layer2.layerName);
            }
            m.append(str);
            m.append("\n");
        }
        List<Mask> list = this.masks;
        if (!list.isEmpty()) {
            m.append(str);
            m.append("\tMasks: ");
            m.append(list.size());
            m.append("\n");
        }
        int r2 = this.solidWidth;
        if (r2 != 0 && (r3 = this.solidHeight) != 0) {
            m.append(str);
            m.append("\tBackground: ");
            m.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(this.solidColor)));
        }
        List<ContentModel> list2 = this.shapes;
        if (!list2.isEmpty()) {
            m.append(str);
            m.append("\tShapes:\n");
            for (ContentModel contentModel : list2) {
                m.append(str);
                m.append("\t\t");
                m.append(contentModel);
                m.append("\n");
            }
        }
        return m.toString();
    }

    public final String toString() {
        return toString("");
    }
}
