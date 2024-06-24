package com.animaconnected.watch.device;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;

/* compiled from: StringsBackend.kt */
/* loaded from: classes3.dex */
public final class StringsBackendKt {
    public static final String format(DateFormatter dateFormatter, Instant instant, TimeZone timeZone, boolean z) {
        Intrinsics.checkNotNullParameter(dateFormatter, "<this>");
        Intrinsics.checkNotNullParameter(instant, "instant");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return dateFormatter.format(instant.toEpochMilliseconds(), timeZone, z);
    }

    public static /* synthetic */ String format$default(DateFormatter dateFormatter, Instant instant, TimeZone timeZone, boolean z, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            TimeZone.Companion.getClass();
            timeZone = TimeZone.Companion.currentSystemDefault();
        }
        if ((r4 & 4) != 0) {
            z = false;
        }
        return format(dateFormatter, instant, timeZone, z);
    }
}
