package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.runtime.collection.MutableVector;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.ArrayIteratorsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyLayoutBeyondBoundsState.kt */
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider lazyLayoutItemProvider, LazyLayoutPinnedItemList pinnedItemList, LazyLayoutBeyondBoundsInfo beyondBoundsInfo) {
        IntRange intRange;
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "<this>");
        Intrinsics.checkNotNullParameter(pinnedItemList, "pinnedItemList");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        MutableVector<LazyLayoutBeyondBoundsInfo.Interval> mutableVector = beyondBoundsInfo.beyondBoundsItems;
        if (!mutableVector.isNotEmpty() && pinnedItemList.isEmpty()) {
            return EmptyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        if (mutableVector.isNotEmpty()) {
            if (!mutableVector.isEmpty()) {
                LazyLayoutBeyondBoundsInfo.Interval[] intervalArr = mutableVector.content;
                int r6 = intervalArr[0].start;
                int r7 = mutableVector.size;
                if (r7 > 0) {
                    int r8 = 0;
                    do {
                        int r9 = intervalArr[r8].start;
                        if (r9 < r6) {
                            r6 = r9;
                        }
                        r8++;
                    } while (r8 < r7);
                }
                if (r6 >= 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    if (!mutableVector.isEmpty()) {
                        LazyLayoutBeyondBoundsInfo.Interval[] intervalArr2 = mutableVector.content;
                        int r5 = intervalArr2[0].end;
                        int r12 = mutableVector.size;
                        if (r12 > 0) {
                            int r72 = 0;
                            do {
                                int r82 = intervalArr2[r72].end;
                                if (r82 > r5) {
                                    r5 = r82;
                                }
                                r72++;
                            } while (r72 < r12);
                        }
                        intRange = new IntRange(r6, Math.min(r5, lazyLayoutItemProvider.getItemCount() - 1));
                    } else {
                        throw new NoSuchElementException("MutableVector is empty.");
                    }
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            } else {
                throw new NoSuchElementException("MutableVector is empty.");
            }
        } else {
            intRange = IntRange.EMPTY;
        }
        int size = pinnedItemList.size();
        for (int r4 = 0; r4 < size; r4++) {
            LazyLayoutPinnedItemList.PinnedItem pinnedItem = (LazyLayoutPinnedItemList.PinnedItem) pinnedItemList.get(r4);
            int findIndexByKey = ArrayIteratorsKt.findIndexByKey(lazyLayoutItemProvider, pinnedItem.getKey(), pinnedItem.getIndex());
            int r62 = intRange.first;
            if (findIndexByKey <= intRange.last && r62 <= findIndexByKey) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (findIndexByKey >= 0 && findIndexByKey < lazyLayoutItemProvider.getItemCount()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(Integer.valueOf(findIndexByKey));
                }
            }
        }
        int r10 = intRange.first;
        int r11 = intRange.last;
        if (r10 <= r11) {
            while (true) {
                arrayList.add(Integer.valueOf(r10));
                if (r10 == r11) {
                    break;
                }
                r10++;
            }
        }
        return arrayList;
    }
}
