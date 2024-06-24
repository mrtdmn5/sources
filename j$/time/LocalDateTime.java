package j$.time;

import com.animaconnected.firebase.AnalyticsConstants;
import j$.time.chrono.ChronoLocalDateTime;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.ValueRange;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class LocalDateTime implements Temporal, TemporalAdjuster, ChronoLocalDateTime<LocalDate>, Serializable {
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);

    /* renamed from: j$.time.LocalDateTime$1 */
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

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.toLocalDate());
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.toLocalTime()) : compareTo0;
    }

    public static LocalDateTime from(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof LocalDateTime) {
            return (LocalDateTime) temporalAccessor;
        }
        if (temporalAccessor instanceof ZonedDateTime) {
            return ((ZonedDateTime) temporalAccessor).toLocalDateTime();
        }
        if (temporalAccessor instanceof OffsetDateTime) {
            return ((OffsetDateTime) temporalAccessor).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(temporalAccessor), LocalTime.from(temporalAccessor));
        } catch (DateTimeException e) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName(), e);
        }
    }

    public static LocalDateTime of(int r0, int r1, int r2, int r3, int r4) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4));
    }

    public static LocalDateTime of(int r0, int r1, int r2, int r3, int r4, int r5, int r6) {
        return new LocalDateTime(LocalDate.of(r0, r1, r2), LocalTime.of(r3, r4, r5, r6));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(localTime, AnalyticsConstants.KEY_TIME);
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime ofEpochSecond(long j, int r7, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, "offset");
        long j2 = r7;
        ChronoField.NANO_OF_SECOND.checkValidValue(j2);
        return new LocalDateTime(LocalDate.ofEpochDay(Math.floorDiv(j + zoneOffset.getTotalSeconds(), 86400L)), LocalTime.ofNanoOfDay((((int) Math.floorMod(r5, 86400L)) * 1000000000) + j2));
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), zoneId.getRules().getOffset(instant));
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: j$.time.LocalDateTime$$ExternalSyntheticLambda0
            @Override // j$.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDateTime.from(temporalAccessor);
            }
        });
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j, long j2, long j3, long j4, int r28) {
        LocalTime ofNanoOfDay;
        LocalDate localDate2 = localDate;
        if ((j | j2 | j3 | j4) == 0) {
            ofNanoOfDay = this.time;
        } else {
            long j5 = r28;
            long nanoOfDay = this.time.toNanoOfDay();
            long j6 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000) + ((j2 % 1440) * 60000000000L) + ((j % 24) * 3600000000000L)) * j5) + nanoOfDay;
            long floorDiv = (((j4 / 86400000000000L) + (j3 / 86400) + (j2 / 1440) + (j / 24)) * j5) + Math.floorDiv(j6, 86400000000000L);
            long floorMod = Math.floorMod(j6, 86400000000000L);
            ofNanoOfDay = floorMod == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(floorMod);
            localDate2 = localDate2.plusDays(floorDiv);
        }
        return with(localDate2, ofNanoOfDay);
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime, java.lang.Comparable
    public int compareTo(ChronoLocalDateTime<?> chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) : super.compareTo((ChronoLocalDateTime) chronoLocalDateTime);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.format(this);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.get(temporalField) : this.date.get(temporalField) : super.get(temporalField);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.getLong(temporalField) : this.date.getLong(temporalField) : temporalField.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public boolean isAfter(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) > 0 : super.isAfter(chronoLocalDateTime);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public boolean isBefore(ChronoLocalDateTime chronoLocalDateTime) {
        return chronoLocalDateTime instanceof LocalDateTime ? compareTo0((LocalDateTime) chronoLocalDateTime) < 0 : super.isBefore(chronoLocalDateTime);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField != null && temporalField.isSupportedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        return chronoField.isDateBased() || chronoField.isTimeBased();
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.addTo(this, j);
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

    public LocalDateTime plusDays(long j) {
        return with(this.date.plusDays(j), this.time);
    }

    public LocalDateTime plusHours(long j) {
        return plusWithOverflow(this.date, j, 0L, 0L, 0L, 1);
    }

    public LocalDateTime plusMinutes(long j) {
        return plusWithOverflow(this.date, 0L, j, 0L, 0L, 1);
    }

    public LocalDateTime plusMonths(long j) {
        return with(this.date.plusMonths(j), this.time);
    }

    public LocalDateTime plusNanos(long j) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j, 1);
    }

    public LocalDateTime plusSeconds(long j) {
        return plusWithOverflow(this.date, 0L, 0L, j, 0L, 1);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this.date : super.query(temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? this.time.range(temporalField) : this.date.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalDate toLocalDate() {
        return this.date;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // j$.time.chrono.ChronoLocalDateTime
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long j;
        long j2;
        long j3;
        LocalDateTime from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        if (!temporalUnit.isTimeBased()) {
            LocalDate localDate = from.date;
            if (localDate.isAfter(this.date) && from.time.isBefore(this.time)) {
                localDate = localDate.minusDays(1L);
            } else if (localDate.isBefore(this.date) && from.time.isAfter(this.time)) {
                localDate = localDate.plusDays(1L);
            }
            return this.date.until(localDate, temporalUnit);
        }
        long daysUntil = this.date.daysUntil(from.date);
        if (daysUntil == 0) {
            return this.time.until(from.time, temporalUnit);
        }
        long nanoOfDay = from.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (daysUntil > 0) {
            j = daysUntil - 1;
            j2 = nanoOfDay + 86400000000000L;
        } else {
            j = daysUntil + 1;
            j2 = nanoOfDay - 86400000000000L;
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                j = Math.multiplyExact(j, 86400000000000L);
                break;
            case 2:
                j = Math.multiplyExact(j, 86400000000L);
                j3 = 1000;
                j2 /= j3;
                break;
            case 3:
                j = Math.multiplyExact(j, 86400000L);
                j3 = 1000000;
                j2 /= j3;
                break;
            case 4:
                j = Math.multiplyExact(j, 86400L);
                j3 = 1000000000;
                j2 /= j3;
                break;
            case 5:
                j = Math.multiplyExact(j, 1440L);
                j3 = 60000000000L;
                j2 /= j3;
                break;
            case 6:
                j = Math.multiplyExact(j, 24L);
                j3 = 3600000000000L;
                j2 /= j3;
                break;
            case 7:
                j = Math.multiplyExact(j, 2L);
                j3 = 43200000000000L;
                j2 /= j3;
                break;
        }
        return Math.addExact(j, j2);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? with((LocalDate) temporalAdjuster, this.time) : temporalAdjuster instanceof LocalTime ? with(this.date, (LocalTime) temporalAdjuster) : temporalAdjuster instanceof LocalDateTime ? (LocalDateTime) temporalAdjuster : (LocalDateTime) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDateTime with(TemporalField temporalField, long j) {
        return temporalField instanceof ChronoField ? ((ChronoField) temporalField).isTimeBased() ? with(this.date, this.time.with(temporalField, j)) : with(this.date.with(temporalField, j), this.time) : (LocalDateTime) temporalField.adjustInto(this, j);
    }
}
