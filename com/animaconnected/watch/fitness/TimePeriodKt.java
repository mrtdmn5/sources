package com.animaconnected.watch.fitness;

import com.animaconnected.info.DateTimeUtilsKt;
import j$.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.TakeWhileSequence;
import kotlin.sequences.TransformingSequence;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.InstantKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import kotlinx.datetime.internal.MathKt;

/* compiled from: TimePeriod.kt */
/* loaded from: classes3.dex */
public final class TimePeriodKt {
    public static final TimePeriod coerceInOrNull(TimePeriod timePeriod, TimePeriod timePeriod2) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        if (timePeriod2 != null && timePeriod.getEnd().compareTo(timePeriod2.getStart()) > 0 && timePeriod.getStart().compareTo(timePeriod2.getEnd()) < 0) {
            return new TimePeriod(Math.max(timePeriod.getStartTs(), timePeriod2.getStartTs()), Math.min(timePeriod.getEndTs(), timePeriod2.getEndTs()));
        }
        return null;
    }

    public static final List<TimePeriod> dayIntervals(TimePeriod timePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant startOfDay = DateTimeUtilsKt.getStartOfDay(timePeriod.getStart(), timeZone);
        IntRange until = RangesKt___RangesKt.until(0, inDays$default(timePeriod, null, 1, null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            DateTimeUnit.Companion companion = DateTimeUnit.Companion;
            companion.getClass();
            DateTimeUnit.DayBased dayBased = DateTimeUnit.DAY;
            Instant plus = InstantJvmKt.plus(startOfDay, nextInt, (DateTimeUnit) dayBased, timeZone);
            companion.getClass();
            arrayList.add(new TimePeriod(plus, InstantJvmKt.plus(plus, 1, (DateTimeUnit) dayBased, timeZone)));
        }
        return arrayList;
    }

    public static /* synthetic */ List dayIntervals$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return dayIntervals(timePeriod, timeZone);
    }

    public static final TimePeriod excludeEnd(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Instant start = timePeriod.getStart();
        Instant end = timePeriod.getEnd();
        int r2 = Duration.$r8$clinit;
        return new TimePeriod(start, end.m1705minusLRDsOJo(DurationKt.toDuration(1, DurationUnit.MILLISECONDS)));
    }

    public static final TimePeriod excludeStart(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Instant start = timePeriod.getStart();
        int r2 = Duration.$r8$clinit;
        return new TimePeriod(start.m1706plusLRDsOJo(DurationKt.toDuration(1, DurationUnit.MILLISECONDS)), timePeriod.getEnd());
    }

    public static final int inDays(TimePeriod timePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantKt.daysUntil(timePeriod.getStart(), timePeriod.getEnd(), timeZone);
    }

    public static /* synthetic */ int inDays$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return inDays(timePeriod, timeZone);
    }

    public static final int inMonths(TimePeriod timePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant start = timePeriod.getStart();
        Instant other = timePeriod.getEnd();
        Intrinsics.checkNotNullParameter(start, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        DateTimeUnit.Companion.getClass();
        return MathKt.clampToInt(InstantJvmKt.until(start, other, DateTimeUnit.MONTH, timeZone));
    }

    public static /* synthetic */ int inMonths$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return inMonths(timePeriod, timeZone);
    }

    public static final List<TimePeriod> monthIntervals(TimePeriod timePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Instant start = TimePeriod.Companion.month(timePeriod.getStart(), timeZone).getStart();
        IntRange until = RangesKt___RangesKt.until(0, inMonths$default(timePeriod, null, 1, null));
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            DateTimeUnit.Companion companion = DateTimeUnit.Companion;
            companion.getClass();
            DateTimeUnit.MonthBased monthBased = DateTimeUnit.MONTH;
            Instant plus = InstantJvmKt.plus(start, nextInt, (DateTimeUnit) monthBased, timeZone);
            companion.getClass();
            arrayList.add(new TimePeriod(plus, InstantJvmKt.plus(plus, 1, (DateTimeUnit) monthBased, timeZone)));
        }
        return arrayList;
    }

    public static /* synthetic */ List monthIntervals$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return monthIntervals(timePeriod, timeZone);
    }

    public static final List<TimePeriod> monthlyPeriods(TimePeriod timePeriod, final TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        LocalDateTime atStartOfMonth = DateTimeUtilsKt.atStartOfMonth(TimeZoneKt.toLocalDateTime(timePeriod.getStart(), timeZone));
        final LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(timePeriod.getEnd(), timeZone);
        return SequencesKt___SequencesKt.toList(new TransformingSequence(new TakeWhileSequence(SequencesKt__SequencesKt.generateSequence(atStartOfMonth, new Function1<LocalDateTime, LocalDateTime>() { // from class: com.animaconnected.watch.fitness.TimePeriodKt$monthlyPeriods$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final LocalDateTime invoke(LocalDateTime localDateTime2) {
                Intrinsics.checkNotNullParameter(localDateTime2, "localDateTime");
                return DateTimeUtilsKt.plusMonth(localDateTime2, TimeZone.this);
            }
        }), new Function1<LocalDateTime, Boolean>() { // from class: com.animaconnected.watch.fitness.TimePeriodKt$monthlyPeriods$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(LocalDateTime it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LocalDateTime other = LocalDateTime.this;
                Intrinsics.checkNotNullParameter(other, "other");
                return Boolean.valueOf(it.value.compareTo((ChronoLocalDateTime<?>) other.value) < 0);
            }
        }), new Function1<LocalDateTime, TimePeriod>() { // from class: com.animaconnected.watch.fitness.TimePeriodKt$monthlyPeriods$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TimePeriod invoke(LocalDateTime startOfMonth) {
                Intrinsics.checkNotNullParameter(startOfMonth, "startOfMonth");
                LocalDateTime plusMonth = DateTimeUtilsKt.plusMonth(startOfMonth, TimeZone.this);
                LocalDateTime maximumValue = localDateTime;
                Intrinsics.checkNotNullParameter(plusMonth, "<this>");
                Intrinsics.checkNotNullParameter(maximumValue, "maximumValue");
                if (plusMonth.compareTo(maximumValue) > 0) {
                    plusMonth = maximumValue;
                }
                return new TimePeriod(startOfMonth, plusMonth, TimeZone.this);
            }
        }));
    }

    public static /* synthetic */ List monthlyPeriods$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return monthlyPeriods(timePeriod, timeZone);
    }

    public static final List<List<TimePeriod>> monthlyPeriodsByYear(TimePeriod timePeriod, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        List<TimePeriod> monthlyPeriods = monthlyPeriods(timePeriod, timeZone);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : monthlyPeriods) {
            Integer valueOf = Integer.valueOf(TimeZoneKt.toLocalDateTime(((TimePeriod) obj).getStart(), timeZone).getYear());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        return CollectionsKt___CollectionsKt.toList(linkedHashMap.values());
    }

    public static /* synthetic */ List monthlyPeriodsByYear$default(TimePeriod timePeriod, TimeZone timeZone, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        return monthlyPeriodsByYear(timePeriod, timeZone);
    }

    public static final TimePeriod shiftForPostCalculatedData(TimePeriod timePeriod) {
        Intrinsics.checkNotNullParameter(timePeriod, "<this>");
        Instant start = timePeriod.getStart();
        int r2 = Duration.$r8$clinit;
        DurationUnit durationUnit = DurationUnit.MINUTES;
        return new TimePeriod(start.m1706plusLRDsOJo(DurationKt.toDuration(1, durationUnit)), timePeriod.getEnd().m1706plusLRDsOJo(DurationKt.toDuration(1, durationUnit)));
    }
}
