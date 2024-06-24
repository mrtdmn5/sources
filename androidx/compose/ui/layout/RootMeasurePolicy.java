package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RootMeasurePolicy.kt */
/* loaded from: classes.dex */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    public RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean isEmpty = measurables.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (isEmpty) {
            return measure.layout(Constraints.m567getMinWidthimpl(j), Constraints.m566getMinHeightimpl(j), emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    return Unit.INSTANCE;
                }
            });
        }
        if (measurables.size() == 1) {
            final Placeable mo421measureBRTryo0 = measurables.get(0).mo421measureBRTryo0(j);
            return measure.layout(ConstraintsKt.m576constrainWidthK40F9xA(mo421measureBRTryo0.width, j), ConstraintsKt.m575constrainHeightK40F9xA(mo421measureBRTryo0.height, j), emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    Placeable.PlacementScope.placeRelativeWithLayer$default(layout, Placeable.this, 0, 0);
                    return Unit.INSTANCE;
                }
            });
        }
        final ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r4 = 0; r4 < size; r4++) {
            arrayList.add(measurables.get(r4).mo421measureBRTryo0(j));
        }
        int size2 = arrayList.size();
        int r2 = 0;
        int r42 = 0;
        for (int r3 = 0; r3 < size2; r3++) {
            Placeable placeable = (Placeable) arrayList.get(r3);
            r2 = Math.max(placeable.width, r2);
            r42 = Math.max(placeable.height, r42);
        }
        return measure.layout(ConstraintsKt.m576constrainWidthK40F9xA(r2, j), ConstraintsKt.m575constrainHeightK40F9xA(r42, j), emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.RootMeasurePolicy$measure$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List<Placeable> list = arrayList;
                int size3 = list.size();
                for (int r32 = 0; r32 < size3; r32++) {
                    Placeable.PlacementScope.placeRelativeWithLayer$default(layout, list.get(r32), 0, 0);
                }
                return Unit.INSTANCE;
            }
        });
    }
}
