package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;

/* compiled from: OnPositionedDispatcher.kt */
/* loaded from: classes.dex */
public final class OnPositionedDispatcher {
    public final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16]);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static void dispatchHierarchy(LayoutNode layoutNode) {
        boolean z;
        boolean z2;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        int r4 = 0;
        if (layoutNodeLayoutDelegate.layoutState == LayoutNode.LayoutState.Idle && !layoutNodeLayoutDelegate.layoutPending && !layoutNodeLayoutDelegate.measurePending && layoutNode.isPlaced()) {
            Modifier.Node node = layoutNode.nodes.head;
            if ((node.aggregateChildKindSet & 256) != 0) {
                while (node != null) {
                    if ((node.kindSet & 256) != 0) {
                        DelegatingNode delegatingNode = node;
                        ?? r6 = 0;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof GlobalPositionAwareModifierNode) {
                                GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) delegatingNode;
                                globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m441requireCoordinator64DMado(globalPositionAwareModifierNode, 256));
                            } else {
                                if ((delegatingNode.kindSet & 256) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node node2 = delegatingNode.delegate;
                                    int r8 = 0;
                                    delegatingNode = delegatingNode;
                                    r6 = r6;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 256) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            r8++;
                                            r6 = r6;
                                            if (r8 == 1) {
                                                delegatingNode = node2;
                                            } else {
                                                if (r6 == 0) {
                                                    r6 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (delegatingNode != 0) {
                                                    r6.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                r6.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
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
                    if ((node.aggregateChildKindSet & 256) == 0) {
                        break;
                    } else {
                        node = node.child;
                    }
                }
            }
        }
        layoutNode.needsOnPositionedDispatch = false;
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int r0 = mutableVector.size;
        if (r0 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            do {
                dispatchHierarchy(layoutNodeArr[r4]);
                r4++;
            } while (r4 < r0);
        }
    }
}
