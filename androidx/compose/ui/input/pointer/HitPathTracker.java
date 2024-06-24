package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.InnerNodeCoordinator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public final class HitPathTracker {
    public final NodeParent root;
    public final LayoutCoordinates rootCoordinates;

    public HitPathTracker(InnerNodeCoordinator rootCoordinates) {
        Intrinsics.checkNotNullParameter(rootCoordinates, "rootCoordinates");
        this.rootCoordinates = rootCoordinates;
        this.root = new NodeParent();
    }

    /* renamed from: addHitPath-KNwqfcY, reason: not valid java name */
    public final void m408addHitPathKNwqfcY(long j, HitTestResult pointerInputNodes) {
        Node node;
        Intrinsics.checkNotNullParameter(pointerInputNodes, "pointerInputNodes");
        NodeParent nodeParent = this.root;
        int r1 = pointerInputNodes.size;
        boolean z = true;
        for (int r4 = 0; r4 < r1; r4++) {
            Modifier.Node node2 = (Modifier.Node) pointerInputNodes.get(r4);
            if (z) {
                MutableVector<Node> mutableVector = nodeParent.children;
                int r8 = mutableVector.size;
                if (r8 > 0) {
                    Node[] nodeArr = mutableVector.content;
                    int r9 = 0;
                    do {
                        node = nodeArr[r9];
                        if (Intrinsics.areEqual(node.modifierNode, node2)) {
                            break;
                        } else {
                            r9++;
                        }
                    } while (r9 < r8);
                }
                node = null;
                Node node3 = node;
                if (node3 != null) {
                    node3.isIn = true;
                    PointerId pointerId = new PointerId(j);
                    MutableVector<PointerId> mutableVector2 = node3.pointerIds;
                    if (!mutableVector2.contains(pointerId)) {
                        mutableVector2.add(new PointerId(j));
                    }
                    nodeParent = node3;
                } else {
                    z = false;
                }
            }
            Node node4 = new Node(node2);
            node4.pointerIds.add(new PointerId(j));
            nodeParent.children.add(node4);
            nodeParent = node4;
        }
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean z) {
        boolean z2;
        boolean z3;
        NodeParent nodeParent = this.root;
        Map<PointerId, PointerInputChange> changes = internalPointerEvent.changes;
        LayoutCoordinates parentCoordinates = this.rootCoordinates;
        if (!nodeParent.buildCache(changes, parentCoordinates, internalPointerEvent, z)) {
            return false;
        }
        Intrinsics.checkNotNullParameter(changes, "changes");
        Intrinsics.checkNotNullParameter(parentCoordinates, "parentCoordinates");
        MutableVector<Node> mutableVector = nodeParent.children;
        int r5 = mutableVector.size;
        if (r5 > 0) {
            Node[] nodeArr = mutableVector.content;
            int r8 = 0;
            z2 = false;
            do {
                if (!nodeArr[r8].dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, z) && !z2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                r8++;
            } while (r8 < r5);
        } else {
            z2 = false;
        }
        int r13 = mutableVector.size;
        if (r13 > 0) {
            Node[] nodeArr2 = mutableVector.content;
            int r2 = 0;
            z3 = false;
            do {
                if (!nodeArr2[r2].dispatchFinalEventPass(internalPointerEvent) && !z3) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                r2++;
            } while (r2 < r13);
        } else {
            z3 = false;
        }
        nodeParent.cleanUpHits(internalPointerEvent);
        if (!z3 && !z2) {
            return false;
        }
        return true;
    }
}
