package androidx.compose.ui.node;

import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.CombinedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import java.util.Arrays;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: LayoutNode.kt */
/* loaded from: classes.dex */
public final class LayoutNode implements ComposeNodeLifecycleCallback, Remeasurement, OwnerScope, ComposeUiNode, Owner.OnLayoutCompletedListener {
    public SemanticsConfiguration _collapsedSemantics;
    public final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    public LayoutNode _foldedParent;
    public NodeCoordinator _innerLayerCoordinator;
    public MutableVector<LayoutNode> _unfoldedChildren;
    public final MutableVector<LayoutNode> _zSortedChildren;
    public boolean canMultiMeasure;
    public CompositionLocalMap compositionLocalMap;
    public boolean deactivated;
    public Density density;
    public int depth;
    public boolean ignoreRemeasureRequests;
    public boolean innerLayerCoordinatorIsDirty;
    public AndroidViewHolder interopViewFactoryHolder;
    public final IntrinsicsPolicy intrinsicsPolicy;
    public UsageByParent intrinsicsUsageByParent;
    public final boolean isVirtual;
    public final LayoutNodeLayoutDelegate layoutDelegate;
    public LayoutDirection layoutDirection;
    public LayoutNode lookaheadRoot;
    public MeasurePolicy measurePolicy;
    public Modifier modifier;
    public boolean needsOnPositionedDispatch;
    public final NodeChain nodes;
    public Function1<? super Owner, Unit> onAttach;
    public Function1<? super Owner, Unit> onDetach;
    public Owner owner;
    public UsageByParent previousIntrinsicsUsageByParent;
    public int semanticsId;
    public LayoutNodeSubcompositionsState subcompositionsState;
    public boolean unfoldedVirtualChildrenListDirty;
    public ViewConfiguration viewConfiguration;
    public int virtualChildrenCount;
    public boolean zSortedChildrenInvalidated;
    public static final LayoutNode$Companion$ErrorMeasurePolicy$1 ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List measurables, long j) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    public static final LayoutNode$Companion$Constructor$1 Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    public static final LayoutNode$Companion$DummyViewConfiguration$1 DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    public static final LayoutNode$$ExternalSyntheticLambda0 ZComparator = new LayoutNode$$ExternalSyntheticLambda0();

    /* compiled from: LayoutNode.kt */
    /* loaded from: classes.dex */
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* compiled from: LayoutNode.kt */
    /* loaded from: classes.dex */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        public final String error;

        public NoIntrinsicsMeasurePolicy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int r3) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int r3) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int r3) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List measurables, int r3) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* compiled from: LayoutNode.kt */
    /* loaded from: classes.dex */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* compiled from: LayoutNode.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LayoutState.values().length];
            try {
                r0[LayoutState.Idle.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public LayoutNode() {
        this(false, 3, 0);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static boolean m446remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode) {
        Constraints constraints;
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = layoutNode.layoutDelegate.measurePassDelegate;
        if (measurePassDelegate.measuredOnce) {
            constraints = new Constraints(measurePassDelegate.measurementConstraints);
        } else {
            constraints = null;
        }
        return layoutNode.m448remeasure_Sx5XlM$ui_release(constraints);
    }

    public static void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int r6) {
        boolean z2;
        LayoutNode parent$ui_release;
        boolean z3 = false;
        if ((r6 & 1) != 0) {
            z = false;
        }
        if ((r6 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (layoutNode.lookaheadRoot != null) {
            z3 = true;
        }
        if (z3) {
            Owner owner = layoutNode.owner;
            if (owner != null && !layoutNode.ignoreRemeasureRequests && !layoutNode.isVirtual) {
                owner.onRequestMeasure(layoutNode, true, z, z2);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                LayoutNode parent$ui_release2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                UsageByParent usageByParent = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
                if (parent$ui_release2 != null && usageByParent != UsageByParent.NotUsed) {
                    while (parent$ui_release2.intrinsicsUsageByParent == usageByParent && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                        parent$ui_release2 = parent$ui_release;
                    }
                    int r4 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.WhenMappings.$EnumSwitchMapping$1[usageByParent.ordinal()];
                    if (r4 != 1) {
                        if (r4 == 2) {
                            if (parent$ui_release2.lookaheadRoot != null) {
                                parent$ui_release2.requestLookaheadRelayout$ui_release(z);
                                return;
                            } else {
                                parent$ui_release2.requestRelayout$ui_release(z);
                                return;
                            }
                        }
                        throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                    }
                    if (parent$ui_release2.lookaheadRoot != null) {
                        requestLookaheadRemeasure$ui_release$default(parent$ui_release2, z, 2);
                        return;
                    } else {
                        requestRemeasure$ui_release$default(parent$ui_release2, z, 2);
                        return;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
    }

    public static void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int r6) {
        boolean z2;
        Owner owner;
        LayoutNode parent$ui_release;
        if ((r6 & 1) != 0) {
            z = false;
        }
        if ((r6 & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!layoutNode.ignoreRemeasureRequests && !layoutNode.isVirtual && (owner = layoutNode.owner) != null) {
            owner.onRequestMeasure(layoutNode, false, z, z2);
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode parent$ui_release2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
            UsageByParent usageByParent = layoutNodeLayoutDelegate.layoutNode.intrinsicsUsageByParent;
            if (parent$ui_release2 != null && usageByParent != UsageByParent.NotUsed) {
                while (parent$ui_release2.intrinsicsUsageByParent == usageByParent && (parent$ui_release = parent$ui_release2.getParent$ui_release()) != null) {
                    parent$ui_release2 = parent$ui_release;
                }
                int r4 = LayoutNodeLayoutDelegate.MeasurePassDelegate.WhenMappings.$EnumSwitchMapping$1[usageByParent.ordinal()];
                if (r4 != 1) {
                    if (r4 == 2) {
                        parent$ui_release2.requestRelayout$ui_release(z);
                        return;
                    }
                    throw new IllegalStateException("Intrinsics isn't used by the parent".toString());
                }
                requestRemeasure$ui_release$default(parent$ui_release2, z, 2);
            }
        }
    }

    public static void rescheduleRemeasureOrRelayout$ui_release(LayoutNode layoutNode) {
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
        if (WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate.layoutState.ordinal()] == 1) {
            if (layoutNodeLayoutDelegate.measurePending) {
                requestRemeasure$ui_release$default(layoutNode, true, 2);
                return;
            }
            if (layoutNodeLayoutDelegate.layoutPending) {
                layoutNode.requestRelayout$ui_release(true);
                return;
            } else if (layoutNodeLayoutDelegate.lookaheadMeasurePending) {
                requestLookaheadRemeasure$ui_release$default(layoutNode, true, 2);
                return;
            } else {
                if (layoutNodeLayoutDelegate.lookaheadLayoutPending) {
                    layoutNode.requestLookaheadRelayout$ui_release(true);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + layoutNodeLayoutDelegate.layoutState);
    }

    public final void attach$ui_release(Owner owner) {
        boolean z;
        boolean z2;
        InnerNodeCoordinator innerNodeCoordinator;
        int r6;
        LayoutNode layoutNode;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Owner owner2;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (this.owner == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            LayoutNode layoutNode2 = this._foldedParent;
            if (layoutNode2 != null && !Intrinsics.areEqual(layoutNode2.owner, owner)) {
                z2 = false;
            } else {
                z2 = true;
            }
            String str = null;
            if (!z2) {
                StringBuilder sb = new StringBuilder("Attaching to a different owner(");
                sb.append(owner);
                sb.append(") than the parent's owner(");
                LayoutNode parent$ui_release = getParent$ui_release();
                if (parent$ui_release != null) {
                    owner2 = parent$ui_release.owner;
                } else {
                    owner2 = null;
                }
                sb.append(owner2);
                sb.append("). This tree: ");
                sb.append(debugTreeToString(0));
                sb.append(" Parent tree: ");
                LayoutNode layoutNode3 = this._foldedParent;
                if (layoutNode3 != null) {
                    str = layoutNode3.debugTreeToString(0);
                }
                sb.append(str);
                throw new IllegalStateException(sb.toString().toString());
            }
            LayoutNode parent$ui_release2 = getParent$ui_release();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            if (parent$ui_release2 == null) {
                layoutNodeLayoutDelegate.measurePassDelegate.isPlaced = true;
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.isPlaced = true;
                }
            }
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = nodeChain.outerCoordinator;
            if (parent$ui_release2 != null) {
                innerNodeCoordinator = parent$ui_release2.nodes.innerCoordinator;
            } else {
                innerNodeCoordinator = null;
            }
            nodeCoordinator.wrappedBy = innerNodeCoordinator;
            this.owner = owner;
            if (parent$ui_release2 != null) {
                r6 = parent$ui_release2.depth;
            } else {
                r6 = -1;
            }
            this.depth = r6 + 1;
            if (nodeChain.m460hasH91voCI$ui_release(8)) {
                this._collapsedSemantics = null;
                LayoutNodeKt.requireOwner(this).onSemanticsChange();
            }
            owner.onAttach(this);
            LayoutNode layoutNode4 = this._foldedParent;
            if (layoutNode4 == null || (layoutNode = layoutNode4.lookaheadRoot) == null) {
                layoutNode = this.lookaheadRoot;
            }
            setLookaheadRoot(layoutNode);
            if (!this.deactivated) {
                for (Modifier.Node node = nodeChain.head; node != null; node = node.child) {
                    node.markAsAttached$ui_release();
                }
            }
            MutableVector<LayoutNode> mutableVector = this._foldedChildren.vector;
            int r62 = mutableVector.size;
            if (r62 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r7 = 0;
                do {
                    layoutNodeArr[r7].attach$ui_release(owner);
                    r7++;
                } while (r7 < r62);
            }
            if (!this.deactivated) {
                nodeChain.runAttachLifecycle();
            }
            invalidateMeasurements$ui_release();
            if (parent$ui_release2 != null) {
                parent$ui_release2.invalidateMeasurements$ui_release();
            }
            NodeCoordinator nodeCoordinator2 = nodeChain.innerCoordinator.wrapped;
            for (NodeCoordinator nodeCoordinator3 = nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator3, nodeCoordinator2) && nodeCoordinator3 != null; nodeCoordinator3 = nodeCoordinator3.wrapped) {
                nodeCoordinator3.updateLayerBlock(true, nodeCoordinator3.layerBlock);
                OwnedLayer ownedLayer = nodeCoordinator3.layer;
                if (ownedLayer != null) {
                    ownedLayer.invalidate();
                }
            }
            Function1<? super Owner, Unit> function1 = this.onAttach;
            if (function1 != null) {
                function1.invoke(owner);
            }
            layoutNodeLayoutDelegate.updateParentData();
            if (!this.deactivated) {
                Modifier.Node node2 = nodeChain.head;
                if ((node2.aggregateChildKindSet & 7168) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    while (node2 != null) {
                        int r0 = node2.kindSet;
                        if ((r0 & 1024) != 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if ((r0 & 2048) != 0) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        boolean z7 = z4 | z5;
                        if ((r0 & 4096) != 0) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6 | z7) {
                            NodeKindKt.autoInvalidateInsertedNode(node2);
                        }
                        node2 = node2.child;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString(0)).toString());
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int r1 = mutableVector.size;
        if (r1 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r2 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArr[r2];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                r2++;
            } while (r2 < r1);
        }
    }

    public final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int r1 = mutableVector.size;
        if (r1 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r2 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArr[r2];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                r2++;
            } while (r2 < r1);
        }
    }

    public final String debugTreeToString(int r8) {
        StringBuilder sb = new StringBuilder();
        for (int r2 = 0; r2 < r8; r2++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int r3 = mutableVector.size;
        if (r3 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r4 = 0;
            do {
                sb.append(layoutNodeArr[r4].debugTreeToString(r8 + 1));
                r4++;
            } while (r4 < r3);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "tree.toString()");
        if (r8 == 0) {
            String substring = sb2.substring(0, sb2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return sb2;
    }

    public final void detach$ui_release() {
        LookaheadAlignmentLines lookaheadAlignmentLines;
        boolean z;
        boolean z2;
        Owner owner = this.owner;
        String str = null;
        if (owner == null) {
            StringBuilder sb = new StringBuilder("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = parent$ui_release.debugTreeToString(0);
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString().toString());
        }
        NodeChain nodeChain = this.nodes;
        int r4 = nodeChain.head.aggregateChildKindSet & 1024;
        Modifier.Node node = nodeChain.tail;
        if (r4 != 0) {
            for (Modifier.Node node2 = node; node2 != null; node2 = node2.parent) {
                if ((node2.kindSet & 1024) != 0) {
                    MutableVector mutableVector = null;
                    Modifier.Node node3 = node2;
                    while (node3 != null) {
                        if (node3 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node3;
                            if (focusTargetNode.focusState.isFocused()) {
                                LayoutNodeKt.requireOwner(this).getFocusOwner().clearFocus(true, false);
                                focusTargetNode.scheduleInvalidationForFocusEvents$ui_release();
                            }
                        } else {
                            if ((node3.kindSet & 1024) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (node3 instanceof DelegatingNode)) {
                                int r10 = 0;
                                for (Modifier.Node node4 = ((DelegatingNode) node3).delegate; node4 != null; node4 = node4.child) {
                                    if ((node4.kindSet & 1024) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        r10++;
                                        if (r10 == 1) {
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
                                if (r10 == 1) {
                                }
                            }
                        }
                        node3 = DelegatableNodeKt.access$pop(mutableVector);
                    }
                }
            }
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = layoutNodeLayoutDelegate.measurePassDelegate;
            UsageByParent usageByParent = UsageByParent.NotUsed;
            measurePassDelegate.getClass();
            Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
            measurePassDelegate.measuredByParent = usageByParent;
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.measuredByParent = usageByParent;
            }
        }
        LayoutNodeAlignmentLines layoutNodeAlignmentLines = layoutNodeLayoutDelegate.measurePassDelegate.alignmentLines;
        layoutNodeAlignmentLines.dirty = true;
        layoutNodeAlignmentLines.usedDuringParentMeasurement = false;
        layoutNodeAlignmentLines.previousUsedDuringParentLayout = false;
        layoutNodeAlignmentLines.usedDuringParentLayout = false;
        layoutNodeAlignmentLines.usedByModifierMeasurement = false;
        layoutNodeAlignmentLines.usedByModifierLayout = false;
        layoutNodeAlignmentLines.queryOwner = null;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate2 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate2 != null && (lookaheadAlignmentLines = lookaheadPassDelegate2.alignmentLines) != null) {
            lookaheadAlignmentLines.dirty = true;
            lookaheadAlignmentLines.usedDuringParentMeasurement = false;
            lookaheadAlignmentLines.previousUsedDuringParentLayout = false;
            lookaheadAlignmentLines.usedDuringParentLayout = false;
            lookaheadAlignmentLines.usedByModifierMeasurement = false;
            lookaheadAlignmentLines.usedByModifierLayout = false;
            lookaheadAlignmentLines.queryOwner = null;
        }
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        if (nodeChain.m460hasH91voCI$ui_release(8)) {
            this._collapsedSemantics = null;
            LayoutNodeKt.requireOwner(this).onSemanticsChange();
        }
        for (Modifier.Node node5 = node; node5 != null; node5 = node5.parent) {
            if (node5.isAttached) {
                node5.runDetachLifecycle$ui_release();
            }
        }
        this.ignoreRemeasureRequests = true;
        MutableVector<LayoutNode> mutableVector2 = this._foldedChildren.vector;
        int r42 = mutableVector2.size;
        if (r42 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector2.content;
            int r8 = 0;
            do {
                layoutNodeArr[r8].detach$ui_release();
                r8++;
            } while (r8 < r42);
        }
        this.ignoreRemeasureRequests = false;
        while (node != null) {
            if (node.isAttached) {
                node.markAsDetached$ui_release();
            }
            node = node.parent;
        }
        owner.onDetach(this);
        this.owner = null;
        setLookaheadRoot(null);
        this.depth = 0;
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate2 = layoutNodeLayoutDelegate.measurePassDelegate;
        measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
        measurePassDelegate2.previousPlaceOrder = Integer.MAX_VALUE;
        measurePassDelegate2.isPlaced = false;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeLayoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate3 != null) {
            lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3.previousPlaceOrder = Integer.MAX_VALUE;
            lookaheadPassDelegate3.isPlaced = false;
        }
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.nodes.outerCoordinator.draw(canvas);
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public final void forceRemeasure() {
        Constraints constraints;
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 1);
        } else {
            requestRemeasure$ui_release$default(this, false, 1);
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        if (measurePassDelegate.measuredOnce) {
            constraints = new Constraints(measurePassDelegate.measurementConstraints);
        } else {
            constraints = null;
        }
        if (constraints != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo484measureAndLayout0kLqBqw(this, constraints.value);
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            owner2.measureAndLayout(true);
        }
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
        layoutNodeLayoutDelegate.layoutNode.getChildren$ui_release();
        boolean z = lookaheadPassDelegate.childDelegatesDirty;
        MutableVector<LayoutNodeLayoutDelegate.LookaheadPassDelegate> mutableVector = lookaheadPassDelegate._childDelegates;
        if (!z) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int r4 = mutableVector2.size;
        if (r4 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector2.content;
            int r6 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArr[r6];
                if (mutableVector.size <= r6) {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate2 = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                    Intrinsics.checkNotNull(lookaheadPassDelegate2);
                    mutableVector.add(lookaheadPassDelegate2);
                } else {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate3 = layoutNode2.layoutDelegate.lookaheadPassDelegate;
                    Intrinsics.checkNotNull(lookaheadPassDelegate3);
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate[] lookaheadPassDelegateArr = mutableVector.content;
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate4 = lookaheadPassDelegateArr[r6];
                    lookaheadPassDelegateArr[r6] = lookaheadPassDelegate3;
                }
                r6++;
            } while (r6 < r4);
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.size);
        lookaheadPassDelegate.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
        layoutNodeLayoutDelegate.layoutNode.updateChildrenIfDirty$ui_release();
        boolean z = measurePassDelegate.childDelegatesDirty;
        MutableVector<LayoutNodeLayoutDelegate.MeasurePassDelegate> mutableVector = measurePassDelegate._childDelegates;
        if (!z) {
            return mutableVector.asMutableList();
        }
        LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int r4 = mutableVector2.size;
        if (r4 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector2.content;
            int r6 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArr[r6];
                if (mutableVector.size <= r6) {
                    mutableVector.add(layoutNode2.layoutDelegate.measurePassDelegate);
                } else {
                    LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate2 = layoutNode2.layoutDelegate.measurePassDelegate;
                    LayoutNodeLayoutDelegate.MeasurePassDelegate[] measurePassDelegateArr = mutableVector.content;
                    LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate3 = measurePassDelegateArr[r6];
                    measurePassDelegateArr[r6] = measurePassDelegate2;
                }
                r6++;
            } while (r6 < r4);
        }
        mutableVector.removeRange(layoutNode.getChildren$ui_release().size(), mutableVector.size);
        measurePassDelegate.childDelegatesDirty = false;
        return mutableVector.asMutableList();
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
    public final SemanticsConfiguration getCollapsedSemantics$ui_release() {
        if (this.nodes.m460hasH91voCI$ui_release(8) && this._collapsedSemantics == null) {
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = new SemanticsConfiguration();
            OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(this).getSnapshotObserver();
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$collapsedSemantics$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v0 */
                /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
                /* JADX WARN: Type inference failed for: r2v10 */
                /* JADX WARN: Type inference failed for: r2v11 */
                /* JADX WARN: Type inference failed for: r2v3 */
                /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
                /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
                /* JADX WARN: Type inference failed for: r2v6 */
                /* JADX WARN: Type inference failed for: r2v7 */
                /* JADX WARN: Type inference failed for: r2v8 */
                /* JADX WARN: Type inference failed for: r2v9 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1 */
                /* JADX WARN: Type inference failed for: r3v10 */
                /* JADX WARN: Type inference failed for: r3v11 */
                /* JADX WARN: Type inference failed for: r3v2 */
                /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
                /* JADX WARN: Type inference failed for: r3v4 */
                /* JADX WARN: Type inference failed for: r3v5 */
                /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
                /* JADX WARN: Type inference failed for: r3v8 */
                /* JADX WARN: Type inference failed for: r3v9 */
                /* JADX WARN: Type inference failed for: r4v7, types: [androidx.compose.ui.semantics.SemanticsConfiguration, T] */
                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    boolean z;
                    boolean z2;
                    NodeChain nodeChain = LayoutNode.this.nodes;
                    if ((nodeChain.head.aggregateChildKindSet & 8) != 0) {
                        for (Modifier.Node node = nodeChain.tail; node != null; node = node.parent) {
                            if ((node.kindSet & 8) != 0) {
                                DelegatingNode delegatingNode = node;
                                ?? r3 = 0;
                                while (delegatingNode != 0) {
                                    if (delegatingNode instanceof SemanticsModifierNode) {
                                        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) delegatingNode;
                                        boolean shouldClearDescendantSemantics = semanticsModifierNode.getShouldClearDescendantSemantics();
                                        Ref$ObjectRef<SemanticsConfiguration> ref$ObjectRef2 = ref$ObjectRef;
                                        if (shouldClearDescendantSemantics) {
                                            ?? semanticsConfiguration = new SemanticsConfiguration();
                                            ref$ObjectRef2.element = semanticsConfiguration;
                                            semanticsConfiguration.isClearingSemantics = true;
                                        }
                                        if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                            ref$ObjectRef2.element.isMergingSemanticsOfDescendants = true;
                                        }
                                        semanticsModifierNode.applySemantics(ref$ObjectRef2.element);
                                    } else {
                                        if ((delegatingNode.kindSet & 8) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z && (delegatingNode instanceof DelegatingNode)) {
                                            Modifier.Node node2 = delegatingNode.delegate;
                                            int r7 = 0;
                                            delegatingNode = delegatingNode;
                                            r3 = r3;
                                            while (node2 != null) {
                                                if ((node2.kindSet & 8) != 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    r7++;
                                                    r3 = r3;
                                                    if (r7 == 1) {
                                                        delegatingNode = node2;
                                                    } else {
                                                        if (r3 == 0) {
                                                            r3 = new MutableVector(new Modifier.Node[16]);
                                                        }
                                                        if (delegatingNode != 0) {
                                                            r3.add(delegatingNode);
                                                            delegatingNode = 0;
                                                        }
                                                        r3.add(node2);
                                                    }
                                                }
                                                node2 = node2.child;
                                                delegatingNode = delegatingNode;
                                                r3 = r3;
                                            }
                                            if (r7 == 1) {
                                            }
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(r3);
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            };
            snapshotObserver.getClass();
            snapshotObserver.observeReads$ui_release(this, snapshotObserver.onCommitAffectingSemantics, function0);
            SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) ref$ObjectRef.element;
            this._collapsedSemantics = semanticsConfiguration;
            return semanticsConfiguration;
        }
        return this._collapsedSemantics;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.vector.asMutableList();
    }

    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        UsageByParent usageByParent;
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate == null || (usageByParent = lookaheadPassDelegate.measuredByParent) == null) {
            return UsageByParent.NotUsed;
        }
        return usageByParent;
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        while (true) {
            boolean z = false;
            if (layoutNode != null && layoutNode.isVirtual) {
                z = true;
            }
            if (z) {
                layoutNode = layoutNode._foldedParent;
            } else {
                return layoutNode;
            }
        }
    }

    public final int getPlaceOrder$ui_release() {
        return this.layoutDelegate.measurePassDelegate.placeOrder;
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        boolean z = this.zSortedChildrenInvalidated;
        MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
        if (z) {
            mutableVector.clear();
            mutableVector.addAll(mutableVector.size, get_children$ui_release());
            LayoutNode$$ExternalSyntheticLambda0 comparator = ZComparator;
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r3 = mutableVector.size;
            Intrinsics.checkNotNullParameter(layoutNodeArr, "<this>");
            Arrays.sort(layoutNodeArr, 0, r3, comparator);
            this.zSortedChildrenInvalidated = false;
        }
        return mutableVector;
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.vector;
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m447hitTestM_7yMNQ$ui_release(long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeChain nodeChain = this.nodes;
        nodeChain.outerCoordinator.m469hitTestYqVAtuI(NodeCoordinator.PointerInputSource, nodeChain.outerCoordinator.m464fromParentPositionMKHz9U(j), hitTestResult, z, z2);
    }

    public final void insertAt$ui_release(int r6, LayoutNode instance) {
        boolean z;
        boolean z2;
        String str;
        Intrinsics.checkNotNullParameter(instance, "instance");
        if (instance._foldedParent == null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder("Cannot insert ");
            sb.append(instance);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString(0));
            sb.append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            if (layoutNode != null) {
                str = layoutNode.debugTreeToString(0);
            } else {
                str = null;
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString().toString());
        }
        if (instance.owner == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            instance._foldedParent = this;
            MutableVectorWithMutationTracking<LayoutNode> mutableVectorWithMutationTracking = this._foldedChildren;
            mutableVectorWithMutationTracking.vector.add(r6, instance);
            mutableVectorWithMutationTracking.onVectorMutated.invoke();
            onZSortedChildrenInvalidated$ui_release();
            if (instance.isVirtual) {
                this.virtualChildrenCount++;
            }
            invalidateUnfoldedVirtualChildren();
            Owner owner = this.owner;
            if (owner != null) {
                instance.attach$ui_release(owner);
            }
            if (instance.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
                layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
                return;
            }
            return;
        }
        throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString(0) + " Other tree: " + instance.debugTreeToString(0)).toString());
    }

    public final void invalidateLayer$ui_release() {
        OwnedLayer ownedLayer;
        if (this.innerLayerCoordinatorIsDirty) {
            NodeChain nodeChain = this.nodes;
            NodeCoordinator nodeCoordinator = nodeChain.innerCoordinator;
            NodeCoordinator nodeCoordinator2 = nodeChain.outerCoordinator.wrappedBy;
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
                    break;
                }
                if (nodeCoordinator != null) {
                    ownedLayer = nodeCoordinator.layer;
                } else {
                    ownedLayer = null;
                }
                if (ownedLayer != null) {
                    this._innerLayerCoordinator = nodeCoordinator;
                    break;
                } else if (nodeCoordinator != null) {
                    nodeCoordinator = nodeCoordinator.wrappedBy;
                } else {
                    nodeCoordinator = null;
                }
            }
        }
        NodeCoordinator nodeCoordinator3 = this._innerLayerCoordinator;
        if (nodeCoordinator3 != null && nodeCoordinator3.layer == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (nodeCoordinator3 != null) {
            nodeCoordinator3.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = nodeChain.outerCoordinator;
        InnerNodeCoordinator innerNodeCoordinator = nodeChain.innerCoordinator;
        while (nodeCoordinator != innerNodeCoordinator) {
            Intrinsics.checkNotNull(nodeCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
            OwnedLayer ownedLayer = layoutModifierNodeCoordinator.layer;
            if (ownedLayer != null) {
                ownedLayer.invalidate();
            }
            nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
        }
        OwnedLayer ownedLayer2 = nodeChain.innerCoordinator.layer;
        if (ownedLayer2 != null) {
            ownedLayer2.invalidate();
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.lookaheadRoot != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 3);
        } else {
            requestRemeasure$ui_release$default(this, false, 3);
        }
    }

    public final void invalidateUnfoldedVirtualChildren() {
        LayoutNode layoutNode;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (layoutNode = this._foldedParent) != null) {
            layoutNode.invalidateUnfoldedVirtualChildren();
        }
    }

    public final boolean isAttached() {
        if (this.owner != null) {
            return true;
        }
        return false;
    }

    public final boolean isPlaced() {
        return this.layoutDelegate.measurePassDelegate.isPlaced;
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate.isPlaced);
        }
        return null;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        return isAttached();
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.layoutDelegate.lookaheadPassDelegate;
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        try {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = true;
            if (lookaheadPassDelegate.placedOnce) {
                lookaheadPassDelegate.mo422placeAtf8xVGno(lookaheadPassDelegate.lastPosition, 0.0f, null);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        } finally {
            lookaheadPassDelegate.relayoutWithoutParentInProgress = false;
        }
    }

    public final void move$ui_release(int r6, int r7, int r8) {
        int r1;
        if (r6 == r7) {
            return;
        }
        for (int r0 = 0; r0 < r8; r0++) {
            if (r6 > r7) {
                r1 = r6 + r0;
            } else {
                r1 = r6;
            }
            int r2 = r6 > r7 ? r7 + r0 : (r7 + r8) - 2;
            MutableVectorWithMutationTracking<LayoutNode> mutableVectorWithMutationTracking = this._foldedChildren;
            LayoutNode removeAt = mutableVectorWithMutationTracking.vector.removeAt(r1);
            mutableVectorWithMutationTracking.onVectorMutated.invoke();
            mutableVectorWithMutationTracking.vector.add(r2, removeAt);
            mutableVectorWithMutationTracking.onVectorMutated.invoke();
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    public final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.childrenAccessingCoordinatesDuringPlacement - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.nodes.outerCoordinator.wrappedBy = null;
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> mutableVector = layoutNode._foldedChildren.vector;
            int r1 = mutableVector.size;
            if (r1 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r2 = 0;
                do {
                    layoutNodeArr[r2].nodes.outerCoordinator.wrappedBy = null;
                    r2++;
                } while (r2 < r1);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onDeactivate();
        }
        this.deactivated = true;
        resetModifierState();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public final void onLayoutComplete() {
        Modifier.Node node;
        boolean z;
        boolean z2;
        NodeChain nodeChain = this.nodes;
        InnerNodeCoordinator innerNodeCoordinator = nodeChain.innerCoordinator;
        boolean m476getIncludeSelfInTraversalH91voCI = NodeKindKt.m476getIncludeSelfInTraversalH91voCI(128);
        if (m476getIncludeSelfInTraversalH91voCI) {
            node = innerNodeCoordinator.tail;
        } else {
            node = innerNodeCoordinator.tail.parent;
            if (node == null) {
                return;
            }
        }
        NodeCoordinator$Companion$onCommitAffectingLayerParams$1 nodeCoordinator$Companion$onCommitAffectingLayerParams$1 = NodeCoordinator.onCommitAffectingLayerParams;
        for (Modifier.Node headNode = innerNodeCoordinator.headNode(m476getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.aggregateChildKindSet & 128) != 0; headNode = headNode.child) {
            if ((headNode.kindSet & 128) != 0) {
                DelegatingNode delegatingNode = headNode;
                ?? r6 = 0;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof LayoutAwareModifierNode) {
                        ((LayoutAwareModifierNode) delegatingNode).onPlaced(nodeChain.innerCoordinator);
                    } else {
                        if ((delegatingNode.kindSet & 128) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node node2 = delegatingNode.delegate;
                            int r10 = 0;
                            delegatingNode = delegatingNode;
                            r6 = r6;
                            while (node2 != null) {
                                if ((node2.kindSet & 128) != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    r10++;
                                    r6 = r6;
                                    if (r10 == 1) {
                                        delegatingNode = node2;
                                    } else {
                                        if (r6 == 0) {
                                            r6 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (delegatingNode != 0) {
                                            r6.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        r6.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                delegatingNode = delegatingNode;
                                r6 = r6;
                            }
                            if (r10 == 1) {
                            }
                        }
                    }
                    delegatingNode = DelegatableNodeKt.access$pop(r6);
                }
            }
            if (headNode == node) {
                return;
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            androidViewHolder.onRelease();
        }
        NodeChain nodeChain = this.nodes;
        NodeCoordinator nodeCoordinator = nodeChain.innerCoordinator.wrapped;
        for (NodeCoordinator nodeCoordinator2 = nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
            nodeCoordinator2.released = true;
            if (nodeCoordinator2.layer != null) {
                nodeCoordinator2.updateLayerBlock(false, null);
            }
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onReuse() {
        if (isAttached()) {
            AndroidViewHolder androidViewHolder = this.interopViewFactoryHolder;
            if (androidViewHolder != null) {
                androidViewHolder.onReuse();
            }
            if (this.deactivated) {
                this.deactivated = false;
            } else {
                resetModifierState();
            }
            this.semanticsId = SemanticsModifierKt.lastIdentifier.addAndGet(1);
            NodeChain nodeChain = this.nodes;
            for (Modifier.Node node = nodeChain.head; node != null; node = node.child) {
                node.markAsAttached$ui_release();
            }
            nodeChain.runAttachLifecycle();
            return;
        }
        throw new IllegalArgumentException("onReuse is only expected on attached node".toString());
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m448remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null) {
            if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
                clearSubtreeIntrinsicsUsage$ui_release();
            }
            return this.layoutDelegate.measurePassDelegate.m453remeasureBRTryo0(constraints.value);
        }
        return false;
    }

    public final void removeAll$ui_release() {
        MutableVectorWithMutationTracking<LayoutNode> mutableVectorWithMutationTracking = this._foldedChildren;
        int r1 = mutableVectorWithMutationTracking.vector.size;
        while (true) {
            r1--;
            if (-1 < r1) {
                onChildRemoved(mutableVectorWithMutationTracking.vector.content[r1]);
            } else {
                mutableVectorWithMutationTracking.vector.clear();
                mutableVectorWithMutationTracking.onVectorMutated.invoke();
                return;
            }
        }
    }

    public final void removeAt$ui_release(int r3, int r4) {
        boolean z;
        if (r4 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r42 = (r4 + r3) - 1;
            if (r3 > r42) {
                return;
            }
            while (true) {
                MutableVectorWithMutationTracking<LayoutNode> mutableVectorWithMutationTracking = this._foldedChildren;
                LayoutNode removeAt = mutableVectorWithMutationTracking.vector.removeAt(r42);
                mutableVectorWithMutationTracking.onVectorMutated.invoke();
                onChildRemoved(removeAt);
                if (r42 != r3) {
                    r42--;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("count (", r4, ") must be greater than 0").toString());
        }
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.layoutDelegate.measurePassDelegate;
        measurePassDelegate.getClass();
        try {
            measurePassDelegate.relayoutWithoutParentInProgress = true;
            if (measurePassDelegate.placedOnce) {
                measurePassDelegate.m452placeOuterCoordinatorf8xVGno(measurePassDelegate.lastPosition, measurePassDelegate.lastZIndex, measurePassDelegate.lastLayerBlock);
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        } finally {
            measurePassDelegate.relayoutWithoutParentInProgress = false;
        }
    }

    public final void requestLookaheadRelayout$ui_release(boolean z) {
        Owner owner;
        if (!this.isVirtual && (owner = this.owner) != null) {
            owner.onRequestRelayout(this, true, z);
        }
    }

    public final void requestRelayout$ui_release(boolean z) {
        Owner owner;
        if (!this.isVirtual && (owner = this.owner) != null) {
            int r1 = Owner.$r8$clinit;
            owner.onRequestRelayout(this, false, z);
        }
    }

    public final void resetModifierState() {
        int r2;
        NodeChain nodeChain = this.nodes;
        for (Modifier.Node node = nodeChain.tail; node != null; node = node.parent) {
            if (node.isAttached) {
                node.reset$ui_release();
            }
        }
        MutableVector<Modifier.Element> mutableVector = nodeChain.current;
        if (mutableVector != null && (r2 = mutableVector.size) > 0) {
            Modifier.Element[] elementArr = mutableVector.content;
            int r4 = 0;
            do {
                Modifier.Element element = elementArr[r4];
                if (element instanceof SuspendPointerInputElement) {
                    ForceUpdateElement forceUpdateElement = new ForceUpdateElement((ModifierNodeElement) element);
                    Modifier.Element[] elementArr2 = mutableVector.content;
                    Modifier.Element element2 = elementArr2[r4];
                    elementArr2[r4] = forceUpdateElement;
                }
                r4++;
            } while (r4 < r2);
        }
        Modifier.Node node2 = nodeChain.tail;
        for (Modifier.Node node3 = node2; node3 != null; node3 = node3.parent) {
            if (node3.isAttached) {
                node3.runDetachLifecycle$ui_release();
            }
        }
        while (node2 != null) {
            if (node2.isAttached) {
                node2.markAsDetached$ui_release();
            }
            node2 = node2.parent;
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int r1 = mutableVector.size;
        if (r1 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r2 = 0;
            do {
                LayoutNode layoutNode = layoutNodeArr[r2];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                r2++;
            } while (r2 < r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public final void setCompositionLocalMap(CompositionLocalMap value) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        this.compositionLocalMap = value;
        setDensity((Density) value.get(CompositionLocalsKt.LocalDensity));
        setLayoutDirection((LayoutDirection) value.get(CompositionLocalsKt.LocalLayoutDirection));
        setViewConfiguration((ViewConfiguration) value.get(CompositionLocalsKt.LocalViewConfiguration));
        Modifier.Node node = this.nodes.head;
        if ((node.aggregateChildKindSet & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
            while (node != null) {
                if ((node.kindSet & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
                    DelegatingNode delegatingNode = node;
                    ?? r3 = 0;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof CompositionLocalConsumerModifierNode) {
                            Modifier.Node node2 = ((CompositionLocalConsumerModifierNode) delegatingNode).getNode();
                            if (node2.isAttached) {
                                NodeKindKt.autoInvalidateUpdatedNode(node2);
                            } else {
                                node2.updatedNodeAwaitingAttachForInvalidation = true;
                            }
                        } else {
                            if ((delegatingNode.kindSet & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node node3 = delegatingNode.delegate;
                                int r7 = 0;
                                delegatingNode = delegatingNode;
                                r3 = r3;
                                while (node3 != null) {
                                    if ((node3.kindSet & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        r7++;
                                        r3 = r3;
                                        if (r7 == 1) {
                                            delegatingNode = node3;
                                        } else {
                                            if (r3 == 0) {
                                                r3 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (delegatingNode != 0) {
                                                r3.add(delegatingNode);
                                                delegatingNode = 0;
                                            }
                                            r3.add(node3);
                                        }
                                    }
                                    node3 = node3.child;
                                    delegatingNode = delegatingNode;
                                    r3 = r3;
                                }
                                if (r7 == 1) {
                                }
                            }
                        }
                        delegatingNode = DelegatableNodeKt.access$pop(r3);
                    }
                }
                if ((node.aggregateChildKindSet & DfuBaseService.ERROR_CONNECTION_STATE_MASK) != 0) {
                    node = node.child;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void setDensity(Density value) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.density, value)) {
            this.density = value;
            invalidateMeasurements$ui_release();
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            invalidateLayers$ui_release();
            Modifier.Node node = this.nodes.head;
            if ((node.aggregateChildKindSet & 16) != 0) {
                while (node != null) {
                    if ((node.kindSet & 16) != 0) {
                        DelegatingNode delegatingNode = node;
                        ?? r3 = 0;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) delegatingNode).onDensityChange();
                            } else {
                                if ((delegatingNode.kindSet & 16) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node node2 = delegatingNode.delegate;
                                    int r7 = 0;
                                    delegatingNode = delegatingNode;
                                    r3 = r3;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 16) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            r7++;
                                            r3 = r3;
                                            if (r7 == 1) {
                                                delegatingNode = node2;
                                            } else {
                                                if (r3 == 0) {
                                                    r3 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (delegatingNode != 0) {
                                                    r3.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                r3.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
                                        delegatingNode = delegatingNode;
                                        r3 = r3;
                                    }
                                    if (r7 == 1) {
                                    }
                                }
                            }
                            delegatingNode = DelegatableNodeKt.access$pop(r3);
                        }
                    }
                    if ((node.aggregateChildKindSet & 16) != 0) {
                        node = node.child;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            invalidateMeasurements$ui_release();
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            invalidateLayers$ui_release();
        }
    }

    public final void setLookaheadRoot(LayoutNode layoutNode) {
        if (!Intrinsics.areEqual(layoutNode, this.lookaheadRoot)) {
            this.lookaheadRoot = layoutNode;
            if (layoutNode != null) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
                if (layoutNodeLayoutDelegate.lookaheadPassDelegate == null) {
                    layoutNodeLayoutDelegate.lookaheadPassDelegate = new LayoutNodeLayoutDelegate.LookaheadPassDelegate();
                }
                NodeChain nodeChain = this.nodes;
                NodeCoordinator nodeCoordinator = nodeChain.innerCoordinator.wrapped;
                for (NodeCoordinator nodeCoordinator2 = nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                    nodeCoordinator2.ensureLookaheadDelegateCreated();
                }
            }
            invalidateMeasurements$ui_release();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public final void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.measurePolicy, value)) {
            this.measurePolicy = value;
            IntrinsicsPolicy intrinsicsPolicy = this.intrinsicsPolicy;
            intrinsicsPolicy.getClass();
            intrinsicsPolicy.measurePolicyState$delegate.setValue(value);
            invalidateMeasurements$ui_release();
        }
    }

    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v8, types: [androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.node.ComposeUiNode
    public final void setModifier(Modifier value) {
        boolean z;
        boolean z2;
        int r5;
        boolean z3;
        InnerNodeCoordinator innerNodeCoordinator;
        boolean z4;
        boolean z5;
        ?? r1;
        MutableVector<Modifier.Element> mutableVector;
        boolean z6;
        boolean z7;
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.isVirtual && this.modifier != Modifier.Companion.$$INSTANCE) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.modifier = value;
            NodeChain nodeChain = this.nodes;
            nodeChain.getClass();
            Modifier.Node node = nodeChain.head;
            NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
            if (node != nodeChainKt$SentinelHead$1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                node.parent = nodeChainKt$SentinelHead$1;
                nodeChainKt$SentinelHead$1.child = node;
                MutableVector<Modifier.Element> mutableVector2 = nodeChain.current;
                if (mutableVector2 != null) {
                    r5 = mutableVector2.size;
                } else {
                    r5 = 0;
                }
                MutableVector<Modifier.Element> mutableVector3 = nodeChain.buffer;
                if (mutableVector3 == null) {
                    mutableVector3 = new MutableVector<>(new Modifier.Element[16]);
                }
                final MutableVector<Modifier.Element> mutableVector4 = mutableVector3;
                int r6 = mutableVector4.size;
                if (r6 < 16) {
                    r6 = 16;
                }
                MutableVector mutableVector5 = new MutableVector(new Modifier[r6]);
                mutableVector5.add(value);
                while (mutableVector5.isNotEmpty()) {
                    Modifier modifier = (Modifier) mutableVector5.removeAt(mutableVector5.size - 1);
                    if (modifier instanceof CombinedModifier) {
                        CombinedModifier combinedModifier = (CombinedModifier) modifier;
                        mutableVector5.add(combinedModifier.inner);
                        mutableVector5.add(combinedModifier.outer);
                    } else if (modifier instanceof Modifier.Element) {
                        mutableVector4.add(modifier);
                    } else {
                        modifier.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.node.NodeChainKt$fillVector$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(Modifier.Element element) {
                                Modifier.Element it = element;
                                Intrinsics.checkNotNullParameter(it, "it");
                                mutableVector4.add(it);
                                return Boolean.TRUE;
                            }
                        });
                    }
                }
                int r12 = mutableVector4.size;
                Modifier.Node node2 = nodeChain.tail;
                LayoutNode layoutNode = nodeChain.layoutNode;
                if (r12 == r5) {
                    Modifier.Node node3 = nodeChainKt$SentinelHead$1.child;
                    int r7 = 0;
                    while (true) {
                        if (node3 == null || r7 >= r5) {
                            break;
                        }
                        if (mutableVector2 != null) {
                            Modifier.Element element = mutableVector2.content[r7];
                            Modifier.Element element2 = mutableVector4.content[r7];
                            int actionForModifiers = NodeChainKt.actionForModifiers(element, element2);
                            if (actionForModifiers != 0) {
                                if (actionForModifiers == 1) {
                                    NodeChain.updateNode(element, element2, node3);
                                }
                                node3 = node3.child;
                                r7++;
                            } else {
                                node3 = node3.parent;
                                break;
                            }
                        } else {
                            throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
                        }
                    }
                    Modifier.Node node4 = node3;
                    if (r7 < r5) {
                        if (mutableVector2 != null) {
                            if (node4 != null) {
                                z3 = false;
                                nodeChain.structuralUpdate(r7, mutableVector2, mutableVector4, node4, layoutNode.isAttached());
                                z5 = true;
                                r1 = z3;
                            } else {
                                throw new IllegalStateException("structuralUpdate requires a non-null tail".toString());
                            }
                        } else {
                            throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
                        }
                    } else {
                        z4 = false;
                        z5 = false;
                        r1 = z4;
                    }
                } else {
                    z3 = false;
                    z3 = false;
                    z3 = false;
                    z4 = false;
                    if (!layoutNode.isAttached() && r5 == 0) {
                        Modifier.Node node5 = nodeChainKt$SentinelHead$1;
                        for (int r3 = 0; r3 < mutableVector4.size; r3++) {
                            node5 = NodeChain.createAndInsertNodeAsChild(mutableVector4.content[r3], node5);
                        }
                        int r52 = 0;
                        for (Modifier.Node node6 = node2.parent; node6 != null && node6 != NodeChainKt.SentinelHead; node6 = node6.parent) {
                            r52 |= node6.kindSet;
                            node6.aggregateChildKindSet = r52;
                        }
                    } else if (mutableVector4.size == 0) {
                        if (mutableVector2 != null) {
                            Modifier.Node node7 = nodeChainKt$SentinelHead$1.child;
                            for (int r53 = 0; node7 != null && r53 < mutableVector2.size; r53++) {
                                node7 = NodeChain.detachAndRemoveNode(node7).child;
                            }
                            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                            if (parent$ui_release != null) {
                                innerNodeCoordinator = parent$ui_release.nodes.innerCoordinator;
                            } else {
                                innerNodeCoordinator = null;
                            }
                            InnerNodeCoordinator innerNodeCoordinator2 = nodeChain.innerCoordinator;
                            innerNodeCoordinator2.wrappedBy = innerNodeCoordinator;
                            nodeChain.outerCoordinator = innerNodeCoordinator2;
                            z5 = false;
                            r1 = z4;
                        } else {
                            throw new IllegalStateException("expected prior modifier list to be non-empty".toString());
                        }
                    } else {
                        if (mutableVector2 == null) {
                            mutableVector2 = new MutableVector<>(new Modifier.Element[16]);
                        }
                        nodeChain.structuralUpdate(0, mutableVector2, mutableVector4, nodeChainKt$SentinelHead$1, layoutNode.isAttached());
                    }
                    z5 = true;
                    r1 = z3;
                }
                nodeChain.current = mutableVector4;
                if (mutableVector2 != null) {
                    mutableVector2.clear();
                    mutableVector = mutableVector2;
                } else {
                    mutableVector = r1;
                }
                nodeChain.buffer = mutableVector;
                NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
                if (nodeChainKt$SentinelHead$1 == nodeChainKt$SentinelHead$12) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    Modifier.Node node8 = nodeChainKt$SentinelHead$12.child;
                    if (node8 != null) {
                        node2 = node8;
                    }
                    node2.parent = r1;
                    nodeChainKt$SentinelHead$12.child = r1;
                    nodeChainKt$SentinelHead$12.aggregateChildKindSet = -1;
                    nodeChainKt$SentinelHead$12.coordinator = r1;
                    if (node2 != nodeChainKt$SentinelHead$12) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        nodeChain.head = node2;
                        if (z5) {
                            nodeChain.syncCoordinators();
                        }
                        this.layoutDelegate.updateParentData();
                        if (nodeChain.m460hasH91voCI$ui_release(DfuBaseService.ERROR_REMOTE_TYPE_SECURE) && this.lookaheadRoot == null) {
                            setLookaheadRoot(this);
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException("trimChain did not update the head".toString());
                }
                throw new IllegalStateException("trimChain called on already trimmed chain".toString());
            }
            throw new IllegalStateException("padChain called on already padded chain".toString());
        }
        throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void setViewConfiguration(ViewConfiguration value) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.viewConfiguration, value)) {
            this.viewConfiguration = value;
            Modifier.Node node = this.nodes.head;
            if ((node.aggregateChildKindSet & 16) != 0) {
                while (node != null) {
                    if ((node.kindSet & 16) != 0) {
                        DelegatingNode delegatingNode = node;
                        ?? r3 = 0;
                        while (delegatingNode != 0) {
                            if (delegatingNode instanceof PointerInputModifierNode) {
                                ((PointerInputModifierNode) delegatingNode).onViewConfigurationChange();
                            } else {
                                if ((delegatingNode.kindSet & 16) != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z && (delegatingNode instanceof DelegatingNode)) {
                                    Modifier.Node node2 = delegatingNode.delegate;
                                    int r7 = 0;
                                    delegatingNode = delegatingNode;
                                    r3 = r3;
                                    while (node2 != null) {
                                        if ((node2.kindSet & 16) != 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            r7++;
                                            r3 = r3;
                                            if (r7 == 1) {
                                                delegatingNode = node2;
                                            } else {
                                                if (r3 == 0) {
                                                    r3 = new MutableVector(new Modifier.Node[16]);
                                                }
                                                if (delegatingNode != 0) {
                                                    r3.add(delegatingNode);
                                                    delegatingNode = 0;
                                                }
                                                r3.add(node2);
                                            }
                                        }
                                        node2 = node2.child;
                                        delegatingNode = delegatingNode;
                                        r3 = r3;
                                    }
                                    if (r7 == 1) {
                                    }
                                }
                            }
                            delegatingNode = DelegatableNodeKt.access$pop(r3);
                        }
                    }
                    if ((node.aggregateChildKindSet & 16) != 0) {
                        node = node.child;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + this.measurePolicy;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0 && this.unfoldedVirtualChildrenListDirty) {
            int r0 = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16]);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> mutableVector2 = this._foldedChildren.vector;
            int r3 = mutableVector2.size;
            if (r3 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector2.content;
                do {
                    LayoutNode layoutNode = layoutNodeArr[r0];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.size, layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    r0++;
                } while (r0 < r3);
            }
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.childDelegatesDirty = true;
            }
        }
    }

    public LayoutNode(boolean z, int r3, int r4) {
        this((r3 & 1) != 0 ? false : z, (r3 & 2) != 0 ? SemanticsModifierKt.lastIdentifier.addAndGet(1) : 0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.compose.ui.node.LayoutNode$_foldedChildren$1] */
    public LayoutNode(boolean z, int r4) {
        this.isVirtual = z;
        this.semanticsId = r4;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16]), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNode.this.layoutDelegate;
                layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                if (lookaheadPassDelegate != null) {
                    lookaheadPassDelegate.childDelegatesDirty = true;
                }
                return Unit.INSTANCE;
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16]);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = LayoutNodeKt.DefaultDensity;
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        CompositionLocalMap.Companion.getClass();
        this.compositionLocalMap = CompositionLocalMap.Companion.Empty;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion.$$INSTANCE;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public final void setCompositeKeyHash() {
    }
}
