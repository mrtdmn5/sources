package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNodeLayoutDelegate.kt */
/* loaded from: classes.dex */
public final class LayoutNodeLayoutDelegate {
    public int childrenAccessingCoordinatesDuringPlacement;
    public boolean coordinatesAccessedDuringModifierPlacement;
    public boolean coordinatesAccessedDuringPlacement;
    public final LayoutNode layoutNode;
    public boolean layoutPending;
    public boolean layoutPendingForAlignment;
    public LayoutNode.LayoutState layoutState;
    public boolean lookaheadLayoutPending;
    public boolean lookaheadLayoutPendingForAlignment;
    public boolean lookaheadMeasurePending;
    public LookaheadPassDelegate lookaheadPassDelegate;
    public final MeasurePassDelegate measurePassDelegate;
    public boolean measurePending;
    public int nextChildLookaheadPlaceOrder;
    public int nextChildPlaceOrder;

    /* compiled from: LayoutNodeLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public final class LookaheadPassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        public boolean duringAlignmentLinesQuery;
        public boolean isPlaced;
        public Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        public boolean layingOutChildren;
        public Constraints lookaheadConstraints;
        public Object parentData;
        public boolean placedOnce;
        public boolean relayoutWithoutParentInProgress;
        public int previousPlaceOrder = Integer.MAX_VALUE;
        public int placeOrder = Integer.MAX_VALUE;
        public LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        public long lastPosition = IntOffset.Zero;
        public final LookaheadAlignmentLines alignmentLines = new LookaheadAlignmentLines(this);
        public final MutableVector<LookaheadPassDelegate> _childDelegates = new MutableVector<>(new LookaheadPassDelegate[16]);
        public boolean childDelegatesDirty = true;
        public boolean parentDataDirty = true;

        /* compiled from: LayoutNodeLayoutDelegate.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] r0 = new int[LayoutNode.LayoutState.values().length];
                try {
                    r0[LayoutNode.LayoutState.LookaheadMeasuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[LayoutNode.LayoutState.Measuring.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    r0[LayoutNode.LayoutState.LayingOut.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r0[LayoutNode.LayoutState.LookaheadLayingOut.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = r0;
                int[] r02 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    r02[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    r02[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$1 = r02;
            }
        }

        public LookaheadPassDelegate() {
            this.parentData = LayoutNodeLayoutDelegate.this.measurePassDelegate.parentData;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int r1 = mutableVector.size;
            if (r1 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r2 = 0;
                do {
                    LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[r2].layoutDelegate.lookaheadPassDelegate;
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    block.invoke(lookaheadPassDelegate);
                    r2++;
                } while (r2 < r1);
            }
        }

        @Override // androidx.compose.ui.layout.Measured
        public final int get(AlignmentLine alignmentLine) {
            LayoutNode.LayoutState layoutState;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState2 = null;
            if (parent$ui_release != null) {
                layoutState = parent$ui_release.layoutDelegate.layoutState;
            } else {
                layoutState = null;
            }
            LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.LookaheadMeasuring;
            LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
            if (layoutState == layoutState3) {
                lookaheadAlignmentLines.usedDuringParentMeasurement = true;
            } else {
                LayoutNode parent$ui_release2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState2 = parent$ui_release2.layoutDelegate.layoutState;
                }
                if (layoutState2 == LayoutNode.LayoutState.LookaheadLayingOut) {
                    lookaheadAlignmentLines.usedDuringParentLayout = true;
                }
            }
            this.duringAlignmentLinesQuery = true;
            LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            int r7 = lookaheadDelegate.get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return r7;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final InnerNodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.nodes.innerCoordinator;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getMeasuredHeight() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getMeasuredWidth() {
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && (layoutNodeLayoutDelegate = parent$ui_release.layoutDelegate) != null) {
                return layoutNodeLayoutDelegate.lookaheadPassDelegate;
            }
            return null;
        }

        @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public final Object getParentData() {
            return this.parentData;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final boolean isPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void layoutChildren() {
            MutableVector<LayoutNode> mutableVector;
            int r6;
            this.layingOutChildren = true;
            LookaheadAlignmentLines lookaheadAlignmentLines = this.alignmentLines;
            lookaheadAlignmentLines.recalculateQueryOwner();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            boolean z = layoutNodeLayoutDelegate.lookaheadLayoutPending;
            LayoutNode node = layoutNodeLayoutDelegate.layoutNode;
            if (z && (r6 = (mutableVector = node.get_children$ui_release()).size) > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r7 = 0;
                do {
                    LayoutNode layoutNode = layoutNodeArr[r7];
                    if (layoutNode.layoutDelegate.lookaheadMeasurePending && layoutNode.getMeasuredByParentInLookahead$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        Constraints constraints = this.lookaheadConstraints;
                        Intrinsics.checkNotNull(constraints);
                        if (lookaheadPassDelegate.m451remeasureBRTryo0(constraints.value)) {
                            LayoutNode.requestLookaheadRemeasure$ui_release$default(node, false, 3);
                        }
                    }
                    r7++;
                } while (r7 < r6);
            }
            final LookaheadDelegate lookaheadDelegate = getInnerCoordinator().lookaheadDelegate;
            Intrinsics.checkNotNull(lookaheadDelegate);
            if (layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !lookaheadDelegate.isPlacingForAlignment && layoutNodeLayoutDelegate.lookaheadLayoutPending)) {
                layoutNodeLayoutDelegate.lookaheadLayoutPending = false;
                LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
                layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
                Owner requireOwner = LayoutNodeKt.requireOwner(node);
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
                OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate2 = LayoutNodeLayoutDelegate.LookaheadPassDelegate.this;
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = LayoutNodeLayoutDelegate.this;
                        int r2 = 0;
                        layoutNodeLayoutDelegate2.nextChildLookaheadPlaceOrder = 0;
                        MutableVector<LayoutNode> mutableVector2 = layoutNodeLayoutDelegate2.layoutNode.get_children$ui_release();
                        int r3 = mutableVector2.size;
                        if (r3 > 0) {
                            LayoutNode[] layoutNodeArr2 = mutableVector2.content;
                            int r5 = 0;
                            do {
                                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate3 = layoutNodeArr2[r5].layoutDelegate.lookaheadPassDelegate;
                                Intrinsics.checkNotNull(lookaheadPassDelegate3);
                                lookaheadPassDelegate3.previousPlaceOrder = lookaheadPassDelegate3.placeOrder;
                                lookaheadPassDelegate3.placeOrder = Integer.MAX_VALUE;
                                if (lookaheadPassDelegate3.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                    lookaheadPassDelegate3.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                                }
                                r5++;
                            } while (r5 < r3);
                        }
                        lookaheadPassDelegate2.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                AlignmentLinesOwner child = alignmentLinesOwner;
                                Intrinsics.checkNotNullParameter(child, "child");
                                child.getAlignmentLines().usedDuringParentLayout = false;
                                return Unit.INSTANCE;
                            }
                        });
                        lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
                        MutableVector<LayoutNode> mutableVector3 = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                        int r32 = mutableVector3.size;
                        if (r32 > 0) {
                            LayoutNode[] layoutNodeArr3 = mutableVector3.content;
                            do {
                                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate4 = layoutNodeArr3[r2].layoutDelegate.lookaheadPassDelegate;
                                Intrinsics.checkNotNull(lookaheadPassDelegate4);
                                int r62 = lookaheadPassDelegate4.previousPlaceOrder;
                                int r72 = lookaheadPassDelegate4.placeOrder;
                                if (r62 != r72 && r72 == Integer.MAX_VALUE) {
                                    lookaheadPassDelegate4.markSubtreeAsNotPlaced();
                                }
                                r2++;
                            } while (r2 < r32);
                        }
                        lookaheadPassDelegate2.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                AlignmentLinesOwner child = alignmentLinesOwner;
                                Intrinsics.checkNotNullParameter(child, "child");
                                child.getAlignmentLines().previousUsedDuringParentLayout = child.getAlignmentLines().usedDuringParentLayout;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                Intrinsics.checkNotNullParameter(node, "node");
                if (node.lookaheadRoot != null) {
                    snapshotObserver.observeReads$ui_release(node, snapshotObserver.onCommitAffectingLookaheadLayout, function0);
                } else {
                    snapshotObserver.observeReads$ui_release(node, snapshotObserver.onCommitAffectingLayout, function0);
                }
                layoutNodeLayoutDelegate.layoutState = layoutState;
                if (layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement && lookaheadDelegate.isPlacingForAlignment) {
                    requestLayout();
                }
                layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = false;
            }
            if (lookaheadAlignmentLines.usedDuringParentLayout) {
                lookaheadAlignmentLines.previousUsedDuringParentLayout = true;
            }
            if (lookaheadAlignmentLines.dirty && lookaheadAlignmentLines.getRequired$ui_release()) {
                lookaheadAlignmentLines.recalculate();
            }
            this.layingOutChildren = false;
        }

        public final void markNodeAndSubtreeAsPlaced() {
            boolean z = this.isPlaced;
            this.isPlaced = true;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (!z && layoutNodeLayoutDelegate.lookaheadMeasurePending) {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, true, 2);
            }
            MutableVector<LayoutNode> mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui_release();
            int r1 = mutableVector.size;
            if (r1 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r2 = 0;
                do {
                    LayoutNode layoutNode = layoutNodeArr[r2];
                    if (layoutNode.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNode.layoutDelegate.lookaheadPassDelegate;
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        lookaheadPassDelegate.markNodeAndSubtreeAsPlaced();
                        LayoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                    }
                    r2++;
                } while (r2 < r1);
            }
        }

        public final void markSubtreeAsNotPlaced() {
            if (this.isPlaced) {
                int r0 = 0;
                this.isPlaced = false;
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int r2 = mutableVector.size;
                if (r2 > 0) {
                    LayoutNode[] layoutNodeArr = mutableVector.content;
                    do {
                        LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[r0].layoutDelegate.lookaheadPassDelegate;
                        Intrinsics.checkNotNull(lookaheadPassDelegate);
                        lookaheadPassDelegate.markSubtreeAsNotPlaced();
                        r0++;
                    } while (r0 < r2);
                }
            }
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicHeight(int r2) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicHeight(r2);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicWidth(int r2) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.maxIntrinsicWidth(r2);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public final Placeable mo421measureBRTryo0(long j) {
            boolean z;
            LayoutNode.UsageByParent usageByParent;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                if (this.measuredByParent != LayoutNode.UsageByParent.NotUsed && !layoutNode.canMultiMeasure) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui_release.layoutDelegate;
                    int r2 = WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate2.layoutState.ordinal()];
                    if (r2 != 1 && r2 != 2) {
                        if (r2 != 3 && r2 != 4) {
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeLayoutDelegate2.layoutState);
                        }
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    } else {
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    }
                    this.measuredByParent = usageByParent;
                } else {
                    throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
                }
            } else {
                this.measuredByParent = LayoutNode.UsageByParent.NotUsed;
            }
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            if (layoutNode2.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                layoutNode2.clearSubtreeIntrinsicsUsage$ui_release();
            }
            m451remeasureBRTryo0(j);
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicHeight(int r2) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicHeight(r2);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicWidth(int r2) {
            onIntrinsicsQueried();
            LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return lookaheadDelegate.minIntrinsicWidth(r2);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int r1;
            boolean z;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0 && (r1 = (mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui_release()).size) > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r3 = 0;
                do {
                    LayoutNode layoutNode = layoutNodeArr[r3];
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                    if (!layoutNodeLayoutDelegate2.coordinatesAccessedDuringPlacement && !layoutNodeLayoutDelegate2.coordinatesAccessedDuringModifierPlacement) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && !layoutNodeLayoutDelegate2.layoutPending) {
                        layoutNode.requestLookaheadRelayout$ui_release(false);
                    }
                    LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate2.lookaheadPassDelegate;
                    if (lookaheadPassDelegate != null) {
                        lookaheadPassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    r3++;
                } while (r3 < r1);
            }
        }

        public final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 3);
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null && layoutNode.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                int r2 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.layoutDelegate.layoutState.ordinal()];
                if (r2 != 2) {
                    if (r2 != 3) {
                        usageByParent = parent$ui_release.intrinsicsUsageByParent;
                    } else {
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    }
                } else {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                }
                Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
                layoutNode.intrinsicsUsageByParent = usageByParent;
            }
        }

        public final void onNodePlaced$ui_release() {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
            LayoutNode.LayoutState layoutState;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (!this.isPlaced) {
                markNodeAndSubtreeAsPlaced();
            }
            boolean z = false;
            if (parent$ui_release != null) {
                if (!this.relayoutWithoutParentInProgress && ((layoutState = (layoutNodeLayoutDelegate = parent$ui_release.layoutDelegate).layoutState) == LayoutNode.LayoutState.LayingOut || layoutState == LayoutNode.LayoutState.LookaheadLayingOut)) {
                    if (this.placeOrder == Integer.MAX_VALUE) {
                        z = true;
                    }
                    if (z) {
                        int r1 = layoutNodeLayoutDelegate.nextChildLookaheadPlaceOrder;
                        this.placeOrder = r1;
                        layoutNodeLayoutDelegate.nextChildLookaheadPlaceOrder = r1 + 1;
                    } else {
                        throw new IllegalStateException("Place was called on a node which was placed already".toString());
                    }
                }
            } else {
                this.placeOrder = 0;
            }
            layoutChildren();
        }

        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public final void mo422placeAtf8xVGno(final long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.LookaheadLayingOut;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            layoutNodeLayoutDelegate.layoutState = layoutState;
            this.placedOnce = true;
            if (!IntOffset.m589equalsimpl0(j, this.lastPosition)) {
                if (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement) {
                    layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LayoutNode node = layoutNodeLayoutDelegate.layoutNode;
            Owner requireOwner = LayoutNodeKt.requireOwner(node);
            if (!layoutNodeLayoutDelegate.lookaheadLayoutPending && this.isPlaced) {
                onNodePlaced$ui_release();
            } else {
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
                this.alignmentLines.usedByModifierLayout = false;
                OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                        LookaheadDelegate lookaheadDelegate = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                        Intrinsics.checkNotNull(lookaheadDelegate);
                        Placeable.PlacementScope.m433place70tqf50$default(companion, lookaheadDelegate, j);
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                Intrinsics.checkNotNullParameter(node, "node");
                if (node.lookaheadRoot != null) {
                    snapshotObserver.observeReads$ui_release(node, snapshotObserver.onCommitAffectingLayoutModifierInLookahead, function0);
                } else {
                    snapshotObserver.observeReads$ui_release(node, snapshotObserver.onCommitAffectingLayoutModifier, function0);
                }
            }
            this.lastPosition = j;
            this.lastLayerBlock = function1;
            layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: remeasure-BRTryo0 */
        public final boolean m451remeasureBRTryo0(final long j) {
            boolean z;
            boolean z2;
            boolean m559equalsimpl0;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            if (!layoutNode.canMultiMeasure && (parent$ui_release == null || !parent$ui_release.canMultiMeasure)) {
                z = false;
            } else {
                z = true;
            }
            layoutNode.canMultiMeasure = z;
            if (!layoutNode.layoutDelegate.lookaheadMeasurePending) {
                Constraints constraints = this.lookaheadConstraints;
                if (constraints == null) {
                    m559equalsimpl0 = false;
                } else {
                    m559equalsimpl0 = Constraints.m559equalsimpl0(constraints.value, j);
                }
                if (m559equalsimpl0) {
                    Owner owner = layoutNode.owner;
                    if (owner != null) {
                        owner.forceMeasureTheSubtree(layoutNode, true);
                    }
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                    return false;
                }
            }
            this.lookaheadConstraints = new Constraints(j);
            this.alignmentLines.usedByModifierMeasurement = false;
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    AlignmentLinesOwner it = alignmentLinesOwner;
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.getAlignmentLines().usedDuringParentMeasurement = false;
                    return Unit.INSTANCE;
                }
            });
            LookaheadDelegate lookaheadDelegate = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
            if (lookaheadDelegate != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                long IntSize = IntSizeKt.IntSize(lookaheadDelegate.width, lookaheadDelegate.height);
                layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LookaheadMeasuring;
                layoutNodeLayoutDelegate.lookaheadMeasurePending = false;
                OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver();
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performLookaheadMeasure$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LookaheadDelegate lookaheadDelegate2 = LayoutNodeLayoutDelegate.this.getOuterCoordinator().getLookaheadDelegate();
                        Intrinsics.checkNotNull(lookaheadDelegate2);
                        lookaheadDelegate2.mo421measureBRTryo0(j);
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                if (layoutNode.lookaheadRoot != null) {
                    snapshotObserver.observeReads$ui_release(layoutNode, snapshotObserver.onCommitAffectingLookaheadMeasure, function0);
                } else {
                    snapshotObserver.observeReads$ui_release(layoutNode, snapshotObserver.onCommitAffectingMeasure, function0);
                }
                layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
                if (LayoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNode)) {
                    layoutNodeLayoutDelegate.layoutPending = true;
                    layoutNodeLayoutDelegate.layoutPendingForAlignment = true;
                } else {
                    layoutNodeLayoutDelegate.measurePending = true;
                }
                layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.Idle;
                m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(lookaheadDelegate.width, lookaheadDelegate.height));
                if (((int) (IntSize >> 32)) != lookaheadDelegate.width || IntSize.m593getHeightimpl(IntSize) != lookaheadDelegate.height) {
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("Lookahead result from lookaheadRemeasure cannot be null".toString());
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void requestLayout() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNode$Companion$ErrorMeasurePolicy$1 layoutNode$Companion$ErrorMeasurePolicy$1 = LayoutNode.ErrorMeasurePolicy;
            layoutNode.requestLookaheadRelayout$ui_release(false);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void requestMeasure() {
            LayoutNode.requestLookaheadRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 3);
        }
    }

    /* compiled from: LayoutNodeLayoutDelegate.kt */
    /* loaded from: classes.dex */
    public final class MeasurePassDelegate extends Placeable implements Measurable, AlignmentLinesOwner {
        public boolean duringAlignmentLinesQuery;
        public boolean isPlaced;
        public Function1<? super GraphicsLayerScope, Unit> lastLayerBlock;
        public float lastZIndex;
        public boolean layingOutChildren;
        public boolean measuredOnce;
        public Object parentData;
        public boolean placedOnce;
        public boolean relayoutWithoutParentInProgress;
        public float zIndex;
        public int previousPlaceOrder = Integer.MAX_VALUE;
        public int placeOrder = Integer.MAX_VALUE;
        public LayoutNode.UsageByParent measuredByParent = LayoutNode.UsageByParent.NotUsed;
        public long lastPosition = IntOffset.Zero;
        public boolean parentDataDirty = true;
        public final LayoutNodeAlignmentLines alignmentLines = new LayoutNodeAlignmentLines(this);
        public final MutableVector<MeasurePassDelegate> _childDelegates = new MutableVector<>(new MeasurePassDelegate[16]);
        public boolean childDelegatesDirty = true;

        /* compiled from: LayoutNodeLayoutDelegate.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                int[] r0 = new int[LayoutNode.LayoutState.values().length];
                try {
                    r0[LayoutNode.LayoutState.Measuring.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    r0[LayoutNode.LayoutState.LayingOut.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = r0;
                int[] r02 = new int[LayoutNode.UsageByParent.values().length];
                try {
                    r02[LayoutNode.UsageByParent.InMeasureBlock.ordinal()] = 1;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    r02[LayoutNode.UsageByParent.InLayoutBlock.ordinal()] = 2;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$1 = r02;
            }
        }

        public MeasurePassDelegate() {
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void forEachChildAlignmentLinesOwner(Function1<? super AlignmentLinesOwner, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
            int r1 = mutableVector.size;
            if (r1 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r2 = 0;
                do {
                    block.invoke(layoutNodeArr[r2].layoutDelegate.measurePassDelegate);
                    r2++;
                } while (r2 < r1);
            }
        }

        @Override // androidx.compose.ui.layout.Measured
        public final int get(AlignmentLine alignmentLine) {
            LayoutNode.LayoutState layoutState;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
            LayoutNode.LayoutState layoutState2 = null;
            if (parent$ui_release != null) {
                layoutState = parent$ui_release.layoutDelegate.layoutState;
            } else {
                layoutState = null;
            }
            LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
            LayoutNodeAlignmentLines layoutNodeAlignmentLines = this.alignmentLines;
            if (layoutState == layoutState3) {
                layoutNodeAlignmentLines.usedDuringParentMeasurement = true;
            } else {
                LayoutNode parent$ui_release2 = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutState2 = parent$ui_release2.layoutDelegate.layoutState;
                }
                if (layoutState2 == LayoutNode.LayoutState.LayingOut) {
                    layoutNodeAlignmentLines.usedDuringParentLayout = true;
                }
            }
            this.duringAlignmentLinesQuery = true;
            int r7 = layoutNodeLayoutDelegate.getOuterCoordinator().get(alignmentLine);
            this.duringAlignmentLinesQuery = false;
            return r7;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final AlignmentLines getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final InnerNodeCoordinator getInnerCoordinator() {
            return LayoutNodeLayoutDelegate.this.layoutNode.nodes.innerCoordinator;
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getMeasuredHeight() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredHeight();
        }

        @Override // androidx.compose.ui.layout.Placeable
        public final int getMeasuredWidth() {
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().getMeasuredWidth();
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final AlignmentLinesOwner getParentAlignmentLinesOwner() {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
            LayoutNode parent$ui_release = LayoutNodeLayoutDelegate.this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null && (layoutNodeLayoutDelegate = parent$ui_release.layoutDelegate) != null) {
                return layoutNodeLayoutDelegate.measurePassDelegate;
            }
            return null;
        }

        @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
        public final Object getParentData() {
            return this.parentData;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final boolean isPlaced() {
            return this.isPlaced;
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void layoutChildren() {
            MutableVector<LayoutNode> mutableVector;
            int r6;
            this.layingOutChildren = true;
            LayoutNodeAlignmentLines layoutNodeAlignmentLines = this.alignmentLines;
            layoutNodeAlignmentLines.recalculateQueryOwner();
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            boolean z = layoutNodeLayoutDelegate.layoutPending;
            final LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            if (z && (r6 = (mutableVector = layoutNode.get_children$ui_release()).size) > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r7 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArr[r7];
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode2.layoutDelegate;
                    if (layoutNodeLayoutDelegate2.measurePending && layoutNodeLayoutDelegate2.measurePassDelegate.measuredByParent == LayoutNode.UsageByParent.InMeasureBlock && LayoutNode.m446remeasure_Sx5XlM$ui_release$default(layoutNode2)) {
                        LayoutNode.requestRemeasure$ui_release$default(layoutNode, false, 3);
                    }
                    r7++;
                } while (r7 < r6);
            }
            if (layoutNodeLayoutDelegate.layoutPendingForAlignment || (!this.duringAlignmentLinesQuery && !getInnerCoordinator().isPlacingForAlignment && layoutNodeLayoutDelegate.layoutPending)) {
                layoutNodeLayoutDelegate.layoutPending = false;
                LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
                layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.LayingOut;
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(false);
                OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver();
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = LayoutNodeLayoutDelegate.MeasurePassDelegate.this;
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate3 = LayoutNodeLayoutDelegate.this;
                        int r2 = 0;
                        layoutNodeLayoutDelegate3.nextChildPlaceOrder = 0;
                        MutableVector<LayoutNode> mutableVector2 = layoutNodeLayoutDelegate3.layoutNode.get_children$ui_release();
                        int r3 = mutableVector2.size;
                        if (r3 > 0) {
                            LayoutNode[] layoutNodeArr2 = mutableVector2.content;
                            int r5 = 0;
                            do {
                                LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate2 = layoutNodeArr2[r5].layoutDelegate.measurePassDelegate;
                                measurePassDelegate2.previousPlaceOrder = measurePassDelegate2.placeOrder;
                                measurePassDelegate2.placeOrder = Integer.MAX_VALUE;
                                if (measurePassDelegate2.measuredByParent == LayoutNode.UsageByParent.InLayoutBlock) {
                                    measurePassDelegate2.measuredByParent = LayoutNode.UsageByParent.NotUsed;
                                }
                                r5++;
                            } while (r5 < r3);
                        }
                        measurePassDelegate.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                AlignmentLinesOwner it = alignmentLinesOwner;
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.getAlignmentLines().usedDuringParentLayout = false;
                                return Unit.INSTANCE;
                            }
                        });
                        layoutNode.nodes.innerCoordinator.getMeasureResult$ui_release().placeChildren();
                        LayoutNode layoutNode3 = LayoutNodeLayoutDelegate.this.layoutNode;
                        MutableVector<LayoutNode> mutableVector3 = layoutNode3.get_children$ui_release();
                        int r52 = mutableVector3.size;
                        if (r52 > 0) {
                            LayoutNode[] layoutNodeArr3 = mutableVector3.content;
                            do {
                                LayoutNode layoutNode4 = layoutNodeArr3[r2];
                                if (layoutNode4.layoutDelegate.measurePassDelegate.previousPlaceOrder != layoutNode4.getPlaceOrder$ui_release()) {
                                    layoutNode3.onZSortedChildrenInvalidated$ui_release();
                                    layoutNode3.invalidateLayer$ui_release();
                                    if (layoutNode4.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                                        layoutNode4.layoutDelegate.measurePassDelegate.markSubtreeAsNotPlaced();
                                    }
                                }
                                r2++;
                            } while (r2 < r52);
                        }
                        measurePassDelegate.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildren$1$1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                                AlignmentLinesOwner it = alignmentLinesOwner;
                                Intrinsics.checkNotNullParameter(it, "it");
                                it.getAlignmentLines().previousUsedDuringParentLayout = it.getAlignmentLines().usedDuringParentLayout;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                snapshotObserver.observeReads$ui_release(layoutNode, snapshotObserver.onCommitAffectingLayout, function0);
                layoutNodeLayoutDelegate.layoutState = layoutState;
                if (getInnerCoordinator().isPlacingForAlignment && layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement) {
                    requestLayout();
                }
                layoutNodeLayoutDelegate.layoutPendingForAlignment = false;
            }
            if (layoutNodeAlignmentLines.usedDuringParentLayout) {
                layoutNodeAlignmentLines.previousUsedDuringParentLayout = true;
            }
            if (layoutNodeAlignmentLines.dirty && layoutNodeAlignmentLines.getRequired$ui_release()) {
                layoutNodeAlignmentLines.recalculate();
            }
            this.layingOutChildren = false;
        }

        public final void markNodeAndSubtreeAsPlaced() {
            boolean z = this.isPlaced;
            this.isPlaced = true;
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            if (!z) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = layoutNode.layoutDelegate;
                if (layoutNodeLayoutDelegate.measurePending) {
                    LayoutNode.requestRemeasure$ui_release$default(layoutNode, true, 2);
                } else if (layoutNodeLayoutDelegate.lookaheadMeasurePending) {
                    LayoutNode.requestLookaheadRemeasure$ui_release$default(layoutNode, true, 2);
                }
            }
            NodeChain nodeChain = layoutNode.nodes;
            NodeCoordinator nodeCoordinator = nodeChain.innerCoordinator.wrapped;
            for (NodeCoordinator nodeCoordinator2 = nodeChain.outerCoordinator; !Intrinsics.areEqual(nodeCoordinator2, nodeCoordinator) && nodeCoordinator2 != null; nodeCoordinator2 = nodeCoordinator2.wrapped) {
                if (nodeCoordinator2.lastLayerDrawingWasSkipped) {
                    nodeCoordinator2.invalidateLayer();
                }
            }
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            int r1 = mutableVector.size;
            if (r1 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r2 = 0;
                do {
                    LayoutNode layoutNode2 = layoutNodeArr[r2];
                    if (layoutNode2.getPlaceOrder$ui_release() != Integer.MAX_VALUE) {
                        layoutNode2.layoutDelegate.measurePassDelegate.markNodeAndSubtreeAsPlaced();
                        LayoutNode.rescheduleRemeasureOrRelayout$ui_release(layoutNode2);
                    }
                    r2++;
                } while (r2 < r1);
            }
        }

        public final void markSubtreeAsNotPlaced() {
            if (this.isPlaced) {
                int r0 = 0;
                this.isPlaced = false;
                MutableVector<LayoutNode> mutableVector = LayoutNodeLayoutDelegate.this.layoutNode.get_children$ui_release();
                int r2 = mutableVector.size;
                if (r2 > 0) {
                    LayoutNode[] layoutNodeArr = mutableVector.content;
                    do {
                        layoutNodeArr[r0].layoutDelegate.measurePassDelegate.markSubtreeAsNotPlaced();
                        r0++;
                    } while (r0 < r2);
                }
            }
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicHeight(int r2) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicHeight(r2);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicWidth(int r2) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().maxIntrinsicWidth(r2);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public final Placeable mo421measureBRTryo0(long j) {
            boolean z;
            LayoutNode.UsageByParent usageByParent;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode.UsageByParent usageByParent2 = layoutNode.intrinsicsUsageByParent;
            LayoutNode.UsageByParent usageByParent3 = LayoutNode.UsageByParent.NotUsed;
            if (usageByParent2 == usageByParent3) {
                layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
            }
            LayoutNode layoutNode2 = layoutNodeLayoutDelegate.layoutNode;
            if (LayoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNode2)) {
                this.measuredOnce = true;
                m431setMeasurementConstraintsBRTryo0(j);
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                Intrinsics.checkNotNullParameter(usageByParent3, "<set-?>");
                lookaheadPassDelegate.measuredByParent = usageByParent3;
                lookaheadPassDelegate.mo421measureBRTryo0(j);
            }
            LayoutNode parent$ui_release = layoutNode2.getParent$ui_release();
            if (parent$ui_release != null) {
                if (this.measuredByParent != usageByParent3 && !layoutNode2.canMultiMeasure) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui_release.layoutDelegate;
                    int r1 = WhenMappings.$EnumSwitchMapping$0[layoutNodeLayoutDelegate2.layoutState.ordinal()];
                    if (r1 != 1) {
                        if (r1 == 2) {
                            usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                        } else {
                            throw new IllegalStateException("Measurable could be only measured from the parent's measure or layout block. Parents state is " + layoutNodeLayoutDelegate2.layoutState);
                        }
                    } else {
                        usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                    }
                    this.measuredByParent = usageByParent;
                } else {
                    throw new IllegalStateException("measure() may not be called multiple times on the same Measurable. If you want to get the content size of the Measurable before calculating the final constraints, please use methods like minIntrinsicWidth()/maxIntrinsicWidth() and minIntrinsicHeight()/maxIntrinsicHeight()".toString());
                }
            } else {
                this.measuredByParent = usageByParent3;
            }
            m453remeasureBRTryo0(j);
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicHeight(int r2) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicHeight(r2);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicWidth(int r2) {
            onIntrinsicsQueried();
            return LayoutNodeLayoutDelegate.this.getOuterCoordinator().minIntrinsicWidth(r2);
        }

        public final void notifyChildrenUsingCoordinatesWhilePlacing() {
            MutableVector<LayoutNode> mutableVector;
            int r1;
            boolean z;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement > 0 && (r1 = (mutableVector = layoutNodeLayoutDelegate.layoutNode.get_children$ui_release()).size) > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r3 = 0;
                do {
                    LayoutNode layoutNode = layoutNodeArr[r3];
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNode.layoutDelegate;
                    if (!layoutNodeLayoutDelegate2.coordinatesAccessedDuringPlacement && !layoutNodeLayoutDelegate2.coordinatesAccessedDuringModifierPlacement) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && !layoutNodeLayoutDelegate2.layoutPending) {
                        layoutNode.requestRelayout$ui_release(false);
                    }
                    layoutNodeLayoutDelegate2.measurePassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
                    r3++;
                } while (r3 < r1);
            }
        }

        public final void onIntrinsicsQueried() {
            LayoutNode.UsageByParent usageByParent;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode.requestRemeasure$ui_release$default(layoutNodeLayoutDelegate.layoutNode, false, 3);
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null && layoutNode.intrinsicsUsageByParent == LayoutNode.UsageByParent.NotUsed) {
                int r2 = WhenMappings.$EnumSwitchMapping$0[parent$ui_release.layoutDelegate.layoutState.ordinal()];
                if (r2 != 1) {
                    if (r2 != 2) {
                        usageByParent = parent$ui_release.intrinsicsUsageByParent;
                    } else {
                        usageByParent = LayoutNode.UsageByParent.InLayoutBlock;
                    }
                } else {
                    usageByParent = LayoutNode.UsageByParent.InMeasureBlock;
                }
                Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
                layoutNode.intrinsicsUsageByParent = usageByParent;
            }
        }

        public final void onNodePlaced$ui_release() {
            boolean z;
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
            float f = getInnerCoordinator().zIndex;
            NodeChain nodeChain = layoutNodeLayoutDelegate.layoutNode.nodes;
            NodeCoordinator nodeCoordinator = nodeChain.outerCoordinator;
            while (nodeCoordinator != nodeChain.innerCoordinator) {
                Intrinsics.checkNotNull(nodeCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) nodeCoordinator;
                f += layoutModifierNodeCoordinator.zIndex;
                nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            }
            boolean z2 = false;
            if (f == this.zIndex) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                this.zIndex = f;
                if (parent$ui_release != null) {
                    parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                }
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
            }
            if (!this.isPlaced) {
                if (parent$ui_release != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
                markNodeAndSubtreeAsPlaced();
            }
            if (parent$ui_release != null) {
                if (!this.relayoutWithoutParentInProgress) {
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = parent$ui_release.layoutDelegate;
                    if (layoutNodeLayoutDelegate2.layoutState == LayoutNode.LayoutState.LayingOut) {
                        if (this.placeOrder == Integer.MAX_VALUE) {
                            z2 = true;
                        }
                        if (z2) {
                            int r1 = layoutNodeLayoutDelegate2.nextChildPlaceOrder;
                            this.placeOrder = r1;
                            layoutNodeLayoutDelegate2.nextChildPlaceOrder = r1 + 1;
                        } else {
                            throw new IllegalStateException("Place was called on a node which was placed already".toString());
                        }
                    }
                }
            } else {
                this.placeOrder = 0;
            }
            layoutChildren();
        }

        @Override // androidx.compose.ui.layout.Placeable
        /* renamed from: placeAt-f8xVGno */
        public final void mo422placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
            boolean m589equalsimpl0 = IntOffset.m589equalsimpl0(j, this.lastPosition);
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (!m589equalsimpl0) {
                if (layoutNodeLayoutDelegate.coordinatesAccessedDuringModifierPlacement || layoutNodeLayoutDelegate.coordinatesAccessedDuringPlacement) {
                    layoutNodeLayoutDelegate.layoutPending = true;
                }
                notifyChildrenUsingCoordinatesWhilePlacing();
            }
            if (LayoutNodeLayoutDelegate.isOutMostLookaheadRoot(layoutNodeLayoutDelegate.layoutNode)) {
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                LayoutNode parent$ui_release = layoutNodeLayoutDelegate.layoutNode.getParent$ui_release();
                if (parent$ui_release != null) {
                    parent$ui_release.layoutDelegate.nextChildLookaheadPlaceOrder = 0;
                }
                lookaheadPassDelegate.placeOrder = Integer.MAX_VALUE;
                Placeable.PlacementScope.place$default(companion, lookaheadPassDelegate, (int) (j >> 32), IntOffset.m590getYimpl(j));
            }
            m452placeOuterCoordinatorf8xVGno(j, f, function1);
        }

        /* renamed from: placeOuterCoordinator-f8xVGno */
        public final void m452placeOuterCoordinatorf8xVGno(final long j, final float f, final Function1<? super GraphicsLayerScope, Unit> function1) {
            LayoutNode.LayoutState layoutState = LayoutNode.LayoutState.LayingOut;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            layoutNodeLayoutDelegate.layoutState = layoutState;
            this.lastPosition = j;
            this.lastZIndex = f;
            this.lastLayerBlock = function1;
            this.placedOnce = true;
            Owner requireOwner = LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate.layoutNode);
            if (!layoutNodeLayoutDelegate.layoutPending && this.isPlaced) {
                NodeCoordinator outerCoordinator = layoutNodeLayoutDelegate.getOuterCoordinator();
                long j2 = outerCoordinator.apparentToRealOffset;
                outerCoordinator.m470placeSelff8xVGno(IntOffsetKt.IntOffset(((int) (j >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(j)), f, function1);
                onNodePlaced$ui_release();
            } else {
                this.alignmentLines.usedByModifierLayout = false;
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(false);
                OwnerSnapshotObserver snapshotObserver = requireOwner.getSnapshotObserver();
                LayoutNode node = layoutNodeLayoutDelegate.layoutNode;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                        long j3 = j;
                        float f2 = f;
                        Function1<GraphicsLayerScope, Unit> function12 = function1;
                        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate2 = layoutNodeLayoutDelegate;
                        if (function12 == null) {
                            NodeCoordinator outerCoordinator2 = layoutNodeLayoutDelegate2.getOuterCoordinator();
                            companion.getClass();
                            Placeable.PlacementScope.m432place70tqf50(outerCoordinator2, j3, f2);
                        } else {
                            NodeCoordinator outerCoordinator3 = layoutNodeLayoutDelegate2.getOuterCoordinator();
                            companion.getClass();
                            Placeable.PlacementScope.m435placeWithLayeraW9wM(outerCoordinator3, j3, f2, function12);
                        }
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                Intrinsics.checkNotNullParameter(node, "node");
                snapshotObserver.observeReads$ui_release(node, snapshotObserver.onCommitAffectingLayoutModifier, function0);
            }
            layoutNodeLayoutDelegate.layoutState = LayoutNode.LayoutState.Idle;
        }

        /* renamed from: remeasure-BRTryo0 */
        public final boolean m453remeasureBRTryo0(final long j) {
            boolean z;
            boolean z2;
            final LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            Owner requireOwner = LayoutNodeKt.requireOwner(layoutNodeLayoutDelegate.layoutNode);
            LayoutNode layoutNode = layoutNodeLayoutDelegate.layoutNode;
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            boolean z3 = true;
            if (!layoutNode.canMultiMeasure && (parent$ui_release == null || !parent$ui_release.canMultiMeasure)) {
                z = false;
            } else {
                z = true;
            }
            layoutNode.canMultiMeasure = z;
            if (!layoutNode.layoutDelegate.measurePending && Constraints.m559equalsimpl0(this.measurementConstraints, j)) {
                requireOwner.forceMeasureTheSubtree(layoutNode, false);
                layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                return false;
            }
            this.alignmentLines.usedByModifierMeasurement = false;
            forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate$remeasure$1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                    AlignmentLinesOwner it = alignmentLinesOwner;
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.getAlignmentLines().usedDuringParentMeasurement = false;
                    return Unit.INSTANCE;
                }
            });
            this.measuredOnce = true;
            long j2 = layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize;
            m431setMeasurementConstraintsBRTryo0(j);
            LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutState;
            LayoutNode.LayoutState layoutState2 = LayoutNode.LayoutState.Idle;
            if (layoutState == layoutState2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                LayoutNode.LayoutState layoutState3 = LayoutNode.LayoutState.Measuring;
                layoutNodeLayoutDelegate.layoutState = layoutState3;
                layoutNodeLayoutDelegate.measurePending = false;
                OwnerSnapshotObserver snapshotObserver = LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver();
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNodeLayoutDelegate$performMeasure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        LayoutNodeLayoutDelegate.this.getOuterCoordinator().mo421measureBRTryo0(j);
                        return Unit.INSTANCE;
                    }
                };
                snapshotObserver.getClass();
                snapshotObserver.observeReads$ui_release(layoutNode, snapshotObserver.onCommitAffectingMeasure, function0);
                if (layoutNodeLayoutDelegate.layoutState == layoutState3) {
                    layoutNodeLayoutDelegate.layoutPending = true;
                    layoutNodeLayoutDelegate.layoutPendingForAlignment = true;
                    layoutNodeLayoutDelegate.layoutState = layoutState2;
                }
                if (IntSize.m592equalsimpl0(layoutNodeLayoutDelegate.getOuterCoordinator().measuredSize, j2) && layoutNodeLayoutDelegate.getOuterCoordinator().width == this.width && layoutNodeLayoutDelegate.getOuterCoordinator().height == this.height) {
                    z3 = false;
                }
                m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(layoutNodeLayoutDelegate.getOuterCoordinator().width, layoutNodeLayoutDelegate.getOuterCoordinator().height));
                return z3;
            }
            throw new IllegalStateException("layout state is not idle before measure starts".toString());
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void requestLayout() {
            LayoutNode layoutNode = LayoutNodeLayoutDelegate.this.layoutNode;
            LayoutNode$Companion$ErrorMeasurePolicy$1 layoutNode$Companion$ErrorMeasurePolicy$1 = LayoutNode.ErrorMeasurePolicy;
            layoutNode.requestRelayout$ui_release(false);
        }

        @Override // androidx.compose.ui.node.AlignmentLinesOwner
        public final void requestMeasure() {
            LayoutNode.requestRemeasure$ui_release$default(LayoutNodeLayoutDelegate.this.layoutNode, false, 3);
        }
    }

    public LayoutNodeLayoutDelegate(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layoutState = LayoutNode.LayoutState.Idle;
        this.measurePassDelegate = new MeasurePassDelegate();
    }

    public static boolean isOutMostLookaheadRoot(LayoutNode layoutNode) {
        LayoutNode layoutNode2;
        if (layoutNode.lookaheadRoot != null) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                layoutNode2 = parent$ui_release.lookaheadRoot;
            } else {
                layoutNode2 = null;
            }
            if (layoutNode2 == null) {
                return true;
            }
        }
        return false;
    }

    public final NodeCoordinator getOuterCoordinator() {
        return this.layoutNode.nodes.outerCoordinator;
    }

    public final void setChildrenAccessingCoordinatesDuringPlacement(int r4) {
        boolean z;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate;
        int r0 = this.childrenAccessingCoordinatesDuringPlacement;
        this.childrenAccessingCoordinatesDuringPlacement = r4;
        boolean z2 = false;
        if (r0 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (r4 == 0) {
            z2 = true;
        }
        if (z != z2) {
            LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
            if (parent$ui_release != null) {
                layoutNodeLayoutDelegate = parent$ui_release.layoutDelegate;
            } else {
                layoutNodeLayoutDelegate = null;
            }
            if (layoutNodeLayoutDelegate != null) {
                if (r4 == 0) {
                    layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement - 1);
                } else {
                    layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.childrenAccessingCoordinatesDuringPlacement + 1);
                }
            }
        }
    }

    public final void setCoordinatesAccessedDuringModifierPlacement(boolean z) {
        if (this.coordinatesAccessedDuringModifierPlacement != z) {
            this.coordinatesAccessedDuringModifierPlacement = z;
            if (z && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!z && !this.coordinatesAccessedDuringPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    public final void setCoordinatesAccessedDuringPlacement(boolean z) {
        if (this.coordinatesAccessedDuringPlacement != z) {
            this.coordinatesAccessedDuringPlacement = z;
            if (z && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement + 1);
            } else if (!z && !this.coordinatesAccessedDuringModifierPlacement) {
                setChildrenAccessingCoordinatesDuringPlacement(this.childrenAccessingCoordinatesDuringPlacement - 1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:            if (r5.getParentData() == null) goto L69;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:            if (r0 != true) goto L73;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateParentData() {
        /*
            r7 = this;
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r0 = r7.measurePassDelegate
            java.lang.Object r1 = r0.parentData
            r2 = 1
            r3 = 0
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r4 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
            if (r1 != 0) goto L15
            androidx.compose.ui.node.NodeCoordinator r1 = r4.getOuterCoordinator()
            java.lang.Object r1 = r1.getParentData()
            if (r1 != 0) goto L15
            goto L19
        L15:
            boolean r1 = r0.parentDataDirty
            if (r1 != 0) goto L1b
        L19:
            r0 = r3
            goto L28
        L1b:
            r0.parentDataDirty = r3
            androidx.compose.ui.node.NodeCoordinator r1 = r4.getOuterCoordinator()
            java.lang.Object r1 = r1.getParentData()
            r0.parentData = r1
            r0 = r2
        L28:
            r1 = 3
            androidx.compose.ui.node.LayoutNode r4 = r7.layoutNode
            if (r0 == 0) goto L36
            androidx.compose.ui.node.LayoutNode r0 = r4.getParent$ui_release()
            if (r0 == 0) goto L36
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r0, r3, r1)
        L36:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate r0 = r7.lookaheadPassDelegate
            if (r0 == 0) goto L6f
            java.lang.Object r5 = r0.parentData
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r6 = androidx.compose.ui.node.LayoutNodeLayoutDelegate.this
            if (r5 != 0) goto L52
            androidx.compose.ui.node.NodeCoordinator r5 = r6.getOuterCoordinator()
            androidx.compose.ui.node.LookaheadDelegate r5 = r5.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Object r5 = r5.getParentData()
            if (r5 != 0) goto L52
            goto L56
        L52:
            boolean r5 = r0.parentDataDirty
            if (r5 != 0) goto L58
        L56:
            r0 = r3
            goto L6c
        L58:
            r0.parentDataDirty = r3
            androidx.compose.ui.node.NodeCoordinator r5 = r6.getOuterCoordinator()
            androidx.compose.ui.node.LookaheadDelegate r5 = r5.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            java.lang.Object r5 = r5.getParentData()
            r0.parentData = r5
            r0 = r2
        L6c:
            if (r0 != r2) goto L6f
            goto L70
        L6f:
            r2 = r3
        L70:
            if (r2 == 0) goto L8b
            boolean r0 = isOutMostLookaheadRoot(r4)
            if (r0 == 0) goto L82
            androidx.compose.ui.node.LayoutNode r0 = r4.getParent$ui_release()
            if (r0 == 0) goto L8b
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r0, r3, r1)
            goto L8b
        L82:
            androidx.compose.ui.node.LayoutNode r0 = r4.getParent$ui_release()
            if (r0 == 0) goto L8b
            androidx.compose.ui.node.LayoutNode.requestLookaheadRemeasure$ui_release$default(r0, r3, r1)
        L8b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNodeLayoutDelegate.updateParentData():void");
    }
}
