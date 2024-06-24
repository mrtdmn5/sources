package com.animaconnected.watch.provider.preferences;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreferenceProvider.kt */
/* loaded from: classes3.dex */
public final class GPSPreferences {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GPSPreferences[] $VALUES;
    public static final Companion Companion;
    private final int id;
    public static final GPSPreferences Unknown = new GPSPreferences("Unknown", 0, 0);
    public static final GPSPreferences Yes = new GPSPreferences("Yes", 1, 1);
    public static final GPSPreferences No = new GPSPreferences("No", 2, 2);

    /* compiled from: PreferenceProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GPSPreferences fromId$watch_release(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = GPSPreferences.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((GPSPreferences) obj).getId$watch_release() == r4) {
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
            return (GPSPreferences) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ GPSPreferences[] $values() {
        return new GPSPreferences[]{Unknown, Yes, No};
    }

    static {
        GPSPreferences[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private GPSPreferences(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<GPSPreferences> getEntries() {
        return $ENTRIES;
    }

    public static GPSPreferences valueOf(String str) {
        return (GPSPreferences) Enum.valueOf(GPSPreferences.class, str);
    }

    public static GPSPreferences[] values() {
        return (GPSPreferences[]) $VALUES.clone();
    }

    public final int getId$watch_release() {
        return this.id;
    }
}
