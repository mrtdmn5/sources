package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatableNode.kt */
/* loaded from: classes.dex */
public final class DelegatableNodeKt {
    public static final void access$addLayoutNodeChildren(MutableVector mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int r0 = mutableVector2.size;
        if (r0 > 0) {
            int r02 = r0 - 1;
            LayoutNode[] layoutNodeArr = mutableVector2.content;
            do {
                mutableVector.add(layoutNodeArr[r02].nodes.head);
                r02--;
            } while (r02 >= 0);
        }
    }

    public static final Modifier.Node access$pop(MutableVector mutableVector) {
        if (mutableVector != null && !mutableVector.isEmpty()) {
            return (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(node, "<this>");
        if ((node.kindSet & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        if (node instanceof LayoutModifierNode) {
            return (LayoutModifierNode) node;
        }
        if (node instanceof DelegatingNode) {
            Modifier.Node node2 = ((DelegatingNode) node).delegate;
            while (node2 != 0) {
                if (node2 instanceof LayoutModifierNode) {
                    return (LayoutModifierNode) node2;
                }
                if (node2 instanceof DelegatingNode) {
                    if ((node2.kindSet & 2) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        node2 = ((DelegatingNode) node2).delegate;
                    }
                }
                node2 = node2.child;
            }
        }
        return null;
    }

    /* renamed from: requireCoordinator-64DMado */
    public static final NodeCoordinator m441requireCoordinator64DMado(DelegatableNode requireCoordinator, int r3) {
        Intrinsics.checkNotNullParameter(requireCoordinator, "$this$requireCoordinator");
        NodeCoordinator nodeCoordinator = requireCoordinator.getNode().coordinator;
        Intrinsics.checkNotNull(nodeCoordinator);
        if (nodeCoordinator.getTail() == requireCoordinator && NodeKindKt.m476getIncludeSelfInTraversalH91voCI(r3)) {
            NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator2);
            return nodeCoordinator2;
        }
        return nodeCoordinator;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        NodeCoordinator nodeCoordinator = delegatableNode.getNode().coordinator;
        if (nodeCoordinator != null) {
            return nodeCoordinator.layoutNode;
        }
        throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Intrinsics.checkNotNullParameter(delegatableNode, "<this>");
        Owner owner = requireLayoutNode(delegatableNode).owner;
        if (owner != null) {
            return owner;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
