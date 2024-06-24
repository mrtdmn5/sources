package com.animaconnected.watch.workout;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkoutDatePickerViewModel.kt */
/* loaded from: classes3.dex */
public final class Action {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Action[] $VALUES;
    public static final Action PreviousDate = new Action("PreviousDate", 0);
    public static final Action NextDate = new Action("NextDate", 1);

    private static final /* synthetic */ Action[] $values() {
        return new Action[]{PreviousDate, NextDate};
    }

    static {
        Action[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Action(String str, int r2) {
    }

    public static EnumEntries<Action> getEntries() {
        return $ENTRIES;
    }

    public static Action valueOf(String str) {
        return (Action) Enum.valueOf(Action.class, str);
    }

    public static Action[] values() {
        return (Action[]) $VALUES.clone();
    }
}
