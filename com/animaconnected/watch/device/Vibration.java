package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchNotification.kt */
/* loaded from: classes3.dex */
public final class Vibration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Vibration[] $VALUES;
    private final int id;
    public static final Vibration NONE = new Vibration("NONE", 0, 0);
    public static final Vibration ONE = new Vibration("ONE", 1, 1);
    public static final Vibration TWO = new Vibration("TWO", 2, 2);
    public static final Vibration THREE = new Vibration("THREE", 3, 3);

    private static final /* synthetic */ Vibration[] $values() {
        return new Vibration[]{NONE, ONE, TWO, THREE};
    }

    static {
        Vibration[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Vibration(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<Vibration> getEntries() {
        return $ENTRIES;
    }

    public static Vibration valueOf(String str) {
        return (Vibration) Enum.valueOf(Vibration.class, str);
    }

    public static Vibration[] values() {
        return (Vibration[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
