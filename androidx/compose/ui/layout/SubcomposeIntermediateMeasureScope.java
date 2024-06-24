package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public interface SubcomposeIntermediateMeasureScope extends SubcomposeMeasureScope {
    Function2<SubcomposeMeasureScope, Constraints, MeasureResult> getLookaheadMeasurePolicy();

    List<Measurable> measurablesForSlot(Object obj);

    @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
    default List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return measurablesForSlot(obj);
    }
}
