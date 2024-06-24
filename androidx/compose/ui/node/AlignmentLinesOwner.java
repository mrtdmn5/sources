package androidx.compose.ui.node;

import androidx.compose.ui.layout.Measurable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LayoutNodeLayoutDelegate.kt */
/* loaded from: classes.dex */
public interface AlignmentLinesOwner extends Measurable {
    void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> function1);

    AlignmentLines getAlignmentLines();

    InnerNodeCoordinator getInnerCoordinator();

    AlignmentLinesOwner getParentAlignmentLinesOwner();

    boolean isPlaced();

    void layoutChildren();

    void requestLayout();

    void requestMeasure();
}
