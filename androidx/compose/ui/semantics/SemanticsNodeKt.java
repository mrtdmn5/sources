package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsNode.kt */
/* loaded from: classes.dex */
public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z) {
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
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
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && (node2 instanceof DelegatingNode)) {
                            int r7 = 0;
                            for (Modifier.Node node3 = ((DelegatingNode) node2).delegate; node3 != null; node3 = node3.child) {
                                if ((node3.kindSet & 8) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    r7++;
                                    if (r7 == 1) {
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
                            if (r7 == 1) {
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
        Modifier.Node node4 = ((SemanticsModifierNode) obj).getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        return new SemanticsNode(node4, z, layoutNode, collapsedSemantics$ui_release);
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> selector) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (selector.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode layoutNode) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
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
                            if (((SemanticsModifierNode) node2).getShouldMergeDescendantSemantics()) {
                                obj = node2;
                                break loop0;
                            }
                        } else {
                            if ((node2.kindSet & 8) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (node2 instanceof DelegatingNode)) {
                                int r6 = 0;
                                for (Modifier.Node node3 = ((DelegatingNode) node2).delegate; node3 != null; node3 = node3.child) {
                                    if ((node3.kindSet & 8) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        r6++;
                                        if (r6 == 1) {
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
                                if (r6 == 1) {
                                }
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
        return (SemanticsModifierNode) obj;
    }
}
