package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public final class NodeCoordinator$Companion$PointerInputSource$1 implements NodeCoordinator.HitTestSource {
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* renamed from: childHitTest-YqVAtuI */
    public final void mo473childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        layoutNode.m447hitTestM_7yMNQ$ui_release(j, hitTestResult, z, z2);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    /* renamed from: entityType-OLwlOKw */
    public final int mo474entityTypeOLwlOKw() {
        return 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(node, "node");
        ?? r1 = 0;
        while (node != 0) {
            if (node instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents();
            } else {
                if ((node.kindSet & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (node instanceof DelegatingNode)) {
                    Modifier.Node node2 = node.delegate;
                    int r6 = 0;
                    r1 = r1;
                    node = node;
                    while (node2 != null) {
                        if ((node2.kindSet & 16) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            r6++;
                            r1 = r1;
                            if (r6 == 1) {
                                node = node2;
                            } else {
                                if (r1 == 0) {
                                    r1 = new MutableVector(new Modifier.Node[16]);
                                }
                                if (node != 0) {
                                    r1.add(node);
                                    node = 0;
                                }
                                r1.add(node2);
                            }
                        }
                        node2 = node2.child;
                        r1 = r1;
                        node = node;
                    }
                    if (r6 == 1) {
                    }
                }
            }
            node = DelegatableNodeKt.access$pop(r1);
        }
        return false;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
    public final boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
        Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
        return true;
    }
}
