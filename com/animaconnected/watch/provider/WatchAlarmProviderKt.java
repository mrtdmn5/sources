package com.animaconnected.watch.provider;

import com.animaconnected.watch.model.alarms.Alarms;
import com.animaconnected.watch.model.alarms.DaysOfWeek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAlarmProvider.kt */
/* loaded from: classes3.dex */
public final class WatchAlarmProviderKt {
    public static final DaysOfWeek toDaysOfWeek(Set<? extends AlarmDay> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        Set<? extends AlarmDay> set2 = set;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(set2, 10));
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((AlarmDay) it.next()).getIsoDayNumber()));
        }
        return new DaysOfWeek(CollectionsKt___CollectionsKt.toSet(arrayList));
    }

    public static final Alarms toDbAlarms(WatchAlarm watchAlarm) {
        Intrinsics.checkNotNullParameter(watchAlarm, "<this>");
        return new Alarms(watchAlarm.getId(), watchAlarm.getHour(), watchAlarm.getMinute(), toDaysOfWeek(watchAlarm.getDaysEnabled()), watchAlarm.getEnabled(), watchAlarm.getDeleteAfterUse(), watchAlarm.getLastModified());
    }

    public static final WatchAlarm toWatchAlarm(Alarms alarms) {
        Intrinsics.checkNotNullParameter(alarms, "<this>");
        Set<Integer> days = alarms.getDaysofweek().getDays();
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(days, 10));
        Iterator<T> it = days.iterator();
        while (it.hasNext()) {
            arrayList.add(AlarmDay.Companion.fromInt(((Number) it.next()).intValue()));
        }
        return new WatchAlarm(alarms.get_id(), alarms.getHour(), alarms.getMinutes(), CollectionsKt___CollectionsKt.toSet(arrayList), alarms.getEnabled(), alarms.getDelete_after_use(), alarms.getLast_modified());
    }
}
