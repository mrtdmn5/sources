package com.animaconnected.watch.display.view;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DisplayDefinition.kt */
/* loaded from: classes3.dex */
public final class Position {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Position[] $VALUES;
    public static final Position TopLeft = new Position("TopLeft", 0);
    public static final Position Top = new Position("Top", 1);
    public static final Position TopRight = new Position("TopRight", 2);
    public static final Position Left = new Position("Left", 3);
    public static final Position Center = new Position("Center", 4);
    public static final Position Right = new Position("Right", 5);
    public static final Position BottomLeft = new Position("BottomLeft", 6);
    public static final Position Bottom = new Position("Bottom", 7);
    public static final Position BottomRight = new Position("BottomRight", 8);
    public static final Position Coordinates = new Position("Coordinates", 9);

    private static final /* synthetic */ Position[] $values() {
        return new Position[]{TopLeft, Top, TopRight, Left, Center, Right, BottomLeft, Bottom, BottomRight, Coordinates};
    }

    static {
        Position[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Position(String str, int r2) {
    }

    public static EnumEntries<Position> getEntries() {
        return $ENTRIES;
    }

    public static Position valueOf(String str) {
        return (Position) Enum.valueOf(Position.class, str);
    }

    public static Position[] values() {
        return (Position[]) $VALUES.clone();
    }
}
