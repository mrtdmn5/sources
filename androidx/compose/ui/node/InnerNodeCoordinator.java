package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InnerNodeCoordinator.kt */
/* loaded from: classes.dex */
public final class InnerNodeCoordinator extends NodeCoordinator {
    public static final AndroidPaint innerBoundsPaint;
    public LookaheadDelegate lookaheadDelegate;
    public final TailModifierNode tail;

    /* compiled from: InnerNodeCoordinator.kt */
    /* loaded from: classes.dex */
    public final class LookaheadDelegateImpl extends LookaheadDelegate {
        public LookaheadDelegateImpl(InnerNodeCoordinator innerNodeCoordinator) {
            super(innerNodeCoordinator);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int r0;
            Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            boolean z = lookaheadPassDelegate.duringAlignmentLinesQuery;
            LookaheadAlignmentLines lookaheadAlignmentLines = lookaheadPassDelegate.alignmentLines;
            if (!z) {
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
                if (layoutNodeLayoutDelegate.layoutState == LayoutNode.LayoutState.LookaheadMeasuring) {
                    lookaheadAlignmentLines.usedByModifierMeasurement = true;
                    if (lookaheadAlignmentLines.dirty) {
                        layoutNodeLayoutDelegate.lookaheadLayoutPending = true;
                        layoutNodeLayoutDelegate.lookaheadLayoutPendingForAlignment = true;
                    }
                } else {
                    lookaheadAlignmentLines.usedByModifierLayout = true;
                }
            }
            LookaheadDelegate lookaheadDelegate = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegate != null) {
                lookaheadDelegate.isPlacingForAlignment = true;
            }
            lookaheadPassDelegate.layoutChildren();
            LookaheadDelegate lookaheadDelegate2 = lookaheadPassDelegate.getInnerCoordinator().lookaheadDelegate;
            if (lookaheadDelegate2 != null) {
                lookaheadDelegate2.isPlacingForAlignment = false;
            }
            Integer num = (Integer) lookaheadAlignmentLines.alignmentLineMap.get(alignmentLine);
            if (num != null) {
                r0 = num.intValue();
            } else {
                r0 = Integer.MIN_VALUE;
            }
            this.cachedAlignmentLinesMap.put(alignmentLine, Integer.valueOf(r0));
            return r0;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicHeight(int r4) {
            IntrinsicsPolicy intrinsicsPolicy = this.coordinator.layoutNode.intrinsicsPolicy;
            MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
            LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
            return measurePolicyFromState.maxIntrinsicHeight(layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui_release(), r4);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int maxIntrinsicWidth(int r4) {
            IntrinsicsPolicy intrinsicsPolicy = this.coordinator.layoutNode.intrinsicsPolicy;
            MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
            LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
            return measurePolicyFromState.maxIntrinsicWidth(layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui_release(), r4);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public final Placeable mo421measureBRTryo0(long j) {
            m431setMeasurementConstraintsBRTryo0(j);
            NodeCoordinator nodeCoordinator = this.coordinator;
            MutableVector<LayoutNode> mutableVector = nodeCoordinator.layoutNode.get_children$ui_release();
            int r2 = mutableVector.size;
            if (r2 > 0) {
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int r3 = 0;
                do {
                    LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeArr[r3].layoutDelegate.lookaheadPassDelegate;
                    Intrinsics.checkNotNull(lookaheadPassDelegate);
                    LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
                    Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
                    lookaheadPassDelegate.measuredByParent = usageByParent;
                    r3++;
                } while (r3 < r2);
            }
            LayoutNode layoutNode = nodeCoordinator.layoutNode;
            LookaheadDelegate.access$set_measureResult(this, layoutNode.measurePolicy.mo4measure3p2s80s(this, layoutNode.getChildLookaheadMeasurables$ui_release(), j));
            return this;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicHeight(int r4) {
            IntrinsicsPolicy intrinsicsPolicy = this.coordinator.layoutNode.intrinsicsPolicy;
            MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
            LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
            return measurePolicyFromState.minIntrinsicHeight(layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui_release(), r4);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public final int minIntrinsicWidth(int r4) {
            IntrinsicsPolicy intrinsicsPolicy = this.coordinator.layoutNode.intrinsicsPolicy;
            MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
            LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
            return measurePolicyFromState.minIntrinsicWidth(layoutNode.nodes.outerCoordinator, layoutNode.getChildLookaheadMeasurables$ui_release(), r4);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate
        public final void placeChildren() {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = this.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.onNodePlaced$ui_release();
        }
    }

    static {
        AndroidPaint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo298setColor8_81llA(Color.Red);
        Paint.setStrokeWidth(1.0f);
        Paint.m302setStylek9PVt8s(1);
        innerBoundsPaint = Paint;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerNodeCoordinator(LayoutNode layoutNode) {
        super(layoutNode);
        LookaheadDelegateImpl lookaheadDelegateImpl;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        TailModifierNode tailModifierNode = new TailModifierNode();
        this.tail = tailModifierNode;
        tailModifierNode.coordinator = this;
        if (layoutNode.lookaheadRoot != null) {
            lookaheadDelegateImpl = new LookaheadDelegateImpl(this);
        } else {
            lookaheadDelegateImpl = null;
        }
        this.lookaheadDelegate = lookaheadDelegateImpl;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        LookaheadDelegate lookaheadDelegate = this.lookaheadDelegate;
        if (lookaheadDelegate != null) {
            return lookaheadDelegate.calculateAlignmentLine(alignmentLine);
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.layoutNode.layoutDelegate.measurePassDelegate;
        boolean z = measurePassDelegate.duringAlignmentLinesQuery;
        LayoutNodeAlignmentLines layoutNodeAlignmentLines = measurePassDelegate.alignmentLines;
        if (!z) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = LayoutNodeLayoutDelegate.this;
            if (layoutNodeLayoutDelegate.layoutState == LayoutNode.LayoutState.Measuring) {
                layoutNodeAlignmentLines.usedByModifierMeasurement = true;
                if (layoutNodeAlignmentLines.dirty) {
                    layoutNodeLayoutDelegate.layoutPending = true;
                    layoutNodeLayoutDelegate.layoutPendingForAlignment = true;
                }
            } else {
                layoutNodeAlignmentLines.usedByModifierLayout = true;
            }
        }
        measurePassDelegate.getInnerCoordinator().isPlacingForAlignment = true;
        measurePassDelegate.layoutChildren();
        measurePassDelegate.getInnerCoordinator().isPlacingForAlignment = false;
        Integer num = (Integer) layoutNodeAlignmentLines.alignmentLineMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void ensureLookaheadDelegateCreated() {
        if (this.lookaheadDelegate == null) {
            this.lookaheadDelegate = new LookaheadDelegateImpl(this);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0134  */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // androidx.compose.ui.node.NodeCoordinator
    /* renamed from: hitTestChild-YqVAtuI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo445hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator.HitTestSource r19, long r20, androidx.compose.ui.node.HitTestResult r22, boolean r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerNodeCoordinator.mo445hitTestChildYqVAtuI(androidx.compose.ui.node.NodeCoordinator$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicHeight(int r4) {
        IntrinsicsPolicy intrinsicsPolicy = this.layoutNode.intrinsicsPolicy;
        MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
        LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
        return measurePolicyFromState.maxIntrinsicHeight(layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui_release(), r4);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int maxIntrinsicWidth(int r4) {
        IntrinsicsPolicy intrinsicsPolicy = this.layoutNode.intrinsicsPolicy;
        MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
        LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
        return measurePolicyFromState.maxIntrinsicWidth(layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui_release(), r4);
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    public final Placeable mo421measureBRTryo0(long j) {
        m431setMeasurementConstraintsBRTryo0(j);
        LayoutNode layoutNode = this.layoutNode;
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int r2 = mutableVector.size;
        if (r2 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r3 = 0;
            do {
                LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = layoutNodeArr[r3].layoutDelegate.measurePassDelegate;
                LayoutNode.UsageByParent usageByParent = LayoutNode.UsageByParent.NotUsed;
                measurePassDelegate.getClass();
                Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
                measurePassDelegate.measuredByParent = usageByParent;
                r3++;
            } while (r3 < r2);
        }
        setMeasureResult$ui_release(layoutNode.measurePolicy.mo4measure3p2s80s(this, layoutNode.getChildMeasurables$ui_release(), j));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicHeight(int r4) {
        IntrinsicsPolicy intrinsicsPolicy = this.layoutNode.intrinsicsPolicy;
        MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
        LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
        return measurePolicyFromState.minIntrinsicHeight(layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui_release(), r4);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public final int minIntrinsicWidth(int r4) {
        IntrinsicsPolicy intrinsicsPolicy = this.layoutNode.intrinsicsPolicy;
        MeasurePolicy measurePolicyFromState = intrinsicsPolicy.measurePolicyFromState();
        LayoutNode layoutNode = intrinsicsPolicy.layoutNode;
        return measurePolicyFromState.minIntrinsicWidth(layoutNode.nodes.outerCoordinator, layoutNode.getChildMeasurables$ui_release(), r4);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public final void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        LayoutNode layoutNode = this.layoutNode;
        Owner requireOwner = LayoutNodeKt.requireOwner(layoutNode);
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        int r2 = zSortedChildren.size;
        if (r2 > 0) {
            LayoutNode[] layoutNodeArr = zSortedChildren.content;
            int r3 = 0;
            do {
                LayoutNode layoutNode2 = layoutNodeArr[r3];
                if (layoutNode2.isPlaced()) {
                    layoutNode2.draw$ui_release(canvas);
                }
                r3++;
            } while (r3 < r2);
        }
        if (requireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
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
        this.layoutNode.layoutDelegate.measurePassDelegate.onNodePlaced$ui_release();
    }
}
