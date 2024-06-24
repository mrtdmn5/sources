package kotlin.time;

import com.airbnb.lottie.utils.GammaEvaluator;

/* compiled from: longSaturatedMath.kt */
/* loaded from: classes.dex */
public final class LongSaturatedMathKt {
    public static final long infinityOfSign(long j) {
        if (j < 0) {
            int r2 = Duration.$r8$clinit;
            return Duration.NEG_INFINITE;
        }
        int r22 = Duration.$r8$clinit;
        return Duration.INFINITE;
    }

    public static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
            if (durationUnit.compareTo(durationUnit2) < 0) {
                long convertDurationUnit = GammaEvaluator.convertDurationUnit(1L, durationUnit2, durationUnit);
                long j4 = (j / convertDurationUnit) - (j2 / convertDurationUnit);
                long j5 = (j % convertDurationUnit) - (j2 % convertDurationUnit);
                int r9 = Duration.$r8$clinit;
                return Duration.m1686plusLRDsOJo(DurationKt.toDuration(j4, durationUnit2), DurationKt.toDuration(j5, durationUnit));
            }
            return Duration.m1691unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
