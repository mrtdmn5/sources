package kotlin.time;

import com.airbnb.lottie.utils.GammaEvaluator;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: Duration.kt */
/* loaded from: classes.dex */
public final class DurationKt {
    public static final long access$durationOfNanosNormalized(long j) {
        if (new LongRange(-4611686018426999999L, 4611686018426999999L).contains(j)) {
            return durationOfNanos(j);
        }
        return durationOfMillis(j / 1000000);
    }

    public static final long access$parseDuration(String str) {
        int r2;
        boolean z;
        boolean z2;
        boolean z3;
        DurationUnit durationUnit;
        long m1686plusLRDsOJo;
        boolean z4;
        int length = str.length();
        if (length != 0) {
            int r1 = Duration.$r8$clinit;
            char charAt = str.charAt(0);
            if (charAt == '+' || charAt == '-') {
                r2 = 1;
            } else {
                r2 = 0;
            }
            if (r2 > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && StringsKt__StringsKt.startsWith$default((CharSequence) str, '-')) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (length > r2) {
                if (str.charAt(r2) == 'P') {
                    int r22 = r2 + 1;
                    if (r22 != length) {
                        DurationUnit durationUnit2 = null;
                        long j = 0;
                        boolean z5 = false;
                        while (r22 < length) {
                            if (str.charAt(r22) == 'T') {
                                if (!z5 && (r22 = r22 + 1) != length) {
                                    z5 = true;
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            } else {
                                int r9 = r22;
                                while (r9 < str.length()) {
                                    char charAt2 = str.charAt(r9);
                                    if (!new CharRange('0', '9').contains(charAt2) && !StringsKt__StringsKt.contains$default("+-.", charAt2)) {
                                        z4 = false;
                                    } else {
                                        z4 = true;
                                    }
                                    if (!z4) {
                                        break;
                                    }
                                    r9++;
                                }
                                String substring = str.substring(r22, r9);
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                if (substring.length() == 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    int length2 = substring.length() + r22;
                                    if (length2 >= 0 && length2 <= StringsKt__StringsKt.getLastIndex(str)) {
                                        char charAt3 = str.charAt(length2);
                                        int r11 = length2 + 1;
                                        if (!z5) {
                                            if (charAt3 == 'D') {
                                                durationUnit = DurationUnit.DAYS;
                                            } else {
                                                throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + charAt3);
                                            }
                                        } else if (charAt3 == 'H') {
                                            durationUnit = DurationUnit.HOURS;
                                        } else if (charAt3 == 'M') {
                                            durationUnit = DurationUnit.MINUTES;
                                        } else if (charAt3 == 'S') {
                                            durationUnit = DurationUnit.SECONDS;
                                        } else {
                                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + charAt3);
                                        }
                                        if (durationUnit2 != null && durationUnit2.compareTo(durationUnit) <= 0) {
                                            throw new IllegalArgumentException("Unexpected order of duration components");
                                        }
                                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) substring, '.', 0, false, 6);
                                        if (durationUnit == DurationUnit.SECONDS && indexOf$default > 0) {
                                            String substring2 = substring.substring(0, indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                            long m1686plusLRDsOJo2 = Duration.m1686plusLRDsOJo(j, toDuration(parseOverLongIsoComponent(substring2), durationUnit));
                                            String substring3 = substring.substring(indexOf$default);
                                            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                                            m1686plusLRDsOJo = Duration.m1686plusLRDsOJo(m1686plusLRDsOJo2, toDuration(Double.parseDouble(substring3), durationUnit));
                                        } else {
                                            m1686plusLRDsOJo = Duration.m1686plusLRDsOJo(j, toDuration(parseOverLongIsoComponent(substring), durationUnit));
                                        }
                                        j = m1686plusLRDsOJo;
                                        durationUnit2 = durationUnit;
                                        r22 = r11;
                                    } else {
                                        throw new IllegalArgumentException("Missing unit for value ".concat(substring));
                                    }
                                } else {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }
                        if (z2) {
                            return Duration.m1691unaryMinusUwyO8pc(j);
                        }
                        return j;
                    }
                    throw new IllegalArgumentException();
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("No components");
        }
        throw new IllegalArgumentException("The string is empty");
    }

    public static final long durationOfMillis(long j) {
        long j2 = (j << 1) + 1;
        int r0 = Duration.$r8$clinit;
        int r02 = DurationJvmKt.$r8$clinit;
        return j2;
    }

    public static final long durationOfMillisNormalized(long j) {
        if (new LongRange(-4611686018426L, 4611686018426L).contains(j)) {
            return durationOfNanos(j * 1000000);
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(j, -4611686018427387903L, 4611686018427387903L));
    }

    public static final long durationOfNanos(long j) {
        long j2 = j << 1;
        int r0 = Duration.$r8$clinit;
        int r02 = DurationJvmKt.$r8$clinit;
        return j2;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.collections.IntIterator, kotlin.ranges.IntProgressionIterator] */
    public static final long parseOverLongIsoComponent(String str) {
        int r3;
        boolean z;
        int length = str.length();
        if (length > 0 && StringsKt__StringsKt.contains$default("+-", str.charAt(0))) {
            r3 = 1;
        } else {
            r3 = 0;
        }
        if (length - r3 > 16) {
            Iterable intRange = new IntRange(r3, StringsKt__StringsKt.getLastIndex(str));
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                ?? it = intRange.iterator();
                while (it.hasNext) {
                    if (!new CharRange('0', '9').contains(str.charAt(it.nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                if (str.charAt(0) == '-') {
                    return Long.MIN_VALUE;
                }
                return Long.MAX_VALUE;
            }
        }
        if (StringsKt__StringsJVMKt.startsWith(str, "+", false)) {
            str = StringsKt___StringsKt.drop(1, str);
        }
        return Long.parseLong(str);
    }

    public static final long toDuration(int r2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo(DurationUnit.SECONDS) <= 0) {
            return durationOfNanos(GammaEvaluator.convertDurationUnitOverflow(r2, unit, DurationUnit.NANOSECONDS));
        }
        return toDuration(r2, unit);
    }

    public static final long toDuration(long j, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit durationUnit = DurationUnit.NANOSECONDS;
        long convertDurationUnitOverflow = GammaEvaluator.convertDurationUnitOverflow(4611686018426999999L, durationUnit, unit);
        if (new LongRange(-convertDurationUnitOverflow, convertDurationUnitOverflow).contains(j)) {
            return durationOfNanos(GammaEvaluator.convertDurationUnitOverflow(j, unit, durationUnit));
        }
        return durationOfMillis(RangesKt___RangesKt.coerceIn(GammaEvaluator.convertDurationUnit(j, unit, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }

    public static final long toDuration(double d, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        double convertDurationUnit = GammaEvaluator.convertDurationUnit(d, unit, DurationUnit.NANOSECONDS);
        if (!Double.isNaN(convertDurationUnit)) {
            long roundToLong = MathKt__MathJVMKt.roundToLong(convertDurationUnit);
            if (new LongRange(-4611686018426999999L, 4611686018426999999L).contains(roundToLong)) {
                return durationOfNanos(roundToLong);
            }
            return durationOfMillisNormalized(MathKt__MathJVMKt.roundToLong(GammaEvaluator.convertDurationUnit(d, unit, DurationUnit.MILLISECONDS)));
        }
        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }
}
