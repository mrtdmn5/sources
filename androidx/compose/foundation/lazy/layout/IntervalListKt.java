package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.collection.MutableVector;

/* compiled from: IntervalList.kt */
/* loaded from: classes.dex */
public final class IntervalListKt {
    public static final int access$binarySearch(int r5, MutableVector mutableVector) {
        int r0 = mutableVector.size - 1;
        int r1 = 0;
        while (r1 < r0) {
            int r2 = ((r0 - r1) / 2) + r1;
            Object[] objArr = mutableVector.content;
            int r4 = ((IntervalList$Interval) objArr[r2]).startIndex;
            if (r4 != r5) {
                if (r4 < r5) {
                    r1 = r2 + 1;
                    if (r5 < ((IntervalList$Interval) objArr[r1]).startIndex) {
                    }
                } else {
                    r0 = r2 - 1;
                }
            }
            return r2;
        }
        return r1;
    }
}
