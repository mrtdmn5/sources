package androidx.compose.ui.layout;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: IntermediateLayoutModifierNode.kt */
/* loaded from: classes.dex */
public final class IntermediateLayoutModifierNode extends Modifier.Node implements LayoutModifierNode {
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        final Placeable mo421measureBRTryo0 = measurable.mo421measureBRTryo0(j);
        return measure.layout(mo421measureBRTryo0.width, mo421measureBRTryo0.height, EmptyMap.INSTANCE, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.layout.IntermediateLayoutModifierNode$measure$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope layout = placementScope;
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.place(Placeable.this, 0, 0, 0.0f);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl;
        boolean z;
        NodeChain nodeChain;
        boolean z2;
        boolean z3;
        NodeCoordinator nodeCoordinator = this.coordinator;
        Intrinsics.checkNotNull(nodeCoordinator);
        NodeCoordinator nodeCoordinator2 = this.coordinator;
        Intrinsics.checkNotNull(nodeCoordinator2);
        LookaheadDelegate lookaheadDelegate = nodeCoordinator2.getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            lookaheadLayoutCoordinatesImpl = lookaheadDelegate.lookaheadLayoutCoordinates;
        } else {
            lookaheadLayoutCoordinatesImpl = null;
        }
        if (lookaheadLayoutCoordinatesImpl != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LayoutNode layoutNode = nodeCoordinator.layoutNode.lookaheadRoot;
            Modifier.Node node = this.node;
            if (node.isAttached) {
                Modifier.Node node2 = node.parent;
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(this);
                while (requireLayoutNode != null) {
                    if ((requireLayoutNode.nodes.head.aggregateChildKindSet & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
                        while (node2 != null) {
                            if ((node2.kindSet & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
                                Modifier.Node node3 = node2;
                                MutableVector mutableVector = null;
                                while (node3 != null) {
                                    if (node3 instanceof IntermediateLayoutModifierNode) {
                                    } else {
                                        if ((node3.kindSet & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2 && (node3 instanceof DelegatingNode)) {
                                            int r8 = 0;
                                            for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                                if ((node4.kindSet & DfuBaseService.ERROR_REMOTE_TYPE_SECURE) != 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (z3) {
                                                    r8++;
                                                    if (r8 == 1) {
                                                        node3 = node4;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (node3 != null) {
                                                            mutableVector.add(node3);
                                                            node3 = null;
                                                        }
                                                        mutableVector.add(node4);
                                                    }
                                                }
                                            }
                                            if (r8 == 1) {
                                            }
                                        }
                                    }
                                    node3 = DelegatableNodeKt.access$pop(mutableVector);
                                }
                            }
                            node2 = node2.parent;
                        }
                    }
                    requireLayoutNode = requireLayoutNode.getParent$ui_release();
                    if (requireLayoutNode != null && (nodeChain = requireLayoutNode.nodes) != null) {
                        node2 = nodeChain.tail;
                    } else {
                        node2 = null;
                    }
                }
                return;
            }
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
