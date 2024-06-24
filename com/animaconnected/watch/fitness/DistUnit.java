package com.animaconnected.watch.fitness;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LocationUtils.kt */
/* loaded from: classes3.dex */
final class DistUnit {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DistUnit[] $VALUES;
    public static final DistUnit Miles = new DistUnit("Miles", 0);
    public static final DistUnit Kilometers = new DistUnit("Kilometers", 1);
    public static final DistUnit NauticalMiles = new DistUnit("NauticalMiles", 2);

    private static final /* synthetic */ DistUnit[] $values() {
        return new DistUnit[]{Miles, Kilometers, NauticalMiles};
    }

    static {
        DistUnit[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DistUnit(String str, int r2) {
    }

    public static EnumEntries<DistUnit> getEntries() {
        return $ENTRIES;
    }

    public static DistUnit valueOf(String str) {
        return (DistUnit) Enum.valueOf(DistUnit.class, str);
    }

    public static DistUnit[] values() {
        return (DistUnit[]) $VALUES.clone();
    }
}
