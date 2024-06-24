package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: FocusTargetNode.kt */
/* loaded from: classes.dex */
public final class FocusTargetNode extends Modifier.Node implements ObserverModifierNode, ModifierLocalModifierNode {
    public FocusStateImpl focusState = FocusStateImpl.Inactive;
    public boolean isProcessingCustomEnter;
    public boolean isProcessingCustomExit;

    /* compiled from: FocusTargetNode.kt */
    /* loaded from: classes.dex */
    public static final class FocusTargetElement extends ModifierNodeElement<FocusTargetNode> {
        public static final FocusTargetElement INSTANCE = new FocusTargetElement();

        private FocusTargetElement() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final FocusTargetNode create() {
            return new FocusTargetNode();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return false;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final int hashCode() {
            return 1739042953;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(FocusTargetNode focusTargetNode) {
            FocusTargetNode node = focusTargetNode;
            Intrinsics.checkNotNullParameter(node, "node");
        }
    }

    /* compiled from: FocusTargetNode.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FocusStateImpl.values().length];
            try {
                r0[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FocusStateImpl.Captured.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    public final FocusPropertiesImpl fetchFocusProperties$ui_release() {
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        Modifier.Node node = this.node;
        if (node.isAttached) {
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
            Modifier.Node node2 = node;
            loop0: while (requireLayoutNode != null) {
                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 3072) != 0) {
                    while (node2 != null) {
                        int r4 = node2.kindSet;
                        if ((r4 & 3072) != 0) {
                            if (node2 != node) {
                                if ((r4 & 1024) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    break loop0;
                                }
                            }
                            if ((r4 & 2048) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                DelegatingNode delegatingNode = node2;
                                ?? r8 = 0;
                                while (delegatingNode != 0) {
                                    if (delegatingNode instanceof FocusPropertiesModifierNode) {
                                        ((FocusPropertiesModifierNode) delegatingNode).applyFocusProperties(focusPropertiesImpl);
                                    } else {
                                        if ((delegatingNode.kindSet & 2048) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2 && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node3 = delegatingNode.delegate;
                                            int r10 = 0;
                                            delegatingNode = delegatingNode;
                                            r8 = r8;
                                            while (node3 != null) {
                                                if ((node3.kindSet & 2048) != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    r10++;
                                                    r8 = r8;
                                                    if (r10 == 1) {
                                                        delegatingNode = node3;
                                                    } else {
                                                        if (r8 == 0) {
                                                            r8 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r8.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r8.add(node3);
                                                    }
                                                }
                                                node3 = node3.child;
                                                delegatingNode = delegatingNode;
                                                r8 = r8;
                                            }
                                            if (r10 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(r8);
                                }
                            }
                        }
                        node2 = node2.parent;
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                    node2 = nodeChain.tail;
                } else {
                    node2 = null;
                }
            }
            return focusPropertiesImpl;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public final void invalidateFocus$ui_release() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.focusState.ordinal()];
        if (r0 == 1 || r0 == 2) {
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ObserverModifierNodeKt.observeReads(this, new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusTargetNode$invalidateFocus$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.focus.FocusPropertiesImpl, T] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    ref$ObjectRef.element = this.fetchFocusProperties$ui_release();
                    return Unit.INSTANCE;
                }
            });
            T t = ref$ObjectRef.element;
            if (t != 0) {
                if (!((FocusProperties) t).getCanFocus()) {
                    DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("focusProperties");
            throw null;
        }
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        FocusStateImpl focusStateImpl = this.focusState;
        invalidateFocus$ui_release();
        if (focusStateImpl != this.focusState) {
            FocusEventModifierNodeKt.refreshFocusEventNodes(this);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onReset() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.focusState.ordinal()];
        if (r0 != 1 && r0 != 2) {
            if (r0 != 3) {
                if (r0 == 4) {
                    scheduleInvalidationForFocusEvents$ui_release();
                    return;
                }
                return;
            } else {
                scheduleInvalidationForFocusEvents$ui_release();
                setFocusState(FocusStateImpl.Inactive);
                return;
            }
        }
        DelegatableNodeKt.requireOwner(this).getFocusOwner().clearFocus(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v33 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [androidx.compose.runtime.collection.MutableVector] */
    public final void scheduleInvalidationForFocusEvents$ui_release() {
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        DelegatingNode delegatingNode = this.node;
        ?? r2 = 0;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof FocusEventModifierNode) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) delegatingNode);
            } else {
                if ((delegatingNode.kindSet & 4096) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4 && (delegatingNode instanceof DelegatingNode)) {
                    Modifier.Node node = delegatingNode.delegate;
                    int r7 = 0;
                    delegatingNode = delegatingNode;
                    r2 = r2;
                    while (node != null) {
                        if ((node.kindSet & 4096) != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            r7++;
                            r2 = r2;
                            if (r7 == 1) {
                                delegatingNode = node;
                            } else {
                                if (r2 == 0) {
                                    r2 = new MutableVector(new Modifier.Node[16]);
                                }
                                if (delegatingNode != 0) {
                                    r2.add(delegatingNode);
                                    delegatingNode = 0;
                                }
                                r2.add(node);
                            }
                        }
                        node = node.child;
                        delegatingNode = delegatingNode;
                        r2 = r2;
                    }
                    if (r7 == 1) {
                    }
                }
            }
            delegatingNode = DelegatableNodeKt.access$pop(r2);
        }
        Modifier.Node node2 = this.node;
        if (node2.isAttached) {
            Modifier.Node node3 = node2.parent;
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 5120) != 0) {
                    while (node3 != null) {
                        int r6 = node3.kindSet;
                        if ((r6 & 5120) != 0) {
                            if ((r6 & 1024) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z && node3.isAttached) {
                                DelegatingNode delegatingNode2 = node3;
                                ?? r72 = 0;
                                while (delegatingNode2 != 0) {
                                    if (delegatingNode2 instanceof FocusEventModifierNode) {
                                        FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) delegatingNode2);
                                    } else {
                                        if ((delegatingNode2.kindSet & 4096) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2 && (delegatingNode2 instanceof DelegatingNode)) {
                                            Modifier.Node node4 = delegatingNode2.delegate;
                                            int r9 = 0;
                                            delegatingNode2 = delegatingNode2;
                                            r72 = r72;
                                            while (node4 != null) {
                                                if ((node4.kindSet & 4096) != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    r9++;
                                                    r72 = r72;
                                                    if (r9 == 1) {
                                                        delegatingNode2 = node4;
                                                    } else {
                                                        if (r72 == 0) {
                                                            r72 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode2 != 0) {
                                                            r72.add(delegatingNode2);
                                                            delegatingNode2 = 0;
                                                        }
                                                        r72.add(node4);
                                                    }
                                                }
                                                node4 = node4.child;
                                                delegatingNode2 = delegatingNode2;
                                                r72 = r72;
                                            }
                                            if (r9 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode2 = DelegatableNodeKt.access$pop(r72);
                                }
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
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public final void setFocusState(FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "<set-?>");
        this.focusState = focusStateImpl;
    }
}
