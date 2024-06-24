package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class NodeCoordinator$Companion$SemanticsSource$1 implements NodeCoordinator.HitTestSource {
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* renamed from: childHitTest-YqVAtuI */
    public final void mo473childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeChain nodeChain = layoutNode.nodes;
        nodeChain.outerCoordinator.m469hitTestYqVAtuI(NodeCoordinator.SemanticsSource, nodeChain.outerCoordinator.m464fromParentPositionMKHz9U(j), hitTestResult, true, z2);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* renamed from: entityType-OLwlOKw */
    public final int mo474entityTypeOLwlOKw() {
        return 8;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return false;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
        Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
        SemanticsConfiguration collapsedSemantics$ui_release = parentLayoutNode.getCollapsedSemantics$ui_release();
        boolean z = false;
        if (collapsedSemantics$ui_release != null && collapsedSemantics$ui_release.isClearingSemantics) {
            z = true;
        }
        return !z;
    }
}
