package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Offset.kt */
/* loaded from: classes.dex */
public final class OffsetPxNode extends Modifier.Node implements LayoutModifierNode {
    public Function1<? super Density, IntOffset> offset;
    public boolean rtlAware;

    public OffsetPxNode(boolean z, Function1 offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.offset = offset;
        this.rtlAware = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.OffsetPxNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                OffsetPxNode offsetPxNode = OffsetPxNode.this;
                long j2 = offsetPxNode.offset.invoke(measure).packedValue;
                if (offsetPxNode.rtlAware) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(layout, mo421measureBRTryo0, (int) (j2 >> 32), IntOffset.m590getYimpl(j2));
                } else {
                    Placeable.PlacementScope.placeWithLayer$default(layout, mo421measureBRTryo0, (int) (j2 >> 32), IntOffset.m590getYimpl(j2), null, 12);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
