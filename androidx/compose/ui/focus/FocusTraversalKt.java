package androidx.compose.ui.focus;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            try {
                r0[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FocusStateImpl.values().length];
            try {
                r02[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r02[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r02[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x003d, code lost:            continue;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode r9) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.findActiveFocusNode(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        Rect localBoundingBoxOf;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        NodeCoordinator nodeCoordinator = focusTargetNode.coordinator;
        if (nodeCoordinator == null || (localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).localBoundingBoxOf(nodeCoordinator, false)) == null) {
            return Rect.Zero;
        }
        return localBoundingBoxOf;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0023, code lost:            continue;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusTargetNode getActiveChild(androidx.compose.ui.focus.FocusTargetNode r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            androidx.compose.ui.Modifier$Node r9 = r9.node
            boolean r0 = r9.isAttached
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            if (r0 == 0) goto Lac
            androidx.compose.runtime.collection.MutableVector r0 = new androidx.compose.runtime.collection.MutableVector
            r2 = 16
            androidx.compose.ui.Modifier$Node[] r3 = new androidx.compose.ui.Modifier.Node[r2]
            r0.<init>(r3)
            androidx.compose.ui.Modifier$Node r3 = r9.child
            if (r3 != 0) goto L20
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r0, r9)
            goto L23
        L20:
            r0.add(r3)
        L23:
            boolean r9 = r0.isNotEmpty()
            if (r9 == 0) goto Lab
            int r9 = r0.size
            r3 = 1
            int r9 = r9 - r3
            java.lang.Object r9 = r0.removeAt(r9)
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            int r4 = r9.aggregateChildKindSet
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 != 0) goto L3d
            androidx.compose.ui.node.DelegatableNodeKt.access$addLayoutNodeChildren(r0, r9)
            goto L23
        L3d:
            if (r9 == 0) goto L23
            int r4 = r9.kindSet
            r4 = r4 & 1024(0x400, float:1.435E-42)
            if (r4 == 0) goto La8
            r4 = r1
        L46:
            if (r9 == 0) goto L23
            boolean r5 = r9 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r5 == 0) goto L62
            androidx.compose.ui.focus.FocusTargetNode r9 = (androidx.compose.ui.focus.FocusTargetNode) r9
            androidx.compose.ui.focus.FocusStateImpl r5 = r9.focusState
            int[] r6 = androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.$EnumSwitchMapping$1
            int r5 = r5.ordinal()
            r5 = r6[r5]
            if (r5 == r3) goto L61
            r6 = 2
            if (r5 == r6) goto L61
            r6 = 3
            if (r5 == r6) goto L61
            goto La3
        L61:
            return r9
        L62:
            int r5 = r9.kindSet
            r5 = r5 & 1024(0x400, float:1.435E-42)
            r6 = 0
            if (r5 == 0) goto L6b
            r5 = r3
            goto L6c
        L6b:
            r5 = r6
        L6c:
            if (r5 == 0) goto La3
            boolean r5 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto La3
            r5 = r9
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.delegate
            r7 = r6
        L78:
            if (r5 == 0) goto La0
            int r8 = r5.kindSet
            r8 = r8 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L82
            r8 = r3
            goto L83
        L82:
            r8 = r6
        L83:
            if (r8 == 0) goto L9d
            int r7 = r7 + 1
            if (r7 != r3) goto L8b
            r9 = r5
            goto L9d
        L8b:
            if (r4 != 0) goto L94
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r2]
            r4.<init>(r8)
        L94:
            if (r9 == 0) goto L9a
            r4.add(r9)
            r9 = r1
        L9a:
            r4.add(r5)
        L9d:
            androidx.compose.ui.Modifier$Node r5 = r5.child
            goto L78
        La0:
            if (r7 != r3) goto La3
            goto L46
        La3:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.access$pop(r4)
            goto L46
        La8:
            androidx.compose.ui.Modifier$Node r9 = r9.child
            goto L3d
        Lab:
            return r1
        Lac:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitChildren called on an unattached node"
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.getActiveChild(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        boolean z;
        boolean z2;
        LayoutNode layoutNode;
        LayoutNode layoutNode2;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        NodeCoordinator nodeCoordinator = focusTargetNode.coordinator;
        if (nodeCoordinator != null && (layoutNode2 = nodeCoordinator.layoutNode) != null && layoutNode2.isPlaced()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            NodeCoordinator nodeCoordinator2 = focusTargetNode.coordinator;
            if (nodeCoordinator2 != null && (layoutNode = nodeCoordinator2.layoutNode) != null && layoutNode.isAttached()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }
}
