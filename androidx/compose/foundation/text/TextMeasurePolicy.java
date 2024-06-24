package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: BasicText.kt */
/* loaded from: classes.dex */
public final class TextMeasurePolicy implements MeasurePolicy {
    public final Function0<List<Rect>> placements;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<? extends List<Rect>> placements) {
        Intrinsics.checkNotNullParameter(placements, "placements");
        this.placements = placements;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Pair pair;
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        List<Rect> invoke = this.placements.invoke();
        final ArrayList arrayList = null;
        if (invoke != null) {
            ArrayList arrayList2 = new ArrayList(invoke.size());
            int size = invoke.size();
            for (int r7 = 0; r7 < size; r7++) {
                Rect rect = invoke.get(r7);
                if (rect != null) {
                    Measurable measurable = measurables.get(r7);
                    float f = rect.right;
                    float f2 = rect.left;
                    float f3 = rect.bottom;
                    pair = new Pair(measurable.mo421measureBRTryo0(ConstraintsKt.Constraints$default((int) Math.floor(f - f2), (int) Math.floor(f3 - r8), 5)), new IntOffset(IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(f2), MathKt__MathJVMKt.roundToInt(rect.top))));
                } else {
                    pair = null;
                }
                if (pair != null) {
                    arrayList2.add(pair);
                }
            }
            arrayList = arrayList2;
        }
        return measure.layout(Constraints.m565getMaxWidthimpl(j), Constraints.m564getMaxHeightimpl(j), EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                List<Pair<Placeable, IntOffset>> list = arrayList;
                if (list != null) {
                    int size2 = list.size();
                    for (int r1 = 0; r1 < size2; r1++) {
                        Pair<Placeable, IntOffset> pair2 = list.get(r1);
                        Placeable.PlacementScope.m432place70tqf50(pair2.first, pair2.second.packedValue, 0.0f);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
