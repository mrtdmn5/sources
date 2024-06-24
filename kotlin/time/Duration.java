package kotlin.time;

import com.airbnb.lottie.utils.GammaEvaluator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: Duration.kt */
/* loaded from: classes.dex */
public final class Duration implements Comparable<Duration> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long INFINITE;
    public static final long NEG_INFINITE;
    public final long rawValue;

    static {
        int r0 = DurationJvmKt.$r8$clinit;
        INFINITE = DurationKt.durationOfMillis(4611686018427387903L);
        NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    }

    public /* synthetic */ Duration(long j) {
        this.rawValue = j;
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc, reason: not valid java name */
    public static final long m1670addValuesMixedRangesUwyO8pc(long j, long j2) {
        long j3 = 1000000;
        long j4 = j2 / j3;
        long j5 = j + j4;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j5)) {
            return DurationKt.durationOfNanos((j5 * j3) + (j2 - (j4 * j3)));
        }
        return DurationKt.durationOfMillis(RangesKt___RangesKt.coerceIn(j5, -4611686018427387903L, 4611686018427387903L));
    }

    /* renamed from: appendFractional-impl, reason: not valid java name */
    public static final void m1671appendFractionalimpl(StringBuilder sb, int r6, int r7, int r8, String str, boolean z) {
        boolean z2;
        sb.append(r6);
        if (r7 != 0) {
            sb.append('.');
            String padStart = StringsKt__StringsKt.padStart(String.valueOf(r7), r8, '0');
            int r0 = -1;
            int length = padStart.length() - 1;
            if (length >= 0) {
                while (true) {
                    int r3 = length - 1;
                    if (padStart.charAt(length) != '0') {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        r0 = length;
                        break;
                    } else if (r3 < 0) {
                        break;
                    } else {
                        length = r3;
                    }
                }
            }
            int r02 = r0 + 1;
            if (!z && r02 < 3) {
                sb.append((CharSequence) padStart, 0, r02);
            } else {
                sb.append((CharSequence) padStart, 0, ((r02 + 2) / 3) * 3);
            }
        }
        sb.append(str);
    }

    /* renamed from: compareTo-LRDsOJo, reason: not valid java name */
    public static int m1672compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 >= 0 && (((int) j3) & 1) != 0) {
            int r0 = (((int) j) & 1) - (((int) j2) & 1);
            if (m1685isNegativeimpl(j)) {
                return -r0;
            }
            return r0;
        }
        if (j < j2) {
            return -1;
        }
        if (j != j2) {
            return 1;
        }
        return 0;
    }

    /* renamed from: div-LRDsOJo, reason: not valid java name */
    public static final double m1673divLRDsOJo(long j, long j2) {
        DurationUnit a = m1683getStorageUnitimpl(j);
        DurationUnit b = m1683getStorageUnitimpl(j2);
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        if (a.compareTo(b) < 0) {
            a = b;
        }
        return m1688toDoubleimpl(j, a) / m1688toDoubleimpl(j2, a);
    }

    /* renamed from: div-UwyO8pc, reason: not valid java name */
    public static final long m1674divUwyO8pc(int r8, long j) {
        boolean z = false;
        if (r8 == 0) {
            if (j > 0) {
                z = true;
            }
            if (z) {
                return INFINITE;
            }
            if (m1685isNegativeimpl(j)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if ((((int) j) & 1) == 0) {
            z = true;
        }
        if (z) {
            return DurationKt.durationOfNanos((j >> 1) / r8);
        }
        if (m1684isInfiniteimpl(j)) {
            return m1687timesUwyO8pc(MathKt__MathJVMKt.getSign(r8), j);
        }
        long j2 = j >> 1;
        long j3 = r8;
        long j4 = j2 / j3;
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j4)) {
            long j5 = 1000000;
            return DurationKt.durationOfNanos((j4 * j5) + (((j2 - (j4 * j3)) * j5) / j3));
        }
        return DurationKt.durationOfMillis(j4);
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1675equalsimpl0(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return false;
    }

    /* renamed from: getInWholeHours-impl, reason: not valid java name */
    public static final long m1676getInWholeHoursimpl(long j) {
        return m1689toLongimpl(j, DurationUnit.HOURS);
    }

    /* renamed from: getInWholeMilliseconds-impl, reason: not valid java name */
    public static final long m1677getInWholeMillisecondsimpl(long j) {
        boolean z;
        if ((((int) j) & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z && (!m1684isInfiniteimpl(j))) {
            return j >> 1;
        }
        return m1689toLongimpl(j, DurationUnit.MILLISECONDS);
    }

    /* renamed from: getInWholeMinutes-impl, reason: not valid java name */
    public static final long m1678getInWholeMinutesimpl(long j) {
        return m1689toLongimpl(j, DurationUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl, reason: not valid java name */
    public static final long m1679getInWholeSecondsimpl(long j) {
        return m1689toLongimpl(j, DurationUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl, reason: not valid java name */
    public static final int m1680getMinutesComponentimpl(long j) {
        if (m1684isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1678getInWholeMinutesimpl(j) % 60);
    }

    /* renamed from: getNanosecondsComponent-impl, reason: not valid java name */
    public static final int m1681getNanosecondsComponentimpl(long j) {
        long j2;
        boolean z = false;
        if (m1684isInfiniteimpl(j)) {
            return 0;
        }
        if ((((int) j) & 1) == 1) {
            z = true;
        }
        long j3 = j >> 1;
        if (z) {
            j2 = (j3 % 1000) * 1000000;
        } else {
            j2 = j3 % 1000000000;
        }
        return (int) j2;
    }

    /* renamed from: getSecondsComponent-impl, reason: not valid java name */
    public static final int m1682getSecondsComponentimpl(long j) {
        if (m1684isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m1679getInWholeSecondsimpl(j) % 60);
    }

    /* renamed from: getStorageUnit-impl, reason: not valid java name */
    public static final DurationUnit m1683getStorageUnitimpl(long j) {
        boolean z = true;
        if ((((int) j) & 1) != 0) {
            z = false;
        }
        if (z) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m1684isInfiniteimpl(long j) {
        if (j != INFINITE && j != NEG_INFINITE) {
            return false;
        }
        return true;
    }

    /* renamed from: isNegative-impl, reason: not valid java name */
    public static final boolean m1685isNegativeimpl(long j) {
        if (j < 0) {
            return true;
        }
        return false;
    }

    /* renamed from: plus-LRDsOJo, reason: not valid java name */
    public static final long m1686plusLRDsOJo(long j, long j2) {
        boolean z = true;
        if (m1684isInfiniteimpl(j)) {
            if (!(!m1684isInfiniteimpl(j2)) && (j2 ^ j) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j;
        }
        if (m1684isInfiniteimpl(j2)) {
            return j2;
        }
        int r0 = ((int) j) & 1;
        boolean z2 = false;
        if (r0 == (((int) j2) & 1)) {
            long j3 = (j >> 1) + (j2 >> 1);
            if (r0 != 0) {
                z = false;
            }
            if (z) {
                return DurationKt.access$durationOfNanosNormalized(j3);
            }
            return DurationKt.durationOfMillisNormalized(j3);
        }
        if (r0 == 1) {
            z2 = true;
        }
        if (z2) {
            return m1670addValuesMixedRangesUwyO8pc(j >> 1, j2 >> 1);
        }
        return m1670addValuesMixedRangesUwyO8pc(j2 >> 1, j >> 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x009b, code lost:            if ((kotlin.math.MathKt__MathJVMKt.getSign(r19) * r5) > 0) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d3, code lost:            return kotlin.time.Duration.NEG_INFINITE;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:            return kotlin.time.Duration.INFINITE;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00cc, code lost:            if ((kotlin.math.MathKt__MathJVMKt.getSign(r19) * r5) > 0) goto L51;     */
    /* renamed from: times-UwyO8pc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long m1687timesUwyO8pc(int r19, long r20) {
        /*
            r0 = r19
            r1 = r20
            boolean r3 = m1684isInfiniteimpl(r20)
            if (r3 == 0) goto L1d
            if (r0 == 0) goto L15
            if (r0 <= 0) goto L10
            r0 = r1
            goto L14
        L10:
            long r0 = m1691unaryMinusUwyO8pc(r20)
        L14:
            return r0
        L15:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Multiplying infinite duration by zero yields an undefined result."
            r0.<init>(r1)
            throw r0
        L1d:
            r3 = 0
            if (r0 != 0) goto L22
            return r3
        L22:
            r5 = 1
            long r6 = r1 >> r5
            long r8 = (long) r0
            long r10 = r6 * r8
            int r1 = (int) r1
            r1 = r1 & r5
            r2 = 0
            if (r1 != 0) goto L2f
            r1 = r5
            goto L30
        L2f:
            r1 = r2
        L30:
            r16 = -1
            if (r1 == 0) goto L9e
            kotlin.ranges.LongRange r1 = new kotlin.ranges.LongRange
            r12 = -2147483647(0xffffffff80000001, double:NaN)
            r14 = 2147483647(0x7fffffff, double:1.060997895E-314)
            r1.<init>(r12, r14)
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L4b
            long r0 = kotlin.time.DurationKt.durationOfNanos(r10)
            goto Ld3
        L4b:
            long r12 = r10 / r8
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 != 0) goto L57
            long r0 = kotlin.time.DurationKt.access$durationOfNanosNormalized(r10)
            goto Ld3
        L57:
            r1 = 1000000(0xf4240, float:1.401298E-39)
            long r10 = (long) r1
            long r12 = r6 / r10
            long r14 = r12 * r10
            long r14 = r6 - r14
            long r17 = r12 * r8
            long r14 = r14 * r8
            long r14 = r14 / r10
            long r14 = r14 + r17
            long r8 = r17 / r8
            int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r1 != 0) goto L8b
            long r8 = r14 ^ r17
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 < 0) goto L8b
            kotlin.ranges.LongRange r0 = new kotlin.ranges.LongRange
            r1 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            r3 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            r0.<init>(r1, r3)
            long r0 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r14, r0)
            long r0 = kotlin.time.DurationKt.durationOfMillis(r0)
            goto Ld3
        L8b:
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 >= 0) goto L92
            r5 = r16
            goto L96
        L92:
            if (r1 <= 0) goto L95
            goto L96
        L95:
            r5 = r2
        L96:
            int r0 = kotlin.math.MathKt__MathJVMKt.getSign(r19)
            int r0 = r0 * r5
            if (r0 <= 0) goto Ld1
            goto Lce
        L9e:
            long r8 = r10 / r8
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto Lbc
            kotlin.ranges.LongRange r0 = new kotlin.ranges.LongRange
            r1 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            r3 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            r0.<init>(r1, r3)
            long r0 = kotlin.ranges.RangesKt___RangesKt.coerceIn(r10, r0)
            long r0 = kotlin.time.DurationKt.durationOfMillis(r0)
            goto Ld3
        Lbc:
            int r1 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r1 >= 0) goto Lc3
            r5 = r16
            goto Lc7
        Lc3:
            if (r1 <= 0) goto Lc6
            goto Lc7
        Lc6:
            r5 = r2
        Lc7:
            int r0 = kotlin.math.MathKt__MathJVMKt.getSign(r19)
            int r0 = r0 * r5
            if (r0 <= 0) goto Ld1
        Lce:
            long r0 = kotlin.time.Duration.INFINITE
            goto Ld3
        Ld1:
            long r0 = kotlin.time.Duration.NEG_INFINITE
        Ld3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.Duration.m1687timesUwyO8pc(int, long):long");
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m1688toDoubleimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return GammaEvaluator.convertDurationUnit(j >> 1, m1683getStorageUnitimpl(j), unit);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m1689toLongimpl(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j == INFINITE) {
            return Long.MAX_VALUE;
        }
        if (j == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return GammaEvaluator.convertDurationUnit(j >> 1, m1683getStorageUnitimpl(j), unit);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1690toStringimpl(long j) {
        int m1676getInWholeHoursimpl;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (j == 0) {
            return "0s";
        }
        if (j == INFINITE) {
            return "Infinity";
        }
        if (j == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean m1685isNegativeimpl = m1685isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (m1685isNegativeimpl) {
            sb.append('-');
        }
        if (m1685isNegativeimpl(j)) {
            j = m1691unaryMinusUwyO8pc(j);
        }
        long m1689toLongimpl = m1689toLongimpl(j, DurationUnit.DAYS);
        int r6 = 0;
        if (m1684isInfiniteimpl(j)) {
            m1676getInWholeHoursimpl = 0;
        } else {
            m1676getInWholeHoursimpl = (int) (m1676getInWholeHoursimpl(j) % 24);
        }
        int m1680getMinutesComponentimpl = m1680getMinutesComponentimpl(j);
        int m1682getSecondsComponentimpl = m1682getSecondsComponentimpl(j);
        int m1681getNanosecondsComponentimpl = m1681getNanosecondsComponentimpl(j);
        if (m1689toLongimpl != 0) {
            z = true;
        } else {
            z = false;
        }
        if (m1676getInWholeHoursimpl != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (m1680getMinutesComponentimpl != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (m1682getSecondsComponentimpl == 0 && m1681getNanosecondsComponentimpl == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (z) {
            sb.append(m1689toLongimpl);
            sb.append('d');
            r6 = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int r4 = r6 + 1;
            if (r6 > 0) {
                sb.append(' ');
            }
            sb.append(m1676getInWholeHoursimpl);
            sb.append('h');
            r6 = r4;
        }
        if (z3 || (z4 && (z2 || z))) {
            int r42 = r6 + 1;
            if (r6 > 0) {
                sb.append(' ');
            }
            sb.append(m1680getMinutesComponentimpl);
            sb.append('m');
            r6 = r42;
        }
        if (z4) {
            int r11 = r6 + 1;
            if (r6 > 0) {
                sb.append(' ');
            }
            if (m1682getSecondsComponentimpl == 0 && !z && !z2 && !z3) {
                if (m1681getNanosecondsComponentimpl >= 1000000) {
                    m1671appendFractionalimpl(sb, m1681getNanosecondsComponentimpl / 1000000, m1681getNanosecondsComponentimpl % 1000000, 6, "ms", false);
                } else if (m1681getNanosecondsComponentimpl >= 1000) {
                    m1671appendFractionalimpl(sb, m1681getNanosecondsComponentimpl / 1000, m1681getNanosecondsComponentimpl % 1000, 3, "us", false);
                } else {
                    sb.append(m1681getNanosecondsComponentimpl);
                    sb.append("ns");
                }
            } else {
                m1671appendFractionalimpl(sb, m1682getSecondsComponentimpl, m1681getNanosecondsComponentimpl, 9, "s", false);
            }
            r6 = r11;
        }
        if (m1685isNegativeimpl && r6 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* renamed from: unaryMinus-UwyO8pc, reason: not valid java name */
    public static final long m1691unaryMinusUwyO8pc(long j) {
        long j2 = ((-(j >> 1)) << 1) + (((int) j) & 1);
        int r3 = DurationJvmKt.$r8$clinit;
        return j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        return m1672compareToLRDsOJo(this.rawValue, duration.rawValue);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Duration)) {
            return false;
        }
        if (this.rawValue != ((Duration) obj).rawValue) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Long.hashCode(this.rawValue);
    }

    public final String toString() {
        return m1690toStringimpl(this.rawValue);
    }
}
