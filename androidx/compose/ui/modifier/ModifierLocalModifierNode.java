package androidx.compose.ui.modifier;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.transition.PathMotion;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalModifierNode.kt */
/* loaded from: classes.dex */
public interface ModifierLocalModifierNode extends ModifierLocalReadScope, DelegatableNode {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.modifier.ModifierLocalReadScope
    default Object getCurrent(ProvidableModifierLocal providableModifierLocal) {
        NodeChain nodeChain;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(providableModifierLocal, "<this>");
        if (getNode().isAttached) {
            if (getNode().isAttached) {
                Modifier.Node node = getNode().parent;
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 32) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 32) != 0) {
                                DelegatingNode delegatingNode = node;
                                ?? r4 = 0;
                                while (delegatingNode != 0) {
                                    if (delegatingNode instanceof ModifierLocalModifierNode) {
                                        ModifierLocalModifierNode modifierLocalModifierNode = (ModifierLocalModifierNode) delegatingNode;
                                        if (modifierLocalModifierNode.getProvidedValues().contains$ui_release(providableModifierLocal)) {
                                            return modifierLocalModifierNode.getProvidedValues().get$ui_release(providableModifierLocal);
                                        }
                                    } else {
                                        if ((delegatingNode.kindSet & 32) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node2 = delegatingNode.delegate;
                                            int r8 = 0;
                                            delegatingNode = delegatingNode;
                                            r4 = r4;
                                            while (node2 != null) {
                                                if ((node2.kindSet & 32) != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    r8++;
                                                    r4 = r4;
                                                    if (r8 == 1) {
                                                        delegatingNode = node2;
                                                    } else {
                                                        if (r4 == 0) {
                                                            r4 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r4.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r4.add(node2);
                                                    }
                                                }
                                                node2 = node2.child;
                                                delegatingNode = delegatingNode;
                                                r4 = r4;
                                            }
                                            if (r8 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(r4);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                        node = nodeChain.tail;
                    } else {
                        node = null;
                    }
                }
                return providableModifierLocal.defaultFactory.invoke();
            }
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    default PathMotion getProvidedValues() {
        return EmptyMap.INSTANCE;
    }
}
