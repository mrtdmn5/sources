package androidx.compose.ui.layout;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasureScope.kt */
/* loaded from: classes.dex */
public interface MeasureScope extends IntrinsicMeasureScope {
    default MeasureResult layout(final int r8, final int r9, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        Intrinsics.checkNotNullParameter(alignmentLines, "alignmentLines");
        Intrinsics.checkNotNullParameter(placementBlock, "placementBlock");
        return new MeasureResult(r8, r9, alignmentLines, this, placementBlock) { // from class: androidx.compose.ui.layout.MeasureScope$layout$1
            public final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
            public final /* synthetic */ int $width;
            public final Map<AlignmentLine, Integer> alignmentLines;
            public final int height;
            public final /* synthetic */ MeasureScope this$0;
            public final int width;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$width = r8;
                this.this$0 = this;
                this.$placementBlock = placementBlock;
                this.width = r8;
                this.height = r9;
                this.alignmentLines = alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public final void placeChildren() {
                LookaheadCapablePlaceable lookaheadCapablePlaceable;
                Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
                MeasureScope measureScope = this.this$0;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                if (measureScope instanceof LookaheadCapablePlaceable) {
                    lookaheadCapablePlaceable = (LookaheadCapablePlaceable) measureScope;
                } else {
                    lookaheadCapablePlaceable = null;
                }
                LayoutCoordinates layoutCoordinates = Placeable.PlacementScope._coordinates;
                companion.getClass();
                int r4 = Placeable.PlacementScope.parentWidth;
                LayoutDirection layoutDirection2 = Placeable.PlacementScope.parentLayoutDirection;
                Placeable.PlacementScope.parentWidth = this.$width;
                Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
                boolean access$configureForPlacingForAlignment = Placeable.PlacementScope.Companion.access$configureForPlacingForAlignment(companion, lookaheadCapablePlaceable);
                this.$placementBlock.invoke(companion);
                if (lookaheadCapablePlaceable != null) {
                    lookaheadCapablePlaceable.isPlacingForAlignment = access$configureForPlacingForAlignment;
                }
                Placeable.PlacementScope.parentWidth = r4;
                Placeable.PlacementScope.parentLayoutDirection = layoutDirection2;
                Placeable.PlacementScope._coordinates = layoutCoordinates;
            }
        };
    }
}
