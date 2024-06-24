package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeAlignmentLines.kt */
/* loaded from: classes.dex */
public final class LookaheadAlignmentLines extends AlignmentLines {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LookaheadAlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        super(alignmentLinesOwner);
        Intrinsics.checkNotNullParameter(alignmentLinesOwner, "alignmentLinesOwner");
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    /* renamed from: calculatePositionInParent-R5De75A */
    public final long mo439calculatePositionInParentR5De75A(NodeCoordinator calculatePositionInParent, long j) {
        Intrinsics.checkNotNullParameter(calculatePositionInParent, "$this$calculatePositionInParent");
        LookaheadDelegate lookaheadDelegate = calculatePositionInParent.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        long j2 = lookaheadDelegate.position;
        return Offset.m262plusMKHz9U(OffsetKt.Offset((int) (j2 >> 32), IntOffset.m590getYimpl(j2)), j);
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public final Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.getMeasureResult$ui_release().getAlignmentLines();
    }

    @Override // androidx.compose.ui.node.AlignmentLines
    public final int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        return lookaheadDelegate.get(alignmentLine);
    }
}
