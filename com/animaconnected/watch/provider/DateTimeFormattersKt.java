package com.animaconnected.watch.provider;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DateTimeFormatters.kt */
/* loaded from: classes3.dex */
public final class DateTimeFormattersKt {
    public static final String briefMonthAndYearFormat = "MMM, y";
    public static final String dayInMonthFormat = "d";
    public static final String iso8601Format = "yyyyMMdd'T'HHmmss'Z'";
    public static final String isoOffsetDateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String longDayNameInWeekFormat = "EEEE";
    public static final String longMonthInYearFormat = "MMMM";
    public static final String longYearFormat = "yyyy";
    public static final String mediumDayNameInWeekFormat = "EEE";
    public static final String monthInYearFormat = "M";
    public static final String shortDayNameInWeekFormat = "EEEEE";
    public static final String shortMonthAndDateFormat = "MMM d";
    public static final String yearNoPaddingFormat = "y";

    public static final DateFormatter getBriefMonthAndYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, briefMonthAndYearFormat, false, 2, null);
    }

    public static final DateFormatter getDayInMonthFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, dayInMonthFormat, false, 2, null);
    }

    public static final String getHourMinuteFormat() {
        if (ServiceLocator.INSTANCE.getStringsBackend().is24HourFormat()) {
            return "HH:mm";
        }
        return "h:mm a";
    }

    public static final DateFormatter getHourMinuteFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, getHourMinuteFormat(), false, 2, null);
    }

    public static final DateFormatter getIso8601Formatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, "yyyyMMdd'T'HHmmss'Z'", false, 2, null);
    }

    public static final DateFormatter getIsoOffsetDateTime(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, isoOffsetDateTimeFormat, false, 2, null);
    }

    public static final DateFormatter getLongDayNameInWeekFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, longDayNameInWeekFormat, false, 2, null);
    }

    public static final DateFormatter getLongMonthInYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, longMonthInYearFormat, false, 2, null);
    }

    public static final DateFormatter getLongYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, longYearFormat, false, 2, null);
    }

    public static final DateFormatter getMediumDayNameInWeekFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, mediumDayNameInWeekFormat, false, 2, null);
    }

    public static final DateFormatter getMonthInYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, monthInYearFormat, false, 2, null);
    }

    public static final DateFormatter getShortDayNameInWeekFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, shortDayNameInWeekFormat, false, 2, null);
    }

    public static final DateFormatter getShortMonthAndDateFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, shortMonthAndDateFormat, false, 2, null);
    }

    public static final DateFormatter getShortMonthInYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, "MMM", false, 2, null);
    }

    public static final DateFormatter getYearFormatter(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "<this>");
        return StringsBackend.createDateFormatter$default(stringsBackend, yearNoPaddingFormat, false, 2, null);
    }
}
