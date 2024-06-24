package kotlin.ranges;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline0;
import io.ktor.util.ThrowableKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _Ranges.kt */
/* loaded from: classes.dex */
public class RangesKt___RangesKt extends ThrowableKt {
    public static final int coerceIn(int r2, int r3, int r4) {
        if (r3 <= r4) {
            return r2 < r3 ? r3 : r2 > r4 ? r4 : r2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + r4 + " is less than minimum " + r3 + '.');
    }

    public static final IntProgression reversed(IntRange intRange) {
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        return new IntProgression(intRange.last, intRange.first, -intRange.step);
    }

    public static final IntProgression step(IntRange intRange, int r4) {
        boolean z;
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        if (r4 > 0) {
            z = true;
        } else {
            z = false;
        }
        Integer step = Integer.valueOf(r4);
        Intrinsics.checkNotNullParameter(step, "step");
        if (z) {
            if (intRange.step <= 0) {
                r4 = -r4;
            }
            return new IntProgression(intRange.first, intRange.last, r4);
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    public static final IntRange until(int r1, int r2) {
        if (r2 <= Integer.MIN_VALUE) {
            IntRange intRange = IntRange.EMPTY;
            return IntRange.EMPTY;
        }
        return new IntRange(r1, r2 - 1);
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        StringBuilder sb = new StringBuilder("Cannot coerce value to an empty range: maximum ");
        sb.append(j3);
        sb.append(" is less than minimum ");
        throw new IllegalArgumentException(FlingCalculator$FlingInfo$$ExternalSyntheticOutline0.m(sb, j2, '.'));
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 <= d3) {
            return d < d2 ? d2 : d > d3 ? d3 : d;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + '.');
    }

    public static final <T extends Comparable<? super T>> T coerceIn(T t, ClosedFloatingPointRange<T> range) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        if (!range.isEmpty()) {
            return (!range.lessThanOrEquals(t, range.getStart()) || range.lessThanOrEquals(range.getStart(), t)) ? (!range.lessThanOrEquals(range.getEndInclusive(), t) || range.lessThanOrEquals(t, range.getEndInclusive())) ? t : range.getEndInclusive() : range.getStart();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    public static final int coerceIn(int r2, ClosedRange<Integer> range) {
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(r2), (ClosedFloatingPointRange<Integer>) range)).intValue();
        }
        if (!range.isEmpty()) {
            return r2 < range.getStart().intValue() ? range.getStart().intValue() : r2 > range.getEndInclusive().intValue() ? range.getEndInclusive().intValue() : r2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final long coerceIn(long j, LongRange longRange) {
        if (longRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) longRange)).longValue();
        }
        if (!longRange.isEmpty()) {
            return j < ((Number) longRange.getStart()).longValue() ? ((Number) longRange.getStart()).longValue() : j > ((Number) longRange.getEndInclusive()).longValue() ? ((Number) longRange.getEndInclusive()).longValue() : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + longRange + '.');
    }
}
