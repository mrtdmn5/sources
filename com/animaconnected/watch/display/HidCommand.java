package com.animaconnected.watch.display;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class HidCommand {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HidCommand[] $VALUES;
    private final int command;
    public static final HidCommand BTN_RELEASE = new HidCommand("BTN_RELEASE", 0, 0);
    public static final HidCommand VOLUME_DOWN = new HidCommand("VOLUME_DOWN", 1, 1);
    public static final HidCommand VOLUME_UP = new HidCommand("VOLUME_UP", 2, 2);
    public static final HidCommand PLAY_PAUSE = new HidCommand("PLAY_PAUSE", 3, 10);
    public static final HidCommand MUTE = new HidCommand("MUTE", 4, 20);

    private static final /* synthetic */ HidCommand[] $values() {
        return new HidCommand[]{BTN_RELEASE, VOLUME_DOWN, VOLUME_UP, PLAY_PAUSE, MUTE};
    }

    static {
        HidCommand[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private HidCommand(String str, int r2, int r3) {
        this.command = r3;
    }

    public static EnumEntries<HidCommand> getEntries() {
        return $ENTRIES;
    }

    public static HidCommand valueOf(String str) {
        return (HidCommand) Enum.valueOf(HidCommand.class, str);
    }

    public static HidCommand[] values() {
        return (HidCommand[]) $VALUES.clone();
    }

    public final int getCommand() {
        return this.command;
    }
}
