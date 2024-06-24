package com.animaconnected.watch.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WatchAlarmProvider.kt */
/* loaded from: classes3.dex */
public final class AlarmDay extends Enum<AlarmDay> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AlarmDay[] $VALUES;
    public static final Companion Companion;
    public static final AlarmDay Friday;
    public static final AlarmDay Monday;
    public static final AlarmDay Saturday;
    public static final AlarmDay Sunday;
    public static final AlarmDay Thursday;
    public static final AlarmDay Tuesday;
    public static final AlarmDay Wednesday;
    private static final List<AlarmDay> all;
    private static final List<AlarmDay> weekdays;
    private static final List<AlarmDay> weekend;
    private final int isoDayNumber;

    /* compiled from: WatchAlarmProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<AlarmDay> fromBitmask(int r5) {
            boolean z;
            List<AlarmDay> all = getAll();
            ArrayList arrayList = new ArrayList();
            for (Object obj : all) {
                if ((((AlarmDay) obj).bitmask() & r5) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            return CollectionsKt___CollectionsKt.toSet(arrayList);
        }

        public final AlarmDay fromInt(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = AlarmDay.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((AlarmDay) obj).getIsoDayNumber() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            AlarmDay alarmDay = (AlarmDay) obj;
            if (alarmDay != null) {
                return alarmDay;
            }
            throw new IllegalArgumentException();
        }

        public final List<AlarmDay> getAll() {
            return AlarmDay.all;
        }

        public final List<AlarmDay> getWeekdays() {
            return AlarmDay.weekdays;
        }

        public final List<AlarmDay> getWeekend() {
            return AlarmDay.weekend;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AlarmDay[] $values() {
        return new AlarmDay[]{Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday};
    }

    static {
        AlarmDay alarmDay = new AlarmDay("Monday", 0, 1);
        Monday = alarmDay;
        AlarmDay alarmDay2 = new AlarmDay("Tuesday", 1, 2);
        Tuesday = alarmDay2;
        AlarmDay alarmDay3 = new AlarmDay("Wednesday", 2, 3);
        Wednesday = alarmDay3;
        AlarmDay alarmDay4 = new AlarmDay("Thursday", 3, 4);
        Thursday = alarmDay4;
        AlarmDay alarmDay5 = new AlarmDay("Friday", 4, 5);
        Friday = alarmDay5;
        AlarmDay alarmDay6 = new AlarmDay("Saturday", 5, 6);
        Saturday = alarmDay6;
        AlarmDay alarmDay7 = new AlarmDay("Sunday", 6, 7);
        Sunday = alarmDay7;
        AlarmDay[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        List<AlarmDay> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AlarmDay[]{alarmDay, alarmDay2, alarmDay3, alarmDay4, alarmDay5});
        weekdays = listOf;
        List<AlarmDay> listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new AlarmDay[]{alarmDay6, alarmDay7});
        weekend = listOf2;
        all = CollectionsKt___CollectionsKt.plus((Iterable) listOf2, (Collection) listOf);
    }

    private AlarmDay(String str, int r2, int r3) {
        super(str, r2);
        this.isoDayNumber = r3;
    }

    public static EnumEntries<AlarmDay> getEntries() {
        return $ENTRIES;
    }

    public static AlarmDay valueOf(String str) {
        return (AlarmDay) Enum.valueOf(AlarmDay.class, str);
    }

    public static AlarmDay[] values() {
        return (AlarmDay[]) $VALUES.clone();
    }

    public final int bitmask() {
        return 1 << this.isoDayNumber;
    }

    public final int getIsoDayNumber() {
        return this.isoDayNumber;
    }
}
