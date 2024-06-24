package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNodeCoordinator.kt */
/* loaded from: classes.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final AndroidPaint modifierBoundsPaint;
    public LayoutModifierNode layoutModifierNode;
    public Constraints lookaheadConstraints;
    public LookaheadDelegate lookaheadDelegate;

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    /* loaded from: classes.dex */
    public final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            int access$calculateAlignmentAndPlaceChildAsNeeded = MutableRectKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            this.cachedAlignmentLinesMap.put(alignmentLine, Integer.valueOf(access$calculateAlignmentAndPlaceChildAsNeeded));
            return access$calculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicHeight(int r3) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
            NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, r3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicWidth(int r3) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
            NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, r3);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public final Placeable mo421measureBRTryo0(long j) {
            m431setMeasurementConstraintsBRTryo0(j);
            Constraints constraints = new Constraints(j);
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            layoutModifierNodeCoordinator.lookaheadConstraints = constraints;
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
            NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            LookaheadDelegate.access$set_measureResult(this, layoutModifierNode.mo31measure3p2s80s(this, lookaheadDelegate, j));
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicHeight(int r3) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
            NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, r3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicWidth(int r3) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.layoutModifierNode;
            NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            LookaheadDelegate lookaheadDelegate = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, r3);
        }
    }

    static {
        AndroidPaint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo298setColor8_81llA(Color.Blue);
        Paint.setStrokeWidth(1.0f);
        Paint.m302setStylek9PVt8s(1);
        modifierBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        LookaheadDelegateForLayoutModifierNode lookaheadDelegateForLayoutModifierNode;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutModifierNode = layoutModifierNode;
        if (layoutNode.lookaheadRoot != null) {
            lookaheadDelegateForLayoutModifierNode = new LookaheadDelegateForLayoutModifierNode();
        } else {
            lookaheadDelegateForLayoutModifierNode = null;
        }
        this.lookaheadDelegate = lookaheadDelegateForLayoutModifierNode;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (lookaheadDelegate != null) {
            Integer num = (Integer) lookaheadDelegate.cachedAlignmentLinesMap.get(alignmentLine);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        return MutableRectKt.access$calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void ensureLookaheadDelegateCreated() {
        if (this.lookaheadDelegate == null) {
            this.lookaheadDelegate = new LookaheadDelegateForLayoutModifierNode();
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicHeight(int r5) {
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (layoutModifierNode instanceof IntermediateLayoutModifierNode) {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode;
        } else {
            intermediateLayoutModifierNode = null;
        }
        if (intermediateLayoutModifierNode == null) {
            NodeCoordinator nodeCoordinator = this.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            return layoutModifierNode.maxIntrinsicHeight(this, nodeCoordinator, r5);
        }
        Intrinsics.checkNotNull(this.wrapped);
        NodeMeasuringIntrinsics$IntrinsicMinMax minMax = NodeMeasuringIntrinsics$IntrinsicMinMax.Max;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight = NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height;
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        ConstraintsKt.Constraints$default(r5, 0, 13);
        LayoutDirection layoutDirection = this.layoutNode.layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        throw null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicWidth(int r5) {
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (layoutModifierNode instanceof IntermediateLayoutModifierNode) {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode;
        } else {
            intermediateLayoutModifierNode = null;
        }
        if (intermediateLayoutModifierNode == null) {
            NodeCoordinator nodeCoordinator = this.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            return layoutModifierNode.maxIntrinsicWidth(this, nodeCoordinator, r5);
        }
        Intrinsics.checkNotNull(this.wrapped);
        NodeMeasuringIntrinsics$IntrinsicMinMax minMax = NodeMeasuringIntrinsics$IntrinsicMinMax.Max;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight = NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width;
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        ConstraintsKt.Constraints$default(0, r5, 7);
        LayoutDirection layoutDirection = this.layoutNode.layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        throw null;
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public final Placeable mo421measureBRTryo0(long j) {
        m431setMeasurementConstraintsBRTryo0(j);
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (!(layoutModifierNode instanceof IntermediateLayoutModifierNode)) {
            NodeCoordinator nodeCoordinator = this.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            setMeasureResult$ui_release(layoutModifierNode.mo31measure3p2s80s(this, nodeCoordinator, j));
            onMeasured();
            return this;
        }
        Intrinsics.checkNotNull(this.wrapped);
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        Intrinsics.checkNotNull(lookaheadDelegate);
        MeasureResult measureResult$ui_release = lookaheadDelegate.getMeasureResult$ui_release();
        measureResult$ui_release.getWidth();
        measureResult$ui_release.getHeight();
        Intrinsics.checkNotNull(this.lookaheadConstraints);
        ((IntermediateLayoutModifierNode) layoutModifierNode).getClass();
        throw null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicHeight(int r5) {
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (layoutModifierNode instanceof IntermediateLayoutModifierNode) {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode;
        } else {
            intermediateLayoutModifierNode = null;
        }
        if (intermediateLayoutModifierNode == null) {
            NodeCoordinator nodeCoordinator = this.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            return layoutModifierNode.minIntrinsicHeight(this, nodeCoordinator, r5);
        }
        Intrinsics.checkNotNull(this.wrapped);
        NodeMeasuringIntrinsics$IntrinsicMinMax minMax = NodeMeasuringIntrinsics$IntrinsicMinMax.Min;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight = NodeMeasuringIntrinsics$IntrinsicWidthHeight.Height;
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        ConstraintsKt.Constraints$default(r5, 0, 13);
        LayoutDirection layoutDirection = this.layoutNode.layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        throw null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicWidth(int r5) {
        IntermediateLayoutModifierNode intermediateLayoutModifierNode;
        LayoutModifierNode layoutModifierNode = this.layoutModifierNode;
        if (layoutModifierNode instanceof IntermediateLayoutModifierNode) {
            intermediateLayoutModifierNode = (IntermediateLayoutModifierNode) layoutModifierNode;
        } else {
            intermediateLayoutModifierNode = null;
        }
        if (intermediateLayoutModifierNode == null) {
            NodeCoordinator nodeCoordinator = this.wrapped;
            Intrinsics.checkNotNull(nodeCoordinator);
            return layoutModifierNode.minIntrinsicWidth(this, nodeCoordinator, r5);
        }
        Intrinsics.checkNotNull(this.wrapped);
        NodeMeasuringIntrinsics$IntrinsicMinMax minMax = NodeMeasuringIntrinsics$IntrinsicMinMax.Min;
        NodeMeasuringIntrinsics$IntrinsicWidthHeight widthHeight = NodeMeasuringIntrinsics$IntrinsicWidthHeight.Width;
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        Intrinsics.checkNotNullParameter(widthHeight, "widthHeight");
        ConstraintsKt.Constraints$default(0, r5, 7);
        LayoutDirection layoutDirection = this.layoutNode.layoutDirection;
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        throw null;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        Intrinsics.checkNotNull(nodeCoordinator);
        nodeCoordinator.draw(canvas);
        if (LayoutNodeKt.requireOwner(this.layoutNode).getShowLayoutBounds()) {
            drawBorder(canvas, modifierBoundsPaint);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public final void mo422placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        m470placeSelff8xVGno(j, f, function1);
        if (this.isShallowPlacing) {
            return;
        }
        onPlaced();
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int r4 = (int) (this.measuredSize >> 32);
        LayoutDirection layoutDirection = this.layoutNode.layoutDirection;
        LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
        companion.getClass();
        int r0 = Placeable.PlacementScope.parentWidth;
        LayoutDirection layoutDirection2 = Placeable.PlacementScope.parentLayoutDirection;
        Placeable.PlacementScope.parentWidth = r4;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = Placeable.PlacementScope.Companion.access$configureForPlacingForAlignment(companion, this);
        getMeasureResult$ui_release().placeChildren();
        this.isPlacingForAlignment = access$configureForPlacingForAlignment;
        Placeable.PlacementScope.parentWidth = r0;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection2;
        Placeable.PlacementScope._coordinates = layoutCoordinates;
    }
}
