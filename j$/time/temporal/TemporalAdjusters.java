package j$.time.temporal;

import j$.time.DayOfWeek;

/* loaded from: classes2.dex */
public abstract class TemporalAdjusters {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Temporal lambda$nextOrSame$10(int r2, Temporal temporal) {
        int r0 = temporal.get(ChronoField.DAY_OF_WEEK);
        if (r0 == r2) {
            return temporal;
        }
        return temporal.plus(r0 - r2 >= 0 ? 7 - r0 : -r0, ChronoUnit.DAYS);
    }

    public static TemporalAdjuster nextOrSame(DayOfWeek dayOfWeek) {
        final int value = dayOfWeek.getValue();
        return new TemporalAdjuster() { // from class: j$.time.temporal.TemporalAdjusters$$ExternalSyntheticLambda11
            @Override // j$.time.temporal.TemporalAdjuster
            public final Temporal adjustInto(Temporal temporal) {
                return TemporalAdjusters.lambda$nextOrSame$10(value, temporal);
            }
        };
    }
}
