package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerScope.kt */
/* loaded from: classes.dex */
public final class ReusableGraphicsLayerScope implements GraphicsLayerScope {
    public long ambientShadowColor;
    public float cameraDistance;
    public boolean clip;
    public int compositingStrategy;
    public Density graphicsDensity;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float shadowElevation;
    public Shape shape;
    public long spotShadowColor;
    public long transformOrigin;
    public float translationX;
    public float translationY;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float alpha = 1.0f;

    public ReusableGraphicsLayerScope() {
        long j = GraphicsLayerScopeKt.DefaultShadowColor;
        this.ambientShadowColor = j;
        this.spotShadowColor = j;
        this.cameraDistance = 8.0f;
        this.transformOrigin = TransformOrigin.Center;
        this.shape = RectangleShapeKt.RectangleShape;
        this.compositingStrategy = 0;
        int r1 = Size.$r8$clinit;
        this.graphicsDensity = new DensityImpl(1.0f, 1.0f);
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.graphicsDensity.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.graphicsDensity.getFontScale();
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setAlpha(float f) {
        this.alpha = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    /* renamed from: setAmbientShadowColor-8_81llA */
    public final void mo332setAmbientShadowColor8_81llA(long j) {
        this.ambientShadowColor = j;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setCameraDistance(float f) {
        this.cameraDistance = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setClip(boolean z) {
        this.clip = z;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    /* renamed from: setCompositingStrategy-aDBOjCE */
    public final void mo333setCompositingStrategyaDBOjCE(int r1) {
        this.compositingStrategy = r1;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setRotationX(float f) {
        this.rotationX = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setRotationY(float f) {
        this.rotationY = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setRotationZ(float f) {
        this.rotationZ = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setScaleX(float f) {
        this.scaleX = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setScaleY(float f) {
        this.scaleY = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setShadowElevation(float f) {
        this.shadowElevation = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setShape(Shape shape) {
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        this.shape = shape;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    /* renamed from: setSpotShadowColor-8_81llA */
    public final void mo334setSpotShadowColor8_81llA(long j) {
        this.spotShadowColor = j;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    /* renamed from: setTransformOrigin-__ExYCQ */
    public final void mo335setTransformOrigin__ExYCQ(long j) {
        this.transformOrigin = j;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setTranslationX(float f) {
        this.translationX = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setTranslationY(float f) {
        this.translationY = f;
    }

    @Override // androidx.compose.ui.graphics.GraphicsLayerScope
    public final void setRenderEffect() {
    }
}
