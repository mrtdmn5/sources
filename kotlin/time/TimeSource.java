package kotlin.time;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeSource.kt */
/* loaded from: classes.dex */
public interface TimeSource {
    Monotonic.ValueTimeMark markNow();

    /* compiled from: TimeSource.kt */
    /* loaded from: classes.dex */
    public static final class Monotonic implements TimeSource {
        public static final Monotonic INSTANCE = new Monotonic();

        @Override // kotlin.time.TimeSource
        public final ValueTimeMark markNow() {
            return new ValueTimeMark(MonotonicTimeSource.read());
        }

        public final String toString() {
            int r0 = MonotonicTimeSource.$r8$clinit;
            return "TimeSource(System.nanoTime())";
        }

        /* compiled from: TimeSource.kt */
        /* loaded from: classes.dex */
        public static final class ValueTimeMark implements ComparableTimeMark {
            public final long reading;

            public /* synthetic */ ValueTimeMark(long j) {
                this.reading = j;
            }

            /* renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m1693elapsedNowUwyO8pc(long j) {
                long read = MonotonicTimeSource.read();
                DurationUnit unit = DurationUnit.NANOSECONDS;
                Intrinsics.checkNotNullParameter(unit, "unit");
                if ((1 | (j - 1)) == Long.MAX_VALUE) {
                    return Duration.m1691unaryMinusUwyO8pc(LongSaturatedMathKt.infinityOfSign(j));
                }
                return LongSaturatedMathKt.saturatingFiniteDiff(read, j, unit);
            }

            @Override // java.lang.Comparable
            public final int compareTo(ComparableTimeMark comparableTimeMark) {
                ComparableTimeMark other = comparableTimeMark;
                Intrinsics.checkNotNullParameter(other, "other");
                return Duration.m1672compareToLRDsOJo(m1694minusUwyO8pc(other), 0L);
            }

            public final boolean equals(Object obj) {
                if (!(obj instanceof ValueTimeMark)) {
                    return false;
                }
                if (this.reading != ((ValueTimeMark) obj).reading) {
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                return Long.hashCode(this.reading);
            }

            /* renamed from: minus-UwyO8pc, reason: not valid java name */
            public final long m1694minusUwyO8pc(ComparableTimeMark other) {
                boolean z;
                Intrinsics.checkNotNullParameter(other, "other");
                boolean z2 = other instanceof ValueTimeMark;
                long j = this.reading;
                if (z2) {
                    int r0 = MonotonicTimeSource.$r8$clinit;
                    DurationUnit unit = DurationUnit.NANOSECONDS;
                    Intrinsics.checkNotNullParameter(unit, "unit");
                    long j2 = ((ValueTimeMark) other).reading;
                    boolean z3 = true;
                    if (((j2 - 1) | 1) == Long.MAX_VALUE) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (j == j2) {
                            int r14 = Duration.$r8$clinit;
                            return 0L;
                        }
                        return Duration.m1691unaryMinusUwyO8pc(LongSaturatedMathKt.infinityOfSign(j2));
                    }
                    if ((1 | (j - 1)) != Long.MAX_VALUE) {
                        z3 = false;
                    }
                    if (z3) {
                        return LongSaturatedMathKt.infinityOfSign(j);
                    }
                    return LongSaturatedMathKt.saturatingFiniteDiff(j, j2, unit);
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) ("ValueTimeMark(reading=" + j + ')')) + " and " + other);
            }

            public final String toString() {
                return "ValueTimeMark(reading=" + this.reading + ')';
            }

            @Override // kotlin.time.TimeMark
            /* renamed from: elapsedNow-UwyO8pc */
            public final long mo1692elapsedNowUwyO8pc() {
                return m1693elapsedNowUwyO8pc(this.reading);
            }
        }
    }
}
