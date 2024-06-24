package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.InnerNodeCoordinator;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: LayoutCoordinates.kt */
/* loaded from: classes.dex */
public final class LayoutCoordinatesKt {
    public static final Rect boundsInParent(InnerNodeCoordinator innerNodeCoordinator) {
        Intrinsics.checkNotNullParameter(innerNodeCoordinator, "<this>");
        LayoutCoordinates parentLayoutCoordinates = innerNodeCoordinator.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            return ((NodeCoordinator) parentLayoutCoordinates).localBoundingBoxOf(innerNodeCoordinator, true);
        }
        long j = innerNodeCoordinator.measuredSize;
        return new Rect(0.0f, 0.0f, (int) (j >> 32), IntSize.m593getHeightimpl(j));
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return findRootCoordinates(layoutCoordinates).localBoundingBoxOf(layoutCoordinates, true);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        boolean z;
        boolean z2;
        LayoutCoordinates findRootCoordinates = findRootCoordinates(layoutCoordinates);
        Rect boundsInRoot = boundsInRoot(layoutCoordinates);
        float mo423getSizeYbymL2g = (int) (findRootCoordinates.mo423getSizeYbymL2g() >> 32);
        float m593getHeightimpl = IntSize.m593getHeightimpl(findRootCoordinates.mo423getSizeYbymL2g());
        float coerceIn = RangesKt___RangesKt.coerceIn(boundsInRoot.left, 0.0f, mo423getSizeYbymL2g);
        float coerceIn2 = RangesKt___RangesKt.coerceIn(boundsInRoot.top, 0.0f, m593getHeightimpl);
        float coerceIn3 = RangesKt___RangesKt.coerceIn(boundsInRoot.right, 0.0f, mo423getSizeYbymL2g);
        float coerceIn4 = RangesKt___RangesKt.coerceIn(boundsInRoot.bottom, 0.0f, m593getHeightimpl);
        if (coerceIn == coerceIn3) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (coerceIn2 == coerceIn4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                long mo426localToWindowMKHz9U = findRootCoordinates.mo426localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn2));
                long mo426localToWindowMKHz9U2 = findRootCoordinates.mo426localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn2));
                long mo426localToWindowMKHz9U3 = findRootCoordinates.mo426localToWindowMKHz9U(OffsetKt.Offset(coerceIn3, coerceIn4));
                long mo426localToWindowMKHz9U4 = findRootCoordinates.mo426localToWindowMKHz9U(OffsetKt.Offset(coerceIn, coerceIn4));
                float m259getXimpl = Offset.m259getXimpl(mo426localToWindowMKHz9U);
                float[] fArr = {Offset.m259getXimpl(mo426localToWindowMKHz9U2), Offset.m259getXimpl(mo426localToWindowMKHz9U4), Offset.m259getXimpl(mo426localToWindowMKHz9U3)};
                for (int r13 = 0; r13 < 3; r13++) {
                    m259getXimpl = Math.min(m259getXimpl, fArr[r13]);
                }
                float m260getYimpl = Offset.m260getYimpl(mo426localToWindowMKHz9U);
                float[] fArr2 = {Offset.m260getYimpl(mo426localToWindowMKHz9U2), Offset.m260getYimpl(mo426localToWindowMKHz9U4), Offset.m260getYimpl(mo426localToWindowMKHz9U3)};
                for (int r15 = 0; r15 < 3; r15++) {
                    m260getYimpl = Math.min(m260getYimpl, fArr2[r15]);
                }
                float m259getXimpl2 = Offset.m259getXimpl(mo426localToWindowMKHz9U);
                float[] fArr3 = {Offset.m259getXimpl(mo426localToWindowMKHz9U2), Offset.m259getXimpl(mo426localToWindowMKHz9U4), Offset.m259getXimpl(mo426localToWindowMKHz9U3)};
                for (int r152 = 0; r152 < 3; r152++) {
                    m259getXimpl2 = Math.max(m259getXimpl2, fArr3[r152]);
                }
                float m260getYimpl2 = Offset.m260getYimpl(mo426localToWindowMKHz9U);
                float[] fArr4 = {Offset.m260getYimpl(mo426localToWindowMKHz9U2), Offset.m260getYimpl(mo426localToWindowMKHz9U4), Offset.m260getYimpl(mo426localToWindowMKHz9U3)};
                for (int r7 = 0; r7 < 3; r7++) {
                    m260getYimpl2 = Math.max(m260getYimpl2, fArr4[r7]);
                }
                return new Rect(m259getXimpl, m260getYimpl, m259getXimpl2, m260getYimpl2);
            }
        }
        return Rect.Zero;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        NodeCoordinator nodeCoordinator;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        if (layoutCoordinates2 instanceof NodeCoordinator) {
            nodeCoordinator = (NodeCoordinator) layoutCoordinates2;
        } else {
            nodeCoordinator = null;
        }
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        while (true) {
            NodeCoordinator nodeCoordinator3 = nodeCoordinator2;
            NodeCoordinator nodeCoordinator4 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator3;
            if (nodeCoordinator != null) {
                nodeCoordinator2 = nodeCoordinator.wrappedBy;
            } else {
                return nodeCoordinator4;
            }
        }
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            int r1 = Offset.$r8$clinit;
            return parentLayoutCoordinates.mo424localPositionOfR5De75A(layoutCoordinates, Offset.Zero);
        }
        int r3 = Offset.$r8$clinit;
        return Offset.Zero;
    }

    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        int r0 = Offset.$r8$clinit;
        return layoutCoordinates.mo425localToRootMKHz9U(Offset.Zero);
    }
}
