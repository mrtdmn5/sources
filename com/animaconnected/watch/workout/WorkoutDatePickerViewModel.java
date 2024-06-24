package com.animaconnected.watch.workout;

import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DateTimeUtilsKt$$ExternalSyntheticOutline0;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Days;
import com.animaconnected.watch.fitness.Months;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.fitness.TimePeriodKt;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: WorkoutDatePickerViewModel.kt */
/* loaded from: classes3.dex */
public final class WorkoutDatePickerViewModel {
    private Instant date;
    private final Function1<Instant, Boolean> hasDataBefore;
    private final MutableStateFlow<HistoryState> historyState;
    private TimePeriod timePeriod;

    /* compiled from: WorkoutDatePickerViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Action.values().length];
            try {
                r0[Action.NextDate.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Action.PreviousDate.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkoutDatePickerViewModel(Function1<? super Instant, Boolean> hasDataBefore) {
        Intrinsics.checkNotNullParameter(hasDataBefore, "hasDataBefore");
        this.hasDataBefore = hasDataBefore;
        Instant.Companion.getClass();
        this.date = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        this.timePeriod = TimePeriod.Companion.day$default(TimePeriod.Companion, getDate(), null, 2, null);
        this.historyState = StateFlowKt.MutableStateFlow(new HistoryState(null, null, null, null, null, null, null, false, false, 511, null));
    }

    private final Instant getDate() {
        Instant instant = this.date;
        Instant relevantInstant$default = DateTimeUtilsKt.relevantInstant$default(0L, 1, null);
        Instant.Companion.getClass();
        Instant instant2 = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        Intrinsics.checkNotNullParameter(instant, "<this>");
        if (relevantInstant$default != null) {
            if (relevantInstant$default.compareTo(instant2) <= 0) {
                if (instant.compareTo(relevantInstant$default) >= 0) {
                    if (instant.compareTo(instant2) <= 0) {
                        return instant;
                    }
                    return instant2;
                }
                return relevantInstant$default;
            }
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + instant2 + " is less than minimum " + relevantInstant$default + '.');
        }
        if (relevantInstant$default == null || instant.compareTo(relevantInstant$default) >= 0) {
            if (instant.compareTo(instant2) <= 0) {
                return instant;
            }
            return instant2;
        }
        return relevantInstant$default;
    }

    private final StringsBackend getStringsBackend() {
        return ServiceLocator.INSTANCE.getStringsBackend();
    }

    private final boolean isLastWeek() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        Instant.Companion.getClass();
        Instant instant = new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"));
        int r2 = Duration.$r8$clinit;
        return TimePeriod.Companion.week$default(companion, instant.m1705minusLRDsOJo(DurationKt.toDuration(7, DurationUnit.DAYS)), null, 2, null).contains(getDate());
    }

    private final boolean isNextDateClickable() {
        Instant end = this.timePeriod.getEnd();
        Instant.Companion.getClass();
        if (end.compareTo(new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()"))) < 0) {
            return true;
        }
        return false;
    }

    private final boolean isPrevDateClickable() {
        return this.hasDataBefore.invoke(this.timePeriod.getStart()).booleanValue();
    }

    private final boolean isThisWeek() {
        TimePeriod week$default = TimePeriod.Companion.week$default(TimePeriod.Companion, null, null, 3, null);
        Instant start = week$default.getStart();
        Instant that = week$default.getEnd();
        Intrinsics.checkNotNullParameter(start, "<this>");
        Intrinsics.checkNotNullParameter(that, "that");
        Instant value = getDate();
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.compareTo(start) >= 0 && value.compareTo(that) <= 0) {
            return true;
        }
        return false;
    }

    public final void changeMonth(Action action) {
        Instant plusMonth$default;
        Intrinsics.checkNotNullParameter(action, "action");
        int r4 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r4 != 1) {
            if (r4 == 2) {
                plusMonth$default = DateTimeUtilsKt.minusMonth$default(getDate(), null, 1, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            plusMonth$default = DateTimeUtilsKt.plusMonth$default(getDate(), (TimeZone) null, 1, (Object) null);
        }
        this.date = plusMonth$default;
        onMonthClick();
    }

    public final void changeWeek(Action action) {
        Instant plusWeek$default;
        Intrinsics.checkNotNullParameter(action, "action");
        int r4 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r4 != 1) {
            if (r4 == 2) {
                plusWeek$default = DateTimeUtilsKt.minusWeek$default(getDate(), null, 1, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            plusWeek$default = DateTimeUtilsKt.plusWeek$default(getDate(), (TimeZone) null, 1, (Object) null);
        }
        this.date = plusWeek$default;
        onWeekClick();
    }

    public final void changeYear(Action action) {
        Instant plusYear$default;
        Intrinsics.checkNotNullParameter(action, "action");
        int r4 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r4 != 1) {
            if (r4 == 2) {
                plusYear$default = DateTimeUtilsKt.minusYear$default(getDate(), null, 1, null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            plusYear$default = DateTimeUtilsKt.plusYear$default(getDate(), (TimeZone) null, 1, (Object) null);
        }
        this.date = plusYear$default;
        onYearClick();
    }

    public final Function1<Instant, Boolean> getHasDataBefore() {
        return this.hasDataBefore;
    }

    public final MutableStateFlow<HistoryState> getHistoryState() {
        return this.historyState;
    }

    public final void onMonthClick() {
        String format$default;
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimePeriod month$default = TimePeriod.Companion.month$default(companion, getDate(), null, 2, null);
        this.timePeriod = month$default;
        MutableStateFlow<HistoryState> mutableStateFlow = this.historyState;
        HistoryPeriodTab historyPeriodTab = HistoryPeriodTab.Month;
        TimePeriod day$default = TimePeriod.Companion.day$default(companion, null, null, 3, null);
        Days days = Days.INSTANCE;
        DateFormatter dayInMonthFormatter = DateTimeFormattersKt.getDayInMonthFormatter(getStringsBackend());
        Instant start = this.timePeriod.getStart();
        Instant.Companion.getClass();
        if (DateTimeUtilsKt.sameYear$default(start, new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")), null, 2, null)) {
            format$default = "";
        } else {
            format$default = DateFormatter.format$default(DateTimeFormattersKt.getYearFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null);
        }
        mutableStateFlow.setValue(new HistoryState(historyPeriodTab, month$default, day$default, days, dayInMonthFormatter, format$default, DateFormatter.format$default(DateTimeFormattersKt.getLongMonthInYearFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null), isNextDateClickable(), isPrevDateClickable()));
    }

    public final void onWeekClick() {
        String str;
        TimePeriod.Companion companion = TimePeriod.Companion;
        this.timePeriod = TimePeriod.Companion.week$default(companion, getDate(), null, 2, null);
        String format$default = DateFormatter.format$default(DateTimeFormattersKt.getYearFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null);
        String format$default2 = DateFormatter.format$default(DateTimeFormattersKt.getYearFormatter(getStringsBackend()), this.timePeriod.getEndTs(), null, false, 6, null);
        Instant start = this.timePeriod.getStart();
        Instant.Companion.getClass();
        if (DateTimeUtilsKt.sameYear$default(start, new Instant(DateTimeUtilsKt$$ExternalSyntheticOutline0.m("systemUTC().instant()")), null, 2, null)) {
            format$default = "";
        } else if (!Intrinsics.areEqual(format$default, format$default2)) {
            format$default = AbstractResolvableFuture$$ExternalSyntheticOutline0.m(format$default, " - ", format$default2);
        }
        String str2 = format$default;
        if (isThisWeek()) {
            str = StringsExtensionsKt.getAppString(Key.health_detail_history_this_week_title);
        } else if (isLastWeek()) {
            str = StringsExtensionsKt.getAppString(Key.health_detail_history_last_week_title);
        } else {
            TimePeriod timePeriod = this.timePeriod;
            boolean sameMonth$default = DateTimeUtilsKt.sameMonth$default(timePeriod.getStart(), timePeriod.getEnd(), null, 2, null);
            String format$default3 = DateFormatter.format$default(DateTimeFormattersKt.getDayInMonthFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null);
            String format$default4 = DateFormatter.format$default(DateTimeFormattersKt.getDayInMonthFormatter(getStringsBackend()), TimePeriodKt.excludeEnd(this.timePeriod).getEndTs(), null, false, 6, null);
            String format$default5 = DateFormatter.format$default(DateTimeFormattersKt.getShortMonthInYearFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null);
            String format$default6 = DateFormatter.format$default(DateTimeFormattersKt.getShortMonthInYearFormatter(getStringsBackend()), this.timePeriod.getEndTs(), null, false, 6, null);
            if (sameMonth$default) {
                str = format$default3 + " - " + format$default4 + ' ' + format$default5;
            } else {
                str = format$default3 + ' ' + format$default5 + " - " + format$default4 + ' ' + format$default6;
            }
        }
        this.historyState.setValue(new HistoryState(HistoryPeriodTab.Week, this.timePeriod, TimePeriod.Companion.day$default(companion, null, null, 3, null), Days.INSTANCE, DateTimeFormattersKt.getShortDayNameInWeekFormatter(getStringsBackend()), str2, str, isNextDateClickable(), isPrevDateClickable()));
    }

    public final void onYearClick() {
        TimePeriod.Companion companion = TimePeriod.Companion;
        TimePeriod year$default = TimePeriod.Companion.year$default(companion, getDate(), null, 2, null);
        this.timePeriod = year$default;
        this.historyState.setValue(new HistoryState(HistoryPeriodTab.Year, year$default, TimePeriod.Companion.month$default(companion, null, null, 3, null), Months.INSTANCE, DateTimeFormattersKt.getMonthInYearFormatter(getStringsBackend()), null, DateFormatter.format$default(DateTimeFormattersKt.getLongYearFormatter(getStringsBackend()), this.timePeriod.getStartTs(), null, false, 6, null), isNextDateClickable(), isPrevDateClickable(), 32, null));
    }
}
