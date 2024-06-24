package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: OneDimensionalFocusSearch.kt */
/* loaded from: classes.dex */
public final class OneDimensionalFocusSearchKt {

    /* compiled from: OneDimensionalFocusSearch.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FocusStateImpl.values().length];
            try {
                r0[FocusStateImpl.ActiveParent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        boolean z;
        FocusStateImpl focusStateImpl = focusTargetNode.focusState;
        int[] r1 = WhenMappings.$EnumSwitchMapping$0;
        int r0 = r1[focusStateImpl.ordinal()];
        if (r0 != 1) {
            if (r0 != 2 && r0 != 3) {
                if (r0 == 4) {
                    if (!pickChildForBackwardSearch(focusTargetNode, function1)) {
                        if (focusTargetNode.fetchFocusProperties$ui_release().canFocus) {
                            z = function1.invoke(focusTargetNode).booleanValue();
                        } else {
                            z = false;
                        }
                        if (!z) {
                            return false;
                        }
                    }
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                return pickChildForBackwardSearch(focusTargetNode, function1);
            }
        } else {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                int r12 = r1[activeChild.focusState.ordinal()];
                if (r12 != 1) {
                    if (r12 != 2 && r12 != 3) {
                        if (r12 != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
                    }
                    return m244generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, function1);
                }
                if (!backwardFocusSearch(activeChild, function1) && !m244generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 2, function1) && (!activeChild.fetchFocusProperties$ui_release().canFocus || !function1.invoke(activeChild).booleanValue())) {
                    return false;
                }
            } else {
                throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
            }
        }
        return true;
    }

    public static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        int r0 = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.focusState.ordinal()];
        if (r0 != 1) {
            if (r0 != 2 && r0 != 3) {
                if (r0 == 4) {
                    if (focusTargetNode.fetchFocusProperties$ui_release().canFocus) {
                        return function1.invoke(focusTargetNode).booleanValue();
                    }
                    return pickChildForForwardSearch(focusTargetNode, function1);
                }
                throw new NoWhenBranchMatchedException();
            }
            return pickChildForForwardSearch(focusTargetNode, function1);
        }
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            if (forwardFocusSearch(activeChild, function1) || m244generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, 1, function1)) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("ActiveParent must have a focusedChild".toString());
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m244generateAndSearchChildren4C6V_qg(final FocusTargetNode focusTargetNode, final FocusTargetNode focusTargetNode2, final int r3, final Function1<? super FocusTargetNode, Boolean> function1) {
        if (m245searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, r3, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m236searchBeyondBoundsOMvw8(focusTargetNode, r3, new Function1<BeyondBoundsLayout.BeyondBoundsScope, Boolean>() { // from class: androidx.compose.ui.focus.OneDimensionalFocusSearchKt$generateAndSearchChildren$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BeyondBoundsLayout.BeyondBoundsScope beyondBoundsScope) {
                boolean z;
                BeyondBoundsLayout.BeyondBoundsScope searchBeyondBounds = beyondBoundsScope;
                Intrinsics.checkNotNullParameter(searchBeyondBounds, "$this$searchBeyondBounds");
                Boolean valueOf = Boolean.valueOf(OneDimensionalFocusSearchKt.m245searchChildren4C6V_qg(FocusTargetNode.this, focusTargetNode2, r3, function1));
                if (!valueOf.booleanValue() && searchBeyondBounds.getHasMoreContent()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return null;
                }
                return valueOf;
            }
        });
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        boolean z;
        boolean z2;
        Object[] objArr = new FocusTargetNode[16];
        Modifier.Node node = focusTargetNode.node;
        if (node.isAttached) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            } else {
                mutableVector.add(node2);
            }
            int r3 = 0;
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
                if ((node3.aggregateChildKindSet & 1024) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node3);
                } else {
                    while (true) {
                        if (node3 == null) {
                            break;
                        }
                        if ((node3.kindSet & 1024) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                    int r8 = r3 + 1;
                                    if (objArr.length < r8) {
                                        objArr = Arrays.copyOf(objArr, Math.max(r8, objArr.length * 2));
                                        Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
                                    }
                                    objArr[r3] = focusTargetNode2;
                                    r3 = r8;
                                } else {
                                    if ((node3.kindSet & 1024) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && (node3 instanceof DelegatingNode)) {
                                        int r9 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 1024) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                r9++;
                                                if (r9 == 1) {
                                                    node3 = node4;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (node3 != null) {
                                                        mutableVector2.add(node3);
                                                        node3 = null;
                                                    }
                                                    mutableVector2.add(node4);
                                                }
                                            }
                                        }
                                        if (r9 == 1) {
                                        }
                                    }
                                }
                                node3 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        } else {
                            node3 = node3.child;
                        }
                    }
                }
            }
            FocusableChildrenComparator focusableChildrenComparator = FocusableChildrenComparator.INSTANCE;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Arrays.sort(objArr, 0, r3, focusableChildrenComparator);
            if (r3 > 0) {
                int r32 = r3 - 1;
                do {
                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[r32];
                    if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && backwardFocusSearch(focusTargetNode3, function1)) {
                        return true;
                    }
                    r32--;
                } while (r32 >= 0);
            }
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        boolean z;
        boolean z2;
        boolean z3;
        Object[] objArr = new FocusTargetNode[16];
        Modifier.Node node = focusTargetNode.node;
        if (node.isAttached) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
            Modifier.Node node2 = node.child;
            if (node2 == null) {
                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node);
            } else {
                mutableVector.add(node2);
            }
            int r3 = 0;
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
                if ((node3.aggregateChildKindSet & 1024) == 0) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node3);
                } else {
                    while (true) {
                        if (node3 == null) {
                            break;
                        }
                        if ((node3.kindSet & 1024) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                    int r8 = r3 + 1;
                                    if (objArr.length < r8) {
                                        objArr = Arrays.copyOf(objArr, Math.max(r8, objArr.length * 2));
                                        Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
                                    }
                                    objArr[r3] = focusTargetNode2;
                                    r3 = r8;
                                } else {
                                    if ((node3.kindSet & 1024) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2 && (node3 instanceof DelegatingNode)) {
                                        int r9 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 1024) != 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                r9++;
                                                if (r9 == 1) {
                                                    node3 = node4;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (node3 != null) {
                                                        mutableVector2.add(node3);
                                                        node3 = null;
                                                    }
                                                    mutableVector2.add(node4);
                                                }
                                            }
                                        }
                                        if (r9 == 1) {
                                        }
                                    }
                                }
                                node3 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        } else {
                            node3 = node3.child;
                        }
                    }
                }
            }
            FocusableChildrenComparator focusableChildrenComparator = FocusableChildrenComparator.INSTANCE;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Arrays.sort(objArr, 0, r3, focusableChildrenComparator);
            if (r3 <= 0) {
                return false;
            }
            int r0 = 0;
            do {
                FocusTargetNode focusTargetNode3 = (FocusTargetNode) objArr[r0];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, function1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return true;
                }
                r0++;
            } while (r0 < r3);
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: searchChildren-4C6V_qg, reason: not valid java name */
    public static final boolean m245searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int r18, Function1<? super FocusTargetNode, Boolean> function1) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Modifier.Node node;
        NodeChain nodeChain;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9 = true;
        if (focusTargetNode.focusState == FocusStateImpl.ActiveParent) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Object[] objArr = new FocusTargetNode[16];
            Modifier.Node node2 = focusTargetNode.node;
            if (node2.isAttached) {
                MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
                Modifier.Node node3 = node2.child;
                if (node3 == null) {
                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2);
                } else {
                    mutableVector.add(node3);
                }
                int r8 = 0;
                while (mutableVector.isNotEmpty()) {
                    Modifier.Node node4 = (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
                    if ((node4.aggregateChildKindSet & 1024) == 0) {
                        DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node4);
                    } else {
                        while (true) {
                            if (node4 == null) {
                                break;
                            }
                            if ((node4.kindSet & 1024) != 0) {
                                MutableVector mutableVector2 = null;
                                while (node4 != null) {
                                    if (node4 instanceof FocusTargetNode) {
                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node4;
                                        int r14 = r8 + 1;
                                        if (objArr.length < r14) {
                                            objArr = Arrays.copyOf(objArr, Math.max(r14, objArr.length * 2));
                                            Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(this, newSize)");
                                        }
                                        objArr[r8] = focusTargetNode3;
                                        r8 = r14;
                                    } else {
                                        if ((node4.kindSet & 1024) != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        if (z7 && (node4 instanceof DelegatingNode)) {
                                            int r15 = 0;
                                            for (Modifier.Node node5 = ((DelegatingNode) node4).delegate; node5 != null; node5 = node5.child) {
                                                if ((node5.kindSet & 1024) != 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    r15++;
                                                    if (r15 == 1) {
                                                        node4 = node5;
                                                    } else {
                                                        if (mutableVector2 == null) {
                                                            mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (node4 != null) {
                                                            mutableVector2.add(node4);
                                                            node4 = null;
                                                        }
                                                        mutableVector2.add(node5);
                                                    }
                                                }
                                            }
                                            if (r15 == 1) {
                                            }
                                        }
                                    }
                                    node4 = DelegatableNodeKt.access$pop(mutableVector2);
                                }
                            } else {
                                node4 = node4.child;
                            }
                        }
                    }
                }
                FocusableChildrenComparator focusableChildrenComparator = FocusableChildrenComparator.INSTANCE;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                Arrays.sort(objArr, 0, r8, focusableChildrenComparator);
                if (r18 == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    int r82 = new IntRange(0, r8 - 1).last;
                    if (r82 >= 0) {
                        boolean z10 = false;
                        int r10 = 0;
                        while (true) {
                            if (z10) {
                                FocusTargetNode focusTargetNode4 = (FocusTargetNode) objArr[r10];
                                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4) && forwardFocusSearch(focusTargetNode4, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual(objArr[r10], focusTargetNode2)) {
                                z10 = true;
                            }
                            if (r10 == r82) {
                                break;
                            }
                            r10++;
                        }
                    }
                } else {
                    if (r18 == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        int r83 = new IntRange(0, r8 - 1).last;
                        if (r83 >= 0) {
                            boolean z11 = false;
                            while (true) {
                                if (z11) {
                                    FocusTargetNode focusTargetNode5 = (FocusTargetNode) objArr[r83];
                                    if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode5) && backwardFocusSearch(focusTargetNode5, function1)) {
                                        return true;
                                    }
                                }
                                if (Intrinsics.areEqual(objArr[r83], focusTargetNode2)) {
                                    z11 = true;
                                }
                                if (r83 == 0) {
                                    break;
                                }
                                r83--;
                            }
                        }
                    } else {
                        throw new IllegalStateException("This function should only be used for 1-D focus search".toString());
                    }
                }
                if (r18 == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (!z4 && focusTargetNode.fetchFocusProperties$ui_release().canFocus) {
                    Modifier.Node node6 = focusTargetNode.node;
                    if (node6.isAttached) {
                        Modifier.Node node7 = node6.parent;
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                        loop5: while (true) {
                            if (requireLayoutNode != null) {
                                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 1024) != 0) {
                                    while (node7 != null) {
                                        if ((node7.kindSet & 1024) != 0) {
                                            Modifier.Node node8 = node7;
                                            MutableVector mutableVector3 = null;
                                            while (node8 != null) {
                                                if (node8 instanceof FocusTargetNode) {
                                                    node = node8;
                                                    break loop5;
                                                }
                                                if ((node8.kindSet & 1024) != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (z5 && (node8 instanceof DelegatingNode)) {
                                                    int r102 = 0;
                                                    for (Modifier.Node node9 = ((DelegatingNode) node8).delegate; node9 != null; node9 = node9.child) {
                                                        if ((node9.kindSet & 1024) != 0) {
                                                            z6 = true;
                                                        } else {
                                                            z6 = false;
                                                        }
                                                        if (z6) {
                                                            r102++;
                                                            if (r102 == 1) {
                                                                node8 = node9;
                                                            } else {
                                                                if (mutableVector3 == null) {
                                                                    mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                                }
                                                                if (node8 != null) {
                                                                    mutableVector3.add(node8);
                                                                    node8 = null;
                                                                }
                                                                mutableVector3.add(node9);
                                                            }
                                                        }
                                                    }
                                                    if (r102 == 1) {
                                                    }
                                                }
                                                node8 = DelegatableNodeKt.access$pop(mutableVector3);
                                            }
                                        }
                                        node7 = node7.parent;
                                    }
                                }
                                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                                if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                                    node7 = nodeChain.tail;
                                } else {
                                    node7 = null;
                                }
                            } else {
                                node = null;
                                break;
                            }
                        }
                        if (node != null) {
                            z9 = false;
                        }
                        if (!z9) {
                            return function1.invoke(focusTargetNode).booleanValue();
                        }
                    } else {
                        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                    }
                }
                return false;
            }
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }
}
