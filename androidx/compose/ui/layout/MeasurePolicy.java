package androidx.compose.ui.layout;

import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasurePolicy.kt */
/* loaded from: classes.dex */
public interface MeasurePolicy {
    default int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r3 = 0; r3 < size; r3++) {
            arrayList.add(new DefaultIntrinsicMeasurable(measurables.get(r3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }
        return mo4measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(r11, 0, 13)).getHeight();
    }

    default int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r3 = 0; r3 < size; r3++) {
            arrayList.add(new DefaultIntrinsicMeasurable(measurables.get(r3), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }
        return mo4measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, r11, 7)).getWidth();
    }

    /* renamed from: measure-3p2s80s */
    MeasureResult mo4measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j);

    default int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r3 = 0; r3 < size; r3++) {
            arrayList.add(new DefaultIntrinsicMeasurable(measurables.get(r3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }
        return mo4measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(r11, 0, 13)).getHeight();
    }

    default int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r11) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        ArrayList arrayList = new ArrayList(measurables.size());
        int size = measurables.size();
        for (int r3 = 0; r3 < size; r3++) {
            arrayList.add(new DefaultIntrinsicMeasurable(measurables.get(r3), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }
        return mo4measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, r11, 7)).getWidth();
    }
}
