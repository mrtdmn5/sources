package androidx.compose.ui.input.pointer;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.PointerInputModifierNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    public NodeCoordinator coordinates;
    public boolean hasExited;
    public boolean isIn;
    public final Modifier.Node modifierNode;
    public PointerEvent pointerEvent;
    public final MutableVector<PointerId> pointerIds;
    public final LinkedHashMap relevantChanges;
    public boolean wasIn;

    public Node(Modifier.Node modifierNode) {
        Intrinsics.checkNotNullParameter(modifierNode, "modifierNode");
        this.modifierNode = modifierNode;
        this.pointerIds = new MutableVector<>(new PointerId[16]);
        this.relevantChanges = new LinkedHashMap();
        this.isIn = true;
        this.hasExited = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0202, code lost:            if (r12 != false) goto L108;     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x026c, code lost:            if (r2 == false) goto L149;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0210  */
    /* JADX WARN: Type inference failed for: r5v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v24, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean buildCache(java.util.Map<androidx.compose.ui.input.pointer.PointerId, androidx.compose.ui.input.pointer.PointerInputChange> r38, androidx.compose.ui.layout.LayoutCoordinates r39, androidx.compose.ui.input.pointer.InternalPointerEvent r40, boolean r41) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(java.util.Map, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public final void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> list = pointerEvent.changes;
        int size = list.size();
        boolean z = false;
        int r4 = 0;
        while (true) {
            boolean z2 = true;
            if (r4 >= size) {
                break;
            }
            PointerInputChange pointerInputChange = list.get(r4);
            boolean z3 = pointerInputChange.pressed;
            long j = pointerInputChange.id;
            if (z3 || (internalPointerEvent.m409issuesEnterExitEvent0FcD4WY(j) && this.isIn)) {
                z2 = false;
            }
            if (z2) {
                this.pointerIds.remove(new PointerId(j));
            }
            r4++;
        }
        this.isIn = false;
        if (pointerEvent.type == 5) {
            z = true;
        }
        this.hasExited = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.runtime.collection.MutableVector] */
    public final void dispatchCancel() {
        boolean z;
        boolean z2;
        MutableVector<Node> mutableVector = this.children;
        int r1 = mutableVector.size;
        if (r1 > 0) {
            Node[] nodeArr = mutableVector.content;
            int r4 = 0;
            do {
                nodeArr[r4].dispatchCancel();
                r4++;
            } while (r4 < r1);
        }
        DelegatingNode delegatingNode = this.modifierNode;
        ?? r42 = 0;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).onCancelPointerInput();
            } else {
                if ((delegatingNode.kindSet & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (delegatingNode instanceof DelegatingNode)) {
                    Modifier.Node node = delegatingNode.delegate;
                    int r7 = 0;
                    delegatingNode = delegatingNode;
                    r42 = r42;
                    while (node != null) {
                        if ((node.kindSet & 16) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            r7++;
                            r42 = r42;
                            if (r7 == 1) {
                                delegatingNode = node;
                            } else {
                                if (r42 == 0) {
                                    r42 = new MutableVector(new Modifier.Node[16]);
                                }
                                if (delegatingNode != 0) {
                                    r42.add(delegatingNode);
                                    delegatingNode = 0;
                                }
                                r42.add(node);
                            }
                        }
                        node = node.child;
                        delegatingNode = delegatingNode;
                        r42 = r42;
                    }
                    if (r7 == 1) {
                    }
                }
            }
            delegatingNode = DelegatableNodeKt.access$pop(r42);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> mutableVector;
        int r4;
        boolean z;
        boolean z2;
        LinkedHashMap linkedHashMap = this.relevantChanges;
        boolean z3 = false;
        int r3 = 0;
        z3 = false;
        if (!linkedHashMap.isEmpty()) {
            Modifier.Node node = this.modifierNode;
            if (node.isAttached) {
                PointerEvent pointerEvent = this.pointerEvent;
                Intrinsics.checkNotNull(pointerEvent);
                NodeCoordinator nodeCoordinator = this.coordinates;
                Intrinsics.checkNotNull(nodeCoordinator);
                long j = nodeCoordinator.measuredSize;
                DelegatingNode delegatingNode = node;
                ?? r8 = 0;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) delegatingNode).mo13onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, j);
                    } else {
                        if ((delegatingNode.kindSet & 16) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node node2 = delegatingNode.delegate;
                            int r12 = 0;
                            delegatingNode = delegatingNode;
                            r8 = r8;
                            while (node2 != null) {
                                if ((node2.kindSet & 16) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    r12++;
                                    r8 = r8;
                                    if (r12 == 1) {
                                        delegatingNode = node2;
                                    } else {
                                        if (r8 == 0) {
                                            r8 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (delegatingNode != 0) {
                                            r8.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        r8.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                delegatingNode = delegatingNode;
                                r8 = r8;
                            }
                            if (r12 == 1) {
                            }
                        }
                    }
                    delegatingNode = DelegatableNodeKt.access$pop(r8);
                }
                if (node.isAttached && (r4 = (mutableVector = this.children).size) > 0) {
                    Node[] nodeArr = mutableVector.content;
                    do {
                        nodeArr[r3].dispatchFinalEventPass(internalPointerEvent);
                        r3++;
                    } while (r3 < r4);
                }
                z3 = true;
            }
        }
        cleanUpHits(internalPointerEvent);
        linkedHashMap.clear();
        this.coordinates = null;
        return z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public final boolean dispatchMainEventPass(Map<PointerId, PointerInputChange> changes, LayoutCoordinates layoutCoordinates, InternalPointerEvent internalPointerEvent, boolean z) {
        boolean z2;
        boolean z3;
        MutableVector<Node> mutableVector;
        int r9;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(changes, "changes");
        LinkedHashMap linkedHashMap = this.relevantChanges;
        if (!linkedHashMap.isEmpty()) {
            DelegatingNode delegatingNode = this.modifierNode;
            if (delegatingNode.isAttached) {
                PointerEvent pointerEvent = this.pointerEvent;
                Intrinsics.checkNotNull(pointerEvent);
                NodeCoordinator nodeCoordinator = this.coordinates;
                Intrinsics.checkNotNull(nodeCoordinator);
                long j = nodeCoordinator.measuredSize;
                DelegatingNode delegatingNode2 = delegatingNode;
                ?? r92 = 0;
                while (delegatingNode2 != 0) {
                    if (delegatingNode2 instanceof PointerInputModifierNode) {
                        ((PointerInputModifierNode) delegatingNode2).mo13onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, j);
                    } else {
                        if ((delegatingNode2.kindSet & 16) != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4 && (delegatingNode2 instanceof DelegatingNode)) {
                            Modifier.Node node = delegatingNode2.delegate;
                            int r13 = 0;
                            delegatingNode2 = delegatingNode2;
                            r92 = r92;
                            while (node != null) {
                                if ((node.kindSet & 16) != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5) {
                                    r13++;
                                    r92 = r92;
                                    if (r13 == 1) {
                                        delegatingNode2 = node;
                                    } else {
                                        if (r92 == 0) {
                                            r92 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (delegatingNode2 != 0) {
                                            r92.add(delegatingNode2);
                                            delegatingNode2 = 0;
                                        }
                                        r92.add(node);
                                    }
                                }
                                node = node.child;
                                delegatingNode2 = delegatingNode2;
                                r92 = r92;
                            }
                            if (r13 == 1) {
                            }
                        }
                    }
                    delegatingNode2 = DelegatableNodeKt.access$pop(r92);
                }
                if (delegatingNode.isAttached && (r9 = (mutableVector = this.children).size) > 0) {
                    Node[] nodeArr = mutableVector.content;
                    int r12 = 0;
                    do {
                        Node node2 = nodeArr[r12];
                        NodeCoordinator nodeCoordinator2 = this.coordinates;
                        Intrinsics.checkNotNull(nodeCoordinator2);
                        node2.dispatchMainEventPass(linkedHashMap, nodeCoordinator2, internalPointerEvent, z);
                        r12++;
                    } while (r12 < r9);
                }
                if (delegatingNode.isAttached) {
                    ?? r1 = 0;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof PointerInputModifierNode) {
                            ((PointerInputModifierNode) delegatingNode).mo13onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, j);
                        } else {
                            if ((delegatingNode.kindSet & 16) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node node3 = delegatingNode.delegate;
                                int r8 = 0;
                                r1 = r1;
                                delegatingNode = delegatingNode;
                                while (node3 != null) {
                                    if ((node3.kindSet & 16) != 0) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        r8++;
                                        r1 = r1;
                                        if (r8 == 1) {
                                            delegatingNode = node3;
                                        } else {
                                            if (r1 == 0) {
                                                r1 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (delegatingNode != 0) {
                                                r1.add(delegatingNode);
                                                delegatingNode = 0;
                                            }
                                            r1.add(node3);
                                        }
                                    }
                                    node3 = node3.child;
                                    r1 = r1;
                                    delegatingNode = delegatingNode;
                                }
                                if (r8 == 1) {
                                }
                            }
                        }
                        delegatingNode = DelegatableNodeKt.access$pop(r1);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + this.children + ", pointerIds=" + this.pointerIds + ')';
    }
}
