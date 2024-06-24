package com.animaconnected.watch.display;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class QuickActionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ QuickActionType[] $VALUES;
    private final int id;
    public static final QuickActionType None = new QuickActionType("None", 0, 0);
    public static final QuickActionType Button = new QuickActionType("Button", 1, 1);
    public static final QuickActionType Camera = new QuickActionType("Camera", 2, 2);
    public static final QuickActionType MediaController = new QuickActionType("MediaController", 3, 3);
    public static final QuickActionType Mute = new QuickActionType("Mute", 4, 4);
    public static final QuickActionType LaunchApp = new QuickActionType("LaunchApp", 5, 5);

    private static final /* synthetic */ QuickActionType[] $values() {
        return new QuickActionType[]{None, Button, Camera, MediaController, Mute, LaunchApp};
    }

    static {
        QuickActionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private QuickActionType(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<QuickActionType> getEntries() {
        return $ENTRIES;
    }

    public static QuickActionType valueOf(String str) {
        return (QuickActionType) Enum.valueOf(QuickActionType.class, str);
    }

    public static QuickActionType[] values() {
        return (QuickActionType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
