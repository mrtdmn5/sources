package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeChain.kt */
/* loaded from: classes.dex */
public final class NodeChain {
    public MutableVector<Modifier.Element> buffer;
    public Differ cachedDiffer;
    public MutableVector<Modifier.Element> current;
    public Modifier.Node head;
    public final InnerNodeCoordinator innerCoordinator;
    public final LayoutNode layoutNode;
    public NodeCoordinator outerCoordinator;
    public final TailModifierNode tail;

    /* compiled from: NodeChain.kt */
    /* loaded from: classes.dex */
    public final class Differ {
        public MutableVector<Modifier.Element> after;
        public MutableVector<Modifier.Element> before;
        public Modifier.Node node;
        public int offset;
        public boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node, int r3, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
            this.node = node;
            this.offset = r3;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z;
        }

        public final boolean areItemsTheSame(int r3, int r4) {
            MutableVector<Modifier.Element> mutableVector = this.before;
            int r1 = this.offset;
            if (NodeChainKt.actionForModifiers(mutableVector.content[r3 + r1], this.after.content[r1 + r4]) != 0) {
                return true;
            }
            return false;
        }

        public final void insert(int r5) {
            int r0 = this.offset + r5;
            Modifier.Node node = this.node;
            Modifier.Element element = this.after.content[r0];
            NodeChain nodeChain = NodeChain.this;
            nodeChain.getClass();
            Modifier.Node createAndInsertNodeAsChild = NodeChain.createAndInsertNodeAsChild(element, node);
            this.node = createAndInsertNodeAsChild;
            if (this.shouldAttachOnInsert) {
                Modifier.Node node2 = createAndInsertNodeAsChild.child;
                Intrinsics.checkNotNull(node2);
                NodeCoordinator nodeCoordinator = node2.coordinator;
                Intrinsics.checkNotNull(nodeCoordinator);
                LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (asLayoutModifierNode != null) {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(nodeChain.layoutNode, asLayoutModifierNode);
                    this.node.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                    NodeChain.access$propagateCoordinator(nodeChain, this.node, layoutModifierNodeCoordinator);
                    layoutModifierNodeCoordinator.wrappedBy = nodeCoordinator.wrappedBy;
                    layoutModifierNodeCoordinator.wrapped = nodeCoordinator;
                    nodeCoordinator.wrappedBy = layoutModifierNodeCoordinator;
                } else {
                    this.node.updateCoordinator$ui_release(nodeCoordinator);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            createAndInsertNodeAsChild.insertedNodeAwaitingAttachForInvalidation = true;
        }

        public final void remove() {
            boolean z;
            Modifier.Node node = this.node.child;
            Intrinsics.checkNotNull(node);
            NodeChain nodeChain = NodeChain.this;
            nodeChain.getClass();
            if ((node.kindSet & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                NodeCoordinator nodeCoordinator = node.coordinator;
                Intrinsics.checkNotNull(nodeCoordinator);
                NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
                NodeCoordinator nodeCoordinator3 = nodeCoordinator.wrapped;
                Intrinsics.checkNotNull(nodeCoordinator3);
                if (nodeCoordinator2 != null) {
                    nodeCoordinator2.wrapped = nodeCoordinator3;
                }
                nodeCoordinator3.wrappedBy = nodeCoordinator2;
                NodeChain.access$propagateCoordinator(nodeChain, this.node, nodeCoordinator3);
            }
            this.node = NodeChain.detachAndRemoveNode(node);
        }

        public final void same(int r3, int r4) {
            Modifier.Node node = this.node.child;
            Intrinsics.checkNotNull(node);
            this.node = node;
            MutableVector<Modifier.Element> mutableVector = this.before;
            int r1 = this.offset;
            Modifier.Element element = mutableVector.content[r3 + r1];
            Modifier.Element element2 = this.after.content[r1 + r4];
            boolean areEqual = Intrinsics.areEqual(element, element2);
            NodeChain nodeChain = NodeChain.this;
            if (!areEqual) {
                Modifier.Node node2 = this.node;
                nodeChain.getClass();
                NodeChain.updateNode(element, element2, node2);
                return;
            }
            nodeChain.getClass();
        }
    }

    public NodeChain(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        TailModifierNode tailModifierNode = innerNodeCoordinator.tail;
        this.tail = tailModifierNode;
        this.head = tailModifierNode;
    }

    public static final void access$propagateCoordinator(NodeChain nodeChain, Modifier.Node node, NodeCoordinator nodeCoordinator) {
        InnerNodeCoordinator innerNodeCoordinator;
        boolean z;
        nodeChain.getClass();
        for (Modifier.Node node2 = node.parent; node2 != null; node2 = node2.parent) {
            if (node2 == NodeChainKt.SentinelHead) {
                LayoutNode parent$ui_release = nodeChain.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    innerNodeCoordinator = parent$ui_release.nodes.innerCoordinator;
                } else {
                    innerNodeCoordinator = null;
                }
                nodeCoordinator.wrappedBy = innerNodeCoordinator;
                nodeChain.outerCoordinator = nodeCoordinator;
                return;
            }
            if ((node2.kindSet & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                node2.updateCoordinator$ui_release(nodeCoordinator);
            } else {
                return;
            }
        }
    }

    public static Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node node) {
        Modifier.Node backwardsCompatNode;
        if (element instanceof ModifierNodeElement) {
            backwardsCompatNode = ((ModifierNodeElement) element).create();
            backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(backwardsCompatNode);
        } else {
            backwardsCompatNode = new BackwardsCompatNode(element);
        }
        if (!backwardsCompatNode.isAttached) {
            backwardsCompatNode.insertedNodeAwaitingAttachForInvalidation = true;
            Modifier.Node node2 = node.child;
            if (node2 != null) {
                node2.parent = backwardsCompatNode;
                backwardsCompatNode.child = node2;
            }
            node.child = backwardsCompatNode;
            backwardsCompatNode.parent = node;
            return backwardsCompatNode;
        }
        throw new IllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ".toString());
    }

    public static Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        boolean z = node.isAttached;
        if (z) {
            if (z) {
                NodeKindKt.autoInvalidateNodeIncludingDelegates(node, -1, 2);
                node.runDetachLifecycle$ui_release();
                node.markAsDetached$ui_release();
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        Modifier.Node node2 = node.child;
        Modifier.Node node3 = node.parent;
        if (node2 != null) {
            node2.parent = node3;
            node.child = null;
        }
        if (node3 != null) {
            node3.child = node2;
            node.parent = null;
        }
        Intrinsics.checkNotNull(node3);
        return node3;
    }

    public static void updateNode(Modifier.Element element, Modifier.Element value, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (value instanceof ModifierNodeElement)) {
            NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            Intrinsics.checkNotNull(node, "null cannot be cast to non-null type T of androidx.compose.ui.node.NodeChainKt.updateUnsafe");
            ((ModifierNodeElement) value).update(node);
            if (node.isAttached) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.updatedNodeAwaitingAttachForInvalidation = true;
                return;
            }
        }
        if (node instanceof BackwardsCompatNode) {
            BackwardsCompatNode backwardsCompatNode = (BackwardsCompatNode) node;
            backwardsCompatNode.getClass();
            Intrinsics.checkNotNullParameter(value, "value");
            if (backwardsCompatNode.isAttached) {
                backwardsCompatNode.unInitializeModifier();
            }
            backwardsCompatNode.element = value;
            backwardsCompatNode.kindSet = NodeKindKt.calculateNodeKindSetFrom(value);
            if (backwardsCompatNode.isAttached) {
                backwardsCompatNode.initializeModifier(false);
            }
            if (node.isAttached) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
                return;
            } else {
                node.updatedNodeAwaitingAttachForInvalidation = true;
                return;
            }
        }
        throw new IllegalStateException("Unknown Modifier.Node type".toString());
    }

    /* renamed from: has-H91voCI$ui_release */
    public final boolean m460hasH91voCI$ui_release(int r2) {
        if ((r2 & this.head.aggregateChildKindSet) != 0) {
            return true;
        }
        return false;
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node node = this.head; node != null; node = node.child) {
            node.runAttachLifecycle$ui_release();
            if (node.insertedNodeAwaitingAttachForInvalidation) {
                NodeKindKt.autoInvalidateInsertedNode(node);
            }
            if (node.updatedNodeAwaitingAttachForInvalidation) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            }
            node.insertedNodeAwaitingAttachForInvalidation = false;
            node.updatedNodeAwaitingAttachForInvalidation = false;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v1 ??, still in use, count: 1, list:
          (r11v1 ?? I:androidx.compose.ui.node.NodeChain$Differ) from 0x001e: IPUT 
          (r11v1 ?? I:androidx.compose.ui.node.NodeChain$Differ)
          (r30v0 'this' ?? I:androidx.compose.ui.node.NodeChain A[IMMUTABLE_TYPE, THIS])
         (LINE:31) androidx.compose.ui.node.NodeChain.cachedDiffer androidx.compose.ui.node.NodeChain$Differ
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public final void structuralUpdate(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v1 ??, still in use, count: 1, list:
          (r11v1 ?? I:androidx.compose.ui.node.NodeChain$Differ) from 0x001e: IPUT 
          (r11v1 ?? I:androidx.compose.ui.node.NodeChain$Differ)
          (r30v0 'this' ?? I:androidx.compose.ui.node.NodeChain A[IMMUTABLE_TYPE, THIS])
         (LINE:31) androidx.compose.ui.node.NodeChain.cachedDiffer androidx.compose.ui.node.NodeChain$Differ
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r31v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:237)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        */

    public final void syncCoordinators() {
        LayoutNode layoutNode;
        InnerNodeCoordinator innerNodeCoordinator;
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        Modifier.Node node = this.tail.parent;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        Modifier.Node node2 = node;
        while (true) {
            layoutNode = this.layoutNode;
            if (node2 == null) {
                break;
            }
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(node2);
            if (asLayoutModifierNode != null) {
                NodeCoordinator nodeCoordinator2 = node2.coordinator;
                if (nodeCoordinator2 != null) {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator2 = (LayoutModifierNodeCoordinator) nodeCoordinator2;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator2.layoutModifierNode;
                    layoutModifierNodeCoordinator2.layoutModifierNode = asLayoutModifierNode;
                    layoutModifierNodeCoordinator = layoutModifierNodeCoordinator2;
                    if (layoutModifierNode != node2) {
                        OwnedLayer ownedLayer = layoutModifierNodeCoordinator2.layer;
                        layoutModifierNodeCoordinator = layoutModifierNodeCoordinator2;
                        if (ownedLayer != null) {
                            ownedLayer.invalidate();
                            layoutModifierNodeCoordinator = layoutModifierNodeCoordinator2;
                        }
                    }
                } else {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator3 = new LayoutModifierNodeCoordinator(layoutNode, asLayoutModifierNode);
                    node2.updateCoordinator$ui_release(layoutModifierNodeCoordinator3);
                    layoutModifierNodeCoordinator = layoutModifierNodeCoordinator3;
                }
                nodeCoordinator.wrappedBy = layoutModifierNodeCoordinator;
                layoutModifierNodeCoordinator.wrapped = nodeCoordinator;
                nodeCoordinator = layoutModifierNodeCoordinator;
            } else {
                node2.updateCoordinator$ui_release(nodeCoordinator);
            }
            node2 = node2.parent;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            innerNodeCoordinator = parent$ui_release.nodes.innerCoordinator;
        } else {
            innerNodeCoordinator = null;
        }
        nodeCoordinator.wrappedBy = innerNodeCoordinator;
        this.outerCoordinator = nodeCoordinator;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Modifier.Node node = this.head;
        TailModifierNode tailModifierNode = this.tail;
        if (node != tailModifierNode) {
            while (true) {
                if (node == null || node == tailModifierNode) {
                    break;
                }
                sb.append(String.valueOf(node));
                if (node.child == tailModifierNode) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                node = node.child;
            }
        } else {
            sb.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
