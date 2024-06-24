package com.animaconnected.watch.provider.demo;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DemoModeProvider.kt */
/* loaded from: classes3.dex */
public final class WatchDemoMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchDemoMode[] $VALUES;
    public static final WatchDemoMode None = new WatchDemoMode("None", 0, 0);
    public static final WatchDemoMode Retail = new WatchDemoMode("Retail", 1, 1);
    private final int mode;

    private static final /* synthetic */ WatchDemoMode[] $values() {
        return new WatchDemoMode[]{None, Retail};
    }

    static {
        WatchDemoMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WatchDemoMode(String str, int r2, int r3) {
        this.mode = r3;
    }

    public static EnumEntries<WatchDemoMode> getEntries() {
        return $ENTRIES;
    }

    public static WatchDemoMode valueOf(String str) {
        return (WatchDemoMode) Enum.valueOf(WatchDemoMode.class, str);
    }

    public static WatchDemoMode[] values() {
        return (WatchDemoMode[]) $VALUES.clone();
    }

    public final int getMode() {
        return this.mode;
    }
}
