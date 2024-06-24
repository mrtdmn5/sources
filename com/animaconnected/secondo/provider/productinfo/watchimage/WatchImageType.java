package com.animaconnected.secondo.provider.productinfo.watchimage;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchImageType.kt */
/* loaded from: classes3.dex */
public final class WatchImageType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WatchImageType[] $VALUES;
    public static final WatchImageType SKU = new WatchImageType("SKU", 0);
    public static final WatchImageType THUMBNAIL = new WatchImageType("THUMBNAIL", 1);
    public static final WatchImageType MAIN_HOUR_HAND = new WatchImageType("MAIN_HOUR_HAND", 2);
    public static final WatchImageType MAIN_MIN_HAND = new WatchImageType("MAIN_MIN_HAND", 3);
    public static final WatchImageType SUB_HOUR_HAND = new WatchImageType("SUB_HOUR_HAND", 4);
    public static final WatchImageType SUB_MIN_HAND = new WatchImageType("SUB_MIN_HAND", 5);
    public static final WatchImageType GLOW = new WatchImageType("GLOW", 6);

    private static final /* synthetic */ WatchImageType[] $values() {
        return new WatchImageType[]{SKU, THUMBNAIL, MAIN_HOUR_HAND, MAIN_MIN_HAND, SUB_HOUR_HAND, SUB_MIN_HAND, GLOW};
    }

    static {
        WatchImageType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private WatchImageType(String str, int r2) {
    }

    public static EnumEntries<WatchImageType> getEntries() {
        return $ENTRIES;
    }

    public static WatchImageType valueOf(String str) {
        return (WatchImageType) Enum.valueOf(WatchImageType.class, str);
    }

    public static WatchImageType[] values() {
        return (WatchImageType[]) $VALUES.clone();
    }
}
