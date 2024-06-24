package com.animaconnected.watch.account.strava;

import com.animaconnected.watch.fitness.Session;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: StravaActivity.kt */
/* loaded from: classes3.dex */
public final class StravaActivityKt {
    public static final StravaActivity toStravaActivity(Session session) {
        Intrinsics.checkNotNullParameter(session, "<this>");
        String stravaType = StravaClientKt.toStravaType(session.getType());
        Instant.Companion companion = Instant.Companion;
        long startTs = session.getStartTs();
        companion.getClass();
        Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(startTs);
        TimeZone.Companion.getClass();
        return new StravaActivity(stravaType, stravaType, TimeZoneKt.toLocalDateTime(fromEpochMilliseconds, TimeZone.Companion.currentSystemDefault()).toString(), (int) (((float) session.getTotalTimeMs()) / 1000.0f), (String) null, (String) null, (float) session.getTotalDistanceMeter(), 0, 0, 432, (DefaultConstructorMarker) null);
    }
}
