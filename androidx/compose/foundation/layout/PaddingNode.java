package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Padding.kt */
/* loaded from: classes.dex */
public final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    public float bottom;
    public float end;
    public boolean rtlAware;
    public float start;
    public float top;

    public PaddingNode(float f, float f2, float f3, float f4, boolean z) {
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.rtlAware = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        int mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(this.end) + measure.mo44roundToPx0680j_4(this.start);
        int mo44roundToPx0680j_42 = measure.mo44roundToPx0680j_4(this.bottom) + measure.mo44roundToPx0680j_4(this.top);
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.m578offsetNN6EwU(j, -mo44roundToPx0680j_4, -mo44roundToPx0680j_42));
        return measure.layout(ConstraintsKt.m576constrainWidthK40F9xA(mo421measureBRTryo0.width + mo44roundToPx0680j_4, j), ConstraintsKt.m575constrainHeightK40F9xA(mo421measureBRTryo0.height + mo44roundToPx0680j_42, j), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                PaddingNode paddingNode = PaddingNode.this;
                boolean z = paddingNode.rtlAware;
                Placeable placeable = mo421measureBRTryo0;
                MeasureScope measureScope = measure;
                if (z) {
                    Placeable.PlacementScope.placeRelative$default(layout, placeable, measureScope.mo44roundToPx0680j_4(paddingNode.start), measureScope.mo44roundToPx0680j_4(paddingNode.top));
                } else {
                    Placeable.PlacementScope.place(placeable, measureScope.mo44roundToPx0680j_4(paddingNode.start), measureScope.mo44roundToPx0680j_4(paddingNode.top), 0.0f);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
