package com.animaconnected.watch.display;

import com.animaconnected.secondo.behaviour.time.Time;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class VarType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VarType[] $VALUES;
    private final int id;
    public static final VarType Test = new VarType("Test", 0, 0);
    public static final VarType Time = new VarType(Time.TYPE, 1, 1);
    public static final VarType Timezone1 = new VarType("Timezone1", 2, 2);
    public static final VarType Timezone2 = new VarType("Timezone2", 3, 3);
    public static final VarType Timezone3 = new VarType("Timezone3", 4, 4);
    public static final VarType ActivityStepsToday = new VarType("ActivityStepsToday", 5, 5);
    public static final VarType ActivityStepsYesterday = new VarType("ActivityStepsYesterday", 6, 6);
    public static final VarType AlarmNextActive = new VarType("AlarmNextActive", 7, 7);
    public static final VarType RunLevel = new VarType("RunLevel", 8, 8);

    private static final /* synthetic */ VarType[] $values() {
        return new VarType[]{Test, Time, Timezone1, Timezone2, Timezone3, ActivityStepsToday, ActivityStepsYesterday, AlarmNextActive, RunLevel};
    }

    static {
        VarType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private VarType(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<VarType> getEntries() {
        return $ENTRIES;
    }

    public static VarType valueOf(String str) {
        return (VarType) Enum.valueOf(VarType.class, str);
    }

    public static VarType[] values() {
        return (VarType[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
