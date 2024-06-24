package j$.time.chrono;

import com.animaconnected.firebase.AnalyticsConstants;
import j$.time.LocalTime;
import j$.time.ZoneId;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class ChronoLocalDateTimeImpl implements ChronoLocalDateTime, Temporal, TemporalAdjuster, Serializable {
    private final transient ChronoLocalDate date;
    private final transient LocalTime time;

    /* renamed from: j$.time.chrono.ChronoLocalDateTimeImpl$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = r0;
            try {
                r0[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ChronoLocalDateTimeImpl(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        Objects.requireNonNull(chronoLocalDate, "date");
        Objects.requireNonNull(localTime, AnalyticsConstants.KEY_TIME);
        this.date = chronoLocalDate;
        this.time = localTime;
    }

    public static ChronoLocalDateTimeImpl ensureValid(Chronology chronology, Temporal temporal) {
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (chronology.equals(chronoLocalDateTimeImpl.getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chronology mismatch, required: " + chronology.getId() + ", actual: " + chronoLocalDateTimeImpl.getChronology().getId());
    }

    public static ChronoLocalDateTimeImpl of(ChronoLocalDate chronoLocalDate, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(chronoLocalDate, localTime);
    }

    private ChronoLocalDateTimeImpl plusDays(long j) {
        return with(this.date.plus(j, (TemporalUnit) ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl plusHours(long j) {
        return plusWithOverflow(this.date, j, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl plusMinutes(long j) {
        return plusWithOverflow(this.date, 0L, j, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl plusNanos(long j) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j);
    }

    private ChronoLocalDateTimeImpl plusWithOverflow(ChronoLocalDate chronoLocalDate, long j, long j2, long j3, long j4) {
        LocalTime ofNanoOfDay;
        ChronoLocalDate chronoLocalDate2 = chronoLocalDate;
        if ((j | j2 | j3 | j4) == 0) {
            ofNanoOfDay = this.time;
        } else {
            long nanoOfDay = this.time.toNanoOfDay();
            long j5 = (j4 % 86400000000000L) + ((j3 % 86400) * 1000000000) + ((j2 % 1440) * 60000000000L) + ((j % 24) * 3600000000000L) + nanoOfDay;
            long floorDiv = (j4 / 86400000000000L) + (j3 / 86400) + (j2 / 1440) + (j / 24) + Math.floorDiv(j5, 86400000000000L);
            long floorMod = Math.floorMod(j5, 86400000000000L);
            ofNanoOfDay = floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod);
            chronoLocalDate2 = chronoLocalDate2.plus(floorDiv, (TemporalUnit) ChronoUnit.DAYS);
        }
        return with(chronoLocalDate2, ofNanoOfDay);
    }

    private ChronoLocalDateTimeImpl with(Temporal temporal, LocalTime localTime) {
        ChronoLocalDate chronoLocalDate = this.date;
        return (chronoLocalDate == temporal && this.time == localTime) ? this : new ChronoLocalDateTimeImpl(ChronoLocalDateImpl.ensureValid(chronoLocalDate.getChronology(), temporal), localTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public ChronoZonedDateTime atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(this, zoneId, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && compareTo((ChronoLocalDateTime) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : range(temporalField).checkValidIntValue(getLong(temporalField), temporalField);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public int hashCode() {
        return toLocalDate().hashCode() ^ toLocalTime().hashCode();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    public ChronoLocalDateTimeImpl plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return ensureValid(this.date.getChronology(), temporalUnit.addTo(this, j));
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusNanos(j);
            case 2:
                return plusDays(j / 86400000000L).plusNanos((j % 86400000000L) * 1000);
            case 3:
                return plusDays(j / 86400000).plusNanos((j % 86400000) * 1000000);
            case 4:
                return plusSeconds(j);
            case 5:
                return plusMinutes(j);
            case 6:
                return plusHours(j);
            case 7:
                return plusDays(j / 256).plusHours((j % 256) * 12);
            default:
                return with(this.date.plus(j, temporalUnit), this.time);
        }
    }

    public ChronoLocalDateTimeImpl plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public ChronoLocalDate toLocalDate() {
        return this.date;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x002f. Please report as an issue. */
    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long j;
        Objects.requireNonNull(temporal, "endExclusive");
        ChronoLocalDateTime localDateTime = getChronology().localDateTime(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            Objects.requireNonNull(temporalUnit, "unit");
            return temporalUnit.between(this, localDateTime);
        }
        if (!temporalUnit.isTimeBased()) {
            ChronoLocalDate localDate = localDateTime.toLocalDate();
            if (localDateTime.toLocalTime().isBefore(this.time)) {
                localDate = localDate.minus(1L, (TemporalUnit) ChronoUnit.DAYS);
            }
            return this.date.until(localDate, temporalUnit);
        }
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        long j2 = localDateTime.getLong(chronoField) - this.date.getLong(chronoField);
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                j = 86400000000000L;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 2:
                j = 86400000000L;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 3:
                j = 86400000;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 4:
                j = 86400;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 5:
                j = 1440;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 6:
                j = 24;
                j2 = Math.multiplyExact(j2, j);
                break;
            case 7:
                j = 2;
                j2 = Math.multiplyExact(j2, j);
                break;
        }
        return Math.addExact(j2, this.time.until(localDateTime.toLocalTime(), temporalUnit));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    public ChronoLocalDateTimeImpl with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof ChronoLocalDate ? with((ChronoLocalDate) temporalAdjuster, this.time) : temporalAdjuster instanceof LocalTime ? with(this.date, (LocalTime) temporalAdjuster) : temporalAdjuster instanceof ChronoLocalDateTimeImpl ? ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) temporalAdjuster) : ensureValid(this.date.getChronology(), (ChronoLocalDateTimeImpl) temporalAdjuster.adjustInto(this));
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, j$.time.temporal.Temporal
    public ChronoLocalDateTimeImpl with(TemporalField temporalField, long j) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(temporalField, j)) : with(this.date.with(temporalField, j), this.time) : ensureValid(this.date.getChronology(), temporalField.adjustInto(this, j));
    }
}
