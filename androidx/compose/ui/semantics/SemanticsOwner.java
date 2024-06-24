package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsOwner.kt */
/* loaded from: classes.dex */
public final class SemanticsOwner {
    public final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode rootNode) {
        Intrinsics.checkNotNullParameter(rootNode, "rootNode");
        this.rootNode = rootNode;
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        boolean z;
        boolean z2;
        LayoutNode layoutNode = this.rootNode;
        Modifier.Node node = layoutNode.nodes.head;
        Object obj = null;
        if ((node.aggregateChildKindSet & 8) != 0) {
            loop0: while (true) {
                if (node == null) {
                    break;
                }
                if ((node.kindSet & 8) != 0) {
                    Modifier.Node node2 = node;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof SemanticsModifierNode) {
                            obj = node2;
                            break loop0;
                        }
                        if ((node2.kindSet & 8) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (node2 instanceof DelegatingNode)) {
                            int r8 = 0;
                            for (Modifier.Node node3 = ((DelegatingNode) node2).delegate; node3 != null; node3 = node3.child) {
                                if ((node3.kindSet & 8) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    r8++;
                                    if (r8 == 1) {
                                        node2 = node3;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (node2 != null) {
                                            mutableVector.add(node2);
                                            node2 = null;
                                        }
                                        mutableVector.add(node3);
                                    }
                                }
                            }
                            if (r8 == 1) {
                            }
                        }
                        node2 = DelegatableNodeKt.access$pop(mutableVector);
                    }
                }
                if ((node.aggregateChildKindSet & 8) == 0) {
                    break;
                }
                node = node.child;
            }
        }
        Intrinsics.checkNotNull(obj);
        return new SemanticsNode(((SemanticsModifierNode) obj).getNode(), false, layoutNode, new SemanticsConfiguration());
    }
}
