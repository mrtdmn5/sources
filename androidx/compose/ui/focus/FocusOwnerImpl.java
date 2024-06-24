package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.platform.AndroidComposeView$focusOwner$1;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: FocusOwnerImpl.kt */
/* loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public final FocusInvalidationManager focusInvalidationManager;
    public LayoutDirection layoutDirection;
    public final FocusTargetNode rootFocusNode = new FocusTargetNode();
    public final FocusOwnerImpl$modifier$1 modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        public FocusOwnerImpl$modifier$1() {
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final FocusTargetNode create() {
            return FocusOwnerImpl.this.rootFocusNode;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return false;
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final int hashCode() {
            return FocusOwnerImpl.this.rootFocusNode.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final void update(FocusTargetNode focusTargetNode) {
            FocusTargetNode node = focusTargetNode;
            Intrinsics.checkNotNullParameter(node, "node");
        }
    };

    /* compiled from: FocusOwnerImpl.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] r0 = new int[CustomDestinationResult.values().length];
            try {
                r0[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
            int[] r02 = new int[FocusStateImpl.values().length];
            try {
                r02[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r02[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r02[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r02[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = r02;
        }
    }

    public FocusOwnerImpl(AndroidComposeView$focusOwner$1 androidComposeView$focusOwner$1) {
        this.focusInvalidationManager = new FocusInvalidationManager(androidComposeView$focusOwner$1);
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public final void clearFocus(boolean z) {
        clearFocus(z, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r14v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v27, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v28 */
    /* JADX WARN: Type inference failed for: r14v29 */
    /* JADX WARN: Type inference failed for: r14v30 */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v51 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public final boolean mo239dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int size;
        NodeChain nodeChain;
        boolean z5;
        boolean z6;
        DelegatingNode delegatingNode;
        NodeChain nodeChain2;
        boolean z7;
        boolean z8;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node node = findActiveFocusNode.node;
            if (node.isAttached) {
                Modifier.Node node2 = node.parent;
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
                loop0: while (true) {
                    if (requireLayoutNode != null) {
                        if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 131072) != 0) {
                            while (node2 != null) {
                                if ((node2.kindSet & 131072) != 0) {
                                    ?? r8 = 0;
                                    delegatingNode = node2;
                                    while (delegatingNode != 0) {
                                        if (delegatingNode instanceof SoftKeyboardInterceptionModifierNode) {
                                            break loop0;
                                        }
                                        if ((delegatingNode.kindSet & 131072) != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        if (z7 && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node3 = delegatingNode.delegate;
                                            int r10 = 0;
                                            delegatingNode = delegatingNode;
                                            r8 = r8;
                                            while (node3 != null) {
                                                if ((node3.kindSet & 131072) != 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    r10++;
                                                    r8 = r8;
                                                    if (r10 == 1) {
                                                        delegatingNode = node3;
                                                    } else {
                                                        if (r8 == 0) {
                                                            r8 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r8.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r8.add(node3);
                                                    }
                                                }
                                                node3 = node3.child;
                                                delegatingNode = delegatingNode;
                                                r8 = r8;
                                            }
                                            if (r10 == 1) {
                                            }
                                        }
                                        delegatingNode = DelegatableNodeKt.access$pop(r8);
                                    }
                                }
                                node2 = node2.parent;
                            }
                        }
                        requireLayoutNode = requireLayoutNode.getParent$ui_release();
                        if (requireLayoutNode != null && (nodeChain2 = requireLayoutNode.nodes) != null) {
                            node2 = nodeChain2.tail;
                        } else {
                            node2 = null;
                        }
                    } else {
                        delegatingNode = 0;
                        break;
                    }
                }
                softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) delegatingNode;
            } else {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            if (softKeyboardInterceptionModifierNode.getNode().isAttached) {
                Modifier.Node node4 = softKeyboardInterceptionModifierNode.getNode().parent;
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode);
                ArrayList arrayList = null;
                while (requireLayoutNode2 != null) {
                    if ((requireLayoutNode2.nodes.head.aggregateChildKindSet & 131072) != 0) {
                        while (node4 != null) {
                            if ((node4.kindSet & 131072) != 0) {
                                Modifier.Node node5 = node4;
                                MutableVector mutableVector = null;
                                while (node5 != null) {
                                    if (node5 instanceof SoftKeyboardInterceptionModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(node5);
                                    } else {
                                        if ((node5.kindSet & 131072) != 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        if (z5 && (node5 instanceof DelegatingNode)) {
                                            int r11 = 0;
                                            for (Modifier.Node node6 = ((DelegatingNode) node5).delegate; node6 != null; node6 = node6.child) {
                                                if ((node6.kindSet & 131072) != 0) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (z6) {
                                                    r11++;
                                                    if (r11 == 1) {
                                                        node5 = node6;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (node5 != null) {
                                                            mutableVector.add(node5);
                                                            node5 = null;
                                                        }
                                                        mutableVector.add(node6);
                                                    }
                                                }
                                            }
                                            if (r11 == 1) {
                                            }
                                        }
                                    }
                                    node5 = DelegatableNodeKt.access$pop(mutableVector);
                                }
                            }
                            node4 = node4.parent;
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    if (requireLayoutNode2 != null && (nodeChain = requireLayoutNode2.nodes) != null) {
                        node4 = nodeChain.tail;
                    } else {
                        node4 = null;
                    }
                }
                if (arrayList != null && arrayList.size() - 1 >= 0) {
                    while (true) {
                        int r0 = size - 1;
                        if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).m402onPreInterceptKeyBeforeSoftKeyboardZmokQxo()) {
                            return true;
                        }
                        if (r0 < 0) {
                            break;
                        }
                        size = r0;
                    }
                }
                DelegatingNode node7 = softKeyboardInterceptionModifierNode.getNode();
                ?? r02 = 0;
                while (node7 != 0) {
                    if (node7 instanceof SoftKeyboardInterceptionModifierNode) {
                        if (((SoftKeyboardInterceptionModifierNode) node7).m402onPreInterceptKeyBeforeSoftKeyboardZmokQxo()) {
                            return true;
                        }
                    } else {
                        if ((node7.kindSet & 131072) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3 && (node7 instanceof DelegatingNode)) {
                            Modifier.Node node8 = node7.delegate;
                            int r9 = 0;
                            r02 = r02;
                            node7 = node7;
                            while (node8 != null) {
                                if ((node8.kindSet & 131072) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    r9++;
                                    r02 = r02;
                                    if (r9 == 1) {
                                        node7 = node8;
                                    } else {
                                        if (r02 == 0) {
                                            r02 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (node7 != 0) {
                                            r02.add(node7);
                                            node7 = 0;
                                        }
                                        r02.add(node8);
                                    }
                                }
                                node8 = node8.child;
                                r02 = r02;
                                node7 = node7;
                            }
                            if (r9 == 1) {
                            }
                        }
                    }
                    node7 = DelegatableNodeKt.access$pop(r02);
                }
                DelegatingNode node9 = softKeyboardInterceptionModifierNode.getNode();
                ?? r03 = 0;
                while (node9 != 0) {
                    if (node9 instanceof SoftKeyboardInterceptionModifierNode) {
                        if (((SoftKeyboardInterceptionModifierNode) node9).m401onInterceptKeyBeforeSoftKeyboardZmokQxo()) {
                            return true;
                        }
                    } else {
                        if ((node9.kindSet & 131072) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (node9 instanceof DelegatingNode)) {
                            Modifier.Node node10 = node9.delegate;
                            int r82 = 0;
                            r03 = r03;
                            node9 = node9;
                            while (node10 != null) {
                                if ((node10.kindSet & 131072) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    r82++;
                                    r03 = r03;
                                    if (r82 == 1) {
                                        node9 = node10;
                                    } else {
                                        if (r03 == 0) {
                                            r03 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (node9 != 0) {
                                            r03.add(node9);
                                            node9 = 0;
                                        }
                                        r03.add(node10);
                                    }
                                }
                                node10 = node10.child;
                                r03 = r03;
                                node9 = node9;
                            }
                            if (r82 == 1) {
                            }
                        }
                    }
                    node9 = DelegatableNodeKt.access$pop(r03);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int r04 = 0; r04 < size2; r04++) {
                        if (((SoftKeyboardInterceptionModifierNode) arrayList.get(r04)).m401onInterceptKeyBeforeSoftKeyboardZmokQxo()) {
                            return true;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v14, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v29, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v54 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v25, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    @Override // androidx.compose.ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-ZmokQxo */
    public final boolean mo240dispatchKeyEventZmokQxo(KeyEvent keyEvent) {
        Modifier.Node node;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int size;
        NodeChain nodeChain;
        boolean z5;
        boolean z6;
        DelegatingNode delegatingNode;
        NodeChain nodeChain2;
        boolean z7;
        boolean z8;
        boolean z9;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node node2 = findActiveFocusNode.node;
            if (node2.isAttached) {
                if ((node2.aggregateChildKindSet & 9216) != 0) {
                    node = null;
                    for (Modifier.Node node3 = node2.child; node3 != null; node3 = node3.child) {
                        int r6 = node3.kindSet;
                        if ((r6 & 9216) != 0) {
                            if ((r6 & 1024) != 0) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            if (z9) {
                                break;
                            }
                            node = node3;
                        }
                    }
                } else {
                    node = null;
                }
                if (node == null) {
                    Modifier.Node node4 = findActiveFocusNode.node;
                    if (node4.isAttached) {
                        Modifier.Node node5 = node4.parent;
                        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
                        loop1: while (true) {
                            if (requireLayoutNode != null) {
                                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                    while (node5 != null) {
                                        if ((node5.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                            delegatingNode = node5;
                                            ?? r8 = 0;
                                            while (delegatingNode != 0) {
                                                if (delegatingNode instanceof KeyInputModifierNode) {
                                                    break loop1;
                                                }
                                                if ((delegatingNode.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                                    z7 = true;
                                                } else {
                                                    z7 = false;
                                                }
                                                if (z7 && (delegatingNode instanceof DelegatingNode)) {
                                                    Modifier.Node node6 = delegatingNode.delegate;
                                                    int r10 = 0;
                                                    delegatingNode = delegatingNode;
                                                    r8 = r8;
                                                    while (node6 != null) {
                                                        if ((node6.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                                            z8 = true;
                                                        } else {
                                                            z8 = false;
                                                        }
                                                        if (z8) {
                                                            r10++;
                                                            r8 = r8;
                                                            if (r10 == 1) {
                                                                delegatingNode = node6;
                                                            } else {
                                                                if (r8 == 0) {
                                                                    r8 = new MutableVector(new Modifier.Node[16]);
                                                                }
                                                                if (delegatingNode != 0) {
                                                                    r8.add(delegatingNode);
                                                                    delegatingNode = 0;
                                                                }
                                                                r8.add(node6);
                                                            }
                                                        }
                                                        node6 = node6.child;
                                                        delegatingNode = delegatingNode;
                                                        r8 = r8;
                                                    }
                                                    if (r10 == 1) {
                                                    }
                                                }
                                                delegatingNode = DelegatableNodeKt.access$pop(r8);
                                            }
                                        }
                                        node5 = node5.parent;
                                    }
                                }
                                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                                if (requireLayoutNode != null && (nodeChain2 = requireLayoutNode.nodes) != null) {
                                    node5 = nodeChain2.tail;
                                } else {
                                    node5 = null;
                                }
                            } else {
                                delegatingNode = 0;
                                break;
                            }
                        }
                        KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) delegatingNode;
                        if (keyInputModifierNode != null) {
                            node = keyInputModifierNode.getNode();
                        } else {
                            node = null;
                        }
                    } else {
                        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                    }
                }
                if (node != null) {
                    Modifier.Node node7 = node.node;
                    if (node7.isAttached) {
                        Modifier.Node node8 = node7.parent;
                        LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(node);
                        ArrayList arrayList = null;
                        while (requireLayoutNode2 != null) {
                            if ((requireLayoutNode2.nodes.head.aggregateChildKindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                while (node8 != null) {
                                    if ((node8.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                        Modifier.Node node9 = node8;
                                        MutableVector mutableVector = null;
                                        while (node9 != null) {
                                            if (node9 instanceof KeyInputModifierNode) {
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                }
                                                arrayList.add(node9);
                                            } else {
                                                if ((node9.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (z5 && (node9 instanceof DelegatingNode)) {
                                                    int r11 = 0;
                                                    for (Modifier.Node node10 = ((DelegatingNode) node9).delegate; node10 != null; node10 = node10.child) {
                                                        if ((node10.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                                            z6 = true;
                                                        } else {
                                                            z6 = false;
                                                        }
                                                        if (z6) {
                                                            r11++;
                                                            if (r11 == 1) {
                                                                node9 = node10;
                                                            } else {
                                                                if (mutableVector == null) {
                                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                                }
                                                                if (node9 != null) {
                                                                    mutableVector.add(node9);
                                                                    node9 = null;
                                                                }
                                                                mutableVector.add(node10);
                                                            }
                                                        }
                                                    }
                                                    if (r11 == 1) {
                                                    }
                                                }
                                            }
                                            node9 = DelegatableNodeKt.access$pop(mutableVector);
                                        }
                                    }
                                    node8 = node8.parent;
                                }
                            }
                            requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                            if (requireLayoutNode2 != null && (nodeChain = requireLayoutNode2.nodes) != null) {
                                node8 = nodeChain.tail;
                            } else {
                                node8 = null;
                            }
                        }
                        if (arrayList != null && arrayList.size() - 1 >= 0) {
                            while (true) {
                                int r1 = size - 1;
                                if (((KeyInputModifierNode) arrayList.get(size)).mo14onPreKeyEventZmokQxo(keyEvent)) {
                                    return true;
                                }
                                if (r1 < 0) {
                                    break;
                                }
                                size = r1;
                            }
                        }
                        DelegatingNode delegatingNode2 = node.node;
                        ?? r12 = 0;
                        while (delegatingNode2 != 0) {
                            if (delegatingNode2 instanceof KeyInputModifierNode) {
                                if (((KeyInputModifierNode) delegatingNode2).mo14onPreKeyEventZmokQxo(keyEvent)) {
                                    return true;
                                }
                            } else {
                                if ((delegatingNode2.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3 && (delegatingNode2 instanceof DelegatingNode)) {
                                    Modifier.Node node11 = delegatingNode2.delegate;
                                    int r9 = 0;
                                    delegatingNode2 = delegatingNode2;
                                    r12 = r12;
                                    while (node11 != null) {
                                        if ((node11.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                            z4 = true;
                                        } else {
                                            z4 = false;
                                        }
                                        if (z4) {
                                            r9++;
                                            r12 = r12;
                                            if (r9 == 1) {
                                                delegatingNode2 = node11;
                                            } else {
                                                if (r12 == 0) {
                                                    r12 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (delegatingNode2 != 0) {
                                                    r12.add(delegatingNode2);
                                                    delegatingNode2 = 0;
                                                }
                                                r12.add(node11);
                                            }
                                        }
                                        node11 = node11.child;
                                        delegatingNode2 = delegatingNode2;
                                        r12 = r12;
                                    }
                                    if (r9 == 1) {
                                    }
                                }
                            }
                            delegatingNode2 = DelegatableNodeKt.access$pop(r12);
                        }
                        DelegatingNode delegatingNode3 = node.node;
                        ?? r13 = 0;
                        while (delegatingNode3 != 0) {
                            if (delegatingNode3 instanceof KeyInputModifierNode) {
                                if (((KeyInputModifierNode) delegatingNode3).mo12onKeyEventZmokQxo(keyEvent)) {
                                    return true;
                                }
                            } else {
                                if ((delegatingNode3.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && (delegatingNode3 instanceof DelegatingNode)) {
                                    Modifier.Node node12 = delegatingNode3.delegate;
                                    int r82 = 0;
                                    delegatingNode3 = delegatingNode3;
                                    r13 = r13;
                                    while (node12 != null) {
                                        if ((node12.kindSet & DfuBaseService.ERROR_REMOTE_MASK) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            r82++;
                                            r13 = r13;
                                            if (r82 == 1) {
                                                delegatingNode3 = node12;
                                            } else {
                                                if (r13 == 0) {
                                                    r13 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (delegatingNode3 != 0) {
                                                    r13.add(delegatingNode3);
                                                    delegatingNode3 = 0;
                                                }
                                                r13.add(node12);
                                            }
                                        }
                                        node12 = node12.child;
                                        delegatingNode3 = delegatingNode3;
                                        r13 = r13;
                                    }
                                    if (r82 == 1) {
                                    }
                                }
                            }
                            delegatingNode3 = DelegatableNodeKt.access$pop(r13);
                        }
                        if (arrayList != null) {
                            int size2 = arrayList.size();
                            for (int r14 = 0; r14 < size2; r14++) {
                                if (((KeyInputModifierNode) arrayList.get(r14)).mo12onKeyEventZmokQxo(keyEvent)) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
                    }
                }
                return false;
            }
            throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
        }
        throw new IllegalStateException("Event can't be processed because we do not have an active focus target.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v28, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v35 */
    /* JADX WARN: Type inference failed for: r8v36 */
    /* JADX WARN: Type inference failed for: r8v37, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    @Override // androidx.compose.ui.focus.FocusOwner
    public final boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent) {
        RotaryInputModifierNode rotaryInputModifierNode;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int size;
        NodeChain nodeChain;
        boolean z5;
        boolean z6;
        DelegatingNode delegatingNode;
        NodeChain nodeChain2;
        boolean z7;
        boolean z8;
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            Modifier.Node node = findActiveFocusNode.node;
            if (node.isAttached) {
                Modifier.Node node2 = node.parent;
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(findActiveFocusNode);
                loop0: while (true) {
                    if (requireLayoutNode != null) {
                        if ((requireLayoutNode.nodes.head.aggregateChildKindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                            while (node2 != null) {
                                if ((node2.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                    ?? r8 = 0;
                                    delegatingNode = node2;
                                    while (delegatingNode != 0) {
                                        if (delegatingNode instanceof RotaryInputModifierNode) {
                                            break loop0;
                                        }
                                        if ((delegatingNode.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                            z7 = true;
                                        } else {
                                            z7 = false;
                                        }
                                        if (z7 && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node3 = delegatingNode.delegate;
                                            int r10 = 0;
                                            delegatingNode = delegatingNode;
                                            r8 = r8;
                                            while (node3 != null) {
                                                if ((node3.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                                    z8 = true;
                                                } else {
                                                    z8 = false;
                                                }
                                                if (z8) {
                                                    r10++;
                                                    r8 = r8;
                                                    if (r10 == 1) {
                                                        delegatingNode = node3;
                                                    } else {
                                                        if (r8 == 0) {
                                                            r8 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r8.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r8.add(node3);
                                                    }
                                                }
                                                node3 = node3.child;
                                                delegatingNode = delegatingNode;
                                                r8 = r8;
                                            }
                                            if (r10 == 1) {
                                            }
                                        }
                                        delegatingNode = DelegatableNodeKt.access$pop(r8);
                                    }
                                }
                                node2 = node2.parent;
                            }
                        }
                        requireLayoutNode = requireLayoutNode.getParent$ui_release();
                        if (requireLayoutNode != null && (nodeChain2 = requireLayoutNode.nodes) != null) {
                            node2 = nodeChain2.tail;
                        } else {
                            node2 = null;
                        }
                    } else {
                        delegatingNode = 0;
                        break;
                    }
                }
                rotaryInputModifierNode = (RotaryInputModifierNode) delegatingNode;
            } else {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            if (rotaryInputModifierNode.getNode().isAttached) {
                Modifier.Node node4 = rotaryInputModifierNode.getNode().parent;
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode);
                ArrayList arrayList = null;
                while (requireLayoutNode2 != null) {
                    if ((requireLayoutNode2.nodes.head.aggregateChildKindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                        while (node4 != null) {
                            if ((node4.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                Modifier.Node node5 = node4;
                                MutableVector mutableVector = null;
                                while (node5 != null) {
                                    if (node5 instanceof RotaryInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(node5);
                                    } else {
                                        if ((node5.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                            z5 = true;
                                        } else {
                                            z5 = false;
                                        }
                                        if (z5 && (node5 instanceof DelegatingNode)) {
                                            int r11 = 0;
                                            for (Modifier.Node node6 = ((DelegatingNode) node5).delegate; node6 != null; node6 = node6.child) {
                                                if ((node6.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (z6) {
                                                    r11++;
                                                    if (r11 == 1) {
                                                        node5 = node6;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (node5 != null) {
                                                            mutableVector.add(node5);
                                                            node5 = null;
                                                        }
                                                        mutableVector.add(node6);
                                                    }
                                                }
                                            }
                                            if (r11 == 1) {
                                            }
                                        }
                                    }
                                    node5 = DelegatableNodeKt.access$pop(mutableVector);
                                }
                            }
                            node4 = node4.parent;
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    if (requireLayoutNode2 != null && (nodeChain = requireLayoutNode2.nodes) != null) {
                        node4 = nodeChain.tail;
                    } else {
                        node4 = null;
                    }
                }
                if (arrayList != null && arrayList.size() - 1 >= 0) {
                    while (true) {
                        int r1 = size - 1;
                        if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                            return true;
                        }
                        if (r1 < 0) {
                            break;
                        }
                        size = r1;
                    }
                }
                DelegatingNode node7 = rotaryInputModifierNode.getNode();
                ?? r12 = 0;
                while (node7 != 0) {
                    if (node7 instanceof RotaryInputModifierNode) {
                        if (((RotaryInputModifierNode) node7).onPreRotaryScrollEvent(rotaryScrollEvent)) {
                            return true;
                        }
                    } else {
                        if ((node7.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3 && (node7 instanceof DelegatingNode)) {
                            Modifier.Node node8 = node7.delegate;
                            int r9 = 0;
                            node7 = node7;
                            r12 = r12;
                            while (node8 != null) {
                                if ((node8.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    r9++;
                                    r12 = r12;
                                    if (r9 == 1) {
                                        node7 = node8;
                                    } else {
                                        if (r12 == 0) {
                                            r12 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (node7 != 0) {
                                            r12.add(node7);
                                            node7 = 0;
                                        }
                                        r12.add(node8);
                                    }
                                }
                                node8 = node8.child;
                                node7 = node7;
                                r12 = r12;
                            }
                            if (r9 == 1) {
                            }
                        }
                    }
                    node7 = DelegatableNodeKt.access$pop(r12);
                }
                DelegatingNode node9 = rotaryInputModifierNode.getNode();
                ?? r13 = 0;
                while (node9 != 0) {
                    if (node9 instanceof RotaryInputModifierNode) {
                        if (((RotaryInputModifierNode) node9).onRotaryScrollEvent(rotaryScrollEvent)) {
                            return true;
                        }
                    } else {
                        if ((node9.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (node9 instanceof DelegatingNode)) {
                            Modifier.Node node10 = node9.delegate;
                            int r82 = 0;
                            node9 = node9;
                            r13 = r13;
                            while (node10 != null) {
                                if ((node10.kindSet & DfuBaseService.ERROR_CONNECTION_MASK) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    r82++;
                                    r13 = r13;
                                    if (r82 == 1) {
                                        node9 = node10;
                                    } else {
                                        if (r13 == 0) {
                                            r13 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (node9 != 0) {
                                            r13.add(node9);
                                            node9 = 0;
                                        }
                                        r13.add(node10);
                                    }
                                }
                                node10 = node10.child;
                                node9 = node9;
                                r13 = r13;
                            }
                            if (r82 == 1) {
                            }
                        }
                    }
                    node9 = DelegatableNodeKt.access$pop(r13);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int r14 = 0; r14 < size2; r14++) {
                        if (((RotaryInputModifierNode) arrayList.get(r14)).onRotaryScrollEvent(rotaryScrollEvent)) {
                            return true;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("visitAncestors called on an unattached node".toString());
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final Rect getFocusRect() {
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            return FocusTraversalKt.focusRect(findActiveFocusNode);
        }
        return null;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final FocusOwnerImpl$modifier$1 getModifier() {
        return this.modifier;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x026e, code lost:            if (r1 != false) goto L514;     */
    @Override // androidx.compose.ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo238moveFocus3ESFkO8(int r17) {
        /*
            Method dump skipped, instructions count: 679
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl.mo238moveFocus3ESFkO8(int):boolean");
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void scheduleInvalidation(FocusTargetNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        FocusInvalidationManager focusInvalidationManager = this.focusInvalidationManager;
        focusInvalidationManager.getClass();
        focusInvalidationManager.scheduleInvalidation(focusInvalidationManager.focusTargetNodes, node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void setLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void takeFocus() {
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        if (focusTargetNode.focusState == FocusStateImpl.Inactive) {
            focusTargetNode.setFocusState(FocusStateImpl.Active);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void clearFocus(boolean z, boolean z2) {
        FocusStateImpl focusStateImpl;
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        if (!z) {
            int r4 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m241performCustomClearFocusMxy_nc0(focusTargetNode, 8).ordinal()];
            if (r4 == 1 || r4 == 2 || r4 == 3) {
                return;
            }
        }
        FocusStateImpl focusStateImpl2 = focusTargetNode.focusState;
        if (FocusTransactionsKt.clearFocus(focusTargetNode, z, z2)) {
            int r7 = WhenMappings.$EnumSwitchMapping$1[focusStateImpl2.ordinal()];
            if (r7 == 1 || r7 == 2 || r7 == 3) {
                focusStateImpl = FocusStateImpl.Active;
            } else {
                if (r7 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                focusStateImpl = FocusStateImpl.Inactive;
            }
            focusTargetNode.setFocusState(focusStateImpl);
        }
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void scheduleInvalidation(FocusEventModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        FocusInvalidationManager focusInvalidationManager = this.focusInvalidationManager;
        focusInvalidationManager.getClass();
        focusInvalidationManager.scheduleInvalidation(focusInvalidationManager.focusEventNodes, node);
    }

    @Override // androidx.compose.ui.focus.FocusOwner
    public final void scheduleInvalidation(FocusPropertiesModifierNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        FocusInvalidationManager focusInvalidationManager = this.focusInvalidationManager;
        focusInvalidationManager.getClass();
        focusInvalidationManager.scheduleInvalidation(focusInvalidationManager.focusPropertiesNodes, node);
    }
}
