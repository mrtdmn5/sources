package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class NodeCoordinatorKt {
    /* renamed from: access$nextUntil-hw7D004, reason: not valid java name */
    public static final Modifier.Node m475access$nextUntilhw7D004(DelegatableNode delegatableNode, int r3) {
        Modifier.Node node = delegatableNode.getNode().child;
        if (node != null && (node.aggregateChildKindSet & r3) != 0) {
            while (node != null) {
                int r0 = node.kindSet;
                if ((r0 & 2) != 0) {
                    break;
                }
                if ((r0 & r3) == 0) {
                    node = node.child;
                } else {
                    return node;
                }
            }
        }
        return null;
    }
}
