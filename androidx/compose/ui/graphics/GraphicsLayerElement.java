package androidx.compose.ui.graphics;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GraphicsLayerModifier.kt */
/* loaded from: classes.dex */
public final class GraphicsLayerElement extends ModifierNodeElement<SimpleGraphicsLayerModifier> {
    public final float alpha;
    public final long ambientShadowColor;
    public final float cameraDistance;
    public final boolean clip;
    public final int compositingStrategy;
    public final float rotationX;
    public final float rotationY;
    public final float rotationZ;
    public final float scaleX;
    public final float scaleY;
    public final float shadowElevation;
    public final Shape shape;
    public final long spotShadowColor;
    public final long transformOrigin;
    public final float translationX;
    public final float translationY;

    public GraphicsLayerElement(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, long j2, long j3, int r22) {
        this.scaleX = f;
        this.scaleY = f2;
        this.alpha = f3;
        this.translationX = f4;
        this.translationY = f5;
        this.shadowElevation = f6;
        this.rotationX = f7;
        this.rotationY = f8;
        this.rotationZ = f9;
        this.cameraDistance = f10;
        this.transformOrigin = j;
        this.shape = shape;
        this.clip = z;
        this.ambientShadowColor = j2;
        this.spotShadowColor = j3;
        this.compositingStrategy = r22;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final SimpleGraphicsLayerModifier create() {
        return new SimpleGraphicsLayerModifier(this.scaleX, this.scaleY, this.alpha, this.translationX, this.translationY, this.shadowElevation, this.rotationX, this.rotationY, this.rotationZ, this.cameraDistance, this.transformOrigin, this.shape, this.clip, this.ambientShadowColor, this.spotShadowColor, this.compositingStrategy);
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraphicsLayerElement)) {
            return false;
        }
        GraphicsLayerElement graphicsLayerElement = (GraphicsLayerElement) obj;
        if (Float.compare(this.scaleX, graphicsLayerElement.scaleX) != 0 || Float.compare(this.scaleY, graphicsLayerElement.scaleY) != 0 || Float.compare(this.alpha, graphicsLayerElement.alpha) != 0 || Float.compare(this.translationX, graphicsLayerElement.translationX) != 0 || Float.compare(this.translationY, graphicsLayerElement.translationY) != 0 || Float.compare(this.shadowElevation, graphicsLayerElement.shadowElevation) != 0 || Float.compare(this.rotationX, graphicsLayerElement.rotationX) != 0 || Float.compare(this.rotationY, graphicsLayerElement.rotationY) != 0 || Float.compare(this.rotationZ, graphicsLayerElement.rotationZ) != 0 || Float.compare(this.cameraDistance, graphicsLayerElement.cameraDistance) != 0) {
            return false;
        }
        int r1 = TransformOrigin.$r8$clinit;
        if (this.transformOrigin == graphicsLayerElement.transformOrigin) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !Intrinsics.areEqual(this.shape, graphicsLayerElement.shape) || this.clip != graphicsLayerElement.clip || !Intrinsics.areEqual((Object) null, (Object) null) || !Color.m317equalsimpl0(this.ambientShadowColor, graphicsLayerElement.ambientShadowColor) || !Color.m317equalsimpl0(this.spotShadowColor, graphicsLayerElement.spotShadowColor)) {
            return false;
        }
        if (this.compositingStrategy == graphicsLayerElement.compositingStrategy) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final int hashCode() {
        int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.cameraDistance, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.rotationZ, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.rotationY, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.rotationX, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.shadowElevation, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.translationY, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.translationX, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.alpha, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.scaleY, Float.hashCode(this.scaleX) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31);
        int r1 = TransformOrigin.$r8$clinit;
        int hashCode = (this.shape.hashCode() + Scale$$ExternalSyntheticOutline0.m(this.transformOrigin, m, 31)) * 31;
        boolean z = this.clip;
        int r0 = z;
        if (z != 0) {
            r0 = 1;
        }
        int r12 = (((hashCode + r0) * 31) + 0) * 31;
        int r02 = Color.$r8$clinit;
        return Integer.hashCode(this.compositingStrategy) + Scale$$ExternalSyntheticOutline0.m(this.spotShadowColor, Scale$$ExternalSyntheticOutline0.m(this.ambientShadowColor, r12, 31), 31);
    }

    public final String toString() {
        return "GraphicsLayerElement(scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", alpha=" + this.alpha + ", translationX=" + this.translationX + ", translationY=" + this.translationY + ", shadowElevation=" + this.shadowElevation + ", rotationX=" + this.rotationX + ", rotationY=" + this.rotationY + ", rotationZ=" + this.rotationZ + ", cameraDistance=" + this.cameraDistance + ", transformOrigin=" + ((Object) TransformOrigin.m346toStringimpl(this.transformOrigin)) + ", shape=" + this.shape + ", clip=" + this.clip + ", renderEffect=null, ambientShadowColor=" + ((Object) Color.m323toStringimpl(this.ambientShadowColor)) + ", spotShadowColor=" + ((Object) Color.m323toStringimpl(this.spotShadowColor)) + ", compositingStrategy=" + ((Object) ("CompositingStrategy(value=" + this.compositingStrategy + ')')) + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        SimpleGraphicsLayerModifier node = simpleGraphicsLayerModifier;
        Intrinsics.checkNotNullParameter(node, "node");
        node.scaleX = this.scaleX;
        node.scaleY = this.scaleY;
        node.alpha = this.alpha;
        node.translationX = this.translationX;
        node.translationY = this.translationY;
        node.shadowElevation = this.shadowElevation;
        node.rotationX = this.rotationX;
        node.rotationY = this.rotationY;
        node.rotationZ = this.rotationZ;
        node.cameraDistance = this.cameraDistance;
        node.transformOrigin = this.transformOrigin;
        Shape shape = this.shape;
        Intrinsics.checkNotNullParameter(shape, "<set-?>");
        node.shape = shape;
        node.clip = this.clip;
        node.ambientShadowColor = this.ambientShadowColor;
        node.spotShadowColor = this.spotShadowColor;
        node.compositingStrategy = this.compositingStrategy;
        NodeCoordinator nodeCoordinator = DelegatableNodeKt.m441requireCoordinator64DMado(node, 2).wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.updateLayerBlock(true, node.layerBlock);
        }
    }
}
