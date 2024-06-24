package com.animaconnected.secondo.provider.googlefit;

import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.watch.fitness.Entry;
import com.animaconnected.watch.fitness.TimePeriod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.datetime.DateTimePeriodKt;
import kotlinx.datetime.FixedOffsetTimeZone;
import kotlinx.datetime.Instant;
import kotlinx.datetime.InstantJvmKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: GoogleFitApi.kt */
/* loaded from: classes3.dex */
public final class GoogleFitApiKt {
    private static final <T extends Entry> Map<TimePeriod, List<T>> groupEntriesByInterval(List<? extends T> list) {
        int r10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Instant.Companion companion = Instant.Companion;
            long timestamp = ((Entry) next).getTimestamp();
            companion.getClass();
            Instant fromEpochMilliseconds = Instant.Companion.fromEpochMilliseconds(timestamp);
            TimeZone.Companion.getClass();
            FixedOffsetTimeZone fixedOffsetTimeZone = TimeZone.UTC;
            LocalDateTime localDateTime = DateTimeUtilsKt.getLocalDateTime(fromEpochMilliseconds, fixedOffsetTimeZone);
            if (localDateTime.getMinute() < 30) {
                r10 = 0;
            } else {
                r10 = 30;
            }
            Iterator it2 = it;
            Instant instant = TimeZoneKt.toInstant(DateTimeUtilsKt.copy$default(localDateTime, 0, null, 0, 0, r10, 0, 0, 79, null), fixedOffsetTimeZone);
            TimePeriod timePeriod = new TimePeriod(instant, InstantJvmKt.plus(instant, DateTimePeriodKt.DateTimePeriod$default(0, 0, 30, 111), fixedOffsetTimeZone));
            Object obj = linkedHashMap.get(timePeriod);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(timePeriod, obj);
            }
            ((List) obj).add(next);
            it = it2;
        }
        return linkedHashMap;
    }
}
