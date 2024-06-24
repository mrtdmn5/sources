package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadDelegate.kt */
/* loaded from: classes.dex */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    public MeasureResult _measureResult;
    public final LinkedHashMap cachedAlignmentLinesMap;
    public final NodeCoordinator coordinator;
    public final LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates;
    public LinkedHashMap oldAlignmentLines;
    public long position;

    public LookaheadDelegate(NodeCoordinator coordinator) {
        Intrinsics.checkNotNullParameter(coordinator, "coordinator");
        this.coordinator = coordinator;
        this.position = IntOffset.Zero;
        this.lookaheadLayoutCoordinates = new LookaheadLayoutCoordinatesImpl(this);
        this.cachedAlignmentLinesMap = new LinkedHashMap();
    }

    public static final void access$set_measureResult(LookaheadDelegate lookaheadDelegate, MeasureResult measureResult) {
        Unit unit;
        boolean z;
        if (measureResult != null) {
            lookaheadDelegate.getClass();
            lookaheadDelegate.m430setMeasuredSizeozmzZPI(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            lookaheadDelegate.m430setMeasuredSizeozmzZPI(0L);
        }
        if (!Intrinsics.areEqual(lookaheadDelegate._measureResult, measureResult) && measureResult != null) {
            LinkedHashMap linkedHashMap = lookaheadDelegate.oldAlignmentLines;
            if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if ((!z || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), lookaheadDelegate.oldAlignmentLines)) {
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = lookaheadDelegate.coordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.alignmentLines.onAlignmentsChanged();
                LinkedHashMap linkedHashMap2 = lookaheadDelegate.oldAlignmentLines;
                if (linkedHashMap2 == null) {
                    linkedHashMap2 = new LinkedHashMap();
                    lookaheadDelegate.oldAlignmentLines = linkedHashMap2;
                }
                linkedHashMap2.clear();
                linkedHashMap2.putAll(measureResult.getAlignmentLines());
            }
        }
        lookaheadDelegate._measureResult = measureResult;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getChild() {
        NodeCoordinator nodeCoordinator = this.coordinator.wrapped;
        if (nodeCoordinator != null) {
            return nodeCoordinator.getLookaheadDelegate();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public final float getFontScale() {
        return this.coordinator.getFontScale();
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
        return this.coordinator.layoutNode.layoutDirection;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LayoutNode getLayoutNode() {
        return this.coordinator.layoutNode;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.".toString());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final LookaheadCapablePlaceable getParent() {
        NodeCoordinator nodeCoordinator = this.coordinator.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.getLookaheadDelegate();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public final Object getParentData() {
        return this.coordinator.getParentData();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac */
    public final long mo454getPositionnOccac() {
        return this.position;
    }

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public final void mo422placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        if (!IntOffset.m589equalsimpl0(this.position, j)) {
            this.position = j;
            NodeCoordinator nodeCoordinator = this.coordinator;
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = nodeCoordinator.layoutNode.layoutDelegate.lookaheadPassDelegate;
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
            }
            LookaheadCapablePlaceable.invalidateAlignmentLinesFromPositionChange(nodeCoordinator);
        }
        if (this.isShallowPlacing) {
            return;
        }
        placeChildren();
    }

    public void placeChildren() {
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int width = getMeasureResult$ui_release().getWidth();
        LayoutDirection layoutDirection = this.coordinator.layoutNode.layoutDirection;
        LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
        companion.getClass();
        int r4 = Placeable.PlacementScope.parentWidth;
        LayoutDirection layoutDirection2 = Placeable.PlacementScope.parentLayoutDirection;
        Placeable.PlacementScope.parentWidth = width;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        boolean access$configureForPlacingForAlignment = Placeable.PlacementScope.Companion.access$configureForPlacingForAlignment(companion, this);
        getMeasureResult$ui_release().placeChildren();
        this.isPlacingForAlignment = access$configureForPlacingForAlignment;
        Placeable.PlacementScope.parentWidth = r4;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection2;
        Placeable.PlacementScope._coordinates = layoutCoordinates;
    }

    /* renamed from: positionIn-Bjo55l4$ui_release */
    public final long m455positionInBjo55l4$ui_release(LookaheadDelegate lookaheadDelegate) {
        long j = IntOffset.Zero;
        LookaheadDelegate lookaheadDelegate2 = this;
        while (!Intrinsics.areEqual(lookaheadDelegate2, lookaheadDelegate)) {
            long j2 = lookaheadDelegate2.position;
            j = IntOffsetKt.IntOffset(((int) (j >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(j));
            NodeCoordinator nodeCoordinator = lookaheadDelegate2.coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            lookaheadDelegate2 = nodeCoordinator.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate2);
        }
        return j;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public final void replace$ui_release() {
        mo422placeAtf8xVGno(this.position, 0.0f, null);
    }
}
