package com.animaconnected.watch.graphs.utils;

import kotlin.ranges.ClosedFloatingPointRange;

/* compiled from: YAxisUtils.kt */
/* loaded from: classes3.dex */
public final class FloatRange implements ClosedFloatingPointRange<Float> {
    private final float endInclusive;
    private final float start;

    public FloatRange(float f, float f2) {
        this.start = f;
        this.endInclusive = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    @Override // kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        if (getStart().floatValue() > getEndInclusive().floatValue()) {
            return true;
        }
        return false;
    }

    public boolean lessThanOrEquals(float f, float f2) {
        return f <= f2;
    }

    public boolean contains(float f) {
        return f <= getEndInclusive().floatValue() && getStart().floatValue() <= f;
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getEndInclusive() {
        return Float.valueOf(this.endInclusive);
    }

    @Override // kotlin.ranges.ClosedRange
    public Float getStart() {
        return Float.valueOf(this.start);
    }

    @Override // kotlin.ranges.ClosedFloatingPointRange
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Float f, Float f2) {
        return lessThanOrEquals(f.floatValue(), f2.floatValue());
    }
}
