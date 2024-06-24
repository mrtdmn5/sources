package com.animaconnected.watch.behaviour.util;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: VibratorPatterns.kt */
/* loaded from: classes3.dex */
public final class Strength {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Strength[] $VALUES;
    public static final Strength Normal = new Strength("Normal", 0);
    public static final Strength Stronger = new Strength("Stronger", 1);

    private static final /* synthetic */ Strength[] $values() {
        return new Strength[]{Normal, Stronger};
    }

    static {
        Strength[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Strength(String str, int r2) {
    }

    public static EnumEntries<Strength> getEntries() {
        return $ENTRIES;
    }

    public static Strength valueOf(String str) {
        return (Strength) Enum.valueOf(Strength.class, str);
    }

    public static Strength[] values() {
        return (Strength[]) $VALUES.clone();
    }
}
