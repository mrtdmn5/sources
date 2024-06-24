package com.animaconnected.watch;

import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: HealthSettingsViewModel.kt */
/* loaded from: classes3.dex */
public final class HealthSettingsViewModelKt {
    public static final String displayValue(Bedtime bedtime) {
        Intrinsics.checkNotNullParameter(bedtime, "<this>");
        LocalDateTime localDateTime = new LocalDateTime(1, 1, 1, bedtime.getHour(), bedtime.getMinute(), 0, 96, 0);
        TimeZone.Companion.getClass();
        return DateFormatter.format$default(StringsBackend.createDateFormatter$default(ServiceLocator.INSTANCE.getStringsBackend(), DateTimeFormattersKt.getHourMinuteFormat(), false, 2, null), TimeZoneKt.toInstant(localDateTime, TimeZone.Companion.currentSystemDefault()).toEpochMilliseconds(), null, false, 6, null);
    }
}
