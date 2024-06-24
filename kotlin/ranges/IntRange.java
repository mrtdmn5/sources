package kotlin.ranges;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes.dex */
public final class IntRange extends IntProgression implements ClosedRange<Integer> {
    public static final IntRange EMPTY = new IntRange(1, 0);

    public IntRange(int r2, int r3) {
        super(r2, r3, 1);
    }

    public final boolean contains(int r2) {
        return this.first <= r2 && r2 <= this.last;
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ boolean contains(Integer num) {
        throw null;
    }

    @Override // kotlin.ranges.IntProgression
    public final boolean equals(Object obj) {
        if (obj instanceof IntRange) {
            if (!isEmpty() || !((IntRange) obj).isEmpty()) {
                IntRange intRange = (IntRange) obj;
                if (this.first == intRange.first) {
                    if (this.last == intRange.last) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.first * 31) + this.last;
    }

    @Override // kotlin.ranges.IntProgression, kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this.first > this.last) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.IntProgression
    public final String toString() {
        return this.first + ".." + this.last;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Integer getEndInclusive() {
        return Integer.valueOf(this.last);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Integer getStart() {
        return Integer.valueOf(this.first);
    }
}
