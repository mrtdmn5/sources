package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.room.util.CursorUtil;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: NodeCoordinator.kt */
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final NodeCoordinator$Companion$PointerInputSource$1 PointerInputSource;
    public static final NodeCoordinator$Companion$SemanticsSource$1 SemanticsSource;
    public MeasureResult _measureResult;
    public MutableRect _rectCache;
    public final NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer;
    public boolean isClipping;
    public float lastLayerAlpha;
    public boolean lastLayerDrawingWasSkipped;
    public OwnedLayer layer;
    public Function1<? super GraphicsLayerScope, Unit> layerBlock;
    public Density layerDensity;
    public LayoutDirection layerLayoutDirection;
    public LayerPositionalProperties layerPositionalProperties;
    public final LayoutNode layoutNode;
    public LinkedHashMap oldAlignmentLines;
    public long position;
    public boolean released;
    public NodeCoordinator wrapped;
    public NodeCoordinator wrappedBy;
    public float zIndex;
    public static final NodeCoordinator$Companion$onCommitAffectingLayerParams$1 onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    public static final NodeCoordinator$Companion$onCommitAffectingLayer$1 onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();

    /* compiled from: NodeCoordinator.kt */
    /* loaded from: classes.dex */
    public interface HitTestSource {
        /* renamed from: childHitTest-YqVAtuI */
        void mo473childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2);

        /* renamed from: entityType-OLwlOKw */
        int mo474entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(Modifier.Node node);

        boolean shouldHitTestChildren(LayoutNode layoutNode);
    }

    static {
        Matrix.m337constructorimpl$default();
        PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
        SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.Zero;
        this.invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    }

    public final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z) {
        if (nodeCoordinator == this) {
            return;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z);
        }
        long j = this.position;
        int r5 = IntOffset.$r8$clinit;
        float f = (int) (j >> 32);
        mutableRect.left -= f;
        mutableRect.right -= f;
        float m590getYimpl = IntOffset.m590getYimpl(j);
        mutableRect.top -= m590getYimpl;
        mutableRect.bottom -= m590getYimpl;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z) {
                long j2 = this.measuredSize;
                mutableRect.intersect(0.0f, 0.0f, (int) (j2 >> 32), IntSize.m593getHeightimpl(j2));
            }
        }
    }

    /* renamed from: ancestorToLocal-R5De75A */
    public final long m461ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j) {
        if (nodeCoordinator == this) {
            return j;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null && !Intrinsics.areEqual(nodeCoordinator, nodeCoordinator2)) {
            return m464fromParentPositionMKHz9U(nodeCoordinator2.m461ancestorToLocalR5De75A(nodeCoordinator, j));
        }
        return m464fromParentPositionMKHz9U(j);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU */
    public final long m462calculateMinimumTouchTargetPaddingE7KxVPU(long j) {
        return SizeKt.Size(Math.max(0.0f, (Size.m276getWidthimpl(j) - getMeasuredWidth()) / 2.0f), Math.max(0.0f, (Size.m274getHeightimpl(j) - getMeasuredHeight()) / 2.0f));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw */
    public final float m463distanceInMinimumTouchTargettz77jQw(long j, long j2) {
        float measuredWidth;
        float measuredHeight;
        if (getMeasuredWidth() >= Size.m276getWidthimpl(j2) && getMeasuredHeight() >= Size.m274getHeightimpl(j2)) {
            return Float.POSITIVE_INFINITY;
        }
        long m462calculateMinimumTouchTargetPaddingE7KxVPU = m462calculateMinimumTouchTargetPaddingE7KxVPU(j2);
        float m276getWidthimpl = Size.m276getWidthimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU);
        float m274getHeightimpl = Size.m274getHeightimpl(m462calculateMinimumTouchTargetPaddingE7KxVPU);
        float m259getXimpl = Offset.m259getXimpl(j);
        if (m259getXimpl < 0.0f) {
            measuredWidth = -m259getXimpl;
        } else {
            measuredWidth = m259getXimpl - getMeasuredWidth();
        }
        float max = Math.max(0.0f, measuredWidth);
        float m260getYimpl = Offset.m260getYimpl(j);
        if (m260getYimpl < 0.0f) {
            measuredHeight = -m260getYimpl;
        } else {
            measuredHeight = m260getYimpl - getMeasuredHeight();
        }
        long Offset = OffsetKt.Offset(max, Math.max(0.0f, measuredHeight));
        if ((m276getWidthimpl <= 0.0f && m274getHeightimpl <= 0.0f) || Offset.m259getXimpl(Offset) > m276getWidthimpl || Offset.m260getYimpl(Offset) > m274getHeightimpl) {
            return Float.POSITIVE_INFINITY;
        }
        return (Offset.m260getYimpl(Offset) * Offset.m260getYimpl(Offset)) + (Offset.m259getXimpl(Offset) * Offset.m259getXimpl(Offset));
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        long j = this.position;
        float f = (int) (j >> 32);
        float m590getYimpl = IntOffset.m590getYimpl(j);
        canvas.translate(f, m590getYimpl);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-f, -m590getYimpl);
    }

    public final void drawBorder(Canvas canvas, AndroidPaint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        long j = this.measuredSize;
        canvas.drawRect(new Rect(0.5f, 0.5f, ((int) (j >> 32)) - 0.5f, IntSize.m593getHeightimpl(j) - 0.5f), paint);
    }

    public final void drawContainedDrawModifiers(Canvas canvas) {
        boolean z;
        boolean z2;
        Modifier.Node m466headH91voCI = m466headH91voCI(4);
        if (m466headH91voCI == null) {
            performDraw(canvas);
            return;
        }
        LayoutNode layoutNode = this.layoutNode;
        layoutNode.getClass();
        LayoutNodeDrawScope sharedDrawScope = LayoutNodeKt.requireOwner(layoutNode).getSharedDrawScope();
        long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(this.measuredSize);
        sharedDrawScope.getClass();
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        MutableVector mutableVector = null;
        while (m466headH91voCI != null) {
            if (m466headH91voCI instanceof DrawModifierNode) {
                sharedDrawScope.m450drawDirectx_KDEd0$ui_release(canvas, m595toSizeozmzZPI, this, (DrawModifierNode) m466headH91voCI);
            } else {
                if ((m466headH91voCI.kindSet & 4) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (m466headH91voCI instanceof DelegatingNode)) {
                    int r6 = 0;
                    for (Modifier.Node node = ((DelegatingNode) m466headH91voCI).delegate; node != null; node = node.child) {
                        if ((node.kindSet & 4) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            r6++;
                            if (r6 == 1) {
                                m466headH91voCI = node;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16]);
                                }
                                if (m466headH91voCI != null) {
                                    mutableVector.add(m466headH91voCI);
                                    m466headH91voCI = null;
                                }
                                mutableVector.add(node);
                            }
                        }
                    }
                    if (r6 == 1) {
                    }
                }
            }
            m466headH91voCI = DelegatableNodeKt.access$pop(mutableVector);
        }
    }

    public abstract void ensureLookaheadDelegateCreated();

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode layoutNode = this.layoutNode;
        LayoutNode layoutNode2 = other.layoutNode;
        if (layoutNode2 == layoutNode) {
            Modifier.Node tail = other.getTail();
            Modifier.Node tail2 = getTail();
            if (tail2.getNode().isAttached) {
                for (Modifier.Node node = tail2.getNode().parent; node != null; node = node.parent) {
                    if ((node.kindSet & 2) != 0 && node == tail) {
                        return other;
                    }
                }
                return this;
            }
            throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
        }
        LayoutNode layoutNode3 = layoutNode2;
        while (layoutNode3.depth > layoutNode.depth) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode3);
        }
        LayoutNode layoutNode4 = layoutNode;
        while (layoutNode4.depth > layoutNode3.depth) {
            layoutNode4 = layoutNode4.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode4);
        }
        while (layoutNode3 != layoutNode4) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            layoutNode4 = layoutNode4.getParent$ui_release();
            if (layoutNode3 == null || layoutNode4 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
        }
        if (layoutNode4 == layoutNode) {
            return this;
        }
        if (layoutNode3 != layoutNode2) {
            return layoutNode3.nodes.innerCoordinator;
        }
        return other;
    }

    /* renamed from: fromParentPosition-MK-Hz9U */
    public final long m464fromParentPositionMKHz9U(long j) {
        long j2 = this.position;
        float m259getXimpl = Offset.m259getXimpl(j);
        int r3 = IntOffset.$r8$clinit;
        long Offset = OffsetKt.Offset(m259getXimpl - ((int) (j2 >> 32)), Offset.m260getYimpl(j) - IntOffset.m590getYimpl(j2));
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            return ownedLayer.mo478mapOffset8S9VItk(Offset, true);
        }
        return Offset;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.layoutNode.density.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.layoutNode.density.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final boolean getHasMeasureResult() {
        if (this._measureResult != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public final LayoutDirection getLayoutDirection() {
        return this.layoutNode.layoutDirection;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public abstract LookaheadDelegate getLookaheadDelegate();

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("Asking for measurement result of unmeasured layout modifier".toString());
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc */
    public final long m465getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.mo50toSizeXkaWNTQ(this.layoutNode.viewConfiguration.mo449getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public final Object getParentData() {
        boolean z;
        boolean z2;
        boolean z3;
        LayoutNode layoutNode = this.layoutNode;
        if (!layoutNode.nodes.m460hasH91voCI$ui_release(64)) {
            return null;
        }
        getTail();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (Modifier.Node node = layoutNode.nodes.tail; node != null; node = node.parent) {
            if ((node.kindSet & 64) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                ?? r8 = 0;
                DelegatingNode delegatingNode = node;
                while (delegatingNode != 0) {
                    if (delegatingNode instanceof ParentDataModifierNode) {
                        ref$ObjectRef.element = ((ParentDataModifierNode) delegatingNode).modifyParentData(layoutNode.density, ref$ObjectRef.element);
                    } else {
                        if ((delegatingNode.kindSet & 64) != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2 && (delegatingNode instanceof DelegatingNode)) {
                            Modifier.Node node2 = delegatingNode.delegate;
                            int r10 = 0;
                            delegatingNode = delegatingNode;
                            r8 = r8;
                            while (node2 != null) {
                                if ((node2.kindSet & 64) != 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    r10++;
                                    r8 = r8;
                                    if (r10 == 1) {
                                        delegatingNode = node2;
                                    } else {
                                        if (r8 == 0) {
                                            r8 = new MutableVector(new Modifier.Node[16]);
                                        }
                                        if (delegatingNode != 0) {
                                            r8.add(delegatingNode);
                                            delegatingNode = 0;
                                        }
                                        r8.add(node2);
                                    }
                                }
                                node2 = node2.child;
                                delegatingNode = delegatingNode;
                                r8 = r8;
                            }
                            if (r10 == 1) {
                            }
                        }
                    }
                    delegatingNode = DelegatableNodeKt.access$pop(r8);
                }
            }
        }
        return ref$ObjectRef.element;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            return this.layoutNode.nodes.outerCoordinator.wrappedBy;
        }
        throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public final long mo454getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo423getSizeYbymL2g() {
        return this.measuredSize;
    }

    public abstract Modifier.Node getTail();

    /* renamed from: head-H91voCI */
    public final Modifier.Node m466headH91voCI(int r4) {
        boolean m476getIncludeSelfInTraversalH91voCI = NodeKindKt.m476getIncludeSelfInTraversalH91voCI(r4);
        Modifier.Node tail = getTail();
        if (m476getIncludeSelfInTraversalH91voCI || (tail = tail.parent) != null) {
            for (Modifier.Node headNode = headNode(m476getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.aggregateChildKindSet & r4) != 0; headNode = headNode.child) {
                if ((headNode.kindSet & r4) != 0) {
                    return headNode;
                }
                if (headNode == tail) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    public final Modifier.Node headNode(boolean z) {
        Modifier.Node tail;
        NodeChain nodeChain = this.layoutNode.nodes;
        if (nodeChain.outerCoordinator == this) {
            return nodeChain.head;
        }
        if (z) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null && (tail = nodeCoordinator.getTail()) != null) {
                return tail.child;
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    /* renamed from: hit-1hIXUjU */
    public final void m467hit1hIXUjU(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2) {
        if (node == null) {
            mo445hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                NodeCoordinator.this.m467hit1hIXUjU(NodeCoordinatorKt.m475access$nextUntilhw7D004(node, hitTestSource.mo474entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, z, z2);
                return Unit.INSTANCE;
            }
        };
        hitTestResult.getClass();
        hitTestResult.hitInMinimumTouchTarget(node, -1.0f, z2, function0);
    }

    /* renamed from: hitNear-JHbHoSQ */
    public final void m468hitNearJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo445hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
        } else {
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NodeCoordinator.this.m468hitNearJHbHoSQ(NodeCoordinatorKt.m475access$nextUntilhw7D004(node, hitTestSource.mo474entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, z, z2, f);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* renamed from: hitTest-YqVAtuI */
    public final void m469hitTestYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        float m463distanceInMinimumTouchTargettz77jQw;
        boolean z5;
        boolean z6;
        OwnedLayer ownedLayer;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        Modifier.Node m466headH91voCI = m466headH91voCI(hitTestSource.mo474entityTypeOLwlOKw());
        boolean z7 = true;
        if (!OffsetKt.m265isFinitek4lQ0M(j) || ((ownedLayer = this.layer) != null && this.isClipping && !ownedLayer.mo477isInLayerk4lQ0M(j))) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            if (z) {
                float m463distanceInMinimumTouchTargettz77jQw2 = m463distanceInMinimumTouchTargettz77jQw(j, m465getMinimumTouchTargetSizeNHjbRc());
                if (!Float.isInfinite(m463distanceInMinimumTouchTargettz77jQw2) && !Float.isNaN(m463distanceInMinimumTouchTargettz77jQw2)) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (z6) {
                    if (hitTestResult.hitDepth != CollectionsKt__CollectionsKt.getLastIndex(hitTestResult)) {
                        if (DistanceAndInLayer.m442compareToS_HNhKs(hitTestResult.m444findBestHitDistanceptXAw2c(), CursorUtil.access$DistanceAndInLayer(m463distanceInMinimumTouchTargettz77jQw2, false)) <= 0) {
                            z7 = false;
                        }
                    }
                    if (z7) {
                        m468hitNearJHbHoSQ(m466headH91voCI, hitTestSource, j, hitTestResult, z, false, m463distanceInMinimumTouchTargettz77jQw2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (m466headH91voCI == null) {
            mo445hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        float m259getXimpl = Offset.m259getXimpl(j);
        float m260getYimpl = Offset.m260getYimpl(j);
        if (m259getXimpl >= 0.0f && m260getYimpl >= 0.0f && m259getXimpl < getMeasuredWidth() && m260getYimpl < getMeasuredHeight()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            m467hit1hIXUjU(m466headH91voCI, hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        if (!z) {
            m463distanceInMinimumTouchTargettz77jQw = Float.POSITIVE_INFINITY;
        } else {
            m463distanceInMinimumTouchTargettz77jQw = m463distanceInMinimumTouchTargettz77jQw(j, m465getMinimumTouchTargetSizeNHjbRc());
        }
        float f = m463distanceInMinimumTouchTargettz77jQw;
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            if (hitTestResult.hitDepth != CollectionsKt__CollectionsKt.getLastIndex(hitTestResult)) {
                if (DistanceAndInLayer.m442compareToS_HNhKs(hitTestResult.m444findBestHitDistanceptXAw2c(), CursorUtil.access$DistanceAndInLayer(f, z2)) <= 0) {
                    z7 = false;
                }
            }
            if (z7) {
                m468hitNearJHbHoSQ(m466headH91voCI, hitTestSource, j, hitTestResult, z, z2, f);
                return;
            }
        }
        m471speculativeHitJHbHoSQ(m466headH91voCI, hitTestSource, j, hitTestResult, z, z2, f);
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public void mo445hitTestChildYqVAtuI(HitTestSource hitTestSource, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m469hitTestYqVAtuI(hitTestSource, nodeCoordinator.m464fromParentPositionMKHz9U(j), hitTestResult, z, z2);
        }
    }

    public final void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Canvas canvas) {
        final Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        LayoutNode layoutNode = this.layoutNode;
        if (layoutNode.isPlaced()) {
            LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invoke$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NodeCoordinator.this.drawContainedDrawModifiers(canvas2);
                    return Unit.INSTANCE;
                }
            });
            this.lastLayerDrawingWasSkipped = false;
        } else {
            this.lastLayerDrawingWasSkipped = true;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final boolean isAttached() {
        if (!this.released && this.layoutNode.isAttached()) {
            return true;
        }
        return false;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public final boolean isValidOwnerScope() {
        if (this.layer != null && isAttached()) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    public final Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean z) {
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl;
        NodeCoordinator nodeCoordinator;
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (isAttached()) {
            if (sourceCoordinates.isAttached()) {
                if (sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl) {
                    lookaheadLayoutCoordinatesImpl = (LookaheadLayoutCoordinatesImpl) sourceCoordinates;
                } else {
                    lookaheadLayoutCoordinatesImpl = null;
                }
                if (lookaheadLayoutCoordinatesImpl == null || (nodeCoordinator = lookaheadLayoutCoordinatesImpl.lookaheadDelegate.coordinator) == null) {
                    nodeCoordinator = (NodeCoordinator) sourceCoordinates;
                }
                nodeCoordinator.onCoordinatesUsed$ui_release();
                NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(nodeCoordinator);
                MutableRect mutableRect = this._rectCache;
                if (mutableRect == null) {
                    mutableRect = new MutableRect();
                    this._rectCache = mutableRect;
                }
                mutableRect.left = 0.0f;
                mutableRect.top = 0.0f;
                mutableRect.right = (int) (sourceCoordinates.mo423getSizeYbymL2g() >> 32);
                mutableRect.bottom = IntSize.m593getHeightimpl(sourceCoordinates.mo423getSizeYbymL2g());
                while (nodeCoordinator != findCommonAncestor$ui_release) {
                    nodeCoordinator.rectInParent$ui_release(mutableRect, z, false);
                    if (mutableRect.isEmpty()) {
                        return Rect.Zero;
                    }
                    nodeCoordinator = nodeCoordinator.wrappedBy;
                    Intrinsics.checkNotNull(nodeCoordinator);
                }
                ancestorToLocal(findCommonAncestor$ui_release, mutableRect, z);
                return new Rect(mutableRect.left, mutableRect.top, mutableRect.right, mutableRect.bottom);
            }
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public final long mo424localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long j) {
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl;
        NodeCoordinator nodeCoordinator;
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        boolean z = sourceCoordinates instanceof LookaheadLayoutCoordinatesImpl;
        if (z) {
            long mo424localPositionOfR5De75A = sourceCoordinates.mo424localPositionOfR5De75A(this, OffsetKt.Offset(-Offset.m259getXimpl(j), -Offset.m260getYimpl(j)));
            return OffsetKt.Offset(-Offset.m259getXimpl(mo424localPositionOfR5De75A), -Offset.m260getYimpl(mo424localPositionOfR5De75A));
        }
        if (z) {
            lookaheadLayoutCoordinatesImpl = (LookaheadLayoutCoordinatesImpl) sourceCoordinates;
        } else {
            lookaheadLayoutCoordinatesImpl = null;
        }
        if (lookaheadLayoutCoordinatesImpl == null || (nodeCoordinator = lookaheadLayoutCoordinatesImpl.lookaheadDelegate.coordinator) == null) {
            nodeCoordinator = (NodeCoordinator) sourceCoordinates;
        }
        nodeCoordinator.onCoordinatesUsed$ui_release();
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(nodeCoordinator);
        while (nodeCoordinator != findCommonAncestor$ui_release) {
            j = nodeCoordinator.m472toParentPositionMKHz9U(j);
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return m461ancestorToLocalR5De75A(findCommonAncestor$ui_release, j);
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public final long mo425localToRootMKHz9U(long j) {
        if (isAttached()) {
            onCoordinatesUsed$ui_release();
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
                j = nodeCoordinator.m472toParentPositionMKHz9U(j);
            }
            return j;
        }
        throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public final long mo426localToWindowMKHz9U(long j) {
        return LayoutNodeKt.requireOwner(this.layoutNode).mo483calculatePositionInWindowMKHz9U(mo425localToRootMKHz9U(j));
    }

    public final void onCoordinatesUsed$ui_release() {
        boolean z;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutNode.layoutDelegate;
        LayoutNode.LayoutState layoutState = layoutNodeLayoutDelegate.layoutNode.layoutDelegate.layoutState;
        if (layoutState == LayoutNode.LayoutState.LayingOut || layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
            if (layoutNodeLayoutDelegate.measurePassDelegate.layingOutChildren) {
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(true);
            } else {
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
        if (layoutState == LayoutNode.LayoutState.LookaheadLayingOut) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null && lookaheadPassDelegate.layingOutChildren) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringPlacement(true);
            } else {
                layoutNodeLayoutDelegate.setCoordinatesAccessedDuringModifierPlacement(true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00be A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v2, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasured() {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.onMeasured():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public final void onPlaced() {
        boolean z;
        boolean z2;
        boolean m476getIncludeSelfInTraversalH91voCI = NodeKindKt.m476getIncludeSelfInTraversalH91voCI(128);
        Modifier.Node tail = getTail();
        if (m476getIncludeSelfInTraversalH91voCI || (tail = tail.parent) != null) {
            for (Modifier.Node headNode = headNode(m476getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.aggregateChildKindSet & 128) != 0; headNode = headNode.child) {
                if ((headNode.kindSet & 128) != 0) {
                    DelegatingNode delegatingNode = headNode;
                    ?? r5 = 0;
                    while (delegatingNode != 0) {
                        if (delegatingNode instanceof LayoutAwareModifierNode) {
                            ((LayoutAwareModifierNode) delegatingNode).onPlaced(this);
                        } else {
                            if ((delegatingNode.kindSet & 128) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z && (delegatingNode instanceof DelegatingNode)) {
                                Modifier.Node node = delegatingNode.delegate;
                                int r9 = 0;
                                delegatingNode = delegatingNode;
                                r5 = r5;
                                while (node != null) {
                                    if ((node.kindSet & 128) != 0) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        r9++;
                                        r5 = r5;
                                        if (r9 == 1) {
                                            delegatingNode = node;
                                        } else {
                                            if (r5 == 0) {
                                                r5 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (delegatingNode != 0) {
                                                r5.add(delegatingNode);
                                                delegatingNode = 0;
                                            }
                                            r5.add(node);
                                        }
                                    }
                                    node = node.child;
                                    delegatingNode = delegatingNode;
                                    r5 = r5;
                                }
                                if (r9 == 1) {
                                }
                            }
                        }
                        delegatingNode = DelegatableNodeKt.access$pop(r5);
                    }
                }
                if (headNode == tail) {
                    return;
                }
            }
        }
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo422placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        m470placeSelff8xVGno(j, f, function1);
    }

    /* renamed from: placeSelf-f8xVGno */
    public final void m470placeSelff8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        updateLayerBlock(false, function1);
        if (!IntOffset.m589equalsimpl0(this.position, j)) {
            this.position = j;
            LayoutNode layoutNode = this.layoutNode;
            layoutNode.layoutDelegate.measurePassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo479movegyyYBs(j);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            LookaheadCapablePlaceable.invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = layoutNode.owner;
            if (owner != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.zIndex = f;
    }

    public final void rectInParent$ui_release(MutableRect mutableRect, boolean z, boolean z2) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z2) {
                    long m465getMinimumTouchTargetSizeNHjbRc = m465getMinimumTouchTargetSizeNHjbRc();
                    float m276getWidthimpl = Size.m276getWidthimpl(m465getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    float m274getHeightimpl = Size.m274getHeightimpl(m465getMinimumTouchTargetSizeNHjbRc) / 2.0f;
                    long j = this.measuredSize;
                    mutableRect.intersect(-m276getWidthimpl, -m274getHeightimpl, ((int) (j >> 32)) + m276getWidthimpl, IntSize.m593getHeightimpl(j) + m274getHeightimpl);
                } else if (z) {
                    long j2 = this.measuredSize;
                    mutableRect.intersect(0.0f, 0.0f, (int) (j2 >> 32), IntSize.m593getHeightimpl(j2));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        long j3 = this.position;
        int r0 = IntOffset.$r8$clinit;
        float f = (int) (j3 >> 32);
        mutableRect.left += f;
        mutableRect.right += f;
        float m590getYimpl = IntOffset.m590getYimpl(j3);
        mutableRect.top += m590getYimpl;
        mutableRect.bottom += m590getYimpl;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void replace$ui_release() {
        mo422placeAtf8xVGno(this.position, this.zIndex, this.layerBlock);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void setMeasureResult$ui_release(MeasureResult value) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult measureResult = this._measureResult;
        if (value != measureResult) {
            this._measureResult = value;
            LayoutNode layoutNode = this.layoutNode;
            boolean z3 = false;
            if (measureResult == null || value.getWidth() != measureResult.getWidth() || value.getHeight() != measureResult.getHeight()) {
                int width = value.getWidth();
                int height = value.getHeight();
                OwnedLayer ownedLayer = this.layer;
                if (ownedLayer != null) {
                    ownedLayer.mo480resizeozmzZPI(IntSizeKt.IntSize(width, height));
                } else {
                    NodeCoordinator nodeCoordinator = this.wrappedBy;
                    if (nodeCoordinator != null) {
                        nodeCoordinator.invalidateLayer();
                    }
                }
                m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
                updateLayerParameters(false);
                boolean m476getIncludeSelfInTraversalH91voCI = NodeKindKt.m476getIncludeSelfInTraversalH91voCI(4);
                Modifier.Node tail = getTail();
                if (m476getIncludeSelfInTraversalH91voCI || (tail = tail.parent) != null) {
                    for (Modifier.Node headNode = headNode(m476getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.aggregateChildKindSet & 4) != 0; headNode = headNode.child) {
                        if ((headNode.kindSet & 4) != 0) {
                            DelegatingNode delegatingNode = headNode;
                            ?? r8 = 0;
                            while (delegatingNode != 0) {
                                if (delegatingNode instanceof DrawModifierNode) {
                                    ((DrawModifierNode) delegatingNode).onMeasureResultChanged();
                                } else {
                                    if ((delegatingNode.kindSet & 4) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z && (delegatingNode instanceof DelegatingNode)) {
                                        Modifier.Node node = delegatingNode.delegate;
                                        int r10 = 0;
                                        delegatingNode = delegatingNode;
                                        r8 = r8;
                                        while (node != null) {
                                            if ((node.kindSet & 4) != 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                r10++;
                                                r8 = r8;
                                                if (r10 == 1) {
                                                    delegatingNode = node;
                                                } else {
                                                    if (r8 == 0) {
                                                        r8 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (delegatingNode != 0) {
                                                        r8.add(delegatingNode);
                                                        delegatingNode = 0;
                                                    }
                                                    r8.add(node);
                                                }
                                            }
                                            node = node.child;
                                            delegatingNode = delegatingNode;
                                            r8 = r8;
                                        }
                                        if (r10 == 1) {
                                        }
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.access$pop(r8);
                            }
                        }
                        if (headNode == tail) {
                            break;
                        }
                    }
                }
                Owner owner = layoutNode.owner;
                if (owner != null) {
                    owner.onLayoutChange(layoutNode);
                }
            }
            LinkedHashMap linkedHashMap = this.oldAlignmentLines;
            if (linkedHashMap == null || linkedHashMap.isEmpty()) {
                z3 = true;
            }
            if ((!z3 || (!value.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                layoutNode.layoutDelegate.measurePassDelegate.alignmentLines.onAlignmentsChanged();
                LinkedHashMap linkedHashMap2 = this.oldAlignmentLines;
                if (linkedHashMap2 == null) {
                    linkedHashMap2 = new LinkedHashMap();
                    this.oldAlignmentLines = linkedHashMap2;
                }
                linkedHashMap2.clear();
                linkedHashMap2.putAll(value.getAlignmentLines());
            }
        }
    }

    /* renamed from: speculativeHit-JHbHoSQ */
    public final void m471speculativeHitJHbHoSQ(final Modifier.Node node, final HitTestSource hitTestSource, final long j, final HitTestResult hitTestResult, final boolean z, final boolean z2, final float f) {
        if (node == null) {
            mo445hitTestChildYqVAtuI(hitTestSource, j, hitTestResult, z, z2);
            return;
        }
        if (hitTestSource.interceptOutOfBoundsChildEvents(node)) {
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    NodeCoordinator.this.m471speculativeHitJHbHoSQ(NodeCoordinatorKt.m475access$nextUntilhw7D004(node, hitTestSource.mo474entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, z, z2, f);
                    return Unit.INSTANCE;
                }
            };
            hitTestResult.getClass();
            if (hitTestResult.hitDepth == CollectionsKt__CollectionsKt.getLastIndex(hitTestResult)) {
                hitTestResult.hitInMinimumTouchTarget(node, f, z2, function0);
                if (hitTestResult.hitDepth + 1 == CollectionsKt__CollectionsKt.getLastIndex(hitTestResult)) {
                    hitTestResult.resizeToHitDepth();
                    return;
                }
                return;
            }
            long m444findBestHitDistanceptXAw2c = hitTestResult.m444findBestHitDistanceptXAw2c();
            int r2 = hitTestResult.hitDepth;
            hitTestResult.hitDepth = CollectionsKt__CollectionsKt.getLastIndex(hitTestResult);
            hitTestResult.hitInMinimumTouchTarget(node, f, z2, function0);
            if (hitTestResult.hitDepth + 1 < CollectionsKt__CollectionsKt.getLastIndex(hitTestResult) && DistanceAndInLayer.m442compareToS_HNhKs(m444findBestHitDistanceptXAw2c, hitTestResult.m444findBestHitDistanceptXAw2c()) > 0) {
                int r0 = hitTestResult.hitDepth + 1;
                int r1 = r2 + 1;
                Object[] objArr = hitTestResult.values;
                ArraysKt___ArraysJvmKt.copyInto(r1, r0, hitTestResult.size, objArr, objArr);
                long[] jArr = hitTestResult.distanceFromEdgeAndInLayer;
                int r4 = hitTestResult.size;
                Intrinsics.checkNotNullParameter(jArr, "<this>");
                System.arraycopy(jArr, r0, jArr, r1, r4 - r0);
                hitTestResult.hitDepth = ((hitTestResult.size + r2) - hitTestResult.hitDepth) - 1;
            }
            hitTestResult.resizeToHitDepth();
            hitTestResult.hitDepth = r2;
            return;
        }
        m471speculativeHitJHbHoSQ(NodeCoordinatorKt.m475access$nextUntilhw7D004(node, hitTestSource.mo474entityTypeOLwlOKw()), hitTestSource, j, hitTestResult, z, z2, f);
    }

    /* renamed from: toParentPosition-MK-Hz9U */
    public final long m472toParentPositionMKHz9U(long j) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j = ownedLayer.mo478mapOffset8S9VItk(j, false);
        }
        long j2 = this.position;
        float m259getXimpl = Offset.m259getXimpl(j);
        int r3 = IntOffset.$r8$clinit;
        return OffsetKt.Offset(m259getXimpl + ((int) (j2 >> 32)), Offset.m260getYimpl(j) + IntOffset.m590getYimpl(j2));
    }

    public final void updateLayerBlock(boolean z, Function1 function1) {
        boolean z2;
        Owner owner;
        LayoutNode layoutNode = this.layoutNode;
        if (!z && this.layerBlock == function1 && Intrinsics.areEqual(this.layerDensity, layoutNode.density) && this.layerLayoutDirection == layoutNode.layoutDirection) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.layerBlock = function1;
        this.layerDensity = layoutNode.density;
        this.layerLayoutDirection = layoutNode.layoutDirection;
        boolean isAttached = isAttached();
        NodeCoordinator$invalidateParentLayer$1 nodeCoordinator$invalidateParentLayer$1 = this.invalidateParentLayer;
        if (isAttached && function1 != null) {
            if (this.layer == null) {
                OwnedLayer createLayer = LayoutNodeKt.requireOwner(layoutNode).createLayer(this, nodeCoordinator$invalidateParentLayer$1);
                createLayer.mo480resizeozmzZPI(this.measuredSize);
                createLayer.mo479movegyyYBs(this.position);
                this.layer = createLayer;
                updateLayerParameters(true);
                layoutNode.innerLayerCoordinatorIsDirty = true;
                nodeCoordinator$invalidateParentLayer$1.invoke();
                return;
            }
            if (z2) {
                updateLayerParameters(true);
                return;
            }
            return;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.destroy();
            layoutNode.innerLayerCoordinatorIsDirty = true;
            nodeCoordinator$invalidateParentLayer$1.invoke();
            if (isAttached() && (owner = layoutNode.owner) != null) {
                owner.onLayoutChange(layoutNode);
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    public final void updateLayerParameters(boolean z) {
        Owner owner;
        OwnedLayer ownedLayer = this.layer;
        boolean z2 = false;
        if (ownedLayer != null) {
            final Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.scaleX = 1.0f;
                reusableGraphicsLayerScope.scaleY = 1.0f;
                reusableGraphicsLayerScope.alpha = 1.0f;
                reusableGraphicsLayerScope.translationX = 0.0f;
                reusableGraphicsLayerScope.translationY = 0.0f;
                reusableGraphicsLayerScope.shadowElevation = 0.0f;
                long j = GraphicsLayerScopeKt.DefaultShadowColor;
                reusableGraphicsLayerScope.ambientShadowColor = j;
                reusableGraphicsLayerScope.spotShadowColor = j;
                reusableGraphicsLayerScope.rotationX = 0.0f;
                reusableGraphicsLayerScope.rotationY = 0.0f;
                reusableGraphicsLayerScope.rotationZ = 0.0f;
                reusableGraphicsLayerScope.cameraDistance = 8.0f;
                reusableGraphicsLayerScope.transformOrigin = TransformOrigin.Center;
                reusableGraphicsLayerScope.shape = RectangleShapeKt.RectangleShape;
                reusableGraphicsLayerScope.clip = false;
                reusableGraphicsLayerScope.compositingStrategy = 0;
                int r2 = Size.$r8$clinit;
                LayoutNode layoutNode = this.layoutNode;
                Density density = layoutNode.density;
                Intrinsics.checkNotNullParameter(density, "<set-?>");
                reusableGraphicsLayerScope.graphicsDensity = density;
                IntSizeKt.m595toSizeozmzZPI(this.measuredSize);
                LayoutNodeKt.requireOwner(layoutNode).getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        function1.invoke(NodeCoordinator.graphicsLayerScope);
                        return Unit.INSTANCE;
                    }
                });
                LayerPositionalProperties layerPositionalProperties = this.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    layerPositionalProperties = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties;
                }
                float f = reusableGraphicsLayerScope.scaleX;
                layerPositionalProperties.scaleX = f;
                float f2 = reusableGraphicsLayerScope.scaleY;
                layerPositionalProperties.scaleY = f2;
                float f3 = reusableGraphicsLayerScope.translationX;
                layerPositionalProperties.translationX = f3;
                float f4 = reusableGraphicsLayerScope.translationY;
                layerPositionalProperties.translationY = f4;
                float f5 = reusableGraphicsLayerScope.rotationX;
                layerPositionalProperties.rotationX = f5;
                float f6 = reusableGraphicsLayerScope.rotationY;
                layerPositionalProperties.rotationY = f6;
                float f7 = reusableGraphicsLayerScope.rotationZ;
                layerPositionalProperties.rotationZ = f7;
                float f8 = reusableGraphicsLayerScope.cameraDistance;
                layerPositionalProperties.cameraDistance = f8;
                long j2 = reusableGraphicsLayerScope.transformOrigin;
                layerPositionalProperties.transformOrigin = j2;
                ownedLayer.mo481updateLayerPropertiesdDxrwY(f, f2, reusableGraphicsLayerScope.alpha, f3, f4, reusableGraphicsLayerScope.shadowElevation, f5, f6, f7, f8, j2, reusableGraphicsLayerScope.shape, reusableGraphicsLayerScope.clip, reusableGraphicsLayerScope.ambientShadowColor, reusableGraphicsLayerScope.spotShadowColor, reusableGraphicsLayerScope.compositingStrategy, layoutNode.layoutDirection, layoutNode.density);
                this.isClipping = reusableGraphicsLayerScope.clip;
                this.lastLayerAlpha = reusableGraphicsLayerScope.alpha;
                if (z && (owner = layoutNode.owner) != null) {
                    owner.onLayoutChange(layoutNode);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        if (this.layerBlock == null) {
            z2 = true;
        }
        if (z2) {
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @Override // androidx.compose.ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public final long mo427windowToLocalMKHz9U(long j) {
        if (isAttached()) {
            LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
            return mo424localPositionOfR5De75A(findRootCoordinates, Offset.m261minusMKHz9U(LayoutNodeKt.requireOwner(this.layoutNode).mo482calculateLocalPositionMKHz9U(j), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
        }
        throw new IllegalStateException("LayoutCoordinate operations are only valid when isAttached is true".toString());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getCoordinates() {
        return this;
    }
}
