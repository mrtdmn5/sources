package j$.time.chrono;

import j$.time.Instant;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.chrono.ChronoLocalDate;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;

/* loaded from: classes2.dex */
public interface ChronoZonedDateTime<D extends ChronoLocalDate> extends Temporal, Comparable<ChronoZonedDateTime<?>> {

    /* renamed from: j$.time.chrono.ChronoZonedDateTime$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = r0;
            try {
                r0[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* renamed from: compareTo, reason: avoid collision after fix types in other method */
    default int compareTo2(ChronoZonedDateTime chronoZonedDateTime) {
        int compare = Long.compare(toEpochSecond(), chronoZonedDateTime.toEpochSecond());
        if (compare != 0) {
            return compare;
        }
        int nano = toLocalTime().getNano() - chronoZonedDateTime.toLocalTime().getNano();
        if (nano != 0) {
            return nano;
        }
        int compareTo = toLocalDateTime().compareTo(chronoZonedDateTime.toLocalDateTime());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(chronoZonedDateTime.getZone().getId());
        return compareTo2 == 0 ? getChronology().compareTo(chronoZonedDateTime.getChronology()) : compareTo2;
    }

    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ default int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return compareTo2((ChronoZonedDateTime) chronoZonedDateTime);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.get(temporalField);
        }
        int r0 = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (r0 != 1) {
            return r0 != 2 ? toLocalDateTime().get(temporalField) : getOffset().getTotalSeconds();
        }
        throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
    }

    default Chronology getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // j$.time.temporal.TemporalAccessor
    default long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int r0 = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        return r0 != 1 ? r0 != 2 ? toLocalDateTime().getLong(temporalField) : getOffset().getTotalSeconds() : toEpochSecond();
    }

    ZoneOffset getOffset();

    ZoneId getZone();

    @Override // j$.time.temporal.Temporal
    ChronoZonedDateTime plus(long j, TemporalUnit temporalUnit);

    @Override // j$.time.temporal.TemporalAccessor
    default Object query(TemporalQuery temporalQuery) {
        return (temporalQuery == TemporalQueries.zone() || temporalQuery == TemporalQueries.zoneId()) ? getZone() : temporalQuery == TemporalQueries.offset() ? getOffset() : temporalQuery == TemporalQueries.localTime() ? toLocalTime() : temporalQuery == TemporalQueries.chronology() ? getChronology() : temporalQuery == TemporalQueries.precision() ? ChronoUnit.NANOS : temporalQuery.queryFrom(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    default ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : toLocalDateTime().range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    default long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - getOffset().getTotalSeconds();
    }

    default Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    default ChronoLocalDate toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    ChronoLocalDateTime toLocalDateTime();

    default LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    @Override // j$.time.temporal.Temporal
    default ChronoZonedDateTime with(TemporalAdjuster temporalAdjuster) {
        return ChronoZonedDateTimeImpl.ensureValid(getChronology(), super.with(temporalAdjuster));
    }

    @Override // j$.time.temporal.Temporal
    ChronoZonedDateTime with(TemporalField temporalField, long j);

    ChronoZonedDateTime withZoneSameInstant(ZoneId zoneId);
}
