package com.animaconnected.watch.device;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class WatchAppAnimation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchAppAnimation[] $VALUES;
    private final int id;
    public static final WatchAppAnimation ScrollRight = new WatchAppAnimation("ScrollRight", 0, 1);
    public static final WatchAppAnimation ScrollLeft = new WatchAppAnimation("ScrollLeft", 1, 2);
    public static final WatchAppAnimation FadeFast = new WatchAppAnimation("FadeFast", 2, 3);
    public static final WatchAppAnimation FadeSlowWithPause = new WatchAppAnimation("FadeSlowWithPause", 3, 4);
    public static final WatchAppAnimation None = new WatchAppAnimation("None", 4, 5);

    private static final /* synthetic */ WatchAppAnimation[] $values() {
        return new WatchAppAnimation[]{ScrollRight, ScrollLeft, FadeFast, FadeSlowWithPause, None};
    }

    static {
        WatchAppAnimation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WatchAppAnimation(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<WatchAppAnimation> getEntries() {
        return $ENTRIES;
    }

    public static WatchAppAnimation valueOf(String str) {
        return (WatchAppAnimation) Enum.valueOf(WatchAppAnimation.class, str);
    }

    public static WatchAppAnimation[] values() {
        return (WatchAppAnimation[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
