package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Intrinsic.kt */
/* loaded from: classes.dex */
public interface IntrinsicSizeModifier extends LayoutModifier {
    /* renamed from: calculateContentConstraints-l58MMJ0, reason: not valid java name */
    long mo69calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j);

    @Override // androidx.compose.ui.layout.LayoutModifier
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.maxIntrinsicHeight(r4);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.maxIntrinsicWidth(r4);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    default MeasureResult mo5measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(ConstraintsKt.m574constrainN9IONVI(j, mo69calculateContentConstraintsl58MMJ0(measure, measurable, j)));
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.IntrinsicSizeModifier$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                long j2 = IntOffset.Zero;
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                Placeable placeRelative = Placeable.this;
                Intrinsics.checkNotNullParameter(placeRelative, "$this$placeRelative");
                if (layout.getParentLayoutDirection() != LayoutDirection.Ltr && layout.getParentWidth() != 0) {
                    long IntOffset = IntOffsetKt.IntOffset((layout.getParentWidth() - placeRelative.width) - ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2));
                    long j3 = placeRelative.apparentToRealOffset;
                    placeRelative.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j3 >> 32)), IntOffset.m590getYimpl(j3) + IntOffset.m590getYimpl(IntOffset)), 0.0f, null);
                } else {
                    long j4 = placeRelative.apparentToRealOffset;
                    placeRelative.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (j2 >> 32)) + ((int) (j4 >> 32)), IntOffset.m590getYimpl(j4) + IntOffset.m590getYimpl(j2)), 0.0f, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.minIntrinsicHeight(r4);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int r4) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        return intrinsicMeasurable.minIntrinsicWidth(r4);
    }
}
