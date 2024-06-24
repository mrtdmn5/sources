package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ShapeStroke implements ContentModel {
    public final LineCapType capType;
    public final AnimatableColorValue color;
    public final boolean hidden;
    public final LineJoinType joinType;
    public final List<AnimatableFloatValue> lineDashPattern;
    public final float miterLimit;
    public final String name;
    public final AnimatableFloatValue offset;
    public final AnimatableIntegerValue opacity;
    public final AnimatableFloatValue width;

    /* renamed from: com.airbnb.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType;
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType;

        static {
            int[] r0 = new int[LineJoinType.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType = r0;
            try {
                r0[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] r3 = new int[LineCapType.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType = r3;
            try {
                r3[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[ordinal()];
            if (r0 != 1) {
                if (r0 != 2) {
                    if (r0 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String str, AnimatableFloatValue animatableFloatValue, ArrayList arrayList, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.name = str;
        this.offset = animatableFloatValue;
        this.lineDashPattern = arrayList;
        this.color = animatableColorValue;
        this.opacity = animatableIntegerValue;
        this.width = animatableFloatValue2;
        this.capType = lineCapType;
        this.joinType = lineJoinType;
        this.miterLimit = f;
        this.hidden = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }
}
