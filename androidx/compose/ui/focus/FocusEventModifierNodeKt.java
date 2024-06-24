package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusEventModifierNode.kt */
/* loaded from: classes.dex */
public final class FocusEventModifierNodeKt {

    /* compiled from: FocusEventModifierNode.kt */
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
                r0[FocusStateImpl.ActiveParent.ordinal()] = 2;
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

    /* JADX WARN: Code restructure failed: missing block: B:118:0x008d, code lost:            continue;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.ui.focus.FocusStateImpl getFocusState(androidx.compose.ui.focus.FocusEventModifierNode r11) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusEventModifierNodeKt.getFocusState(androidx.compose.ui.focus.FocusEventModifierNode):androidx.compose.ui.focus.FocusStateImpl");
    }

    public static final void invalidateFocusEvent(FocusEventModifierNode focusEventModifierNode) {
        Intrinsics.checkNotNullParameter(focusEventModifierNode, "<this>");
        DelegatableNodeKt.requireOwner(focusEventModifierNode).getFocusOwner().scheduleInvalidation(focusEventModifierNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    public static final void refreshFocusEventNodes(FocusTargetNode focusTargetNode) {
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(focusTargetNode, "<this>");
        Modifier.Node node = focusTargetNode.node;
        if (node.isAttached) {
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            Modifier.Node node2 = node;
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 5120) != 0) {
                    while (node2 != null) {
                        int r2 = node2.kindSet;
                        if ((r2 & 5120) != 0) {
                            if (node2 != node) {
                                if ((r2 & 1024) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    return;
                                }
                            }
                            if ((r2 & 4096) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                DelegatingNode delegatingNode = node2;
                                ?? r6 = 0;
                                while (delegatingNode != 0) {
                                    if (delegatingNode instanceof FocusEventModifierNode) {
                                        FocusEventModifierNode focusEventModifierNode = (FocusEventModifierNode) delegatingNode;
                                        focusEventModifierNode.onFocusEvent(getFocusState(focusEventModifierNode));
                                    } else {
                                        if ((delegatingNode.kindSet & 4096) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2 && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node3 = delegatingNode.delegate;
                                            int r8 = 0;
                                            delegatingNode = delegatingNode;
                                            r6 = r6;
                                            while (node3 != null) {
                                                if ((node3.kindSet & 4096) != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    r8++;
                                                    r6 = r6;
                                                    if (r8 == 1) {
                                                        delegatingNode = node3;
                                                    } else {
                                                        if (r6 == 0) {
                                                            r6 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r6.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r6.add(node3);
                                                    }
                                                }
                                                node3 = node3.child;
                                                delegatingNode = delegatingNode;
                                                r6 = r6;
                                            }
                                            if (r8 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(r6);
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
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}
