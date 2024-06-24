package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    public final boolean hidden;
    public final FloatKeyframeAnimation innerRadiusAnimation;
    public final FloatKeyframeAnimation innerRoundednessAnimation;
    public boolean isPathValid;
    public final boolean isReversed;
    public final LottieDrawable lottieDrawable;
    public final String name;
    public final FloatKeyframeAnimation outerRadiusAnimation;
    public final FloatKeyframeAnimation outerRoundednessAnimation;
    public final FloatKeyframeAnimation pointsAnimation;
    public final BaseKeyframeAnimation<?, PointF> positionAnimation;
    public final FloatKeyframeAnimation rotationAnimation;
    public final PolystarShape.Type type;
    public final Path path = new Path();
    public final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type;

        static {
            int[] r0 = new int[PolystarShape.Type.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type = r0;
            try {
                r0[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable;
        this.name = polystarShape.name;
        PolystarShape.Type type = polystarShape.type;
        this.type = type;
        this.hidden = polystarShape.hidden;
        this.isReversed = polystarShape.isReversed;
        BaseKeyframeAnimation<?, ?> createAnimation = polystarShape.points.createAnimation();
        this.pointsAnimation = (FloatKeyframeAnimation) createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.position.createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<?, ?> createAnimation3 = polystarShape.rotation.createAnimation();
        this.rotationAnimation = (FloatKeyframeAnimation) createAnimation3;
        BaseKeyframeAnimation<?, ?> createAnimation4 = polystarShape.outerRadius.createAnimation();
        this.outerRadiusAnimation = (FloatKeyframeAnimation) createAnimation4;
        BaseKeyframeAnimation<?, ?> createAnimation5 = polystarShape.outerRoundedness.createAnimation();
        this.outerRoundednessAnimation = (FloatKeyframeAnimation) createAnimation5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.innerRadiusAnimation = (FloatKeyframeAnimation) polystarShape.innerRadius.createAnimation();
            this.innerRoundednessAnimation = (FloatKeyframeAnimation) polystarShape.innerRoundedness.createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == type2) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void addValueCallback(LottieValueCallback lottieValueCallback, Object obj) {
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (obj == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.POLYSTAR_INNER_RADIUS && (floatKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            floatKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
            return;
        }
        if (obj == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (floatKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            floatKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (obj == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.name;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path getPath() {
        double floatValue;
        float f;
        float f2;
        float f3;
        float cos;
        float f4;
        double d;
        float f5;
        Path path;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Path path2;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        double floatValue2;
        int r25;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation;
        double d2;
        double d3;
        float f19;
        double d4;
        boolean z = this.isPathValid;
        Path path3 = this.path;
        if (z) {
            return path3;
        }
        path3.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return path3;
        }
        int r1 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$PolystarShape$Type[this.type.ordinal()];
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.positionAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation = this.outerRoundednessAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.outerRadiusAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.rotationAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation4 = this.pointsAnimation;
        if (r1 != 1) {
            if (r1 == 2) {
                int floor = (int) Math.floor(floatKeyframeAnimation4.getValue().floatValue());
                if (floatKeyframeAnimation3 == null) {
                    floatValue2 = 0.0d;
                } else {
                    floatValue2 = floatKeyframeAnimation3.getValue().floatValue();
                }
                double radians = Math.toRadians(floatValue2 - 90.0d);
                double d5 = floor;
                float floatValue3 = floatKeyframeAnimation.getValue().floatValue() / 100.0f;
                float floatValue4 = floatKeyframeAnimation2.getValue().floatValue();
                double d6 = floatValue4;
                float cos2 = (float) (Math.cos(radians) * d6);
                float sin = (float) (Math.sin(radians) * d6);
                path3.moveTo(cos2, sin);
                double d7 = (float) (6.283185307179586d / d5);
                double d8 = radians + d7;
                double ceil = Math.ceil(d5);
                int r12 = 0;
                double d9 = d7;
                while (r12 < ceil) {
                    float cos3 = (float) (Math.cos(d8) * d6);
                    float sin2 = (float) (Math.sin(d8) * d6);
                    if (floatValue3 != 0.0f) {
                        double d10 = d6;
                        r25 = r12;
                        double atan2 = (float) (Math.atan2(sin, cos2) - 1.5707963267948966d);
                        float cos4 = (float) Math.cos(atan2);
                        float sin3 = (float) Math.sin(atan2);
                        baseKeyframeAnimation = baseKeyframeAnimation2;
                        d2 = d8;
                        double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                        float f20 = floatValue4 * floatValue3 * 0.25f;
                        d3 = d9;
                        f19 = sin2;
                        d4 = d10;
                        path3.cubicTo(cos2 - (cos4 * f20), sin - (sin3 * f20), (((float) Math.cos(atan22)) * f20) + cos3, (f20 * ((float) Math.sin(atan22))) + sin2, cos3, f19);
                    } else {
                        r25 = r12;
                        baseKeyframeAnimation = baseKeyframeAnimation2;
                        d2 = d8;
                        d3 = d9;
                        f19 = sin2;
                        d4 = d6;
                        path3.lineTo(cos3, f19);
                    }
                    double d11 = d2 + d3;
                    sin = f19;
                    d6 = d4;
                    d9 = d3;
                    baseKeyframeAnimation2 = baseKeyframeAnimation;
                    d8 = d11;
                    cos2 = cos3;
                    r12 = r25 + 1;
                }
                PointF value = baseKeyframeAnimation2.getValue();
                path3.offset(value.x, value.y);
                path3.close();
            }
            path = path3;
        } else {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = baseKeyframeAnimation2;
            float floatValue5 = floatKeyframeAnimation4.getValue().floatValue();
            if (floatKeyframeAnimation3 == null) {
                floatValue = 0.0d;
            } else {
                floatValue = floatKeyframeAnimation3.getValue().floatValue();
            }
            double radians2 = Math.toRadians(floatValue - 90.0d);
            double d12 = floatValue5;
            float f21 = (float) (6.283185307179586d / d12);
            if (this.isReversed) {
                f21 *= -1.0f;
            }
            float f22 = f21;
            float f23 = f22 / 2.0f;
            float f24 = floatValue5 - ((int) floatValue5);
            if (f24 != 0.0f) {
                radians2 += (1.0f - f24) * f23;
            }
            float floatValue6 = floatKeyframeAnimation2.getValue().floatValue();
            float floatValue7 = this.innerRadiusAnimation.getValue().floatValue();
            FloatKeyframeAnimation floatKeyframeAnimation5 = this.innerRoundednessAnimation;
            if (floatKeyframeAnimation5 != null) {
                f = floatKeyframeAnimation5.getValue().floatValue() / 100.0f;
            } else {
                f = 0.0f;
            }
            if (floatKeyframeAnimation != null) {
                f2 = floatKeyframeAnimation.getValue().floatValue() / 100.0f;
            } else {
                f2 = 0.0f;
            }
            if (f24 != 0.0f) {
                float m = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(floatValue6, floatValue7, f24, floatValue7);
                double d13 = m;
                f3 = floatValue7;
                cos = (float) (Math.cos(radians2) * d13);
                float sin4 = (float) (d13 * Math.sin(radians2));
                path3.moveTo(cos, sin4);
                f4 = sin4;
                d = radians2 + ((f22 * f24) / 2.0f);
                f5 = m;
            } else {
                f3 = floatValue7;
                double d14 = floatValue6;
                cos = (float) (Math.cos(radians2) * d14);
                float sin5 = (float) (d14 * Math.sin(radians2));
                path3.moveTo(cos, sin5);
                f4 = sin5;
                d = radians2 + f23;
                f5 = 0.0f;
            }
            double ceil2 = Math.ceil(d12) * 2.0d;
            int r13 = 0;
            double d15 = 2.0d;
            double d16 = d;
            boolean z2 = false;
            float f25 = floatValue6;
            while (true) {
                double d17 = r13;
                if (d17 >= ceil2) {
                    break;
                }
                if (z2) {
                    f6 = f25;
                } else {
                    f6 = f3;
                }
                if (f5 != 0.0f && d17 == ceil2 - d15) {
                    f7 = f5;
                    f8 = (f22 * f24) / 2.0f;
                } else {
                    f7 = f5;
                    f8 = f23;
                }
                if (f5 != 0.0f && d17 == ceil2 - 1.0d) {
                    f9 = f22;
                    f6 = f7;
                } else {
                    f9 = f22;
                }
                double d18 = f6;
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = baseKeyframeAnimation3;
                float cos5 = (float) (Math.cos(d16) * d18);
                float sin6 = (float) (d18 * Math.sin(d16));
                if (f == 0.0f && f2 == 0.0f) {
                    path3.lineTo(cos5, sin6);
                    f17 = f23;
                    path2 = path3;
                    f18 = f8;
                    f10 = sin6;
                    f16 = f25;
                    f15 = f3;
                } else {
                    float f26 = f23;
                    float f27 = f4;
                    double atan23 = (float) (Math.atan2(f4, cos) - 1.5707963267948966d);
                    float cos6 = (float) Math.cos(atan23);
                    float sin7 = (float) Math.sin(atan23);
                    float f28 = f8;
                    f10 = sin6;
                    path2 = path3;
                    double atan24 = (float) (Math.atan2(sin6, cos5) - 1.5707963267948966d);
                    float cos7 = (float) Math.cos(atan24);
                    float sin8 = (float) Math.sin(atan24);
                    if (z2) {
                        f11 = f;
                    } else {
                        f11 = f2;
                    }
                    if (z2) {
                        f12 = f2;
                    } else {
                        f12 = f;
                    }
                    if (z2) {
                        f13 = f3;
                    } else {
                        f13 = f25;
                    }
                    if (z2) {
                        f14 = f25;
                    } else {
                        f14 = f3;
                    }
                    float f29 = f13 * f11 * 0.47829f;
                    float f30 = cos6 * f29;
                    float f31 = f29 * sin7;
                    float f32 = f14 * f12 * 0.47829f;
                    float f33 = cos7 * f32;
                    float f34 = f32 * sin8;
                    if (f24 != 0.0f) {
                        if (r13 == 0) {
                            f30 *= f24;
                            f31 *= f24;
                        } else if (d17 == ceil2 - 1.0d) {
                            f33 *= f24;
                            f34 *= f24;
                        }
                    }
                    f15 = f3;
                    f16 = f25;
                    f17 = f26;
                    path2.cubicTo(cos - f30, f27 - f31, cos5 + f33, f10 + f34, cos5, f10);
                    f18 = f28;
                }
                d16 += f18;
                z2 = !z2;
                r13++;
                cos = cos5;
                f3 = f15;
                f25 = f16;
                f23 = f17;
                f5 = f7;
                f22 = f9;
                baseKeyframeAnimation3 = baseKeyframeAnimation4;
                path3 = path2;
                d15 = 2.0d;
                f4 = f10;
            }
            PointF value2 = baseKeyframeAnimation3.getValue();
            path = path3;
            path.offset(value2.x, value2.y);
            path.close();
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
        int r5 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (r5 < arrayList.size()) {
                Content content = (Content) arrayList.get(r5);
                if (content instanceof TrimPathContent) {
                    TrimPathContent trimPathContent = (TrimPathContent) content;
                    if (trimPathContent.type == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                        this.trimPaths.contents.add(trimPathContent);
                        trimPathContent.addListener(this);
                    }
                }
                r5++;
            } else {
                return;
            }
        }
    }
}
