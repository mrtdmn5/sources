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
public final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    public PaddingValues paddingValues;

    public PaddingValuesModifier(PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        this.paddingValues = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(final MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        boolean z = false;
        float f = 0;
        if (Float.compare(this.paddingValues.mo77calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()), f) >= 0 && Float.compare(this.paddingValues.mo79calculateTopPaddingD9Ej5fM(), f) >= 0 && Float.compare(this.paddingValues.mo78calculateRightPaddingu2uoSUM(measure.getLayoutDirection()), f) >= 0 && Float.compare(this.paddingValues.mo76calculateBottomPaddingD9Ej5fM(), f) >= 0) {
            z = true;
        }
        if (z) {
            int mo44roundToPx0680j_4 = measure.mo44roundToPx0680j_4(this.paddingValues.mo78calculateRightPaddingu2uoSUM(measure.getLayoutDirection())) + measure.mo44roundToPx0680j_4(this.paddingValues.mo77calculateLeftPaddingu2uoSUM(measure.getLayoutDirection()));
            int mo44roundToPx0680j_42 = measure.mo44roundToPx0680j_4(this.paddingValues.mo76calculateBottomPaddingD9Ej5fM()) + measure.mo44roundToPx0680j_4(this.paddingValues.mo79calculateTopPaddingD9Ej5fM());
            final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.m578offsetNN6EwU(j, -mo44roundToPx0680j_4, -mo44roundToPx0680j_42));
            return measure.layout(ConstraintsKt.m576constrainWidthK40F9xA(mo421measureBRTryo0.width + mo44roundToPx0680j_4, j), ConstraintsKt.m575constrainHeightK40F9xA(mo421measureBRTryo0.height + mo44roundToPx0680j_42, j), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    PaddingValuesModifier paddingValuesModifier = this;
                    PaddingValues paddingValues = paddingValuesModifier.paddingValues;
                    MeasureScope measureScope = measure;
                    Placeable.PlacementScope.place(Placeable.this, measureScope.mo44roundToPx0680j_4(paddingValues.mo77calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())), measureScope.mo44roundToPx0680j_4(paddingValuesModifier.paddingValues.mo79calculateTopPaddingD9Ej5fM()), 0.0f);
                    return Unit.INSTANCE;
                }
            });
        }
        throw new IllegalArgumentException("Padding must be non-negative".toString());
    }
}
