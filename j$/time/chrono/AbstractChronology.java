package j$.time.chrono;

import j$.time.DateTimeException;
import j$.time.DayOfWeek;
import j$.time.format.ResolverStyle;
import j$.time.temporal.ChronoField;
import j$.time.temporal.ChronoUnit;
import j$.time.temporal.TemporalAdjusters;
import j$.time.temporal.TemporalUnit;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class AbstractChronology implements Chronology {
    static final Comparator DATE_ORDER = new AbstractChronology$$ExternalSyntheticLambda0();
    static final Comparator DATE_TIME_ORDER = new AbstractChronology$$ExternalSyntheticLambda1();
    static final Comparator INSTANT_ORDER = new AbstractChronology$$ExternalSyntheticLambda2();
    private static final ConcurrentHashMap CHRONOS_BY_ID = new ConcurrentHashMap();
    private static final ConcurrentHashMap CHRONOS_BY_TYPE = new ConcurrentHashMap();
    private static final Locale JAPANESE_CALENDAR_LOCALE = new Locale("ja", "JP", "JP");

    public static /* synthetic */ int lambda$static$2241c452$1(ChronoZonedDateTime chronoZonedDateTime, ChronoZonedDateTime chronoZonedDateTime2) {
        int compare = Long.compare(chronoZonedDateTime.toEpochSecond(), chronoZonedDateTime2.toEpochSecond());
        return compare == 0 ? Long.compare(chronoZonedDateTime.toLocalTime().getNano(), chronoZonedDateTime2.toLocalTime().getNano()) : compare;
    }

    public static /* synthetic */ int lambda$static$b5a61975$1(ChronoLocalDateTime chronoLocalDateTime, ChronoLocalDateTime chronoLocalDateTime2) {
        int compare = Long.compare(chronoLocalDateTime.toLocalDate().toEpochDay(), chronoLocalDateTime2.toLocalDate().toEpochDay());
        return compare == 0 ? Long.compare(chronoLocalDateTime.toLocalTime().toNanoOfDay(), chronoLocalDateTime2.toLocalTime().toNanoOfDay()) : compare;
    }

    public void addFieldValue(Map map, ChronoField chronoField, long j) {
        Long l = (Long) map.get(chronoField);
        if (l == null || l.longValue() == j) {
            map.put(chronoField, Long.valueOf(j));
            return;
        }
        throw new DateTimeException("Conflict found: " + chronoField + " " + l + " differs from " + chronoField + " " + j);
    }

    @Override // java.lang.Comparable
    public int compareTo(Chronology chronology) {
        return getId().compareTo(chronology.getId());
    }

    @Override // j$.time.chrono.Chronology
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbstractChronology) && compareTo((Chronology) obj) == 0;
    }

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    ChronoLocalDate resolveAligned(ChronoLocalDate chronoLocalDate, long j, long j2, long j3) {
        long j4;
        ChronoLocalDate plus = chronoLocalDate.plus(j, (TemporalUnit) ChronoUnit.MONTHS);
        ChronoUnit chronoUnit = ChronoUnit.WEEKS;
        ChronoLocalDate plus2 = plus.plus(j2, (TemporalUnit) chronoUnit);
        if (j3 <= 7) {
            if (j3 < 1) {
                plus2 = plus2.plus(Math.subtractExact(j3, 7L) / 7, (TemporalUnit) chronoUnit);
                j4 = j3 + 6;
            }
            return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.of((int) j3)));
        }
        j4 = j3 - 1;
        plus2 = plus2.plus(j4 / 7, (TemporalUnit) chronoUnit);
        j3 = (j4 % 7) + 1;
        return plus2.with(TemporalAdjusters.nextOrSame(DayOfWeek.of((int) j3)));
    }

    @Override // j$.time.chrono.Chronology
    public ChronoLocalDate resolveDate(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            return dateEpochDay(((Long) map.remove(chronoField)).longValue());
        }
        resolveProlepticMonth(map, resolverStyle);
        ChronoLocalDate resolveYearOfEra = resolveYearOfEra(map, resolverStyle);
        if (resolveYearOfEra != null) {
            return resolveYearOfEra;
        }
        if (!map.containsKey(ChronoField.YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.MONTH_OF_YEAR)) {
            if (map.containsKey(ChronoField.DAY_OF_MONTH)) {
                return resolveYMD(map, resolverStyle);
            }
            if (map.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH)) {
                if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)) {
                    return resolveYMAA(map, resolverStyle);
                }
                if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
                    return resolveYMAD(map, resolverStyle);
                }
            }
        }
        if (map.containsKey(ChronoField.DAY_OF_YEAR)) {
            return resolveYD(map, resolverStyle);
        }
        if (!map.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR)) {
            return null;
        }
        if (map.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)) {
            return resolveYAA(map, resolverStyle);
        }
        if (map.containsKey(ChronoField.DAY_OF_WEEK)) {
            return resolveYAD(map, resolverStyle);
        }
        return null;
    }

    abstract void resolveProlepticMonth(Map map, ResolverStyle resolverStyle);

    ChronoLocalDate resolveYAA(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        ChronoLocalDate plus = dateYearDay(checkValidIntValue, 1).plus(((checkValidIntValue2 - 1) * 7) + (range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField) == checkValidIntValue) {
            return plus;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
    }

    ChronoLocalDate resolveYAD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(dateYearDay(checkValidIntValue, 1), 0L, Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_YEAR)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_WEEK)).longValue(), 1L));
        }
        ChronoField chronoField2 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.DAY_OF_WEEK;
        ChronoLocalDate with = dateYearDay(checkValidIntValue, 1).plus((checkValidIntValue2 - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField) == checkValidIntValue) {
            return with;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different year");
    }

    ChronoLocalDate resolveYD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return dateYearDay(checkValidIntValue, 1).plus(Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_YEAR)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
        return dateYearDay(checkValidIntValue, range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2));
    }

    ChronoLocalDate resolveYMAA(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            long subtractExact = Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L);
            return date(checkValidIntValue, 1, 1).plus(subtractExact, (TemporalUnit) ChronoUnit.MONTHS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.WEEKS).plus(Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH)).longValue(), 1L), (TemporalUnit) ChronoUnit.DAYS);
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3);
        ChronoField chronoField4 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        ChronoLocalDate plus = date(checkValidIntValue, checkValidIntValue2, 1).plus(((checkValidIntValue3 - 1) * 7) + (range(chronoField4).checkValidIntValue(((Long) map.remove(chronoField4)).longValue(), chronoField4) - 1), (TemporalUnit) ChronoUnit.DAYS);
        if (resolverStyle != ResolverStyle.STRICT || plus.get(chronoField2) == checkValidIntValue2) {
            return plus;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
    }

    ChronoLocalDate resolveYMAD(Map map, ResolverStyle resolverStyle) {
        ChronoField chronoField = ChronoField.YEAR;
        int checkValidIntValue = range(chronoField).checkValidIntValue(((Long) map.remove(chronoField)).longValue(), chronoField);
        if (resolverStyle == ResolverStyle.LENIENT) {
            return resolveAligned(date(checkValidIntValue, 1, 1), Math.subtractExact(((Long) map.remove(ChronoField.MONTH_OF_YEAR)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.ALIGNED_WEEK_OF_MONTH)).longValue(), 1L), Math.subtractExact(((Long) map.remove(ChronoField.DAY_OF_WEEK)).longValue(), 1L));
        }
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        int checkValidIntValue2 = range(chronoField2).checkValidIntValue(((Long) map.remove(chronoField2)).longValue(), chronoField2);
        ChronoField chronoField3 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        int checkValidIntValue3 = range(chronoField3).checkValidIntValue(((Long) map.remove(chronoField3)).longValue(), chronoField3);
        ChronoField chronoField4 = ChronoField.DAY_OF_WEEK;
        ChronoLocalDate with = date(checkValidIntValue, checkValidIntValue2, 1).plus((checkValidIntValue3 - 1) * 7, (TemporalUnit) ChronoUnit.DAYS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(range(chronoField4).checkValidIntValue(((Long) map.remove(chronoField4)).longValue(), chronoField4))));
        if (resolverStyle != ResolverStyle.STRICT || with.get(chronoField2) == checkValidIntValue2) {
            return with;
        }
        throw new DateTimeException("Strict mode rejected resolved date as it is in a different month");
    }

    abstract ChronoLocalDate resolveYMD(Map map, ResolverStyle resolverStyle);

    abstract ChronoLocalDate resolveYearOfEra(Map map, ResolverStyle resolverStyle);

    public String toString() {
        return getId();
    }
}
