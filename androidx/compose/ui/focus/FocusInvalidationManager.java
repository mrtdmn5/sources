package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.platform.AndroidComposeView$focusOwner$1;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusInvalidationManager.kt */
/* loaded from: classes.dex */
public final class FocusInvalidationManager {
    public final Function1<Function0<Unit>, Unit> onRequestApplyChangesListener;
    public final LinkedHashSet focusTargetNodes = new LinkedHashSet();
    public final LinkedHashSet focusEventNodes = new LinkedHashSet();
    public final LinkedHashSet focusPropertiesNodes = new LinkedHashSet();
    public final FocusInvalidationManager$invalidateNodes$1 invalidateNodes = new Function0<Unit>() { // from class: androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int r0;
            char c;
            FocusStateImpl focusStateImpl;
            boolean z;
            MutableVector mutableVector;
            boolean z2;
            MutableVector mutableVector2;
            int r6;
            int r5;
            MutableVector mutableVector3;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            FocusInvalidationManager focusInvalidationManager = FocusInvalidationManager.this;
            Iterator it = focusInvalidationManager.focusPropertiesNodes.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                LinkedHashSet<FocusTargetNode> linkedHashSet = focusInvalidationManager.focusTargetNodes;
                char c2 = 16;
                int r8 = 1;
                if (hasNext) {
                    FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                    if (focusPropertiesModifierNode.getNode().isAttached) {
                        Modifier.Node node = focusPropertiesModifierNode.getNode();
                        MutableVector mutableVector4 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                linkedHashSet.add((FocusTargetNode) node);
                            } else {
                                if ((node.kindSet & 1024) != 0) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                if (z5 && (node instanceof DelegatingNode)) {
                                    int r13 = 0;
                                    for (Modifier.Node node2 = ((DelegatingNode) node).delegate; node2 != null; node2 = node2.child) {
                                        if ((node2.kindSet & 1024) != 0) {
                                            z6 = true;
                                        } else {
                                            z6 = false;
                                        }
                                        if (z6) {
                                            r13++;
                                            if (r13 == 1) {
                                                node = node2;
                                            } else {
                                                if (mutableVector4 == null) {
                                                    mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (node != null) {
                                                    mutableVector4.add(node);
                                                    node = null;
                                                }
                                                mutableVector4.add(node2);
                                            }
                                        }
                                    }
                                    if (r13 == 1) {
                                    }
                                }
                            }
                            node = DelegatableNodeKt.access$pop(mutableVector4);
                        }
                        if (focusPropertiesModifierNode.getNode().isAttached) {
                            MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16]);
                            Modifier.Node node3 = focusPropertiesModifierNode.getNode().child;
                            if (node3 == null) {
                                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector5, focusPropertiesModifierNode.getNode());
                            } else {
                                mutableVector5.add(node3);
                            }
                            while (mutableVector5.isNotEmpty()) {
                                Modifier.Node node4 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.size - 1);
                                if ((node4.aggregateChildKindSet & 1024) == 0) {
                                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector5, node4);
                                } else {
                                    while (true) {
                                        if (node4 == null) {
                                            break;
                                        }
                                        if ((node4.kindSet & 1024) != 0) {
                                            MutableVector mutableVector6 = null;
                                            while (node4 != null) {
                                                if (node4 instanceof FocusTargetNode) {
                                                    linkedHashSet.add((FocusTargetNode) node4);
                                                } else {
                                                    if ((node4.kindSet & 1024) != 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (z3 && (node4 instanceof DelegatingNode)) {
                                                        int r12 = 0;
                                                        for (Modifier.Node node5 = ((DelegatingNode) node4).delegate; node5 != null; node5 = node5.child) {
                                                            if ((node5.kindSet & 1024) != 0) {
                                                                z4 = true;
                                                            } else {
                                                                z4 = false;
                                                            }
                                                            if (z4) {
                                                                r12++;
                                                                if (r12 == 1) {
                                                                    node4 = node5;
                                                                } else {
                                                                    if (mutableVector6 == null) {
                                                                        mutableVector6 = new MutableVector(new Modifier.Node[16]);
                                                                    }
                                                                    if (node4 != null) {
                                                                        mutableVector6.add(node4);
                                                                        node4 = null;
                                                                    }
                                                                    mutableVector6.add(node5);
                                                                }
                                                            }
                                                        }
                                                        if (r12 == 1) {
                                                        }
                                                    }
                                                }
                                                node4 = DelegatableNodeKt.access$pop(mutableVector6);
                                            }
                                        } else {
                                            node4 = node4.child;
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                    }
                } else {
                    LinkedHashSet linkedHashSet2 = focusInvalidationManager.focusPropertiesNodes;
                    linkedHashSet2.clear();
                    LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                    LinkedHashSet<FocusEventModifierNode> linkedHashSet4 = focusInvalidationManager.focusEventNodes;
                    for (FocusEventModifierNode focusEventModifierNode : linkedHashSet4) {
                        if (!focusEventModifierNode.getNode().isAttached) {
                            focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                            c = c2;
                            r0 = r8;
                        } else {
                            Modifier.Node node6 = focusEventModifierNode.getNode();
                            int r15 = r8;
                            FocusTargetNode focusTargetNode = null;
                            int r14 = 0;
                            MutableVector mutableVector7 = null;
                            while (node6 != null) {
                                if (node6 instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node6;
                                    if (focusTargetNode != null) {
                                        r14 = r8;
                                    }
                                    if (linkedHashSet.contains(focusTargetNode2)) {
                                        linkedHashSet3.add(focusTargetNode2);
                                        r15 = 0;
                                    }
                                    focusTargetNode = focusTargetNode2;
                                } else {
                                    if ((node6.kindSet & 1024) != 0) {
                                        r6 = r8;
                                    } else {
                                        r6 = 0;
                                    }
                                    if (r6 != 0 && (node6 instanceof DelegatingNode)) {
                                        Modifier.Node node7 = ((DelegatingNode) node6).delegate;
                                        int r7 = 0;
                                        while (node7 != null) {
                                            if ((node7.kindSet & 1024) != 0) {
                                                r5 = r8;
                                            } else {
                                                r5 = 0;
                                            }
                                            if (r5 != 0) {
                                                r7++;
                                                if (r7 == r8) {
                                                    node6 = node7;
                                                } else {
                                                    if (mutableVector7 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    } else {
                                                        mutableVector3 = mutableVector7;
                                                    }
                                                    if (node6 != null) {
                                                        mutableVector3.add(node6);
                                                        node6 = null;
                                                    }
                                                    mutableVector3.add(node7);
                                                    mutableVector7 = mutableVector3;
                                                }
                                            }
                                            node7 = node7.child;
                                            r8 = 1;
                                        }
                                        if (r7 == r8) {
                                            r8 = 1;
                                        }
                                    }
                                }
                                node6 = DelegatableNodeKt.access$pop(mutableVector7);
                                r8 = 1;
                            }
                            if (focusEventModifierNode.getNode().isAttached) {
                                MutableVector mutableVector8 = new MutableVector(new Modifier.Node[16]);
                                Modifier.Node node8 = focusEventModifierNode.getNode().child;
                                if (node8 == null) {
                                    DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector8, focusEventModifierNode.getNode());
                                } else {
                                    mutableVector8.add(node8);
                                }
                                while (mutableVector8.isNotEmpty()) {
                                    Modifier.Node node9 = (Modifier.Node) mutableVector8.removeAt(mutableVector8.size - 1);
                                    if ((node9.aggregateChildKindSet & 1024) == 0) {
                                        DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector8, node9);
                                    } else {
                                        while (true) {
                                            if (node9 == null) {
                                                break;
                                            }
                                            if ((node9.kindSet & 1024) != 0) {
                                                MutableVector mutableVector9 = null;
                                                while (node9 != null) {
                                                    if (node9 instanceof FocusTargetNode) {
                                                        FocusTargetNode focusTargetNode3 = (FocusTargetNode) node9;
                                                        if (focusTargetNode != null) {
                                                            r14 = 1;
                                                        }
                                                        if (linkedHashSet.contains(focusTargetNode3)) {
                                                            linkedHashSet3.add(focusTargetNode3);
                                                            r15 = 0;
                                                        }
                                                        mutableVector = mutableVector8;
                                                        focusTargetNode = focusTargetNode3;
                                                    } else {
                                                        if ((node9.kindSet & 1024) != 0) {
                                                            z = true;
                                                        } else {
                                                            z = false;
                                                        }
                                                        if (z && (node9 instanceof DelegatingNode)) {
                                                            Modifier.Node node10 = ((DelegatingNode) node9).delegate;
                                                            int r82 = 0;
                                                            while (node10 != null) {
                                                                if ((node10.kindSet & 1024) != 0) {
                                                                    z2 = true;
                                                                } else {
                                                                    z2 = false;
                                                                }
                                                                if (z2) {
                                                                    r82++;
                                                                    if (r82 == 1) {
                                                                        mutableVector2 = mutableVector8;
                                                                        node9 = node10;
                                                                    } else {
                                                                        if (mutableVector9 == null) {
                                                                            mutableVector2 = mutableVector8;
                                                                            mutableVector9 = new MutableVector(new Modifier.Node[16]);
                                                                        } else {
                                                                            mutableVector2 = mutableVector8;
                                                                        }
                                                                        if (node9 != null) {
                                                                            mutableVector9.add(node9);
                                                                            node9 = null;
                                                                        }
                                                                        mutableVector9.add(node10);
                                                                        node10 = node10.child;
                                                                        mutableVector8 = mutableVector2;
                                                                    }
                                                                } else {
                                                                    mutableVector2 = mutableVector8;
                                                                }
                                                                node10 = node10.child;
                                                                mutableVector8 = mutableVector2;
                                                            }
                                                            mutableVector = mutableVector8;
                                                            if (r82 == 1) {
                                                                mutableVector8 = mutableVector;
                                                            }
                                                            node9 = DelegatableNodeKt.access$pop(mutableVector9);
                                                            mutableVector8 = mutableVector;
                                                        } else {
                                                            mutableVector = mutableVector8;
                                                        }
                                                    }
                                                    node9 = DelegatableNodeKt.access$pop(mutableVector9);
                                                    mutableVector8 = mutableVector;
                                                }
                                            } else {
                                                node9 = node9.child;
                                                mutableVector8 = mutableVector8;
                                            }
                                        }
                                    }
                                    mutableVector8 = mutableVector8;
                                }
                                r0 = 1;
                                c = 16;
                                if (r15 != 0) {
                                    if (r14 != 0) {
                                        focusStateImpl = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                    } else if (focusTargetNode == null || (focusStateImpl = focusTargetNode.focusState) == null) {
                                        focusStateImpl = FocusStateImpl.Inactive;
                                    }
                                    focusEventModifierNode.onFocusEvent(focusStateImpl);
                                }
                            } else {
                                throw new IllegalStateException("visitChildren called on an unattached node".toString());
                            }
                        }
                        r8 = r0;
                        c2 = c;
                    }
                    linkedHashSet4.clear();
                    for (FocusTargetNode focusTargetNode4 : linkedHashSet) {
                        if (focusTargetNode4.isAttached) {
                            FocusStateImpl focusStateImpl2 = focusTargetNode4.focusState;
                            focusTargetNode4.invalidateFocus$ui_release();
                            if (focusStateImpl2 != focusTargetNode4.focusState || linkedHashSet3.contains(focusTargetNode4)) {
                                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                            }
                        }
                    }
                    linkedHashSet.clear();
                    linkedHashSet3.clear();
                    if (linkedHashSet2.isEmpty()) {
                        if (linkedHashSet4.isEmpty()) {
                            if (linkedHashSet.isEmpty()) {
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                        }
                        throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                    }
                    throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                }
            }
        }
    };

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.ui.focus.FocusInvalidationManager$invalidateNodes$1] */
    public FocusInvalidationManager(AndroidComposeView$focusOwner$1 androidComposeView$focusOwner$1) {
        this.onRequestApplyChangesListener = androidComposeView$focusOwner$1;
    }

    public final void scheduleInvalidation(LinkedHashSet linkedHashSet, Object obj) {
        if (linkedHashSet.add(obj)) {
            if (this.focusPropertiesNodes.size() + this.focusEventNodes.size() + this.focusTargetNodes.size() == 1) {
                this.onRequestApplyChangesListener.invoke(this.invalidateNodes);
            }
        }
    }
}
