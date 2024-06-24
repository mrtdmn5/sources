package androidx.compose.ui.layout;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Placeable.kt */
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    public long apparentToRealOffset;
    public int height;
    public long measuredSize = IntSizeKt.IntSize(0, 0);
    public long measurementConstraints = PlaceableKt.DefaultConstraints;
    public int width;

    /* compiled from: Placeable.kt */
    /* loaded from: classes.dex */
    public static abstract class PlacementScope {
        public static LayoutCoordinates _coordinates;
        public static int parentWidth;
        public static final Companion Companion = new Companion(0);
        public static LayoutDirection parentLayoutDirection = LayoutDirection.Ltr;

        /* compiled from: Placeable.kt */
        /* loaded from: classes.dex */
        public static final class Companion extends PlacementScope {
            public Companion(int r1) {
            }

            public static final boolean access$configureForPlacingForAlignment(Companion companion, LookaheadCapablePlaceable lookaheadCapablePlaceable) {
                companion.getClass();
                boolean z = false;
                if (lookaheadCapablePlaceable == null) {
                    PlacementScope._coordinates = null;
                    return false;
                }
                boolean z2 = lookaheadCapablePlaceable.isPlacingForAlignment;
                LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
                if (parent != null && parent.isPlacingForAlignment) {
                    z = true;
                }
                if (z) {
                    lookaheadCapablePlaceable.isPlacingForAlignment = true;
                }
                LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = lookaheadCapablePlaceable.getLayoutNode().layoutDelegate;
                if (!lookaheadCapablePlaceable.isPlacingForAlignment && !lookaheadCapablePlaceable.isShallowPlacing) {
                    PlacementScope._coordinates = lookaheadCapablePlaceable.getCoordinates();
                } else {
                    PlacementScope._coordinates = null;
                }
                return z2;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public final LayoutDirection getParentLayoutDirection() {
                return PlacementScope.parentLayoutDirection;
            }

            @Override // androidx.compose.ui.layout.Placeable.PlacementScope
            public final int getParentWidth() {
                return PlacementScope.parentWidth;
            }
        }

        public static void place(Placeable placeable, int r7, int r8, float f) {
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(r7, r8);
            long j = placeable.apparentToRealOffset;
            placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j >> 32)), IntOffset.m590getYimpl(j) + IntOffset.m590getYimpl(IntOffset)), f, null);
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int r2, int r3) {
            placementScope.getClass();
            place(placeable, r2, r3, 0.0f);
        }

        /* renamed from: place-70tqf50, reason: not valid java name */
        public static void m432place70tqf50(Placeable place, long j, float f) {
            Intrinsics.checkNotNullParameter(place, "$this$place");
            long j2 = place.apparentToRealOffset;
            place.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (j >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(j)), f, null);
        }

        /* renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m433place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j) {
            placementScope.getClass();
            m432place70tqf50(placeable, j, 0.0f);
        }

        public static void placeRelative$default(PlacementScope placementScope, Placeable placeable, int r9, int r10) {
            placementScope.getClass();
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            long IntOffset = IntOffsetKt.IntOffset(r9, r10);
            if (placementScope.getParentLayoutDirection() != LayoutDirection.Ltr && placementScope.getParentWidth() != 0) {
                long IntOffset2 = IntOffsetKt.IntOffset((placementScope.getParentWidth() - placeable.width) - ((int) (IntOffset >> 32)), IntOffset.m590getYimpl(IntOffset));
                long j = placeable.apparentToRealOffset;
                placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset2 >> 32)) + ((int) (j >> 32)), IntOffset.m590getYimpl(j) + IntOffset.m590getYimpl(IntOffset2)), 0.0f, null);
                return;
            }
            long j2 = placeable.apparentToRealOffset;
            placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(IntOffset)), 0.0f, null);
        }

        public static void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int r9, int r10) {
            PlaceableKt$DefaultLayerBlock$1 layerBlock = PlaceableKt.DefaultLayerBlock;
            placementScope.getClass();
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(r9, r10);
            if (placementScope.getParentLayoutDirection() != LayoutDirection.Ltr && placementScope.getParentWidth() != 0) {
                long IntOffset2 = IntOffsetKt.IntOffset((placementScope.getParentWidth() - placeable.width) - ((int) (IntOffset >> 32)), IntOffset.m590getYimpl(IntOffset));
                long j = placeable.apparentToRealOffset;
                placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset2 >> 32)) + ((int) (j >> 32)), IntOffset.m590getYimpl(j) + IntOffset.m590getYimpl(IntOffset2)), 0.0f, layerBlock);
                return;
            }
            long j2 = placeable.apparentToRealOffset;
            placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(IntOffset)), 0.0f, layerBlock);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static void m434placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeRelativeWithLayer, long j) {
            PlaceableKt$DefaultLayerBlock$1 layerBlock = PlaceableKt.DefaultLayerBlock;
            placementScope.getClass();
            Intrinsics.checkNotNullParameter(placeRelativeWithLayer, "$this$placeRelativeWithLayer");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            if (placementScope.getParentLayoutDirection() != LayoutDirection.Ltr && placementScope.getParentWidth() != 0) {
                long IntOffset = IntOffsetKt.IntOffset((placementScope.getParentWidth() - placeRelativeWithLayer.width) - ((int) (j >> 32)), IntOffset.m590getYimpl(j));
                long j2 = placeRelativeWithLayer.apparentToRealOffset;
                placeRelativeWithLayer.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(IntOffset)), 0.0f, layerBlock);
                return;
            }
            long j3 = placeRelativeWithLayer.apparentToRealOffset;
            placeRelativeWithLayer.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (j >> 32)) + ((int) (j3 >> 32)), IntOffset.m590getYimpl(j3) + IntOffset.m590getYimpl(j)), 0.0f, layerBlock);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int r6, int r7, Function1 layerBlock, int r9) {
            if ((r9 & 8) != 0) {
                layerBlock = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.getClass();
            Intrinsics.checkNotNullParameter(placeable, "<this>");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long IntOffset = IntOffsetKt.IntOffset(r6, r7);
            long j = placeable.apparentToRealOffset;
            placeable.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (j >> 32)), IntOffset.m590getYimpl(j) + IntOffset.m590getYimpl(IntOffset)), 0.0f, layerBlock);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public static void m435placeWithLayeraW9wM(Placeable placeWithLayer, long j, float f, Function1 layerBlock) {
            Intrinsics.checkNotNullParameter(placeWithLayer, "$this$placeWithLayer");
            Intrinsics.checkNotNullParameter(layerBlock, "layerBlock");
            long j2 = placeWithLayer.apparentToRealOffset;
            placeWithLayer.mo422placeAtf8xVGno(IntOffsetKt.IntOffset(((int) (j >> 32)) + ((int) (j2 >> 32)), IntOffset.m590getYimpl(j2) + IntOffset.m590getYimpl(j)), f, layerBlock);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m436placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j) {
            PlaceableKt$DefaultLayerBlock$1 placeableKt$DefaultLayerBlock$1 = PlaceableKt.DefaultLayerBlock;
            placementScope.getClass();
            m435placeWithLayeraW9wM(placeable, j, 0.0f, placeableKt$DefaultLayerBlock$1);
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();
    }

    public Placeable() {
        int r0 = IntOffset.$r8$clinit;
        this.apparentToRealOffset = IntOffset.Zero;
    }

    public int getMeasuredHeight() {
        return IntSize.m593getHeightimpl(this.measuredSize);
    }

    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    public final void onMeasuredSizeChanged() {
        this.width = RangesKt___RangesKt.coerceIn((int) (this.measuredSize >> 32), Constraints.m567getMinWidthimpl(this.measurementConstraints), Constraints.m565getMaxWidthimpl(this.measurementConstraints));
        int coerceIn = RangesKt___RangesKt.coerceIn(IntSize.m593getHeightimpl(this.measuredSize), Constraints.m566getMinHeightimpl(this.measurementConstraints), Constraints.m564getMaxHeightimpl(this.measurementConstraints));
        this.height = coerceIn;
        int r1 = this.width;
        long j = this.measuredSize;
        this.apparentToRealOffset = IntOffsetKt.IntOffset((r1 - ((int) (j >> 32))) / 2, (coerceIn - IntSize.m593getHeightimpl(j)) / 2);
    }

    /* renamed from: placeAt-f8xVGno */
    public abstract void mo422placeAtf8xVGno(long j, float f, Function1<? super GraphicsLayerScope, Unit> function1);

    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m430setMeasuredSizeozmzZPI(long j) {
        if (!IntSize.m592equalsimpl0(this.measuredSize, j)) {
            this.measuredSize = j;
            onMeasuredSizeChanged();
        }
    }

    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m431setMeasurementConstraintsBRTryo0(long j) {
        if (!Constraints.m559equalsimpl0(this.measurementConstraints, j)) {
            this.measurementConstraints = j;
            onMeasuredSizeChanged();
        }
    }
}
