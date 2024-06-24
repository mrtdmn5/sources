package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeAlignmentLines.kt */
/* loaded from: classes.dex */
public final class LayoutNodeAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutNodeAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* renamed from: calculatePositionInParent-R5De75A */
    public final long mo439calculatePositionInParentR5De75A(NodeCoordinator calculatePositionInParent, long j) {
        Intrinsics.checkNotNullParameter(calculatePositionInParent, "$this$calculatePositionInParent");
        return calculatePositionInParent.m472toParentPositionMKHz9U(j);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public final Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        return nodeCoordinator.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public final int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return nodeCoordinator.get(alignmentLine);
    }
}
