package j$.time.chrono;

import j$.time.LocalTime;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes2.dex */
public interface ChronoLocalDate extends Temporal, TemporalAdjuster, Comparable<ChronoLocalDate> {
    @Override // j$.time.temporal.TemporalAdjuster
    default Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    default ChronoLocalDateTime atTime(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.of(this, localTime);
    }

    default int compareTo(ChronoLocalDate chronoLocalDate) {
        int compare = Long.compare(toEpochDay(), chronoLocalDate.toEpochDay());
        return compare == 0 ? getChronology().compareTo(chronoLocalDate.getChronology()) : compare;
    }

    boolean equals(Object obj);

    Chronology getChronology();

    int hashCode();

    default boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() > chronoLocalDate.toEpochDay();
    }

    default boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return toEpochDay() < chronoLocalDate.toEpochDay();
    }

    default boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default boolean isSupported(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.isDateBased() : temporalField != null && temporalField.isSupportedBy(this);
    }

    default int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    default ChronoLocalDate minus(long j, TemporalUnit temporalUnit) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.minus(j, temporalUnit));
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return ChronoLocalDateImpl.ensureValid(getChronology(), temporalUnit.addTo(this, j));
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
    }

    default ChronoLocalDate plus(TemporalAmount temporalAmount) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.plus(temporalAmount));
    }

    @Override // j$.time.temporal.TemporalAccessor
    default Object query(TemporalQuery temporalQuery) {
        if (temporalQuery == TemporalQueries.zoneId() || temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.offset() || temporalQuery == TemporalQueries.localTime()) {
            return null;
        }
        return temporalQuery == TemporalQueries.chronology() ? getChronology() : temporalQuery == TemporalQueries.precision() ? ChronoUnit.DAYS : temporalQuery.queryFrom(this);
    }

    default long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    String toString();

    @Override // j$.time.temporal.Temporal
    long until(Temporal temporal, TemporalUnit temporalUnit);

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate with(TemporalAdjuster temporalAdjuster) {
        return ChronoLocalDateImpl.ensureValid(getChronology(), super.with(temporalAdjuster));
    }

    @Override // j$.time.temporal.Temporal
    default ChronoLocalDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return ChronoLocalDateImpl.ensureValid(getChronology(), temporalField.adjustInto(this, j));
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
