package com.animaconnected.watch.display.view;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Orientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Orientation[] $VALUES;
    public static final Orientation Vertical = new Orientation("Vertical", 0);
    public static final Orientation Horizontal = new Orientation("Horizontal", 1);

    private static final /* synthetic */ Orientation[] $values() {
        return new Orientation[]{Vertical, Horizontal};
    }

    static {
        Orientation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Orientation(String str, int r2) {
    }

    public static EnumEntries<Orientation> getEntries() {
        return $ENTRIES;
    }

    public static Orientation valueOf(String str) {
        return (Orientation) Enum.valueOf(Orientation.class, str);
    }

    public static Orientation[] values() {
        return (Orientation[]) $VALUES.clone();
    }
}
