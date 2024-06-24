package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatingNode.kt */
/* loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public Modifier.Node delegate;
    public final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public final void delegate(Modifier.Node node) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int r4;
        Modifier.Node node2;
        boolean z5;
        Modifier.Node node3 = node.node;
        boolean z6 = false;
        if (node3 != node) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Modifier.Node node4 = node.parent;
            if (node3 == this.node && Intrinsics.areEqual(node4, this)) {
                z6 = true;
            }
            if (z6) {
                return;
            } else {
                throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
            }
        }
        if (!node3.isAttached) {
            Modifier.Node owner = this.node;
            Intrinsics.checkNotNullParameter(owner, "owner");
            node3.node = owner;
            int r9 = this.kindSet;
            int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node3);
            node3.kindSet = calculateNodeKindSetFromIncludingDelegates;
            int r42 = this.kindSet;
            int r5 = calculateNodeKindSetFromIncludingDelegates & 2;
            if (r5 != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if ((r42 & 2) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5 && !(this instanceof LayoutModifierNode)) {
                    throw new IllegalStateException(("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node3).toString());
                }
            }
            node3.child = this.delegate;
            this.delegate = node3;
            node3.parent = this;
            int r3 = calculateNodeKindSetFromIncludingDelegates | r42;
            this.kindSet = r3;
            if (r42 != r3) {
                Modifier.Node node5 = this.node;
                if (node5 == this) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    this.aggregateChildKindSet = r3;
                }
                if (this.isAttached) {
                    Modifier.Node node6 = this;
                    while (node6 != null) {
                        r3 |= node6.kindSet;
                        node6.kindSet = r3;
                        if (node6 == node5) {
                            break;
                        } else {
                            node6 = node6.parent;
                        }
                    }
                    if (node6 != null && (node2 = node6.child) != null) {
                        r4 = node2.aggregateChildKindSet;
                    } else {
                        r4 = 0;
                    }
                    int r32 = r3 | r4;
                    while (node6 != null) {
                        r32 |= node6.kindSet;
                        node6.aggregateChildKindSet = r32;
                        node6 = node6.parent;
                    }
                }
            }
            if (this.isAttached) {
                if (r5 != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if ((r9 & 2) != 0) {
                        z6 = true;
                    }
                    if (!z6) {
                        NodeChain nodeChain = DelegatableNodeKt.requireLayoutNode(this).nodes;
                        this.node.updateCoordinator$ui_release(null);
                        nodeChain.syncCoordinators();
                        node3.markAsAttached$ui_release();
                        node3.runAttachLifecycle$ui_release();
                        NodeKindKt.autoInvalidateInsertedNode(node3);
                        return;
                    }
                }
                updateCoordinator$ui_release(this.coordinator);
                node3.markAsAttached$ui_release();
                node3.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(node3);
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot delegate to an already attached node".toString());
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.updateCoordinator$ui_release(this.coordinator);
            if (!node.isAttached) {
                node.markAsAttached$ui_release();
            }
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void markAsDetached$ui_release() {
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.reset$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void runAttachLifecycle$ui_release() {
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.runDetachLifecycle$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
        for (Modifier.Node node = this.delegate; node != null; node = node.child) {
            node.updateCoordinator$ui_release(nodeCoordinator);
        }
    }
}
