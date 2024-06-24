package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.collection.MutableVector;

/* compiled from: IntervalList.kt */
/* loaded from: classes.dex */
public final class MutableIntervalList<T> {
    public final MutableVector<IntervalList$Interval<T>> intervals = new MutableVector<>(new IntervalList$Interval[16]);
    public IntervalList$Interval<? extends T> lastInterval;
    public int size;

    public final void addInterval(int r3, LazyLayoutIntervalContent.Interval interval) {
        boolean z;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r3 == 0) {
                return;
            }
            IntervalList$Interval intervalList$Interval = new IntervalList$Interval(this.size, r3, interval);
            this.size += r3;
            this.intervals.add(intervalList$Interval);
            return;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("size should be >=0, but was ", r3).toString());
    }

    public final void checkIndexBounds(int r4) {
        boolean z = false;
        if (r4 >= 0 && r4 < this.size) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Index ", r4, ", size ");
        m.append(this.size);
        throw new IndexOutOfBoundsException(m.toString());
    }

    public final void forEach(int r5, int r6, NearestRangeKeyIndexMap$1$1 nearestRangeKeyIndexMap$1$1) {
        boolean z;
        checkIndexBounds(r5);
        checkIndexBounds(r6);
        if (r6 >= r5) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            MutableVector<IntervalList$Interval<T>> mutableVector = this.intervals;
            int access$binarySearch = IntervalListKt.access$binarySearch(r5, mutableVector);
            int r2 = mutableVector.content[access$binarySearch].startIndex;
            while (r2 <= r6) {
                IntervalList$Interval<? extends LazyLayoutIntervalContent.Interval> intervalList$Interval = mutableVector.content[access$binarySearch];
                nearestRangeKeyIndexMap$1$1.invoke(intervalList$Interval);
                r2 += intervalList$Interval.size;
                access$binarySearch++;
            }
            return;
        }
        throw new IllegalArgumentException(("toIndex (" + r6 + ") should be not smaller than fromIndex (" + r5 + ')').toString());
    }

    public final IntervalList$Interval<T> get(int r4) {
        boolean z;
        checkIndexBounds(r4);
        IntervalList$Interval<? extends T> intervalList$Interval = this.lastInterval;
        if (intervalList$Interval != null) {
            int r1 = intervalList$Interval.size;
            int r2 = intervalList$Interval.startIndex;
            if (r4 < r1 + r2 && r2 <= r4) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return intervalList$Interval;
            }
        }
        MutableVector<IntervalList$Interval<T>> mutableVector = this.intervals;
        IntervalList$Interval intervalList$Interval2 = (IntervalList$Interval<? extends T>) mutableVector.content[IntervalListKt.access$binarySearch(r4, mutableVector)];
        this.lastInterval = intervalList$Interval2;
        return intervalList$Interval2;
    }
}
