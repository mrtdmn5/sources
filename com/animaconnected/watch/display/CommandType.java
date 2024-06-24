package com.animaconnected.watch.display;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class CommandType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommandType[] $VALUES;
    private final int id;
    public static final CommandType Unknown = new CommandType("Unknown", 0, 0);
    public static final CommandType Line = new CommandType("Line", 1, 1);
    public static final CommandType Image = new CommandType("Image", 2, 2);
    public static final CommandType Text = new CommandType("Text", 3, 3);
    public static final CommandType Rectangle = new CommandType("Rectangle", 4, 4);
    public static final CommandType Container = new CommandType("Container", 5, 5);
    public static final CommandType Button = new CommandType("Button", 6, 6);
    public static final CommandType Progressbar = new CommandType("Progressbar", 7, 7);
    public static final CommandType Back = new CommandType("Back", 8, 8);

    private static final /* synthetic */ CommandType[] $values() {
        return new CommandType[]{Unknown, Line, Image, Text, Rectangle, Container, Button, Progressbar, Back};
    }

    static {
        CommandType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CommandType(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<CommandType> getEntries() {
        return $ENTRIES;
    }

    public static CommandType valueOf(String str) {
        return (CommandType) Enum.valueOf(CommandType.class, str);
    }

    public static CommandType[] values() {
        return (CommandType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
