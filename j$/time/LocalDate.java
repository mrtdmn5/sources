package j$.time;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.R;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.IsoChronology;
import j$.time.format.DateTimeFormatter;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.Temporal;
import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalAdjuster;
import j$.time.temporal.TemporalAmount;
import j$.time.temporal.TemporalField;
import j$.time.temporal.TemporalQueries;
import j$.time.temporal.TemporalQuery;
import j$.time.temporal.TemporalUnit;
import j$.time.temporal.UnsupportedTemporalTypeException;
import j$.time.temporal.ValueRange;
import j$.time.zone.ZoneOffsetTransition;
import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class LocalDate implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
    private final short day;
    private final short month;
    private final int year;
    public static final LocalDate MIN = of(-999999999, 1, 1);
    public static final LocalDate MAX = of(999999999, 12, 31);

    /* renamed from: j$.time.LocalDate$1 */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoUnit;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$java$time$temporal$ChronoUnit = r0;
            try {
                r0[ChronoUnit.DAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoUnit[ChronoUnit.ERAS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] r8 = new int[ChronoField.values().length];
            $SwitchMap$java$time$temporal$ChronoField = r8;
            try {
                r8[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$java$time$temporal$ChronoField[ChronoField.ERA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    private LocalDate(int r1, int r2, int r3) {
        this.year = r1;
        this.month = (short) r2;
        this.day = (short) r3;
    }

    private static LocalDate create(int r5, int r6, int r7) {
        int r0 = 28;
        if (r7 > 28) {
            if (r6 != 2) {
                r0 = (r6 == 4 || r6 == 6 || r6 == 9 || r6 == 11) ? 30 : 31;
            } else if (IsoChronology.INSTANCE.isLeapYear(r5)) {
                r0 = 29;
            }
            if (r7 > r0) {
                if (r7 == 29) {
                    throw new DateTimeException("Invalid date 'February 29' as '" + r5 + "' is not a leap year");
                }
                throw new DateTimeException("Invalid date '" + Month.of(r6).name() + " " + r7 + "'");
            }
        }
        return new LocalDate(r5, r6, r7);
    }

    public static LocalDate from(TemporalAccessor temporalAccessor) {
        Objects.requireNonNull(temporalAccessor, "temporal");
        LocalDate localDate = (LocalDate) temporalAccessor.query(TemporalQueries.localDate());
        if (localDate != null) {
            return localDate;
        }
        throw new DateTimeException("Unable to obtain LocalDate from TemporalAccessor: " + temporalAccessor + " of type " + temporalAccessor.getClass().getName());
    }

    private int get0(TemporalField temporalField) {
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.day;
            case 2:
                return getDayOfYear();
            case 3:
                return ((this.day - 1) / 7) + 1;
            case 4:
                int r4 = this.year;
                return r4 >= 1 ? r4 : 1 - r4;
            case 5:
                return getDayOfWeek().getValue();
            case 6:
                return ((this.day - 1) % 7) + 1;
            case 7:
                return ((getDayOfYear() - 1) % 7) + 1;
            case 8:
                throw new UnsupportedTemporalTypeException("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((getDayOfYear() - 1) / 7) + 1;
            case 10:
                return this.month;
            case 11:
                throw new UnsupportedTemporalTypeException("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.year;
            case 13:
                return this.year >= 1 ? 1 : 0;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    private long getProlepticMonth() {
        return ((this.year * 12) + this.month) - 1;
    }

    private long monthsUntil(LocalDate localDate) {
        return (((localDate.getProlepticMonth() * 32) + localDate.getDayOfMonth()) - ((getProlepticMonth() * 32) + getDayOfMonth())) / 32;
    }

    public static LocalDate of(int r3, int r4, int r5) {
        ChronoField.YEAR.checkValidValue(r3);
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        ChronoField.DAY_OF_MONTH.checkValidValue(r5);
        return create(r3, r4, r5);
    }

    public static LocalDate ofEpochDay(long j) {
        long j2;
        long j3 = (j + 719528) - 60;
        if (j3 < 0) {
            long j4 = ((j3 + 1) / 146097) - 1;
            j2 = j4 * 400;
            j3 += (-j4) * 146097;
        } else {
            j2 = 0;
        }
        long j5 = ((j3 * 400) + 591) / 146097;
        long j6 = j3 - ((((j5 * 365) + (j5 / 4)) - (j5 / 100)) + (j5 / 400));
        if (j6 < 0) {
            j5--;
            j6 = j3 - ((((365 * j5) + (j5 / 4)) - (j5 / 100)) + (j5 / 400));
        }
        int r0 = (int) j6;
        int r1 = ((r0 * 5) + 2) / R.styleable.AppTheme_stepsHistoryLineColorActivity;
        return new LocalDate(ChronoField.YEAR.checkValidIntValue(j5 + j2 + (r1 / 10)), ((r1 + 2) % 12) + 1, (r0 - (((r1 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate ofYearDay(int r5, int r6) {
        long j = r5;
        ChronoField.YEAR.checkValidValue(j);
        ChronoField.DAY_OF_YEAR.checkValidValue(r6);
        boolean isLeapYear = IsoChronology.INSTANCE.isLeapYear(j);
        if (r6 != 366 || isLeapYear) {
            Month of = Month.of(((r6 - 1) / 31) + 1);
            if (r6 > (of.firstDayOfYear(isLeapYear) + of.length(isLeapYear)) - 1) {
                of = of.plus(1L);
            }
            return new LocalDate(r5, of.getValue(), (r6 - of.firstDayOfYear(isLeapYear)) + 1);
        }
        throw new DateTimeException("Invalid date 'DayOfYear 366' as '" + r5 + "' is not a leap year");
    }

    public static LocalDate parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static LocalDate parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return (LocalDate) dateTimeFormatter.parse(charSequence, new TemporalQuery() { // from class: j$.time.LocalDate$$ExternalSyntheticLambda0
            @Override // j$.time.temporal.TemporalQuery
            public final Object queryFrom(TemporalAccessor temporalAccessor) {
                return LocalDate.from(temporalAccessor);
            }
        });
    }

    private static LocalDate resolvePreviousValid(int r3, int r4, int r5) {
        int r0;
        if (r4 != 2) {
            if (r4 == 4 || r4 == 6 || r4 == 9 || r4 == 11) {
                r0 = 30;
            }
            return new LocalDate(r3, r4, r5);
        }
        r0 = IsoChronology.INSTANCE.isLeapYear((long) r3) ? 29 : 28;
        r5 = Math.min(r5, r0);
        return new LocalDate(r3, r4, r5);
    }

    @Override // j$.time.temporal.TemporalAdjuster
    public Temporal adjustInto(Temporal temporal) {
        return super.adjustInto(temporal);
    }

    public ZonedDateTime atStartOfDay(ZoneId zoneId) {
        ZoneOffsetTransition transition;
        Objects.requireNonNull(zoneId, "zone");
        LocalDateTime atTime = atTime(LocalTime.MIDNIGHT);
        if (!(zoneId instanceof ZoneOffset) && (transition = zoneId.getRules().getTransition(atTime)) != null && transition.isGap()) {
            atTime = transition.getDateTimeAfter();
        }
        return ZonedDateTime.of(atTime, zoneId);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public LocalDateTime atTime(LocalTime localTime) {
        return LocalDateTime.of(this, localTime);
    }

    @Override // java.lang.Comparable
    public int compareTo(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) : super.compareTo(chronoLocalDate);
    }

    public int compareTo0(LocalDate localDate) {
        int r0 = this.year - localDate.year;
        if (r0 != 0) {
            return r0;
        }
        int r02 = this.month - localDate.month;
        return r02 == 0 ? this.day - localDate.day : r02;
    }

    public long daysUntil(LocalDate localDate) {
        return localDate.toEpochDay() - toEpochDay();
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && compareTo0((LocalDate) obj) == 0;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public int get(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? get0(temporalField) : super.get(temporalField);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public IsoChronology getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDayOfMonth() {
        return this.day;
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.of(((int) Math.floorMod(toEpochDay() + 3, 7L)) + 1);
    }

    public int getDayOfYear() {
        return (getMonth().firstDayOfYear(isLeapYear()) + this.day) - 1;
    }

    @Override // j$.time.temporal.TemporalAccessor
    public long getLong(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.EPOCH_DAY ? toEpochDay() : temporalField == ChronoField.PROLEPTIC_MONTH ? getProlepticMonth() : get0(temporalField) : temporalField.getFrom(this);
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int hashCode() {
        int r0 = this.year;
        return (((r0 << 11) + (this.month << 6)) + this.day) ^ (r0 & (-2048));
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean isAfter(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) > 0 : super.isAfter(chronoLocalDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean isBefore(ChronoLocalDate chronoLocalDate) {
        return chronoLocalDate instanceof LocalDate ? compareTo0((LocalDate) chronoLocalDate) < 0 : super.isBefore(chronoLocalDate);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public boolean isLeapYear() {
        return IsoChronology.INSTANCE.isLeapYear(this.year);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public boolean isSupported(TemporalField temporalField) {
        return super.isSupported(temporalField);
    }

    public int lengthOfMonth() {
        short s = this.month;
        return s != 2 ? (s == 4 || s == 6 || s == 9 || s == 11) ? 30 : 31 : isLeapYear() ? 29 : 28;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    @Override // j$.time.temporal.Temporal, j$.time.chrono.ChronoLocalDate
    public LocalDate minus(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? plus(Long.MAX_VALUE, temporalUnit).plus(1L, temporalUnit) : plus(-j, temporalUnit);
    }

    public LocalDate minusDays(long j) {
        return j == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j);
    }

    public LocalDate minusYears(long j) {
        return j == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDate plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.addTo(this, j);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return plusDays(j);
            case 2:
                return plusWeeks(j);
            case 3:
                return plusMonths(j);
            case 4:
                return plusYears(j);
            case 5:
                return plusYears(Math.multiplyExact(j, 10L));
            case 6:
                return plusYears(Math.multiplyExact(j, 100L));
            case 7:
                return plusYears(Math.multiplyExact(j, 1000L));
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return with((TemporalField) chronoField, Math.addExact(getLong(chronoField), j));
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    @Override // j$.time.temporal.Temporal, j$.time.chrono.ChronoLocalDate
    public LocalDate plus(TemporalAmount temporalAmount) {
        if (temporalAmount instanceof Period) {
            return plusMonths(((Period) temporalAmount).toTotalMonths()).plusDays(r4.getDays());
        }
        Objects.requireNonNull(temporalAmount, "amountToAdd");
        return (LocalDate) temporalAmount.addTo(this);
    }

    public LocalDate plusDays(long j) {
        return j == 0 ? this : ofEpochDay(Math.addExact(toEpochDay(), j));
    }

    public LocalDate plusMonths(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = (this.year * 12) + (this.month - 1) + j;
        return resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(Math.floorDiv(j2, 12L)), ((int) Math.floorMod(j2, 12L)) + 1, this.day);
    }

    public LocalDate plusWeeks(long j) {
        return plusDays(Math.multiplyExact(j, 7L));
    }

    public LocalDate plusYears(long j) {
        return j == 0 ? this : resolvePreviousValid(ChronoField.YEAR.checkValidIntValue(this.year + j), this.month, this.day);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public Object query(TemporalQuery temporalQuery) {
        return temporalQuery == TemporalQueries.localDate() ? this : super.query(temporalQuery);
    }

    @Override // j$.time.temporal.TemporalAccessor
    public ValueRange range(TemporalField temporalField) {
        int lengthOfMonth;
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.rangeRefinedBy(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (!chronoField.isDateBased()) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
        int r0 = AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
        if (r0 == 1) {
            lengthOfMonth = lengthOfMonth();
        } else {
            if (r0 != 2) {
                if (r0 == 3) {
                    return ValueRange.of(1L, (getMonth() != Month.FEBRUARY || isLeapYear()) ? 5L : 4L);
                }
                if (r0 != 4) {
                    return temporalField.range();
                }
                return ValueRange.of(1L, getYear() <= 0 ? 1000000000L : 999999999L);
            }
            lengthOfMonth = lengthOfYear();
        }
        return ValueRange.of(1L, lengthOfMonth);
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public long toEpochDay() {
        long j = this.year;
        long j2 = this.month;
        long j3 = (365 * j) + 0;
        long j4 = (j >= 0 ? j3 + (((3 + j) / 4) - ((99 + j) / 100)) + ((j + 399) / 400) : j3 - (((j / (-4)) - (j / (-100))) + (j / (-400)))) + (((367 * j2) - 362) / 12) + (this.day - 1);
        if (j2 > 2) {
            j4--;
            if (!isLeapYear()) {
                j4--;
            }
        }
        return j4 - 719528;
    }

    @Override // j$.time.chrono.ChronoLocalDate
    public String toString() {
        int r0;
        int r02 = this.year;
        short s = this.month;
        short s2 = this.day;
        int abs = Math.abs(r02);
        StringBuilder sb = new StringBuilder(10);
        if (abs < 1000) {
            if (r02 < 0) {
                sb.append(r02 - 10000);
                r0 = 1;
            } else {
                sb.append(r02 + Constants.MAXIMUM_UPLOAD_PARTS);
                r0 = 0;
            }
            sb.deleteCharAt(r0);
        } else {
            if (r02 > 9999) {
                sb.append('+');
            }
            sb.append(r02);
        }
        sb.append(s < 10 ? "-0" : "-");
        sb.append((int) s);
        sb.append(s2 >= 10 ? "-" : "-0");
        sb.append((int) s2);
        return sb.toString();
    }

    @Override // j$.time.temporal.Temporal
    public long until(Temporal temporal, TemporalUnit temporalUnit) {
        long daysUntil;
        long j;
        LocalDate from = from(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.between(this, from);
        }
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoUnit[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return daysUntil(from);
            case 2:
                daysUntil = daysUntil(from);
                j = 7;
                break;
            case 3:
                return monthsUntil(from);
            case 4:
                daysUntil = monthsUntil(from);
                j = 12;
                break;
            case 5:
                daysUntil = monthsUntil(from);
                j = 120;
                break;
            case 6:
                daysUntil = monthsUntil(from);
                j = 1200;
                break;
            case 7:
                daysUntil = monthsUntil(from);
                j = 12000;
                break;
            case 8:
                ChronoField chronoField = ChronoField.ERA;
                return from.getLong(chronoField) - getLong(chronoField);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return daysUntil / j;
    }

    @Override // j$.time.temporal.Temporal
    public LocalDate with(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalDate ? (LocalDate) temporalAdjuster : (LocalDate) temporalAdjuster.adjustInto(this);
    }

    @Override // j$.time.temporal.Temporal
    public LocalDate with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.checkValidValue(j);
        switch (AnonymousClass1.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()]) {
            case 1:
                return withDayOfMonth((int) j);
            case 2:
                return withDayOfYear((int) j);
            case 3:
                return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH));
            case 4:
                if (this.year < 1) {
                    j = 1 - j;
                }
                return withYear((int) j);
            case 5:
                return plusDays(j - getDayOfWeek().getValue());
            case 6:
                return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return plusDays(j - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return ofEpochDay(j);
            case 9:
                return plusWeeks(j - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR));
            case 10:
                return withMonth((int) j);
            case 11:
                return plusMonths(j - getProlepticMonth());
            case 12:
                return withYear((int) j);
            case 13:
                return getLong(ChronoField.ERA) == j ? this : withYear(1 - this.year);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public LocalDate withDayOfMonth(int r3) {
        return this.day == r3 ? this : of(this.year, this.month, r3);
    }

    public LocalDate withDayOfYear(int r2) {
        return getDayOfYear() == r2 ? this : ofYearDay(this.year, r2);
    }

    public LocalDate withMonth(int r4) {
        if (this.month == r4) {
            return this;
        }
        ChronoField.MONTH_OF_YEAR.checkValidValue(r4);
        return resolvePreviousValid(this.year, r4, this.day);
    }

    public LocalDate withYear(int r4) {
        if (this.year == r4) {
            return this;
        }
        ChronoField.YEAR.checkValidValue(r4);
        return resolvePreviousValid(r4, this.month, this.day);
    }
}
