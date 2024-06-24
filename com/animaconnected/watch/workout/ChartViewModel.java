package com.animaconnected.watch.workout;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: ChartViewModel.kt */
/* loaded from: classes3.dex */
public class ChartViewModel {
    private final DateFormatter dateMarkerFormatter;
    private final DateFormatter dayMarkerFormatter;
    private final DateFormatter monthMarkerFormatter;
    private final StringsBackend stringsBackend;
    private final DateFormatter weekMarkerFormatter;
    private final DateFormatter yearMarkerFormatter;

    /* compiled from: ChartViewModel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[HistoryPeriodTab.values().length];
            try {
                r0[HistoryPeriodTab.Week.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[HistoryPeriodTab.Month.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[HistoryPeriodTab.Year.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public ChartViewModel() {
        StringsBackend stringsBackend = ServiceLocator.INSTANCE.getStringsBackend();
        this.stringsBackend = stringsBackend;
        this.dayMarkerFormatter = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null);
        this.weekMarkerFormatter = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.mediumDayNameInWeekFormat, false, 2, null);
        this.dateMarkerFormatter = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.dayInMonthFormat, false, 2, null);
        this.monthMarkerFormatter = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.shortMonthAndDateFormat, false, 2, null);
        this.yearMarkerFormatter = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.briefMonthAndYearFormat, false, 2, null);
    }

    public final DateFormatter getDateMarkerFormatter$watch_release() {
        return this.dateMarkerFormatter;
    }

    public final DateFormatter getDayMarkerFormatter$watch_release() {
        return this.dayMarkerFormatter;
    }

    public final DateFormatter getMonthMarkerFormatter$watch_release() {
        return this.monthMarkerFormatter;
    }

    public final StringsBackend getStringsBackend$watch_release() {
        return this.stringsBackend;
    }

    public final DateFormatter getWeekMarkerFormatter$watch_release() {
        return this.weekMarkerFormatter;
    }

    public final DateFormatter getYearMarkerFormatter$watch_release() {
        return this.yearMarkerFormatter;
    }

    public Function1<Long, String> markerHistoryFormatter(HistoryPeriodTab historyPeriod) {
        Intrinsics.checkNotNullParameter(historyPeriod, "historyPeriod");
        int r2 = WhenMappings.$EnumSwitchMapping$0[historyPeriod.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 == 3) {
                    return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.ChartViewModel$markerHistoryFormatter$3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ String invoke(Long l) {
                            return invoke(l.longValue());
                        }

                        public final String invoke(long j) {
                            return DateFormatter.format$default(ChartViewModel.this.getYearMarkerFormatter$watch_release(), j, null, false, 6, null);
                        }
                    };
                }
                throw new NoWhenBranchMatchedException();
            }
            return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.ChartViewModel$markerHistoryFormatter$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ String invoke(Long l) {
                    return invoke(l.longValue());
                }

                public final String invoke(long j) {
                    return DateFormatter.format$default(ChartViewModel.this.getMonthMarkerFormatter$watch_release(), j, null, false, 6, null);
                }
            };
        }
        return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.ChartViewModel$markerHistoryFormatter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Long l) {
                return invoke(l.longValue());
            }

            public final String invoke(long j) {
                return DateFormatter.format$default(ChartViewModel.this.getWeekMarkerFormatter$watch_release(), j, null, false, 6, null);
            }
        };
    }

    public final Function1<Long, String> markerLastWeekFormatter() {
        return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.ChartViewModel$markerLastWeekFormatter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Long l) {
                return invoke(l.longValue());
            }

            public final String invoke(long j) {
                return DateFormatter.format$default(ChartViewModel.this.getWeekMarkerFormatter$watch_release(), j, null, false, 6, null);
            }
        };
    }

    public final Function1<Long, String> markerTodayFormatter() {
        return new Function1<Long, String>() { // from class: com.animaconnected.watch.workout.ChartViewModel$markerTodayFormatter$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Long l) {
                return invoke(l.longValue());
            }

            public final String invoke(long j) {
                StringBuilder sb = new StringBuilder();
                sb.append(DateFormatter.format$default(ChartViewModel.this.getDayMarkerFormatter$watch_release(), j, null, false, 6, null));
                sb.append(" - ");
                DateFormatter dayMarkerFormatter$watch_release = ChartViewModel.this.getDayMarkerFormatter$watch_release();
                int r1 = Duration.$r8$clinit;
                sb.append(DateFormatter.format$default(dayMarkerFormatter$watch_release, Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(30, DurationUnit.MINUTES)) + j, null, false, 6, null));
                return sb.toString();
            }
        };
    }
}
