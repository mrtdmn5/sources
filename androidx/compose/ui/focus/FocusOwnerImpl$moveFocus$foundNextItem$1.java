package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

/* compiled from: FocusOwnerImpl.kt */
/* loaded from: classes.dex */
public final class FocusOwnerImpl$moveFocus$foundNextItem$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    public final /* synthetic */ int $focusDirection;
    public final /* synthetic */ Ref$BooleanRef $isCancelled;
    public final /* synthetic */ FocusTargetNode $source;

    /* compiled from: FocusOwnerImpl.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

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
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FocusOwnerImpl$moveFocus$foundNextItem$1(FocusTargetNode focusTargetNode, int r2, Ref$BooleanRef ref$BooleanRef) {
        super(1);
        this.$source = focusTargetNode;
        this.$focusDirection = r2;
        this.$isCancelled = ref$BooleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(FocusTargetNode focusTargetNode) {
        boolean z;
        Modifier.Node node;
        NodeChain nodeChain;
        boolean z2;
        boolean z3;
        FocusTargetNode destination = focusTargetNode;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (Intrinsics.areEqual(destination, this.$source)) {
            return Boolean.FALSE;
        }
        Modifier.Node node2 = destination.node;
        if (node2.isAttached) {
            Modifier.Node node3 = node2.parent;
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(destination);
            loop0: while (true) {
                z = true;
                node = null;
                if (requireLayoutNode == null) {
                    break;
                }
                if ((requireLayoutNode.nodes.head.aggregateChildKindSet & 1024) != 0) {
                    while (node3 != null) {
                        if ((node3.kindSet & 1024) != 0) {
                            Modifier.Node node4 = node3;
                            MutableVector mutableVector = null;
                            while (node4 != null) {
                                if (node4 instanceof FocusTargetNode) {
                                    node = node4;
                                    break loop0;
                                }
                                if ((node4.kindSet & 1024) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2 && (node4 instanceof DelegatingNode)) {
                                    int r8 = 0;
                                    for (Modifier.Node node5 = ((DelegatingNode) node4).delegate; node5 != null; node5 = node5.child) {
                                        if ((node5.kindSet & 1024) != 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            r8++;
                                            if (r8 == 1) {
                                                node4 = node5;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (node4 != null) {
                                                    mutableVector.add(node4);
                                                    node4 = null;
                                                }
                                                mutableVector.add(node5);
                                            }
                                        }
                                    }
                                    if (r8 == 1) {
                                    }
                                }
                                node4 = DelegatableNodeKt.access$pop(mutableVector);
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
            }
            if (node != null) {
                int r0 = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m243performCustomRequestFocusMxy_nc0(destination, this.$focusDirection).ordinal()];
                if (r0 != 1) {
                    if (r0 != 2 && r0 != 3) {
                        if (r0 == 4) {
                            z = FocusTransactionsKt.performRequestFocus(destination);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        this.$isCancelled.element = true;
                    }
                }
                return Boolean.valueOf(z);
            }
            throw new IllegalStateException("Focus search landed at the root.".toString());
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }
}
