package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RowColumnMeasurementHelper.kt */
/* loaded from: classes.dex */
public final class RowColumnMeasurementHelper {
    public final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> arrangement;
    public final float arrangementSpacing;
    public final CrossAxisAlignment crossAxisAlignment;
    public final SizeMode crossAxisSize;
    public final List<Measurable> measurables;
    public final LayoutOrientation orientation;
    public final Placeable[] placeables;
    public final RowColumnParentData[] rowColumnParentData;

    public RowColumnMeasurementHelper(LayoutOrientation orientation, Function5 arrangement, float f, SizeMode crossAxisSize, CrossAxisAlignment crossAxisAlignment, List measurables, Placeable[] placeableArr) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        Intrinsics.checkNotNullParameter(measurables, "measurables");
        this.orientation = orientation;
        this.arrangement = arrangement;
        this.arrangementSpacing = f;
        this.crossAxisSize = crossAxisSize;
        this.crossAxisAlignment = crossAxisAlignment;
        this.measurables = measurables;
        this.placeables = placeableArr;
        int size = measurables.size();
        RowColumnParentData[] rowColumnParentDataArr = new RowColumnParentData[size];
        for (int r4 = 0; r4 < size; r4++) {
            rowColumnParentDataArr[r4] = RowColumnImplKt.getRowColumnParentData(this.measurables.get(r4));
        }
        this.rowColumnParentData = rowColumnParentDataArr;
    }

    public final int crossAxisSize(Placeable placeable) {
        if (this.orientation == LayoutOrientation.Horizontal) {
            return placeable.height;
        }
        return placeable.width;
    }

    public final int mainAxisSize(Placeable placeable) {
        Intrinsics.checkNotNullParameter(placeable, "<this>");
        if (this.orientation == LayoutOrientation.Horizontal) {
            return placeable.width;
        }
        return placeable.height;
    }
}
