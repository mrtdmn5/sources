package com.animaconnected.watch.provider.preferences;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreferenceData.kt */
/* loaded from: classes3.dex */
public final class Pref {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Pref[] $VALUES;
    public static final Companion Companion;
    private final int id;
    private final boolean perWatch;
    public static final Pref LocationPermission = new Pref("LocationPermission", 0, 0, false);
    public static final Pref QuickActionFirstShown = new Pref("QuickActionFirstShown", 1, 1, true);
    public static final Pref ImperialUnits = new Pref("ImperialUnits", 2, 2, false);
    public static final Pref Brightness = new Pref("Brightness", 3, 3, true);
    public static final Pref NaturalScrolling = new Pref("NaturalScrolling", 4, 4, false);
    public static final Pref ColorTheme = new Pref("ColorTheme", 5, 5, true);
    public static final Pref AssignedQuickAction = new Pref("AssignedQuickAction", 6, 6, true);
    public static final Pref GpsPreferences = new Pref("GpsPreferences", 7, 7, false);
    public static final Pref MetricConfRun = new Pref("MetricConfRun", 8, 8, false);
    public static final Pref MetricConfWalk = new Pref("MetricConfWalk", 9, 9, false);
    public static final Pref MetricConfBike = new Pref("MetricConfBike", 10, 10, false);
    public static final Pref MetricConfOther = new Pref("MetricConfOther", 11, 11, false);
    public static final Pref SpeedCoefficient = new Pref("SpeedCoefficient", 12, 12, false);

    /* compiled from: PreferenceData.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pref fromId(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = Pref.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((Pref) obj).getId() == r4) {
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
            return (Pref) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ Pref[] $values() {
        return new Pref[]{LocationPermission, QuickActionFirstShown, ImperialUnits, Brightness, NaturalScrolling, ColorTheme, AssignedQuickAction, GpsPreferences, MetricConfRun, MetricConfWalk, MetricConfBike, MetricConfOther, SpeedCoefficient};
    }

    static {
        Pref[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private Pref(String str, int r2, int r3, boolean z) {
        this.id = r3;
        this.perWatch = z;
    }

    public static EnumEntries<Pref> getEntries() {
        return $ENTRIES;
    }

    public static Pref valueOf(String str) {
        return (Pref) Enum.valueOf(Pref.class, str);
    }

    public static Pref[] values() {
        return (Pref[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getPerWatch() {
        return this.perWatch;
    }
}
