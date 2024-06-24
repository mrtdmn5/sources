package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: NodeKind.kt */
/* loaded from: classes.dex */
public final class NodeKindKt {
    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached) {
            autoInvalidateNodeIncludingDelegates(node, -1, 1);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int r4, int r5) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int r1 = delegatingNode.selfKindSet;
            autoInvalidateNodeSelf(node, r1 & r4, r5);
            int r3 = (~r1) & r4;
            for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
                autoInvalidateNodeIncludingDelegates(node2, r3, r5);
            }
            return;
        }
        autoInvalidateNodeSelf(node, r4 & node.kindSet, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void autoInvalidateNodeSelf(Modifier.Node node, int r10, int r11) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (r11 == 0 && !node.getShouldAutoInvalidate()) {
            return;
        }
        boolean z11 = false;
        if ((r10 & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (node instanceof LayoutModifierNode)) {
            LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
            if (r11 == 2) {
                NodeCoordinator m441requireCoordinator64DMado = DelegatableNodeKt.m441requireCoordinator64DMado(node, 2);
                m441requireCoordinator64DMado.released = true;
                if (m441requireCoordinator64DMado.layer != null) {
                    m441requireCoordinator64DMado.updateLayerBlock(false, null);
                }
            }
        }
        if ((r10 & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && (node instanceof GlobalPositionAwareModifierNode)) {
            DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
        }
        if ((r10 & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3 && (node instanceof DrawModifierNode)) {
            DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
        }
        if ((r10 & 8) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && (node instanceof SemanticsModifierNode)) {
            SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
        }
        if ((r10 & 64) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5 && (node instanceof ParentDataModifierNode)) {
            ParentDataModifierNode parentDataModifierNode = (ParentDataModifierNode) node;
            Intrinsics.checkNotNullParameter(parentDataModifierNode, "<this>");
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = DelegatableNodeKt.requireLayoutNode(parentDataModifierNode).layoutDelegate;
            layoutNodeLayoutDelegate.measurePassDelegate.parentDataDirty = true;
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.parentDataDirty = true;
            }
        }
        if ((r10 & 1024) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z6 && (node instanceof FocusTargetNode)) {
            if (r11 == 2) {
                node.onReset();
            } else {
                DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
            }
        }
        if ((r10 & 2048) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7 && (node instanceof FocusPropertiesModifierNode)) {
            FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
            CanFocusChecker.canFocusValue = null;
            focusPropertiesModifierNode.applyFocusProperties(CanFocusChecker.INSTANCE);
            if (CanFocusChecker.canFocusValue != null) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (r11 == 2) {
                    if (focusPropertiesModifierNode.getNode().isAttached) {
                        MutableVector mutableVector = new MutableVector(new Modifier.Node[16]);
                        Modifier.Node node2 = focusPropertiesModifierNode.getNode().child;
                        if (node2 == null) {
                            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, focusPropertiesModifierNode.getNode());
                        } else {
                            mutableVector.add(node2);
                        }
                        while (mutableVector.isNotEmpty()) {
                            Modifier.Node node3 = (Modifier.Node) mutableVector.removeAt(mutableVector.size - 1);
                            if ((node3.aggregateChildKindSet & 1024) == 0) {
                                DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node3);
                            } else {
                                while (true) {
                                    if (node3 == null) {
                                        break;
                                    }
                                    if ((node3.kindSet & 1024) != 0) {
                                        MutableVector mutableVector2 = null;
                                        while (node3 != null) {
                                            if (node3 instanceof FocusTargetNode) {
                                                FocusTargetNode focusTargetNode = (FocusTargetNode) node3;
                                                DelegatableNodeKt.requireOwner(focusTargetNode).getFocusOwner().scheduleInvalidation(focusTargetNode);
                                            } else {
                                                if ((node3.kindSet & 1024) != 0) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                if (z9 && (node3 instanceof DelegatingNode)) {
                                                    int r7 = 0;
                                                    for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                                        if ((node4.kindSet & 1024) != 0) {
                                                            z10 = true;
                                                        } else {
                                                            z10 = false;
                                                        }
                                                        if (z10) {
                                                            r7++;
                                                            if (r7 == 1) {
                                                                node3 = node4;
                                                            } else {
                                                                if (mutableVector2 == null) {
                                                                    mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                                }
                                                                if (node3 != null) {
                                                                    mutableVector2.add(node3);
                                                                    node3 = null;
                                                                }
                                                                mutableVector2.add(node4);
                                                            }
                                                        }
                                                    }
                                                    if (r7 == 1) {
                                                    }
                                                }
                                            }
                                            node3 = DelegatableNodeKt.access$pop(mutableVector2);
                                        }
                                    } else {
                                        node3 = node3.child;
                                    }
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("visitChildren called on an unattached node".toString());
                    }
                } else {
                    DelegatableNodeKt.requireOwner(focusPropertiesModifierNode).getFocusOwner().scheduleInvalidation(focusPropertiesModifierNode);
                }
            }
        }
        if ((r10 & 4096) != 0) {
            z11 = true;
        }
        if (z11 && (node instanceof FocusEventModifierNode)) {
            FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
        }
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node.isAttached) {
            autoInvalidateNodeIncludingDelegates(node, -1, 0);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        int r0 = element instanceof LayoutModifier ? 3 : 1;
        if (element instanceof DrawModifier) {
            r0 |= 4;
        }
        if (element instanceof SemanticsModifier) {
            r0 |= 8;
        }
        if (element instanceof PointerInputModifier) {
            r0 |= 16;
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            r0 |= 32;
        }
        if (element instanceof FocusEventModifier) {
            r0 |= 4096;
        }
        if (element instanceof FocusOrderModifier) {
            r0 |= 2048;
        }
        if (element instanceof OnGloballyPositionedModifier) {
            r0 |= 256;
        }
        if (element instanceof ParentDataModifier) {
            r0 |= 64;
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? r0 | 128 : r0;
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int r2 = delegatingNode.selfKindSet;
            for (Modifier.Node node2 = delegatingNode.delegate; node2 != null; node2 = node2.child) {
                r2 |= calculateNodeKindSetFromIncludingDelegates(node2);
            }
            return r2;
        }
        return calculateNodeKindSetFrom(node);
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI */
    public static final boolean m476getIncludeSelfInTraversalH91voCI(int r0) {
        if ((r0 & 128) != 0) {
            return true;
        }
        return false;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        int r0 = node.kindSet;
        if (r0 != 0) {
            return r0;
        }
        int r02 = node instanceof LayoutModifierNode ? 3 : 1;
        if (node instanceof DrawModifierNode) {
            r02 |= 4;
        }
        if (node instanceof SemanticsModifierNode) {
            r02 |= 8;
        }
        if (node instanceof PointerInputModifierNode) {
            r02 |= 16;
        }
        if (node instanceof ModifierLocalModifierNode) {
            r02 |= 32;
        }
        if (node instanceof ParentDataModifierNode) {
            r02 |= 64;
        }
        if (node instanceof LayoutAwareModifierNode) {
            r02 |= 128;
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            r02 |= 256;
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            r02 |= DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
        }
        if (node instanceof FocusTargetNode) {
            r02 |= 1024;
        }
        if (node instanceof FocusPropertiesModifierNode) {
            r02 |= 2048;
        }
        if (node instanceof FocusEventModifierNode) {
            r02 |= 4096;
        }
        if (node instanceof KeyInputModifierNode) {
            r02 |= DfuBaseService.ERROR_REMOTE_MASK;
        }
        if (node instanceof RotaryInputModifierNode) {
            r02 |= DfuBaseService.ERROR_CONNECTION_MASK;
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            r02 |= DfuBaseService.ERROR_CONNECTION_STATE_MASK;
        }
        return node instanceof SoftKeyboardInterceptionModifierNode ? r02 | 131072 : r02;
    }
}
