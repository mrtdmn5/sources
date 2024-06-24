package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: Placeable.kt */
/* loaded from: classes.dex */
public final class PlaceableKt$DefaultLayerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    public static final PlaceableKt$DefaultLayerBlock$1 INSTANCE = new PlaceableKt$DefaultLayerBlock$1();

    public PlaceableKt$DefaultLayerBlock$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$null");
        return Unit.INSTANCE;
    }
}
