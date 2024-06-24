package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GraphicsLayerModifier.kt */
/* loaded from: classes.dex */
public final class SimpleGraphicsLayerModifier extends Modifier.Node implements LayoutModifierNode {
    public float alpha;
    public long ambientShadowColor;
    public float cameraDistance;
    public boolean clip;
    public int compositingStrategy;
    public final SimpleGraphicsLayerModifier$layerBlock$1 layerBlock;
    public float rotationX;
    public float rotationY;
    public float rotationZ;
    public float scaleX;
    public float scaleY;
    public float shadowElevation;
    public Shape shape;
    public long spotShadowColor;
    public long transformOrigin;
    public float translationX;
    public float translationY;

    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1] */
    public SimpleGraphicsLayerModifier(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, long j2, long j3, int r23) {
        Intrinsics.checkNotNullParameter(shape, "shape");
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
        this.compositingStrategy = r23;
        this.layerBlock = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$layerBlock$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                GraphicsLayerScope graphicsLayerScope2 = graphicsLayerScope;
                Intrinsics.checkNotNullParameter(graphicsLayerScope2, "$this$null");
                SimpleGraphicsLayerModifier simpleGraphicsLayerModifier = SimpleGraphicsLayerModifier.this;
                graphicsLayerScope2.setScaleX(simpleGraphicsLayerModifier.scaleX);
                graphicsLayerScope2.setScaleY(simpleGraphicsLayerModifier.scaleY);
                graphicsLayerScope2.setAlpha(simpleGraphicsLayerModifier.alpha);
                graphicsLayerScope2.setTranslationX(simpleGraphicsLayerModifier.translationX);
                graphicsLayerScope2.setTranslationY(simpleGraphicsLayerModifier.translationY);
                graphicsLayerScope2.setShadowElevation(simpleGraphicsLayerModifier.shadowElevation);
                graphicsLayerScope2.setRotationX(simpleGraphicsLayerModifier.rotationX);
                graphicsLayerScope2.setRotationY(simpleGraphicsLayerModifier.rotationY);
                graphicsLayerScope2.setRotationZ(simpleGraphicsLayerModifier.rotationZ);
                graphicsLayerScope2.setCameraDistance(simpleGraphicsLayerModifier.cameraDistance);
                graphicsLayerScope2.mo335setTransformOrigin__ExYCQ(simpleGraphicsLayerModifier.transformOrigin);
                graphicsLayerScope2.setShape(simpleGraphicsLayerModifier.shape);
                graphicsLayerScope2.setClip(simpleGraphicsLayerModifier.clip);
                graphicsLayerScope2.setRenderEffect();
                graphicsLayerScope2.mo332setAmbientShadowColor8_81llA(simpleGraphicsLayerModifier.ambientShadowColor);
                graphicsLayerScope2.mo334setSpotShadowColor8_81llA(simpleGraphicsLayerModifier.spotShadowColor);
                graphicsLayerScope2.mo333setCompositingStrategyaDBOjCE(simpleGraphicsLayerModifier.compositingStrategy);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.graphics.SimpleGraphicsLayerModifier$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeWithLayer$default(layout, Placeable.this, 0, 0, this.layerBlock, 4);
                return Unit.INSTANCE;
            }
        });
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SimpleGraphicsLayerModifier(scaleX=");
        sb.append(this.scaleX);
        sb.append(", scaleY=");
        sb.append(this.scaleY);
        sb.append(", alpha = ");
        sb.append(this.alpha);
        sb.append(", translationX=");
        sb.append(this.translationX);
        sb.append(", translationY=");
        sb.append(this.translationY);
        sb.append(", shadowElevation=");
        sb.append(this.shadowElevation);
        sb.append(", rotationX=");
        sb.append(this.rotationX);
        sb.append(", rotationY=");
        sb.append(this.rotationY);
        sb.append(", rotationZ=");
        sb.append(this.rotationZ);
        sb.append(", cameraDistance=");
        sb.append(this.cameraDistance);
        sb.append(", transformOrigin=");
        sb.append((Object) TransformOrigin.m346toStringimpl(this.transformOrigin));
        sb.append(", shape=");
        sb.append(this.shape);
        sb.append(", clip=");
        sb.append(this.clip);
        sb.append(", renderEffect=null, ambientShadowColor=");
        sb.append((Object) Color.m323toStringimpl(this.ambientShadowColor));
        sb.append(", spotShadowColor=");
        sb.append((Object) Color.m323toStringimpl(this.spotShadowColor));
        sb.append(", compositingStrategy=");
        sb.append((Object) ("CompositingStrategy(value=" + this.compositingStrategy + ')'));
        sb.append(')');
        return sb.toString();
    }
}
