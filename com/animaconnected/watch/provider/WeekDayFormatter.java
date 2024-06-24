package com.animaconnected.watch.provider;

import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: DateTimeFormatters.kt */
/* loaded from: classes3.dex */
public final class WeekDayFormatter {
    private final StringsBackend backend;
    private String[] longWeekdays;
    private String[] mediumWeekdays;
    private String[] shortWeekdays;

    public WeekDayFormatter() {
        StringsBackend stringsBackend = ServiceLocator.INSTANCE.getStringsBackend();
        this.backend = stringsBackend;
        DateFormatter createDateFormatter$default = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.shortDayNameInWeekFormat, false, 2, null);
        DateFormatter createDateFormatter$default2 = StringsBackend.createDateFormatter$default(stringsBackend, DateTimeFormattersKt.mediumDayNameInWeekFormat, false, 2, null);
        DateFormatter createDateFormatter$default3 = StringsBackend.createDateFormatter$default(stringsBackend, "EEEE", false, 2, null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int r13 = 1; r13 < 8; r13++) {
            LocalDateTime localDateTime = new LocalDateTime(2022, 8, r13, 7, 0, 0, 96, 0);
            TimeZone.Companion.getClass();
            long epochMilliseconds = TimeZoneKt.toInstant(localDateTime, TimeZone.UTC).toEpochMilliseconds();
            arrayList.add(DateFormatter.format$default(createDateFormatter$default, epochMilliseconds, null, false, 6, null));
            arrayList2.add(DateFormatter.format$default(createDateFormatter$default2, epochMilliseconds, null, false, 6, null));
            arrayList3.add(DateFormatter.format$default(createDateFormatter$default3, epochMilliseconds, null, false, 6, null));
        }
        this.shortWeekdays = (String[]) arrayList.toArray(new String[0]);
        this.mediumWeekdays = (String[]) arrayList2.toArray(new String[0]);
        this.longWeekdays = (String[]) arrayList3.toArray(new String[0]);
    }

    public final String getLongWeekday(AlarmDay dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        return this.longWeekdays[dayOfWeek.ordinal()];
    }

    public final String getMediumWeekday(AlarmDay dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        return this.mediumWeekdays[dayOfWeek.ordinal()];
    }

    public final String getShortWeekday(AlarmDay dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        return this.shortWeekdays[dayOfWeek.ordinal()];
    }
}
