package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateItemModifierNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: LazyListItemPlacementAnimator.kt */
/* loaded from: classes.dex */
public final class LazyListItemPlacementAnimator {
    public int firstVisibleIndex;
    public final LinkedHashSet activeKeys = new LinkedHashSet();
    public LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.Empty.$$INSTANCE;
    public final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    public final ArrayList movingInFromStartBound = new ArrayList();
    public final ArrayList movingInFromEndBound = new ArrayList();
    public final ArrayList movingAwayToStartBound = new ArrayList();
    public final ArrayList movingAwayToEndBound = new ArrayList();

    public static void initializeNode(LazyListMeasuredItem lazyListMeasuredItem, int r13) {
        long IntOffset;
        LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode;
        long m97getOffsetBjo55l4 = lazyListMeasuredItem.m97getOffsetBjo55l4(0);
        if (lazyListMeasuredItem.isVertical) {
            int r3 = IntOffset.$r8$clinit;
            IntOffset = IntOffsetKt.IntOffset((int) (m97getOffsetBjo55l4 >> 32), r13);
        } else {
            IntOffset = IntOffsetKt.IntOffset(r13, IntOffset.m590getYimpl(m97getOffsetBjo55l4));
        }
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int r0 = 0; r0 < placeablesCount; r0++) {
            Object parentData = lazyListMeasuredItem.getParentData(r0);
            if (parentData instanceof LazyLayoutAnimateItemModifierNode) {
                lazyLayoutAnimateItemModifierNode = (LazyLayoutAnimateItemModifierNode) parentData;
            } else {
                lazyLayoutAnimateItemModifierNode = null;
            }
            if (lazyLayoutAnimateItemModifierNode != null) {
                long m97getOffsetBjo55l42 = lazyListMeasuredItem.m97getOffsetBjo55l4(r0);
                long IntOffset2 = IntOffsetKt.IntOffset(((int) (m97getOffsetBjo55l42 >> 32)) - ((int) (m97getOffsetBjo55l4 >> 32)), IntOffset.m590getYimpl(m97getOffsetBjo55l42) - IntOffset.m590getYimpl(m97getOffsetBjo55l4));
                lazyLayoutAnimateItemModifierNode.rawOffset = IntOffsetKt.IntOffset(((int) (IntOffset >> 32)) + ((int) (IntOffset2 >> 32)), IntOffset.m590getYimpl(IntOffset2) + IntOffset.m590getYimpl(IntOffset));
            }
        }
    }

    public static void startAnimationsIfNeeded(LazyListMeasuredItem lazyListMeasuredItem) {
        LazyLayoutAnimateItemModifierNode lazyLayoutAnimateItemModifierNode;
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int r1 = 0; r1 < placeablesCount; r1++) {
            Object parentData = lazyListMeasuredItem.getParentData(r1);
            if (parentData instanceof LazyLayoutAnimateItemModifierNode) {
                lazyLayoutAnimateItemModifierNode = (LazyLayoutAnimateItemModifierNode) parentData;
            } else {
                lazyLayoutAnimateItemModifierNode = null;
            }
            if (lazyLayoutAnimateItemModifierNode != null) {
                long m97getOffsetBjo55l4 = lazyListMeasuredItem.m97getOffsetBjo55l4(r1);
                long j = lazyLayoutAnimateItemModifierNode.rawOffset;
                if (!IntOffset.m589equalsimpl0(j, LazyLayoutAnimateItemModifierNode.NotInitialized) && !IntOffset.m589equalsimpl0(j, m97getOffsetBjo55l4)) {
                    IntOffsetKt.IntOffset(((int) (m97getOffsetBjo55l4 >> 32)) - ((int) (j >> 32)), IntOffset.m590getYimpl(m97getOffsetBjo55l4) - IntOffset.m590getYimpl(j));
                    throw null;
                }
                lazyLayoutAnimateItemModifierNode.rawOffset = m97getOffsetBjo55l4;
            }
        }
    }
}
