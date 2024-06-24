package kotlin.ranges;

/* compiled from: Ranges.kt */
/* loaded from: classes.dex */
public final class ClosedFloatRange implements ClosedFloatingPointRange<Float> {
    public final float _endInclusive;
    public final float _start;

    public ClosedFloatRange(float f, float f2) {
        this._start = f;
        this._endInclusive = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange
    public final boolean contains(Comparable comparable) {
        float floatValue = ((Number) comparable).floatValue();
        if (floatValue >= this._start && floatValue <= this._endInclusive) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (!(obj instanceof ClosedFloatRange)) {
            return false;
        }
        if (!isEmpty() || !((ClosedFloatRange) obj).isEmpty()) {
            ClosedFloatRange closedFloatRange = (ClosedFloatRange) obj;
            if (this._start == closedFloatRange._start) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            if (this._endInclusive == closedFloatRange._endInclusive) {
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
        return Float.valueOf(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public final Comparable getStart() {
        return Float.valueOf(this._start);
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Float.hashCode(this._start) * 31) + Float.hashCode(this._endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public final boolean isEmpty() {
        if (this._start > this._endInclusive) {
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public final boolean lessThanOrEquals(Float f, Float f2) {
        if (f.floatValue() <= f2.floatValue()) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return this._start + ".." + this._endInclusive;
    }
}
