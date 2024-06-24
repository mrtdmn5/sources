package androidx.compose.foundation.text;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicText.kt */
/* loaded from: classes.dex */
public final class EmptyMeasurePolicy implements MeasurePolicy {
    public static final EmptyMeasurePolicy INSTANCE = new EmptyMeasurePolicy();
    public static final EmptyMeasurePolicy$placementBlock$1 placementBlock = EmptyMeasurePolicy$placementBlock$1.INSTANCE;

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        return measure.layout(Constraints.m565getMaxWidthimpl(j), Constraints.m564getMaxHeightimpl(j), EmptyMap.INSTANCE, placementBlock);
    }
}
