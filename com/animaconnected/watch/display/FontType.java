package com.animaconnected.watch.display;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class FontType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FontType[] $VALUES;
    private final int id;
    public static final FontType Default = new FontType("Default", 0, 0);
    public static final FontType Small = new FontType("Small", 1, 1);
    public static final FontType Normal = new FontType("Normal", 2, 2);
    public static final FontType Subtitle = new FontType("Subtitle", 3, 3);
    public static final FontType Title = new FontType("Title", 4, 4);
    public static final FontType Numbers = new FontType("Numbers", 5, 5);

    private static final /* synthetic */ FontType[] $values() {
        return new FontType[]{Default, Small, Normal, Subtitle, Title, Numbers};
    }

    static {
        FontType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private FontType(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<FontType> getEntries() {
        return $ENTRIES;
    }

    public static FontType valueOf(String str) {
        return (FontType) Enum.valueOf(FontType.class, str);
    }

    public static FontType[] values() {
        return (FontType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
