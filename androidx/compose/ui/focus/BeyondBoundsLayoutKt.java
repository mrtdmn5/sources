package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BeyondBoundsLayout.kt */
/* loaded from: classes.dex */
public final class BeyondBoundsLayoutKt {
    /* renamed from: searchBeyondBounds--OM-vw8, reason: not valid java name */
    public static final <T> T m236searchBeyondBoundsOMvw8(FocusTargetNode focusTargetNode, int r11, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        int r2;
        boolean z;
        Modifier.Node node;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        NodeChain nodeChain;
        boolean z7;
        boolean z8;
        Modifier.Node node2 = focusTargetNode.node;
        if (node2.isAttached) {
            Modifier.Node node3 = node2.parent;
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                r2 = 1;
                z = false;
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
                                        z7 = true;
                                    } else {
                                        z7 = false;
                                    }
                                    if (z7 && (node instanceof DelegatingNode)) {
                                        int r8 = 0;
                                        for (Modifier.Node node4 = ((DelegatingNode) node).delegate; node4 != null; node4 = node4.child) {
                                            if ((node4.kindSet & 1024) != 0) {
                                                z8 = true;
                                            } else {
                                                z8 = false;
                                            }
                                            if (z8) {
                                                r8++;
                                                if (r8 == 1) {
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
                                        if (r8 == 1) {
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
            FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
            if (focusTargetNode2 != null) {
                ProvidableModifierLocal<BeyondBoundsLayout> providableModifierLocal = androidx.compose.ui.layout.BeyondBoundsLayoutKt.ModifierLocalBeyondBoundsLayout;
                if (Intrinsics.areEqual((BeyondBoundsLayout) focusTargetNode2.getCurrent(providableModifierLocal), (BeyondBoundsLayout) focusTargetNode.getCurrent(providableModifierLocal))) {
                    return null;
                }
            }
            BeyondBoundsLayout beyondBoundsLayout = (BeyondBoundsLayout) focusTargetNode.getCurrent(androidx.compose.ui.layout.BeyondBoundsLayoutKt.ModifierLocalBeyondBoundsLayout);
            if (beyondBoundsLayout == null) {
                return null;
            }
            int r0 = 5;
            if (r11 == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                r0 = 6;
                if (r11 == 6) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    r0 = 3;
                    if (r11 == 3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        r0 = 4;
                        if (r11 == 4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (!z5) {
                            if (r11 == 1) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                r2 = 2;
                            } else {
                                if (r11 == 2) {
                                    z = true;
                                }
                                if (!z) {
                                    throw new IllegalStateException("Unsupported direction for beyond bounds layout".toString());
                                }
                            }
                            return (T) beyondBoundsLayout.mo100layouto7g1Pn8(r2, function1);
                        }
                    }
                }
            }
            r2 = r0;
            return (T) beyondBoundsLayout.mo100layouto7g1Pn8(r2, function1);
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}
