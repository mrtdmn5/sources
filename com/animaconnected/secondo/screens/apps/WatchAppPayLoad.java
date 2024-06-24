package com.animaconnected.secondo.screens.apps;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public final class WatchAppPayLoad {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchAppPayLoad[] $VALUES;
    public static final WatchAppPayLoad RADIO_CHECK_CHANGE = new WatchAppPayLoad("RADIO_CHECK_CHANGE", 0);
    public static final WatchAppPayLoad EDIT_MODE_TOGGLE = new WatchAppPayLoad("EDIT_MODE_TOGGLE", 1);

    private static final /* synthetic */ WatchAppPayLoad[] $values() {
        return new WatchAppPayLoad[]{RADIO_CHECK_CHANGE, EDIT_MODE_TOGGLE};
    }

    static {
        WatchAppPayLoad[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WatchAppPayLoad(String str, int r2) {
    }

    public static EnumEntries<WatchAppPayLoad> getEntries() {
        return $ENTRIES;
    }

    public static WatchAppPayLoad valueOf(String str) {
        return (WatchAppPayLoad) Enum.valueOf(WatchAppPayLoad.class, str);
    }

    public static WatchAppPayLoad[] values() {
        return (WatchAppPayLoad[]) $VALUES.clone();
    }
}
