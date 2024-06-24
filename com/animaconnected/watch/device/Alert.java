package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Alert.kt */
/* loaded from: classes3.dex */
public final class Alert {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Alert[] $VALUES;
    private final int id;
    public static final Alert Pattern1 = new Alert("Pattern1", 0, 1);
    public static final Alert Pattern2 = new Alert("Pattern2", 1, 2);
    public static final Alert Pattern3 = new Alert("Pattern3", 2, 3);
    public static final Alert Pattern4 = new Alert("Pattern4", 3, 4);
    public static final Alert Pattern5 = new Alert("Pattern5", 4, 5);
    public static final Alert Pattern6 = new Alert("Pattern6", 5, 6);
    public static final Alert Confirm = new Alert("Confirm", 6, 7);
    public static final Alert Failed = new Alert("Failed", 7, 8);

    private static final /* synthetic */ Alert[] $values() {
        return new Alert[]{Pattern1, Pattern2, Pattern3, Pattern4, Pattern5, Pattern6, Confirm, Failed};
    }

    static {
        Alert[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Alert(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<Alert> getEntries() {
        return $ENTRIES;
    }

    public static Alert valueOf(String str) {
        return (Alert) Enum.valueOf(Alert.class, str);
    }

    public static Alert[] values() {
        return (Alert[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
