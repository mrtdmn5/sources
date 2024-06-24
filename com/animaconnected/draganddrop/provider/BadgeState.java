package com.animaconnected.draganddrop.provider;

import com.animaconnected.draganddrop.R;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BadgeState.kt */
/* loaded from: classes.dex */
public final class BadgeState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BadgeState[] $VALUES;
    private final Integer resId;
    public static final BadgeState Normal = new BadgeState("Normal", 0, null);
    public static final BadgeState Error = new BadgeState("Error", 1, Integer.valueOf(R.drawable.ic_badge_on_marble_attention));
    public static final BadgeState Neutral = new BadgeState("Neutral", 2, Integer.valueOf(R.drawable.badge_on_marble_neutral));
    public static final BadgeState Positive = new BadgeState("Positive", 3, Integer.valueOf(R.drawable.badge_on_marble_positive));

    private static final /* synthetic */ BadgeState[] $values() {
        return new BadgeState[]{Normal, Error, Neutral, Positive};
    }

    static {
        BadgeState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BadgeState(String str, int r2, Integer num) {
        this.resId = num;
    }

    public static EnumEntries<BadgeState> getEntries() {
        return $ENTRIES;
    }

    public static BadgeState valueOf(String str) {
        return (BadgeState) Enum.valueOf(BadgeState.class, str);
    }

    public static BadgeState[] values() {
        return (BadgeState[]) $VALUES.clone();
    }

    public final Integer getResId() {
        return this.resId;
    }
}
