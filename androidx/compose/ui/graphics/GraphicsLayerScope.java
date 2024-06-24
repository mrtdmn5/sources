package androidx.compose.ui.graphics;

import androidx.compose.ui.unit.Density;

/* compiled from: GraphicsLayerScope.kt */
/* loaded from: classes.dex */
public interface GraphicsLayerScope extends Density {
    void setAlpha(float f);

    void setCameraDistance(float f);

    void setClip(boolean z);

    void setRotationX(float f);

    void setRotationY(float f);

    void setRotationZ(float f);

    void setScaleX(float f);

    void setScaleY(float f);

    void setShadowElevation(float f);

    void setShape(Shape shape);

    /* renamed from: setTransformOrigin-__ExYCQ, reason: not valid java name */
    void mo335setTransformOrigin__ExYCQ(long j);

    void setTranslationX(float f);

    void setTranslationY(float f);

    default void setRenderEffect() {
    }

    /* renamed from: setAmbientShadowColor-8_81llA, reason: not valid java name */
    default void mo332setAmbientShadowColor8_81llA(long j) {
    }

    /* renamed from: setCompositingStrategy-aDBOjCE, reason: not valid java name */
    default void mo333setCompositingStrategyaDBOjCE(int r1) {
    }

    /* renamed from: setSpotShadowColor-8_81llA, reason: not valid java name */
    default void mo334setSpotShadowColor8_81llA(long j) {
    }
}
