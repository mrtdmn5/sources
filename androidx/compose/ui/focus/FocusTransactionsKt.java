package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTransactions.kt */
/* loaded from: classes.dex */
public final class FocusTransactionsKt {

    /* compiled from: FocusTransactions.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[CustomDestinationResult.values().length];
            try {
                r0[CustomDestinationResult.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[CustomDestinationResult.Redirected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[CustomDestinationResult.Cancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[CustomDestinationResult.RedirectCancelled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FocusStateImpl.values().length];
            try {
                r02[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r02[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        boolean z3;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int r0 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.focusState.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
                    if (activeChild != null) {
                        z3 = clearFocus(activeChild, z, z2);
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                        if (z2) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                if (z) {
                    focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                    if (z2) {
                        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                        return z;
                    }
                    return z;
                }
                return z;
            }
        } else {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        }
        return true;
    }

    public static final void grantFocus(final FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTransactionsKt$grantFocus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                FocusTargetNode.this.fetchFocusProperties$ui_release();
                return Unit.INSTANCE;
            }
        });
        int r0 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.focusState.ordinal()];
        if (r0 == 3 || r0 == 4) {
            focusTargetNode.setFocusState(FocusStateImpl.Active);
        }
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0 */
    public static final CustomDestinationResult m241performCustomClearFocusMxy_nc0(FocusTargetNode performCustomClearFocus, int r5) {
        boolean z;
        Intrinsics.checkNotNullParameter(performCustomClearFocus, "$this$performCustomClearFocus");
        int r0 = WhenMappings.$EnumSwitchMapping$1[performCustomClearFocus.focusState.ordinal()];
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomClearFocus);
                    if (activeChild != null) {
                        CustomDestinationResult m241performCustomClearFocusMxy_nc0 = m241performCustomClearFocusMxy_nc0(activeChild, r5);
                        CustomDestinationResult customDestinationResult = CustomDestinationResult.None;
                        if (m241performCustomClearFocusMxy_nc0 == customDestinationResult) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            m241performCustomClearFocusMxy_nc0 = null;
                        }
                        if (m241performCustomClearFocusMxy_nc0 == null) {
                            if (!performCustomClearFocus.isProcessingCustomExit) {
                                performCustomClearFocus.isProcessingCustomExit = true;
                                try {
                                    performCustomClearFocus.fetchFocusProperties$ui_release().exit.getClass();
                                    FocusRequester focusRequester = FocusRequester.Default;
                                    return customDestinationResult;
                                } finally {
                                    performCustomClearFocus.isProcessingCustomExit = false;
                                }
                            }
                            return customDestinationResult;
                        }
                        return m241performCustomClearFocusMxy_nc0;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
            } else {
                return CustomDestinationResult.Cancelled;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0 */
    public static final CustomDestinationResult m242performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                focusTargetNode.fetchFocusProperties$ui_release().enter.getClass();
                FocusRequester focusRequester = FocusRequester.Default;
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomRequestFocus-Mxy_nc0 */
    public static final CustomDestinationResult m243performCustomRequestFocusMxy_nc0(FocusTargetNode performCustomRequestFocus, int r13) {
        CustomDestinationResult customDestinationResult;
        Modifier.Node node;
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(performCustomRequestFocus, "$this$performCustomRequestFocus");
        int r0 = WhenMappings.$EnumSwitchMapping$1[performCustomRequestFocus.focusState.ordinal()];
        boolean z3 = true;
        if (r0 != 1 && r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4) {
                    Modifier.Node node2 = performCustomRequestFocus.node;
                    if (node2.isAttached) {
                        Modifier.Node node3 = node2.parent;
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(performCustomRequestFocus);
                        loop0: while (true) {
                            customDestinationResult = null;
                            if (requireLayoutNode != null) {
                                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 1024) != 0) {
                                    while (node3 != null) {
                                        if ((node3.kindSet & 1024) != 0) {
                                            node = node3;
                                            MutableVector mutableVector = null;
                                            while (node != null) {
                                                if (node instanceof FocusTargetNode) {
                                                    break loop0;
                                                }
                                                if ((node.kindSet & 1024) != 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                if (z && (node instanceof DelegatingNode)) {
                                                    int r10 = 0;
                                                    for (Modifier.Node node4 = ((DelegatingNode) node).delegate; node4 != null; node4 = node4.child) {
                                                        if ((node4.kindSet & 1024) != 0) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (z2) {
                                                            r10++;
                                                            if (r10 == 1) {
                                                                node = node4;
                                                            } else {
                                                                if (mutableVector == null) {
                                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                                }
                                                                if (node != null) {
                                                                    mutableVector.add(node);
                                                                    node = null;
                                                                }
                                                                mutableVector.add(node4);
                                                            }
                                                        }
                                                    }
                                                    if (r10 == 1) {
                                                    }
                                                }
                                                node = DelegatableNodeKt.access$pop(mutableVector);
                                            }
                                        }
                                        node3 = node3.parent;
                                    }
                                }
                                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                                if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                                    node3 = nodeChain.tail;
                                } else {
                                    node3 = null;
                                }
                            } else {
                                node = null;
                                break;
                            }
                        }
                        FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                        if (focusTargetNode == null) {
                            return CustomDestinationResult.None;
                        }
                        int r12 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.focusState.ordinal()];
                        if (r12 != 1) {
                            if (r12 != 2) {
                                if (r12 != 3) {
                                    if (r12 == 4) {
                                        CustomDestinationResult m243performCustomRequestFocusMxy_nc0 = m243performCustomRequestFocusMxy_nc0(focusTargetNode, r13);
                                        if (m243performCustomRequestFocusMxy_nc0 != CustomDestinationResult.None) {
                                            z3 = false;
                                        }
                                        if (!z3) {
                                            customDestinationResult = m243performCustomRequestFocusMxy_nc0;
                                        }
                                        if (customDestinationResult == null) {
                                            return m242performCustomEnterMxy_nc0(focusTargetNode);
                                        }
                                        return customDestinationResult;
                                    }
                                    throw new NoWhenBranchMatchedException();
                                }
                                return m243performCustomRequestFocusMxy_nc0(focusTargetNode, r13);
                            }
                            return CustomDestinationResult.Cancelled;
                        }
                        return m242performCustomEnterMxy_nc0(focusTargetNode);
                    }
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(performCustomRequestFocus);
            if (activeChild != null) {
                return m241performCustomClearFocusMxy_nc0(activeChild, r13);
            }
            throw new IllegalStateException("Required value was null.".toString());
        }
        return CustomDestinationResult.None;
    }

    public static final boolean performRequestFocus(FocusTargetNode focusTargetNode) {
        boolean z;
        Modifier.Node node;
        NodeChain nodeChain;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int r0 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.focusState.ordinal()];
        boolean z4 = true;
        if (r0 != 1 && r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4) {
                    Modifier.Node node2 = focusTargetNode.node;
                    if (node2.isAttached) {
                        Modifier.Node node3 = node2.parent;
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                        loop0: while (true) {
                            node = null;
                            if (requireLayoutNode == null) {
                                break;
                            }
                            if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 1024) != 0) {
                                while (node3 != null) {
                                    if ((node3.kindSet & 1024) != 0) {
                                        Modifier.Node node4 = node3;
                                        MutableVector mutableVector = null;
                                        while (node4 != null) {
                                            if (node4 instanceof FocusTargetNode) {
                                                node = node4;
                                                break loop0;
                                            }
                                            if ((node4.kindSet & 1024) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2 && (node4 instanceof DelegatingNode)) {
                                                int r8 = 0;
                                                for (Modifier.Node node5 = ((DelegatingNode) node4).delegate; node5 != null; node5 = node5.child) {
                                                    if ((node5.kindSet & 1024) != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (z3) {
                                                        r8++;
                                                        if (r8 == 1) {
                                                            node4 = node5;
                                                        } else {
                                                            if (mutableVector == null) {
                                                                mutableVector = new MutableVector(new Modifier.Node[16]);
                                                            }
                                                            if (node4 != null) {
                                                                mutableVector.add(node4);
                                                                node4 = null;
                                                            }
                                                            mutableVector.add(node5);
                                                        }
                                                    }
                                                }
                                                if (r8 == 1) {
                                                }
                                            }
                                            node4 = DelegatableNodeKt.access$pop(mutableVector);
                                        }
                                    }
                                    node3 = node3.parent;
                                }
                            }
                            requireLayoutNode = requireLayoutNode.getParent$ui_release();
                            if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                                node3 = nodeChain.tail;
                            } else {
                                node3 = null;
                            }
                        }
                        FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                        if (focusTargetNode2 != null) {
                            return requestFocusForChild(focusTargetNode2, focusTargetNode);
                        }
                        if (requestFocusForOwner(focusTargetNode)) {
                            grantFocus(focusTargetNode);
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                            return z4;
                        }
                        return z4;
                    }
                    throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                }
                throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                z = clearFocus(activeChild, false, true);
            } else {
                z = true;
            }
            if (z) {
                grantFocus(focusTargetNode);
            } else {
                z4 = false;
            }
            if (z4) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return z4;
            }
            return z4;
        }
        FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
        return true;
    }

    public static final boolean requestFocus(FocusTargetNode focusTargetNode) {
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        int r0 = WhenMappings.$EnumSwitchMapping$0[m243performCustomRequestFocusMxy_nc0(focusTargetNode, 7).ordinal()];
        if (r0 != 1) {
            if (r0 == 2) {
                return true;
            }
            if (r0 != 3 && r0 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return false;
        }
        return performRequestFocus(focusTargetNode);
    }

    public static final boolean requestFocusForChild(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        boolean z;
        Modifier.Node node;
        Modifier.Node node2;
        boolean z2;
        NodeChain nodeChain;
        boolean z3;
        boolean z4;
        NodeChain nodeChain2;
        boolean z5;
        boolean z6;
        Modifier.Node node3 = focusTargetNode2.node;
        if (node3.isAttached) {
            Modifier.Node node4 = node3.parent;
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
            loop0: while (true) {
                z = false;
                node = null;
                if (requireLayoutNode != null) {
                    if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 1024) != 0) {
                        while (node4 != null) {
                            if ((node4.kindSet & 1024) != 0) {
                                node2 = node4;
                                MutableVector mutableVector = null;
                                while (node2 != null) {
                                    if (node2 instanceof FocusTargetNode) {
                                        break loop0;
                                    }
                                    if ((node2.kindSet & 1024) != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                    }
                                    if (z5 && (node2 instanceof DelegatingNode)) {
                                        int r10 = 0;
                                        for (Modifier.Node node5 = ((DelegatingNode) node2).delegate; node5 != null; node5 = node5.child) {
                                            if ((node5.kindSet & 1024) != 0) {
                                                z6 = true;
                                            } else {
                                                z6 = false;
                                            }
                                            if (z6) {
                                                r10++;
                                                if (r10 == 1) {
                                                    node2 = node5;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (node2 != null) {
                                                        mutableVector.add(node2);
                                                        node2 = null;
                                                    }
                                                    mutableVector.add(node5);
                                                }
                                            }
                                        }
                                        if (r10 == 1) {
                                        }
                                    }
                                    node2 = DelegatableNodeKt.access$pop(mutableVector);
                                }
                            }
                            node4 = node4.parent;
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    if (requireLayoutNode != null && (nodeChain2 = requireLayoutNode.nodes) != null) {
                        node4 = nodeChain2.tail;
                    } else {
                        node4 = null;
                    }
                } else {
                    node2 = null;
                    break;
                }
            }
            if (Intrinsics.areEqual(node2, focusTargetNode)) {
                int r0 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.focusState.ordinal()];
                if (r0 != 1) {
                    if (r0 == 2) {
                        return false;
                    }
                    if (r0 != 3) {
                        if (r0 == 4) {
                            Modifier.Node node6 = focusTargetNode.node;
                            if (node6.isAttached) {
                                Modifier.Node node7 = node6.parent;
                                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                                loop4: while (true) {
                                    if (requireLayoutNode2 == null) {
                                        break;
                                    }
                                    if ((requireLayoutNode2.nodes.head.aggregateChildKindSet & 1024) != 0) {
                                        while (node7 != null) {
                                            if ((node7.kindSet & 1024) != 0) {
                                                Modifier.Node node8 = node7;
                                                MutableVector mutableVector2 = null;
                                                while (node8 != null) {
                                                    if (node8 instanceof FocusTargetNode) {
                                                        node = node8;
                                                        break loop4;
                                                    }
                                                    if ((node8.kindSet & 1024) != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (z3 && (node8 instanceof DelegatingNode)) {
                                                        int r9 = 0;
                                                        for (Modifier.Node node9 = ((DelegatingNode) node8).delegate; node9 != null; node9 = node9.child) {
                                                            if ((node9.kindSet & 1024) != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            if (z4) {
                                                                r9++;
                                                                if (r9 == 1) {
                                                                    node8 = node9;
                                                                } else {
                                                                    if (mutableVector2 == null) {
                                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                                    }
                                                                    if (node8 != null) {
                                                                        mutableVector2.add(node8);
                                                                        node8 = null;
                                                                    }
                                                                    mutableVector2.add(node9);
                                                                }
                                                            }
                                                        }
                                                        if (r9 == 1) {
                                                        }
                                                    }
                                                    node8 = DelegatableNodeKt.access$pop(mutableVector2);
                                                }
                                            }
                                            node7 = node7.parent;
                                        }
                                    }
                                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                                    if (requireLayoutNode2 != null && (nodeChain = requireLayoutNode2.nodes) != null) {
                                        node7 = nodeChain.tail;
                                    } else {
                                        node7 = null;
                                    }
                                }
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3 == null && requestFocusForOwner(focusTargetNode)) {
                                    focusTargetNode.setFocusState(FocusStateImpl.Active);
                                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                                    return requestFocusForChild(focusTargetNode, focusTargetNode2);
                                }
                                if (focusTargetNode3 == null || !requestFocusForChild(focusTargetNode3, focusTargetNode)) {
                                    return false;
                                }
                                boolean requestFocusForChild = requestFocusForChild(focusTargetNode, focusTargetNode2);
                                if (focusTargetNode.focusState == FocusStateImpl.ActiveParent) {
                                    z = true;
                                }
                                if (z) {
                                    return requestFocusForChild;
                                }
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (FocusTraversalKt.getActiveChild(focusTargetNode) != null) {
                        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
                        if (activeChild != null) {
                            z2 = clearFocus(activeChild, false, true);
                        } else {
                            z2 = true;
                        }
                        if (z2) {
                            grantFocus(focusTargetNode2);
                            z = true;
                        }
                        if (z) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                            return z;
                        }
                        return z;
                    }
                    throw new IllegalStateException("Required value was null.".toString());
                }
                grantFocus(focusTargetNode2);
                focusTargetNode.setFocusState(FocusStateImpl.ActiveParent);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode2);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                return true;
            }
            throw new IllegalStateException("Non child node cannot request focus.".toString());
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        Owner owner;
        NodeCoordinator nodeCoordinator = focusTargetNode.coordinator;
        if (nodeCoordinator != null && (layoutNode = nodeCoordinator.layoutNode) != null && (owner = layoutNode.owner) != null) {
            return owner.requestFocus();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }
}
