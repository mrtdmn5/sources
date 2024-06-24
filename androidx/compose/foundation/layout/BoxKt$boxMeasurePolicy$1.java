package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: Box.kt */
/* loaded from: classes.dex */
public final class BoxKt$boxMeasurePolicy$1 implements MeasurePolicy {
    public final /* synthetic */ Alignment $alignment;
    public final /* synthetic */ boolean $propagateMinConstraints;

    public BoxKt$boxMeasurePolicy$1(Alignment alignment, boolean z) {
        this.$propagateMinConstraints = z;
        this.$alignment = alignment;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(final MeasureScope MeasurePolicy, final List<? extends Measurable> measurables, long j) {
        long m558copyZbe2FdA$default;
        int r5;
        int r2;
        BoxChildDataNode boxChildDataNode;
        boolean z;
        BoxChildDataNode boxChildDataNode2;
        boolean z2;
        BoxChildDataNode boxChildDataNode3;
        int m567getMinWidthimpl;
        int m566getMinHeightimpl;
        Placeable mo421measureBRTryo0;
        Intrinsics.checkNotNullParameter(MeasurePolicy, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        boolean isEmpty = measurables.isEmpty();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        if (isEmpty) {
            return MeasurePolicy.layout(Constraints.m567getMinWidthimpl(j), Constraints.m566getMinHeightimpl(j), emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    return Unit.INSTANCE;
                }
            });
        }
        if (this.$propagateMinConstraints) {
            m558copyZbe2FdA$default = j;
        } else {
            m558copyZbe2FdA$default = Constraints.m558copyZbe2FdA$default(j, 0, 0, 0, 0, 10);
        }
        boolean z3 = false;
        if (measurables.size() == 1) {
            final Measurable measurable = measurables.get(0);
            Object parentData = measurable.getParentData();
            if (parentData instanceof BoxChildDataNode) {
                boxChildDataNode3 = (BoxChildDataNode) parentData;
            } else {
                boxChildDataNode3 = null;
            }
            if (boxChildDataNode3 != null) {
                z3 = boxChildDataNode3.matchParentSize;
            }
            if (!z3) {
                mo421measureBRTryo0 = measurable.mo421measureBRTryo0(m558copyZbe2FdA$default);
                m567getMinWidthimpl = Math.max(Constraints.m567getMinWidthimpl(j), mo421measureBRTryo0.width);
                m566getMinHeightimpl = Math.max(Constraints.m566getMinHeightimpl(j), mo421measureBRTryo0.height);
            } else {
                m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
                m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
                mo421measureBRTryo0 = measurable.mo421measureBRTryo0(Constraints.Companion.m570fixedJhjzzOo(Constraints.m567getMinWidthimpl(j), Constraints.m566getMinHeightimpl(j)));
            }
            final int r10 = m567getMinWidthimpl;
            final int r11 = m566getMinHeightimpl;
            final Placeable placeable = mo421measureBRTryo0;
            final Alignment alignment = this.$alignment;
            return MeasurePolicy.layout(r10, r11, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope layout = placementScope;
                    Intrinsics.checkNotNullParameter(layout, "$this$layout");
                    BoxKt.access$placeInBox(layout, Placeable.this, measurable, MeasurePolicy.getLayoutDirection(), r10, r11, alignment);
                    return Unit.INSTANCE;
                }
            });
        }
        final Placeable[] placeableArr = new Placeable[measurables.size()];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = Constraints.m567getMinWidthimpl(j);
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = Constraints.m566getMinHeightimpl(j);
        int size = measurables.size();
        boolean z4 = false;
        for (int r13 = 0; r13 < size; r13++) {
            Measurable measurable2 = measurables.get(r13);
            Object parentData2 = measurable2.getParentData();
            if (parentData2 instanceof BoxChildDataNode) {
                boxChildDataNode2 = (BoxChildDataNode) parentData2;
            } else {
                boxChildDataNode2 = null;
            }
            if (boxChildDataNode2 != null) {
                z2 = boxChildDataNode2.matchParentSize;
            } else {
                z2 = false;
            }
            if (!z2) {
                Placeable mo421measureBRTryo02 = measurable2.mo421measureBRTryo0(m558copyZbe2FdA$default);
                placeableArr[r13] = mo421measureBRTryo02;
                ref$IntRef.element = Math.max(ref$IntRef.element, mo421measureBRTryo02.width);
                ref$IntRef2.element = Math.max(ref$IntRef2.element, mo421measureBRTryo02.height);
            } else {
                z4 = true;
            }
        }
        if (z4) {
            int r1 = ref$IntRef.element;
            if (r1 != Integer.MAX_VALUE) {
                r5 = r1;
            } else {
                r5 = 0;
            }
            int r6 = ref$IntRef2.element;
            if (r6 != Integer.MAX_VALUE) {
                r2 = r6;
            } else {
                r2 = 0;
            }
            long Constraints = ConstraintsKt.Constraints(r5, r1, r2, r6);
            int size2 = measurables.size();
            for (int r62 = 0; r62 < size2; r62++) {
                Measurable measurable3 = measurables.get(r62);
                Object parentData3 = measurable3.getParentData();
                if (parentData3 instanceof BoxChildDataNode) {
                    boxChildDataNode = (BoxChildDataNode) parentData3;
                } else {
                    boxChildDataNode = null;
                }
                if (boxChildDataNode != null) {
                    z = boxChildDataNode.matchParentSize;
                } else {
                    z = false;
                }
                if (z) {
                    placeableArr[r62] = measurable3.mo421measureBRTryo0(Constraints);
                }
            }
        }
        int r12 = ref$IntRef.element;
        int r132 = ref$IntRef2.element;
        final Alignment alignment2 = this.$alignment;
        return MeasurePolicy.layout(r12, r132, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxKt$boxMeasurePolicy$1$measure$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Alignment alignment3 = alignment2;
                Placeable[] placeableArr2 = placeableArr;
                int length = placeableArr2.length;
                int r0 = 0;
                int r102 = 0;
                while (r102 < length) {
                    Placeable placeable2 = placeableArr2[r102];
                    Intrinsics.checkNotNull(placeable2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    BoxKt.access$placeInBox(layout, placeable2, measurables.get(r0), MeasurePolicy.getLayoutDirection(), ref$IntRef.element, ref$IntRef2.element, alignment3);
                    r102++;
                    r0++;
                }
                return Unit.INSTANCE;
            }
        });
    }
}
