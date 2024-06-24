package kotlin.ranges;

/* compiled from: Ranges.kt */
/* loaded from: classes.dex */
public final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    public final double _start = 0.4d;
    public final double _endInclusive = 0.8d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        double doubleValue = ((Number) comparable).doubleValue();
        if (doubleValue >= this._start && doubleValue <= this._endInclusive) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof ClosedDoubleRange)) {
            return false;
        }
        if (!isEmpty() || !((ClosedDoubleRange) obj).isEmpty()) {
            ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
            if (this._start == closedDoubleRange._start) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this._endInclusive == closedDoubleRange._endInclusive) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getEndInclusive() {
        return Double.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Double.valueOf(this._start);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.hashCode(this._start) * 31) + Double.hashCode(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this._start > this._endInclusive) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public final boolean lessThanOrEquals(Double d, Double d2) {
        if (d.doubleValue() <= d2.doubleValue()) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
