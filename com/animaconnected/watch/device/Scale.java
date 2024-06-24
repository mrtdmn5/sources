package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class Scale {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Scale[] $VALUES;
    private final int position;
    public static final Scale Unknown = new Scale("Unknown", 0, -1);
    public static final Scale ZeroToTwelve = new Scale("ZeroToTwelve", 1, 0);
    public static final Scale ZeroToTwentyFour = new Scale("ZeroToTwentyFour", 2, 1);
    public static final Scale ZeroToSixty = new Scale("ZeroToSixty", 3, 2);
    public static final Scale ZeroToHundred = new Scale("ZeroToHundred", 4, 3);
    public static final Scale ZeroToThirtyOne = new Scale("ZeroToThirtyOne", 5, 4);
    public static final Scale DaysOfWeek = new Scale("DaysOfWeek", 6, 5);
    public static final Scale All = new Scale("All", 7, 20);

    private static final /* synthetic */ Scale[] $values() {
        return new Scale[]{Unknown, ZeroToTwelve, ZeroToTwentyFour, ZeroToSixty, ZeroToHundred, ZeroToThirtyOne, DaysOfWeek, All};
    }

    static {
        Scale[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Scale(String str, int r2, int r3) {
        this.position = r3;
    }

    public static EnumEntries<Scale> getEntries() {
        return $ENTRIES;
    }

    public static Scale valueOf(String str) {
        return (Scale) Enum.valueOf(Scale.class, str);
    }

    public static Scale[] values() {
        return (Scale[]) $VALUES.clone();
    }

    public final int getPosition() {
        return this.position;
    }
}
