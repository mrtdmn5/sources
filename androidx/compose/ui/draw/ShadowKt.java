package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Shadow.kt */
/* loaded from: classes.dex */
public final class ShadowKt {
    /* renamed from: shadow-s4CzXII$default, reason: not valid java name */
    public static Modifier m235shadows4CzXII$default(Modifier shadow, final float f, final Shape shape) {
        final boolean z = false;
        final long j = GraphicsLayerScopeKt.DefaultShadowColor;
        Intrinsics.checkNotNullParameter(shadow, "$this$shadow");
        Intrinsics.checkNotNullParameter(shape, "shape");
        if (Float.compare(f, 0) > 0) {
            return InspectableValueKt.inspectableWrapper(shadow, InspectableValueKt.NoInspectorInfo, GraphicsLayerModifierKt.graphicsLayer(Modifier.Companion.$$INSTANCE, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.ShadowKt$shadow$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                    GraphicsLayerScope graphicsLayer = graphicsLayerScope;
                    Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                    graphicsLayer.setShadowElevation(graphicsLayer.mo49toPx0680j_4(f));
                    graphicsLayer.setShape(shape);
                    graphicsLayer.setClip(z);
                    graphicsLayer.mo332setAmbientShadowColor8_81llA(j);
                    graphicsLayer.mo334setSpotShadowColor8_81llA(j);
                    return Unit.INSTANCE;
                }
            }));
        }
        return shadow;
    }
}
