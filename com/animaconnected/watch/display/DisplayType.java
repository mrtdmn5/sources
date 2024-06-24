package com.animaconnected.watch.display;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RemoteAppViews.kt */
/* loaded from: classes3.dex */
public final class DisplayType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DisplayType[] $VALUES;
    public static final DisplayType Full = new DisplayType("Full", 0);
    public static final DisplayType Sub = new DisplayType("Sub", 1);

    private static final /* synthetic */ DisplayType[] $values() {
        return new DisplayType[]{Full, Sub};
    }

    static {
        DisplayType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private DisplayType(String str, int r2) {
    }

    public static EnumEntries<DisplayType> getEntries() {
        return $ENTRIES;
    }

    public static DisplayType valueOf(String str) {
        return (DisplayType) Enum.valueOf(DisplayType.class, str);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) $VALUES.clone();
    }
}
