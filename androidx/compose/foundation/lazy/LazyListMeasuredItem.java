package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListMeasuredItem.kt */
/* loaded from: classes.dex */
public final class LazyListMeasuredItem implements LazyListItemInfo {
    public final Object contentType;
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
    public final int sizeWithSpacings;
    public final int spacing;
    public final Alignment.Vertical verticalAlignment;
    public final long visualOffset;

    public LazyListMeasuredItem() {
        throw null;
    }

    public LazyListMeasuredItem(int r1, List placeables, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int r8, int r9, int r10, long j, Object key, Object obj) {
        int r92;
        int r7;
        Intrinsics.checkNotNullParameter(placeables, "placeables");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(key, "key");
        this.index = r1;
        this.placeables = placeables;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection;
        this.reverseLayout = z2;
        this.spacing = r10;
        this.visualOffset = j;
        this.key = key;
        this.contentType = obj;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        int size = placeables.size();
        int r5 = 0;
        int r6 = 0;
        for (int r4 = 0; r4 < size; r4++) {
            Placeable placeable = (Placeable) placeables.get(r4);
            boolean z3 = this.isVertical;
            if (z3) {
                r92 = placeable.height;
            } else {
                r92 = placeable.width;
            }
            r5 += r92;
            if (!z3) {
                r7 = placeable.height;
            } else {
                r7 = placeable.width;
            }
            r6 = Math.max(r6, r7);
        }
        this.size = r5;
        int r52 = r5 + this.spacing;
        this.sizeWithSpacings = r52 >= 0 ? r52 : 0;
        this.crossAxisSize = r6;
        this.placeableOffsets = new int[this.placeables.size() * 2];
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final int getOffset() {
        return this.offset;
    }

    /* renamed from: getOffset-Bjo55l4, reason: not valid java name */
    public final long m97getOffsetBjo55l4(int r3) {
        int r32 = r3 * 2;
        int[] r0 = this.placeableOffsets;
        return IntOffsetKt.IntOffset(r0[r32], r0[r32 + 1]);
    }

    public final Object getParentData(int r2) {
        return this.placeables.get(r2).getParentData();
    }

    public final int getPlaceablesCount() {
        return this.placeables.size();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemInfo
    public final int getSize() {
        return this.size;
    }

    public final void place(Placeable.PlacementScope scope) {
        boolean z;
        LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode;
        int m590getYimpl;
        int r4;
        int r6;
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (this.mainAxisLayoutSize != Integer.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int placeablesCount = getPlaceablesCount();
            for (int r2 = 0; r2 < placeablesCount; r2++) {
                Placeable placeable = this.placeables.get(r2);
                boolean z2 = this.isVertical;
                if (z2) {
                    int r42 = placeable.height;
                } else {
                    int r43 = placeable.width;
                }
                long m97getOffsetBjo55l4 = m97getOffsetBjo55l4(r2);
                Object parentData = getParentData(r2);
                if (parentData instanceof LazyLayoutAnimateItemModifierNode) {
                    lazyLayoutAnimateItemModifierNode = (LazyLayoutAnimateItemModifierNode) parentData;
                } else {
                    lazyLayoutAnimateItemModifierNode = null;
                }
                if (lazyLayoutAnimateItemModifierNode == null) {
                    if (this.reverseLayout) {
                        int r62 = IntOffset.$r8$clinit;
                        int r63 = (int) (m97getOffsetBjo55l4 >> 32);
                        if (!z2) {
                            int r8 = this.mainAxisLayoutSize - r63;
                            if (z2) {
                                r6 = placeable.height;
                            } else {
                                r6 = placeable.width;
                            }
                            r63 = r8 - r6;
                        }
                        if (z2) {
                            int m590getYimpl2 = this.mainAxisLayoutSize - IntOffset.m590getYimpl(m97getOffsetBjo55l4);
                            if (z2) {
                                r4 = placeable.height;
                            } else {
                                r4 = placeable.width;
                            }
                            m590getYimpl = m590getYimpl2 - r4;
                        } else {
                            m590getYimpl = IntOffset.m590getYimpl(m97getOffsetBjo55l4);
                        }
                        m97getOffsetBjo55l4 = IntOffsetKt.IntOffset(r63, m590getYimpl);
                    }
                    long j = this.visualOffset;
                    long IntOffset = IntOffsetKt.IntOffset(((int) (m97getOffsetBjo55l4 >> 32)) + ((int) (j >> 32)), IntOffset.m590getYimpl(j) + IntOffset.m590getYimpl(m97getOffsetBjo55l4));
                    if (z2) {
                        Placeable.PlacementScope.m436placeWithLayeraW9wM$default(scope, placeable, IntOffset);
                    } else {
                        Placeable.PlacementScope.m434placeRelativeWithLayeraW9wM$default(scope, placeable, IntOffset);
                    }
                } else {
                    throw null;
                }
            }
            return;
        }
        throw new IllegalArgumentException("position() should be called first".toString());
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
