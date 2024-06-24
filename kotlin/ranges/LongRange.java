package kotlin.ranges;

/* compiled from: PrimitiveRanges.kt */
/* loaded from: classes.dex */
public final class LongRange extends LongProgression implements ClosedRange<Long> {
    static {
        new LongRange(1L, 0L);
    }

    public final boolean contains(long j) {
        return this.first <= j && j <= this.last;
    }

    @Override // kotlin.ranges.ClosedRange
    public final /* bridge */ /* synthetic */ boolean contains(Long l) {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LongRange) {
            if (!isEmpty() || !((LongRange) obj).isEmpty()) {
                LongRange longRange = (LongRange) obj;
                if (this.first == longRange.first) {
                    if (this.last == longRange.last) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Long getEndInclusive() {
        return Long.valueOf(this.last);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Long getStart() {
        return Long.valueOf(this.first);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = this.first;
        long j2 = 31 * (j ^ (j >>> 32));
        long j3 = this.last;
        return (int) (j2 + (j3 ^ (j3 >>> 32)));
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this.first > this.last) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this.first + ".." + this.last;
    }
}
