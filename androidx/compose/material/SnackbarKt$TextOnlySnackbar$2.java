package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snackbar.kt */
/* loaded from: classes.dex */
public final class SnackbarKt$TextOnlySnackbar$2 implements MeasurePolicy {
    public static final SnackbarKt$TextOnlySnackbar$2 INSTANCE = new SnackbarKt$TextOnlySnackbar$2();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope Layout, List<? extends Measurable> measurables, long j) {
        boolean z;
        boolean z2;
        float f;
        Intrinsics.checkNotNullParameter(Layout, "$this$Layout");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean z3 = false;
        if (measurables.size() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            final Placeable mo421measureBRTryo0 = ((Measurable) CollectionsKt___CollectionsKt.first((List) measurables)).mo421measureBRTryo0(j);
            int r0 = mo421measureBRTryo0.get(AlignmentLineKt.FirstBaseline);
            int r3 = mo421measureBRTryo0.get(AlignmentLineKt.LastBaseline);
            if (r0 != Integer.MIN_VALUE) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (r3 != Integer.MIN_VALUE) {
                    z3 = true;
                }
                if (z3) {
                    if (r0 == r3) {
                        f = SnackbarKt.SnackbarMinHeightOneLine;
                    } else {
                        f = SnackbarKt.SnackbarMinHeightTwoLines;
                    }
                    final int max = Math.max(Layout.mo44roundToPx0680j_4(f), mo421measureBRTryo0.height);
                    return Layout.layout(Constraints.m565getMaxWidthimpl(j), max, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.SnackbarKt$TextOnlySnackbar$2$measure$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout = placementScope;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            Placeable placeable = mo421measureBRTryo0;
                            Placeable.PlacementScope.placeRelative$default(layout, placeable, 0, (max - placeable.height) / 2);
                            return Unit.INSTANCE;
                        }
                    });
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
            throw new IllegalArgumentException("No baselines for text".toString());
        }
        throw new IllegalArgumentException("text for Snackbar expected to have exactly only one child".toString());
    }
}
