package j$.time.temporal;

/* loaded from: classes2.dex */
public interface Temporal extends TemporalAccessor {
    default Temporal minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    Temporal plus(long j, TemporalUnit temporalUnit);

    default Temporal plus(TemporalAmount temporalAmount) {
        return temporalAmount.addTo(this);
    }

    long until(Temporal temporal, TemporalUnit temporalUnit);

    default Temporal with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.adjustInto(this);
    }

    Temporal with(TemporalField temporalField, long j);
}
