package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MeasuredPage.kt */
/* loaded from: classes.dex */
public final class MeasuredPage implements PageInfo {
    public final int crossAxisSize;
    public final Alignment.Horizontal horizontalAlignment;
    public final int index;
    public final boolean isVertical;
    public final Object key;
    public final LayoutDirection layoutDirection;
    public int mainAxisLayoutSize;
    public int offset;
    public final int[] placeableOffsets;
    public final List<Placeable> placeables;
    public final boolean reverseLayout;
    public final int size;
    public final Alignment.Vertical verticalAlignment;
    public final long visualOffset;

    public MeasuredPage() {
        throw null;
    }

    public MeasuredPage(int r2, int r3, List placeables, long j, Object obj, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z) {
        int r6;
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.index = r2;
        this.size = r3;
        this.placeables = placeables;
        this.visualOffset = j;
        this.key = obj;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z;
        this.isVertical = orientation == Orientation.Vertical;
        int size = placeables.size();
        int r5 = 0;
        for (int r32 = 0; r32 < size; r32++) {
            Placeable placeable = (Placeable) placeables.get(r32);
            if (!this.isVertical) {
                r6 = placeable.height;
            } else {
                r6 = placeable.width;
            }
            r5 = Math.max(r5, r6);
        }
        this.crossAxisSize = r5;
        this.placeableOffsets = new int[this.placeables.size() * 2];
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.pager.PageInfo
    public final int getOffset() {
        return this.offset;
    }

    public final void position(int r11, int r12, int r13) {
        int r1;
        int r4;
        this.offset = r11;
        boolean z = this.isVertical;
        if (z) {
            r1 = r13;
        } else {
            r1 = r12;
        }
        this.mainAxisLayoutSize = r1;
        List<Placeable> list = this.placeables;
        int size = list.size();
        for (int r3 = 0; r3 < size; r3++) {
            Placeable placeable = list.get(r3);
            int r5 = r3 * 2;
            int[] r7 = this.placeableOffsets;
            if (z) {
                Alignment.Horizontal horizontal = this.horizontalAlignment;
                if (horizontal != null) {
                    r7[r5] = horizontal.align(placeable.width, r12, this.layoutDirection);
                    r7[r5 + 1] = r11;
                    r4 = placeable.height;
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                r7[r5] = r11;
                int r52 = r5 + 1;
                Alignment.Vertical vertical = this.verticalAlignment;
                if (vertical != null) {
                    r7[r52] = vertical.align(placeable.height, r13);
                    r4 = placeable.width;
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
            r11 += r4;
        }
    }
}
