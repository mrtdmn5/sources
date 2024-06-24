package com.animaconnected.draganddrop.provider;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BadgeVisualState.kt */
/* loaded from: classes.dex */
public final class BadgeVisualState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BadgeVisualState[] $VALUES;
    public static final BadgeVisualState Invisible = new BadgeVisualState("Invisible", 0);
    public static final BadgeVisualState AnimateIn = new BadgeVisualState("AnimateIn", 1);
    public static final BadgeVisualState Visible = new BadgeVisualState("Visible", 2);
    public static final BadgeVisualState AnimateOut = new BadgeVisualState("AnimateOut", 3);

    private static final /* synthetic */ BadgeVisualState[] $values() {
        return new BadgeVisualState[]{Invisible, AnimateIn, Visible, AnimateOut};
    }

    static {
        BadgeVisualState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BadgeVisualState(String str, int r2) {
    }

    public static EnumEntries<BadgeVisualState> getEntries() {
        return $ENTRIES;
    }

    public static BadgeVisualState valueOf(String str) {
        return (BadgeVisualState) Enum.valueOf(BadgeVisualState.class, str);
    }

    public static BadgeVisualState[] values() {
        return (BadgeVisualState[]) $VALUES.clone();
    }
}
