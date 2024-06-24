package com.animaconnected.watch.behaviour.util;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VibratorPatterns.kt */
/* loaded from: classes3.dex */
public final class Vibration {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Vibration[] $VALUES;
    public static final Vibration One = new Vibration("One", 0);
    public static final Vibration Two = new Vibration("Two", 1);
    public static final Vibration Three = new Vibration("Three", 2);

    private static final /* synthetic */ Vibration[] $values() {
        return new Vibration[]{One, Two, Three};
    }

    static {
        Vibration[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Vibration(String str, int r2) {
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
}
