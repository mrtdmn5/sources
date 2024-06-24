package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadDelegate.kt */
/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScope {
    public boolean isPlacingForAlignment;
    public boolean isShallowPlacing;

    public static void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        LayoutNode layoutNode;
        LayoutNodeAlignmentLines layoutNodeAlignmentLines;
        Intrinsics.checkNotNullParameter(nodeCoordinator, "<this>");
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrapped;
        if (nodeCoordinator2 != null) {
            layoutNode = nodeCoordinator2.layoutNode;
        } else {
            layoutNode = null;
        }
        LayoutNode layoutNode2 = nodeCoordinator.layoutNode;
        if (!Intrinsics.areEqual(layoutNode, layoutNode2)) {
            layoutNode2.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = layoutNode2.layoutDelegate.measurePassDelegate.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner != null && (layoutNodeAlignmentLines = ((LayoutNodeLayoutDelegate.MeasurePassDelegate) parentAlignmentLinesOwner).alignmentLines) != null) {
            layoutNodeAlignmentLines.onAlignmentsChanged();
        }
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        if (!getHasMeasureResult() || (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return IntOffset.m590getYimpl(this.apparentToRealOffset) + calculateAlignmentLine;
    }

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo454getPositionnOccac();

    public abstract void replace$ui_release();
}
