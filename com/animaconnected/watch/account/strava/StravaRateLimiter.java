package com.animaconnected.watch.account.strava;

import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.logger.LogKt;
import com.animaconnected.watch.device.BasicStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.FixedOffsetTimeZone;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: StravaRateLimiter.kt */
/* loaded from: classes3.dex */
public final class StravaRateLimiter {
    public static final Companion Companion = new Companion(null);
    public static final String is15MinuteLimitActiveKey = "is15MinuteLimitActive";
    public static final String isDailyLimitActiveKey = "isDailyLimitActive";
    public static final String lastResponseTimeKey = "lastResponseTime";
    private final BasicStorage storage;

    /* compiled from: StravaRateLimiter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public StravaRateLimiter(BasicStorage storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        this.storage = storage;
    }

    private final Instant getLastResponseTime() {
        Long l = this.storage.getLong(lastResponseTimeKey);
        if (l != null) {
            Instant fromEpochSeconds$default = Instant.Companion.fromEpochSeconds$default(Instant.Companion, l.longValue());
            if (fromEpochSeconds$default != null) {
                return fromEpochSeconds$default;
            }
        }
        Instant.Companion.getClass();
        return Instant.DISTANT_PAST;
    }

    private final boolean isNextDay(Instant instant) {
        TimeZone.Companion.getClass();
        FixedOffsetTimeZone fixedOffsetTimeZone = TimeZone.UTC;
        if (TimeZoneKt.toLocalDateTime(instant, fixedOffsetTimeZone).value.getDayOfYear() > TimeZoneKt.toLocalDateTime(getLastResponseTime(), fixedOffsetTimeZone).value.getDayOfYear()) {
            return true;
        }
        return false;
    }

    private final boolean isNextQuarterHour(Instant instant) {
        if (instant.compareTo(findNextResetTime()) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void onRequest$default(StravaRateLimiter stravaRateLimiter, Instant instant, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            instant = DateTimeUtilsKt.now();
        }
        stravaRateLimiter.onRequest(instant);
    }

    private final void set15MinuteLimitActive(boolean z) {
        this.storage.put(is15MinuteLimitActiveKey, z);
    }

    private final void setDailyLimitActive(boolean z) {
        this.storage.put(isDailyLimitActiveKey, z);
    }

    private final void setLastResponseTime(Instant instant) {
        this.storage.put(lastResponseTimeKey, instant.getEpochSeconds());
    }

    public final Instant findNextResetTime() {
        Instant lastResponseTime = getLastResponseTime();
        TimeZone.Companion companion = TimeZone.Companion;
        companion.getClass();
        FixedOffsetTimeZone fixedOffsetTimeZone = TimeZone.UTC;
        LocalDateTime localDateTime = TimeZoneKt.toLocalDateTime(lastResponseTime, fixedOffsetTimeZone);
        int r4 = 1;
        int minute = (((localDateTime.getMinute() / 15) + 1) * 15) % 60;
        if (minute != 0) {
            r4 = 0;
        }
        int r0 = r4;
        LocalDateTime copy$default = DateTimeUtilsKt.copy$default(localDateTime, 0, null, 0, 0, minute, 0, 0, 15, null);
        DateTimeUnit.Companion.getClass();
        DateTimeUnit.TimeBased timeBased = DateTimeUnit.HOUR;
        companion.getClass();
        LocalDateTime plus = DateTimeUtilsKt.plus(copy$default, r0, timeBased, fixedOffsetTimeZone);
        companion.getClass();
        return TimeZoneKt.toInstant(plus, fixedOffsetTimeZone);
    }

    public final void handleHeaders(String limitHeader, String usageHeader, Instant responseTime) {
        boolean z;
        Intrinsics.checkNotNullParameter(limitHeader, "limitHeader");
        Intrinsics.checkNotNullParameter(usageHeader, "usageHeader");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        try {
            boolean z2 = false;
            List split$default = StringsKt__StringsKt.split$default(limitHeader, new String[]{","}, 0, 6);
            ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(split$default, 10));
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
            }
            final int intValue = ((Number) arrayList.get(0)).intValue();
            final int intValue2 = ((Number) arrayList.get(1)).intValue();
            List split$default2 = StringsKt__StringsKt.split$default(usageHeader, new String[]{","}, 0, 6);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(split$default2, 10));
            Iterator it2 = split$default2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
            }
            final int intValue3 = ((Number) arrayList2.get(0)).intValue();
            final int intValue4 = ((Number) arrayList2.get(1)).intValue();
            LogKt.debug$default((Object) this, StravaClient.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.StravaRateLimiter$handleHeaders$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "15 minute - Limit: " + intValue + ", Usage: " + intValue3 + "\nDaily - Limit: " + intValue2 + ", Usage: " + intValue4;
                }
            }, 6, (Object) null);
            if (intValue4 >= intValue2) {
                z = true;
            } else {
                z = false;
            }
            setDailyLimitActive(z);
            if (intValue3 >= intValue) {
                z2 = true;
            }
            set15MinuteLimitActive(z2);
            setLastResponseTime(responseTime);
        } catch (Exception e) {
            LogKt.warn$default((Object) this, StravaClient.tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.watch.account.strava.StravaRateLimiter$handleHeaders$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error handling rate limit headers: "));
                }
            }, 6, (Object) null);
        }
    }

    public final boolean is15MinuteLimitActive() {
        Boolean bool = this.storage.getBoolean(is15MinuteLimitActiveKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean isDailyLimitActive() {
        Boolean bool = this.storage.getBoolean(isDailyLimitActiveKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void onRequest(Instant now) {
        Intrinsics.checkNotNullParameter(now, "now");
        if (!is15MinuteLimitActive() && !isDailyLimitActive()) {
            return;
        }
        if (isNextDay(now)) {
            setDailyLimitActive(false);
            set15MinuteLimitActive(false);
        } else {
            if (isNextQuarterHour(now) && !isDailyLimitActive()) {
                set15MinuteLimitActive(false);
                return;
            }
            throw new RateLimitExceededException("Rate Limit Exceeded.");
        }
    }
}
