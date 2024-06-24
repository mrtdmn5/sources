package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: LookaheadLayoutCoordinates.kt */
/* loaded from: classes.dex */
public final class LookaheadLayoutCoordinatesImpl implements LayoutCoordinates {
    public final LookaheadDelegate lookaheadDelegate;

    public LookaheadLayoutCoordinatesImpl(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* renamed from: getLookaheadOffset-F1C5BW0, reason: not valid java name */
    public final long m429getLookaheadOffsetF1C5BW0() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        LookaheadDelegate rootLookaheadDelegate = FlowKt.getRootLookaheadDelegate(lookaheadDelegate);
        int r2 = Offset.$r8$clinit;
        long j = Offset.Zero;
        return Offset.m261minusMKHz9U(mo424localPositionOfR5De75A(rootLookaheadDelegate.lookaheadLayoutCoordinates, j), lookaheadDelegate.coordinator.mo424localPositionOfR5De75A(rootLookaheadDelegate.coordinator, j));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        LookaheadDelegate lookaheadDelegate;
        if (isAttached()) {
            NodeCoordinator nodeCoordinator = this.lookaheadDelegate.coordinator.layoutNode.nodes.outerCoordinator.wrappedBy;
            if (nodeCoordinator == null || (lookaheadDelegate = nodeCoordinator.getLookaheadDelegate()) == null) {
                return null;
            }
            return lookaheadDelegate.lookaheadLayoutCoordinates;
        }
        throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo423getSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        return IntSizeKt.IntSize(lookaheadDelegate.width, lookaheadDelegate.height);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        return this.lookaheadDelegate.coordinator.isAttached();
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean z) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        return this.lookaheadDelegate.coordinator.localBoundingBoxOf(sourceCoordinates, z);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public final long mo424localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long j) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        boolean z = sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl;
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (z) {
            LookaheadDelegate lookaheadDelegate2 = ((LookaheadLayoutCoordinatesImpl) sourceCoordinates).lookaheadDelegate;
            lookaheadDelegate2.coordinator.onCoordinatesUsed$ui_release();
            LookaheadDelegate lookaheadDelegate3 = lookaheadDelegate.coordinator.findCommonAncestor$ui_release(lookaheadDelegate2.coordinator).getLookaheadDelegate();
            if (lookaheadDelegate3 != null) {
                long m455positionInBjo55l4$ui_release = lookaheadDelegate2.m455positionInBjo55l4$ui_release(lookaheadDelegate3);
                long IntOffset = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(j)), MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(j)));
                long IntOffset2 = IntOffsetKt.IntOffset(((int) (m455positionInBjo55l4$ui_release >> 32)) + ((int) (IntOffset >> 32)), IntOffset.m590getYimpl(IntOffset) + IntOffset.m590getYimpl(m455positionInBjo55l4$ui_release));
                long m455positionInBjo55l4$ui_release2 = lookaheadDelegate.m455positionInBjo55l4$ui_release(lookaheadDelegate3);
                long IntOffset3 = IntOffsetKt.IntOffset(((int) (IntOffset2 >> 32)) - ((int) (m455positionInBjo55l4$ui_release2 >> 32)), IntOffset.m590getYimpl(IntOffset2) - IntOffset.m590getYimpl(m455positionInBjo55l4$ui_release2));
                return OffsetKt.Offset((int) (IntOffset3 >> 32), IntOffset.m590getYimpl(IntOffset3));
            }
            LookaheadDelegate rootLookaheadDelegate = FlowKt.getRootLookaheadDelegate(lookaheadDelegate2);
            long m455positionInBjo55l4$ui_release3 = lookaheadDelegate2.m455positionInBjo55l4$ui_release(rootLookaheadDelegate);
            long j2 = rootLookaheadDelegate.position;
            long IntOffset4 = IntOffsetKt.IntOffset(((int) (m455positionInBjo55l4$ui_release3 >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(m455positionInBjo55l4$ui_release3));
            long IntOffset5 = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(j)), MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(j)));
            long IntOffset6 = IntOffsetKt.IntOffset(((int) (IntOffset4 >> 32)) + ((int) (IntOffset5 >> 32)), IntOffset.m590getYimpl(IntOffset5) + IntOffset.m590getYimpl(IntOffset4));
            long m455positionInBjo55l4$ui_release4 = lookaheadDelegate.m455positionInBjo55l4$ui_release(FlowKt.getRootLookaheadDelegate(lookaheadDelegate));
            long j3 = FlowKt.getRootLookaheadDelegate(lookaheadDelegate).position;
            long IntOffset7 = IntOffsetKt.IntOffset(((int) (m455positionInBjo55l4$ui_release4 >> 32)) + ((int) (j3 >> 32)), IntOffset.m590getYimpl(j3) + IntOffset.m590getYimpl(m455positionInBjo55l4$ui_release4));
            long IntOffset8 = IntOffsetKt.IntOffset(((int) (IntOffset6 >> 32)) - ((int) (IntOffset7 >> 32)), IntOffset.m590getYimpl(IntOffset6) - IntOffset.m590getYimpl(IntOffset7));
            NodeCoordinator nodeCoordinator = FlowKt.getRootLookaheadDelegate(lookaheadDelegate).coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            NodeCoordinator nodeCoordinator2 = rootLookaheadDelegate.coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            return nodeCoordinator.mo424localPositionOfR5De75A(nodeCoordinator2, OffsetKt.Offset((int) (IntOffset8 >> 32), IntOffset.m590getYimpl(IntOffset8)));
        }
        LookaheadDelegate rootLookaheadDelegate2 = FlowKt.getRootLookaheadDelegate(lookaheadDelegate);
        long mo424localPositionOfR5De75A = mo424localPositionOfR5De75A(rootLookaheadDelegate2.lookaheadLayoutCoordinates, j);
        NodeCoordinator nodeCoordinator3 = rootLookaheadDelegate2.coordinator;
        nodeCoordinator3.getClass();
        int r1 = Offset.$r8$clinit;
        return Offset.m262plusMKHz9U(mo424localPositionOfR5De75A, nodeCoordinator3.mo424localPositionOfR5De75A(sourceCoordinates, Offset.Zero));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public final long mo425localToRootMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo425localToRootMKHz9U(Offset.m262plusMKHz9U(j, m429getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public final long mo426localToWindowMKHz9U(long j) {
        return this.lookaheadDelegate.coordinator.mo426localToWindowMKHz9U(Offset.m262plusMKHz9U(j, m429getLookaheadOffsetF1C5BW0()));
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public final long mo427windowToLocalMKHz9U(long j) {
        return Offset.m262plusMKHz9U(this.lookaheadDelegate.coordinator.mo427windowToLocalMKHz9U(j), m429getLookaheadOffsetF1C5BW0());
    }
}
