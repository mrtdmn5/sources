package j$.time.temporal;

import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.chrono.ChronoLocalDate;
import j$.time.chrono.Chronology;
import j$.time.format.ResolverStyle;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    public static final TemporalUnit WEEK_BASED_YEARS = IsoFields.WEEK_BASED_YEARS;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient TemporalField dayOfWeek = ComputedDayOfField.ofDayOfWeekField(this);
    private final transient TemporalField weekOfMonth = ComputedDayOfField.ofWeekOfMonthField(this);
    private final transient TemporalField weekOfYear = ComputedDayOfField.ofWeekOfYearField(this);
    private final transient TemporalField weekOfWeekBasedYear = ComputedDayOfField.ofWeekOfWeekBasedYearField(this);
    private final transient TemporalField weekBasedYear = ComputedDayOfField.ofWeekBasedYearField(this);

    /* loaded from: classes2.dex */
    static class ComputedDayOfField implements TemporalField {
        private final TemporalUnit baseUnit;
        private final String name;
        private final ValueRange range;
        private final TemporalUnit rangeUnit;
        private final WeekFields weekDef;
        private static final ValueRange DAY_OF_WEEK_RANGE = ValueRange.of(1, 7);
        private static final ValueRange WEEK_OF_MONTH_RANGE = ValueRange.of(0, 1, 4, 6);
        private static final ValueRange WEEK_OF_YEAR_RANGE = ValueRange.of(0, 1, 52, 54);
        private static final ValueRange WEEK_OF_WEEK_BASED_YEAR_RANGE = ValueRange.of(1, 52, 53);

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.name = str;
            this.weekDef = weekFields;
            this.baseUnit = temporalUnit;
            this.rangeUnit = temporalUnit2;
            this.range = valueRange;
        }

        private int computeWeek(int r1, int r2) {
            return ((r1 + 7) + (r2 - 1)) / 7;
        }

        private int localizedDayOfWeek(int r2) {
            return Math.floorMod(r2 - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private int localizedDayOfWeek(TemporalAccessor temporalAccessor) {
            return Math.floorMod(temporalAccessor.get(ChronoField.DAY_OF_WEEK) - this.weekDef.getFirstDayOfWeek().getValue(), 7) + 1;
        }

        private int localizedWeekBasedYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int r1 = temporalAccessor.get(ChronoField.YEAR);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int r3 = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(r3, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, r3);
            return computeWeek == 0 ? r1 - 1 : computeWeek >= computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(chronoField).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()) ? r1 + 1 : r1;
        }

        private long localizedWeekOfMonth(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int r3 = temporalAccessor.get(ChronoField.DAY_OF_MONTH);
            return computeWeek(startOfWeekOffset(r3, localizedDayOfWeek), r3);
        }

        private int localizedWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            int computeWeek;
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            int r2 = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(r2, localizedDayOfWeek);
            int computeWeek2 = computeWeek(startOfWeekOffset, r2);
            return computeWeek2 == 0 ? localizedWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(r2, (TemporalUnit) ChronoUnit.DAYS)) : (computeWeek2 <= 50 || computeWeek2 < (computeWeek = computeWeek(startOfWeekOffset, ((int) temporalAccessor.range(chronoField).getMaximum()) + this.weekDef.getMinimalDaysInFirstWeek()))) ? computeWeek2 : (computeWeek2 - computeWeek) + 1;
        }

        private long localizedWeekOfYear(TemporalAccessor temporalAccessor) {
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int r3 = temporalAccessor.get(ChronoField.DAY_OF_YEAR);
            return computeWeek(startOfWeekOffset(r3, localizedDayOfWeek), r3);
        }

        static ComputedDayOfField ofDayOfWeekField(WeekFields weekFields) {
            return new ComputedDayOfField(com.animaconnected.secondo.behaviour.dayofweek.DayOfWeek.TYPE, weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, DAY_OF_WEEK_RANGE);
        }

        private ChronoLocalDate ofWeekBasedYear(Chronology chronology, int r5, int r6, int r7) {
            ChronoLocalDate date = chronology.date(r5, 1, 1);
            int startOfWeekOffset = startOfWeekOffset(1, localizedDayOfWeek(date));
            return date.plus((-startOfWeekOffset) + (r7 - 1) + ((Math.min(r6, computeWeek(startOfWeekOffset, date.lengthOfYear() + this.weekDef.getMinimalDaysInFirstWeek()) - 1) - 1) * 7), (TemporalUnit) ChronoUnit.DAYS);
        }

        static ComputedDayOfField ofWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.WEEK_BASED_YEARS, ChronoUnit.FOREVER, ChronoField.YEAR.range());
        }

        static ComputedDayOfField ofWeekOfMonthField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, WEEK_OF_MONTH_RANGE);
        }

        static ComputedDayOfField ofWeekOfWeekBasedYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.WEEK_BASED_YEARS, WEEK_OF_WEEK_BASED_YEAR_RANGE);
        }

        static ComputedDayOfField ofWeekOfYearField(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, WEEK_OF_YEAR_RANGE);
        }

        private ValueRange rangeByWeek(TemporalAccessor temporalAccessor, TemporalField temporalField) {
            int startOfWeekOffset = startOfWeekOffset(temporalAccessor.get(temporalField), localizedDayOfWeek(temporalAccessor));
            ValueRange range = temporalAccessor.range(temporalField);
            return ValueRange.of(computeWeek(startOfWeekOffset, (int) range.getMinimum()), computeWeek(startOfWeekOffset, (int) range.getMaximum()));
        }

        private ValueRange rangeWeekOfWeekBasedYear(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.DAY_OF_YEAR;
            if (!temporalAccessor.isSupported(chronoField)) {
                return WEEK_OF_YEAR_RANGE;
            }
            int localizedDayOfWeek = localizedDayOfWeek(temporalAccessor);
            int r2 = temporalAccessor.get(chronoField);
            int startOfWeekOffset = startOfWeekOffset(r2, localizedDayOfWeek);
            int computeWeek = computeWeek(startOfWeekOffset, r2);
            if (computeWeek == 0) {
                return rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).minus(r2 + 7, (TemporalUnit) ChronoUnit.DAYS));
            }
            return computeWeek >= computeWeek(startOfWeekOffset, this.weekDef.getMinimalDaysInFirstWeek() + ((int) temporalAccessor.range(chronoField).getMaximum())) ? rangeWeekOfWeekBasedYear(Chronology.from(temporalAccessor).date(temporalAccessor).plus((r0 - r2) + 1 + 7, (TemporalUnit) ChronoUnit.DAYS)) : ValueRange.of(1L, r1 - 1);
        }

        private ChronoLocalDate resolveWBY(Map map, Chronology chronology, int r8, ResolverStyle resolverStyle) {
            ChronoLocalDate ofWeekBasedYear;
            int checkValidIntValue = this.weekDef.weekBasedYear.range().checkValidIntValue(((Long) map.get(this.weekDef.weekBasedYear)).longValue(), this.weekDef.weekBasedYear);
            if (resolverStyle == ResolverStyle.LENIENT) {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, 1, r8).plus(Math.subtractExact(((Long) map.get(this.weekDef.weekOfWeekBasedYear)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS);
            } else {
                ofWeekBasedYear = ofWeekBasedYear(chronology, checkValidIntValue, this.weekDef.weekOfWeekBasedYear.range().checkValidIntValue(((Long) map.get(this.weekDef.weekOfWeekBasedYear)).longValue(), this.weekDef.weekOfWeekBasedYear), r8);
                if (resolverStyle == ResolverStyle.STRICT && localizedWeekBasedYear(ofWeekBasedYear) != checkValidIntValue) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different week-based-year");
                }
            }
            map.remove(this);
            map.remove(this.weekDef.weekBasedYear);
            map.remove(this.weekDef.weekOfWeekBasedYear);
            map.remove(ChronoField.DAY_OF_WEEK);
            return ofWeekBasedYear;
        }

        private ChronoLocalDate resolveWoM(Map map, Chronology chronology, int r6, long j, long j2, int r11, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            if (resolverStyle == ResolverStyle.LENIENT) {
                ChronoLocalDate plus2 = chronology.date(r6, 1, 1).plus(Math.subtractExact(j, 1L), (TemporalUnit) ChronoUnit.MONTHS);
                plus = plus2.plus(Math.addExact(Math.multiplyExact(Math.subtractExact(j2, localizedWeekOfMonth(plus2)), 7L), r11 - localizedDayOfWeek(plus2)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                plus = chronology.date(r6, chronoField.checkValidIntValue(j), 1).plus((((int) (this.range.checkValidIntValue(j2, this) - localizedWeekOfMonth(r5))) * 7) + (r11 - localizedDayOfWeek(r5)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(chronoField) != j) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.MONTH_OF_YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private ChronoLocalDate resolveWoY(Map map, Chronology chronology, int r5, long j, int r8, ResolverStyle resolverStyle) {
            ChronoLocalDate plus;
            ChronoLocalDate date = chronology.date(r5, 1, 1);
            if (resolverStyle == ResolverStyle.LENIENT) {
                plus = date.plus(Math.addExact(Math.multiplyExact(Math.subtractExact(j, localizedWeekOfYear(date)), 7L), r8 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
            } else {
                plus = date.plus((((int) (this.range.checkValidIntValue(j, this) - localizedWeekOfYear(date))) * 7) + (r8 - localizedDayOfWeek(date)), (TemporalUnit) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(ChronoField.YEAR) != r5) {
                    throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
                }
            }
            map.remove(this);
            map.remove(ChronoField.YEAR);
            map.remove(ChronoField.DAY_OF_WEEK);
            return plus;
        }

        private int startOfWeekOffset(int r4, int r5) {
            int floorMod = Math.floorMod(r4 - r5, 7);
            return floorMod + 1 > this.weekDef.getMinimalDaysInFirstWeek() ? 7 - floorMod : -floorMod;
        }

        @Override // j$.time.temporal.TemporalField
        public Temporal adjustInto(Temporal temporal, long j) {
            if (this.range.checkValidIntValue(j, this) == temporal.get(this)) {
                return temporal;
            }
            if (this.rangeUnit != ChronoUnit.FOREVER) {
                return temporal.plus(r0 - r1, this.baseUnit);
            }
            return ofWeekBasedYear(Chronology.from(temporal), (int) j, temporal.get(this.weekDef.weekOfWeekBasedYear), temporal.get(this.weekDef.dayOfWeek));
        }

        @Override // j$.time.temporal.TemporalField
        public long getFrom(TemporalAccessor temporalAccessor) {
            int localizedWeekBasedYear;
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                localizedWeekBasedYear = localizedDayOfWeek(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.MONTHS) {
                    return localizedWeekOfMonth(temporalAccessor);
                }
                if (temporalUnit == ChronoUnit.YEARS) {
                    return localizedWeekOfYear(temporalAccessor);
                }
                if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                    localizedWeekBasedYear = localizedWeekOfWeekBasedYear(temporalAccessor);
                } else {
                    if (temporalUnit != ChronoUnit.FOREVER) {
                        throw new IllegalStateException("unreachable, rangeUnit: " + this.rangeUnit + ", this: " + this);
                    }
                    localizedWeekBasedYear = localizedWeekBasedYear(temporalAccessor);
                }
            }
            return localizedWeekBasedYear;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isDateBased() {
            return true;
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isSupportedBy(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            if (!temporalAccessor.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS || temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else {
                if (temporalUnit != ChronoUnit.FOREVER) {
                    return false;
                }
                chronoField = ChronoField.YEAR;
            }
            return temporalAccessor.isSupported(chronoField);
        }

        @Override // j$.time.temporal.TemporalField
        public boolean isTimeBased() {
            return false;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange range() {
            return this.range;
        }

        @Override // j$.time.temporal.TemporalField
        public ValueRange rangeRefinedBy(TemporalAccessor temporalAccessor) {
            TemporalUnit temporalUnit = this.rangeUnit;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.range;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_MONTH);
            }
            if (temporalUnit == ChronoUnit.YEARS) {
                return rangeByWeek(temporalAccessor, ChronoField.DAY_OF_YEAR);
            }
            if (temporalUnit == WeekFields.WEEK_BASED_YEARS) {
                return rangeWeekOfWeekBasedYear(temporalAccessor);
            }
            if (temporalUnit == ChronoUnit.FOREVER) {
                return ChronoField.YEAR.range();
            }
            throw new IllegalStateException("unreachable, rangeUnit: " + this.rangeUnit + ", this: " + this);
        }

        @Override // j$.time.temporal.TemporalField
        public ChronoLocalDate resolve(Map map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            int intExact = Math.toIntExact(((Long) map.get(this)).longValue());
            if (this.rangeUnit == ChronoUnit.WEEKS) {
                long floorMod = Math.floorMod((this.weekDef.getFirstDayOfWeek().getValue() - 1) + (this.range.checkValidIntValue(r2, this) - 1), 7) + 1;
                map.remove(this);
                map.put(ChronoField.DAY_OF_WEEK, Long.valueOf(floorMod));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map.containsKey(chronoField)) {
                return null;
            }
            int localizedDayOfWeek = localizedDayOfWeek(chronoField.checkValidIntValue(((Long) map.get(chronoField)).longValue()));
            Chronology from = Chronology.from(temporalAccessor);
            ChronoField chronoField2 = ChronoField.YEAR;
            if (map.containsKey(chronoField2)) {
                int checkValidIntValue = chronoField2.checkValidIntValue(((Long) map.get(chronoField2)).longValue());
                if (this.rangeUnit == ChronoUnit.MONTHS) {
                    Object obj = ChronoField.MONTH_OF_YEAR;
                    if (map.containsKey(obj)) {
                        return resolveWoM(map, from, checkValidIntValue, ((Long) map.get(obj)).longValue(), intExact, localizedDayOfWeek, resolverStyle);
                    }
                }
                if (this.rangeUnit == ChronoUnit.YEARS) {
                    return resolveWoY(map, from, checkValidIntValue, intExact, localizedDayOfWeek, resolverStyle);
                }
            } else {
                TemporalUnit temporalUnit = this.rangeUnit;
                if ((temporalUnit == WeekFields.WEEK_BASED_YEARS || temporalUnit == ChronoUnit.FOREVER) && map.containsKey(this.weekDef.weekBasedYear) && map.containsKey(this.weekDef.weekOfWeekBasedYear)) {
                    return resolveWBY(map, from, localizedDayOfWeek, resolverStyle);
                }
            }
            return null;
        }

        public String toString() {
            return this.name + "[" + this.weekDef.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek, int r3) {
        Objects.requireNonNull(dayOfWeek, "firstDayOfWeek");
        if (r3 < 1 || r3 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = r3;
    }

    public static WeekFields of(DayOfWeek dayOfWeek, int r4) {
        String str = dayOfWeek.toString() + r4;
        ConcurrentMap concurrentMap = CACHE;
        WeekFields weekFields = (WeekFields) concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, r4));
        return (WeekFields) concurrentMap.get(str);
    }

    public static WeekFields of(Locale locale) {
        Objects.requireNonNull(locale, "locale");
        return of(DayOfWeek.SUNDAY.plus(r4.getFirstDayOfWeek() - 1), Calendar.getInstance(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    public TemporalField dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }

    public TemporalField weekBasedYear() {
        return this.weekBasedYear;
    }

    public TemporalField weekOfMonth() {
        return this.weekOfMonth;
    }

    public TemporalField weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }
}
